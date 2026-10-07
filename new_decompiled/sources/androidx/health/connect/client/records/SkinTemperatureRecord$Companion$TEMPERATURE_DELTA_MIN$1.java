package androidx.health.connect.client.records;

import androidx.core.text.util.LocalePreferences;
import androidx.health.connect.client.units.TemperatureDelta;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: SkinTemperatureRecord.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
/* synthetic */ class SkinTemperatureRecord$Companion$TEMPERATURE_DELTA_MIN$1 extends FunctionReferenceImpl implements Function1<Double, TemperatureDelta> {
    SkinTemperatureRecord$Companion$TEMPERATURE_DELTA_MIN$1(Object obj) {
        super(1, obj, TemperatureDelta.Companion.class, LocalePreferences.TemperatureUnit.CELSIUS, "celsius(D)Landroidx/health/connect/client/units/TemperatureDelta;", 0);
    }

    public final TemperatureDelta invoke(double p0) {
        return ((TemperatureDelta.Companion) this.receiver).celsius(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TemperatureDelta invoke(Double d) {
        return invoke(d.doubleValue());
    }
}
