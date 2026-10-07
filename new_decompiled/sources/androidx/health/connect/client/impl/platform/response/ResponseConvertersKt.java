package androidx.health.connect.client.impl.platform.response;

import android.health.connect.AggregateRecordsGroupedByDurationResponse;
import android.health.connect.AggregateRecordsGroupedByPeriodResponse;
import android.health.connect.AggregateRecordsResponse;
import android.health.connect.datatypes.AggregationType;
import android.health.connect.datatypes.DataOrigin;
import android.health.connect.datatypes.units.Length;
import android.health.connect.datatypes.units.Mass;
import android.health.connect.datatypes.units.Power;
import android.health.connect.datatypes.units.Pressure;
import android.health.connect.datatypes.units.TemperatureDelta;
import android.health.connect.datatypes.units.Velocity;
import android.health.connect.datatypes.units.Volume;
import android.os.ext.SdkExtensions;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByPeriod;
import androidx.health.connect.client.impl.platform.aggregate.AggregationMappingsKt;
import androidx.health.connect.client.impl.platform.records.MetadataConvertersKt;
import androidx.health.connect.client.impl.platform.request.RequestConvertersKt;
import androidx.health.connect.client.units.Energy;
import androidx.health.connect.client.units.Mass;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResponseConverters.kt */
@Metadata(m286d1 = {"\u0000d\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\\\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t2\"\u0010\u000b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n\u0012\u000e\u0012\f\u0012\b\u0012\u00060\fj\u0002`\r0\u00050\tH\u0001\u001a.\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f2\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u000fH\u0001\u001a.\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00140\u000f2\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u000fH\u0001\u001a$\u0010\u0015\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00070\u00172\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u001a$\u0010\u0015\u001a\u00020\u0018*\b\u0012\u0004\u0012\u00020\u00070\u00192\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u001a4\u0010\u0015\u001a\u00020\u0018*\b\u0012\u0004\u0012\u00020\u00070\u00192\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b\u001a$\u0010\u0015\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00070\u001d2\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m287d2 = {"BUCKET_DATA_ORIGINS_EXTENSION_VERSION", "", "buildAggregationResult", "Landroidx/health/connect/client/aggregate/AggregationResult;", "metrics", "", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "", "aggregationValueGetter", "Lkotlin/Function1;", "Landroid/health/connect/datatypes/AggregationType;", "platformDataOriginsGetter", "Landroid/health/connect/datatypes/DataOrigin;", "Landroidx/health/connect/client/impl/platform/records/PlatformDataOrigin;", "getDoubleMetricValues", "", "", "", "metricValueMap", "getLongMetricValues", "", "toSdkResponse", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "Landroid/health/connect/AggregateRecordsGroupedByDurationResponse;", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByPeriod;", "Landroid/health/connect/AggregateRecordsGroupedByPeriodResponse;", "bucketStartTime", "Ljava/time/LocalDateTime;", "bucketEndTime", "Landroid/health/connect/AggregateRecordsResponse;", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class ResponseConvertersKt {
    private static final int BUCKET_DATA_ORIGINS_EXTENSION_VERSION = 10;

    public static final AggregationResult toSdkResponse(AggregateRecordsResponse<Object> aggregateRecordsResponse, Set<? extends AggregateMetric<? extends Object>> metrics) {
        Intrinsics.checkNotNullParameter(aggregateRecordsResponse, "<this>");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        return buildAggregationResult(metrics, new ResponseConvertersKt$toSdkResponse$1(aggregateRecordsResponse), new ResponseConvertersKt$toSdkResponse$2(aggregateRecordsResponse));
    }

    public static final AggregationResultGroupedByDuration toSdkResponse(AggregateRecordsGroupedByDurationResponse<Object> aggregateRecordsGroupedByDurationResponse, Set<? extends AggregateMetric<? extends Object>> metrics) {
        ResponseConvertersKt$toSdkResponse$platformDataOriginsGetter$2 platformDataOriginsGetter;
        Intrinsics.checkNotNullParameter(aggregateRecordsGroupedByDurationResponse, "<this>");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        if (SdkExtensions.getExtensionVersion(34) < 10) {
            platformDataOriginsGetter = new Function1<AggregationType<Object>, Set<? extends DataOrigin>>() { // from class: androidx.health.connect.client.impl.platform.response.ResponseConvertersKt$toSdkResponse$platformDataOriginsGetter$2
                @Override // kotlin.jvm.functions.Function1
                public final Set<DataOrigin> invoke(AggregationType<Object> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return SetsKt.emptySet();
                }
            };
        } else {
            platformDataOriginsGetter = new ResponseConvertersKt$toSdkResponse$platformDataOriginsGetter$1(aggregateRecordsGroupedByDurationResponse);
        }
        AggregationResult buildAggregationResult = buildAggregationResult(metrics, new ResponseConvertersKt$toSdkResponse$3(aggregateRecordsGroupedByDurationResponse), platformDataOriginsGetter);
        Instant startTime = aggregateRecordsGroupedByDurationResponse.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        Instant endTime = aggregateRecordsGroupedByDurationResponse.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset zoneOffset = aggregateRecordsGroupedByDurationResponse.getZoneOffset(RequestConvertersKt.toAggregationType((AggregateMetric) CollectionsKt.first(metrics)));
        if (zoneOffset == null) {
            zoneOffset = ZoneOffset.systemDefault().getRules().getOffset(aggregateRecordsGroupedByDurationResponse.getStartTime());
        }
        Intrinsics.checkNotNullExpressionValue(zoneOffset, "getZoneOffset(metrics.fi…ules.getOffset(startTime)");
        return new AggregationResultGroupedByDuration(buildAggregationResult, startTime, endTime, zoneOffset);
    }

    public static final AggregationResultGroupedByPeriod toSdkResponse(AggregateRecordsGroupedByPeriodResponse<Object> aggregateRecordsGroupedByPeriodResponse, Set<? extends AggregateMetric<? extends Object>> metrics) {
        Intrinsics.checkNotNullParameter(aggregateRecordsGroupedByPeriodResponse, "<this>");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        LocalDateTime startTime = aggregateRecordsGroupedByPeriodResponse.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        LocalDateTime endTime = aggregateRecordsGroupedByPeriodResponse.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        return toSdkResponse(aggregateRecordsGroupedByPeriodResponse, metrics, startTime, endTime);
    }

    public static final AggregationResultGroupedByPeriod toSdkResponse(AggregateRecordsGroupedByPeriodResponse<Object> aggregateRecordsGroupedByPeriodResponse, Set<? extends AggregateMetric<? extends Object>> metrics, LocalDateTime bucketStartTime, LocalDateTime bucketEndTime) {
        ResponseConvertersKt$toSdkResponse$platformDataOriginsGetter$4 platformDataOriginsGetter;
        Intrinsics.checkNotNullParameter(aggregateRecordsGroupedByPeriodResponse, "<this>");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(bucketStartTime, "bucketStartTime");
        Intrinsics.checkNotNullParameter(bucketEndTime, "bucketEndTime");
        if (SdkExtensions.getExtensionVersion(34) < 10) {
            platformDataOriginsGetter = new Function1<AggregationType<Object>, Set<? extends DataOrigin>>() { // from class: androidx.health.connect.client.impl.platform.response.ResponseConvertersKt$toSdkResponse$platformDataOriginsGetter$4
                @Override // kotlin.jvm.functions.Function1
                public final Set<DataOrigin> invoke(AggregationType<Object> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return SetsKt.emptySet();
                }
            };
        } else {
            platformDataOriginsGetter = new ResponseConvertersKt$toSdkResponse$platformDataOriginsGetter$3(aggregateRecordsGroupedByPeriodResponse);
        }
        return new AggregationResultGroupedByPeriod(buildAggregationResult(metrics, new ResponseConvertersKt$toSdkResponse$4(aggregateRecordsGroupedByPeriodResponse), platformDataOriginsGetter), bucketStartTime, bucketEndTime);
    }

    public static final AggregationResult buildAggregationResult(Set<? extends AggregateMetric<? extends Object>> metrics, Function1<? super AggregationType<Object>, ? extends Object> aggregationValueGetter, Function1<? super AggregationType<Object>, ? extends Set<DataOrigin>> platformDataOriginsGetter) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(aggregationValueGetter, "aggregationValueGetter");
        Intrinsics.checkNotNullParameter(platformDataOriginsGetter, "platformDataOriginsGetter");
        Map $this$buildAggregationResult_u24lambda_u242 = MapsKt.createMapBuilder();
        Set<? extends AggregateMetric<? extends Object>> $this$forEach$iv = metrics;
        for (Object element$iv : $this$forEach$iv) {
            AggregateMetric metric = (AggregateMetric) element$iv;
            Object it = aggregationValueGetter.invoke(RequestConvertersKt.toAggregationType(metric));
            if (it != null) {
                $this$buildAggregationResult_u24lambda_u242.put(metric, it);
            }
        }
        Map metricValueMap = MapsKt.build($this$buildAggregationResult_u24lambda_u242);
        Map<String, Long> longMetricValues = getLongMetricValues(metricValueMap);
        Map<String, Double> doubleMetricValues = getDoubleMetricValues(metricValueMap);
        Set<? extends AggregateMetric<? extends Object>> $this$flatMapTo$iv = metrics;
        Collection destination$iv = new HashSet();
        for (Object element$iv2 : $this$flatMapTo$iv) {
            Iterable $this$map$iv = platformDataOriginsGetter.invoke(RequestConvertersKt.toAggregationType((AggregateMetric) element$iv2));
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                destination$iv$iv.add(MetadataConvertersKt.toSdkDataOrigin((DataOrigin) item$iv$iv));
            }
            Iterable list$iv = (List) destination$iv$iv;
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        return new AggregationResult(longMetricValues, doubleMetricValues, (Set) destination$iv);
    }

    public static final Map<String, Long> getLongMetricValues(Map<AggregateMetric<Object>, ? extends Object> metricValueMap) {
        Intrinsics.checkNotNullParameter(metricValueMap, "metricValueMap");
        Map $this$getLongMetricValues_u24lambda_u246 = MapsKt.createMapBuilder();
        for (Map.Entry element$iv : metricValueMap.entrySet()) {
            AggregateMetric<Object> key = element$iv.getKey();
            Object value = element$iv.getValue();
            if (AggregationMappingsKt.getDURATION_AGGREGATION_METRIC_TYPE_MAP().containsKey(key) || AggregationMappingsKt.getLONG_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey = key.getMetricKey();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Long");
                $this$getLongMetricValues_u24lambda_u246.put(metricKey, (Long) value);
            }
        }
        return MapsKt.build($this$getLongMetricValues_u24lambda_u246);
    }

    public static final Map<String, Double> getDoubleMetricValues(Map<AggregateMetric<Object>, ? extends Object> metricValueMap) {
        Intrinsics.checkNotNullParameter(metricValueMap, "metricValueMap");
        Map $this$getDoubleMetricValues_u24lambda_u248 = MapsKt.createMapBuilder();
        for (Map.Entry element$iv : metricValueMap.entrySet()) {
            AggregateMetric<Object> key = element$iv.getKey();
            Object value = element$iv.getValue();
            if (AggregationMappingsKt.getDOUBLE_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey = key.getMetricKey();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Double");
                $this$getDoubleMetricValues_u24lambda_u248.put(metricKey, (Double) value);
            } else if (AggregationMappingsKt.getENERGY_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey2 = key.getMetricKey();
                Energy.Companion companion = Energy.INSTANCE;
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.health.connect.datatypes.units.Energy");
                $this$getDoubleMetricValues_u24lambda_u248.put(metricKey2, Double.valueOf(companion.calories(((android.health.connect.datatypes.units.Energy) value).getInCalories()).getKilocalories()));
            } else if (AggregationMappingsKt.getGRAMS_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey3 = key.getMetricKey();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.health.connect.datatypes.units.Mass{ androidx.health.connect.client.impl.platform.records.PlatformRecordAliasesKt.PlatformMass }");
                $this$getDoubleMetricValues_u24lambda_u248.put(metricKey3, Double.valueOf(((Mass) value).getInGrams()));
            } else if (AggregationMappingsKt.getLENGTH_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey4 = key.getMetricKey();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.health.connect.datatypes.units.Length{ androidx.health.connect.client.impl.platform.records.PlatformRecordAliasesKt.PlatformLength }");
                $this$getDoubleMetricValues_u24lambda_u248.put(metricKey4, Double.valueOf(((Length) value).getInMeters()));
            } else if (AggregationMappingsKt.getKILOGRAMS_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey5 = key.getMetricKey();
                Mass.Companion companion2 = androidx.health.connect.client.units.Mass.INSTANCE;
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.health.connect.datatypes.units.Mass{ androidx.health.connect.client.impl.platform.records.PlatformRecordAliasesKt.PlatformMass }");
                $this$getDoubleMetricValues_u24lambda_u248.put(metricKey5, Double.valueOf(companion2.grams(((android.health.connect.datatypes.units.Mass) value).getInGrams()).getKilograms()));
            } else if (AggregationMappingsKt.getPRESSURE_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey6 = key.getMetricKey();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.health.connect.datatypes.units.Pressure{ androidx.health.connect.client.impl.platform.records.PlatformRecordAliasesKt.PlatformPressure }");
                $this$getDoubleMetricValues_u24lambda_u248.put(metricKey6, Double.valueOf(((Pressure) value).getInMillimetersOfMercury()));
            } else if (AggregationMappingsKt.getPOWER_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey7 = key.getMetricKey();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.health.connect.datatypes.units.Power{ androidx.health.connect.client.impl.platform.records.PlatformRecordAliasesKt.PlatformPower }");
                $this$getDoubleMetricValues_u24lambda_u248.put(metricKey7, Double.valueOf(((Power) value).getInWatts()));
            } else if (AggregationMappingsKt.getTEMPERATURE_DELTA_METRIC_TYPE_MAP().containsKey(key)) {
                if (!(SdkExtensions.getExtensionVersion(34) >= 13)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                String metricKey8 = key.getMetricKey();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.health.connect.datatypes.units.TemperatureDelta{ androidx.health.connect.client.impl.platform.records.PlatformRecordAliasesKt.PlatformTemperatureDelta }");
                $this$getDoubleMetricValues_u24lambda_u248.put(metricKey8, Double.valueOf(((TemperatureDelta) value).getInCelsius()));
            } else if (AggregationMappingsKt.getVELOCITY_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey9 = key.getMetricKey();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.health.connect.datatypes.units.Velocity{ androidx.health.connect.client.impl.platform.records.PlatformRecordAliasesKt.PlatformVelocity }");
                $this$getDoubleMetricValues_u24lambda_u248.put(metricKey9, Double.valueOf(((Velocity) value).getInMetersPerSecond()));
            } else if (AggregationMappingsKt.getVOLUME_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey10 = key.getMetricKey();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.health.connect.datatypes.units.Volume");
                $this$getDoubleMetricValues_u24lambda_u248.put(metricKey10, Double.valueOf(((Volume) value).getInLiters()));
            }
        }
        return MapsKt.build($this$getDoubleMetricValues_u24lambda_u248);
    }
}
