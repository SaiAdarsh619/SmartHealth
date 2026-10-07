package androidx.health.connect.client.impl.platform.records;

import android.health.connect.datatypes.units.BloodGlucose;
import android.health.connect.datatypes.units.Energy;
import android.health.connect.datatypes.units.Length;
import android.health.connect.datatypes.units.Mass;
import android.health.connect.datatypes.units.Percentage;
import android.health.connect.datatypes.units.Power;
import android.health.connect.datatypes.units.Pressure;
import android.health.connect.datatypes.units.Temperature;
import android.health.connect.datatypes.units.TemperatureDelta;
import android.health.connect.datatypes.units.Velocity;
import android.health.connect.datatypes.units.Volume;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnitConverters.kt */
@Metadata(m286d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00060\u0002j\u0002`\u0003H\u0000\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00060\u0006j\u0002`\u0007H\u0000\u001a\u0010\u0010\b\u001a\u00060\tj\u0002`\n*\u00020\u000bH\u0000\u001a\u0010\u0010\f\u001a\u00060\u0002j\u0002`\u0003*\u00020\u0001H\u0000\u001a\u0010\u0010\r\u001a\u00060\u000ej\u0002`\u000f*\u00020\u0010H\u0000\u001a\u0010\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00020\u0005H\u0000\u001a\u0010\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014*\u00020\u0015H\u0000\u001a\u0010\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018*\u00020\u0019H\u0000\u001a\u0010\u0010\u001a\u001a\u00060\u001bj\u0002`\u001c*\u00020\u001dH\u0000\u001a\u0010\u0010\u001e\u001a\u00060\u001fj\u0002` *\u00020!H\u0000\u001a\u0010\u0010\"\u001a\u00060#j\u0002`$*\u00020%H\u0001\u001a\u0010\u0010&\u001a\u00060'j\u0002`(*\u00020)H\u0000\u001a\u0010\u0010*\u001a\u00060+j\u0002`,*\u00020-H\u0000\u001a\u0010\u0010.\u001a\u00020\u000b*\u00060\tj\u0002`\nH\u0000\u001a\u0010\u0010/\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0000\u001a\u0010\u00100\u001a\u00020\u0010*\u00060\u000ej\u0002`\u000fH\u0000\u001a\u0010\u00101\u001a\u00020\u0005*\u00060\u0006j\u0002`\u0007H\u0000\u001a\u0010\u00102\u001a\u00020\u0015*\u00060\u0013j\u0002`\u0014H\u0000\u001a\u0010\u00103\u001a\u00020\u0019*\u00060\u0017j\u0002`\u0018H\u0000\u001a\u0010\u00104\u001a\u00020\u001d*\u00060\u001bj\u0002`\u001cH\u0000\u001a\u0010\u00105\u001a\u00020!*\u00060\u001fj\u0002` H\u0000\u001a\u0010\u00106\u001a\u00020%*\u00060#j\u0002`$H\u0001\u001a\u0010\u00107\u001a\u00020)*\u00060'j\u0002`(H\u0000\u001a\u0010\u00108\u001a\u00020-*\u00060+j\u0002`,H\u0000¨\u00069"}, m287d2 = {"toNonDefaultSdkEnergy", "Landroidx/health/connect/client/units/Energy;", "Landroid/health/connect/datatypes/units/Energy;", "Landroidx/health/connect/client/impl/platform/records/PlatformEnergy;", "toNonDefaultSdkMass", "Landroidx/health/connect/client/units/Mass;", "Landroid/health/connect/datatypes/units/Mass;", "Landroidx/health/connect/client/impl/platform/records/PlatformMass;", "toPlatformBloodGlucose", "Landroid/health/connect/datatypes/units/BloodGlucose;", "Landroidx/health/connect/client/impl/platform/records/PlatformBloodGlucose;", "Landroidx/health/connect/client/units/BloodGlucose;", "toPlatformEnergy", "toPlatformLength", "Landroid/health/connect/datatypes/units/Length;", "Landroidx/health/connect/client/impl/platform/records/PlatformLength;", "Landroidx/health/connect/client/units/Length;", "toPlatformMass", "toPlatformPercentage", "Landroid/health/connect/datatypes/units/Percentage;", "Landroidx/health/connect/client/impl/platform/records/PlatformPercentage;", "Landroidx/health/connect/client/units/Percentage;", "toPlatformPower", "Landroid/health/connect/datatypes/units/Power;", "Landroidx/health/connect/client/impl/platform/records/PlatformPower;", "Landroidx/health/connect/client/units/Power;", "toPlatformPressure", "Landroid/health/connect/datatypes/units/Pressure;", "Landroidx/health/connect/client/impl/platform/records/PlatformPressure;", "Landroidx/health/connect/client/units/Pressure;", "toPlatformTemperature", "Landroid/health/connect/datatypes/units/Temperature;", "Landroidx/health/connect/client/impl/platform/records/PlatformTemperature;", "Landroidx/health/connect/client/units/Temperature;", "toPlatformTemperatureDelta", "Landroid/health/connect/datatypes/units/TemperatureDelta;", "Landroidx/health/connect/client/impl/platform/records/PlatformTemperatureDelta;", "Landroidx/health/connect/client/units/TemperatureDelta;", "toPlatformVelocity", "Landroid/health/connect/datatypes/units/Velocity;", "Landroidx/health/connect/client/impl/platform/records/PlatformVelocity;", "Landroidx/health/connect/client/units/Velocity;", "toPlatformVolume", "Landroid/health/connect/datatypes/units/Volume;", "Landroidx/health/connect/client/impl/platform/records/PlatformVolume;", "Landroidx/health/connect/client/units/Volume;", "toSdkBloodGlucose", "toSdkEnergy", "toSdkLength", "toSdkMass", "toSdkPercentage", "toSdkPower", "toSdkPressure", "toSdkTemperature", "toSdkTemperatureDelta", "toSdkVelocity", "toSdkVolume", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class UnitConvertersKt {
    public static final BloodGlucose toPlatformBloodGlucose(androidx.health.connect.client.units.BloodGlucose $this$toPlatformBloodGlucose) {
        Intrinsics.checkNotNullParameter($this$toPlatformBloodGlucose, "<this>");
        BloodGlucose fromMillimolesPerLiter = BloodGlucose.fromMillimolesPerLiter($this$toPlatformBloodGlucose.getMillimolesPerLiter());
        Intrinsics.checkNotNullExpressionValue(fromMillimolesPerLiter, "fromMillimolesPerLiter(inMillimolesPerLiter)");
        return fromMillimolesPerLiter;
    }

    public static final Energy toPlatformEnergy(androidx.health.connect.client.units.Energy $this$toPlatformEnergy) {
        Intrinsics.checkNotNullParameter($this$toPlatformEnergy, "<this>");
        Energy fromCalories = Energy.fromCalories($this$toPlatformEnergy.getCalories());
        Intrinsics.checkNotNullExpressionValue(fromCalories, "fromCalories(inCalories)");
        return fromCalories;
    }

    public static final Length toPlatformLength(androidx.health.connect.client.units.Length $this$toPlatformLength) {
        Intrinsics.checkNotNullParameter($this$toPlatformLength, "<this>");
        Length fromMeters = Length.fromMeters($this$toPlatformLength.getMeters());
        Intrinsics.checkNotNullExpressionValue(fromMeters, "fromMeters(inMeters)");
        return fromMeters;
    }

    public static final Mass toPlatformMass(androidx.health.connect.client.units.Mass $this$toPlatformMass) {
        Intrinsics.checkNotNullParameter($this$toPlatformMass, "<this>");
        Mass fromGrams = Mass.fromGrams($this$toPlatformMass.getGrams());
        Intrinsics.checkNotNullExpressionValue(fromGrams, "fromGrams(inGrams)");
        return fromGrams;
    }

    public static final Percentage toPlatformPercentage(androidx.health.connect.client.units.Percentage $this$toPlatformPercentage) {
        Intrinsics.checkNotNullParameter($this$toPlatformPercentage, "<this>");
        Percentage fromValue = Percentage.fromValue($this$toPlatformPercentage.getValue());
        Intrinsics.checkNotNullExpressionValue(fromValue, "fromValue(value)");
        return fromValue;
    }

    public static final Power toPlatformPower(androidx.health.connect.client.units.Power $this$toPlatformPower) {
        Intrinsics.checkNotNullParameter($this$toPlatformPower, "<this>");
        Power fromWatts = Power.fromWatts($this$toPlatformPower.getWatts());
        Intrinsics.checkNotNullExpressionValue(fromWatts, "fromWatts(inWatts)");
        return fromWatts;
    }

    public static final Pressure toPlatformPressure(androidx.health.connect.client.units.Pressure $this$toPlatformPressure) {
        Intrinsics.checkNotNullParameter($this$toPlatformPressure, "<this>");
        Pressure fromMillimetersOfMercury = Pressure.fromMillimetersOfMercury($this$toPlatformPressure.getValue());
        Intrinsics.checkNotNullExpressionValue(fromMillimetersOfMercury, "fromMillimetersOfMercury(inMillimetersOfMercury)");
        return fromMillimetersOfMercury;
    }

    public static final Temperature toPlatformTemperature(androidx.health.connect.client.units.Temperature $this$toPlatformTemperature) {
        Intrinsics.checkNotNullParameter($this$toPlatformTemperature, "<this>");
        Temperature fromCelsius = Temperature.fromCelsius($this$toPlatformTemperature.getCelsius());
        Intrinsics.checkNotNullExpressionValue(fromCelsius, "fromCelsius(inCelsius)");
        return fromCelsius;
    }

    public static final TemperatureDelta toPlatformTemperatureDelta(androidx.health.connect.client.units.TemperatureDelta $this$toPlatformTemperatureDelta) {
        Intrinsics.checkNotNullParameter($this$toPlatformTemperatureDelta, "<this>");
        TemperatureDelta fromCelsius = TemperatureDelta.fromCelsius($this$toPlatformTemperatureDelta.getCelsius());
        Intrinsics.checkNotNullExpressionValue(fromCelsius, "fromCelsius(inCelsius)");
        return fromCelsius;
    }

    public static final Velocity toPlatformVelocity(androidx.health.connect.client.units.Velocity $this$toPlatformVelocity) {
        Intrinsics.checkNotNullParameter($this$toPlatformVelocity, "<this>");
        Velocity fromMetersPerSecond = Velocity.fromMetersPerSecond($this$toPlatformVelocity.getMetersPerSecond());
        Intrinsics.checkNotNullExpressionValue(fromMetersPerSecond, "fromMetersPerSecond(inMetersPerSecond)");
        return fromMetersPerSecond;
    }

    public static final Volume toPlatformVolume(androidx.health.connect.client.units.Volume $this$toPlatformVolume) {
        Intrinsics.checkNotNullParameter($this$toPlatformVolume, "<this>");
        Volume fromLiters = Volume.fromLiters($this$toPlatformVolume.getLiters());
        Intrinsics.checkNotNullExpressionValue(fromLiters, "fromLiters(inLiters)");
        return fromLiters;
    }

    public static final androidx.health.connect.client.units.BloodGlucose toSdkBloodGlucose(BloodGlucose $this$toSdkBloodGlucose) {
        Intrinsics.checkNotNullParameter($this$toSdkBloodGlucose, "<this>");
        return androidx.health.connect.client.units.BloodGlucose.INSTANCE.millimolesPerLiter($this$toSdkBloodGlucose.getInMillimolesPerLiter());
    }

    public static final androidx.health.connect.client.units.Energy toNonDefaultSdkEnergy(Energy $this$toNonDefaultSdkEnergy) {
        Intrinsics.checkNotNullParameter($this$toNonDefaultSdkEnergy, "<this>");
        Energy energy = !(($this$toNonDefaultSdkEnergy.getInCalories() > Double.MIN_VALUE ? 1 : ($this$toNonDefaultSdkEnergy.getInCalories() == Double.MIN_VALUE ? 0 : -1)) == 0) ? $this$toNonDefaultSdkEnergy : null;
        if (energy != null) {
            return toSdkEnergy(energy);
        }
        return null;
    }

    public static final androidx.health.connect.client.units.Energy toSdkEnergy(Energy $this$toSdkEnergy) {
        Intrinsics.checkNotNullParameter($this$toSdkEnergy, "<this>");
        return androidx.health.connect.client.units.Energy.INSTANCE.calories($this$toSdkEnergy.getInCalories());
    }

    public static final androidx.health.connect.client.units.Length toSdkLength(Length $this$toSdkLength) {
        Intrinsics.checkNotNullParameter($this$toSdkLength, "<this>");
        return androidx.health.connect.client.units.Length.INSTANCE.meters($this$toSdkLength.getInMeters());
    }

    public static final androidx.health.connect.client.units.Mass toNonDefaultSdkMass(Mass $this$toNonDefaultSdkMass) {
        Intrinsics.checkNotNullParameter($this$toNonDefaultSdkMass, "<this>");
        Mass mass = !(($this$toNonDefaultSdkMass.getInGrams() > Double.MIN_VALUE ? 1 : ($this$toNonDefaultSdkMass.getInGrams() == Double.MIN_VALUE ? 0 : -1)) == 0) ? $this$toNonDefaultSdkMass : null;
        if (mass != null) {
            return toSdkMass(mass);
        }
        return null;
    }

    public static final androidx.health.connect.client.units.Mass toSdkMass(Mass $this$toSdkMass) {
        Intrinsics.checkNotNullParameter($this$toSdkMass, "<this>");
        return androidx.health.connect.client.units.Mass.INSTANCE.grams($this$toSdkMass.getInGrams());
    }

    public static final androidx.health.connect.client.units.Percentage toSdkPercentage(Percentage $this$toSdkPercentage) {
        Intrinsics.checkNotNullParameter($this$toSdkPercentage, "<this>");
        return new androidx.health.connect.client.units.Percentage($this$toSdkPercentage.getValue());
    }

    public static final androidx.health.connect.client.units.Power toSdkPower(Power $this$toSdkPower) {
        Intrinsics.checkNotNullParameter($this$toSdkPower, "<this>");
        return androidx.health.connect.client.units.Power.INSTANCE.watts($this$toSdkPower.getInWatts());
    }

    public static final androidx.health.connect.client.units.Pressure toSdkPressure(Pressure $this$toSdkPressure) {
        Intrinsics.checkNotNullParameter($this$toSdkPressure, "<this>");
        return androidx.health.connect.client.units.Pressure.INSTANCE.millimetersOfMercury($this$toSdkPressure.getInMillimetersOfMercury());
    }

    public static final androidx.health.connect.client.units.Temperature toSdkTemperature(Temperature $this$toSdkTemperature) {
        Intrinsics.checkNotNullParameter($this$toSdkTemperature, "<this>");
        return androidx.health.connect.client.units.Temperature.INSTANCE.celsius($this$toSdkTemperature.getInCelsius());
    }

    public static final androidx.health.connect.client.units.TemperatureDelta toSdkTemperatureDelta(TemperatureDelta $this$toSdkTemperatureDelta) {
        Intrinsics.checkNotNullParameter($this$toSdkTemperatureDelta, "<this>");
        return androidx.health.connect.client.units.TemperatureDelta.INSTANCE.celsius($this$toSdkTemperatureDelta.getInCelsius());
    }

    public static final androidx.health.connect.client.units.Velocity toSdkVelocity(Velocity $this$toSdkVelocity) {
        Intrinsics.checkNotNullParameter($this$toSdkVelocity, "<this>");
        return androidx.health.connect.client.units.Velocity.INSTANCE.metersPerSecond($this$toSdkVelocity.getInMetersPerSecond());
    }

    public static final androidx.health.connect.client.units.Volume toSdkVolume(Volume $this$toSdkVolume) {
        Intrinsics.checkNotNullParameter($this$toSdkVolume, "<this>");
        return androidx.health.connect.client.units.Volume.INSTANCE.liters($this$toSdkVolume.getInLiters());
    }
}
