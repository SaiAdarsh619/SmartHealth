package androidx.health.connect.client.records;

import androidx.health.connect.client.records.Vo2MaxRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlannedExerciseBlock.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Landroidx/health/connect/client/records/PlannedExerciseBlock;", "", "repetitions", "", "steps", "", "Landroidx/health/connect/client/records/PlannedExerciseStep;", "description", "", "(ILjava/util/List;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getRepetitions", "()I", "getSteps", "()Ljava/util/List;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "toString", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes14.dex */
public final class PlannedExerciseBlock {
    private final String description;
    private final int repetitions;
    private final List<PlannedExerciseStep> steps;

    public PlannedExerciseBlock(int repetitions, List<PlannedExerciseStep> steps, String description) {
        Intrinsics.checkNotNullParameter(steps, "steps");
        this.repetitions = repetitions;
        this.steps = steps;
        this.description = description;
    }

    public /* synthetic */ PlannedExerciseBlock(int i, List list, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, (i2 & 4) != 0 ? null : str);
    }

    public final int getRepetitions() {
        return this.repetitions;
    }

    public final List<PlannedExerciseStep> getSteps() {
        return this.steps;
    }

    public final String getDescription() {
        return this.description;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PlannedExerciseBlock) && this.repetitions == ((PlannedExerciseBlock) other).repetitions && Intrinsics.areEqual(this.description, ((PlannedExerciseBlock) other).description) && Intrinsics.areEqual(this.steps, ((PlannedExerciseBlock) other).steps);
    }

    public int hashCode() {
        int result = this.repetitions;
        int i = result * 31;
        String str = this.description;
        int result2 = i + (str != null ? str.hashCode() : 0);
        return (result2 * 31) + this.steps.hashCode();
    }

    public String toString() {
        return "PlannedExerciseBlock(repetitions=" + this.repetitions + ", description=" + this.description + ", steps=" + this.steps + ')';
    }
}
