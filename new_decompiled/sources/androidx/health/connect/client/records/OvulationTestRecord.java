package androidx.health.connect.client.records;

import androidx.health.connect.client.records.Vo2MaxRecord;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OvulationTestRecord.kt */
@Metadata(m286d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001c\u001d\u001eB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\u00020\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, m287d2 = {"Landroidx/health/connect/client/records/OvulationTestRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "time", "Ljava/time/Instant;", "zoneOffset", "Ljava/time/ZoneOffset;", "result", "", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;ILandroidx/health/connect/client/records/metadata/Metadata;)V", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getResult$annotations", "()V", "getResult", "()I", "getTime", "()Ljava/time/Instant;", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "toString", "", "Companion", "Result", "Results", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class OvulationTestRecord implements InstantaneousRecord {
    public static final int RESULT_HIGH = 2;
    public static final int RESULT_INCONCLUSIVE = 0;
    public static final int RESULT_NEGATIVE = 3;
    public static final int RESULT_POSITIVE = 1;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final int result;
    private final Instant time;
    private final ZoneOffset zoneOffset;
    public static final Map<String, Integer> RESULT_STRING_TO_INT_MAP = MapsKt.mapOf(TuplesKt.m294to(Result.INCONCLUSIVE, 0), TuplesKt.m294to(Result.POSITIVE, 1), TuplesKt.m294to(Result.HIGH, 2), TuplesKt.m294to(Result.NEGATIVE, 3));
    public static final Map<Integer, String> RESULT_INT_TO_STRING_MAP = UtilsKt.reverse(RESULT_STRING_TO_INT_MAP);

    /* compiled from: OvulationTestRecord.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m287d2 = {"Landroidx/health/connect/client/records/OvulationTestRecord$Results;", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Results {
    }

    public static /* synthetic */ void getResult$annotations() {
    }

    public OvulationTestRecord(Instant time, ZoneOffset zoneOffset, int result, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.time = time;
        this.zoneOffset = zoneOffset;
        this.result = result;
        this.metadata = metadata;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public Instant getTime() {
        return this.time;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    public final int getResult() {
        return this.result;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof OvulationTestRecord) && this.result == ((OvulationTestRecord) other).result && Intrinsics.areEqual(getTime(), ((OvulationTestRecord) other).getTime()) && Intrinsics.areEqual(getZoneOffset(), ((OvulationTestRecord) other).getZoneOffset()) && Intrinsics.areEqual(getMetadata(), ((OvulationTestRecord) other).getMetadata());
    }

    public int hashCode() {
        int result = Integer.hashCode(this.result);
        int result2 = ((result * 31) + getTime().hashCode()) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return ((result2 + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "OvulationTestRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", result=" + this.result + ", metadata=" + getMetadata() + ')';
    }

    /* compiled from: OvulationTestRecord.kt */
    @Metadata(m286d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m287d2 = {"Landroidx/health/connect/client/records/OvulationTestRecord$Result;", "", "()V", "HIGH", "", "INCONCLUSIVE", "NEGATIVE", "POSITIVE", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class Result {
        public static final String HIGH = "high";
        public static final String INCONCLUSIVE = "inconclusive";
        public static final Result INSTANCE = new Result();
        public static final String NEGATIVE = "negative";
        public static final String POSITIVE = "positive";

        private Result() {
        }
    }
}
