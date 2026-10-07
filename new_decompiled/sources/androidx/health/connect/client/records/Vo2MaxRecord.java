package androidx.health.connect.client.records;

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

/* compiled from: Vo2MaxRecord.kt */
@Metadata(m286d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0003 !\"B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0017\u0010\n\u001a\u00020\u000b¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006#"}, m287d2 = {"Landroidx/health/connect/client/records/Vo2MaxRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "time", "Ljava/time/Instant;", "zoneOffset", "Ljava/time/ZoneOffset;", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "vo2MillilitersPerMinuteKilogram", "", "measurementMethod", "", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;DI)V", "getMeasurementMethod$annotations", "()V", "getMeasurementMethod", "()I", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getTime", "()Ljava/time/Instant;", "getVo2MillilitersPerMinuteKilogram", "()D", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", MeasurementMethod.OTHER, "", "hashCode", "toString", "", "Companion", "MeasurementMethod", "MeasurementMethods", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class Vo2MaxRecord implements InstantaneousRecord {
    public static final int MEASUREMENT_METHOD_COOPER_TEST = 3;
    public static final int MEASUREMENT_METHOD_HEART_RATE_RATIO = 2;
    public static final int MEASUREMENT_METHOD_METABOLIC_CART = 1;
    public static final int MEASUREMENT_METHOD_MULTISTAGE_FITNESS_TEST = 4;
    public static final int MEASUREMENT_METHOD_OTHER = 0;
    public static final int MEASUREMENT_METHOD_ROCKPORT_FITNESS_TEST = 5;
    private final int measurementMethod;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Instant time;
    private final double vo2MillilitersPerMinuteKilogram;
    private final ZoneOffset zoneOffset;
    public static final Map<String, Integer> MEASUREMENT_METHOD_STRING_TO_INT_MAP = MapsKt.mapOf(TuplesKt.m294to(MeasurementMethod.OTHER, 0), TuplesKt.m294to(MeasurementMethod.METABOLIC_CART, 1), TuplesKt.m294to(MeasurementMethod.HEART_RATE_RATIO, 2), TuplesKt.m294to(MeasurementMethod.COOPER_TEST, 3), TuplesKt.m294to(MeasurementMethod.MULTISTAGE_FITNESS_TEST, 4), TuplesKt.m294to(MeasurementMethod.ROCKPORT_FITNESS_TEST, 5));
    public static final Map<Integer, String> MEASUREMENT_METHOD_INT_TO_STRING_MAP = UtilsKt.reverse(MEASUREMENT_METHOD_STRING_TO_INT_MAP);

    /* compiled from: Vo2MaxRecord.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m287d2 = {"Landroidx/health/connect/client/records/Vo2MaxRecord$MeasurementMethods;", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface MeasurementMethods {
    }

    public static /* synthetic */ void getMeasurementMethod$annotations() {
    }

    public Vo2MaxRecord(Instant time, ZoneOffset zoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, double vo2MillilitersPerMinuteKilogram, int measurementMethod) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.time = time;
        this.zoneOffset = zoneOffset;
        this.metadata = metadata;
        this.vo2MillilitersPerMinuteKilogram = vo2MillilitersPerMinuteKilogram;
        this.measurementMethod = measurementMethod;
        UtilsKt.requireNonNegative(this.vo2MillilitersPerMinuteKilogram, "vo2MillilitersPerMinuteKilogram");
        UtilsKt.requireNotMore(Double.valueOf(this.vo2MillilitersPerMinuteKilogram), Double.valueOf(100.0d), "vo2MillilitersPerMinuteKilogram");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ Vo2MaxRecord(Instant instant, ZoneOffset zoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, double d, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, metadata, d, r6);
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

    public final double getVo2MillilitersPerMinuteKilogram() {
        return this.vo2MillilitersPerMinuteKilogram;
    }

    public final int getMeasurementMethod() {
        return this.measurementMethod;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Vo2MaxRecord) {
            return ((this.vo2MillilitersPerMinuteKilogram > ((Vo2MaxRecord) other).vo2MillilitersPerMinuteKilogram ? 1 : (this.vo2MillilitersPerMinuteKilogram == ((Vo2MaxRecord) other).vo2MillilitersPerMinuteKilogram ? 0 : -1)) == 0) && this.measurementMethod == ((Vo2MaxRecord) other).measurementMethod && Intrinsics.areEqual(getTime(), ((Vo2MaxRecord) other).getTime()) && Intrinsics.areEqual(getZoneOffset(), ((Vo2MaxRecord) other).getZoneOffset()) && Intrinsics.areEqual(getMetadata(), ((Vo2MaxRecord) other).getMetadata());
        }
        return false;
    }

    public int hashCode() {
        int result = (0 * 31) + Double.hashCode(this.vo2MillilitersPerMinuteKilogram);
        int result2 = ((((result * 31) + this.measurementMethod) * 31) + getTime().hashCode()) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return ((result2 + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "Vo2MaxRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", vo2MillilitersPerMinuteKilogram=" + this.vo2MillilitersPerMinuteKilogram + ", measurementMethod=" + this.measurementMethod + ", metadata=" + getMetadata() + ')';
    }

    /* compiled from: Vo2MaxRecord.kt */
    @Metadata(m286d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m287d2 = {"Landroidx/health/connect/client/records/Vo2MaxRecord$MeasurementMethod;", "", "()V", "COOPER_TEST", "", "HEART_RATE_RATIO", "METABOLIC_CART", "MULTISTAGE_FITNESS_TEST", "OTHER", "ROCKPORT_FITNESS_TEST", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class MeasurementMethod {
        public static final String COOPER_TEST = "cooper_test";
        public static final String HEART_RATE_RATIO = "heart_rate_ratio";
        public static final MeasurementMethod INSTANCE = new MeasurementMethod();
        public static final String METABOLIC_CART = "metabolic_cart";
        public static final String MULTISTAGE_FITNESS_TEST = "multistage_fitness_test";
        public static final String OTHER = "other";
        public static final String ROCKPORT_FITNESS_TEST = "rockport_fitness_test";

        private MeasurementMethod() {
        }
    }
}
