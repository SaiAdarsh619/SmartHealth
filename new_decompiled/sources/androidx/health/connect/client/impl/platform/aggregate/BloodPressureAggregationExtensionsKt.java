package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByPeriod;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.AggregateGroupByPeriodRequest;
import androidx.health.connect.client.request.AggregateRequest;
import androidx.health.connect.client.request.ReadRecordsRequest;
import androidx.health.connect.client.units.Pressure;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: BloodPressureAggregationExtensions.kt */
@Metadata(m286d1 = {"\u0000:\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0080@¢\u0006\u0002\u0010\n\u001a \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005*\u00020\u00072\u0006\u0010\b\u001a\u00020\fH\u0080@¢\u0006\u0002\u0010\r\u001a\u001a\u0010\u0004\u001a\u00020\u000e*\u00020\u00072\u0006\u0010\b\u001a\u00020\u000fH\u0080@¢\u0006\u0002\u0010\u0010\"\u001a\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m287d2 = {"BLOOD_PRESSURE_METRICS", "", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "Landroidx/health/connect/client/units/Pressure;", "aggregateBloodPressure", "", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationResultGroupedByDurationWithMinTime;", "Landroidx/health/connect/client/HealthConnectClient;", "aggregateRequest", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByPeriod;", "Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/health/connect/client/aggregate/AggregationResult;", "Landroidx/health/connect/client/request/AggregateRequest;", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/request/AggregateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class BloodPressureAggregationExtensionsKt {
    private static final Set<AggregateMetric<Pressure>> BLOOD_PRESSURE_METRICS = SetsKt.setOf((Object[]) new AggregateMetric[]{BloodPressureRecord.DIASTOLIC_AVG, BloodPressureRecord.DIASTOLIC_MAX, BloodPressureRecord.DIASTOLIC_MIN, BloodPressureRecord.SYSTOLIC_AVG, BloodPressureRecord.SYSTOLIC_MAX, BloodPressureRecord.SYSTOLIC_MIN});

    public static final Object aggregateBloodPressure(HealthConnectClient $this$aggregateBloodPressure, final AggregateGroupByDurationRequest aggregateRequest, Continuation<? super List<AggregationResultGroupedByDurationWithMinTime>> continuation) {
        return HealthConnectClientAggregationExtensionsKt.aggregate($this$aggregateBloodPressure, new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(BloodPressureRecord.class), aggregateRequest.getTimeRangeFilter(), aggregateRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null), new ResultGroupedByDurationAggregator(TimeRangeFilterUtilsKt.createTimeRange(aggregateRequest.getTimeRangeFilter()), aggregateRequest.getTimeRangeSlicer(), new Function1<InstantTimeRange, AggregationProcessor<BloodPressureRecord>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.BloodPressureAggregationExtensionsKt$aggregateBloodPressure$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AggregationProcessor<BloodPressureRecord> invoke(InstantTimeRange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new BloodPressureAggregationProcessor(AggregateGroupByDurationRequest.this.getMetrics$connect_client_release());
            }
        }), continuation);
    }

    public static final Object aggregateBloodPressure(HealthConnectClient $this$aggregateBloodPressure, final AggregateGroupByPeriodRequest aggregateRequest, Continuation<? super List<AggregationResultGroupedByPeriod>> continuation) {
        return HealthConnectClientAggregationExtensionsKt.aggregate($this$aggregateBloodPressure, new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(BloodPressureRecord.class), aggregateRequest.getTimeRangeFilter(), aggregateRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null), new ResultGroupedByPeriodAggregator(TimeRangeFilterUtilsKt.createLocalTimeRange(aggregateRequest.getTimeRangeFilter()), aggregateRequest.getTimeRangeSlicer(), new Function1<LocalTimeRange, AggregationProcessor<BloodPressureRecord>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.BloodPressureAggregationExtensionsKt$aggregateBloodPressure$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AggregationProcessor<BloodPressureRecord> invoke(LocalTimeRange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new BloodPressureAggregationProcessor(AggregateGroupByPeriodRequest.this.getMetrics$connect_client_release());
            }
        }), continuation);
    }

    public static final Object aggregateBloodPressure(HealthConnectClient $this$aggregateBloodPressure, AggregateRequest aggregateRequest, Continuation<? super AggregationResult> continuation) {
        return HealthConnectClientAggregationExtensionsKt.aggregate($this$aggregateBloodPressure, new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(BloodPressureRecord.class), aggregateRequest.getTimeRangeFilter(), aggregateRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null), new ResultAggregator(TimeRangeFilterUtilsKt.createTimeRange(aggregateRequest.getTimeRangeFilter()), new BloodPressureAggregationProcessor(aggregateRequest.getMetrics$connect_client_release())), continuation);
    }
}
