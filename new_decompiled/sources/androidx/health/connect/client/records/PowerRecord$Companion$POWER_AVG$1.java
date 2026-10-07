package androidx.health.connect.client.records;

import androidx.health.connect.client.units.Power;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: PowerRecord.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
/* synthetic */ class PowerRecord$Companion$POWER_AVG$1 extends FunctionReferenceImpl implements Function1<Double, Power> {
    PowerRecord$Companion$POWER_AVG$1(Object obj) {
        super(1, obj, Power.Companion.class, "watts", "watts(D)Landroidx/health/connect/client/units/Power;", 0);
    }

    public final Power invoke(double p0) {
        return ((Power.Companion) this.receiver).watts(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Power invoke(Double d) {
        return invoke(d.doubleValue());
    }
}
