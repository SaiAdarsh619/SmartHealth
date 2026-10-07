package com.example.healthconnect.codelab.telemetry;

import com.example.healthconnect.codelab.logic.AlertStatus;
import com.example.healthconnect.codelab.logic.HealthAlert;
import com.example.healthconnect.codelab.logic.MonitorResult;
import com.example.healthconnect.codelab.logic.SmartHealthMonitor;
import com.example.healthconnect.codelab.logic.SystemPhase;
import java.time.Instant;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TelemetryModels.kt */
@Metadata(m286d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\n"}, m287d2 = {"toSnapshot", "Lcom/example/healthconnect/codelab/telemetry/TelemetrySnapshot;", "Lcom/example/healthconnect/codelab/logic/HealthAlert;", "vitalType", "", "currentValue", "", "phase", "Lcom/example/healthconnect/codelab/logic/SystemPhase;", "Lcom/example/healthconnect/codelab/logic/MonitorResult;", "finished_debug"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes6.dex */
public final class TelemetryModelsKt {
    public static final TelemetrySnapshot toSnapshot(MonitorResult $this$toSnapshot, String vitalType, double currentValue) {
        Intrinsics.checkNotNullParameter($this$toSnapshot, "<this>");
        Intrinsics.checkNotNullParameter(vitalType, "vitalType");
        String instant = Instant.now().toString();
        Intrinsics.checkNotNullExpressionValue(instant, "now().toString()");
        AlertStatus status = $this$toSnapshot.getAlert().getStatus();
        SystemPhase phase = $this$toSnapshot.getPhase();
        String message = $this$toSnapshot.getAlert().getMessage();
        SmartHealthMonitor.Baseline baseline = $this$toSnapshot.getBaseline();
        Integer valueOf = baseline != null ? Integer.valueOf(baseline.getMin()) : null;
        SmartHealthMonitor.Baseline baseline2 = $this$toSnapshot.getBaseline();
        Integer valueOf2 = baseline2 != null ? Integer.valueOf(baseline2.getMax()) : null;
        SmartHealthMonitor.Baseline baseline3 = $this$toSnapshot.getBaseline();
        return new TelemetrySnapshot(instant, vitalType, currentValue, status, phase, message, valueOf, valueOf2, baseline3 != null ? Integer.valueOf(baseline3.getAverage()) : null, null, $this$toSnapshot.getMetrics(), null, 2048, null);
    }

    public static /* synthetic */ TelemetrySnapshot toSnapshot$default(HealthAlert healthAlert, String str, double d, SystemPhase systemPhase, int i, Object obj) {
        if ((i & 4) != 0) {
            systemPhase = SystemPhase.COLD_START;
        }
        return toSnapshot(healthAlert, str, d, systemPhase);
    }

    public static final TelemetrySnapshot toSnapshot(HealthAlert $this$toSnapshot, String vitalType, double currentValue, SystemPhase phase) {
        Intrinsics.checkNotNullParameter($this$toSnapshot, "<this>");
        Intrinsics.checkNotNullParameter(vitalType, "vitalType");
        Intrinsics.checkNotNullParameter(phase, "phase");
        String instant = Instant.now().toString();
        Intrinsics.checkNotNullExpressionValue(instant, "now().toString()");
        return new TelemetrySnapshot(instant, vitalType, currentValue, $this$toSnapshot.getStatus(), phase, $this$toSnapshot.getMessage(), null, null, null, null, MapsKt.mapOf(TuplesKt.m294to("debug", $this$toSnapshot.getDebugInfo())), null, 2048, null);
    }
}
