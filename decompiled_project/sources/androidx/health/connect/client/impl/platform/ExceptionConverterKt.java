package androidx.health.connect.client.impl.platform;

import android.health.connect.HealthConnectException;
import android.os.RemoteException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ExceptionConverter.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"toKtException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Landroid/health/connect/HealthConnectException;", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes14.dex */
public final class ExceptionConverterKt {
    public static final Exception toKtException(HealthConnectException $this$toKtException) {
        Intrinsics.checkNotNullParameter($this$toKtException, "<this>");
        switch ($this$toKtException.getErrorCode()) {
            case 3:
                return new IllegalArgumentException((Throwable) $this$toKtException);
            case 4:
                return new IOException((Throwable) $this$toKtException);
            case 5:
                return new SecurityException((Throwable) $this$toKtException);
            case 6:
                return new RemoteException($this$toKtException.getMessage());
            default:
                return new IllegalStateException((Throwable) $this$toKtException);
        }
    }
}
