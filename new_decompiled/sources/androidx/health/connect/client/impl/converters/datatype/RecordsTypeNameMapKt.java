package androidx.health.connect.client.impl.converters.datatype;

import androidx.health.connect.client.records.ActiveCaloriesBurnedRecord;
import androidx.health.connect.client.records.BasalBodyTemperatureRecord;
import androidx.health.connect.client.records.BasalMetabolicRateRecord;
import androidx.health.connect.client.records.BloodGlucoseRecord;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.records.BodyFatRecord;
import androidx.health.connect.client.records.BodyTemperatureRecord;
import androidx.health.connect.client.records.BodyWaterMassRecord;
import androidx.health.connect.client.records.BoneMassRecord;
import androidx.health.connect.client.records.CervicalMucusRecord;
import androidx.health.connect.client.records.CyclingPedalingCadenceRecord;
import androidx.health.connect.client.records.DistanceRecord;
import androidx.health.connect.client.records.ElevationGainedRecord;
import androidx.health.connect.client.records.ExerciseSessionRecord;
import androidx.health.connect.client.records.FloorsClimbedRecord;
import androidx.health.connect.client.records.HeartRateRecord;
import androidx.health.connect.client.records.HeartRateVariabilityRmssdRecord;
import androidx.health.connect.client.records.HeightRecord;
import androidx.health.connect.client.records.HydrationRecord;
import androidx.health.connect.client.records.IntermenstrualBleedingRecord;
import androidx.health.connect.client.records.LeanBodyMassRecord;
import androidx.health.connect.client.records.MenstruationFlowRecord;
import androidx.health.connect.client.records.MenstruationPeriodRecord;
import androidx.health.connect.client.records.NutritionRecord;
import androidx.health.connect.client.records.OvulationTestRecord;
import androidx.health.connect.client.records.OxygenSaturationRecord;
import androidx.health.connect.client.records.PowerRecord;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.RespiratoryRateRecord;
import androidx.health.connect.client.records.RestingHeartRateRecord;
import androidx.health.connect.client.records.SexualActivityRecord;
import androidx.health.connect.client.records.SkinTemperatureRecord;
import androidx.health.connect.client.records.SleepSessionRecord;
import androidx.health.connect.client.records.SpeedRecord;
import androidx.health.connect.client.records.StepsCadenceRecord;
import androidx.health.connect.client.records.StepsRecord;
import androidx.health.connect.client.records.TotalCaloriesBurnedRecord;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.records.WeightRecord;
import androidx.health.connect.client.records.WheelchairPushesRecord;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* compiled from: RecordsTypeNameMap.kt */
@Metadata(m286d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\"%\u0010\u0000\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"%\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, m287d2 = {"RECORDS_CLASS_NAME_MAP", "", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/Record;", "", "getRECORDS_CLASS_NAME_MAP", "()Ljava/util/Map;", "RECORDS_TYPE_NAME_MAP", "getRECORDS_TYPE_NAME_MAP", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class RecordsTypeNameMapKt {
    private static final Map<KClass<? extends Record>, String> RECORDS_CLASS_NAME_MAP;
    private static final Map<String, KClass<? extends Record>> RECORDS_TYPE_NAME_MAP = MapsKt.mapOf(TuplesKt.m294to("ActiveCaloriesBurned", Reflection.getOrCreateKotlinClass(ActiveCaloriesBurnedRecord.class)), TuplesKt.m294to("ActivitySession", Reflection.getOrCreateKotlinClass(ExerciseSessionRecord.class)), TuplesKt.m294to("BasalBodyTemperature", Reflection.getOrCreateKotlinClass(BasalBodyTemperatureRecord.class)), TuplesKt.m294to("BasalMetabolicRate", Reflection.getOrCreateKotlinClass(BasalMetabolicRateRecord.class)), TuplesKt.m294to("BloodGlucose", Reflection.getOrCreateKotlinClass(BloodGlucoseRecord.class)), TuplesKt.m294to("BloodPressure", Reflection.getOrCreateKotlinClass(BloodPressureRecord.class)), TuplesKt.m294to("BodyFat", Reflection.getOrCreateKotlinClass(BodyFatRecord.class)), TuplesKt.m294to("BodyTemperature", Reflection.getOrCreateKotlinClass(BodyTemperatureRecord.class)), TuplesKt.m294to("BodyWaterMass", Reflection.getOrCreateKotlinClass(BodyWaterMassRecord.class)), TuplesKt.m294to("BoneMass", Reflection.getOrCreateKotlinClass(BoneMassRecord.class)), TuplesKt.m294to("CervicalMucus", Reflection.getOrCreateKotlinClass(CervicalMucusRecord.class)), TuplesKt.m294to("CyclingPedalingCadenceSeries", Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class)), TuplesKt.m294to("Distance", Reflection.getOrCreateKotlinClass(DistanceRecord.class)), TuplesKt.m294to("ElevationGained", Reflection.getOrCreateKotlinClass(ElevationGainedRecord.class)), TuplesKt.m294to("FloorsClimbed", Reflection.getOrCreateKotlinClass(FloorsClimbedRecord.class)), TuplesKt.m294to("HeartRateSeries", Reflection.getOrCreateKotlinClass(HeartRateRecord.class)), TuplesKt.m294to("HeartRateVariabilityRmssd", Reflection.getOrCreateKotlinClass(HeartRateVariabilityRmssdRecord.class)), TuplesKt.m294to("Height", Reflection.getOrCreateKotlinClass(HeightRecord.class)), TuplesKt.m294to("Hydration", Reflection.getOrCreateKotlinClass(HydrationRecord.class)), TuplesKt.m294to("LeanBodyMass", Reflection.getOrCreateKotlinClass(LeanBodyMassRecord.class)), TuplesKt.m294to("Menstruation", Reflection.getOrCreateKotlinClass(MenstruationFlowRecord.class)), TuplesKt.m294to("MenstruationPeriod", Reflection.getOrCreateKotlinClass(MenstruationPeriodRecord.class)), TuplesKt.m294to("Nutrition", Reflection.getOrCreateKotlinClass(NutritionRecord.class)), TuplesKt.m294to("OvulationTest", Reflection.getOrCreateKotlinClass(OvulationTestRecord.class)), TuplesKt.m294to("OxygenSaturation", Reflection.getOrCreateKotlinClass(OxygenSaturationRecord.class)), TuplesKt.m294to("PowerSeries", Reflection.getOrCreateKotlinClass(PowerRecord.class)), TuplesKt.m294to("RespiratoryRate", Reflection.getOrCreateKotlinClass(RespiratoryRateRecord.class)), TuplesKt.m294to("RestingHeartRate", Reflection.getOrCreateKotlinClass(RestingHeartRateRecord.class)), TuplesKt.m294to("SexualActivity", Reflection.getOrCreateKotlinClass(SexualActivityRecord.class)), TuplesKt.m294to("SkinTemperature", Reflection.getOrCreateKotlinClass(SkinTemperatureRecord.class)), TuplesKt.m294to("SleepSession", Reflection.getOrCreateKotlinClass(SleepSessionRecord.class)), TuplesKt.m294to("SpeedSeries", Reflection.getOrCreateKotlinClass(SpeedRecord.class)), TuplesKt.m294to("IntermenstrualBleeding", Reflection.getOrCreateKotlinClass(IntermenstrualBleedingRecord.class)), TuplesKt.m294to("Steps", Reflection.getOrCreateKotlinClass(StepsRecord.class)), TuplesKt.m294to("StepsCadenceSeries", Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class)), TuplesKt.m294to("TotalCaloriesBurned", Reflection.getOrCreateKotlinClass(TotalCaloriesBurnedRecord.class)), TuplesKt.m294to("Vo2Max", Reflection.getOrCreateKotlinClass(Vo2MaxRecord.class)), TuplesKt.m294to("WheelchairPushes", Reflection.getOrCreateKotlinClass(WheelchairPushesRecord.class)), TuplesKt.m294to("Weight", Reflection.getOrCreateKotlinClass(WeightRecord.class)));

    public static final Map<String, KClass<? extends Record>> getRECORDS_TYPE_NAME_MAP() {
        return RECORDS_TYPE_NAME_MAP;
    }

    static {
        Iterable $this$associate$iv = RECORDS_TYPE_NAME_MAP.entrySet();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            Map.Entry it = (Map.Entry) element$iv$iv;
            Pair m294to = TuplesKt.m294to(it.getValue(), it.getKey());
            destination$iv$iv.put(m294to.getFirst(), m294to.getSecond());
        }
        RECORDS_CLASS_NAME_MAP = destination$iv$iv;
    }

    public static final Map<KClass<? extends Record>, String> getRECORDS_CLASS_NAME_MAP() {
        return RECORDS_CLASS_NAME_MAP;
    }
}
