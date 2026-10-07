package com.example.healthconnect.codelab.data;

import androidx.autofill.HintConstants;
import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EmergencyContact.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/example/healthconnect/codelab/data/EmergencyContact;", "", "id", "", HintConstants.AUTOFILL_HINT_NAME, HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getPhoneNumber", "component1", "component2", "component3", "copy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "toString", "finished_debug"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class EmergencyContact {
    public static final int $stable = 0;
    private final String id;
    private final String name;
    private final String phoneNumber;

    public static /* synthetic */ EmergencyContact copy$default(EmergencyContact emergencyContact, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emergencyContact.id;
        }
        if ((i & 2) != 0) {
            str2 = emergencyContact.name;
        }
        if ((i & 4) != 0) {
            str3 = emergencyContact.phoneNumber;
        }
        return emergencyContact.copy(str, str2, str3);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.phoneNumber;
    }

    public final EmergencyContact copy(String id, String name, String phoneNumber) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        return new EmergencyContact(id, name, phoneNumber);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EmergencyContact) {
            EmergencyContact emergencyContact = (EmergencyContact) obj;
            return Intrinsics.areEqual(this.id, emergencyContact.id) && Intrinsics.areEqual(this.name, emergencyContact.name) && Intrinsics.areEqual(this.phoneNumber, emergencyContact.phoneNumber);
        }
        return false;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.phoneNumber.hashCode();
    }

    public String toString() {
        return "EmergencyContact(id=" + this.id + ", name=" + this.name + ", phoneNumber=" + this.phoneNumber + ')';
    }

    public EmergencyContact(String id, String name, String phoneNumber) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }
}
