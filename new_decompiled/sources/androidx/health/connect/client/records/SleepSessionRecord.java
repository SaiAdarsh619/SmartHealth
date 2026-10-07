package androidx.health.connect.client.records;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.CervicalMucusRecord;
import androidx.health.connect.client.records.SleepSessionRecord;
import androidx.health.connect.client.records.Vo2MaxRecord;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: SleepSessionRecord.kt */
@Metadata(m286d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0003%&'BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\u0010\u0010J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018¨\u0006("}, m287d2 = {"Landroidx/health/connect/client/records/SleepSessionRecord;", "Landroidx/health/connect/client/records/IntervalRecord;", "startTime", "Ljava/time/Instant;", "startZoneOffset", "Ljava/time/ZoneOffset;", "endTime", "endZoneOffset", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "title", "", "notes", "stages", "", "Landroidx/health/connect/client/records/SleepSessionRecord$Stage;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getEndTime", "()Ljava/time/Instant;", "getEndZoneOffset", "()Ljava/time/ZoneOffset;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getNotes", "()Ljava/lang/String;", "getStages", "()Ljava/util/List;", "getStartTime", "getStartZoneOffset", "getTitle", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "Companion", "Stage", "StageTypes", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class SleepSessionRecord implements IntervalRecord {
    public static final int STAGE_TYPE_AWAKE = 1;
    public static final int STAGE_TYPE_AWAKE_IN_BED = 7;
    public static final int STAGE_TYPE_DEEP = 5;
    public static final Map<Integer, String> STAGE_TYPE_INT_TO_STRING_MAP;
    public static final int STAGE_TYPE_LIGHT = 4;
    public static final int STAGE_TYPE_OUT_OF_BED = 3;
    public static final int STAGE_TYPE_REM = 6;
    public static final int STAGE_TYPE_SLEEPING = 2;
    public static final int STAGE_TYPE_UNKNOWN = 0;
    private final Instant endTime;
    private final ZoneOffset endZoneOffset;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final String notes;
    private final List<Stage> stages;
    private final Instant startTime;
    private final ZoneOffset startZoneOffset;
    private final String title;
    public static final AggregateMetric<Duration> SLEEP_DURATION_TOTAL = AggregateMetric.INSTANCE.durationMetric$connect_client_release("SleepSession");
    public static final Map<String, Integer> STAGE_TYPE_STRING_TO_INT_MAP = MapsKt.mapOf(TuplesKt.m294to("awake", 1), TuplesKt.m294to("sleeping", 2), TuplesKt.m294to("out_of_bed", 3), TuplesKt.m294to(CervicalMucusRecord.Sensation.LIGHT, 4), TuplesKt.m294to("deep", 5), TuplesKt.m294to("rem", 6), TuplesKt.m294to("awake_in_bed", 7), TuplesKt.m294to("unknown", 0));

    /* compiled from: SleepSessionRecord.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m287d2 = {"Landroidx/health/connect/client/records/SleepSessionRecord$StageTypes;", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface StageTypes {
    }

    public SleepSessionRecord(Instant startTime, ZoneOffset startZoneOffset, Instant endTime, ZoneOffset endZoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, String title, String notes, List<Stage> stages) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(stages, "stages");
        this.startTime = startTime;
        this.startZoneOffset = startZoneOffset;
        this.endTime = endTime;
        this.endZoneOffset = endZoneOffset;
        this.metadata = metadata;
        this.title = title;
        this.notes = notes;
        this.stages = stages;
        if (!getStartTime().isBefore(getEndTime())) {
            throw new IllegalArgumentException("startTime must be before endTime.".toString());
        }
        if (this.stages.isEmpty()) {
            return;
        }
        List<Stage> list = this.stages;
        final SleepSessionRecord$sortedStages$1 sleepSessionRecord$sortedStages$1 = new Function2<Stage, Stage, Integer>() { // from class: androidx.health.connect.client.records.SleepSessionRecord$sortedStages$1
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(SleepSessionRecord.Stage a, SleepSessionRecord.Stage b) {
                return Integer.valueOf(a.getStartTime().compareTo(b.getStartTime()));
            }
        };
        List sortedStages = CollectionsKt.sortedWith(list, new Comparator() { // from class: androidx.health.connect.client.records.SleepSessionRecord$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int _init_$lambda$1;
                _init_$lambda$1 = SleepSessionRecord._init_$lambda$1(Function2.this, obj, obj2);
                return _init_$lambda$1;
            }
        });
        int lastIndex = CollectionsKt.getLastIndex(sortedStages);
        for (int i = 0; i < lastIndex; i++) {
            if (((Stage) sortedStages.get(i)).getEndTime().isAfter(((Stage) sortedStages.get(i + 1)).getStartTime())) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
        if (((Stage) CollectionsKt.first(sortedStages)).getStartTime().isBefore(getStartTime())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (((Stage) CollectionsKt.last(sortedStages)).getEndTime().isAfter(getEndTime())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public /* synthetic */ SleepSessionRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, androidx.health.connect.client.records.metadata.Metadata metadata, String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, instant2, zoneOffset2, metadata, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? CollectionsKt.emptyList() : list);
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

    public final String getTitle() {
        return this.title;
    }

    public final String getNotes() {
        return this.notes;
    }

    public final List<Stage> getStages() {
        return this.stages;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _init_$lambda$1(Function2 $tmp0, Object p0, Object p1) {
        return ((Number) $tmp0.invoke(p0, p1)).intValue();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SleepSessionRecord) && Intrinsics.areEqual(this.title, ((SleepSessionRecord) other).title) && Intrinsics.areEqual(this.notes, ((SleepSessionRecord) other).notes) && Intrinsics.areEqual(this.stages, ((SleepSessionRecord) other).stages) && Intrinsics.areEqual(getStartTime(), ((SleepSessionRecord) other).getStartTime()) && Intrinsics.areEqual(getStartZoneOffset(), ((SleepSessionRecord) other).getStartZoneOffset()) && Intrinsics.areEqual(getEndTime(), ((SleepSessionRecord) other).getEndTime()) && Intrinsics.areEqual(getEndZoneOffset(), ((SleepSessionRecord) other).getEndZoneOffset()) && Intrinsics.areEqual(getMetadata(), ((SleepSessionRecord) other).getMetadata());
    }

    public int hashCode() {
        int i = 0 * 31;
        String str = this.title;
        int result = i + (str != null ? str.hashCode() : 0);
        int result2 = result * 31;
        String str2 = this.notes;
        int result3 = (((result2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.stages.hashCode()) * 31;
        ZoneOffset startZoneOffset = getStartZoneOffset();
        int result4 = (((result3 + (startZoneOffset != null ? startZoneOffset.hashCode() : 0)) * 31) + getEndTime().hashCode()) * 31;
        ZoneOffset endZoneOffset = getEndZoneOffset();
        return ((result4 + (endZoneOffset != null ? endZoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "SleepSessionRecord(startTime=" + getStartTime() + ", startZoneOffset=" + getStartZoneOffset() + ", endTime=" + getEndTime() + ", endZoneOffset=" + getEndZoneOffset() + ", title=" + this.title + ", notes=" + this.notes + ", stages=" + this.stages + ", metadata=" + getMetadata() + ')';
    }

    static {
        Iterable $this$associateBy$iv = STAGE_TYPE_STRING_TO_INT_MAP.entrySet();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            Map.Entry it = (Map.Entry) element$iv$iv;
            Map.Entry it2 = (Map.Entry) element$iv$iv;
            destination$iv$iv.put(Integer.valueOf(((Number) it.getValue()).intValue()), (String) it2.getKey());
        }
        STAGE_TYPE_INT_TO_STRING_MAP = destination$iv$iv;
    }

    /* compiled from: SleepSessionRecord.kt */
    @Metadata(m286d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00020\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u0015"}, m287d2 = {"Landroidx/health/connect/client/records/SleepSessionRecord$Stage;", "", "startTime", "Ljava/time/Instant;", "endTime", "stage", "", "(Ljava/time/Instant;Ljava/time/Instant;I)V", "getEndTime", "()Ljava/time/Instant;", "getStage$annotations", "()V", "getStage", "()I", "getStartTime", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class Stage {
        private final Instant endTime;
        private final int stage;
        private final Instant startTime;

        public static /* synthetic */ void getStage$annotations() {
        }

        public Stage(Instant startTime, Instant endTime, int stage) {
            Intrinsics.checkNotNullParameter(startTime, "startTime");
            Intrinsics.checkNotNullParameter(endTime, "endTime");
            this.startTime = startTime;
            this.endTime = endTime;
            this.stage = stage;
            if (!this.startTime.isBefore(this.endTime)) {
                throw new IllegalArgumentException("startTime must be before endTime.".toString());
            }
        }

        public final Instant getStartTime() {
            return this.startTime;
        }

        public final Instant getEndTime() {
            return this.endTime;
        }

        public final int getStage() {
            return this.stage;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Stage) && this.stage == ((Stage) other).stage && Intrinsics.areEqual(this.startTime, ((Stage) other).startTime) && Intrinsics.areEqual(this.endTime, ((Stage) other).endTime);
        }

        public int hashCode() {
            int result = Integer.hashCode(this.stage);
            return (((result * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode();
        }

        public String toString() {
            return "Stage(startTime=" + this.startTime + ", endTime=" + this.endTime + ", stage=" + this.stage + ')';
        }
    }
}
