package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByPeriod;
import androidx.health.connect.client.records.CyclingPedalingCadenceRecord;
import androidx.health.connect.client.records.SeriesRecord;
import androidx.health.connect.client.records.SpeedRecord;
import androidx.health.connect.client.records.StepsCadenceRecord;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.AggregateGroupByPeriodRequest;
import androidx.health.connect.client.request.AggregateRequest;
import androidx.health.connect.client.request.ReadRecordsRequest;
import java.time.Duration;
import java.time.Period;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: SeriesRecordAggregationExtensions.kt */
@Metadata(m286d1 = {"\u0000H\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\"\u000e\b\u0000\u0010\n\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0003*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0080H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000f0\b\"\u000e\b\u0000\u0010\n\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0003*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0010H\u0080H¢\u0006\u0002\u0010\u0011\u001a*\u0010\u0007\u001a\u00020\u0012\"\u000e\b\u0000\u0010\n\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0003*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0013H\u0080H¢\u0006\u0002\u0010\u0014\"4\u0010\u0000\u001a(\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u00050\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m287d2 = {"RECORDS_TO_AGGREGATE_METRICS_INFO_MAP", "", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/SeriesRecord;", "", "Landroidx/health/connect/client/impl/platform/aggregate/AggregateMetricsInfo;", "", "aggregateSeries", "", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationResultGroupedByDurationWithMinTime;", "T", "Landroidx/health/connect/client/HealthConnectClient;", "aggregateRequest", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByPeriod;", "Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/health/connect/client/aggregate/AggregationResult;", "Landroidx/health/connect/client/request/AggregateRequest;", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/request/AggregateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class SeriesRecordAggregationExtensionsKt {
    private static final Map<KClass<? extends SeriesRecord<Object>>, AggregateMetricsInfo<? extends Comparable<?>>> RECORDS_TO_AGGREGATE_METRICS_INFO_MAP = MapsKt.mapOf(TuplesKt.m294to(Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class), new AggregateMetricsInfo(CyclingPedalingCadenceRecord.RPM_AVG, CyclingPedalingCadenceRecord.RPM_MIN, CyclingPedalingCadenceRecord.RPM_MAX)), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(SpeedRecord.class), new AggregateMetricsInfo(SpeedRecord.SPEED_AVG, SpeedRecord.SPEED_MIN, SpeedRecord.SPEED_MAX)), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class), new AggregateMetricsInfo(StepsCadenceRecord.RATE_AVG, StepsCadenceRecord.RATE_MIN, StepsCadenceRecord.RATE_MAX)));

    public static final /* synthetic */ <T extends SeriesRecord<?>> Object aggregateSeries(HealthConnectClient $this$aggregateSeries, AggregateRequest aggregateRequest, Continuation<? super AggregationResult> continuation) {
        TimeRange timeRange = TimeRangeFilterUtilsKt.createTimeRange(aggregateRequest.getTimeRangeFilter());
        Intrinsics.reifiedOperationMarker(4, "T");
        ReadRecordsRequest readRecordsRequest = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(SeriesRecord.class), TimeRangeFilterUtilsKt.withBufferedStart(aggregateRequest.getTimeRangeFilter()), aggregateRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null);
        Intrinsics.reifiedOperationMarker(4, "T");
        ResultAggregator resultAggregator = new ResultAggregator(timeRange, new SeriesAggregationProcessor(Reflection.getOrCreateKotlinClass(SeriesRecord.class), aggregateRequest.getMetrics$connect_client_release(), timeRange));
        InlineMarker.mark(0);
        Object aggregate = HealthConnectClientAggregationExtensionsKt.aggregate($this$aggregateSeries, readRecordsRequest, resultAggregator, continuation);
        InlineMarker.mark(1);
        return aggregate;
    }

    public static final /* synthetic */ <T extends SeriesRecord<?>> Object aggregateSeries(HealthConnectClient $this$aggregateSeries, final AggregateGroupByPeriodRequest aggregateRequest, Continuation<? super List<AggregationResultGroupedByPeriod>> continuation) {
        Intrinsics.reifiedOperationMarker(4, "T");
        ReadRecordsRequest readRecordsRequest = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(SeriesRecord.class), TimeRangeFilterUtilsKt.withBufferedStart(aggregateRequest.getTimeRangeFilter()), aggregateRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null);
        LocalTimeRange createLocalTimeRange = TimeRangeFilterUtilsKt.createLocalTimeRange(aggregateRequest.getTimeRangeFilter());
        Period timeRangeSlicer = aggregateRequest.getTimeRangeSlicer();
        Intrinsics.needClassReification();
        ResultGroupedByPeriodAggregator resultGroupedByPeriodAggregator = new ResultGroupedByPeriodAggregator(createLocalTimeRange, timeRangeSlicer, new Function1<LocalTimeRange, AggregationProcessor<T>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.SeriesRecordAggregationExtensionsKt$aggregateSeries$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AggregationProcessor<T> invoke(LocalTimeRange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Intrinsics.reifiedOperationMarker(4, "T");
                return new SeriesAggregationProcessor(Reflection.getOrCreateKotlinClass(SeriesRecord.class), AggregateGroupByPeriodRequest.this.getMetrics$connect_client_release(), it);
            }
        });
        InlineMarker.mark(0);
        Object aggregate = HealthConnectClientAggregationExtensionsKt.aggregate($this$aggregateSeries, readRecordsRequest, resultGroupedByPeriodAggregator, continuation);
        InlineMarker.mark(1);
        return aggregate;
    }

    public static final /* synthetic */ <T extends SeriesRecord<?>> Object aggregateSeries(HealthConnectClient $this$aggregateSeries, final AggregateGroupByDurationRequest aggregateRequest, Continuation<? super List<AggregationResultGroupedByDurationWithMinTime>> continuation) {
        Intrinsics.reifiedOperationMarker(4, "T");
        ReadRecordsRequest readRecordsRequest = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(SeriesRecord.class), TimeRangeFilterUtilsKt.withBufferedStart(aggregateRequest.getTimeRangeFilter()), aggregateRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null);
        TimeRange<?> createTimeRange = TimeRangeFilterUtilsKt.createTimeRange(aggregateRequest.getTimeRangeFilter());
        Duration timeRangeSlicer = aggregateRequest.getTimeRangeSlicer();
        Intrinsics.needClassReification();
        ResultGroupedByDurationAggregator resultGroupedByDurationAggregator = new ResultGroupedByDurationAggregator(createTimeRange, timeRangeSlicer, new Function1<InstantTimeRange, AggregationProcessor<T>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.SeriesRecordAggregationExtensionsKt$aggregateSeries$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AggregationProcessor<T> invoke(InstantTimeRange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Intrinsics.reifiedOperationMarker(4, "T");
                return new SeriesAggregationProcessor(Reflection.getOrCreateKotlinClass(SeriesRecord.class), AggregateGroupByDurationRequest.this.getMetrics$connect_client_release(), it);
            }
        });
        InlineMarker.mark(0);
        Object aggregate = HealthConnectClientAggregationExtensionsKt.aggregate($this$aggregateSeries, readRecordsRequest, resultGroupedByDurationAggregator, continuation);
        InlineMarker.mark(1);
        return aggregate;
    }
}
