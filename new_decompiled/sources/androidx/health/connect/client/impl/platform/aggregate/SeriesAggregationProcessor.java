package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.impl.platform.TimeExtensionsKt;
import androidx.health.connect.client.records.SeriesRecord;
import androidx.health.connect.client.records.metadata.DataOrigin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* compiled from: SeriesRecordAggregationExtensions.kt */
@Metadata(m286d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B1\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0002\u0010\u000bJ\b\u0010$\u001a\u00020%H\u0016J\u0015\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010)R\u001a\u0010\f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u0015\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006*"}, m287d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/SeriesAggregationProcessor;", "T", "Landroidx/health/connect/client/records/SeriesRecord;", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationProcessor;", "recordType", "Lkotlin/reflect/KClass;", "metrics", "", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "timeRange", "Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;", "(Lkotlin/reflect/KClass;Ljava/util/Set;Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;)V", "aggregateInfo", "Landroidx/health/connect/client/impl/platform/aggregate/AggregateMetricsInfo;", "", "avgData", "Landroidx/health/connect/client/impl/platform/aggregate/AvgData;", "getAvgData", "()Landroidx/health/connect/client/impl/platform/aggregate/AvgData;", "dataOrigins", "", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "max", "", "getMax", "()Ljava/lang/Double;", "setMax", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getMetrics", "()Ljava/util/Set;", "min", "getMin", "setMin", "getTimeRange", "()Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;", "getProcessedAggregationResult", "Landroidx/health/connect/client/aggregate/AggregationResult;", "processRecord", "", "record", "(Landroidx/health/connect/client/records/SeriesRecord;)V", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class SeriesAggregationProcessor<T extends SeriesRecord<?>> implements AggregationProcessor<T> {
    private final AggregateMetricsInfo<? extends Comparable<?>> aggregateInfo;
    private final AvgData avgData;
    private final Set<DataOrigin> dataOrigins;
    private Double max;
    private final Set<AggregateMetric<?>> metrics;
    private Double min;
    private final TimeRange<?> timeRange;

    /* JADX WARN: Multi-variable type inference failed */
    public SeriesAggregationProcessor(KClass<T> recordType, Set<? extends AggregateMetric<?>> metrics, TimeRange<?> timeRange) {
        Map map;
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(timeRange, "timeRange");
        this.metrics = metrics;
        this.timeRange = timeRange;
        this.avgData = new AvgData(0, 0.0d, 3, null);
        this.dataOrigins = new LinkedHashSet();
        map = SeriesRecordAggregationExtensionsKt.RECORDS_TO_AGGREGATE_METRICS_INFO_MAP;
        AggregateMetricsInfo<? extends Comparable<?>> aggregateMetricsInfo = (AggregateMetricsInfo) map.get(recordType);
        if (aggregateMetricsInfo == null) {
            throw new IllegalArgumentException("Non supported fallback series record " + recordType);
        }
        this.aggregateInfo = aggregateMetricsInfo;
        if (SetsKt.setOf((Object[]) new AggregateMetric[]{this.aggregateInfo.getAverageMetric(), this.aggregateInfo.getMinMetric(), this.aggregateInfo.getMaxMetric()}).containsAll(this.metrics)) {
            return;
        }
        StringBuilder append = new StringBuilder().append("Invalid set of metrics ");
        Iterable $this$map$iv = this.metrics;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            AggregateMetric it = (AggregateMetric) item$iv$iv;
            destination$iv$iv.add(it.getMetricKey());
        }
        throw new IllegalStateException(append.append((List) destination$iv$iv).toString().toString());
    }

    public final Set<AggregateMetric<?>> getMetrics() {
        return this.metrics;
    }

    public final TimeRange<?> getTimeRange() {
        return this.timeRange;
    }

    public final AvgData getAvgData() {
        return this.avgData;
    }

    public final Double getMin() {
        return this.min;
    }

    public final void setMin(Double d) {
        this.min = d;
    }

    public final Double getMax() {
        return this.max;
    }

    public final void setMax(Double d) {
        this.max = d;
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.AggregationProcessor
    public void processRecord(T record) {
        Intrinsics.checkNotNullParameter(record, "record");
        Iterable $this$filter$iv = record.getSamples();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (TimeExtensionsKt.isWithin(AggregatorUtils.INSTANCE.getTime$connect_client_release(element$iv$iv), this.timeRange, record.getStartZoneOffset())) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        for (Object element$iv : $this$forEach$iv) {
            this.avgData.plusAssign(AggregatorUtils.INSTANCE.getValue$connect_client_release(element$iv));
            Double d = this.min;
            this.min = Double.valueOf(Math.min(d != null ? d.doubleValue() : AggregatorUtils.INSTANCE.getValue$connect_client_release(element$iv), AggregatorUtils.INSTANCE.getValue$connect_client_release(element$iv)));
            Double d2 = this.max;
            this.max = Double.valueOf(Math.max(d2 != null ? d2.doubleValue() : AggregatorUtils.INSTANCE.getValue$connect_client_release(element$iv), AggregatorUtils.INSTANCE.getValue$connect_client_release(element$iv)));
        }
        Iterable $this$forEach$iv2 = this.dataOrigins;
        ((Collection) $this$forEach$iv2).add(record.getMetadata().getDataOrigin());
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.AggregationProcessor
    public AggregationResult getProcessedAggregationResult() {
        Map doubleValues;
        double doubleValue;
        if (this.dataOrigins.isEmpty()) {
            doubleValues = MapsKt.emptyMap();
        } else {
            Iterable $this$associateBy$iv = this.metrics;
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
            for (Object element$iv$iv : $this$associateBy$iv) {
                AggregateMetric it = (AggregateMetric) element$iv$iv;
                String metricKey = it.getMetricKey();
                AggregateMetric metric = (AggregateMetric) element$iv$iv;
                if (Intrinsics.areEqual(metric, this.aggregateInfo.getAverageMetric())) {
                    doubleValue = this.avgData.average();
                } else if (Intrinsics.areEqual(metric, this.aggregateInfo.getMaxMetric())) {
                    Double d = this.max;
                    Intrinsics.checkNotNull(d);
                    doubleValue = d.doubleValue();
                } else {
                    if (!Intrinsics.areEqual(metric, this.aggregateInfo.getMinMetric())) {
                        throw new IllegalStateException(("Invalid fallback aggregation metric " + metric.getMetricKey()).toString());
                    }
                    Double d2 = this.min;
                    Intrinsics.checkNotNull(d2);
                    doubleValue = d2.doubleValue();
                }
                destination$iv$iv.put(metricKey, Double.valueOf(doubleValue));
            }
            doubleValues = destination$iv$iv;
        }
        return new AggregationResult(MapsKt.emptyMap(), doubleValues, this.dataOrigins);
    }
}
