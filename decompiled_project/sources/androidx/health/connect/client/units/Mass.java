package androidx.health.connect.client.units;

import androidx.health.connect.client.records.Vo2MaxRecord;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: Mass.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002 !B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\r\u0010\u001e\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001fR\u0011\u0010\u0007\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/health/connect/client/units/Mass;", "", "value", "", "type", "Landroidx/health/connect/client/units/Mass$Type;", "(DLandroidx/health/connect/client/units/Mass$Type;)V", "inGrams", "getGrams", "()D", "inKilograms", "getKilograms", "inMicrograms", "getMicrograms", "inMilligrams", "getMilligrams", "inOunces", "getOunces", "inPounds", "getPounds", "compareTo", "", Vo2MaxRecord.MeasurementMethod.OTHER, "equals", "", "", "get", "hashCode", "toString", "", "zero", "zero$connect_client_release", "Companion", "Type", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes14.dex */
public final class Mass implements Comparable<Mass> {
    public static final Companion Companion = new Companion(null);
    private static final Map<Type, Mass> ZEROS;
    private final Type type;
    private final double value;

    public /* synthetic */ Mass(double d, Type type, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, type);
    }

    private Mass(double value, Type type) {
        this.value = value;
        this.type = type;
    }

    public final double getGrams() {
        return this.value * this.type.getGramsPerUnit();
    }

    public final double getKilograms() {
        return get(Type.KILOGRAMS);
    }

    public final double getMilligrams() {
        return get(Type.MILLIGRAMS);
    }

    public final double getMicrograms() {
        return get(Type.MICROGRAMS);
    }

    public final double getOunces() {
        return get(Type.OUNCES);
    }

    public final double getPounds() {
        return get(Type.POUNDS);
    }

    private final double get(Type type) {
        return this.type == type ? this.value : getGrams() / type.getGramsPerUnit();
    }

    public final Mass zero$connect_client_release() {
        return (Mass) MapsKt.getValue(ZEROS, this.type);
    }

    @Override // java.lang.Comparable
    public int compareTo(Mass other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.type == other.type) {
            return Double.compare(this.value, other.value);
        }
        return Double.compare(getGrams(), other.getGrams());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Mass) {
            return this.type == ((Mass) other).type ? this.value == ((Mass) other).value : getGrams() == ((Mass) other).getGrams();
        }
        return false;
    }

    public int hashCode() {
        return Double.hashCode(getGrams());
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append(this.value).append(' ');
        String lowerCase = this.type.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return append.append(lowerCase).toString();
    }

    /* compiled from: Mass.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/health/connect/client/units/Mass$Companion;", "", "()V", "ZEROS", "", "Landroidx/health/connect/client/units/Mass$Type;", "Landroidx/health/connect/client/units/Mass;", "grams", "value", "", "kilograms", "micrograms", "milligrams", "ounces", "pounds", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Mass grams(double value) {
            return new Mass(value, Type.GRAMS, null);
        }

        @JvmStatic
        public final Mass kilograms(double value) {
            return new Mass(value, Type.KILOGRAMS, null);
        }

        @JvmStatic
        public final Mass milligrams(double value) {
            return new Mass(value, Type.MILLIGRAMS, null);
        }

        @JvmStatic
        public final Mass micrograms(double value) {
            return new Mass(value, Type.MICROGRAMS, null);
        }

        @JvmStatic
        public final Mass ounces(double value) {
            return new Mass(value, Type.OUNCES, null);
        }

        @JvmStatic
        public final Mass pounds(double value) {
            return new Mass(value, Type.POUNDS, null);
        }
    }

    static {
        Type[] values = Type.values();
        LinkedHashMap result$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
        for (Type type : values) {
            result$iv.put(type, new Mass(0.0d, type));
        }
        ZEROS = result$iv;
    }

    @JvmStatic
    public static final Mass grams(double value) {
        return Companion.grams(value);
    }

    @JvmStatic
    public static final Mass kilograms(double value) {
        return Companion.kilograms(value);
    }

    @JvmStatic
    public static final Mass milligrams(double value) {
        return Companion.milligrams(value);
    }

    @JvmStatic
    public static final Mass micrograms(double value) {
        return Companion.micrograms(value);
    }

    @JvmStatic
    public static final Mass ounces(double value) {
        return Companion.ounces(value);
    }

    @JvmStatic
    public static final Mass pounds(double value) {
        return Companion.pounds(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Mass.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\t\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Landroidx/health/connect/client/units/Mass$Type;", "", "(Ljava/lang/String;I)V", "gramsPerUnit", "", "getGramsPerUnit", "()D", "GRAMS", "KILOGRAMS", "MILLIGRAMS", "MICROGRAMS", "OUNCES", "POUNDS", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class Type {
        public static final Type GRAMS = new GRAMS("GRAMS", 0);
        public static final Type KILOGRAMS = new KILOGRAMS("KILOGRAMS", 1);
        public static final Type MILLIGRAMS = new MILLIGRAMS("MILLIGRAMS", 2);
        public static final Type MICROGRAMS = new MICROGRAMS("MICROGRAMS", 3);
        public static final Type OUNCES = new OUNCES("OUNCES", 4);
        public static final Type POUNDS = new POUNDS("POUNDS", 5);
        private static final /* synthetic */ Type[] $VALUES = $values();

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{GRAMS, KILOGRAMS, MILLIGRAMS, MICROGRAMS, OUNCES, POUNDS};
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

        public abstract double getGramsPerUnit();

        /* compiled from: Mass.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/units/Mass$Type$GRAMS;", "Landroidx/health/connect/client/units/Mass$Type;", "gramsPerUnit", "", "getGramsPerUnit", "()D", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes14.dex */
        static final class GRAMS extends Type {
            private final double gramsPerUnit;

            GRAMS(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
                this.gramsPerUnit = 1.0d;
            }

            @Override // androidx.health.connect.client.units.Mass.Type
            public double getGramsPerUnit() {
                return this.gramsPerUnit;
            }
        }

        private Type(String $enum$name, int $enum$ordinal) {
        }

        /* compiled from: Mass.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/units/Mass$Type$KILOGRAMS;", "Landroidx/health/connect/client/units/Mass$Type;", "gramsPerUnit", "", "getGramsPerUnit", "()D", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes14.dex */
        static final class KILOGRAMS extends Type {
            private final double gramsPerUnit;

            KILOGRAMS(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
                this.gramsPerUnit = 1000.0d;
            }

            @Override // androidx.health.connect.client.units.Mass.Type
            public double getGramsPerUnit() {
                return this.gramsPerUnit;
            }
        }

        /* compiled from: Mass.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/units/Mass$Type$MILLIGRAMS;", "Landroidx/health/connect/client/units/Mass$Type;", "gramsPerUnit", "", "getGramsPerUnit", "()D", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes14.dex */
        static final class MILLIGRAMS extends Type {
            private final double gramsPerUnit;

            MILLIGRAMS(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
                this.gramsPerUnit = 0.001d;
            }

            @Override // androidx.health.connect.client.units.Mass.Type
            public double getGramsPerUnit() {
                return this.gramsPerUnit;
            }
        }

        /* compiled from: Mass.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/units/Mass$Type$MICROGRAMS;", "Landroidx/health/connect/client/units/Mass$Type;", "gramsPerUnit", "", "getGramsPerUnit", "()D", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes14.dex */
        static final class MICROGRAMS extends Type {
            private final double gramsPerUnit;

            MICROGRAMS(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
                this.gramsPerUnit = 1.0E-6d;
            }

            @Override // androidx.health.connect.client.units.Mass.Type
            public double getGramsPerUnit() {
                return this.gramsPerUnit;
            }
        }

        /* compiled from: Mass.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/units/Mass$Type$OUNCES;", "Landroidx/health/connect/client/units/Mass$Type;", "gramsPerUnit", "", "getGramsPerUnit", "()D", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes14.dex */
        static final class OUNCES extends Type {
            private final double gramsPerUnit;

            OUNCES(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
                this.gramsPerUnit = 28.34952d;
            }

            @Override // androidx.health.connect.client.units.Mass.Type
            public double getGramsPerUnit() {
                return this.gramsPerUnit;
            }
        }

        /* compiled from: Mass.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/units/Mass$Type$POUNDS;", "Landroidx/health/connect/client/units/Mass$Type;", "gramsPerUnit", "", "getGramsPerUnit", "()D", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes14.dex */
        static final class POUNDS extends Type {
            private final double gramsPerUnit;

            POUNDS(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
                this.gramsPerUnit = 453.59237d;
            }

            @Override // androidx.health.connect.client.units.Mass.Type
            public double getGramsPerUnit() {
                return this.gramsPerUnit;
            }
        }
    }
}
