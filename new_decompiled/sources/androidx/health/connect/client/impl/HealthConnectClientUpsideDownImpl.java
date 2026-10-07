package androidx.health.connect.client.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.health.connect.AggregateRecordsGroupedByDurationResponse;
import android.health.connect.AggregateRecordsGroupedByPeriodResponse;
import android.health.connect.AggregateRecordsResponse;
import android.health.connect.HealthConnectException;
import android.health.connect.HealthConnectManager;
import android.health.connect.LocalTimeRangeFilter;
import android.health.connect.ReadRecordsResponse;
import android.health.connect.changelog.ChangeLogTokenResponse;
import android.health.connect.changelog.ChangeLogsRequest;
import android.health.connect.changelog.ChangeLogsResponse;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import androidx.core.os.OutcomeReceiverKt;
import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.HealthConnectFeatures;
import androidx.health.connect.client.PermissionController;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByPeriod;
import androidx.health.connect.client.changes.DeletionChange;
import androidx.health.connect.client.changes.UpsertionChange;
import androidx.health.connect.client.feature.HealthConnectFeaturesPlatformImpl;
import androidx.health.connect.client.impl.platform.ExceptionConverterKt;
import androidx.health.connect.client.impl.platform.aggregate.AggregationExtensionsKt;
import androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt;
import androidx.health.connect.client.impl.platform.records.RecordConvertersKt;
import androidx.health.connect.client.impl.platform.request.RequestConvertersKt;
import androidx.health.connect.client.impl.platform.response.InsertRecordsResponseConverterKt;
import androidx.health.connect.client.impl.platform.response.ResponseConvertersKt;
import androidx.health.connect.client.permission.HealthPermission;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.AggregateGroupByPeriodRequest;
import androidx.health.connect.client.request.AggregateRequest;
import androidx.health.connect.client.request.ChangesTokenRequest;
import androidx.health.connect.client.request.ReadRecordsRequest;
import androidx.health.connect.client.response.ChangesResponse;
import androidx.health.connect.client.response.InsertRecordsResponse;
import androidx.health.connect.client.response.ReadRecordResponse;
import androidx.health.connect.client.time.TimeRangeFilter;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;

/* compiled from: HealthConnectClientUpsideDownImpl.kt */
@Metadata(m286d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B)\b\u0011\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u0019\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001d2\u0006\u0010\u0019\u001a\u00020#H\u0096@¢\u0006\u0002\u0010$J&\u0010%\u001a\u00020\n2\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020(0'2\u0006\u0010)\u001a\u00020*H\u0096@¢\u0006\u0002\u0010+J:\u0010%\u001a\u00020\n2\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020(0'2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0\u001dH\u0096@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\tH\u0096@¢\u0006\u0002\u00102J\u0016\u00103\u001a\u00020\t2\u0006\u0010\u0019\u001a\u000204H\u0096@¢\u0006\u0002\u00105J\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020\t07H\u0096@¢\u0006\u0002\u00108J\u001c\u00109\u001a\u00020:2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020(0\u001dH\u0096@¢\u0006\u0002\u0010<J4\u0010=\u001a\b\u0012\u0004\u0012\u0002H?0>\"\b\b\u0000\u0010?*\u00020(2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H?0'2\u0006\u0010@\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010AJ,\u0010B\u001a\b\u0012\u0004\u0012\u0002H?0C\"\b\b\u0000\u0010?*\u00020(2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H?0DH\u0096@¢\u0006\u0002\u0010EJ\u000e\u0010F\u001a\u00020\nH\u0096@¢\u0006\u0002\u00108J\u001c\u0010G\u001a\u00020\n2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020(0\u001dH\u0096@¢\u0006\u0002\u0010<J\u001a\u0010H\u001a\u00020\n2\u0010\u0010I\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030J07H\u0002J2\u0010K\u001a\u0002H?\"\u0004\b\u0000\u0010?2\u001c\u0010L\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H?0M\u0012\u0006\u0012\u0004\u0018\u00010N0\u0007H\u0082@¢\u0006\u0002\u0010OR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, m287d2 = {"Landroidx/health/connect/client/impl/HealthConnectClientUpsideDownImpl;", "Landroidx/health/connect/client/HealthConnectClient;", "Landroidx/health/connect/client/PermissionController;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "revokePermissionsFunction", "Lkotlin/Function1;", "", "", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "executor", "Ljava/util/concurrent/Executor;", "features", "Landroidx/health/connect/client/HealthConnectFeatures;", "getFeatures", "()Landroidx/health/connect/client/HealthConnectFeatures;", "healthConnectManager", "Landroid/health/connect/HealthConnectManager;", "permissionController", "getPermissionController", "()Landroidx/health/connect/client/PermissionController;", "aggregate", "Landroidx/health/connect/client/aggregate/AggregationResult;", "request", "Landroidx/health/connect/client/request/AggregateRequest;", "(Landroidx/health/connect/client/request/AggregateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aggregateGroupByDuration", "", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "(Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aggregateGroupByPeriod", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByPeriod;", "Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;", "(Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecords", "recordType", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/Record;", "timeRangeFilter", "Landroidx/health/connect/client/time/TimeRangeFilter;", "(Lkotlin/reflect/KClass;Landroidx/health/connect/client/time/TimeRangeFilter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordIdsList", "clientRecordIdsList", "(Lkotlin/reflect/KClass;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChanges", "Landroidx/health/connect/client/response/ChangesResponse;", "changesToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChangesToken", "Landroidx/health/connect/client/request/ChangesTokenRequest;", "(Landroidx/health/connect/client/request/ChangesTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGrantedPermissions", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertRecords", "Landroidx/health/connect/client/response/InsertRecordsResponse;", "records", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRecord", "Landroidx/health/connect/client/response/ReadRecordResponse;", "T", "recordId", "(Lkotlin/reflect/KClass;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRecords", "Landroidx/health/connect/client/response/ReadRecordsResponse;", "Landroidx/health/connect/client/request/ReadRecordsRequest;", "(Landroidx/health/connect/client/request/ReadRecordsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revokeAllPermissions", "updateRecords", "verifyAggregationMetrics", "metrics", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "wrapPlatformException", "function", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class HealthConnectClientUpsideDownImpl implements HealthConnectClient, PermissionController {
    private final Context context;
    private final Executor executor;
    private final HealthConnectFeatures features;
    private final HealthConnectManager healthConnectManager;
    private final Function1<Collection<String>, Unit> revokePermissionsFunction;

    /* compiled from: HealthConnectClientUpsideDownImpl.kt */
    @Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
    /* renamed from: androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$1 */
    /* synthetic */ class C06291 extends FunctionReferenceImpl implements Function1<Collection<String>, Unit> {
        C06291(Object obj) {
            super(1, obj, Context.class, "revokeSelfPermissionsOnKill", "revokeSelfPermissionsOnKill(Ljava/util/Collection;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Collection<String> collection) {
            invoke2(collection);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Collection<String> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((Context) this.receiver).revokeSelfPermissionsOnKill(p0);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HealthConnectClientUpsideDownImpl(Context context) {
        this(context, new C06291(context));
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HealthConnectClientUpsideDownImpl(Context context, Function1<? super Collection<String>, Unit> revokePermissionsFunction) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(revokePermissionsFunction, "revokePermissionsFunction");
        this.executor = ExecutorsKt.asExecutor(Dispatchers.getDefault());
        this.features = new HealthConnectFeaturesPlatformImpl();
        this.context = context;
        Object systemService = context.getSystemService("healthconnect");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.health.connect.HealthConnectManager");
        this.healthConnectManager = (HealthConnectManager) systemService;
        this.revokePermissionsFunction = revokePermissionsFunction;
    }

    @Override // androidx.health.connect.client.HealthConnectClient
    public PermissionController getPermissionController() {
        return this;
    }

    @Override // androidx.health.connect.client.HealthConnectClient
    public HealthConnectFeatures getFeatures() {
        return this.features;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object insertRecords(List<? extends Record> list, Continuation<? super InsertRecordsResponse> continuation) {
        HealthConnectClientUpsideDownImpl$insertRecords$1 healthConnectClientUpsideDownImpl$insertRecords$1;
        Object wrapPlatformException;
        if (continuation instanceof HealthConnectClientUpsideDownImpl$insertRecords$1) {
            healthConnectClientUpsideDownImpl$insertRecords$1 = (HealthConnectClientUpsideDownImpl$insertRecords$1) continuation;
            if ((healthConnectClientUpsideDownImpl$insertRecords$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientUpsideDownImpl$insertRecords$1.label -= Integer.MIN_VALUE;
                Object $result = healthConnectClientUpsideDownImpl$insertRecords$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientUpsideDownImpl$insertRecords$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        HealthConnectClientUpsideDownImpl$insertRecords$response$1 healthConnectClientUpsideDownImpl$insertRecords$response$1 = new HealthConnectClientUpsideDownImpl$insertRecords$response$1(this, list, null);
                        healthConnectClientUpsideDownImpl$insertRecords$1.label = 1;
                        wrapPlatformException = wrapPlatformException(healthConnectClientUpsideDownImpl$insertRecords$response$1, healthConnectClientUpsideDownImpl$insertRecords$1);
                        if (wrapPlatformException == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        wrapPlatformException = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                android.health.connect.InsertRecordsResponse response = (android.health.connect.InsertRecordsResponse) wrapPlatformException;
                Intrinsics.checkNotNullExpressionValue(response, "response");
                return InsertRecordsResponseConverterKt.toKtResponse(response);
            }
        }
        healthConnectClientUpsideDownImpl$insertRecords$1 = new HealthConnectClientUpsideDownImpl$insertRecords$1(this, continuation);
        Object $result2 = healthConnectClientUpsideDownImpl$insertRecords$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientUpsideDownImpl$insertRecords$1.label) {
        }
        android.health.connect.InsertRecordsResponse response2 = (android.health.connect.InsertRecordsResponse) wrapPlatformException;
        Intrinsics.checkNotNullExpressionValue(response2, "response");
        return InsertRecordsResponseConverterKt.toKtResponse(response2);
    }

    @Override // androidx.health.connect.client.HealthConnectClient
    public Object updateRecords(List<? extends Record> list, Continuation<? super Unit> continuation) {
        Object wrapPlatformException = wrapPlatformException(new HealthConnectClientUpsideDownImpl$updateRecords$2(this, list, null), continuation);
        return wrapPlatformException == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? wrapPlatformException : Unit.INSTANCE;
    }

    @Override // androidx.health.connect.client.HealthConnectClient
    public Object deleteRecords(KClass<? extends Record> kClass, List<String> list, List<String> list2, Continuation<? super Unit> continuation) {
        Object wrapPlatformException = wrapPlatformException(new HealthConnectClientUpsideDownImpl$deleteRecords$2(this, list, list2, kClass, null), continuation);
        return wrapPlatformException == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? wrapPlatformException : Unit.INSTANCE;
    }

    @Override // androidx.health.connect.client.HealthConnectClient
    public Object deleteRecords(KClass<? extends Record> kClass, TimeRangeFilter timeRangeFilter, Continuation<? super Unit> continuation) {
        Object wrapPlatformException = wrapPlatformException(new HealthConnectClientUpsideDownImpl$deleteRecords$4(this, kClass, timeRangeFilter, null), continuation);
        return wrapPlatformException == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? wrapPlatformException : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T extends Record> Object readRecord(KClass<T> kClass, String recordId, Continuation<? super ReadRecordResponse<T>> continuation) {
        HealthConnectClientUpsideDownImpl$readRecord$1 healthConnectClientUpsideDownImpl$readRecord$1;
        Object wrapPlatformException;
        ReadRecordsResponse response;
        if (continuation instanceof HealthConnectClientUpsideDownImpl$readRecord$1) {
            healthConnectClientUpsideDownImpl$readRecord$1 = (HealthConnectClientUpsideDownImpl$readRecord$1) continuation;
            if ((healthConnectClientUpsideDownImpl$readRecord$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientUpsideDownImpl$readRecord$1.label -= Integer.MIN_VALUE;
                Object $result = healthConnectClientUpsideDownImpl$readRecord$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientUpsideDownImpl$readRecord$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        HealthConnectClientUpsideDownImpl$readRecord$response$1 healthConnectClientUpsideDownImpl$readRecord$response$1 = new HealthConnectClientUpsideDownImpl$readRecord$response$1(this, kClass, recordId, null);
                        healthConnectClientUpsideDownImpl$readRecord$1.label = 1;
                        wrapPlatformException = wrapPlatformException(healthConnectClientUpsideDownImpl$readRecord$response$1, healthConnectClientUpsideDownImpl$readRecord$1);
                        if (wrapPlatformException == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        wrapPlatformException = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                response = (ReadRecordsResponse) wrapPlatformException;
                if (!response.getRecords().isEmpty()) {
                    throw new RemoteException("No records");
                }
                Object obj = response.getRecords().get(0);
                Intrinsics.checkNotNullExpressionValue(obj, "response.records[0]");
                Record sdkRecord = RecordConvertersKt.toSdkRecord((android.health.connect.datatypes.Record) obj);
                Intrinsics.checkNotNull(sdkRecord, "null cannot be cast to non-null type T of androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.readRecord");
                return new ReadRecordResponse(sdkRecord);
            }
        }
        healthConnectClientUpsideDownImpl$readRecord$1 = new HealthConnectClientUpsideDownImpl$readRecord$1(this, continuation);
        Object $result2 = healthConnectClientUpsideDownImpl$readRecord$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientUpsideDownImpl$readRecord$1.label) {
        }
        response = (ReadRecordsResponse) wrapPlatformException;
        if (!response.getRecords().isEmpty()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0074 A[LOOP:0: B:13:0x006e->B:15:0x0074, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T extends Record> Object readRecords(ReadRecordsRequest<T> readRecordsRequest, Continuation<? super androidx.health.connect.client.response.ReadRecordsResponse<T>> continuation) {
        HealthConnectClientUpsideDownImpl$readRecords$1 healthConnectClientUpsideDownImpl$readRecords$1;
        Object wrapPlatformException;
        Long boxLong;
        if (continuation instanceof HealthConnectClientUpsideDownImpl$readRecords$1) {
            healthConnectClientUpsideDownImpl$readRecords$1 = (HealthConnectClientUpsideDownImpl$readRecords$1) continuation;
            if ((healthConnectClientUpsideDownImpl$readRecords$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientUpsideDownImpl$readRecords$1.label -= Integer.MIN_VALUE;
                Object $result = healthConnectClientUpsideDownImpl$readRecords$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientUpsideDownImpl$readRecords$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (readRecordsRequest.getDeduplicateStrategy() != 0) {
                            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
                        }
                        HealthConnectClientUpsideDownImpl$readRecords$response$1 healthConnectClientUpsideDownImpl$readRecords$response$1 = new HealthConnectClientUpsideDownImpl$readRecords$response$1(this, readRecordsRequest, null);
                        healthConnectClientUpsideDownImpl$readRecords$1.label = 1;
                        wrapPlatformException = wrapPlatformException(healthConnectClientUpsideDownImpl$readRecords$response$1, healthConnectClientUpsideDownImpl$readRecords$1);
                        if (wrapPlatformException == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        wrapPlatformException = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ReadRecordsResponse response = (ReadRecordsResponse) wrapPlatformException;
                Iterable records = response.getRecords();
                Intrinsics.checkNotNullExpressionValue(records, "response.records");
                Iterable $this$map$iv = records;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    android.health.connect.datatypes.Record it = (android.health.connect.datatypes.Record) item$iv$iv;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Record sdkRecord = RecordConvertersKt.toSdkRecord(it);
                    Intrinsics.checkNotNull(sdkRecord, "null cannot be cast to non-null type T of androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl.readRecords");
                    destination$iv$iv.add(sdkRecord);
                }
                ArrayList arrayList = (List) destination$iv$iv;
                boxLong = Boxing.boxLong(response.getNextPageToken());
                if (boxLong.longValue() == -1) {
                    boxLong = null;
                }
                return new androidx.health.connect.client.response.ReadRecordsResponse(arrayList, boxLong != null ? boxLong.toString() : null);
            }
        }
        healthConnectClientUpsideDownImpl$readRecords$1 = new HealthConnectClientUpsideDownImpl$readRecords$1(this, continuation);
        Object $result2 = healthConnectClientUpsideDownImpl$readRecords$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientUpsideDownImpl$readRecords$1.label) {
        }
        ReadRecordsResponse response2 = (ReadRecordsResponse) wrapPlatformException;
        Iterable records2 = response2.getRecords();
        Intrinsics.checkNotNullExpressionValue(records2, "response.records");
        Iterable $this$map$iv2 = records2;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        while (r8.hasNext()) {
        }
        ArrayList arrayList2 = (List) destination$iv$iv2;
        boxLong = Boxing.boxLong(response2.getNextPageToken());
        if (boxLong.longValue() == -1) {
        }
        return new androidx.health.connect.client.response.ReadRecordsResponse(arrayList2, boxLong != null ? boxLong.toString() : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object aggregate(AggregateRequest request, Continuation<? super AggregationResult> continuation) {
        HealthConnectClientUpsideDownImpl$aggregate$1 healthConnectClientUpsideDownImpl$aggregate$1;
        HealthConnectClientUpsideDownImpl healthConnectClientUpsideDownImpl;
        Object aggregateFallback;
        Iterable $this$none$iv;
        Iterator it;
        Object wrapPlatformException;
        AggregateRequest request2;
        AggregationResult fallbackResponse;
        if (continuation instanceof HealthConnectClientUpsideDownImpl$aggregate$1) {
            healthConnectClientUpsideDownImpl$aggregate$1 = (HealthConnectClientUpsideDownImpl$aggregate$1) continuation;
            if ((healthConnectClientUpsideDownImpl$aggregate$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientUpsideDownImpl$aggregate$1.label -= Integer.MIN_VALUE;
                Object $result = healthConnectClientUpsideDownImpl$aggregate$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z = true;
                switch (healthConnectClientUpsideDownImpl$aggregate$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        healthConnectClientUpsideDownImpl = this;
                        healthConnectClientUpsideDownImpl.verifyAggregationMetrics(request.getMetrics$connect_client_release());
                        healthConnectClientUpsideDownImpl$aggregate$1.L$0 = healthConnectClientUpsideDownImpl;
                        healthConnectClientUpsideDownImpl$aggregate$1.L$1 = request;
                        healthConnectClientUpsideDownImpl$aggregate$1.label = 1;
                        aggregateFallback = HealthConnectClientAggregationExtensionsKt.aggregateFallback(healthConnectClientUpsideDownImpl, request, healthConnectClientUpsideDownImpl$aggregate$1);
                        if (aggregateFallback == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        AggregationResult fallbackResponse2 = (AggregationResult) aggregateFallback;
                        $this$none$iv = request.getMetrics$connect_client_release();
                        if (($this$none$iv instanceof Collection) || !((Collection) $this$none$iv).isEmpty()) {
                            it = $this$none$iv.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    Object element$iv = it.next();
                                    AggregateMetric it2 = (AggregateMetric) element$iv;
                                    if (AggregationExtensionsKt.isPlatformSupportedMetric(it2)) {
                                        z = false;
                                    }
                                }
                            }
                        }
                        if (!z) {
                            return fallbackResponse2;
                        }
                        HealthConnectClientUpsideDownImpl$aggregate$platformResponse$1 healthConnectClientUpsideDownImpl$aggregate$platformResponse$1 = new HealthConnectClientUpsideDownImpl$aggregate$platformResponse$1(healthConnectClientUpsideDownImpl, request, null);
                        healthConnectClientUpsideDownImpl$aggregate$1.L$0 = request;
                        healthConnectClientUpsideDownImpl$aggregate$1.L$1 = fallbackResponse2;
                        healthConnectClientUpsideDownImpl$aggregate$1.label = 2;
                        wrapPlatformException = healthConnectClientUpsideDownImpl.wrapPlatformException(healthConnectClientUpsideDownImpl$aggregate$platformResponse$1, healthConnectClientUpsideDownImpl$aggregate$1);
                        if (wrapPlatformException == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        request2 = request;
                        fallbackResponse = fallbackResponse2;
                        Intrinsics.checkNotNullExpressionValue(wrapPlatformException, "override suspend fun agg… + fallbackResponse\n    }");
                        AggregateRecordsResponse aggregateRecordsResponse = (AggregateRecordsResponse) wrapPlatformException;
                        Iterable $this$filterTo$iv$iv = request2.getMetrics$connect_client_release();
                        Collection destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv : $this$filterTo$iv$iv) {
                            AggregateMetric it3 = (AggregateMetric) element$iv$iv;
                            if (AggregationExtensionsKt.isPlatformSupportedMetric(it3)) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                        }
                        AggregationResult platformResponse = ResponseConvertersKt.toSdkResponse((AggregateRecordsResponse<Object>) aggregateRecordsResponse, (Set<? extends AggregateMetric<? extends Object>>) CollectionsKt.toSet((List) destination$iv$iv));
                        return platformResponse.plus$connect_client_release(fallbackResponse);
                    case 1:
                        request = (AggregateRequest) healthConnectClientUpsideDownImpl$aggregate$1.L$1;
                        healthConnectClientUpsideDownImpl = (HealthConnectClientUpsideDownImpl) healthConnectClientUpsideDownImpl$aggregate$1.L$0;
                        ResultKt.throwOnFailure($result);
                        aggregateFallback = $result;
                        AggregationResult fallbackResponse22 = (AggregationResult) aggregateFallback;
                        $this$none$iv = request.getMetrics$connect_client_release();
                        if ($this$none$iv instanceof Collection) {
                            break;
                        }
                        it = $this$none$iv.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                            }
                        }
                        if (!z) {
                        }
                        break;
                    case 2:
                        fallbackResponse = (AggregationResult) healthConnectClientUpsideDownImpl$aggregate$1.L$1;
                        request2 = (AggregateRequest) healthConnectClientUpsideDownImpl$aggregate$1.L$0;
                        ResultKt.throwOnFailure($result);
                        wrapPlatformException = $result;
                        Intrinsics.checkNotNullExpressionValue(wrapPlatformException, "override suspend fun agg… + fallbackResponse\n    }");
                        AggregateRecordsResponse aggregateRecordsResponse2 = (AggregateRecordsResponse) wrapPlatformException;
                        Iterable $this$filterTo$iv$iv2 = request2.getMetrics$connect_client_release();
                        Collection destination$iv$iv2 = new ArrayList();
                        while (r7.hasNext()) {
                        }
                        AggregationResult platformResponse2 = ResponseConvertersKt.toSdkResponse((AggregateRecordsResponse<Object>) aggregateRecordsResponse2, (Set<? extends AggregateMetric<? extends Object>>) CollectionsKt.toSet((List) destination$iv$iv2));
                        return platformResponse2.plus$connect_client_release(fallbackResponse);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        healthConnectClientUpsideDownImpl$aggregate$1 = new HealthConnectClientUpsideDownImpl$aggregate$1(this, continuation);
        Object $result2 = healthConnectClientUpsideDownImpl$aggregate$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = true;
        switch (healthConnectClientUpsideDownImpl$aggregate$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0075 A[LOOP:0: B:13:0x006f->B:15:0x0075, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object aggregateGroupByDuration(AggregateGroupByDurationRequest request, Continuation<? super List<AggregationResultGroupedByDuration>> continuation) {
        HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$1 healthConnectClientUpsideDownImpl$aggregateGroupByDuration$1;
        Object wrapPlatformException;
        if (continuation instanceof HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$1) {
            healthConnectClientUpsideDownImpl$aggregateGroupByDuration$1 = (HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$1) continuation;
            if ((healthConnectClientUpsideDownImpl$aggregateGroupByDuration$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientUpsideDownImpl$aggregateGroupByDuration$1.label -= Integer.MIN_VALUE;
                Object $result = healthConnectClientUpsideDownImpl$aggregateGroupByDuration$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientUpsideDownImpl$aggregateGroupByDuration$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        verifyAggregationMetrics(request.getMetrics$connect_client_release());
                        HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$2 healthConnectClientUpsideDownImpl$aggregateGroupByDuration$2 = new HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$2(this, request, null);
                        healthConnectClientUpsideDownImpl$aggregateGroupByDuration$1.L$0 = request;
                        healthConnectClientUpsideDownImpl$aggregateGroupByDuration$1.label = 1;
                        wrapPlatformException = wrapPlatformException(healthConnectClientUpsideDownImpl$aggregateGroupByDuration$2, healthConnectClientUpsideDownImpl$aggregateGroupByDuration$1);
                        if (wrapPlatformException == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        request = (AggregateGroupByDurationRequest) healthConnectClientUpsideDownImpl$aggregateGroupByDuration$1.L$0;
                        ResultKt.throwOnFailure($result);
                        wrapPlatformException = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Intrinsics.checkNotNullExpressionValue(wrapPlatformException, "override suspend fun agg…(request.metrics) }\n    }");
                Iterable $this$map$iv = (Iterable) wrapPlatformException;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    AggregateRecordsGroupedByDurationResponse it = (AggregateRecordsGroupedByDurationResponse) item$iv$iv;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    destination$iv$iv.add(ResponseConvertersKt.toSdkResponse((AggregateRecordsGroupedByDurationResponse<Object>) it, request.getMetrics$connect_client_release()));
                }
                return (List) destination$iv$iv;
            }
        }
        healthConnectClientUpsideDownImpl$aggregateGroupByDuration$1 = new HealthConnectClientUpsideDownImpl$aggregateGroupByDuration$1(this, continuation);
        Object $result2 = healthConnectClientUpsideDownImpl$aggregateGroupByDuration$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientUpsideDownImpl$aggregateGroupByDuration$1.label) {
        }
        Intrinsics.checkNotNullExpressionValue(wrapPlatformException, "override suspend fun agg…(request.metrics) }\n    }");
        Iterable $this$map$iv2 = (Iterable) wrapPlatformException;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        while (r6.hasNext()) {
        }
        return (List) destination$iv$iv2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object aggregateGroupByPeriod(AggregateGroupByPeriodRequest request, Continuation<? super List<AggregationResultGroupedByPeriod>> continuation) {
        HealthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1 healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1;
        Object wrapPlatformException;
        AggregateGroupByPeriodRequest request2;
        HealthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1 healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$12;
        AggregationResultGroupedByPeriod aggregationResultGroupedByPeriod;
        if (continuation instanceof HealthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1) {
            healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1 = (HealthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1) continuation;
            if ((healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1.label -= Integer.MIN_VALUE;
                Object $result = healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        verifyAggregationMetrics(request.getMetrics$connect_client_release());
                        HealthConnectClientUpsideDownImpl$aggregateGroupByPeriod$2 healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$2 = new HealthConnectClientUpsideDownImpl$aggregateGroupByPeriod$2(this, request, null);
                        healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1.L$0 = request;
                        healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1.label = 1;
                        wrapPlatformException = wrapPlatformException(healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$2, healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1);
                        if (wrapPlatformException == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        request2 = request;
                        break;
                    case 1:
                        request2 = (AggregateGroupByPeriodRequest) healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1.L$0;
                        ResultKt.throwOnFailure($result);
                        wrapPlatformException = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Intrinsics.checkNotNullExpressionValue(wrapPlatformException, "override suspend fun agg…    }\n            }\n    }");
                Iterable $this$mapIndexed$iv = (Iterable) wrapPlatformException;
                int i = 10;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                int index$iv$iv = 0;
                for (Object item$iv$iv : $this$mapIndexed$iv) {
                    int index$iv$iv2 = index$iv$iv + 1;
                    if (index$iv$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    AggregateRecordsGroupedByPeriodResponse platformResponse = (AggregateRecordsGroupedByPeriodResponse) item$iv$iv;
                    int index = index$iv$iv;
                    if (SdkExtensions.getExtensionVersion(34) >= i) {
                        healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$12 = healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1;
                    } else if (request2.getTimeRangeSlicer().getMonths() == 0 && request2.getTimeRangeSlicer().getYears() == 0) {
                        healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$12 = healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1;
                    } else {
                        LocalTimeRangeFilter requestTimeRangeFilter = RequestConvertersKt.toPlatformLocalTimeRangeFilter(request2.getTimeRangeFilter());
                        LocalDateTime startTime = requestTimeRangeFilter.getStartTime();
                        Intrinsics.checkNotNull(startTime);
                        LocalDateTime bucketStartTime = startTime.plus((TemporalAmount) request2.getTimeRangeSlicer().multipliedBy(index));
                        LocalDateTime bucketEndTime = bucketStartTime.plus((TemporalAmount) request2.getTimeRangeSlicer());
                        Intrinsics.checkNotNullExpressionValue(platformResponse, "platformResponse");
                        Set<AggregateMetric<?>> metrics$connect_client_release = request2.getMetrics$connect_client_release();
                        Intrinsics.checkNotNullExpressionValue(bucketStartTime, "bucketStartTime");
                        LocalDateTime endTime = requestTimeRangeFilter.getEndTime();
                        Intrinsics.checkNotNull(endTime);
                        healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$12 = healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1;
                        if (endTime.isBefore(bucketEndTime)) {
                            bucketEndTime = requestTimeRangeFilter.getEndTime();
                            Intrinsics.checkNotNull(bucketEndTime);
                        }
                        Intrinsics.checkNotNullExpressionValue(bucketEndTime, "if (requestTimeRangeFilt…                        }");
                        aggregationResultGroupedByPeriod = ResponseConvertersKt.toSdkResponse(platformResponse, metrics$connect_client_release, bucketStartTime, bucketEndTime);
                        destination$iv$iv.add(aggregationResultGroupedByPeriod);
                        index$iv$iv = index$iv$iv2;
                        healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1 = healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$12;
                        i = 10;
                    }
                    Intrinsics.checkNotNullExpressionValue(platformResponse, "platformResponse");
                    aggregationResultGroupedByPeriod = ResponseConvertersKt.toSdkResponse((AggregateRecordsGroupedByPeriodResponse<Object>) platformResponse, request2.getMetrics$connect_client_release());
                    destination$iv$iv.add(aggregationResultGroupedByPeriod);
                    index$iv$iv = index$iv$iv2;
                    healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1 = healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$12;
                    i = 10;
                }
                return (List) destination$iv$iv;
            }
        }
        healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1 = new HealthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1(this, continuation);
        Object $result2 = healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientUpsideDownImpl$aggregateGroupByPeriod$1.label) {
        }
        Intrinsics.checkNotNullExpressionValue(wrapPlatformException, "override suspend fun agg…    }\n            }\n    }");
        Iterable $this$mapIndexed$iv2 = (Iterable) wrapPlatformException;
        int i2 = 10;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
        int index$iv$iv3 = 0;
        while (r11.hasNext()) {
        }
        return (List) destination$iv$iv2;
    }

    private final void verifyAggregationMetrics(Set<? extends AggregateMetric<?>> metrics) {
        AggregateMetric it = (AggregateMetric) CollectionsKt.firstOrNull(CollectionsKt.intersect(AggregationExtensionsKt.getAGGREGATE_METRICS_ADDED_IN_SDK_EXT_10(), metrics));
        if (it != null) {
            throw new UnsupportedOperationException("Unsupported metric type " + it.getMetricKey());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getChangesToken(ChangesTokenRequest request, Continuation<? super String> continuation) {
        HealthConnectClientUpsideDownImpl$getChangesToken$1 healthConnectClientUpsideDownImpl$getChangesToken$1;
        Object wrapPlatformException;
        if (continuation instanceof HealthConnectClientUpsideDownImpl$getChangesToken$1) {
            healthConnectClientUpsideDownImpl$getChangesToken$1 = (HealthConnectClientUpsideDownImpl$getChangesToken$1) continuation;
            if ((healthConnectClientUpsideDownImpl$getChangesToken$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectClientUpsideDownImpl$getChangesToken$1.label -= Integer.MIN_VALUE;
                Object $result = healthConnectClientUpsideDownImpl$getChangesToken$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectClientUpsideDownImpl$getChangesToken$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        HealthConnectClientUpsideDownImpl$getChangesToken$2 healthConnectClientUpsideDownImpl$getChangesToken$2 = new HealthConnectClientUpsideDownImpl$getChangesToken$2(this, request, null);
                        healthConnectClientUpsideDownImpl$getChangesToken$1.label = 1;
                        wrapPlatformException = wrapPlatformException(healthConnectClientUpsideDownImpl$getChangesToken$2, healthConnectClientUpsideDownImpl$getChangesToken$1);
                        if (wrapPlatformException == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        wrapPlatformException = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String token = ((ChangeLogTokenResponse) wrapPlatformException).getToken();
                Intrinsics.checkNotNullExpressionValue(token, "override suspend fun get…\n            .token\n    }");
                return token;
            }
        }
        healthConnectClientUpsideDownImpl$getChangesToken$1 = new HealthConnectClientUpsideDownImpl$getChangesToken$1(this, continuation);
        Object $result2 = healthConnectClientUpsideDownImpl$getChangesToken$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectClientUpsideDownImpl$getChangesToken$1.label) {
        }
        String token2 = ((ChangeLogTokenResponse) wrapPlatformException).getToken();
        Intrinsics.checkNotNullExpressionValue(token2, "override suspend fun get…\n            .token\n    }");
        return token2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b7 A[Catch: HealthConnectException -> 0x0124, LOOP:0: B:16:0x00b1->B:18:0x00b7, LOOP_END, TryCatch #0 {HealthConnectException -> 0x0124, blocks: (B:13:0x003d, B:15:0x0096, B:16:0x00b1, B:18:0x00b7, B:20:0x00d2, B:21:0x00e3, B:23:0x00e9, B:25:0x0104, B:28:0x011f, B:33:0x004b, B:35:0x008c), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e9 A[Catch: HealthConnectException -> 0x0124, LOOP:1: B:21:0x00e3->B:23:0x00e9, LOOP_END, TryCatch #0 {HealthConnectException -> 0x0124, blocks: (B:13:0x003d, B:15:0x0096, B:16:0x00b1, B:18:0x00b7, B:20:0x00d2, B:21:0x00e3, B:23:0x00e9, B:25:0x0104, B:28:0x011f, B:33:0x004b, B:35:0x008c), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    @Override // androidx.health.connect.client.HealthConnectClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getChanges(String changesToken, Continuation<? super ChangesResponse> continuation) {
        HealthConnectClientUpsideDownImpl$getChanges$1 healthConnectClientUpsideDownImpl$getChanges$1;
        HealthConnectClientUpsideDownImpl$getChanges$1 healthConnectClientUpsideDownImpl$getChanges$12;
        Object result;
        try {
            if (continuation instanceof HealthConnectClientUpsideDownImpl$getChanges$1) {
                healthConnectClientUpsideDownImpl$getChanges$1 = (HealthConnectClientUpsideDownImpl$getChanges$1) continuation;
                if ((healthConnectClientUpsideDownImpl$getChanges$1.label & Integer.MIN_VALUE) != 0) {
                    healthConnectClientUpsideDownImpl$getChanges$1.label -= Integer.MIN_VALUE;
                    healthConnectClientUpsideDownImpl$getChanges$12 = healthConnectClientUpsideDownImpl$getChanges$1;
                    Object $result = healthConnectClientUpsideDownImpl$getChanges$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (healthConnectClientUpsideDownImpl$getChanges$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            healthConnectClientUpsideDownImpl$getChanges$12.L$0 = this;
                            healthConnectClientUpsideDownImpl$getChanges$12.L$1 = changesToken;
                            healthConnectClientUpsideDownImpl$getChanges$12.label = 1;
                            HealthConnectClientUpsideDownImpl$getChanges$1 uCont$iv = healthConnectClientUpsideDownImpl$getChanges$12;
                            CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                            cancellable$iv.initCancellability();
                            CancellableContinuationImpl continuation2 = cancellable$iv;
                            this.healthConnectManager.getChangeLogs(new ChangeLogsRequest.Builder(changesToken).build(), this.executor, OutcomeReceiverKt.asOutcomeReceiver(continuation2));
                            result = cancellable$iv.getResult();
                            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                DebugProbesKt.probeCoroutineSuspended(healthConnectClientUpsideDownImpl$getChanges$12);
                            }
                            if (result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            result = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ChangeLogsResponse response = (ChangeLogsResponse) result;
                    List $this$getChanges_u24lambda_u2410 = CollectionsKt.createListBuilder();
                    Iterable upsertedRecords = response.getUpsertedRecords();
                    Intrinsics.checkNotNullExpressionValue(upsertedRecords, "response.upsertedRecords");
                    Iterable $this$forEach$iv = upsertedRecords;
                    for (Object element$iv : $this$forEach$iv) {
                        android.health.connect.datatypes.Record it = (android.health.connect.datatypes.Record) element$iv;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        $this$getChanges_u24lambda_u2410.add(new UpsertionChange(RecordConvertersKt.toSdkRecord(it)));
                    }
                    Iterable deletedLogs = response.getDeletedLogs();
                    Intrinsics.checkNotNullExpressionValue(deletedLogs, "response.deletedLogs");
                    Iterable $this$forEach$iv2 = deletedLogs;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        String deletedRecordId = ((ChangeLogsResponse.DeletedLog) element$iv2).getDeletedRecordId();
                        Intrinsics.checkNotNullExpressionValue(deletedRecordId, "it.deletedRecordId");
                        $this$getChanges_u24lambda_u2410.add(new DeletionChange(deletedRecordId));
                    }
                    List build = CollectionsKt.build($this$getChanges_u24lambda_u2410);
                    String nextChangesToken = response.getNextChangesToken();
                    Intrinsics.checkNotNullExpressionValue(nextChangesToken, "response.nextChangesToken");
                    return new ChangesResponse(build, nextChangesToken, !response.hasMorePages(), false);
                }
            }
            switch (healthConnectClientUpsideDownImpl$getChanges$12.label) {
            }
            ChangeLogsResponse response2 = (ChangeLogsResponse) result;
            List $this$getChanges_u24lambda_u24102 = CollectionsKt.createListBuilder();
            Iterable upsertedRecords2 = response2.getUpsertedRecords();
            Intrinsics.checkNotNullExpressionValue(upsertedRecords2, "response.upsertedRecords");
            Iterable $this$forEach$iv3 = upsertedRecords2;
            while (r11.hasNext()) {
            }
            Iterable deletedLogs2 = response2.getDeletedLogs();
            Intrinsics.checkNotNullExpressionValue(deletedLogs2, "response.deletedLogs");
            Iterable $this$forEach$iv22 = deletedLogs2;
            while (r11.hasNext()) {
            }
            List build2 = CollectionsKt.build($this$getChanges_u24lambda_u24102);
            String nextChangesToken2 = response2.getNextChangesToken();
            Intrinsics.checkNotNullExpressionValue(nextChangesToken2, "response.nextChangesToken");
            return new ChangesResponse(build2, nextChangesToken2, !response2.hasMorePages(), false);
        } catch (HealthConnectException e) {
            if (e.getErrorCode() == 3) {
                return new ChangesResponse(CollectionsKt.emptyList(), "", false, true);
            }
            throw ExceptionConverterKt.toKtException(e);
        }
        healthConnectClientUpsideDownImpl$getChanges$1 = new HealthConnectClientUpsideDownImpl$getChanges$1(this, continuation);
        healthConnectClientUpsideDownImpl$getChanges$12 = healthConnectClientUpsideDownImpl$getChanges$1;
        Object $result2 = healthConnectClientUpsideDownImpl$getChanges$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    @Override // androidx.health.connect.client.PermissionController
    public Object getGrantedPermissions(Continuation<? super Set<String>> continuation) {
        PackageInfo it = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), PackageManager.PackageInfoFlags.of(4096L));
        Set $this$getGrantedPermissions_u24lambda_u2412_u24lambda_u2411 = SetsKt.createSetBuilder();
        String[] requestedPermissions = it.requestedPermissions;
        if (requestedPermissions == null) {
            requestedPermissions = new String[0];
        } else {
            Intrinsics.checkNotNullExpressionValue(requestedPermissions, "it.requestedPermissions ?: emptyArray()");
        }
        int length = requestedPermissions.length;
        for (int i = 0; i < length; i++) {
            String str = requestedPermissions[i];
            Intrinsics.checkNotNullExpressionValue(str, "requestedPermissions[i]");
            if (StringsKt.startsWith$default(str, HealthPermission.PERMISSION_PREFIX, false, 2, (Object) null)) {
                int[] iArr = it.requestedPermissionsFlags;
                Intrinsics.checkNotNull(iArr);
                if ((iArr[i] & 2) > 0) {
                    String str2 = requestedPermissions[i];
                    Intrinsics.checkNotNullExpressionValue(str2, "requestedPermissions[i]");
                    $this$getGrantedPermissions_u24lambda_u2412_u24lambda_u2411.add(str2);
                }
            }
        }
        return SetsKt.build($this$getGrantedPermissions_u24lambda_u2412_u24lambda_u2411);
    }

    @Override // androidx.health.connect.client.PermissionController
    public Object revokeAllPermissions(Continuation<? super Unit> continuation) {
        String[] requestedPermissions = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), PackageManager.PackageInfoFlags.of(4096L)).requestedPermissions;
        if (requestedPermissions == null) {
            requestedPermissions = new String[0];
        }
        Collection destination$iv$iv = new ArrayList();
        for (String it : requestedPermissions) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (StringsKt.startsWith$default(it, HealthPermission.PERMISSION_PREFIX, false, 2, (Object) null)) {
                destination$iv$iv.add(it);
            }
        }
        List allHealthPermissions = (List) destination$iv$iv;
        if (!allHealthPermissions.isEmpty()) {
            this.revokePermissionsFunction.invoke(allHealthPermissions);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c A[Catch: HealthConnectException -> 0x0031, TRY_ENTER, TRY_LEAVE, TryCatch #0 {HealthConnectException -> 0x0031, blocks: (B:12:0x002c, B:18:0x0038), top: B:7:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object wrapPlatformException(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        HealthConnectClientUpsideDownImpl$wrapPlatformException$1 healthConnectClientUpsideDownImpl$wrapPlatformException$1;
        Object invoke;
        try {
            if (continuation instanceof HealthConnectClientUpsideDownImpl$wrapPlatformException$1) {
                healthConnectClientUpsideDownImpl$wrapPlatformException$1 = (HealthConnectClientUpsideDownImpl$wrapPlatformException$1) continuation;
                if ((healthConnectClientUpsideDownImpl$wrapPlatformException$1.label & Integer.MIN_VALUE) != 0) {
                    healthConnectClientUpsideDownImpl$wrapPlatformException$1.label -= Integer.MIN_VALUE;
                    Object $result = healthConnectClientUpsideDownImpl$wrapPlatformException$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (healthConnectClientUpsideDownImpl$wrapPlatformException$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            healthConnectClientUpsideDownImpl$wrapPlatformException$1.label = 1;
                            invoke = function1.invoke(healthConnectClientUpsideDownImpl$wrapPlatformException$1);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            invoke = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return invoke;
                }
            }
            switch (healthConnectClientUpsideDownImpl$wrapPlatformException$1.label) {
            }
            return invoke;
        } catch (HealthConnectException e) {
            throw ExceptionConverterKt.toKtException(e);
        }
        healthConnectClientUpsideDownImpl$wrapPlatformException$1 = new HealthConnectClientUpsideDownImpl$wrapPlatformException$1(this, continuation);
        Object $result2 = healthConnectClientUpsideDownImpl$wrapPlatformException$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
}
