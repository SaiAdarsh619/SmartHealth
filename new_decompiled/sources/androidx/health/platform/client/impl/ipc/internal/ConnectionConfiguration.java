package androidx.health.platform.client.impl.ipc.internal;

import com.google.common.base.Preconditions;

/* loaded from: classes14.dex */
public final class ConnectionConfiguration {
    private final String mBindAction;
    private final String mClientName;
    private final String mPackageName;
    private final QueueOperation mRefreshVersionOperation;

    public ConnectionConfiguration(String packageName, String clientName, String bindAction, QueueOperation refreshVersionOperation) {
        this.mPackageName = (String) Preconditions.checkNotNull(packageName);
        this.mClientName = (String) Preconditions.checkNotNull(clientName);
        this.mBindAction = (String) Preconditions.checkNotNull(bindAction);
        this.mRefreshVersionOperation = (QueueOperation) Preconditions.checkNotNull(refreshVersionOperation);
    }

    String getKey() {
        return String.format("%s#%s#%s", this.mClientName, this.mPackageName, this.mBindAction);
    }

    String getClientName() {
        return this.mClientName;
    }

    String getBindAction() {
        return this.mBindAction;
    }

    String getPackageName() {
        return this.mPackageName;
    }

    QueueOperation getRefreshVersionOperation() {
        return this.mRefreshVersionOperation;
    }
}
