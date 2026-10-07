package com.example.healthconnect.codelab.telemetry;

import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import androidx.health.connect.client.records.Vo2MaxRecord;
import com.example.healthconnect.codelab.data.EmergencyContact;
import com.example.healthconnect.codelab.logic.AlertStatus;
import com.example.healthconnect.codelab.logic.SystemPhase;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: TelemetryModels.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0015\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0012HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00106\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00107\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u009c\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\rHÖ\u0001J\u0006\u0010>\u001a\u00020\u0003J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#¨\u0006@"}, d2 = {"Lcom/example/healthconnect/codelab/telemetry/TelemetrySnapshot;", "", "timestamp", "", "vitalType", "currentValue", "", "alertStatus", "Lcom/example/healthconnect/codelab/logic/AlertStatus;", "systemPhase", "Lcom/example/healthconnect/codelab/logic/SystemPhase;", "decisionMessage", "baselineMin", "", "baselineMax", "baselineAvg", "anomalyScore", "meta", "", "userProfile", "Lcom/example/healthconnect/codelab/telemetry/UserProfileData;", "(Ljava/lang/String;Ljava/lang/String;DLcom/example/healthconnect/codelab/logic/AlertStatus;Lcom/example/healthconnect/codelab/logic/SystemPhase;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/util/Map;Lcom/example/healthconnect/codelab/telemetry/UserProfileData;)V", "getAlertStatus", "()Lcom/example/healthconnect/codelab/logic/AlertStatus;", "getAnomalyScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getBaselineAvg", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBaselineMax", "getBaselineMin", "getCurrentValue", "()D", "getDecisionMessage", "()Ljava/lang/String;", "getMeta", "()Ljava/util/Map;", "getSystemPhase", "()Lcom/example/healthconnect/codelab/logic/SystemPhase;", "getTimestamp", "getUserProfile", "()Lcom/example/healthconnect/codelab/telemetry/UserProfileData;", "getVitalType", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;DLcom/example/healthconnect/codelab/logic/AlertStatus;Lcom/example/healthconnect/codelab/logic/SystemPhase;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/util/Map;Lcom/example/healthconnect/codelab/telemetry/UserProfileData;)Lcom/example/healthconnect/codelab/telemetry/TelemetrySnapshot;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "toJson", "toString", "finished_debug"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TelemetrySnapshot {
    public static final int $stable = 8;
    private final AlertStatus alertStatus;
    private final Double anomalyScore;
    private final Integer baselineAvg;
    private final Integer baselineMax;
    private final Integer baselineMin;
    private final double currentValue;
    private final String decisionMessage;
    private final Map<String, Object> meta;
    private final SystemPhase systemPhase;
    private final String timestamp;
    private final UserProfileData userProfile;
    private final String vitalType;

    public final String component1() {
        return this.timestamp;
    }

    public final Double component10() {
        return this.anomalyScore;
    }

    public final Map<String, Object> component11() {
        return this.meta;
    }

    public final UserProfileData component12() {
        return this.userProfile;
    }

    public final String component2() {
        return this.vitalType;
    }

    public final double component3() {
        return this.currentValue;
    }

    public final AlertStatus component4() {
        return this.alertStatus;
    }

    public final SystemPhase component5() {
        return this.systemPhase;
    }

    public final String component6() {
        return this.decisionMessage;
    }

    public final Integer component7() {
        return this.baselineMin;
    }

    public final Integer component8() {
        return this.baselineMax;
    }

    public final Integer component9() {
        return this.baselineAvg;
    }

    public final TelemetrySnapshot copy(String timestamp, String vitalType, double d, AlertStatus alertStatus, SystemPhase systemPhase, String decisionMessage, Integer num, Integer num2, Integer num3, Double d2, Map<String, ? extends Object> meta, UserProfileData userProfileData) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(vitalType, "vitalType");
        Intrinsics.checkNotNullParameter(alertStatus, "alertStatus");
        Intrinsics.checkNotNullParameter(systemPhase, "systemPhase");
        Intrinsics.checkNotNullParameter(decisionMessage, "decisionMessage");
        Intrinsics.checkNotNullParameter(meta, "meta");
        return new TelemetrySnapshot(timestamp, vitalType, d, alertStatus, systemPhase, decisionMessage, num, num2, num3, d2, meta, userProfileData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TelemetrySnapshot) {
            TelemetrySnapshot telemetrySnapshot = (TelemetrySnapshot) obj;
            return Intrinsics.areEqual(this.timestamp, telemetrySnapshot.timestamp) && Intrinsics.areEqual(this.vitalType, telemetrySnapshot.vitalType) && Double.compare(this.currentValue, telemetrySnapshot.currentValue) == 0 && this.alertStatus == telemetrySnapshot.alertStatus && this.systemPhase == telemetrySnapshot.systemPhase && Intrinsics.areEqual(this.decisionMessage, telemetrySnapshot.decisionMessage) && Intrinsics.areEqual(this.baselineMin, telemetrySnapshot.baselineMin) && Intrinsics.areEqual(this.baselineMax, telemetrySnapshot.baselineMax) && Intrinsics.areEqual(this.baselineAvg, telemetrySnapshot.baselineAvg) && Intrinsics.areEqual((Object) this.anomalyScore, (Object) telemetrySnapshot.anomalyScore) && Intrinsics.areEqual(this.meta, telemetrySnapshot.meta) && Intrinsics.areEqual(this.userProfile, telemetrySnapshot.userProfile);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.timestamp.hashCode() * 31) + this.vitalType.hashCode()) * 31) + Double.hashCode(this.currentValue)) * 31) + this.alertStatus.hashCode()) * 31) + this.systemPhase.hashCode()) * 31) + this.decisionMessage.hashCode()) * 31) + (this.baselineMin == null ? 0 : this.baselineMin.hashCode())) * 31) + (this.baselineMax == null ? 0 : this.baselineMax.hashCode())) * 31) + (this.baselineAvg == null ? 0 : this.baselineAvg.hashCode())) * 31) + (this.anomalyScore == null ? 0 : this.anomalyScore.hashCode())) * 31) + this.meta.hashCode()) * 31) + (this.userProfile != null ? this.userProfile.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TelemetrySnapshot(timestamp=").append(this.timestamp).append(", vitalType=").append(this.vitalType).append(", currentValue=").append(this.currentValue).append(", alertStatus=").append(this.alertStatus).append(", systemPhase=").append(this.systemPhase).append(", decisionMessage=").append(this.decisionMessage).append(", baselineMin=").append(this.baselineMin).append(", baselineMax=").append(this.baselineMax).append(", baselineAvg=").append(this.baselineAvg).append(", anomalyScore=").append(this.anomalyScore).append(", meta=").append(this.meta).append(", userProfile=");
        sb.append(this.userProfile).append(')');
        return sb.toString();
    }

    public TelemetrySnapshot(String timestamp, String vitalType, double currentValue, AlertStatus alertStatus, SystemPhase systemPhase, String decisionMessage, Integer baselineMin, Integer baselineMax, Integer baselineAvg, Double anomalyScore, Map<String, ? extends Object> meta, UserProfileData userProfile) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(vitalType, "vitalType");
        Intrinsics.checkNotNullParameter(alertStatus, "alertStatus");
        Intrinsics.checkNotNullParameter(systemPhase, "systemPhase");
        Intrinsics.checkNotNullParameter(decisionMessage, "decisionMessage");
        Intrinsics.checkNotNullParameter(meta, "meta");
        this.timestamp = timestamp;
        this.vitalType = vitalType;
        this.currentValue = currentValue;
        this.alertStatus = alertStatus;
        this.systemPhase = systemPhase;
        this.decisionMessage = decisionMessage;
        this.baselineMin = baselineMin;
        this.baselineMax = baselineMax;
        this.baselineAvg = baselineAvg;
        this.anomalyScore = anomalyScore;
        this.meta = meta;
        this.userProfile = userProfile;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ TelemetrySnapshot(java.lang.String r16, java.lang.String r17, double r18, com.example.healthconnect.codelab.logic.AlertStatus r20, com.example.healthconnect.codelab.logic.SystemPhase r21, java.lang.String r22, java.lang.Integer r23, java.lang.Integer r24, java.lang.Integer r25, java.lang.Double r26, java.util.Map r27, com.example.healthconnect.codelab.telemetry.UserProfileData r28, int r29, kotlin.jvm.internal.DefaultConstructorMarker r30) {
        /*
            r15 = this;
            r0 = r29
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L9
            r0 = 0
            r14 = r0
            goto Lb
        L9:
            r14 = r28
        Lb:
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            r6 = r20
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            r11 = r25
            r12 = r26
            r13 = r27
            r1.<init>(r2, r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.healthconnect.codelab.telemetry.TelemetrySnapshot.<init>(java.lang.String, java.lang.String, double, com.example.healthconnect.codelab.logic.AlertStatus, com.example.healthconnect.codelab.logic.SystemPhase, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Double, java.util.Map, com.example.healthconnect.codelab.telemetry.UserProfileData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final String getVitalType() {
        return this.vitalType;
    }

    public final double getCurrentValue() {
        return this.currentValue;
    }

    public final AlertStatus getAlertStatus() {
        return this.alertStatus;
    }

    public final SystemPhase getSystemPhase() {
        return this.systemPhase;
    }

    public final String getDecisionMessage() {
        return this.decisionMessage;
    }

    public final Integer getBaselineMin() {
        return this.baselineMin;
    }

    public final Integer getBaselineMax() {
        return this.baselineMax;
    }

    public final Integer getBaselineAvg() {
        return this.baselineAvg;
    }

    public final Double getAnomalyScore() {
        return this.anomalyScore;
    }

    public final Map<String, Object> getMeta() {
        return this.meta;
    }

    public final UserProfileData getUserProfile() {
        return this.userProfile;
    }

    public final String toJson() {
        JSONObject json = new JSONObject();
        json.put("timestamp", this.timestamp);
        json.put("vital_type", this.vitalType);
        json.put("value", this.currentValue);
        json.put(NotificationCompat.CATEGORY_STATUS, this.alertStatus.name());
        json.put("phase", this.systemPhase.name());
        json.put("decision", this.decisionMessage);
        Integer num = this.baselineMin;
        if (num != null) {
            int it = num.intValue();
            json.put("baseline_min", it);
        }
        Integer num2 = this.baselineMax;
        if (num2 != null) {
            int it2 = num2.intValue();
            json.put("baseline_max", it2);
        }
        Integer num3 = this.baselineAvg;
        if (num3 != null) {
            int it3 = num3.intValue();
            json.put("baseline_avg", it3);
        }
        JSONObject metaJson = new JSONObject();
        Map $this$forEach$iv = this.meta;
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            String k = element$iv.getKey();
            Object v = element$iv.getValue();
            metaJson.put(k, v);
        }
        json.put("meta", metaJson);
        UserProfileData profile = this.userProfile;
        if (profile != null) {
            JSONObject profileJson = new JSONObject();
            profileJson.put("age", profile.getAge());
            JSONObject condJson = new JSONObject();
            Map $this$forEach$iv2 = profile.getConditions();
            for (Map.Entry element$iv2 : $this$forEach$iv2.entrySet()) {
                String k2 = element$iv2.getKey();
                boolean v2 = element$iv2.getValue().booleanValue();
                condJson.put(k2, v2);
            }
            profileJson.put("conditions", condJson);
            JSONArray contactsArray = new JSONArray();
            Iterable<EmergencyContact> $this$forEach$iv3 = profile.getContacts();
            for (EmergencyContact contact : $this$forEach$iv3) {
                JSONObject c = new JSONObject();
                c.put(HintConstants.AUTOFILL_HINT_NAME, contact.getName());
                c.put(HintConstants.AUTOFILL_HINT_PHONE, contact.getPhoneNumber());
                contactsArray.put(c);
            }
            profileJson.put("contacts", contactsArray);
            json.put("user_profile", profileJson);
        }
        String jSONObject = json.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "json.toString()");
        return jSONObject;
    }
}
