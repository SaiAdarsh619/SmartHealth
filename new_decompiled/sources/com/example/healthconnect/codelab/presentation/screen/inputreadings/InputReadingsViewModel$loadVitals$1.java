package com.example.healthconnect.codelab.presentation.screen.inputreadings;

import android.util.Log;
import androidx.compose.material.TextFieldImplKt;
import androidx.health.connect.client.records.HeartRateRecord;
import androidx.health.connect.client.records.OxygenSaturationRecord;
import com.example.healthconnect.codelab.data.HealthConnectManager;
import com.example.healthconnect.codelab.logic.AlertStatus;
import com.example.healthconnect.codelab.logic.HealthAlert;
import com.example.healthconnect.codelab.logic.MonitorResult;
import com.example.healthconnect.codelab.logic.SmartHealthMonitor;
import com.example.healthconnect.codelab.presentation.model.VitalType;
import com.example.healthconnect.codelab.presentation.model.VitalUiModel;
import com.example.healthconnect.codelab.telemetry.TelemetryManager;
import com.example.healthconnect.codelab.telemetry.TelemetryModelsKt;
import com.example.healthconnect.codelab.telemetry.TelemetrySnapshot;
import com.example.healthconnect.codelab.telemetry.UserProfileData;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InputReadingsViewModel.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel$loadVitals$1", m297f = "InputReadingsViewModel.kt", m298i = {}, m299l = {147, 229}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes12.dex */
final class InputReadingsViewModel$loadVitals$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InputReadingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InputReadingsViewModel$loadVitals$1(InputReadingsViewModel inputReadingsViewModel, Continuation<? super InputReadingsViewModel$loadVitals$1> continuation) {
        super(2, continuation);
        this.this$0 = inputReadingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InputReadingsViewModel$loadVitals$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InputReadingsViewModel$loadVitals$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0065 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0072 -> B:7:0x0026). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            java.lang.String r2 = "Telemetry"
            switch(r1) {
                case 0: goto L1d;
                case 1: goto L18;
                case 2: goto L13;
                default: goto Lb;
            }
        Lb:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L13:
            r1 = r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L75
        L18:
            r1 = r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L66
        L1d:
            kotlin.ResultKt.throwOnFailure(r8)
            r1 = r7
            java.lang.String r3 = "Starting background monitor loop"
            android.util.Log.d(r2, r3)
        L26:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "loadVitals loop iteration. Permissions: "
            java.lang.StringBuilder r3 = r3.append(r4)
            com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel r4 = r1.this$0
            androidx.compose.runtime.MutableState r4 = r4.getPermissionsGranted()
            java.lang.Object r4 = r4.getValue()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r2, r3)
            com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel r3 = r1.this$0
            com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel$loadVitals$1$1 r4 = new com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel$loadVitals$1$1
            com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel r5 = r1.this$0
            r6 = 0
            r4.<init>(r5, r6)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r5 = r1
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6 = 1
            r1.label = r6
            java.lang.Object r3 = com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel.access$tryWithPermissionsCheck(r3, r4, r5)
            if (r3 != r0) goto L66
            return r0
        L66:
            r3 = r1
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 2
            r1.label = r4
            r4 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r4, r3)
            if (r3 != r0) goto L75
            return r0
        L75:
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel$loadVitals$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* compiled from: InputReadingsViewModel.kt */
    @Metadata(m286d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m287d2 = {"<anonymous>", ""}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
    @DebugMetadata(m296c = "com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel$loadVitals$1$1", m297f = "InputReadingsViewModel.kt", m298i = {0, 1, 2, 3}, m299l = {TextFieldImplKt.AnimationDuration, 166, 178, 194}, m300m = "invokeSuspend", m301n = {"vitalList", "vitalList", "vitalList", "vitalList"}, m302s = {"L$0", "L$0", "L$0", "L$0"})
    /* renamed from: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel$loadVitals$1$1 */
    static final class C09931 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ InputReadingsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09931(InputReadingsViewModel inputReadingsViewModel, Continuation<? super C09931> continuation) {
            super(1, continuation);
            this.this$0 = inputReadingsViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C09931(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C09931) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0197  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x01d6  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x020a  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0253  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x027b  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x02ba  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0269 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0213  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x01ad A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0183 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0184  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0115 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x0116  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x00d8 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            C09931 c09931;
            HealthConnectManager healthConnectManager;
            Object $result2;
            Object $result3;
            List vitalList;
            HeartRateRecord hrRecord;
            HealthConnectManager healthConnectManager2;
            Object $result4;
            List<HeartRateRecord.Sample> samples;
            HeartRateRecord.Sample sample;
            OxygenSaturationRecord record;
            HealthConnectManager healthConnectManager3;
            Object readTodaySteps;
            Object $result5;
            long steps;
            HealthConnectManager healthConnectManager4;
            Object heartRateHistory;
            C09931 c099312;
            Object $result6;
            Iterator it;
            Integer num;
            Object obj;
            Integer hr;
            SmartHealthMonitor smartHealthMonitor;
            int i;
            int i2;
            boolean includeProfile;
            UserProfileData userProfile;
            TelemetrySnapshot snapshot;
            TelemetryManager telemetryManager;
            Iterator it2;
            Object obj2;
            VitalUiModel vitalUiModel;
            Integer spo2Value;
            SmartHealthMonitor smartHealthMonitor2;
            TelemetryManager telemetryManager2;
            String value;
            UserProfileData userProfileData;
            int i3;
            String value2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c09931 = this;
                    List vitalList2 = new ArrayList();
                    healthConnectManager = c09931.this$0.healthConnectManager;
                    c09931.L$0 = vitalList2;
                    c09931.label = 1;
                    Object readLatestHeartRate = healthConnectManager.readLatestHeartRate(c09931);
                    if (readLatestHeartRate == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    $result3 = readLatestHeartRate;
                    vitalList = vitalList2;
                    hrRecord = (HeartRateRecord) $result3;
                    Log.d("Telemetry", "Read HeartRate: " + hrRecord);
                    if (hrRecord != null && (samples = hrRecord.getSamples()) != null && (sample = (HeartRateRecord.Sample) CollectionsKt.lastOrNull((List) samples)) != null) {
                        Boxing.boxBoolean(vitalList.add(new VitalUiModel(VitalType.HEART_RATE, String.valueOf((int) sample.getBeatsPerMinute()), sample.getTime())));
                    }
                    healthConnectManager2 = c09931.this$0.healthConnectManager;
                    c09931.L$0 = vitalList;
                    c09931.label = 2;
                    $result4 = healthConnectManager2.readLatestSpO2(c09931);
                    if ($result4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    record = (OxygenSaturationRecord) $result4;
                    if (record != null) {
                        Boxing.boxBoolean(vitalList.add(new VitalUiModel(VitalType.SPO2, String.valueOf((int) record.getPercentage().getValue()), record.getTime())));
                    }
                    healthConnectManager3 = c09931.this$0.healthConnectManager;
                    c09931.L$0 = vitalList;
                    c09931.label = 3;
                    readTodaySteps = healthConnectManager3.readTodaySteps(c09931);
                    if (readTodaySteps == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result5 = readTodaySteps;
                    steps = ((Number) $result5).longValue();
                    if (steps > 0) {
                        VitalType vitalType = VitalType.STEPS;
                        String valueOf = String.valueOf(steps);
                        Instant now = Instant.now();
                        Intrinsics.checkNotNullExpressionValue(now, "now()");
                        vitalList.add(new VitalUiModel(vitalType, valueOf, now));
                    }
                    Iterable $this$sortedByDescending$iv = vitalList;
                    c09931.this$0.getVitals().setValue(CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel$loadVitals$1$1$invokeSuspend$$inlined$sortedByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            VitalUiModel it3 = (VitalUiModel) t2;
                            VitalUiModel it4 = (VitalUiModel) t;
                            return ComparisonsKt.compareValues(it3.getTime(), it4.getTime());
                        }
                    }));
                    Instant now2 = Instant.now();
                    Instant oneWeekAgo = now2.minus(7L, (TemporalUnit) ChronoUnit.DAYS);
                    healthConnectManager4 = c09931.this$0.healthConnectManager;
                    Intrinsics.checkNotNullExpressionValue(oneWeekAgo, "oneWeekAgo");
                    Intrinsics.checkNotNullExpressionValue(now2, "now");
                    c09931.L$0 = vitalList;
                    c09931.label = 4;
                    heartRateHistory = healthConnectManager4.getHeartRateHistory(oneWeekAgo, now2, c09931);
                    if (heartRateHistory != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c099312 = c09931;
                    $result6 = heartRateHistory;
                    List history = (List) $result6;
                    it = vitalList.iterator();
                    while (true) {
                        num = null;
                        if (it.hasNext()) {
                            obj = null;
                        } else {
                            obj = it.next();
                            VitalUiModel it3 = (VitalUiModel) obj;
                            VitalUiModel it4 = it3.getType() == VitalType.HEART_RATE ? 1 : null;
                            if (it4 != null) {
                            }
                        }
                    }
                    VitalUiModel vitalUiModel2 = (VitalUiModel) obj;
                    hr = (vitalUiModel2 != null || (value2 = vitalUiModel2.getValue()) == null) ? null : StringsKt.toIntOrNull(value2);
                    Log.d("Telemetry", "Assessing HR: " + hr);
                    if (hr != null) {
                        smartHealthMonitor = c099312.this$0.smartMonitor;
                        MonitorResult result = smartHealthMonitor.assessStatus(hr.intValue(), history);
                        HealthAlert alert = result.getAlert();
                        InputReadingsViewModel inputReadingsViewModel = c099312.this$0;
                        i = inputReadingsViewModel.telemetryPacketCount;
                        inputReadingsViewModel.telemetryPacketCount = i + 1;
                        i2 = c099312.this$0.telemetryPacketCount;
                        if (i2 != 1) {
                            i3 = c099312.this$0.telemetryPacketCount;
                            if (i3 % 5 != 0) {
                                includeProfile = false;
                                if (includeProfile) {
                                    userProfile = null;
                                } else {
                                    userProfileData = c099312.this$0.getUserProfileData();
                                    userProfile = userProfileData;
                                }
                                TelemetrySnapshot snapshot2 = TelemetryModelsKt.toSnapshot(result, "HEART_RATE", hr.intValue());
                                snapshot = snapshot2.copy((r28 & 1) != 0 ? snapshot2.timestamp : null, (r28 & 2) != 0 ? snapshot2.vitalType : null, (r28 & 4) != 0 ? snapshot2.currentValue : 0.0d, (r28 & 8) != 0 ? snapshot2.alertStatus : null, (r28 & 16) != 0 ? snapshot2.systemPhase : null, (r28 & 32) != 0 ? snapshot2.decisionMessage : null, (r28 & 64) != 0 ? snapshot2.baselineMin : null, (r28 & 128) != 0 ? snapshot2.baselineMax : null, (r28 & 256) != 0 ? snapshot2.baselineAvg : null, (r28 & 512) != 0 ? snapshot2.anomalyScore : null, (r28 & 1024) != 0 ? snapshot2.meta : null, (r28 & 2048) != 0 ? snapshot2.userProfile : userProfile);
                                telemetryManager = c099312.this$0.telemetryManager;
                                telemetryManager.send(snapshot);
                                it2 = vitalList.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        obj2 = null;
                                    } else {
                                        obj2 = it2.next();
                                        VitalUiModel it5 = (VitalUiModel) obj2;
                                        VitalUiModel it6 = it5.getType() == VitalType.SPO2 ? 1 : null;
                                        if (it6 != null) {
                                        }
                                    }
                                }
                                vitalUiModel = (VitalUiModel) obj2;
                                if (vitalUiModel != null && (value = vitalUiModel.getValue()) != null) {
                                    num = StringsKt.toIntOrNull(value);
                                }
                                spo2Value = num;
                                if (spo2Value != null) {
                                    smartHealthMonitor2 = c099312.this$0.smartMonitor;
                                    HealthAlert spo2Alert = smartHealthMonitor2.assessSpO2Status(spo2Value.intValue());
                                    telemetryManager2 = c099312.this$0.telemetryManager;
                                    telemetryManager2.send(TelemetryModelsKt.toSnapshot(spo2Alert, "SPO2", spo2Value.intValue(), result.getPhase()));
                                    if (spo2Alert.getStatus() != AlertStatus.NORMAL) {
                                        c099312.this$0.checkAndSendAlert(spo2Alert.getMessage());
                                    }
                                }
                                if (alert.getStatus() != AlertStatus.NORMAL) {
                                    c099312.this$0.checkAndSendAlert(alert.getMessage());
                                }
                            }
                        }
                        includeProfile = true;
                        if (includeProfile) {
                        }
                        TelemetrySnapshot snapshot22 = TelemetryModelsKt.toSnapshot(result, "HEART_RATE", hr.intValue());
                        snapshot = snapshot22.copy((r28 & 1) != 0 ? snapshot22.timestamp : null, (r28 & 2) != 0 ? snapshot22.vitalType : null, (r28 & 4) != 0 ? snapshot22.currentValue : 0.0d, (r28 & 8) != 0 ? snapshot22.alertStatus : null, (r28 & 16) != 0 ? snapshot22.systemPhase : null, (r28 & 32) != 0 ? snapshot22.decisionMessage : null, (r28 & 64) != 0 ? snapshot22.baselineMin : null, (r28 & 128) != 0 ? snapshot22.baselineMax : null, (r28 & 256) != 0 ? snapshot22.baselineAvg : null, (r28 & 512) != 0 ? snapshot22.anomalyScore : null, (r28 & 1024) != 0 ? snapshot22.meta : null, (r28 & 2048) != 0 ? snapshot22.userProfile : userProfile);
                        telemetryManager = c099312.this$0.telemetryManager;
                        telemetryManager.send(snapshot);
                        it2 = vitalList.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                            }
                        }
                        vitalUiModel = (VitalUiModel) obj2;
                        if (vitalUiModel != null) {
                            num = StringsKt.toIntOrNull(value);
                        }
                        spo2Value = num;
                        if (spo2Value != null) {
                        }
                        if (alert.getStatus() != AlertStatus.NORMAL) {
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    c09931 = this;
                    $result3 = $result;
                    List vitalList3 = (List) c09931.L$0;
                    ResultKt.throwOnFailure($result3);
                    vitalList = vitalList3;
                    $result2 = $result3;
                    hrRecord = (HeartRateRecord) $result3;
                    Log.d("Telemetry", "Read HeartRate: " + hrRecord);
                    if (hrRecord != null) {
                        Boxing.boxBoolean(vitalList.add(new VitalUiModel(VitalType.HEART_RATE, String.valueOf((int) sample.getBeatsPerMinute()), sample.getTime())));
                        break;
                    }
                    healthConnectManager2 = c09931.this$0.healthConnectManager;
                    c09931.L$0 = vitalList;
                    c09931.label = 2;
                    $result4 = healthConnectManager2.readLatestSpO2(c09931);
                    if ($result4 == coroutine_suspended) {
                    }
                    record = (OxygenSaturationRecord) $result4;
                    if (record != null) {
                    }
                    healthConnectManager3 = c09931.this$0.healthConnectManager;
                    c09931.L$0 = vitalList;
                    c09931.label = 3;
                    readTodaySteps = healthConnectManager3.readTodaySteps(c09931);
                    if (readTodaySteps == coroutine_suspended) {
                    }
                    break;
                case 2:
                    c09931 = this;
                    $result4 = $result;
                    List vitalList4 = (List) c09931.L$0;
                    ResultKt.throwOnFailure($result4);
                    vitalList = vitalList4;
                    $result2 = $result4;
                    record = (OxygenSaturationRecord) $result4;
                    if (record != null) {
                    }
                    healthConnectManager3 = c09931.this$0.healthConnectManager;
                    c09931.L$0 = vitalList;
                    c09931.label = 3;
                    readTodaySteps = healthConnectManager3.readTodaySteps(c09931);
                    if (readTodaySteps == coroutine_suspended) {
                    }
                    break;
                case 3:
                    c09931 = this;
                    List vitalList5 = (List) c09931.L$0;
                    ResultKt.throwOnFailure($result);
                    vitalList = vitalList5;
                    $result5 = $result;
                    steps = ((Number) $result5).longValue();
                    if (steps > 0) {
                    }
                    Iterable $this$sortedByDescending$iv2 = vitalList;
                    c09931.this$0.getVitals().setValue(CollectionsKt.sortedWith($this$sortedByDescending$iv2, new Comparator() { // from class: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel$loadVitals$1$1$invokeSuspend$$inlined$sortedByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            VitalUiModel it32 = (VitalUiModel) t2;
                            VitalUiModel it42 = (VitalUiModel) t;
                            return ComparisonsKt.compareValues(it32.getTime(), it42.getTime());
                        }
                    }));
                    Instant now22 = Instant.now();
                    Instant oneWeekAgo2 = now22.minus(7L, (TemporalUnit) ChronoUnit.DAYS);
                    healthConnectManager4 = c09931.this$0.healthConnectManager;
                    Intrinsics.checkNotNullExpressionValue(oneWeekAgo2, "oneWeekAgo");
                    Intrinsics.checkNotNullExpressionValue(now22, "now");
                    c09931.L$0 = vitalList;
                    c09931.label = 4;
                    heartRateHistory = healthConnectManager4.getHeartRateHistory(oneWeekAgo2, now22, c09931);
                    if (heartRateHistory != coroutine_suspended) {
                    }
                    break;
                case 4:
                    c099312 = this;
                    $result6 = $result;
                    List vitalList6 = (List) c099312.L$0;
                    ResultKt.throwOnFailure($result6);
                    vitalList = vitalList6;
                    List history2 = (List) $result6;
                    it = vitalList.iterator();
                    while (true) {
                        num = null;
                        if (it.hasNext()) {
                        }
                    }
                    VitalUiModel vitalUiModel22 = (VitalUiModel) obj;
                    if (vitalUiModel22 != null) {
                        break;
                    }
                    Log.d("Telemetry", "Assessing HR: " + hr);
                    if (hr != null) {
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
