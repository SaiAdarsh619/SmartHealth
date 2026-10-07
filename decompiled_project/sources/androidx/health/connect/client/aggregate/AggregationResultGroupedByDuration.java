package androidx.health.connect.client.aggregate;

import androidx.health.connect.client.records.Vo2MaxRecord;
import java.time.Instant;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AggregationResultGroupedByDuration.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "", "result", "Landroidx/health/connect/client/aggregate/AggregationResult;", "startTime", "Ljava/time/Instant;", "endTime", "zoneOffset", "Ljava/time/ZoneOffset;", "(Landroidx/health/connect/client/aggregate/AggregationResult;Ljava/time/Instant;Ljava/time/Instant;Ljava/time/ZoneOffset;)V", "getEndTime", "()Ljava/time/Instant;", "getResult", "()Landroidx/health/connect/client/aggregate/AggregationResult;", "getStartTime", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "toString", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes14.dex */
public final class AggregationResultGroupedByDuration {
    private final Instant endTime;
    private final AggregationResult result;
    private final Instant startTime;
    private final ZoneOffset zoneOffset;

    public AggregationResultGroupedByDuration(AggregationResult result, Instant startTime, Instant endTime, ZoneOffset zoneOffset) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(zoneOffset, "zoneOffset");
        this.result = result;
        this.startTime = startTime;
        this.endTime = endTime;
        this.zoneOffset = zoneOffset;
        if (!this.startTime.isBefore(this.endTime)) {
            throw new IllegalArgumentException("start time must be before end time".toString());
        }
    }

    public final AggregationResult getResult() {
        return this.result;
    }

    public final Instant getStartTime() {
        return this.startTime;
    }

    public final Instant getEndTime() {
        return this.endTime;
    }

    public final ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration");
            AggregationResultGroupedByDuration aggregationResultGroupedByDuration = (AggregationResultGroupedByDuration) other;
            return Intrinsics.areEqual(this.result, ((AggregationResultGroupedByDuration) other).result) && Intrinsics.areEqual(this.startTime, ((AggregationResultGroupedByDuration) other).startTime) && Intrinsics.areEqual(this.endTime, ((AggregationResultGroupedByDuration) other).endTime) && Intrinsics.areEqual(this.zoneOffset, ((AggregationResultGroupedByDuration) other).zoneOffset);
        }
        return false;
    }

    public int hashCode() {
        int hash = this.result.hashCode();
        return (((((hash * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.zoneOffset.hashCode();
    }

    public String toString() {
        return "AggregationResultGroupedByDuration(result=" + this.result + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", zoneOffset=" + this.zoneOffset + ')';
    }
}
