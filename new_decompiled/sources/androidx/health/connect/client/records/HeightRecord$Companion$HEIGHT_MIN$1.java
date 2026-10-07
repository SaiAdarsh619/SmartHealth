package androidx.health.connect.client.records;

import androidx.health.connect.client.units.Length;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: HeightRecord.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
/* synthetic */ class HeightRecord$Companion$HEIGHT_MIN$1 extends FunctionReferenceImpl implements Function1<Double, Length> {
    HeightRecord$Companion$HEIGHT_MIN$1(Object obj) {
        super(1, obj, Length.Companion.class, "meters", "meters(D)Landroidx/health/connect/client/units/Length;", 0);
    }

    public final Length invoke(double p0) {
        return ((Length.Companion) this.receiver).meters(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Length invoke(Double d) {
        return invoke(d.doubleValue());
    }
}
