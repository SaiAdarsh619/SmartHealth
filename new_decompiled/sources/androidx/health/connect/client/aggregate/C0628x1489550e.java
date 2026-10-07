package androidx.health.connect.client.aggregate;

import androidx.health.connect.client.aggregate.AggregateMetric;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AggregateMetric.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* renamed from: androidx.health.connect.client.aggregate.AggregateMetric$sam$androidx_health_connect_client_aggregate_AggregateMetric_Converter_FromDouble$0 */
/* loaded from: classes14.dex */
final class C0628x1489550e implements AggregateMetric.Converter.FromDouble, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    C0628x1489550e(Function1 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.function = function;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof AggregateMetric.Converter.FromDouble) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final /* synthetic */ Object invoke(double d) {
        return this.function.invoke(Double.valueOf(d));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).doubleValue());
    }
}
