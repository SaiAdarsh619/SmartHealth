package androidx.health.platform.client.impl.sdkservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes14.dex */
public interface IGetPermissionTokenCallback extends IInterface {
    public static final String DESCRIPTOR = "androidx.health.platform.client.impl.sdkservice.IGetPermissionTokenCallback";

    void onSuccess(String str) throws RemoteException;

    public static class Default implements IGetPermissionTokenCallback {
        @Override // androidx.health.platform.client.impl.sdkservice.IGetPermissionTokenCallback
        public void onSuccess(String token) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IGetPermissionTokenCallback {
        static final int TRANSACTION_onSuccess = 1;

        public Stub() {
            attachInterface(this, IGetPermissionTokenCallback.DESCRIPTOR);
        }

        public static IGetPermissionTokenCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IGetPermissionTokenCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IGetPermissionTokenCallback)) {
                return (IGetPermissionTokenCallback) iin;
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
                data.enforceInterface(IGetPermissionTokenCallback.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IGetPermissionTokenCallback.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    String _arg0 = data.readString();
                    onSuccess(_arg0);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IGetPermissionTokenCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IGetPermissionTokenCallback.DESCRIPTOR;
            }

            @Override // androidx.health.platform.client.impl.sdkservice.IGetPermissionTokenCallback
            public void onSuccess(String token) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IGetPermissionTokenCallback.DESCRIPTOR);
                    _data.writeString(token);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }
    }
}
