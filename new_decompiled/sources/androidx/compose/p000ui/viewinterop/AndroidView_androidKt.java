package androidx.compose.p000ui.viewinterop;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p000ui.node.LayoutNode;
import androidx.compose.p000ui.node.Ref;
import androidx.compose.p000ui.node.UiApplier;
import androidx.compose.p000ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.health.platform.client.SdkConfig;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidView.android.kt */
@Metadata(m286d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010\u000e\"\"\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m287d2 = {"NoOpUpdate", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "getNoOpUpdate", "()Lkotlin/jvm/functions/Function1;", "AndroidView", "T", "factory", "Landroid/content/Context;", "modifier", "Landroidx/compose/ui/Modifier;", "update", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AndroidView_androidKt {
    private static final Function1<View, Unit> NoOpUpdate = new Function1<View, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$NoOpUpdate$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View $this$null) {
            Intrinsics.checkNotNullParameter($this$null, "$this$null");
        }
    };

    public static final <T extends View> void AndroidView(final Function1<? super Context, ? extends T> factory, Modifier modifier, Function1<? super T, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 function12;
        Function1 update;
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(factory, "factory");
        Composer $composer2 = $composer.startRestartGroup(-1783766393);
        ComposerKt.sourceInformation($composer2, "C(AndroidView)86@4146L7,89@4353L47,91@4503L37,98@5071L7,99@5126L7,100@5160L28,101@5240L7,102@5267L23,103@5333L40,109@5749L7,110@5820L7,112@5833L1313,140@7189L439:AndroidView.android.kt#z33iqn");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(factory) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function12 = function1;
        } else if (($changed & 896) == 0) {
            function12 = function1;
            $dirty |= $composer2.changed(function12) ? 256 : 128;
        } else {
            function12 = function1;
        }
        if (($dirty & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            update = function12;
        } else {
            Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            update = i3 != 0 ? NoOpUpdate : function12;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1783766393, $changed, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:81)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Context context = (Context) consume;
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new NestedScrollConnection() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$noOpConnection$1$1
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            AndroidView_androidKt$AndroidView$noOpConnection$1$1 noOpConnection = (AndroidView_androidKt$AndroidView$noOpConnection$1$1) value$iv$iv;
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv2 = $composer2.rememberedValue();
            if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = new NestedScrollDispatcher();
                $composer2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            final NestedScrollDispatcher dispatcher = (NestedScrollDispatcher) value$iv$iv2;
            Modifier nestedScrollInteropModifier = NestedScrollModifierKt.nestedScroll(Modifier.INSTANCE, noOpConnection, dispatcher);
            Modifier modifierWithSemantics = SemanticsModifierKt.semantics(modifier4.then(nestedScrollInteropModifier), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$modifierWithSemantics$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                }
            });
            Modifier materialized = ComposedModifierKt.materialize($composer2, modifierWithSemantics);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) consume2;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection = (LayoutDirection) consume3;
            final CompositionContext parentReference = ComposablesKt.rememberCompositionContext($composer2, 0);
            ProvidableCompositionLocal<SaveableStateRegistry> localSaveableStateRegistry = SaveableStateRegistryKt.getLocalSaveableStateRegistry();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer2.consume(localSaveableStateRegistry);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final SaveableStateRegistry stateRegistry = (SaveableStateRegistry) consume4;
            final String stateKey = String.valueOf(ComposablesKt.getCurrentCompositeKeyHash($composer2, 0));
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv3 = $composer2.rememberedValue();
            if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv3 = new Ref();
                $composer2.updateRememberedValue(value$iv$iv3);
            } else {
                value$iv$iv3 = it$iv$iv3;
            }
            $composer2.endReplaceableGroup();
            final Ref viewFactoryHolderRef = (Ref) value$iv$iv3;
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer2.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LifecycleOwner lifecycleOwner = (LifecycleOwner) consume5;
            ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = $composer2.consume(localSavedStateRegistryOwner);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) consume6;
            modifier3 = modifier4;
            final Function0 factory$iv = new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final LayoutNode invoke() {
                    View typedView$ui_release;
                    ViewFactoryHolder viewFactoryHolder = new ViewFactoryHolder(context, parentReference, dispatcher);
                    viewFactoryHolder.setFactory(factory);
                    SaveableStateRegistry saveableStateRegistry = stateRegistry;
                    Object consumeRestored = saveableStateRegistry != null ? saveableStateRegistry.consumeRestored(stateKey) : null;
                    SparseArray savedState = consumeRestored instanceof SparseArray ? (SparseArray) consumeRestored : null;
                    if (savedState != null && (typedView$ui_release = viewFactoryHolder.getTypedView$ui_release()) != null) {
                        typedView$ui_release.restoreHierarchyState(savedState);
                    }
                    viewFactoryHolderRef.setValue(viewFactoryHolder);
                    return viewFactoryHolder.getLayoutNode();
                }
            };
            $composer2.startReplaceableGroup(1886828752);
            ComposerKt.sourceInformation($composer2, "C(ComposeNode):Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof UiApplier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.LayoutNode, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final LayoutNode invoke() {
                        return Function0.this.invoke();
                    }
                });
            } else {
                $composer2.useNode();
            }
            Composer $this$AndroidView_u24lambda_u2d3 = Updater.m1639constructorimpl($composer2);
            Updater.m1646setimpl($this$AndroidView_u24lambda_u2d3, materialized, new Function2<LayoutNode, Modifier, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Modifier modifier5) {
                    invoke2(layoutNode, modifier5);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutNode set, Modifier it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object value = viewFactoryHolderRef.getValue();
                    Intrinsics.checkNotNull(value);
                    ((ViewFactoryHolder) value).setModifier(it);
                }
            });
            Updater.m1646setimpl($this$AndroidView_u24lambda_u2d3, density, new Function2<LayoutNode, Density, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Density density2) {
                    invoke2(layoutNode, density2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutNode set, Density it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object value = viewFactoryHolderRef.getValue();
                    Intrinsics.checkNotNull(value);
                    ((ViewFactoryHolder) value).setDensity(it);
                }
            });
            Updater.m1646setimpl($this$AndroidView_u24lambda_u2d3, lifecycleOwner, new Function2<LayoutNode, LifecycleOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LifecycleOwner lifecycleOwner2) {
                    invoke2(layoutNode, lifecycleOwner2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutNode set, LifecycleOwner it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object value = viewFactoryHolderRef.getValue();
                    Intrinsics.checkNotNull(value);
                    ((ViewFactoryHolder) value).setLifecycleOwner(it);
                }
            });
            Updater.m1646setimpl($this$AndroidView_u24lambda_u2d3, savedStateRegistryOwner, new Function2<LayoutNode, SavedStateRegistryOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, SavedStateRegistryOwner savedStateRegistryOwner2) {
                    invoke2(layoutNode, savedStateRegistryOwner2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutNode set, SavedStateRegistryOwner it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object value = viewFactoryHolderRef.getValue();
                    Intrinsics.checkNotNull(value);
                    ((ViewFactoryHolder) value).setSavedStateRegistryOwner(it);
                }
            });
            Updater.m1646setimpl($this$AndroidView_u24lambda_u2d3, update, (Function2<? super T, ? super Function1, Unit>) new Function2<LayoutNode, Function1<? super T, ? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Object p2) {
                    invoke(layoutNode, (Function1) p2);
                    return Unit.INSTANCE;
                }

                public final void invoke(LayoutNode set, Function1<? super T, Unit> it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    ViewFactoryHolder<T> value = viewFactoryHolderRef.getValue();
                    Intrinsics.checkNotNull(value);
                    value.setUpdateBlock(it);
                }
            });
            Updater.m1646setimpl($this$AndroidView_u24lambda_u2d3, layoutDirection, new Function2<LayoutNode, LayoutDirection, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$6

                /* compiled from: AndroidView.android.kt */
                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[LayoutDirection.values().length];
                        iArr[LayoutDirection.Ltr.ordinal()] = 1;
                        iArr[LayoutDirection.Rtl.ordinal()] = 2;
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LayoutDirection layoutDirection2) {
                    invoke2(layoutNode, layoutDirection2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutNode set, LayoutDirection it) {
                    int i4;
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object value = viewFactoryHolderRef.getValue();
                    Intrinsics.checkNotNull(value);
                    ViewFactoryHolder viewFactoryHolder = (ViewFactoryHolder) value;
                    switch (WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
                        case 1:
                            i4 = 0;
                            break;
                        case 2:
                            i4 = 1;
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    viewFactoryHolder.setLayoutDirection(i4);
                }
            });
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (stateRegistry != null) {
                EffectsKt.DisposableEffect(stateRegistry, stateKey, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        final Ref<ViewFactoryHolder<T>> ref = viewFactoryHolderRef;
                        Function0 valueProvider = new Function0<SparseArray<Parcelable>>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$valueProvider$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final SparseArray<Parcelable> invoke() {
                                SparseArray hierarchyState = new SparseArray();
                                Object value = ref.getValue();
                                Intrinsics.checkNotNull(value);
                                View typedView$ui_release = ((ViewFactoryHolder) value).getTypedView$ui_release();
                                if (typedView$ui_release != null) {
                                    typedView$ui_release.saveHierarchyState(hierarchyState);
                                }
                                return hierarchyState;
                            }
                        };
                        final SaveableStateRegistry.Entry entry = SaveableStateRegistry.this.registerProvider(stateKey, valueProvider);
                        return new DisposableEffectResult() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                SaveableStateRegistry.Entry.this.unregister();
                            }
                        };
                    }
                }, $composer2, 8);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final Function1 function13 = update;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i4) {
                AndroidView_androidKt.AndroidView(factory, modifier5, function13, composer, $changed | 1, i);
            }
        });
    }

    public static final Function1<View, Unit> getNoOpUpdate() {
        return NoOpUpdate;
    }
}
