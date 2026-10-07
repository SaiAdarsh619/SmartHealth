package androidx.health.platform.client.impl.sdkservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes14.dex */
public interface ISetPermissionTokenCallback extends IInterface {
    public static final String DESCRIPTOR = "androidx.health.platform.client.impl.sdkservice.ISetPermissionTokenCallback";

    void onSuccess() throws RemoteException;

    public static class Default implements ISetPermissionTokenCallback {
        @Override // androidx.health.platform.client.impl.sdkservice.ISetPermissionTokenCallback
        public void onSuccess() throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ISetPermissionTokenCallback {
        static final int TRANSACTION_onSuccess = 1;

        public Stub() {
            attachInterface(this, ISetPermissionTokenCallback.DESCRIPTOR);
        }

        public static ISetPermissionTokenCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(ISetPermissionTokenCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof ISetPermissionTokenCallback)) {
                return (ISetPermissionTokenCallback) iin;
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
                data.enforceInterface(ISetPermissionTokenCallback.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(ISetPermissionTokenCallback.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    onSuccess();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements ISetPermissionTokenCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISetPermissionTokenCallback.DESCRIPTOR;
            }

            @Override // androidx.health.platform.client.impl.sdkservice.ISetPermissionTokenCallback
            public void onSuccess() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(ISetPermissionTokenCallback.DESCRIPTOR);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }
    }
}
