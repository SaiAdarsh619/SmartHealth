package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.colorspace.ColorSpace;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldImpl.kt */
@Metadata(m286d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jµ\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2e\u0010\u000f\u001aa\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, m287d2 = {"Landroidx/compose/material/TextFieldTransitionScope;", "", "()V", "Transition", "", "inputState", "Landroidx/compose/material/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "showLabel", "", "content", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "Transition-DTcfvLk", "(Landroidx/compose/material/InputPhase;JJLkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function6;Landroidx/compose/runtime/Composer;I)V", "material_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class TextFieldTransitionScope {
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    /* compiled from: TextFieldImpl.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputPhase.values().length];
            iArr[InputPhase.Focused.ordinal()] = 1;
            iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TextFieldTransitionScope() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0502 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03a4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0353  */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* renamed from: Transition-DTcfvLk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1583TransitionDTcfvLk(final InputPhase inputState, final long focusedTextStyleColor, final long unfocusedTextStyleColor, final Function3<? super InputPhase, ? super Composer, ? super Integer, Color> contentColor, final boolean showLabel, final Function6<? super Float, ? super Color, ? super Color, ? super Float, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed) {
        int $dirty;
        float f;
        String str;
        ?? r5;
        float f2;
        float f3;
        boolean invalid$iv$iv$iv;
        Object it$iv$iv$iv;
        Object value$iv$iv$iv;
        boolean invalid$iv$iv$iv2;
        Object it$iv$iv$iv2;
        Object value$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(inputState, "inputState");
        Intrinsics.checkNotNullParameter(contentColor, "contentColor");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(1988729962);
        ComposerKt.sourceInformation($composer2, "C(Transition)P(3,2:c#ui.graphics.Color,5:c#ui.graphics.Color,1,4)276@11184L59,278@11285L325,289@11657L1101,317@12806L299,327@13151L186,333@13347L140:TextFieldImpl.kt#jmzs0o");
        int $dirty2 = $changed;
        if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(inputState) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer2.changed(focusedTextStyleColor) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changed(unfocusedTextStyleColor) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty2 |= $composer2.changed(contentColor) ? 2048 : 1024;
        }
        if (($changed & 57344) == 0) {
            $dirty2 |= $composer2.changed(showLabel) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            $dirty2 |= $composer2.changed(content) ? 131072 : 65536;
        }
        int $dirty3 = $dirty2;
        if ((374491 & $dirty3) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1988729962, $dirty3, -1, "androidx.compose.material.TextFieldTransitionScope.Transition (TextFieldImpl.kt:260)");
            }
            Transition transition = TransitionKt.updateTransition(inputState, "TextFieldInputState", $composer2, ($dirty3 & 14) | 48, 0);
            Function3 transitionSpec$iv = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelProgress$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> animateFloat, Composer $composer3, int $changed2) {
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    $composer3.startReplaceableGroup(-611722692);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-611722692, $changed2, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:280)");
                    }
                    TweenSpec tween$default = AnimationSpecKt.tween$default(TextFieldImplKt.AnimationDuration, 0, null, 6, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3.endReplaceableGroup();
                    return tween$default;
                }
            };
            $composer2.startReplaceableGroup(1399891485);
            ComposerKt.sourceInformation($composer2, "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli");
            TwoWayConverter typeConverter$iv$iv = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
            $composer2.startReplaceableGroup(1847725064);
            ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
            Object currentState = transition.getCurrentState();
            int $changed2 = ($changed$iv$iv >> 9) & SdkConfig.SDK_VERSION;
            InputPhase it = (InputPhase) currentState;
            $composer2.startReplaceableGroup(-1158004136);
            ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                $dirty = $dirty3;
                ComposerKt.traceEventStart(-1158004136, $changed2, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:281)");
            } else {
                $dirty = $dirty3;
            }
            float f4 = 1.0f;
            switch (WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
                case 1:
                    f = 1.0f;
                    break;
                case 2:
                    f = 0.0f;
                    break;
                case 3:
                    f = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceableGroup();
            Object initialValue$iv$iv = Float.valueOf(f);
            Object targetState = transition.getTargetState();
            int $changed3 = ($changed$iv$iv >> 9) & SdkConfig.SDK_VERSION;
            InputPhase it2 = (InputPhase) targetState;
            $composer2.startReplaceableGroup(-1158004136);
            ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                str = "C:TextFieldImpl.kt#jmzs0o";
                r5 = -1;
                ComposerKt.traceEventStart(-1158004136, $changed3, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:281)");
            } else {
                str = "C:TextFieldImpl.kt#jmzs0o";
                r5 = -1;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it2.ordinal()]) {
                case 1:
                    f2 = 1.0f;
                    break;
                case 2:
                    f2 = 0.0f;
                    break;
                case 3:
                    f2 = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceableGroup();
            Object targetValue$iv$iv = Float.valueOf(f2);
            FiniteAnimationSpec<Float> animationSpec$iv$iv = transitionSpec$iv.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & SdkConfig.SDK_VERSION));
            String str2 = str;
            int $dirty4 = $dirty;
            State labelProgress$delegate = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv, targetValue$iv$iv, animationSpec$iv$iv, typeConverter$iv$iv, "LabelProgress", $composer2, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            Function3 transitionSpec$iv2 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$placeholderOpacity$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> animateFloat, Composer $composer3, int $changed4) {
                    TweenSpec tween;
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    $composer3.startReplaceableGroup(-1079955085);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1079955085, $changed4, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:291)");
                    }
                    if (animateFloat.isTransitioningTo(InputPhase.Focused, InputPhase.UnfocusedEmpty)) {
                        tween = AnimationSpecKt.tween$default(67, 0, EasingKt.getLinearEasing(), 2, null);
                    } else if (animateFloat.isTransitioningTo(InputPhase.UnfocusedEmpty, InputPhase.Focused) || animateFloat.isTransitioningTo(InputPhase.UnfocusedNotEmpty, InputPhase.UnfocusedEmpty)) {
                        tween = AnimationSpecKt.tween(83, 67, EasingKt.getLinearEasing());
                    } else {
                        tween = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3.endReplaceableGroup();
                    return tween;
                }
            };
            $composer2.startReplaceableGroup(1399891485);
            ComposerKt.sourceInformation($composer2, "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli");
            TwoWayConverter typeConverter$iv$iv2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv2 = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
            $composer2.startReplaceableGroup(1847725064);
            ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
            Object currentState2 = transition.getCurrentState();
            int $changed4 = ($changed$iv$iv2 >> 9) & SdkConfig.SDK_VERSION;
            InputPhase it3 = (InputPhase) currentState2;
            $composer2.startReplaceableGroup(-1376159017);
            ComposerKt.sourceInformation($composer2, str2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1376159017, $changed4, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:309)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it3.ordinal()]) {
                case 1:
                    f3 = 1.0f;
                    break;
                case 2:
                    if (!showLabel) {
                        f3 = 1.0f;
                        break;
                    } else {
                        f3 = 0.0f;
                        break;
                    }
                case 3:
                    f3 = 0.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceableGroup();
            Object initialValue$iv$iv2 = Float.valueOf(f3);
            Object targetState2 = transition.getTargetState();
            int $changed5 = ($changed$iv$iv2 >> 9) & SdkConfig.SDK_VERSION;
            InputPhase it4 = (InputPhase) targetState2;
            $composer2.startReplaceableGroup(-1376159017);
            ComposerKt.sourceInformation($composer2, str2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1376159017, $changed5, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:309)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it4.ordinal()]) {
                case 1:
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceableGroup();
                    Object targetValue$iv$iv2 = Float.valueOf(f4);
                    FiniteAnimationSpec<Float> animationSpec$iv$iv2 = transitionSpec$iv2.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                    State placeholderOpacity$delegate = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv2, targetValue$iv$iv2, animationSpec$iv$iv2, typeConverter$iv$iv2, "PlaceholderOpacity", $composer2, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    Function3 transitionSpec$iv3 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                            return invoke(segment, composer, num.intValue());
                        }

                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> animateColor, Composer $composer3, int $changed6) {
                            Intrinsics.checkNotNullParameter(animateColor, "$this$animateColor");
                            $composer3.startReplaceableGroup(-130058045);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-130058045, $changed6, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:318)");
                            }
                            TweenSpec tween$default = AnimationSpecKt.tween$default(TextFieldImplKt.AnimationDuration, 0, null, 6, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            $composer3.endReplaceableGroup();
                            return tween$default;
                        }
                    };
                    $composer2.startReplaceableGroup(-1462136984);
                    ComposerKt.sourceInformation($composer2, "C(animateColor)P(2)68@3224L31,69@3291L70,73@3374L70:Transition.kt#xbi5r1");
                    Object targetState3 = transition.getTargetState();
                    int $changed6 = (384 >> 6) & SdkConfig.SDK_VERSION;
                    InputPhase it5 = (InputPhase) targetState3;
                    $composer2.startReplaceableGroup(-1490209928);
                    ComposerKt.sourceInformation($composer2, str2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1490209928, $changed6, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:320)");
                    }
                    long j = WhenMappings.$EnumSwitchMapping$0[it5.ordinal()] == 1 ? focusedTextStyleColor : unfocusedTextStyleColor;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceableGroup();
                    ColorSpace colorSpace$iv = Color.m2000getColorSpaceimpl(j);
                    $composer2.startReplaceableGroup(-3686930);
                    ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                    invalid$iv$iv$iv = $composer2.changed(colorSpace$iv);
                    it$iv$iv$iv = $composer2.rememberedValue();
                    if (invalid$iv$iv$iv && it$iv$iv$iv != Composer.INSTANCE.getEmpty()) {
                        value$iv$iv$iv = it$iv$iv$iv;
                        $composer2.endReplaceableGroup();
                        TwoWayConverter typeConverter$iv = (TwoWayConverter) value$iv$iv$iv;
                        int $changed$iv$iv3 = (384 & 14) | 64 | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
                        $composer2.startReplaceableGroup(1847725064);
                        ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
                        Object currentState3 = transition.getCurrentState();
                        int $changed7 = ($changed$iv$iv3 >> 9) & SdkConfig.SDK_VERSION;
                        InputPhase it6 = (InputPhase) currentState3;
                        $composer2.startReplaceableGroup(-1490209928);
                        ComposerKt.sourceInformation($composer2, str2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1490209928, $changed7, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:320)");
                        }
                        long j2 = WhenMappings.$EnumSwitchMapping$0[it6.ordinal()] == 1 ? focusedTextStyleColor : unfocusedTextStyleColor;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        $composer2.endReplaceableGroup();
                        Object initialValue$iv$iv3 = Color.m1986boximpl(j2);
                        Object targetState4 = transition.getTargetState();
                        int $changed8 = ($changed$iv$iv3 >> 9) & SdkConfig.SDK_VERSION;
                        InputPhase it7 = (InputPhase) targetState4;
                        $composer2.startReplaceableGroup(-1490209928);
                        ComposerKt.sourceInformation($composer2, str2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1490209928, $changed8, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:320)");
                        }
                        long j3 = WhenMappings.$EnumSwitchMapping$0[it7.ordinal()] == 1 ? focusedTextStyleColor : unfocusedTextStyleColor;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        $composer2.endReplaceableGroup();
                        Object targetValue$iv$iv3 = Color.m1986boximpl(j3);
                        FiniteAnimationSpec<Color> animationSpec$iv$iv3 = transitionSpec$iv3.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv3 >> 3) & SdkConfig.SDK_VERSION));
                        State labelTextStyleColor$delegate = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv3, targetValue$iv$iv3, animationSpec$iv$iv3, typeConverter$iv, "LabelTextStyleColor", $composer2, ($changed$iv$iv3 & 14) | (($changed$iv$iv3 << 9) & 57344) | (($changed$iv$iv3 << 6) & 458752));
                        $composer2.endReplaceableGroup();
                        $composer2.endReplaceableGroup();
                        Function3 transitionSpec$iv4 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                                return invoke(segment, composer, num.intValue());
                            }

                            public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> animateColor, Composer $composer3, int $changed9) {
                                Intrinsics.checkNotNullParameter(animateColor, "$this$animateColor");
                                $composer3.startReplaceableGroup(-32667848);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-32667848, $changed9, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:328)");
                                }
                                TweenSpec tween$default = AnimationSpecKt.tween$default(TextFieldImplKt.AnimationDuration, 0, null, 6, null);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                $composer3.endReplaceableGroup();
                                return tween$default;
                            }
                        };
                        int $changed$iv = ($dirty4 & 7168) | 384;
                        $composer2.startReplaceableGroup(-1462136984);
                        ComposerKt.sourceInformation($composer2, "C(animateColor)P(2)68@3224L31,69@3291L70,73@3374L70:Transition.kt#xbi5r1");
                        ColorSpace colorSpace$iv2 = Color.m2000getColorSpaceimpl(contentColor.invoke(transition.getTargetState(), $composer2, Integer.valueOf(($changed$iv >> 6) & SdkConfig.SDK_VERSION)).m2006unboximpl());
                        $composer2.startReplaceableGroup(-3686930);
                        ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                        invalid$iv$iv$iv2 = $composer2.changed(colorSpace$iv2);
                        it$iv$iv$iv2 = $composer2.rememberedValue();
                        if (invalid$iv$iv$iv2 && it$iv$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                            value$iv$iv$iv2 = it$iv$iv$iv2;
                            $composer2.endReplaceableGroup();
                            TwoWayConverter typeConverter$iv2 = (TwoWayConverter) value$iv$iv$iv2;
                            int $changed$iv$iv4 = (($changed$iv << 3) & 57344) | ($changed$iv & 14) | 64 | (($changed$iv << 3) & 896) | (($changed$iv << 3) & 7168);
                            $composer2.startReplaceableGroup(1847725064);
                            ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
                            Object initialValue$iv$iv4 = contentColor.invoke(transition.getCurrentState(), $composer2, Integer.valueOf(($changed$iv$iv4 >> 9) & SdkConfig.SDK_VERSION));
                            Object targetValue$iv$iv4 = contentColor.invoke(transition.getTargetState(), $composer2, Integer.valueOf(($changed$iv$iv4 >> 9) & SdkConfig.SDK_VERSION));
                            FiniteAnimationSpec<Color> animationSpec$iv$iv4 = transitionSpec$iv4.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv4 >> 3) & SdkConfig.SDK_VERSION));
                            State labelContentColor$delegate = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv4, targetValue$iv$iv4, animationSpec$iv$iv4, typeConverter$iv2, "LabelContentColor", $composer2, ($changed$iv$iv4 & 14) | (($changed$iv$iv4 << 9) & 57344) | (($changed$iv$iv4 << 6) & 458752));
                            $composer2.endReplaceableGroup();
                            $composer2.endReplaceableGroup();
                            content.invoke(Float.valueOf(m1579Transition_DTcfvLk$lambda1(labelProgress$delegate)), Color.m1986boximpl(m1581Transition_DTcfvLk$lambda5(labelTextStyleColor$delegate)), Color.m1986boximpl(m1582Transition_DTcfvLk$lambda6(labelContentColor$delegate)), Float.valueOf(m1580Transition_DTcfvLk$lambda3(placeholderOpacity$delegate)), $composer2, Integer.valueOf(($dirty4 >> 3) & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                break;
                            }
                        }
                        value$iv$iv$iv2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv2);
                        $composer2.updateRememberedValue(value$iv$iv$iv2);
                        $composer2.endReplaceableGroup();
                        TwoWayConverter typeConverter$iv22 = (TwoWayConverter) value$iv$iv$iv2;
                        int $changed$iv$iv42 = (($changed$iv << 3) & 57344) | ($changed$iv & 14) | 64 | (($changed$iv << 3) & 896) | (($changed$iv << 3) & 7168);
                        $composer2.startReplaceableGroup(1847725064);
                        ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
                        Object initialValue$iv$iv42 = contentColor.invoke(transition.getCurrentState(), $composer2, Integer.valueOf(($changed$iv$iv42 >> 9) & SdkConfig.SDK_VERSION));
                        Object targetValue$iv$iv42 = contentColor.invoke(transition.getTargetState(), $composer2, Integer.valueOf(($changed$iv$iv42 >> 9) & SdkConfig.SDK_VERSION));
                        FiniteAnimationSpec<Color> animationSpec$iv$iv42 = transitionSpec$iv4.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv42 >> 3) & SdkConfig.SDK_VERSION));
                        State labelContentColor$delegate2 = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv42, targetValue$iv$iv42, animationSpec$iv$iv42, typeConverter$iv22, "LabelContentColor", $composer2, ($changed$iv$iv42 & 14) | (($changed$iv$iv42 << 9) & 57344) | (($changed$iv$iv42 << 6) & 458752));
                        $composer2.endReplaceableGroup();
                        $composer2.endReplaceableGroup();
                        content.invoke(Float.valueOf(m1579Transition_DTcfvLk$lambda1(labelProgress$delegate)), Color.m1986boximpl(m1581Transition_DTcfvLk$lambda5(labelTextStyleColor$delegate)), Color.m1986boximpl(m1582Transition_DTcfvLk$lambda6(labelContentColor$delegate2)), Float.valueOf(m1580Transition_DTcfvLk$lambda3(placeholderOpacity$delegate)), $composer2, Integer.valueOf(($dirty4 >> 3) & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                    value$iv$iv$iv = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv);
                    $composer2.updateRememberedValue(value$iv$iv$iv);
                    $composer2.endReplaceableGroup();
                    TwoWayConverter typeConverter$iv3 = (TwoWayConverter) value$iv$iv$iv;
                    int $changed$iv$iv32 = (384 & 14) | 64 | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
                    $composer2.startReplaceableGroup(1847725064);
                    ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
                    Object currentState32 = transition.getCurrentState();
                    int $changed72 = ($changed$iv$iv32 >> 9) & SdkConfig.SDK_VERSION;
                    InputPhase it62 = (InputPhase) currentState32;
                    $composer2.startReplaceableGroup(-1490209928);
                    ComposerKt.sourceInformation($composer2, str2);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[it62.ordinal()] == 1) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer2.endReplaceableGroup();
                    Object initialValue$iv$iv32 = Color.m1986boximpl(j2);
                    Object targetState42 = transition.getTargetState();
                    int $changed82 = ($changed$iv$iv32 >> 9) & SdkConfig.SDK_VERSION;
                    InputPhase it72 = (InputPhase) targetState42;
                    $composer2.startReplaceableGroup(-1490209928);
                    ComposerKt.sourceInformation($composer2, str2);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[it72.ordinal()] == 1) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer2.endReplaceableGroup();
                    Object targetValue$iv$iv32 = Color.m1986boximpl(j3);
                    FiniteAnimationSpec<Color> animationSpec$iv$iv32 = transitionSpec$iv3.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv32 >> 3) & SdkConfig.SDK_VERSION));
                    State labelTextStyleColor$delegate2 = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv32, targetValue$iv$iv32, animationSpec$iv$iv32, typeConverter$iv3, "LabelTextStyleColor", $composer2, ($changed$iv$iv32 & 14) | (($changed$iv$iv32 << 9) & 57344) | (($changed$iv$iv32 << 6) & 458752));
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    Function3 transitionSpec$iv42 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                            return invoke(segment, composer, num.intValue());
                        }

                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> animateColor, Composer $composer3, int $changed9) {
                            Intrinsics.checkNotNullParameter(animateColor, "$this$animateColor");
                            $composer3.startReplaceableGroup(-32667848);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-32667848, $changed9, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:328)");
                            }
                            TweenSpec tween$default = AnimationSpecKt.tween$default(TextFieldImplKt.AnimationDuration, 0, null, 6, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            $composer3.endReplaceableGroup();
                            return tween$default;
                        }
                    };
                    int $changed$iv2 = ($dirty4 & 7168) | 384;
                    $composer2.startReplaceableGroup(-1462136984);
                    ComposerKt.sourceInformation($composer2, "C(animateColor)P(2)68@3224L31,69@3291L70,73@3374L70:Transition.kt#xbi5r1");
                    ColorSpace colorSpace$iv22 = Color.m2000getColorSpaceimpl(contentColor.invoke(transition.getTargetState(), $composer2, Integer.valueOf(($changed$iv2 >> 6) & SdkConfig.SDK_VERSION)).m2006unboximpl());
                    $composer2.startReplaceableGroup(-3686930);
                    ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                    invalid$iv$iv$iv2 = $composer2.changed(colorSpace$iv22);
                    it$iv$iv$iv2 = $composer2.rememberedValue();
                    if (invalid$iv$iv$iv2) {
                        value$iv$iv$iv2 = it$iv$iv$iv2;
                        $composer2.endReplaceableGroup();
                        TwoWayConverter typeConverter$iv222 = (TwoWayConverter) value$iv$iv$iv2;
                        int $changed$iv$iv422 = (($changed$iv2 << 3) & 57344) | ($changed$iv2 & 14) | 64 | (($changed$iv2 << 3) & 896) | (($changed$iv2 << 3) & 7168);
                        $composer2.startReplaceableGroup(1847725064);
                        ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
                        Object initialValue$iv$iv422 = contentColor.invoke(transition.getCurrentState(), $composer2, Integer.valueOf(($changed$iv$iv422 >> 9) & SdkConfig.SDK_VERSION));
                        Object targetValue$iv$iv422 = contentColor.invoke(transition.getTargetState(), $composer2, Integer.valueOf(($changed$iv$iv422 >> 9) & SdkConfig.SDK_VERSION));
                        FiniteAnimationSpec<Color> animationSpec$iv$iv422 = transitionSpec$iv42.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv422 >> 3) & SdkConfig.SDK_VERSION));
                        State labelContentColor$delegate22 = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv422, targetValue$iv$iv422, animationSpec$iv$iv422, typeConverter$iv222, "LabelContentColor", $composer2, ($changed$iv$iv422 & 14) | (($changed$iv$iv422 << 9) & 57344) | (($changed$iv$iv422 << 6) & 458752));
                        $composer2.endReplaceableGroup();
                        $composer2.endReplaceableGroup();
                        content.invoke(Float.valueOf(m1579Transition_DTcfvLk$lambda1(labelProgress$delegate)), Color.m1986boximpl(m1581Transition_DTcfvLk$lambda5(labelTextStyleColor$delegate2)), Color.m1986boximpl(m1582Transition_DTcfvLk$lambda6(labelContentColor$delegate22)), Float.valueOf(m1580Transition_DTcfvLk$lambda3(placeholderOpacity$delegate)), $composer2, Integer.valueOf(($dirty4 >> 3) & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                    value$iv$iv$iv2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv22);
                    $composer2.updateRememberedValue(value$iv$iv$iv2);
                    $composer2.endReplaceableGroup();
                    TwoWayConverter typeConverter$iv2222 = (TwoWayConverter) value$iv$iv$iv2;
                    int $changed$iv$iv4222 = (($changed$iv2 << 3) & 57344) | ($changed$iv2 & 14) | 64 | (($changed$iv2 << 3) & 896) | (($changed$iv2 << 3) & 7168);
                    $composer2.startReplaceableGroup(1847725064);
                    ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
                    Object initialValue$iv$iv4222 = contentColor.invoke(transition.getCurrentState(), $composer2, Integer.valueOf(($changed$iv$iv4222 >> 9) & SdkConfig.SDK_VERSION));
                    Object targetValue$iv$iv4222 = contentColor.invoke(transition.getTargetState(), $composer2, Integer.valueOf(($changed$iv$iv4222 >> 9) & SdkConfig.SDK_VERSION));
                    FiniteAnimationSpec<Color> animationSpec$iv$iv4222 = transitionSpec$iv42.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv4222 >> 3) & SdkConfig.SDK_VERSION));
                    State labelContentColor$delegate222 = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv4222, targetValue$iv$iv4222, animationSpec$iv$iv4222, typeConverter$iv2222, "LabelContentColor", $composer2, ($changed$iv$iv4222 & 14) | (($changed$iv$iv4222 << 9) & 57344) | (($changed$iv$iv4222 << 6) & 458752));
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    content.invoke(Float.valueOf(m1579Transition_DTcfvLk$lambda1(labelProgress$delegate)), Color.m1986boximpl(m1581Transition_DTcfvLk$lambda5(labelTextStyleColor$delegate2)), Color.m1986boximpl(m1582Transition_DTcfvLk$lambda6(labelContentColor$delegate222)), Float.valueOf(m1580Transition_DTcfvLk$lambda3(placeholderOpacity$delegate)), $composer2, Integer.valueOf(($dirty4 >> 3) & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    break;
                case 2:
                    if (showLabel) {
                        f4 = 0.0f;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer2.endReplaceableGroup();
                    Object targetValue$iv$iv22 = Float.valueOf(f4);
                    FiniteAnimationSpec<Float> animationSpec$iv$iv22 = transitionSpec$iv2.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                    State placeholderOpacity$delegate2 = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv2, targetValue$iv$iv22, animationSpec$iv$iv22, typeConverter$iv$iv2, "PlaceholderOpacity", $composer2, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    Function3 transitionSpec$iv32 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                            return invoke(segment, composer, num.intValue());
                        }

                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> animateColor, Composer $composer3, int $changed62) {
                            Intrinsics.checkNotNullParameter(animateColor, "$this$animateColor");
                            $composer3.startReplaceableGroup(-130058045);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-130058045, $changed62, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:318)");
                            }
                            TweenSpec tween$default = AnimationSpecKt.tween$default(TextFieldImplKt.AnimationDuration, 0, null, 6, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            $composer3.endReplaceableGroup();
                            return tween$default;
                        }
                    };
                    $composer2.startReplaceableGroup(-1462136984);
                    ComposerKt.sourceInformation($composer2, "C(animateColor)P(2)68@3224L31,69@3291L70,73@3374L70:Transition.kt#xbi5r1");
                    Object targetState32 = transition.getTargetState();
                    int $changed62 = (384 >> 6) & SdkConfig.SDK_VERSION;
                    InputPhase it52 = (InputPhase) targetState32;
                    $composer2.startReplaceableGroup(-1490209928);
                    ComposerKt.sourceInformation($composer2, str2);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[it52.ordinal()] == 1) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer2.endReplaceableGroup();
                    ColorSpace colorSpace$iv3 = Color.m2000getColorSpaceimpl(j);
                    $composer2.startReplaceableGroup(-3686930);
                    ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                    invalid$iv$iv$iv = $composer2.changed(colorSpace$iv3);
                    it$iv$iv$iv = $composer2.rememberedValue();
                    if (invalid$iv$iv$iv) {
                        value$iv$iv$iv = it$iv$iv$iv;
                        $composer2.endReplaceableGroup();
                        TwoWayConverter typeConverter$iv32 = (TwoWayConverter) value$iv$iv$iv;
                        int $changed$iv$iv322 = (384 & 14) | 64 | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
                        $composer2.startReplaceableGroup(1847725064);
                        ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
                        Object currentState322 = transition.getCurrentState();
                        int $changed722 = ($changed$iv$iv322 >> 9) & SdkConfig.SDK_VERSION;
                        InputPhase it622 = (InputPhase) currentState322;
                        $composer2.startReplaceableGroup(-1490209928);
                        ComposerKt.sourceInformation($composer2, str2);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (WhenMappings.$EnumSwitchMapping$0[it622.ordinal()] == 1) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        $composer2.endReplaceableGroup();
                        Object initialValue$iv$iv322 = Color.m1986boximpl(j2);
                        Object targetState422 = transition.getTargetState();
                        int $changed822 = ($changed$iv$iv322 >> 9) & SdkConfig.SDK_VERSION;
                        InputPhase it722 = (InputPhase) targetState422;
                        $composer2.startReplaceableGroup(-1490209928);
                        ComposerKt.sourceInformation($composer2, str2);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (WhenMappings.$EnumSwitchMapping$0[it722.ordinal()] == 1) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        $composer2.endReplaceableGroup();
                        Object targetValue$iv$iv322 = Color.m1986boximpl(j3);
                        FiniteAnimationSpec<Color> animationSpec$iv$iv322 = transitionSpec$iv32.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv322 >> 3) & SdkConfig.SDK_VERSION));
                        State labelTextStyleColor$delegate22 = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv322, targetValue$iv$iv322, animationSpec$iv$iv322, typeConverter$iv32, "LabelTextStyleColor", $composer2, ($changed$iv$iv322 & 14) | (($changed$iv$iv322 << 9) & 57344) | (($changed$iv$iv322 << 6) & 458752));
                        $composer2.endReplaceableGroup();
                        $composer2.endReplaceableGroup();
                        Function3 transitionSpec$iv422 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                                return invoke(segment, composer, num.intValue());
                            }

                            public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> animateColor, Composer $composer3, int $changed9) {
                                Intrinsics.checkNotNullParameter(animateColor, "$this$animateColor");
                                $composer3.startReplaceableGroup(-32667848);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-32667848, $changed9, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:328)");
                                }
                                TweenSpec tween$default = AnimationSpecKt.tween$default(TextFieldImplKt.AnimationDuration, 0, null, 6, null);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                $composer3.endReplaceableGroup();
                                return tween$default;
                            }
                        };
                        int $changed$iv22 = ($dirty4 & 7168) | 384;
                        $composer2.startReplaceableGroup(-1462136984);
                        ComposerKt.sourceInformation($composer2, "C(animateColor)P(2)68@3224L31,69@3291L70,73@3374L70:Transition.kt#xbi5r1");
                        ColorSpace colorSpace$iv222 = Color.m2000getColorSpaceimpl(contentColor.invoke(transition.getTargetState(), $composer2, Integer.valueOf(($changed$iv22 >> 6) & SdkConfig.SDK_VERSION)).m2006unboximpl());
                        $composer2.startReplaceableGroup(-3686930);
                        ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                        invalid$iv$iv$iv2 = $composer2.changed(colorSpace$iv222);
                        it$iv$iv$iv2 = $composer2.rememberedValue();
                        if (invalid$iv$iv$iv2) {
                        }
                        value$iv$iv$iv2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv222);
                        $composer2.updateRememberedValue(value$iv$iv$iv2);
                        $composer2.endReplaceableGroup();
                        TwoWayConverter typeConverter$iv22222 = (TwoWayConverter) value$iv$iv$iv2;
                        int $changed$iv$iv42222 = (($changed$iv22 << 3) & 57344) | ($changed$iv22 & 14) | 64 | (($changed$iv22 << 3) & 896) | (($changed$iv22 << 3) & 7168);
                        $composer2.startReplaceableGroup(1847725064);
                        ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
                        Object initialValue$iv$iv42222 = contentColor.invoke(transition.getCurrentState(), $composer2, Integer.valueOf(($changed$iv$iv42222 >> 9) & SdkConfig.SDK_VERSION));
                        Object targetValue$iv$iv42222 = contentColor.invoke(transition.getTargetState(), $composer2, Integer.valueOf(($changed$iv$iv42222 >> 9) & SdkConfig.SDK_VERSION));
                        FiniteAnimationSpec<Color> animationSpec$iv$iv42222 = transitionSpec$iv422.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv42222 >> 3) & SdkConfig.SDK_VERSION));
                        State labelContentColor$delegate2222 = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv42222, targetValue$iv$iv42222, animationSpec$iv$iv42222, typeConverter$iv22222, "LabelContentColor", $composer2, ($changed$iv$iv42222 & 14) | (($changed$iv$iv42222 << 9) & 57344) | (($changed$iv$iv42222 << 6) & 458752));
                        $composer2.endReplaceableGroup();
                        $composer2.endReplaceableGroup();
                        content.invoke(Float.valueOf(m1579Transition_DTcfvLk$lambda1(labelProgress$delegate)), Color.m1986boximpl(m1581Transition_DTcfvLk$lambda5(labelTextStyleColor$delegate22)), Color.m1986boximpl(m1582Transition_DTcfvLk$lambda6(labelContentColor$delegate2222)), Float.valueOf(m1580Transition_DTcfvLk$lambda3(placeholderOpacity$delegate2)), $composer2, Integer.valueOf(($dirty4 >> 3) & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        break;
                    }
                    value$iv$iv$iv = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv3);
                    $composer2.updateRememberedValue(value$iv$iv$iv);
                    $composer2.endReplaceableGroup();
                    TwoWayConverter typeConverter$iv322 = (TwoWayConverter) value$iv$iv$iv;
                    int $changed$iv$iv3222 = (384 & 14) | 64 | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
                    $composer2.startReplaceableGroup(1847725064);
                    ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
                    Object currentState3222 = transition.getCurrentState();
                    int $changed7222 = ($changed$iv$iv3222 >> 9) & SdkConfig.SDK_VERSION;
                    InputPhase it6222 = (InputPhase) currentState3222;
                    $composer2.startReplaceableGroup(-1490209928);
                    ComposerKt.sourceInformation($composer2, str2);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[it6222.ordinal()] == 1) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer2.endReplaceableGroup();
                    Object initialValue$iv$iv3222 = Color.m1986boximpl(j2);
                    Object targetState4222 = transition.getTargetState();
                    int $changed8222 = ($changed$iv$iv3222 >> 9) & SdkConfig.SDK_VERSION;
                    InputPhase it7222 = (InputPhase) targetState4222;
                    $composer2.startReplaceableGroup(-1490209928);
                    ComposerKt.sourceInformation($composer2, str2);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[it7222.ordinal()] == 1) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer2.endReplaceableGroup();
                    Object targetValue$iv$iv3222 = Color.m1986boximpl(j3);
                    FiniteAnimationSpec<Color> animationSpec$iv$iv3222 = transitionSpec$iv32.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv3222 >> 3) & SdkConfig.SDK_VERSION));
                    State labelTextStyleColor$delegate222 = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv3222, targetValue$iv$iv3222, animationSpec$iv$iv3222, typeConverter$iv322, "LabelTextStyleColor", $composer2, ($changed$iv$iv3222 & 14) | (($changed$iv$iv3222 << 9) & 57344) | (($changed$iv$iv3222 << 6) & 458752));
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    Function3 transitionSpec$iv4222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                            return invoke(segment, composer, num.intValue());
                        }

                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> animateColor, Composer $composer3, int $changed9) {
                            Intrinsics.checkNotNullParameter(animateColor, "$this$animateColor");
                            $composer3.startReplaceableGroup(-32667848);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-32667848, $changed9, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:328)");
                            }
                            TweenSpec tween$default = AnimationSpecKt.tween$default(TextFieldImplKt.AnimationDuration, 0, null, 6, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            $composer3.endReplaceableGroup();
                            return tween$default;
                        }
                    };
                    int $changed$iv222 = ($dirty4 & 7168) | 384;
                    $composer2.startReplaceableGroup(-1462136984);
                    ComposerKt.sourceInformation($composer2, "C(animateColor)P(2)68@3224L31,69@3291L70,73@3374L70:Transition.kt#xbi5r1");
                    ColorSpace colorSpace$iv2222 = Color.m2000getColorSpaceimpl(contentColor.invoke(transition.getTargetState(), $composer2, Integer.valueOf(($changed$iv222 >> 6) & SdkConfig.SDK_VERSION)).m2006unboximpl());
                    $composer2.startReplaceableGroup(-3686930);
                    ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                    invalid$iv$iv$iv2 = $composer2.changed(colorSpace$iv2222);
                    it$iv$iv$iv2 = $composer2.rememberedValue();
                    if (invalid$iv$iv$iv2) {
                    }
                    value$iv$iv$iv2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv2222);
                    $composer2.updateRememberedValue(value$iv$iv$iv2);
                    $composer2.endReplaceableGroup();
                    TwoWayConverter typeConverter$iv222222 = (TwoWayConverter) value$iv$iv$iv2;
                    int $changed$iv$iv422222 = (($changed$iv222 << 3) & 57344) | ($changed$iv222 & 14) | 64 | (($changed$iv222 << 3) & 896) | (($changed$iv222 << 3) & 7168);
                    $composer2.startReplaceableGroup(1847725064);
                    ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
                    Object initialValue$iv$iv422222 = contentColor.invoke(transition.getCurrentState(), $composer2, Integer.valueOf(($changed$iv$iv422222 >> 9) & SdkConfig.SDK_VERSION));
                    Object targetValue$iv$iv422222 = contentColor.invoke(transition.getTargetState(), $composer2, Integer.valueOf(($changed$iv$iv422222 >> 9) & SdkConfig.SDK_VERSION));
                    FiniteAnimationSpec<Color> animationSpec$iv$iv422222 = transitionSpec$iv4222.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv422222 >> 3) & SdkConfig.SDK_VERSION));
                    State labelContentColor$delegate22222 = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv422222, targetValue$iv$iv422222, animationSpec$iv$iv422222, typeConverter$iv222222, "LabelContentColor", $composer2, ($changed$iv$iv422222 & 14) | (($changed$iv$iv422222 << 9) & 57344) | (($changed$iv$iv422222 << 6) & 458752));
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    content.invoke(Float.valueOf(m1579Transition_DTcfvLk$lambda1(labelProgress$delegate)), Color.m1986boximpl(m1581Transition_DTcfvLk$lambda5(labelTextStyleColor$delegate222)), Color.m1986boximpl(m1582Transition_DTcfvLk$lambda6(labelContentColor$delegate22222)), Float.valueOf(m1580Transition_DTcfvLk$lambda3(placeholderOpacity$delegate2)), $composer2, Integer.valueOf(($dirty4 >> 3) & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    break;
                case 3:
                    f4 = 0.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer2.endReplaceableGroup();
                    Object targetValue$iv$iv222 = Float.valueOf(f4);
                    FiniteAnimationSpec<Float> animationSpec$iv$iv222 = transitionSpec$iv2.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                    State placeholderOpacity$delegate22 = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv2, targetValue$iv$iv222, animationSpec$iv$iv222, typeConverter$iv$iv2, "PlaceholderOpacity", $composer2, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    Function3 transitionSpec$iv322 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                            return invoke(segment, composer, num.intValue());
                        }

                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> animateColor, Composer $composer3, int $changed622) {
                            Intrinsics.checkNotNullParameter(animateColor, "$this$animateColor");
                            $composer3.startReplaceableGroup(-130058045);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-130058045, $changed622, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:318)");
                            }
                            TweenSpec tween$default = AnimationSpecKt.tween$default(TextFieldImplKt.AnimationDuration, 0, null, 6, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            $composer3.endReplaceableGroup();
                            return tween$default;
                        }
                    };
                    $composer2.startReplaceableGroup(-1462136984);
                    ComposerKt.sourceInformation($composer2, "C(animateColor)P(2)68@3224L31,69@3291L70,73@3374L70:Transition.kt#xbi5r1");
                    Object targetState322 = transition.getTargetState();
                    int $changed622 = (384 >> 6) & SdkConfig.SDK_VERSION;
                    InputPhase it522 = (InputPhase) targetState322;
                    $composer2.startReplaceableGroup(-1490209928);
                    ComposerKt.sourceInformation($composer2, str2);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[it522.ordinal()] == 1) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer2.endReplaceableGroup();
                    ColorSpace colorSpace$iv32 = Color.m2000getColorSpaceimpl(j);
                    $composer2.startReplaceableGroup(-3686930);
                    ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                    invalid$iv$iv$iv = $composer2.changed(colorSpace$iv32);
                    it$iv$iv$iv = $composer2.rememberedValue();
                    if (invalid$iv$iv$iv) {
                    }
                    value$iv$iv$iv = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv32);
                    $composer2.updateRememberedValue(value$iv$iv$iv);
                    $composer2.endReplaceableGroup();
                    TwoWayConverter typeConverter$iv3222 = (TwoWayConverter) value$iv$iv$iv;
                    int $changed$iv$iv32222 = (384 & 14) | 64 | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
                    $composer2.startReplaceableGroup(1847725064);
                    ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
                    Object currentState32222 = transition.getCurrentState();
                    int $changed72222 = ($changed$iv$iv32222 >> 9) & SdkConfig.SDK_VERSION;
                    InputPhase it62222 = (InputPhase) currentState32222;
                    $composer2.startReplaceableGroup(-1490209928);
                    ComposerKt.sourceInformation($composer2, str2);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[it62222.ordinal()] == 1) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer2.endReplaceableGroup();
                    Object initialValue$iv$iv32222 = Color.m1986boximpl(j2);
                    Object targetState42222 = transition.getTargetState();
                    int $changed82222 = ($changed$iv$iv32222 >> 9) & SdkConfig.SDK_VERSION;
                    InputPhase it72222 = (InputPhase) targetState42222;
                    $composer2.startReplaceableGroup(-1490209928);
                    ComposerKt.sourceInformation($composer2, str2);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[it72222.ordinal()] == 1) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer2.endReplaceableGroup();
                    Object targetValue$iv$iv32222 = Color.m1986boximpl(j3);
                    FiniteAnimationSpec<Color> animationSpec$iv$iv32222 = transitionSpec$iv322.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv32222 >> 3) & SdkConfig.SDK_VERSION));
                    State labelTextStyleColor$delegate2222 = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv32222, targetValue$iv$iv32222, animationSpec$iv$iv32222, typeConverter$iv3222, "LabelTextStyleColor", $composer2, ($changed$iv$iv32222 & 14) | (($changed$iv$iv32222 << 9) & 57344) | (($changed$iv$iv32222 << 6) & 458752));
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    Function3 transitionSpec$iv42222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                            return invoke(segment, composer, num.intValue());
                        }

                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> animateColor, Composer $composer3, int $changed9) {
                            Intrinsics.checkNotNullParameter(animateColor, "$this$animateColor");
                            $composer3.startReplaceableGroup(-32667848);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-32667848, $changed9, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:328)");
                            }
                            TweenSpec tween$default = AnimationSpecKt.tween$default(TextFieldImplKt.AnimationDuration, 0, null, 6, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            $composer3.endReplaceableGroup();
                            return tween$default;
                        }
                    };
                    int $changed$iv2222 = ($dirty4 & 7168) | 384;
                    $composer2.startReplaceableGroup(-1462136984);
                    ComposerKt.sourceInformation($composer2, "C(animateColor)P(2)68@3224L31,69@3291L70,73@3374L70:Transition.kt#xbi5r1");
                    ColorSpace colorSpace$iv22222 = Color.m2000getColorSpaceimpl(contentColor.invoke(transition.getTargetState(), $composer2, Integer.valueOf(($changed$iv2222 >> 6) & SdkConfig.SDK_VERSION)).m2006unboximpl());
                    $composer2.startReplaceableGroup(-3686930);
                    ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                    invalid$iv$iv$iv2 = $composer2.changed(colorSpace$iv22222);
                    it$iv$iv$iv2 = $composer2.rememberedValue();
                    if (invalid$iv$iv$iv2) {
                    }
                    value$iv$iv$iv2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv22222);
                    $composer2.updateRememberedValue(value$iv$iv$iv2);
                    $composer2.endReplaceableGroup();
                    TwoWayConverter typeConverter$iv2222222 = (TwoWayConverter) value$iv$iv$iv2;
                    int $changed$iv$iv4222222 = (($changed$iv2222 << 3) & 57344) | ($changed$iv2222 & 14) | 64 | (($changed$iv2222 << 3) & 896) | (($changed$iv2222 << 3) & 7168);
                    $composer2.startReplaceableGroup(1847725064);
                    ComposerKt.sourceInformation($composer2, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
                    Object initialValue$iv$iv4222222 = contentColor.invoke(transition.getCurrentState(), $composer2, Integer.valueOf(($changed$iv$iv4222222 >> 9) & SdkConfig.SDK_VERSION));
                    Object targetValue$iv$iv4222222 = contentColor.invoke(transition.getTargetState(), $composer2, Integer.valueOf(($changed$iv$iv4222222 >> 9) & SdkConfig.SDK_VERSION));
                    FiniteAnimationSpec<Color> animationSpec$iv$iv4222222 = transitionSpec$iv42222.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv4222222 >> 3) & SdkConfig.SDK_VERSION));
                    State labelContentColor$delegate222222 = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv4222222, targetValue$iv$iv4222222, animationSpec$iv$iv4222222, typeConverter$iv2222222, "LabelContentColor", $composer2, ($changed$iv$iv4222222 & 14) | (($changed$iv$iv4222222 << 9) & 57344) | (($changed$iv$iv4222222 << 6) & 458752));
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    content.invoke(Float.valueOf(m1579Transition_DTcfvLk$lambda1(labelProgress$delegate)), Color.m1986boximpl(m1581Transition_DTcfvLk$lambda5(labelTextStyleColor$delegate2222)), Color.m1986boximpl(m1582Transition_DTcfvLk$lambda6(labelContentColor$delegate222222)), Float.valueOf(m1580Transition_DTcfvLk$lambda3(placeholderOpacity$delegate22)), $composer2, Integer.valueOf(($dirty4 >> 3) & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$1
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

            public final void invoke(Composer composer, int i) {
                TextFieldTransitionScope.this.m1583TransitionDTcfvLk(inputState, focusedTextStyleColor, unfocusedTextStyleColor, contentColor, showLabel, content, composer, $changed | 1);
            }
        });
    }

    /* renamed from: Transition_DTcfvLk$lambda-1, reason: not valid java name */
    private static final float m1579Transition_DTcfvLk$lambda1(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* renamed from: Transition_DTcfvLk$lambda-3, reason: not valid java name */
    private static final float m1580Transition_DTcfvLk$lambda3(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* renamed from: Transition_DTcfvLk$lambda-5, reason: not valid java name */
    private static final long m1581Transition_DTcfvLk$lambda5(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m2006unboximpl();
    }

    /* renamed from: Transition_DTcfvLk$lambda-6, reason: not valid java name */
    private static final long m1582Transition_DTcfvLk$lambda6(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m2006unboximpl();
    }
}
