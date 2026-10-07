package androidx.health.connect.client.impl;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.HealthConnectFeatures;
import androidx.health.connect.client.PermissionController;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByPeriod;
import androidx.health.connect.client.feature.HealthConnectFeaturesApkImpl;
import androidx.health.connect.client.feature.HealthConnectFeaturesUnavailableImpl;
import androidx.health.connect.client.impl.converters.aggregate.ProtoToAggregateDataRowKt;
import androidx.health.connect.client.impl.converters.datatype.DataTypeConverterKt;
import androidx.health.connect.client.impl.converters.datatype.DataTypeIdPairConverterKt;
import androidx.health.connect.client.impl.converters.records.ProtoToRecordConvertersKt;
import androidx.health.connect.client.impl.converters.records.RecordToProtoConvertersKt;
import androidx.health.connect.client.impl.converters.request.AggregateRequestToProtoKt;
import androidx.health.connect.client.impl.converters.request.DeleteDataRangeRequestToProtoKt;
import androidx.health.connect.client.impl.converters.request.ReadDataRangeRequestToProtoKt;
import androidx.health.connect.client.impl.converters.request.ReadDataRequestToProtoKt;
import androidx.health.connect.client.impl.converters.response.ProtoToChangesResponseKt;
import androidx.health.connect.client.impl.converters.response.ProtoToReadRecordsResponseKt;
import androidx.health.connect.client.permission.HealthPermission;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.AggregateGroupByPeriodRequest;
import androidx.health.connect.client.request.AggregateRequest;
import androidx.health.connect.client.request.ChangesTokenRequest;
import androidx.health.connect.client.request.ReadRecordsRequest;
import androidx.health.connect.client.response.ChangesResponse;
import androidx.health.connect.client.response.InsertRecordsResponse;
import androidx.health.connect.client.response.ReadRecordResponse;
import androidx.health.connect.client.response.ReadRecordsResponse;
import androidx.health.connect.client.time.TimeRangeFilter;
import androidx.health.platform.client.HealthDataAsyncClient;
import androidx.health.platform.client.HealthDataService;
import androidx.health.platform.client.impl.logger.Logger;
import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.PermissionProto;
import androidx.health.platform.client.proto.RequestProto;
import androidx.health.platform.client.proto.ResponseProto;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.guava.ListenableFutureKt;

/* compiled from: HealthConnectClientImpl.kt */
@Metadata(m286d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0017\b\u0001\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0014\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00182\u0006\u0010\u0014\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010\u001fJ&\u0010 \u001a\u00020!2\u000e\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0#2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010'J:\u0010 \u001a\u00020!2\u000e\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0#2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u00182\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018H\u0096@¢\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u000200H\u0096@¢\u0006\u0002\u00101J\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u000603H\u0096@¢\u0006\u0002\u00104J\u001c\u00105\u001a\u0002062\f\u00107\u001a\b\u0012\u0004\u0012\u00020$0\u0018H\u0096@¢\u0006\u0002\u00108J4\u00109\u001a\b\u0012\u0004\u0012\u0002H;0:\"\b\b\u0000\u0010;*\u00020$2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H;0#2\u0006\u0010<\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010=J,\u0010>\u001a\b\u0012\u0004\u0012\u0002H;0?\"\b\b\u0000\u0010;*\u00020$2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H;0@H\u0096@¢\u0006\u0002\u0010AJ\u000e\u0010B\u001a\u00020!H\u0096@¢\u0006\u0002\u00104J\u001c\u0010C\u001a\u00020!2\f\u00107\u001a\b\u0012\u0004\u0012\u00020$0\u0018H\u0096@¢\u0006\u0002\u00108J\"\u0010D\u001a\u0002H;\"\u0004\b\u0000\u0010;2\f\u0010E\u001a\b\u0012\u0004\u0012\u0002H;0FH\u0082\b¢\u0006\u0002\u0010GR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006H"}, m287d2 = {"Landroidx/health/connect/client/impl/HealthConnectClientImpl;", "Landroidx/health/connect/client/HealthConnectClient;", "Landroidx/health/connect/client/PermissionController;", "context", "Landroid/content/Context;", "providerPackageName", "", "(Landroid/content/Context;Ljava/lang/String;)V", "delegate", "Landroidx/health/platform/client/HealthDataAsyncClient;", "features", "Landroidx/health/connect/client/HealthConnectFeatures;", "(Landroidx/health/platform/client/HealthDataAsyncClient;Landroidx/health/connect/client/HealthConnectFeatures;)V", "getFeatures", "()Landroidx/health/connect/client/HealthConnectFeatures;", "permissionController", "getPermissionController", "()Landroidx/health/connect/client/PermissionController;", "aggregate", "Landroidx/health/connect/client/aggregate/AggregationResult;", "request", "Landroidx/health/connect/client/request/AggregateRequest;", "(Landroidx/health/connect/client/request/AggregateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aggregateGroupByDuration", "", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "(Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aggregateGroupByPeriod", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByPeriod;", "Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;", "(Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecords", "", "recordType", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/Record;", "timeRangeFilter", "Landroidx/health/connect/client/time/TimeRangeFilter;", "(Lkotlin/reflect/KClass;Landroidx/health/connect/client/time/TimeRangeFilter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordIdsList", "clientRecordIdsList", "(Lkotlin/reflect/KClass;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChanges", "Landroidx/health/connect/client/response/ChangesResponse;", "changesToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChangesToken", "Landroidx/health/connect/client/request/ChangesTokenRequest;", "(Landroidx/health/connect/client/request/ChangesTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGrantedPermissions", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertRecords", "Landroidx/health/connect/client/response/InsertRecordsResponse;", "records", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRecord", "Landroidx/health/connect/client/response/ReadRecordResponse;", "T", "recordId", "(Lkotlin/reflect/KClass;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRecords", "Landroidx/health/connect/client/response/ReadRecordsResponse;", "Landroidx/health/connect/client/request/ReadRecordsRequest;", "(Landroidx/health/connect/client/request/ReadRecordsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revokeAllPermissions", "updateRecords", "wrapRemoteException", "function", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class HealthConnectClientImpl implements HealthConnectClient, PermissionController {
    private final HealthDataAsyncClient delegate;
    private final HealthConnectFeatures features;

    public HealthConnectClientImpl(HealthDataAsyncClient delegate, HealthConnectFeatures features) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(features, "features");
        this.delegate = delegate;
        this.features = features;
    }

    @Override // androidx.health.connect.client.HealthConnectClient
    public HealthConnectFeatures getFeatures() {
        return this.features;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HealthConnectClientImpl(Context context, String providerPackageName) {
        this(r0, r1);
        HealthConnectFeaturesUnavailableImpl healthConnectFeaturesUnavailableImpl;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(providerPackageName, "providerPackageName");
        HealthDataAsyncClient client = HealthDataService.INSTANCE.getClient(context, providerPackageName);
        if (Intrinsics.areEqual(providerPackageName, "com.google.android.apps.healthdata")) {
            healthConnectFeaturesUnavailableImpl = new HealthConnectFeaturesApkImpl(context, providerPackageName);
        } else {
            healthConnectFeaturesUnavailableImpl = HealthConnectFeaturesUnavailableImpl.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b6 A[Catch: RemoteException -> 0x0107, LOOP:0: B:16:0x00b0->B:18:0x00b6, LOOP_END, TryCatch #1 {RemoteException -> 0x0107, blocks: (B:15:0x009b, B:16:0x00b0, B:18:0x00b6, B:20:0x00c6, B:39:0x0048, B:40:0x005f, B:42:0x0065, B:44:0x0081), top: B:38:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    @Override // androidx.health.connect.client.PermissionController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getGrantedPermissions(Continuation<? super Set<String>> continuation) {
        HealthConnectClientImpl$getGrantedPermissions$1 healthConnectClientImpl$getGrantedPermissions$1;
        HealthConnectClientImpl$getGrantedPermissions$1 healthConnectClientImpl$getGrantedPermissions$12;
        int $i$f$wrapRemoteException;
        Object await;
        RemoteException e$iv;
        if (continuation instanceof HealthConnectClientImpl$getGrantedPermissions$1) {
            healthConnectClientImpl$getGrantedPermissions$1 = (HealthConnectClientImpl$getGrantedPermissions$1) continuation;
            if ((healthConnectClientImpl$getGrantedPermissions$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientImpl$getGrantedPermissions$1.label -= Integer.MIN_VALUE;
                healthConnectClientImpl$getGrantedPermissions$12 = healthConnectClientImpl$getGrantedPermissions$1;
                Object $result = healthConnectClientImpl$getGrantedPermissions$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientImpl$getGrantedPermissions$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $i$f$wrapRemoteException = 0;
                        try {
                            HealthDataAsyncClient healthDataAsyncClient = this.delegate;
                            Iterable $this$map$iv = HealthPermission.ALL_PERMISSIONS;
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                String it = (String) item$iv$iv;
                                destination$iv$iv.add(PermissionProto.Permission.newBuilder().setPermission(it).build());
                            }
                            ListenableFuture<Set<PermissionProto.Permission>> filterGrantedPermissions = healthDataAsyncClient.filterGrantedPermissions(CollectionsKt.toSet((List) destination$iv$iv));
                            healthConnectClientImpl$getGrantedPermissions$12.label = 1;
                            await = ListenableFutureKt.await(filterGrantedPermissions, healthConnectClientImpl$getGrantedPermissions$12);
                            if (await == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Iterable $this$map$iv2 = (Iterable) await;
                            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                            for (Object item$iv$iv2 : $this$map$iv2) {
                                PermissionProto.Permission it2 = (PermissionProto.Permission) item$iv$iv2;
                                destination$iv$iv2.add(it2.getPermission());
                            }
                            Set grantedPermissions = CollectionsKt.toSet((List) destination$iv$iv2);
                            Logger.debug("HealthConnectClient", "Granted " + grantedPermissions.size() + " out of " + HealthPermission.ALL_PERMISSIONS.size() + " permissions.");
                            return grantedPermissions;
                        } catch (RemoteException e) {
                            e$iv = e;
                            if (e$iv instanceof DeadObjectException) {
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    case 1:
                        try {
                            ResultKt.throwOnFailure($result);
                            $i$f$wrapRemoteException = 0;
                            await = $result;
                            Iterable $this$map$iv22 = (Iterable) await;
                            Collection destination$iv$iv22 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv22, 10));
                            while (r10.hasNext()) {
                            }
                            Set grantedPermissions2 = CollectionsKt.toSet((List) destination$iv$iv22);
                            Logger.debug("HealthConnectClient", "Granted " + grantedPermissions2.size() + " out of " + HealthPermission.ALL_PERMISSIONS.size() + " permissions.");
                            return grantedPermissions2;
                        } catch (RemoteException e2) {
                            e$iv = e2;
                            DeadObjectException wrapper$iv = e$iv instanceof DeadObjectException ? e$iv instanceof TransactionTooLargeException ? new TransactionTooLargeException(e$iv.getMessage()) : new RemoteException(e$iv.getMessage()) : new DeadObjectException(e$iv.getMessage());
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        healthConnectClientImpl$getGrantedPermissions$1 = new HealthConnectClientImpl$getGrantedPermissions$1(this, continuation);
        healthConnectClientImpl$getGrantedPermissions$12 = healthConnectClientImpl$getGrantedPermissions$1;
        Object $result2 = healthConnectClientImpl$getGrantedPermissions$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientImpl$getGrantedPermissions$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.health.connect.client.PermissionController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object revokeAllPermissions(Continuation<? super Unit> continuation) {
        HealthConnectClientImpl$revokeAllPermissions$1 healthConnectClientImpl$revokeAllPermissions$1;
        DeadObjectException wrapper$iv;
        if (continuation instanceof HealthConnectClientImpl$revokeAllPermissions$1) {
            healthConnectClientImpl$revokeAllPermissions$1 = (HealthConnectClientImpl$revokeAllPermissions$1) continuation;
            if ((healthConnectClientImpl$revokeAllPermissions$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientImpl$revokeAllPermissions$1.label -= Integer.MIN_VALUE;
                Object $result = healthConnectClientImpl$revokeAllPermissions$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientImpl$revokeAllPermissions$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            ListenableFuture<Unit> revokeAllPermissions = this.delegate.revokeAllPermissions();
                            healthConnectClientImpl$revokeAllPermissions$1.label = 1;
                            if (ListenableFutureKt.await(revokeAllPermissions, healthConnectClientImpl$revokeAllPermissions$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Logger.debug("HealthConnectClient", "Revoked all permissions.");
                            return Unit.INSTANCE;
                        } catch (RemoteException e) {
                            e$iv = e;
                            if (!(e$iv instanceof DeadObjectException)) {
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    case 1:
                        try {
                            ResultKt.throwOnFailure($result);
                            Logger.debug("HealthConnectClient", "Revoked all permissions.");
                            return Unit.INSTANCE;
                        } catch (RemoteException e2) {
                            e$iv = e2;
                            if (!(e$iv instanceof DeadObjectException)) {
                                wrapper$iv = new DeadObjectException(e$iv.getMessage());
                            } else {
                                wrapper$iv = e$iv instanceof TransactionTooLargeException ? new TransactionTooLargeException(e$iv.getMessage()) : new RemoteException(e$iv.getMessage());
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        healthConnectClientImpl$revokeAllPermissions$1 = new HealthConnectClientImpl$revokeAllPermissions$1(this, continuation);
        Object $result2 = healthConnectClientImpl$revokeAllPermissions$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientImpl$revokeAllPermissions$1.label) {
        }
    }

    @Override // androidx.health.connect.client.HealthConnectClient
    public PermissionController getPermissionController() {
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object insertRecords(List<? extends Record> list, Continuation<? super InsertRecordsResponse> continuation) {
        HealthConnectClientImpl$insertRecords$1 healthConnectClientImpl$insertRecords$1;
        HealthConnectClientImpl$insertRecords$1 healthConnectClientImpl$insertRecords$12;
        List records;
        Object await;
        if (continuation instanceof HealthConnectClientImpl$insertRecords$1) {
            healthConnectClientImpl$insertRecords$1 = (HealthConnectClientImpl$insertRecords$1) continuation;
            if ((healthConnectClientImpl$insertRecords$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientImpl$insertRecords$1.label -= Integer.MIN_VALUE;
                healthConnectClientImpl$insertRecords$12 = healthConnectClientImpl$insertRecords$1;
                Object $result = healthConnectClientImpl$insertRecords$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientImpl$insertRecords$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        records = list;
                        try {
                            HealthDataAsyncClient healthDataAsyncClient = this.delegate;
                            List $this$map$iv = records;
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                Record it = (Record) item$iv$iv;
                                destination$iv$iv.add(RecordToProtoConvertersKt.toProto(it));
                            }
                            ListenableFuture<List<String>> insertData = healthDataAsyncClient.insertData((List) destination$iv$iv);
                            healthConnectClientImpl$insertRecords$12.L$0 = records;
                            healthConnectClientImpl$insertRecords$12.label = 1;
                            await = ListenableFutureKt.await(insertData, healthConnectClientImpl$insertRecords$12);
                            if (await == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            List uidList = (List) await;
                            Logger.debug("HealthConnectClient", records.size() + " records inserted.");
                            return new InsertRecordsResponse(uidList);
                        } catch (RemoteException e) {
                            e$iv = e;
                            if (e$iv instanceof DeadObjectException) {
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    case 1:
                        records = (List) healthConnectClientImpl$insertRecords$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            await = $result;
                            List uidList2 = (List) await;
                            Logger.debug("HealthConnectClient", records.size() + " records inserted.");
                            return new InsertRecordsResponse(uidList2);
                        } catch (RemoteException e2) {
                            e$iv = e2;
                            DeadObjectException wrapper$iv = e$iv instanceof DeadObjectException ? e$iv instanceof TransactionTooLargeException ? new TransactionTooLargeException(e$iv.getMessage()) : new RemoteException(e$iv.getMessage()) : new DeadObjectException(e$iv.getMessage());
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        healthConnectClientImpl$insertRecords$1 = new HealthConnectClientImpl$insertRecords$1(this, continuation);
        healthConnectClientImpl$insertRecords$12 = healthConnectClientImpl$insertRecords$1;
        Object $result2 = healthConnectClientImpl$insertRecords$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientImpl$insertRecords$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateRecords(List<? extends Record> list, Continuation<? super Unit> continuation) {
        HealthConnectClientImpl$updateRecords$1 healthConnectClientImpl$updateRecords$1;
        HealthConnectClientImpl$updateRecords$1 healthConnectClientImpl$updateRecords$12;
        List records;
        if (continuation instanceof HealthConnectClientImpl$updateRecords$1) {
            healthConnectClientImpl$updateRecords$1 = (HealthConnectClientImpl$updateRecords$1) continuation;
            if ((healthConnectClientImpl$updateRecords$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientImpl$updateRecords$1.label -= Integer.MIN_VALUE;
                healthConnectClientImpl$updateRecords$12 = healthConnectClientImpl$updateRecords$1;
                Object $result = healthConnectClientImpl$updateRecords$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientImpl$updateRecords$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        records = list;
                        try {
                            HealthDataAsyncClient healthDataAsyncClient = this.delegate;
                            List $this$map$iv = records;
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                Record it = (Record) item$iv$iv;
                                destination$iv$iv.add(RecordToProtoConvertersKt.toProto(it));
                            }
                            ListenableFuture<Unit> updateData = healthDataAsyncClient.updateData((List) destination$iv$iv);
                            healthConnectClientImpl$updateRecords$12.L$0 = records;
                            healthConnectClientImpl$updateRecords$12.label = 1;
                            if (ListenableFutureKt.await(updateData, healthConnectClientImpl$updateRecords$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Logger.debug("HealthConnectClient", records.size() + " records updated.");
                            return Unit.INSTANCE;
                        } catch (RemoteException e) {
                            e$iv = e;
                            DeadObjectException wrapper$iv = e$iv instanceof DeadObjectException ? e$iv instanceof TransactionTooLargeException ? new TransactionTooLargeException(e$iv.getMessage()) : new RemoteException(e$iv.getMessage()) : new DeadObjectException(e$iv.getMessage());
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    case 1:
                        records = (List) healthConnectClientImpl$updateRecords$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            Logger.debug("HealthConnectClient", records.size() + " records updated.");
                            return Unit.INSTANCE;
                        } catch (RemoteException e2) {
                            e$iv = e2;
                            if (e$iv instanceof DeadObjectException) {
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        healthConnectClientImpl$updateRecords$1 = new HealthConnectClientImpl$updateRecords$1(this, continuation);
        healthConnectClientImpl$updateRecords$12 = healthConnectClientImpl$updateRecords$1;
        Object $result2 = healthConnectClientImpl$updateRecords$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientImpl$updateRecords$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deleteRecords(KClass<? extends Record> kClass, List<String> list, List<String> list2, Continuation<? super Unit> continuation) {
        HealthConnectClientImpl$deleteRecords$1 healthConnectClientImpl$deleteRecords$1;
        List recordIdsList;
        DeadObjectException wrapper$iv;
        if (continuation instanceof HealthConnectClientImpl$deleteRecords$1) {
            healthConnectClientImpl$deleteRecords$1 = (HealthConnectClientImpl$deleteRecords$1) continuation;
            if ((healthConnectClientImpl$deleteRecords$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientImpl$deleteRecords$1.label -= Integer.MIN_VALUE;
                Object $result = healthConnectClientImpl$deleteRecords$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientImpl$deleteRecords$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            ListenableFuture<Unit> deleteData = this.delegate.deleteData(DataTypeIdPairConverterKt.toDataTypeIdPairProtoList(kClass, list), DataTypeIdPairConverterKt.toDataTypeIdPairProtoList(kClass, list2));
                            healthConnectClientImpl$deleteRecords$1.L$0 = list;
                            healthConnectClientImpl$deleteRecords$1.L$1 = list2;
                            healthConnectClientImpl$deleteRecords$1.label = 1;
                            if (ListenableFutureKt.await(deleteData, healthConnectClientImpl$deleteRecords$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            recordIdsList = list;
                            Logger.debug("HealthConnectClient", (recordIdsList.size() + list2.size()) + " records deleted.");
                            return Unit.INSTANCE;
                        } catch (RemoteException e) {
                            e$iv = e;
                            if (!(e$iv instanceof DeadObjectException)) {
                                wrapper$iv = new DeadObjectException(e$iv.getMessage());
                            } else {
                                wrapper$iv = e$iv instanceof TransactionTooLargeException ? new TransactionTooLargeException(e$iv.getMessage()) : new RemoteException(e$iv.getMessage());
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    case 1:
                        list2 = (List) healthConnectClientImpl$deleteRecords$1.L$1;
                        recordIdsList = (List) healthConnectClientImpl$deleteRecords$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            Logger.debug("HealthConnectClient", (recordIdsList.size() + list2.size()) + " records deleted.");
                            return Unit.INSTANCE;
                        } catch (RemoteException e2) {
                            e$iv = e2;
                            if (!(e$iv instanceof DeadObjectException)) {
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        healthConnectClientImpl$deleteRecords$1 = new HealthConnectClientImpl$deleteRecords$1(this, continuation);
        Object $result2 = healthConnectClientImpl$deleteRecords$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientImpl$deleteRecords$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deleteRecords(KClass<? extends Record> kClass, TimeRangeFilter timeRangeFilter, Continuation<? super Unit> continuation) {
        HealthConnectClientImpl$deleteRecords$3 healthConnectClientImpl$deleteRecords$3;
        DeadObjectException wrapper$iv;
        if (continuation instanceof HealthConnectClientImpl$deleteRecords$3) {
            healthConnectClientImpl$deleteRecords$3 = (HealthConnectClientImpl$deleteRecords$3) continuation;
            if ((healthConnectClientImpl$deleteRecords$3.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientImpl$deleteRecords$3.label -= Integer.MIN_VALUE;
                Object $result = healthConnectClientImpl$deleteRecords$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientImpl$deleteRecords$3.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            ListenableFuture<Unit> deleteDataRange = this.delegate.deleteDataRange(DeleteDataRangeRequestToProtoKt.toDeleteDataRangeRequestProto(kClass, timeRangeFilter));
                            healthConnectClientImpl$deleteRecords$3.label = 1;
                            if (ListenableFutureKt.await(deleteDataRange, healthConnectClientImpl$deleteRecords$3) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Logger.debug("HealthConnectClient", "Records deletion successful.");
                            return Unit.INSTANCE;
                        } catch (RemoteException e) {
                            e$iv = e;
                            if (!(e$iv instanceof DeadObjectException)) {
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    case 1:
                        try {
                            ResultKt.throwOnFailure($result);
                            Logger.debug("HealthConnectClient", "Records deletion successful.");
                            return Unit.INSTANCE;
                        } catch (RemoteException e2) {
                            e$iv = e2;
                            if (!(e$iv instanceof DeadObjectException)) {
                                wrapper$iv = new DeadObjectException(e$iv.getMessage());
                            } else {
                                wrapper$iv = e$iv instanceof TransactionTooLargeException ? new TransactionTooLargeException(e$iv.getMessage()) : new RemoteException(e$iv.getMessage());
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        healthConnectClientImpl$deleteRecords$3 = new HealthConnectClientImpl$deleteRecords$3(this, continuation);
        Object $result2 = healthConnectClientImpl$deleteRecords$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientImpl$deleteRecords$3.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T extends Record> Object readRecord(KClass<T> kClass, String recordId, Continuation<? super ReadRecordResponse<T>> continuation) {
        HealthConnectClientImpl$readRecord$1 healthConnectClientImpl$readRecord$1;
        Object await;
        String recordId2;
        DeadObjectException wrapper$iv;
        if (continuation instanceof HealthConnectClientImpl$readRecord$1) {
            healthConnectClientImpl$readRecord$1 = (HealthConnectClientImpl$readRecord$1) continuation;
            if ((healthConnectClientImpl$readRecord$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientImpl$readRecord$1.label -= Integer.MIN_VALUE;
                Object $result = healthConnectClientImpl$readRecord$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientImpl$readRecord$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            ListenableFuture<DataProto.DataPoint> readData = this.delegate.readData(ReadDataRequestToProtoKt.toReadDataRequestProto(kClass, recordId));
                            healthConnectClientImpl$readRecord$1.L$0 = recordId;
                            healthConnectClientImpl$readRecord$1.label = 1;
                            await = ListenableFutureKt.await(readData, healthConnectClientImpl$readRecord$1);
                            if (await == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            recordId2 = recordId;
                            DataProto.DataPoint proto = (DataProto.DataPoint) await;
                            Record record = ProtoToRecordConvertersKt.toRecord(proto);
                            Intrinsics.checkNotNull(record, "null cannot be cast to non-null type T of androidx.health.connect.client.impl.HealthConnectClientImpl.readRecord");
                            ReadRecordResponse response = new ReadRecordResponse(record);
                            Logger.debug("HealthConnectClient", "Reading record of " + recordId2 + " successful.");
                            return response;
                        } catch (RemoteException e) {
                            e$iv = e;
                            if (!(e$iv instanceof DeadObjectException)) {
                                wrapper$iv = new DeadObjectException(e$iv.getMessage());
                            } else {
                                wrapper$iv = e$iv instanceof TransactionTooLargeException ? new TransactionTooLargeException(e$iv.getMessage()) : new RemoteException(e$iv.getMessage());
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    case 1:
                        recordId2 = (String) healthConnectClientImpl$readRecord$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            await = $result;
                            DataProto.DataPoint proto2 = (DataProto.DataPoint) await;
                            Record record2 = ProtoToRecordConvertersKt.toRecord(proto2);
                            Intrinsics.checkNotNull(record2, "null cannot be cast to non-null type T of androidx.health.connect.client.impl.HealthConnectClientImpl.readRecord");
                            ReadRecordResponse response2 = new ReadRecordResponse(record2);
                            Logger.debug("HealthConnectClient", "Reading record of " + recordId2 + " successful.");
                            return response2;
                        } catch (RemoteException e2) {
                            e$iv = e2;
                            if (!(e$iv instanceof DeadObjectException)) {
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        healthConnectClientImpl$readRecord$1 = new HealthConnectClientImpl$readRecord$1(this, continuation);
        Object $result2 = healthConnectClientImpl$readRecord$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientImpl$readRecord$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getChangesToken(ChangesTokenRequest request, Continuation<? super String> continuation) {
        HealthConnectClientImpl$getChangesToken$1 healthConnectClientImpl$getChangesToken$1;
        HealthConnectClientImpl$getChangesToken$1 healthConnectClientImpl$getChangesToken$12;
        Object await;
        DeadObjectException wrapper$iv;
        if (continuation instanceof HealthConnectClientImpl$getChangesToken$1) {
            healthConnectClientImpl$getChangesToken$1 = (HealthConnectClientImpl$getChangesToken$1) continuation;
            if ((healthConnectClientImpl$getChangesToken$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientImpl$getChangesToken$1.label -= Integer.MIN_VALUE;
                healthConnectClientImpl$getChangesToken$12 = healthConnectClientImpl$getChangesToken$1;
                Object $result = healthConnectClientImpl$getChangesToken$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientImpl$getChangesToken$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            HealthDataAsyncClient healthDataAsyncClient = this.delegate;
                            RequestProto.GetChangesTokenRequest.Builder newBuilder = RequestProto.GetChangesTokenRequest.newBuilder();
                            Iterable $this$map$iv = request.getRecordTypes();
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                KClass it = (KClass) item$iv$iv;
                                destination$iv$iv.add(DataTypeConverterKt.toDataType(it));
                            }
                            RequestProto.GetChangesTokenRequest.Builder addAllDataType = newBuilder.addAllDataType((List) destination$iv$iv);
                            Iterable $this$map$iv2 = request.getDataOriginFilters();
                            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                            for (Object item$iv$iv2 : $this$map$iv2) {
                                DataOrigin it2 = (DataOrigin) item$iv$iv2;
                                destination$iv$iv2.add(DataProto.DataOrigin.newBuilder().setApplicationId(it2.getPackageName()).build());
                            }
                            RequestProto.GetChangesTokenRequest build = addAllDataType.addAllDataOriginFilters((List) destination$iv$iv2).build();
                            Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …                 .build()");
                            ListenableFuture<ResponseProto.GetChangesTokenResponse> changesToken = healthDataAsyncClient.getChangesToken(build);
                            healthConnectClientImpl$getChangesToken$12.label = 1;
                            await = ListenableFutureKt.await(changesToken, healthConnectClientImpl$getChangesToken$12);
                            if (await == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ResponseProto.GetChangesTokenResponse proto = (ResponseProto.GetChangesTokenResponse) await;
                            String changeToken = proto.getChangesToken();
                            Logger.debug("HealthConnectClient", "Retrieved change token " + changeToken + '.');
                            Intrinsics.checkNotNullExpressionValue(changeToken, "changeToken");
                            return changeToken;
                        } catch (RemoteException e) {
                            e$iv = e;
                            if (!(e$iv instanceof DeadObjectException)) {
                                wrapper$iv = new DeadObjectException(e$iv.getMessage());
                            } else {
                                wrapper$iv = e$iv instanceof TransactionTooLargeException ? new TransactionTooLargeException(e$iv.getMessage()) : new RemoteException(e$iv.getMessage());
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    case 1:
                        try {
                            ResultKt.throwOnFailure($result);
                            await = $result;
                            ResponseProto.GetChangesTokenResponse proto2 = (ResponseProto.GetChangesTokenResponse) await;
                            String changeToken2 = proto2.getChangesToken();
                            Logger.debug("HealthConnectClient", "Retrieved change token " + changeToken2 + '.');
                            Intrinsics.checkNotNullExpressionValue(changeToken2, "changeToken");
                            return changeToken2;
                        } catch (RemoteException e2) {
                            e$iv = e2;
                            if (!(e$iv instanceof DeadObjectException)) {
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        healthConnectClientImpl$getChangesToken$1 = new HealthConnectClientImpl$getChangesToken$1(this, continuation);
        healthConnectClientImpl$getChangesToken$12 = healthConnectClientImpl$getChangesToken$1;
        Object $result2 = healthConnectClientImpl$getChangesToken$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientImpl$getChangesToken$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getChanges(String changesToken, Continuation<? super ChangesResponse> continuation) {
        HealthConnectClientImpl$getChanges$1 healthConnectClientImpl$getChanges$1;
        Object await;
        String changesToken2;
        DeadObjectException wrapper$iv;
        if (continuation instanceof HealthConnectClientImpl$getChanges$1) {
            healthConnectClientImpl$getChanges$1 = (HealthConnectClientImpl$getChanges$1) continuation;
            if ((healthConnectClientImpl$getChanges$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientImpl$getChanges$1.label -= Integer.MIN_VALUE;
                Object $result = healthConnectClientImpl$getChanges$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientImpl$getChanges$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            HealthDataAsyncClient healthDataAsyncClient = this.delegate;
                            RequestProto.GetChangesRequest build = RequestProto.GetChangesRequest.newBuilder().setChangesToken(changesToken).build();
                            Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …                 .build()");
                            ListenableFuture<ResponseProto.GetChangesResponse> changes = healthDataAsyncClient.getChanges(build);
                            healthConnectClientImpl$getChanges$1.L$0 = changesToken;
                            healthConnectClientImpl$getChanges$1.label = 1;
                            await = ListenableFutureKt.await(changes, healthConnectClientImpl$getChanges$1);
                            if (await == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            changesToken2 = changesToken;
                            ResponseProto.GetChangesResponse proto = (ResponseProto.GetChangesResponse) await;
                            String nextToken = proto.getNextChangesToken();
                            Logger.debug("HealthConnectClient", "Retrieved changes successful with " + changesToken2 + ", next token " + nextToken + '.');
                            return ProtoToChangesResponseKt.toChangesResponse(proto);
                        } catch (RemoteException e) {
                            e$iv = e;
                            if (!(e$iv instanceof DeadObjectException)) {
                                wrapper$iv = new DeadObjectException(e$iv.getMessage());
                            } else {
                                wrapper$iv = e$iv instanceof TransactionTooLargeException ? new TransactionTooLargeException(e$iv.getMessage()) : new RemoteException(e$iv.getMessage());
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    case 1:
                        String changesToken3 = (String) healthConnectClientImpl$getChanges$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            changesToken2 = changesToken3;
                            await = $result;
                            ResponseProto.GetChangesResponse proto2 = (ResponseProto.GetChangesResponse) await;
                            String nextToken2 = proto2.getNextChangesToken();
                            Logger.debug("HealthConnectClient", "Retrieved changes successful with " + changesToken2 + ", next token " + nextToken2 + '.');
                            return ProtoToChangesResponseKt.toChangesResponse(proto2);
                        } catch (RemoteException e2) {
                            e$iv = e2;
                            if (!(e$iv instanceof DeadObjectException)) {
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        healthConnectClientImpl$getChanges$1 = new HealthConnectClientImpl$getChanges$1(this, continuation);
        Object $result2 = healthConnectClientImpl$getChanges$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientImpl$getChanges$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T extends Record> Object readRecords(ReadRecordsRequest<T> readRecordsRequest, Continuation<? super ReadRecordsResponse<T>> continuation) {
        HealthConnectClientImpl$readRecords$1 healthConnectClientImpl$readRecords$1;
        Object await;
        DeadObjectException wrapper$iv;
        if (continuation instanceof HealthConnectClientImpl$readRecords$1) {
            healthConnectClientImpl$readRecords$1 = (HealthConnectClientImpl$readRecords$1) continuation;
            if ((healthConnectClientImpl$readRecords$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientImpl$readRecords$1.label -= Integer.MIN_VALUE;
                Object $result = healthConnectClientImpl$readRecords$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientImpl$readRecords$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (readRecordsRequest.getDeduplicateStrategy() != 0) {
                            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
                        }
                        try {
                            ListenableFuture<ResponseProto.ReadDataRangeResponse> readDataRange = this.delegate.readDataRange(ReadDataRangeRequestToProtoKt.toReadDataRangeRequestProto(readRecordsRequest));
                            healthConnectClientImpl$readRecords$1.label = 1;
                            await = ListenableFutureKt.await(readDataRange, healthConnectClientImpl$readRecords$1);
                            if (await == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ResponseProto.ReadDataRangeResponse proto = (ResponseProto.ReadDataRangeResponse) await;
                            ReadRecordsResponse response = ProtoToReadRecordsResponseKt.toReadRecordsResponse(proto);
                            Logger.debug("HealthConnectClient", "Retrieve records successful.");
                            return response;
                        } catch (RemoteException e) {
                            e$iv = e;
                            if (!(e$iv instanceof DeadObjectException)) {
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    case 1:
                        try {
                            ResultKt.throwOnFailure($result);
                            await = $result;
                            ResponseProto.ReadDataRangeResponse proto2 = (ResponseProto.ReadDataRangeResponse) await;
                            ReadRecordsResponse response2 = ProtoToReadRecordsResponseKt.toReadRecordsResponse(proto2);
                            Logger.debug("HealthConnectClient", "Retrieve records successful.");
                            return response2;
                        } catch (RemoteException e2) {
                            e$iv = e2;
                            if (!(e$iv instanceof DeadObjectException)) {
                                wrapper$iv = new DeadObjectException(e$iv.getMessage());
                            } else {
                                wrapper$iv = e$iv instanceof TransactionTooLargeException ? new TransactionTooLargeException(e$iv.getMessage()) : new RemoteException(e$iv.getMessage());
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        healthConnectClientImpl$readRecords$1 = new HealthConnectClientImpl$readRecords$1(this, continuation);
        Object $result2 = healthConnectClientImpl$readRecords$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientImpl$readRecords$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object aggregate(AggregateRequest request, Continuation<? super AggregationResult> continuation) {
        HealthConnectClientImpl$aggregate$1 healthConnectClientImpl$aggregate$1;
        Object await;
        if (continuation instanceof HealthConnectClientImpl$aggregate$1) {
            healthConnectClientImpl$aggregate$1 = (HealthConnectClientImpl$aggregate$1) continuation;
            if ((healthConnectClientImpl$aggregate$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientImpl$aggregate$1.label -= Integer.MIN_VALUE;
                Object $result = healthConnectClientImpl$aggregate$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientImpl$aggregate$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            ListenableFuture<ResponseProto.AggregateDataResponse> aggregate = this.delegate.aggregate(AggregateRequestToProtoKt.toProto(request));
                            healthConnectClientImpl$aggregate$1.label = 1;
                            await = ListenableFutureKt.await(aggregate, healthConnectClientImpl$aggregate$1);
                            if (await == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ResponseProto.AggregateDataResponse responseProto = (ResponseProto.AggregateDataResponse) await;
                            List<DataProto.AggregateDataRow> rowsList = responseProto.getRowsList();
                            Intrinsics.checkNotNullExpressionValue(rowsList, "responseProto.rowsList");
                            Object first = CollectionsKt.first((List<? extends Object>) rowsList);
                            Intrinsics.checkNotNullExpressionValue(first, "responseProto.rowsList.first()");
                            AggregationResult result = ProtoToAggregateDataRowKt.retrieveAggregateDataRow((DataProto.AggregateDataRow) first);
                            int numberOfMetrics = result.getLongValues().size() + result.getDoubleValues().size();
                            Logger.debug("HealthConnectClient", "Retrieved " + numberOfMetrics + " metrics.");
                            return result;
                        } catch (RemoteException e) {
                            e$iv = e;
                            if (e$iv instanceof DeadObjectException) {
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    case 1:
                        try {
                            ResultKt.throwOnFailure($result);
                            await = $result;
                            ResponseProto.AggregateDataResponse responseProto2 = (ResponseProto.AggregateDataResponse) await;
                            List<DataProto.AggregateDataRow> rowsList2 = responseProto2.getRowsList();
                            Intrinsics.checkNotNullExpressionValue(rowsList2, "responseProto.rowsList");
                            Object first2 = CollectionsKt.first((List<? extends Object>) rowsList2);
                            Intrinsics.checkNotNullExpressionValue(first2, "responseProto.rowsList.first()");
                            AggregationResult result2 = ProtoToAggregateDataRowKt.retrieveAggregateDataRow((DataProto.AggregateDataRow) first2);
                            int numberOfMetrics2 = result2.getLongValues().size() + result2.getDoubleValues().size();
                            Logger.debug("HealthConnectClient", "Retrieved " + numberOfMetrics2 + " metrics.");
                            return result2;
                        } catch (RemoteException e2) {
                            e$iv = e2;
                            DeadObjectException wrapper$iv = e$iv instanceof DeadObjectException ? e$iv instanceof TransactionTooLargeException ? new TransactionTooLargeException(e$iv.getMessage()) : new RemoteException(e$iv.getMessage()) : new DeadObjectException(e$iv.getMessage());
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        healthConnectClientImpl$aggregate$1 = new HealthConnectClientImpl$aggregate$1(this, continuation);
        Object $result2 = healthConnectClientImpl$aggregate$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientImpl$aggregate$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007c A[LOOP:0: B:17:0x0076->B:19:0x007c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object aggregateGroupByDuration(AggregateGroupByDurationRequest request, Continuation<? super List<AggregationResultGroupedByDuration>> continuation) {
        HealthConnectClientImpl$aggregateGroupByDuration$1 healthConnectClientImpl$aggregateGroupByDuration$1;
        Object await;
        if (continuation instanceof HealthConnectClientImpl$aggregateGroupByDuration$1) {
            healthConnectClientImpl$aggregateGroupByDuration$1 = (HealthConnectClientImpl$aggregateGroupByDuration$1) continuation;
            if ((healthConnectClientImpl$aggregateGroupByDuration$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientImpl$aggregateGroupByDuration$1.label -= Integer.MIN_VALUE;
                Object $result = healthConnectClientImpl$aggregateGroupByDuration$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientImpl$aggregateGroupByDuration$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            ListenableFuture<ResponseProto.AggregateDataResponse> aggregate = this.delegate.aggregate(AggregateRequestToProtoKt.toProto(request));
                            healthConnectClientImpl$aggregateGroupByDuration$1.label = 1;
                            await = ListenableFutureKt.await(aggregate, healthConnectClientImpl$aggregateGroupByDuration$1);
                            if (await == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ResponseProto.AggregateDataResponse responseProto = (ResponseProto.AggregateDataResponse) await;
                            Iterable rowsList = responseProto.getRowsList();
                            Intrinsics.checkNotNullExpressionValue(rowsList, "responseProto.rowsList");
                            Iterable $this$map$iv = rowsList;
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                DataProto.AggregateDataRow it = (DataProto.AggregateDataRow) item$iv$iv;
                                Intrinsics.checkNotNullExpressionValue(it, "it");
                                destination$iv$iv.add(ProtoToAggregateDataRowKt.toAggregateDataRowGroupByDuration(it));
                            }
                            List result = CollectionsKt.toList((List) destination$iv$iv);
                            Logger.debug("HealthConnectClient", "Retrieved " + result.size() + " duration aggregation buckets.");
                            return result;
                        } catch (RemoteException e) {
                            e$iv = e;
                            DeadObjectException wrapper$iv = e$iv instanceof DeadObjectException ? e$iv instanceof TransactionTooLargeException ? new TransactionTooLargeException(e$iv.getMessage()) : new RemoteException(e$iv.getMessage()) : new DeadObjectException(e$iv.getMessage());
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    case 1:
                        try {
                            ResultKt.throwOnFailure($result);
                            await = $result;
                            ResponseProto.AggregateDataResponse responseProto2 = (ResponseProto.AggregateDataResponse) await;
                            Iterable rowsList2 = responseProto2.getRowsList();
                            Intrinsics.checkNotNullExpressionValue(rowsList2, "responseProto.rowsList");
                            Iterable $this$map$iv2 = rowsList2;
                            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                            while (r5.hasNext()) {
                            }
                            List result2 = CollectionsKt.toList((List) destination$iv$iv2);
                            Logger.debug("HealthConnectClient", "Retrieved " + result2.size() + " duration aggregation buckets.");
                            return result2;
                        } catch (RemoteException e2) {
                            e$iv = e2;
                            if (e$iv instanceof DeadObjectException) {
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        healthConnectClientImpl$aggregateGroupByDuration$1 = new HealthConnectClientImpl$aggregateGroupByDuration$1(this, continuation);
        Object $result2 = healthConnectClientImpl$aggregateGroupByDuration$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientImpl$aggregateGroupByDuration$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007c A[LOOP:0: B:17:0x0076->B:19:0x007c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object aggregateGroupByPeriod(AggregateGroupByPeriodRequest request, Continuation<? super List<AggregationResultGroupedByPeriod>> continuation) {
        HealthConnectClientImpl$aggregateGroupByPeriod$1 healthConnectClientImpl$aggregateGroupByPeriod$1;
        Object await;
        if (continuation instanceof HealthConnectClientImpl$aggregateGroupByPeriod$1) {
            healthConnectClientImpl$aggregateGroupByPeriod$1 = (HealthConnectClientImpl$aggregateGroupByPeriod$1) continuation;
            if ((healthConnectClientImpl$aggregateGroupByPeriod$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientImpl$aggregateGroupByPeriod$1.label -= Integer.MIN_VALUE;
                Object $result = healthConnectClientImpl$aggregateGroupByPeriod$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientImpl$aggregateGroupByPeriod$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            ListenableFuture<ResponseProto.AggregateDataResponse> aggregate = this.delegate.aggregate(AggregateRequestToProtoKt.toProto(request));
                            healthConnectClientImpl$aggregateGroupByPeriod$1.label = 1;
                            await = ListenableFutureKt.await(aggregate, healthConnectClientImpl$aggregateGroupByPeriod$1);
                            if (await == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ResponseProto.AggregateDataResponse responseProto = (ResponseProto.AggregateDataResponse) await;
                            Iterable rowsList = responseProto.getRowsList();
                            Intrinsics.checkNotNullExpressionValue(rowsList, "responseProto.rowsList");
                            Iterable $this$map$iv = rowsList;
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                DataProto.AggregateDataRow it = (DataProto.AggregateDataRow) item$iv$iv;
                                Intrinsics.checkNotNullExpressionValue(it, "it");
                                destination$iv$iv.add(ProtoToAggregateDataRowKt.toAggregateDataRowGroupByPeriod(it));
                            }
                            List result = CollectionsKt.toList((List) destination$iv$iv);
                            Logger.debug("HealthConnectClient", "Retrieved " + result.size() + " period aggregation buckets.");
                            return result;
                        } catch (RemoteException e) {
                            e$iv = e;
                            DeadObjectException wrapper$iv = e$iv instanceof DeadObjectException ? e$iv instanceof TransactionTooLargeException ? new TransactionTooLargeException(e$iv.getMessage()) : new RemoteException(e$iv.getMessage()) : new DeadObjectException(e$iv.getMessage());
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    case 1:
                        try {
                            ResultKt.throwOnFailure($result);
                            await = $result;
                            ResponseProto.AggregateDataResponse responseProto2 = (ResponseProto.AggregateDataResponse) await;
                            Iterable rowsList2 = responseProto2.getRowsList();
                            Intrinsics.checkNotNullExpressionValue(rowsList2, "responseProto.rowsList");
                            Iterable $this$map$iv2 = rowsList2;
                            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                            while (r5.hasNext()) {
                            }
                            List result2 = CollectionsKt.toList((List) destination$iv$iv2);
                            Logger.debug("HealthConnectClient", "Retrieved " + result2.size() + " period aggregation buckets.");
                            return result2;
                        } catch (RemoteException e2) {
                            e$iv = e2;
                            if (e$iv instanceof DeadObjectException) {
                            }
                            wrapper$iv.initCause(e$iv);
                            throw wrapper$iv;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        healthConnectClientImpl$aggregateGroupByPeriod$1 = new HealthConnectClientImpl$aggregateGroupByPeriod$1(this, continuation);
        Object $result2 = healthConnectClientImpl$aggregateGroupByPeriod$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientImpl$aggregateGroupByPeriod$1.label) {
        }
    }

    private final <T> T wrapRemoteException(Function0<? extends T> function) {
        DeadObjectException wrapper;
        try {
            return function.invoke();
        } catch (RemoteException e) {
            if (e instanceof DeadObjectException) {
                wrapper = new DeadObjectException(e.getMessage());
            } else {
                wrapper = e instanceof TransactionTooLargeException ? new TransactionTooLargeException(e.getMessage()) : new RemoteException(e.getMessage());
            }
            wrapper.initCause(e);
            throw wrapper;
        }
    }
}
