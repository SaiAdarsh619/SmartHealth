package androidx.health.platform.client.request;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.health.platform.client.impl.data.ProtoParcelable;
import androidx.health.platform.client.impl.data.SharedMemory27Impl;
import androidx.health.platform.client.proto.RequestProto;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeleteDataRangeRequest.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m287d2 = {"Landroidx/health/platform/client/request/DeleteDataRangeRequest;", "Landroidx/health/platform/client/impl/data/ProtoParcelable;", "Landroidx/health/platform/client/proto/RequestProto$DeleteDataRangeRequest;", "proto", "(Landroidx/health/platform/client/proto/RequestProto$DeleteDataRangeRequest;)V", "getProto", "()Landroidx/health/platform/client/proto/RequestProto$DeleteDataRangeRequest;", "Companion", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class DeleteDataRangeRequest extends ProtoParcelable<RequestProto.DeleteDataRangeRequest> {
    public static final Parcelable.Creator<DeleteDataRangeRequest> CREATOR;
    private final RequestProto.DeleteDataRangeRequest proto;

    @Override // androidx.health.platform.client.impl.data.ProtoData
    public RequestProto.DeleteDataRangeRequest getProto() {
        return this.proto;
    }

    public DeleteDataRangeRequest(RequestProto.DeleteDataRangeRequest proto) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        this.proto = proto;
    }

    static {
        ProtoParcelable.Companion companion = ProtoParcelable.INSTANCE;
        CREATOR = new Parcelable.Creator<DeleteDataRangeRequest>() { // from class: androidx.health.platform.client.request.DeleteDataRangeRequest$special$$inlined$newCreator$connect_client_release$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r1v4, types: [androidx.health.platform.client.impl.data.ProtoParcelable, androidx.health.platform.client.request.DeleteDataRangeRequest] */
            @Override // android.os.Parcelable.Creator
            public DeleteDataRangeRequest createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                int storage = source.readInt();
                switch (storage) {
                    case 0:
                        byte[] payload = source.createByteArray();
                        if (payload == null) {
                            return null;
                        }
                        RequestProto.DeleteDataRangeRequest proto = RequestProto.DeleteDataRangeRequest.parseFrom(payload);
                        Intrinsics.checkNotNullExpressionValue(proto, "proto");
                        return new DeleteDataRangeRequest(proto);
                    case 1:
                        return (ProtoParcelable) SharedMemory27Impl.INSTANCE.parseParcelUsingSharedMemory(source, new Function1<byte[], DeleteDataRangeRequest>() { // from class: androidx.health.platform.client.request.DeleteDataRangeRequest$special$$inlined$newCreator$connect_client_release$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final DeleteDataRangeRequest invoke(byte[] it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                RequestProto.DeleteDataRangeRequest proto2 = RequestProto.DeleteDataRangeRequest.parseFrom(it);
                                Intrinsics.checkNotNullExpressionValue(proto2, "proto");
                                return new DeleteDataRangeRequest(proto2);
                            }
                        });
                    default:
                        throw new IllegalArgumentException("Unknown storage: " + storage);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DeleteDataRangeRequest[] newArray(int size) {
                return new DeleteDataRangeRequest[size];
            }
        };
    }
}
