package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByPeriod;
import androidx.health.connect.client.records.NutritionRecord;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.AggregateGroupByPeriodRequest;
import androidx.health.connect.client.request.AggregateRequest;
import androidx.health.connect.client.request.ReadRecordsRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: NutritionAggregationExtensions.kt */
@Metadata(m286d1 = {"\u0000,\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0080@¢\u0006\u0002\u0010\u0006\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH\u0080@¢\u0006\u0002\u0010\t\u001a\u001a\u0010\u0000\u001a\u00020\n*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH\u0080@¢\u0006\u0002\u0010\f¨\u0006\r"}, m287d2 = {"aggregateNutritionTransFatTotal", "", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationResultGroupedByDurationWithMinTime;", "Landroidx/health/connect/client/HealthConnectClient;", "aggregateRequest", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByPeriod;", "Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/health/connect/client/aggregate/AggregationResult;", "Landroidx/health/connect/client/request/AggregateRequest;", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/request/AggregateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class NutritionAggregationExtensionsKt {
    public static final Object aggregateNutritionTransFatTotal(HealthConnectClient $this$aggregateNutritionTransFatTotal, AggregateRequest aggregateRequest, Continuation<? super AggregationResult> continuation) {
        TimeRange timeRange = TimeRangeFilterUtilsKt.createTimeRange(aggregateRequest.getTimeRangeFilter());
        return HealthConnectClientAggregationExtensionsKt.aggregate($this$aggregateNutritionTransFatTotal, new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(NutritionRecord.class), TimeRangeFilterUtilsKt.withBufferedStart(aggregateRequest.getTimeRangeFilter()), aggregateRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null), new ResultAggregator(timeRange, new TransFatTotalAggregationProcessor(timeRange)), continuation);
    }

    public static final Object aggregateNutritionTransFatTotal(HealthConnectClient $this$aggregateNutritionTransFatTotal, AggregateGroupByPeriodRequest aggregateRequest, Continuation<? super List<AggregationResultGroupedByPeriod>> continuation) {
        return HealthConnectClientAggregationExtensionsKt.aggregate($this$aggregateNutritionTransFatTotal, new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(NutritionRecord.class), TimeRangeFilterUtilsKt.withBufferedStart(aggregateRequest.getTimeRangeFilter()), aggregateRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null), new ResultGroupedByPeriodAggregator(TimeRangeFilterUtilsKt.createLocalTimeRange(aggregateRequest.getTimeRangeFilter()), aggregateRequest.getTimeRangeSlicer(), new Function1<LocalTimeRange, AggregationProcessor<NutritionRecord>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.NutritionAggregationExtensionsKt$aggregateNutritionTransFatTotal$3
            @Override // kotlin.jvm.functions.Function1
            public final AggregationProcessor<NutritionRecord> invoke(LocalTimeRange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new TransFatTotalAggregationProcessor(it);
            }
        }), continuation);
    }

    public static final Object aggregateNutritionTransFatTotal(HealthConnectClient $this$aggregateNutritionTransFatTotal, AggregateGroupByDurationRequest aggregateRequest, Continuation<? super List<AggregationResultGroupedByDurationWithMinTime>> continuation) {
        return HealthConnectClientAggregationExtensionsKt.aggregate($this$aggregateNutritionTransFatTotal, new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(NutritionRecord.class), TimeRangeFilterUtilsKt.withBufferedStart(aggregateRequest.getTimeRangeFilter()), aggregateRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null), new ResultGroupedByDurationAggregator(TimeRangeFilterUtilsKt.createTimeRange(aggregateRequest.getTimeRangeFilter()), aggregateRequest.getTimeRangeSlicer(), new Function1<InstantTimeRange, AggregationProcessor<NutritionRecord>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.NutritionAggregationExtensionsKt$aggregateNutritionTransFatTotal$5
            @Override // kotlin.jvm.functions.Function1
            public final AggregationProcessor<NutritionRecord> invoke(InstantTimeRange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new TransFatTotalAggregationProcessor(it);
            }
        }), continuation);
    }
}
