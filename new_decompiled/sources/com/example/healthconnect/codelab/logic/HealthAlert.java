package com.example.healthconnect.codelab.logic;

import androidx.core.app.NotificationCompat;
import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SmartHealthMonitor.kt */
@Metadata(m286d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m287d2 = {"Lcom/example/healthconnect/codelab/logic/HealthAlert;", "", NotificationCompat.CATEGORY_STATUS, "Lcom/example/healthconnect/codelab/logic/AlertStatus;", "message", "", "debugInfo", "(Lcom/example/healthconnect/codelab/logic/AlertStatus;Ljava/lang/String;Ljava/lang/String;)V", "getDebugInfo", "()Ljava/lang/String;", "getMessage", "getStatus", "()Lcom/example/healthconnect/codelab/logic/AlertStatus;", "component1", "component2", "component3", "copy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "toString", "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class HealthAlert {
    public static final int $stable = 0;
    private final String debugInfo;
    private final String message;
    private final AlertStatus status;

    public static /* synthetic */ HealthAlert copy$default(HealthAlert healthAlert, AlertStatus alertStatus, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            alertStatus = healthAlert.status;
        }
        if ((i & 2) != 0) {
            str = healthAlert.message;
        }
        if ((i & 4) != 0) {
            str2 = healthAlert.debugInfo;
        }
        return healthAlert.copy(alertStatus, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final AlertStatus getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDebugInfo() {
        return this.debugInfo;
    }

    public final HealthAlert copy(AlertStatus status, String message, String debugInfo) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(debugInfo, "debugInfo");
        return new HealthAlert(status, message, debugInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HealthAlert)) {
            return false;
        }
        HealthAlert healthAlert = (HealthAlert) other;
        return this.status == healthAlert.status && Intrinsics.areEqual(this.message, healthAlert.message) && Intrinsics.areEqual(this.debugInfo, healthAlert.debugInfo);
    }

    public int hashCode() {
        return (((this.status.hashCode() * 31) + this.message.hashCode()) * 31) + this.debugInfo.hashCode();
    }

    public String toString() {
        return "HealthAlert(status=" + this.status + ", message=" + this.message + ", debugInfo=" + this.debugInfo + ')';
    }

    public HealthAlert(AlertStatus status, String message, String debugInfo) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(debugInfo, "debugInfo");
        this.status = status;
        this.message = message;
        this.debugInfo = debugInfo;
    }

    public /* synthetic */ HealthAlert(AlertStatus alertStatus, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(alertStatus, str, (i & 4) != 0 ? "" : str2);
    }

    public final AlertStatus getStatus() {
        return this.status;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getDebugInfo() {
        return this.debugInfo;
    }
}
