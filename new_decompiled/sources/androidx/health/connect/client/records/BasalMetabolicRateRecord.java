package androidx.health.connect.client.records;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.units.Energy;
import androidx.health.connect.client.units.Power;
import androidx.health.connect.client.units.PowerKt;
import java.time.Instant;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasalMetabolicRateRecord.kt */
@Metadata(m286d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, m287d2 = {"Landroidx/health/connect/client/records/BasalMetabolicRateRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "time", "Ljava/time/Instant;", "zoneOffset", "Ljava/time/ZoneOffset;", "basalMetabolicRate", "Landroidx/health/connect/client/units/Power;", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/units/Power;Landroidx/health/connect/client/records/metadata/Metadata;)V", "getBasalMetabolicRate", "()Landroidx/health/connect/client/units/Power;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getTime", "()Ljava/time/Instant;", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "Companion", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class BasalMetabolicRateRecord implements InstantaneousRecord {
    public static final AggregateMetric<Energy> BASAL_CALORIES_TOTAL;
    private static final String BASAL_CALORIES_TYPE_NAME = "BasalCaloriesBurned";
    private static final String ENERGY_FIELD_NAME = "energy";
    private static final Power MAX_BASAL_METABLOIC_RATE;
    private final Power basalMetabolicRate;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Instant time;
    private final ZoneOffset zoneOffset;

    public BasalMetabolicRateRecord(Instant time, ZoneOffset zoneOffset, Power basalMetabolicRate, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(basalMetabolicRate, "basalMetabolicRate");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.time = time;
        this.zoneOffset = zoneOffset;
        this.basalMetabolicRate = basalMetabolicRate;
        this.metadata = metadata;
        UtilsKt.requireNotLess(this.basalMetabolicRate, this.basalMetabolicRate.zero$connect_client_release(), "bmr");
        UtilsKt.requireNotMore(this.basalMetabolicRate, MAX_BASAL_METABLOIC_RATE, "bmr");
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public Instant getTime() {
        return this.time;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    public final Power getBasalMetabolicRate() {
        return this.basalMetabolicRate;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BasalMetabolicRateRecord) && Intrinsics.areEqual(this.basalMetabolicRate, ((BasalMetabolicRateRecord) other).basalMetabolicRate) && Intrinsics.areEqual(getTime(), ((BasalMetabolicRateRecord) other).getTime()) && Intrinsics.areEqual(getZoneOffset(), ((BasalMetabolicRateRecord) other).getZoneOffset()) && Intrinsics.areEqual(getMetadata(), ((BasalMetabolicRateRecord) other).getMetadata());
    }

    public int hashCode() {
        int result = this.basalMetabolicRate.hashCode();
        int result2 = ((result * 31) + getTime().hashCode()) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return ((result2 + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "BasalMetabolicRateRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", basalMetabolicRate=" + this.basalMetabolicRate + ", metadata=" + getMetadata() + ')';
    }

    static {
        Power kilocaloriesPerDay;
        kilocaloriesPerDay = PowerKt.getKilocaloriesPerDay(4.9407E-320d);
        MAX_BASAL_METABLOIC_RATE = kilocaloriesPerDay;
        BASAL_CALORIES_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(BASAL_CALORIES_TYPE_NAME, AggregateMetric.AggregationType.TOTAL, ENERGY_FIELD_NAME, new BasalMetabolicRateRecord$Companion$BASAL_CALORIES_TOTAL$1(Energy.INSTANCE));
    }
}
