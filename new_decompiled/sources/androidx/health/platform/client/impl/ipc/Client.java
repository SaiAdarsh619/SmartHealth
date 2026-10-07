package androidx.health.platform.client.impl.ipc;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.health.platform.client.impl.ipc.internal.BaseQueueOperation;
import androidx.health.platform.client.impl.ipc.internal.ConnectionConfiguration;
import androidx.health.platform.client.impl.ipc.internal.ConnectionManager;
import androidx.health.platform.client.impl.ipc.internal.ExecutionTracker;
import androidx.health.platform.client.impl.ipc.internal.ListenerKey;
import androidx.health.platform.client.impl.ipc.internal.QueueOperation;
import com.google.common.base.Function;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;

/* loaded from: classes14.dex */
public abstract class Client<S extends IInterface> {
    private static final int UNKNOWN_VERSION = -1;
    protected final ConnectionConfiguration mConnectionConfiguration;
    protected final ConnectionManager mConnectionManager;
    protected volatile int mCurrentVersion = -1;
    private final RemoteOperation<S, Integer> mRemoteVersionGetter;
    private final ServiceGetter<S> mServiceGetter;

    /* JADX INFO: Access modifiers changed from: protected */
    public interface ServiceGetter<S> {
        S getService(IBinder iBinder);
    }

    public Client(ClientConfiguration clientConfiguration, ConnectionManager connectionManager, final ServiceGetter<S> serviceGetter, final RemoteOperation<S, Integer> remoteVersionGetter) {
        QueueOperation versionOperation = new QueueOperation() { // from class: androidx.health.platform.client.impl.ipc.Client.1
            @Override // androidx.health.platform.client.impl.ipc.internal.QueueOperation
            public void execute(IBinder binder) throws RemoteException {
                Client.this.mCurrentVersion = ((Integer) remoteVersionGetter.execute((IInterface) serviceGetter.getService(binder))).intValue();
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
                return Client.this.mConnectionConfiguration;
            }
        };
        this.mConnectionConfiguration = new ConnectionConfiguration(clientConfiguration.getServicePackageName(), clientConfiguration.getApiClientName(), clientConfiguration.getBindAction(), versionOperation);
        this.mConnectionManager = connectionManager;
        this.mServiceGetter = serviceGetter;
        this.mRemoteVersionGetter = remoteVersionGetter;
    }

    protected <R> ListenableFuture<R> execute(final RemoteOperation<S, R> operation) {
        return execute(new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ipc.Client$$ExternalSyntheticLambda2
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                settableFuture.set(RemoteOperation.this.execute((IInterface) obj));
            }
        });
    }

    protected <R> ListenableFuture<R> execute(RemoteFutureOperation<S, R> operation) {
        SettableFuture<R> settableFuture = SettableFuture.create();
        this.mConnectionManager.scheduleForExecution(createQueueOperation(operation, settableFuture));
        return settableFuture;
    }

    protected <R> ListenableFuture<R> executeWithVersionCheck(final int minApiVersion, final RemoteFutureOperation<S, R> operation) {
        final SettableFuture<R> settableFuture = SettableFuture.create();
        ListenableFuture<Integer> versionFuture = getCurrentRemoteVersion(false);
        Futures.addCallback(versionFuture, new FutureCallback<Integer>() { // from class: androidx.health.platform.client.impl.ipc.Client.2
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Integer remoteVersion) {
                if (remoteVersion.intValue() < minApiVersion) {
                    Client.this.mConnectionManager.scheduleForExecution(new BaseQueueOperation(Client.this.mConnectionConfiguration));
                    settableFuture.setException(Client.this.getApiVersionCheckFailureException(remoteVersion.intValue(), minApiVersion));
                } else {
                    Client.this.mConnectionManager.scheduleForExecution(Client.this.createQueueOperation(operation, settableFuture));
                }
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable throwable) {
                settableFuture.setException(throwable);
            }
        }, MoreExecutors.directExecutor());
        return settableFuture;
    }

    protected ListenableFuture<Integer> getCurrentRemoteVersion(boolean z) {
        if (this.mCurrentVersion == -1 || z) {
            return Futures.transform(execute(this.mRemoteVersionGetter), new Function() { // from class: androidx.health.platform.client.impl.ipc.Client$$ExternalSyntheticLambda1
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return Client.this.m48x4bf610cf((Integer) obj);
                }
            }, MoreExecutors.directExecutor());
        }
        return Futures.immediateFuture(Integer.valueOf(this.mCurrentVersion));
    }

    /* renamed from: lambda$getCurrentRemoteVersion$1$androidx-health-platform-client-impl-ipc-Client */
    /* synthetic */ Integer m48x4bf610cf(Integer version) {
        this.mCurrentVersion = version.intValue();
        return Integer.valueOf(this.mCurrentVersion);
    }

    protected <R> ListenableFuture<R> registerListener(ListenerKey listenerKey, final RemoteOperation<S, R> registerListenerOperation) {
        return registerListener(listenerKey, new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ipc.Client$$ExternalSyntheticLambda0
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                settableFuture.set(RemoteOperation.this.execute((IInterface) obj));
            }
        });
    }

    protected <R> ListenableFuture<R> registerListener(ListenerKey listenerKey, RemoteFutureOperation<S, R> registerListenerOperation) {
        SettableFuture<R> settableFuture = SettableFuture.create();
        this.mConnectionManager.registerListener(listenerKey, createQueueOperation(registerListenerOperation, settableFuture));
        return settableFuture;
    }

    protected <R> ListenableFuture<R> unregisterListener(ListenerKey listenerKey, final RemoteOperation<S, R> unregisterListenerOperation) {
        return unregisterListener(listenerKey, new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ipc.Client$$ExternalSyntheticLambda3
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                settableFuture.set(RemoteOperation.this.execute((IInterface) obj));
            }
        });
    }

    protected <R> ListenableFuture<R> unregisterListener(ListenerKey listenerKey, RemoteFutureOperation<S, R> unregisterListenerOperation) {
        SettableFuture<R> settableFuture = SettableFuture.create();
        this.mConnectionManager.unregisterListener(listenerKey, createQueueOperation(unregisterListenerOperation, settableFuture));
        return settableFuture;
    }

    protected Exception getApiVersionCheckFailureException(int currentVersion, int minApiVersion) {
        return new ApiVersionException(currentVersion, minApiVersion);
    }

    ConnectionConfiguration getConnectionConfiguration() {
        return this.mConnectionConfiguration;
    }

    ConnectionManager getConnectionManager() {
        return this.mConnectionManager;
    }

    <R> QueueOperation createQueueOperation(final RemoteFutureOperation<S, R> operation, final SettableFuture<R> settableFuture) {
        return new BaseQueueOperation(this.mConnectionConfiguration) { // from class: androidx.health.platform.client.impl.ipc.Client.3
            @Override // androidx.health.platform.client.impl.ipc.internal.BaseQueueOperation, androidx.health.platform.client.impl.ipc.internal.QueueOperation
            public void execute(IBinder binder) throws RemoteException {
                operation.execute(Client.this.getService(binder), settableFuture);
            }

            @Override // androidx.health.platform.client.impl.ipc.internal.BaseQueueOperation, androidx.health.platform.client.impl.ipc.internal.QueueOperation
            public void setException(Throwable exception) {
                settableFuture.setException(exception);
            }

            @Override // androidx.health.platform.client.impl.ipc.internal.BaseQueueOperation, androidx.health.platform.client.impl.ipc.internal.QueueOperation
            public QueueOperation trackExecution(ExecutionTracker tracker) {
                tracker.track(settableFuture);
                return this;
            }
        };
    }

    S getService(IBinder binder) {
        return this.mServiceGetter.getService(binder);
    }
}
