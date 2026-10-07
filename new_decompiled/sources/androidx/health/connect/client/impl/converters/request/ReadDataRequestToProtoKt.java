package androidx.health.connect.client.impl.converters.request;

import androidx.health.connect.client.impl.converters.datatype.DataTypeIdPairConverterKt;
import androidx.health.connect.client.records.Record;
import androidx.health.platform.client.proto.RequestProto;
import com.example.healthconnect.codelab.presentation.navigation.ScreenKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: ReadDataRequestToProto.kt */
@Metadata(m286d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m287d2 = {"toReadDataRequestProto", "Landroidx/health/platform/client/proto/RequestProto$ReadDataRequest;", "dataTypeKC", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/Record;", ScreenKt.UID_NAV_ARGUMENT, "", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class ReadDataRequestToProtoKt {
    public static final RequestProto.ReadDataRequest toReadDataRequestProto(KClass<? extends Record> dataTypeKC, String uid) {
        Intrinsics.checkNotNullParameter(dataTypeKC, "dataTypeKC");
        Intrinsics.checkNotNullParameter(uid, "uid");
        RequestProto.ReadDataRequest build = RequestProto.ReadDataRequest.newBuilder().setDataTypeIdPair(DataTypeIdPairConverterKt.toDataTypeIdPairProto(dataTypeKC, uid)).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n        .se…C, uid))\n        .build()");
        return build;
    }
}
