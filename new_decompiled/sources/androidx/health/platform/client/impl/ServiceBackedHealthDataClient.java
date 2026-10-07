package androidx.health.platform.client.impl;

import android.content.Context;
import android.os.IBinder;
import androidx.health.platform.client.HealthDataAsyncClient;
import androidx.health.platform.client.SdkConfig;
import androidx.health.platform.client.impl.internal.ProviderConnectionManager;
import androidx.health.platform.client.impl.ipc.Client;
import androidx.health.platform.client.impl.ipc.ClientConfiguration;
import androidx.health.platform.client.impl.ipc.RemoteFutureOperation;
import androidx.health.platform.client.impl.ipc.RemoteOperation;
import androidx.health.platform.client.impl.ipc.internal.ConnectionManager;
import androidx.health.platform.client.impl.permission.foregroundstate.ForegroundStateChecker;
import androidx.health.platform.client.impl.permission.token.PermissionTokenManager;
import androidx.health.platform.client.permission.Permission;
import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.PermissionProto;
import androidx.health.platform.client.proto.RequestProto;
import androidx.health.platform.client.proto.ResponseProto;
import androidx.health.platform.client.request.AggregateDataRequest;
import androidx.health.platform.client.request.DeleteDataRangeRequest;
import androidx.health.platform.client.request.DeleteDataRequest;
import androidx.health.platform.client.request.GetChangesRequest;
import androidx.health.platform.client.request.GetChangesTokenRequest;
import androidx.health.platform.client.request.ReadDataRangeRequest;
import androidx.health.platform.client.request.ReadDataRequest;
import androidx.health.platform.client.request.RegisterForDataNotificationsRequest;
import androidx.health.platform.client.request.RequestContext;
import androidx.health.platform.client.request.UnregisterFromDataNotificationsRequest;
import androidx.health.platform.client.request.UpsertDataRequest;
import androidx.health.platform.client.service.IHealthDataService;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServiceBackedHealthDataClient.kt */
@Metadata(m286d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\"\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u00102\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00102\u0006\u0010\u0012\u001a\u00020#H\u0016J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00102\u0006\u0010\u0012\u001a\u00020&H\u0016J\"\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u00102\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\b\u0010(\u001a\u00020)H\u0002J\"\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00170\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020+0\u0017H\u0016J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u00102\u0006\u0010\u001b\u001a\u00020-H\u0016J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00102\u0006\u0010\u001b\u001a\u000200H\u0016J\u0016\u00101\u001a\b\u0012\u0004\u0012\u0002020\u00102\u0006\u0010\u0012\u001a\u000203H\u0016J\u000e\u00104\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010H\u0016J\u0016\u00105\u001a\b\u0012\u0004\u0012\u0002020\u00102\u0006\u0010\u0012\u001a\u000206H\u0016J\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020+0\u0017H\u0016R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, m287d2 = {"Landroidx/health/platform/client/impl/ServiceBackedHealthDataClient;", "Landroidx/health/platform/client/impl/ipc/Client;", "Landroidx/health/platform/client/service/IHealthDataService;", "Landroidx/health/platform/client/HealthDataAsyncClient;", "context", "Landroid/content/Context;", "clientConfiguration", "Landroidx/health/platform/client/impl/ipc/ClientConfiguration;", "(Landroid/content/Context;Landroidx/health/platform/client/impl/ipc/ClientConfiguration;)V", "connectionManager", "Landroidx/health/platform/client/impl/ipc/internal/ConnectionManager;", "(Landroid/content/Context;Landroidx/health/platform/client/impl/ipc/ClientConfiguration;Landroidx/health/platform/client/impl/ipc/internal/ConnectionManager;)V", "callingPackageName", "", "kotlin.jvm.PlatformType", "aggregate", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/health/platform/client/proto/ResponseProto$AggregateDataResponse;", "request", "Landroidx/health/platform/client/proto/RequestProto$AggregateDataRequest;", "deleteData", "", "uidsCollection", "", "Landroidx/health/platform/client/proto/RequestProto$DataTypeIdPair;", "clientIdsCollection", "deleteDataRange", "dataCollection", "Landroidx/health/platform/client/proto/RequestProto$DeleteDataRangeRequest;", "filterGrantedPermissions", "", "Landroidx/health/platform/client/proto/PermissionProto$Permission;", "permissions", "getChanges", "Landroidx/health/platform/client/proto/ResponseProto$GetChangesResponse;", "Landroidx/health/platform/client/proto/RequestProto$GetChangesRequest;", "getChangesToken", "Landroidx/health/platform/client/proto/ResponseProto$GetChangesTokenResponse;", "Landroidx/health/platform/client/proto/RequestProto$GetChangesTokenRequest;", "getGrantedPermissions", "getRequestContext", "Landroidx/health/platform/client/request/RequestContext;", "insertData", "Landroidx/health/platform/client/proto/DataProto$DataPoint;", "readData", "Landroidx/health/platform/client/proto/RequestProto$ReadDataRequest;", "readDataRange", "Landroidx/health/platform/client/proto/ResponseProto$ReadDataRangeResponse;", "Landroidx/health/platform/client/proto/RequestProto$ReadDataRangeRequest;", "registerForDataNotifications", "Ljava/lang/Void;", "Landroidx/health/platform/client/proto/RequestProto$RegisterForDataNotificationsRequest;", "revokeAllPermissions", "unregisterFromDataNotifications", "Landroidx/health/platform/client/proto/RequestProto$UnregisterFromDataNotificationsRequest;", "updateData", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class ServiceBackedHealthDataClient extends Client<IHealthDataService> implements HealthDataAsyncClient {
    private final String callingPackageName;
    private final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceBackedHealthDataClient(Context context, ClientConfiguration clientConfiguration, ConnectionManager connectionManager) {
        super(clientConfiguration, connectionManager, new Client.ServiceGetter() { // from class: androidx.health.platform.client.impl.ServiceBackedHealthDataClient$$ExternalSyntheticLambda0
            @Override // androidx.health.platform.client.impl.ipc.Client.ServiceGetter
            public final Object getService(IBinder iBinder) {
                return IHealthDataService.Stub.asInterface(iBinder);
            }
        }, new RemoteOperation() { // from class: androidx.health.platform.client.impl.ServiceBackedHealthDataClient$$ExternalSyntheticLambda7
            @Override // androidx.health.platform.client.impl.ipc.RemoteOperation
            public final Object execute(Object obj) {
                return Integer.valueOf(((IHealthDataService) obj).getApiVersion());
            }
        });
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(clientConfiguration, "clientConfiguration");
        Intrinsics.checkNotNullParameter(connectionManager, "connectionManager");
        this.context = context;
        this.callingPackageName = this.context.getPackageName();
    }

    private final RequestContext getRequestContext() {
        String callingPackageName = this.callingPackageName;
        Intrinsics.checkNotNullExpressionValue(callingPackageName, "callingPackageName");
        return new RequestContext(callingPackageName, SdkConfig.SDK_VERSION, PermissionTokenManager.getCurrentToken(this.context), ForegroundStateChecker.isInForeground());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ServiceBackedHealthDataClient(Context context, ClientConfiguration clientConfiguration) {
        this(context, clientConfiguration, ProviderConnectionManager.INSTANCE.getInstance(context));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(clientConfiguration, "clientConfiguration");
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<Set<PermissionProto.Permission>> getGrantedPermissions(final Set<PermissionProto.Permission> permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        ListenableFuture executeWithVersionCheck = executeWithVersionCheck(1, new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ServiceBackedHealthDataClient$$ExternalSyntheticLambda4
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                ServiceBackedHealthDataClient.getGrantedPermissions$lambda$1(ServiceBackedHealthDataClient.this, permissions, (IHealthDataService) obj, settableFuture);
            }
        });
        Intrinsics.checkNotNullExpressionValue(executeWithVersionCheck, "executeWithVersionCheck(…)\n            )\n        }");
        return executeWithVersionCheck;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGrantedPermissions$lambda$1(ServiceBackedHealthDataClient this$0, Set $permissions, IHealthDataService service, SettableFuture resultFuture) {
        RequestContext requestContext = this$0.getRequestContext();
        Set $this$map$iv = $permissions;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            PermissionProto.Permission it = (PermissionProto.Permission) item$iv$iv;
            destination$iv$iv.add(new Permission(it));
        }
        List<Permission> list = CollectionsKt.toList((List) destination$iv$iv);
        Intrinsics.checkNotNullExpressionValue(resultFuture, "resultFuture");
        service.getGrantedPermissions(requestContext, list, new GetGrantedPermissionsCallback(resultFuture));
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<Set<PermissionProto.Permission>> filterGrantedPermissions(final Set<PermissionProto.Permission> permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        ListenableFuture executeWithVersionCheck = executeWithVersionCheck(Math.min(1, 5), new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ServiceBackedHealthDataClient$$ExternalSyntheticLambda9
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                ServiceBackedHealthDataClient.filterGrantedPermissions$lambda$3(ServiceBackedHealthDataClient.this, permissions, (IHealthDataService) obj, settableFuture);
            }
        });
        Intrinsics.checkNotNullExpressionValue(executeWithVersionCheck, "executeWithVersionCheck(…)\n            )\n        }");
        return executeWithVersionCheck;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void filterGrantedPermissions$lambda$3(ServiceBackedHealthDataClient this$0, Set $permissions, IHealthDataService service, SettableFuture resultFuture) {
        RequestContext requestContext = this$0.getRequestContext();
        Set $this$map$iv = $permissions;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            PermissionProto.Permission it = (PermissionProto.Permission) item$iv$iv;
            destination$iv$iv.add(new Permission(it));
        }
        List<Permission> list = CollectionsKt.toList((List) destination$iv$iv);
        Intrinsics.checkNotNullExpressionValue(resultFuture, "resultFuture");
        service.filterGrantedPermissions(requestContext, list, new FilterGrantedPermissionsCallback(resultFuture));
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<Unit> revokeAllPermissions() {
        ListenableFuture executeWithVersionCheck = executeWithVersionCheck(1, new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ServiceBackedHealthDataClient$$ExternalSyntheticLambda10
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                ServiceBackedHealthDataClient.revokeAllPermissions$lambda$4(ServiceBackedHealthDataClient.this, (IHealthDataService) obj, settableFuture);
            }
        });
        Intrinsics.checkNotNullExpressionValue(executeWithVersionCheck, "executeWithVersionCheck(…)\n            )\n        }");
        return executeWithVersionCheck;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void revokeAllPermissions$lambda$4(ServiceBackedHealthDataClient this$0, IHealthDataService service, SettableFuture resultFuture) {
        RequestContext requestContext = this$0.getRequestContext();
        Intrinsics.checkNotNullExpressionValue(resultFuture, "resultFuture");
        service.revokeAllPermissions(requestContext, new RevokeAllPermissionsCallback(resultFuture));
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<List<String>> insertData(List<DataProto.DataPoint> dataCollection) {
        Intrinsics.checkNotNullParameter(dataCollection, "dataCollection");
        final UpsertDataRequest request = new UpsertDataRequest(dataCollection);
        ListenableFuture executeWithVersionCheck = executeWithVersionCheck(1, new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ServiceBackedHealthDataClient$$ExternalSyntheticLambda13
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                ServiceBackedHealthDataClient.insertData$lambda$5(ServiceBackedHealthDataClient.this, request, (IHealthDataService) obj, settableFuture);
            }
        });
        Intrinsics.checkNotNullExpressionValue(executeWithVersionCheck, "executeWithVersionCheck(…(resultFuture))\n        }");
        return executeWithVersionCheck;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void insertData$lambda$5(ServiceBackedHealthDataClient this$0, UpsertDataRequest $request, IHealthDataService service, SettableFuture resultFuture) {
        RequestContext requestContext = this$0.getRequestContext();
        Intrinsics.checkNotNullExpressionValue(resultFuture, "resultFuture");
        service.insertData(requestContext, $request, new InsertDataCallback(resultFuture));
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<Unit> updateData(List<DataProto.DataPoint> dataCollection) {
        Intrinsics.checkNotNullParameter(dataCollection, "dataCollection");
        final UpsertDataRequest request = new UpsertDataRequest(dataCollection);
        ListenableFuture executeWithVersionCheck = executeWithVersionCheck(1, new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ServiceBackedHealthDataClient$$ExternalSyntheticLambda5
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                ServiceBackedHealthDataClient.updateData$lambda$6(ServiceBackedHealthDataClient.this, request, (IHealthDataService) obj, settableFuture);
            }
        });
        Intrinsics.checkNotNullExpressionValue(executeWithVersionCheck, "executeWithVersionCheck(…(resultFuture))\n        }");
        return executeWithVersionCheck;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateData$lambda$6(ServiceBackedHealthDataClient this$0, UpsertDataRequest $request, IHealthDataService service, SettableFuture resultFuture) {
        RequestContext requestContext = this$0.getRequestContext();
        Intrinsics.checkNotNullExpressionValue(resultFuture, "resultFuture");
        service.updateData(requestContext, $request, new UpdateDataCallback(resultFuture));
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<Unit> deleteData(List<RequestProto.DataTypeIdPair> uidsCollection, List<RequestProto.DataTypeIdPair> clientIdsCollection) {
        Intrinsics.checkNotNullParameter(uidsCollection, "uidsCollection");
        Intrinsics.checkNotNullParameter(clientIdsCollection, "clientIdsCollection");
        final DeleteDataRequest request = new DeleteDataRequest(uidsCollection, clientIdsCollection);
        ListenableFuture executeWithVersionCheck = executeWithVersionCheck(1, new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ServiceBackedHealthDataClient$$ExternalSyntheticLambda6
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                ServiceBackedHealthDataClient.deleteData$lambda$7(ServiceBackedHealthDataClient.this, request, (IHealthDataService) obj, settableFuture);
            }
        });
        Intrinsics.checkNotNullExpressionValue(executeWithVersionCheck, "executeWithVersionCheck(…(resultFuture))\n        }");
        return executeWithVersionCheck;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteData$lambda$7(ServiceBackedHealthDataClient this$0, DeleteDataRequest $request, IHealthDataService service, SettableFuture resultFuture) {
        RequestContext requestContext = this$0.getRequestContext();
        Intrinsics.checkNotNullExpressionValue(resultFuture, "resultFuture");
        service.deleteData(requestContext, $request, new DeleteDataCallback(resultFuture));
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<Unit> deleteDataRange(RequestProto.DeleteDataRangeRequest dataCollection) {
        Intrinsics.checkNotNullParameter(dataCollection, "dataCollection");
        final DeleteDataRangeRequest request = new DeleteDataRangeRequest(dataCollection);
        ListenableFuture executeWithVersionCheck = executeWithVersionCheck(1, new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ServiceBackedHealthDataClient$$ExternalSyntheticLambda8
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                ServiceBackedHealthDataClient.deleteDataRange$lambda$8(ServiceBackedHealthDataClient.this, request, (IHealthDataService) obj, settableFuture);
            }
        });
        Intrinsics.checkNotNullExpressionValue(executeWithVersionCheck, "executeWithVersionCheck(…)\n            )\n        }");
        return executeWithVersionCheck;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteDataRange$lambda$8(ServiceBackedHealthDataClient this$0, DeleteDataRangeRequest $request, IHealthDataService service, SettableFuture resultFuture) {
        RequestContext requestContext = this$0.getRequestContext();
        Intrinsics.checkNotNullExpressionValue(resultFuture, "resultFuture");
        service.deleteDataRange(requestContext, $request, new DeleteDataRangeCallback(resultFuture));
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<DataProto.DataPoint> readData(RequestProto.ReadDataRequest dataCollection) {
        Intrinsics.checkNotNullParameter(dataCollection, "dataCollection");
        final ReadDataRequest request = new ReadDataRequest(dataCollection);
        ListenableFuture executeWithVersionCheck = executeWithVersionCheck(1, new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ServiceBackedHealthDataClient$$ExternalSyntheticLambda15
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                ServiceBackedHealthDataClient.readData$lambda$9(ServiceBackedHealthDataClient.this, request, (IHealthDataService) obj, settableFuture);
            }
        });
        Intrinsics.checkNotNullExpressionValue(executeWithVersionCheck, "executeWithVersionCheck(…(resultFuture))\n        }");
        return executeWithVersionCheck;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void readData$lambda$9(ServiceBackedHealthDataClient this$0, ReadDataRequest $request, IHealthDataService service, SettableFuture resultFuture) {
        RequestContext requestContext = this$0.getRequestContext();
        Intrinsics.checkNotNullExpressionValue(resultFuture, "resultFuture");
        service.readData(requestContext, $request, new ReadDataCallback(resultFuture));
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<ResponseProto.ReadDataRangeResponse> readDataRange(RequestProto.ReadDataRangeRequest dataCollection) {
        Intrinsics.checkNotNullParameter(dataCollection, "dataCollection");
        final ReadDataRangeRequest request = new ReadDataRangeRequest(dataCollection);
        ListenableFuture executeWithVersionCheck = executeWithVersionCheck(1, new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ServiceBackedHealthDataClient$$ExternalSyntheticLambda12
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                ServiceBackedHealthDataClient.readDataRange$lambda$10(ServiceBackedHealthDataClient.this, request, (IHealthDataService) obj, settableFuture);
            }
        });
        Intrinsics.checkNotNullExpressionValue(executeWithVersionCheck, "executeWithVersionCheck(…(resultFuture))\n        }");
        return executeWithVersionCheck;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void readDataRange$lambda$10(ServiceBackedHealthDataClient this$0, ReadDataRangeRequest $request, IHealthDataService service, SettableFuture resultFuture) {
        RequestContext requestContext = this$0.getRequestContext();
        Intrinsics.checkNotNullExpressionValue(resultFuture, "resultFuture");
        service.readDataRange(requestContext, $request, new ReadDataRangeCallback(resultFuture));
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<ResponseProto.AggregateDataResponse> aggregate(final RequestProto.AggregateDataRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        ListenableFuture executeWithVersionCheck = executeWithVersionCheck(1, new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ServiceBackedHealthDataClient$$ExternalSyntheticLambda3
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                ServiceBackedHealthDataClient.aggregate$lambda$11(ServiceBackedHealthDataClient.this, request, (IHealthDataService) obj, settableFuture);
            }
        });
        Intrinsics.checkNotNullExpressionValue(executeWithVersionCheck, "executeWithVersionCheck(…)\n            )\n        }");
        return executeWithVersionCheck;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aggregate$lambda$11(ServiceBackedHealthDataClient this$0, RequestProto.AggregateDataRequest $request, IHealthDataService service, SettableFuture resultFuture) {
        RequestContext requestContext = this$0.getRequestContext();
        AggregateDataRequest aggregateDataRequest = new AggregateDataRequest($request);
        Intrinsics.checkNotNullExpressionValue(resultFuture, "resultFuture");
        service.aggregate(requestContext, aggregateDataRequest, new AggregateDataCallback(resultFuture));
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<ResponseProto.GetChangesTokenResponse> getChangesToken(final RequestProto.GetChangesTokenRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        ListenableFuture executeWithVersionCheck = executeWithVersionCheck(1, new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ServiceBackedHealthDataClient$$ExternalSyntheticLambda2
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                ServiceBackedHealthDataClient.getChangesToken$lambda$12(ServiceBackedHealthDataClient.this, request, (IHealthDataService) obj, settableFuture);
            }
        });
        Intrinsics.checkNotNullExpressionValue(executeWithVersionCheck, "executeWithVersionCheck(…)\n            )\n        }");
        return executeWithVersionCheck;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getChangesToken$lambda$12(ServiceBackedHealthDataClient this$0, RequestProto.GetChangesTokenRequest $request, IHealthDataService service, SettableFuture resultFuture) {
        RequestContext requestContext = this$0.getRequestContext();
        GetChangesTokenRequest getChangesTokenRequest = new GetChangesTokenRequest($request);
        Intrinsics.checkNotNullExpressionValue(resultFuture, "resultFuture");
        service.getChangesToken(requestContext, getChangesTokenRequest, new GetChangesTokenCallback(resultFuture));
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<ResponseProto.GetChangesResponse> getChanges(final RequestProto.GetChangesRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        ListenableFuture executeWithVersionCheck = executeWithVersionCheck(1, new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ServiceBackedHealthDataClient$$ExternalSyntheticLambda1
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                ServiceBackedHealthDataClient.getChanges$lambda$13(ServiceBackedHealthDataClient.this, request, (IHealthDataService) obj, settableFuture);
            }
        });
        Intrinsics.checkNotNullExpressionValue(executeWithVersionCheck, "executeWithVersionCheck(…)\n            )\n        }");
        return executeWithVersionCheck;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getChanges$lambda$13(ServiceBackedHealthDataClient this$0, RequestProto.GetChangesRequest $request, IHealthDataService service, SettableFuture resultFuture) {
        RequestContext requestContext = this$0.getRequestContext();
        GetChangesRequest getChangesRequest = new GetChangesRequest($request);
        Intrinsics.checkNotNullExpressionValue(resultFuture, "resultFuture");
        service.getChanges(requestContext, getChangesRequest, new GetChangesCallback(resultFuture));
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<Void> registerForDataNotifications(final RequestProto.RegisterForDataNotificationsRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        ListenableFuture executeWithVersionCheck = executeWithVersionCheck(Math.min(1, 2), new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ServiceBackedHealthDataClient$$ExternalSyntheticLambda11
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                ServiceBackedHealthDataClient.registerForDataNotifications$lambda$14(ServiceBackedHealthDataClient.this, request, (IHealthDataService) obj, settableFuture);
            }
        });
        Intrinsics.checkNotNullExpressionValue(executeWithVersionCheck, "executeWithVersionCheck(…,\n            )\n        }");
        return executeWithVersionCheck;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerForDataNotifications$lambda$14(ServiceBackedHealthDataClient this$0, RequestProto.RegisterForDataNotificationsRequest $request, IHealthDataService service, SettableFuture resultFuture) {
        RequestContext requestContext = this$0.getRequestContext();
        RegisterForDataNotificationsRequest registerForDataNotificationsRequest = new RegisterForDataNotificationsRequest($request);
        Intrinsics.checkNotNullExpressionValue(resultFuture, "resultFuture");
        service.registerForDataNotifications(requestContext, registerForDataNotificationsRequest, new RegisterForDataNotificationsCallback(resultFuture));
    }

    @Override // androidx.health.platform.client.HealthDataAsyncClient
    public ListenableFuture<Void> unregisterFromDataNotifications(final RequestProto.UnregisterFromDataNotificationsRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        ListenableFuture executeWithVersionCheck = executeWithVersionCheck(Math.min(1, 2), new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ServiceBackedHealthDataClient$$ExternalSyntheticLambda14
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                ServiceBackedHealthDataClient.unregisterFromDataNotifications$lambda$15(ServiceBackedHealthDataClient.this, request, (IHealthDataService) obj, settableFuture);
            }
        });
        Intrinsics.checkNotNullExpressionValue(executeWithVersionCheck, "executeWithVersionCheck(…,\n            )\n        }");
        return executeWithVersionCheck;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void unregisterFromDataNotifications$lambda$15(ServiceBackedHealthDataClient this$0, RequestProto.UnregisterFromDataNotificationsRequest $request, IHealthDataService service, SettableFuture resultFuture) {
        RequestContext requestContext = this$0.getRequestContext();
        UnregisterFromDataNotificationsRequest unregisterFromDataNotificationsRequest = new UnregisterFromDataNotificationsRequest($request);
        Intrinsics.checkNotNullExpressionValue(resultFuture, "resultFuture");
        service.unregisterFromDataNotifications(requestContext, unregisterFromDataNotificationsRequest, new UnregisterFromDataNotificationsCallback(resultFuture));
    }
}
