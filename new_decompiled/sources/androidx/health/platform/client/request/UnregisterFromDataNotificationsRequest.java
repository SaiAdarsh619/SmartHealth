package androidx.health.platform.client.request;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.health.platform.client.impl.data.ProtoParcelable;
import androidx.health.platform.client.impl.data.SharedMemory27Impl;
import androidx.health.platform.client.proto.RequestProto;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnregisterFromDataNotificationsRequest.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m287d2 = {"Landroidx/health/platform/client/request/UnregisterFromDataNotificationsRequest;", "Landroidx/health/platform/client/impl/data/ProtoParcelable;", "Landroidx/health/platform/client/proto/RequestProto$UnregisterFromDataNotificationsRequest;", "proto", "(Landroidx/health/platform/client/proto/RequestProto$UnregisterFromDataNotificationsRequest;)V", "getProto", "()Landroidx/health/platform/client/proto/RequestProto$UnregisterFromDataNotificationsRequest;", "Companion", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class UnregisterFromDataNotificationsRequest extends ProtoParcelable<RequestProto.UnregisterFromDataNotificationsRequest> {
    public static final Parcelable.Creator<UnregisterFromDataNotificationsRequest> CREATOR;
    private final RequestProto.UnregisterFromDataNotificationsRequest proto;

    @Override // androidx.health.platform.client.impl.data.ProtoData
    public RequestProto.UnregisterFromDataNotificationsRequest getProto() {
        return this.proto;
    }

    public UnregisterFromDataNotificationsRequest(RequestProto.UnregisterFromDataNotificationsRequest proto) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        this.proto = proto;
    }

    static {
        ProtoParcelable.Companion companion = ProtoParcelable.INSTANCE;
        CREATOR = new Parcelable.Creator<UnregisterFromDataNotificationsRequest>() { // from class: androidx.health.platform.client.request.UnregisterFromDataNotificationsRequest$special$$inlined$newCreator$connect_client_release$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r1v4, types: [androidx.health.platform.client.impl.data.ProtoParcelable, androidx.health.platform.client.request.UnregisterFromDataNotificationsRequest] */
            @Override // android.os.Parcelable.Creator
            public UnregisterFromDataNotificationsRequest createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                int storage = source.readInt();
                switch (storage) {
                    case 0:
                        byte[] payload = source.createByteArray();
                        if (payload == null) {
                            return null;
                        }
                        RequestProto.UnregisterFromDataNotificationsRequest parseFrom = RequestProto.UnregisterFromDataNotificationsRequest.parseFrom(payload);
                        Intrinsics.checkNotNullExpressionValue(parseFrom, "parseFrom(it)");
                        return new UnregisterFromDataNotificationsRequest(parseFrom);
                    case 1:
                        return (ProtoParcelable) SharedMemory27Impl.INSTANCE.parseParcelUsingSharedMemory(source, new Function1<byte[], UnregisterFromDataNotificationsRequest>() { // from class: androidx.health.platform.client.request.UnregisterFromDataNotificationsRequest$special$$inlined$newCreator$connect_client_release$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final UnregisterFromDataNotificationsRequest invoke(byte[] it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                RequestProto.UnregisterFromDataNotificationsRequest parseFrom2 = RequestProto.UnregisterFromDataNotificationsRequest.parseFrom(it);
                                Intrinsics.checkNotNullExpressionValue(parseFrom2, "parseFrom(it)");
                                return new UnregisterFromDataNotificationsRequest(parseFrom2);
                            }
                        });
                    default:
                        throw new IllegalArgumentException("Unknown storage: " + storage);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public UnregisterFromDataNotificationsRequest[] newArray(int size) {
                return new UnregisterFromDataNotificationsRequest[size];
            }
        };
    }
}
