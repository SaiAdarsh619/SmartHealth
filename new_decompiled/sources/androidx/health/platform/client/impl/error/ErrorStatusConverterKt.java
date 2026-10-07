package androidx.health.platform.client.impl.error;

import android.os.RemoteException;
import androidx.health.platform.client.error.ErrorStatus;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: ErrorStatusConverter.kt */
@Metadata(m286d1 = {"\u0000 \n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0007\u001a\u00060\u0004j\u0002`\b*\u00020\tH\u0000\"(\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, m287d2 = {"errorCodeExceptionMap", "", "", "Lkotlin/reflect/KClass;", "Ljava/lang/Exception;", "getErrorCodeExceptionMap", "()Ljava/util/Map;", "toException", "Lkotlin/Exception;", "Landroidx/health/platform/client/error/ErrorStatus;", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class ErrorStatusConverterKt {
    private static final Map<Integer, KClass<? extends Exception>> errorCodeExceptionMap = MapsKt.mapOf(TuplesKt.m294to(1, Reflection.getOrCreateKotlinClass(UnsupportedOperationException.class)), TuplesKt.m294to(2, Reflection.getOrCreateKotlinClass(UnsupportedOperationException.class)), TuplesKt.m294to(3, Reflection.getOrCreateKotlinClass(UnsupportedOperationException.class)), TuplesKt.m294to(4, Reflection.getOrCreateKotlinClass(SecurityException.class)), TuplesKt.m294to(10000, Reflection.getOrCreateKotlinClass(SecurityException.class)), TuplesKt.m294to(10001, Reflection.getOrCreateKotlinClass(SecurityException.class)), TuplesKt.m294to(10002, Reflection.getOrCreateKotlinClass(IllegalArgumentException.class)), TuplesKt.m294to(10003, Reflection.getOrCreateKotlinClass(SecurityException.class)), TuplesKt.m294to(10004, Reflection.getOrCreateKotlinClass(SecurityException.class)), TuplesKt.m294to(10005, Reflection.getOrCreateKotlinClass(RemoteException.class)), TuplesKt.m294to(10006, Reflection.getOrCreateKotlinClass(IOException.class)), TuplesKt.m294to(10007, Reflection.getOrCreateKotlinClass(RemoteException.class)), TuplesKt.m294to(10008, Reflection.getOrCreateKotlinClass(RemoteException.class)), TuplesKt.m294to(10010, Reflection.getOrCreateKotlinClass(RemoteException.class)));

    public static final Map<Integer, KClass<? extends Exception>> getErrorCodeExceptionMap() {
        return errorCodeExceptionMap;
    }

    public static final Exception toException(ErrorStatus $this$toException) {
        Intrinsics.checkNotNullParameter($this$toException, "<this>");
        KClass it = errorCodeExceptionMap.get(Integer.valueOf($this$toException.getErrorCode()));
        if (it != null) {
            if (Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(SecurityException.class))) {
                return new SecurityException($this$toException.getErrorMessage());
            }
            if (Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(RemoteException.class))) {
                return new RemoteException($this$toException.getErrorMessage());
            }
            return Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(IllegalArgumentException.class)) ? new IllegalArgumentException($this$toException.getErrorMessage()) : Intrinsics.areEqual(it, Reflection.getOrCreateKotlinClass(IOException.class)) ? new IOException($this$toException.getErrorMessage()) : new UnsupportedOperationException($this$toException.getErrorMessage());
        }
        return new UnsupportedOperationException($this$toException.getErrorMessage());
    }
}
