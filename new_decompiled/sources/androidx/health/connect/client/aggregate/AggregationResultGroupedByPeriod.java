package androidx.health.connect.client.aggregate;

import androidx.health.connect.client.records.Vo2MaxRecord;
import java.time.LocalDateTime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AggregationResultGroupedByPeriod.kt */
@Metadata(m286d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0014"}, m287d2 = {"Landroidx/health/connect/client/aggregate/AggregationResultGroupedByPeriod;", "", "result", "Landroidx/health/connect/client/aggregate/AggregationResult;", "startTime", "Ljava/time/LocalDateTime;", "endTime", "(Landroidx/health/connect/client/aggregate/AggregationResult;Ljava/time/LocalDateTime;Ljava/time/LocalDateTime;)V", "getEndTime", "()Ljava/time/LocalDateTime;", "getResult", "()Landroidx/health/connect/client/aggregate/AggregationResult;", "getStartTime", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class AggregationResultGroupedByPeriod {
    private final LocalDateTime endTime;
    private final AggregationResult result;
    private final LocalDateTime startTime;

    public AggregationResultGroupedByPeriod(AggregationResult result, LocalDateTime startTime, LocalDateTime endTime) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        this.result = result;
        this.startTime = startTime;
        this.endTime = endTime;
        if (!this.startTime.isBefore(this.endTime)) {
            throw new IllegalArgumentException("start time must be before end time".toString());
        }
    }

    public final AggregationResult getResult() {
        return this.result;
    }

    public final LocalDateTime getStartTime() {
        return this.startTime;
    }

    public final LocalDateTime getEndTime() {
        return this.endTime;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.health.connect.client.aggregate.AggregationResultGroupedByPeriod");
        return Intrinsics.areEqual(this.result, ((AggregationResultGroupedByPeriod) other).result) && Intrinsics.areEqual(this.startTime, ((AggregationResultGroupedByPeriod) other).startTime) && Intrinsics.areEqual(this.endTime, ((AggregationResultGroupedByPeriod) other).endTime);
    }

    public int hashCode() {
        int hash = this.result.hashCode();
        return (((hash * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode();
    }

    public String toString() {
        return "AggregationResultGroupedByPeriod(result=" + this.result + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ')';
    }
}
