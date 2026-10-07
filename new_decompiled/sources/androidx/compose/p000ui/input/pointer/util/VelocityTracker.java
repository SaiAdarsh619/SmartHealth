package androidx.compose.p000ui.input.pointer.util;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.unit.VelocityKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* compiled from: VelocityTracker.kt */
@Metadata(m286d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u0018ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\u0011R%\u0010\u0003\u001a\u00020\u0004X\u0080\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, m287d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "", "()V", "currentPointerPositionAccumulator", "Landroidx/compose/ui/geometry/Offset;", "getCurrentPointerPositionAccumulator-F1C5BW0$ui_release", "()J", "setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release", "(J)V", "J", "index", "", "samples", "", "Landroidx/compose/ui/input/pointer/util/PointAtTime;", "[Landroidx/compose/ui/input/pointer/util/PointAtTime;", "addPosition", "", "timeMillis", "", "position", "addPosition-Uv8p0NA", "(JJ)V", "calculateVelocity", "Landroidx/compose/ui/unit/Velocity;", "calculateVelocity-9UxMQ8M", "getVelocityEstimate", "Landroidx/compose/ui/input/pointer/util/VelocityEstimate;", "resetTracking", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class VelocityTracker {
    public static final int $stable = 8;
    private long currentPointerPositionAccumulator;
    private int index;
    private final PointAtTime[] samples;

    public VelocityTracker() {
        PointAtTime[] pointAtTimeArr = new PointAtTime[20];
        for (int i = 0; i < 20; i++) {
            pointAtTimeArr[i] = null;
        }
        this.samples = pointAtTimeArr;
        this.currentPointerPositionAccumulator = Offset.INSTANCE.m1776getZeroF1C5BW0();
    }

    /* renamed from: getCurrentPointerPositionAccumulator-F1C5BW0$ui_release, reason: not valid java name and from getter */
    public final long getCurrentPointerPositionAccumulator() {
        return this.currentPointerPositionAccumulator;
    }

    /* renamed from: setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release, reason: not valid java name */
    public final void m3468setCurrentPointerPositionAccumulatork4lQ0M$ui_release(long j) {
        this.currentPointerPositionAccumulator = j;
    }

    /* renamed from: addPosition-Uv8p0NA, reason: not valid java name */
    public final void m3465addPositionUv8p0NA(long timeMillis, long position) {
        this.index = (this.index + 1) % 20;
        this.samples[this.index] = new PointAtTime(position, timeMillis, null);
    }

    /* renamed from: calculateVelocity-9UxMQ8M, reason: not valid java name */
    public final long m3466calculateVelocity9UxMQ8M() {
        long estimate = getVelocityEstimate().m3464getPixelsPerSecondF1C5BW0();
        return VelocityKt.Velocity(Offset.m1760getXimpl(estimate), Offset.m1761getYimpl(estimate));
    }

    public final void resetTracking() {
        ArraysKt.fill$default(this.samples, (Object) null, 0, 0, 6, (Object) null);
    }

    private final VelocityEstimate getVelocityEstimate() {
        PointAtTime sample;
        int index;
        List x = new ArrayList();
        List y = new ArrayList();
        List time = new ArrayList();
        int sampleCount = 0;
        int index2 = this.index;
        PointAtTime newestSample = this.samples[index2];
        if (newestSample == null) {
            return VelocityEstimate.INSTANCE.getNone();
        }
        PointAtTime previousSample = newestSample;
        PointAtTime oldestSample = newestSample;
        while (true) {
            PointAtTime sample2 = this.samples[index2];
            if (sample2 == null) {
                sample = oldestSample;
                index = sampleCount;
                break;
            }
            float age = newestSample.getTime() - sample2.getTime();
            float delta = Math.abs(sample2.getTime() - previousSample.getTime());
            previousSample = sample2;
            if (age > 100.0f || delta > 40.0f) {
                break;
            }
            oldestSample = sample2;
            long position = sample2.m3458getPointF1C5BW0();
            x.add(Float.valueOf(Offset.m1760getXimpl(position)));
            y.add(Float.valueOf(Offset.m1761getYimpl(position)));
            time.add(Float.valueOf(-age));
            index2 = (index2 == 0 ? 20 : index2) - 1;
            sampleCount++;
            if (sampleCount >= 20) {
                sample = oldestSample;
                index = sampleCount;
                break;
            }
        }
        sample = oldestSample;
        index = sampleCount;
        if (index >= 3) {
            try {
                PolynomialFit xFit = VelocityTrackerKt.polyFitLeastSquares(time, x, 2);
                PolynomialFit yFit = VelocityTrackerKt.polyFitLeastSquares(time, y, 2);
                float xSlope = xFit.getCoefficients().get(1).floatValue();
                float ySlope = yFit.getCoefficients().get(1).floatValue();
                float f = 1000;
                try {
                    return new VelocityEstimate(OffsetKt.Offset(xSlope * f, f * ySlope), yFit.getConfidence() * xFit.getConfidence(), newestSample.getTime() - sample.getTime(), Offset.m1764minusMKHz9U(newestSample.m3458getPointF1C5BW0(), sample.m3458getPointF1C5BW0()), null);
                } catch (IllegalArgumentException e) {
                    return VelocityEstimate.INSTANCE.getNone();
                }
            } catch (IllegalArgumentException e2) {
            }
        } else {
            return new VelocityEstimate(Offset.INSTANCE.m1776getZeroF1C5BW0(), 1.0f, newestSample.getTime() - sample.getTime(), Offset.m1764minusMKHz9U(newestSample.m3458getPointF1C5BW0(), sample.m3458getPointF1C5BW0()), null);
        }
    }
}
