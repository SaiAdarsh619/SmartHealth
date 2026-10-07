package androidx.health.connect.client.impl.converters.request;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.impl.converters.aggregate.AggregateMetricToProtoKt;
import androidx.health.connect.client.impl.converters.time.TimeRangeFilterConverterKt;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.AggregateGroupByPeriodRequest;
import androidx.health.connect.client.request.AggregateRequest;
import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.RequestProto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AggregateRequestToProto.kt */
@Metadata(m286d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0004\u001a \u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006*\b\u0012\u0004\u0012\u00020\n0\tH\u0002¨\u0006\u000b"}, m287d2 = {"toProto", "Landroidx/health/platform/client/proto/RequestProto$AggregateDataRequest;", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;", "Landroidx/health/connect/client/request/AggregateRequest;", "toProtoList", "", "Landroidx/health/platform/client/proto/DataProto$DataOrigin;", "kotlin.jvm.PlatformType", "", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class AggregateRequestToProtoKt {
    public static final RequestProto.AggregateDataRequest toProto(AggregateRequest $this$toProto) {
        Intrinsics.checkNotNullParameter($this$toProto, "<this>");
        RequestProto.AggregateDataRequest.Builder addAllDataOrigin = RequestProto.AggregateDataRequest.newBuilder().setTimeSpec(TimeRangeFilterConverterKt.toProto($this$toProto.getTimeRangeFilter())).addAllDataOrigin(toProtoList($this$toProto.getDataOriginFilter$connect_client_release()));
        Iterable $this$map$iv = $this$toProto.getMetrics$connect_client_release();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            AggregateMetric it = (AggregateMetric) item$iv$iv;
            destination$iv$iv.add(AggregateMetricToProtoKt.toProto(it));
        }
        RequestProto.AggregateDataRequest build = addAllDataOrigin.addAllMetricSpec((List) destination$iv$iv).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n        .se…oto() })\n        .build()");
        return build;
    }

    public static final RequestProto.AggregateDataRequest toProto(AggregateGroupByDurationRequest $this$toProto) {
        Intrinsics.checkNotNullParameter($this$toProto, "<this>");
        RequestProto.AggregateDataRequest.Builder addAllDataOrigin = RequestProto.AggregateDataRequest.newBuilder().setTimeSpec(TimeRangeFilterConverterKt.toProto($this$toProto.getTimeRangeFilter())).addAllDataOrigin(toProtoList($this$toProto.getDataOriginFilter$connect_client_release()));
        Iterable $this$map$iv = $this$toProto.getMetrics$connect_client_release();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            AggregateMetric it = (AggregateMetric) item$iv$iv;
            destination$iv$iv.add(AggregateMetricToProtoKt.toProto(it));
        }
        RequestProto.AggregateDataRequest build = addAllDataOrigin.addAllMetricSpec((List) destination$iv$iv).setSliceDurationMillis($this$toProto.getTimeRangeSlicer().toMillis()).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n        .se…illis())\n        .build()");
        return build;
    }

    public static final RequestProto.AggregateDataRequest toProto(AggregateGroupByPeriodRequest $this$toProto) {
        Intrinsics.checkNotNullParameter($this$toProto, "<this>");
        RequestProto.AggregateDataRequest.Builder addAllDataOrigin = RequestProto.AggregateDataRequest.newBuilder().setTimeSpec(TimeRangeFilterConverterKt.toProto($this$toProto.getTimeRangeFilter())).addAllDataOrigin(toProtoList($this$toProto.getDataOriginFilter$connect_client_release()));
        Iterable $this$map$iv = $this$toProto.getMetrics$connect_client_release();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            AggregateMetric it = (AggregateMetric) item$iv$iv;
            destination$iv$iv.add(AggregateMetricToProtoKt.toProto(it));
        }
        RequestProto.AggregateDataRequest build = addAllDataOrigin.addAllMetricSpec((List) destination$iv$iv).setSlicePeriod($this$toProto.getTimeRangeSlicer().toString()).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n        .se…tring())\n        .build()");
        return build;
    }

    private static final List<DataProto.DataOrigin> toProtoList(Set<DataOrigin> set) {
        Set<DataOrigin> $this$map$iv = set;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            DataOrigin it = (DataOrigin) item$iv$iv;
            destination$iv$iv.add(DataProto.DataOrigin.newBuilder().setApplicationId(it.getPackageName()).build());
        }
        return (List) destination$iv$iv;
    }
}
