package androidx.health.connect.client.records;

import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.units.Mass;
import androidx.health.connect.client.units.Power;
import androidx.health.connect.client.units.Velocity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExercisePerformanceTarget.kt */
@Metadata(m286d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b&\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0000¢\u0006\u0002\u0010\u0002¨\u0006\u000b"}, m287d2 = {"Landroidx/health/connect/client/records/ExercisePerformanceTarget;", "", "()V", "AmrapTarget", "CadenceTarget", "HeartRateTarget", "PowerTarget", "RateOfPerceivedExertionTarget", "SpeedTarget", "UnknownTarget", "WeightTarget", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public abstract class ExercisePerformanceTarget {

    /* compiled from: ExercisePerformanceTarget.kt */
    @Metadata(m286d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0011"}, m287d2 = {"Landroidx/health/connect/client/records/ExercisePerformanceTarget$PowerTarget;", "Landroidx/health/connect/client/records/ExercisePerformanceTarget;", "minPower", "Landroidx/health/connect/client/units/Power;", "maxPower", "(Landroidx/health/connect/client/units/Power;Landroidx/health/connect/client/units/Power;)V", "getMaxPower", "()Landroidx/health/connect/client/units/Power;", "getMinPower", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class PowerTarget extends ExercisePerformanceTarget {
        private final Power maxPower;
        private final Power minPower;

        public final Power getMinPower() {
            return this.minPower;
        }

        public final Power getMaxPower() {
            return this.maxPower;
        }

        public PowerTarget(Power minPower, Power maxPower) {
            Intrinsics.checkNotNullParameter(minPower, "minPower");
            Intrinsics.checkNotNullParameter(maxPower, "maxPower");
            this.minPower = minPower;
            this.maxPower = maxPower;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PowerTarget) && Intrinsics.areEqual(this.minPower, ((PowerTarget) other).minPower) && Intrinsics.areEqual(this.maxPower, ((PowerTarget) other).maxPower);
        }

        public int hashCode() {
            int result = this.minPower.hashCode();
            return (result * 31) + this.maxPower.hashCode();
        }

        public String toString() {
            return "PowerTarget(minPower=" + this.minPower + ", maxPower=" + this.maxPower + ')';
        }
    }

    /* compiled from: ExercisePerformanceTarget.kt */
    @Metadata(m286d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0011"}, m287d2 = {"Landroidx/health/connect/client/records/ExercisePerformanceTarget$SpeedTarget;", "Landroidx/health/connect/client/records/ExercisePerformanceTarget;", "minSpeed", "Landroidx/health/connect/client/units/Velocity;", "maxSpeed", "(Landroidx/health/connect/client/units/Velocity;Landroidx/health/connect/client/units/Velocity;)V", "getMaxSpeed", "()Landroidx/health/connect/client/units/Velocity;", "getMinSpeed", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class SpeedTarget extends ExercisePerformanceTarget {
        private final Velocity maxSpeed;
        private final Velocity minSpeed;

        public final Velocity getMinSpeed() {
            return this.minSpeed;
        }

        public final Velocity getMaxSpeed() {
            return this.maxSpeed;
        }

        public SpeedTarget(Velocity minSpeed, Velocity maxSpeed) {
            Intrinsics.checkNotNullParameter(minSpeed, "minSpeed");
            Intrinsics.checkNotNullParameter(maxSpeed, "maxSpeed");
            this.minSpeed = minSpeed;
            this.maxSpeed = maxSpeed;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SpeedTarget) && Intrinsics.areEqual(this.minSpeed, ((SpeedTarget) other).minSpeed) && Intrinsics.areEqual(this.maxSpeed, ((SpeedTarget) other).maxSpeed);
        }

        public int hashCode() {
            int result = this.minSpeed.hashCode();
            return (result * 31) + this.maxSpeed.hashCode();
        }

        public String toString() {
            return "SpeedTarget(minSpeed=" + this.minSpeed + ", maxSpeed=" + this.maxSpeed + ')';
        }
    }

    /* compiled from: ExercisePerformanceTarget.kt */
    @Metadata(m286d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0011"}, m287d2 = {"Landroidx/health/connect/client/records/ExercisePerformanceTarget$CadenceTarget;", "Landroidx/health/connect/client/records/ExercisePerformanceTarget;", "minCadence", "", "maxCadence", "(DD)V", "getMaxCadence", "()D", "getMinCadence", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class CadenceTarget extends ExercisePerformanceTarget {
        private final double maxCadence;
        private final double minCadence;

        public final double getMinCadence() {
            return this.minCadence;
        }

        public final double getMaxCadence() {
            return this.maxCadence;
        }

        public CadenceTarget(double minCadence, double maxCadence) {
            this.minCadence = minCadence;
            this.maxCadence = maxCadence;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CadenceTarget)) {
                return false;
            }
            if (this.minCadence == ((CadenceTarget) other).minCadence) {
                return (this.maxCadence > ((CadenceTarget) other).maxCadence ? 1 : (this.maxCadence == ((CadenceTarget) other).maxCadence ? 0 : -1)) == 0;
            }
            return false;
        }

        public int hashCode() {
            int result = Double.hashCode(this.minCadence);
            return (result * 31) + Double.hashCode(this.maxCadence);
        }

        public String toString() {
            return "CadenceTarget(minCadence=" + this.minCadence + ", maxCadence=" + this.maxCadence + ')';
        }
    }

    /* compiled from: ExercisePerformanceTarget.kt */
    @Metadata(m286d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0011"}, m287d2 = {"Landroidx/health/connect/client/records/ExercisePerformanceTarget$HeartRateTarget;", "Landroidx/health/connect/client/records/ExercisePerformanceTarget;", "minHeartRate", "", "maxHeartRate", "(DD)V", "getMaxHeartRate", "()D", "getMinHeartRate", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class HeartRateTarget extends ExercisePerformanceTarget {
        private final double maxHeartRate;
        private final double minHeartRate;

        public final double getMinHeartRate() {
            return this.minHeartRate;
        }

        public final double getMaxHeartRate() {
            return this.maxHeartRate;
        }

        public HeartRateTarget(double minHeartRate, double maxHeartRate) {
            this.minHeartRate = minHeartRate;
            this.maxHeartRate = maxHeartRate;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HeartRateTarget)) {
                return false;
            }
            if (this.minHeartRate == ((HeartRateTarget) other).minHeartRate) {
                return (this.maxHeartRate > ((HeartRateTarget) other).maxHeartRate ? 1 : (this.maxHeartRate == ((HeartRateTarget) other).maxHeartRate ? 0 : -1)) == 0;
            }
            return false;
        }

        public int hashCode() {
            int result = Double.hashCode(this.minHeartRate);
            return (result * 31) + Double.hashCode(this.maxHeartRate);
        }

        public String toString() {
            return "HeartRateTarget(minHeartRate=" + this.minHeartRate + ", maxHeartRate=" + this.maxHeartRate + ')';
        }
    }

    /* compiled from: ExercisePerformanceTarget.kt */
    @Metadata(m286d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m287d2 = {"Landroidx/health/connect/client/records/ExercisePerformanceTarget$WeightTarget;", "Landroidx/health/connect/client/records/ExercisePerformanceTarget;", "mass", "Landroidx/health/connect/client/units/Mass;", "(Landroidx/health/connect/client/units/Mass;)V", "getMass", "()Landroidx/health/connect/client/units/Mass;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class WeightTarget extends ExercisePerformanceTarget {
        private final Mass mass;

        public final Mass getMass() {
            return this.mass;
        }

        public WeightTarget(Mass mass) {
            Intrinsics.checkNotNullParameter(mass, "mass");
            this.mass = mass;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof WeightTarget) {
                return Intrinsics.areEqual(this.mass, ((WeightTarget) other).mass);
            }
            return false;
        }

        public int hashCode() {
            return this.mass.hashCode();
        }

        public String toString() {
            return "WeightTarget(mass=" + this.mass + ')';
        }
    }

    /* compiled from: ExercisePerformanceTarget.kt */
    @Metadata(m286d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, m287d2 = {"Landroidx/health/connect/client/records/ExercisePerformanceTarget$RateOfPerceivedExertionTarget;", "Landroidx/health/connect/client/records/ExercisePerformanceTarget;", "rpe", "", "(I)V", "getRpe", "()I", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class RateOfPerceivedExertionTarget extends ExercisePerformanceTarget {
        private final int rpe;

        public final int getRpe() {
            return this.rpe;
        }

        public RateOfPerceivedExertionTarget(int rpe) {
            this.rpe = rpe;
            int i = this.rpe;
            boolean z = false;
            if (i >= 0 && i < 11) {
                z = true;
            }
            if (!z) {
                throw new IllegalArgumentException("RPE value must be between 0 and 10, inclusive.".toString());
            }
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RateOfPerceivedExertionTarget) && this.rpe == ((RateOfPerceivedExertionTarget) other).rpe;
        }

        public int hashCode() {
            return Integer.hashCode(this.rpe);
        }

        public String toString() {
            return "RateOfPerceivedExertionTarget(rpe=" + this.rpe + ')';
        }
    }

    /* compiled from: ExercisePerformanceTarget.kt */
    @Metadata(m286d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m287d2 = {"Landroidx/health/connect/client/records/ExercisePerformanceTarget$AmrapTarget;", "Landroidx/health/connect/client/records/ExercisePerformanceTarget;", "()V", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class AmrapTarget extends ExercisePerformanceTarget {
        public static final AmrapTarget INSTANCE = new AmrapTarget();

        private AmrapTarget() {
        }

        public String toString() {
            return "AmrapTarget()";
        }
    }

    /* compiled from: ExercisePerformanceTarget.kt */
    @Metadata(m286d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m287d2 = {"Landroidx/health/connect/client/records/ExercisePerformanceTarget$UnknownTarget;", "Landroidx/health/connect/client/records/ExercisePerformanceTarget;", "()V", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class UnknownTarget extends ExercisePerformanceTarget {
        public static final UnknownTarget INSTANCE = new UnknownTarget();

        private UnknownTarget() {
        }

        public String toString() {
            return "UnknownTarget()";
        }
    }
}
