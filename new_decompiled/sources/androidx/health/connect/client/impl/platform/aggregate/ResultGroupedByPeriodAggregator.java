package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.aggregate.AggregationResultGroupedByPeriod;
import androidx.health.connect.client.impl.platform.TimeExtensionsKt;
import androidx.health.connect.client.records.InstantaneousRecord;
import androidx.health.connect.client.records.IntervalRecord;
import androidx.health.connect.client.records.Record;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResultGroupedByPeriodAggregator.kt */
@Metadata(m286d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003B/\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000b¢\u0006\u0002\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0010H\u0002J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m287d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/ResultGroupedByPeriodAggregator;", "T", "Landroidx/health/connect/client/records/Record;", "Landroidx/health/connect/client/impl/platform/aggregate/Aggregator;", "", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByPeriod;", "timeRange", "Landroidx/health/connect/client/impl/platform/aggregate/LocalTimeRange;", "bucketPeriod", "Ljava/time/Period;", "initProcessor", "Lkotlin/Function1;", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationProcessor;", "(Landroidx/health/connect/client/impl/platform/aggregate/LocalTimeRange;Ljava/time/Period;Lkotlin/jvm/functions/Function1;)V", "bucketProcessors", "", "Ljava/time/LocalDateTime;", "filterAndAggregate", "", "record", "(Landroidx/health/connect/client/records/Record;)V", "getBucketStartTime", "time", "getBucketTimeRange", "bucketStartTime", "getResult", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class ResultGroupedByPeriodAggregator<T extends Record> implements Aggregator<T, List<? extends AggregationResultGroupedByPeriod>> {
    private final Period bucketPeriod;
    private final Map<LocalDateTime, AggregationProcessor<T>> bucketProcessors;
    private final Function1<LocalTimeRange, AggregationProcessor<T>> initProcessor;
    private final LocalTimeRange timeRange;

    /* JADX WARN: Multi-variable type inference failed */
    public ResultGroupedByPeriodAggregator(LocalTimeRange timeRange, Period bucketPeriod, Function1<? super LocalTimeRange, ? extends AggregationProcessor<T>> initProcessor) {
        Intrinsics.checkNotNullParameter(timeRange, "timeRange");
        Intrinsics.checkNotNullParameter(bucketPeriod, "bucketPeriod");
        Intrinsics.checkNotNullParameter(initProcessor, "initProcessor");
        this.timeRange = timeRange;
        this.bucketPeriod = bucketPeriod;
        this.initProcessor = initProcessor;
        this.bucketProcessors = new LinkedHashMap();
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.Aggregator
    public void filterAndAggregate(T record) {
        LocalDateTime bucketStartTime;
        LocalDateTime lastBucketStartTime;
        AggregationProcessor<T> aggregationProcessor;
        Intrinsics.checkNotNullParameter(record, "record");
        if (!AggregatorUtils.INSTANCE.contributesToAggregation$connect_client_release(record, this.timeRange)) {
            return;
        }
        LocalDateTime startTime = this.timeRange.getStartTime();
        if (record instanceof InstantaneousRecord) {
            bucketStartTime = getBucketStartTime(TimeExtensionsKt.toLocalTimeWithDefaultZoneFallback(((InstantaneousRecord) record).getTime(), ((InstantaneousRecord) record).getZoneOffset()));
        } else if (record instanceof IntervalRecord) {
            bucketStartTime = getBucketStartTime(TimeExtensionsKt.toLocalTimeWithDefaultZoneFallback(((IntervalRecord) record).getStartTime(), ((IntervalRecord) record).getStartZoneOffset()));
        } else {
            throw new IllegalStateException(("Unsupported value for aggregation: " + record).toString());
        }
        LocalDateTime bucketStartTime2 = (LocalDateTime) ComparisonsKt.maxOf(startTime, bucketStartTime);
        if (record instanceof InstantaneousRecord) {
            lastBucketStartTime = bucketStartTime2;
        } else if (record instanceof IntervalRecord) {
            lastBucketStartTime = getBucketStartTime(TimeExtensionsKt.toLocalTimeWithDefaultZoneFallback(((IntervalRecord) record).getEndTime(), ((IntervalRecord) record).getEndZoneOffset()));
        } else {
            throw new IllegalStateException(("Unsupported value for aggregation: " + record).toString());
        }
        while (bucketStartTime2.compareTo((ChronoLocalDateTime<?>) lastBucketStartTime) <= 0 && bucketStartTime2.compareTo((ChronoLocalDateTime<?>) this.timeRange.getEndTime()) < 0) {
            LocalTimeRange bucketTimeRange = getBucketTimeRange(bucketStartTime2);
            if (AggregatorUtils.INSTANCE.contributesToAggregation$connect_client_release(record, bucketTimeRange)) {
                Map $this$getOrPut$iv = this.bucketProcessors;
                AggregationProcessor<T> aggregationProcessor2 = $this$getOrPut$iv.get(bucketStartTime2);
                if (aggregationProcessor2 == null) {
                    aggregationProcessor = this.initProcessor.invoke(bucketTimeRange);
                    $this$getOrPut$iv.put(bucketStartTime2, aggregationProcessor);
                } else {
                    aggregationProcessor = aggregationProcessor2;
                }
                aggregationProcessor.processRecord(record);
            }
            LocalDateTime plus = bucketStartTime2.plus((TemporalAmount) this.bucketPeriod);
            Intrinsics.checkNotNullExpressionValue(plus, "bucketStartTime += bucketPeriod");
            bucketStartTime2 = plus;
        }
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.Aggregator
    public List<? extends AggregationResultGroupedByPeriod> getResult() {
        Map $this$map$iv = this.bucketProcessors;
        Collection destination$iv$iv = new ArrayList($this$map$iv.size());
        for (Map.Entry item$iv$iv : $this$map$iv.entrySet()) {
            LocalDateTime startTime = item$iv$iv.getKey();
            AggregationProcessor<T> processor = item$iv$iv.getValue();
            destination$iv$iv.add(new AggregationResultGroupedByPeriod(processor.getProcessedAggregationResult(), startTime, getBucketTimeRange(startTime).getEndTime()));
        }
        return (List) destination$iv$iv;
    }

    private final LocalDateTime getBucketStartTime(LocalDateTime time) {
        LocalDateTime bucketEndTime = this.timeRange.getStartTime();
        while (time.compareTo((ChronoLocalDateTime<?>) bucketEndTime) >= 0) {
            LocalDateTime plus = bucketEndTime.plus((TemporalAmount) this.bucketPeriod);
            Intrinsics.checkNotNullExpressionValue(plus, "bucketEndTime += bucketPeriod");
            bucketEndTime = plus;
        }
        LocalDateTime minus = bucketEndTime.minus((TemporalAmount) this.bucketPeriod);
        Intrinsics.checkNotNullExpressionValue(minus, "bucketEndTime - bucketPeriod");
        return minus;
    }

    private final LocalTimeRange getBucketTimeRange(LocalDateTime bucketStartTime) {
        LocalDateTime bucketEndTime = (LocalDateTime) ComparisonsKt.minOf(bucketStartTime.plus((TemporalAmount) this.bucketPeriod), this.timeRange.getEndTime());
        Intrinsics.checkNotNullExpressionValue(bucketEndTime, "bucketEndTime");
        return new LocalTimeRange(bucketStartTime, bucketEndTime);
    }
}
