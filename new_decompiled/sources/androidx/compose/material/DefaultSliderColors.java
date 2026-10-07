package androidx.compose.material;

import androidx.compose.p000ui.graphics.Color;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: Slider.kt */
@Metadata(m286d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001BX\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u0010H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0017J&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u0019\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\u000b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000e\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, m287d2 = {"Landroidx/compose/material/DefaultSliderColors;", "Landroidx/compose/material/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "disabledThumbColor", "activeTrackColor", "inactiveTrackColor", "disabledActiveTrackColor", "disabledInactiveTrackColor", "activeTickColor", "inactiveTickColor", "disabledActiveTickColor", "disabledInactiveTickColor", "(JJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "Landroidx/compose/runtime/State;", "enabled", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "tickColor", "active", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "trackColor", "material_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class DefaultSliderColors implements SliderColors {
    private final long activeTickColor;
    private final long activeTrackColor;
    private final long disabledActiveTickColor;
    private final long disabledActiveTrackColor;
    private final long disabledInactiveTickColor;
    private final long disabledInactiveTrackColor;
    private final long disabledThumbColor;
    private final long inactiveTickColor;
    private final long inactiveTrackColor;
    private final long thumbColor;

    public /* synthetic */ DefaultSliderColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10);
    }

    private DefaultSliderColors(long thumbColor, long disabledThumbColor, long activeTrackColor, long inactiveTrackColor, long disabledActiveTrackColor, long disabledInactiveTrackColor, long activeTickColor, long inactiveTickColor, long disabledActiveTickColor, long disabledInactiveTickColor) {
        this.thumbColor = thumbColor;
        this.disabledThumbColor = disabledThumbColor;
        this.activeTrackColor = activeTrackColor;
        this.inactiveTrackColor = inactiveTrackColor;
        this.disabledActiveTrackColor = disabledActiveTrackColor;
        this.disabledInactiveTrackColor = disabledInactiveTrackColor;
        this.activeTickColor = activeTickColor;
        this.inactiveTickColor = inactiveTickColor;
        this.disabledActiveTickColor = disabledActiveTickColor;
        this.disabledInactiveTickColor = disabledInactiveTickColor;
    }

    @Override // androidx.compose.material.SliderColors
    public State<Color> thumbColor(boolean enabled, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1733795637);
        ComposerKt.sourceInformation($composer, "C(thumbColor)1088@42532L69:Slider.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1733795637, $changed, -1, "androidx.compose.material.DefaultSliderColors.thumbColor (Slider.kt:1087)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1986boximpl(enabled ? this.thumbColor : this.disabledThumbColor), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.SliderColors
    public State<Color> trackColor(boolean enabled, boolean active, Composer $composer, int $changed) {
        long j;
        $composer.startReplaceableGroup(1575395620);
        ComposerKt.sourceInformation($composer, "C(trackColor)P(1)1093@42719L247:Slider.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1575395620, $changed, -1, "androidx.compose.material.DefaultSliderColors.trackColor (Slider.kt:1092)");
        }
        if (enabled) {
            j = active ? this.activeTrackColor : this.inactiveTrackColor;
        } else {
            j = active ? this.disabledActiveTrackColor : this.disabledInactiveTrackColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1986boximpl(j), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.SliderColors
    public State<Color> tickColor(boolean enabled, boolean active, Composer $composer, int $changed) {
        long j;
        $composer.startReplaceableGroup(-1491563694);
        ComposerKt.sourceInformation($composer, "C(tickColor)P(1)1104@43083L243:Slider.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1491563694, $changed, -1, "androidx.compose.material.DefaultSliderColors.tickColor (Slider.kt:1103)");
        }
        if (enabled) {
            j = active ? this.activeTickColor : this.inactiveTickColor;
        } else {
            j = active ? this.disabledActiveTickColor : this.disabledInactiveTickColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1986boximpl(j), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(getClass()), Reflection.getOrCreateKotlinClass(other.getClass()))) {
            return false;
        }
        if (Color.m1997equalsimpl0(this.thumbColor, ((DefaultSliderColors) other).thumbColor) && Color.m1997equalsimpl0(this.disabledThumbColor, ((DefaultSliderColors) other).disabledThumbColor) && Color.m1997equalsimpl0(this.activeTrackColor, ((DefaultSliderColors) other).activeTrackColor) && Color.m1997equalsimpl0(this.inactiveTrackColor, ((DefaultSliderColors) other).inactiveTrackColor) && Color.m1997equalsimpl0(this.disabledActiveTrackColor, ((DefaultSliderColors) other).disabledActiveTrackColor) && Color.m1997equalsimpl0(this.disabledInactiveTrackColor, ((DefaultSliderColors) other).disabledInactiveTrackColor) && Color.m1997equalsimpl0(this.activeTickColor, ((DefaultSliderColors) other).activeTickColor) && Color.m1997equalsimpl0(this.inactiveTickColor, ((DefaultSliderColors) other).inactiveTickColor) && Color.m1997equalsimpl0(this.disabledActiveTickColor, ((DefaultSliderColors) other).disabledActiveTickColor) && Color.m1997equalsimpl0(this.disabledInactiveTickColor, ((DefaultSliderColors) other).disabledInactiveTickColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = Color.m2003hashCodeimpl(this.thumbColor);
        return (((((((((((((((((result * 31) + Color.m2003hashCodeimpl(this.disabledThumbColor)) * 31) + Color.m2003hashCodeimpl(this.activeTrackColor)) * 31) + Color.m2003hashCodeimpl(this.inactiveTrackColor)) * 31) + Color.m2003hashCodeimpl(this.disabledActiveTrackColor)) * 31) + Color.m2003hashCodeimpl(this.disabledInactiveTrackColor)) * 31) + Color.m2003hashCodeimpl(this.activeTickColor)) * 31) + Color.m2003hashCodeimpl(this.inactiveTickColor)) * 31) + Color.m2003hashCodeimpl(this.disabledActiveTickColor)) * 31) + Color.m2003hashCodeimpl(this.disabledInactiveTickColor);
    }
}
