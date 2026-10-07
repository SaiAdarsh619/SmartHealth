package com.example.healthconnect.codelab.telemetry;

import androidx.health.connect.client.records.Vo2MaxRecord;
import com.example.healthconnect.codelab.data.EmergencyContact;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TelemetryModels.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/example/healthconnect/codelab/telemetry/UserProfileData;", "", "age", "", "conditions", "", "", "", "contacts", "", "Lcom/example/healthconnect/codelab/data/EmergencyContact;", "(ILjava/util/Map;Ljava/util/List;)V", "getAge", "()I", "getConditions", "()Ljava/util/Map;", "getContacts", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "toString", "finished_debug"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UserProfileData {
    public static final int $stable = 8;
    private final int age;
    private final Map<String, Boolean> conditions;
    private final List<EmergencyContact> contacts;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserProfileData copy$default(UserProfileData userProfileData, int i, Map map, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = userProfileData.age;
        }
        if ((i2 & 2) != 0) {
            map = userProfileData.conditions;
        }
        if ((i2 & 4) != 0) {
            list = userProfileData.contacts;
        }
        return userProfileData.copy(i, map, list);
    }

    public final int component1() {
        return this.age;
    }

    public final Map<String, Boolean> component2() {
        return this.conditions;
    }

    public final List<EmergencyContact> component3() {
        return this.contacts;
    }

    public final UserProfileData copy(int i, Map<String, Boolean> conditions, List<EmergencyContact> contacts) {
        Intrinsics.checkNotNullParameter(conditions, "conditions");
        Intrinsics.checkNotNullParameter(contacts, "contacts");
        return new UserProfileData(i, conditions, contacts);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserProfileData) {
            UserProfileData userProfileData = (UserProfileData) obj;
            return this.age == userProfileData.age && Intrinsics.areEqual(this.conditions, userProfileData.conditions) && Intrinsics.areEqual(this.contacts, userProfileData.contacts);
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.age) * 31) + this.conditions.hashCode()) * 31) + this.contacts.hashCode();
    }

    public String toString() {
        return "UserProfileData(age=" + this.age + ", conditions=" + this.conditions + ", contacts=" + this.contacts + ')';
    }

    public UserProfileData(int age, Map<String, Boolean> conditions, List<EmergencyContact> contacts) {
        Intrinsics.checkNotNullParameter(conditions, "conditions");
        Intrinsics.checkNotNullParameter(contacts, "contacts");
        this.age = age;
        this.conditions = conditions;
        this.contacts = contacts;
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
}
