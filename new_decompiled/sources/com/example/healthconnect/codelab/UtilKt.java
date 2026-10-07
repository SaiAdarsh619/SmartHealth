package com.example.healthconnect.codelab;

import androidx.compose.material.ScaffoldState;
import com.example.healthconnect.codelab.data.HealthConnectUtilKt;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Util.kt */
@Metadata(m286d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u001a \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¨\u0006\u0010"}, m287d2 = {"formatDisplayTimeStartEnd", "", "startTime", "Ljava/time/Instant;", "startZoneOffset", "Ljava/time/ZoneOffset;", "endTime", "endZoneOffset", "showExceptionSnackbar", "", "scaffoldState", "Landroidx/compose/material/ScaffoldState;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "throwable", "", "finished_debug"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes11.dex */
public final class UtilKt {
    public static final void showExceptionSnackbar(ScaffoldState scaffoldState, CoroutineScope scope, Throwable throwable) {
        Intrinsics.checkNotNullParameter(scaffoldState, "scaffoldState");
        Intrinsics.checkNotNullParameter(scope, "scope");
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new UtilKt$showExceptionSnackbar$1(scaffoldState, throwable, null), 3, null);
    }

    public static final String formatDisplayTimeStartEnd(Instant startTime, ZoneOffset startZoneOffset, Instant endTime, ZoneOffset endZoneOffset) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        String start = timeFormatter.format(HealthConnectUtilKt.dateTimeWithOffsetOrDefault(startTime, startZoneOffset));
        String end = timeFormatter.format(HealthConnectUtilKt.dateTimeWithOffsetOrDefault(endTime, endZoneOffset));
        return start + " - " + end;
    }
}
