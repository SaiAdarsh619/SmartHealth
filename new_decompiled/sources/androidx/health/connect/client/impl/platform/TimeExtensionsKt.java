package androidx.health.connect.client.impl.platform;

import androidx.health.connect.client.impl.platform.aggregate.InstantTimeRange;
import androidx.health.connect.client.impl.platform.aggregate.LocalTimeRange;
import androidx.health.connect.client.impl.platform.aggregate.TimeRange;
import androidx.health.connect.client.records.IntervalRecord;
import androidx.health.connect.client.records.Vo2MaxRecord;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeExtensions.kt */
@Metadata(m286d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0080\u0002\u001a$\u0010\b\u001a\u00020\t*\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0080\u0002\u001a\u0018\u0010\u0011\u001a\u00020\n*\u00020\u00122\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000\u001a\u0018\u0010\u0013\u001a\u00020\u0012*\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0014H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0015"}, m287d2 = {"duration", "Ljava/time/Duration;", "Landroidx/health/connect/client/records/IntervalRecord;", "getDuration", "(Landroidx/health/connect/client/records/IntervalRecord;)Ljava/time/Duration;", "div", "", "divisor", "isWithin", "", "Ljava/time/Instant;", "timeRange", "Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;", "zoneOffset", "Ljava/time/ZoneOffset;", "minus", Vo2MaxRecord.MeasurementMethod.OTHER, "toInstantWithDefaultZoneFallback", "Ljava/time/LocalDateTime;", "toLocalTimeWithDefaultZoneFallback", "Ljava/time/ZoneId;", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class TimeExtensionsKt {
    public static final double div(Duration $this$div, Duration divisor) {
        Intrinsics.checkNotNullParameter($this$div, "<this>");
        Intrinsics.checkNotNullParameter(divisor, "divisor");
        return $this$div.toMillis() / divisor.toMillis();
    }

    public static final Duration minus(Instant $this$minus, Instant other) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Duration between = Duration.between(other, $this$minus);
        Intrinsics.checkNotNullExpressionValue(between, "between(other, this)");
        return between;
    }

    public static /* synthetic */ Instant toInstantWithDefaultZoneFallback$default(LocalDateTime localDateTime, ZoneOffset zoneOffset, int i, Object obj) {
        if ((i & 1) != 0) {
            zoneOffset = null;
        }
        return toInstantWithDefaultZoneFallback(localDateTime, zoneOffset);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.time.ZonedDateTime] */
    public static final Instant toInstantWithDefaultZoneFallback(LocalDateTime $this$toInstantWithDefaultZoneFallback, ZoneOffset zoneOffset) {
        Intrinsics.checkNotNullParameter($this$toInstantWithDefaultZoneFallback, "<this>");
        Instant instant = $this$toInstantWithDefaultZoneFallback.atZone(zoneOffset != null ? zoneOffset : ZoneId.systemDefault()).toInstant();
        Intrinsics.checkNotNullExpressionValue(instant, "atZone(zoneOffset ?: Zon…temDefault()).toInstant()");
        return instant;
    }

    public static /* synthetic */ LocalDateTime toLocalTimeWithDefaultZoneFallback$default(Instant instant, ZoneId zoneId, int i, Object obj) {
        if ((i & 1) != 0) {
            zoneId = null;
        }
        return toLocalTimeWithDefaultZoneFallback(instant, zoneId);
    }

    public static final LocalDateTime toLocalTimeWithDefaultZoneFallback(Instant $this$toLocalTimeWithDefaultZoneFallback, ZoneId zoneOffset) {
        Intrinsics.checkNotNullParameter($this$toLocalTimeWithDefaultZoneFallback, "<this>");
        LocalDateTime ofInstant = LocalDateTime.ofInstant($this$toLocalTimeWithDefaultZoneFallback, zoneOffset == null ? ZoneId.systemDefault() : zoneOffset);
        Intrinsics.checkNotNullExpressionValue(ofInstant, "ofInstant(this, zoneOffs…: ZoneId.systemDefault())");
        return ofInstant;
    }

    public static final Duration getDuration(IntervalRecord $this$duration) {
        Intrinsics.checkNotNullParameter($this$duration, "<this>");
        return minus($this$duration.getEndTime(), $this$duration.getStartTime());
    }

    public static /* synthetic */ boolean isWithin$default(Instant instant, TimeRange timeRange, ZoneOffset zoneOffset, int i, Object obj) {
        if ((i & 2) != 0) {
            zoneOffset = null;
        }
        return isWithin(instant, timeRange, zoneOffset);
    }

    public static final boolean isWithin(Instant $this$isWithin, TimeRange<?> timeRange, ZoneOffset zoneOffset) {
        Intrinsics.checkNotNullParameter($this$isWithin, "<this>");
        Intrinsics.checkNotNullParameter(timeRange, "timeRange");
        if (timeRange instanceof InstantTimeRange) {
            return !$this$isWithin.isBefore(((InstantTimeRange) timeRange).getStartTime()) && $this$isWithin.isBefore(((InstantTimeRange) timeRange).getEndTime());
        }
        if (timeRange instanceof LocalTimeRange) {
            return !$this$isWithin.isBefore(toInstantWithDefaultZoneFallback(((LocalTimeRange) timeRange).getStartTime(), zoneOffset)) && $this$isWithin.isBefore(toInstantWithDefaultZoneFallback(((LocalTimeRange) timeRange).getEndTime(), zoneOffset));
        }
        throw new NoWhenBranchMatchedException();
    }
}
