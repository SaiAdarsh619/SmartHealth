package androidx.health.connect.client.records;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.units.Length;
import androidx.health.connect.client.units.LengthKt;
import java.time.Instant;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeightRecord.kt */
@Metadata(m286d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, m287d2 = {"Landroidx/health/connect/client/records/HeightRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "time", "Ljava/time/Instant;", "zoneOffset", "Ljava/time/ZoneOffset;", HeightRecord.HEIGHT_FIELD_NAME, "Landroidx/health/connect/client/units/Length;", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/units/Length;Landroidx/health/connect/client/records/metadata/Metadata;)V", "getHeight", "()Landroidx/health/connect/client/units/Length;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getTime", "()Ljava/time/Instant;", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "Companion", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class HeightRecord implements InstantaneousRecord {
    public static final AggregateMetric<Length> HEIGHT_AVG;
    private static final String HEIGHT_FIELD_NAME = "height";
    public static final AggregateMetric<Length> HEIGHT_MAX;
    public static final AggregateMetric<Length> HEIGHT_MIN;
    private static final String HEIGHT_NAME = "Height";
    private static final Length MAX_HEIGHT;
    private final Length height;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Instant time;
    private final ZoneOffset zoneOffset;

    public HeightRecord(Instant time, ZoneOffset zoneOffset, Length height, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.time = time;
        this.zoneOffset = zoneOffset;
        this.height = height;
        this.metadata = metadata;
        UtilsKt.requireNotLess(this.height, this.height.zero$connect_client_release(), HEIGHT_FIELD_NAME);
        UtilsKt.requireNotMore(this.height, MAX_HEIGHT, HEIGHT_FIELD_NAME);
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public Instant getTime() {
        return this.time;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    public final Length getHeight() {
        return this.height;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HeightRecord) && Intrinsics.areEqual(this.height, ((HeightRecord) other).height) && Intrinsics.areEqual(getTime(), ((HeightRecord) other).getTime()) && Intrinsics.areEqual(getZoneOffset(), ((HeightRecord) other).getZoneOffset()) && Intrinsics.areEqual(getMetadata(), ((HeightRecord) other).getMetadata());
    }

    public int hashCode() {
        int result = this.height.hashCode();
        int result2 = ((result * 31) + getTime().hashCode()) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return ((result2 + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "HeightRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", height=" + this.height + ", metadata=" + getMetadata() + ')';
    }

    static {
        Length meters;
        meters = LengthKt.getMeters(1.5E-323d);
        MAX_HEIGHT = meters;
        HEIGHT_AVG = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(HEIGHT_NAME, AggregateMetric.AggregationType.AVERAGE, HEIGHT_FIELD_NAME, new HeightRecord$Companion$HEIGHT_AVG$1(Length.INSTANCE));
        HEIGHT_MIN = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(HEIGHT_NAME, AggregateMetric.AggregationType.MINIMUM, HEIGHT_FIELD_NAME, new HeightRecord$Companion$HEIGHT_MIN$1(Length.INSTANCE));
        HEIGHT_MAX = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(HEIGHT_NAME, AggregateMetric.AggregationType.MAXIMUM, HEIGHT_FIELD_NAME, new HeightRecord$Companion$HEIGHT_MAX$1(Length.INSTANCE));
    }
}
