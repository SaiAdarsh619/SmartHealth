package com.example.healthconnect.codelab.data;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: HealthConnectUtil.kt */
@Metadata(m286d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\n\u0010\t\u001a\u00020\u0007*\u00020\b¨\u0006\n"}, m287d2 = {"dateTimeWithOffsetOrDefault", "Ljava/time/ZonedDateTime;", "time", "Ljava/time/Instant;", "offset", "Ljava/time/ZoneOffset;", "formatHoursMinutes", "", "Ljava/time/Duration;", "formatTime", "finished_debug"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes8.dex */
public final class HealthConnectUtilKt {
    public static final ZonedDateTime dateTimeWithOffsetOrDefault(Instant time, ZoneOffset offset) {
        Intrinsics.checkNotNullParameter(time, "time");
        if (offset != null) {
            ZonedDateTime ofInstant = ZonedDateTime.ofInstant(time, offset);
            Intrinsics.checkNotNullExpressionValue(ofInstant, "{\n    ZonedDateTime.ofInstant(time, offset)\n  }");
            return ofInstant;
        }
        ZonedDateTime ofInstant2 = ZonedDateTime.ofInstant(time, ZoneId.systemDefault());
        Intrinsics.checkNotNullExpressionValue(ofInstant2, "{\n    ZonedDateTime.ofIn…neId.systemDefault())\n  }");
        return ofInstant2;
    }

    public static final String formatTime(Duration $this$formatTime) {
        Intrinsics.checkNotNullParameter($this$formatTime, "<this>");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        long j = 60;
        String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf($this$formatTime.toHours() % 24), Long.valueOf($this$formatTime.toMinutes() % j), Long.valueOf($this$formatTime.getSeconds() % j)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    public static final String formatHoursMinutes(Duration $this$formatHoursMinutes) {
        Intrinsics.checkNotNullParameter($this$formatHoursMinutes, "<this>");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%01dh%02dm", Arrays.copyOf(new Object[]{Long.valueOf($this$formatHoursMinutes.toHours() % 24), Long.valueOf($this$formatHoursMinutes.toMinutes() % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }
}
