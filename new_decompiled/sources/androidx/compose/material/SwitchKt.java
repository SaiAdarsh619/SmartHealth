package androidx.compose.material;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.ShadowKt;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.p000ui.graphics.RectangleShapeKt;
import androidx.compose.p000ui.graphics.StrokeCap;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.semantics.Role;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.IntOffsetKt;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Switch.kt */
@Metadata(m286d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aS\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010 \u001a?\u0010!\u001a\u00020\u0014*\u00020\"2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020$2\u0006\u0010\u001c\u001a\u00020%H\u0003¢\u0006\u0002\u0010&\u001a1\u0010'\u001a\u00020\u0014*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0007\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\t\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\n\u0010\u000b\"\u0013\u0010\f\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\r\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u000e\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\u000f\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0010\u0010\u000b\"\u0019\u0010\u0011\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\u000b\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006/"}, m287d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DefaultSwitchPadding", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchHeight", "SwitchWidth", "ThumbDefaultElevation", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPathLength", "ThumbPressedElevation", "ThumbRippleRadius", "TrackStrokeWidth", "getTrackStrokeWidth", "TrackWidth", "getTrackWidth", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/SwitchColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SwitchColors;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material/SwitchColors;Landroidx/compose/runtime/State;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)V", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "trackColor", "Landroidx/compose/ui/graphics/Color;", "trackWidth", "strokeWidth", "drawTrack-RPmYEkk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFF)V", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec;
    private static final float ThumbDefaultElevation;
    private static final float ThumbPathLength;
    private static final float ThumbPressedElevation;
    private static final float TrackWidth = C0504Dp.m4382constructorimpl(34);
    private static final float TrackStrokeWidth = C0504Dp.m4382constructorimpl(14);
    private static final float ThumbDiameter = C0504Dp.m4382constructorimpl(20);
    private static final float ThumbRippleRadius = C0504Dp.m4382constructorimpl(24);
    private static final float DefaultSwitchPadding = C0504Dp.m4382constructorimpl(2);
    private static final float SwitchWidth = TrackWidth;
    private static final float SwitchHeight = ThumbDiameter;

    public static final void Switch(final boolean checked, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, SwitchColors colors, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        MutableInteractionSource interactionSource2;
        SwitchColors colors2;
        MutableInteractionSource interactionSource3;
        SwitchColors colors3;
        MutableInteractionSource interactionSource4;
        int $dirty;
        Modifier modifier3;
        boolean enabled2;
        Object value$iv$iv;
        Modifier m1523swipeablepPrIpRY;
        Modifier modifier4;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(25866825);
        ComposerKt.sourceInformation($composer2, "C(Switch)P(!1,5,4,2,3)94@4383L39,95@4466L8,*98@4538L7,99@4599L72,100@4709L7,115@5150L1024:Switch.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(checked) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer2.changed(function1) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            z = enabled;
        } else if (($changed & 7168) == 0) {
            z = enabled;
            $dirty2 |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            interactionSource2 = interactionSource;
        } else if ((57344 & $changed) == 0) {
            interactionSource2 = interactionSource;
            $dirty2 |= $composer2.changed(interactionSource2) ? 16384 : 8192;
        } else {
            interactionSource2 = interactionSource;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                if ($composer2.changed(colors2)) {
                    i2 = 131072;
                    $dirty2 |= i2;
                }
            } else {
                colors2 = colors;
            }
            i2 = 65536;
            $dirty2 |= i2;
        } else {
            colors2 = colors;
        }
        if ((374491 & $dirty2) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            enabled2 = z;
            modifier4 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled3 = i4 != 0 ? true : z;
                if (i5 != 0) {
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
                    interactionSource3 = (MutableInteractionSource) value$iv$iv;
                } else {
                    interactionSource3 = interactionSource2;
                }
                if ((i & 32) != 0) {
                    interactionSource4 = interactionSource3;
                    $dirty = $dirty2 & (-458753);
                    modifier3 = modifier5;
                    enabled2 = enabled3;
                    colors3 = SwitchDefaults.INSTANCE.m1526colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, $composer2, 0, 6, 1023);
                } else {
                    colors3 = colors;
                    interactionSource4 = interactionSource3;
                    $dirty = $dirty2;
                    modifier3 = modifier5;
                    enabled2 = enabled3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                enabled2 = z;
                interactionSource4 = interactionSource2;
                colors3 = colors2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(25866825, $dirty, -1, "androidx.compose.material.Switch (Switch.kt:89)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$Switch_u24lambda_u2d1 = (Density) consume;
            float maxBound = $this$Switch_u24lambda_u2d1.mo648toPx0680j_4(ThumbPathLength);
            SwipeableState swipeableState = SwipeableKt.rememberSwipeableStateFor(Boolean.valueOf(checked), function1 == null ? new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$swipeableState$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean it) {
                }
            } : function1, AnimationSpec, $composer2, ($dirty & 14) | 384, 0);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            boolean isRtl = consume2 == LayoutDirection.Rtl;
            Modifier.Companion toggleableModifier = function1 != null ? ToggleableKt.m984toggleableO2vRcR0(Modifier.INSTANCE, checked, interactionSource4, null, enabled2, Role.m3825boximpl(Role.INSTANCE.m3836getSwitcho7Vup1c()), function1) : Modifier.INSTANCE;
            Modifier.Companion companion = Modifier.INSTANCE;
            if (function1 != null) {
                companion = TouchTargetKt.minimumTouchTargetSize(companion);
            }
            m1523swipeablepPrIpRY = SwipeableKt.m1523swipeablepPrIpRY(modifier3.then(companion).then(toggleableModifier), swipeableState, r22, Orientation.Horizontal, (r26 & 8) != 0 ? true : enabled2 && function1 != null, (r26 & 16) != 0 ? false : isRtl, (r26 & 32) != 0 ? null : interactionSource4, (r26 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function2
                public final FixedThreshold invoke(T t, T t2) {
                    return new FixedThreshold(C0504Dp.m4382constructorimpl(56), null);
                }
            } : new Function2<Boolean, Boolean, ThresholdConfig>() { // from class: androidx.compose.material.SwitchKt$Switch$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ ThresholdConfig invoke(Boolean bool, Boolean bool2) {
                    return invoke(bool.booleanValue(), bool2.booleanValue());
                }

                public final ThresholdConfig invoke(boolean z2, boolean z3) {
                    return new FractionalThreshold(0.5f);
                }
            }, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, MapsKt.mapOf(TuplesKt.m294to(Float.valueOf(0.0f), false), TuplesKt.m294to(Float.valueOf(maxBound), true)).keySet(), 0.0f, 0.0f, 6, null) : null, (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1522getVelocityThresholdD9Ej5fM() : 0.0f);
            Modifier modifier$iv = SizeKt.m794requiredSizeVpY3zN4(PaddingKt.m759padding3ABfNKs(SizeKt.wrapContentSize$default(m1523swipeablepPrIpRY, Alignment.INSTANCE.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
            int $changed$iv$iv = (0 << 3) & SdkConfig.SDK_VERSION;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume3;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer2.consume(localLayoutDirection2);
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
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                $composer2.useNode();
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
            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
            $composer2.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation($composer2, "C72@3384L9:Box.kt#2w3rfo");
            if (($changed$iv & 11) == 2 && $composer2.getSkipping()) {
                $composer2.skipToGroupEnd();
            } else {
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int $changed2 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                BoxScope $this$Switch_u24lambda_u2d2 = boxScope;
                $composer2.startReplaceableGroup(1571176015);
                ComposerKt.sourceInformation($composer2, "C135@5958L210:Switch.kt#jmzs0o");
                int $dirty3 = $changed2;
                if (($changed2 & 14) == 0) {
                    $dirty3 |= $composer2.changed($this$Switch_u24lambda_u2d2) ? 4 : 2;
                }
                int $changed$iv2 = $dirty3 & 91;
                if ($changed$iv2 == 18 && $composer2.getSkipping()) {
                    $composer2.skipToGroupEnd();
                } else {
                    SwitchImpl($this$Switch_u24lambda_u2d2, checked, enabled2, colors3, swipeableState.getOffset(), interactionSource4, $composer2, (($dirty >> 3) & 896) | ($dirty3 & 14) | (($dirty << 3) & SdkConfig.SDK_VERSION) | (($dirty >> 6) & 7168) | (($dirty << 3) & 458752));
                }
                $composer2.endReplaceableGroup();
            }
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            interactionSource2 = interactionSource4;
            colors2 = colors3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier4;
        final boolean z2 = enabled2;
        final MutableInteractionSource mutableInteractionSource = interactionSource2;
        final SwitchColors switchColors = colors2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$4
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

            public final void invoke(Composer composer, int i6) {
                SwitchKt.Switch(checked, function1, modifier6, z2, mutableInteractionSource, switchColors, composer, $changed | 1, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SwitchImpl(final BoxScope $this$SwitchImpl, final boolean checked, final boolean enabled, final SwitchColors colors, final State<Float> state, final InteractionSource interactionSource, Composer $composer, final int $changed) {
        Object value$iv$iv;
        SwitchKt$SwitchImpl$1$1 value$iv$iv2;
        float f;
        Object value$iv$iv3;
        State thumbColor$delegate;
        String str;
        int i;
        long resolvedThumbColor;
        boolean invalid$iv$iv;
        Modifier m1677shadows4CzXII;
        Composer $composer2 = $composer.startRestartGroup(-1834839253);
        ComposerKt.sourceInformation($composer2, "C(SwitchImpl)P(!1,2!1,4)181@7257L46,183@7343L614,183@7309L648,202@8160L28,203@8248L81,203@8193L136,206@8359L28,207@8437L7,*208@8496L7,210@8585L6,218@8838L47,221@8995L59,215@8751L479:Switch.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed($this$SwitchImpl) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(checked) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(enabled) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(colors) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changed(state) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((374491 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1834839253, $dirty2, -1, "androidx.compose.material.SwitchImpl (Switch.kt:174)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotStateKt.mutableStateListOf();
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SnapshotStateList interactions = (SnapshotStateList) value$iv$iv;
            int i2 = (($dirty2 >> 15) & 14) | 560;
            $composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv2 = $composer2.changed(interactionSource) | $composer2.changed(interactions);
            Object it$iv$iv2 = $composer2.rememberedValue();
            if (invalid$iv$iv2 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = new SwitchKt$SwitchImpl$1$1(interactionSource, interactions, null);
                $composer2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv2, $composer2, (($dirty2 >> 15) & 14) | 64);
            boolean hasInteraction = !interactions.isEmpty();
            if (hasInteraction) {
                f = ThumbPressedElevation;
            } else {
                f = ThumbDefaultElevation;
            }
            float elevation = f;
            final State trackColor$delegate = colors.trackColor(enabled, checked, $composer2, (($dirty2 >> 6) & 14) | ($dirty2 & SdkConfig.SDK_VERSION) | (($dirty2 >> 3) & 896));
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default($this$SwitchImpl.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), 0.0f, 1, null);
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv3 = $composer2.changed(trackColor$delegate);
            Object it$iv$iv3 = $composer2.rememberedValue();
            if (!invalid$iv$iv3 && it$iv$iv3 != Composer.INSTANCE.getEmpty()) {
                value$iv$iv3 = it$iv$iv3;
                $composer2.endReplaceableGroup();
                CanvasKt.Canvas(fillMaxSize$default, (Function1) value$iv$iv3, $composer2, 0);
                thumbColor$delegate = colors.thumbColor(enabled, checked, $composer2, (($dirty2 >> 6) & 14) | ($dirty2 & SdkConfig.SDK_VERSION) | (($dirty2 >> 3) & 896));
                ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(localElevationOverlay);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ElevationOverlay elevationOverlay = (ElevationOverlay) consume;
                ProvidableCompositionLocal<C0504Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume2 = $composer2.consume(localAbsoluteElevation);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                float arg0$iv = ((C0504Dp) consume2).m4396unboximpl();
                float arg0$iv2 = C0504Dp.m4382constructorimpl(arg0$iv + elevation);
                $composer2.startReplaceableGroup(-539245361);
                ComposerKt.sourceInformation($composer2, "211@8660L36");
                if (!Color.m1997equalsimpl0(m1528SwitchImpl$lambda7(thumbColor$delegate), MaterialTheme.INSTANCE.getColors($composer2, 6).m1321getSurface0d7_KjU()) && elevationOverlay != null) {
                    str = "C(remember)P(1):Composables.kt#9igjgp";
                    i = 1157296644;
                    resolvedThumbColor = elevationOverlay.mo1351apply7g2Lkgo(m1528SwitchImpl$lambda7(thumbColor$delegate), arg0$iv2, $composer2, 0);
                } else {
                    str = "C(remember)P(1):Composables.kt#9igjgp";
                    i = 1157296644;
                    resolvedThumbColor = m1528SwitchImpl$lambda7(thumbColor$delegate);
                }
                $composer2.endReplaceableGroup();
                Modifier align = $this$SwitchImpl.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart());
                int i3 = ($dirty2 >> 12) & 14;
                $composer2.startReplaceableGroup(i);
                ComposerKt.sourceInformation($composer2, str);
                invalid$iv$iv = $composer2.changed(state);
                Object value$iv$iv4 = $composer2.rememberedValue();
                if (!invalid$iv$iv && value$iv$iv4 != Composer.INSTANCE.getEmpty()) {
                    $composer2.endReplaceableGroup();
                    m1677shadows4CzXII = ShadowKt.m1677shadows4CzXII(SizeKt.m792requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(align, (Function1) value$iv$iv4), interactionSource, RippleKt.m1618rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0L, $composer2, 54, 4)), ThumbDiameter), elevation, (r15 & 2) != 0 ? RectangleShapeKt.getRectangleShape() : RoundedCornerShapeKt.getCircleShape(), (r15 & 4) != 0 ? C0504Dp.m4381compareTo0680j_4(r8, C0504Dp.m4382constructorimpl((float) 0)) > 0 : false, (r15 & 8) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (r15 & 16) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L);
                    SpacerKt.Spacer(BackgroundKt.m494backgroundbw27NRU(m1677shadows4CzXII, resolvedThumbColor, RoundedCornerShapeKt.getCircleShape()), $composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                value$iv$iv4 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                        return IntOffset.m4491boximpl(m1532invokeBjo55l4(density));
                    }

                    /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                    public final long m1532invokeBjo55l4(Density offset) {
                        Intrinsics.checkNotNullParameter(offset, "$this$offset");
                        return IntOffsetKt.IntOffset(MathKt.roundToInt(state.getValue().floatValue()), 0);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv4);
                $composer2.endReplaceableGroup();
                m1677shadows4CzXII = ShadowKt.m1677shadows4CzXII(SizeKt.m792requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(align, (Function1) value$iv$iv4), interactionSource, RippleKt.m1618rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0L, $composer2, 54, 4)), ThumbDiameter), elevation, (r15 & 2) != 0 ? RectangleShapeKt.getRectangleShape() : RoundedCornerShapeKt.getCircleShape(), (r15 & 4) != 0 ? C0504Dp.m4381compareTo0680j_4(r8, C0504Dp.m4382constructorimpl((float) 0)) > 0 : false, (r15 & 8) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (r15 & 16) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L);
                SpacerKt.Spacer(BackgroundKt.m494backgroundbw27NRU(m1677shadows4CzXII, resolvedThumbColor, RoundedCornerShapeKt.getCircleShape()), $composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            value$iv$iv3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$2$1
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
                    long m1527SwitchImpl$lambda5;
                    Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                    m1527SwitchImpl$lambda5 = SwitchKt.m1527SwitchImpl$lambda5(trackColor$delegate);
                    SwitchKt.m1531drawTrackRPmYEkk(Canvas, m1527SwitchImpl$lambda5, Canvas.mo648toPx0680j_4(SwitchKt.getTrackWidth()), Canvas.mo648toPx0680j_4(SwitchKt.getTrackStrokeWidth()));
                }
            };
            $composer2.updateRememberedValue(value$iv$iv3);
            $composer2.endReplaceableGroup();
            CanvasKt.Canvas(fillMaxSize$default, (Function1) value$iv$iv3, $composer2, 0);
            thumbColor$delegate = colors.thumbColor(enabled, checked, $composer2, (($dirty2 >> 6) & 14) | ($dirty2 & SdkConfig.SDK_VERSION) | (($dirty2 >> 3) & 896));
            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay2 = ElevationOverlayKt.getLocalElevationOverlay();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(localElevationOverlay2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ElevationOverlay elevationOverlay2 = (ElevationOverlay) consume3;
            ProvidableCompositionLocal<C0504Dp> localAbsoluteElevation2 = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume22 = $composer2.consume(localAbsoluteElevation2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float arg0$iv3 = ((C0504Dp) consume22).m4396unboximpl();
            float arg0$iv22 = C0504Dp.m4382constructorimpl(arg0$iv3 + elevation);
            $composer2.startReplaceableGroup(-539245361);
            ComposerKt.sourceInformation($composer2, "211@8660L36");
            if (!Color.m1997equalsimpl0(m1528SwitchImpl$lambda7(thumbColor$delegate), MaterialTheme.INSTANCE.getColors($composer2, 6).m1321getSurface0d7_KjU())) {
            }
            str = "C(remember)P(1):Composables.kt#9igjgp";
            i = 1157296644;
            resolvedThumbColor = m1528SwitchImpl$lambda7(thumbColor$delegate);
            $composer2.endReplaceableGroup();
            Modifier align2 = $this$SwitchImpl.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart());
            int i32 = ($dirty2 >> 12) & 14;
            $composer2.startReplaceableGroup(i);
            ComposerKt.sourceInformation($composer2, str);
            invalid$iv$iv = $composer2.changed(state);
            Object value$iv$iv42 = $composer2.rememberedValue();
            if (!invalid$iv$iv) {
                $composer2.endReplaceableGroup();
                m1677shadows4CzXII = ShadowKt.m1677shadows4CzXII(SizeKt.m792requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(align2, (Function1) value$iv$iv42), interactionSource, RippleKt.m1618rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0L, $composer2, 54, 4)), ThumbDiameter), elevation, (r15 & 2) != 0 ? RectangleShapeKt.getRectangleShape() : RoundedCornerShapeKt.getCircleShape(), (r15 & 4) != 0 ? C0504Dp.m4381compareTo0680j_4(r8, C0504Dp.m4382constructorimpl((float) 0)) > 0 : false, (r15 & 8) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (r15 & 16) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L);
                SpacerKt.Spacer(BackgroundKt.m494backgroundbw27NRU(m1677shadows4CzXII, resolvedThumbColor, RoundedCornerShapeKt.getCircleShape()), $composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            value$iv$iv42 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                    return IntOffset.m4491boximpl(m1532invokeBjo55l4(density));
                }

                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                public final long m1532invokeBjo55l4(Density offset) {
                    Intrinsics.checkNotNullParameter(offset, "$this$offset");
                    return IntOffsetKt.IntOffset(MathKt.roundToInt(state.getValue().floatValue()), 0);
                }
            };
            $composer2.updateRememberedValue(value$iv$iv42);
            $composer2.endReplaceableGroup();
            m1677shadows4CzXII = ShadowKt.m1677shadows4CzXII(SizeKt.m792requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(align2, (Function1) value$iv$iv42), interactionSource, RippleKt.m1618rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0L, $composer2, 54, 4)), ThumbDiameter), elevation, (r15 & 2) != 0 ? RectangleShapeKt.getRectangleShape() : RoundedCornerShapeKt.getCircleShape(), (r15 & 4) != 0 ? C0504Dp.m4381compareTo0680j_4(r8, C0504Dp.m4382constructorimpl((float) 0)) > 0 : false, (r15 & 8) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (r15 & 16) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L);
            SpacerKt.Spacer(BackgroundKt.m494backgroundbw27NRU(m1677shadows4CzXII, resolvedThumbColor, RoundedCornerShapeKt.getCircleShape()), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i4) {
                SwitchKt.SwitchImpl(BoxScope.this, checked, enabled, colors, state, interactionSource, composer, $changed | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: SwitchImpl$lambda-5, reason: not valid java name */
    public static final long m1527SwitchImpl$lambda5(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m2006unboximpl();
    }

    /* renamed from: SwitchImpl$lambda-7, reason: not valid java name */
    private static final long m1528SwitchImpl$lambda7(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m2006unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawTrack-RPmYEkk, reason: not valid java name */
    public static final void m1531drawTrackRPmYEkk(DrawScope $this$drawTrack_u2dRPmYEkk, long trackColor, float trackWidth, float strokeWidth) {
        float strokeRadius = strokeWidth / 2;
        DrawScope.m2477drawLineNGM6Ib0$default($this$drawTrack_u2dRPmYEkk, trackColor, androidx.compose.p000ui.geometry.OffsetKt.Offset(strokeRadius, Offset.m1761getYimpl($this$drawTrack_u2dRPmYEkk.mo2489getCenterF1C5BW0())), androidx.compose.p000ui.geometry.OffsetKt.Offset(trackWidth - strokeRadius, Offset.m1761getYimpl($this$drawTrack_u2dRPmYEkk.mo2489getCenterF1C5BW0())), strokeWidth, StrokeCap.INSTANCE.m2301getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
    }

    static {
        float arg0$iv = TrackWidth;
        float other$iv = ThumbDiameter;
        ThumbPathLength = C0504Dp.m4382constructorimpl(arg0$iv - other$iv);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
        ThumbDefaultElevation = C0504Dp.m4382constructorimpl(1);
        ThumbPressedElevation = C0504Dp.m4382constructorimpl(6);
    }

    public static final float getTrackWidth() {
        return TrackWidth;
    }

    public static final float getTrackStrokeWidth() {
        return TrackStrokeWidth;
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }
}
