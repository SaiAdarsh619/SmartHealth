package androidx.health.platform.client.request;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.health.platform.client.impl.data.ProtoParcelable;
import androidx.health.platform.client.impl.data.SharedMemory27Impl;
import androidx.health.platform.client.proto.RequestProto;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestContext.kt */
@Metadata(m286d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0007\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR!\u0010\u000f\u001a\u00020\u00028VX\u0096\u0084\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, m287d2 = {"Landroidx/health/platform/client/request/RequestContext;", "Landroidx/health/platform/client/impl/data/ProtoParcelable;", "Landroidx/health/platform/client/proto/RequestProto$RequestContext;", "callingPackage", "", "sdkVersion", "", "permissionToken", "isInForeground", "", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getCallingPackage", "()Ljava/lang/String;", "()Z", "getPermissionToken", "proto", "getProto$annotations", "()V", "getProto", "()Landroidx/health/platform/client/proto/RequestProto$RequestContext;", "proto$delegate", "Lkotlin/Lazy;", "getSdkVersion", "()I", "Companion", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class RequestContext extends ProtoParcelable<RequestProto.RequestContext> {
    public static final Parcelable.Creator<RequestContext> CREATOR;
    private final String callingPackage;
    private final boolean isInForeground;
    private final String permissionToken;

    /* renamed from: proto$delegate, reason: from kotlin metadata */
    private final Lazy proto;
    private final int sdkVersion;

    public static /* synthetic */ void getProto$annotations() {
    }

    public final String getCallingPackage() {
        return this.callingPackage;
    }

    public final int getSdkVersion() {
        return this.sdkVersion;
    }

    public final String getPermissionToken() {
        return this.permissionToken;
    }

    /* renamed from: isInForeground, reason: from getter */
    public final boolean getIsInForeground() {
        return this.isInForeground;
    }

    public RequestContext(String callingPackage, int sdkVersion, String permissionToken, boolean isInForeground) {
        Intrinsics.checkNotNullParameter(callingPackage, "callingPackage");
        this.callingPackage = callingPackage;
        this.sdkVersion = sdkVersion;
        this.permissionToken = permissionToken;
        this.isInForeground = isInForeground;
        this.proto = LazyKt.lazy(new Function0<RequestProto.RequestContext>() { // from class: androidx.health.platform.client.request.RequestContext$proto$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RequestProto.RequestContext invoke() {
                RequestContext obj = RequestContext.this;
                RequestProto.RequestContext.Builder $this$invoke_u24lambda_u241 = RequestProto.RequestContext.newBuilder().setCallingPackage(obj.getCallingPackage()).setSdkVersion(obj.getSdkVersion());
                String it = obj.getPermissionToken();
                if (it != null) {
                    $this$invoke_u24lambda_u241.setPermissionToken(it);
                }
                return $this$invoke_u24lambda_u241.setIsInForeground(obj.getIsInForeground()).build();
            }
        });
    }

    @Override // androidx.health.platform.client.impl.data.ProtoData
    public RequestProto.RequestContext getProto() {
        Object value = this.proto.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-proto>(...)");
        return (RequestProto.RequestContext) value;
    }

    static {
        ProtoParcelable.Companion companion = ProtoParcelable.INSTANCE;
        CREATOR = new Parcelable.Creator<RequestContext>() { // from class: androidx.health.platform.client.request.RequestContext$special$$inlined$newCreator$connect_client_release$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r1v4, types: [androidx.health.platform.client.impl.data.ProtoParcelable, androidx.health.platform.client.request.RequestContext] */
            @Override // android.os.Parcelable.Creator
            public RequestContext createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                int storage = source.readInt();
                switch (storage) {
                    case 0:
                        byte[] payload = source.createByteArray();
                        if (payload == null) {
                            return null;
                        }
                        RequestProto.RequestContext $this$CREATOR_u24lambda_u241_u24lambda_u240 = RequestProto.RequestContext.parseFrom(payload);
                        String callingPackage = $this$CREATOR_u24lambda_u241_u24lambda_u240.getCallingPackage();
                        Intrinsics.checkNotNullExpressionValue(callingPackage, "callingPackage");
                        return new RequestContext(callingPackage, $this$CREATOR_u24lambda_u241_u24lambda_u240.getSdkVersion(), $this$CREATOR_u24lambda_u241_u24lambda_u240.getPermissionToken(), $this$CREATOR_u24lambda_u241_u24lambda_u240.getIsInForeground());
                    case 1:
                        return (ProtoParcelable) SharedMemory27Impl.INSTANCE.parseParcelUsingSharedMemory(source, new Function1<byte[], RequestContext>() { // from class: androidx.health.platform.client.request.RequestContext$special$$inlined$newCreator$connect_client_release$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final RequestContext invoke(byte[] it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                RequestProto.RequestContext $this$CREATOR_u24lambda_u241_u24lambda_u2402 = RequestProto.RequestContext.parseFrom(it);
                                String callingPackage2 = $this$CREATOR_u24lambda_u241_u24lambda_u2402.getCallingPackage();
                                Intrinsics.checkNotNullExpressionValue(callingPackage2, "callingPackage");
                                return new RequestContext(callingPackage2, $this$CREATOR_u24lambda_u241_u24lambda_u2402.getSdkVersion(), $this$CREATOR_u24lambda_u241_u24lambda_u2402.getPermissionToken(), $this$CREATOR_u24lambda_u241_u24lambda_u2402.getIsInForeground());
                            }
                        });
                    default:
                        throw new IllegalArgumentException("Unknown storage: " + storage);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RequestContext[] newArray(int size) {
                return new RequestContext[size];
            }
        };
    }
}
