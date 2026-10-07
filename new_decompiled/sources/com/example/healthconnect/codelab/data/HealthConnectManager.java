package com.example.healthconnect.codelab.data;

import android.content.Context;
import android.os.Build;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.PermissionController;
import androidx.health.connect.client.permission.HealthPermission;
import androidx.health.connect.client.records.HeartRateRecord;
import androidx.health.connect.client.records.OxygenSaturationRecord;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.StepsRecord;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.request.ReadRecordsRequest;
import androidx.health.connect.client.response.ReadRecordsResponse;
import androidx.health.connect.client.time.TimeRangeFilter;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: HealthConnectManager.kt */
@Metadata(m286d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0019J'\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010 J\u001f\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020\"H\u0002J;\u0010)\u001a\b\u0012\u0004\u0012\u0002H*0\u001b\"\n\b\u0000\u0010*\u0018\u0001*\u00020+2\u0006\u0010,\u001a\u00020-2\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u0014H\u0082Hø\u0001\u0000¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0004\u0018\u00010\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u00102J\u0013\u00103\u001a\u0004\u0018\u000104H\u0086@ø\u0001\u0000¢\u0006\u0002\u00102J\u0011\u00105\u001a\u000206H\u0086@ø\u0001\u0000¢\u0006\u0002\u00102J\u001e\u00107\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001408R*\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u00069"}, m287d2 = {"Lcom/example/healthconnect/codelab/data/HealthConnectManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "<set-?>", "Landroidx/compose/runtime/MutableState;", "Lcom/example/healthconnect/codelab/data/HealthConnectAvailability;", "availability", "getAvailability", "()Landroidx/compose/runtime/MutableState;", "getContext", "()Landroid/content/Context;", "healthConnectClient", "Landroidx/health/connect/client/HealthConnectClient;", "getHealthConnectClient", "()Landroidx/health/connect/client/HealthConnectClient;", "healthConnectClient$delegate", "Lkotlin/Lazy;", "vitalsPermissions", "", "", "getVitalsPermissions", "()Ljava/util/Set;", "checkAvailability", "", "getHeartRateHistory", "", "Landroidx/health/connect/client/records/HeartRateRecord;", "start", "Ljava/time/Instant;", "end", "(Ljava/time/Instant;Ljava/time/Instant;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasAllPermissions", "", "permissions", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFeatureAvailable", "feature", "", "isSupported", "readData", "T", "Landroidx/health/connect/client/records/Record;", "timeRangeFilter", "Landroidx/health/connect/client/time/TimeRangeFilter;", "dataOriginFilter", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "(Landroidx/health/connect/client/time/TimeRangeFilter;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readLatestHeartRate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readLatestSpO2", "Landroidx/health/connect/client/records/OxygenSaturationRecord;", "readTodaySteps", "", "requestPermissionsActivityContract", "Landroidx/activity/result/contract/ActivityResultContract;", "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes8.dex */
public final class HealthConnectManager {
    public static final int $stable = 8;
    private MutableState<HealthConnectAvailability> availability;
    private final Context context;

    /* renamed from: healthConnectClient$delegate, reason: from kotlin metadata */
    private final Lazy healthConnectClient;
    private final Set<String> vitalsPermissions;

    public HealthConnectManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.healthConnectClient = LazyKt.lazy(new Function0<HealthConnectClient>() { // from class: com.example.healthconnect.codelab.data.HealthConnectManager$healthConnectClient$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final HealthConnectClient invoke() {
                return HealthConnectClient.Companion.getOrCreate$default(HealthConnectClient.INSTANCE, HealthConnectManager.this.getContext(), null, 2, null);
            }
        });
        this.vitalsPermissions = SetsKt.setOf((Object[]) new String[]{HealthPermission.INSTANCE.getReadPermission(Reflection.getOrCreateKotlinClass(HeartRateRecord.class)), HealthPermission.INSTANCE.getReadPermission(Reflection.getOrCreateKotlinClass(OxygenSaturationRecord.class)), HealthPermission.INSTANCE.getReadPermission(Reflection.getOrCreateKotlinClass(StepsRecord.class))});
        this.availability = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(HealthConnectAvailability.NOT_SUPPORTED, null, 2, null);
        checkAvailability();
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HealthConnectClient getHealthConnectClient() {
        return (HealthConnectClient) this.healthConnectClient.getValue();
    }

    public final Set<String> getVitalsPermissions() {
        return this.vitalsPermissions;
    }

    public final MutableState<HealthConnectAvailability> getAvailability() {
        return this.availability;
    }

    public final void checkAvailability() {
        HealthConnectAvailability healthConnectAvailability;
        MutableState<HealthConnectAvailability> mutableState = this.availability;
        if (HealthConnectClient.Companion.getSdkStatus$default(HealthConnectClient.INSTANCE, this.context, null, 2, null) == 3) {
            healthConnectAvailability = HealthConnectAvailability.INSTALLED;
        } else {
            healthConnectAvailability = isSupported() ? HealthConnectAvailability.NOT_INSTALLED : HealthConnectAvailability.NOT_SUPPORTED;
        }
        mutableState.setValue(healthConnectAvailability);
    }

    public final boolean isFeatureAvailable(int feature) {
        return getHealthConnectClient().getFeatures().getFeatureStatus(feature) == 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0098 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readLatestHeartRate(Continuation<? super HeartRateRecord> continuation) {
        HealthConnectManager$readLatestHeartRate$1 healthConnectManager$readLatestHeartRate$1;
        Object readRecords;
        Iterator iterator$iv;
        if (continuation instanceof HealthConnectManager$readLatestHeartRate$1) {
            HealthConnectManager$readLatestHeartRate$1 healthConnectManager$readLatestHeartRate$12 = (HealthConnectManager$readLatestHeartRate$1) continuation;
            if ((healthConnectManager$readLatestHeartRate$12.label & Integer.MIN_VALUE) != 0) {
                healthConnectManager$readLatestHeartRate$12.label -= Integer.MIN_VALUE;
                healthConnectManager$readLatestHeartRate$1 = healthConnectManager$readLatestHeartRate$12;
                Object $result = healthConnectManager$readLatestHeartRate$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectManager$readLatestHeartRate$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Instant now = Instant.now();
                        Instant yesterday = now.minusSeconds(86400L);
                        TimeRangeFilter.Companion companion = TimeRangeFilter.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(yesterday, "yesterday");
                        Intrinsics.checkNotNullExpressionValue(now, "now");
                        ReadRecordsRequest request$iv = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(HeartRateRecord.class), companion.between(yesterday, now), SetsKt.emptySet(), false, 0, null, 56, null);
                        HealthConnectClient healthConnectClient = getHealthConnectClient();
                        healthConnectManager$readLatestHeartRate$1.label = 1;
                        readRecords = healthConnectClient.readRecords(request$iv, healthConnectManager$readLatestHeartRate$1);
                        if (readRecords != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        readRecords = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Iterable $this$maxByOrNull$iv = ((ReadRecordsResponse) readRecords).getRecords();
                iterator$iv = $this$maxByOrNull$iv.iterator();
                if (iterator$iv.hasNext()) {
                    return null;
                }
                Object maxElem$iv = iterator$iv.next();
                if (!iterator$iv.hasNext()) {
                    return maxElem$iv;
                }
                HeartRateRecord it = (HeartRateRecord) maxElem$iv;
                Comparable maxValue$iv = it.getEndTime();
                do {
                    Object e$iv = iterator$iv.next();
                    HeartRateRecord it2 = (HeartRateRecord) e$iv;
                    Instant endTime = it2.getEndTime();
                    if (maxValue$iv.compareTo(endTime) < 0) {
                        maxElem$iv = e$iv;
                        maxValue$iv = endTime;
                    }
                } while (iterator$iv.hasNext());
                return maxElem$iv;
            }
        }
        healthConnectManager$readLatestHeartRate$1 = new HealthConnectManager$readLatestHeartRate$1(this, continuation);
        Object $result2 = healthConnectManager$readLatestHeartRate$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectManager$readLatestHeartRate$1.label) {
        }
        Iterable $this$maxByOrNull$iv2 = ((ReadRecordsResponse) readRecords).getRecords();
        iterator$iv = $this$maxByOrNull$iv2.iterator();
        if (iterator$iv.hasNext()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getHeartRateHistory(Instant start, Instant end, Continuation<? super List<HeartRateRecord>> continuation) {
        HealthConnectManager$getHeartRateHistory$1 healthConnectManager$getHeartRateHistory$1;
        Object readRecords;
        if (continuation instanceof HealthConnectManager$getHeartRateHistory$1) {
            HealthConnectManager$getHeartRateHistory$1 healthConnectManager$getHeartRateHistory$12 = (HealthConnectManager$getHeartRateHistory$1) continuation;
            if ((healthConnectManager$getHeartRateHistory$12.label & Integer.MIN_VALUE) != 0) {
                healthConnectManager$getHeartRateHistory$12.label -= Integer.MIN_VALUE;
                healthConnectManager$getHeartRateHistory$1 = healthConnectManager$getHeartRateHistory$12;
                Object $result = healthConnectManager$getHeartRateHistory$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectManager$getHeartRateHistory$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        ReadRecordsRequest request$iv = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(HeartRateRecord.class), TimeRangeFilter.INSTANCE.between(start, end), SetsKt.emptySet(), false, 0, null, 56, null);
                        HealthConnectClient healthConnectClient = getHealthConnectClient();
                        healthConnectManager$getHeartRateHistory$1.label = 1;
                        readRecords = healthConnectClient.readRecords(request$iv, healthConnectManager$getHeartRateHistory$1);
                        if (readRecords != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        readRecords = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ((ReadRecordsResponse) readRecords).getRecords();
            }
        }
        healthConnectManager$getHeartRateHistory$1 = new HealthConnectManager$getHeartRateHistory$1(this, continuation);
        Object $result2 = healthConnectManager$getHeartRateHistory$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectManager$getHeartRateHistory$1.label) {
        }
        return ((ReadRecordsResponse) readRecords).getRecords();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0098 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readLatestSpO2(Continuation<? super OxygenSaturationRecord> continuation) {
        HealthConnectManager$readLatestSpO2$1 healthConnectManager$readLatestSpO2$1;
        Object readRecords;
        Iterator iterator$iv;
        if (continuation instanceof HealthConnectManager$readLatestSpO2$1) {
            HealthConnectManager$readLatestSpO2$1 healthConnectManager$readLatestSpO2$12 = (HealthConnectManager$readLatestSpO2$1) continuation;
            if ((healthConnectManager$readLatestSpO2$12.label & Integer.MIN_VALUE) != 0) {
                healthConnectManager$readLatestSpO2$12.label -= Integer.MIN_VALUE;
                healthConnectManager$readLatestSpO2$1 = healthConnectManager$readLatestSpO2$12;
                Object $result = healthConnectManager$readLatestSpO2$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectManager$readLatestSpO2$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Instant now = Instant.now();
                        Instant yesterday = now.minusSeconds(86400L);
                        TimeRangeFilter.Companion companion = TimeRangeFilter.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(yesterday, "yesterday");
                        Intrinsics.checkNotNullExpressionValue(now, "now");
                        ReadRecordsRequest request$iv = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(OxygenSaturationRecord.class), companion.between(yesterday, now), SetsKt.emptySet(), false, 0, null, 56, null);
                        HealthConnectClient healthConnectClient = getHealthConnectClient();
                        healthConnectManager$readLatestSpO2$1.label = 1;
                        readRecords = healthConnectClient.readRecords(request$iv, healthConnectManager$readLatestSpO2$1);
                        if (readRecords != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        readRecords = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Iterable $this$maxByOrNull$iv = ((ReadRecordsResponse) readRecords).getRecords();
                iterator$iv = $this$maxByOrNull$iv.iterator();
                if (iterator$iv.hasNext()) {
                    return null;
                }
                Object maxElem$iv = iterator$iv.next();
                if (!iterator$iv.hasNext()) {
                    return maxElem$iv;
                }
                OxygenSaturationRecord it = (OxygenSaturationRecord) maxElem$iv;
                Comparable maxValue$iv = it.getTime();
                do {
                    Object e$iv = iterator$iv.next();
                    OxygenSaturationRecord it2 = (OxygenSaturationRecord) e$iv;
                    Instant time = it2.getTime();
                    if (maxValue$iv.compareTo(time) < 0) {
                        maxElem$iv = e$iv;
                        maxValue$iv = time;
                    }
                } while (iterator$iv.hasNext());
                return maxElem$iv;
            }
        }
        healthConnectManager$readLatestSpO2$1 = new HealthConnectManager$readLatestSpO2$1(this, continuation);
        Object $result2 = healthConnectManager$readLatestSpO2$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectManager$readLatestSpO2$1.label) {
        }
        Iterable $this$maxByOrNull$iv2 = ((ReadRecordsResponse) readRecords).getRecords();
        iterator$iv = $this$maxByOrNull$iv2.iterator();
        if (iterator$iv.hasNext()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ad A[LOOP:0: B:13:0x00a7->B:15:0x00ad, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readTodaySteps(Continuation<? super Long> continuation) {
        HealthConnectManager$readTodaySteps$1 healthConnectManager$readTodaySteps$1;
        Object readRecords;
        if (continuation instanceof HealthConnectManager$readTodaySteps$1) {
            HealthConnectManager$readTodaySteps$1 healthConnectManager$readTodaySteps$12 = (HealthConnectManager$readTodaySteps$1) continuation;
            if ((healthConnectManager$readTodaySteps$12.label & Integer.MIN_VALUE) != 0) {
                healthConnectManager$readTodaySteps$12.label -= Integer.MIN_VALUE;
                healthConnectManager$readTodaySteps$1 = healthConnectManager$readTodaySteps$12;
                Object $result = healthConnectManager$readTodaySteps$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectManager$readTodaySteps$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Instant startOfDay = ZonedDateTime.now().toLocalDate().atStartOfDay(ZonedDateTime.now().getZone()).toInstant();
                        Instant now = Instant.now();
                        TimeRangeFilter.Companion companion = TimeRangeFilter.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(startOfDay, "startOfDay");
                        Intrinsics.checkNotNullExpressionValue(now, "now");
                        ReadRecordsRequest request$iv = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(StepsRecord.class), companion.between(startOfDay, now), SetsKt.emptySet(), false, 0, null, 56, null);
                        HealthConnectClient healthConnectClient = getHealthConnectClient();
                        healthConnectManager$readTodaySteps$1.label = 1;
                        readRecords = healthConnectClient.readRecords(request$iv, healthConnectManager$readTodaySteps$1);
                        if (readRecords == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        readRecords = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                List<StepsRecord> steps = ((ReadRecordsResponse) readRecords).getRecords();
                long j = 0;
                for (StepsRecord it : steps) {
                    j += it.getCount();
                }
                return Boxing.boxLong(j);
            }
        }
        healthConnectManager$readTodaySteps$1 = new HealthConnectManager$readTodaySteps$1(this, continuation);
        Object $result2 = healthConnectManager$readTodaySteps$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectManager$readTodaySteps$1.label) {
        }
        List<StepsRecord> steps2 = ((ReadRecordsResponse) readRecords).getRecords();
        long j2 = 0;
        while (r3.hasNext()) {
        }
        return Boxing.boxLong(j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object hasAllPermissions(Set<String> set, Continuation<? super Boolean> continuation) {
        HealthConnectManager$hasAllPermissions$1 healthConnectManager$hasAllPermissions$1;
        HealthConnectManager$hasAllPermissions$1 healthConnectManager$hasAllPermissions$12;
        Object grantedPermissions;
        if (continuation instanceof HealthConnectManager$hasAllPermissions$1) {
            healthConnectManager$hasAllPermissions$1 = (HealthConnectManager$hasAllPermissions$1) continuation;
            if ((healthConnectManager$hasAllPermissions$1.label & Integer.MIN_VALUE) != 0) {
                healthConnectManager$hasAllPermissions$1.label -= Integer.MIN_VALUE;
                healthConnectManager$hasAllPermissions$12 = healthConnectManager$hasAllPermissions$1;
                Object $result = healthConnectManager$hasAllPermissions$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (healthConnectManager$hasAllPermissions$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        PermissionController permissionController = getHealthConnectClient().getPermissionController();
                        healthConnectManager$hasAllPermissions$12.L$0 = set;
                        healthConnectManager$hasAllPermissions$12.label = 1;
                        grantedPermissions = permissionController.getGrantedPermissions(healthConnectManager$hasAllPermissions$12);
                        if (grantedPermissions == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        set = (Set) healthConnectManager$hasAllPermissions$12.L$0;
                        ResultKt.throwOnFailure($result);
                        grantedPermissions = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Boxing.boxBoolean(((Set) grantedPermissions).containsAll(set));
            }
        }
        healthConnectManager$hasAllPermissions$1 = new HealthConnectManager$hasAllPermissions$1(this, continuation);
        healthConnectManager$hasAllPermissions$12 = healthConnectManager$hasAllPermissions$1;
        Object $result2 = healthConnectManager$hasAllPermissions$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (healthConnectManager$hasAllPermissions$12.label) {
        }
        return Boxing.boxBoolean(((Set) grantedPermissions).containsAll(set));
    }

    public final ActivityResultContract<Set<String>, Set<String>> requestPermissionsActivityContract() {
        return PermissionController.Companion.createRequestPermissionResultContract$default(PermissionController.INSTANCE, null, 1, null);
    }

    static /* synthetic */ Object readData$default(HealthConnectManager $this, TimeRangeFilter timeRangeFilter, Set dataOriginFilter, Continuation $completion, int i, Object obj) {
        if ((i & 2) != 0) {
            dataOriginFilter = SetsKt.emptySet();
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        ReadRecordsRequest request = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(Record.class), timeRangeFilter, dataOriginFilter, false, 0, null, 56, null);
        HealthConnectClient healthConnectClient = $this.getHealthConnectClient();
        InlineMarker.mark(0);
        Object readRecords = healthConnectClient.readRecords(request, $completion);
        InlineMarker.mark(1);
        return ((ReadRecordsResponse) readRecords).getRecords();
    }

    private final /* synthetic */ <T extends Record> Object readData(TimeRangeFilter timeRangeFilter, Set<DataOrigin> set, Continuation<? super List<? extends T>> continuation) {
        Intrinsics.reifiedOperationMarker(4, "T");
        ReadRecordsRequest request = new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(Record.class), timeRangeFilter, set, false, 0, null, 56, null);
        HealthConnectClient healthConnectClient = getHealthConnectClient();
        InlineMarker.mark(0);
        Object readRecords = healthConnectClient.readRecords(request, continuation);
        InlineMarker.mark(1);
        return ((ReadRecordsResponse) readRecords).getRecords();
    }

    private final boolean isSupported() {
        return Build.VERSION.SDK_INT >= 27;
    }
}
