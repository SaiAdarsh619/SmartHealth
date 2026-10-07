package androidx.health.platform.client.impl.sdkservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.health.platform.client.impl.sdkservice.IGetIsInForegroundCallback;
import androidx.health.platform.client.impl.sdkservice.IGetPermissionTokenCallback;
import androidx.health.platform.client.impl.sdkservice.ISetPermissionTokenCallback;
/* loaded from: classes14.dex */
public interface IHealthDataSdkService extends IInterface {
    public static final String DESCRIPTOR = "androidx.health.platform.client.impl.sdkservice.IHealthDataSdkService";

    void getIsInForeground(String str, IGetIsInForegroundCallback iGetIsInForegroundCallback) throws RemoteException;

    void getPermissionToken(String str, IGetPermissionTokenCallback iGetPermissionTokenCallback) throws RemoteException;

    void setPermissionToken(String str, String str2, ISetPermissionTokenCallback iSetPermissionTokenCallback) throws RemoteException;

    /* loaded from: classes14.dex */
    public static class Default implements IHealthDataSdkService {
        @Override // androidx.health.platform.client.impl.sdkservice.IHealthDataSdkService
        public void setPermissionToken(String healthDataPackageName, String permissionToken, ISetPermissionTokenCallback callback) throws RemoteException {
        }

        @Override // androidx.health.platform.client.impl.sdkservice.IHealthDataSdkService
        public void getPermissionToken(String healthDataPackageName, IGetPermissionTokenCallback callback) throws RemoteException {
        }

        @Override // androidx.health.platform.client.impl.sdkservice.IHealthDataSdkService
        public void getIsInForeground(String healthDataPackageName, IGetIsInForegroundCallback callback) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes14.dex */
    public static abstract class Stub extends Binder implements IHealthDataSdkService {
        static final int TRANSACTION_getIsInForeground = 3;
        static final int TRANSACTION_getPermissionToken = 2;
        static final int TRANSACTION_setPermissionToken = 1;

        public Stub() {
            attachInterface(this, IHealthDataSdkService.DESCRIPTOR);
        }

        public static IHealthDataSdkService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IHealthDataSdkService.DESCRIPTOR);
            if (iin != null && (iin instanceof IHealthDataSdkService)) {
                return (IHealthDataSdkService) iin;
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
                data.enforceInterface(IHealthDataSdkService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IHealthDataSdkService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    String _arg0 = data.readString();
                    String _arg1 = data.readString();
                    ISetPermissionTokenCallback _arg2 = ISetPermissionTokenCallback.Stub.asInterface(data.readStrongBinder());
                    setPermissionToken(_arg0, _arg1, _arg2);
                    break;
                case 2:
                    String _arg02 = data.readString();
                    IGetPermissionTokenCallback _arg12 = IGetPermissionTokenCallback.Stub.asInterface(data.readStrongBinder());
                    getPermissionToken(_arg02, _arg12);
                    break;
                case 3:
                    String _arg03 = data.readString();
                    IGetIsInForegroundCallback _arg13 = IGetIsInForegroundCallback.Stub.asInterface(data.readStrongBinder());
                    getIsInForeground(_arg03, _arg13);
                    break;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
            return true;
        }

        /* loaded from: classes14.dex */
        private static class Proxy implements IHealthDataSdkService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IHealthDataSdkService.DESCRIPTOR;
            }

            @Override // androidx.health.platform.client.impl.sdkservice.IHealthDataSdkService
            public void setPermissionToken(String healthDataPackageName, String permissionToken, ISetPermissionTokenCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataSdkService.DESCRIPTOR);
                    _data.writeString(healthDataPackageName);
                    _data.writeString(permissionToken);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.impl.sdkservice.IHealthDataSdkService
            public void getPermissionToken(String healthDataPackageName, IGetPermissionTokenCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataSdkService.DESCRIPTOR);
                    _data.writeString(healthDataPackageName);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.impl.sdkservice.IHealthDataSdkService
            public void getIsInForeground(String healthDataPackageName, IGetIsInForegroundCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataSdkService.DESCRIPTOR);
                    _data.writeString(healthDataPackageName);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }
    }
}
