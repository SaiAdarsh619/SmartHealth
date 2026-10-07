package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.time.TimeRangeFilter;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAmount;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TimeRangeFilterUtils.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\f\u0010\n\u001a\u00020\u0005*\u00020\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"RECORD_START_TIME_BUFFER", "Ljava/time/Duration;", "createInstantTimeRange", "Landroidx/health/connect/client/impl/platform/aggregate/InstantTimeRange;", "timeRangeFilter", "Landroidx/health/connect/client/time/TimeRangeFilter;", "createLocalTimeRange", "Landroidx/health/connect/client/impl/platform/aggregate/LocalTimeRange;", "createTimeRange", "Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;", "withBufferedStart", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes14.dex */
public final class TimeRangeFilterUtilsKt {
    private static final Duration RECORD_START_TIME_BUFFER;

    public static final TimeRange<?> createTimeRange(TimeRangeFilter timeRangeFilter) {
        Intrinsics.checkNotNullParameter(timeRangeFilter, "timeRangeFilter");
        if (timeRangeFilter.isBasedOnLocalTime$connect_client_release()) {
            return createLocalTimeRange(timeRangeFilter);
        }
        return createInstantTimeRange(timeRangeFilter);
    }

    public static final InstantTimeRange createInstantTimeRange(TimeRangeFilter timeRangeFilter) {
        Intrinsics.checkNotNullParameter(timeRangeFilter, "timeRangeFilter");
        if (timeRangeFilter.isBasedOnLocalTime$connect_client_release()) {
            throw new IllegalArgumentException("TimeRangeFilter should be based on instant time".toString());
        }
        Instant startTime = timeRangeFilter.getStartTime();
        if (startTime == null) {
            startTime = Instant.EPOCH;
        }
        Instant endTime = timeRangeFilter.getEndTime();
        if (endTime == null) {
            endTime = Instant.now();
        }
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        return new InstantTimeRange(startTime, endTime);
    }

    public static final LocalTimeRange createLocalTimeRange(TimeRangeFilter timeRangeFilter) {
        Intrinsics.checkNotNullParameter(timeRangeFilter, "timeRangeFilter");
        if (!timeRangeFilter.isBasedOnLocalTime$connect_client_release()) {
            throw new IllegalArgumentException("TimeRangeFilter should be based on local time".toString());
        }
        LocalDateTime startTime = timeRangeFilter.getLocalStartTime();
        if (startTime == null) {
            startTime = LocalDateTime.ofInstant(Instant.EPOCH, ZoneOffset.MIN);
        }
        LocalDateTime endTime = timeRangeFilter.getLocalEndTime();
        if (endTime == null) {
            endTime = LocalDateTime.ofInstant(Instant.now().plus((TemporalAmount) Duration.ofDays(1L)), ZoneOffset.MAX);
        }
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        return new LocalTimeRange(startTime, endTime);
    }

    public static final TimeRangeFilter withBufferedStart(TimeRangeFilter $this$withBufferedStart) {
        Intrinsics.checkNotNullParameter($this$withBufferedStart, "<this>");
        Instant startTime = $this$withBufferedStart.getStartTime();
        Instant minus = startTime != null ? startTime.minus((TemporalAmount) RECORD_START_TIME_BUFFER) : null;
        Instant endTime = $this$withBufferedStart.getEndTime();
        LocalDateTime localStartTime = $this$withBufferedStart.getLocalStartTime();
        return new TimeRangeFilter(minus, endTime, localStartTime != null ? localStartTime.minus((TemporalAmount) RECORD_START_TIME_BUFFER) : null, $this$withBufferedStart.getLocalEndTime());
    }

    static {
        Duration ofDays = Duration.ofDays(1L);
        Intrinsics.checkNotNullExpressionValue(ofDays, "ofDays(1)");
        RECORD_START_TIME_BUFFER = ofDays;
    }
}
