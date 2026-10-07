package androidx.health.connect.client.records;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.units.Mass;
import androidx.health.connect.client.units.MassKt;
import java.time.Instant;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WeightRecord.kt */
@Metadata(m286d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, m287d2 = {"Landroidx/health/connect/client/records/WeightRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "time", "Ljava/time/Instant;", "zoneOffset", "Ljava/time/ZoneOffset;", WeightRecord.WEIGHT_FIELD, "Landroidx/health/connect/client/units/Mass;", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/records/metadata/Metadata;)V", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getTime", "()Ljava/time/Instant;", "getWeight", "()Landroidx/health/connect/client/units/Mass;", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "Companion", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class WeightRecord implements InstantaneousRecord {
    private static final Mass MAX_WEIGHT;
    public static final AggregateMetric<Mass> WEIGHT_AVG;
    private static final String WEIGHT_FIELD = "weight";
    public static final AggregateMetric<Mass> WEIGHT_MAX;
    public static final AggregateMetric<Mass> WEIGHT_MIN;
    private static final String WEIGHT_NAME = "Weight";
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Instant time;
    private final Mass weight;
    private final ZoneOffset zoneOffset;

    public WeightRecord(Instant time, ZoneOffset zoneOffset, Mass weight, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(weight, "weight");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.time = time;
        this.zoneOffset = zoneOffset;
        this.weight = weight;
        this.metadata = metadata;
        UtilsKt.requireNotLess(this.weight, this.weight.zero$connect_client_release(), WEIGHT_FIELD);
        UtilsKt.requireNotMore(this.weight, MAX_WEIGHT, WEIGHT_FIELD);
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public Instant getTime() {
        return this.time;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    public final Mass getWeight() {
        return this.weight;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof WeightRecord) && Intrinsics.areEqual(this.weight, ((WeightRecord) other).weight) && Intrinsics.areEqual(getTime(), ((WeightRecord) other).getTime()) && Intrinsics.areEqual(getZoneOffset(), ((WeightRecord) other).getZoneOffset()) && Intrinsics.areEqual(getMetadata(), ((WeightRecord) other).getMetadata());
    }

    public int hashCode() {
        int result = this.weight.hashCode();
        int result2 = ((result * 31) + getTime().hashCode()) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return ((result2 + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "WeightRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", weight=" + this.weight + ", metadata=" + getMetadata() + ')';
    }

    static {
        Mass kilograms;
        kilograms = MassKt.getKilograms(4.94E-321d);
        MAX_WEIGHT = kilograms;
        WEIGHT_AVG = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(WEIGHT_NAME, AggregateMetric.AggregationType.AVERAGE, WEIGHT_FIELD, new WeightRecord$Companion$WEIGHT_AVG$1(Mass.INSTANCE));
        WEIGHT_MIN = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(WEIGHT_NAME, AggregateMetric.AggregationType.MINIMUM, WEIGHT_FIELD, new WeightRecord$Companion$WEIGHT_MIN$1(Mass.INSTANCE));
        WEIGHT_MAX = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(WEIGHT_NAME, AggregateMetric.AggregationType.MAXIMUM, WEIGHT_FIELD, new WeightRecord$Companion$WEIGHT_MAX$1(Mass.INSTANCE));
    }
}
