package com.example.healthconnect.codelab.data;

import androidx.health.connect.client.records.HeartRateRecord;
import androidx.health.connect.client.records.SpeedRecord;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.units.Energy;
import androidx.health.connect.client.units.Length;
import androidx.health.connect.client.units.Velocity;
import com.example.healthconnect.codelab.presentation.navigation.ScreenKt;
import java.time.Duration;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExerciseSessionData.kt */
@Metadata(m286d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0013\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0010¢\u0006\u0002\u0010\u0018J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00170\u0010HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00105\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J°\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0010HÆ\u0001¢\u0006\u0002\u0010<J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b \u0010\u001aR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\"\u0010\u001aR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0010¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b+\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006C"}, m287d2 = {"Lcom/example/healthconnect/codelab/data/ExerciseSessionData;", "", ScreenKt.UID_NAV_ARGUMENT, "", "totalActiveTime", "Ljava/time/Duration;", "totalSteps", "", "totalDistance", "Landroidx/health/connect/client/units/Length;", "totalEnergyBurned", "Landroidx/health/connect/client/units/Energy;", "minHeartRate", "maxHeartRate", "avgHeartRate", "heartRateSeries", "", "Landroidx/health/connect/client/records/HeartRateRecord;", "minSpeed", "Landroidx/health/connect/client/units/Velocity;", "maxSpeed", "avgSpeed", "speedRecord", "Landroidx/health/connect/client/records/SpeedRecord;", "(Ljava/lang/String;Ljava/time/Duration;Ljava/lang/Long;Landroidx/health/connect/client/units/Length;Landroidx/health/connect/client/units/Energy;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Landroidx/health/connect/client/units/Velocity;Landroidx/health/connect/client/units/Velocity;Landroidx/health/connect/client/units/Velocity;Ljava/util/List;)V", "getAvgHeartRate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAvgSpeed", "()Landroidx/health/connect/client/units/Velocity;", "getHeartRateSeries", "()Ljava/util/List;", "getMaxHeartRate", "getMaxSpeed", "getMinHeartRate", "getMinSpeed", "getSpeedRecord", "getTotalActiveTime", "()Ljava/time/Duration;", "getTotalDistance", "()Landroidx/health/connect/client/units/Length;", "getTotalEnergyBurned", "()Landroidx/health/connect/client/units/Energy;", "getTotalSteps", "getUid", "()Ljava/lang/String;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/time/Duration;Ljava/lang/Long;Landroidx/health/connect/client/units/Length;Landroidx/health/connect/client/units/Energy;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Landroidx/health/connect/client/units/Velocity;Landroidx/health/connect/client/units/Velocity;Landroidx/health/connect/client/units/Velocity;Ljava/util/List;)Lcom/example/healthconnect/codelab/data/ExerciseSessionData;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "toString", "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class ExerciseSessionData {
    public static final int $stable = 8;
    private final Long avgHeartRate;
    private final Velocity avgSpeed;
    private final List<HeartRateRecord> heartRateSeries;
    private final Long maxHeartRate;
    private final Velocity maxSpeed;
    private final Long minHeartRate;
    private final Velocity minSpeed;
    private final List<SpeedRecord> speedRecord;
    private final Duration totalActiveTime;
    private final Length totalDistance;
    private final Energy totalEnergyBurned;
    private final Long totalSteps;
    private final String uid;

    /* renamed from: component1, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    /* renamed from: component10, reason: from getter */
    public final Velocity getMinSpeed() {
        return this.minSpeed;
    }

    /* renamed from: component11, reason: from getter */
    public final Velocity getMaxSpeed() {
        return this.maxSpeed;
    }

    /* renamed from: component12, reason: from getter */
    public final Velocity getAvgSpeed() {
        return this.avgSpeed;
    }

    public final List<SpeedRecord> component13() {
        return this.speedRecord;
    }

    /* renamed from: component2, reason: from getter */
    public final Duration getTotalActiveTime() {
        return this.totalActiveTime;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getTotalSteps() {
        return this.totalSteps;
    }

    /* renamed from: component4, reason: from getter */
    public final Length getTotalDistance() {
        return this.totalDistance;
    }

    /* renamed from: component5, reason: from getter */
    public final Energy getTotalEnergyBurned() {
        return this.totalEnergyBurned;
    }

    /* renamed from: component6, reason: from getter */
    public final Long getMinHeartRate() {
        return this.minHeartRate;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getMaxHeartRate() {
        return this.maxHeartRate;
    }

    /* renamed from: component8, reason: from getter */
    public final Long getAvgHeartRate() {
        return this.avgHeartRate;
    }

    public final List<HeartRateRecord> component9() {
        return this.heartRateSeries;
    }

    public final ExerciseSessionData copy(String uid, Duration totalActiveTime, Long totalSteps, Length totalDistance, Energy totalEnergyBurned, Long minHeartRate, Long maxHeartRate, Long avgHeartRate, List<HeartRateRecord> heartRateSeries, Velocity minSpeed, Velocity maxSpeed, Velocity avgSpeed, List<SpeedRecord> speedRecord) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(heartRateSeries, "heartRateSeries");
        Intrinsics.checkNotNullParameter(speedRecord, "speedRecord");
        return new ExerciseSessionData(uid, totalActiveTime, totalSteps, totalDistance, totalEnergyBurned, minHeartRate, maxHeartRate, avgHeartRate, heartRateSeries, minSpeed, maxSpeed, avgSpeed, speedRecord);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExerciseSessionData)) {
            return false;
        }
        ExerciseSessionData exerciseSessionData = (ExerciseSessionData) other;
        return Intrinsics.areEqual(this.uid, exerciseSessionData.uid) && Intrinsics.areEqual(this.totalActiveTime, exerciseSessionData.totalActiveTime) && Intrinsics.areEqual(this.totalSteps, exerciseSessionData.totalSteps) && Intrinsics.areEqual(this.totalDistance, exerciseSessionData.totalDistance) && Intrinsics.areEqual(this.totalEnergyBurned, exerciseSessionData.totalEnergyBurned) && Intrinsics.areEqual(this.minHeartRate, exerciseSessionData.minHeartRate) && Intrinsics.areEqual(this.maxHeartRate, exerciseSessionData.maxHeartRate) && Intrinsics.areEqual(this.avgHeartRate, exerciseSessionData.avgHeartRate) && Intrinsics.areEqual(this.heartRateSeries, exerciseSessionData.heartRateSeries) && Intrinsics.areEqual(this.minSpeed, exerciseSessionData.minSpeed) && Intrinsics.areEqual(this.maxSpeed, exerciseSessionData.maxSpeed) && Intrinsics.areEqual(this.avgSpeed, exerciseSessionData.avgSpeed) && Intrinsics.areEqual(this.speedRecord, exerciseSessionData.speedRecord);
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.uid.hashCode() * 31) + (this.totalActiveTime == null ? 0 : this.totalActiveTime.hashCode())) * 31) + (this.totalSteps == null ? 0 : this.totalSteps.hashCode())) * 31) + (this.totalDistance == null ? 0 : this.totalDistance.hashCode())) * 31) + (this.totalEnergyBurned == null ? 0 : this.totalEnergyBurned.hashCode())) * 31) + (this.minHeartRate == null ? 0 : this.minHeartRate.hashCode())) * 31) + (this.maxHeartRate == null ? 0 : this.maxHeartRate.hashCode())) * 31) + (this.avgHeartRate == null ? 0 : this.avgHeartRate.hashCode())) * 31) + this.heartRateSeries.hashCode()) * 31) + (this.minSpeed == null ? 0 : this.minSpeed.hashCode())) * 31) + (this.maxSpeed == null ? 0 : this.maxSpeed.hashCode())) * 31) + (this.avgSpeed != null ? this.avgSpeed.hashCode() : 0)) * 31) + this.speedRecord.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExerciseSessionData(uid=").append(this.uid).append(", totalActiveTime=").append(this.totalActiveTime).append(", totalSteps=").append(this.totalSteps).append(", totalDistance=").append(this.totalDistance).append(", totalEnergyBurned=").append(this.totalEnergyBurned).append(", minHeartRate=").append(this.minHeartRate).append(", maxHeartRate=").append(this.maxHeartRate).append(", avgHeartRate=").append(this.avgHeartRate).append(", heartRateSeries=").append(this.heartRateSeries).append(", minSpeed=").append(this.minSpeed).append(", maxSpeed=").append(this.maxSpeed).append(", avgSpeed=");
        sb.append(this.avgSpeed).append(", speedRecord=").append(this.speedRecord).append(')');
        return sb.toString();
    }

    public ExerciseSessionData(String uid, Duration totalActiveTime, Long totalSteps, Length totalDistance, Energy totalEnergyBurned, Long minHeartRate, Long maxHeartRate, Long avgHeartRate, List<HeartRateRecord> heartRateSeries, Velocity minSpeed, Velocity maxSpeed, Velocity avgSpeed, List<SpeedRecord> speedRecord) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(heartRateSeries, "heartRateSeries");
        Intrinsics.checkNotNullParameter(speedRecord, "speedRecord");
        this.uid = uid;
        this.totalActiveTime = totalActiveTime;
        this.totalSteps = totalSteps;
        this.totalDistance = totalDistance;
        this.totalEnergyBurned = totalEnergyBurned;
        this.minHeartRate = minHeartRate;
        this.maxHeartRate = maxHeartRate;
        this.avgHeartRate = avgHeartRate;
        this.heartRateSeries = heartRateSeries;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.avgSpeed = avgSpeed;
        this.speedRecord = speedRecord;
    }

    public /* synthetic */ ExerciseSessionData(String str, Duration duration, Long l, Length length, Energy energy, Long l2, Long l3, Long l4, List list, Velocity velocity, Velocity velocity2, Velocity velocity3, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : duration, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : length, (i & 16) != 0 ? null : energy, (i & 32) != 0 ? null : l2, (i & 64) != 0 ? null : l3, (i & 128) != 0 ? null : l4, (i & 256) != 0 ? CollectionsKt.emptyList() : list, (i & 512) != 0 ? null : velocity, (i & 1024) != 0 ? null : velocity2, (i & 2048) == 0 ? velocity3 : null, (i & 4096) != 0 ? CollectionsKt.emptyList() : list2);
    }

    public final String getUid() {
        return this.uid;
    }

    public final Duration getTotalActiveTime() {
        return this.totalActiveTime;
    }

    public final Long getTotalSteps() {
        return this.totalSteps;
    }

    public final Length getTotalDistance() {
        return this.totalDistance;
    }

    public final Energy getTotalEnergyBurned() {
        return this.totalEnergyBurned;
    }

    public final Long getMinHeartRate() {
        return this.minHeartRate;
    }

    public final Long getMaxHeartRate() {
        return this.maxHeartRate;
    }

    public final Long getAvgHeartRate() {
        return this.avgHeartRate;
    }

    public final List<HeartRateRecord> getHeartRateSeries() {
        return this.heartRateSeries;
    }

    public final Velocity getMinSpeed() {
        return this.minSpeed;
    }

    public final Velocity getMaxSpeed() {
        return this.maxSpeed;
    }

    public final Velocity getAvgSpeed() {
        return this.avgSpeed;
    }

    public final List<SpeedRecord> getSpeedRecord() {
        return this.speedRecord;
    }
}
