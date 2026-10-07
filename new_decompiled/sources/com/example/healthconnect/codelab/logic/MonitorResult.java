package com.example.healthconnect.codelab.logic;

import androidx.health.connect.client.records.Vo2MaxRecord;
import com.example.healthconnect.codelab.logic.SmartHealthMonitor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SmartHealthMonitor.kt */
@Metadata(m286d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, m287d2 = {"Lcom/example/healthconnect/codelab/logic/MonitorResult;", "", "alert", "Lcom/example/healthconnect/codelab/logic/HealthAlert;", "baseline", "Lcom/example/healthconnect/codelab/logic/SmartHealthMonitor$Baseline;", "phase", "Lcom/example/healthconnect/codelab/logic/SystemPhase;", "metrics", "", "", "(Lcom/example/healthconnect/codelab/logic/HealthAlert;Lcom/example/healthconnect/codelab/logic/SmartHealthMonitor$Baseline;Lcom/example/healthconnect/codelab/logic/SystemPhase;Ljava/util/Map;)V", "getAlert", "()Lcom/example/healthconnect/codelab/logic/HealthAlert;", "getBaseline", "()Lcom/example/healthconnect/codelab/logic/SmartHealthMonitor$Baseline;", "getMetrics", "()Ljava/util/Map;", "getPhase", "()Lcom/example/healthconnect/codelab/logic/SystemPhase;", "component1", "component2", "component3", "component4", "copy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "toString", "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MonitorResult {
    public static final int $stable = 8;
    private final HealthAlert alert;
    private final SmartHealthMonitor.Baseline baseline;
    private final Map<String, Object> metrics;
    private final SystemPhase phase;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MonitorResult copy$default(MonitorResult monitorResult, HealthAlert healthAlert, SmartHealthMonitor.Baseline baseline, SystemPhase systemPhase, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            healthAlert = monitorResult.alert;
        }
        if ((i & 2) != 0) {
            baseline = monitorResult.baseline;
        }
        if ((i & 4) != 0) {
            systemPhase = monitorResult.phase;
        }
        if ((i & 8) != 0) {
            map = monitorResult.metrics;
        }
        return monitorResult.copy(healthAlert, baseline, systemPhase, map);
    }

    /* renamed from: component1, reason: from getter */
    public final HealthAlert getAlert() {
        return this.alert;
    }

    /* renamed from: component2, reason: from getter */
    public final SmartHealthMonitor.Baseline getBaseline() {
        return this.baseline;
    }

    /* renamed from: component3, reason: from getter */
    public final SystemPhase getPhase() {
        return this.phase;
    }

    public final Map<String, Object> component4() {
        return this.metrics;
    }

    public final MonitorResult copy(HealthAlert alert, SmartHealthMonitor.Baseline baseline, SystemPhase phase, Map<String, ? extends Object> metrics) {
        Intrinsics.checkNotNullParameter(alert, "alert");
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        return new MonitorResult(alert, baseline, phase, metrics);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MonitorResult)) {
            return false;
        }
        MonitorResult monitorResult = (MonitorResult) other;
        return Intrinsics.areEqual(this.alert, monitorResult.alert) && Intrinsics.areEqual(this.baseline, monitorResult.baseline) && this.phase == monitorResult.phase && Intrinsics.areEqual(this.metrics, monitorResult.metrics);
    }

    public int hashCode() {
        return (((((this.alert.hashCode() * 31) + (this.baseline == null ? 0 : this.baseline.hashCode())) * 31) + this.phase.hashCode()) * 31) + this.metrics.hashCode();
    }

    public String toString() {
        return "MonitorResult(alert=" + this.alert + ", baseline=" + this.baseline + ", phase=" + this.phase + ", metrics=" + this.metrics + ')';
    }

    public MonitorResult(HealthAlert alert, SmartHealthMonitor.Baseline baseline, SystemPhase phase, Map<String, ? extends Object> metrics) {
        Intrinsics.checkNotNullParameter(alert, "alert");
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        this.alert = alert;
        this.baseline = baseline;
        this.phase = phase;
        this.metrics = metrics;
    }

    public final HealthAlert getAlert() {
        return this.alert;
    }

    public final SmartHealthMonitor.Baseline getBaseline() {
        return this.baseline;
    }

    public final SystemPhase getPhase() {
        return this.phase;
    }

    public final Map<String, Object> getMetrics() {
        return this.metrics;
    }
}
