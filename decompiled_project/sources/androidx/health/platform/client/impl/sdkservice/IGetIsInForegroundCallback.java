package androidx.health.platform.client.impl.sdkservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes14.dex */
public interface IGetIsInForegroundCallback extends IInterface {
    public static final String DESCRIPTOR = "androidx.health.platform.client.impl.sdkservice.IGetIsInForegroundCallback";

    void onSuccess(boolean z) throws RemoteException;

    /* loaded from: classes14.dex */
    public static class Default implements IGetIsInForegroundCallback {
        @Override // androidx.health.platform.client.impl.sdkservice.IGetIsInForegroundCallback
        public void onSuccess(boolean isInForeground) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes14.dex */
    public static abstract class Stub extends Binder implements IGetIsInForegroundCallback {
        static final int TRANSACTION_onSuccess = 1;

        public Stub() {
            attachInterface(this, IGetIsInForegroundCallback.DESCRIPTOR);
        }

        public static IGetIsInForegroundCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IGetIsInForegroundCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IGetIsInForegroundCallback)) {
                return (IGetIsInForegroundCallback) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code >= 1 && code <= 16777215) {
                data.enforceInterface(IGetIsInForegroundCallback.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IGetIsInForegroundCallback.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    boolean _arg0 = data.readInt() != 0;
                    onSuccess(_arg0);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* loaded from: classes14.dex */
        private static class Proxy implements IGetIsInForegroundCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IGetIsInForegroundCallback.DESCRIPTOR;
            }

            @Override // androidx.health.platform.client.impl.sdkservice.IGetIsInForegroundCallback
            public void onSuccess(boolean isInForeground) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IGetIsInForegroundCallback.DESCRIPTOR);
                    _data.writeInt(isInForeground ? 1 : 0);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }
    }
}
