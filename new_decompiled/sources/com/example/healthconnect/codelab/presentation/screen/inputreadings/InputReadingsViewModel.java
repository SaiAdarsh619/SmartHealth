package com.example.healthconnect.codelab.presentation.screen.inputreadings;

import android.location.Location;
import android.os.RemoteException;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.health.connect.client.permission.HealthPermission;
import androidx.health.connect.client.records.HeartRateRecord;
import androidx.health.connect.client.records.OxygenSaturationRecord;
import androidx.health.connect.client.records.StepsRecord;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.healthconnect.codelab.data.EmergencyContactsManager;
import com.example.healthconnect.codelab.data.HealthConnectManager;
import com.example.healthconnect.codelab.data.UserProfileManager;
import com.example.healthconnect.codelab.logic.SmartHealthMonitor;
import com.example.healthconnect.codelab.presentation.model.VitalUiModel;
import com.example.healthconnect.codelab.telemetry.TelemetryManager;
import com.example.healthconnect.codelab.telemetry.UserInfoSnapshot;
import com.example.healthconnect.codelab.telemetry.UserProfileData;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.tasks.TasksKt;

/* compiled from: InputReadingsViewModel.kt */
@Metadata(m286d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001MB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0011H\u0002J\u0013\u00109\u001a\u0004\u0018\u00010\u0011H\u0083@ø\u0001\u0000¢\u0006\u0002\u0010:J\b\u0010;\u001a\u00020<H\u0002J\u0006\u0010=\u001a\u000207J\u0006\u0010>\u001a\u000207J\u0006\u0010?\u001a\u000207J\u001a\u0010@\u001a\u0002072\u0006\u00108\u001a\u00020\u00112\b\b\u0002\u0010A\u001a\u00020\u0016H\u0002J\u0006\u0010B\u001a\u000207J\b\u0010C\u001a\u000207H\u0002J\u0016\u0010D\u001a\u0002072\u0006\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020*J/\u0010G\u001a\u0002072\u001c\u0010H\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002070J\u0012\u0006\u0012\u0004\u0018\u00010K0IH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010LR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R*\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R)\u0010\u001a\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR/\u0010\u001e\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00118F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010,\u001a\u00020+2\u0006\u0010\u0014\u001a\u00020+8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010$\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R6\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000203020\u00152\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000203020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006N"}, m287d2 = {"Lcom/example/healthconnect/codelab/presentation/screen/inputreadings/InputReadingsViewModel;", "Landroidx/lifecycle/ViewModel;", "healthConnectManager", "Lcom/example/healthconnect/codelab/data/HealthConnectManager;", "contactsManager", "Lcom/example/healthconnect/codelab/data/EmergencyContactsManager;", "userProfileManager", "Lcom/example/healthconnect/codelab/data/UserProfileManager;", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "(Lcom/example/healthconnect/codelab/data/HealthConnectManager;Lcom/example/healthconnect/codelab/data/EmergencyContactsManager;Lcom/example/healthconnect/codelab/data/UserProfileManager;Lcom/google/android/gms/location/FusedLocationProviderClient;)V", "backgroundMonitorJob", "Lkotlinx/coroutines/Job;", "lastAlertTime", "Ljava/time/Instant;", "permissions", "", "", "getPermissions", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/MutableState;", "", "permissionsGranted", "getPermissionsGranted", "()Landroidx/compose/runtime/MutableState;", "permissionsLauncher", "Landroidx/activity/result/contract/ActivityResultContract;", "getPermissionsLauncher", "()Landroidx/activity/result/contract/ActivityResultContract;", "simulationResult", "getSimulationResult", "()Ljava/lang/String;", "setSimulationResult", "(Ljava/lang/String;)V", "simulationResult$delegate", "Landroidx/compose/runtime/MutableState;", "smartMonitor", "Lcom/example/healthconnect/codelab/logic/SmartHealthMonitor;", "telemetryManager", "Lcom/example/healthconnect/codelab/telemetry/TelemetryManager;", "telemetryPacketCount", "", "Lcom/example/healthconnect/codelab/presentation/screen/inputreadings/InputReadingsViewModel$UiState;", "uiState", "getUiState", "()Lcom/example/healthconnect/codelab/presentation/screen/inputreadings/InputReadingsViewModel$UiState;", "setUiState", "(Lcom/example/healthconnect/codelab/presentation/screen/inputreadings/InputReadingsViewModel$UiState;)V", "uiState$delegate", "", "Lcom/example/healthconnect/codelab/presentation/model/VitalUiModel;", "vitals", "getVitals", "checkAndSendAlert", "", "message", "getLastLocation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserProfileData", "Lcom/example/healthconnect/codelab/telemetry/UserProfileData;", "initialLoad", "loadVitals", "onPermissionsGranted", "sendSmsToContacts", "isTest", "sendTestAlert", "sendUserInfoTelemetry", "simulateVital", "hr", "spo2", "tryWithPermissionsCheck", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "UiState", "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes12.dex */
public final class InputReadingsViewModel extends ViewModel {
    public static final int $stable = 8;
    private Job backgroundMonitorJob;
    private final EmergencyContactsManager contactsManager;
    private final FusedLocationProviderClient fusedLocationClient;
    private final HealthConnectManager healthConnectManager;
    private Instant lastAlertTime;
    private final Set<String> permissions;
    private MutableState<Boolean> permissionsGranted;
    private final ActivityResultContract<Set<String>, Set<String>> permissionsLauncher;

    /* renamed from: simulationResult$delegate, reason: from kotlin metadata */
    private final MutableState simulationResult;
    private final SmartHealthMonitor smartMonitor;
    private final TelemetryManager telemetryManager;
    private int telemetryPacketCount;

    /* renamed from: uiState$delegate, reason: from kotlin metadata */
    private final MutableState uiState;
    private final UserProfileManager userProfileManager;
    private MutableState<List<VitalUiModel>> vitals;

    public InputReadingsViewModel(HealthConnectManager healthConnectManager, EmergencyContactsManager contactsManager, UserProfileManager userProfileManager, FusedLocationProviderClient fusedLocationClient) {
        Intrinsics.checkNotNullParameter(healthConnectManager, "healthConnectManager");
        Intrinsics.checkNotNullParameter(contactsManager, "contactsManager");
        Intrinsics.checkNotNullParameter(userProfileManager, "userProfileManager");
        Intrinsics.checkNotNullParameter(fusedLocationClient, "fusedLocationClient");
        this.healthConnectManager = healthConnectManager;
        this.contactsManager = contactsManager;
        this.userProfileManager = userProfileManager;
        this.fusedLocationClient = fusedLocationClient;
        this.smartMonitor = new SmartHealthMonitor(this.userProfileManager);
        this.telemetryManager = new TelemetryManager();
        this.permissions = SetsKt.setOf((Object[]) new String[]{HealthPermission.INSTANCE.getReadPermission(Reflection.getOrCreateKotlinClass(HeartRateRecord.class)), HealthPermission.INSTANCE.getReadPermission(Reflection.getOrCreateKotlinClass(OxygenSaturationRecord.class)), HealthPermission.INSTANCE.getReadPermission(Reflection.getOrCreateKotlinClass(StepsRecord.class))});
        this.vitals = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
        this.permissionsGranted = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.uiState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(UiState.Uninitialized.INSTANCE, null, 2, null);
        this.permissionsLauncher = this.healthConnectManager.requestPermissionsActivityContract();
        this.simulationResult = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    public final Set<String> getPermissions() {
        return this.permissions;
    }

    public final MutableState<List<VitalUiModel>> getVitals() {
        return this.vitals;
    }

    public final MutableState<Boolean> getPermissionsGranted() {
        return this.permissionsGranted;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUiState(UiState uiState) {
        MutableState $this$setValue$iv = this.uiState;
        $this$setValue$iv.setValue(uiState);
    }

    public final UiState getUiState() {
        State $this$getValue$iv = this.uiState;
        return (UiState) $this$getValue$iv.getValue();
    }

    public final ActivityResultContract<Set<String>, Set<String>> getPermissionsLauncher() {
        return this.permissionsLauncher;
    }

    public final void onPermissionsGranted() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new InputReadingsViewModel$onPermissionsGranted$1(this, null), 3, null);
    }

    public final void initialLoad() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new InputReadingsViewModel$initialLoad$1(this, null), 3, null);
    }

    private final void sendUserInfoTelemetry() {
        String instant = Instant.now().toString();
        Intrinsics.checkNotNullExpressionValue(instant, "now().toString()");
        UserInfoSnapshot info = new UserInfoSnapshot(instant, this.userProfileManager.getAge(), MapsKt.mapOf(TuplesKt.m294to("has_heart_condition", Boolean.valueOf(this.userProfileManager.getHasHeartCondition())), TuplesKt.m294to("is_athlete", Boolean.valueOf(this.userProfileManager.isAthlete())), TuplesKt.m294to("has_respiratory_condition", Boolean.valueOf(this.userProfileManager.getHasRespiratoryCondition()))), this.contactsManager.getContacts());
        this.telemetryManager.send(info);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UserProfileData getUserProfileData() {
        return new UserProfileData(this.userProfileManager.getAge(), MapsKt.mapOf(TuplesKt.m294to("has_heart_condition", Boolean.valueOf(this.userProfileManager.getHasHeartCondition())), TuplesKt.m294to("is_athlete", Boolean.valueOf(this.userProfileManager.isAthlete())), TuplesKt.m294to("has_respiratory_condition", Boolean.valueOf(this.userProfileManager.getHasRespiratoryCondition()))), this.contactsManager.getContacts());
    }

    public final void loadVitals() {
        Job launch$default;
        Job job = this.backgroundMonitorJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new InputReadingsViewModel$loadVitals$1(this, null), 3, null);
        this.backgroundMonitorJob = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSimulationResult(String str) {
        MutableState $this$setValue$iv = this.simulationResult;
        $this$setValue$iv.setValue(str);
    }

    public final String getSimulationResult() {
        State $this$getValue$iv = this.simulationResult;
        return (String) $this$getValue$iv.getValue();
    }

    public final void simulateVital(int hr, int spo2) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new InputReadingsViewModel$simulateVital$1(this, hr, spo2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkAndSendAlert(String message) {
        Instant now = Instant.now();
        if (this.lastAlertTime == null || ChronoUnit.SECONDS.between(this.lastAlertTime, now) >= 5) {
            sendSmsToContacts$default(this, message, false, 2, null);
            this.lastAlertTime = now;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030 A[Catch: Exception -> 0x0035, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0035, blocks: (B:12:0x0030, B:14:0x0092, B:16:0x0097, B:18:0x00e6, B:21:0x003c, B:23:0x005d, B:25:0x0061, B:29:0x0046), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0097 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:12:0x0030, B:14:0x0092, B:16:0x0097, B:18:0x00e6, B:21:0x003c, B:23:0x005d, B:25:0x0061, B:29:0x0046), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e6 A[Catch: Exception -> 0x0035, TRY_LEAVE, TryCatch #0 {Exception -> 0x0035, blocks: (B:12:0x0030, B:14:0x0092, B:16:0x0097, B:18:0x00e6, B:21:0x003c, B:23:0x005d, B:25:0x0061, B:29:0x0046), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:12:0x0030, B:14:0x0092, B:16:0x0097, B:18:0x00e6, B:21:0x003c, B:23:0x005d, B:25:0x0061, B:29:0x0046), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getLastLocation(Continuation<? super String> continuation) {
        InputReadingsViewModel$getLastLocation$1 inputReadingsViewModel$getLastLocation$1;
        InputReadingsViewModel$getLastLocation$1 inputReadingsViewModel$getLastLocation$12;
        InputReadingsViewModel inputReadingsViewModel;
        Object await;
        Location location;
        Object await2;
        try {
            if (continuation instanceof InputReadingsViewModel$getLastLocation$1) {
                inputReadingsViewModel$getLastLocation$1 = (InputReadingsViewModel$getLastLocation$1) continuation;
                if ((inputReadingsViewModel$getLastLocation$1.label & Integer.MIN_VALUE) != 0) {
                    inputReadingsViewModel$getLastLocation$1.label -= Integer.MIN_VALUE;
                    inputReadingsViewModel$getLastLocation$12 = inputReadingsViewModel$getLastLocation$1;
                    Object $result = inputReadingsViewModel$getLastLocation$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (inputReadingsViewModel$getLastLocation$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            inputReadingsViewModel = this;
                            Task<Location> lastLocation = inputReadingsViewModel.fusedLocationClient.getLastLocation();
                            Intrinsics.checkNotNullExpressionValue(lastLocation, "fusedLocationClient.lastLocation");
                            inputReadingsViewModel$getLastLocation$12.L$0 = inputReadingsViewModel;
                            inputReadingsViewModel$getLastLocation$12.label = 1;
                            await = TasksKt.await(lastLocation, inputReadingsViewModel$getLastLocation$12);
                            if (await == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            location = (Location) await;
                            if (location == null) {
                                Log.d("Vitals", "Last location is null, requesting current location...");
                                CurrentLocationRequest request = new CurrentLocationRequest.Builder().setPriority(100).build();
                                Intrinsics.checkNotNullExpressionValue(request, "Builder()\n              …                 .build()");
                                Task<Location> currentLocation = inputReadingsViewModel.fusedLocationClient.getCurrentLocation(request, (CancellationToken) null);
                                Intrinsics.checkNotNullExpressionValue(currentLocation, "fusedLocationClient.getC…ntLocation(request, null)");
                                inputReadingsViewModel$getLastLocation$12.L$0 = null;
                                inputReadingsViewModel$getLastLocation$12.label = 2;
                                await2 = TasksKt.await(currentLocation, inputReadingsViewModel$getLastLocation$12);
                                if (await2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                location = (Location) await2;
                            }
                            if (location != null) {
                                Log.d("Vitals", "Location obtained: " + location.getLatitude() + ", " + location.getLongitude());
                                return "http://maps.google.com/?q=" + location.getLatitude() + ',' + location.getLongitude();
                            }
                            Log.e("Vitals", "Location is still null after request");
                            return null;
                        case 1:
                            inputReadingsViewModel = (InputReadingsViewModel) inputReadingsViewModel$getLastLocation$12.L$0;
                            ResultKt.throwOnFailure($result);
                            await = $result;
                            location = (Location) await;
                            if (location == null) {
                            }
                            if (location != null) {
                            }
                            break;
                        case 2:
                            ResultKt.throwOnFailure($result);
                            await2 = $result;
                            location = (Location) await2;
                            if (location != null) {
                            }
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (inputReadingsViewModel$getLastLocation$12.label) {
            }
        } catch (Exception e) {
            Log.e("Vitals", "Failed to get location: " + e.getMessage());
            return null;
        }
        inputReadingsViewModel$getLastLocation$1 = new InputReadingsViewModel$getLastLocation$1(this, continuation);
        inputReadingsViewModel$getLastLocation$12 = inputReadingsViewModel$getLastLocation$1;
        Object $result2 = inputReadingsViewModel$getLastLocation$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public final void sendTestAlert() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new InputReadingsViewModel$sendTestAlert$1(this, null), 3, null);
    }

    static /* synthetic */ void sendSmsToContacts$default(InputReadingsViewModel inputReadingsViewModel, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        inputReadingsViewModel.sendSmsToContacts(str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendSmsToContacts(String message, boolean isTest) {
        List contacts = this.contactsManager.getContacts();
        if (contacts.isEmpty()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new InputReadingsViewModel$sendSmsToContacts$1(this, isTest, message, contacts, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b A[Catch: IllegalStateException -> 0x00a4, IOException -> 0x00b3, SecurityException -> 0x00c2, RemoteException -> 0x00d1, TRY_LEAVE, TryCatch #4 {RemoteException -> 0x00d1, IOException -> 0x00b3, IllegalStateException -> 0x00a4, SecurityException -> 0x00c2, blocks: (B:30:0x007d, B:32:0x008b), top: B:29:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object tryWithPermissionsCheck(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        InputReadingsViewModel$tryWithPermissionsCheck$1 inputReadingsViewModel$tryWithPermissionsCheck$1;
        InputReadingsViewModel$tryWithPermissionsCheck$1 inputReadingsViewModel$tryWithPermissionsCheck$12;
        InputReadingsViewModel inputReadingsViewModel;
        Object hasAllPermissions;
        Function1<? super Continuation<? super Unit>, ? extends Object> function12;
        MutableState mutableState;
        InputReadingsViewModel inputReadingsViewModel2;
        InputReadingsViewModel inputReadingsViewModel3;
        UiState.Done error;
        if (continuation instanceof InputReadingsViewModel$tryWithPermissionsCheck$1) {
            inputReadingsViewModel$tryWithPermissionsCheck$1 = (InputReadingsViewModel$tryWithPermissionsCheck$1) continuation;
            if ((inputReadingsViewModel$tryWithPermissionsCheck$1.label & Integer.MIN_VALUE) != 0) {
                inputReadingsViewModel$tryWithPermissionsCheck$1.label -= Integer.MIN_VALUE;
                inputReadingsViewModel$tryWithPermissionsCheck$12 = inputReadingsViewModel$tryWithPermissionsCheck$1;
                Object obj = inputReadingsViewModel$tryWithPermissionsCheck$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = 2;
                UUID uuid = null;
                Object[] objArr = 0;
                Object[] objArr2 = 0;
                Object[] objArr3 = 0;
                Object[] objArr4 = 0;
                Object[] objArr5 = 0;
                Object[] objArr6 = 0;
                Object[] objArr7 = 0;
                switch (inputReadingsViewModel$tryWithPermissionsCheck$12.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        inputReadingsViewModel = this;
                        MutableState<Boolean> mutableState2 = inputReadingsViewModel.permissionsGranted;
                        HealthConnectManager healthConnectManager = inputReadingsViewModel.healthConnectManager;
                        Set<String> set = inputReadingsViewModel.permissions;
                        inputReadingsViewModel$tryWithPermissionsCheck$12.L$0 = inputReadingsViewModel;
                        inputReadingsViewModel$tryWithPermissionsCheck$12.L$1 = function1;
                        inputReadingsViewModel$tryWithPermissionsCheck$12.L$2 = mutableState2;
                        inputReadingsViewModel$tryWithPermissionsCheck$12.label = 1;
                        hasAllPermissions = healthConnectManager.hasAllPermissions(set, inputReadingsViewModel$tryWithPermissionsCheck$12);
                        if (hasAllPermissions == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function12 = function1;
                        mutableState = mutableState2;
                        mutableState.setValue(hasAllPermissions);
                        try {
                        } catch (RemoteException e) {
                            e = e;
                            inputReadingsViewModel2 = inputReadingsViewModel;
                            error = new UiState.Error(e, uuid, i, objArr7 == true ? 1 : 0);
                            inputReadingsViewModel = inputReadingsViewModel2;
                            inputReadingsViewModel.setUiState(error);
                            return Unit.INSTANCE;
                        } catch (IOException e2) {
                            e = e2;
                            inputReadingsViewModel2 = inputReadingsViewModel;
                            error = new UiState.Error(e, objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
                            inputReadingsViewModel = inputReadingsViewModel2;
                            inputReadingsViewModel.setUiState(error);
                            return Unit.INSTANCE;
                        } catch (IllegalStateException e3) {
                            e = e3;
                            inputReadingsViewModel2 = inputReadingsViewModel;
                            error = new UiState.Error(e, objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
                            inputReadingsViewModel = inputReadingsViewModel2;
                            inputReadingsViewModel.setUiState(error);
                            return Unit.INSTANCE;
                        } catch (SecurityException e4) {
                            e = e4;
                            inputReadingsViewModel2 = inputReadingsViewModel;
                            error = new UiState.Error(e, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
                            inputReadingsViewModel = inputReadingsViewModel2;
                            inputReadingsViewModel.setUiState(error);
                            return Unit.INSTANCE;
                        }
                        if (inputReadingsViewModel.permissionsGranted.getValue().booleanValue()) {
                            inputReadingsViewModel2 = inputReadingsViewModel;
                            error = UiState.Done.INSTANCE;
                            inputReadingsViewModel.setUiState(error);
                            return Unit.INSTANCE;
                        }
                        inputReadingsViewModel$tryWithPermissionsCheck$12.L$0 = inputReadingsViewModel;
                        inputReadingsViewModel$tryWithPermissionsCheck$12.L$1 = inputReadingsViewModel;
                        inputReadingsViewModel$tryWithPermissionsCheck$12.L$2 = null;
                        inputReadingsViewModel$tryWithPermissionsCheck$12.label = 2;
                        if (function12.invoke(inputReadingsViewModel$tryWithPermissionsCheck$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        inputReadingsViewModel3 = inputReadingsViewModel;
                        inputReadingsViewModel2 = inputReadingsViewModel3;
                        inputReadingsViewModel = inputReadingsViewModel3;
                        error = UiState.Done.INSTANCE;
                        inputReadingsViewModel.setUiState(error);
                        return Unit.INSTANCE;
                    case 1:
                        mutableState = (MutableState) inputReadingsViewModel$tryWithPermissionsCheck$12.L$2;
                        Function1<? super Continuation<? super Unit>, ? extends Object> function13 = (Function1) inputReadingsViewModel$tryWithPermissionsCheck$12.L$1;
                        InputReadingsViewModel inputReadingsViewModel4 = (InputReadingsViewModel) inputReadingsViewModel$tryWithPermissionsCheck$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        hasAllPermissions = obj;
                        function12 = function13;
                        inputReadingsViewModel = inputReadingsViewModel4;
                        mutableState.setValue(hasAllPermissions);
                        if (inputReadingsViewModel.permissionsGranted.getValue().booleanValue()) {
                        }
                        break;
                    case 2:
                        inputReadingsViewModel3 = (InputReadingsViewModel) inputReadingsViewModel$tryWithPermissionsCheck$12.L$1;
                        inputReadingsViewModel2 = (InputReadingsViewModel) inputReadingsViewModel$tryWithPermissionsCheck$12.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            inputReadingsViewModel = inputReadingsViewModel3;
                            error = UiState.Done.INSTANCE;
                        } catch (RemoteException e5) {
                            e = e5;
                            error = new UiState.Error(e, uuid, i, objArr7 == true ? 1 : 0);
                            inputReadingsViewModel = inputReadingsViewModel2;
                            inputReadingsViewModel.setUiState(error);
                            return Unit.INSTANCE;
                        } catch (IOException e6) {
                            e = e6;
                            error = new UiState.Error(e, objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
                            inputReadingsViewModel = inputReadingsViewModel2;
                            inputReadingsViewModel.setUiState(error);
                            return Unit.INSTANCE;
                        } catch (IllegalStateException e7) {
                            e = e7;
                            error = new UiState.Error(e, objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
                            inputReadingsViewModel = inputReadingsViewModel2;
                            inputReadingsViewModel.setUiState(error);
                            return Unit.INSTANCE;
                        } catch (SecurityException e8) {
                            e = e8;
                            error = new UiState.Error(e, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
                            inputReadingsViewModel = inputReadingsViewModel2;
                            inputReadingsViewModel.setUiState(error);
                            return Unit.INSTANCE;
                        }
                        inputReadingsViewModel.setUiState(error);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        inputReadingsViewModel$tryWithPermissionsCheck$1 = new InputReadingsViewModel$tryWithPermissionsCheck$1(this, continuation);
        inputReadingsViewModel$tryWithPermissionsCheck$12 = inputReadingsViewModel$tryWithPermissionsCheck$1;
        Object obj2 = inputReadingsViewModel$tryWithPermissionsCheck$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = 2;
        UUID uuid2 = null;
        Object[] objArr8 = 0;
        Object[] objArr22 = 0;
        Object[] objArr32 = 0;
        Object[] objArr42 = 0;
        Object[] objArr52 = 0;
        Object[] objArr62 = 0;
        Object[] objArr72 = 0;
        switch (inputReadingsViewModel$tryWithPermissionsCheck$12.label) {
        }
    }

    /* compiled from: InputReadingsViewModel.kt */
    @Metadata(m286d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m287d2 = {"Lcom/example/healthconnect/codelab/presentation/screen/inputreadings/InputReadingsViewModel$UiState;", "", "()V", "Done", "Error", "Uninitialized", "Lcom/example/healthconnect/codelab/presentation/screen/inputreadings/InputReadingsViewModel$UiState$Done;", "Lcom/example/healthconnect/codelab/presentation/screen/inputreadings/InputReadingsViewModel$UiState$Error;", "Lcom/example/healthconnect/codelab/presentation/screen/inputreadings/InputReadingsViewModel$UiState$Uninitialized;", "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static abstract class UiState {
        public static final int $stable = 0;

        public /* synthetic */ UiState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: InputReadingsViewModel.kt */
        @Metadata(m286d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m287d2 = {"Lcom/example/healthconnect/codelab/presentation/screen/inputreadings/InputReadingsViewModel$UiState$Uninitialized;", "Lcom/example/healthconnect/codelab/presentation/screen/inputreadings/InputReadingsViewModel$UiState;", "()V", "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
        public static final class Uninitialized extends UiState {
            public static final int $stable = 0;
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private UiState() {
        }

        /* compiled from: InputReadingsViewModel.kt */
        @Metadata(m286d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m287d2 = {"Lcom/example/healthconnect/codelab/presentation/screen/inputreadings/InputReadingsViewModel$UiState$Done;", "Lcom/example/healthconnect/codelab/presentation/screen/inputreadings/InputReadingsViewModel$UiState;", "()V", "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
        public static final class Done extends UiState {
            public static final int $stable = 0;
            public static final Done INSTANCE = new Done();

            private Done() {
                super(null);
            }
        }

        /* compiled from: InputReadingsViewModel.kt */
        @Metadata(m286d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m287d2 = {"Lcom/example/healthconnect/codelab/presentation/screen/inputreadings/InputReadingsViewModel$UiState$Error;", "Lcom/example/healthconnect/codelab/presentation/screen/inputreadings/InputReadingsViewModel$UiState;", "exception", "", "uuid", "Ljava/util/UUID;", "(Ljava/lang/Throwable;Ljava/util/UUID;)V", "getException", "()Ljava/lang/Throwable;", "getUuid", "()Ljava/util/UUID;", "component1", "component2", "copy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
        public static final /* data */ class Error extends UiState {
            public static final int $stable = 8;
            private final Throwable exception;
            private final UUID uuid;

            public static /* synthetic */ Error copy$default(Error error, Throwable th, UUID uuid, int i, Object obj) {
                if ((i & 1) != 0) {
                    th = error.exception;
                }
                if ((i & 2) != 0) {
                    uuid = error.uuid;
                }
                return error.copy(th, uuid);
            }

            /* renamed from: component1, reason: from getter */
            public final Throwable getException() {
                return this.exception;
            }

            /* renamed from: component2, reason: from getter */
            public final UUID getUuid() {
                return this.uuid;
            }

            public final Error copy(Throwable exception, UUID uuid) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                return new Error(exception, uuid);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                Error error = (Error) other;
                return Intrinsics.areEqual(this.exception, error.exception) && Intrinsics.areEqual(this.uuid, error.uuid);
            }

            public int hashCode() {
                return (this.exception.hashCode() * 31) + this.uuid.hashCode();
            }

            public String toString() {
                return "Error(exception=" + this.exception + ", uuid=" + this.uuid + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(Throwable exception, UUID uuid) {
                super(null);
                Intrinsics.checkNotNullParameter(exception, "exception");
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                this.exception = exception;
                this.uuid = uuid;
            }

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public /* synthetic */ Error(Throwable th, UUID uuid, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(th, uuid);
                if ((i & 2) != 0) {
                    uuid = UUID.randomUUID();
                    Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID()");
                }
            }

            public final Throwable getException() {
                return this.exception;
            }

            public final UUID getUuid() {
                return this.uuid;
            }
        }
    }
}
