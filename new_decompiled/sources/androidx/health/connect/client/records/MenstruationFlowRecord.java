package androidx.health.connect.client.records;

import androidx.health.connect.client.records.CervicalMucusRecord;
import androidx.health.connect.client.records.Vo2MaxRecord;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: MenstruationFlowRecord.kt */
@Metadata(m286d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0017\u0010\b\u001a\u00020\t¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, m287d2 = {"Landroidx/health/connect/client/records/MenstruationFlowRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "time", "Ljava/time/Instant;", "zoneOffset", "Ljava/time/ZoneOffset;", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "flow", "", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;I)V", "getFlow$annotations", "()V", "getFlow", "()I", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getTime", "()Ljava/time/Instant;", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "toString", "", "Companion", "Flows", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class MenstruationFlowRecord implements InstantaneousRecord {
    public static final int FLOW_HEAVY = 3;
    public static final int FLOW_LIGHT = 1;
    public static final int FLOW_MEDIUM = 2;
    public static final Map<Integer, String> FLOW_TYPE_INT_TO_STRING_MAP;
    public static final int FLOW_UNKNOWN = 0;
    private final int flow;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Instant time;
    private final ZoneOffset zoneOffset;
    public static final Map<String, Integer> FLOW_TYPE_STRING_TO_INT_MAP = MapsKt.mapOf(TuplesKt.m294to(CervicalMucusRecord.Sensation.LIGHT, 1), TuplesKt.m294to(CervicalMucusRecord.Sensation.MEDIUM, 2), TuplesKt.m294to(CervicalMucusRecord.Sensation.HEAVY, 3));

    /* compiled from: MenstruationFlowRecord.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m287d2 = {"Landroidx/health/connect/client/records/MenstruationFlowRecord$Flows;", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Flows {
    }

    public static /* synthetic */ void getFlow$annotations() {
    }

    public MenstruationFlowRecord(Instant time, ZoneOffset zoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, int flow) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.time = time;
        this.zoneOffset = zoneOffset;
        this.metadata = metadata;
        this.flow = flow;
    }

    public /* synthetic */ MenstruationFlowRecord(Instant instant, ZoneOffset zoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, metadata, (i2 & 8) != 0 ? 0 : i);
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

    public final int getFlow() {
        return this.flow;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MenstruationFlowRecord) && this.flow == ((MenstruationFlowRecord) other).flow && Intrinsics.areEqual(getTime(), ((MenstruationFlowRecord) other).getTime()) && Intrinsics.areEqual(getZoneOffset(), ((MenstruationFlowRecord) other).getZoneOffset()) && Intrinsics.areEqual(getMetadata(), ((MenstruationFlowRecord) other).getMetadata());
    }

    public int hashCode() {
        int result = this.flow;
        int result2 = ((result * 31) + getTime().hashCode()) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return ((result2 + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "MenstruationFlowRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", flow=" + this.flow + ", metadata=" + getMetadata() + ')';
    }

    static {
        Iterable $this$associateBy$iv = FLOW_TYPE_STRING_TO_INT_MAP.entrySet();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            Map.Entry it = (Map.Entry) element$iv$iv;
            Map.Entry it2 = (Map.Entry) element$iv$iv;
            destination$iv$iv.put(Integer.valueOf(((Number) it.getValue()).intValue()), (String) it2.getKey());
        }
        FLOW_TYPE_INT_TO_STRING_MAP = destination$iv$iv;
    }
}
