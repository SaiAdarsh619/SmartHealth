package androidx.health.connect.client.records;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.units.Temperature;
import androidx.health.connect.client.units.TemperatureDelta;
import androidx.health.connect.client.units.TemperatureKt;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SkinTemperatureRecord.kt */
@Metadata(m286d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0002'(BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0002J\b\u0010$\u001a\u00020\u0010H\u0016J\b\u0010%\u001a\u00020&H\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019¨\u0006)"}, m287d2 = {"Landroidx/health/connect/client/records/SkinTemperatureRecord;", "Landroidx/health/connect/client/records/IntervalRecord;", "startTime", "Ljava/time/Instant;", "startZoneOffset", "Ljava/time/ZoneOffset;", "endTime", "endZoneOffset", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "deltas", "", "Landroidx/health/connect/client/records/SkinTemperatureRecord$Delta;", "baseline", "Landroidx/health/connect/client/units/Temperature;", "measurementLocation", "", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;Ljava/util/List;Landroidx/health/connect/client/units/Temperature;I)V", "getBaseline", "()Landroidx/health/connect/client/units/Temperature;", "getDeltas", "()Ljava/util/List;", "getEndTime", "()Ljava/time/Instant;", "getEndZoneOffset", "()Ljava/time/ZoneOffset;", "getMeasurementLocation", "()I", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getStartTime", "getStartZoneOffset", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "toString", "", "Companion", "Delta", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class SkinTemperatureRecord implements IntervalRecord {
    private static final Temperature MAX_TEMPERATURE;
    public static final int MEASUREMENT_LOCATION_FINGER = 1;
    public static final Map<Integer, String> MEASUREMENT_LOCATION_INT_TO_STRING_MAP;
    public static final Map<String, Integer> MEASUREMENT_LOCATION_STRING_TO_INT_MAP;
    public static final int MEASUREMENT_LOCATION_TOE = 2;
    public static final int MEASUREMENT_LOCATION_UNKNOWN = 0;
    public static final int MEASUREMENT_LOCATION_WRIST = 3;
    private static final Temperature MIN_TEMPERATURE;
    private static final String SKIN_TEMPERATURE_TYPE_NAME = "SkinTemperature";
    public static final AggregateMetric<TemperatureDelta> TEMPERATURE_DELTA_AVG;
    private static final String TEMPERATURE_DELTA_FIELD_NAME = "temperatureDelta";
    public static final AggregateMetric<TemperatureDelta> TEMPERATURE_DELTA_MAX;
    public static final AggregateMetric<TemperatureDelta> TEMPERATURE_DELTA_MIN;
    private final Temperature baseline;
    private final List<Delta> deltas;
    private final Instant endTime;
    private final ZoneOffset endZoneOffset;
    private final int measurementLocation;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Instant startTime;
    private final ZoneOffset startZoneOffset;

    public SkinTemperatureRecord(Instant startTime, ZoneOffset startZoneOffset, Instant endTime, ZoneOffset endZoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, List<Delta> deltas, Temperature baseline, int measurementLocation) {
        SkinTemperatureRecord skinTemperatureRecord = this;
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(deltas, "deltas");
        skinTemperatureRecord.startTime = startTime;
        skinTemperatureRecord.startZoneOffset = startZoneOffset;
        skinTemperatureRecord.endTime = endTime;
        skinTemperatureRecord.endZoneOffset = endZoneOffset;
        skinTemperatureRecord.metadata = metadata;
        skinTemperatureRecord.deltas = deltas;
        skinTemperatureRecord.baseline = baseline;
        skinTemperatureRecord.measurementLocation = measurementLocation;
        if (!getStartTime().isBefore(getEndTime())) {
            throw new IllegalArgumentException("startTime must be before endTime.".toString());
        }
        if (skinTemperatureRecord.baseline != null) {
            UtilsKt.requireNotLess(skinTemperatureRecord.baseline, MIN_TEMPERATURE, "temperature");
            UtilsKt.requireNotMore(skinTemperatureRecord.baseline, MAX_TEMPERATURE, "temperature");
        }
        if (skinTemperatureRecord.deltas.isEmpty()) {
            return;
        }
        Iterable $this$minBy$iv = skinTemperatureRecord.deltas;
        Iterator iterator$iv = $this$minBy$iv.iterator();
        if (!iterator$iv.hasNext()) {
            throw new NoSuchElementException();
        }
        Object minElem$iv = iterator$iv.next();
        if (iterator$iv.hasNext()) {
            Delta it = (Delta) minElem$iv;
            Comparable minValue$iv = it.getTime();
            while (true) {
                Object e$iv = iterator$iv.next();
                Delta it2 = (Delta) e$iv;
                Instant time = it2.getTime();
                if (minValue$iv.compareTo(time) > 0) {
                    minElem$iv = e$iv;
                    minValue$iv = time;
                }
                if (!iterator$iv.hasNext()) {
                    break;
                } else {
                    skinTemperatureRecord = this;
                }
            }
        }
        if (((Delta) minElem$iv).getTime().isBefore(getStartTime())) {
            throw new IllegalArgumentException("deltas can not be out of parent time range.".toString());
        }
        Iterable $this$maxBy$iv = skinTemperatureRecord.deltas;
        Iterator iterator$iv2 = $this$maxBy$iv.iterator();
        if (!iterator$iv2.hasNext()) {
            throw new NoSuchElementException();
        }
        Object maxElem$iv = iterator$iv2.next();
        if (iterator$iv2.hasNext()) {
            Delta it3 = (Delta) maxElem$iv;
            Comparable maxValue$iv = it3.getTime();
            do {
                Object e$iv2 = iterator$iv2.next();
                Delta it4 = (Delta) e$iv2;
                Instant time2 = it4.getTime();
                if (maxValue$iv.compareTo(time2) < 0) {
                    maxElem$iv = e$iv2;
                    maxValue$iv = time2;
                }
            } while (iterator$iv2.hasNext());
        }
        if (!((Delta) maxElem$iv).getTime().isBefore(getEndTime())) {
            throw new IllegalArgumentException("deltas can not be out of parent time range.".toString());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SkinTemperatureRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, androidx.health.connect.client.records.metadata.Metadata metadata, List list, Temperature temperature, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, instant2, zoneOffset2, metadata, list, r9, r10);
        Temperature temperature2;
        int i3;
        if ((i2 & 64) == 0) {
            temperature2 = temperature;
        } else {
            temperature2 = null;
        }
        if ((i2 & 128) == 0) {
            i3 = i;
        } else {
            i3 = 0;
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

    public final List<Delta> getDeltas() {
        return this.deltas;
    }

    public final Temperature getBaseline() {
        return this.baseline;
    }

    public final int getMeasurementLocation() {
        return this.measurementLocation;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SkinTemperatureRecord) && Intrinsics.areEqual(getStartTime(), ((SkinTemperatureRecord) other).getStartTime()) && Intrinsics.areEqual(getEndTime(), ((SkinTemperatureRecord) other).getEndTime()) && Intrinsics.areEqual(getStartZoneOffset(), ((SkinTemperatureRecord) other).getStartZoneOffset()) && Intrinsics.areEqual(getEndZoneOffset(), ((SkinTemperatureRecord) other).getEndZoneOffset()) && Intrinsics.areEqual(this.baseline, ((SkinTemperatureRecord) other).baseline) && this.measurementLocation == ((SkinTemperatureRecord) other).measurementLocation && Intrinsics.areEqual(this.deltas, ((SkinTemperatureRecord) other).deltas) && Intrinsics.areEqual(getMetadata(), ((SkinTemperatureRecord) other).getMetadata());
    }

    public int hashCode() {
        int result = getStartTime().hashCode();
        int result2 = ((result * 31) + getEndTime().hashCode()) * 31;
        ZoneOffset startZoneOffset = getStartZoneOffset();
        int result3 = (result2 + (startZoneOffset != null ? startZoneOffset.hashCode() : 0)) * 31;
        ZoneOffset endZoneOffset = getEndZoneOffset();
        int result4 = (result3 + (endZoneOffset != null ? endZoneOffset.hashCode() : 0)) * 31;
        Temperature temperature = this.baseline;
        return ((((((result4 + (temperature != null ? temperature.hashCode() : 0)) * 31) + Integer.hashCode(this.measurementLocation)) * 31) + this.deltas.hashCode()) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "SkinTemperatureRecord(startTime=" + getStartTime() + ", startZoneOffset=" + getStartZoneOffset() + ", endTime=" + getEndTime() + ", endZoneOffset=" + getEndZoneOffset() + ", deltas=" + this.deltas + ", baseline=" + this.baseline + ", measurementLocation=" + this.measurementLocation + ", metadata=" + getMetadata() + ')';
    }

    static {
        Temperature celsius;
        Temperature celsius2;
        celsius = TemperatureKt.getCelsius(0.0d);
        MIN_TEMPERATURE = celsius;
        celsius2 = TemperatureKt.getCelsius(4.94E-322d);
        MAX_TEMPERATURE = celsius2;
        TEMPERATURE_DELTA_AVG = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(SKIN_TEMPERATURE_TYPE_NAME, AggregateMetric.AggregationType.AVERAGE, TEMPERATURE_DELTA_FIELD_NAME, new SkinTemperatureRecord$Companion$TEMPERATURE_DELTA_AVG$1(TemperatureDelta.INSTANCE));
        TEMPERATURE_DELTA_MIN = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(SKIN_TEMPERATURE_TYPE_NAME, AggregateMetric.AggregationType.MINIMUM, TEMPERATURE_DELTA_FIELD_NAME, new SkinTemperatureRecord$Companion$TEMPERATURE_DELTA_MIN$1(TemperatureDelta.INSTANCE));
        TEMPERATURE_DELTA_MAX = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(SKIN_TEMPERATURE_TYPE_NAME, AggregateMetric.AggregationType.MAXIMUM, TEMPERATURE_DELTA_FIELD_NAME, new SkinTemperatureRecord$Companion$TEMPERATURE_DELTA_MAX$1(TemperatureDelta.INSTANCE));
        MEASUREMENT_LOCATION_STRING_TO_INT_MAP = MapsKt.mapOf(TuplesKt.m294to(BodyTemperatureMeasurementLocation.FINGER, 1), TuplesKt.m294to(BodyTemperatureMeasurementLocation.TOE, 2), TuplesKt.m294to(BodyTemperatureMeasurementLocation.WRIST, 3));
        MEASUREMENT_LOCATION_INT_TO_STRING_MAP = UtilsKt.reverse(MEASUREMENT_LOCATION_STRING_TO_INT_MAP);
    }

    /* compiled from: SkinTemperatureRecord.kt */
    @Metadata(m286d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, m287d2 = {"Landroidx/health/connect/client/records/SkinTemperatureRecord$Delta;", "", "time", "Ljava/time/Instant;", "delta", "Landroidx/health/connect/client/units/TemperatureDelta;", "(Ljava/time/Instant;Landroidx/health/connect/client/units/TemperatureDelta;)V", "getDelta", "()Landroidx/health/connect/client/units/TemperatureDelta;", "getTime", "()Ljava/time/Instant;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "toString", "", "Companion", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class Delta {
        private final TemperatureDelta delta;
        private final Instant time;
        private static final Companion Companion = new Companion(null);
        private static final TemperatureDelta MIN_DELTA_TEMPERATURE = TemperatureDelta.INSTANCE.celsius(-30.0d);
        private static final TemperatureDelta MAX_DELTA_TEMPERATURE = TemperatureDelta.INSTANCE.celsius(30.0d);

        public Delta(Instant time, TemperatureDelta delta) {
            Intrinsics.checkNotNullParameter(time, "time");
            Intrinsics.checkNotNullParameter(delta, "delta");
            this.time = time;
            this.delta = delta;
            UtilsKt.requireNotLess(this.delta, MIN_DELTA_TEMPERATURE, "delta");
            UtilsKt.requireNotMore(this.delta, MAX_DELTA_TEMPERATURE, "delta");
        }

        public final TemperatureDelta getDelta() {
            return this.delta;
        }

        public final Instant getTime() {
            return this.time;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.health.connect.client.records.SkinTemperatureRecord.Delta");
            return Intrinsics.areEqual(this.time, ((Delta) other).time) && Intrinsics.areEqual(this.delta, ((Delta) other).delta);
        }

        public int hashCode() {
            int result = this.time.hashCode();
            return (result * 31) + this.delta.hashCode();
        }

        public String toString() {
            return "Delta(time=" + this.time + ", delta=" + this.delta + ')';
        }

        /* compiled from: SkinTemperatureRecord.kt */
        @Metadata(m286d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m287d2 = {"Landroidx/health/connect/client/records/SkinTemperatureRecord$Delta$Companion;", "", "()V", "MAX_DELTA_TEMPERATURE", "Landroidx/health/connect/client/units/TemperatureDelta;", "MIN_DELTA_TEMPERATURE", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
