package androidx.health.connect.client.impl.platform.request;

import android.health.connect.AggregateRecordsRequest;
import android.health.connect.LocalTimeRangeFilter;
import android.health.connect.ReadRecordsRequestUsingFilters;
import android.health.connect.TimeInstantRangeFilter;
import android.health.connect.TimeRangeFilter;
import android.health.connect.changelog.ChangeLogTokenRequest;
import android.health.connect.datatypes.AggregationType;
import android.health.connect.datatypes.Record;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.impl.platform.aggregate.AggregationExtensionsKt;
import androidx.health.connect.client.impl.platform.aggregate.AggregationMappingsKt;
import androidx.health.connect.client.impl.platform.records.MetadataConvertersKt;
import androidx.health.connect.client.impl.platform.records.RecordConvertersKt;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.AggregateGroupByPeriodRequest;
import androidx.health.connect.client.request.AggregateRequest;
import androidx.health.connect.client.request.ChangesTokenRequest;
import androidx.health.connect.client.request.ReadRecordsRequest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: RequestConverters.kt */
@Metadata(m286d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u0003\u001a\u0014\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005*\u00020\u0007H\u0002\u001a\n\u0010\b\u001a\u00020\t*\u00020\n\u001a\u0010\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f*\u00020\r\u001a\u0010\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f*\u00020\u000e\u001a\u0010\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f*\u00020\u000f\u001a\n\u0010\u000b\u001a\u00020\u0010*\u00020\u0011\u001a\u001a\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012*\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\u001a\n\u0010\u0016\u001a\u00020\u0017*\u00020\n¨\u0006\u0018"}, m287d2 = {"toAggregationType", "Landroid/health/connect/datatypes/AggregationType;", "", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "toLocalDateTime", "Ljava/time/LocalDateTime;", "kotlin.jvm.PlatformType", "Ljava/time/Instant;", "toPlatformLocalTimeRangeFilter", "Landroid/health/connect/LocalTimeRangeFilter;", "Landroidx/health/connect/client/time/TimeRangeFilter;", "toPlatformRequest", "Landroid/health/connect/AggregateRecordsRequest;", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;", "Landroidx/health/connect/client/request/AggregateRequest;", "Landroid/health/connect/changelog/ChangeLogTokenRequest;", "Landroidx/health/connect/client/request/ChangesTokenRequest;", "Landroid/health/connect/ReadRecordsRequestUsingFilters;", "Landroid/health/connect/datatypes/Record;", "Landroidx/health/connect/client/request/ReadRecordsRequest;", "Landroidx/health/connect/client/records/Record;", "toPlatformTimeRangeFilter", "Landroid/health/connect/TimeRangeFilter;", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class RequestConvertersKt {
    public static final ReadRecordsRequestUsingFilters<? extends Record> toPlatformRequest(ReadRecordsRequest<? extends androidx.health.connect.client.records.Record> readRecordsRequest) {
        Intrinsics.checkNotNullParameter(readRecordsRequest, "<this>");
        ReadRecordsRequestUsingFilters.Builder $this$toPlatformRequest_u24lambda_u242 = new ReadRecordsRequestUsingFilters.Builder(RecordConvertersKt.toPlatformRecordClass(readRecordsRequest.getRecordType())).setTimeRangeFilter(toPlatformTimeRangeFilter(readRecordsRequest.getTimeRangeFilter())).setPageSize(readRecordsRequest.getPageSize());
        Iterable $this$forEach$iv = readRecordsRequest.getDataOriginFilter();
        for (Object element$iv : $this$forEach$iv) {
            $this$toPlatformRequest_u24lambda_u242.addDataOrigins(MetadataConvertersKt.toPlatformDataOrigin((DataOrigin) element$iv));
        }
        String it = readRecordsRequest.getPageToken();
        if (it != null) {
            $this$toPlatformRequest_u24lambda_u242.setPageToken(Long.parseLong(it));
        }
        if (readRecordsRequest.getPageToken() == null) {
            $this$toPlatformRequest_u24lambda_u242.setAscending(readRecordsRequest.getAscendingOrder());
        }
        ReadRecordsRequestUsingFilters<? extends Record> build = $this$toPlatformRequest_u24lambda_u242.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(recordType.toPla…       }\n        .build()");
        return build;
    }

    public static final TimeRangeFilter toPlatformTimeRangeFilter(androidx.health.connect.client.time.TimeRangeFilter $this$toPlatformTimeRangeFilter) {
        Intrinsics.checkNotNullParameter($this$toPlatformTimeRangeFilter, "<this>");
        if ($this$toPlatformTimeRangeFilter.getStartTime() != null || $this$toPlatformTimeRangeFilter.getEndTime() != null) {
            TimeInstantRangeFilter build = new TimeInstantRangeFilter.Builder().setStartTime($this$toPlatformTimeRangeFilter.getStartTime()).setEndTime($this$toPlatformTimeRangeFilter.getEndTime()).build();
            Intrinsics.checkNotNullExpressionValue(build, "{\n        TimeInstantRan…me(endTime).build()\n    }");
            return build;
        }
        if ($this$toPlatformTimeRangeFilter.getLocalStartTime() != null || $this$toPlatformTimeRangeFilter.getLocalEndTime() != null) {
            LocalTimeRangeFilter build2 = new LocalTimeRangeFilter.Builder().setStartTime($this$toPlatformTimeRangeFilter.getLocalStartTime()).setEndTime($this$toPlatformTimeRangeFilter.getLocalEndTime()).build();
            Intrinsics.checkNotNullExpressionValue(build2, "{\n        LocalTimeRange…calEndTime).build()\n    }");
            return build2;
        }
        TimeInstantRangeFilter build3 = new TimeInstantRangeFilter.Builder().setStartTime(Instant.EPOCH).build();
        Intrinsics.checkNotNullExpressionValue(build3, "{\n        // Platform do…tant.EPOCH).build()\n    }");
        return build3;
    }

    public static final LocalTimeRangeFilter toPlatformLocalTimeRangeFilter(androidx.health.connect.client.time.TimeRangeFilter $this$toPlatformLocalTimeRangeFilter) {
        Intrinsics.checkNotNullParameter($this$toPlatformLocalTimeRangeFilter, "<this>");
        if ($this$toPlatformLocalTimeRangeFilter.getLocalStartTime() != null || $this$toPlatformLocalTimeRangeFilter.getLocalEndTime() != null) {
            LocalTimeRangeFilter build = new LocalTimeRangeFilter.Builder().setStartTime($this$toPlatformLocalTimeRangeFilter.getLocalStartTime()).setEndTime($this$toPlatformLocalTimeRangeFilter.getLocalEndTime()).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
            return build;
        }
        if ($this$toPlatformLocalTimeRangeFilter.getStartTime() != null || $this$toPlatformLocalTimeRangeFilter.getEndTime() != null) {
            LocalTimeRangeFilter.Builder builder = new LocalTimeRangeFilter.Builder();
            Instant startTime = $this$toPlatformLocalTimeRangeFilter.getStartTime();
            LocalTimeRangeFilter.Builder startTime2 = builder.setStartTime(startTime != null ? toLocalDateTime(startTime) : null);
            Instant endTime = $this$toPlatformLocalTimeRangeFilter.getEndTime();
            LocalTimeRangeFilter build2 = startTime2.setEndTime(endTime != null ? toLocalDateTime(endTime) : null).build();
            Intrinsics.checkNotNullExpressionValue(build2, "Builder()\n              …\n                .build()");
            return build2;
        }
        LocalTimeRangeFilter.Builder builder2 = new LocalTimeRangeFilter.Builder();
        Instant EPOCH = Instant.EPOCH;
        Intrinsics.checkNotNullExpressionValue(EPOCH, "EPOCH");
        LocalTimeRangeFilter build3 = builder2.setStartTime(toLocalDateTime(EPOCH)).build();
        Intrinsics.checkNotNullExpressionValue(build3, "Builder().setStartTime(I…oLocalDateTime()).build()");
        return build3;
    }

    private static final LocalDateTime toLocalDateTime(Instant $this$toLocalDateTime) {
        return LocalDateTime.ofInstant($this$toLocalDateTime, ZoneOffset.UTC);
    }

    public static final ChangeLogTokenRequest toPlatformRequest(ChangesTokenRequest $this$toPlatformRequest) {
        Intrinsics.checkNotNullParameter($this$toPlatformRequest, "<this>");
        ChangeLogTokenRequest.Builder $this$toPlatformRequest_u24lambda_u245 = new ChangeLogTokenRequest.Builder();
        Iterable $this$forEach$iv = $this$toPlatformRequest.getDataOriginFilters();
        for (Object element$iv : $this$forEach$iv) {
            DataOrigin it = (DataOrigin) element$iv;
            $this$toPlatformRequest_u24lambda_u245.addDataOriginFilter(MetadataConvertersKt.toPlatformDataOrigin(it));
        }
        Iterable $this$forEach$iv2 = $this$toPlatformRequest.getRecordTypes();
        for (Object element$iv2 : $this$forEach$iv2) {
            KClass it2 = (KClass) element$iv2;
            $this$toPlatformRequest_u24lambda_u245.addRecordType(RecordConvertersKt.toPlatformRecordClass(it2));
        }
        ChangeLogTokenRequest build = $this$toPlatformRequest_u24lambda_u245.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .apply…       }\n        .build()");
        return build;
    }

    public static final AggregateRecordsRequest<Object> toPlatformRequest(AggregateRequest $this$toPlatformRequest) {
        Intrinsics.checkNotNullParameter($this$toPlatformRequest, "<this>");
        AggregateRecordsRequest.Builder $this$toPlatformRequest_u24lambda_u249 = new AggregateRecordsRequest.Builder(toPlatformTimeRangeFilter($this$toPlatformRequest.getTimeRangeFilter()));
        Iterable $this$forEach$iv = $this$toPlatformRequest.getDataOriginFilter$connect_client_release();
        for (Object element$iv : $this$forEach$iv) {
            DataOrigin it = (DataOrigin) element$iv;
            $this$toPlatformRequest_u24lambda_u249.addDataOriginsFilter(MetadataConvertersKt.toPlatformDataOrigin(it));
        }
        Iterable $this$forEach$iv2 = $this$toPlatformRequest.getMetrics$connect_client_release();
        Iterable $this$filter$iv = $this$forEach$iv2;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            AggregateMetric it2 = (AggregateMetric) element$iv$iv;
            if (AggregationExtensionsKt.isPlatformSupportedMetric(it2)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$forEach$iv3 = (List) destination$iv$iv;
        for (Object element$iv2 : $this$forEach$iv3) {
            AggregateMetric it3 = (AggregateMetric) element$iv2;
            $this$toPlatformRequest_u24lambda_u249.addAggregationType(toAggregationType(it3));
        }
        AggregateRecordsRequest<Object> build = $this$toPlatformRequest_u24lambda_u249.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder<Any>(timeRangeFi…       }\n        .build()");
        return build;
    }

    public static final AggregateRecordsRequest<Object> toPlatformRequest(AggregateGroupByDurationRequest $this$toPlatformRequest) {
        Intrinsics.checkNotNullParameter($this$toPlatformRequest, "<this>");
        AggregateRecordsRequest.Builder $this$toPlatformRequest_u24lambda_u2412 = new AggregateRecordsRequest.Builder(toPlatformTimeRangeFilter($this$toPlatformRequest.getTimeRangeFilter()));
        Iterable $this$forEach$iv = $this$toPlatformRequest.getDataOriginFilter$connect_client_release();
        for (Object element$iv : $this$forEach$iv) {
            DataOrigin it = (DataOrigin) element$iv;
            $this$toPlatformRequest_u24lambda_u2412.addDataOriginsFilter(MetadataConvertersKt.toPlatformDataOrigin(it));
        }
        Iterable $this$forEach$iv2 = $this$toPlatformRequest.getMetrics$connect_client_release();
        for (Object element$iv2 : $this$forEach$iv2) {
            AggregateMetric it2 = (AggregateMetric) element$iv2;
            $this$toPlatformRequest_u24lambda_u2412.addAggregationType(toAggregationType(it2));
        }
        AggregateRecordsRequest<Object> build = $this$toPlatformRequest_u24lambda_u2412.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder<Any>(timeRangeFi…       }\n        .build()");
        return build;
    }

    public static final AggregateRecordsRequest<Object> toPlatformRequest(AggregateGroupByPeriodRequest $this$toPlatformRequest) {
        Intrinsics.checkNotNullParameter($this$toPlatformRequest, "<this>");
        AggregateRecordsRequest.Builder $this$toPlatformRequest_u24lambda_u2415 = new AggregateRecordsRequest.Builder(toPlatformLocalTimeRangeFilter($this$toPlatformRequest.getTimeRangeFilter()));
        Iterable $this$forEach$iv = $this$toPlatformRequest.getDataOriginFilter$connect_client_release();
        for (Object element$iv : $this$forEach$iv) {
            DataOrigin it = (DataOrigin) element$iv;
            $this$toPlatformRequest_u24lambda_u2415.addDataOriginsFilter(MetadataConvertersKt.toPlatformDataOrigin(it));
        }
        Iterable $this$forEach$iv2 = $this$toPlatformRequest.getMetrics$connect_client_release();
        for (Object element$iv2 : $this$forEach$iv2) {
            AggregateMetric it2 = (AggregateMetric) element$iv2;
            $this$toPlatformRequest_u24lambda_u2415.addAggregationType(toAggregationType(it2));
        }
        AggregateRecordsRequest<Object> build = $this$toPlatformRequest_u24lambda_u2415.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder<Any>(timeRangeFi…       }\n        .build()");
        return build;
    }

    public static final AggregationType<Object> toAggregationType(AggregateMetric<? extends Object> aggregateMetric) {
        Intrinsics.checkNotNullParameter(aggregateMetric, "<this>");
        AggregationType<Double> aggregationType = AggregationMappingsKt.getDOUBLE_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric);
        if (aggregationType == null && (aggregationType = (AggregationType) AggregationMappingsKt.getDURATION_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null && (aggregationType = (AggregationType) AggregationMappingsKt.getENERGY_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null && (aggregationType = (AggregationType) AggregationMappingsKt.getGRAMS_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null && (aggregationType = (AggregationType) AggregationMappingsKt.getLENGTH_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null && (aggregationType = (AggregationType) AggregationMappingsKt.getLONG_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null && (aggregationType = (AggregationType) AggregationMappingsKt.getKILOGRAMS_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null && (aggregationType = (AggregationType) AggregationMappingsKt.getPOWER_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null && (aggregationType = (AggregationType) AggregationMappingsKt.getPRESSURE_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null && (aggregationType = (AggregationType) AggregationMappingsKt.getTEMPERATURE_DELTA_METRIC_TYPE_MAP().get(aggregateMetric)) == null && (aggregationType = (AggregationType) AggregationMappingsKt.getVELOCITY_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null && (aggregationType = (AggregationType) AggregationMappingsKt.getVOLUME_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null) {
            throw new IllegalArgumentException("Unsupported aggregation type " + aggregateMetric.getMetricKey());
        }
        return aggregationType;
    }
}
