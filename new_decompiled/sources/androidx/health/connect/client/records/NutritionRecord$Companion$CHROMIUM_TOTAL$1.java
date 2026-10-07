package androidx.health.connect.client.records;

import androidx.health.connect.client.units.Mass;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: NutritionRecord.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
/* synthetic */ class NutritionRecord$Companion$CHROMIUM_TOTAL$1 extends FunctionReferenceImpl implements Function1<Double, Mass> {
    NutritionRecord$Companion$CHROMIUM_TOTAL$1(Object obj) {
        super(1, obj, Mass.Companion.class, "grams", "grams(D)Landroidx/health/connect/client/units/Mass;", 0);
    }

    public final Mass invoke(double p0) {
        return ((Mass.Companion) this.receiver).grams(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Mass invoke(Double d) {
        return invoke(d.doubleValue());
    }
}
