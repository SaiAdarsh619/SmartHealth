package androidx.health.platform.client.impl.permission.foregroundstate;

import android.app.ActivityManager;
/* loaded from: classes14.dex */
public final class ForegroundStateChecker {
    private ForegroundStateChecker() {
    }

    public static boolean isInForeground() {
        ActivityManager.RunningAppProcessInfo appProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(appProcessInfo);
        int importance = appProcessInfo.importance;
        return importance == 100 || importance == 125 || importance == 200;
    }
}
