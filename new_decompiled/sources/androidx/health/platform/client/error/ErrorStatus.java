package androidx.health.platform.client.error;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.health.platform.client.impl.data.ProtoParcelable;
import androidx.health.platform.client.impl.data.SharedMemory27Impl;
import androidx.health.platform.client.proto.ErrorProto;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ErrorStatus.kt */
@Metadata(m286d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u001b\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\u00028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, m287d2 = {"Landroidx/health/platform/client/error/ErrorStatus;", "Landroidx/health/platform/client/impl/data/ProtoParcelable;", "Landroidx/health/platform/client/proto/ErrorProto$ErrorStatus;", "errorCode", "", "errorMessage", "", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "proto", "getProto", "()Landroidx/health/platform/client/proto/ErrorProto$ErrorStatus;", "proto$delegate", "Lkotlin/Lazy;", "Companion", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class ErrorStatus extends ProtoParcelable<ErrorProto.ErrorStatus> {
    public static final Parcelable.Creator<ErrorStatus> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int errorCode;
    private final String errorMessage;

    /* renamed from: proto$delegate, reason: from kotlin metadata */
    private final Lazy proto;

    public /* synthetic */ ErrorStatus(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str);
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public ErrorStatus(@ErrorCode int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.proto = LazyKt.lazy(new Function0<ErrorProto.ErrorStatus>() { // from class: androidx.health.platform.client.error.ErrorStatus$proto$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ErrorProto.ErrorStatus invoke() {
                ErrorProto.ErrorStatus.Builder builder = ErrorProto.ErrorStatus.newBuilder().setCode(ErrorStatus.this.getErrorCode());
                String p0 = ErrorStatus.this.getErrorMessage();
                if (p0 != null) {
                    Intrinsics.checkNotNullExpressionValue(builder, "builder");
                    builder.setMessage(p0);
                }
                return builder.build();
            }
        });
    }

    @Override // androidx.health.platform.client.impl.data.ProtoData
    public ErrorProto.ErrorStatus getProto() {
        Object value = this.proto.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-proto>(...)");
        return (ErrorProto.ErrorStatus) value;
    }

    /* compiled from: ErrorStatus.kt */
    @Metadata(m286d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m287d2 = {"Landroidx/health/platform/client/error/ErrorStatus$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/health/platform/client/error/ErrorStatus;", "create", "errorCode", "", "errorMessage", "", "safeErrorCode", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ErrorStatus create$default(Companion companion, int i, String str, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                str = null;
            }
            return companion.create(i, str);
        }

        @JvmStatic
        public final ErrorStatus create(int errorCode, String errorMessage) {
            return new ErrorStatus(safeErrorCode(errorCode), errorMessage);
        }

        @JvmStatic
        public final ErrorStatus create(int errorCode) {
            return create$default(this, errorCode, null, 2, null);
        }

        @ErrorCode
        public final int safeErrorCode(int errorCode) {
            Object obj;
            Field[] declaredFields = ErrorCode.class.getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(declaredFields, "ErrorCode::class\n       …          .declaredFields");
            Collection destination$iv$iv = new ArrayList();
            for (Field field : declaredFields) {
                Field it = field;
                if (it.getType().isAssignableFrom(Integer.TYPE)) {
                    destination$iv$iv.add(field);
                }
            }
            Iterable $this$map$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            Iterator it2 = $this$map$iv.iterator();
            while (true) {
                int i = 10007;
                obj = null;
                if (!it2.hasNext()) {
                    break;
                }
                Object item$iv$iv = it2.next();
                Field field2 = (Field) item$iv$iv;
                try {
                    Object obj2 = field2.get(null);
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                    i = ((Integer) obj2).intValue();
                } catch (IllegalAccessException e) {
                }
                destination$iv$iv2.add(Integer.valueOf(i));
            }
            Iterable $this$firstOrNull$iv = (List) destination$iv$iv2;
            Iterator it3 = $this$firstOrNull$iv.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object element$iv = it3.next();
                int value = ((Number) element$iv).intValue();
                if (value == errorCode) {
                    obj = element$iv;
                    break;
                }
            }
            Integer num = (Integer) obj;
            if (num != null) {
                return num.intValue();
            }
            return 10007;
        }
    }

    @JvmStatic
    public static final ErrorStatus create(int errorCode) {
        return INSTANCE.create(errorCode);
    }

    @JvmStatic
    public static final ErrorStatus create(int errorCode, String errorMessage) {
        return INSTANCE.create(errorCode, errorMessage);
    }

    static {
        ProtoParcelable.Companion companion = ProtoParcelable.INSTANCE;
        CREATOR = new Parcelable.Creator<ErrorStatus>() { // from class: androidx.health.platform.client.error.ErrorStatus$special$$inlined$newCreator$connect_client_release$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r1v3, types: [androidx.health.platform.client.error.ErrorStatus, androidx.health.platform.client.impl.data.ProtoParcelable] */
            @Override // android.os.Parcelable.Creator
            public ErrorStatus createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                int storage = source.readInt();
                switch (storage) {
                    case 0:
                        byte[] payload = source.createByteArray();
                        if (payload == null) {
                            return null;
                        }
                        ErrorProto.ErrorStatus proto = ErrorProto.ErrorStatus.parseFrom(payload);
                        return ErrorStatus.INSTANCE.create(proto.getCode(), proto.hasMessage() ? proto.getMessage() : null);
                    case 1:
                        return (ProtoParcelable) SharedMemory27Impl.INSTANCE.parseParcelUsingSharedMemory(source, new Function1<byte[], ErrorStatus>() { // from class: androidx.health.platform.client.error.ErrorStatus$special$$inlined$newCreator$connect_client_release$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final ErrorStatus invoke(byte[] it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                ErrorProto.ErrorStatus proto2 = ErrorProto.ErrorStatus.parseFrom(it);
                                return ErrorStatus.INSTANCE.create(proto2.getCode(), proto2.hasMessage() ? proto2.getMessage() : null);
                            }
                        });
                    default:
                        throw new IllegalArgumentException("Unknown storage: " + storage);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ErrorStatus[] newArray(int size) {
                return new ErrorStatus[size];
            }
        };
    }
}
