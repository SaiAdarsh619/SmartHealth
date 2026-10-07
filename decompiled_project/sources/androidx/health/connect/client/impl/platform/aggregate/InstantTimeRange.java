package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.records.Vo2MaxRecord;
import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TimeRange.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0002HÆ\u0003J\t\u0010\n\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/InstantTimeRange;", "Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;", "Ljava/time/Instant;", "startTime", "endTime", "(Ljava/time/Instant;Ljava/time/Instant;)V", "getEndTime", "()Ljava/time/Instant;", "getStartTime", "component1", "component2", "copy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes14.dex */
public final class InstantTimeRange implements TimeRange<Instant> {
    private final Instant endTime;
    private final Instant startTime;

    public static /* synthetic */ InstantTimeRange copy$default(InstantTimeRange instantTimeRange, Instant instant, Instant instant2, int i, Object obj) {
        if ((i & 1) != 0) {
            instant = instantTimeRange.startTime;
        }
        if ((i & 2) != 0) {
            instant2 = instantTimeRange.endTime;
        }
        return instantTimeRange.copy(instant, instant2);
    }

    public final Instant component1() {
        return this.startTime;
    }

    public final Instant component2() {
        return this.endTime;
    }

    public final InstantTimeRange copy(Instant startTime, Instant endTime) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        return new InstantTimeRange(startTime, endTime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InstantTimeRange) {
            InstantTimeRange instantTimeRange = (InstantTimeRange) obj;
            return Intrinsics.areEqual(this.startTime, instantTimeRange.startTime) && Intrinsics.areEqual(this.endTime, instantTimeRange.endTime);
        }
        return false;
    }

    public int hashCode() {
        return (this.startTime.hashCode() * 31) + this.endTime.hashCode();
    }

    public String toString() {
        return "InstantTimeRange(startTime=" + this.startTime + ", endTime=" + this.endTime + ')';
    }

    public InstantTimeRange(Instant startTime, Instant endTime) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.health.connect.client.impl.platform.aggregate.TimeRange
    public Instant getStartTime() {
        return this.startTime;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.health.connect.client.impl.platform.aggregate.TimeRange
    public Instant getEndTime() {
        return this.endTime;
    }
}
