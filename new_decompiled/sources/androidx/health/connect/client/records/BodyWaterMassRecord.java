package androidx.health.connect.client.records;

import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.units.Mass;
import androidx.health.connect.client.units.MassKt;
import java.time.Instant;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BodyWaterMassRecord.kt */
@Metadata(m286d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, m287d2 = {"Landroidx/health/connect/client/records/BodyWaterMassRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "time", "Ljava/time/Instant;", "zoneOffset", "Ljava/time/ZoneOffset;", "mass", "Landroidx/health/connect/client/units/Mass;", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/records/metadata/Metadata;)V", "getMass", "()Landroidx/health/connect/client/units/Mass;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getTime", "()Ljava/time/Instant;", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "Companion", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class BodyWaterMassRecord implements InstantaneousRecord {
    private static final Companion Companion = new Companion(null);
    private static final Mass MAX_BODY_WATER_MASS;
    private final Mass mass;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Instant time;
    private final ZoneOffset zoneOffset;

    public BodyWaterMassRecord(Instant time, ZoneOffset zoneOffset, Mass mass, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(mass, "mass");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.time = time;
        this.zoneOffset = zoneOffset;
        this.mass = mass;
        this.metadata = metadata;
        UtilsKt.requireNotLess(this.mass, this.mass.zero$connect_client_release(), "mass");
        UtilsKt.requireNotMore(this.mass, MAX_BODY_WATER_MASS, "mass");
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public Instant getTime() {
        return this.time;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    public final Mass getMass() {
        return this.mass;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BodyWaterMassRecord) && Intrinsics.areEqual(this.mass, ((BodyWaterMassRecord) other).mass) && Intrinsics.areEqual(getTime(), ((BodyWaterMassRecord) other).getTime()) && Intrinsics.areEqual(getZoneOffset(), ((BodyWaterMassRecord) other).getZoneOffset()) && Intrinsics.areEqual(getMetadata(), ((BodyWaterMassRecord) other).getMetadata());
    }

    public int hashCode() {
        int result = this.mass.hashCode();
        int result2 = ((result * 31) + getTime().hashCode()) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return ((result2 + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "BodyWaterMassRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", mass=" + this.mass + ", metadata=" + getMetadata() + ')';
    }

    /* compiled from: BodyWaterMassRecord.kt */
    @Metadata(m286d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m287d2 = {"Landroidx/health/connect/client/records/BodyWaterMassRecord$Companion;", "", "()V", "MAX_BODY_WATER_MASS", "Landroidx/health/connect/client/units/Mass;", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Mass kilograms;
        kilograms = MassKt.getKilograms(4.94E-321d);
        MAX_BODY_WATER_MASS = kilograms;
    }
}
