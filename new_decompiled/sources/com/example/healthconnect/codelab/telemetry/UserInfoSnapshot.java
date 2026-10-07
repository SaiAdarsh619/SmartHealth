package com.example.healthconnect.codelab.telemetry;

import androidx.autofill.HintConstants;
import androidx.health.connect.client.records.Vo2MaxRecord;
import com.example.healthconnect.codelab.data.EmergencyContact;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TelemetryModels.kt */
@Metadata(m286d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u001d\u001a\u00020\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, m287d2 = {"Lcom/example/healthconnect/codelab/telemetry/UserInfoSnapshot;", "", "timestamp", "", "age", "", "conditions", "", "", "contacts", "", "Lcom/example/healthconnect/codelab/data/EmergencyContact;", "(Ljava/lang/String;ILjava/util/Map;Ljava/util/List;)V", "getAge", "()I", "getConditions", "()Ljava/util/Map;", "getContacts", "()Ljava/util/List;", "getTimestamp", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "toJson", "toString", "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class UserInfoSnapshot {
    public static final int $stable = 8;
    private final int age;
    private final Map<String, Boolean> conditions;
    private final List<EmergencyContact> contacts;
    private final String timestamp;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserInfoSnapshot copy$default(UserInfoSnapshot userInfoSnapshot, String str, int i, Map map, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userInfoSnapshot.timestamp;
        }
        if ((i2 & 2) != 0) {
            i = userInfoSnapshot.age;
        }
        if ((i2 & 4) != 0) {
            map = userInfoSnapshot.conditions;
        }
        if ((i2 & 8) != 0) {
            list = userInfoSnapshot.contacts;
        }
        return userInfoSnapshot.copy(str, i, map, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component2, reason: from getter */
    public final int getAge() {
        return this.age;
    }

    public final Map<String, Boolean> component3() {
        return this.conditions;
    }

    public final List<EmergencyContact> component4() {
        return this.contacts;
    }

    public final UserInfoSnapshot copy(String timestamp, int age, Map<String, Boolean> conditions, List<EmergencyContact> contacts) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(conditions, "conditions");
        Intrinsics.checkNotNullParameter(contacts, "contacts");
        return new UserInfoSnapshot(timestamp, age, conditions, contacts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInfoSnapshot)) {
            return false;
        }
        UserInfoSnapshot userInfoSnapshot = (UserInfoSnapshot) other;
        return Intrinsics.areEqual(this.timestamp, userInfoSnapshot.timestamp) && this.age == userInfoSnapshot.age && Intrinsics.areEqual(this.conditions, userInfoSnapshot.conditions) && Intrinsics.areEqual(this.contacts, userInfoSnapshot.contacts);
    }

    public int hashCode() {
        return (((((this.timestamp.hashCode() * 31) + Integer.hashCode(this.age)) * 31) + this.conditions.hashCode()) * 31) + this.contacts.hashCode();
    }

    public String toString() {
        return "UserInfoSnapshot(timestamp=" + this.timestamp + ", age=" + this.age + ", conditions=" + this.conditions + ", contacts=" + this.contacts + ')';
    }

    public UserInfoSnapshot(String timestamp, int age, Map<String, Boolean> conditions, List<EmergencyContact> contacts) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(conditions, "conditions");
        Intrinsics.checkNotNullParameter(contacts, "contacts");
        this.timestamp = timestamp;
        this.age = age;
        this.conditions = conditions;
        this.contacts = contacts;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final int getAge() {
        return this.age;
    }

    public final Map<String, Boolean> getConditions() {
        return this.conditions;
    }

    public final List<EmergencyContact> getContacts() {
        return this.contacts;
    }

    public final String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "USER_INFO");
        jSONObject.put("timestamp", this.timestamp);
        jSONObject.put("age", this.age);
        JSONObject condJson = new JSONObject();
        Map $this$forEach$iv = this.conditions;
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            String k = element$iv.getKey();
            boolean v = element$iv.getValue().booleanValue();
            condJson.put(k, v);
        }
        jSONObject.put("conditions", condJson);
        JSONArray contactsArray = new JSONArray();
        Iterable<EmergencyContact> $this$forEach$iv2 = this.contacts;
        for (EmergencyContact contact : $this$forEach$iv2) {
            JSONObject c = new JSONObject();
            c.put(HintConstants.AUTOFILL_HINT_NAME, contact.getName());
            c.put(HintConstants.AUTOFILL_HINT_PHONE, contact.getPhoneNumber());
            contactsArray.put(c);
        }
        jSONObject.put("contacts", contactsArray);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }
}
