package androidx.health.connect.client.records;

import androidx.health.connect.client.units.Energy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: NutritionRecord.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
/* synthetic */ class NutritionRecord$Companion$ENERGY_TOTAL$1 extends FunctionReferenceImpl implements Function1<Double, Energy> {
    NutritionRecord$Companion$ENERGY_TOTAL$1(Object obj) {
        super(1, obj, Energy.Companion.class, "kilocalories", "kilocalories(D)Landroidx/health/connect/client/units/Energy;", 0);
    }

    public final Energy invoke(double p0) {
        return ((Energy.Companion) this.receiver).kilocalories(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Energy invoke(Double d) {
        return invoke(d.doubleValue());
    }
}
