package com.example.healthconnect.codelab.presentation.model;

import androidx.health.connect.client.records.Vo2MaxRecord;
import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: VitalUiModel.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/example/healthconnect/codelab/presentation/model/VitalUiModel;", "", "type", "Lcom/example/healthconnect/codelab/presentation/model/VitalType;", "value", "", "time", "Ljava/time/Instant;", "(Lcom/example/healthconnect/codelab/presentation/model/VitalType;Ljava/lang/String;Ljava/time/Instant;)V", "getTime", "()Ljava/time/Instant;", "getType", "()Lcom/example/healthconnect/codelab/presentation/model/VitalType;", "getValue", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "toString", "finished_debug"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VitalUiModel {
    public static final int $stable = 8;
    private final Instant time;
    private final VitalType type;
    private final String value;

    public static /* synthetic */ VitalUiModel copy$default(VitalUiModel vitalUiModel, VitalType vitalType, String str, Instant instant, int i, Object obj) {
        if ((i & 1) != 0) {
            vitalType = vitalUiModel.type;
        }
        if ((i & 2) != 0) {
            str = vitalUiModel.value;
        }
        if ((i & 4) != 0) {
            instant = vitalUiModel.time;
        }
        return vitalUiModel.copy(vitalType, str, instant);
    }

    public final VitalType component1() {
        return this.type;
    }

    public final String component2() {
        return this.value;
    }

    public final Instant component3() {
        return this.time;
    }

    public final VitalUiModel copy(VitalType type, String value, Instant time) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(time, "time");
        return new VitalUiModel(type, value, time);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VitalUiModel) {
            VitalUiModel vitalUiModel = (VitalUiModel) obj;
            return this.type == vitalUiModel.type && Intrinsics.areEqual(this.value, vitalUiModel.value) && Intrinsics.areEqual(this.time, vitalUiModel.time);
        }
        return false;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.value.hashCode()) * 31) + this.time.hashCode();
    }

    public String toString() {
        return "VitalUiModel(type=" + this.type + ", value=" + this.value + ", time=" + this.time + ')';
    }

    public VitalUiModel(VitalType type, String value, Instant time) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(time, "time");
        this.type = type;
        this.value = value;
        this.time = time;
    }

    public final VitalType getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public final Instant getTime() {
        return this.time;
    }
}
