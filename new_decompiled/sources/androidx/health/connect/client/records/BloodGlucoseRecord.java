package androidx.health.connect.client.records;

import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.units.BloodGlucose;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BloodGlucoseRecord.kt */
@Metadata(m286d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0005&'()*BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010#\u001a\u00020\u000bH\u0016J\b\u0010$\u001a\u00020%H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\f\u001a\u00020\u000b¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\r\u001a\u00020\u000b¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010\n\u001a\u00020\u000b¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006+"}, m287d2 = {"Landroidx/health/connect/client/records/BloodGlucoseRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "time", "Ljava/time/Instant;", "zoneOffset", "Ljava/time/ZoneOffset;", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "level", "Landroidx/health/connect/client/units/BloodGlucose;", "specimenSource", "", "mealType", "relationToMeal", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;Landroidx/health/connect/client/units/BloodGlucose;III)V", "getLevel", "()Landroidx/health/connect/client/units/BloodGlucose;", "getMealType$annotations", "()V", "getMealType", "()I", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getRelationToMeal$annotations", "getRelationToMeal", "getSpecimenSource$annotations", "getSpecimenSource", "getTime", "()Ljava/time/Instant;", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "toString", "", "Companion", "RelationToMeal", "RelationToMeals", "SpecimenSource", "SpecimenSources", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class BloodGlucoseRecord implements InstantaneousRecord {
    public static final int RELATION_TO_MEAL_AFTER_MEAL = 4;
    public static final int RELATION_TO_MEAL_BEFORE_MEAL = 3;
    public static final int RELATION_TO_MEAL_FASTING = 2;
    public static final int RELATION_TO_MEAL_GENERAL = 1;
    public static final int RELATION_TO_MEAL_UNKNOWN = 0;
    public static final int SPECIMEN_SOURCE_CAPILLARY_BLOOD = 2;
    public static final int SPECIMEN_SOURCE_INTERSTITIAL_FLUID = 1;
    public static final int SPECIMEN_SOURCE_PLASMA = 3;
    public static final int SPECIMEN_SOURCE_SERUM = 4;
    public static final int SPECIMEN_SOURCE_TEARS = 5;
    public static final int SPECIMEN_SOURCE_UNKNOWN = 0;
    public static final int SPECIMEN_SOURCE_WHOLE_BLOOD = 6;
    private final BloodGlucose level;
    private final int mealType;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final int relationToMeal;
    private final int specimenSource;
    private final Instant time;
    private final ZoneOffset zoneOffset;
    private static final BloodGlucose MAX_BLOOD_GLUCOSE_LEVEL = BloodGlucose.INSTANCE.millimolesPerLiter(50.0d);
    public static final Map<String, Integer> RELATION_TO_MEAL_STRING_TO_INT_MAP = MapsKt.mapOf(TuplesKt.m294to(RelationToMeal.GENERAL, 1), TuplesKt.m294to(RelationToMeal.AFTER_MEAL, 4), TuplesKt.m294to(RelationToMeal.FASTING, 2), TuplesKt.m294to(RelationToMeal.BEFORE_MEAL, 3));
    public static final Map<Integer, String> RELATION_TO_MEAL_INT_TO_STRING_MAP = UtilsKt.reverse(RELATION_TO_MEAL_STRING_TO_INT_MAP);
    public static final Map<String, Integer> SPECIMEN_SOURCE_STRING_TO_INT_MAP = MapsKt.mapOf(TuplesKt.m294to(SpecimenSource.INTERSTITIAL_FLUID, 1), TuplesKt.m294to(SpecimenSource.CAPILLARY_BLOOD, 2), TuplesKt.m294to(SpecimenSource.PLASMA, 3), TuplesKt.m294to(SpecimenSource.TEARS, 5), TuplesKt.m294to(SpecimenSource.WHOLE_BLOOD, 6), TuplesKt.m294to(SpecimenSource.SERUM, 4));
    public static final Map<Integer, String> SPECIMEN_SOURCE_INT_TO_STRING_MAP = UtilsKt.reverse(SPECIMEN_SOURCE_STRING_TO_INT_MAP);

    /* compiled from: BloodGlucoseRecord.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m287d2 = {"Landroidx/health/connect/client/records/BloodGlucoseRecord$RelationToMeals;", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface RelationToMeals {
    }

    /* compiled from: BloodGlucoseRecord.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m287d2 = {"Landroidx/health/connect/client/records/BloodGlucoseRecord$SpecimenSources;", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface SpecimenSources {
    }

    public static /* synthetic */ void getMealType$annotations() {
    }

    public static /* synthetic */ void getRelationToMeal$annotations() {
    }

    public static /* synthetic */ void getSpecimenSource$annotations() {
    }

    public BloodGlucoseRecord(Instant time, ZoneOffset zoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, BloodGlucose level, int specimenSource, int mealType, int relationToMeal) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(level, "level");
        this.time = time;
        this.zoneOffset = zoneOffset;
        this.metadata = metadata;
        this.level = level;
        this.specimenSource = specimenSource;
        this.mealType = mealType;
        this.relationToMeal = relationToMeal;
        UtilsKt.requireNotLess(this.level, this.level.zero$connect_client_release(), "level");
        UtilsKt.requireNotMore(this.level, MAX_BLOOD_GLUCOSE_LEVEL, "level");
    }

    public /* synthetic */ BloodGlucoseRecord(Instant instant, ZoneOffset zoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, BloodGlucose bloodGlucose, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, metadata, bloodGlucose, (i4 & 16) != 0 ? 0 : i, (i4 & 32) != 0 ? 0 : i2, (i4 & 64) != 0 ? 0 : i3);
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public Instant getTime() {
        return this.time;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public final BloodGlucose getLevel() {
        return this.level;
    }

    public final int getSpecimenSource() {
        return this.specimenSource;
    }

    public final int getMealType() {
        return this.mealType;
    }

    public final int getRelationToMeal() {
        return this.relationToMeal;
    }

    /* compiled from: BloodGlucoseRecord.kt */
    @Metadata(m286d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m287d2 = {"Landroidx/health/connect/client/records/BloodGlucoseRecord$SpecimenSource;", "", "()V", "CAPILLARY_BLOOD", "", "INTERSTITIAL_FLUID", "PLASMA", "SERUM", "TEARS", "WHOLE_BLOOD", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class SpecimenSource {
        public static final String CAPILLARY_BLOOD = "capillary_blood";
        public static final SpecimenSource INSTANCE = new SpecimenSource();
        public static final String INTERSTITIAL_FLUID = "interstitial_fluid";
        public static final String PLASMA = "plasma";
        public static final String SERUM = "serum";
        public static final String TEARS = "tears";
        public static final String WHOLE_BLOOD = "whole_blood";

        private SpecimenSource() {
        }
    }

    /* compiled from: BloodGlucoseRecord.kt */
    @Metadata(m286d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m287d2 = {"Landroidx/health/connect/client/records/BloodGlucoseRecord$RelationToMeal;", "", "()V", "AFTER_MEAL", "", "BEFORE_MEAL", "FASTING", "GENERAL", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class RelationToMeal {
        public static final String AFTER_MEAL = "after_meal";
        public static final String BEFORE_MEAL = "before_meal";
        public static final String FASTING = "fasting";
        public static final String GENERAL = "general";
        public static final RelationToMeal INSTANCE = new RelationToMeal();

        private RelationToMeal() {
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.health.connect.client.records.BloodGlucoseRecord");
        return Intrinsics.areEqual(getTime(), ((BloodGlucoseRecord) other).getTime()) && Intrinsics.areEqual(getZoneOffset(), ((BloodGlucoseRecord) other).getZoneOffset()) && Intrinsics.areEqual(this.level, ((BloodGlucoseRecord) other).level) && this.specimenSource == ((BloodGlucoseRecord) other).specimenSource && this.mealType == ((BloodGlucoseRecord) other).mealType && this.relationToMeal == ((BloodGlucoseRecord) other).relationToMeal && Intrinsics.areEqual(getMetadata(), ((BloodGlucoseRecord) other).getMetadata());
    }

    public int hashCode() {
        int result = getTime().hashCode();
        int i = result * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        int result2 = i + (zoneOffset != null ? zoneOffset.hashCode() : 0);
        return (((((((((result2 * 31) + this.level.hashCode()) * 31) + this.specimenSource) * 31) + this.mealType) * 31) + this.relationToMeal) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "BloodGlucoseRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", level=" + this.level + ", specimenSource=" + this.specimenSource + ", mealType=" + this.mealType + ", relationToMeal=" + this.relationToMeal + ", metadata=" + getMetadata() + ')';
    }
}
