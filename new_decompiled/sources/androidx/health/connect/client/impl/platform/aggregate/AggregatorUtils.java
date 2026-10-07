package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.impl.converters.datatype.RecordsTypeNameMapKt;
import androidx.health.connect.client.impl.platform.TimeExtensionsKt;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.records.CyclingPedalingCadenceRecord;
import androidx.health.connect.client.records.IntervalRecord;
import androidx.health.connect.client.records.NutritionRecord;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.SeriesRecord;
import androidx.health.connect.client.records.SpeedRecord;
import androidx.health.connect.client.records.StepsCadenceRecord;
import java.time.Instant;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: AggregatorUtils.kt */
@Metadata(m286d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0000¢\u0006\u0002\b\u0011J!\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00132\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0000¢\u0006\u0002\b\u0014R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\b*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m287d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/AggregatorUtils;", "", "()V", "time", "Ljava/time/Instant;", "getTime$connect_client_release", "(Ljava/lang/Object;)Ljava/time/Instant;", "value", "", "getValue$connect_client_release", "(Ljava/lang/Object;)D", "contributesToAggregation", "", "record", "Landroidx/health/connect/client/records/Record;", "timeRange", "Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;", "contributesToAggregation$connect_client_release", "sliceFactor", "Landroidx/health/connect/client/records/IntervalRecord;", "sliceFactor$connect_client_release", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class AggregatorUtils {
    public static final AggregatorUtils INSTANCE = new AggregatorUtils();

    private AggregatorUtils() {
    }

    public final boolean contributesToAggregation$connect_client_release(Record record, TimeRange<?> timeRange) {
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(timeRange, "timeRange");
        if (record instanceof BloodPressureRecord) {
            return TimeExtensionsKt.isWithin(((BloodPressureRecord) record).getTime(), timeRange, ((BloodPressureRecord) record).getZoneOffset());
        }
        if (record instanceof NutritionRecord) {
            return ((NutritionRecord) record).getTransFat() != null && sliceFactor$connect_client_release((IntervalRecord) record, timeRange) > 0.0d;
        }
        if (record instanceof SeriesRecord) {
            Iterable $this$any$iv = ((SeriesRecord) record).getSamples();
            if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                return false;
            }
            for (Object element$iv : $this$any$iv) {
                if (TimeExtensionsKt.isWithin(INSTANCE.getTime$connect_client_release(element$iv), timeRange, ((SeriesRecord) record).getStartZoneOffset())) {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalStateException(("Unsupported record type for aggregation fallback: " + RecordsTypeNameMapKt.getRECORDS_CLASS_NAME_MAP().get(Reflection.getOrCreateKotlinClass(record.getClass()))).toString());
    }

    public final double sliceFactor$connect_client_release(IntervalRecord record, TimeRange<?> timeRange) {
        Instant rangeStartTime;
        Instant rangeEndTime;
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(timeRange, "timeRange");
        if (timeRange instanceof InstantTimeRange) {
            rangeStartTime = ((InstantTimeRange) timeRange).getStartTime();
        } else if (timeRange instanceof LocalTimeRange) {
            rangeStartTime = TimeExtensionsKt.toInstantWithDefaultZoneFallback(((LocalTimeRange) timeRange).getStartTime(), record.getStartZoneOffset());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (timeRange instanceof InstantTimeRange) {
            rangeEndTime = ((InstantTimeRange) timeRange).getEndTime();
        } else if (timeRange instanceof LocalTimeRange) {
            rangeEndTime = TimeExtensionsKt.toInstantWithDefaultZoneFallback(((LocalTimeRange) timeRange).getEndTime(), record.getEndZoneOffset());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Math.max(0.0d, TimeExtensionsKt.div(TimeExtensionsKt.minus((Instant) ComparisonsKt.minOf(record.getEndTime(), rangeEndTime), (Instant) ComparisonsKt.maxOf(record.getStartTime(), rangeStartTime)), TimeExtensionsKt.getDuration(record)));
    }

    public final Instant getTime$connect_client_release(Object $this$time) {
        Intrinsics.checkNotNullParameter($this$time, "<this>");
        if ($this$time instanceof CyclingPedalingCadenceRecord.Sample) {
            return ((CyclingPedalingCadenceRecord.Sample) $this$time).getTime();
        }
        if ($this$time instanceof SpeedRecord.Sample) {
            return ((SpeedRecord.Sample) $this$time).getTime();
        }
        if ($this$time instanceof StepsCadenceRecord.Sample) {
            return ((StepsCadenceRecord.Sample) $this$time).getTime();
        }
        throw new IllegalStateException(("Unsupported type for time: " + $this$time).toString());
    }

    public final double getValue$connect_client_release(Object $this$value) {
        Intrinsics.checkNotNullParameter($this$value, "<this>");
        if ($this$value instanceof CyclingPedalingCadenceRecord.Sample) {
            return ((CyclingPedalingCadenceRecord.Sample) $this$value).getRevolutionsPerMinute();
        }
        if ($this$value instanceof SpeedRecord.Sample) {
            return ((SpeedRecord.Sample) $this$value).getSpeed().getMetersPerSecond();
        }
        if ($this$value instanceof StepsCadenceRecord.Sample) {
            return ((StepsCadenceRecord.Sample) $this$value).getRate();
        }
        throw new IllegalStateException(("Unsupported type for value: " + $this$value).toString());
    }
}
