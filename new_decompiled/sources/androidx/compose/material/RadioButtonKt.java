package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.graphics.drawscope.Fill;
import androidx.compose.p000ui.graphics.drawscope.Stroke;
import androidx.compose.p000ui.semantics.Role;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RadioButton.kt */
@Metadata(m286d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, m287d2 = {"RadioAnimationDuration", "", "RadioButtonDotSize", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonPadding", "RadioButtonRippleRadius", "RadioButtonSize", "RadioRadius", "RadioStrokeWidth", "RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/RadioButtonColors;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/RadioButtonColors;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class RadioButtonKt {
    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize;
    private static final float RadioRadius;
    private static final float RadioStrokeWidth;
    private static final float RadioButtonRippleRadius = C0504Dp.m4382constructorimpl(24);
    private static final float RadioButtonPadding = C0504Dp.m4382constructorimpl(2);
    private static final float RadioButtonSize = C0504Dp.m4382constructorimpl(20);

    /* JADX WARN: Removed duplicated region for block: B:62:0x027f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RadioButton(final boolean selected, final Function0<Unit> function0, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, RadioButtonColors colors, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        MutableInteractionSource mutableInteractionSource;
        RadioButtonColors colors2;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        int $dirty;
        Modifier modifier3;
        boolean enabled2;
        Object value$iv$iv;
        float arg0$iv;
        State radioColor;
        State dotRadius;
        boolean z2;
        int i2;
        int $dirty2;
        Modifier.Companion selectableModifier;
        Object value$iv$iv2;
        int i3;
        Composer $composer2 = $composer.startRestartGroup(1314435585);
        ComposerKt.sourceInformation($composer2, "C(RadioButton)P(5,4,3,1,2)78@3687L39,79@3780L8,81@3813L164,85@4006L29,109@4847L385,102@4551L681:RadioButton.kt#jmzs0o");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer2.changed(selected) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty3 |= $composer2.changed(function0) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty3 |= 3072;
            z = enabled;
        } else if (($changed & 7168) == 0) {
            z = enabled;
            $dirty3 |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty3 |= 24576;
            mutableInteractionSource = interactionSource;
        } else if ((57344 & $changed) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty3 |= $composer2.changed(mutableInteractionSource) ? 16384 : 8192;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                if ($composer2.changed(colors2)) {
                    i3 = 131072;
                    $dirty3 |= i3;
                }
            } else {
                colors2 = colors;
            }
            i3 = 65536;
            $dirty3 |= i3;
        } else {
            colors2 = colors;
        }
        if ((374491 & $dirty3) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            enabled2 = z;
            interactionSource3 = mutableInteractionSource;
            modifier3 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled3 = i5 != 0 ? true : z;
                if (i6 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer2.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    interactionSource2 = mutableInteractionSource;
                }
                if ((i & 32) != 0) {
                    interactionSource3 = interactionSource2;
                    $dirty = $dirty3 & (-458753);
                    modifier3 = modifier4;
                    enabled2 = enabled3;
                    colors2 = RadioButtonDefaults.INSTANCE.m1483colorsRGew2ao(0L, 0L, 0L, $composer2, 3072, 7);
                } else {
                    colors2 = colors;
                    interactionSource3 = interactionSource2;
                    $dirty = $dirty3;
                    modifier3 = modifier4;
                    enabled2 = enabled3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                $dirty = $dirty3;
                enabled2 = z;
                interactionSource3 = mutableInteractionSource;
                modifier3 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1314435585, $dirty, -1, "androidx.compose.material.RadioButton (RadioButton.kt:73)");
            }
            if (selected) {
                float arg0$iv2 = RadioButtonDotSize;
                arg0$iv = C0504Dp.m4382constructorimpl(arg0$iv2 / 2);
            } else {
                arg0$iv = C0504Dp.m4382constructorimpl(0);
            }
            State dotRadius2 = AnimateAsStateKt.m420animateDpAsStateKz89ssw(arg0$iv, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, $composer2, 48, 4);
            State radioColor2 = colors2.radioColor(enabled2, selected, $composer2, (($dirty >> 9) & 14) | (($dirty << 3) & SdkConfig.SDK_VERSION) | (($dirty >> 9) & 896));
            $composer2.startReplaceableGroup(1941632354);
            ComposerKt.sourceInformation($composer2, "94@4361L123");
            if (function0 != null) {
                radioColor = radioColor2;
                dotRadius = dotRadius2;
                z2 = false;
                i2 = 2;
                $dirty2 = $dirty;
                selectableModifier = SelectableKt.m980selectableO2vRcR0(Modifier.INSTANCE, selected, interactionSource3, RippleKt.m1618rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, $composer2, 54, 4), enabled2, Role.m3825boximpl(Role.INSTANCE.m3835getRadioButtono7Vup1c()), function0);
            } else {
                radioColor = radioColor2;
                dotRadius = dotRadius2;
                z2 = false;
                i2 = 2;
                $dirty2 = $dirty;
                selectableModifier = Modifier.INSTANCE;
            }
            $composer2.endReplaceableGroup();
            Modifier.Companion companion = Modifier.INSTANCE;
            if (function0 != null) {
                companion = TouchTargetKt.minimumTouchTargetSize(companion);
            }
            Modifier m792requiredSize3ABfNKs = SizeKt.m792requiredSize3ABfNKs(PaddingKt.m759padding3ABfNKs(SizeKt.wrapContentSize$default(modifier3.then(companion).then(selectableModifier), Alignment.INSTANCE.getCenter(), z2, i2, null), RadioButtonPadding), RadioButtonSize);
            $composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
            final State radioColor3 = radioColor;
            final State dotRadius3 = dotRadius;
            boolean invalid$iv$iv = $composer2.changed(radioColor3) | $composer2.changed(dotRadius3);
            Object it$iv$iv2 = $composer2.rememberedValue();
            if (!invalid$iv$iv && it$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = it$iv$iv2;
                $composer2.endReplaceableGroup();
                CanvasKt.Canvas(m792requiredSize3ABfNKs, (Function1) value$iv$iv2, $composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            value$iv$iv2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope Canvas) {
                    float f;
                    float f2;
                    Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                    f = RadioButtonKt.RadioStrokeWidth;
                    float strokeWidth = Canvas.mo648toPx0680j_4(f);
                    long m2006unboximpl = radioColor3.getValue().m2006unboximpl();
                    f2 = RadioButtonKt.RadioRadius;
                    float f3 = 2;
                    DrawScope.m2472drawCircleVaOC9Bg$default(Canvas, m2006unboximpl, Canvas.mo648toPx0680j_4(f2) - (strokeWidth / f3), 0L, 0.0f, new Stroke(strokeWidth, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                    if (C0504Dp.m4381compareTo0680j_4(dotRadius3.getValue().m4396unboximpl(), C0504Dp.m4382constructorimpl(0)) > 0) {
                        DrawScope.m2472drawCircleVaOC9Bg$default(Canvas, radioColor3.getValue().m2006unboximpl(), Canvas.mo648toPx0680j_4(dotRadius3.getValue().m4396unboximpl()) - (strokeWidth / f3), 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                    }
                }
            };
            $composer2.updateRememberedValue(value$iv$iv2);
            $composer2.endReplaceableGroup();
            CanvasKt.Canvas(m792requiredSize3ABfNKs, (Function1) value$iv$iv2, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final boolean z3 = enabled2;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
        final RadioButtonColors radioButtonColors = colors2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i7) {
                RadioButtonKt.RadioButton(selected, function0, modifier5, z3, mutableInteractionSource2, radioButtonColors, composer, $changed | 1, i);
            }
        });
    }

    static {
        float arg0$iv = RadioButtonSize;
        RadioRadius = C0504Dp.m4382constructorimpl(arg0$iv / 2);
        RadioButtonDotSize = C0504Dp.m4382constructorimpl(12);
        RadioStrokeWidth = C0504Dp.m4382constructorimpl(2);
    }
}
