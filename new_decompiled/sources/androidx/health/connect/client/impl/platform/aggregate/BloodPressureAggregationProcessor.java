package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.units.Pressure;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: BloodPressureAggregationExtensions.kt */
@Metadata(m286d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0016R \u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00110\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m287d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/BloodPressureAggregationProcessor;", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationProcessor;", "Landroidx/health/connect/client/records/BloodPressureRecord;", "metrics", "", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "(Ljava/util/Set;)V", "avgDataMap", "", "Landroidx/health/connect/client/units/Pressure;", "Landroidx/health/connect/client/impl/platform/aggregate/AvgData;", "dataOrigins", "", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "getMetrics", "()Ljava/util/Set;", "minMaxMap", "", "getProcessedAggregationResult", "Landroidx/health/connect/client/aggregate/AggregationResult;", "processRecord", "", "record", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class BloodPressureAggregationProcessor implements AggregationProcessor<BloodPressureRecord> {
    private final Map<AggregateMetric<Pressure>, AvgData> avgDataMap;
    private final Set<DataOrigin> dataOrigins;
    private final Set<AggregateMetric<?>> metrics;
    private final Map<AggregateMetric<Pressure>, Double> minMaxMap;

    /* JADX WARN: Multi-variable type inference failed */
    public BloodPressureAggregationProcessor(Set<? extends AggregateMetric<?>> metrics) {
        Set set;
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        this.metrics = metrics;
        this.avgDataMap = new LinkedHashMap();
        this.minMaxMap = new LinkedHashMap();
        this.dataOrigins = new LinkedHashSet();
        set = BloodPressureAggregationExtensionsKt.BLOOD_PRESSURE_METRICS;
        if (!set.containsAll(this.metrics)) {
            StringBuilder append = new StringBuilder().append("Invalid set of blood pressure fallback aggregation metrics ");
            Iterable $this$map$iv = this.metrics;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                AggregateMetric it = (AggregateMetric) item$iv$iv;
                destination$iv$iv.add(it.getMetricKey());
            }
            throw new IllegalStateException(append.append((List) destination$iv$iv).toString().toString());
        }
        for (AggregateMetric metric : this.metrics) {
            if (Intrinsics.areEqual(metric, BloodPressureRecord.DIASTOLIC_AVG) ? true : Intrinsics.areEqual(metric, BloodPressureRecord.SYSTOLIC_AVG)) {
                this.avgDataMap.put(metric, new AvgData(0, 0.0d, 3, null));
            } else {
                if (!(Intrinsics.areEqual(metric, BloodPressureRecord.DIASTOLIC_MAX) ? true : Intrinsics.areEqual(metric, BloodPressureRecord.DIASTOLIC_MIN) ? true : Intrinsics.areEqual(metric, BloodPressureRecord.SYSTOLIC_MAX) ? true : Intrinsics.areEqual(metric, BloodPressureRecord.SYSTOLIC_MIN))) {
                    throw new IllegalStateException(("Invalid blood pressure fallback aggregation metric " + metric.getMetricKey()).toString());
                }
                this.minMaxMap.put(metric, null);
            }
        }
    }

    public final Set<AggregateMetric<?>> getMetrics() {
        return this.metrics;
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.AggregationProcessor
    public void processRecord(BloodPressureRecord record) {
        Intrinsics.checkNotNullParameter(record, "record");
        double diastolic = record.getDiastolic().getValue();
        double systolic = record.getSystolic().getValue();
        for (AggregateMetric metric : this.metrics) {
            if (Intrinsics.areEqual(metric, BloodPressureRecord.DIASTOLIC_AVG)) {
                AvgData avgData = this.avgDataMap.get(metric);
                Intrinsics.checkNotNull(avgData);
                avgData.plusAssign(diastolic);
            } else if (Intrinsics.areEqual(metric, BloodPressureRecord.DIASTOLIC_MAX)) {
                Map<AggregateMetric<Pressure>, Double> map = this.minMaxMap;
                Double d = this.minMaxMap.get(metric);
                map.put(metric, Double.valueOf(Math.max(d != null ? d.doubleValue() : diastolic, diastolic)));
            } else if (Intrinsics.areEqual(metric, BloodPressureRecord.DIASTOLIC_MIN)) {
                Map<AggregateMetric<Pressure>, Double> map2 = this.minMaxMap;
                Double d2 = this.minMaxMap.get(metric);
                map2.put(metric, Double.valueOf(Math.min(d2 != null ? d2.doubleValue() : diastolic, diastolic)));
            } else if (Intrinsics.areEqual(metric, BloodPressureRecord.SYSTOLIC_AVG)) {
                AvgData avgData2 = this.avgDataMap.get(metric);
                Intrinsics.checkNotNull(avgData2);
                avgData2.plusAssign(systolic);
            } else if (Intrinsics.areEqual(metric, BloodPressureRecord.SYSTOLIC_MAX)) {
                Map<AggregateMetric<Pressure>, Double> map3 = this.minMaxMap;
                Double d3 = this.minMaxMap.get(metric);
                map3.put(metric, Double.valueOf(Math.max(d3 != null ? d3.doubleValue() : systolic, systolic)));
            } else if (Intrinsics.areEqual(metric, BloodPressureRecord.SYSTOLIC_MIN)) {
                Map<AggregateMetric<Pressure>, Double> map4 = this.minMaxMap;
                Double d4 = this.minMaxMap.get(metric);
                map4.put(metric, Double.valueOf(Math.min(d4 != null ? d4.doubleValue() : systolic, systolic)));
            }
            this.dataOrigins.add(record.getMetadata().getDataOrigin());
        }
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
                if (Intrinsics.areEqual(metric, BloodPressureRecord.DIASTOLIC_AVG) ? true : Intrinsics.areEqual(metric, BloodPressureRecord.SYSTOLIC_AVG)) {
                    AvgData avgData = this.avgDataMap.get(metric);
                    Intrinsics.checkNotNull(avgData);
                    doubleValue = avgData.average();
                } else {
                    if (!(Intrinsics.areEqual(metric, BloodPressureRecord.DIASTOLIC_MAX) ? true : Intrinsics.areEqual(metric, BloodPressureRecord.DIASTOLIC_MIN) ? true : Intrinsics.areEqual(metric, BloodPressureRecord.SYSTOLIC_MAX) ? true : Intrinsics.areEqual(metric, BloodPressureRecord.SYSTOLIC_MIN))) {
                        throw new IllegalStateException(("Invalid blood pressure fallback aggregation type " + metric.getMetricKey()).toString());
                    }
                    Double d = this.minMaxMap.get(metric);
                    Intrinsics.checkNotNull(d);
                    doubleValue = d.doubleValue();
                }
                destination$iv$iv.put(metricKey, Double.valueOf(doubleValue));
            }
            doubleValues = destination$iv$iv;
        }
        return new AggregationResult(MapsKt.emptyMap(), doubleValues, this.dataOrigins);
    }
}
