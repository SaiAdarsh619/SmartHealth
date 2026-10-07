package androidx.compose.p000ui.geometry;

import kotlin.Metadata;

/* compiled from: GeometryUtils.kt */
@Metadata(m286d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, m287d2 = {"toStringAsFixed", "", "", "digits", "", "ui-geometry_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class GeometryUtilsKt {
    public static final String toStringAsFixed(float $this$toStringAsFixed, int digits) {
        int roundedShifted;
        int clampedDigits = Math.max(digits, 0);
        float pow = (float) Math.pow(10.0f, clampedDigits);
        float shifted = $this$toStringAsFixed * pow;
        float decimal = shifted - ((int) shifted);
        if (decimal >= 0.5f) {
            roundedShifted = ((int) shifted) + 1;
        } else {
            roundedShifted = (int) shifted;
        }
        float rounded = roundedShifted / pow;
        if (clampedDigits > 0) {
            return String.valueOf(rounded);
        }
        return String.valueOf((int) rounded);
    }
}
