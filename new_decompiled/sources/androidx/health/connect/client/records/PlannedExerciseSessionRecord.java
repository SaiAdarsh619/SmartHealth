package androidx.health.connect.client.records;

import androidx.health.connect.client.records.Vo2MaxRecord;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAmount;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlannedExerciseSessionRecord.kt */
@Metadata(m286d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 42\u00020\u0001:\u00014Ba\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0012BM\b\u0017\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0017Bs\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u001bJ\u0013\u0010/\u001a\u00020\u00192\b\u00100\u001a\u0004\u0018\u000101H\u0096\u0002J\b\u00102\u001a\u00020\u000eH\u0016J\b\u00103\u001a\u00020\u0010H\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0017\u0010\r\u001a\u00020\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0013\u0010\u0018\u001a\u00020\u00198\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010(R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001f¨\u00065"}, m287d2 = {"Landroidx/health/connect/client/records/PlannedExerciseSessionRecord;", "Landroidx/health/connect/client/records/IntervalRecord;", "startTime", "Ljava/time/Instant;", "startZoneOffset", "Ljava/time/ZoneOffset;", "endTime", "endZoneOffset", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "blocks", "", "Landroidx/health/connect/client/records/PlannedExerciseBlock;", "exerciseType", "", "title", "", "notes", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;)V", "startDate", "Ljava/time/LocalDate;", "duration", "Ljava/time/Duration;", "(Landroidx/health/connect/client/records/metadata/Metadata;Ljava/time/LocalDate;Ljava/time/Duration;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;)V", "hasExplicitTime", "", "completedExerciseSessionId", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;ZILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getBlocks", "()Ljava/util/List;", "getCompletedExerciseSessionId", "()Ljava/lang/String;", "getEndTime", "()Ljava/time/Instant;", "getEndZoneOffset", "()Ljava/time/ZoneOffset;", "getExerciseType$annotations", "()V", "getExerciseType", "()I", "()Z", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getNotes", "getStartTime", "getStartZoneOffset", "getTitle", "equals", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "toString", "Companion", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class PlannedExerciseSessionRecord implements IntervalRecord {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<PlannedExerciseBlock> blocks;
    private final String completedExerciseSessionId;
    private final Instant endTime;
    private final ZoneOffset endZoneOffset;
    private final int exerciseType;
    private final boolean hasExplicitTime;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final String notes;
    private final Instant startTime;
    private final ZoneOffset startZoneOffset;
    private final String title;

    public static /* synthetic */ void getExerciseType$annotations() {
    }

    public PlannedExerciseSessionRecord(Instant startTime, ZoneOffset startZoneOffset, Instant endTime, ZoneOffset endZoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, boolean hasExplicitTime, int exerciseType, String completedExerciseSessionId, List<PlannedExerciseBlock> blocks, String title, String notes) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(blocks, "blocks");
        this.startTime = startTime;
        this.startZoneOffset = startZoneOffset;
        this.endTime = endTime;
        this.endZoneOffset = endZoneOffset;
        this.metadata = metadata;
        this.hasExplicitTime = hasExplicitTime;
        this.exerciseType = exerciseType;
        this.completedExerciseSessionId = completedExerciseSessionId;
        this.blocks = blocks;
        this.title = title;
        this.notes = notes;
        if (getStartTime().isBefore(getEndTime())) {
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PlannedExerciseSessionRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, androidx.health.connect.client.records.metadata.Metadata metadata, boolean z, int i, String str, List list, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, instant2, zoneOffset2, metadata, z, i, str, (List<PlannedExerciseBlock>) list, r13, r14);
        String str4;
        String str5;
        if ((i2 & 512) == 0) {
            str4 = str2;
        } else {
            str4 = null;
        }
        if ((i2 & 1024) == 0) {
            str5 = str3;
        } else {
            str5 = null;
        }
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public Instant getStartTime() {
        return this.startTime;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public ZoneOffset getStartZoneOffset() {
        return this.startZoneOffset;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public Instant getEndTime() {
        return this.endTime;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public ZoneOffset getEndZoneOffset() {
        return this.endZoneOffset;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    /* renamed from: hasExplicitTime, reason: from getter */
    public final boolean getHasExplicitTime() {
        return this.hasExplicitTime;
    }

    public final int getExerciseType() {
        return this.exerciseType;
    }

    public final String getCompletedExerciseSessionId() {
        return this.completedExerciseSessionId;
    }

    public final List<PlannedExerciseBlock> getBlocks() {
        return this.blocks;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getNotes() {
        return this.notes;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PlannedExerciseSessionRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, androidx.health.connect.client.records.metadata.Metadata metadata, List list, int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, instant2, zoneOffset2, metadata, (List<PlannedExerciseBlock>) list, i, r11, r12);
        String str3;
        String str4;
        if ((i2 & 128) == 0) {
            str3 = str;
        } else {
            str3 = null;
        }
        if ((i2 & 256) == 0) {
            str4 = str2;
        } else {
            str4 = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlannedExerciseSessionRecord(Instant startTime, ZoneOffset startZoneOffset, Instant endTime, ZoneOffset endZoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, List<PlannedExerciseBlock> blocks, int exerciseType, String title, String notes) {
        this(startTime, startZoneOffset, endTime, endZoneOffset, metadata, true, exerciseType, (String) null, blocks, title, notes);
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(blocks, "blocks");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlannedExerciseSessionRecord(Instant startTime, ZoneOffset startZoneOffset, Instant endTime, ZoneOffset endZoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, List<PlannedExerciseBlock> blocks, int exerciseType) {
        this(startTime, startZoneOffset, endTime, endZoneOffset, metadata, blocks, exerciseType, (String) null, (String) null, 384, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(blocks, "blocks");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlannedExerciseSessionRecord(Instant startTime, ZoneOffset startZoneOffset, Instant endTime, ZoneOffset endZoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, List<PlannedExerciseBlock> blocks, int exerciseType, String title) {
        this(startTime, startZoneOffset, endTime, endZoneOffset, metadata, blocks, exerciseType, title, (String) null, 256, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(blocks, "blocks");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PlannedExerciseSessionRecord(androidx.health.connect.client.records.metadata.Metadata metadata, LocalDate localDate, Duration duration, List list, int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(metadata, localDate, duration, (List<PlannedExerciseBlock>) list, i, r8, r9);
        String str3;
        String str4;
        if ((i2 & 32) == 0) {
            str3 = str;
        } else {
            str3 = null;
        }
        if ((i2 & 64) == 0) {
            str4 = str2;
        } else {
            str4 = null;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PlannedExerciseSessionRecord(androidx.health.connect.client.records.metadata.Metadata metadata, LocalDate startDate, Duration duration, List<PlannedExerciseBlock> blocks, int exerciseType, String title, String notes) {
        this(r4, r5, r6, r3.getOffset(r7), metadata, false, exerciseType, (String) null, blocks, title, notes);
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(blocks, "blocks");
        Instant physicalTimeAtNoon = INSTANCE.toPhysicalTimeAtNoon(startDate);
        ZoneOffset offset = INSTANCE.getOffset(INSTANCE.toPhysicalTimeAtNoon(startDate));
        Instant plus = INSTANCE.toPhysicalTimeAtNoon(startDate).plus((TemporalAmount) duration);
        Intrinsics.checkNotNullExpressionValue(plus, "startDate.toPhysicalTimeAtNoon().plus(duration)");
        Companion companion = INSTANCE;
        Instant plus2 = INSTANCE.toPhysicalTimeAtNoon(startDate).plus((TemporalAmount) duration);
        Intrinsics.checkNotNullExpressionValue(plus2, "startDate.toPhysicalTimeAtNoon().plus(duration)");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlannedExerciseSessionRecord(androidx.health.connect.client.records.metadata.Metadata metadata, LocalDate startDate, Duration duration, List<PlannedExerciseBlock> blocks, int exerciseType) {
        this(metadata, startDate, duration, blocks, exerciseType, (String) null, (String) null, 96, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(blocks, "blocks");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlannedExerciseSessionRecord(androidx.health.connect.client.records.metadata.Metadata metadata, LocalDate startDate, Duration duration, List<PlannedExerciseBlock> blocks, int exerciseType, String title) {
        this(metadata, startDate, duration, blocks, exerciseType, title, (String) null, 64, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(blocks, "blocks");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PlannedExerciseSessionRecord) && Intrinsics.areEqual(getStartTime(), ((PlannedExerciseSessionRecord) other).getStartTime()) && Intrinsics.areEqual(getStartZoneOffset(), ((PlannedExerciseSessionRecord) other).getStartZoneOffset()) && Intrinsics.areEqual(getEndTime(), ((PlannedExerciseSessionRecord) other).getEndTime()) && Intrinsics.areEqual(getEndZoneOffset(), ((PlannedExerciseSessionRecord) other).getEndZoneOffset()) && this.hasExplicitTime == ((PlannedExerciseSessionRecord) other).hasExplicitTime && Intrinsics.areEqual(this.blocks, ((PlannedExerciseSessionRecord) other).blocks) && Intrinsics.areEqual(this.title, ((PlannedExerciseSessionRecord) other).title) && Intrinsics.areEqual(this.notes, ((PlannedExerciseSessionRecord) other).notes) && this.exerciseType == ((PlannedExerciseSessionRecord) other).exerciseType && Intrinsics.areEqual(getMetadata(), ((PlannedExerciseSessionRecord) other).getMetadata());
    }

    public int hashCode() {
        int result = getStartTime().hashCode();
        int i = result * 31;
        ZoneOffset startZoneOffset = getStartZoneOffset();
        int result2 = i + (startZoneOffset != null ? startZoneOffset.hashCode() : 0);
        int result3 = ((result2 * 31) + getEndTime().hashCode()) * 31;
        ZoneOffset endZoneOffset = getEndZoneOffset();
        int result4 = (((((result3 + (endZoneOffset != null ? endZoneOffset.hashCode() : 0)) * 31) + Boolean.hashCode(this.hasExplicitTime)) * 31) + this.blocks.hashCode()) * 31;
        String str = this.title;
        int result5 = (result4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.notes;
        int result6 = (((result5 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.exerciseType) * 31;
        String str3 = this.completedExerciseSessionId;
        return ((result6 + (str3 != null ? str3.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlannedExerciseSessionRecord(startTime=").append(getStartTime()).append(", startZoneOffset=").append(getStartZoneOffset()).append(", endTime=").append(getEndTime()).append(", endZoneOffset=").append(getEndZoneOffset()).append(", hasExplicitTime=").append(this.hasExplicitTime).append(", title=").append(this.title).append(", notes=").append(this.notes).append(", exerciseType=").append(this.exerciseType).append(", completedExerciseSessionId=").append(this.completedExerciseSessionId).append(", metadata=").append(getMetadata()).append(", blocks=").append(this.blocks).append(')');
        return sb.toString();
    }

    /* compiled from: PlannedExerciseSessionRecord.kt */
    @Metadata(m286d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0007H\u0002¨\u0006\b"}, m287d2 = {"Landroidx/health/connect/client/records/PlannedExerciseSessionRecord$Companion;", "", "()V", "getOffset", "Ljava/time/ZoneOffset;", "Ljava/time/Instant;", "toPhysicalTimeAtNoon", "Ljava/time/LocalDate;", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.time.ZonedDateTime] */
        public final Instant toPhysicalTimeAtNoon(LocalDate $this$toPhysicalTimeAtNoon) {
            Instant instant = $this$toPhysicalTimeAtNoon.atTime(LocalTime.NOON).atZone(ZoneId.systemDefault()).toInstant();
            Intrinsics.checkNotNullExpressionValue(instant, "this.atTime(LocalTime.NO…temDefault()).toInstant()");
            return instant;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ZoneOffset getOffset(Instant $this$getOffset) {
            ZoneOffset offset = ZoneOffset.systemDefault().getRules().getOffset($this$getOffset);
            Intrinsics.checkNotNullExpressionValue(offset, "systemDefault().rules.getOffset(this)");
            return offset;
        }
    }
}
