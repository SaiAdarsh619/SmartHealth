package androidx.health.connect.client.request;

import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.time.TimeRangeFilter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: ReadRecordsRequest.kt */
@Metadata(m286d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\u0018\u0000 '*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0002'(BM\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011BW\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e¢\u0006\u0002\u0010\u0013J\u0013\u0010!\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010#\u001a\u00020\u000eH\u0016J\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010%\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b&R\u0013\u0010\u000b\u001a\u00020\f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0012\u001a\u00020\u000e8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\r\u001a\u00020\u000e8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006)"}, m287d2 = {"Landroidx/health/connect/client/request/ReadRecordsRequest;", "T", "Landroidx/health/connect/client/records/Record;", "", "recordType", "Lkotlin/reflect/KClass;", "timeRangeFilter", "Landroidx/health/connect/client/time/TimeRangeFilter;", "dataOriginFilter", "", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "ascendingOrder", "", "pageSize", "", "pageToken", "", "(Lkotlin/reflect/KClass;Landroidx/health/connect/client/time/TimeRangeFilter;Ljava/util/Set;ZILjava/lang/String;)V", "deduplicateStrategy", "(Lkotlin/reflect/KClass;Landroidx/health/connect/client/time/TimeRangeFilter;Ljava/util/Set;ZILjava/lang/String;I)V", "getAscendingOrder", "()Z", "getDataOriginFilter", "()Ljava/util/Set;", "getDeduplicateStrategy", "()I", "getPageSize", "getPageToken", "()Ljava/lang/String;", "getRecordType", "()Lkotlin/reflect/KClass;", "getTimeRangeFilter", "()Landroidx/health/connect/client/time/TimeRangeFilter;", "equals", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "withPageToken", "newPageToken", "withPageToken$connect_client_release", "Companion", "DeduplicationStrategy", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class ReadRecordsRequest<T extends Record> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEDUPLICATION_STRATEGY_DISABLED = 0;
    public static final int DEDUPLICATION_STRATEGY_ENABLED_DEFAULT = 1;
    public static final int DEDUPLICATION_STRATEGY_ENABLED_PRIORITIZE_CALLING_APP = 2;
    private final boolean ascendingOrder;
    private final Set<DataOrigin> dataOriginFilter;
    private final int deduplicateStrategy;
    private final int pageSize;
    private final String pageToken;
    private final KClass<T> recordType;
    private final TimeRangeFilter timeRangeFilter;

    /* compiled from: ReadRecordsRequest.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m287d2 = {"Landroidx/health/connect/client/request/ReadRecordsRequest$DeduplicationStrategy;", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface DeduplicationStrategy {
    }

    public ReadRecordsRequest(KClass<T> recordType, TimeRangeFilter timeRangeFilter, Set<DataOrigin> dataOriginFilter, boolean ascendingOrder, int pageSize, String pageToken, int deduplicateStrategy) {
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        Intrinsics.checkNotNullParameter(timeRangeFilter, "timeRangeFilter");
        Intrinsics.checkNotNullParameter(dataOriginFilter, "dataOriginFilter");
        this.recordType = recordType;
        this.timeRangeFilter = timeRangeFilter;
        this.dataOriginFilter = dataOriginFilter;
        this.ascendingOrder = ascendingOrder;
        this.pageSize = pageSize;
        this.pageToken = pageToken;
        this.deduplicateStrategy = deduplicateStrategy;
        if (!(this.pageSize > 0)) {
            throw new IllegalArgumentException("pageSize must be positive.".toString());
        }
    }

    public /* synthetic */ ReadRecordsRequest(KClass kClass, TimeRangeFilter timeRangeFilter, Set set, boolean z, int i, String str, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, timeRangeFilter, (i3 & 4) != 0 ? SetsKt.emptySet() : set, (i3 & 8) != 0 ? true : z, (i3 & 16) != 0 ? 1000 : i, (i3 & 32) != 0 ? null : str, (i3 & 64) != 0 ? 1 : i2);
    }

    public final KClass<T> getRecordType() {
        return this.recordType;
    }

    public final TimeRangeFilter getTimeRangeFilter() {
        return this.timeRangeFilter;
    }

    public final Set<DataOrigin> getDataOriginFilter() {
        return this.dataOriginFilter;
    }

    public final boolean getAscendingOrder() {
        return this.ascendingOrder;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final String getPageToken() {
        return this.pageToken;
    }

    public final int getDeduplicateStrategy() {
        return this.deduplicateStrategy;
    }

    public /* synthetic */ ReadRecordsRequest(KClass kClass, TimeRangeFilter timeRangeFilter, Set set, boolean z, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, timeRangeFilter, (i2 & 4) != 0 ? SetsKt.emptySet() : set, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? 1000 : i, (i2 & 32) != 0 ? null : str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReadRecordsRequest(KClass<T> recordType, TimeRangeFilter timeRangeFilter, Set<DataOrigin> dataOriginFilter, boolean ascendingOrder, int pageSize, String pageToken) {
        this(recordType, timeRangeFilter, dataOriginFilter, ascendingOrder, pageSize, pageToken, 0);
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        Intrinsics.checkNotNullParameter(timeRangeFilter, "timeRangeFilter");
        Intrinsics.checkNotNullParameter(dataOriginFilter, "dataOriginFilter");
    }

    public final ReadRecordsRequest<T> withPageToken$connect_client_release(String newPageToken) {
        return new ReadRecordsRequest<>(this.recordType, this.timeRangeFilter, this.dataOriginFilter, this.ascendingOrder, this.pageSize, newPageToken, this.deduplicateStrategy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.health.connect.client.request.ReadRecordsRequest<*>");
        return Intrinsics.areEqual(this.recordType, ((ReadRecordsRequest) other).recordType) && Intrinsics.areEqual(this.timeRangeFilter, ((ReadRecordsRequest) other).timeRangeFilter) && Intrinsics.areEqual(this.dataOriginFilter, ((ReadRecordsRequest) other).dataOriginFilter) && this.ascendingOrder == ((ReadRecordsRequest) other).ascendingOrder && this.pageSize == ((ReadRecordsRequest) other).pageSize && Intrinsics.areEqual(this.pageToken, ((ReadRecordsRequest) other).pageToken) && this.deduplicateStrategy == ((ReadRecordsRequest) other).deduplicateStrategy;
    }

    public int hashCode() {
        int result = this.recordType.hashCode();
        int result2 = ((((((((result * 31) + this.timeRangeFilter.hashCode()) * 31) + this.dataOriginFilter.hashCode()) * 31) + Boolean.hashCode(this.ascendingOrder)) * 31) + this.pageSize) * 31;
        String str = this.pageToken;
        return ((result2 + (str != null ? str.hashCode() : 0)) * 31) + Integer.hashCode(this.deduplicateStrategy);
    }

    /* compiled from: ReadRecordsRequest.kt */
    @Metadata(m286d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0081\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002¨\u0006\n"}, m287d2 = {"Landroidx/health/connect/client/request/ReadRecordsRequest$Companion;", "", "()V", "DEDUPLICATION_STRATEGY_DISABLED", "", "getDEDUPLICATION_STRATEGY_DISABLED$annotations", "DEDUPLICATION_STRATEGY_ENABLED_DEFAULT", "getDEDUPLICATION_STRATEGY_ENABLED_DEFAULT$annotations", "DEDUPLICATION_STRATEGY_ENABLED_PRIORITIZE_CALLING_APP", "getDEDUPLICATION_STRATEGY_ENABLED_PRIORITIZE_CALLING_APP$annotations", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDEDUPLICATION_STRATEGY_DISABLED$annotations() {
        }

        public static /* synthetic */ void getDEDUPLICATION_STRATEGY_ENABLED_DEFAULT$annotations() {
        }

        /* renamed from: getDEDUPLICATION_STRATEGY_ENABLED_PRIORITIZE_CALLING_APP$annotations */
        public static /* synthetic */ void m47x41409928() {
        }

        private Companion() {
        }
    }
}
