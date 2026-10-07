package androidx.compose.material;

import androidx.compose.p000ui.graphics.ColorKt;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;

/* compiled from: ElevationOverlay.kt */
@Metadata(m286d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\n"}, m287d2 = {"Landroidx/compose/material/DefaultElevationOverlay;", "Landroidx/compose/material/ElevationOverlay;", "()V", "apply", "Landroidx/compose/ui/graphics/Color;", "color", "elevation", "Landroidx/compose/ui/unit/Dp;", "apply-7g2Lkgo", "(JFLandroidx/compose/runtime/Composer;I)J", "material_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class DefaultElevationOverlay implements ElevationOverlay {
    public static final DefaultElevationOverlay INSTANCE = new DefaultElevationOverlay();

    private DefaultElevationOverlay() {
    }

    @Override // androidx.compose.material.ElevationOverlay
    /* renamed from: apply-7g2Lkgo, reason: not valid java name */
    public long mo1351apply7g2Lkgo(long color, float elevation, Composer $composer, int $changed) {
        long foregroundColor;
        long foregroundColor2;
        ComposerKt.sourceInformationMarkerStart($composer, -1687113661, "C(apply)P(0:c#ui.graphics.Color,1:c#ui.unit.Dp)69@2742L6,71@2841L42:ElevationOverlay.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1687113661, $changed, -1, "androidx.compose.material.DefaultElevationOverlay.apply (ElevationOverlay.kt:68)");
        }
        Colors colors = MaterialTheme.INSTANCE.getColors($composer, 6);
        int $this$dp$iv = C0504Dp.m4381compareTo0680j_4(elevation, C0504Dp.m4382constructorimpl(0));
        if ($this$dp$iv > 0 && !colors.isLight()) {
            foregroundColor2 = ElevationOverlayKt.m1385calculateForegroundColorCLU3JFs(color, elevation, $composer, ($changed & 14) | ($changed & SdkConfig.SDK_VERSION));
            foregroundColor = ColorKt.m2042compositeOverOWjLjI(foregroundColor2, color);
        } else {
            foregroundColor = color;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return foregroundColor;
    }
}
