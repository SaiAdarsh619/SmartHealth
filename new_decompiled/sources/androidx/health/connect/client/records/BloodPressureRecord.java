package androidx.health.connect.client.records;

import android.os.Build;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.impl.platform.records.RecordConvertersKt;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.units.Pressure;
import androidx.health.connect.client.units.PressureKt;
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

/* compiled from: BloodPressureRecord.kt */
@Metadata(m286d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0005%&'()BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020$H\u0016R\u0017\u0010\u000b\u001a\u00020\f¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\r\u001a\u00020\f¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006*"}, m287d2 = {"Landroidx/health/connect/client/records/BloodPressureRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "time", "Ljava/time/Instant;", "zoneOffset", "Ljava/time/ZoneOffset;", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", BloodPressureRecord.SYSTOLIC_FIELD_NAME, "Landroidx/health/connect/client/units/Pressure;", BloodPressureRecord.DIASTOLIC_FIELD_NAME, "bodyPosition", "", "measurementLocation", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;Landroidx/health/connect/client/units/Pressure;Landroidx/health/connect/client/units/Pressure;II)V", "getBodyPosition$annotations", "()V", "getBodyPosition", "()I", "getDiastolic", "()Landroidx/health/connect/client/units/Pressure;", "getMeasurementLocation$annotations", "getMeasurementLocation", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getSystolic", "getTime", "()Ljava/time/Instant;", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "toString", "", "BodyPosition", "BodyPositions", "Companion", "MeasurementLocation", "MeasurementLocations", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class BloodPressureRecord implements InstantaneousRecord {
    private static final String BLOOD_PRESSURE_NAME = "BloodPressure";
    public static final int BODY_POSITION_LYING_DOWN = 3;
    public static final int BODY_POSITION_RECLINING = 4;
    public static final int BODY_POSITION_SITTING_DOWN = 2;
    public static final int BODY_POSITION_STANDING_UP = 1;
    public static final int BODY_POSITION_UNKNOWN = 0;
    public static final AggregateMetric<Pressure> DIASTOLIC_AVG;
    private static final String DIASTOLIC_FIELD_NAME = "diastolic";
    public static final AggregateMetric<Pressure> DIASTOLIC_MAX;
    public static final AggregateMetric<Pressure> DIASTOLIC_MIN;
    private static final Pressure MAX_DIASTOLIC;
    private static final Pressure MAX_SYSTOLIC;
    public static final int MEASUREMENT_LOCATION_LEFT_UPPER_ARM = 3;
    public static final int MEASUREMENT_LOCATION_LEFT_WRIST = 1;
    public static final int MEASUREMENT_LOCATION_RIGHT_UPPER_ARM = 4;
    public static final int MEASUREMENT_LOCATION_RIGHT_WRIST = 2;
    public static final int MEASUREMENT_LOCATION_UNKNOWN = 0;
    private static final Pressure MIN_DIASTOLIC;
    private static final Pressure MIN_SYSTOLIC;
    public static final AggregateMetric<Pressure> SYSTOLIC_AVG;
    private static final String SYSTOLIC_FIELD_NAME = "systolic";
    public static final AggregateMetric<Pressure> SYSTOLIC_MAX;
    public static final AggregateMetric<Pressure> SYSTOLIC_MIN;
    private final int bodyPosition;
    private final Pressure diastolic;
    private final int measurementLocation;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Pressure systolic;
    private final Instant time;
    private final ZoneOffset zoneOffset;
    public static final Map<String, Integer> MEASUREMENT_LOCATION_STRING_TO_INT_MAP = MapsKt.mapOf(TuplesKt.m294to(MeasurementLocation.LEFT_UPPER_ARM, 3), TuplesKt.m294to(MeasurementLocation.LEFT_WRIST, 1), TuplesKt.m294to(MeasurementLocation.RIGHT_UPPER_ARM, 4), TuplesKt.m294to(MeasurementLocation.RIGHT_WRIST, 2));
    public static final Map<Integer, String> MEASUREMENT_LOCATION_INT_TO_STRING_MAP = UtilsKt.reverse(MEASUREMENT_LOCATION_STRING_TO_INT_MAP);
    public static final Map<String, Integer> BODY_POSITION_STRING_TO_INT_MAP = MapsKt.mapOf(TuplesKt.m294to(BodyPosition.LYING_DOWN, 3), TuplesKt.m294to(BodyPosition.RECLINING, 4), TuplesKt.m294to(BodyPosition.SITTING_DOWN, 2), TuplesKt.m294to(BodyPosition.STANDING_UP, 1));
    public static final Map<Integer, String> BODY_POSITION_INT_TO_STRING_MAP = UtilsKt.reverse(BODY_POSITION_STRING_TO_INT_MAP);

    /* compiled from: BloodPressureRecord.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m287d2 = {"Landroidx/health/connect/client/records/BloodPressureRecord$BodyPositions;", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface BodyPositions {
    }

    /* compiled from: BloodPressureRecord.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m287d2 = {"Landroidx/health/connect/client/records/BloodPressureRecord$MeasurementLocations;", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface MeasurementLocations {
    }

    public static /* synthetic */ void getBodyPosition$annotations() {
    }

    public static /* synthetic */ void getMeasurementLocation$annotations() {
    }

    public BloodPressureRecord(Instant time, ZoneOffset zoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, Pressure systolic, Pressure diastolic, int bodyPosition, int measurementLocation) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(systolic, "systolic");
        Intrinsics.checkNotNullParameter(diastolic, "diastolic");
        this.time = time;
        this.zoneOffset = zoneOffset;
        this.metadata = metadata;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.bodyPosition = bodyPosition;
        this.measurementLocation = measurementLocation;
        if (Build.VERSION.SDK_INT >= 34) {
            RecordConvertersKt.toPlatformRecord(this);
            return;
        }
        UtilsKt.requireNotLess(this.systolic, MIN_SYSTOLIC, SYSTOLIC_FIELD_NAME);
        UtilsKt.requireNotMore(this.systolic, MAX_SYSTOLIC, SYSTOLIC_FIELD_NAME);
        UtilsKt.requireNotLess(this.diastolic, MIN_DIASTOLIC, DIASTOLIC_FIELD_NAME);
        UtilsKt.requireNotMore(this.diastolic, MAX_DIASTOLIC, DIASTOLIC_FIELD_NAME);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ BloodPressureRecord(Instant instant, ZoneOffset zoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, Pressure pressure, Pressure pressure2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, metadata, pressure, pressure2, r8, r9);
        int i4;
        int i5;
        if ((i3 & 32) == 0) {
            i4 = i;
        } else {
            i4 = 0;
        }
        if ((i3 & 64) == 0) {
            i5 = i2;
        } else {
            i5 = 0;
        }
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

    public final Pressure getSystolic() {
        return this.systolic;
    }

    public final Pressure getDiastolic() {
        return this.diastolic;
    }

    public final int getBodyPosition() {
        return this.bodyPosition;
    }

    public final int getMeasurementLocation() {
        return this.measurementLocation;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BloodPressureRecord) && Intrinsics.areEqual(this.systolic, ((BloodPressureRecord) other).systolic) && Intrinsics.areEqual(this.diastolic, ((BloodPressureRecord) other).diastolic) && this.bodyPosition == ((BloodPressureRecord) other).bodyPosition && this.measurementLocation == ((BloodPressureRecord) other).measurementLocation && Intrinsics.areEqual(getTime(), ((BloodPressureRecord) other).getTime()) && Intrinsics.areEqual(getZoneOffset(), ((BloodPressureRecord) other).getZoneOffset()) && Intrinsics.areEqual(getMetadata(), ((BloodPressureRecord) other).getMetadata());
    }

    public int hashCode() {
        int result = this.systolic.hashCode();
        int result2 = ((((((((result * 31) + this.diastolic.hashCode()) * 31) + this.bodyPosition) * 31) + this.measurementLocation) * 31) + getTime().hashCode()) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return ((result2 + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "BloodPressureRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", systolic=" + this.systolic + ", diastolic=" + this.diastolic + ", bodyPosition=" + this.bodyPosition + ", measurementLocation=" + this.measurementLocation + ", metadata=" + getMetadata() + ')';
    }

    /* compiled from: BloodPressureRecord.kt */
    @Metadata(m286d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m287d2 = {"Landroidx/health/connect/client/records/BloodPressureRecord$MeasurementLocation;", "", "()V", "LEFT_UPPER_ARM", "", "LEFT_WRIST", "RIGHT_UPPER_ARM", "RIGHT_WRIST", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class MeasurementLocation {
        public static final MeasurementLocation INSTANCE = new MeasurementLocation();
        public static final String LEFT_UPPER_ARM = "left_upper_arm";
        public static final String LEFT_WRIST = "left_wrist";
        public static final String RIGHT_UPPER_ARM = "right_upper_arm";
        public static final String RIGHT_WRIST = "right_wrist";

        private MeasurementLocation() {
        }
    }

    /* compiled from: BloodPressureRecord.kt */
    @Metadata(m286d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m287d2 = {"Landroidx/health/connect/client/records/BloodPressureRecord$BodyPosition;", "", "()V", "LYING_DOWN", "", "RECLINING", "SITTING_DOWN", "STANDING_UP", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class BodyPosition {
        public static final BodyPosition INSTANCE = new BodyPosition();
        public static final String LYING_DOWN = "lying_down";
        public static final String RECLINING = "reclining";
        public static final String SITTING_DOWN = "sitting_down";
        public static final String STANDING_UP = "standing_up";

        private BodyPosition() {
        }
    }

    static {
        Pressure millimetersOfMercury;
        Pressure millimetersOfMercury2;
        Pressure millimetersOfMercury3;
        Pressure millimetersOfMercury4;
        millimetersOfMercury = PressureKt.getMillimetersOfMercury(9.9E-323d);
        MIN_SYSTOLIC = millimetersOfMercury;
        millimetersOfMercury2 = PressureKt.getMillimetersOfMercury(9.9E-322d);
        MAX_SYSTOLIC = millimetersOfMercury2;
        millimetersOfMercury3 = PressureKt.getMillimetersOfMercury(4.9E-323d);
        MIN_DIASTOLIC = millimetersOfMercury3;
        millimetersOfMercury4 = PressureKt.getMillimetersOfMercury(8.9E-322d);
        MAX_DIASTOLIC = millimetersOfMercury4;
        SYSTOLIC_AVG = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(BLOOD_PRESSURE_NAME, AggregateMetric.AggregationType.AVERAGE, SYSTOLIC_FIELD_NAME, new BloodPressureRecord$Companion$SYSTOLIC_AVG$1(Pressure.INSTANCE));
        SYSTOLIC_MIN = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(BLOOD_PRESSURE_NAME, AggregateMetric.AggregationType.MINIMUM, SYSTOLIC_FIELD_NAME, new BloodPressureRecord$Companion$SYSTOLIC_MIN$1(Pressure.INSTANCE));
        SYSTOLIC_MAX = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(BLOOD_PRESSURE_NAME, AggregateMetric.AggregationType.MAXIMUM, SYSTOLIC_FIELD_NAME, new BloodPressureRecord$Companion$SYSTOLIC_MAX$1(Pressure.INSTANCE));
        DIASTOLIC_AVG = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(BLOOD_PRESSURE_NAME, AggregateMetric.AggregationType.AVERAGE, DIASTOLIC_FIELD_NAME, new BloodPressureRecord$Companion$DIASTOLIC_AVG$1(Pressure.INSTANCE));
        DIASTOLIC_MIN = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(BLOOD_PRESSURE_NAME, AggregateMetric.AggregationType.MINIMUM, DIASTOLIC_FIELD_NAME, new BloodPressureRecord$Companion$DIASTOLIC_MIN$1(Pressure.INSTANCE));
        DIASTOLIC_MAX = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(BLOOD_PRESSURE_NAME, AggregateMetric.AggregationType.MAXIMUM, DIASTOLIC_FIELD_NAME, new BloodPressureRecord$Companion$DIASTOLIC_MAX$1(Pressure.INSTANCE));
    }
}
