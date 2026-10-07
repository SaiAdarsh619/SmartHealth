package androidx.health.platform.client.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.health.platform.client.error.ErrorStatus;
import androidx.health.platform.client.response.ReadDataRangeResponse;

/* loaded from: classes14.dex */
public interface IReadDataRangeCallback extends IInterface {
    public static final String DESCRIPTOR = "androidx.health.platform.client.service.IReadDataRangeCallback";

    void onError(ErrorStatus errorStatus) throws RemoteException;

    void onSuccess(ReadDataRangeResponse readDataRangeResponse) throws RemoteException;

    public static class Default implements IReadDataRangeCallback {
        @Override // androidx.health.platform.client.service.IReadDataRangeCallback
        public void onSuccess(ReadDataRangeResponse response) throws RemoteException {
        }

        @Override // androidx.health.platform.client.service.IReadDataRangeCallback
        public void onError(ErrorStatus status) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IReadDataRangeCallback {
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onSuccess = 1;

        public Stub() {
            attachInterface(this, IReadDataRangeCallback.DESCRIPTOR);
        }

        public static IReadDataRangeCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IReadDataRangeCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IReadDataRangeCallback)) {
                return (IReadDataRangeCallback) iin;
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
                data.enforceInterface(IReadDataRangeCallback.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IReadDataRangeCallback.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    ReadDataRangeResponse _arg0 = (ReadDataRangeResponse) _Parcel.readTypedObject(data, ReadDataRangeResponse.CREATOR);
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

        private static class Proxy implements IReadDataRangeCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IReadDataRangeCallback.DESCRIPTOR;
            }

            @Override // androidx.health.platform.client.service.IReadDataRangeCallback
            public void onSuccess(ReadDataRangeResponse response) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IReadDataRangeCallback.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, response, 0);
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IReadDataRangeCallback
            public void onError(ErrorStatus status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IReadDataRangeCallback.DESCRIPTOR);
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
