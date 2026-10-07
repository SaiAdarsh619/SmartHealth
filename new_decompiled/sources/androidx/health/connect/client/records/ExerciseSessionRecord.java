package androidx.health.connect.client.records;

import androidx.core.app.NotificationCompat;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.ExerciseRoute;
import androidx.health.connect.client.records.ExerciseRouteResult;
import androidx.health.connect.client.records.Vo2MaxRecord;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: ExerciseSessionRecord.kt */
@Metadata(m286d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 62\u00020\u0001:\u000267B\u008b\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0017B\u0089\u0001\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u001aJ\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0096\u0002J\b\u00104\u001a\u00020\u000bH\u0016J\b\u00105\u001a\u00020\rH\u0016R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\n\u001a\u00020\u000b¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b,\u0010&R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b/\u0010*¨\u00068"}, m287d2 = {"Landroidx/health/connect/client/records/ExerciseSessionRecord;", "Landroidx/health/connect/client/records/IntervalRecord;", "startTime", "Ljava/time/Instant;", "startZoneOffset", "Ljava/time/ZoneOffset;", "endTime", "endZoneOffset", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "exerciseType", "", "title", "", "notes", "segments", "", "Landroidx/health/connect/client/records/ExerciseSegment;", "laps", "Landroidx/health/connect/client/records/ExerciseLap;", "exerciseRoute", "Landroidx/health/connect/client/records/ExerciseRoute;", "plannedExerciseSessionId", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Landroidx/health/connect/client/records/ExerciseRoute;Ljava/lang/String;)V", "exerciseRouteResult", "Landroidx/health/connect/client/records/ExerciseRouteResult;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Landroidx/health/connect/client/records/ExerciseRouteResult;Ljava/lang/String;)V", "getEndTime", "()Ljava/time/Instant;", "getEndZoneOffset", "()Ljava/time/ZoneOffset;", "getExerciseRouteResult", "()Landroidx/health/connect/client/records/ExerciseRouteResult;", "getExerciseType$annotations", "()V", "getExerciseType", "()I", "getLaps", "()Ljava/util/List;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getNotes", "()Ljava/lang/String;", "getPlannedExerciseSessionId", "getSegments", "getStartTime", "getStartZoneOffset", "getTitle", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "toString", "Companion", "ExerciseTypes", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class ExerciseSessionRecord implements IntervalRecord {
    public static final int EXERCISE_TYPE_BADMINTON = 2;
    public static final int EXERCISE_TYPE_BASEBALL = 4;
    public static final int EXERCISE_TYPE_BASKETBALL = 5;
    public static final int EXERCISE_TYPE_BIKING = 8;
    public static final int EXERCISE_TYPE_BIKING_STATIONARY = 9;
    public static final int EXERCISE_TYPE_BOOT_CAMP = 10;
    public static final int EXERCISE_TYPE_BOXING = 11;
    public static final int EXERCISE_TYPE_CALISTHENICS = 13;
    public static final int EXERCISE_TYPE_CRICKET = 14;
    public static final int EXERCISE_TYPE_DANCING = 16;
    public static final int EXERCISE_TYPE_ELLIPTICAL = 25;
    public static final int EXERCISE_TYPE_EXERCISE_CLASS = 26;
    public static final int EXERCISE_TYPE_FENCING = 27;
    public static final int EXERCISE_TYPE_FOOTBALL_AMERICAN = 28;
    public static final int EXERCISE_TYPE_FOOTBALL_AUSTRALIAN = 29;
    public static final int EXERCISE_TYPE_FRISBEE_DISC = 31;
    public static final int EXERCISE_TYPE_GOLF = 32;
    public static final int EXERCISE_TYPE_GUIDED_BREATHING = 33;
    public static final int EXERCISE_TYPE_GYMNASTICS = 34;
    public static final int EXERCISE_TYPE_HANDBALL = 35;
    public static final int EXERCISE_TYPE_HIGH_INTENSITY_INTERVAL_TRAINING = 36;
    public static final int EXERCISE_TYPE_HIKING = 37;
    public static final int EXERCISE_TYPE_ICE_HOCKEY = 38;
    public static final int EXERCISE_TYPE_ICE_SKATING = 39;
    public static final Map<Integer, String> EXERCISE_TYPE_INT_TO_STRING_MAP;
    public static final int EXERCISE_TYPE_MARTIAL_ARTS = 44;
    public static final int EXERCISE_TYPE_OTHER_WORKOUT = 0;
    public static final int EXERCISE_TYPE_PADDLING = 46;
    public static final int EXERCISE_TYPE_PARAGLIDING = 47;
    public static final int EXERCISE_TYPE_PILATES = 48;
    public static final int EXERCISE_TYPE_RACQUETBALL = 50;
    public static final int EXERCISE_TYPE_ROCK_CLIMBING = 51;
    public static final int EXERCISE_TYPE_ROLLER_HOCKEY = 52;
    public static final int EXERCISE_TYPE_ROWING = 53;
    public static final int EXERCISE_TYPE_ROWING_MACHINE = 54;
    public static final int EXERCISE_TYPE_RUGBY = 55;
    public static final int EXERCISE_TYPE_RUNNING = 56;
    public static final int EXERCISE_TYPE_RUNNING_TREADMILL = 57;
    public static final int EXERCISE_TYPE_SAILING = 58;
    public static final int EXERCISE_TYPE_SCUBA_DIVING = 59;
    public static final int EXERCISE_TYPE_SKATING = 60;
    public static final int EXERCISE_TYPE_SKIING = 61;
    public static final int EXERCISE_TYPE_SNOWBOARDING = 62;
    public static final int EXERCISE_TYPE_SNOWSHOEING = 63;
    public static final int EXERCISE_TYPE_SOCCER = 64;
    public static final int EXERCISE_TYPE_SOFTBALL = 65;
    public static final int EXERCISE_TYPE_SQUASH = 66;
    public static final int EXERCISE_TYPE_STAIR_CLIMBING = 68;
    public static final int EXERCISE_TYPE_STAIR_CLIMBING_MACHINE = 69;
    public static final int EXERCISE_TYPE_STRENGTH_TRAINING = 70;
    public static final int EXERCISE_TYPE_STRETCHING = 71;
    public static final int EXERCISE_TYPE_SURFING = 72;
    public static final int EXERCISE_TYPE_SWIMMING_OPEN_WATER = 73;
    public static final int EXERCISE_TYPE_SWIMMING_POOL = 74;
    public static final int EXERCISE_TYPE_TABLE_TENNIS = 75;
    public static final int EXERCISE_TYPE_TENNIS = 76;
    public static final int EXERCISE_TYPE_VOLLEYBALL = 78;
    public static final int EXERCISE_TYPE_WALKING = 79;
    public static final int EXERCISE_TYPE_WATER_POLO = 80;
    public static final int EXERCISE_TYPE_WEIGHTLIFTING = 81;
    public static final int EXERCISE_TYPE_WHEELCHAIR = 82;
    public static final int EXERCISE_TYPE_YOGA = 83;
    private final Instant endTime;
    private final ZoneOffset endZoneOffset;
    private final ExerciseRouteResult exerciseRouteResult;
    private final int exerciseType;
    private final List<ExerciseLap> laps;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final String notes;
    private final String plannedExerciseSessionId;
    private final List<ExerciseSegment> segments;
    private final Instant startTime;
    private final ZoneOffset startZoneOffset;
    private final String title;
    public static final AggregateMetric<Duration> EXERCISE_DURATION_TOTAL = AggregateMetric.INSTANCE.durationMetric$connect_client_release("ActiveTime", AggregateMetric.AggregationType.TOTAL, "time");
    public static final Map<String, Integer> EXERCISE_TYPE_STRING_TO_INT_MAP = MapsKt.mapOf(TuplesKt.m294to("back_extension", 13), TuplesKt.m294to("badminton", 2), TuplesKt.m294to("barbell_shoulder_press", 70), TuplesKt.m294to("baseball", 4), TuplesKt.m294to("basketball", 5), TuplesKt.m294to("bench_press", 70), TuplesKt.m294to("bench_sit_up", 13), TuplesKt.m294to("biking", 8), TuplesKt.m294to("biking_stationary", 9), TuplesKt.m294to("boot_camp", 10), TuplesKt.m294to("boxing", 11), TuplesKt.m294to("burpee", 13), TuplesKt.m294to("cricket", 14), TuplesKt.m294to("crunch", 13), TuplesKt.m294to("dancing", 16), TuplesKt.m294to("deadlift", 70), TuplesKt.m294to("dumbbell_curl_left_arm", 70), TuplesKt.m294to("dumbbell_curl_right_arm", 70), TuplesKt.m294to("dumbbell_front_raise", 70), TuplesKt.m294to("dumbbell_lateral_raise", 70), TuplesKt.m294to("dumbbell_triceps_extension_left_arm", 70), TuplesKt.m294to("dumbbell_triceps_extension_right_arm", 70), TuplesKt.m294to("dumbbell_triceps_extension_two_arm", 70), TuplesKt.m294to("elliptical", 25), TuplesKt.m294to("exercise_class", 26), TuplesKt.m294to("fencing", 27), TuplesKt.m294to("football_american", 28), TuplesKt.m294to("football_australian", 29), TuplesKt.m294to("forward_twist", 13), TuplesKt.m294to("frisbee_disc", 31), TuplesKt.m294to("golf", 32), TuplesKt.m294to("guided_breathing", 33), TuplesKt.m294to("gymnastics", 34), TuplesKt.m294to("handball", 35), TuplesKt.m294to("hiking", 37), TuplesKt.m294to("ice_hockey", 38), TuplesKt.m294to("ice_skating", 39), TuplesKt.m294to("jumping_jack", 36), TuplesKt.m294to("jump_rope", 36), TuplesKt.m294to("lat_pull_down", 70), TuplesKt.m294to("lunge", 13), TuplesKt.m294to("martial_arts", 44), TuplesKt.m294to("paddling", 46), TuplesKt.m294to("para_gliding", 47), TuplesKt.m294to("pilates", 48), TuplesKt.m294to("plank", 13), TuplesKt.m294to("racquetball", 50), TuplesKt.m294to("rock_climbing", 51), TuplesKt.m294to("roller_hockey", 52), TuplesKt.m294to("rowing", 53), TuplesKt.m294to("rowing_machine", 54), TuplesKt.m294to("rugby", 55), TuplesKt.m294to("running", 56), TuplesKt.m294to("running_treadmill", 57), TuplesKt.m294to("sailing", 58), TuplesKt.m294to("scuba_diving", 59), TuplesKt.m294to("skating", 60), TuplesKt.m294to("skiing", 61), TuplesKt.m294to("snowboarding", 62), TuplesKt.m294to("snowshoeing", 63), TuplesKt.m294to("soccer", 64), TuplesKt.m294to("softball", 65), TuplesKt.m294to("squash", 66), TuplesKt.m294to("squat", 13), TuplesKt.m294to("stair_climbing", 68), TuplesKt.m294to("stair_climbing_machine", 69), TuplesKt.m294to("stretching", 71), TuplesKt.m294to("surfing", 72), TuplesKt.m294to("swimming_open_water", 73), TuplesKt.m294to("swimming_pool", 74), TuplesKt.m294to("table_tennis", 75), TuplesKt.m294to("tennis", 76), TuplesKt.m294to("upper_twist", 13), TuplesKt.m294to("volleyball", 78), TuplesKt.m294to("walking", 79), TuplesKt.m294to("water_polo", 80), TuplesKt.m294to("weightlifting", 81), TuplesKt.m294to("wheelchair", 82), TuplesKt.m294to(NotificationCompat.CATEGORY_WORKOUT, 0), TuplesKt.m294to("yoga", 83), TuplesKt.m294to("calisthenics", 13), TuplesKt.m294to("high_intensity_interval_training", 36), TuplesKt.m294to("strength_training", 70));

    /* compiled from: ExerciseSessionRecord.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m287d2 = {"Landroidx/health/connect/client/records/ExerciseSessionRecord$ExerciseTypes;", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ExerciseTypes {
    }

    public static /* synthetic */ void getExerciseType$annotations() {
    }

    public ExerciseSessionRecord(Instant startTime, ZoneOffset startZoneOffset, Instant endTime, ZoneOffset endZoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, int exerciseType, String title, String notes, List<ExerciseSegment> segments, List<ExerciseLap> laps, ExerciseRouteResult exerciseRouteResult, String plannedExerciseSessionId) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(laps, "laps");
        Intrinsics.checkNotNullParameter(exerciseRouteResult, "exerciseRouteResult");
        this.startTime = startTime;
        this.startZoneOffset = startZoneOffset;
        this.endTime = endTime;
        this.endZoneOffset = endZoneOffset;
        this.metadata = metadata;
        this.exerciseType = exerciseType;
        this.title = title;
        this.notes = notes;
        this.segments = segments;
        this.laps = laps;
        this.exerciseRouteResult = exerciseRouteResult;
        this.plannedExerciseSessionId = plannedExerciseSessionId;
        if (!getStartTime().isBefore(getEndTime())) {
            throw new IllegalArgumentException("startTime must be before endTime.".toString());
        }
        if (!this.segments.isEmpty()) {
            List<ExerciseSegment> list = this.segments;
            final ExerciseSessionRecord$sortedSegments$1 exerciseSessionRecord$sortedSegments$1 = new Function2<ExerciseSegment, ExerciseSegment, Integer>() { // from class: androidx.health.connect.client.records.ExerciseSessionRecord$sortedSegments$1
                @Override // kotlin.jvm.functions.Function2
                public final Integer invoke(ExerciseSegment a, ExerciseSegment b) {
                    return Integer.valueOf(a.getStartTime().compareTo(b.getStartTime()));
                }
            };
            List<ExerciseSegment> sortedSegments = CollectionsKt.sortedWith(list, new Comparator() { // from class: androidx.health.connect.client.records.ExerciseSessionRecord$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int _init_$lambda$2;
                    _init_$lambda$2 = ExerciseSessionRecord._init_$lambda$2(Function2.this, obj, obj2);
                    return _init_$lambda$2;
                }
            });
            int lastIndex = CollectionsKt.getLastIndex(sortedSegments);
            for (int i = 0; i < lastIndex; i++) {
                if (((ExerciseSegment) sortedSegments.get(i)).getEndTime().isAfter(((ExerciseSegment) sortedSegments.get(i + 1)).getStartTime())) {
                    throw new IllegalArgumentException("segments can not overlap.".toString());
                }
            }
            if (((ExerciseSegment) CollectionsKt.first(sortedSegments)).getStartTime().isBefore(getStartTime())) {
                throw new IllegalArgumentException("segments can not be out of parent time range.".toString());
            }
            if (((ExerciseSegment) CollectionsKt.last(sortedSegments)).getEndTime().isAfter(getEndTime())) {
                throw new IllegalArgumentException("segments can not be out of parent time range.".toString());
            }
            for (ExerciseSegment segment : sortedSegments) {
                if (!segment.isCompatibleWith$connect_client_release(this.exerciseType)) {
                    throw new IllegalArgumentException("segmentType and sessionType is not compatible.".toString());
                }
            }
        }
        if (!this.laps.isEmpty()) {
            List<ExerciseLap> list2 = this.laps;
            final ExerciseSessionRecord$sortedLaps$1 exerciseSessionRecord$sortedLaps$1 = new Function2<ExerciseLap, ExerciseLap, Integer>() { // from class: androidx.health.connect.client.records.ExerciseSessionRecord$sortedLaps$1
                @Override // kotlin.jvm.functions.Function2
                public final Integer invoke(ExerciseLap a, ExerciseLap b) {
                    return Integer.valueOf(a.getStartTime().compareTo(b.getStartTime()));
                }
            };
            List sortedLaps = CollectionsKt.sortedWith(list2, new Comparator() { // from class: androidx.health.connect.client.records.ExerciseSessionRecord$$ExternalSyntheticLambda1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int _init_$lambda$7;
                    _init_$lambda$7 = ExerciseSessionRecord._init_$lambda$7(Function2.this, obj, obj2);
                    return _init_$lambda$7;
                }
            });
            int lastIndex2 = CollectionsKt.getLastIndex(sortedLaps);
            for (int i2 = 0; i2 < lastIndex2; i2++) {
                if (((ExerciseLap) sortedLaps.get(i2)).getEndTime().isAfter(((ExerciseLap) sortedLaps.get(i2 + 1)).getStartTime())) {
                    throw new IllegalArgumentException("laps can not overlap.".toString());
                }
            }
            if (((ExerciseLap) CollectionsKt.first(sortedLaps)).getStartTime().isBefore(getStartTime())) {
                throw new IllegalArgumentException("laps can not be out of parent time range.".toString());
            }
            if (((ExerciseLap) CollectionsKt.last(sortedLaps)).getEndTime().isAfter(getEndTime())) {
                throw new IllegalArgumentException("laps can not be out of parent time range.".toString());
            }
        }
        if (!(this.exerciseRouteResult instanceof ExerciseRouteResult.Data) || ((ExerciseRouteResult.Data) this.exerciseRouteResult).getExerciseRoute().getRoute().isEmpty()) {
            return;
        }
        Iterable route = ((ExerciseRouteResult.Data) this.exerciseRouteResult).getExerciseRoute().getRoute();
        Iterable $this$minBy$iv = route;
        Iterator iterator$iv = $this$minBy$iv.iterator();
        if (!iterator$iv.hasNext()) {
            throw new NoSuchElementException();
        }
        Object minElem$iv = iterator$iv.next();
        if (iterator$iv.hasNext()) {
            ExerciseRoute.Location it = (ExerciseRoute.Location) minElem$iv;
            Comparable minValue$iv = it.getTime();
            while (true) {
                Object e$iv = iterator$iv.next();
                ExerciseRoute.Location it2 = (ExerciseRoute.Location) e$iv;
                Iterable $this$minBy$iv2 = $this$minBy$iv;
                Instant time = it2.getTime();
                if (minValue$iv.compareTo(time) > 0) {
                    minElem$iv = e$iv;
                    minValue$iv = time;
                }
                if (!iterator$iv.hasNext()) {
                    break;
                } else {
                    $this$minBy$iv = $this$minBy$iv2;
                }
            }
        }
        Instant minTime = ((ExerciseRoute.Location) minElem$iv).getTime();
        Iterable $this$maxBy$iv = route;
        Iterator iterator$iv2 = $this$maxBy$iv.iterator();
        if (!iterator$iv2.hasNext()) {
            throw new NoSuchElementException();
        }
        Object maxElem$iv = iterator$iv2.next();
        if (iterator$iv2.hasNext()) {
            ExerciseRoute.Location it3 = (ExerciseRoute.Location) maxElem$iv;
            Comparable maxValue$iv = it3.getTime();
            while (true) {
                Object e$iv2 = iterator$iv2.next();
                ExerciseRoute.Location it4 = (ExerciseRoute.Location) e$iv2;
                Iterable $this$maxBy$iv2 = $this$maxBy$iv;
                Instant time2 = it4.getTime();
                if (maxValue$iv.compareTo(time2) < 0) {
                    maxElem$iv = e$iv2;
                    maxValue$iv = time2;
                }
                if (!iterator$iv2.hasNext()) {
                    break;
                } else {
                    $this$maxBy$iv = $this$maxBy$iv2;
                }
            }
        }
        Instant maxTime = ((ExerciseRoute.Location) maxElem$iv).getTime();
        if (!(!minTime.isBefore(getStartTime()) && maxTime.isBefore(getEndTime()))) {
            throw new IllegalArgumentException("route can not be out of parent time range.".toString());
        }
    }

    public /* synthetic */ ExerciseSessionRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, androidx.health.connect.client.records.metadata.Metadata metadata, int i, String str, String str2, List list, List list2, ExerciseRouteResult exerciseRouteResult, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, instant2, zoneOffset2, metadata, i, (i2 & 64) != 0 ? null : str, (i2 & 128) != 0 ? null : str2, (List<ExerciseSegment>) ((i2 & 256) != 0 ? CollectionsKt.emptyList() : list), (List<ExerciseLap>) ((i2 & 512) != 0 ? CollectionsKt.emptyList() : list2), (i2 & 1024) != 0 ? new ExerciseRouteResult.NoData() : exerciseRouteResult, (i2 & 2048) != 0 ? null : str3);
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

    public final int getExerciseType() {
        return this.exerciseType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getNotes() {
        return this.notes;
    }

    public final List<ExerciseSegment> getSegments() {
        return this.segments;
    }

    public final List<ExerciseLap> getLaps() {
        return this.laps;
    }

    public final ExerciseRouteResult getExerciseRouteResult() {
        return this.exerciseRouteResult;
    }

    public final String getPlannedExerciseSessionId() {
        return this.plannedExerciseSessionId;
    }

    public /* synthetic */ ExerciseSessionRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, androidx.health.connect.client.records.metadata.Metadata metadata, int i, String str, String str2, List list, List list2, ExerciseRoute exerciseRoute, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, instant2, zoneOffset2, metadata, i, (i2 & 64) != 0 ? null : str, (i2 & 128) != 0 ? null : str2, (List<ExerciseSegment>) ((i2 & 256) != 0 ? CollectionsKt.emptyList() : list), (List<ExerciseLap>) ((i2 & 512) != 0 ? CollectionsKt.emptyList() : list2), (i2 & 1024) != 0 ? null : exerciseRoute, (i2 & 2048) != 0 ? null : str3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExerciseSessionRecord(Instant startTime, ZoneOffset startZoneOffset, Instant endTime, ZoneOffset endZoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, int exerciseType, String title, String notes, List<ExerciseSegment> segments, List<ExerciseLap> laps, ExerciseRoute exerciseRoute, String plannedExerciseSessionId) {
        this(startTime, startZoneOffset, endTime, endZoneOffset, metadata, exerciseType, title, notes, segments, laps, exerciseRoute != null ? new ExerciseRouteResult.Data(exerciseRoute) : new ExerciseRouteResult.NoData(), plannedExerciseSessionId);
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(laps, "laps");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExerciseSessionRecord(Instant startTime, ZoneOffset startZoneOffset, Instant endTime, ZoneOffset endZoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, int exerciseType) {
        this(startTime, startZoneOffset, endTime, endZoneOffset, metadata, exerciseType, (String) null, (String) null, (List) null, (List) null, (ExerciseRoute) null, (String) null, 4032, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExerciseSessionRecord(Instant startTime, ZoneOffset startZoneOffset, Instant endTime, ZoneOffset endZoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, int exerciseType, String title) {
        this(startTime, startZoneOffset, endTime, endZoneOffset, metadata, exerciseType, title, (String) null, (List) null, (List) null, (ExerciseRoute) null, (String) null, 3968, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExerciseSessionRecord(Instant startTime, ZoneOffset startZoneOffset, Instant endTime, ZoneOffset endZoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, int exerciseType, String title, String notes) {
        this(startTime, startZoneOffset, endTime, endZoneOffset, metadata, exerciseType, title, notes, (List) null, (List) null, (ExerciseRoute) null, (String) null, 3840, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExerciseSessionRecord(Instant startTime, ZoneOffset startZoneOffset, Instant endTime, ZoneOffset endZoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, int exerciseType, String title, String notes, List<ExerciseSegment> segments) {
        this(startTime, startZoneOffset, endTime, endZoneOffset, metadata, exerciseType, title, notes, segments, (List) null, (ExerciseRoute) null, (String) null, 3584, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(segments, "segments");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExerciseSessionRecord(Instant startTime, ZoneOffset startZoneOffset, Instant endTime, ZoneOffset endZoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, int exerciseType, String title, String notes, List<ExerciseSegment> segments, List<ExerciseLap> laps) {
        this(startTime, startZoneOffset, endTime, endZoneOffset, metadata, exerciseType, title, notes, segments, laps, (ExerciseRoute) null, (String) null, 3072, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(laps, "laps");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExerciseSessionRecord(Instant startTime, ZoneOffset startZoneOffset, Instant endTime, ZoneOffset endZoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, int exerciseType, String title, String notes, List<ExerciseSegment> segments, List<ExerciseLap> laps, ExerciseRoute exerciseRoute) {
        this(startTime, startZoneOffset, endTime, endZoneOffset, metadata, exerciseType, title, notes, segments, laps, exerciseRoute, (String) null, 2048, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(laps, "laps");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _init_$lambda$2(Function2 $tmp0, Object p0, Object p1) {
        return ((Number) $tmp0.invoke(p0, p1)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _init_$lambda$7(Function2 $tmp0, Object p0, Object p1) {
        return ((Number) $tmp0.invoke(p0, p1)).intValue();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ExerciseSessionRecord) && this.exerciseType == ((ExerciseSessionRecord) other).exerciseType && Intrinsics.areEqual(this.title, ((ExerciseSessionRecord) other).title) && Intrinsics.areEqual(this.notes, ((ExerciseSessionRecord) other).notes) && Intrinsics.areEqual(getStartTime(), ((ExerciseSessionRecord) other).getStartTime()) && Intrinsics.areEqual(getStartZoneOffset(), ((ExerciseSessionRecord) other).getStartZoneOffset()) && Intrinsics.areEqual(getEndTime(), ((ExerciseSessionRecord) other).getEndTime()) && Intrinsics.areEqual(getEndZoneOffset(), ((ExerciseSessionRecord) other).getEndZoneOffset()) && Intrinsics.areEqual(getMetadata(), ((ExerciseSessionRecord) other).getMetadata()) && Intrinsics.areEqual(this.segments, ((ExerciseSessionRecord) other).segments) && Intrinsics.areEqual(this.laps, ((ExerciseSessionRecord) other).laps) && Intrinsics.areEqual(this.exerciseRouteResult, ((ExerciseSessionRecord) other).exerciseRouteResult);
    }

    public int hashCode() {
        int result = Integer.hashCode(this.exerciseType);
        int i = result * 31;
        String str = this.title;
        int result2 = i + (str != null ? str.hashCode() : 0);
        int result3 = result2 * 31;
        String str2 = this.notes;
        int result4 = (result3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ZoneOffset startZoneOffset = getStartZoneOffset();
        int result5 = (((result4 + (startZoneOffset != null ? startZoneOffset.hashCode() : 0)) * 31) + getEndTime().hashCode()) * 31;
        ZoneOffset endZoneOffset = getEndZoneOffset();
        return ((((result5 + (endZoneOffset != null ? endZoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode()) * 31) + this.exerciseRouteResult.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExerciseSessionRecord(startTime=").append(getStartTime()).append(", startZoneOffset=").append(getStartZoneOffset()).append(", endTime=").append(getEndTime()).append(", endZoneOffset=").append(getEndZoneOffset()).append(", exerciseType=").append(this.exerciseType).append(", title=").append(this.title).append(", notes=").append(this.notes).append(", metadata=").append(getMetadata()).append(", segments=").append(this.segments).append(", laps=").append(this.laps).append(", exerciseRouteResult=").append(this.exerciseRouteResult).append(')');
        return sb.toString();
    }

    static {
        Iterable $this$associateBy$iv = EXERCISE_TYPE_STRING_TO_INT_MAP.entrySet();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            Map.Entry it = (Map.Entry) element$iv$iv;
            Map.Entry it2 = (Map.Entry) element$iv$iv;
            destination$iv$iv.put(Integer.valueOf(((Number) it.getValue()).intValue()), (String) it2.getKey());
        }
        EXERCISE_TYPE_INT_TO_STRING_MAP = destination$iv$iv;
    }
}
