package androidx.startup;

import android.util.Log;

/* loaded from: classes14.dex */
public final class StartupLogger {
    static final boolean DEBUG = false;
    private static final String TAG = "StartupLogger";

    private StartupLogger() {
    }

    /* renamed from: i */
    public static void m67i(String message) {
        Log.i(TAG, message);
    }

    /* renamed from: w */
    public static void m68w(String message) {
        Log.w(TAG, message);
    }

    /* renamed from: e */
    public static void m66e(String message, Throwable throwable) {
        Log.e(TAG, message, throwable);
    }
}
