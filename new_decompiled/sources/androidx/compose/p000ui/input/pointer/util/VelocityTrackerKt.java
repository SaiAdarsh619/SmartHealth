package androidx.compose.p000ui.input.pointer.util;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.pointer.HistoricalChange;
import androidx.compose.p000ui.input.pointer.PointerEventKt;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VelocityTracker.kt */
@Metadata(m286d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m287d2 = {"AssumePointerMoveStoppedMilliseconds", "", "DefaultWeight", "", "HistorySize", "HorizonMilliseconds", "MinSampleSize", "polyFitLeastSquares", "Landroidx/compose/ui/input/pointer/util/PolynomialFit;", "x", "", "y", "degree", "addPointerInputChange", "", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/pointer/PointerInputChange;", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class VelocityTrackerKt {
    private static final int AssumePointerMoveStoppedMilliseconds = 40;
    private static final float DefaultWeight = 1.0f;
    private static final int HistorySize = 20;
    private static final int HorizonMilliseconds = 100;
    private static final int MinSampleSize = 3;

    public static final void addPointerInputChange(VelocityTracker $this$addPointerInputChange, PointerInputChange event) {
        Intrinsics.checkNotNullParameter($this$addPointerInputChange, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (PointerEventKt.changedToDownIgnoreConsumed(event)) {
            $this$addPointerInputChange.m3468setCurrentPointerPositionAccumulatork4lQ0M$ui_release(event.getPosition());
            $this$addPointerInputChange.resetTracking();
        }
        long previousPointerPosition = event.getPreviousPosition();
        List $this$fastForEach$iv = event.getHistorical();
        int index$iv = 0;
        int size = $this$fastForEach$iv.size();
        while (index$iv < size) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            HistoricalChange it = (HistoricalChange) item$iv;
            long historicalDelta = Offset.m1764minusMKHz9U(it.getPosition(), previousPointerPosition);
            previousPointerPosition = it.getPosition();
            $this$addPointerInputChange.m3468setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m1765plusMKHz9U($this$addPointerInputChange.getCurrentPointerPositionAccumulator(), historicalDelta));
            $this$addPointerInputChange.m3465addPositionUv8p0NA(it.getUptimeMillis(), $this$addPointerInputChange.getCurrentPointerPositionAccumulator());
            index$iv++;
            $this$fastForEach$iv = $this$fastForEach$iv;
        }
        long delta = Offset.m1764minusMKHz9U(event.getPosition(), previousPointerPosition);
        $this$addPointerInputChange.m3468setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m1765plusMKHz9U($this$addPointerInputChange.getCurrentPointerPositionAccumulator(), delta));
        $this$addPointerInputChange.m3465addPositionUv8p0NA(event.getUptimeMillis(), $this$addPointerInputChange.getCurrentPointerPositionAccumulator());
    }

    public static final PolynomialFit polyFitLeastSquares(List<Float> x, List<Float> y, int degree) {
        int i;
        float f;
        Intrinsics.checkNotNullParameter(x, "x");
        Intrinsics.checkNotNullParameter(y, "y");
        if (degree < 1) {
            throw new IllegalArgumentException("The degree must be at positive integer");
        }
        if (x.size() != y.size()) {
            throw new IllegalArgumentException("x and y must be the same length");
        }
        if (x.isEmpty()) {
            throw new IllegalArgumentException("At least one point must be provided");
        }
        if (degree >= x.size()) {
            i = x.size() - 1;
        } else {
            i = degree;
        }
        int truncatedDegree = i;
        int i2 = degree + 1;
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(Float.valueOf(0.0f));
        }
        ArrayList coefficients = arrayList;
        int m = x.size();
        int n = truncatedDegree + 1;
        Matrix a = new Matrix(n, m);
        int h = 0;
        while (true) {
            f = 1.0f;
            if (h >= m) {
                break;
            }
            a.set(0, h, 1.0f);
            for (int i4 = 1; i4 < n; i4++) {
                a.set(i4, h, a.get(i4 - 1, h) * x.get(h).floatValue());
            }
            h++;
        }
        Matrix q = new Matrix(n, m);
        Matrix r = new Matrix(n, n);
        int j = 0;
        while (j < n) {
            for (int h2 = 0; h2 < m; h2++) {
                q.set(j, h2, a.get(j, h2));
            }
            for (int i5 = 0; i5 < j; i5++) {
                float dot = q.getRow(j).times(q.getRow(i5));
                for (int h3 = 0; h3 < m; h3++) {
                    q.set(j, h3, q.get(j, h3) - (q.get(i5, h3) * dot));
                }
            }
            float norm = q.getRow(j).norm();
            if (norm < 1.0E-6d) {
                throw new IllegalArgumentException("Vectors are linearly dependent or zero so no solution. TODO(shepshapard), actually determine what this means");
            }
            float inverseNorm = f / norm;
            for (int h4 = 0; h4 < m; h4++) {
                q.set(j, h4, q.get(j, h4) * inverseNorm);
            }
            int i6 = 0;
            while (i6 < n) {
                r.set(j, i6, i6 < j ? 0.0f : q.getRow(j).times(a.getRow(i6)));
                i6++;
            }
            j++;
            f = 1.0f;
        }
        Vector wy = new Vector(m);
        for (int h5 = 0; h5 < m; h5++) {
            wy.set(h5, y.get(h5).floatValue() * 1.0f);
        }
        for (int i7 = n - 1; -1 < i7; i7--) {
            coefficients.set(i7, Float.valueOf(q.getRow(i7).times(wy)));
            int j2 = n - 1;
            int i8 = i7 + 1;
            if (i8 <= j2) {
                while (true) {
                    coefficients.set(i7, Float.valueOf(((Number) coefficients.get(i7)).floatValue() - (r.get(i7, j2) * ((Number) coefficients.get(j2)).floatValue())));
                    if (j2 != i8) {
                        j2--;
                    }
                }
            }
            coefficients.set(i7, Float.valueOf(((Number) coefficients.get(i7)).floatValue() / r.get(i7, i7)));
        }
        float yMean = 0.0f;
        for (int h6 = 0; h6 < m; h6++) {
            yMean += y.get(h6).floatValue();
        }
        float yMean2 = yMean / m;
        float sumSquaredError = 0.0f;
        float sumSquaredTotal = 0.0f;
        for (int h7 = 0; h7 < m; h7++) {
            float term = 1.0f;
            float err = y.get(h7).floatValue() - ((Number) coefficients.get(0)).floatValue();
            for (int i9 = 1; i9 < n; i9++) {
                term *= x.get(h7).floatValue();
                err -= ((Number) coefficients.get(i9)).floatValue() * term;
            }
            sumSquaredError += err * 1.0f * err;
            float v = y.get(h7).floatValue() - yMean2;
            sumSquaredTotal += v * 1.0f * v;
        }
        float confidence = sumSquaredTotal <= 1.0E-6f ? 1.0f : 1.0f - (sumSquaredError / sumSquaredTotal);
        return new PolynomialFit(coefficients, confidence);
    }
}
