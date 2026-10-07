package androidx.health.connect.client.records;

import androidx.health.connect.client.units.Volume;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: HydrationRecord.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
/* synthetic */ class HydrationRecord$Companion$VOLUME_TOTAL$1 extends FunctionReferenceImpl implements Function1<Double, Volume> {
    HydrationRecord$Companion$VOLUME_TOTAL$1(Object obj) {
        super(1, obj, Volume.Companion.class, "liters", "liters(D)Landroidx/health/connect/client/units/Volume;", 0);
    }

    public final Volume invoke(double p0) {
        return ((Volume.Companion) this.receiver).liters(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Volume invoke(Double d) {
        return invoke(d.doubleValue());
    }
}
