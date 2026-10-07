package androidx.health.connect.client.records;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.units.Velocity;
import androidx.health.connect.client.units.VelocityKt;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;

/* compiled from: SpeedRecord.kt */
@Metadata(m286d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006\""}, m287d2 = {"Landroidx/health/connect/client/records/SpeedRecord;", "Landroidx/health/connect/client/records/SeriesRecord;", "Landroidx/health/connect/client/records/SpeedRecord$Sample;", "startTime", "Ljava/time/Instant;", "startZoneOffset", "Ljava/time/ZoneOffset;", "endTime", "endZoneOffset", "samples", "", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Ljava/time/Instant;Ljava/time/ZoneOffset;Ljava/util/List;Landroidx/health/connect/client/records/metadata/Metadata;)V", "getEndTime", "()Ljava/time/Instant;", "getEndZoneOffset", "()Ljava/time/ZoneOffset;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getSamples", "()Ljava/util/List;", "getStartTime", "getStartZoneOffset", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "Companion", "Sample", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class SpeedRecord implements SeriesRecord<Sample> {
    private static final Velocity MAX_SPEED;
    public static final AggregateMetric<Velocity> SPEED_AVG;
    private static final String SPEED_FIELD_NAME = "speed";
    public static final AggregateMetric<Velocity> SPEED_MAX;
    public static final AggregateMetric<Velocity> SPEED_MIN;
    private static final String SPEED_TYPE_NAME = "SpeedSeries";
    private final Instant endTime;
    private final ZoneOffset endZoneOffset;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final List<Sample> samples;
    private final Instant startTime;
    private final ZoneOffset startZoneOffset;

    public SpeedRecord(Instant startTime, ZoneOffset startZoneOffset, Instant endTime, ZoneOffset endZoneOffset, List<Sample> samples, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(samples, "samples");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.startTime = startTime;
        this.startZoneOffset = startZoneOffset;
        this.endTime = endTime;
        this.endZoneOffset = endZoneOffset;
        this.samples = samples;
        this.metadata = metadata;
        if (getStartTime().isAfter(getEndTime())) {
            throw new IllegalArgumentException("startTime must not be after endTime.".toString());
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

    @Override // androidx.health.connect.client.records.SeriesRecord
    public List<Sample> getSamples() {
        return this.samples;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SpeedRecord) && Intrinsics.areEqual(getStartTime(), ((SpeedRecord) other).getStartTime()) && Intrinsics.areEqual(getStartZoneOffset(), ((SpeedRecord) other).getStartZoneOffset()) && Intrinsics.areEqual(getEndTime(), ((SpeedRecord) other).getEndTime()) && Intrinsics.areEqual(getEndZoneOffset(), ((SpeedRecord) other).getEndZoneOffset()) && Intrinsics.areEqual(getSamples(), ((SpeedRecord) other).getSamples()) && Intrinsics.areEqual(getMetadata(), ((SpeedRecord) other).getMetadata());
    }

    public int hashCode() {
        int result = getStartTime().hashCode();
        int i = result * 31;
        ZoneOffset startZoneOffset = getStartZoneOffset();
        int result2 = i + (startZoneOffset != null ? startZoneOffset.hashCode() : 0);
        int result3 = ((result2 * 31) + getEndTime().hashCode()) * 31;
        ZoneOffset endZoneOffset = getEndZoneOffset();
        return ((((result3 + (endZoneOffset != null ? endZoneOffset.hashCode() : 0)) * 31) + getSamples().hashCode()) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "SpeedRecord(startTime=" + getStartTime() + ", startZoneOffset=" + getStartZoneOffset() + ", endTime=" + getEndTime() + ", endZoneOffset=" + getEndZoneOffset() + ", samples=" + getSamples() + ", metadata=" + getMetadata() + ')';
    }

    static {
        Velocity metersPerSecond;
        metersPerSecond = VelocityKt.getMetersPerSecond((double) DurationKt.NANOS_IN_MILLIS);
        MAX_SPEED = metersPerSecond;
        SPEED_AVG = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(SPEED_TYPE_NAME, AggregateMetric.AggregationType.AVERAGE, SPEED_FIELD_NAME, new SpeedRecord$Companion$SPEED_AVG$1(Velocity.INSTANCE));
        SPEED_MIN = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(SPEED_TYPE_NAME, AggregateMetric.AggregationType.MINIMUM, SPEED_FIELD_NAME, new SpeedRecord$Companion$SPEED_MIN$1(Velocity.INSTANCE));
        SPEED_MAX = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(SPEED_TYPE_NAME, AggregateMetric.AggregationType.MAXIMUM, SPEED_FIELD_NAME, new SpeedRecord$Companion$SPEED_MAX$1(Velocity.INSTANCE));
    }

    /* compiled from: SpeedRecord.kt */
    @Metadata(m286d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, m287d2 = {"Landroidx/health/connect/client/records/SpeedRecord$Sample;", "", "time", "Ljava/time/Instant;", SpeedRecord.SPEED_FIELD_NAME, "Landroidx/health/connect/client/units/Velocity;", "(Ljava/time/Instant;Landroidx/health/connect/client/units/Velocity;)V", "getSpeed", "()Landroidx/health/connect/client/units/Velocity;", "getTime", "()Ljava/time/Instant;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "toString", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class Sample {
        private final Velocity speed;
        private final Instant time;

        public Sample(Instant time, Velocity speed) {
            Intrinsics.checkNotNullParameter(time, "time");
            Intrinsics.checkNotNullParameter(speed, "speed");
            this.time = time;
            this.speed = speed;
            UtilsKt.requireNotLess(this.speed, this.speed.zero$connect_client_release(), SpeedRecord.SPEED_FIELD_NAME);
            UtilsKt.requireNotMore(this.speed, SpeedRecord.MAX_SPEED, SpeedRecord.SPEED_FIELD_NAME);
        }

        public final Instant getTime() {
            return this.time;
        }

        public final Velocity getSpeed() {
            return this.speed;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Sample) && Intrinsics.areEqual(this.time, ((Sample) other).time) && Intrinsics.areEqual(this.speed, ((Sample) other).speed);
        }

        public int hashCode() {
            int result = this.time.hashCode();
            return (result * 31) + this.speed.hashCode();
        }

        public String toString() {
            return "Sample(time=" + this.time + ", speed=" + this.speed + ')';
        }
    }
}
