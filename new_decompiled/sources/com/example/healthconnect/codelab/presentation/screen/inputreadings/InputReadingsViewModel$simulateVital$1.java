package com.example.healthconnect.codelab.presentation.screen.inputreadings;

import com.example.healthconnect.codelab.data.HealthConnectManager;
import com.example.healthconnect.codelab.data.UserProfileManager;
import com.example.healthconnect.codelab.logic.AlertStatus;
import com.example.healthconnect.codelab.logic.HealthAlert;
import com.example.healthconnect.codelab.logic.MonitorResult;
import com.example.healthconnect.codelab.logic.SmartHealthMonitor;
import com.example.healthconnect.codelab.telemetry.TelemetryManager;
import com.example.healthconnect.codelab.telemetry.TelemetryModelsKt;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InputReadingsViewModel.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel$simulateVital$1", m297f = "InputReadingsViewModel.kt", m298i = {}, m299l = {241}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes12.dex */
final class InputReadingsViewModel$simulateVital$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $hr;
    final /* synthetic */ int $spo2;
    int label;
    final /* synthetic */ InputReadingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InputReadingsViewModel$simulateVital$1(InputReadingsViewModel inputReadingsViewModel, int i, int i2, Continuation<? super InputReadingsViewModel$simulateVital$1> continuation) {
        super(2, continuation);
        this.this$0 = inputReadingsViewModel;
        this.$hr = i;
        this.$spo2 = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InputReadingsViewModel$simulateVital$1(this.this$0, this.$hr, this.$spo2, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InputReadingsViewModel$simulateVital$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        InputReadingsViewModel$simulateVital$1 inputReadingsViewModel$simulateVital$1;
        HealthConnectManager healthConnectManager;
        SmartHealthMonitor smartHealthMonitor;
        SmartHealthMonitor smartHealthMonitor2;
        TelemetryManager telemetryManager;
        TelemetryManager telemetryManager2;
        UserProfileManager userProfileManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                inputReadingsViewModel$simulateVital$1 = this;
                Instant now = Instant.now();
                Instant oneWeekAgo = now.minus(7L, (TemporalUnit) ChronoUnit.DAYS);
                healthConnectManager = inputReadingsViewModel$simulateVital$1.this$0.healthConnectManager;
                Intrinsics.checkNotNullExpressionValue(oneWeekAgo, "oneWeekAgo");
                Intrinsics.checkNotNullExpressionValue(now, "now");
                inputReadingsViewModel$simulateVital$1.label = 1;
                Object heartRateHistory = healthConnectManager.getHeartRateHistory(oneWeekAgo, now, inputReadingsViewModel$simulateVital$1);
                if (heartRateHistory != coroutine_suspended) {
                    $result = heartRateHistory;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                inputReadingsViewModel$simulateVital$1 = this;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List history = (List) $result;
        smartHealthMonitor = inputReadingsViewModel$simulateVital$1.this$0.smartMonitor;
        MonitorResult hrResult = smartHealthMonitor.assessStatus(inputReadingsViewModel$simulateVital$1.$hr, history);
        HealthAlert hrAlert = hrResult.getAlert();
        smartHealthMonitor2 = inputReadingsViewModel$simulateVital$1.this$0.smartMonitor;
        HealthAlert spo2Alert = smartHealthMonitor2.assessSpO2Status(inputReadingsViewModel$simulateVital$1.$spo2);
        telemetryManager = inputReadingsViewModel$simulateVital$1.this$0.telemetryManager;
        telemetryManager.send(TelemetryModelsKt.toSnapshot(hrResult, "HEART_RATE_SIM", inputReadingsViewModel$simulateVital$1.$hr));
        telemetryManager2 = inputReadingsViewModel$simulateVital$1.this$0.telemetryManager;
        telemetryManager2.send(TelemetryModelsKt.toSnapshot(spo2Alert, "SPO2_SIM", inputReadingsViewModel$simulateVital$1.$spo2, hrResult.getPhase()));
        userProfileManager = inputReadingsViewModel$simulateVital$1.this$0.userProfileManager;
        int age = userProfileManager.getAge();
        String result = "Profile Age: " + age + '\n';
        inputReadingsViewModel$simulateVital$1.this$0.setSimulationResult((result + "HR (" + inputReadingsViewModel$simulateVital$1.$hr + " bpm): " + hrAlert.getStatus() + "\nDebug: " + hrAlert.getDebugInfo() + '\n' + hrAlert.getMessage() + "\n\n") + "SpO2 (" + inputReadingsViewModel$simulateVital$1.$spo2 + "%): " + spo2Alert.getStatus() + "\nDebug: " + spo2Alert.getDebugInfo() + '\n' + spo2Alert.getMessage());
        if (hrAlert.getStatus() != AlertStatus.NORMAL) {
            inputReadingsViewModel$simulateVital$1.this$0.checkAndSendAlert("HR Alert: " + hrAlert.getMessage());
        }
        if (spo2Alert.getStatus() != AlertStatus.NORMAL) {
            inputReadingsViewModel$simulateVital$1.this$0.checkAndSendAlert("SpO2 Alert: " + spo2Alert.getMessage());
        }
        return Unit.INSTANCE;
    }
}
