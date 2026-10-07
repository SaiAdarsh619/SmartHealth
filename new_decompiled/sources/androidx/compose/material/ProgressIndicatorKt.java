package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.StrokeCap;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.graphics.drawscope.Stroke;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.core.app.NotificationCompat;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProgressIndicator.kt */
@Metadata(m286d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a3\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0005H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a;\u0010\u001e\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0005H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a3\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010+\u001a\u00020#H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a;\u0010*\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010+\u001a\u00020#H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a9\u00100\u001a\u00020\u001f*\u0002012\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u00104\u001a\u000205H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001a9\u00108\u001a\u00020\u001f*\u0002012\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u00104\u001a\u000205H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u00107\u001aA\u0010:\u001a\u00020\u001f*\u0002012\u0006\u00102\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u00104\u001a\u000205H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a9\u0010=\u001a\u00020\u001f*\u0002012\u0006\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a)\u0010B\u001a\u00020\u001f*\u0002012\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010D\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0012\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0013\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006E"}, m287d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "LinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "StartAngleOffset", "CircularProgressIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", NotificationCompat.CATEGORY_PROGRESS, "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "backgroundColor", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJF)V", "drawLinearIndicatorBackground", "drawLinearIndicatorBackground-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JF)V", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    private static final float StartAngleOffset = -90.0f;
    private static final float LinearIndicatorHeight = ProgressIndicatorDefaults.INSTANCE.m1453getStrokeWidthD9Ej5fM();
    private static final float LinearIndicatorWidth = C0504Dp.m4382constructorimpl(240);
    private static final float CircularIndicatorDiameter = C0504Dp.m4382constructorimpl(40);
    private static final CubicBezierEasing FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);
    private static final CubicBezierEasing FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
    private static final CubicBezierEasing SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);
    private static final CubicBezierEasing SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);
    private static final CubicBezierEasing CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);

    /* JADX WARN: Removed duplicated region for block: B:55:0x019c  */
    /* renamed from: LinearProgressIndicator-eaDK9VM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1461LinearProgressIndicatoreaDK9VM(final float progress, Modifier modifier, long color, long backgroundColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long backgroundColor2;
        Modifier.Companion modifier3;
        long color2;
        long backgroundColor3;
        Modifier modifier4;
        Object value$iv$iv;
        long color3;
        long backgroundColor4;
        int i2;
        int i3;
        Composer $composer2 = $composer.startRestartGroup(-850309746);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(3,2,1:c#ui.graphics.Color,0:c#ui.graphics.Color)74@3420L6,81@3655L175,77@3520L310:ProgressIndicator.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(progress) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i3 = 256;
                    $dirty |= i3;
                }
            } else {
                j = color;
            }
            i3 = 128;
            $dirty |= i3;
        } else {
            j = color;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                backgroundColor2 = backgroundColor;
                if ($composer2.changed(backgroundColor2)) {
                    i2 = 2048;
                    $dirty |= i2;
                }
            } else {
                backgroundColor2 = backgroundColor;
            }
            i2 = 1024;
            $dirty |= i2;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            color3 = j;
            backgroundColor4 = backgroundColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1317getPrimary0d7_KjU();
                    $dirty &= -897;
                } else {
                    color2 = j;
                }
                if ((i & 8) != 0) {
                    backgroundColor3 = Color.m1994copywmQWz5c(r12, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r12) : 0.24f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r12) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r12) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(color2) : 0.0f);
                    $dirty &= -7169;
                    backgroundColor2 = backgroundColor3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                modifier3 = modifier2;
                color2 = j;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-850309746, $dirty, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:70)");
            }
            Modifier m802sizeVpY3zN4 = SizeKt.m802sizeVpY3zN4(ProgressSemanticsKt.progressSemantics$default(modifier3, progress, null, 0, 6, null), LinearIndicatorWidth, LinearIndicatorHeight);
            Object key1$iv = Color.m1986boximpl(backgroundColor2);
            Object key2$iv = Float.valueOf(progress);
            Object key3$iv = Color.m1986boximpl(color2);
            int i5 = (($dirty >> 9) & 14) | (($dirty << 3) & SdkConfig.SDK_VERSION) | ($dirty & 896);
            $composer2.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(key1$iv) | $composer2.changed(key2$iv) | $composer2.changed(key3$iv);
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv) {
                modifier4 = modifier3;
            } else {
                modifier4 = modifier3;
                if (it$iv$iv != Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = it$iv$iv;
                    $composer2.endReplaceableGroup();
                    CanvasKt.Canvas(m802sizeVpY3zN4, (Function1) value$iv$iv, $composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    color3 = color2;
                    backgroundColor4 = backgroundColor2;
                }
            }
            final long j2 = backgroundColor2;
            final long j3 = color2;
            value$iv$iv = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$1$1
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
                    Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                    float strokeWidth = Size.m1826getHeightimpl(Canvas.mo2490getSizeNHjbRc());
                    ProgressIndicatorKt.m1482drawLinearIndicatorBackgroundbw27NRU(Canvas, j2, strokeWidth);
                    ProgressIndicatorKt.m1481drawLinearIndicator42QJj7c(Canvas, 0.0f, progress, j3, strokeWidth);
                }
            };
            $composer2.updateRememberedValue(value$iv$iv);
            $composer2.endReplaceableGroup();
            CanvasKt.Canvas(m802sizeVpY3zN4, (Function1) value$iv$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            color3 = color2;
            backgroundColor4 = backgroundColor2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier4;
        final long j4 = color3;
        final long j5 = backgroundColor4;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i6) {
                ProgressIndicatorKt.m1461LinearProgressIndicatoreaDK9VM(progress, modifier5, j4, j5, composer, $changed | 1, i);
            }
        });
    }

    /* renamed from: LinearProgressIndicator-RIQooxk, reason: not valid java name */
    public static final void m1460LinearProgressIndicatorRIQooxk(Modifier modifier, long color, long backgroundColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long backgroundColor2;
        Modifier.Companion modifier3;
        long color2;
        long backgroundColor3;
        int $dirty;
        Modifier modifier4;
        Modifier modifier5;
        long color3;
        long backgroundColor4;
        int i2;
        int i3;
        Composer $composer2 = $composer.startRestartGroup(-819397058);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(2,1:c#ui.graphics.Color,0:c#ui.graphics.Color)102@4593L6,105@4718L28,109@5000L319,120@5364L319,131@5729L323,142@6098L323,157@6553L557,153@6426L684:ProgressIndicator.kt#jmzs0o");
        int $dirty2 = $changed;
        int i4 = i & 1;
        if (i4 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            if ((i & 2) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i3 = 32;
                    $dirty2 |= i3;
                }
            } else {
                j = color;
            }
            i3 = 16;
            $dirty2 |= i3;
        } else {
            j = color;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                backgroundColor2 = backgroundColor;
                if ($composer2.changed(backgroundColor2)) {
                    i2 = 256;
                    $dirty2 |= i2;
                }
            } else {
                backgroundColor2 = backgroundColor;
            }
            i2 = 128;
            $dirty2 |= i2;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($dirty2 & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier5 = modifier2;
            color3 = j;
            backgroundColor4 = backgroundColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1317getPrimary0d7_KjU();
                    $dirty2 &= -113;
                } else {
                    color2 = j;
                }
                if ((i & 4) != 0) {
                    backgroundColor3 = Color.m1994copywmQWz5c(r10, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r10) : 0.24f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r10) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r10) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(color2) : 0.0f);
                    $dirty2 &= -897;
                    backgroundColor2 = backgroundColor3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                modifier3 = modifier2;
                color2 = j;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-819397058, $changed, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:100)");
            }
            InfiniteTransition infiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition($composer2, 0);
            final State firstLineHead$delegate = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m432infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    CubicBezierEasing cubicBezierEasing;
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1800);
                    KeyframesSpec.KeyframeEntity<Float> m4at = keyframes.m4at(Float.valueOf(0.0f), 0);
                    cubicBezierEasing = ProgressIndicatorKt.FirstLineHeadEasing;
                    keyframes.with(m4at, cubicBezierEasing);
                    keyframes.m4at(Float.valueOf(1.0f), 750);
                }
            }), null, 0L, 6, null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            final State firstLineTail$delegate = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m432infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    CubicBezierEasing cubicBezierEasing;
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1800);
                    KeyframesSpec.KeyframeEntity<Float> m4at = keyframes.m4at(Float.valueOf(0.0f), 333);
                    cubicBezierEasing = ProgressIndicatorKt.FirstLineTailEasing;
                    keyframes.with(m4at, cubicBezierEasing);
                    keyframes.m4at(Float.valueOf(1.0f), 1183);
                }
            }), null, 0L, 6, null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            final State secondLineHead$delegate = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m432infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    CubicBezierEasing cubicBezierEasing;
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1800);
                    KeyframesSpec.KeyframeEntity<Float> m4at = keyframes.m4at(Float.valueOf(0.0f), 1000);
                    cubicBezierEasing = ProgressIndicatorKt.SecondLineHeadEasing;
                    keyframes.with(m4at, cubicBezierEasing);
                    keyframes.m4at(Float.valueOf(1.0f), 1567);
                }
            }), null, 0L, 6, null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            final State secondLineTail$delegate = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m432infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    CubicBezierEasing cubicBezierEasing;
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1800);
                    KeyframesSpec.KeyframeEntity<Float> m4at = keyframes.m4at(Float.valueOf(0.0f), 1267);
                    cubicBezierEasing = ProgressIndicatorKt.SecondLineTailEasing;
                    keyframes.with(m4at, cubicBezierEasing);
                    keyframes.m4at(Float.valueOf(1.0f), 1800);
                }
            }), null, 0L, 6, null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            Modifier m802sizeVpY3zN4 = SizeKt.m802sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(modifier3), LinearIndicatorWidth, LinearIndicatorHeight);
            Object[] keys$iv = {Color.m1986boximpl(backgroundColor2), firstLineHead$delegate, firstLineTail$delegate, Color.m1986boximpl(color2), secondLineHead$delegate, secondLineTail$delegate};
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : keys$iv) {
                invalid$iv |= $composer2.changed(key$iv);
            }
            Object value$iv$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
                final long j2 = backgroundColor2;
                final long j3 = color2;
                $dirty = $dirty2;
                modifier4 = m802sizeVpY3zN4;
                value$iv$iv = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$3$1
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
                        float m1462LinearProgressIndicator_RIQooxk$lambda1;
                        float m1463LinearProgressIndicator_RIQooxk$lambda2;
                        float m1464LinearProgressIndicator_RIQooxk$lambda3;
                        float m1465LinearProgressIndicator_RIQooxk$lambda4;
                        float m1464LinearProgressIndicator_RIQooxk$lambda32;
                        float m1465LinearProgressIndicator_RIQooxk$lambda42;
                        float m1462LinearProgressIndicator_RIQooxk$lambda12;
                        float m1463LinearProgressIndicator_RIQooxk$lambda22;
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        float strokeWidth = Size.m1826getHeightimpl(Canvas.mo2490getSizeNHjbRc());
                        ProgressIndicatorKt.m1482drawLinearIndicatorBackgroundbw27NRU(Canvas, j2, strokeWidth);
                        m1462LinearProgressIndicator_RIQooxk$lambda1 = ProgressIndicatorKt.m1462LinearProgressIndicator_RIQooxk$lambda1(firstLineHead$delegate);
                        m1463LinearProgressIndicator_RIQooxk$lambda2 = ProgressIndicatorKt.m1463LinearProgressIndicator_RIQooxk$lambda2(firstLineTail$delegate);
                        if (m1462LinearProgressIndicator_RIQooxk$lambda1 - m1463LinearProgressIndicator_RIQooxk$lambda2 > 0.0f) {
                            m1462LinearProgressIndicator_RIQooxk$lambda12 = ProgressIndicatorKt.m1462LinearProgressIndicator_RIQooxk$lambda1(firstLineHead$delegate);
                            m1463LinearProgressIndicator_RIQooxk$lambda22 = ProgressIndicatorKt.m1463LinearProgressIndicator_RIQooxk$lambda2(firstLineTail$delegate);
                            ProgressIndicatorKt.m1481drawLinearIndicator42QJj7c(Canvas, m1462LinearProgressIndicator_RIQooxk$lambda12, m1463LinearProgressIndicator_RIQooxk$lambda22, j3, strokeWidth);
                        }
                        m1464LinearProgressIndicator_RIQooxk$lambda3 = ProgressIndicatorKt.m1464LinearProgressIndicator_RIQooxk$lambda3(secondLineHead$delegate);
                        m1465LinearProgressIndicator_RIQooxk$lambda4 = ProgressIndicatorKt.m1465LinearProgressIndicator_RIQooxk$lambda4(secondLineTail$delegate);
                        if (m1464LinearProgressIndicator_RIQooxk$lambda3 - m1465LinearProgressIndicator_RIQooxk$lambda4 > 0.0f) {
                            m1464LinearProgressIndicator_RIQooxk$lambda32 = ProgressIndicatorKt.m1464LinearProgressIndicator_RIQooxk$lambda3(secondLineHead$delegate);
                            m1465LinearProgressIndicator_RIQooxk$lambda42 = ProgressIndicatorKt.m1465LinearProgressIndicator_RIQooxk$lambda4(secondLineTail$delegate);
                            ProgressIndicatorKt.m1481drawLinearIndicator42QJj7c(Canvas, m1464LinearProgressIndicator_RIQooxk$lambda32, m1465LinearProgressIndicator_RIQooxk$lambda42, j3, strokeWidth);
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                $dirty = $dirty2;
                modifier4 = m802sizeVpY3zN4;
            }
            $composer2.endReplaceableGroup();
            CanvasKt.Canvas(modifier4, (Function1) value$iv$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier3;
            color3 = color2;
            backgroundColor4 = backgroundColor2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier5;
        final long j4 = color3;
        final long j5 = backgroundColor4;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i5) {
                ProgressIndicatorKt.m1460LinearProgressIndicatorRIQooxk(Modifier.this, j4, j5, composer, $changed | 1, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: LinearProgressIndicator_RIQooxk$lambda-1, reason: not valid java name */
    public static final float m1462LinearProgressIndicator_RIQooxk$lambda1(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: LinearProgressIndicator_RIQooxk$lambda-2, reason: not valid java name */
    public static final float m1463LinearProgressIndicator_RIQooxk$lambda2(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: LinearProgressIndicator_RIQooxk$lambda-3, reason: not valid java name */
    public static final float m1464LinearProgressIndicator_RIQooxk$lambda3(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: LinearProgressIndicator_RIQooxk$lambda-4, reason: not valid java name */
    public static final float m1465LinearProgressIndicator_RIQooxk$lambda4(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawLinearIndicator-42QJj7c, reason: not valid java name */
    public static final void m1481drawLinearIndicator42QJj7c(DrawScope $this$drawLinearIndicator_u2d42QJj7c, float startFraction, float endFraction, long color, float strokeWidth) {
        float width = Size.m1829getWidthimpl($this$drawLinearIndicator_u2d42QJj7c.mo2490getSizeNHjbRc());
        float height = Size.m1826getHeightimpl($this$drawLinearIndicator_u2d42QJj7c.mo2490getSizeNHjbRc());
        float yOffset = height / 2;
        boolean isLtr = $this$drawLinearIndicator_u2d42QJj7c.getLayoutDirection() == LayoutDirection.Ltr;
        float barStart = (isLtr ? startFraction : 1.0f - endFraction) * width;
        float barEnd = (isLtr ? endFraction : 1.0f - startFraction) * width;
        DrawScope.m2477drawLineNGM6Ib0$default($this$drawLinearIndicator_u2d42QJj7c, color, OffsetKt.Offset(barStart, yOffset), OffsetKt.Offset(barEnd, yOffset), strokeWidth, 0, null, 0.0f, null, 0, 496, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawLinearIndicatorBackground-bw27NRU, reason: not valid java name */
    public static final void m1482drawLinearIndicatorBackgroundbw27NRU(DrawScope $this$drawLinearIndicatorBackground_u2dbw27NRU, long color, float strokeWidth) {
        m1481drawLinearIndicator42QJj7c($this$drawLinearIndicatorBackground_u2dbw27NRU, 0.0f, 1.0f, color, strokeWidth);
    }

    /* renamed from: CircularProgressIndicator-MBs18nI, reason: not valid java name */
    public static final void m1454CircularProgressIndicatorMBs18nI(final float progress, Modifier modifier, long color, float strokeWidth, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        float strokeWidth2;
        long color2;
        int $dirty;
        Modifier modifier3;
        final long color3;
        float strokeWidth3;
        long color4;
        Modifier modifier4;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(-409649739);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.unit.Dp)226@9099L6,*229@9214L7,232@9300L296:ProgressIndicator.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(progress) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i2 = 256;
                    $dirty2 |= i2;
                }
            } else {
                j = color;
            }
            i2 = 128;
            $dirty2 |= i2;
        } else {
            j = color;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            strokeWidth2 = strokeWidth;
        } else if (($changed & 7168) == 0) {
            strokeWidth2 = strokeWidth;
            $dirty2 |= $composer2.changed(strokeWidth2) ? 2048 : 1024;
        } else {
            strokeWidth2 = strokeWidth;
        }
        if (($dirty2 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            color4 = j;
            strokeWidth3 = strokeWidth2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1317getPrimary0d7_KjU();
                    $dirty2 &= -897;
                } else {
                    color2 = j;
                }
                if (i4 != 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier5;
                    color3 = color2;
                    strokeWidth2 = ProgressIndicatorDefaults.INSTANCE.m1453getStrokeWidthD9Ej5fM();
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier5;
                    color3 = color2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                color3 = j;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-409649739, $changed, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:222)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$CircularProgressIndicator_MBs18nI_u24lambda_u2d6 = (Density) consume;
            final Stroke stroke = new Stroke($this$CircularProgressIndicator_MBs18nI_u24lambda_u2d6.mo648toPx0680j_4(strokeWidth2), 0.0f, StrokeCap.INSTANCE.m2300getButtKaPHkGw(), 0, null, 26, null);
            CanvasKt.Canvas(SizeKt.m800size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier3, progress, null, 0, 6, null), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1
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
                    Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                    float sweep = progress * 360.0f;
                    ProgressIndicatorKt.m1479drawDeterminateCircularIndicator42QJj7c(Canvas, 270.0f, sweep, color3, stroke);
                }
            }, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            strokeWidth3 = strokeWidth2;
            color4 = color3;
            modifier4 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier4;
        final long j2 = color4;
        final float f = strokeWidth3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i5) {
                ProgressIndicatorKt.m1454CircularProgressIndicatorMBs18nI(progress, modifier6, j2, f, composer, $changed | 1, i);
            }
        });
    }

    /* renamed from: CircularProgressIndicator-aM-cp0Q, reason: not valid java name */
    public static final void m1455CircularProgressIndicatoraMcp0Q(Modifier modifier, long color, float strokeWidth, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        float strokeWidth2;
        long color2;
        Modifier modifier3;
        long color3;
        float strokeWidth3;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(-392089979);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.unit.Dp)257@10275L6,*260@10390L7,264@10496L28,266@10654L278,278@11047L230,289@11395L345,301@11775L354,312@12134L582:ProgressIndicator.kt#jmzs0o");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            if ((i & 2) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i2 = 32;
                    $dirty |= i2;
                }
            } else {
                j = color;
            }
            i2 = 16;
            $dirty |= i2;
        } else {
            j = color;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            strokeWidth2 = strokeWidth;
        } else if (($changed & 896) == 0) {
            strokeWidth2 = strokeWidth;
            $dirty |= $composer2.changed(strokeWidth2) ? 256 : 128;
        } else {
            strokeWidth2 = strokeWidth;
        }
        if (($dirty & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            color3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1317getPrimary0d7_KjU();
                    $dirty &= -113;
                } else {
                    color2 = j;
                }
                if (i4 != 0) {
                    strokeWidth3 = ProgressIndicatorDefaults.INSTANCE.m1453getStrokeWidthD9Ej5fM();
                    modifier3 = modifier4;
                    color3 = color2;
                } else {
                    modifier3 = modifier4;
                    color3 = color2;
                    strokeWidth3 = strokeWidth2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                modifier3 = modifier2;
                color3 = j;
                strokeWidth3 = strokeWidth2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-392089979, $changed, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:255)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$CircularProgressIndicator_aM_cp0Q_u24lambda_u2d7 = (Density) consume;
            final Stroke stroke = new Stroke($this$CircularProgressIndicator_aM_cp0Q_u24lambda_u2d7.mo648toPx0680j_4(strokeWidth3), 0.0f, StrokeCap.INSTANCE.m2302getSquareKaPHkGw(), 0, null, 26, null);
            InfiniteTransition transition = InfiniteTransitionKt.rememberInfiniteTransition($composer2, 0);
            final State currentRotation$delegate = InfiniteTransitionKt.animateValue(transition, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m432infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), $composer2, InfiniteTransition.$stable | 4528 | (InfiniteRepeatableSpec.$stable << 12));
            final float strokeWidth4 = strokeWidth3;
            final State baseRotation$delegate = InfiniteTransitionKt.animateFloat(transition, 0.0f, BaseRotationAngle, AnimationSpecKt.m432infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            final State endAngle$delegate = InfiniteTransitionKt.animateFloat(transition, 0.0f, JumpRotationAngle, AnimationSpecKt.m432infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$endAngle$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    CubicBezierEasing cubicBezierEasing;
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1332);
                    KeyframesSpec.KeyframeEntity<Float> m4at = keyframes.m4at(Float.valueOf(0.0f), 0);
                    cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                    keyframes.with(m4at, cubicBezierEasing);
                    keyframes.m4at(Float.valueOf(290.0f), 666);
                }
            }), null, 0L, 6, null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            final State startAngle$delegate = InfiniteTransitionKt.animateFloat(transition, 0.0f, JumpRotationAngle, AnimationSpecKt.m432infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$startAngle$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    CubicBezierEasing cubicBezierEasing;
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1332);
                    KeyframesSpec.KeyframeEntity<Float> m4at = keyframes.m4at(Float.valueOf(0.0f), 666);
                    cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                    keyframes.with(m4at, cubicBezierEasing);
                    keyframes.m4at(Float.valueOf(290.0f), keyframes.getDurationMillis());
                }
            }), null, 0L, 6, null), $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            final long j2 = color3;
            CanvasKt.Canvas(SizeKt.m800size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3
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
                    int m1458CircularProgressIndicator_aM_cp0Q$lambda8;
                    float m1456CircularProgressIndicator_aM_cp0Q$lambda10;
                    float m1457CircularProgressIndicator_aM_cp0Q$lambda11;
                    float m1459CircularProgressIndicator_aM_cp0Q$lambda9;
                    float m1457CircularProgressIndicator_aM_cp0Q$lambda112;
                    Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                    m1458CircularProgressIndicator_aM_cp0Q$lambda8 = ProgressIndicatorKt.m1458CircularProgressIndicator_aM_cp0Q$lambda8(currentRotation$delegate);
                    float currentRotationAngleOffset = (m1458CircularProgressIndicator_aM_cp0Q$lambda8 * 216.0f) % 360.0f;
                    m1456CircularProgressIndicator_aM_cp0Q$lambda10 = ProgressIndicatorKt.m1456CircularProgressIndicator_aM_cp0Q$lambda10(endAngle$delegate);
                    m1457CircularProgressIndicator_aM_cp0Q$lambda11 = ProgressIndicatorKt.m1457CircularProgressIndicator_aM_cp0Q$lambda11(startAngle$delegate);
                    float sweep = Math.abs(m1456CircularProgressIndicator_aM_cp0Q$lambda10 - m1457CircularProgressIndicator_aM_cp0Q$lambda11);
                    m1459CircularProgressIndicator_aM_cp0Q$lambda9 = ProgressIndicatorKt.m1459CircularProgressIndicator_aM_cp0Q$lambda9(baseRotation$delegate);
                    float offset = (-90.0f) + currentRotationAngleOffset + m1459CircularProgressIndicator_aM_cp0Q$lambda9;
                    m1457CircularProgressIndicator_aM_cp0Q$lambda112 = ProgressIndicatorKt.m1457CircularProgressIndicator_aM_cp0Q$lambda11(startAngle$delegate);
                    ProgressIndicatorKt.m1480drawIndeterminateCircularIndicatorhrjfTZI(Canvas, m1457CircularProgressIndicator_aM_cp0Q$lambda112 + offset, strokeWidth4, sweep, j2, stroke);
                }
            }, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            strokeWidth2 = strokeWidth4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final long j3 = color3;
        final float f = strokeWidth2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i5) {
                ProgressIndicatorKt.m1455CircularProgressIndicatoraMcp0Q(Modifier.this, j3, f, composer, $changed | 1, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CircularProgressIndicator_aM_cp0Q$lambda-8, reason: not valid java name */
    public static final int m1458CircularProgressIndicator_aM_cp0Q$lambda8(State<Integer> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CircularProgressIndicator_aM_cp0Q$lambda-9, reason: not valid java name */
    public static final float m1459CircularProgressIndicator_aM_cp0Q$lambda9(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CircularProgressIndicator_aM_cp0Q$lambda-10, reason: not valid java name */
    public static final float m1456CircularProgressIndicator_aM_cp0Q$lambda10(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CircularProgressIndicator_aM_cp0Q$lambda-11, reason: not valid java name */
    public static final float m1457CircularProgressIndicator_aM_cp0Q$lambda11(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m1478drawCircularIndicator42QJj7c(DrawScope $this$drawCircularIndicator_u2d42QJj7c, float startAngle, float sweep, long color, Stroke stroke) {
        float f = 2;
        float diameterOffset = stroke.getWidth() / f;
        float arcDimen = Size.m1829getWidthimpl($this$drawCircularIndicator_u2d42QJj7c.mo2490getSizeNHjbRc()) - (f * diameterOffset);
        DrawScope.m2470drawArcyD3GUKo$default($this$drawCircularIndicator_u2d42QJj7c, color, startAngle, sweep, false, OffsetKt.Offset(diameterOffset, diameterOffset), androidx.compose.p000ui.geometry.SizeKt.Size(arcDimen, arcDimen), 0.0f, stroke, null, 0, 832, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawDeterminateCircularIndicator-42QJj7c, reason: not valid java name */
    public static final void m1479drawDeterminateCircularIndicator42QJj7c(DrawScope $this$drawDeterminateCircularIndicator_u2d42QJj7c, float startAngle, float sweep, long color, Stroke stroke) {
        m1478drawCircularIndicator42QJj7c($this$drawDeterminateCircularIndicator_u2d42QJj7c, startAngle, sweep, color, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawIndeterminateCircularIndicator-hrjfTZI, reason: not valid java name */
    public static final void m1480drawIndeterminateCircularIndicatorhrjfTZI(DrawScope $this$drawIndeterminateCircularIndicator_u2dhrjfTZI, float startAngle, float strokeWidth, float sweep, long color, Stroke stroke) {
        float arg0$iv = CircularIndicatorDiameter;
        float other$iv = strokeWidth / C0504Dp.m4382constructorimpl(arg0$iv / 2);
        float squareStrokeCapOffset = (other$iv * 57.29578f) / 2.0f;
        float adjustedStartAngle = startAngle + squareStrokeCapOffset;
        float adjustedSweep = Math.max(sweep, 0.1f);
        m1478drawCircularIndicator42QJj7c($this$drawIndeterminateCircularIndicator_u2dhrjfTZI, adjustedStartAngle, adjustedSweep, color, stroke);
    }
}
