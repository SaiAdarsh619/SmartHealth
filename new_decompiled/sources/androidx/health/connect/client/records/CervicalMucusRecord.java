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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CervicalMucusRecord.kt */
@Metadata(m286d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0005\u001f !\"#B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0017\u0010\b\u001a\u00020\t¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\n\u001a\u00020\t¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, m287d2 = {"Landroidx/health/connect/client/records/CervicalMucusRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "time", "Ljava/time/Instant;", "zoneOffset", "Ljava/time/ZoneOffset;", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "appearance", "", "sensation", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;II)V", "getAppearance$annotations", "()V", "getAppearance", "()I", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getSensation$annotations", "getSensation", "getTime", "()Ljava/time/Instant;", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "toString", "", "Appearance", "Appearances", "Companion", "Sensation", "Sensations", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class CervicalMucusRecord implements InstantaneousRecord {
    public static final int APPEARANCE_CREAMY = 3;
    public static final int APPEARANCE_DRY = 1;
    public static final int APPEARANCE_EGG_WHITE = 5;
    public static final int APPEARANCE_STICKY = 2;
    public static final int APPEARANCE_UNKNOWN = 0;
    public static final int APPEARANCE_UNUSUAL = 6;
    public static final int APPEARANCE_WATERY = 4;
    public static final int SENSATION_HEAVY = 3;
    public static final int SENSATION_LIGHT = 1;
    public static final int SENSATION_MEDIUM = 2;
    public static final int SENSATION_UNKNOWN = 0;
    private final int appearance;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final int sensation;
    private final Instant time;
    private final ZoneOffset zoneOffset;
    public static final Map<String, Integer> APPEARANCE_STRING_TO_INT_MAP = MapsKt.mapOf(TuplesKt.m294to(Appearance.CLEAR, 5), TuplesKt.m294to(Appearance.CREAMY, 3), TuplesKt.m294to(Appearance.DRY, 1), TuplesKt.m294to(Appearance.STICKY, 2), TuplesKt.m294to(Appearance.WATERY, 4), TuplesKt.m294to(Appearance.UNUSUAL, 6));
    public static final Map<Integer, String> APPEARANCE_INT_TO_STRING_MAP = UtilsKt.reverse(APPEARANCE_STRING_TO_INT_MAP);
    public static final Map<String, Integer> SENSATION_STRING_TO_INT_MAP = MapsKt.mapOf(TuplesKt.m294to(Sensation.LIGHT, 1), TuplesKt.m294to(Sensation.MEDIUM, 2), TuplesKt.m294to(Sensation.HEAVY, 3));
    public static final Map<Integer, String> SENSATION_INT_TO_STRING_MAP = UtilsKt.reverse(SENSATION_STRING_TO_INT_MAP);

    /* compiled from: CervicalMucusRecord.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m287d2 = {"Landroidx/health/connect/client/records/CervicalMucusRecord$Appearances;", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Appearances {
    }

    /* compiled from: CervicalMucusRecord.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m287d2 = {"Landroidx/health/connect/client/records/CervicalMucusRecord$Sensations;", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Sensations {
    }

    public static /* synthetic */ void getAppearance$annotations() {
    }

    public static /* synthetic */ void getSensation$annotations() {
    }

    public CervicalMucusRecord(Instant time, ZoneOffset zoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, int appearance, int sensation) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.time = time;
        this.zoneOffset = zoneOffset;
        this.metadata = metadata;
        this.appearance = appearance;
        this.sensation = sensation;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ CervicalMucusRecord(Instant instant, ZoneOffset zoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, metadata, r5, r6);
        int i4;
        int i5;
        if ((i3 & 8) == 0) {
            i4 = i;
        } else {
            i4 = 0;
        }
        if ((i3 & 16) == 0) {
            i5 = i2;
        } else {
            i5 = 0;
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

    public final int getAppearance() {
        return this.appearance;
    }

    public final int getSensation() {
        return this.sensation;
    }

    /* compiled from: CervicalMucusRecord.kt */
    @Metadata(m286d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m287d2 = {"Landroidx/health/connect/client/records/CervicalMucusRecord$Sensation;", "", "()V", "HEAVY", "", "LIGHT", "MEDIUM", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class Sensation {
        public static final String HEAVY = "heavy";
        public static final Sensation INSTANCE = new Sensation();
        public static final String LIGHT = "light";
        public static final String MEDIUM = "medium";

        private Sensation() {
        }
    }

    /* compiled from: CervicalMucusRecord.kt */
    @Metadata(m286d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m287d2 = {"Landroidx/health/connect/client/records/CervicalMucusRecord$Appearance;", "", "()V", "CLEAR", "", "CREAMY", "DRY", "STICKY", "UNUSUAL", "WATERY", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class Appearance {
        public static final String CLEAR = "clear";
        public static final String CREAMY = "creamy";
        public static final String DRY = "dry";
        public static final Appearance INSTANCE = new Appearance();
        public static final String STICKY = "sticky";
        public static final String UNUSUAL = "unusual";
        public static final String WATERY = "watery";

        private Appearance() {
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.health.connect.client.records.CervicalMucusRecord");
        return Intrinsics.areEqual(getTime(), ((CervicalMucusRecord) other).getTime()) && Intrinsics.areEqual(getZoneOffset(), ((CervicalMucusRecord) other).getZoneOffset()) && this.appearance == ((CervicalMucusRecord) other).appearance && this.sensation == ((CervicalMucusRecord) other).sensation && Intrinsics.areEqual(getMetadata(), ((CervicalMucusRecord) other).getMetadata());
    }

    public int hashCode() {
        int result = getTime().hashCode();
        int i = result * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        int result2 = i + (zoneOffset != null ? zoneOffset.hashCode() : 0);
        return (((((result2 * 31) + this.appearance) * 31) + this.sensation) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "CervicalMucusRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", appearance=" + this.appearance + ", sensation=" + this.sensation + ", metadata=" + getMetadata() + ')';
    }
}
