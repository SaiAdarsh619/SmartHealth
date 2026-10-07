package androidx.health.connect.client.impl.converters.request;

import androidx.health.connect.client.impl.converters.datatype.DataTypeConverterKt;
import androidx.health.connect.client.impl.converters.time.TimeRangeFilterConverterKt;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.request.ReadRecordsRequest;
import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.RequestProto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReadDataRangeRequestToProto.kt */
@Metadata(m286d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005¨\u0006\u0006"}, m287d2 = {"toReadDataRangeRequestProto", "Landroidx/health/platform/client/proto/RequestProto$ReadDataRangeRequest;", "T", "Landroidx/health/connect/client/records/Record;", "request", "Landroidx/health/connect/client/request/ReadRecordsRequest;", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class ReadDataRangeRequestToProtoKt {
    public static final <T extends Record> RequestProto.ReadDataRangeRequest toReadDataRangeRequestProto(ReadRecordsRequest<T> request) {
        Intrinsics.checkNotNullParameter(request, "request");
        RequestProto.ReadDataRangeRequest.Builder $this$toReadDataRangeRequestProto_u24lambda_u242 = RequestProto.ReadDataRangeRequest.newBuilder().setDataType(DataTypeConverterKt.toDataType(request.getRecordType()));
        $this$toReadDataRangeRequestProto_u24lambda_u242.setTimeSpec(TimeRangeFilterConverterKt.toProto(request.getTimeRangeFilter()));
        Iterable $this$map$iv = request.getDataOriginFilter();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(DataProto.DataOrigin.newBuilder().setApplicationId(((DataOrigin) item$iv$iv).getPackageName()).build());
        }
        $this$toReadDataRangeRequestProto_u24lambda_u242.addAllDataOriginFilters((List) destination$iv$iv);
        $this$toReadDataRangeRequestProto_u24lambda_u242.setAscOrdering(request.getAscendingOrder());
        $this$toReadDataRangeRequestProto_u24lambda_u242.setPageSize(request.getPageSize());
        String it = request.getPageToken();
        if (it != null) {
            $this$toReadDataRangeRequestProto_u24lambda_u242.setPageToken(it);
        }
        RequestProto.ReadDataRangeRequest build = $this$toReadDataRangeRequestProto_u24lambda_u242.build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n        .se…       }\n        .build()");
        return build;
    }
}
