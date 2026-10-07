package androidx.health.platform.client.impl.data;

import android.os.Parcel;
import android.os.SharedMemory;
import android.system.OsConstants;
import androidx.autofill.HintConstants;
import java.io.Closeable;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SharedMemory27Impl.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00040\b¢\u0006\u0002\u0010\nJ&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012¨\u0006\u0013"}, d2 = {"Landroidx/health/platform/client/impl/data/SharedMemory27Impl;", "", "()V", "parseParcelUsingSharedMemory", "U", "source", "Landroid/os/Parcel;", "parser", "Lkotlin/Function1;", "", "(Landroid/os/Parcel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeToParcelUsingSharedMemory", "", HintConstants.AUTOFILL_HINT_NAME, "", "bytes", "dest", "flags", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes14.dex */
public final class SharedMemory27Impl {
    public static final SharedMemory27Impl INSTANCE = new SharedMemory27Impl();

    private SharedMemory27Impl() {
    }

    public final void writeToParcelUsingSharedMemory(String name, byte[] bytes, Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(dest, "dest");
        SharedMemory create = SharedMemory.create(name, bytes.length);
        try {
            SharedMemory memory = create;
            memory.setProtect(OsConstants.PROT_READ | OsConstants.PROT_WRITE);
            memory.mapReadWrite().put(bytes);
            memory.setProtect(OsConstants.PROT_READ);
            memory.writeToParcel(dest, flags);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(create, null);
        } finally {
        }
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, byte[]] */
    public final <U> U parseParcelUsingSharedMemory(Parcel source, Function1<? super byte[], ? extends U> parser) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(parser, "parser");
        Closeable closeable = (Closeable) SharedMemory.CREATOR.createFromParcel(source);
        try {
            SharedMemory memory = (SharedMemory) closeable;
            ByteBuffer buffer = memory.mapReadOnly();
            Intrinsics.checkNotNullExpressionValue(buffer, "memory.mapReadOnly()");
            ?? r4 = new byte[buffer.remaining()];
            buffer.get((byte[]) r4);
            U invoke = parser.invoke(r4);
            CloseableKt.closeFinally(closeable, null);
            return invoke;
        } finally {
        }
    }
}
