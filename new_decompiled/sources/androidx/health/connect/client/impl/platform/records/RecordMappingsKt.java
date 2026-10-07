package androidx.health.connect.client.impl.platform.records;

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
import androidx.health.connect.client.records.PlannedExerciseSessionRecord;
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
import androidx.health.connect.client.records.UtilsKt;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.records.WeightRecord;
import androidx.health.connect.client.records.WheelchairPushesRecord;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: RecordMappings.kt */
@Metadata(m286d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"4\u0010\u0000\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u00060\u0005j\u0002`\u00060\u00040\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"6\u0010\t\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u00060\u0005j\u0002`\u00060\u00040\u00018\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, m287d2 = {"SDK_TO_PLATFORM_RECORD_CLASS", "", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/Record;", "Ljava/lang/Class;", "Landroid/health/connect/datatypes/Record;", "Landroidx/health/connect/client/impl/platform/records/PlatformRecord;", "getSDK_TO_PLATFORM_RECORD_CLASS", "()Ljava/util/Map;", "SDK_TO_PLATFORM_RECORD_CLASS_EXT_13", "getSDK_TO_PLATFORM_RECORD_CLASS_EXT_13", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class RecordMappingsKt {
    private static final Map<KClass<? extends Record>, Class<? extends android.health.connect.datatypes.Record>> SDK_TO_PLATFORM_RECORD_CLASS;
    private static final Map<KClass<? extends Record>, Class<? extends android.health.connect.datatypes.Record>> SDK_TO_PLATFORM_RECORD_CLASS_EXT_13;

    public static final Map<KClass<? extends Record>, Class<? extends android.health.connect.datatypes.Record>> getSDK_TO_PLATFORM_RECORD_CLASS_EXT_13() {
        return SDK_TO_PLATFORM_RECORD_CLASS_EXT_13;
    }

    static {
        SDK_TO_PLATFORM_RECORD_CLASS_EXT_13 = UtilsKt.isAtLeastSdkExtension13() ? MapsKt.mapOf(TuplesKt.m294to(Reflection.getOrCreateKotlinClass(PlannedExerciseSessionRecord.class), android.health.connect.datatypes.PlannedExerciseSessionRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(SkinTemperatureRecord.class), android.health.connect.datatypes.SkinTemperatureRecord.class)) : MapsKt.emptyMap();
        SDK_TO_PLATFORM_RECORD_CLASS = MapsKt.mapOf(TuplesKt.m294to(Reflection.getOrCreateKotlinClass(ActiveCaloriesBurnedRecord.class), android.health.connect.datatypes.ActiveCaloriesBurnedRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(BasalBodyTemperatureRecord.class), android.health.connect.datatypes.BasalBodyTemperatureRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(BasalMetabolicRateRecord.class), android.health.connect.datatypes.BasalMetabolicRateRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(BloodGlucoseRecord.class), android.health.connect.datatypes.BloodGlucoseRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(BloodPressureRecord.class), android.health.connect.datatypes.BloodPressureRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(BodyFatRecord.class), android.health.connect.datatypes.BodyFatRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(BodyTemperatureRecord.class), android.health.connect.datatypes.BodyTemperatureRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(BodyWaterMassRecord.class), android.health.connect.datatypes.BodyWaterMassRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(BoneMassRecord.class), android.health.connect.datatypes.BoneMassRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(CervicalMucusRecord.class), android.health.connect.datatypes.CervicalMucusRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class), android.health.connect.datatypes.CyclingPedalingCadenceRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(DistanceRecord.class), android.health.connect.datatypes.DistanceRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(ElevationGainedRecord.class), android.health.connect.datatypes.ElevationGainedRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(ExerciseSessionRecord.class), android.health.connect.datatypes.ExerciseSessionRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(FloorsClimbedRecord.class), android.health.connect.datatypes.FloorsClimbedRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(HeartRateRecord.class), android.health.connect.datatypes.HeartRateRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(HeartRateVariabilityRmssdRecord.class), android.health.connect.datatypes.HeartRateVariabilityRmssdRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(HeightRecord.class), android.health.connect.datatypes.HeightRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(HydrationRecord.class), android.health.connect.datatypes.HydrationRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(IntermenstrualBleedingRecord.class), android.health.connect.datatypes.IntermenstrualBleedingRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(LeanBodyMassRecord.class), android.health.connect.datatypes.LeanBodyMassRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(MenstruationFlowRecord.class), android.health.connect.datatypes.MenstruationFlowRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(MenstruationPeriodRecord.class), android.health.connect.datatypes.MenstruationPeriodRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(NutritionRecord.class), android.health.connect.datatypes.NutritionRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(OvulationTestRecord.class), android.health.connect.datatypes.OvulationTestRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(OxygenSaturationRecord.class), android.health.connect.datatypes.OxygenSaturationRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(PowerRecord.class), android.health.connect.datatypes.PowerRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(RespiratoryRateRecord.class), android.health.connect.datatypes.RespiratoryRateRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(RestingHeartRateRecord.class), android.health.connect.datatypes.RestingHeartRateRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(SexualActivityRecord.class), android.health.connect.datatypes.SexualActivityRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(SleepSessionRecord.class), android.health.connect.datatypes.SleepSessionRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(SpeedRecord.class), android.health.connect.datatypes.SpeedRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class), android.health.connect.datatypes.StepsCadenceRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(StepsRecord.class), android.health.connect.datatypes.StepsRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(TotalCaloriesBurnedRecord.class), android.health.connect.datatypes.TotalCaloriesBurnedRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(Vo2MaxRecord.class), android.health.connect.datatypes.Vo2MaxRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(WeightRecord.class), android.health.connect.datatypes.WeightRecord.class), TuplesKt.m294to(Reflection.getOrCreateKotlinClass(WheelchairPushesRecord.class), android.health.connect.datatypes.WheelchairPushesRecord.class));
    }

    public static final Map<KClass<? extends Record>, Class<? extends android.health.connect.datatypes.Record>> getSDK_TO_PLATFORM_RECORD_CLASS() {
        return SDK_TO_PLATFORM_RECORD_CLASS;
    }
}
