package androidx.health.platform.client.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.health.platform.client.permission.Permission;
import androidx.health.platform.client.request.AggregateDataRequest;
import androidx.health.platform.client.request.DeleteDataRangeRequest;
import androidx.health.platform.client.request.DeleteDataRequest;
import androidx.health.platform.client.request.GetChangesRequest;
import androidx.health.platform.client.request.GetChangesTokenRequest;
import androidx.health.platform.client.request.ReadDataRangeRequest;
import androidx.health.platform.client.request.ReadDataRequest;
import androidx.health.platform.client.request.ReadExerciseRouteRequest;
import androidx.health.platform.client.request.RegisterForDataNotificationsRequest;
import androidx.health.platform.client.request.RequestContext;
import androidx.health.platform.client.request.UnregisterFromDataNotificationsRequest;
import androidx.health.platform.client.request.UpsertDataRequest;
import androidx.health.platform.client.request.UpsertExerciseRouteRequest;
import androidx.health.platform.client.service.IAggregateDataCallback;
import androidx.health.platform.client.service.IDeleteDataCallback;
import androidx.health.platform.client.service.IDeleteDataRangeCallback;
import androidx.health.platform.client.service.IFilterGrantedPermissionsCallback;
import androidx.health.platform.client.service.IGetChangesCallback;
import androidx.health.platform.client.service.IGetChangesTokenCallback;
import androidx.health.platform.client.service.IGetGrantedPermissionsCallback;
import androidx.health.platform.client.service.IInsertDataCallback;
import androidx.health.platform.client.service.IReadDataCallback;
import androidx.health.platform.client.service.IReadDataRangeCallback;
import androidx.health.platform.client.service.IReadExerciseRouteCallback;
import androidx.health.platform.client.service.IRegisterForDataNotificationsCallback;
import androidx.health.platform.client.service.IRevokeAllPermissionsCallback;
import androidx.health.platform.client.service.IUnregisterFromDataNotificationsCallback;
import androidx.health.platform.client.service.IUpdateDataCallback;
import androidx.health.platform.client.service.IUpsertExerciseRouteCallback;
import java.util.List;

/* loaded from: classes14.dex */
public interface IHealthDataService extends IInterface {
    public static final int CURRENT_API_VERSION = 5;
    public static final String DESCRIPTOR = "androidx.health.platform.client.service.IHealthDataService";
    public static final int MIN_API_VERSION = 1;

    void aggregate(RequestContext requestContext, AggregateDataRequest aggregateDataRequest, IAggregateDataCallback iAggregateDataCallback) throws RemoteException;

    void deleteData(RequestContext requestContext, DeleteDataRequest deleteDataRequest, IDeleteDataCallback iDeleteDataCallback) throws RemoteException;

    void deleteDataRange(RequestContext requestContext, DeleteDataRangeRequest deleteDataRangeRequest, IDeleteDataRangeCallback iDeleteDataRangeCallback) throws RemoteException;

    void filterGrantedPermissions(RequestContext requestContext, List<Permission> list, IFilterGrantedPermissionsCallback iFilterGrantedPermissionsCallback) throws RemoteException;

    int getApiVersion() throws RemoteException;

    void getChanges(RequestContext requestContext, GetChangesRequest getChangesRequest, IGetChangesCallback iGetChangesCallback) throws RemoteException;

    void getChangesToken(RequestContext requestContext, GetChangesTokenRequest getChangesTokenRequest, IGetChangesTokenCallback iGetChangesTokenCallback) throws RemoteException;

    void getGrantedPermissions(RequestContext requestContext, List<Permission> list, IGetGrantedPermissionsCallback iGetGrantedPermissionsCallback) throws RemoteException;

    void insertData(RequestContext requestContext, UpsertDataRequest upsertDataRequest, IInsertDataCallback iInsertDataCallback) throws RemoteException;

    void readData(RequestContext requestContext, ReadDataRequest readDataRequest, IReadDataCallback iReadDataCallback) throws RemoteException;

    void readDataRange(RequestContext requestContext, ReadDataRangeRequest readDataRangeRequest, IReadDataRangeCallback iReadDataRangeCallback) throws RemoteException;

    void readExerciseRoute(RequestContext requestContext, ReadExerciseRouteRequest readExerciseRouteRequest, IReadExerciseRouteCallback iReadExerciseRouteCallback) throws RemoteException;

    void registerForDataNotifications(RequestContext requestContext, RegisterForDataNotificationsRequest registerForDataNotificationsRequest, IRegisterForDataNotificationsCallback iRegisterForDataNotificationsCallback) throws RemoteException;

    void revokeAllPermissions(RequestContext requestContext, IRevokeAllPermissionsCallback iRevokeAllPermissionsCallback) throws RemoteException;

    void unregisterFromDataNotifications(RequestContext requestContext, UnregisterFromDataNotificationsRequest unregisterFromDataNotificationsRequest, IUnregisterFromDataNotificationsCallback iUnregisterFromDataNotificationsCallback) throws RemoteException;

    void updateData(RequestContext requestContext, UpsertDataRequest upsertDataRequest, IUpdateDataCallback iUpdateDataCallback) throws RemoteException;

    void upsertExerciseRoute(RequestContext requestContext, UpsertExerciseRouteRequest upsertExerciseRouteRequest, IUpsertExerciseRouteCallback iUpsertExerciseRouteCallback) throws RemoteException;

    public static class Default implements IHealthDataService {
        @Override // androidx.health.platform.client.service.IHealthDataService
        public int getApiVersion() throws RemoteException {
            return 0;
        }

        @Override // androidx.health.platform.client.service.IHealthDataService
        public void getGrantedPermissions(RequestContext context, List<Permission> permissions, IGetGrantedPermissionsCallback callback) throws RemoteException {
        }

        @Override // androidx.health.platform.client.service.IHealthDataService
        public void filterGrantedPermissions(RequestContext context, List<Permission> permissions, IFilterGrantedPermissionsCallback callback) throws RemoteException {
        }

        @Override // androidx.health.platform.client.service.IHealthDataService
        public void revokeAllPermissions(RequestContext context, IRevokeAllPermissionsCallback callback) throws RemoteException {
        }

        @Override // androidx.health.platform.client.service.IHealthDataService
        public void insertData(RequestContext context, UpsertDataRequest request, IInsertDataCallback callback) throws RemoteException {
        }

        @Override // androidx.health.platform.client.service.IHealthDataService
        public void deleteData(RequestContext context, DeleteDataRequest request, IDeleteDataCallback callback) throws RemoteException {
        }

        @Override // androidx.health.platform.client.service.IHealthDataService
        public void deleteDataRange(RequestContext context, DeleteDataRangeRequest request, IDeleteDataRangeCallback callback) throws RemoteException {
        }

        @Override // androidx.health.platform.client.service.IHealthDataService
        public void readData(RequestContext context, ReadDataRequest request, IReadDataCallback callback) throws RemoteException {
        }

        @Override // androidx.health.platform.client.service.IHealthDataService
        public void readDataRange(RequestContext context, ReadDataRangeRequest request, IReadDataRangeCallback callback) throws RemoteException {
        }

        @Override // androidx.health.platform.client.service.IHealthDataService
        public void updateData(RequestContext context, UpsertDataRequest request, IUpdateDataCallback callback) throws RemoteException {
        }

        @Override // androidx.health.platform.client.service.IHealthDataService
        public void aggregate(RequestContext context, AggregateDataRequest request, IAggregateDataCallback callback) throws RemoteException {
        }

        @Override // androidx.health.platform.client.service.IHealthDataService
        public void getChangesToken(RequestContext context, GetChangesTokenRequest request, IGetChangesTokenCallback callback) throws RemoteException {
        }

        @Override // androidx.health.platform.client.service.IHealthDataService
        public void getChanges(RequestContext context, GetChangesRequest request, IGetChangesCallback callback) throws RemoteException {
        }

        @Override // androidx.health.platform.client.service.IHealthDataService
        public void registerForDataNotifications(RequestContext context, RegisterForDataNotificationsRequest request, IRegisterForDataNotificationsCallback callback) throws RemoteException {
        }

        @Override // androidx.health.platform.client.service.IHealthDataService
        public void unregisterFromDataNotifications(RequestContext context, UnregisterFromDataNotificationsRequest request, IUnregisterFromDataNotificationsCallback callback) throws RemoteException {
        }

        @Override // androidx.health.platform.client.service.IHealthDataService
        public void upsertExerciseRoute(RequestContext context, UpsertExerciseRouteRequest request, IUpsertExerciseRouteCallback callback) throws RemoteException {
        }

        @Override // androidx.health.platform.client.service.IHealthDataService
        public void readExerciseRoute(RequestContext context, ReadExerciseRouteRequest request, IReadExerciseRouteCallback callback) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IHealthDataService {
        static final int TRANSACTION_aggregate = 15;
        static final int TRANSACTION_deleteData = 11;
        static final int TRANSACTION_deleteDataRange = 14;
        static final int TRANSACTION_filterGrantedPermissions = 23;
        static final int TRANSACTION_getApiVersion = 1;
        static final int TRANSACTION_getChanges = 18;
        static final int TRANSACTION_getChangesToken = 17;
        static final int TRANSACTION_getGrantedPermissions = 4;
        static final int TRANSACTION_insertData = 10;
        static final int TRANSACTION_readData = 12;
        static final int TRANSACTION_readDataRange = 16;
        static final int TRANSACTION_readExerciseRoute = 22;
        static final int TRANSACTION_registerForDataNotifications = 19;
        static final int TRANSACTION_revokeAllPermissions = 9;
        static final int TRANSACTION_unregisterFromDataNotifications = 20;
        static final int TRANSACTION_updateData = 13;
        static final int TRANSACTION_upsertExerciseRoute = 21;

        public Stub() {
            attachInterface(this, IHealthDataService.DESCRIPTOR);
        }

        public static IHealthDataService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IHealthDataService.DESCRIPTOR);
            if (iin != null && (iin instanceof IHealthDataService)) {
                return (IHealthDataService) iin;
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
                data.enforceInterface(IHealthDataService.DESCRIPTOR);
            }
            if (code == 1598968902) {
                reply.writeString(IHealthDataService.DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    int _result = getApiVersion();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 2:
                case 3:
                case 5:
                case 6:
                case 7:
                case 8:
                default:
                    return super.onTransact(code, data, reply, flags);
                case 4:
                    RequestContext _arg0 = (RequestContext) _Parcel.readTypedObject(data, RequestContext.CREATOR);
                    List<Permission> _arg1 = data.createTypedArrayList(Permission.CREATOR);
                    IGetGrantedPermissionsCallback _arg2 = IGetGrantedPermissionsCallback.Stub.asInterface(data.readStrongBinder());
                    getGrantedPermissions(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                case 9:
                    RequestContext _arg02 = (RequestContext) _Parcel.readTypedObject(data, RequestContext.CREATOR);
                    IRevokeAllPermissionsCallback _arg12 = IRevokeAllPermissionsCallback.Stub.asInterface(data.readStrongBinder());
                    revokeAllPermissions(_arg02, _arg12);
                    reply.writeNoException();
                    return true;
                case 10:
                    RequestContext _arg03 = (RequestContext) _Parcel.readTypedObject(data, RequestContext.CREATOR);
                    UpsertDataRequest _arg13 = (UpsertDataRequest) _Parcel.readTypedObject(data, UpsertDataRequest.CREATOR);
                    IInsertDataCallback _arg22 = IInsertDataCallback.Stub.asInterface(data.readStrongBinder());
                    insertData(_arg03, _arg13, _arg22);
                    reply.writeNoException();
                    return true;
                case 11:
                    RequestContext _arg04 = (RequestContext) _Parcel.readTypedObject(data, RequestContext.CREATOR);
                    DeleteDataRequest _arg14 = (DeleteDataRequest) _Parcel.readTypedObject(data, DeleteDataRequest.CREATOR);
                    IDeleteDataCallback _arg23 = IDeleteDataCallback.Stub.asInterface(data.readStrongBinder());
                    deleteData(_arg04, _arg14, _arg23);
                    reply.writeNoException();
                    return true;
                case 12:
                    RequestContext _arg05 = (RequestContext) _Parcel.readTypedObject(data, RequestContext.CREATOR);
                    ReadDataRequest _arg15 = (ReadDataRequest) _Parcel.readTypedObject(data, ReadDataRequest.CREATOR);
                    IReadDataCallback _arg24 = IReadDataCallback.Stub.asInterface(data.readStrongBinder());
                    readData(_arg05, _arg15, _arg24);
                    reply.writeNoException();
                    return true;
                case 13:
                    RequestContext _arg06 = (RequestContext) _Parcel.readTypedObject(data, RequestContext.CREATOR);
                    UpsertDataRequest _arg16 = (UpsertDataRequest) _Parcel.readTypedObject(data, UpsertDataRequest.CREATOR);
                    IUpdateDataCallback _arg25 = IUpdateDataCallback.Stub.asInterface(data.readStrongBinder());
                    updateData(_arg06, _arg16, _arg25);
                    reply.writeNoException();
                    return true;
                case 14:
                    RequestContext _arg07 = (RequestContext) _Parcel.readTypedObject(data, RequestContext.CREATOR);
                    DeleteDataRangeRequest _arg17 = (DeleteDataRangeRequest) _Parcel.readTypedObject(data, DeleteDataRangeRequest.CREATOR);
                    IDeleteDataRangeCallback _arg26 = IDeleteDataRangeCallback.Stub.asInterface(data.readStrongBinder());
                    deleteDataRange(_arg07, _arg17, _arg26);
                    reply.writeNoException();
                    return true;
                case 15:
                    RequestContext _arg08 = (RequestContext) _Parcel.readTypedObject(data, RequestContext.CREATOR);
                    AggregateDataRequest _arg18 = (AggregateDataRequest) _Parcel.readTypedObject(data, AggregateDataRequest.CREATOR);
                    IAggregateDataCallback _arg27 = IAggregateDataCallback.Stub.asInterface(data.readStrongBinder());
                    aggregate(_arg08, _arg18, _arg27);
                    reply.writeNoException();
                    return true;
                case 16:
                    RequestContext _arg09 = (RequestContext) _Parcel.readTypedObject(data, RequestContext.CREATOR);
                    ReadDataRangeRequest _arg19 = (ReadDataRangeRequest) _Parcel.readTypedObject(data, ReadDataRangeRequest.CREATOR);
                    IReadDataRangeCallback _arg28 = IReadDataRangeCallback.Stub.asInterface(data.readStrongBinder());
                    readDataRange(_arg09, _arg19, _arg28);
                    reply.writeNoException();
                    return true;
                case 17:
                    RequestContext _arg010 = (RequestContext) _Parcel.readTypedObject(data, RequestContext.CREATOR);
                    GetChangesTokenRequest _arg110 = (GetChangesTokenRequest) _Parcel.readTypedObject(data, GetChangesTokenRequest.CREATOR);
                    IGetChangesTokenCallback _arg29 = IGetChangesTokenCallback.Stub.asInterface(data.readStrongBinder());
                    getChangesToken(_arg010, _arg110, _arg29);
                    reply.writeNoException();
                    return true;
                case 18:
                    RequestContext _arg011 = (RequestContext) _Parcel.readTypedObject(data, RequestContext.CREATOR);
                    GetChangesRequest _arg111 = (GetChangesRequest) _Parcel.readTypedObject(data, GetChangesRequest.CREATOR);
                    IGetChangesCallback _arg210 = IGetChangesCallback.Stub.asInterface(data.readStrongBinder());
                    getChanges(_arg011, _arg111, _arg210);
                    reply.writeNoException();
                    return true;
                case 19:
                    RequestContext _arg012 = (RequestContext) _Parcel.readTypedObject(data, RequestContext.CREATOR);
                    RegisterForDataNotificationsRequest _arg112 = (RegisterForDataNotificationsRequest) _Parcel.readTypedObject(data, RegisterForDataNotificationsRequest.CREATOR);
                    IRegisterForDataNotificationsCallback _arg211 = IRegisterForDataNotificationsCallback.Stub.asInterface(data.readStrongBinder());
                    registerForDataNotifications(_arg012, _arg112, _arg211);
                    reply.writeNoException();
                    return true;
                case 20:
                    RequestContext _arg013 = (RequestContext) _Parcel.readTypedObject(data, RequestContext.CREATOR);
                    UnregisterFromDataNotificationsRequest _arg113 = (UnregisterFromDataNotificationsRequest) _Parcel.readTypedObject(data, UnregisterFromDataNotificationsRequest.CREATOR);
                    IUnregisterFromDataNotificationsCallback _arg212 = IUnregisterFromDataNotificationsCallback.Stub.asInterface(data.readStrongBinder());
                    unregisterFromDataNotifications(_arg013, _arg113, _arg212);
                    reply.writeNoException();
                    return true;
                case 21:
                    RequestContext _arg014 = (RequestContext) _Parcel.readTypedObject(data, RequestContext.CREATOR);
                    UpsertExerciseRouteRequest _arg114 = (UpsertExerciseRouteRequest) _Parcel.readTypedObject(data, UpsertExerciseRouteRequest.CREATOR);
                    IUpsertExerciseRouteCallback _arg213 = IUpsertExerciseRouteCallback.Stub.asInterface(data.readStrongBinder());
                    upsertExerciseRoute(_arg014, _arg114, _arg213);
                    reply.writeNoException();
                    return true;
                case 22:
                    RequestContext _arg015 = (RequestContext) _Parcel.readTypedObject(data, RequestContext.CREATOR);
                    ReadExerciseRouteRequest _arg115 = (ReadExerciseRouteRequest) _Parcel.readTypedObject(data, ReadExerciseRouteRequest.CREATOR);
                    IReadExerciseRouteCallback _arg214 = IReadExerciseRouteCallback.Stub.asInterface(data.readStrongBinder());
                    readExerciseRoute(_arg015, _arg115, _arg214);
                    reply.writeNoException();
                    return true;
                case 23:
                    RequestContext _arg016 = (RequestContext) _Parcel.readTypedObject(data, RequestContext.CREATOR);
                    List<Permission> _arg116 = data.createTypedArrayList(Permission.CREATOR);
                    IFilterGrantedPermissionsCallback _arg215 = IFilterGrantedPermissionsCallback.Stub.asInterface(data.readStrongBinder());
                    filterGrantedPermissions(_arg016, _arg116, _arg215);
                    reply.writeNoException();
                    return true;
            }
        }

        private static class Proxy implements IHealthDataService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IHealthDataService.DESCRIPTOR;
            }

            @Override // androidx.health.platform.client.service.IHealthDataService
            public int getApiVersion() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataService.DESCRIPTOR);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IHealthDataService
            public void getGrantedPermissions(RequestContext context, List<Permission> permissions, IGetGrantedPermissionsCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataService.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, context, 0);
                    _Parcel.writeTypedList(_data, permissions, 0);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IHealthDataService
            public void filterGrantedPermissions(RequestContext context, List<Permission> permissions, IFilterGrantedPermissionsCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataService.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, context, 0);
                    _Parcel.writeTypedList(_data, permissions, 0);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(23, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IHealthDataService
            public void revokeAllPermissions(RequestContext context, IRevokeAllPermissionsCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataService.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, context, 0);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IHealthDataService
            public void insertData(RequestContext context, UpsertDataRequest request, IInsertDataCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataService.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, context, 0);
                    _Parcel.writeTypedObject(_data, request, 0);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IHealthDataService
            public void deleteData(RequestContext context, DeleteDataRequest request, IDeleteDataCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataService.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, context, 0);
                    _Parcel.writeTypedObject(_data, request, 0);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IHealthDataService
            public void deleteDataRange(RequestContext context, DeleteDataRangeRequest request, IDeleteDataRangeCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataService.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, context, 0);
                    _Parcel.writeTypedObject(_data, request, 0);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IHealthDataService
            public void readData(RequestContext context, ReadDataRequest request, IReadDataCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataService.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, context, 0);
                    _Parcel.writeTypedObject(_data, request, 0);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IHealthDataService
            public void readDataRange(RequestContext context, ReadDataRangeRequest request, IReadDataRangeCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataService.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, context, 0);
                    _Parcel.writeTypedObject(_data, request, 0);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IHealthDataService
            public void updateData(RequestContext context, UpsertDataRequest request, IUpdateDataCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataService.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, context, 0);
                    _Parcel.writeTypedObject(_data, request, 0);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IHealthDataService
            public void aggregate(RequestContext context, AggregateDataRequest request, IAggregateDataCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataService.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, context, 0);
                    _Parcel.writeTypedObject(_data, request, 0);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IHealthDataService
            public void getChangesToken(RequestContext context, GetChangesTokenRequest request, IGetChangesTokenCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataService.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, context, 0);
                    _Parcel.writeTypedObject(_data, request, 0);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IHealthDataService
            public void getChanges(RequestContext context, GetChangesRequest request, IGetChangesCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataService.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, context, 0);
                    _Parcel.writeTypedObject(_data, request, 0);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IHealthDataService
            public void registerForDataNotifications(RequestContext context, RegisterForDataNotificationsRequest request, IRegisterForDataNotificationsCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataService.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, context, 0);
                    _Parcel.writeTypedObject(_data, request, 0);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IHealthDataService
            public void unregisterFromDataNotifications(RequestContext context, UnregisterFromDataNotificationsRequest request, IUnregisterFromDataNotificationsCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataService.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, context, 0);
                    _Parcel.writeTypedObject(_data, request, 0);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(20, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IHealthDataService
            public void upsertExerciseRoute(RequestContext context, UpsertExerciseRouteRequest request, IUpsertExerciseRouteCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataService.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, context, 0);
                    _Parcel.writeTypedObject(_data, request, 0);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(21, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IHealthDataService
            public void readExerciseRoute(RequestContext context, ReadExerciseRouteRequest request, IReadExerciseRouteCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IHealthDataService.DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, context, 0);
                    _Parcel.writeTypedObject(_data, request, 0);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(22, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
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

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> value, int parcelableFlags) {
            if (value == null) {
                parcel.writeInt(-1);
                return;
            }
            int N = value.size();
            parcel.writeInt(N);
            for (int i = 0; i < N; i++) {
                writeTypedObject(parcel, value.get(i), parcelableFlags);
            }
        }
    }
}
