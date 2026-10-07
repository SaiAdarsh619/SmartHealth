package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration;
import androidx.health.connect.client.records.Vo2MaxRecord;
import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ResultGroupByDurationAggregator.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/AggregationResultGroupedByDurationWithMinTime;", "", "aggregationResultGroupedByDuration", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "minTime", "Ljava/time/Instant;", "(Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;Ljava/time/Instant;)V", "getAggregationResultGroupedByDuration", "()Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "getMinTime", "()Ljava/time/Instant;", "component1", "component2", "copy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "toString", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes14.dex */
public final class AggregationResultGroupedByDurationWithMinTime {
    private final AggregationResultGroupedByDuration aggregationResultGroupedByDuration;
    private final Instant minTime;

    public static /* synthetic */ AggregationResultGroupedByDurationWithMinTime copy$default(AggregationResultGroupedByDurationWithMinTime aggregationResultGroupedByDurationWithMinTime, AggregationResultGroupedByDuration aggregationResultGroupedByDuration, Instant instant, int i, Object obj) {
        if ((i & 1) != 0) {
            aggregationResultGroupedByDuration = aggregationResultGroupedByDurationWithMinTime.aggregationResultGroupedByDuration;
        }
        if ((i & 2) != 0) {
            instant = aggregationResultGroupedByDurationWithMinTime.minTime;
        }
        return aggregationResultGroupedByDurationWithMinTime.copy(aggregationResultGroupedByDuration, instant);
    }

    public final AggregationResultGroupedByDuration component1() {
        return this.aggregationResultGroupedByDuration;
    }

    public final Instant component2() {
        return this.minTime;
    }

    public final AggregationResultGroupedByDurationWithMinTime copy(AggregationResultGroupedByDuration aggregationResultGroupedByDuration, Instant minTime) {
        Intrinsics.checkNotNullParameter(aggregationResultGroupedByDuration, "aggregationResultGroupedByDuration");
        Intrinsics.checkNotNullParameter(minTime, "minTime");
        return new AggregationResultGroupedByDurationWithMinTime(aggregationResultGroupedByDuration, minTime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AggregationResultGroupedByDurationWithMinTime) {
            AggregationResultGroupedByDurationWithMinTime aggregationResultGroupedByDurationWithMinTime = (AggregationResultGroupedByDurationWithMinTime) obj;
            return Intrinsics.areEqual(this.aggregationResultGroupedByDuration, aggregationResultGroupedByDurationWithMinTime.aggregationResultGroupedByDuration) && Intrinsics.areEqual(this.minTime, aggregationResultGroupedByDurationWithMinTime.minTime);
        }
        return false;
    }

    public int hashCode() {
        return (this.aggregationResultGroupedByDuration.hashCode() * 31) + this.minTime.hashCode();
    }

    public String toString() {
        return "AggregationResultGroupedByDurationWithMinTime(aggregationResultGroupedByDuration=" + this.aggregationResultGroupedByDuration + ", minTime=" + this.minTime + ')';
    }

    public AggregationResultGroupedByDurationWithMinTime(AggregationResultGroupedByDuration aggregationResultGroupedByDuration, Instant minTime) {
        Intrinsics.checkNotNullParameter(aggregationResultGroupedByDuration, "aggregationResultGroupedByDuration");
        Intrinsics.checkNotNullParameter(minTime, "minTime");
        this.aggregationResultGroupedByDuration = aggregationResultGroupedByDuration;
        this.minTime = minTime;
    }

    public final AggregationResultGroupedByDuration getAggregationResultGroupedByDuration() {
        return this.aggregationResultGroupedByDuration;
    }

    public final Instant getMinTime() {
        return this.minTime;
    }
}
