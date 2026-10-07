package androidx.health.connect.client.records;

import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.units.Energy;
import androidx.health.connect.client.units.Length;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExerciseCompletionGoal.kt */
@Metadata(m286d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001:\t\u0003\u0004\u0005\u0006\u0007\b\t\n\u000bB\u0007\b\u0000¢\u0006\u0002\u0010\u0002¨\u0006\f"}, m287d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "", "()V", "ActiveCaloriesBurnedGoal", "DistanceAndDurationGoal", "DistanceGoal", "DurationGoal", "ManualCompletion", "RepetitionsGoal", "StepsGoal", "TotalCaloriesBurnedGoal", "UnknownGoal", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public abstract class ExerciseCompletionGoal {

    /* compiled from: ExerciseCompletionGoal.kt */
    @Metadata(m286d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m287d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal$DistanceGoal;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "distance", "Landroidx/health/connect/client/units/Length;", "(Landroidx/health/connect/client/units/Length;)V", "getDistance", "()Landroidx/health/connect/client/units/Length;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class DistanceGoal extends ExerciseCompletionGoal {
        private final Length distance;

        public final Length getDistance() {
            return this.distance;
        }

        public DistanceGoal(Length distance) {
            Intrinsics.checkNotNullParameter(distance, "distance");
            this.distance = distance;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof DistanceGoal) {
                return Intrinsics.areEqual(this.distance, ((DistanceGoal) other).distance);
            }
            return false;
        }

        public int hashCode() {
            return this.distance.hashCode();
        }

        public String toString() {
            return "DistanceGoal(distance=" + this.distance + ')';
        }
    }

    /* compiled from: ExerciseCompletionGoal.kt */
    @Metadata(m286d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, m287d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal$DistanceAndDurationGoal;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "distance", "Landroidx/health/connect/client/units/Length;", "duration", "Ljava/time/Duration;", "(Landroidx/health/connect/client/units/Length;Ljava/time/Duration;)V", "getDistance", "()Landroidx/health/connect/client/units/Length;", "getDuration", "()Ljava/time/Duration;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class DistanceAndDurationGoal extends ExerciseCompletionGoal {
        private final Length distance;
        private final Duration duration;

        public final Length getDistance() {
            return this.distance;
        }

        public final Duration getDuration() {
            return this.duration;
        }

        public DistanceAndDurationGoal(Length distance, Duration duration) {
            Intrinsics.checkNotNullParameter(distance, "distance");
            Intrinsics.checkNotNullParameter(duration, "duration");
            this.distance = distance;
            this.duration = duration;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof DistanceAndDurationGoal) {
                return Intrinsics.areEqual(this.distance, ((DistanceAndDurationGoal) other).distance) && Intrinsics.areEqual(this.duration, ((DistanceAndDurationGoal) other).duration);
            }
            return false;
        }

        public String toString() {
            return "DistanceAndDurationGoal(distance=" + this.distance + ", duration=" + this.duration + ')';
        }

        public int hashCode() {
            int result = this.distance.hashCode();
            return (result * 31) + this.duration.hashCode();
        }
    }

    /* compiled from: ExerciseCompletionGoal.kt */
    @Metadata(m286d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, m287d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal$StepsGoal;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "steps", "", "(I)V", "getSteps", "()I", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class StepsGoal extends ExerciseCompletionGoal {
        private final int steps;

        public final int getSteps() {
            return this.steps;
        }

        public StepsGoal(int steps) {
            this.steps = steps;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StepsGoal) && this.steps == ((StepsGoal) other).steps;
        }

        public int hashCode() {
            return this.steps;
        }

        public String toString() {
            return "StepsGoal(steps=" + this.steps + ')';
        }
    }

    /* compiled from: ExerciseCompletionGoal.kt */
    @Metadata(m286d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m287d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal$DurationGoal;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "duration", "Ljava/time/Duration;", "(Ljava/time/Duration;)V", "getDuration", "()Ljava/time/Duration;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class DurationGoal extends ExerciseCompletionGoal {
        private final Duration duration;

        public final Duration getDuration() {
            return this.duration;
        }

        public DurationGoal(Duration duration) {
            Intrinsics.checkNotNullParameter(duration, "duration");
            this.duration = duration;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof DurationGoal) {
                return Intrinsics.areEqual(this.duration, ((DurationGoal) other).duration);
            }
            return false;
        }

        public int hashCode() {
            return this.duration.hashCode();
        }

        public String toString() {
            return "DurationGoal(duration=" + this.duration + ')';
        }
    }

    /* compiled from: ExerciseCompletionGoal.kt */
    @Metadata(m286d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, m287d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal$RepetitionsGoal;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "repetitions", "", "(I)V", "getRepetitions", "()I", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class RepetitionsGoal extends ExerciseCompletionGoal {
        private final int repetitions;

        public final int getRepetitions() {
            return this.repetitions;
        }

        public RepetitionsGoal(int repetitions) {
            this.repetitions = repetitions;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RepetitionsGoal) && this.repetitions == ((RepetitionsGoal) other).repetitions;
        }

        public int hashCode() {
            return Integer.hashCode(this.repetitions);
        }

        public String toString() {
            return "RepetitionsGoal(repetitions=" + this.repetitions + ')';
        }
    }

    /* compiled from: ExerciseCompletionGoal.kt */
    @Metadata(m286d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m287d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal$TotalCaloriesBurnedGoal;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "totalCalories", "Landroidx/health/connect/client/units/Energy;", "(Landroidx/health/connect/client/units/Energy;)V", "getTotalCalories", "()Landroidx/health/connect/client/units/Energy;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class TotalCaloriesBurnedGoal extends ExerciseCompletionGoal {
        private final Energy totalCalories;

        public final Energy getTotalCalories() {
            return this.totalCalories;
        }

        public TotalCaloriesBurnedGoal(Energy totalCalories) {
            Intrinsics.checkNotNullParameter(totalCalories, "totalCalories");
            this.totalCalories = totalCalories;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof TotalCaloriesBurnedGoal) {
                return Intrinsics.areEqual(this.totalCalories, ((TotalCaloriesBurnedGoal) other).totalCalories);
            }
            return false;
        }

        public int hashCode() {
            return this.totalCalories.hashCode();
        }

        public String toString() {
            return "TotalCaloriesBurnedGoal(totalCalories=" + this.totalCalories + ')';
        }
    }

    /* compiled from: ExerciseCompletionGoal.kt */
    @Metadata(m286d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m287d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal$ActiveCaloriesBurnedGoal;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "activeCalories", "Landroidx/health/connect/client/units/Energy;", "(Landroidx/health/connect/client/units/Energy;)V", "getActiveCalories", "()Landroidx/health/connect/client/units/Energy;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class ActiveCaloriesBurnedGoal extends ExerciseCompletionGoal {
        private final Energy activeCalories;

        public final Energy getActiveCalories() {
            return this.activeCalories;
        }

        public ActiveCaloriesBurnedGoal(Energy activeCalories) {
            Intrinsics.checkNotNullParameter(activeCalories, "activeCalories");
            this.activeCalories = activeCalories;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof ActiveCaloriesBurnedGoal) {
                return Intrinsics.areEqual(this.activeCalories, ((ActiveCaloriesBurnedGoal) other).activeCalories);
            }
            return false;
        }

        public int hashCode() {
            return this.activeCalories.hashCode();
        }

        public String toString() {
            return "ActiveCaloriesBurnedGoal(activeCalories=" + this.activeCalories + ')';
        }
    }

    /* compiled from: ExerciseCompletionGoal.kt */
    @Metadata(m286d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m287d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal$UnknownGoal;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "()V", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class UnknownGoal extends ExerciseCompletionGoal {
        public static final UnknownGoal INSTANCE = new UnknownGoal();

        private UnknownGoal() {
        }

        public String toString() {
            return "UnknownGoal()";
        }
    }

    /* compiled from: ExerciseCompletionGoal.kt */
    @Metadata(m286d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m287d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal$ManualCompletion;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "()V", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class ManualCompletion extends ExerciseCompletionGoal {
        public static final ManualCompletion INSTANCE = new ManualCompletion();

        private ManualCompletion() {
        }

        public String toString() {
            return "ManualCompletion()";
        }
    }
}
