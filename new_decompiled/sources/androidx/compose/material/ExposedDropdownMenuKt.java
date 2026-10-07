package androidx.compose.material;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ExposedDropdownMenuBoxScope;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.focus.FocusRequester;
import androidx.compose.p000ui.focus.FocusRequesterModifierKt;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.LayoutCoordinatesKt;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.node.Ref;
import androidx.compose.p000ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExposedDropdownMenu.kt */
@Metadata(m286d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a6\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0005H\u0002\u001a\"\u0010\u0015\u001a\u00020\u0007*\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u0019"}, m287d2 = {"ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "updateHeight", "view", "Landroid/view/View;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "verticalMarginInPx", "", "onHeightUpdate", "expandable", "Lkotlin/Function0;", "menuLabel", "", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ExposedDropdownMenuKt {
    /* JADX WARN: Removed duplicated region for block: B:45:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x024f  */
    @ExperimentalMaterialApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ExposedDropdownMenuBox(final boolean expanded, final Function1<? super Boolean, Unit> onExpandedChange, Modifier modifier, final Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Object value$iv$iv4;
        Object it$iv$iv;
        Object value$iv$iv5;
        Modifier modifier3;
        boolean invalid$iv$iv;
        Object it$iv$iv2;
        Object value$iv$iv6;
        int $changed$iv;
        int $changed2;
        Intrinsics.checkNotNullParameter(onExpandedChange, "onExpandedChange");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(1456052980);
        ComposerKt.sourceInformation($composer2, "C(ExposedDropdownMenuBox)P(1,3,2)95@4098L7,96@4131L7,97@4156L30,98@4209L30,100@4340L37,102@4395L486,115@4907L29,129@5318L31,130@5375L38,117@4942L550,136@5498L70,140@5574L441:ExposedDropdownMenu.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(expanded) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(onExpandedChange) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(content) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1456052980, $dirty2, -1, "androidx.compose.material.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:89)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Density density = (Density) consume;
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(localView);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final View view = (View) consume2;
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv3 = $composer2.rememberedValue();
            if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv3;
            }
            $composer2.endReplaceableGroup();
            final MutableState width$delegate = (MutableState) value$iv$iv;
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv4 = $composer2.rememberedValue();
            if (it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                $composer2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv4;
            }
            $composer2.endReplaceableGroup();
            final MutableState menuHeight$delegate = (MutableState) value$iv$iv2;
            final int verticalMarginInPx = density.mo642roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv5 = $composer2.rememberedValue();
            if (it$iv$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv3 = new Ref();
                $composer2.updateRememberedValue(value$iv$iv3);
            } else {
                value$iv$iv3 = it$iv$iv5;
            }
            $composer2.endReplaceableGroup();
            final Ref coordinates = (Ref) value$iv$iv3;
            Object key2$iv = Integer.valueOf(m1391ExposedDropdownMenuBox$lambda4(menuHeight$delegate));
            Object key3$iv = Integer.valueOf(m1389ExposedDropdownMenuBox$lambda1(width$delegate));
            $composer2.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean invalid$iv$iv2 = $composer2.changed(density) | $composer2.changed(key2$iv) | $composer2.changed(key3$iv);
            Object it$iv$iv6 = $composer2.rememberedValue();
            if (!invalid$iv$iv2 && it$iv$iv6 != Composer.INSTANCE.getEmpty()) {
                value$iv$iv4 = it$iv$iv6;
                $composer2.endReplaceableGroup();
                ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 scope = (ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) value$iv$iv4;
                $composer2.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                it$iv$iv = $composer2.rememberedValue();
                if (it$iv$iv != Composer.INSTANCE.getEmpty()) {
                    value$iv$iv5 = new FocusRequester();
                    $composer2.updateRememberedValue(value$iv$iv5);
                } else {
                    value$iv$iv5 = it$iv$iv;
                }
                $composer2.endReplaceableGroup();
                final FocusRequester focusRequester = (FocusRequester) value$iv$iv5;
                Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier4, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutCoordinates it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        ExposedDropdownMenuKt.m1390ExposedDropdownMenuBox$lambda2(width$delegate, IntSize.m4542getWidthimpl(it.mo3497getSizeYbymL2g()));
                        coordinates.setValue(it);
                        View rootView = view.getRootView();
                        Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
                        LayoutCoordinates value = coordinates.getValue();
                        int i3 = verticalMarginInPx;
                        final MutableState<Integer> mutableState = menuHeight$delegate;
                        ExposedDropdownMenuKt.updateHeight(rootView, value, i3, new Function1<Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                invoke(num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int newHeight) {
                                ExposedDropdownMenuKt.m1392ExposedDropdownMenuBox$lambda5(mutableState, newHeight);
                            }
                        });
                    }
                });
                Object key2$iv2 = Boolean.valueOf(expanded);
                int i3 = (($dirty2 >> 3) & 14) | (($dirty2 << 3) & SdkConfig.SDK_VERSION);
                modifier3 = modifier4;
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
                invalid$iv$iv = $composer2.changed(onExpandedChange) | $composer2.changed(key2$iv2);
                it$iv$iv2 = $composer2.rememberedValue();
                if (!invalid$iv$iv && it$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                    value$iv$iv6 = it$iv$iv2;
                    $composer2.endReplaceableGroup();
                    Modifier modifier$iv = FocusRequesterModifierKt.focusRequester(expandable(onGloballyPositioned, (Function0) value$iv$iv6, Strings_androidKt.m1511getString4foXLRw(Strings.INSTANCE.m1507getExposedDropdownMenuUdPEhr4(), $composer2, 6)), focusRequester);
                    $composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    int $i$f$Box = ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION);
                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, $i$f$Box);
                    int $changed$iv$iv = (0 << 3) & SdkConfig.SDK_VERSION;
                    $composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume3 = $composer2.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Density density$iv$iv = (Density) consume3;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume4 = $composer2.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume4;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume5 = $composer2.consume(localViewConfiguration);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume5;
                    Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                    int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        $composer2.useNode();
                    } else {
                        $composer2.createNode(factory$iv$iv$iv);
                    }
                    $composer2.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer2);
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    $composer2.enableReusing();
                    skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                    $composer2.startReplaceableGroup(2058660585);
                    $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                    $composer2.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer2, "C72@3384L9:Box.kt#2w3rfo");
                    if (($changed$iv & 11) == 2 || !$composer2.getSkipping()) {
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        $changed2 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        $composer2.startReplaceableGroup(-443225682);
                        ComposerKt.sourceInformation($composer2, "C133@5477L9:ExposedDropdownMenu.kt#jmzs0o");
                        if (($changed2 & 81) == 16 || !$composer2.getSkipping()) {
                            content.invoke(scope, $composer2, Integer.valueOf(($dirty2 >> 6) & SdkConfig.SDK_VERSION));
                        } else {
                            $composer2.skipToGroupEnd();
                        }
                        $composer2.endReplaceableGroup();
                    } else {
                        $composer2.skipToGroupEnd();
                    }
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    $composer2.endNode();
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            if (expanded) {
                                focusRequester.requestFocus();
                            }
                        }
                    }, $composer2, 0);
                    EffectsKt.DisposableEffect(view, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                            View view2 = view;
                            final View view3 = view;
                            final Ref<LayoutCoordinates> ref = coordinates;
                            final int i4 = verticalMarginInPx;
                            final MutableState<Integer> mutableState = menuHeight$delegate;
                            final OnGlobalLayoutListener listener = new OnGlobalLayoutListener(view2, new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    View rootView = view3.getRootView();
                                    Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
                                    LayoutCoordinates value = ref.getValue();
                                    int i5 = i4;
                                    final MutableState<Integer> mutableState2 = mutableState;
                                    ExposedDropdownMenuKt.updateHeight(rootView, value, i5, new Function1<Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                            invoke(num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(int newHeight) {
                                            ExposedDropdownMenuKt.m1392ExposedDropdownMenuBox$lambda5(mutableState2, newHeight);
                                        }
                                    });
                                }
                            });
                            return new DisposableEffectResult() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    OnGlobalLayoutListener.this.dispose();
                                }
                            };
                        }
                    }, $composer2, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                value$iv$iv6 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        onExpandedChange.invoke(Boolean.valueOf(!expanded));
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv6);
                $composer2.endReplaceableGroup();
                Modifier modifier$iv2 = FocusRequesterModifierKt.focusRequester(expandable(onGloballyPositioned, (Function0) value$iv$iv6, Strings_androidKt.m1511getString4foXLRw(Strings.INSTANCE.m1507getExposedDropdownMenuUdPEhr4(), $composer2, 6)), focusRequester);
                $composer2.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                int $i$f$Box2 = ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION);
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer2, $i$f$Box2);
                int $changed$iv$iv2 = (0 << 3) & SdkConfig.SDK_VERSION;
                $composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume32 = $composer2.consume(localDensity22);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density density$iv$iv2 = (Density) consume32;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume42 = $composer2.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume42;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume52 = $composer2.consume(localViewConfiguration2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume52;
                Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                if (!($composer2.getApplier() instanceof Applier)) {
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                }
                $composer2.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer2);
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer2.enableReusing();
                skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                $composer2.startReplaceableGroup(2058660585);
                $changed$iv = ($changed$iv$iv$iv2 >> 9) & 14;
                $composer2.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation($composer2, "C72@3384L9:Box.kt#2w3rfo");
                if (($changed$iv & 11) == 2) {
                }
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                $changed2 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                $composer2.startReplaceableGroup(-443225682);
                ComposerKt.sourceInformation($composer2, "C133@5477L9:ExposedDropdownMenu.kt#jmzs0o");
                if (($changed2 & 81) == 16) {
                }
                content.invoke(scope, $composer2, Integer.valueOf(($dirty2 >> 6) & SdkConfig.SDK_VERSION));
                $composer2.endReplaceableGroup();
                $composer2.endReplaceableGroup();
                $composer2.endReplaceableGroup();
                $composer2.endNode();
                $composer2.endReplaceableGroup();
                $composer2.endReplaceableGroup();
                EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (expanded) {
                            focusRequester.requestFocus();
                        }
                    }
                }, $composer2, 0);
                EffectsKt.DisposableEffect(view, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        View view2 = view;
                        final View view3 = view;
                        final Ref<LayoutCoordinates> ref = coordinates;
                        final int i4 = verticalMarginInPx;
                        final MutableState<Integer> mutableState = menuHeight$delegate;
                        final OnGlobalLayoutListener listener = new OnGlobalLayoutListener(view2, new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                View rootView = view3.getRootView();
                                Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
                                LayoutCoordinates value = ref.getValue();
                                int i5 = i4;
                                final MutableState<Integer> mutableState2 = mutableState;
                                ExposedDropdownMenuKt.updateHeight(rootView, value, i5, new Function1<Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                        invoke(num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(int newHeight) {
                                        ExposedDropdownMenuKt.m1392ExposedDropdownMenuBox$lambda5(mutableState2, newHeight);
                                    }
                                });
                            }
                        });
                        return new DisposableEffectResult() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                OnGlobalLayoutListener.this.dispose();
                            }
                        };
                    }
                }, $composer2, 8);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            value$iv$iv4 = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1
                @Override // androidx.compose.material.ExposedDropdownMenuBoxScope
                public void ExposedDropdownMenu(boolean expanded2, Function0<Unit> function0, Modifier modifier5, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer3, int $changed3, int i4) {
                    ExposedDropdownMenuBoxScope.DefaultImpls.ExposedDropdownMenu(this, expanded2, function0, modifier5, function3, $composer3, $changed3, i4);
                }

                @Override // androidx.compose.material.ExposedDropdownMenuBoxScope
                public Modifier exposedDropdownSize(Modifier $this$exposedDropdownSize, boolean matchTextFieldWidth) {
                    int m1391ExposedDropdownMenuBox$lambda4;
                    int m1389ExposedDropdownMenuBox$lambda1;
                    Intrinsics.checkNotNullParameter($this$exposedDropdownSize, "<this>");
                    Density $this$exposedDropdownSize_u24lambda_u2d1 = Density.this;
                    MutableState<Integer> mutableState = menuHeight$delegate;
                    MutableState<Integer> mutableState2 = width$delegate;
                    m1391ExposedDropdownMenuBox$lambda4 = ExposedDropdownMenuKt.m1391ExposedDropdownMenuBox$lambda4(mutableState);
                    Modifier it = SizeKt.m788heightInVpY3zN4$default($this$exposedDropdownSize, 0.0f, $this$exposedDropdownSize_u24lambda_u2d1.mo645toDpu2uoSUM(m1391ExposedDropdownMenuBox$lambda4), 1, null);
                    if (matchTextFieldWidth) {
                        m1389ExposedDropdownMenuBox$lambda1 = ExposedDropdownMenuKt.m1389ExposedDropdownMenuBox$lambda1(mutableState2);
                        return SizeKt.m805width3ABfNKs(it, $this$exposedDropdownSize_u24lambda_u2d1.mo645toDpu2uoSUM(m1389ExposedDropdownMenuBox$lambda1));
                    }
                    return it;
                }
            };
            $composer2.updateRememberedValue(value$iv$iv4);
            $composer2.endReplaceableGroup();
            ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 scope2 = (ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) value$iv$iv4;
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv != Composer.INSTANCE.getEmpty()) {
            }
            $composer2.endReplaceableGroup();
            final FocusRequester focusRequester2 = (FocusRequester) value$iv$iv5;
            Modifier onGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier4, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                    invoke2(layoutCoordinates);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutCoordinates it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ExposedDropdownMenuKt.m1390ExposedDropdownMenuBox$lambda2(width$delegate, IntSize.m4542getWidthimpl(it.mo3497getSizeYbymL2g()));
                    coordinates.setValue(it);
                    View rootView = view.getRootView();
                    Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
                    LayoutCoordinates value = coordinates.getValue();
                    int i32 = verticalMarginInPx;
                    final MutableState<Integer> mutableState = menuHeight$delegate;
                    ExposedDropdownMenuKt.updateHeight(rootView, value, i32, new Function1<Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int newHeight) {
                            ExposedDropdownMenuKt.m1392ExposedDropdownMenuBox$lambda5(mutableState, newHeight);
                        }
                    });
                }
            });
            Object key2$iv22 = Boolean.valueOf(expanded);
            int i32 = (($dirty2 >> 3) & 14) | (($dirty2 << 3) & SdkConfig.SDK_VERSION);
            modifier3 = modifier4;
            $composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
            invalid$iv$iv = $composer2.changed(onExpandedChange) | $composer2.changed(key2$iv22);
            it$iv$iv2 = $composer2.rememberedValue();
            if (!invalid$iv$iv) {
                value$iv$iv6 = it$iv$iv2;
                $composer2.endReplaceableGroup();
                Modifier modifier$iv22 = FocusRequesterModifierKt.focusRequester(expandable(onGloballyPositioned2, (Function0) value$iv$iv6, Strings_androidKt.m1511getString4foXLRw(Strings.INSTANCE.m1507getExposedDropdownMenuUdPEhr4(), $composer2, 6)), focusRequester2);
                $composer2.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv22 = Alignment.INSTANCE.getTopStart();
                int $i$f$Box22 = ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION);
                MeasurePolicy measurePolicy$iv22 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv22, false, $composer2, $i$f$Box22);
                int $changed$iv$iv22 = (0 << 3) & SdkConfig.SDK_VERSION;
                $composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume322 = $composer2.consume(localDensity222);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density density$iv$iv22 = (Density) consume322;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume422 = $composer2.consume(localLayoutDirection22);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LayoutDirection layoutDirection$iv$iv22 = (LayoutDirection) consume422;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration22 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume522 = $composer2.consume(localViewConfiguration22);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ViewConfiguration viewConfiguration$iv$iv22 = (ViewConfiguration) consume522;
                Function0 factory$iv$iv$iv22 = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv22 = LayoutKt.materializerOf(modifier$iv22);
                int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 9) & 7168) | 6;
                if (!($composer2.getApplier() instanceof Applier)) {
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                }
                $composer2.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv22 = Updater.m1639constructorimpl($composer2);
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, measurePolicy$iv22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, density$iv$iv22, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, layoutDirection$iv$iv22, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, viewConfiguration$iv$iv22, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer2.enableReusing();
                skippableUpdate$iv$iv$iv22.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv22 >> 3) & SdkConfig.SDK_VERSION));
                $composer2.startReplaceableGroup(2058660585);
                $changed$iv = ($changed$iv$iv$iv22 >> 9) & 14;
                $composer2.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation($composer2, "C72@3384L9:Box.kt#2w3rfo");
                if (($changed$iv & 11) == 2) {
                }
                BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                $changed2 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                $composer2.startReplaceableGroup(-443225682);
                ComposerKt.sourceInformation($composer2, "C133@5477L9:ExposedDropdownMenu.kt#jmzs0o");
                if (($changed2 & 81) == 16) {
                }
                content.invoke(scope2, $composer2, Integer.valueOf(($dirty2 >> 6) & SdkConfig.SDK_VERSION));
                $composer2.endReplaceableGroup();
                $composer2.endReplaceableGroup();
                $composer2.endReplaceableGroup();
                $composer2.endNode();
                $composer2.endReplaceableGroup();
                $composer2.endReplaceableGroup();
                EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (expanded) {
                            focusRequester2.requestFocus();
                        }
                    }
                }, $composer2, 0);
                EffectsKt.DisposableEffect(view, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        View view2 = view;
                        final View view3 = view;
                        final Ref<LayoutCoordinates> ref = coordinates;
                        final int i4 = verticalMarginInPx;
                        final MutableState<Integer> mutableState = menuHeight$delegate;
                        final OnGlobalLayoutListener listener = new OnGlobalLayoutListener(view2, new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                View rootView = view3.getRootView();
                                Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
                                LayoutCoordinates value = ref.getValue();
                                int i5 = i4;
                                final MutableState<Integer> mutableState2 = mutableState;
                                ExposedDropdownMenuKt.updateHeight(rootView, value, i5, new Function1<Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                        invoke(num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(int newHeight) {
                                        ExposedDropdownMenuKt.m1392ExposedDropdownMenuBox$lambda5(mutableState2, newHeight);
                                    }
                                });
                            }
                        });
                        return new DisposableEffectResult() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                OnGlobalLayoutListener.this.dispose();
                            }
                        };
                    }
                }, $composer2, 8);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            value$iv$iv6 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    onExpandedChange.invoke(Boolean.valueOf(!expanded));
                }
            };
            $composer2.updateRememberedValue(value$iv$iv6);
            $composer2.endReplaceableGroup();
            Modifier modifier$iv222 = FocusRequesterModifierKt.focusRequester(expandable(onGloballyPositioned2, (Function0) value$iv$iv6, Strings_androidKt.m1511getString4foXLRw(Strings.INSTANCE.m1507getExposedDropdownMenuUdPEhr4(), $composer2, 6)), focusRequester2);
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv222 = Alignment.INSTANCE.getTopStart();
            int $i$f$Box222 = ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION);
            MeasurePolicy measurePolicy$iv222 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv222, false, $composer2, $i$f$Box222);
            int $changed$iv$iv222 = (0 << 3) & SdkConfig.SDK_VERSION;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity2222 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3222 = $composer2.consume(localDensity2222);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv222 = (Density) consume3222;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection222 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4222 = $composer2.consume(localLayoutDirection222);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv222 = (LayoutDirection) consume4222;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration222 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5222 = $composer2.consume(localViewConfiguration222);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv222 = (ViewConfiguration) consume5222;
            Function0 factory$iv$iv$iv222 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv222 = LayoutKt.materializerOf(modifier$iv222);
            int $changed$iv$iv$iv222 = (($changed$iv$iv222 << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv222 = Updater.m1639constructorimpl($composer2);
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv222, measurePolicy$iv222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv222, density$iv$iv222, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv222, layoutDirection$iv$iv222, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv222, viewConfiguration$iv$iv222, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv$iv222.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv222 >> 3) & SdkConfig.SDK_VERSION));
            $composer2.startReplaceableGroup(2058660585);
            $changed$iv = ($changed$iv$iv$iv222 >> 9) & 14;
            $composer2.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation($composer2, "C72@3384L9:Box.kt#2w3rfo");
            if (($changed$iv & 11) == 2) {
            }
            BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
            $changed2 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
            $composer2.startReplaceableGroup(-443225682);
            ComposerKt.sourceInformation($composer2, "C133@5477L9:ExposedDropdownMenu.kt#jmzs0o");
            if (($changed2 & 81) == 16) {
            }
            content.invoke(scope2, $composer2, Integer.valueOf(($dirty2 >> 6) & SdkConfig.SDK_VERSION));
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (expanded) {
                        focusRequester2.requestFocus();
                    }
                }
            }, $composer2, 0);
            EffectsKt.DisposableEffect(view, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    View view2 = view;
                    final View view3 = view;
                    final Ref<LayoutCoordinates> ref = coordinates;
                    final int i4 = verticalMarginInPx;
                    final MutableState<Integer> mutableState = menuHeight$delegate;
                    final OnGlobalLayoutListener listener = new OnGlobalLayoutListener(view2, new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            View rootView = view3.getRootView();
                            Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
                            LayoutCoordinates value = ref.getValue();
                            int i5 = i4;
                            final MutableState<Integer> mutableState2 = mutableState;
                            ExposedDropdownMenuKt.updateHeight(rootView, value, i5, new Function1<Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                    invoke(num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(int newHeight) {
                                    ExposedDropdownMenuKt.m1392ExposedDropdownMenuBox$lambda5(mutableState2, newHeight);
                                }
                            });
                        }
                    });
                    return new DisposableEffectResult() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            OnGlobalLayoutListener.this.dispose();
                        }
                    };
                }
            }, $composer2, 8);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$6
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
                ExposedDropdownMenuKt.ExposedDropdownMenuBox(expanded, onExpandedChange, modifier5, content, composer, $changed | 1, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ExposedDropdownMenuBox$lambda-1, reason: not valid java name */
    public static final int m1389ExposedDropdownMenuBox$lambda1(MutableState<Integer> mutableState) {
        MutableState<Integer> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ExposedDropdownMenuBox$lambda-2, reason: not valid java name */
    public static final void m1390ExposedDropdownMenuBox$lambda2(MutableState<Integer> mutableState, int value) {
        mutableState.setValue(Integer.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ExposedDropdownMenuBox$lambda-4, reason: not valid java name */
    public static final int m1391ExposedDropdownMenuBox$lambda4(MutableState<Integer> mutableState) {
        MutableState<Integer> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ExposedDropdownMenuBox$lambda-5, reason: not valid java name */
    public static final void m1392ExposedDropdownMenuBox$lambda5(MutableState<Integer> mutableState, int value) {
        mutableState.setValue(Integer.valueOf(value));
    }

    private static final Modifier expandable(Modifier $this$expandable, final Function0<Unit> function0, final String menuLabel) {
        return SemanticsModifierKt.semantics$default(SuspendingPointerInputFilterKt.pointerInput($this$expandable, Unit.INSTANCE, new ExposedDropdownMenuKt$expandable$1(function0, null)), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$expandable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semantics) {
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                SemanticsPropertiesKt.setContentDescription(semantics, menuLabel);
                final Function0<Unit> function02 = function0;
                SemanticsPropertiesKt.onClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ExposedDropdownMenuKt$expandable$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        function02.invoke();
                        return true;
                    }
                }, 1, null);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateHeight(View view, LayoutCoordinates coordinates, int verticalMarginInPx, Function1<? super Integer, Unit> function1) {
        if (coordinates == null) {
            return;
        }
        Rect it = new Rect();
        view.getWindowVisibleDisplayFrame(it);
        float heightAbove = LayoutCoordinatesKt.boundsInWindow(coordinates).getTop() - it.top;
        float heightBelow = (it.bottom - it.top) - LayoutCoordinatesKt.boundsInWindow(coordinates).getBottom();
        function1.invoke(Integer.valueOf(((int) Math.max(heightAbove, heightBelow)) - verticalMarginInPx));
    }
}
