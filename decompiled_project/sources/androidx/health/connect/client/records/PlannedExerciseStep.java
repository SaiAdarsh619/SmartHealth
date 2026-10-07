package androidx.health.connect.client.records;

import androidx.health.connect.client.records.Vo2MaxRecord;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlannedExerciseStep.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u0003¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0002\u001a\u00020\u0003¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Landroidx/health/connect/client/records/PlannedExerciseStep;", "", "exerciseType", "", "exercisePhase", "completionGoal", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "performanceTargets", "", "Landroidx/health/connect/client/records/ExercisePerformanceTarget;", "description", "", "(IILandroidx/health/connect/client/records/ExerciseCompletionGoal;Ljava/util/List;Ljava/lang/String;)V", "getCompletionGoal", "()Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "getDescription", "()Ljava/lang/String;", "getExercisePhase$annotations", "()V", "getExercisePhase", "()I", "getExerciseType$annotations", "getExerciseType", "getPerformanceTargets", "()Ljava/util/List;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "toString", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes14.dex */
public final class PlannedExerciseStep {
    public static final Companion Companion = new Companion(null);
    public static final int EXERCISE_PHASE_ACTIVE = 3;
    public static final int EXERCISE_PHASE_COOLDOWN = 4;
    public static final int EXERCISE_PHASE_RECOVERY = 5;
    public static final int EXERCISE_PHASE_REST = 2;
    public static final int EXERCISE_PHASE_UNKNOWN = 0;
    public static final int EXERCISE_PHASE_WARMUP = 1;
    private final ExerciseCompletionGoal completionGoal;
    private final String description;
    private final int exercisePhase;
    private final int exerciseType;
    private final List<ExercisePerformanceTarget> performanceTargets;

    public static /* synthetic */ void getExercisePhase$annotations() {
    }

    public static /* synthetic */ void getExerciseType$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PlannedExerciseStep(int exerciseType, int exercisePhase, ExerciseCompletionGoal completionGoal, List<? extends ExercisePerformanceTarget> performanceTargets, String description) {
        Intrinsics.checkNotNullParameter(completionGoal, "completionGoal");
        Intrinsics.checkNotNullParameter(performanceTargets, "performanceTargets");
        this.exerciseType = exerciseType;
        this.exercisePhase = exercisePhase;
        this.completionGoal = completionGoal;
        this.performanceTargets = performanceTargets;
        this.description = description;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ PlannedExerciseStep(int r7, int r8, androidx.health.connect.client.records.ExerciseCompletionGoal r9, java.util.List r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r12 = r12 & 16
            if (r12 == 0) goto L7
            r11 = 0
            r5 = r11
            goto L8
        L7:
            r5 = r11
        L8:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.records.PlannedExerciseStep.<init>(int, int, androidx.health.connect.client.records.ExerciseCompletionGoal, java.util.List, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getExerciseType() {
        return this.exerciseType;
    }

    public final int getExercisePhase() {
        return this.exercisePhase;
    }

    public final ExerciseCompletionGoal getCompletionGoal() {
        return this.completionGoal;
    }

    public final List<ExercisePerformanceTarget> getPerformanceTargets() {
        return this.performanceTargets;
    }

    public final String getDescription() {
        return this.description;
    }

    /* compiled from: PlannedExerciseStep.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/health/connect/client/records/PlannedExerciseStep$Companion;", "", "()V", "EXERCISE_PHASE_ACTIVE", "", "EXERCISE_PHASE_COOLDOWN", "EXERCISE_PHASE_RECOVERY", "EXERCISE_PHASE_REST", "EXERCISE_PHASE_UNKNOWN", "EXERCISE_PHASE_WARMUP", "ExercisePhase", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: PlannedExerciseStep.kt */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/health/connect/client/records/PlannedExerciseStep$Companion$ExercisePhase;", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        /* loaded from: classes14.dex */
        public @interface ExercisePhase {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PlannedExerciseStep) && this.exerciseType == ((PlannedExerciseStep) other).exerciseType && this.exercisePhase == ((PlannedExerciseStep) other).exercisePhase && Intrinsics.areEqual(this.description, ((PlannedExerciseStep) other).description) && Intrinsics.areEqual(this.completionGoal, ((PlannedExerciseStep) other).completionGoal) && Intrinsics.areEqual(this.performanceTargets, ((PlannedExerciseStep) other).performanceTargets);
    }

    public int hashCode() {
        int result = this.exerciseType;
        int result2 = ((result * 31) + this.exercisePhase) * 31;
        String str = this.description;
        return ((((result2 + (str != null ? str.hashCode() : 0)) * 31) + this.completionGoal.hashCode()) * 31) + this.performanceTargets.hashCode();
    }

    public String toString() {
        return "PlannedExerciseStep(exerciseType=" + this.exerciseType + ", exerciseCategory=" + this.exercisePhase + ", description=" + this.description + ", completionGoal=" + this.completionGoal + ", performanceTargets=" + this.performanceTargets + ')';
    }
}
