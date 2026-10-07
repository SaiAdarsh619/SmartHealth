package androidx.health.connect.client.impl.converters.records;

import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import androidx.health.connect.client.records.ActiveCaloriesBurnedRecord;
import androidx.health.connect.client.records.BasalBodyTemperatureRecord;
import androidx.health.connect.client.records.BasalMetabolicRateRecord;
import androidx.health.connect.client.records.BloodGlucoseRecord;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.records.BodyFatRecord;
import androidx.health.connect.client.records.BodyTemperatureMeasurementLocation;
import androidx.health.connect.client.records.BodyTemperatureRecord;
import androidx.health.connect.client.records.BodyWaterMassRecord;
import androidx.health.connect.client.records.BoneMassRecord;
import androidx.health.connect.client.records.CervicalMucusRecord;
import androidx.health.connect.client.records.CyclingPedalingCadenceRecord;
import androidx.health.connect.client.records.DistanceRecord;
import androidx.health.connect.client.records.ElevationGainedRecord;
import androidx.health.connect.client.records.ExerciseLap;
import androidx.health.connect.client.records.ExerciseRoute;
import androidx.health.connect.client.records.ExerciseRouteResult;
import androidx.health.connect.client.records.ExerciseSegment;
import androidx.health.connect.client.records.ExerciseSessionRecord;
import androidx.health.connect.client.records.FloorsClimbedRecord;
import androidx.health.connect.client.records.HeartRateRecord;
import androidx.health.connect.client.records.HeartRateVariabilityRmssdRecord;
import androidx.health.connect.client.records.HeightRecord;
import androidx.health.connect.client.records.HydrationRecord;
import androidx.health.connect.client.records.InstantaneousRecord;
import androidx.health.connect.client.records.IntermenstrualBleedingRecord;
import androidx.health.connect.client.records.IntervalRecord;
import androidx.health.connect.client.records.LeanBodyMassRecord;
import androidx.health.connect.client.records.MealType;
import androidx.health.connect.client.records.MenstruationFlowRecord;
import androidx.health.connect.client.records.MenstruationPeriodRecord;
import androidx.health.connect.client.records.NutritionRecord;
import androidx.health.connect.client.records.OvulationTestRecord;
import androidx.health.connect.client.records.OxygenSaturationRecord;
import androidx.health.connect.client.records.PowerRecord;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.RespiratoryRateRecord;
import androidx.health.connect.client.records.RestingHeartRateRecord;
import androidx.health.connect.client.records.SeriesRecord;
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
import androidx.health.platform.client.proto.DataProto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecordToProtoConverters.kt */
@Metadata(m286d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001aG\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tH\u0002¨\u0006\u000e"}, m287d2 = {"toProto", "Landroidx/health/platform/client/proto/DataProto$DataPoint;", "Landroidx/health/connect/client/records/Record;", "T", "", "Landroidx/health/connect/client/records/SeriesRecord;", "dataTypeName", "", "getSeriesValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "sample", "Landroidx/health/platform/client/proto/DataProto$SeriesValue;", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class RecordToProtoConvertersKt {
    public static final DataProto.DataPoint toProto(Record $this$toProto) {
        Intrinsics.checkNotNullParameter($this$toProto, "<this>");
        if ($this$toProto instanceof BasalBodyTemperatureRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u241 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("BasalBodyTemperature"));
            $this$toProto_u24lambda_u241.putValues("temperature", ValueExtKt.doubleVal(((BasalBodyTemperatureRecord) $this$toProto).getTemperature().getCelsius()));
            DataProto.Value it = ValueExtKt.enumValFromInt(((BasalBodyTemperatureRecord) $this$toProto).getMeasurementLocation(), BodyTemperatureMeasurementLocation.MEASUREMENT_LOCATION_INT_TO_STRING_MAP);
            if (it != null) {
                $this$toProto_u24lambda_u241.putValues("measurementLocation", it);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            DataProto.DataPoint build = $this$toProto_u24lambda_u241.build();
            Intrinsics.checkNotNullExpressionValue(build, "instantaneousProto()\n   …\n                .build()");
            return build;
        }
        if ($this$toProto instanceof BasalMetabolicRateRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u242 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("BasalMetabolicRate"));
            $this$toProto_u24lambda_u242.putValues("bmr", ValueExtKt.doubleVal(((BasalMetabolicRateRecord) $this$toProto).getBasalMetabolicRate().getKilocaloriesPerDay()));
            DataProto.DataPoint build2 = $this$toProto_u24lambda_u242.build();
            Intrinsics.checkNotNullExpressionValue(build2, "instantaneousProto()\n   …\n                .build()");
            return build2;
        }
        if ($this$toProto instanceof BloodGlucoseRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u246 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("BloodGlucose"));
            $this$toProto_u24lambda_u246.putValues("level", ValueExtKt.doubleVal(((BloodGlucoseRecord) $this$toProto).getLevel().getMillimolesPerLiter()));
            DataProto.Value it2 = ValueExtKt.enumValFromInt(((BloodGlucoseRecord) $this$toProto).getSpecimenSource(), BloodGlucoseRecord.SPECIMEN_SOURCE_INT_TO_STRING_MAP);
            if (it2 != null) {
                $this$toProto_u24lambda_u246.putValues("specimenSource", it2);
            }
            DataProto.Value it3 = ValueExtKt.enumValFromInt(((BloodGlucoseRecord) $this$toProto).getMealType(), MealType.MEAL_TYPE_INT_TO_STRING_MAP);
            if (it3 != null) {
                $this$toProto_u24lambda_u246.putValues("mealType", it3);
            }
            DataProto.Value it4 = ValueExtKt.enumValFromInt(((BloodGlucoseRecord) $this$toProto).getRelationToMeal(), BloodGlucoseRecord.RELATION_TO_MEAL_INT_TO_STRING_MAP);
            if (it4 != null) {
                $this$toProto_u24lambda_u246.putValues("relationToMeal", it4);
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
            }
            DataProto.DataPoint build3 = $this$toProto_u24lambda_u246.build();
            Intrinsics.checkNotNullExpressionValue(build3, "instantaneousProto()\n   …\n                .build()");
            return build3;
        }
        if ($this$toProto instanceof BloodPressureRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u249 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("BloodPressure"));
            $this$toProto_u24lambda_u249.putValues("systolic", ValueExtKt.doubleVal(((BloodPressureRecord) $this$toProto).getSystolic().getValue()));
            $this$toProto_u24lambda_u249.putValues("diastolic", ValueExtKt.doubleVal(((BloodPressureRecord) $this$toProto).getDiastolic().getValue()));
            DataProto.Value it5 = ValueExtKt.enumValFromInt(((BloodPressureRecord) $this$toProto).getBodyPosition(), BloodPressureRecord.BODY_POSITION_INT_TO_STRING_MAP);
            if (it5 != null) {
                $this$toProto_u24lambda_u249.putValues("bodyPosition", it5);
            }
            DataProto.Value it6 = ValueExtKt.enumValFromInt(((BloodPressureRecord) $this$toProto).getMeasurementLocation(), BloodPressureRecord.MEASUREMENT_LOCATION_INT_TO_STRING_MAP);
            if (it6 != null) {
                $this$toProto_u24lambda_u249.putValues("measurementLocation", it6);
                Unit unit5 = Unit.INSTANCE;
                Unit unit6 = Unit.INSTANCE;
            }
            DataProto.DataPoint build4 = $this$toProto_u24lambda_u249.build();
            Intrinsics.checkNotNullExpressionValue(build4, "instantaneousProto()\n   …\n                .build()");
            return build4;
        }
        if ($this$toProto instanceof BodyFatRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2410 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("BodyFat"));
            $this$toProto_u24lambda_u2410.putValues("percentage", ValueExtKt.doubleVal(((BodyFatRecord) $this$toProto).getPercentage().getValue()));
            DataProto.DataPoint build5 = $this$toProto_u24lambda_u2410.build();
            Intrinsics.checkNotNullExpressionValue(build5, "instantaneousProto()\n   …\n                .build()");
            return build5;
        }
        if ($this$toProto instanceof BodyTemperatureRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2412 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("BodyTemperature"));
            $this$toProto_u24lambda_u2412.putValues("temperature", ValueExtKt.doubleVal(((BodyTemperatureRecord) $this$toProto).getTemperature().getCelsius()));
            DataProto.Value it7 = ValueExtKt.enumValFromInt(((BodyTemperatureRecord) $this$toProto).getMeasurementLocation(), BodyTemperatureMeasurementLocation.MEASUREMENT_LOCATION_INT_TO_STRING_MAP);
            if (it7 != null) {
                $this$toProto_u24lambda_u2412.putValues("measurementLocation", it7);
                Unit unit7 = Unit.INSTANCE;
                Unit unit8 = Unit.INSTANCE;
            }
            DataProto.DataPoint build6 = $this$toProto_u24lambda_u2412.build();
            Intrinsics.checkNotNullExpressionValue(build6, "instantaneousProto()\n   …\n                .build()");
            return build6;
        }
        if ($this$toProto instanceof BodyWaterMassRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2413 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("BodyWaterMass"));
            $this$toProto_u24lambda_u2413.putValues("mass", ValueExtKt.doubleVal(((BodyWaterMassRecord) $this$toProto).getMass().getKilograms()));
            DataProto.DataPoint build7 = $this$toProto_u24lambda_u2413.build();
            Intrinsics.checkNotNullExpressionValue(build7, "instantaneousProto()\n   …\n                .build()");
            return build7;
        }
        if ($this$toProto instanceof BoneMassRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2414 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("BoneMass"));
            $this$toProto_u24lambda_u2414.putValues("mass", ValueExtKt.doubleVal(((BoneMassRecord) $this$toProto).getMass().getKilograms()));
            DataProto.DataPoint build8 = $this$toProto_u24lambda_u2414.build();
            Intrinsics.checkNotNullExpressionValue(build8, "instantaneousProto()\n   …\n                .build()");
            return build8;
        }
        if ($this$toProto instanceof CervicalMucusRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2417 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("CervicalMucus"));
            DataProto.Value it8 = ValueExtKt.enumValFromInt(((CervicalMucusRecord) $this$toProto).getAppearance(), CervicalMucusRecord.APPEARANCE_INT_TO_STRING_MAP);
            if (it8 != null) {
                $this$toProto_u24lambda_u2417.putValues("texture", it8);
            }
            DataProto.Value it9 = ValueExtKt.enumValFromInt(((CervicalMucusRecord) $this$toProto).getSensation(), CervicalMucusRecord.SENSATION_INT_TO_STRING_MAP);
            if (it9 != null) {
                $this$toProto_u24lambda_u2417.putValues("amount", it9);
                Unit unit9 = Unit.INSTANCE;
                Unit unit10 = Unit.INSTANCE;
            }
            DataProto.DataPoint build9 = $this$toProto_u24lambda_u2417.build();
            Intrinsics.checkNotNullExpressionValue(build9, "instantaneousProto()\n   …\n                .build()");
            return build9;
        }
        if ($this$toProto instanceof CyclingPedalingCadenceRecord) {
            return toProto((SeriesRecord) $this$toProto, "CyclingPedalingCadenceSeries", new Function1<CyclingPedalingCadenceRecord.Sample, DataProto.SeriesValue>() { // from class: androidx.health.connect.client.impl.converters.records.RecordToProtoConvertersKt$toProto$10
                @Override // kotlin.jvm.functions.Function1
                public final DataProto.SeriesValue invoke(CyclingPedalingCadenceRecord.Sample sample) {
                    Intrinsics.checkNotNullParameter(sample, "sample");
                    DataProto.SeriesValue build10 = DataProto.SeriesValue.newBuilder().putValues("rpm", ValueExtKt.doubleVal(sample.getRevolutionsPerMinute())).setInstantTimeMillis(sample.getTime().toEpochMilli()).build();
                    Intrinsics.checkNotNullExpressionValue(build10, "newBuilder()\n           …                 .build()");
                    return build10;
                }
            });
        }
        if ($this$toProto instanceof HeartRateRecord) {
            return toProto((SeriesRecord) $this$toProto, "HeartRateSeries", new Function1<HeartRateRecord.Sample, DataProto.SeriesValue>() { // from class: androidx.health.connect.client.impl.converters.records.RecordToProtoConvertersKt$toProto$11
                @Override // kotlin.jvm.functions.Function1
                public final DataProto.SeriesValue invoke(HeartRateRecord.Sample sample) {
                    Intrinsics.checkNotNullParameter(sample, "sample");
                    DataProto.SeriesValue build10 = DataProto.SeriesValue.newBuilder().putValues("bpm", ValueExtKt.longVal(sample.getBeatsPerMinute())).setInstantTimeMillis(sample.getTime().toEpochMilli()).build();
                    Intrinsics.checkNotNullExpressionValue(build10, "newBuilder()\n           …                 .build()");
                    return build10;
                }
            });
        }
        if ($this$toProto instanceof HeightRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2418 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("Height"));
            $this$toProto_u24lambda_u2418.putValues("height", ValueExtKt.doubleVal(((HeightRecord) $this$toProto).getHeight().getMeters()));
            DataProto.DataPoint build10 = $this$toProto_u24lambda_u2418.build();
            Intrinsics.checkNotNullExpressionValue(build10, "instantaneousProto()\n   …\n                .build()");
            return build10;
        }
        if ($this$toProto instanceof HeartRateVariabilityRmssdRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2419 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("HeartRateVariabilityRmssd"));
            $this$toProto_u24lambda_u2419.putValues("heartRateVariability", ValueExtKt.doubleVal(((HeartRateVariabilityRmssdRecord) $this$toProto).getHeartRateVariabilityMillis()));
            DataProto.DataPoint build11 = $this$toProto_u24lambda_u2419.build();
            Intrinsics.checkNotNullExpressionValue(build11, "instantaneousProto()\n   …\n                .build()");
            return build11;
        }
        if ($this$toProto instanceof IntermenstrualBleedingRecord) {
            DataProto.DataPoint build12 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("IntermenstrualBleeding")).build();
            Intrinsics.checkNotNullExpressionValue(build12, "instantaneousProto().set…strualBleeding\")).build()");
            return build12;
        }
        if ($this$toProto instanceof LeanBodyMassRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2420 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("LeanBodyMass"));
            $this$toProto_u24lambda_u2420.putValues("mass", ValueExtKt.doubleVal(((LeanBodyMassRecord) $this$toProto).getMass().getKilograms()));
            DataProto.DataPoint build13 = $this$toProto_u24lambda_u2420.build();
            Intrinsics.checkNotNullExpressionValue(build13, "instantaneousProto()\n   …\n                .build()");
            return build13;
        }
        if ($this$toProto instanceof MenstruationFlowRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2422 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("Menstruation"));
            DataProto.Value it10 = ValueExtKt.enumValFromInt(((MenstruationFlowRecord) $this$toProto).getFlow(), MenstruationFlowRecord.FLOW_TYPE_INT_TO_STRING_MAP);
            if (it10 != null) {
                $this$toProto_u24lambda_u2422.putValues("flow", it10);
                Unit unit11 = Unit.INSTANCE;
                Unit unit12 = Unit.INSTANCE;
            }
            DataProto.DataPoint build14 = $this$toProto_u24lambda_u2422.build();
            Intrinsics.checkNotNullExpressionValue(build14, "instantaneousProto()\n   …\n                .build()");
            return build14;
        }
        if ($this$toProto instanceof MenstruationPeriodRecord) {
            DataProto.DataPoint build15 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("MenstruationPeriod")).build();
            Intrinsics.checkNotNullExpressionValue(build15, "intervalProto().setDataT…truationPeriod\")).build()");
            return build15;
        }
        if ($this$toProto instanceof OvulationTestRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2424 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("OvulationTest"));
            DataProto.Value it11 = ValueExtKt.enumValFromInt(((OvulationTestRecord) $this$toProto).getResult(), OvulationTestRecord.RESULT_INT_TO_STRING_MAP);
            if (it11 != null) {
                $this$toProto_u24lambda_u2424.putValues("result", it11);
                Unit unit13 = Unit.INSTANCE;
                Unit unit14 = Unit.INSTANCE;
            }
            DataProto.DataPoint build16 = $this$toProto_u24lambda_u2424.build();
            Intrinsics.checkNotNullExpressionValue(build16, "instantaneousProto()\n   …\n                .build()");
            return build16;
        }
        if ($this$toProto instanceof OxygenSaturationRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2425 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("OxygenSaturation"));
            $this$toProto_u24lambda_u2425.putValues("percentage", ValueExtKt.doubleVal(((OxygenSaturationRecord) $this$toProto).getPercentage().getValue()));
            DataProto.DataPoint build17 = $this$toProto_u24lambda_u2425.build();
            Intrinsics.checkNotNullExpressionValue(build17, "instantaneousProto()\n   …\n                .build()");
            return build17;
        }
        if ($this$toProto instanceof PowerRecord) {
            return toProto((SeriesRecord) $this$toProto, "PowerSeries", new Function1<PowerRecord.Sample, DataProto.SeriesValue>() { // from class: androidx.health.connect.client.impl.converters.records.RecordToProtoConvertersKt$toProto$18
                @Override // kotlin.jvm.functions.Function1
                public final DataProto.SeriesValue invoke(PowerRecord.Sample sample) {
                    Intrinsics.checkNotNullParameter(sample, "sample");
                    DataProto.SeriesValue build18 = DataProto.SeriesValue.newBuilder().putValues("power", ValueExtKt.doubleVal(sample.getPower().getWatts())).setInstantTimeMillis(sample.getTime().toEpochMilli()).build();
                    Intrinsics.checkNotNullExpressionValue(build18, "newBuilder()\n           …                 .build()");
                    return build18;
                }
            });
        }
        if ($this$toProto instanceof RespiratoryRateRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2426 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("RespiratoryRate"));
            $this$toProto_u24lambda_u2426.putValues("rate", ValueExtKt.doubleVal(((RespiratoryRateRecord) $this$toProto).getRate()));
            DataProto.DataPoint build18 = $this$toProto_u24lambda_u2426.build();
            Intrinsics.checkNotNullExpressionValue(build18, "instantaneousProto()\n   …\n                .build()");
            return build18;
        }
        if ($this$toProto instanceof RestingHeartRateRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2427 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("RestingHeartRate"));
            $this$toProto_u24lambda_u2427.putValues("bpm", ValueExtKt.longVal(((RestingHeartRateRecord) $this$toProto).getBeatsPerMinute()));
            DataProto.DataPoint build19 = $this$toProto_u24lambda_u2427.build();
            Intrinsics.checkNotNullExpressionValue(build19, "instantaneousProto()\n   …\n                .build()");
            return build19;
        }
        if ($this$toProto instanceof SexualActivityRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2429 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("SexualActivity"));
            DataProto.Value it12 = ValueExtKt.enumValFromInt(((SexualActivityRecord) $this$toProto).getProtectionUsed(), SexualActivityRecord.PROTECTION_USED_INT_TO_STRING_MAP);
            if (it12 != null) {
                $this$toProto_u24lambda_u2429.putValues("protectionUsed", it12);
                Unit unit15 = Unit.INSTANCE;
                Unit unit16 = Unit.INSTANCE;
            }
            DataProto.DataPoint build20 = $this$toProto_u24lambda_u2429.build();
            Intrinsics.checkNotNullExpressionValue(build20, "instantaneousProto()\n   …\n                .build()");
            return build20;
        }
        if ($this$toProto instanceof SpeedRecord) {
            return toProto((SeriesRecord) $this$toProto, "SpeedSeries", new Function1<SpeedRecord.Sample, DataProto.SeriesValue>() { // from class: androidx.health.connect.client.impl.converters.records.RecordToProtoConvertersKt$toProto$22
                @Override // kotlin.jvm.functions.Function1
                public final DataProto.SeriesValue invoke(SpeedRecord.Sample sample) {
                    Intrinsics.checkNotNullParameter(sample, "sample");
                    DataProto.SeriesValue build21 = DataProto.SeriesValue.newBuilder().putValues("speed", ValueExtKt.doubleVal(sample.getSpeed().getMetersPerSecond())).setInstantTimeMillis(sample.getTime().toEpochMilli()).build();
                    Intrinsics.checkNotNullExpressionValue(build21, "newBuilder()\n           …                 .build()");
                    return build21;
                }
            });
        }
        if ($this$toProto instanceof StepsCadenceRecord) {
            return toProto((SeriesRecord) $this$toProto, "StepsCadenceSeries", new Function1<StepsCadenceRecord.Sample, DataProto.SeriesValue>() { // from class: androidx.health.connect.client.impl.converters.records.RecordToProtoConvertersKt$toProto$23
                @Override // kotlin.jvm.functions.Function1
                public final DataProto.SeriesValue invoke(StepsCadenceRecord.Sample sample) {
                    Intrinsics.checkNotNullParameter(sample, "sample");
                    DataProto.SeriesValue build21 = DataProto.SeriesValue.newBuilder().putValues("rate", ValueExtKt.doubleVal(sample.getRate())).setInstantTimeMillis(sample.getTime().toEpochMilli()).build();
                    Intrinsics.checkNotNullExpressionValue(build21, "newBuilder()\n           …                 .build()");
                    return build21;
                }
            });
        }
        if ($this$toProto instanceof Vo2MaxRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2431 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("Vo2Max"));
            $this$toProto_u24lambda_u2431.putValues("vo2", ValueExtKt.doubleVal(((Vo2MaxRecord) $this$toProto).getVo2MillilitersPerMinuteKilogram()));
            DataProto.Value it13 = ValueExtKt.enumValFromInt(((Vo2MaxRecord) $this$toProto).getMeasurementMethod(), Vo2MaxRecord.MEASUREMENT_METHOD_INT_TO_STRING_MAP);
            if (it13 != null) {
                $this$toProto_u24lambda_u2431.putValues("measurementMethod", it13);
                Unit unit17 = Unit.INSTANCE;
                Unit unit18 = Unit.INSTANCE;
            }
            DataProto.DataPoint build21 = $this$toProto_u24lambda_u2431.build();
            Intrinsics.checkNotNullExpressionValue(build21, "instantaneousProto()\n   …\n                .build()");
            return build21;
        }
        if ($this$toProto instanceof WeightRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2432 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("Weight"));
            $this$toProto_u24lambda_u2432.putValues("weight", ValueExtKt.doubleVal(((WeightRecord) $this$toProto).getWeight().getKilograms()));
            DataProto.DataPoint build22 = $this$toProto_u24lambda_u2432.build();
            Intrinsics.checkNotNullExpressionValue(build22, "instantaneousProto()\n   …\n                .build()");
            return build22;
        }
        if ($this$toProto instanceof ActiveCaloriesBurnedRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2433 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("ActiveCaloriesBurned"));
            $this$toProto_u24lambda_u2433.putValues("energy", ValueExtKt.doubleVal(((ActiveCaloriesBurnedRecord) $this$toProto).getEnergy().getKilocalories()));
            DataProto.DataPoint build23 = $this$toProto_u24lambda_u2433.build();
            Intrinsics.checkNotNullExpressionValue(build23, "intervalProto()\n        …\n                .build()");
            return build23;
        }
        if ($this$toProto instanceof ExerciseSessionRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2439 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("ActivitySession")).putValues("hasRoute", ValueExtKt.boolVal(!(((ExerciseSessionRecord) $this$toProto).getExerciseRouteResult() instanceof ExerciseRouteResult.NoData)));
            DataProto.Value exerciseType = ValueExtKt.enumValFromInt(((ExerciseSessionRecord) $this$toProto).getExerciseType(), ExerciseSessionRecord.EXERCISE_TYPE_INT_TO_STRING_MAP);
            if (exerciseType == null) {
                exerciseType = ValueExtKt.enumVal(NotificationCompat.CATEGORY_WORKOUT);
            }
            $this$toProto_u24lambda_u2439.putValues("activityType", exerciseType);
            String it14 = ((ExerciseSessionRecord) $this$toProto).getTitle();
            if (it14 != null) {
                $this$toProto_u24lambda_u2439.putValues("title", ValueExtKt.stringVal(it14));
            }
            String it15 = ((ExerciseSessionRecord) $this$toProto).getNotes();
            if (it15 != null) {
                $this$toProto_u24lambda_u2439.putValues("notes", ValueExtKt.stringVal(it15));
            }
            if (!((ExerciseSessionRecord) $this$toProto).getSegments().isEmpty()) {
                DataProto.DataPoint.SubTypeDataList.Builder newBuilder = DataProto.DataPoint.SubTypeDataList.newBuilder();
                Iterable $this$map$iv = ((ExerciseSessionRecord) $this$toProto).getSegments();
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    destination$iv$iv.add(RecordToProtoUtilsKt.toProto((ExerciseSegment) item$iv$iv));
                }
                $this$toProto_u24lambda_u2439.putSubTypeDataLists("segments", newBuilder.addAllValues((List) destination$iv$iv).build());
            }
            if (!((ExerciseSessionRecord) $this$toProto).getLaps().isEmpty()) {
                DataProto.DataPoint.SubTypeDataList.Builder newBuilder2 = DataProto.DataPoint.SubTypeDataList.newBuilder();
                Iterable $this$map$iv2 = ((ExerciseSessionRecord) $this$toProto).getLaps();
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv2 : $this$map$iv2) {
                    destination$iv$iv2.add(RecordToProtoUtilsKt.toProto((ExerciseLap) item$iv$iv2));
                }
                $this$toProto_u24lambda_u2439.putSubTypeDataLists("laps", newBuilder2.addAllValues((List) destination$iv$iv2).build());
            }
            if (((ExerciseSessionRecord) $this$toProto).getExerciseRouteResult() instanceof ExerciseRouteResult.Data) {
                DataProto.DataPoint.SubTypeDataList.Builder newBuilder3 = DataProto.DataPoint.SubTypeDataList.newBuilder();
                Iterable $this$map$iv3 = ((ExerciseRouteResult.Data) ((ExerciseSessionRecord) $this$toProto).getExerciseRouteResult()).getExerciseRoute().getRoute();
                Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                for (Object item$iv$iv3 : $this$map$iv3) {
                    destination$iv$iv3.add(RecordToProtoUtilsKt.toProto((ExerciseRoute.Location) item$iv$iv3));
                }
                $this$toProto_u24lambda_u2439.putSubTypeDataLists("route", newBuilder3.addAllValues((List) destination$iv$iv3).build());
            }
            DataProto.DataPoint build24 = $this$toProto_u24lambda_u2439.build();
            Intrinsics.checkNotNullExpressionValue(build24, "intervalProto()\n        …\n                .build()");
            return build24;
        }
        if ($this$toProto instanceof DistanceRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2440 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("Distance"));
            $this$toProto_u24lambda_u2440.putValues("distance", ValueExtKt.doubleVal(((DistanceRecord) $this$toProto).getDistance().getMeters()));
            DataProto.DataPoint build25 = $this$toProto_u24lambda_u2440.build();
            Intrinsics.checkNotNullExpressionValue(build25, "intervalProto()\n        …\n                .build()");
            return build25;
        }
        if ($this$toProto instanceof ElevationGainedRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2441 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("ElevationGained"));
            $this$toProto_u24lambda_u2441.putValues("elevation", ValueExtKt.doubleVal(((ElevationGainedRecord) $this$toProto).getElevation().getMeters()));
            DataProto.DataPoint build26 = $this$toProto_u24lambda_u2441.build();
            Intrinsics.checkNotNullExpressionValue(build26, "intervalProto()\n        …\n                .build()");
            return build26;
        }
        if ($this$toProto instanceof FloorsClimbedRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2442 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("FloorsClimbed"));
            $this$toProto_u24lambda_u2442.putValues("floors", ValueExtKt.doubleVal(((FloorsClimbedRecord) $this$toProto).getFloors()));
            DataProto.DataPoint build27 = $this$toProto_u24lambda_u2442.build();
            Intrinsics.checkNotNullExpressionValue(build27, "intervalProto()\n        …\n                .build()");
            return build27;
        }
        if ($this$toProto instanceof HydrationRecord) {
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2443 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("Hydration"));
            $this$toProto_u24lambda_u2443.putValues("volume", ValueExtKt.doubleVal(((HydrationRecord) $this$toProto).getVolume().getLiters()));
            DataProto.DataPoint build28 = $this$toProto_u24lambda_u2443.build();
            Intrinsics.checkNotNullExpressionValue(build28, "intervalProto()\n        …\n                .build()");
            return build28;
        }
        if (!($this$toProto instanceof NutritionRecord)) {
            if ($this$toProto instanceof SkinTemperatureRecord) {
                DataProto.DataPoint.Builder $this$toProto_u24lambda_u2449 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("SkinTemperature"));
                if (((SkinTemperatureRecord) $this$toProto).getBaseline() != null) {
                    $this$toProto_u24lambda_u2449.putValues("baseline", ValueExtKt.doubleVal(((SkinTemperatureRecord) $this$toProto).getBaseline().getCelsius()));
                }
                if (!((SkinTemperatureRecord) $this$toProto).getDeltas().isEmpty()) {
                    DataProto.DataPoint.SubTypeDataList.Builder newBuilder4 = DataProto.DataPoint.SubTypeDataList.newBuilder();
                    Iterable $this$map$iv4 = ((SkinTemperatureRecord) $this$toProto).getDeltas();
                    Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                    for (Object item$iv$iv4 : $this$map$iv4) {
                        destination$iv$iv4.add(RecordToProtoUtilsKt.toProto((SkinTemperatureRecord.Delta) item$iv$iv4));
                    }
                    $this$toProto_u24lambda_u2449.putSubTypeDataLists("deltas", newBuilder4.addAllValues((List) destination$iv$iv4).build());
                }
                DataProto.Value it16 = ValueExtKt.enumValFromInt(((SkinTemperatureRecord) $this$toProto).getMeasurementLocation(), SkinTemperatureRecord.MEASUREMENT_LOCATION_INT_TO_STRING_MAP);
                if (it16 != null) {
                    $this$toProto_u24lambda_u2449.putValues("measurementLocation", it16);
                    Unit unit19 = Unit.INSTANCE;
                    Unit unit20 = Unit.INSTANCE;
                }
                DataProto.DataPoint build29 = $this$toProto_u24lambda_u2449.build();
                Intrinsics.checkNotNullExpressionValue(build29, "intervalProto()\n        …\n                .build()");
                return build29;
            }
            if (!($this$toProto instanceof SleepSessionRecord)) {
                if ($this$toProto instanceof StepsRecord) {
                    DataProto.DataPoint.Builder $this$toProto_u24lambda_u2454 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("Steps"));
                    $this$toProto_u24lambda_u2454.putValues("count", ValueExtKt.longVal(((StepsRecord) $this$toProto).getCount()));
                    DataProto.DataPoint build30 = $this$toProto_u24lambda_u2454.build();
                    Intrinsics.checkNotNullExpressionValue(build30, "intervalProto()\n        …\n                .build()");
                    return build30;
                }
                if ($this$toProto instanceof TotalCaloriesBurnedRecord) {
                    DataProto.DataPoint.Builder $this$toProto_u24lambda_u2455 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("TotalCaloriesBurned"));
                    $this$toProto_u24lambda_u2455.putValues("energy", ValueExtKt.doubleVal(((TotalCaloriesBurnedRecord) $this$toProto).getEnergy().getKilocalories()));
                    DataProto.DataPoint build31 = $this$toProto_u24lambda_u2455.build();
                    Intrinsics.checkNotNullExpressionValue(build31, "intervalProto()\n        …\n                .build()");
                    return build31;
                }
                if (!($this$toProto instanceof WheelchairPushesRecord)) {
                    throw new RuntimeException("Unsupported yet!");
                }
                DataProto.DataPoint.Builder $this$toProto_u24lambda_u2456 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("WheelchairPushes"));
                $this$toProto_u24lambda_u2456.putValues("count", ValueExtKt.longVal(((WheelchairPushesRecord) $this$toProto).getCount()));
                DataProto.DataPoint build32 = $this$toProto_u24lambda_u2456.build();
                Intrinsics.checkNotNullExpressionValue(build32, "intervalProto()\n        …\n                .build()");
                return build32;
            }
            DataProto.DataPoint.Builder $this$toProto_u24lambda_u2453 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("SleepSession"));
            if (!((SleepSessionRecord) $this$toProto).getStages().isEmpty()) {
                DataProto.DataPoint.SubTypeDataList.Builder newBuilder5 = DataProto.DataPoint.SubTypeDataList.newBuilder();
                Iterable $this$map$iv5 = ((SleepSessionRecord) $this$toProto).getStages();
                Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                for (Object item$iv$iv5 : $this$map$iv5) {
                    destination$iv$iv5.add(RecordToProtoUtilsKt.toProto((SleepSessionRecord.Stage) item$iv$iv5));
                }
                $this$toProto_u24lambda_u2453.putSubTypeDataLists("stages", newBuilder5.addAllValues((List) destination$iv$iv5).build());
            }
            String it17 = ((SleepSessionRecord) $this$toProto).getTitle();
            if (it17 != null) {
                $this$toProto_u24lambda_u2453.putValues("title", ValueExtKt.stringVal(it17));
            }
            String it18 = ((SleepSessionRecord) $this$toProto).getNotes();
            if (it18 != null) {
                $this$toProto_u24lambda_u2453.putValues("notes", ValueExtKt.stringVal(it18));
                Unit unit21 = Unit.INSTANCE;
                Unit unit22 = Unit.INSTANCE;
            }
            DataProto.DataPoint build33 = $this$toProto_u24lambda_u2453.build();
            Intrinsics.checkNotNullExpressionValue(build33, "intervalProto()\n        …\n                .build()");
            return build33;
        }
        DataProto.DataPoint.Builder $this$toProto_u24lambda_u2446 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) $this$toProto).setDataType(RecordToProtoUtilsKt.protoDataType("Nutrition"));
        if (((NutritionRecord) $this$toProto).getBiotin() != null) {
            $this$toProto_u24lambda_u2446.putValues("biotin", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getBiotin().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getCaffeine() != null) {
            $this$toProto_u24lambda_u2446.putValues("caffeine", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getCaffeine().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getCalcium() != null) {
            $this$toProto_u24lambda_u2446.putValues("calcium", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getCalcium().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getEnergy() != null) {
            $this$toProto_u24lambda_u2446.putValues("calories", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getEnergy().getKilocalories()));
        }
        if (((NutritionRecord) $this$toProto).getEnergyFromFat() != null) {
            $this$toProto_u24lambda_u2446.putValues("caloriesFromFat", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getEnergyFromFat().getKilocalories()));
        }
        if (((NutritionRecord) $this$toProto).getChloride() != null) {
            $this$toProto_u24lambda_u2446.putValues("chloride", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getChloride().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getCholesterol() != null) {
            $this$toProto_u24lambda_u2446.putValues("cholesterol", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getCholesterol().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getChromium() != null) {
            $this$toProto_u24lambda_u2446.putValues("chromium", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getChromium().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getCopper() != null) {
            $this$toProto_u24lambda_u2446.putValues("copper", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getCopper().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getDietaryFiber() != null) {
            $this$toProto_u24lambda_u2446.putValues("dietaryFiber", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getDietaryFiber().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getFolate() != null) {
            $this$toProto_u24lambda_u2446.putValues("folate", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getFolate().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getFolicAcid() != null) {
            $this$toProto_u24lambda_u2446.putValues("folicAcid", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getFolicAcid().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getIodine() != null) {
            $this$toProto_u24lambda_u2446.putValues("iodine", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getIodine().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getIron() != null) {
            $this$toProto_u24lambda_u2446.putValues("iron", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getIron().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getMagnesium() != null) {
            $this$toProto_u24lambda_u2446.putValues("magnesium", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getMagnesium().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getManganese() != null) {
            $this$toProto_u24lambda_u2446.putValues("manganese", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getManganese().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getMolybdenum() != null) {
            $this$toProto_u24lambda_u2446.putValues("molybdenum", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getMolybdenum().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getMonounsaturatedFat() != null) {
            $this$toProto_u24lambda_u2446.putValues("monounsaturatedFat", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getMonounsaturatedFat().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getNiacin() != null) {
            $this$toProto_u24lambda_u2446.putValues("niacin", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getNiacin().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getPantothenicAcid() != null) {
            $this$toProto_u24lambda_u2446.putValues("pantothenicAcid", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getPantothenicAcid().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getPhosphorus() != null) {
            $this$toProto_u24lambda_u2446.putValues("phosphorus", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getPhosphorus().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getPolyunsaturatedFat() != null) {
            $this$toProto_u24lambda_u2446.putValues("polyunsaturatedFat", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getPolyunsaturatedFat().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getPotassium() != null) {
            $this$toProto_u24lambda_u2446.putValues("potassium", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getPotassium().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getProtein() != null) {
            $this$toProto_u24lambda_u2446.putValues("protein", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getProtein().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getRiboflavin() != null) {
            $this$toProto_u24lambda_u2446.putValues("riboflavin", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getRiboflavin().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getSaturatedFat() != null) {
            $this$toProto_u24lambda_u2446.putValues("saturatedFat", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getSaturatedFat().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getSelenium() != null) {
            $this$toProto_u24lambda_u2446.putValues("selenium", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getSelenium().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getSodium() != null) {
            $this$toProto_u24lambda_u2446.putValues("sodium", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getSodium().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getSugar() != null) {
            $this$toProto_u24lambda_u2446.putValues("sugar", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getSugar().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getThiamin() != null) {
            $this$toProto_u24lambda_u2446.putValues("thiamin", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getThiamin().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getTotalCarbohydrate() != null) {
            $this$toProto_u24lambda_u2446.putValues("totalCarbohydrate", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getTotalCarbohydrate().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getTotalFat() != null) {
            $this$toProto_u24lambda_u2446.putValues("totalFat", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getTotalFat().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getTransFat() != null) {
            $this$toProto_u24lambda_u2446.putValues("transFat", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getTransFat().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getUnsaturatedFat() != null) {
            $this$toProto_u24lambda_u2446.putValues("unsaturatedFat", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getUnsaturatedFat().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getVitaminA() != null) {
            $this$toProto_u24lambda_u2446.putValues("vitaminA", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getVitaminA().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getVitaminB12() != null) {
            $this$toProto_u24lambda_u2446.putValues("vitaminB12", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getVitaminB12().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getVitaminB6() != null) {
            $this$toProto_u24lambda_u2446.putValues("vitaminB6", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getVitaminB6().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getVitaminC() != null) {
            $this$toProto_u24lambda_u2446.putValues("vitaminC", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getVitaminC().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getVitaminD() != null) {
            $this$toProto_u24lambda_u2446.putValues("vitaminD", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getVitaminD().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getVitaminE() != null) {
            $this$toProto_u24lambda_u2446.putValues("vitaminE", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getVitaminE().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getVitaminK() != null) {
            $this$toProto_u24lambda_u2446.putValues("vitaminK", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getVitaminK().getGrams()));
        }
        if (((NutritionRecord) $this$toProto).getZinc() != null) {
            $this$toProto_u24lambda_u2446.putValues("zinc", ValueExtKt.doubleVal(((NutritionRecord) $this$toProto).getZinc().getGrams()));
        }
        DataProto.Value it19 = ValueExtKt.enumValFromInt(((NutritionRecord) $this$toProto).getMealType(), MealType.MEAL_TYPE_INT_TO_STRING_MAP);
        if (it19 != null) {
            $this$toProto_u24lambda_u2446.putValues("mealType", it19);
        }
        String it20 = ((NutritionRecord) $this$toProto).getName();
        if (it20 != null) {
            $this$toProto_u24lambda_u2446.putValues(HintConstants.AUTOFILL_HINT_NAME, ValueExtKt.stringVal(it20));
            Unit unit23 = Unit.INSTANCE;
            Unit unit24 = Unit.INSTANCE;
        }
        DataProto.DataPoint build34 = $this$toProto_u24lambda_u2446.build();
        Intrinsics.checkNotNullExpressionValue(build34, "intervalProto()\n        …\n                .build()");
        return build34;
    }

    private static final <T> DataProto.DataPoint toProto(SeriesRecord<? extends T> seriesRecord, String dataTypeName, Function1<? super T, DataProto.SeriesValue> function1) {
        DataProto.DataPoint.Builder $this$toProto_u24lambda_u2457 = RecordToProtoUtilsKt.intervalProto(seriesRecord).setDataType(RecordToProtoUtilsKt.protoDataType(dataTypeName));
        for (Object sample : seriesRecord.getSamples()) {
            $this$toProto_u24lambda_u2457.addSeriesValues(function1.invoke(sample));
        }
        DataProto.DataPoint build = $this$toProto_u24lambda_u2457.build();
        Intrinsics.checkNotNullExpressionValue(build, "intervalProto()\n        …       }\n        .build()");
        return build;
    }
}
