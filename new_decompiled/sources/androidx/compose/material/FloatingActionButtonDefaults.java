package androidx.compose.material;

import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.health.platform.client.SdkConfig;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* compiled from: FloatingActionButton.kt */
@Metadata(m286d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ=\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, m287d2 = {"Landroidx/compose/material/FloatingActionButtonDefaults;", "", "()V", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "elevation-ixp7dh8", "(FFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/FloatingActionButtonElevation;", "hoveredElevation", "focusedElevation", "elevation-xZ9-QkE", "(FFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/FloatingActionButtonElevation;", "material_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class FloatingActionButtonDefaults {
    public static final int $stable = 0;
    public static final FloatingActionButtonDefaults INSTANCE = new FloatingActionButtonDefaults();

    private FloatingActionButtonDefaults() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another overload of elevation")
    /* renamed from: elevation-ixp7dh8, reason: not valid java name */
    public final /* synthetic */ FloatingActionButtonElevation m1409elevationixp7dh8(float defaultElevation, float pressedElevation, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(-654132828);
        ComposerKt.sourceInformation($composer, "C(elevation)P(0:c#ui.unit.Dp,1:c#ui.unit.Dp)219@9593L134:FloatingActionButton.kt#jmzs0o");
        if ((i & 1) != 0) {
            defaultElevation = C0504Dp.m4382constructorimpl(6);
        }
        if ((i & 2) != 0) {
            pressedElevation = C0504Dp.m4382constructorimpl(12);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-654132828, $changed, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:216)");
        }
        int $this$dp$iv = $changed & 14;
        FloatingActionButtonElevation m1410elevationxZ9QkE = m1410elevationxZ9QkE(defaultElevation, pressedElevation, C0504Dp.m4382constructorimpl(8), C0504Dp.m4382constructorimpl(8), $composer, $this$dp$iv | 3456 | ($changed & SdkConfig.SDK_VERSION) | (($changed << 6) & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m1410elevationxZ9QkE;
    }

    /* renamed from: elevation-xZ9-QkE, reason: not valid java name */
    public final FloatingActionButtonElevation m1410elevationxZ9QkE(float defaultElevation, float pressedElevation, float hoveredElevation, float focusedElevation, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(380403812);
        ComposerKt.sourceInformation($composer, "C(elevation)P(0:c#ui.unit.Dp,3:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp)247@10589L367:FloatingActionButton.kt#jmzs0o");
        float defaultElevation2 = (i & 1) != 0 ? C0504Dp.m4382constructorimpl(6) : defaultElevation;
        float pressedElevation2 = (i & 2) != 0 ? C0504Dp.m4382constructorimpl(12) : pressedElevation;
        float hoveredElevation2 = (i & 4) != 0 ? C0504Dp.m4382constructorimpl(8) : hoveredElevation;
        float focusedElevation2 = (i & 8) != 0 ? C0504Dp.m4382constructorimpl(8) : focusedElevation;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(380403812, $changed, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:241)");
        }
        Object[] keys$iv = {C0504Dp.m4380boximpl(defaultElevation2), C0504Dp.m4380boximpl(pressedElevation2), C0504Dp.m4380boximpl(hoveredElevation2), C0504Dp.m4380boximpl(focusedElevation2)};
        $composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= $composer.changed(key$iv);
        }
        Object value$iv$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new DefaultFloatingActionButtonElevation(defaultElevation2, pressedElevation2, hoveredElevation2, focusedElevation2, null);
            $composer.updateRememberedValue(value$iv$iv);
        }
        $composer.endReplaceableGroup();
        DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation = (DefaultFloatingActionButtonElevation) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultFloatingActionButtonElevation;
    }
}
