package androidx.health.connect.client.aggregate;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.records.metadata.DataOrigin;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AggregationResult.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B=\b\u0007\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0086\u0002J\u0013\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J(\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0014H\u0086\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0016\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000H\u0080\u0002¢\u0006\u0002\b\u001dJ\b\u0010\u001e\u001a\u00020\u0004H\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001f"}, d2 = {"Landroidx/health/connect/client/aggregate/AggregationResult;", "", "longValues", "", "", "", "doubleValues", "", "dataOrigins", "", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;)V", "getDataOrigins", "()Ljava/util/Set;", "getDoubleValues", "()Ljava/util/Map;", "getLongValues", "contains", "", "metric", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "equals", Vo2MaxRecord.MeasurementMethod.OTHER, "get", "T", "(Landroidx/health/connect/client/aggregate/AggregateMetric;)Ljava/lang/Object;", "hashCode", "", "plus", "plus$connect_client_release", "toString", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes14.dex */
public final class AggregationResult {
    private final Set<DataOrigin> dataOrigins;
    private final Map<String, Double> doubleValues;
    private final Map<String, Long> longValues;

    public AggregationResult(Map<String, Long> longValues, Map<String, Double> doubleValues, Set<DataOrigin> dataOrigins) {
        Intrinsics.checkNotNullParameter(longValues, "longValues");
        Intrinsics.checkNotNullParameter(doubleValues, "doubleValues");
        Intrinsics.checkNotNullParameter(dataOrigins, "dataOrigins");
        this.longValues = longValues;
        this.doubleValues = doubleValues;
        this.dataOrigins = dataOrigins;
    }

    public final Map<String, Long> getLongValues() {
        return this.longValues;
    }

    public final Map<String, Double> getDoubleValues() {
        return this.doubleValues;
    }

    public final Set<DataOrigin> getDataOrigins() {
        return this.dataOrigins;
    }

    public final boolean contains(AggregateMetric<?> metric) {
        Intrinsics.checkNotNullParameter(metric, "metric");
        AggregateMetric.Converter<?, ?> converter$connect_client_release = metric.getConverter$connect_client_release();
        if (converter$connect_client_release instanceof AggregateMetric.Converter.FromLong) {
            return this.longValues.containsKey(metric.getMetricKey());
        }
        if (converter$connect_client_release instanceof AggregateMetric.Converter.FromDouble) {
            return this.doubleValues.containsKey(metric.getMetricKey());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final <T> T get(AggregateMetric<? extends T> metric) {
        Intrinsics.checkNotNullParameter(metric, "metric");
        AggregateMetric.Converter<?, ? extends T> converter$connect_client_release = metric.getConverter$connect_client_release();
        if (converter$connect_client_release instanceof AggregateMetric.Converter.FromLong) {
            Long l = this.longValues.get(metric.getMetricKey());
            if (l != null) {
                return metric.getConverter$connect_client_release().invoke(l);
            }
            return null;
        } else if (converter$connect_client_release instanceof AggregateMetric.Converter.FromDouble) {
            Double d = this.doubleValues.get(metric.getMetricKey());
            if (d != null) {
                return metric.getConverter$connect_client_release().invoke(d);
            }
            return null;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final AggregationResult plus$connect_client_release(AggregationResult other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return new AggregationResult(MapsKt.plus(this.longValues, other.longValues), MapsKt.plus(this.doubleValues, other.doubleValues), SetsKt.plus((Set) this.dataOrigins, (Iterable) other.dataOrigins));
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.health.connect.client.aggregate.AggregationResult");
            AggregationResult aggregationResult = (AggregationResult) other;
            return Intrinsics.areEqual(this.longValues, ((AggregationResult) other).longValues) && Intrinsics.areEqual(this.doubleValues, ((AggregationResult) other).doubleValues) && Intrinsics.areEqual(this.dataOrigins, ((AggregationResult) other).dataOrigins);
        }
        return false;
    }

    public int hashCode() {
        int result = this.longValues.hashCode();
        return (((result * 31) + this.doubleValues.hashCode()) * 31) + this.dataOrigins.hashCode();
    }

    public String toString() {
        return "AggregationResult(longValues=" + this.longValues + ", doubleValues=" + this.doubleValues + ", dataOrigins=" + this.dataOrigins + ')';
    }
}
