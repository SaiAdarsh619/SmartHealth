package androidx.health.connect.client.records;

import androidx.health.connect.client.records.Vo2MaxRecord;
import java.time.Instant;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeartRateVariabilityRmssdRecord.kt */
@Metadata(m286d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, m287d2 = {"Landroidx/health/connect/client/records/HeartRateVariabilityRmssdRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "time", "Ljava/time/Instant;", "zoneOffset", "Ljava/time/ZoneOffset;", "heartRateVariabilityMillis", "", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;DLandroidx/health/connect/client/records/metadata/Metadata;)V", "getHeartRateVariabilityMillis", "()D", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getTime", "()Ljava/time/Instant;", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "Companion", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class HeartRateVariabilityRmssdRecord implements InstantaneousRecord {
    public static final double MAX_HRV_RMSSD = 200.0d;
    public static final double MIN_HRV_RMSSD = 1.0d;
    private final double heartRateVariabilityMillis;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Instant time;
    private final ZoneOffset zoneOffset;

    public HeartRateVariabilityRmssdRecord(Instant time, ZoneOffset zoneOffset, double heartRateVariabilityMillis, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.time = time;
        this.zoneOffset = zoneOffset;
        this.heartRateVariabilityMillis = heartRateVariabilityMillis;
        this.metadata = metadata;
        UtilsKt.requireInRange(Double.valueOf(this.heartRateVariabilityMillis), Double.valueOf(1.0d), Double.valueOf(200.0d), "heartRateVariabilityMillis");
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public Instant getTime() {
        return this.time;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    public final double getHeartRateVariabilityMillis() {
        return this.heartRateVariabilityMillis;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof HeartRateVariabilityRmssdRecord) {
            return ((this.heartRateVariabilityMillis > ((HeartRateVariabilityRmssdRecord) other).heartRateVariabilityMillis ? 1 : (this.heartRateVariabilityMillis == ((HeartRateVariabilityRmssdRecord) other).heartRateVariabilityMillis ? 0 : -1)) == 0) && Intrinsics.areEqual(getTime(), ((HeartRateVariabilityRmssdRecord) other).getTime()) && Intrinsics.areEqual(getZoneOffset(), ((HeartRateVariabilityRmssdRecord) other).getZoneOffset()) && Intrinsics.areEqual(getMetadata(), ((HeartRateVariabilityRmssdRecord) other).getMetadata());
        }
        return false;
    }

    public int hashCode() {
        int result = (0 * 31) + Double.hashCode(this.heartRateVariabilityMillis);
        int result2 = ((result * 31) + getTime().hashCode()) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return ((result2 + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "HeartRateVariabilityRmssdRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", heartRateVariabilityMillis=" + this.heartRateVariabilityMillis + ", metadata=" + getMetadata() + ')';
    }
}
