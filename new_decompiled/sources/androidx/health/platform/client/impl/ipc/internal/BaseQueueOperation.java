package androidx.health.platform.client.impl.ipc.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.common.base.Preconditions;

/* loaded from: classes14.dex */
public class BaseQueueOperation implements QueueOperation {
    private final ConnectionConfiguration mConnectionConfiguration;

    public BaseQueueOperation(ConnectionConfiguration connectionConfiguration) {
        this.mConnectionConfiguration = (ConnectionConfiguration) Preconditions.checkNotNull(connectionConfiguration);
    }

    @Override // androidx.health.platform.client.impl.ipc.internal.QueueOperation
    public void execute(IBinder binder) throws RemoteException {
    }

    @Override // androidx.health.platform.client.impl.ipc.internal.QueueOperation
    public void setException(Throwable exception) {
    }

    @Override // androidx.health.platform.client.impl.ipc.internal.QueueOperation
    public QueueOperation trackExecution(ExecutionTracker tracker) {
        return this;
    }

    @Override // androidx.health.platform.client.impl.ipc.internal.QueueOperation
    public ConnectionConfiguration getConnectionConfiguration() {
        return this.mConnectionConfiguration;
    }
}
