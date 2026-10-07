package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: VelocityTracker.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\b\u0018\u0000 !2\u00020\u0001:\u0001!B(\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\u0011\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\rJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u0019\u0010\u0015\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\rJ>\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u000e\u0010\rR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\r\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityEstimate;", "", "pixelsPerSecond", "Landroidx/compose/ui/geometry/Offset;", "confidence", "", "durationMillis", "", "offset", "(JFJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConfidence", "()F", "getDurationMillis", "()J", "getOffset-F1C5BW0", "J", "getPixelsPerSecond-F1C5BW0", "component1", "component1-F1C5BW0", "component2", "component3", "component4", "component4-F1C5BW0", "copy", "copy-PZAlG8E", "(JFJJ)Landroidx/compose/ui/input/pointer/util/VelocityEstimate;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "toString", "", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
final class VelocityEstimate {
    public static final Companion Companion = new Companion(null);
    private static final VelocityEstimate None = new VelocityEstimate(Offset.Companion.m1460getZeroF1C5BW0(), 1.0f, 0, Offset.Companion.m1460getZeroF1C5BW0(), null);
    private final float confidence;
    private final long durationMillis;
    private final long offset;
    private final long pixelsPerSecond;

    public /* synthetic */ VelocityEstimate(long j, float f, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, f, j2, j3);
    }

    /* renamed from: component1-F1C5BW0  reason: not valid java name */
    public final long m3144component1F1C5BW0() {
        return this.pixelsPerSecond;
    }

    public final float component2() {
        return this.confidence;
    }

    public final long component3() {
        return this.durationMillis;
    }

    /* renamed from: component4-F1C5BW0  reason: not valid java name */
    public final long m3145component4F1C5BW0() {
        return this.offset;
    }

    /* renamed from: copy-PZAlG8E  reason: not valid java name */
    public final VelocityEstimate m3146copyPZAlG8E(long j, float f, long j2, long j3) {
        return new VelocityEstimate(j, f, j2, j3, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VelocityEstimate) {
            VelocityEstimate velocityEstimate = (VelocityEstimate) obj;
            return Offset.m1441equalsimpl0(this.pixelsPerSecond, velocityEstimate.pixelsPerSecond) && Intrinsics.areEqual((Object) Float.valueOf(this.confidence), (Object) Float.valueOf(velocityEstimate.confidence)) && this.durationMillis == velocityEstimate.durationMillis && Offset.m1441equalsimpl0(this.offset, velocityEstimate.offset);
        }
        return false;
    }

    public int hashCode() {
        return (((((Offset.m1446hashCodeimpl(this.pixelsPerSecond) * 31) + Float.hashCode(this.confidence)) * 31) + Long.hashCode(this.durationMillis)) * 31) + Offset.m1446hashCodeimpl(this.offset);
    }

    public String toString() {
        return "VelocityEstimate(pixelsPerSecond=" + ((Object) Offset.m1452toStringimpl(this.pixelsPerSecond)) + ", confidence=" + this.confidence + ", durationMillis=" + this.durationMillis + ", offset=" + ((Object) Offset.m1452toStringimpl(this.offset)) + ')';
    }

    private VelocityEstimate(long pixelsPerSecond, float confidence, long durationMillis, long offset) {
        this.pixelsPerSecond = pixelsPerSecond;
        this.confidence = confidence;
        this.durationMillis = durationMillis;
        this.offset = offset;
    }

    /* renamed from: getPixelsPerSecond-F1C5BW0  reason: not valid java name */
    public final long m3148getPixelsPerSecondF1C5BW0() {
        return this.pixelsPerSecond;
    }

    public final float getConfidence() {
        return this.confidence;
    }

    public final long getDurationMillis() {
        return this.durationMillis;
    }

    /* renamed from: getOffset-F1C5BW0  reason: not valid java name */
    public final long m3147getOffsetF1C5BW0() {
        return this.offset;
    }

    /* compiled from: VelocityTracker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityEstimate$Companion;", "", "()V", "None", "Landroidx/compose/ui/input/pointer/util/VelocityEstimate;", "getNone", "()Landroidx/compose/ui/input/pointer/util/VelocityEstimate;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VelocityEstimate getNone() {
            return VelocityEstimate.None;
        }
    }
}
