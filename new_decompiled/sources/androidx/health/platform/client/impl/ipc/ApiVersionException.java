package androidx.health.platform.client.impl.ipc;

import java.util.concurrent.ExecutionException;

/* loaded from: classes14.dex */
public class ApiVersionException extends ExecutionException {
    private final int mMinVersion;
    private final int mRemoteVersion;

    public ApiVersionException(int remoteVersion, int minVersion) {
        super("Version requirements for calling the method was not met, remoteVersion: " + remoteVersion + ", minVersion: " + minVersion);
        this.mRemoteVersion = remoteVersion;
        this.mMinVersion = minVersion;
    }

    public int getRemoteVersion() {
        return this.mRemoteVersion;
    }

    public int getMinVersion() {
        return this.mMinVersion;
    }
}
