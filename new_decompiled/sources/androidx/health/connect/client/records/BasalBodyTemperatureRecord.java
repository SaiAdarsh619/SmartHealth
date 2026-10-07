package androidx.health.connect.client.records;

import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.units.Temperature;
import androidx.health.connect.client.units.TemperatureKt;
import java.time.Instant;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasalBodyTemperatureRecord.kt */
@Metadata(m286d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0017\u0010\n\u001a\u00020\u000b¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, m287d2 = {"Landroidx/health/connect/client/records/BasalBodyTemperatureRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "time", "Ljava/time/Instant;", "zoneOffset", "Ljava/time/ZoneOffset;", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "temperature", "Landroidx/health/connect/client/units/Temperature;", "measurementLocation", "", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;Landroidx/health/connect/client/units/Temperature;I)V", "getMeasurementLocation$annotations", "()V", "getMeasurementLocation", "()I", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getTemperature", "()Landroidx/health/connect/client/units/Temperature;", "getTime", "()Ljava/time/Instant;", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "toString", "", "Companion", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class BasalBodyTemperatureRecord implements InstantaneousRecord {
    private static final Companion Companion = new Companion(null);
    private static final Temperature MAX_TEMPERATURE;
    private static final Temperature MIN_TEMPERATURE;
    private final int measurementLocation;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Temperature temperature;
    private final Instant time;
    private final ZoneOffset zoneOffset;

    public static /* synthetic */ void getMeasurementLocation$annotations() {
    }

    public BasalBodyTemperatureRecord(Instant time, ZoneOffset zoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, Temperature temperature, int measurementLocation) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(temperature, "temperature");
        this.time = time;
        this.zoneOffset = zoneOffset;
        this.metadata = metadata;
        this.temperature = temperature;
        this.measurementLocation = measurementLocation;
        UtilsKt.requireNotLess(this.temperature, MIN_TEMPERATURE, "temperature");
        UtilsKt.requireNotMore(this.temperature, MAX_TEMPERATURE, "temperature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ BasalBodyTemperatureRecord(Instant instant, ZoneOffset zoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, Temperature temperature, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, metadata, temperature, r5);
        int i3;
        if ((i2 & 16) == 0) {
            i3 = i;
        } else {
            i3 = 0;
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

    public final Temperature getTemperature() {
        return this.temperature;
    }

    public final int getMeasurementLocation() {
        return this.measurementLocation;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BasalBodyTemperatureRecord) && Intrinsics.areEqual(this.temperature, ((BasalBodyTemperatureRecord) other).temperature) && this.measurementLocation == ((BasalBodyTemperatureRecord) other).measurementLocation && Intrinsics.areEqual(getTime(), ((BasalBodyTemperatureRecord) other).getTime()) && Intrinsics.areEqual(getZoneOffset(), ((BasalBodyTemperatureRecord) other).getZoneOffset()) && Intrinsics.areEqual(getMetadata(), ((BasalBodyTemperatureRecord) other).getMetadata());
    }

    public int hashCode() {
        int result = this.temperature.hashCode();
        int result2 = ((((result * 31) + this.measurementLocation) * 31) + getTime().hashCode()) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return ((result2 + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "BasalBodyTemperatureRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", temperature=" + this.temperature + ", measurementLocation=" + this.measurementLocation + ", metadata=" + getMetadata() + ')';
    }

    /* compiled from: BasalBodyTemperatureRecord.kt */
    @Metadata(m286d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m287d2 = {"Landroidx/health/connect/client/records/BasalBodyTemperatureRecord$Companion;", "", "()V", "MAX_TEMPERATURE", "Landroidx/health/connect/client/units/Temperature;", "MIN_TEMPERATURE", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Temperature celsius;
        Temperature celsius2;
        celsius = TemperatureKt.getCelsius(0.0d);
        MIN_TEMPERATURE = celsius;
        celsius2 = TemperatureKt.getCelsius(4.94E-322d);
        MAX_TEMPERATURE = celsius2;
    }
}
