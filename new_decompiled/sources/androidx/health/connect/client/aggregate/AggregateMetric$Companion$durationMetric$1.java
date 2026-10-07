package androidx.health.connect.client.aggregate;

import androidx.health.connect.client.aggregate.AggregateMetric;
import java.time.Duration;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AggregateMetric.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
/* synthetic */ class AggregateMetric$Companion$durationMetric$1 implements AggregateMetric.Converter.FromLong, FunctionAdapter {
    public static final AggregateMetric$Companion$durationMetric$1 INSTANCE = new AggregateMetric$Companion$durationMetric$1();

    AggregateMetric$Companion$durationMetric$1() {
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof AggregateMetric.Converter.FromLong) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(1, Duration.class, "ofMillis", "ofMillis(J)Ljava/time/Duration;", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).longValue());
    }

    public final Duration invoke(long p0) {
        return Duration.ofMillis(p0);
    }
}
