package androidx.health.connect.client.impl.converters.response;

import androidx.health.connect.client.impl.converters.records.ProtoToRecordConvertersKt;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.response.ReadRecordsResponse;
import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.ResponseProto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProtoToReadRecordsResponse.kt */
@Metadata(m286d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, m287d2 = {"toReadRecordsResponse", "Landroidx/health/connect/client/response/ReadRecordsResponse;", "T", "Landroidx/health/connect/client/records/Record;", "proto", "Landroidx/health/platform/client/proto/ResponseProto$ReadDataRangeResponse;", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class ProtoToReadRecordsResponseKt {
    public static final <T extends Record> ReadRecordsResponse<T> toReadRecordsResponse(ResponseProto.ReadDataRangeResponse proto) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Iterable dataPointList = proto.getDataPointList();
        Intrinsics.checkNotNullExpressionValue(dataPointList, "proto.dataPointList");
        Iterable $this$map$iv = dataPointList;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            DataProto.DataPoint it = (DataProto.DataPoint) item$iv$iv;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Record record = ProtoToRecordConvertersKt.toRecord(it);
            Intrinsics.checkNotNull(record, "null cannot be cast to non-null type T of androidx.health.connect.client.impl.converters.response.ProtoToReadRecordsResponseKt.toReadRecordsResponse");
            destination$iv$iv.add(record);
        }
        return new ReadRecordsResponse<>((List) destination$iv$iv, proto.getPageToken());
    }
}
