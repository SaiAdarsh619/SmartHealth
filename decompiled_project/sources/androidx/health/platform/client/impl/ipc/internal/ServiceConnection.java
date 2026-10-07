package androidx.health.platform.client.impl.ipc.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.health.platform.client.impl.logger.Logger;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes14.dex */
public class ServiceConnection implements android.content.ServiceConnection {
    private static final int MAX_RETRIES = 10;
    private static final String TAG = "ServiceConnection";
    IBinder mBinder;
    private final Callback mCallback;
    private final ConnectionConfiguration mConnectionConfiguration;
    private final Context mContext;
    private final ExecutionTracker mExecutionTracker;
    volatile boolean mIsServiceBound;
    private int mServiceConnectionRetry;
    private final Queue<QueueOperation> mOperationQueue = new ConcurrentLinkedQueue();
    private final Map<ListenerKey, QueueOperation> mRegisteredListeners = new HashMap();
    private final IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { // from class: androidx.health.platform.client.impl.ipc.internal.ServiceConnection$$ExternalSyntheticLambda0
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            ServiceConnection.this.m4357xb72a76d7();
        }
    };

    /* loaded from: classes14.dex */
    public interface Callback {
        boolean isBindToSelfEnabled();

        void onConnected(ServiceConnection serviceConnection);

        void onDisconnected(ServiceConnection serviceConnection, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceConnection(Context context, ConnectionConfiguration connectionConfiguration, ExecutionTracker executionTracker, Callback callback) {
        this.mContext = (Context) Preconditions.checkNotNull(context);
        this.mConnectionConfiguration = (ConnectionConfiguration) Preconditions.checkNotNull(connectionConfiguration);
        this.mExecutionTracker = (ExecutionTracker) Preconditions.checkNotNull(executionTracker);
        this.mCallback = (Callback) Preconditions.checkNotNull(callback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$androidx-health-platform-client-impl-ipc-internal-ServiceConnection  reason: not valid java name */
    public /* synthetic */ void m4357xb72a76d7() {
        Logger.warning(TAG, "Binder died for client:" + this.mConnectionConfiguration.getClientName());
        handleRetriableDisconnection(new RemoteException("Binder died"));
    }

    private String getBindPackageName() {
        if (this.mCallback.isBindToSelfEnabled()) {
            return this.mContext.getPackageName();
        }
        return this.mConnectionConfiguration.getPackageName();
    }

    public void connect() {
        if (this.mIsServiceBound) {
            return;
        }
        try {
            this.mIsServiceBound = this.mContext.bindService(new Intent().setPackage(getBindPackageName()).setAction(this.mConnectionConfiguration.getBindAction()), this, 129);
            if (!this.mIsServiceBound) {
                Logger.error(TAG, "Connection to service is not available for package '" + this.mConnectionConfiguration.getPackageName() + "' and action '" + this.mConnectionConfiguration.getBindAction() + "'.");
                handleNonRetriableDisconnection(new RemoteException("Binding to service failed"));
            }
        } catch (SecurityException exception) {
            Logger.warning(TAG, "Failed to bind connection '" + this.mConnectionConfiguration.getKey() + "', no permission or service not found.", exception);
            this.mIsServiceBound = false;
            this.mBinder = null;
            throw exception;
        }
    }

    private void handleNonRetriableDisconnection(Throwable throwable) {
        this.mServiceConnectionRetry = 10;
        handleRetriableDisconnection(throwable);
    }

    private synchronized void handleRetriableDisconnection(Throwable throwable) {
        if (isConnected()) {
            Logger.warning(TAG, "Connection is already re-established. No need to reconnect again");
            return;
        }
        clearConnection(throwable);
        if (this.mServiceConnectionRetry < 10) {
            Logger.warning(TAG, "WCS SDK Client '" + this.mConnectionConfiguration.getClientName() + "' disconnected, retrying connection. Retry attempt: " + this.mServiceConnectionRetry, throwable);
            this.mCallback.onDisconnected(this, getRetryDelayMs(this.mServiceConnectionRetry));
        } else {
            Logger.error(TAG, "Connection disconnected and maximum number of retries reached.", throwable);
        }
    }

    private static int getRetryDelayMs(int retryNumber) {
        return 200 << retryNumber;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean clearConnectionIfIdle() {
        if (this.mOperationQueue.isEmpty() && this.mRegisteredListeners.isEmpty()) {
            tryClearConnection();
            return true;
        }
        return false;
    }

    void clearConnection(Throwable throwable) {
        tryClearConnection();
        this.mExecutionTracker.cancelPendingFutures(throwable);
        cancelAllOperationsInQueue(throwable);
    }

    private void tryClearConnection() {
        if (this.mIsServiceBound) {
            try {
                this.mContext.unbindService(this);
            } catch (IllegalArgumentException e) {
                Logger.error(TAG, "Failed to unbind the service. Ignoring and continuing", e);
            }
            this.mIsServiceBound = false;
        }
        if (this.mBinder != null) {
            try {
                this.mBinder.unlinkToDeath(this.mDeathRecipient, 0);
            } catch (NoSuchElementException e2) {
                Logger.error(TAG, "mDeathRecipient not linked", e2);
            }
            this.mBinder = null;
        }
        Logger.debug(TAG, "unbindService called");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enqueue(QueueOperation operation) {
        if (isConnected()) {
            execute(operation);
            return;
        }
        this.mOperationQueue.add(operation);
        connect();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerListener(ListenerKey listenerKey, QueueOperation registerListenerOperation) {
        this.mRegisteredListeners.put(listenerKey, registerListenerOperation);
        if (isConnected()) {
            enqueue(registerListenerOperation);
        } else {
            connect();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unregisterListener(ListenerKey listenerKey, QueueOperation unregisterListenerOperation) {
        this.mRegisteredListeners.remove(listenerKey);
        enqueue(unregisterListenerOperation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void maybeReconnect() {
        if (this.mRegisteredListeners.isEmpty()) {
            Logger.debug(TAG, "No listeners registered, service " + this.mConnectionConfiguration.getClientName() + " is not automatically reconnected.");
            return;
        }
        this.mServiceConnectionRetry++;
        Logger.debug(TAG, "Listeners for service " + this.mConnectionConfiguration.getClientName() + " are registered, reconnecting.");
        connect();
    }

    void execute(QueueOperation operation) {
        try {
            operation.trackExecution(this.mExecutionTracker);
            operation.execute((IBinder) Preconditions.checkNotNull(this.mBinder));
        } catch (DeadObjectException exception) {
            handleRetriableDisconnection(exception);
        } catch (RemoteException e) {
            exception = e;
            operation.setException(exception);
        } catch (RuntimeException e2) {
            exception = e2;
            operation.setException(exception);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reRegisterAllListeners() {
        for (Map.Entry<ListenerKey, QueueOperation> entry : this.mRegisteredListeners.entrySet()) {
            Logger.debug(TAG, "Re-registering listener: " + entry.getKey());
            execute(entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void refreshServiceVersion() {
        this.mOperationQueue.add(this.mConnectionConfiguration.getRefreshVersionOperation());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void flushQueue() {
        Iterator it = new ArrayList(this.mOperationQueue).iterator();
        while (it.hasNext()) {
            QueueOperation operation = (QueueOperation) it.next();
            boolean removed = this.mOperationQueue.remove(operation);
            if (removed) {
                execute(operation);
            }
        }
    }

    private void cancelAllOperationsInQueue(Throwable throwable) {
        Iterator it = new ArrayList(this.mOperationQueue).iterator();
        while (it.hasNext()) {
            QueueOperation operation = (QueueOperation) it.next();
            boolean removed = this.mOperationQueue.remove(operation);
            if (removed) {
                operation.setException(throwable);
            }
        }
    }

    private boolean isConnected() {
        return this.mBinder != null && this.mBinder.isBinderAlive();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder binder) {
        Logger.debug(TAG, "onServiceConnected(), componentName = " + componentName);
        if (binder == null) {
            Logger.error(TAG, "Service connected but binder is null.");
            return;
        }
        this.mServiceConnectionRetry = 0;
        cleanOnDeath(binder);
        this.mBinder = binder;
        this.mCallback.onConnected(this);
    }

    private void cleanOnDeath(IBinder binder) {
        try {
            binder.linkToDeath(this.mDeathRecipient, 0);
        } catch (RemoteException exception) {
            Logger.warning(TAG, "Cannot link to death, binder already died. Cleaning operations.", exception);
            handleRetriableDisconnection(exception);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Logger.debug(TAG, "onServiceDisconnected(), componentName = " + componentName);
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName name) {
        Logger.error(TAG, "Binding died for client '" + this.mConnectionConfiguration.getClientName() + "'.");
        handleRetriableDisconnection(new RemoteException("Binding died"));
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName name) {
        Logger.error(TAG, "Cannot bind client '" + this.mConnectionConfiguration.getClientName() + "', binder is null");
        handleRetriableDisconnection(new RemoteException("Null binding"));
    }
}
