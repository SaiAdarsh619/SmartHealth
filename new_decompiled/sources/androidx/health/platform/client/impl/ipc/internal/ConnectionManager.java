package androidx.health.platform.client.impl.ipc.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.health.platform.client.impl.ipc.internal.ServiceConnection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes14.dex */
public final class ConnectionManager implements Handler.Callback, ServiceConnection.Callback {
    private static final int MSG_CONNECTED = 1;
    private static final int MSG_DISCONNECTED = 2;
    private static final int MSG_EXECUTE = 3;
    private static final int MSG_REGISTER_LISTENER = 4;
    private static final int MSG_UNBIND = 6;
    private static final int MSG_UNREGISTER_LISTENER = 5;
    private static final String TAG = "ConnectionManager";
    static final int UNBIND_IDLE_DELAY_MILLISECONDS = 15000;
    private boolean mBindToSelfEnabled;
    private final Context mContext;
    private final Handler mHandler;
    private final Map<String, ServiceConnection> mServiceConnectionMap = new HashMap();

    public ConnectionManager(Context context, Looper looper) {
        this.mContext = context;
        this.mHandler = new Handler(looper, this);
    }

    public void scheduleForExecution(QueueOperation operation) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, operation));
    }

    public void registerListener(ListenerKey listenerKey, QueueOperation registerOperation) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new ListenerHolder(listenerKey, registerOperation)));
    }

    public void unregisterListener(ListenerKey listenerKey, QueueOperation unregisterOperation) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5, new ListenerHolder(listenerKey, unregisterOperation)));
    }

    void delayIdleServiceUnbindCheck(ServiceConnection serviceConnection) {
        this.mHandler.removeMessages(6, serviceConnection);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(6, serviceConnection), 15000L);
    }

    @Override // androidx.health.platform.client.impl.ipc.internal.ServiceConnection.Callback
    public void onConnected(ServiceConnection connection) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, connection));
    }

    @Override // androidx.health.platform.client.impl.ipc.internal.ServiceConnection.Callback
    public void onDisconnected(ServiceConnection connection, long reconnectDelayMs) {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2, connection), reconnectDelayMs);
    }

    @Override // androidx.health.platform.client.impl.ipc.internal.ServiceConnection.Callback
    public boolean isBindToSelfEnabled() {
        return this.mBindToSelfEnabled;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 1:
                ServiceConnection serviceConnection = (ServiceConnection) msg.obj;
                serviceConnection.reRegisterAllListeners();
                serviceConnection.refreshServiceVersion();
                serviceConnection.flushQueue();
                delayIdleServiceUnbindCheck(serviceConnection);
                return true;
            case 2:
                ((ServiceConnection) msg.obj).maybeReconnect();
                return true;
            case 3:
                QueueOperation queueOperation = (QueueOperation) msg.obj;
                ServiceConnection serviceConnectionForExecute = getConnection(queueOperation.getConnectionConfiguration());
                serviceConnectionForExecute.enqueue(queueOperation);
                delayIdleServiceUnbindCheck(serviceConnectionForExecute);
                return true;
            case 4:
                ListenerHolder registerListenerHolder = (ListenerHolder) msg.obj;
                ServiceConnection serviceConnectionForRegister = getConnection(registerListenerHolder.getListenerOperation().getConnectionConfiguration());
                serviceConnectionForRegister.registerListener(registerListenerHolder.getListenerKey(), registerListenerHolder.getListenerOperation());
                delayIdleServiceUnbindCheck(serviceConnectionForRegister);
                return true;
            case 5:
                ListenerHolder unregisterListenerHolder = (ListenerHolder) msg.obj;
                ServiceConnection serviceConnectionForUnregister = getConnection(unregisterListenerHolder.getListenerOperation().getConnectionConfiguration());
                serviceConnectionForUnregister.unregisterListener(unregisterListenerHolder.getListenerKey(), unregisterListenerHolder.getListenerOperation());
                delayIdleServiceUnbindCheck(serviceConnectionForUnregister);
                return true;
            case 6:
                ServiceConnection serviceConnectionToClear = (ServiceConnection) msg.obj;
                if (this.mHandler.hasMessages(3) || this.mHandler.hasMessages(4) || this.mHandler.hasMessages(5)) {
                    return true;
                }
                boolean isIdle = serviceConnectionToClear.clearConnectionIfIdle();
                if (!isIdle) {
                    delayIdleServiceUnbindCheck(serviceConnectionToClear);
                }
                return true;
            default:
                Log.e(TAG, "Received unknown message: " + msg.what);
                return false;
        }
    }

    public void setBindToSelf(boolean bindToSelfEnabled) {
        this.mBindToSelfEnabled = bindToSelfEnabled;
    }

    ServiceConnection getConnection(ConnectionConfiguration connectionConfiguration) {
        String connectionKey = connectionConfiguration.getKey();
        ServiceConnection serviceConnection = this.mServiceConnectionMap.get(connectionKey);
        if (serviceConnection == null) {
            ServiceConnection serviceConnection2 = new ServiceConnection(this.mContext, connectionConfiguration, new DefaultExecutionTracker(), this);
            this.mServiceConnectionMap.put(connectionKey, serviceConnection2);
            return serviceConnection2;
        }
        return serviceConnection;
    }

    private static class ListenerHolder {
        private final ListenerKey mListenerKey;
        private final QueueOperation mListenerOperation;

        ListenerHolder(ListenerKey listenerKey, QueueOperation listenerOperation) {
            this.mListenerKey = listenerKey;
            this.mListenerOperation = listenerOperation;
        }

        ListenerKey getListenerKey() {
            return this.mListenerKey;
        }

        QueueOperation getListenerOperation() {
            return this.mListenerOperation;
        }
    }
}
