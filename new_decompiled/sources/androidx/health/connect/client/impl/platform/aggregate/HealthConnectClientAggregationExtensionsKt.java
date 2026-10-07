package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByPeriod;
import androidx.health.connect.client.impl.converters.datatype.RecordsTypeNameMapKt;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.records.CyclingPedalingCadenceRecord;
import androidx.health.connect.client.records.NutritionRecord;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.SpeedRecord;
import androidx.health.connect.client.records.StepsCadenceRecord;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.AggregateGroupByPeriodRequest;
import androidx.health.connect.client.request.AggregateRequest;
import androidx.health.connect.client.request.ReadRecordsRequest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: HealthConnectClientAggregationExtensions.kt */
@Metadata(m286d1 = {"\u0000R\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aD\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\u0004\b\u0001\u0010\u0005*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00050\u000bH\u0080@¢\u0006\u0002\u0010\f\u001a \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0080@¢\u0006\u0002\u0010\u0012\u001a \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0014H\u0080@¢\u0006\u0002\u0010\u0015\u001a\u001a\u0010\r\u001a\u00020\u0016*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0017H\u0080@¢\u0006\u0002\u0010\u0018\u001a0\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000e0\u001a\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0000\"\u001c\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m287d2 = {"AGGREGATION_FALLBACK_RECORD_TYPES", "", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/Record;", "aggregate", "R", "T", "Landroidx/health/connect/client/HealthConnectClient;", "readRecordsRequest", "Landroidx/health/connect/client/request/ReadRecordsRequest;", "aggregator", "Landroidx/health/connect/client/impl/platform/aggregate/Aggregator;", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/request/ReadRecordsRequest;Landroidx/health/connect/client/impl/platform/aggregate/Aggregator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aggregateFallback", "", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "request", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByPeriod;", "Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/health/connect/client/aggregate/AggregationResult;", "Landroidx/health/connect/client/request/AggregateRequest;", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/request/AggregateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRecordsFlow", "Lkotlinx/coroutines/flow/Flow;", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class HealthConnectClientAggregationExtensionsKt {
    private static final Set<KClass<? extends Record>> AGGREGATION_FALLBACK_RECORD_TYPES = SetsKt.setOf((Object[]) new KClass[]{Reflection.getOrCreateKotlinClass(BloodPressureRecord.class), Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class), Reflection.getOrCreateKotlinClass(NutritionRecord.class), Reflection.getOrCreateKotlinClass(SpeedRecord.class), Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class)});

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0348 -> B:12:0x0354). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object aggregateFallback(HealthConnectClient $this$aggregateFallback, AggregateRequest request, Continuation<? super AggregationResult> continuation) {
        HealthConnectClientAggregationExtensionsKt$aggregateFallback$1 healthConnectClientAggregationExtensionsKt$aggregateFallback$1;
        HealthConnectClient $this$aggregateFallback2;
        Iterator it;
        HealthConnectClient $this$aggregateFallback3;
        Map $this$mapTo$iv$iv;
        Collection destination$iv$iv;
        Collection destination$iv$iv2;
        Object obj;
        Object $result;
        AggregationResult aggregationResult;
        HealthConnectClient healthConnectClient;
        Object accumulator$iv;
        int i;
        Continuation $completion = continuation;
        if ($completion instanceof HealthConnectClientAggregationExtensionsKt$aggregateFallback$1) {
            healthConnectClientAggregationExtensionsKt$aggregateFallback$1 = (HealthConnectClientAggregationExtensionsKt$aggregateFallback$1) $completion;
            if ((healthConnectClientAggregationExtensionsKt$aggregateFallback$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientAggregationExtensionsKt$aggregateFallback$1.label -= Integer.MIN_VALUE;
                Object $result2 = healthConnectClientAggregationExtensionsKt$aggregateFallback$1.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int $i$f$map = 1;
                switch (healthConnectClientAggregationExtensionsKt$aggregateFallback$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        Iterable $this$associateWith$iv = AGGREGATION_FALLBACK_RECORD_TYPES;
                        Map result$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv, 10)), 16));
                        for (Object element$iv$iv : $this$associateWith$iv) {
                            final KClass recordType = (KClass) element$iv$iv;
                            result$iv.put(element$iv$iv, AggregationExtensionsKt.withFilteredMetrics(request, new Function1<AggregateMetric<?>, Boolean>() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$aggregationResult$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(AggregateMetric<?> it2) {
                                    Intrinsics.checkNotNullParameter(it2, "it");
                                    String dataTypeName = it2.getDataTypeName();
                                    String str = RecordsTypeNameMapKt.getRECORDS_CLASS_NAME_MAP().get(recordType);
                                    Intrinsics.checkNotNull(str);
                                    return Boolean.valueOf(Intrinsics.areEqual(dataTypeName, str));
                                }
                            }));
                        }
                        Map $this$filterValues$iv = result$iv;
                        LinkedHashMap result$iv2 = new LinkedHashMap();
                        for (Map.Entry entry$iv : $this$filterValues$iv.entrySet()) {
                            AggregateRequest it2 = (AggregateRequest) entry$iv.getValue();
                            AggregateRequest it3 = !it2.getMetrics$connect_client_release().isEmpty() ? 1 : null;
                            if (it3 != null) {
                                result$iv2.put(entry$iv.getKey(), entry$iv.getValue());
                            }
                        }
                        LinkedHashMap $this$map$iv = result$iv2;
                        Collection destination$iv$iv3 = new ArrayList($this$map$iv.size());
                        $this$aggregateFallback2 = $this$aggregateFallback;
                        it = $this$map$iv.entrySet().iterator();
                        $this$aggregateFallback3 = null;
                        $this$mapTo$iv$iv = null;
                        destination$iv$iv = destination$iv$iv3;
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            KClass recordType2 = (KClass) entry.getKey();
                            AggregateRequest recordTypeRequest = (AggregateRequest) entry.getValue();
                            if (Intrinsics.areEqual(recordType2, Reflection.getOrCreateKotlinClass(BloodPressureRecord.class))) {
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$0 = $this$aggregateFallback2;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$1 = destination$iv$iv;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$2 = it;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$3 = destination$iv$iv;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$1.label = $i$f$map;
                                Object $result4 = BloodPressureAggregationExtensionsKt.aggregateBloodPressure($this$aggregateFallback2, recordTypeRequest, healthConnectClientAggregationExtensionsKt$aggregateFallback$1);
                                if ($result4 == $result3) {
                                    return $result3;
                                }
                                destination$iv$iv2 = destination$iv$iv;
                                Object obj2 = $result3;
                                $result = $result2;
                                Map map = $this$mapTo$iv$iv;
                                HealthConnectClient healthConnectClient2 = $this$aggregateFallback3;
                                obj = obj2;
                                aggregationResult = (AggregationResult) $result4;
                                healthConnectClient = healthConnectClient2;
                                $this$mapTo$iv$iv = map;
                            } else if (Intrinsics.areEqual(recordType2, Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class))) {
                                TimeRange timeRange$iv = TimeRangeFilterUtilsKt.createTimeRange(recordTypeRequest.getTimeRangeFilter());
                                ReadRecordsRequest readRecordsRequest = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class), TimeRangeFilterUtilsKt.withBufferedStart(recordTypeRequest.getTimeRangeFilter()), recordTypeRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null);
                                Continuation $completion2 = $completion;
                                Object $result5 = $result2;
                                HealthConnectClient healthConnectClient3 = $this$aggregateFallback3;
                                Map map2 = $this$mapTo$iv$iv;
                                ResultAggregator resultAggregator = new ResultAggregator(timeRange$iv, new SeriesAggregationProcessor(Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class), recordTypeRequest.getMetrics$connect_client_release(), timeRange$iv));
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$0 = $this$aggregateFallback2;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$1 = destination$iv$iv;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$2 = it;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$3 = destination$iv$iv;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$1.label = 2;
                                Object aggregate = aggregate($this$aggregateFallback2, readRecordsRequest, resultAggregator, healthConnectClientAggregationExtensionsKt$aggregateFallback$1);
                                if (aggregate == $result3) {
                                    return $result3;
                                }
                                $completion = $completion2;
                                healthConnectClient = healthConnectClient3;
                                obj = $result3;
                                destination$iv$iv2 = destination$iv$iv;
                                $this$mapTo$iv$iv = map2;
                                $result = $result5;
                                aggregationResult = (AggregationResult) aggregate;
                            } else {
                                Continuation $completion3 = $completion;
                                Object $result6 = $result2;
                                HealthConnectClient healthConnectClient4 = $this$aggregateFallback3;
                                Map map3 = $this$mapTo$iv$iv;
                                if (Intrinsics.areEqual(recordType2, Reflection.getOrCreateKotlinClass(NutritionRecord.class))) {
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$0 = $this$aggregateFallback2;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$1 = destination$iv$iv;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$2 = it;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$3 = destination$iv$iv;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$1.label = 3;
                                    Object aggregateNutritionTransFatTotal = NutritionAggregationExtensionsKt.aggregateNutritionTransFatTotal($this$aggregateFallback2, recordTypeRequest, healthConnectClientAggregationExtensionsKt$aggregateFallback$1);
                                    if (aggregateNutritionTransFatTotal == $result3) {
                                        return $result3;
                                    }
                                    $completion = $completion3;
                                    healthConnectClient = healthConnectClient4;
                                    obj = $result3;
                                    Collection collection = destination$iv$iv;
                                    $this$mapTo$iv$iv = map3;
                                    $result = $result6;
                                    aggregationResult = (AggregationResult) aggregateNutritionTransFatTotal;
                                    $this$aggregateFallback2 = $this$aggregateFallback2;
                                    destination$iv$iv2 = collection;
                                    it = it;
                                    destination$iv$iv = collection;
                                } else if (Intrinsics.areEqual(recordType2, Reflection.getOrCreateKotlinClass(SpeedRecord.class))) {
                                    TimeRange timeRange$iv2 = TimeRangeFilterUtilsKt.createTimeRange(recordTypeRequest.getTimeRangeFilter());
                                    ReadRecordsRequest readRecordsRequest2 = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(SpeedRecord.class), TimeRangeFilterUtilsKt.withBufferedStart(recordTypeRequest.getTimeRangeFilter()), recordTypeRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null);
                                    ResultAggregator resultAggregator2 = new ResultAggregator(timeRange$iv2, new SeriesAggregationProcessor(Reflection.getOrCreateKotlinClass(SpeedRecord.class), recordTypeRequest.getMetrics$connect_client_release(), timeRange$iv2));
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$0 = $this$aggregateFallback2;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$1 = destination$iv$iv;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$2 = it;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$3 = destination$iv$iv;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$1.label = 4;
                                    Object aggregate2 = aggregate($this$aggregateFallback2, readRecordsRequest2, resultAggregator2, healthConnectClientAggregationExtensionsKt$aggregateFallback$1);
                                    if (aggregate2 == $result3) {
                                        return $result3;
                                    }
                                    $completion = $completion3;
                                    healthConnectClient = healthConnectClient4;
                                    destination$iv$iv2 = destination$iv$iv;
                                    $this$mapTo$iv$iv = map3;
                                    obj = $result3;
                                    $result = $result6;
                                    aggregationResult = (AggregationResult) aggregate2;
                                } else {
                                    if (!Intrinsics.areEqual(recordType2, Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class))) {
                                        throw new IllegalStateException(("Invalid record type for aggregation fallback: " + recordType2).toString());
                                    }
                                    TimeRange timeRange$iv3 = TimeRangeFilterUtilsKt.createTimeRange(recordTypeRequest.getTimeRangeFilter());
                                    ReadRecordsRequest readRecordsRequest3 = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class), TimeRangeFilterUtilsKt.withBufferedStart(recordTypeRequest.getTimeRangeFilter()), recordTypeRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null);
                                    ResultAggregator resultAggregator3 = new ResultAggregator(timeRange$iv3, new SeriesAggregationProcessor(Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class), recordTypeRequest.getMetrics$connect_client_release(), timeRange$iv3));
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$0 = $this$aggregateFallback2;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$1 = destination$iv$iv;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$2 = it;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$3 = destination$iv$iv;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$1.label = 5;
                                    $result2 = aggregate($this$aggregateFallback2, readRecordsRequest3, resultAggregator3, healthConnectClientAggregationExtensionsKt$aggregateFallback$1);
                                    if ($result2 == $result3) {
                                        return $result3;
                                    }
                                    $completion = $completion3;
                                    healthConnectClient = healthConnectClient4;
                                    i = 0;
                                    destination$iv$iv2 = destination$iv$iv;
                                    $this$mapTo$iv$iv = map3;
                                    obj = $result3;
                                    $result = $result6;
                                    aggregationResult = (AggregationResult) $result2;
                                }
                            }
                            destination$iv$iv.add(aggregationResult);
                            $result2 = $result;
                            $result3 = obj;
                            $this$aggregateFallback3 = healthConnectClient;
                            destination$iv$iv = destination$iv$iv2;
                            $i$f$map = 1;
                            if (it.hasNext()) {
                                Iterable $this$reduceOrNull$iv = (List) destination$iv$iv;
                                Iterator iterator$iv = $this$reduceOrNull$iv.iterator();
                                if (iterator$iv.hasNext()) {
                                    accumulator$iv = iterator$iv.next();
                                    while (iterator$iv.hasNext()) {
                                        AggregationResult p1 = (AggregationResult) iterator$iv.next();
                                        AggregationResult p0 = (AggregationResult) accumulator$iv;
                                        accumulator$iv = p0.plus$connect_client_release(p1);
                                    }
                                } else {
                                    accumulator$iv = null;
                                }
                                AggregationResult aggregationResult2 = (AggregationResult) accumulator$iv;
                                return aggregationResult2 == null ? new AggregationResult(MapsKt.emptyMap(), MapsKt.emptyMap(), SetsKt.emptySet()) : aggregationResult2;
                            }
                        }
                    case 1:
                        Collection collection2 = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$3;
                        Iterator it4 = (Iterator) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$2;
                        Collection destination$iv$iv4 = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$1;
                        HealthConnectClient $this$aggregateFallback4 = (HealthConnectClient) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        $this$aggregateFallback2 = $this$aggregateFallback4;
                        destination$iv$iv2 = destination$iv$iv4;
                        it = it4;
                        destination$iv$iv = collection2;
                        obj = $result3;
                        $result = $result2;
                        aggregationResult = (AggregationResult) $result2;
                        healthConnectClient = null;
                        $this$mapTo$iv$iv = null;
                        destination$iv$iv.add(aggregationResult);
                        $result2 = $result;
                        $result3 = obj;
                        $this$aggregateFallback3 = healthConnectClient;
                        destination$iv$iv = destination$iv$iv2;
                        $i$f$map = 1;
                        if (it.hasNext()) {
                        }
                        break;
                    case 2:
                        $this$mapTo$iv$iv = null;
                        destination$iv$iv = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$3;
                        it = (Iterator) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$2;
                        destination$iv$iv2 = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$1;
                        $this$aggregateFallback2 = (HealthConnectClient) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        healthConnectClient = null;
                        obj = $result3;
                        $result = $result2;
                        aggregationResult = (AggregationResult) $result2;
                        destination$iv$iv.add(aggregationResult);
                        $result2 = $result;
                        $result3 = obj;
                        $this$aggregateFallback3 = healthConnectClient;
                        destination$iv$iv = destination$iv$iv2;
                        $i$f$map = 1;
                        if (it.hasNext()) {
                        }
                        break;
                    case 3:
                        $this$mapTo$iv$iv = null;
                        Collection collection3 = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$3;
                        Iterator it5 = (Iterator) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$2;
                        Collection destination$iv$iv5 = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$1;
                        HealthConnectClient $this$aggregateFallback5 = (HealthConnectClient) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        healthConnectClient = null;
                        obj = $result3;
                        $result = $result2;
                        aggregationResult = (AggregationResult) $result2;
                        $this$aggregateFallback2 = $this$aggregateFallback5;
                        destination$iv$iv2 = destination$iv$iv5;
                        it = it5;
                        destination$iv$iv = collection3;
                        destination$iv$iv.add(aggregationResult);
                        $result2 = $result;
                        $result3 = obj;
                        $this$aggregateFallback3 = healthConnectClient;
                        destination$iv$iv = destination$iv$iv2;
                        $i$f$map = 1;
                        if (it.hasNext()) {
                        }
                        break;
                    case 4:
                        $this$mapTo$iv$iv = null;
                        destination$iv$iv = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$3;
                        it = (Iterator) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$2;
                        destination$iv$iv2 = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$1;
                        $this$aggregateFallback2 = (HealthConnectClient) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        healthConnectClient = null;
                        obj = $result3;
                        $result = $result2;
                        aggregationResult = (AggregationResult) $result2;
                        destination$iv$iv.add(aggregationResult);
                        $result2 = $result;
                        $result3 = obj;
                        $this$aggregateFallback3 = healthConnectClient;
                        destination$iv$iv = destination$iv$iv2;
                        $i$f$map = 1;
                        if (it.hasNext()) {
                        }
                        break;
                    case 5:
                        $this$mapTo$iv$iv = null;
                        i = 0;
                        destination$iv$iv = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$3;
                        it = (Iterator) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$2;
                        destination$iv$iv2 = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$1;
                        $this$aggregateFallback2 = (HealthConnectClient) healthConnectClientAggregationExtensionsKt$aggregateFallback$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        healthConnectClient = null;
                        obj = $result3;
                        $result = $result2;
                        aggregationResult = (AggregationResult) $result2;
                        destination$iv$iv.add(aggregationResult);
                        $result2 = $result;
                        $result3 = obj;
                        $this$aggregateFallback3 = healthConnectClient;
                        destination$iv$iv = destination$iv$iv2;
                        $i$f$map = 1;
                        if (it.hasNext()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        healthConnectClientAggregationExtensionsKt$aggregateFallback$1 = new HealthConnectClientAggregationExtensionsKt$aggregateFallback$1($completion);
        Object $result22 = healthConnectClientAggregationExtensionsKt$aggregateFallback$1.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int $i$f$map2 = 1;
        switch (healthConnectClientAggregationExtensionsKt$aggregateFallback$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x02f6 -> B:12:0x02fd). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object aggregateFallback(HealthConnectClient $this$aggregateFallback, AggregateGroupByPeriodRequest request, Continuation<? super List<AggregationResultGroupedByPeriod>> continuation) {
        HealthConnectClientAggregationExtensionsKt$aggregateFallback$2 healthConnectClientAggregationExtensionsKt$aggregateFallback$2;
        HealthConnectClient $this$aggregateFallback2;
        Iterator it;
        HealthConnectClient $this$aggregateFallback3;
        Collection destination$iv$iv;
        HealthConnectClient healthConnectClient;
        Object obj;
        Object $result;
        Iterable $result2;
        Grouping $this$aggregateTo$iv$iv$iv;
        HealthConnectClientAggregationExtensionsKt$aggregateFallback$2 healthConnectClientAggregationExtensionsKt$aggregateFallback$22;
        int $i$f$reduce;
        int $i$f$aggregate;
        Continuation $completion = continuation;
        if ($completion instanceof HealthConnectClientAggregationExtensionsKt$aggregateFallback$2) {
            healthConnectClientAggregationExtensionsKt$aggregateFallback$2 = (HealthConnectClientAggregationExtensionsKt$aggregateFallback$2) $completion;
            if ((healthConnectClientAggregationExtensionsKt$aggregateFallback$2.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientAggregationExtensionsKt$aggregateFallback$2.label -= Integer.MIN_VALUE;
                Object $result3 = healthConnectClientAggregationExtensionsKt$aggregateFallback$2.result;
                Object $result4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = 1;
                switch (healthConnectClientAggregationExtensionsKt$aggregateFallback$2.label) {
                    case 0:
                        ResultKt.throwOnFailure($result3);
                        Iterable $this$associateWith$iv = AGGREGATION_FALLBACK_RECORD_TYPES;
                        Map result$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv, 10)), 16));
                        for (Object element$iv$iv : $this$associateWith$iv) {
                            final KClass recordType = (KClass) element$iv$iv;
                            result$iv.put(element$iv$iv, AggregationExtensionsKt.withFilteredMetrics(request, new Function1<AggregateMetric<?>, Boolean>() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(AggregateMetric<?> it2) {
                                    Intrinsics.checkNotNullParameter(it2, "it");
                                    String dataTypeName = it2.getDataTypeName();
                                    String str = RecordsTypeNameMapKt.getRECORDS_CLASS_NAME_MAP().get(recordType);
                                    Intrinsics.checkNotNull(str);
                                    return Boolean.valueOf(Intrinsics.areEqual(dataTypeName, str));
                                }
                            }));
                        }
                        Map $this$filterValues$iv = result$iv;
                        LinkedHashMap result$iv2 = new LinkedHashMap();
                        for (Map.Entry entry$iv : $this$filterValues$iv.entrySet()) {
                            AggregateGroupByPeriodRequest it2 = (AggregateGroupByPeriodRequest) entry$iv.getValue();
                            AggregateGroupByPeriodRequest it3 = !it2.getMetrics$connect_client_release().isEmpty() ? 1 : null;
                            if (it3 != null) {
                                result$iv2.put(entry$iv.getKey(), entry$iv.getValue());
                            }
                        }
                        LinkedHashMap $this$flatMapTo$iv$iv = result$iv2;
                        Collection destination$iv$iv2 = new ArrayList();
                        $this$aggregateFallback2 = $this$aggregateFallback;
                        it = $this$flatMapTo$iv$iv.entrySet().iterator();
                        $this$aggregateFallback3 = null;
                        destination$iv$iv = destination$iv$iv2;
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            KClass recordType2 = (KClass) entry.getKey();
                            final AggregateGroupByPeriodRequest recordTypeRequest = (AggregateGroupByPeriodRequest) entry.getValue();
                            if (Intrinsics.areEqual(recordType2, Reflection.getOrCreateKotlinClass(BloodPressureRecord.class))) {
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$0 = $this$aggregateFallback2;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$1 = destination$iv$iv;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$2 = it;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$2.label = i;
                                Object $result5 = BloodPressureAggregationExtensionsKt.aggregateBloodPressure($this$aggregateFallback2, recordTypeRequest, healthConnectClientAggregationExtensionsKt$aggregateFallback$2);
                                if ($result5 == $result4) {
                                    return $result4;
                                }
                                Object obj2 = $result4;
                                $result = $result3;
                                healthConnectClient = $this$aggregateFallback3;
                                obj = obj2;
                                $result2 = (List) $result5;
                                $this$aggregateFallback2 = $this$aggregateFallback2;
                                destination$iv$iv = destination$iv$iv;
                                it = it;
                            } else if (Intrinsics.areEqual(recordType2, Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class))) {
                                ReadRecordsRequest readRecordsRequest = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class), TimeRangeFilterUtilsKt.withBufferedStart(recordTypeRequest.getTimeRangeFilter()), recordTypeRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null);
                                Continuation $completion2 = $completion;
                                Object $result6 = $result3;
                                HealthConnectClient healthConnectClient2 = $this$aggregateFallback3;
                                ResultGroupedByPeriodAggregator resultGroupedByPeriodAggregator = new ResultGroupedByPeriodAggregator(TimeRangeFilterUtilsKt.createLocalTimeRange(recordTypeRequest.getTimeRangeFilter()), recordTypeRequest.getTimeRangeSlicer(), new Function1<LocalTimeRange, AggregationProcessor<CyclingPedalingCadenceRecord>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$lambda$5$$inlined$aggregateSeries$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final AggregationProcessor<CyclingPedalingCadenceRecord> invoke(LocalTimeRange it4) {
                                        Intrinsics.checkNotNullParameter(it4, "it");
                                        return new SeriesAggregationProcessor(Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class), AggregateGroupByPeriodRequest.this.getMetrics$connect_client_release(), it4);
                                    }
                                });
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$0 = $this$aggregateFallback2;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$1 = destination$iv$iv;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$2 = it;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$2.label = 2;
                                Object aggregate = aggregate($this$aggregateFallback2, readRecordsRequest, resultGroupedByPeriodAggregator, healthConnectClientAggregationExtensionsKt$aggregateFallback$2);
                                if (aggregate == $result4) {
                                    return $result4;
                                }
                                $completion = $completion2;
                                healthConnectClient = healthConnectClient2;
                                obj = $result4;
                                $result = $result6;
                                $result2 = (List) aggregate;
                            } else {
                                Continuation $completion3 = $completion;
                                Object $result7 = $result3;
                                HealthConnectClient healthConnectClient3 = $this$aggregateFallback3;
                                if (Intrinsics.areEqual(recordType2, Reflection.getOrCreateKotlinClass(NutritionRecord.class))) {
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$0 = $this$aggregateFallback2;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$1 = destination$iv$iv;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$2 = it;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$2.label = 3;
                                    Object aggregateNutritionTransFatTotal = NutritionAggregationExtensionsKt.aggregateNutritionTransFatTotal($this$aggregateFallback2, recordTypeRequest, healthConnectClientAggregationExtensionsKt$aggregateFallback$2);
                                    if (aggregateNutritionTransFatTotal == $result4) {
                                        return $result4;
                                    }
                                    $completion = $completion3;
                                    healthConnectClient = healthConnectClient3;
                                    obj = $result4;
                                    $result = $result7;
                                    $result2 = (List) aggregateNutritionTransFatTotal;
                                    $this$aggregateFallback2 = $this$aggregateFallback2;
                                    destination$iv$iv = destination$iv$iv;
                                    it = it;
                                } else if (Intrinsics.areEqual(recordType2, Reflection.getOrCreateKotlinClass(SpeedRecord.class))) {
                                    ReadRecordsRequest readRecordsRequest2 = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(SpeedRecord.class), TimeRangeFilterUtilsKt.withBufferedStart(recordTypeRequest.getTimeRangeFilter()), recordTypeRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null);
                                    ResultGroupedByPeriodAggregator resultGroupedByPeriodAggregator2 = new ResultGroupedByPeriodAggregator(TimeRangeFilterUtilsKt.createLocalTimeRange(recordTypeRequest.getTimeRangeFilter()), recordTypeRequest.getTimeRangeSlicer(), new Function1<LocalTimeRange, AggregationProcessor<SpeedRecord>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$lambda$5$$inlined$aggregateSeries$2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final AggregationProcessor<SpeedRecord> invoke(LocalTimeRange it4) {
                                            Intrinsics.checkNotNullParameter(it4, "it");
                                            return new SeriesAggregationProcessor(Reflection.getOrCreateKotlinClass(SpeedRecord.class), AggregateGroupByPeriodRequest.this.getMetrics$connect_client_release(), it4);
                                        }
                                    });
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$0 = $this$aggregateFallback2;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$1 = destination$iv$iv;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$2 = it;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$2.label = 4;
                                    Object aggregate2 = aggregate($this$aggregateFallback2, readRecordsRequest2, resultGroupedByPeriodAggregator2, healthConnectClientAggregationExtensionsKt$aggregateFallback$2);
                                    if (aggregate2 == $result4) {
                                        return $result4;
                                    }
                                    $completion = $completion3;
                                    healthConnectClient = healthConnectClient3;
                                    obj = $result4;
                                    $result = $result7;
                                    $result2 = (List) aggregate2;
                                } else {
                                    if (!Intrinsics.areEqual(recordType2, Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class))) {
                                        throw new IllegalStateException(("Invalid record type for aggregation fallback: " + recordType2).toString());
                                    }
                                    ReadRecordsRequest readRecordsRequest3 = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class), TimeRangeFilterUtilsKt.withBufferedStart(recordTypeRequest.getTimeRangeFilter()), recordTypeRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null);
                                    ResultGroupedByPeriodAggregator resultGroupedByPeriodAggregator3 = new ResultGroupedByPeriodAggregator(TimeRangeFilterUtilsKt.createLocalTimeRange(recordTypeRequest.getTimeRangeFilter()), recordTypeRequest.getTimeRangeSlicer(), new Function1<LocalTimeRange, AggregationProcessor<StepsCadenceRecord>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$lambda$5$$inlined$aggregateSeries$3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final AggregationProcessor<StepsCadenceRecord> invoke(LocalTimeRange it4) {
                                            Intrinsics.checkNotNullParameter(it4, "it");
                                            return new SeriesAggregationProcessor(Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class), AggregateGroupByPeriodRequest.this.getMetrics$connect_client_release(), it4);
                                        }
                                    });
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$0 = $this$aggregateFallback2;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$1 = destination$iv$iv;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$2 = it;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$2.label = 5;
                                    $result3 = aggregate($this$aggregateFallback2, readRecordsRequest3, resultGroupedByPeriodAggregator3, healthConnectClientAggregationExtensionsKt$aggregateFallback$2);
                                    if ($result3 == $result4) {
                                        return $result4;
                                    }
                                    $completion = $completion3;
                                    healthConnectClient = healthConnectClient3;
                                    obj = $result4;
                                    $result = $result7;
                                    $result2 = (List) $result3;
                                }
                            }
                            Iterable list$iv$iv = $result2;
                            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
                            $result3 = $result;
                            $result4 = obj;
                            $this$aggregateFallback3 = healthConnectClient;
                            i = 1;
                            if (it.hasNext()) {
                                final Iterable $this$groupingBy$iv = (List) destination$iv$iv;
                                Grouping $this$aggregateTo$iv$iv$iv2 = new Grouping<AggregationResultGroupedByPeriod, LocalDateTime>() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$$inlined$groupingBy$1
                                    @Override // kotlin.collections.Grouping
                                    public Iterator<AggregationResultGroupedByPeriod> sourceIterator() {
                                        return $this$groupingBy$iv.iterator();
                                    }

                                    @Override // kotlin.collections.Grouping
                                    public LocalDateTime keyOf(AggregationResultGroupedByPeriod element) {
                                        AggregationResultGroupedByPeriod it4 = element;
                                        return it4.getStartTime();
                                    }
                                };
                                int $i$f$reduce2 = 0;
                                int $i$f$aggregate2 = 0;
                                Map destination$iv$iv$iv = new LinkedHashMap();
                                Iterator<AggregationResultGroupedByPeriod> sourceIterator = $this$aggregateTo$iv$iv$iv2.sourceIterator();
                                while (sourceIterator.hasNext()) {
                                    AggregationResultGroupedByPeriod next = sourceIterator.next();
                                    LocalDateTime keyOf = $this$aggregateTo$iv$iv$iv2.keyOf(next);
                                    Object accumulator$iv$iv$iv = destination$iv$iv$iv.get(keyOf);
                                    boolean first$iv = accumulator$iv$iv$iv == null && !destination$iv$iv$iv.containsKey(keyOf);
                                    if (first$iv) {
                                        $this$aggregateTo$iv$iv$iv = $this$aggregateTo$iv$iv$iv2;
                                        healthConnectClientAggregationExtensionsKt$aggregateFallback$22 = healthConnectClientAggregationExtensionsKt$aggregateFallback$2;
                                        $i$f$reduce = $i$f$reduce2;
                                        $i$f$aggregate = $i$f$aggregate2;
                                    } else {
                                        AggregationResultGroupedByPeriod element = next;
                                        AggregationResultGroupedByPeriod accumulator = (AggregationResultGroupedByPeriod) accumulator$iv$iv$iv;
                                        $this$aggregateTo$iv$iv$iv = $this$aggregateTo$iv$iv$iv2;
                                        healthConnectClientAggregationExtensionsKt$aggregateFallback$22 = healthConnectClientAggregationExtensionsKt$aggregateFallback$2;
                                        $i$f$reduce = $i$f$reduce2;
                                        $i$f$aggregate = $i$f$aggregate2;
                                        next = new AggregationResultGroupedByPeriod(accumulator.getResult().plus$connect_client_release(element.getResult()), accumulator.getStartTime(), accumulator.getEndTime());
                                    }
                                    destination$iv$iv$iv.put(keyOf, next);
                                    $this$aggregateTo$iv$iv$iv2 = $this$aggregateTo$iv$iv$iv;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$2 = healthConnectClientAggregationExtensionsKt$aggregateFallback$22;
                                    $i$f$reduce2 = $i$f$reduce;
                                    $i$f$aggregate2 = $i$f$aggregate;
                                }
                                Iterable $this$sortedBy$iv = destination$iv$iv$iv.values();
                                return CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$$inlined$sortedBy$1
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // java.util.Comparator
                                    public final int compare(T t, T t2) {
                                        AggregationResultGroupedByPeriod it4 = (AggregationResultGroupedByPeriod) t;
                                        AggregationResultGroupedByPeriod it5 = (AggregationResultGroupedByPeriod) t2;
                                        return ComparisonsKt.compareValues(it4.getStartTime(), it5.getStartTime());
                                    }
                                });
                            }
                        }
                        break;
                    case 1:
                        Iterator it4 = (Iterator) healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$2;
                        Collection destination$iv$iv3 = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$1;
                        HealthConnectClient $this$aggregateFallback4 = (HealthConnectClient) healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$0;
                        ResultKt.throwOnFailure($result3);
                        healthConnectClient = null;
                        obj = $result4;
                        $result = $result3;
                        $result2 = (List) $result3;
                        $this$aggregateFallback2 = $this$aggregateFallback4;
                        destination$iv$iv = destination$iv$iv3;
                        it = it4;
                        Iterable list$iv$iv2 = $result2;
                        CollectionsKt.addAll(destination$iv$iv, list$iv$iv2);
                        $result3 = $result;
                        $result4 = obj;
                        $this$aggregateFallback3 = healthConnectClient;
                        i = 1;
                        if (it.hasNext()) {
                        }
                        break;
                    case 2:
                        it = (Iterator) healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$2;
                        destination$iv$iv = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$1;
                        $this$aggregateFallback2 = (HealthConnectClient) healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$0;
                        ResultKt.throwOnFailure($result3);
                        healthConnectClient = null;
                        obj = $result4;
                        $result = $result3;
                        $result2 = (List) $result3;
                        Iterable list$iv$iv22 = $result2;
                        CollectionsKt.addAll(destination$iv$iv, list$iv$iv22);
                        $result3 = $result;
                        $result4 = obj;
                        $this$aggregateFallback3 = healthConnectClient;
                        i = 1;
                        if (it.hasNext()) {
                        }
                        break;
                    case 3:
                        Iterator it5 = (Iterator) healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$2;
                        Collection destination$iv$iv4 = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$1;
                        HealthConnectClient $this$aggregateFallback5 = (HealthConnectClient) healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$0;
                        ResultKt.throwOnFailure($result3);
                        healthConnectClient = null;
                        obj = $result4;
                        $result = $result3;
                        $result2 = (List) $result3;
                        $this$aggregateFallback2 = $this$aggregateFallback5;
                        destination$iv$iv = destination$iv$iv4;
                        it = it5;
                        Iterable list$iv$iv222 = $result2;
                        CollectionsKt.addAll(destination$iv$iv, list$iv$iv222);
                        $result3 = $result;
                        $result4 = obj;
                        $this$aggregateFallback3 = healthConnectClient;
                        i = 1;
                        if (it.hasNext()) {
                        }
                        break;
                    case 4:
                        it = (Iterator) healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$2;
                        destination$iv$iv = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$1;
                        $this$aggregateFallback2 = (HealthConnectClient) healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$0;
                        ResultKt.throwOnFailure($result3);
                        healthConnectClient = null;
                        obj = $result4;
                        $result = $result3;
                        $result2 = (List) $result3;
                        Iterable list$iv$iv2222 = $result2;
                        CollectionsKt.addAll(destination$iv$iv, list$iv$iv2222);
                        $result3 = $result;
                        $result4 = obj;
                        $this$aggregateFallback3 = healthConnectClient;
                        i = 1;
                        if (it.hasNext()) {
                        }
                        break;
                    case 5:
                        it = (Iterator) healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$2;
                        destination$iv$iv = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$1;
                        $this$aggregateFallback2 = (HealthConnectClient) healthConnectClientAggregationExtensionsKt$aggregateFallback$2.L$0;
                        ResultKt.throwOnFailure($result3);
                        healthConnectClient = null;
                        obj = $result4;
                        $result = $result3;
                        $result2 = (List) $result3;
                        Iterable list$iv$iv22222 = $result2;
                        CollectionsKt.addAll(destination$iv$iv, list$iv$iv22222);
                        $result3 = $result;
                        $result4 = obj;
                        $this$aggregateFallback3 = healthConnectClient;
                        i = 1;
                        if (it.hasNext()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        healthConnectClientAggregationExtensionsKt$aggregateFallback$2 = new HealthConnectClientAggregationExtensionsKt$aggregateFallback$2($completion);
        Object $result32 = healthConnectClientAggregationExtensionsKt$aggregateFallback$2.result;
        Object $result42 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = 1;
        switch (healthConnectClientAggregationExtensionsKt$aggregateFallback$2.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x02f6 -> B:12:0x02fd). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object aggregateFallback(HealthConnectClient $this$aggregateFallback, AggregateGroupByDurationRequest request, Continuation<? super List<AggregationResultGroupedByDuration>> continuation) {
        HealthConnectClientAggregationExtensionsKt$aggregateFallback$9 healthConnectClientAggregationExtensionsKt$aggregateFallback$9;
        HealthConnectClient $this$aggregateFallback2;
        Iterator it;
        HealthConnectClient $this$aggregateFallback3;
        Collection destination$iv$iv;
        HealthConnectClient healthConnectClient;
        Object obj;
        Object $result;
        Iterable $result2;
        Grouping $this$aggregateTo$iv$iv$iv;
        HealthConnectClientAggregationExtensionsKt$aggregateFallback$9 healthConnectClientAggregationExtensionsKt$aggregateFallback$92;
        int $i$f$reduce;
        int $i$f$aggregate;
        int $i$f$aggregateTo;
        Continuation $completion = continuation;
        if ($completion instanceof HealthConnectClientAggregationExtensionsKt$aggregateFallback$9) {
            healthConnectClientAggregationExtensionsKt$aggregateFallback$9 = (HealthConnectClientAggregationExtensionsKt$aggregateFallback$9) $completion;
            if ((healthConnectClientAggregationExtensionsKt$aggregateFallback$9.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientAggregationExtensionsKt$aggregateFallback$9.label -= Integer.MIN_VALUE;
                Object $result3 = healthConnectClientAggregationExtensionsKt$aggregateFallback$9.result;
                Object $result4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = 1;
                switch (healthConnectClientAggregationExtensionsKt$aggregateFallback$9.label) {
                    case 0:
                        ResultKt.throwOnFailure($result3);
                        Iterable $this$associateWith$iv = AGGREGATION_FALLBACK_RECORD_TYPES;
                        Map result$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv, 10)), 16));
                        for (Object element$iv$iv : $this$associateWith$iv) {
                            final KClass recordType = (KClass) element$iv$iv;
                            result$iv.put(element$iv$iv, AggregationExtensionsKt.withFilteredMetrics(request, new Function1<AggregateMetric<?>, Boolean>() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$10$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(AggregateMetric<?> it2) {
                                    Intrinsics.checkNotNullParameter(it2, "it");
                                    String dataTypeName = it2.getDataTypeName();
                                    String str = RecordsTypeNameMapKt.getRECORDS_CLASS_NAME_MAP().get(recordType);
                                    Intrinsics.checkNotNull(str);
                                    return Boolean.valueOf(Intrinsics.areEqual(dataTypeName, str));
                                }
                            }));
                        }
                        Map $this$filterValues$iv = result$iv;
                        LinkedHashMap result$iv2 = new LinkedHashMap();
                        for (Map.Entry entry$iv : $this$filterValues$iv.entrySet()) {
                            AggregateGroupByDurationRequest it2 = (AggregateGroupByDurationRequest) entry$iv.getValue();
                            AggregateGroupByDurationRequest it3 = !it2.getMetrics$connect_client_release().isEmpty() ? 1 : null;
                            if (it3 != null) {
                                result$iv2.put(entry$iv.getKey(), entry$iv.getValue());
                            }
                        }
                        LinkedHashMap $this$flatMapTo$iv$iv = result$iv2;
                        Collection destination$iv$iv2 = new ArrayList();
                        $this$aggregateFallback2 = $this$aggregateFallback;
                        it = $this$flatMapTo$iv$iv.entrySet().iterator();
                        $this$aggregateFallback3 = null;
                        destination$iv$iv = destination$iv$iv2;
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            KClass recordType2 = (KClass) entry.getKey();
                            final AggregateGroupByDurationRequest recordTypeRequest = (AggregateGroupByDurationRequest) entry.getValue();
                            if (Intrinsics.areEqual(recordType2, Reflection.getOrCreateKotlinClass(BloodPressureRecord.class))) {
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$0 = $this$aggregateFallback2;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$1 = destination$iv$iv;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$2 = it;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$9.label = i;
                                Object $result5 = BloodPressureAggregationExtensionsKt.aggregateBloodPressure($this$aggregateFallback2, recordTypeRequest, healthConnectClientAggregationExtensionsKt$aggregateFallback$9);
                                if ($result5 == $result4) {
                                    return $result4;
                                }
                                Object obj2 = $result4;
                                $result = $result3;
                                healthConnectClient = $this$aggregateFallback3;
                                obj = obj2;
                                $result2 = (List) $result5;
                                $this$aggregateFallback2 = $this$aggregateFallback2;
                                destination$iv$iv = destination$iv$iv;
                                it = it;
                            } else if (Intrinsics.areEqual(recordType2, Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class))) {
                                ReadRecordsRequest readRecordsRequest = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class), TimeRangeFilterUtilsKt.withBufferedStart(recordTypeRequest.getTimeRangeFilter()), recordTypeRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null);
                                Continuation $completion2 = $completion;
                                Object $result6 = $result3;
                                HealthConnectClient healthConnectClient2 = $this$aggregateFallback3;
                                ResultGroupedByDurationAggregator resultGroupedByDurationAggregator = new ResultGroupedByDurationAggregator(TimeRangeFilterUtilsKt.createTimeRange(recordTypeRequest.getTimeRangeFilter()), recordTypeRequest.getTimeRangeSlicer(), new Function1<InstantTimeRange, AggregationProcessor<CyclingPedalingCadenceRecord>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$lambda$11$$inlined$aggregateSeries$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final AggregationProcessor<CyclingPedalingCadenceRecord> invoke(InstantTimeRange it4) {
                                        Intrinsics.checkNotNullParameter(it4, "it");
                                        return new SeriesAggregationProcessor(Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class), AggregateGroupByDurationRequest.this.getMetrics$connect_client_release(), it4);
                                    }
                                });
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$0 = $this$aggregateFallback2;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$1 = destination$iv$iv;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$2 = it;
                                healthConnectClientAggregationExtensionsKt$aggregateFallback$9.label = 2;
                                Object aggregate = aggregate($this$aggregateFallback2, readRecordsRequest, resultGroupedByDurationAggregator, healthConnectClientAggregationExtensionsKt$aggregateFallback$9);
                                if (aggregate == $result4) {
                                    return $result4;
                                }
                                $completion = $completion2;
                                healthConnectClient = healthConnectClient2;
                                obj = $result4;
                                $result = $result6;
                                $result2 = (List) aggregate;
                            } else {
                                Continuation $completion3 = $completion;
                                Object $result7 = $result3;
                                HealthConnectClient healthConnectClient3 = $this$aggregateFallback3;
                                if (Intrinsics.areEqual(recordType2, Reflection.getOrCreateKotlinClass(NutritionRecord.class))) {
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$0 = $this$aggregateFallback2;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$1 = destination$iv$iv;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$2 = it;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$9.label = 3;
                                    Object aggregateNutritionTransFatTotal = NutritionAggregationExtensionsKt.aggregateNutritionTransFatTotal($this$aggregateFallback2, recordTypeRequest, healthConnectClientAggregationExtensionsKt$aggregateFallback$9);
                                    if (aggregateNutritionTransFatTotal == $result4) {
                                        return $result4;
                                    }
                                    $completion = $completion3;
                                    healthConnectClient = healthConnectClient3;
                                    obj = $result4;
                                    $result = $result7;
                                    $result2 = (List) aggregateNutritionTransFatTotal;
                                    $this$aggregateFallback2 = $this$aggregateFallback2;
                                    destination$iv$iv = destination$iv$iv;
                                    it = it;
                                } else if (Intrinsics.areEqual(recordType2, Reflection.getOrCreateKotlinClass(SpeedRecord.class))) {
                                    ReadRecordsRequest readRecordsRequest2 = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(SpeedRecord.class), TimeRangeFilterUtilsKt.withBufferedStart(recordTypeRequest.getTimeRangeFilter()), recordTypeRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null);
                                    ResultGroupedByDurationAggregator resultGroupedByDurationAggregator2 = new ResultGroupedByDurationAggregator(TimeRangeFilterUtilsKt.createTimeRange(recordTypeRequest.getTimeRangeFilter()), recordTypeRequest.getTimeRangeSlicer(), new Function1<InstantTimeRange, AggregationProcessor<SpeedRecord>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$lambda$11$$inlined$aggregateSeries$2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final AggregationProcessor<SpeedRecord> invoke(InstantTimeRange it4) {
                                            Intrinsics.checkNotNullParameter(it4, "it");
                                            return new SeriesAggregationProcessor(Reflection.getOrCreateKotlinClass(SpeedRecord.class), AggregateGroupByDurationRequest.this.getMetrics$connect_client_release(), it4);
                                        }
                                    });
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$0 = $this$aggregateFallback2;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$1 = destination$iv$iv;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$2 = it;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$9.label = 4;
                                    Object aggregate2 = aggregate($this$aggregateFallback2, readRecordsRequest2, resultGroupedByDurationAggregator2, healthConnectClientAggregationExtensionsKt$aggregateFallback$9);
                                    if (aggregate2 == $result4) {
                                        return $result4;
                                    }
                                    $completion = $completion3;
                                    healthConnectClient = healthConnectClient3;
                                    obj = $result4;
                                    $result = $result7;
                                    $result2 = (List) aggregate2;
                                } else {
                                    if (!Intrinsics.areEqual(recordType2, Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class))) {
                                        throw new IllegalStateException(("Invalid record type for aggregation fallback: " + recordType2).toString());
                                    }
                                    ReadRecordsRequest readRecordsRequest3 = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class), TimeRangeFilterUtilsKt.withBufferedStart(recordTypeRequest.getTimeRangeFilter()), recordTypeRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null);
                                    ResultGroupedByDurationAggregator resultGroupedByDurationAggregator3 = new ResultGroupedByDurationAggregator(TimeRangeFilterUtilsKt.createTimeRange(recordTypeRequest.getTimeRangeFilter()), recordTypeRequest.getTimeRangeSlicer(), new Function1<InstantTimeRange, AggregationProcessor<StepsCadenceRecord>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$lambda$11$$inlined$aggregateSeries$3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final AggregationProcessor<StepsCadenceRecord> invoke(InstantTimeRange it4) {
                                            Intrinsics.checkNotNullParameter(it4, "it");
                                            return new SeriesAggregationProcessor(Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class), AggregateGroupByDurationRequest.this.getMetrics$connect_client_release(), it4);
                                        }
                                    });
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$0 = $this$aggregateFallback2;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$1 = destination$iv$iv;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$2 = it;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$9.label = 5;
                                    $result3 = aggregate($this$aggregateFallback2, readRecordsRequest3, resultGroupedByDurationAggregator3, healthConnectClientAggregationExtensionsKt$aggregateFallback$9);
                                    if ($result3 == $result4) {
                                        return $result4;
                                    }
                                    $completion = $completion3;
                                    healthConnectClient = healthConnectClient3;
                                    obj = $result4;
                                    $result = $result7;
                                    $result2 = (List) $result3;
                                }
                            }
                            Iterable list$iv$iv = $result2;
                            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
                            $result3 = $result;
                            $result4 = obj;
                            $this$aggregateFallback3 = healthConnectClient;
                            i = 1;
                            if (it.hasNext()) {
                                final Iterable $this$groupingBy$iv = (List) destination$iv$iv;
                                Grouping $this$aggregateTo$iv$iv$iv2 = new Grouping<AggregationResultGroupedByDurationWithMinTime, Instant>() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$$inlined$groupingBy$2
                                    @Override // kotlin.collections.Grouping
                                    public Iterator<AggregationResultGroupedByDurationWithMinTime> sourceIterator() {
                                        return $this$groupingBy$iv.iterator();
                                    }

                                    @Override // kotlin.collections.Grouping
                                    public Instant keyOf(AggregationResultGroupedByDurationWithMinTime element) {
                                        AggregationResultGroupedByDurationWithMinTime it4 = element;
                                        return it4.getAggregationResultGroupedByDuration().getStartTime();
                                    }
                                };
                                int $i$f$reduce2 = 0;
                                int $i$f$aggregate2 = 0;
                                Map destination$iv$iv$iv = new LinkedHashMap();
                                int $i$f$aggregateTo2 = 0;
                                Iterator<AggregationResultGroupedByDurationWithMinTime> sourceIterator = $this$aggregateTo$iv$iv$iv2.sourceIterator();
                                while (sourceIterator.hasNext()) {
                                    AggregationResultGroupedByDurationWithMinTime next = sourceIterator.next();
                                    Instant keyOf = $this$aggregateTo$iv$iv$iv2.keyOf(next);
                                    Object accumulator$iv$iv$iv = destination$iv$iv$iv.get(keyOf);
                                    boolean first$iv = accumulator$iv$iv$iv == null && !destination$iv$iv$iv.containsKey(keyOf);
                                    if (first$iv) {
                                        $this$aggregateTo$iv$iv$iv = $this$aggregateTo$iv$iv$iv2;
                                        healthConnectClientAggregationExtensionsKt$aggregateFallback$92 = healthConnectClientAggregationExtensionsKt$aggregateFallback$9;
                                        $i$f$reduce = $i$f$reduce2;
                                        $i$f$aggregate = $i$f$aggregate2;
                                        $i$f$aggregateTo = $i$f$aggregateTo2;
                                    } else {
                                        AggregationResultGroupedByDurationWithMinTime element = next;
                                        AggregationResultGroupedByDurationWithMinTime accumulator = (AggregationResultGroupedByDurationWithMinTime) accumulator$iv$iv$iv;
                                        Instant startTime = keyOf;
                                        $this$aggregateTo$iv$iv$iv = $this$aggregateTo$iv$iv$iv2;
                                        healthConnectClientAggregationExtensionsKt$aggregateFallback$92 = healthConnectClientAggregationExtensionsKt$aggregateFallback$9;
                                        $i$f$reduce = $i$f$reduce2;
                                        $i$f$aggregate = $i$f$aggregate2;
                                        $i$f$aggregateTo = $i$f$aggregateTo2;
                                        next = new AggregationResultGroupedByDurationWithMinTime(new AggregationResultGroupedByDuration(accumulator.getAggregationResultGroupedByDuration().getResult().plus$connect_client_release(element.getAggregationResultGroupedByDuration().getResult()), startTime, accumulator.getAggregationResultGroupedByDuration().getEndTime(), ((AggregationResultGroupedByDurationWithMinTime) ComparisonsKt.minOf(accumulator, element, (Comparator<? super AggregationResultGroupedByDurationWithMinTime>) new Comparator() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$lambda$14$$inlined$compareBy$1
                                            /* JADX WARN: Multi-variable type inference failed */
                                            @Override // java.util.Comparator
                                            public final int compare(T t, T t2) {
                                                AggregationResultGroupedByDurationWithMinTime it4 = (AggregationResultGroupedByDurationWithMinTime) t;
                                                Instant minTime = it4.getMinTime();
                                                AggregationResultGroupedByDurationWithMinTime it5 = (AggregationResultGroupedByDurationWithMinTime) t2;
                                                return ComparisonsKt.compareValues(minTime, it5.getMinTime());
                                            }
                                        })).getAggregationResultGroupedByDuration().getZoneOffset()), (Instant) ComparisonsKt.minOf(accumulator.getMinTime(), element.getMinTime()));
                                    }
                                    destination$iv$iv$iv.put(keyOf, next);
                                    $this$aggregateTo$iv$iv$iv2 = $this$aggregateTo$iv$iv$iv;
                                    $i$f$aggregateTo2 = $i$f$aggregateTo;
                                    healthConnectClientAggregationExtensionsKt$aggregateFallback$9 = healthConnectClientAggregationExtensionsKt$aggregateFallback$92;
                                    $i$f$reduce2 = $i$f$reduce;
                                    $i$f$aggregate2 = $i$f$aggregate;
                                }
                                Collection destination$iv$iv3 = new ArrayList(destination$iv$iv$iv.size());
                                for (Map.Entry item$iv$iv : destination$iv$iv$iv.entrySet()) {
                                    destination$iv$iv3.add(((AggregationResultGroupedByDurationWithMinTime) item$iv$iv.getValue()).getAggregationResultGroupedByDuration());
                                }
                                Iterable $this$sortedBy$iv = (List) destination$iv$iv3;
                                return CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$$inlined$sortedBy$2
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // java.util.Comparator
                                    public final int compare(T t, T t2) {
                                        AggregationResultGroupedByDuration it4 = (AggregationResultGroupedByDuration) t;
                                        AggregationResultGroupedByDuration it5 = (AggregationResultGroupedByDuration) t2;
                                        return ComparisonsKt.compareValues(it4.getStartTime(), it5.getStartTime());
                                    }
                                });
                            }
                        }
                        break;
                    case 1:
                        Iterator it4 = (Iterator) healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$2;
                        Collection destination$iv$iv4 = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$1;
                        HealthConnectClient $this$aggregateFallback4 = (HealthConnectClient) healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$0;
                        ResultKt.throwOnFailure($result3);
                        healthConnectClient = null;
                        obj = $result4;
                        $result = $result3;
                        $result2 = (List) $result3;
                        $this$aggregateFallback2 = $this$aggregateFallback4;
                        destination$iv$iv = destination$iv$iv4;
                        it = it4;
                        Iterable list$iv$iv2 = $result2;
                        CollectionsKt.addAll(destination$iv$iv, list$iv$iv2);
                        $result3 = $result;
                        $result4 = obj;
                        $this$aggregateFallback3 = healthConnectClient;
                        i = 1;
                        if (it.hasNext()) {
                        }
                        break;
                    case 2:
                        it = (Iterator) healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$2;
                        destination$iv$iv = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$1;
                        $this$aggregateFallback2 = (HealthConnectClient) healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$0;
                        ResultKt.throwOnFailure($result3);
                        healthConnectClient = null;
                        obj = $result4;
                        $result = $result3;
                        $result2 = (List) $result3;
                        Iterable list$iv$iv22 = $result2;
                        CollectionsKt.addAll(destination$iv$iv, list$iv$iv22);
                        $result3 = $result;
                        $result4 = obj;
                        $this$aggregateFallback3 = healthConnectClient;
                        i = 1;
                        if (it.hasNext()) {
                        }
                        break;
                    case 3:
                        Iterator it5 = (Iterator) healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$2;
                        Collection destination$iv$iv5 = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$1;
                        HealthConnectClient $this$aggregateFallback5 = (HealthConnectClient) healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$0;
                        ResultKt.throwOnFailure($result3);
                        healthConnectClient = null;
                        obj = $result4;
                        $result = $result3;
                        $result2 = (List) $result3;
                        $this$aggregateFallback2 = $this$aggregateFallback5;
                        destination$iv$iv = destination$iv$iv5;
                        it = it5;
                        Iterable list$iv$iv222 = $result2;
                        CollectionsKt.addAll(destination$iv$iv, list$iv$iv222);
                        $result3 = $result;
                        $result4 = obj;
                        $this$aggregateFallback3 = healthConnectClient;
                        i = 1;
                        if (it.hasNext()) {
                        }
                        break;
                    case 4:
                        it = (Iterator) healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$2;
                        destination$iv$iv = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$1;
                        $this$aggregateFallback2 = (HealthConnectClient) healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$0;
                        ResultKt.throwOnFailure($result3);
                        healthConnectClient = null;
                        obj = $result4;
                        $result = $result3;
                        $result2 = (List) $result3;
                        Iterable list$iv$iv2222 = $result2;
                        CollectionsKt.addAll(destination$iv$iv, list$iv$iv2222);
                        $result3 = $result;
                        $result4 = obj;
                        $this$aggregateFallback3 = healthConnectClient;
                        i = 1;
                        if (it.hasNext()) {
                        }
                        break;
                    case 5:
                        it = (Iterator) healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$2;
                        destination$iv$iv = (Collection) healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$1;
                        $this$aggregateFallback2 = (HealthConnectClient) healthConnectClientAggregationExtensionsKt$aggregateFallback$9.L$0;
                        ResultKt.throwOnFailure($result3);
                        healthConnectClient = null;
                        obj = $result4;
                        $result = $result3;
                        $result2 = (List) $result3;
                        Iterable list$iv$iv22222 = $result2;
                        CollectionsKt.addAll(destination$iv$iv, list$iv$iv22222);
                        $result3 = $result;
                        $result4 = obj;
                        $this$aggregateFallback3 = healthConnectClient;
                        i = 1;
                        if (it.hasNext()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        healthConnectClientAggregationExtensionsKt$aggregateFallback$9 = new HealthConnectClientAggregationExtensionsKt$aggregateFallback$9($completion);
        Object $result32 = healthConnectClientAggregationExtensionsKt$aggregateFallback$9.result;
        Object $result42 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = 1;
        switch (healthConnectClientAggregationExtensionsKt$aggregateFallback$9.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T extends Record, R> Object aggregate(HealthConnectClient $this$aggregate, ReadRecordsRequest<T> readRecordsRequest, final Aggregator<T, R> aggregator, Continuation<? super R> continuation) {
        HealthConnectClientAggregationExtensionsKt$aggregate$1 healthConnectClientAggregationExtensionsKt$aggregate$1;
        Aggregator aggregator2;
        if (continuation instanceof HealthConnectClientAggregationExtensionsKt$aggregate$1) {
            healthConnectClientAggregationExtensionsKt$aggregate$1 = (HealthConnectClientAggregationExtensionsKt$aggregate$1) continuation;
            if ((healthConnectClientAggregationExtensionsKt$aggregate$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientAggregationExtensionsKt$aggregate$1.label -= Integer.MIN_VALUE;
                Object $result = healthConnectClientAggregationExtensionsKt$aggregate$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientAggregationExtensionsKt$aggregate$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Flow readRecordsFlow = readRecordsFlow($this$aggregate, readRecordsRequest);
                        FlowCollector flowCollector = new FlowCollector() { // from class: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregate$2
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                return emit((List) value, (Continuation<? super Unit>) $completion);
                            }

                            public final Object emit(List<? extends T> list, Continuation<? super Unit> continuation2) {
                                List<? extends T> $this$forEach$iv = list;
                                Aggregator<T, R> aggregator3 = aggregator;
                                for (Object element$iv : $this$forEach$iv) {
                                    Record it = (Record) element$iv;
                                    aggregator3.filterAndAggregate(it);
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        healthConnectClientAggregationExtensionsKt$aggregate$1.L$0 = aggregator;
                        healthConnectClientAggregationExtensionsKt$aggregate$1.label = 1;
                        if (readRecordsFlow.collect(flowCollector, healthConnectClientAggregationExtensionsKt$aggregate$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        aggregator2 = aggregator;
                        break;
                    case 1:
                        aggregator2 = (Aggregator) healthConnectClientAggregationExtensionsKt$aggregate$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return aggregator2.getResult();
            }
        }
        healthConnectClientAggregationExtensionsKt$aggregate$1 = new HealthConnectClientAggregationExtensionsKt$aggregate$1(continuation);
        Object $result2 = healthConnectClientAggregationExtensionsKt$aggregate$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientAggregationExtensionsKt$aggregate$1.label) {
        }
        return aggregator2.getResult();
    }

    public static final <T extends Record> Flow<List<T>> readRecordsFlow(HealthConnectClient $this$readRecordsFlow, ReadRecordsRequest<T> request) {
        Intrinsics.checkNotNullParameter($this$readRecordsFlow, "<this>");
        Intrinsics.checkNotNullParameter(request, "request");
        return FlowKt.flow(new HealthConnectClientAggregationExtensionsKt$readRecordsFlow$1(request, $this$readRecordsFlow, null));
    }
}
