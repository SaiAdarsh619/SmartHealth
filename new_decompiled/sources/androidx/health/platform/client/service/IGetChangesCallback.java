package androidx.health.platform.client.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.health.platform.client.error.ErrorStatus;
import androidx.health.platform.client.response.GetChangesResponse;

/* loaded from: classes14.dex */
public interface IGetChangesCallback extends IInterface {
    public static final String DESCRIPTOR = "androidx.health.platform.client.service.IGetChangesCallback";

    void onError(ErrorStatus errorStatus) throws RemoteException;

    void onSuccess(GetChangesResponse getChangesResponse) throws RemoteException;

    public static class Default implements IGetChangesCallback {
        @Override // androidx.health.platform.client.service.IGetChangesCallback
        public void onSuccess(GetChangesResponse response) throws RemoteException {
        }

        @Override // androidx.health.platform.client.service.IGetChangesCallback
        public void onError(ErrorStatus status) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IGetChangesCallback {
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onSuccess = 1;

        public Stub() {
            attachInterface(this, IGetChangesCallback.DESCRIPTOR);
        }

        public static IGetChangesCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IGetChangesCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IGetChangesCallback)) {
                return (IGetChangesCallback) iin;
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
                data.enforceInterface(IGetChangesCallback.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IGetChangesCallback.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    GetChangesResponse _arg0 = (GetChangesResponse) _Parcel.readTypedObject(data, GetChangesResponse.CREATOR);
                    onSuccess(_arg0);
                    return true;
                case 2:
                    ErrorStatus _arg02 = (ErrorStatus) _Parcel.readTypedObject(data, ErrorStatus.CREATOR);
                    onError(_arg02);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IGetChangesCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IGetChangesCallback.DESCRIPTOR;
            }

            @Override // androidx.health.platform.client.service.IGetChangesCallback
            public void onSuccess(GetChangesResponse response) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IGetChangesCallback.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, response, 0);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IGetChangesCallback
            public void onError(ErrorStatus status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IGetChangesCallback.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, status, 0);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> c) {
            if (parcel.readInt() != 0) {
                return c.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T value, int parcelableFlags) {
            if (value != null) {
                parcel.writeInt(1);
                value.writeToParcel(parcel, parcelableFlags);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
