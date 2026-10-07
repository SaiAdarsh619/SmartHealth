package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration;
import androidx.health.connect.client.records.InstantaneousRecord;
import androidx.health.connect.client.records.IntervalRecord;
import androidx.health.connect.client.records.Record;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAmount;
import java.time.zone.ZoneRules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResultGroupByDurationAggregator.kt */
@Metadata(m286d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003B3\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u000b¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0011H\u0002J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m287d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/ResultGroupedByDurationAggregator;", "T", "Landroidx/health/connect/client/records/Record;", "Landroidx/health/connect/client/impl/platform/aggregate/Aggregator;", "", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationResultGroupedByDurationWithMinTime;", "timeRange", "Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;", "bucketDuration", "Ljava/time/Duration;", "initProcessor", "Lkotlin/Function1;", "Landroidx/health/connect/client/impl/platform/aggregate/InstantTimeRange;", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationProcessor;", "(Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;Ljava/time/Duration;Lkotlin/jvm/functions/Function1;)V", "bucketProcessors", "", "Ljava/time/Instant;", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationProcessorWithZoneOffset;", "instantTimeRange", "filterAndAggregate", "", "record", "(Landroidx/health/connect/client/records/Record;)V", "getBucketStartTime", "time", "getBucketTimeRange", "bucketStartTime", "getResult", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class ResultGroupedByDurationAggregator<T extends Record> implements Aggregator<T, List<? extends AggregationResultGroupedByDurationWithMinTime>> {
    private final Duration bucketDuration;
    private final Map<Instant, AggregationProcessorWithZoneOffset<T>> bucketProcessors;
    private final Function1<InstantTimeRange, AggregationProcessor<T>> initProcessor;
    private final InstantTimeRange instantTimeRange;
    private final TimeRange<?> timeRange;

    /* JADX WARN: Multi-variable type inference failed */
    public ResultGroupedByDurationAggregator(TimeRange<?> timeRange, Duration bucketDuration, Function1<? super InstantTimeRange, ? extends AggregationProcessor<T>> initProcessor) {
        InstantTimeRange instantTimeRange;
        Intrinsics.checkNotNullParameter(timeRange, "timeRange");
        Intrinsics.checkNotNullParameter(bucketDuration, "bucketDuration");
        Intrinsics.checkNotNullParameter(initProcessor, "initProcessor");
        this.timeRange = timeRange;
        this.bucketDuration = bucketDuration;
        this.initProcessor = initProcessor;
        TimeRange<?> timeRange2 = this.timeRange;
        if (timeRange2 instanceof InstantTimeRange) {
            instantTimeRange = (InstantTimeRange) this.timeRange;
        } else {
            if (!(timeRange2 instanceof LocalTimeRange)) {
                throw new NoWhenBranchMatchedException();
            }
            Instant instant = ((LocalTimeRange) this.timeRange).getStartTime().toInstant(ZoneOffset.MAX);
            Intrinsics.checkNotNullExpressionValue(instant, "timeRange.startTime.toInstant(ZoneOffset.MAX)");
            Instant instant2 = ((LocalTimeRange) this.timeRange).getEndTime().toInstant(ZoneOffset.MIN);
            Intrinsics.checkNotNullExpressionValue(instant2, "timeRange.endTime.toInstant(ZoneOffset.MIN)");
            instantTimeRange = new InstantTimeRange(instant, instant2);
        }
        this.instantTimeRange = instantTimeRange;
        this.bucketProcessors = new LinkedHashMap();
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.Aggregator
    public void filterAndAggregate(T record) {
        Instant bucketStartTime;
        Instant lastBucketStartTime;
        Object answer$iv;
        Intrinsics.checkNotNullParameter(record, "record");
        if (!AggregatorUtils.INSTANCE.contributesToAggregation$connect_client_release(record, this.timeRange)) {
            return;
        }
        Instant startTime = this.instantTimeRange.getStartTime();
        if (record instanceof InstantaneousRecord) {
            bucketStartTime = getBucketStartTime(((InstantaneousRecord) record).getTime());
        } else {
            if (!(record instanceof IntervalRecord)) {
                throw new IllegalStateException(("Unsupported value for aggregation: " + record).toString());
            }
            bucketStartTime = getBucketStartTime(((IntervalRecord) record).getStartTime());
        }
        Comparable maxOf = ComparisonsKt.maxOf(startTime, bucketStartTime);
        if (record instanceof InstantaneousRecord) {
            lastBucketStartTime = (Instant) maxOf;
        } else {
            if (!(record instanceof IntervalRecord)) {
                throw new IllegalStateException(("Unsupported value for aggregation: " + record).toString());
            }
            lastBucketStartTime = getBucketStartTime(((IntervalRecord) record).getEndTime());
        }
        while (((Instant) maxOf).compareTo(lastBucketStartTime) <= 0 && ((Instant) maxOf).compareTo(this.instantTimeRange.getEndTime()) < 0) {
            InstantTimeRange bucketTimeRange = getBucketTimeRange((Instant) maxOf);
            if (AggregatorUtils.INSTANCE.contributesToAggregation$connect_client_release(record, bucketTimeRange)) {
                Map $this$getOrPut$iv = this.bucketProcessors;
                Comparable comparable = maxOf;
                Object value$iv = $this$getOrPut$iv.get(comparable);
                if (value$iv == null) {
                    answer$iv = new AggregationProcessorWithZoneOffset(this.initProcessor.invoke(bucketTimeRange), (Instant) maxOf);
                    $this$getOrPut$iv.put(comparable, answer$iv);
                } else {
                    answer$iv = value$iv;
                }
                ((AggregationProcessorWithZoneOffset) answer$iv).processRecord(record);
            }
            Instant plus = ((Instant) maxOf).plus((TemporalAmount) this.bucketDuration);
            Intrinsics.checkNotNullExpressionValue(plus, "bucketStartTime += bucketDuration");
            maxOf = plus;
        }
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.Aggregator
    public List<? extends AggregationResultGroupedByDurationWithMinTime> getResult() {
        ResultGroupedByDurationAggregator<T> resultGroupedByDurationAggregator = this;
        Iterable $this$map$iv = resultGroupedByDurationAggregator.bucketProcessors.values();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            AggregationProcessorWithZoneOffset it = (AggregationProcessorWithZoneOffset) item$iv$iv;
            InstantTimeRange bucketTimeRange = resultGroupedByDurationAggregator.getBucketTimeRange(it.getBucketStartTime());
            ZoneOffset zoneOffset = it.getZoneOffset();
            if (zoneOffset == null) {
                ZoneRules rules = ZoneId.systemDefault().getRules();
                Instant minTime = it.getMinTime();
                if (minTime == null) {
                    minTime = Instant.now();
                }
                zoneOffset = rules.getOffset(minTime);
            }
            AggregationResult processedAggregationResult = it.getProcessedAggregationResult();
            Instant startTime = bucketTimeRange.getStartTime();
            Instant endTime = bucketTimeRange.getEndTime();
            Iterable $this$map$iv2 = $this$map$iv;
            Intrinsics.checkNotNullExpressionValue(zoneOffset, "zoneOffset");
            AggregationResultGroupedByDuration aggregationResultGroupedByDuration = new AggregationResultGroupedByDuration(processedAggregationResult, startTime, endTime, zoneOffset);
            Instant minTime2 = it.getMinTime();
            if (minTime2 == null) {
                minTime2 = Instant.MAX;
            }
            Intrinsics.checkNotNullExpressionValue(minTime2, "it.minTime ?: Instant.MAX");
            destination$iv$iv.add(new AggregationResultGroupedByDurationWithMinTime(aggregationResultGroupedByDuration, minTime2));
            resultGroupedByDurationAggregator = this;
            $this$map$iv = $this$map$iv2;
        }
        return (List) destination$iv$iv;
    }

    private final Instant getBucketStartTime(Instant time) {
        Instant plus = this.instantTimeRange.getStartTime().plus((TemporalAmount) this.bucketDuration.multipliedBy(Duration.between(this.instantTimeRange.getStartTime(), time).dividedBy(this.bucketDuration)));
        Intrinsics.checkNotNullExpressionValue(plus, "instantTimeRange.startTi…etDuration)\n            )");
        return plus;
    }

    private final InstantTimeRange getBucketTimeRange(Instant bucketStartTime) {
        Instant bucketEndTime = (Instant) ComparisonsKt.minOf(bucketStartTime.plus((TemporalAmount) this.bucketDuration), this.instantTimeRange.getEndTime());
        Intrinsics.checkNotNullExpressionValue(bucketEndTime, "bucketEndTime");
        return new InstantTimeRange(bucketStartTime, bucketEndTime);
    }
}
