package androidx.health.platform.client.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.health.platform.client.changes.ChangesEvent;

/* loaded from: classes14.dex */
public interface IOnChangesListener extends IInterface {
    public static final String DESCRIPTOR = "androidx.health.platform.client.service.IOnChangesListener";

    void onChanges(ChangesEvent changesEvent) throws RemoteException;

    public static class Default implements IOnChangesListener {
        @Override // androidx.health.platform.client.service.IOnChangesListener
        public void onChanges(ChangesEvent changesEvent) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IOnChangesListener {
        static final int TRANSACTION_onChanges = 1;

        public Stub() {
            attachInterface(this, IOnChangesListener.DESCRIPTOR);
        }

        public static IOnChangesListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IOnChangesListener.DESCRIPTOR);
            if (iin != null && (iin instanceof IOnChangesListener)) {
                return (IOnChangesListener) iin;
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
                data.enforceInterface(IOnChangesListener.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IOnChangesListener.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    ChangesEvent _arg0 = (ChangesEvent) _Parcel.readTypedObject(data, ChangesEvent.CREATOR);
                    onChanges(_arg0);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IOnChangesListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOnChangesListener.DESCRIPTOR;
            }

            @Override // androidx.health.platform.client.service.IOnChangesListener
            public void onChanges(ChangesEvent changesEvent) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOnChangesListener.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, changesEvent, 0);
                    this.mRemote.transact(1, _data, null, 1);
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
