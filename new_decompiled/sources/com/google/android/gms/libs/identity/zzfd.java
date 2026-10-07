package com.google.android.gms.libs.identity;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* loaded from: classes14.dex */
public final class zzfd {
    public static boolean zza(CountDownLatch countDownLatch, long j, TimeUnit timeUnit) {
        boolean await;
        boolean z = false;
        try {
            long nanos = timeUnit.toNanos(30L);
            long nanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    try {
                        await = countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
                        break;
                    } catch (InterruptedException e) {
                        z = true;
                        nanos = nanoTime - System.nanoTime();
                    }
                } catch (Throwable th) {
                    th = th;
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return await;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
