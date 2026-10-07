package androidx.health.connect.client.impl.platform.aggregate;

import java.time.temporal.Temporal;
import kotlin.Metadata;

/* compiled from: TimeRange.kt */
@Metadata(m286d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003R\u0012\u0010\u0004\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0082\u0001\u0002\t\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, m287d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;", "T", "Ljava/time/temporal/Temporal;", "", "endTime", "getEndTime", "()Ljava/time/temporal/Temporal;", "startTime", "getStartTime", "Landroidx/health/connect/client/impl/platform/aggregate/InstantTimeRange;", "Landroidx/health/connect/client/impl/platform/aggregate/LocalTimeRange;", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public interface TimeRange<T extends Temporal> {
    T getEndTime();

    T getStartTime();
}
