package androidx.health.platform.client.response;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.health.platform.client.impl.data.ProtoParcelable;
import androidx.health.platform.client.impl.data.SharedMemory27Impl;
import androidx.health.platform.client.proto.ResponseProto;
import androidx.health.platform.client.response.InsertDataResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InsertDataResponse.kt */
@Metadata(m286d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, m287d2 = {"Landroidx/health/platform/client/response/InsertDataResponse;", "Landroidx/health/platform/client/impl/data/ProtoParcelable;", "Landroidx/health/platform/client/proto/ResponseProto$InsertDataResponse;", "dataPointUids", "", "", "(Ljava/util/List;)V", "getDataPointUids", "()Ljava/util/List;", "proto", "getProto", "()Landroidx/health/platform/client/proto/ResponseProto$InsertDataResponse;", "Companion", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class InsertDataResponse extends ProtoParcelable<ResponseProto.InsertDataResponse> {
    public static final Parcelable.Creator<InsertDataResponse> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<String> dataPointUids;

    public final List<String> getDataPointUids() {
        return this.dataPointUids;
    }

    public InsertDataResponse(List<String> dataPointUids) {
        Intrinsics.checkNotNullParameter(dataPointUids, "dataPointUids");
        this.dataPointUids = dataPointUids;
    }

    @Override // androidx.health.platform.client.impl.data.ProtoData
    public ResponseProto.InsertDataResponse getProto() {
        ResponseProto.InsertDataResponse build = ResponseProto.InsertDataResponse.newBuilder().addAllDataPointUid(this.dataPointUids).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …\n                .build()");
        return build;
    }

    /* compiled from: InsertDataResponse.kt */
    @Metadata(m286d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m287d2 = {"Landroidx/health/platform/client/response/InsertDataResponse$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/health/platform/client/response/InsertDataResponse;", "fromProto", "proto", "Landroidx/health/platform/client/proto/ResponseProto$InsertDataResponse;", "fromProto$connect_client_release", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InsertDataResponse fromProto$connect_client_release(ResponseProto.InsertDataResponse proto) {
            Intrinsics.checkNotNullParameter(proto, "proto");
            List<String> dataPointUidList = proto.getDataPointUidList();
            Intrinsics.checkNotNullExpressionValue(dataPointUidList, "proto.dataPointUidList");
            return new InsertDataResponse(dataPointUidList);
        }
    }

    static {
        ProtoParcelable.Companion companion = ProtoParcelable.INSTANCE;
        CREATOR = new Parcelable.Creator<InsertDataResponse>() { // from class: androidx.health.platform.client.response.InsertDataResponse$special$$inlined$newCreator$connect_client_release$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r1v4, types: [androidx.health.platform.client.impl.data.ProtoParcelable, androidx.health.platform.client.response.InsertDataResponse] */
            @Override // android.os.Parcelable.Creator
            public InsertDataResponse createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                int storage = source.readInt();
                switch (storage) {
                    case 0:
                        byte[] payload = source.createByteArray();
                        if (payload == null) {
                            return null;
                        }
                        ResponseProto.InsertDataResponse proto = ResponseProto.InsertDataResponse.parseFrom(payload);
                        InsertDataResponse.Companion companion2 = InsertDataResponse.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(proto, "proto");
                        return companion2.fromProto$connect_client_release(proto);
                    case 1:
                        return (ProtoParcelable) SharedMemory27Impl.INSTANCE.parseParcelUsingSharedMemory(source, new Function1<byte[], InsertDataResponse>() { // from class: androidx.health.platform.client.response.InsertDataResponse$special$$inlined$newCreator$connect_client_release$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final InsertDataResponse invoke(byte[] it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                ResponseProto.InsertDataResponse proto2 = ResponseProto.InsertDataResponse.parseFrom(it);
                                InsertDataResponse.Companion companion3 = InsertDataResponse.INSTANCE;
                                Intrinsics.checkNotNullExpressionValue(proto2, "proto");
                                return companion3.fromProto$connect_client_release(proto2);
                            }
                        });
                    default:
                        throw new IllegalArgumentException("Unknown storage: " + storage);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public InsertDataResponse[] newArray(int size) {
                return new InsertDataResponse[size];
            }
        };
    }
}
