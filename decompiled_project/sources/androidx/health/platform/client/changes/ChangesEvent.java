package androidx.health.platform.client.changes;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.health.platform.client.impl.data.ProtoParcelable;
import androidx.health.platform.client.impl.data.SharedMemory27Impl;
import androidx.health.platform.client.proto.ChangeProto;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ChangesEvent.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Landroidx/health/platform/client/changes/ChangesEvent;", "Landroidx/health/platform/client/impl/data/ProtoParcelable;", "Landroidx/health/platform/client/proto/ChangeProto$ChangesEvent;", "proto", "(Landroidx/health/platform/client/proto/ChangeProto$ChangesEvent;)V", "getProto", "()Landroidx/health/platform/client/proto/ChangeProto$ChangesEvent;", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes14.dex */
public final class ChangesEvent extends ProtoParcelable<ChangeProto.ChangesEvent> {
    public static final Parcelable.Creator<ChangesEvent> CREATOR;
    public static final Companion Companion = new Companion(null);
    private final ChangeProto.ChangesEvent proto;

    @Override // androidx.health.platform.client.impl.data.ProtoData
    public ChangeProto.ChangesEvent getProto() {
        return this.proto;
    }

    /* compiled from: ChangesEvent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/health/platform/client/changes/ChangesEvent$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/health/platform/client/changes/ChangesEvent;", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ChangesEvent(ChangeProto.ChangesEvent proto) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        this.proto = proto;
    }

    static {
        ProtoParcelable.Companion companion = ProtoParcelable.Companion;
        CREATOR = new Parcelable.Creator<ChangesEvent>() { // from class: androidx.health.platform.client.changes.ChangesEvent$special$$inlined$newCreator$connect_client_release$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r1v4, types: [androidx.health.platform.client.changes.ChangesEvent, androidx.health.platform.client.impl.data.ProtoParcelable] */
            @Override // android.os.Parcelable.Creator
            public ChangesEvent createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                int storage = source.readInt();
                switch (storage) {
                    case 0:
                        byte[] payload = source.createByteArray();
                        if (payload == null) {
                            return null;
                        }
                        ChangeProto.ChangesEvent proto = ChangeProto.ChangesEvent.parseFrom(payload);
                        Intrinsics.checkNotNullExpressionValue(proto, "proto");
                        return new ChangesEvent(proto);
                    case 1:
                        return (ProtoParcelable) SharedMemory27Impl.INSTANCE.parseParcelUsingSharedMemory(source, new Function1<byte[], ChangesEvent>() { // from class: androidx.health.platform.client.changes.ChangesEvent$special$$inlined$newCreator$connect_client_release$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final ChangesEvent invoke(byte[] it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                ChangeProto.ChangesEvent proto2 = ChangeProto.ChangesEvent.parseFrom(it);
                                Intrinsics.checkNotNullExpressionValue(proto2, "proto");
                                return new ChangesEvent(proto2);
                            }
                        });
                    default:
                        throw new IllegalArgumentException("Unknown storage: " + storage);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ChangesEvent[] newArray(int size) {
                return new ChangesEvent[size];
            }
        };
    }
}
