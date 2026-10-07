package androidx.compose.p000ui.focus;

import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.modifier.ModifierLocalKt;
import androidx.compose.p000ui.modifier.ModifierLocalProvider;
import androidx.compose.p000ui.modifier.ProvidableModifierLocal;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusModifier.kt */
@Metadata(m286d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\f\u0010\t\u001a\u00020\u0006*\u00020\u0006H\u0007\u001a\n\u0010\n\u001a\u00020\u0006*\u00020\u0006\u001a\u0014\u0010\n\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0000\"\u001c\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, m287d2 = {"ModifierLocalParentFocusModifier", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/ui/focus/FocusModifier;", "getModifierLocalParentFocusModifier", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "ResetFocusModifierLocals", "Landroidx/compose/ui/Modifier;", "getResetFocusModifierLocals", "()Landroidx/compose/ui/Modifier;", "focusModifier", "focusTarget", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class FocusModifierKt {
    private static final ProvidableModifierLocal<FocusModifier> ModifierLocalParentFocusModifier = ModifierLocalKt.modifierLocalOf(new Function0<FocusModifier>() { // from class: androidx.compose.ui.focus.FocusModifierKt$ModifierLocalParentFocusModifier$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FocusModifier invoke() {
            return null;
        }
    });
    private static final Modifier ResetFocusModifierLocals = Modifier.INSTANCE.then(new ModifierLocalProvider<FocusPropertiesModifier>() { // from class: androidx.compose.ui.focus.FocusModifierKt$ResetFocusModifierLocals$1
        @Override // androidx.compose.p000ui.modifier.ModifierLocalProvider
        public ProvidableModifierLocal<FocusPropertiesModifier> getKey() {
            return FocusPropertiesKt.getModifierLocalFocusProperties();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.compose.p000ui.modifier.ModifierLocalProvider
        public FocusPropertiesModifier getValue() {
            return null;
        }
    }).then(new ModifierLocalProvider<FocusEventModifierLocal>() { // from class: androidx.compose.ui.focus.FocusModifierKt$ResetFocusModifierLocals$2
        @Override // androidx.compose.p000ui.modifier.ModifierLocalProvider
        public ProvidableModifierLocal<FocusEventModifierLocal> getKey() {
            return FocusEventModifierKt.getModifierLocalFocusEvent();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.compose.p000ui.modifier.ModifierLocalProvider
        public FocusEventModifierLocal getValue() {
            return null;
        }
    }).then(new ModifierLocalProvider<FocusRequesterModifierLocal>() { // from class: androidx.compose.ui.focus.FocusModifierKt$ResetFocusModifierLocals$3
        @Override // androidx.compose.p000ui.modifier.ModifierLocalProvider
        public ProvidableModifierLocal<FocusRequesterModifierLocal> getKey() {
            return FocusRequesterModifierKt.getModifierLocalFocusRequester();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.compose.p000ui.modifier.ModifierLocalProvider
        public FocusRequesterModifierLocal getValue() {
            return null;
        }
    });

    public static final ProvidableModifierLocal<FocusModifier> getModifierLocalParentFocusModifier() {
        return ModifierLocalParentFocusModifier;
    }

    public static final Modifier focusTarget(Modifier $this$focusTarget) {
        Intrinsics.checkNotNullParameter($this$focusTarget, "<this>");
        return ComposedModifierKt.composed($this$focusTarget, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.focus.FocusModifierKt$focusTarget$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("focusTarget");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.ui.focus.FocusModifierKt$focusTarget$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Object value$iv$iv;
                Object value$iv$iv2;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(-326009031);
                ComposerKt.sourceInformation($composer, "C195@8442L36,196@8494L48,196@8483L59:FocusModifier.kt#b42af3");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-326009031, $changed, -1, "androidx.compose.ui.focus.focusTarget.<anonymous> (FocusModifier.kt:194)");
                }
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv = $composer.rememberedValue();
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = new FocusModifier(FocusStateImpl.Inactive, null, 2, null);
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                final FocusModifier focusModifier = (FocusModifier) value$iv$iv;
                $composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer.changed(focusModifier);
                Object it$iv$iv2 = $composer.rememberedValue();
                if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusModifierKt$focusTarget$2$1$1
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
                            FocusTransactionsKt.sendOnFocusEvent(FocusModifier.this);
                        }
                    };
                    $composer.updateRememberedValue(value$iv$iv2);
                } else {
                    value$iv$iv2 = it$iv$iv2;
                }
                $composer.endReplaceableGroup();
                EffectsKt.SideEffect((Function0) value$iv$iv2, $composer, 0);
                Modifier focusTarget = FocusModifierKt.focusTarget(composed, focusModifier);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return focusTarget;
            }
        });
    }

    @Deprecated(message = "Replaced by focusTarget", replaceWith = @ReplaceWith(expression = "focusTarget()", imports = {"androidx.compose.ui.focus.focusTarget"}))
    public static final Modifier focusModifier(Modifier $this$focusModifier) {
        Intrinsics.checkNotNullParameter($this$focusModifier, "<this>");
        return ComposedModifierKt.composed($this$focusModifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.focus.FocusModifierKt$focusModifier$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("focusModifier");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.ui.focus.FocusModifierKt$focusModifier$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Object value$iv$iv;
                Object value$iv$iv2;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(-1810534337);
                ComposerKt.sourceInformation($composer, "C210@8886L36,211@8938L48,211@8927L59:FocusModifier.kt#b42af3");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1810534337, $changed, -1, "androidx.compose.ui.focus.focusModifier.<anonymous> (FocusModifier.kt:209)");
                }
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv = $composer.rememberedValue();
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = new FocusModifier(FocusStateImpl.Inactive, null, 2, null);
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                final FocusModifier focusModifier = (FocusModifier) value$iv$iv;
                $composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer.changed(focusModifier);
                Object it$iv$iv2 = $composer.rememberedValue();
                if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusModifierKt$focusModifier$2$1$1
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
                            FocusTransactionsKt.sendOnFocusEvent(FocusModifier.this);
                        }
                    };
                    $composer.updateRememberedValue(value$iv$iv2);
                } else {
                    value$iv$iv2 = it$iv$iv2;
                }
                $composer.endReplaceableGroup();
                EffectsKt.SideEffect((Function0) value$iv$iv2, $composer, 0);
                Modifier focusTarget = FocusModifierKt.focusTarget(composed, focusModifier);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return focusTarget;
            }
        });
    }

    public static final Modifier focusTarget(Modifier $this$focusTarget, FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter($this$focusTarget, "<this>");
        Intrinsics.checkNotNullParameter(focusModifier, "focusModifier");
        return $this$focusTarget.then(focusModifier).then(ResetFocusModifierLocals);
    }

    public static final Modifier getResetFocusModifierLocals() {
        return ResetFocusModifierLocals;
    }
}
