package androidx.health.connect.client.impl.converters.time;

import androidx.health.connect.client.time.TimeRangeFilter;
import androidx.health.platform.client.proto.TimeProto;
import java.time.Instant;
import java.time.LocalDateTime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeRangeFilterConverter.kt */
@Metadata(m286d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m287d2 = {"toProto", "Landroidx/health/platform/client/proto/TimeProto$TimeSpec;", "Landroidx/health/connect/client/time/TimeRangeFilter;", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class TimeRangeFilterConverterKt {
    public static final TimeProto.TimeSpec toProto(TimeRangeFilter $this$toProto) {
        Intrinsics.checkNotNullParameter($this$toProto, "<this>");
        TimeProto.TimeSpec.Builder $this$toProto_u24lambda_u244 = TimeProto.TimeSpec.newBuilder();
        Instant it = $this$toProto.getStartTime();
        if (it != null) {
            $this$toProto_u24lambda_u244.setStartTimeEpochMs(it.toEpochMilli());
        }
        Instant it2 = $this$toProto.getEndTime();
        if (it2 != null) {
            $this$toProto_u24lambda_u244.setEndTimeEpochMs(it2.toEpochMilli());
        }
        LocalDateTime it3 = $this$toProto.getLocalStartTime();
        if (it3 != null) {
            $this$toProto_u24lambda_u244.setStartLocalDateTime(it3.toString());
        }
        LocalDateTime it4 = $this$toProto.getLocalEndTime();
        if (it4 != null) {
            $this$toProto_u24lambda_u244.setEndLocalDateTime(it4.toString());
        }
        TimeProto.TimeSpec build = $this$toProto_u24lambda_u244.build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n        .ap…       }\n        .build()");
        return build;
    }
}
