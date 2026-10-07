package androidx.health.connect.client.impl.platform.records;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* compiled from: IntDefMappings.kt */
@Metadata(m286d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\bn\u001a$\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001H\u0002\u001a\f\u0010L\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010M\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010N\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010O\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010P\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010Q\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010R\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010S\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010T\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010U\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010V\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010W\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010X\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010Y\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010Z\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010[\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010\\\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010]\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010^\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010_\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010`\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010a\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010b\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010c\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010d\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010e\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010f\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010g\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010h\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010i\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010j\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010k\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010l\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010m\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010n\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010o\u001a\u00020\u0002*\u00020\u0002H\u0000\" \u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\" \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0004\" \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0004\" \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0004\" \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0004\" \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0004\" \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0004\" \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0004\" \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0004\" \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0004\" \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0004\" \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0004\" \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0004\" \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0004\" \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0004\" \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0004\" \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0004\" \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0004\" \u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0004\" \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0004\" \u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0004\" \u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0004\" \u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0004\" \u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0004\" \u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0004\" \u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0004\" \u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0004\" \u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0004\" \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0004\" \u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0004\" \u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0004\" \u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0004\" \u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0004\" \u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0004\" \u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0004\" \u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u0004¨\u0006p"}, m287d2 = {"PLATFORM_TO_SDK_BLOOD_GLUCOSE_RELATION_TO_MEAL", "", "", "getPLATFORM_TO_SDK_BLOOD_GLUCOSE_RELATION_TO_MEAL", "()Ljava/util/Map;", "PLATFORM_TO_SDK_BLOOD_PRESSURE_BODY_POSITION", "getPLATFORM_TO_SDK_BLOOD_PRESSURE_BODY_POSITION", "PLATFORM_TO_SDK_BLOOD_PRESSURE_MEASUREMENT_LOCATION", "getPLATFORM_TO_SDK_BLOOD_PRESSURE_MEASUREMENT_LOCATION", "PLATFORM_TO_SDK_BODY_TEMPERATURE_MEASUREMENT_LOCATION", "getPLATFORM_TO_SDK_BODY_TEMPERATURE_MEASUREMENT_LOCATION", "PLATFORM_TO_SDK_CERVICAL_MUCUS_APPEARANCE", "getPLATFORM_TO_SDK_CERVICAL_MUCUS_APPEARANCE", "PLATFORM_TO_SDK_CERVICAL_MUCUS_SENSATION", "getPLATFORM_TO_SDK_CERVICAL_MUCUS_SENSATION", "PLATFORM_TO_SDK_EXERCISE_CATEGORY", "getPLATFORM_TO_SDK_EXERCISE_CATEGORY", "PLATFORM_TO_SDK_EXERCISE_SEGMENT_TYPE", "getPLATFORM_TO_SDK_EXERCISE_SEGMENT_TYPE", "PLATFORM_TO_SDK_EXERCISE_SESSION_TYPE", "getPLATFORM_TO_SDK_EXERCISE_SESSION_TYPE", "PLATFORM_TO_SDK_GLUCOSE_SPECIMEN_SOURCE", "getPLATFORM_TO_SDK_GLUCOSE_SPECIMEN_SOURCE", "PLATFORM_TO_SDK_MEAL_TYPE", "getPLATFORM_TO_SDK_MEAL_TYPE", "PLATFORM_TO_SDK_MENSTRUATION_FLOW_TYPE", "getPLATFORM_TO_SDK_MENSTRUATION_FLOW_TYPE", "PLATFORM_TO_SDK_OVULATION_TEST_RESULT", "getPLATFORM_TO_SDK_OVULATION_TEST_RESULT", "PLATFORM_TO_SDK_RECORDING_METHOD", "getPLATFORM_TO_SDK_RECORDING_METHOD", "PLATFORM_TO_SDK_SEXUAL_ACTIVITY_PROTECTION_USED", "getPLATFORM_TO_SDK_SEXUAL_ACTIVITY_PROTECTION_USED", "PLATFORM_TO_SDK_SKIN_TEMPERATURE_MEASUREMENT_LOCATION", "getPLATFORM_TO_SDK_SKIN_TEMPERATURE_MEASUREMENT_LOCATION", "PLATFORM_TO_SDK_SLEEP_STAGE_TYPE", "getPLATFORM_TO_SDK_SLEEP_STAGE_TYPE", "PLATFORM_TO_SDK_VO2_MAX_MEASUREMENT_METHOD", "getPLATFORM_TO_SDK_VO2_MAX_MEASUREMENT_METHOD", "SDK_TO_PLATFORM_BLOOD_GLUCOSE_RELATION_TO_MEAL", "getSDK_TO_PLATFORM_BLOOD_GLUCOSE_RELATION_TO_MEAL", "SDK_TO_PLATFORM_BLOOD_GLUCOSE_SPECIMEN_SOURCE", "getSDK_TO_PLATFORM_BLOOD_GLUCOSE_SPECIMEN_SOURCE", "SDK_TO_PLATFORM_BLOOD_PRESSURE_BODY_POSITION", "getSDK_TO_PLATFORM_BLOOD_PRESSURE_BODY_POSITION", "SDK_TO_PLATFORM_BLOOD_PRESSURE_MEASUREMENT_LOCATION", "getSDK_TO_PLATFORM_BLOOD_PRESSURE_MEASUREMENT_LOCATION", "SDK_TO_PLATFORM_BODY_TEMPERATURE_MEASUREMENT_LOCATION", "getSDK_TO_PLATFORM_BODY_TEMPERATURE_MEASUREMENT_LOCATION", "SDK_TO_PLATFORM_CERVICAL_MUCUS_APPEARANCE", "getSDK_TO_PLATFORM_CERVICAL_MUCUS_APPEARANCE", "SDK_TO_PLATFORM_CERVICAL_MUCUS_SENSATION", "getSDK_TO_PLATFORM_CERVICAL_MUCUS_SENSATION", "SDK_TO_PLATFORM_EXERCISE_CATEGORY", "getSDK_TO_PLATFORM_EXERCISE_CATEGORY", "SDK_TO_PLATFORM_EXERCISE_SEGMENT_TYPE", "getSDK_TO_PLATFORM_EXERCISE_SEGMENT_TYPE", "SDK_TO_PLATFORM_EXERCISE_SESSION_TYPE", "getSDK_TO_PLATFORM_EXERCISE_SESSION_TYPE", "SDK_TO_PLATFORM_MEAL_TYPE", "getSDK_TO_PLATFORM_MEAL_TYPE", "SDK_TO_PLATFORM_MENSTRUATION_FLOW_TYPE", "getSDK_TO_PLATFORM_MENSTRUATION_FLOW_TYPE", "SDK_TO_PLATFORM_OVULATION_TEST_RESULT", "getSDK_TO_PLATFORM_OVULATION_TEST_RESULT", "SDK_TO_PLATFORM_RECORDING_METHOD", "getSDK_TO_PLATFORM_RECORDING_METHOD", "SDK_TO_PLATFORM_SEXUAL_ACTIVITY_PROTECTION_USED", "getSDK_TO_PLATFORM_SEXUAL_ACTIVITY_PROTECTION_USED", "SDK_TO_PLATFORM_SKIN_TEMPERATURE_MEASUREMENT_LOCATION", "getSDK_TO_PLATFORM_SKIN_TEMPERATURE_MEASUREMENT_LOCATION", "SDK_TO_PLATFORM_SLEEP_STAGE_TYPE", "getSDK_TO_PLATFORM_SLEEP_STAGE_TYPE", "SDK_TO_PLATFORM_VO2_MAX_MEASUREMENT_METHOD", "getSDK_TO_PLATFORM_VO2_MAX_MEASUREMENT_METHOD", "reversed", "toPlatformBloodGlucoseRelationToMeal", "toPlatformBloodGlucoseSpecimenSource", "toPlatformBloodPressureBodyPosition", "toPlatformBloodPressureMeasurementLocation", "toPlatformBodyTemperatureMeasurementLocation", "toPlatformCervicalMucusAppearance", "toPlatformCervicalMucusSensation", "toPlatformExerciseCategory", "toPlatformExerciseSegmentType", "toPlatformExerciseSessionType", "toPlatformMealType", "toPlatformMenstruationFlow", "toPlatformOvulationTestResult", "toPlatformRecordingMethod", "toPlatformSexualActivityProtectionUsed", "toPlatformSkinTemperatureMeasurementLocation", "toPlatformSleepStageType", "toPlatformVo2MaxMeasurementMethod", "toSdkBloodGlucoseSpecimenSource", "toSdkBloodPressureBodyPosition", "toSdkBloodPressureMeasurementLocation", "toSdkBodyTemperatureMeasurementLocation", "toSdkCervicalMucusAppearance", "toSdkCervicalMucusSensation", "toSdkExerciseCategory", "toSdkExerciseSegmentType", "toSdkExerciseSessionType", "toSdkMealType", "toSdkMenstruationFlow", "toSdkOvulationTestResult", "toSdkProtectionUsed", "toSdkRecordingMethod", "toSdkRelationToMeal", "toSdkSkinTemperatureMeasurementLocation", "toSdkSleepStageType", "toSdkVo2MaxMeasurementMethod", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class IntDefMappingsKt {
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_CERVICAL_MUCUS_APPEARANCE = MapsKt.mapOf(TuplesKt.m294to(5, 5), TuplesKt.m294to(1, 1), TuplesKt.m294to(2, 2), TuplesKt.m294to(3, 3), TuplesKt.m294to(4, 4), TuplesKt.m294to(6, 6));
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_CERVICAL_MUCUS_APPEARANCE = reversed(SDK_TO_PLATFORM_CERVICAL_MUCUS_APPEARANCE);
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_BLOOD_PRESSURE_BODY_POSITION = MapsKt.mapOf(TuplesKt.m294to(1, 1), TuplesKt.m294to(2, 2), TuplesKt.m294to(3, 3), TuplesKt.m294to(4, 4));
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_BLOOD_PRESSURE_BODY_POSITION = reversed(SDK_TO_PLATFORM_BLOOD_PRESSURE_BODY_POSITION);
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_EXERCISE_SESSION_TYPE = MapsKt.mapOf(TuplesKt.m294to(0, 58), TuplesKt.m294to(2, 1), TuplesKt.m294to(4, 2), TuplesKt.m294to(5, 3), TuplesKt.m294to(8, 4), TuplesKt.m294to(9, 5), TuplesKt.m294to(10, 6), TuplesKt.m294to(11, 7), TuplesKt.m294to(13, 8), TuplesKt.m294to(14, 9), TuplesKt.m294to(16, 10), TuplesKt.m294to(25, 60), TuplesKt.m294to(26, 11), TuplesKt.m294to(27, 12), TuplesKt.m294to(28, 13), TuplesKt.m294to(29, 14), TuplesKt.m294to(31, 15), TuplesKt.m294to(32, 16), TuplesKt.m294to(33, 17), TuplesKt.m294to(34, 18), TuplesKt.m294to(35, 19), TuplesKt.m294to(36, 20), TuplesKt.m294to(37, 21), TuplesKt.m294to(38, 22), TuplesKt.m294to(39, 23), TuplesKt.m294to(44, 24), TuplesKt.m294to(46, 25), TuplesKt.m294to(47, 26), TuplesKt.m294to(48, 27), TuplesKt.m294to(50, 28), TuplesKt.m294to(51, 29), TuplesKt.m294to(52, 30), TuplesKt.m294to(53, 31), TuplesKt.m294to(54, 61), TuplesKt.m294to(55, 32), TuplesKt.m294to(56, 33), TuplesKt.m294to(57, 34), TuplesKt.m294to(58, 35), TuplesKt.m294to(59, 36), TuplesKt.m294to(60, 37), TuplesKt.m294to(61, 38), TuplesKt.m294to(62, 39), TuplesKt.m294to(63, 40), TuplesKt.m294to(64, 41), TuplesKt.m294to(65, 42), TuplesKt.m294to(66, 43), TuplesKt.m294to(68, 44), TuplesKt.m294to(69, 59), TuplesKt.m294to(70, 45), TuplesKt.m294to(71, 46), TuplesKt.m294to(72, 47), TuplesKt.m294to(73, 48), TuplesKt.m294to(74, 49), TuplesKt.m294to(75, 50), TuplesKt.m294to(76, 51), TuplesKt.m294to(78, 52), TuplesKt.m294to(79, 53), TuplesKt.m294to(80, 54), TuplesKt.m294to(81, 55), TuplesKt.m294to(82, 56), TuplesKt.m294to(83, 57));
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_EXERCISE_SESSION_TYPE = reversed(SDK_TO_PLATFORM_EXERCISE_SESSION_TYPE);
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_MEAL_TYPE = MapsKt.mapOf(TuplesKt.m294to(1, 1), TuplesKt.m294to(2, 2), TuplesKt.m294to(3, 3), TuplesKt.m294to(4, 4));
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_MEAL_TYPE = reversed(SDK_TO_PLATFORM_MEAL_TYPE);
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_VO2_MAX_MEASUREMENT_METHOD = MapsKt.mapOf(TuplesKt.m294to(1, 1), TuplesKt.m294to(2, 2), TuplesKt.m294to(3, 3), TuplesKt.m294to(4, 4), TuplesKt.m294to(5, 5));
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_VO2_MAX_MEASUREMENT_METHOD = reversed(SDK_TO_PLATFORM_VO2_MAX_MEASUREMENT_METHOD);
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_MENSTRUATION_FLOW_TYPE = MapsKt.mapOf(TuplesKt.m294to(1, 1), TuplesKt.m294to(2, 2), TuplesKt.m294to(3, 3));
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_MENSTRUATION_FLOW_TYPE = reversed(SDK_TO_PLATFORM_MENSTRUATION_FLOW_TYPE);
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_BODY_TEMPERATURE_MEASUREMENT_LOCATION = MapsKt.mapOf(TuplesKt.m294to(1, 1), TuplesKt.m294to(2, 2), TuplesKt.m294to(3, 3), TuplesKt.m294to(4, 4), TuplesKt.m294to(5, 5), TuplesKt.m294to(6, 6), TuplesKt.m294to(7, 7), TuplesKt.m294to(8, 8), TuplesKt.m294to(9, 9), TuplesKt.m294to(10, 10));
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_BODY_TEMPERATURE_MEASUREMENT_LOCATION = reversed(SDK_TO_PLATFORM_BODY_TEMPERATURE_MEASUREMENT_LOCATION);
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_BLOOD_PRESSURE_MEASUREMENT_LOCATION = MapsKt.mapOf(TuplesKt.m294to(1, 1), TuplesKt.m294to(2, 2), TuplesKt.m294to(3, 3), TuplesKt.m294to(4, 4));
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_BLOOD_PRESSURE_MEASUREMENT_LOCATION = reversed(SDK_TO_PLATFORM_BLOOD_PRESSURE_MEASUREMENT_LOCATION);
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_OVULATION_TEST_RESULT = MapsKt.mapOf(TuplesKt.m294to(1, 1), TuplesKt.m294to(2, 2), TuplesKt.m294to(3, 3), TuplesKt.m294to(0, 0));
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_OVULATION_TEST_RESULT = reversed(SDK_TO_PLATFORM_OVULATION_TEST_RESULT);
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_CERVICAL_MUCUS_SENSATION = MapsKt.mapOf(TuplesKt.m294to(1, 1), TuplesKt.m294to(2, 2), TuplesKt.m294to(3, 3));
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_CERVICAL_MUCUS_SENSATION = reversed(SDK_TO_PLATFORM_CERVICAL_MUCUS_SENSATION);
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_SEXUAL_ACTIVITY_PROTECTION_USED = MapsKt.mapOf(TuplesKt.m294to(1, 1), TuplesKt.m294to(2, 2));
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_SEXUAL_ACTIVITY_PROTECTION_USED = reversed(SDK_TO_PLATFORM_SEXUAL_ACTIVITY_PROTECTION_USED);
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_SKIN_TEMPERATURE_MEASUREMENT_LOCATION = MapsKt.mapOf(TuplesKt.m294to(1, 1), TuplesKt.m294to(2, 2), TuplesKt.m294to(3, 3));
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_SKIN_TEMPERATURE_MEASUREMENT_LOCATION = reversed(SDK_TO_PLATFORM_SKIN_TEMPERATURE_MEASUREMENT_LOCATION);
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_BLOOD_GLUCOSE_SPECIMEN_SOURCE = MapsKt.mapOf(TuplesKt.m294to(1, 1), TuplesKt.m294to(2, 2), TuplesKt.m294to(3, 3), TuplesKt.m294to(4, 4), TuplesKt.m294to(5, 5), TuplesKt.m294to(6, 6));
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_GLUCOSE_SPECIMEN_SOURCE = reversed(SDK_TO_PLATFORM_BLOOD_GLUCOSE_SPECIMEN_SOURCE);
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_BLOOD_GLUCOSE_RELATION_TO_MEAL = MapsKt.mapOf(TuplesKt.m294to(1, 1), TuplesKt.m294to(2, 2), TuplesKt.m294to(3, 3), TuplesKt.m294to(4, 4));
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_BLOOD_GLUCOSE_RELATION_TO_MEAL = reversed(SDK_TO_PLATFORM_BLOOD_GLUCOSE_RELATION_TO_MEAL);
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_EXERCISE_CATEGORY = MapsKt.mapOf(TuplesKt.m294to(0, 0), TuplesKt.m294to(1, 1), TuplesKt.m294to(2, 2), TuplesKt.m294to(3, 3), TuplesKt.m294to(4, 4), TuplesKt.m294to(5, 5));
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_EXERCISE_CATEGORY = reversed(SDK_TO_PLATFORM_EXERCISE_CATEGORY);
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_SLEEP_STAGE_TYPE = MapsKt.mapOf(TuplesKt.m294to(1, 1), TuplesKt.m294to(2, 2), TuplesKt.m294to(3, 3), TuplesKt.m294to(4, 4), TuplesKt.m294to(5, 5), TuplesKt.m294to(6, 6), TuplesKt.m294to(7, 7));
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_SLEEP_STAGE_TYPE = reversed(SDK_TO_PLATFORM_SLEEP_STAGE_TYPE);
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_EXERCISE_SEGMENT_TYPE = MapsKt.mapOf(TuplesKt.m294to(1, 26), TuplesKt.m294to(2, 27), TuplesKt.m294to(3, 28), TuplesKt.m294to(4, 1), TuplesKt.m294to(5, 29), TuplesKt.m294to(6, 2), TuplesKt.m294to(7, 3), TuplesKt.m294to(8, 4), TuplesKt.m294to(9, 30), TuplesKt.m294to(10, 31), TuplesKt.m294to(11, 32), TuplesKt.m294to(12, 33), TuplesKt.m294to(13, 5), TuplesKt.m294to(14, 6), TuplesKt.m294to(15, 7), TuplesKt.m294to(16, 8), TuplesKt.m294to(17, 34), TuplesKt.m294to(18, 9), TuplesKt.m294to(19, 10), TuplesKt.m294to(20, 11), TuplesKt.m294to(21, 12), TuplesKt.m294to(22, 13), TuplesKt.m294to(23, 35), TuplesKt.m294to(24, 62), TuplesKt.m294to(25, 36), TuplesKt.m294to(26, 37), TuplesKt.m294to(27, 38), TuplesKt.m294to(28, 39), TuplesKt.m294to(29, 40), TuplesKt.m294to(30, 41), TuplesKt.m294to(31, 42), TuplesKt.m294to(32, 43), TuplesKt.m294to(33, 44), TuplesKt.m294to(34, 45), TuplesKt.m294to(35, 46), TuplesKt.m294to(36, 47), TuplesKt.m294to(37, 48), TuplesKt.m294to(38, 64), TuplesKt.m294to(39, 67), TuplesKt.m294to(40, 14), TuplesKt.m294to(41, 49), TuplesKt.m294to(42, 50), TuplesKt.m294to(43, 51), TuplesKt.m294to(44, 66), TuplesKt.m294to(45, 15), TuplesKt.m294to(46, 16), TuplesKt.m294to(47, 17), TuplesKt.m294to(48, 52), TuplesKt.m294to(49, 53), TuplesKt.m294to(50, 54), TuplesKt.m294to(51, 55), TuplesKt.m294to(52, 18), TuplesKt.m294to(53, 19), TuplesKt.m294to(54, 20), TuplesKt.m294to(55, 57), TuplesKt.m294to(56, 58), TuplesKt.m294to(57, 59), TuplesKt.m294to(58, 56), TuplesKt.m294to(59, 60), TuplesKt.m294to(60, 21), TuplesKt.m294to(61, 61), TuplesKt.m294to(62, 22), TuplesKt.m294to(63, 23), TuplesKt.m294to(64, 24), TuplesKt.m294to(65, 63), TuplesKt.m294to(66, 25), TuplesKt.m294to(67, 65));
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_EXERCISE_SEGMENT_TYPE = reversed(SDK_TO_PLATFORM_EXERCISE_SEGMENT_TYPE);
    private static final Map<Integer, Integer> SDK_TO_PLATFORM_RECORDING_METHOD = MapsKt.mapOf(TuplesKt.m294to(1, 1), TuplesKt.m294to(2, 2), TuplesKt.m294to(3, 3));
    private static final Map<Integer, Integer> PLATFORM_TO_SDK_RECORDING_METHOD = reversed(SDK_TO_PLATFORM_RECORDING_METHOD);

    public static final Map<Integer, Integer> getSDK_TO_PLATFORM_CERVICAL_MUCUS_APPEARANCE() {
        return SDK_TO_PLATFORM_CERVICAL_MUCUS_APPEARANCE;
    }

    public static final Map<Integer, Integer> getPLATFORM_TO_SDK_CERVICAL_MUCUS_APPEARANCE() {
        return PLATFORM_TO_SDK_CERVICAL_MUCUS_APPEARANCE;
    }

    public static final Map<Integer, Integer> getSDK_TO_PLATFORM_BLOOD_PRESSURE_BODY_POSITION() {
        return SDK_TO_PLATFORM_BLOOD_PRESSURE_BODY_POSITION;
    }

    public static final Map<Integer, Integer> getPLATFORM_TO_SDK_BLOOD_PRESSURE_BODY_POSITION() {
        return PLATFORM_TO_SDK_BLOOD_PRESSURE_BODY_POSITION;
    }

    public static final Map<Integer, Integer> getSDK_TO_PLATFORM_EXERCISE_SESSION_TYPE() {
        return SDK_TO_PLATFORM_EXERCISE_SESSION_TYPE;
    }

    public static final Map<Integer, Integer> getPLATFORM_TO_SDK_EXERCISE_SESSION_TYPE() {
        return PLATFORM_TO_SDK_EXERCISE_SESSION_TYPE;
    }

    public static final Map<Integer, Integer> getSDK_TO_PLATFORM_MEAL_TYPE() {
        return SDK_TO_PLATFORM_MEAL_TYPE;
    }

    public static final Map<Integer, Integer> getPLATFORM_TO_SDK_MEAL_TYPE() {
        return PLATFORM_TO_SDK_MEAL_TYPE;
    }

    public static final Map<Integer, Integer> getSDK_TO_PLATFORM_VO2_MAX_MEASUREMENT_METHOD() {
        return SDK_TO_PLATFORM_VO2_MAX_MEASUREMENT_METHOD;
    }

    public static final Map<Integer, Integer> getPLATFORM_TO_SDK_VO2_MAX_MEASUREMENT_METHOD() {
        return PLATFORM_TO_SDK_VO2_MAX_MEASUREMENT_METHOD;
    }

    public static final Map<Integer, Integer> getSDK_TO_PLATFORM_MENSTRUATION_FLOW_TYPE() {
        return SDK_TO_PLATFORM_MENSTRUATION_FLOW_TYPE;
    }

    public static final Map<Integer, Integer> getPLATFORM_TO_SDK_MENSTRUATION_FLOW_TYPE() {
        return PLATFORM_TO_SDK_MENSTRUATION_FLOW_TYPE;
    }

    public static final Map<Integer, Integer> getSDK_TO_PLATFORM_BODY_TEMPERATURE_MEASUREMENT_LOCATION() {
        return SDK_TO_PLATFORM_BODY_TEMPERATURE_MEASUREMENT_LOCATION;
    }

    public static final Map<Integer, Integer> getPLATFORM_TO_SDK_BODY_TEMPERATURE_MEASUREMENT_LOCATION() {
        return PLATFORM_TO_SDK_BODY_TEMPERATURE_MEASUREMENT_LOCATION;
    }

    public static final Map<Integer, Integer> getSDK_TO_PLATFORM_BLOOD_PRESSURE_MEASUREMENT_LOCATION() {
        return SDK_TO_PLATFORM_BLOOD_PRESSURE_MEASUREMENT_LOCATION;
    }

    public static final Map<Integer, Integer> getPLATFORM_TO_SDK_BLOOD_PRESSURE_MEASUREMENT_LOCATION() {
        return PLATFORM_TO_SDK_BLOOD_PRESSURE_MEASUREMENT_LOCATION;
    }

    public static final Map<Integer, Integer> getSDK_TO_PLATFORM_OVULATION_TEST_RESULT() {
        return SDK_TO_PLATFORM_OVULATION_TEST_RESULT;
    }

    public static final Map<Integer, Integer> getPLATFORM_TO_SDK_OVULATION_TEST_RESULT() {
        return PLATFORM_TO_SDK_OVULATION_TEST_RESULT;
    }

    public static final Map<Integer, Integer> getSDK_TO_PLATFORM_CERVICAL_MUCUS_SENSATION() {
        return SDK_TO_PLATFORM_CERVICAL_MUCUS_SENSATION;
    }

    public static final Map<Integer, Integer> getPLATFORM_TO_SDK_CERVICAL_MUCUS_SENSATION() {
        return PLATFORM_TO_SDK_CERVICAL_MUCUS_SENSATION;
    }

    public static final Map<Integer, Integer> getSDK_TO_PLATFORM_SEXUAL_ACTIVITY_PROTECTION_USED() {
        return SDK_TO_PLATFORM_SEXUAL_ACTIVITY_PROTECTION_USED;
    }

    public static final Map<Integer, Integer> getPLATFORM_TO_SDK_SEXUAL_ACTIVITY_PROTECTION_USED() {
        return PLATFORM_TO_SDK_SEXUAL_ACTIVITY_PROTECTION_USED;
    }

    public static final Map<Integer, Integer> getSDK_TO_PLATFORM_SKIN_TEMPERATURE_MEASUREMENT_LOCATION() {
        return SDK_TO_PLATFORM_SKIN_TEMPERATURE_MEASUREMENT_LOCATION;
    }

    public static final Map<Integer, Integer> getPLATFORM_TO_SDK_SKIN_TEMPERATURE_MEASUREMENT_LOCATION() {
        return PLATFORM_TO_SDK_SKIN_TEMPERATURE_MEASUREMENT_LOCATION;
    }

    public static final Map<Integer, Integer> getSDK_TO_PLATFORM_BLOOD_GLUCOSE_SPECIMEN_SOURCE() {
        return SDK_TO_PLATFORM_BLOOD_GLUCOSE_SPECIMEN_SOURCE;
    }

    public static final Map<Integer, Integer> getPLATFORM_TO_SDK_GLUCOSE_SPECIMEN_SOURCE() {
        return PLATFORM_TO_SDK_GLUCOSE_SPECIMEN_SOURCE;
    }

    public static final Map<Integer, Integer> getSDK_TO_PLATFORM_BLOOD_GLUCOSE_RELATION_TO_MEAL() {
        return SDK_TO_PLATFORM_BLOOD_GLUCOSE_RELATION_TO_MEAL;
    }

    public static final Map<Integer, Integer> getPLATFORM_TO_SDK_BLOOD_GLUCOSE_RELATION_TO_MEAL() {
        return PLATFORM_TO_SDK_BLOOD_GLUCOSE_RELATION_TO_MEAL;
    }

    public static final Map<Integer, Integer> getSDK_TO_PLATFORM_EXERCISE_CATEGORY() {
        return SDK_TO_PLATFORM_EXERCISE_CATEGORY;
    }

    public static final Map<Integer, Integer> getPLATFORM_TO_SDK_EXERCISE_CATEGORY() {
        return PLATFORM_TO_SDK_EXERCISE_CATEGORY;
    }

    public static final Map<Integer, Integer> getSDK_TO_PLATFORM_SLEEP_STAGE_TYPE() {
        return SDK_TO_PLATFORM_SLEEP_STAGE_TYPE;
    }

    public static final Map<Integer, Integer> getPLATFORM_TO_SDK_SLEEP_STAGE_TYPE() {
        return PLATFORM_TO_SDK_SLEEP_STAGE_TYPE;
    }

    public static final Map<Integer, Integer> getSDK_TO_PLATFORM_EXERCISE_SEGMENT_TYPE() {
        return SDK_TO_PLATFORM_EXERCISE_SEGMENT_TYPE;
    }

    public static final Map<Integer, Integer> getPLATFORM_TO_SDK_EXERCISE_SEGMENT_TYPE() {
        return PLATFORM_TO_SDK_EXERCISE_SEGMENT_TYPE;
    }

    public static final Map<Integer, Integer> getSDK_TO_PLATFORM_RECORDING_METHOD() {
        return SDK_TO_PLATFORM_RECORDING_METHOD;
    }

    public static final int toPlatformExerciseCategory(int $this$toPlatformExerciseCategory) {
        Integer num = SDK_TO_PLATFORM_BLOOD_GLUCOSE_SPECIMEN_SOURCE.get(Integer.valueOf($this$toPlatformExerciseCategory));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final Map<Integer, Integer> getPLATFORM_TO_SDK_RECORDING_METHOD() {
        return PLATFORM_TO_SDK_RECORDING_METHOD;
    }

    public static final int toPlatformCervicalMucusAppearance(int $this$toPlatformCervicalMucusAppearance) {
        Integer num = SDK_TO_PLATFORM_CERVICAL_MUCUS_APPEARANCE.get(Integer.valueOf($this$toPlatformCervicalMucusAppearance));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformBloodPressureBodyPosition(int $this$toPlatformBloodPressureBodyPosition) {
        Integer num = SDK_TO_PLATFORM_BLOOD_PRESSURE_BODY_POSITION.get(Integer.valueOf($this$toPlatformBloodPressureBodyPosition));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformExerciseSessionType(int $this$toPlatformExerciseSessionType) {
        Integer num = SDK_TO_PLATFORM_EXERCISE_SESSION_TYPE.get(Integer.valueOf($this$toPlatformExerciseSessionType));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformExerciseSegmentType(int $this$toPlatformExerciseSegmentType) {
        Integer num = SDK_TO_PLATFORM_EXERCISE_SEGMENT_TYPE.get(Integer.valueOf($this$toPlatformExerciseSegmentType));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformMealType(int $this$toPlatformMealType) {
        Integer num = SDK_TO_PLATFORM_MEAL_TYPE.get(Integer.valueOf($this$toPlatformMealType));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformVo2MaxMeasurementMethod(int $this$toPlatformVo2MaxMeasurementMethod) {
        Integer num = SDK_TO_PLATFORM_VO2_MAX_MEASUREMENT_METHOD.get(Integer.valueOf($this$toPlatformVo2MaxMeasurementMethod));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformMenstruationFlow(int $this$toPlatformMenstruationFlow) {
        Integer num = SDK_TO_PLATFORM_MENSTRUATION_FLOW_TYPE.get(Integer.valueOf($this$toPlatformMenstruationFlow));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformBodyTemperatureMeasurementLocation(int $this$toPlatformBodyTemperatureMeasurementLocation) {
        Integer num = SDK_TO_PLATFORM_BODY_TEMPERATURE_MEASUREMENT_LOCATION.get(Integer.valueOf($this$toPlatformBodyTemperatureMeasurementLocation));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformBloodPressureMeasurementLocation(int $this$toPlatformBloodPressureMeasurementLocation) {
        Integer num = SDK_TO_PLATFORM_BLOOD_PRESSURE_MEASUREMENT_LOCATION.get(Integer.valueOf($this$toPlatformBloodPressureMeasurementLocation));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformOvulationTestResult(int $this$toPlatformOvulationTestResult) {
        Integer num = SDK_TO_PLATFORM_OVULATION_TEST_RESULT.get(Integer.valueOf($this$toPlatformOvulationTestResult));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformCervicalMucusSensation(int $this$toPlatformCervicalMucusSensation) {
        Integer num = SDK_TO_PLATFORM_CERVICAL_MUCUS_SENSATION.get(Integer.valueOf($this$toPlatformCervicalMucusSensation));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformSexualActivityProtectionUsed(int $this$toPlatformSexualActivityProtectionUsed) {
        Integer num = SDK_TO_PLATFORM_SEXUAL_ACTIVITY_PROTECTION_USED.get(Integer.valueOf($this$toPlatformSexualActivityProtectionUsed));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformSkinTemperatureMeasurementLocation(int $this$toPlatformSkinTemperatureMeasurementLocation) {
        Integer num = SDK_TO_PLATFORM_SKIN_TEMPERATURE_MEASUREMENT_LOCATION.get(Integer.valueOf($this$toPlatformSkinTemperatureMeasurementLocation));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformBloodGlucoseSpecimenSource(int $this$toPlatformBloodGlucoseSpecimenSource) {
        Integer num = SDK_TO_PLATFORM_BLOOD_GLUCOSE_SPECIMEN_SOURCE.get(Integer.valueOf($this$toPlatformBloodGlucoseSpecimenSource));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformBloodGlucoseRelationToMeal(int $this$toPlatformBloodGlucoseRelationToMeal) {
        Integer num = SDK_TO_PLATFORM_BLOOD_GLUCOSE_RELATION_TO_MEAL.get(Integer.valueOf($this$toPlatformBloodGlucoseRelationToMeal));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformSleepStageType(int $this$toPlatformSleepStageType) {
        Integer num = SDK_TO_PLATFORM_SLEEP_STAGE_TYPE.get(Integer.valueOf($this$toPlatformSleepStageType));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toPlatformRecordingMethod(int $this$toPlatformRecordingMethod) {
        Integer num = SDK_TO_PLATFORM_RECORDING_METHOD.get(Integer.valueOf($this$toPlatformRecordingMethod));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkBloodPressureBodyPosition(int $this$toSdkBloodPressureBodyPosition) {
        Integer num = PLATFORM_TO_SDK_BLOOD_PRESSURE_BODY_POSITION.get(Integer.valueOf($this$toSdkBloodPressureBodyPosition));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkBloodPressureMeasurementLocation(int $this$toSdkBloodPressureMeasurementLocation) {
        Integer num = PLATFORM_TO_SDK_BLOOD_PRESSURE_MEASUREMENT_LOCATION.get(Integer.valueOf($this$toSdkBloodPressureMeasurementLocation));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkExerciseSessionType(int $this$toSdkExerciseSessionType) {
        Integer num = PLATFORM_TO_SDK_EXERCISE_SESSION_TYPE.get(Integer.valueOf($this$toSdkExerciseSessionType));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkExerciseSegmentType(int $this$toSdkExerciseSegmentType) {
        Integer num = PLATFORM_TO_SDK_EXERCISE_SEGMENT_TYPE.get(Integer.valueOf($this$toSdkExerciseSegmentType));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkExerciseCategory(int $this$toSdkExerciseCategory) {
        Integer num = PLATFORM_TO_SDK_EXERCISE_CATEGORY.get(Integer.valueOf($this$toSdkExerciseCategory));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkVo2MaxMeasurementMethod(int $this$toSdkVo2MaxMeasurementMethod) {
        Integer num = PLATFORM_TO_SDK_VO2_MAX_MEASUREMENT_METHOD.get(Integer.valueOf($this$toSdkVo2MaxMeasurementMethod));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkMenstruationFlow(int $this$toSdkMenstruationFlow) {
        Integer num = PLATFORM_TO_SDK_MENSTRUATION_FLOW_TYPE.get(Integer.valueOf($this$toSdkMenstruationFlow));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkProtectionUsed(int $this$toSdkProtectionUsed) {
        Integer num = PLATFORM_TO_SDK_SEXUAL_ACTIVITY_PROTECTION_USED.get(Integer.valueOf($this$toSdkProtectionUsed));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkCervicalMucusSensation(int $this$toSdkCervicalMucusSensation) {
        Integer num = PLATFORM_TO_SDK_CERVICAL_MUCUS_SENSATION.get(Integer.valueOf($this$toSdkCervicalMucusSensation));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkBloodGlucoseSpecimenSource(int $this$toSdkBloodGlucoseSpecimenSource) {
        Integer num = PLATFORM_TO_SDK_GLUCOSE_SPECIMEN_SOURCE.get(Integer.valueOf($this$toSdkBloodGlucoseSpecimenSource));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkMealType(int $this$toSdkMealType) {
        Integer num = PLATFORM_TO_SDK_MEAL_TYPE.get(Integer.valueOf($this$toSdkMealType));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkOvulationTestResult(int $this$toSdkOvulationTestResult) {
        Integer num = PLATFORM_TO_SDK_OVULATION_TEST_RESULT.get(Integer.valueOf($this$toSdkOvulationTestResult));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkRelationToMeal(int $this$toSdkRelationToMeal) {
        Integer num = PLATFORM_TO_SDK_BLOOD_GLUCOSE_RELATION_TO_MEAL.get(Integer.valueOf($this$toSdkRelationToMeal));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkBodyTemperatureMeasurementLocation(int $this$toSdkBodyTemperatureMeasurementLocation) {
        Integer num = PLATFORM_TO_SDK_BODY_TEMPERATURE_MEASUREMENT_LOCATION.get(Integer.valueOf($this$toSdkBodyTemperatureMeasurementLocation));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkCervicalMucusAppearance(int $this$toSdkCervicalMucusAppearance) {
        Integer num = PLATFORM_TO_SDK_CERVICAL_MUCUS_APPEARANCE.get(Integer.valueOf($this$toSdkCervicalMucusAppearance));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkSleepStageType(int $this$toSdkSleepStageType) {
        Integer num = PLATFORM_TO_SDK_SLEEP_STAGE_TYPE.get(Integer.valueOf($this$toSdkSleepStageType));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkSkinTemperatureMeasurementLocation(int $this$toSdkSkinTemperatureMeasurementLocation) {
        Integer num = PLATFORM_TO_SDK_SKIN_TEMPERATURE_MEASUREMENT_LOCATION.get(Integer.valueOf($this$toSdkSkinTemperatureMeasurementLocation));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int toSdkRecordingMethod(int $this$toSdkRecordingMethod) {
        Integer num = PLATFORM_TO_SDK_RECORDING_METHOD.get(Integer.valueOf($this$toSdkRecordingMethod));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    private static final Map<Integer, Integer> reversed(Map<Integer, Integer> map) {
        Iterable $this$associate$iv = map.entrySet();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            Map.Entry entry = (Map.Entry) element$iv$iv;
            int k = ((Number) entry.getKey()).intValue();
            int v = ((Number) entry.getValue()).intValue();
            Pair m294to = TuplesKt.m294to(Integer.valueOf(v), Integer.valueOf(k));
            destination$iv$iv.put(m294to.getFirst(), m294to.getSecond());
        }
        return destination$iv$iv;
    }
}
