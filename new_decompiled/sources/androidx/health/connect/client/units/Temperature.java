package androidx.health.connect.client.units;

import androidx.core.text.util.LocalePreferences;
import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Temperature.kt */
@Metadata(m286d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0015\u0016B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0007\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m287d2 = {"Landroidx/health/connect/client/units/Temperature;", "", "value", "", "type", "Landroidx/health/connect/client/units/Temperature$Type;", "(DLandroidx/health/connect/client/units/Temperature$Type;)V", "inCelsius", "getCelsius", "()D", "inFahrenheit", "getFahrenheit", "compareTo", "", Vo2MaxRecord.MeasurementMethod.OTHER, "equals", "", "", "hashCode", "toString", "", "Companion", "Type", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class Temperature implements Comparable<Temperature> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Type type;
    private final double value;

    /* compiled from: Temperature.kt */
    @Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            try {
                iArr[Type.CELSIUS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Type.FAHRENHEIT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ Temperature(double d, Type type, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, type);
    }

    private Temperature(double value, Type type) {
        this.value = value;
        this.type = type;
    }

    public final double getCelsius() {
        switch (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()]) {
            case 1:
                return this.value;
            case 2:
                return (this.value - 32.0d) / 1.8d;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final double getFahrenheit() {
        switch (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()]) {
            case 1:
                return (this.value * 1.8d) + 32.0d;
            case 2:
                return this.value;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Temperature other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.type == other.type) {
            return Double.compare(this.value, other.value);
        }
        return Double.compare(getCelsius(), other.getCelsius());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Temperature) {
            return this.type == ((Temperature) other).type ? this.value == ((Temperature) other).value : getCelsius() == ((Temperature) other).getCelsius();
        }
        return false;
    }

    public int hashCode() {
        return Double.hashCode(getCelsius());
    }

    public String toString() {
        return this.value + ' ' + this.type.getTitle();
    }

    /* compiled from: Temperature.kt */
    @Metadata(m286d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\b"}, m287d2 = {"Landroidx/health/connect/client/units/Temperature$Companion;", "", "()V", LocalePreferences.TemperatureUnit.CELSIUS, "Landroidx/health/connect/client/units/Temperature;", "value", "", "fahrenheit", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Temperature celsius(double value) {
            return new Temperature(value, Type.CELSIUS, null);
        }

        @JvmStatic
        public final Temperature fahrenheit(double value) {
            return new Temperature(value, Type.FAHRENHEIT, null);
        }
    }

    @JvmStatic
    public static final Temperature celsius(double value) {
        return INSTANCE.celsius(value);
    }

    @JvmStatic
    public static final Temperature fahrenheit(double value) {
        return INSTANCE.fahrenheit(value);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Temperature.kt */
    @Metadata(m286d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m287d2 = {"Landroidx/health/connect/client/units/Temperature$Type;", "", "(Ljava/lang/String;I)V", "title", "", "getTitle", "()Ljava/lang/String;", "CELSIUS", "FAHRENHEIT", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    private static final class Type {
        public static final Type CELSIUS = new CELSIUS("CELSIUS", 0);
        public static final Type FAHRENHEIT = new FAHRENHEIT("FAHRENHEIT", 1);
        private static final /* synthetic */ Type[] $VALUES = $values();

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{CELSIUS, FAHRENHEIT};
        }

        public /* synthetic */ Type(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public abstract String getTitle();

        /* compiled from: Temperature.kt */
        @Metadata(m286d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"Landroidx/health/connect/client/units/Temperature$Type$CELSIUS;", "Landroidx/health/connect/client/units/Temperature$Type;", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
        static final class CELSIUS extends Type {
            private final String title;

            CELSIUS(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
                this.title = "Celsius";
            }

            @Override // androidx.health.connect.client.units.Temperature.Type
            public String getTitle() {
                return this.title;
            }
        }

        private Type(String $enum$name, int $enum$ordinal) {
        }

        /* compiled from: Temperature.kt */
        @Metadata(m286d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"Landroidx/health/connect/client/units/Temperature$Type$FAHRENHEIT;", "Landroidx/health/connect/client/units/Temperature$Type;", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
        static final class FAHRENHEIT extends Type {
            private final String title;

            FAHRENHEIT(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
                this.title = "Fahrenheit";
            }

            @Override // androidx.health.connect.client.units.Temperature.Type
            public String getTitle() {
                return this.title;
            }
        }
    }
}
