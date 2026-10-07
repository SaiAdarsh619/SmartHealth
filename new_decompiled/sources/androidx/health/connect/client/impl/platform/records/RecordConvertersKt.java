package androidx.health.connect.client.impl.platform.records;

import android.health.connect.datatypes.ActiveCaloriesBurnedRecord;
import android.health.connect.datatypes.BasalBodyTemperatureRecord;
import android.health.connect.datatypes.BasalMetabolicRateRecord;
import android.health.connect.datatypes.BloodGlucoseRecord;
import android.health.connect.datatypes.BloodPressureRecord;
import android.health.connect.datatypes.BodyFatRecord;
import android.health.connect.datatypes.BodyTemperatureRecord;
import android.health.connect.datatypes.BodyWaterMassRecord;
import android.health.connect.datatypes.BoneMassRecord;
import android.health.connect.datatypes.CervicalMucusRecord;
import android.health.connect.datatypes.CyclingPedalingCadenceRecord;
import android.health.connect.datatypes.DistanceRecord;
import android.health.connect.datatypes.ElevationGainedRecord;
import android.health.connect.datatypes.ExerciseCompletionGoal;
import android.health.connect.datatypes.ExerciseLap;
import android.health.connect.datatypes.ExercisePerformanceGoal;
import android.health.connect.datatypes.ExerciseRoute;
import android.health.connect.datatypes.ExerciseSegment;
import android.health.connect.datatypes.ExerciseSessionRecord;
import android.health.connect.datatypes.FloorsClimbedRecord;
import android.health.connect.datatypes.HeartRateRecord;
import android.health.connect.datatypes.HeartRateVariabilityRmssdRecord;
import android.health.connect.datatypes.HeightRecord;
import android.health.connect.datatypes.HydrationRecord;
import android.health.connect.datatypes.IntermenstrualBleedingRecord;
import android.health.connect.datatypes.LeanBodyMassRecord;
import android.health.connect.datatypes.MenstruationFlowRecord;
import android.health.connect.datatypes.MenstruationPeriodRecord;
import android.health.connect.datatypes.NutritionRecord;
import android.health.connect.datatypes.OvulationTestRecord;
import android.health.connect.datatypes.OxygenSaturationRecord;
import android.health.connect.datatypes.PlannedExerciseBlock;
import android.health.connect.datatypes.PlannedExerciseSessionRecord;
import android.health.connect.datatypes.PlannedExerciseStep;
import android.health.connect.datatypes.PowerRecord;
import android.health.connect.datatypes.Record;
import android.health.connect.datatypes.RespiratoryRateRecord;
import android.health.connect.datatypes.RestingHeartRateRecord;
import android.health.connect.datatypes.SexualActivityRecord;
import android.health.connect.datatypes.SkinTemperatureRecord;
import android.health.connect.datatypes.SleepSessionRecord;
import android.health.connect.datatypes.SpeedRecord;
import android.health.connect.datatypes.StepsCadenceRecord;
import android.health.connect.datatypes.StepsRecord;
import android.health.connect.datatypes.TotalCaloriesBurnedRecord;
import android.health.connect.datatypes.Vo2MaxRecord;
import android.health.connect.datatypes.WeightRecord;
import android.health.connect.datatypes.WheelchairPushesRecord;
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
import androidx.health.connect.client.records.ExerciseCompletionGoal;
import androidx.health.connect.client.records.ExercisePerformanceTarget;
import androidx.health.connect.client.records.ExerciseRoute;
import androidx.health.connect.client.records.ExerciseRouteResult;
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
import androidx.health.connect.client.records.PlannedExerciseBlock;
import androidx.health.connect.client.records.PlannedExerciseSessionRecord;
import androidx.health.connect.client.records.PlannedExerciseStep;
import androidx.health.connect.client.records.PowerRecord;
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
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.reflect.KClass;

/* compiled from: RecordConverters.kt */
@Metadata(m286d1 = {"\u0000ü\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0002\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0002\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0011H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0002\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0017H\u0002\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0002\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001dH\u0002\u001a\f\u0010\u001e\u001a\u00020\u001f*\u00020 H\u0002\u001a\u0010\u0010!\u001a\u00060\"j\u0002`#*\u00020$H\u0002\u001a\f\u0010%\u001a\u00020&*\u00020'H\u0002\u001a\f\u0010(\u001a\u00020)*\u00020*H\u0002\u001a\f\u0010+\u001a\u00020,*\u00020-H\u0001\u001a\f\u0010.\u001a\u00020/*\u000200H\u0002\u001a\f\u00101\u001a\u000202*\u000203H\u0001\u001a\u0010\u00104\u001a\u000605j\u0002`6*\u000207H\u0002\u001a\f\u00108\u001a\u000209*\u00020:H\u0002\u001a\f\u0010;\u001a\u00020<*\u00020=H\u0003\u001a\f\u0010>\u001a\u00020?*\u00020@H\u0002\u001a\f\u0010A\u001a\u00020B*\u00020CH\u0002\u001a\u0010\u0010D\u001a\u00060Ej\u0002`F*\u00020GH\u0002\u001a\f\u0010H\u001a\u00020I*\u00020JH\u0002\u001a\f\u0010K\u001a\u00020L*\u00020MH\u0002\u001a\f\u0010N\u001a\u00020O*\u00020PH\u0002\u001a\f\u0010Q\u001a\u00020R*\u00020SH\u0002\u001a\f\u0010T\u001a\u00020U*\u00020VH\u0002\u001a\f\u0010W\u001a\u00020X*\u00020YH\u0002\u001a\f\u0010Z\u001a\u00020[*\u00020\\H\u0002\u001a\f\u0010]\u001a\u00020^*\u00020_H\u0002\u001a\f\u0010`\u001a\u00020a*\u00020bH\u0002\u001a\f\u0010c\u001a\u00020d*\u00020eH\u0002\u001a\f\u0010f\u001a\u00020g*\u00020hH\u0003\u001a\f\u0010i\u001a\u00020j*\u00020kH\u0003\u001a\f\u0010l\u001a\u00020m*\u00020nH\u0003\u001a\f\u0010o\u001a\u00020p*\u00020qH\u0002\u001a\u0010\u0010r\u001a\u00060sj\u0002`t*\u00020uH\u0002\u001a\u000e\u0010v\u001a\u00060wj\u0002`x*\u00020y\u001a \u0010z\u001a\u000e\u0012\n\b\u0001\u0012\u00060wj\u0002`x0{*\n\u0012\u0006\b\u0001\u0012\u00020y0|H\u0000\u001a\"\u0010}\u001a\u0010\u0012\n\b\u0001\u0012\u00060wj\u0002`x\u0018\u00010{*\n\u0012\u0006\b\u0001\u0012\u00020y0|H\u0003\u001a\u0014\u0010~\u001a\n\u0018\u00010wj\u0004\u0018\u0001`x*\u00020yH\u0002\u001a\u000e\u0010\u007f\u001a\u00030\u0080\u0001*\u00030\u0081\u0001H\u0002\u001a\u000f\u0010\u0082\u0001\u001a\u00030\u0083\u0001*\u00030\u0084\u0001H\u0002\u001a\u000f\u0010\u0085\u0001\u001a\u00030\u0086\u0001*\u00030\u0087\u0001H\u0002\u001a\u000f\u0010\u0088\u0001\u001a\u00030\u0089\u0001*\u00030\u008a\u0001H\u0003\u001a\u0014\u0010\u008b\u0001\u001a\b0\u008c\u0001j\u0003`\u008d\u0001*\u00030\u008e\u0001H\u0003\u001a\u000f\u0010\u008f\u0001\u001a\u00030\u0090\u0001*\u00030\u0091\u0001H\u0002\u001a\u0014\u0010\u0092\u0001\u001a\b0\u0093\u0001j\u0003`\u0094\u0001*\u00030\u0095\u0001H\u0002\u001a\u000f\u0010\u0096\u0001\u001a\u00030\u0097\u0001*\u00030\u0098\u0001H\u0002\u001a\u0014\u0010\u0099\u0001\u001a\b0\u009a\u0001j\u0003`\u009b\u0001*\u00030\u009c\u0001H\u0002\u001a\u000f\u0010\u009d\u0001\u001a\u00030\u009e\u0001*\u00030\u009f\u0001H\u0002\u001a\u0014\u0010 \u0001\u001a\b0¡\u0001j\u0003`¢\u0001*\u00030£\u0001H\u0002\u001a\u000f\u0010¤\u0001\u001a\u00030¥\u0001*\u00030¦\u0001H\u0002\u001a\u000f\u0010§\u0001\u001a\u00030¨\u0001*\u00030©\u0001H\u0002\u001a\u000f\u0010ª\u0001\u001a\u00030«\u0001*\u00030¬\u0001H\u0002\u001a\u000f\u0010\u00ad\u0001\u001a\u00030®\u0001*\u00030¯\u0001H\u0002\u001a\u000f\u0010°\u0001\u001a\u00030±\u0001*\u00030²\u0001H\u0002\u001a\u0012\u0010³\u0001\u001a\u00020\u0002*\u00070\u0001j\u0003`´\u0001H\u0002\u001a\u0012\u0010µ\u0001\u001a\u00020\u0005*\u00070\u0004j\u0003`¶\u0001H\u0002\u001a\u0012\u0010·\u0001\u001a\u00020\b*\u00070\u0007j\u0003`¸\u0001H\u0002\u001a\u0012\u0010¹\u0001\u001a\u00020\u000b*\u00070\nj\u0003`º\u0001H\u0002\u001a\u0012\u0010»\u0001\u001a\u00020\u000e*\u00070\rj\u0003`¼\u0001H\u0002\u001a\u0012\u0010½\u0001\u001a\u00020\u0011*\u00070\u0010j\u0003`¾\u0001H\u0002\u001a\u0012\u0010¿\u0001\u001a\u00020\u0014*\u00070\u0013j\u0003`À\u0001H\u0002\u001a\u0012\u0010Á\u0001\u001a\u00020\u0017*\u00070\u0016j\u0003`Â\u0001H\u0002\u001a\u0012\u0010Ã\u0001\u001a\u00020\u001a*\u00070\u0019j\u0003`Ä\u0001H\u0002\u001a\u0012\u0010Å\u0001\u001a\u00020\u001d*\u00070\u001cj\u0003`Æ\u0001H\u0002\u001a\u0012\u0010Ç\u0001\u001a\u00020 *\u00070\u001fj\u0003`È\u0001H\u0002\u001a\u0011\u0010É\u0001\u001a\u00020$*\u00060\"j\u0002`#H\u0002\u001a\u0012\u0010Ê\u0001\u001a\u00020'*\u00070&j\u0003`Ë\u0001H\u0002\u001a\u0012\u0010Ì\u0001\u001a\u00020**\u00070)j\u0003`Í\u0001H\u0002\u001a\u0012\u0010Î\u0001\u001a\u00020-*\u00070,j\u0003`Ï\u0001H\u0001\u001a\u0012\u0010Ð\u0001\u001a\u000200*\u00070/j\u0003`Ñ\u0001H\u0000\u001a\u0012\u0010Ò\u0001\u001a\u000203*\u000702j\u0003`Ó\u0001H\u0001\u001a\u0011\u0010Ô\u0001\u001a\u000207*\u000605j\u0002`6H\u0000\u001a\u0012\u0010Õ\u0001\u001a\u00020:*\u000709j\u0003`Ö\u0001H\u0000\u001a\u0012\u0010×\u0001\u001a\u00020=*\u00070<j\u0003`Ø\u0001H\u0003\u001a\u0012\u0010Ù\u0001\u001a\u00020@*\u00070?j\u0003`Ú\u0001H\u0002\u001a\u0012\u0010Û\u0001\u001a\u00020C*\u00070Bj\u0003`Ü\u0001H\u0002\u001a\u0011\u0010Ý\u0001\u001a\u00020G*\u00060Ej\u0002`FH\u0002\u001a\u0012\u0010Þ\u0001\u001a\u00020J*\u00070Ij\u0003`ß\u0001H\u0002\u001a\u0012\u0010à\u0001\u001a\u00020M*\u00070Lj\u0003`á\u0001H\u0002\u001a\u0012\u0010â\u0001\u001a\u00020P*\u00070Oj\u0003`ã\u0001H\u0002\u001a\u0012\u0010ä\u0001\u001a\u00020S*\u00070Rj\u0003`å\u0001H\u0002\u001a\u0012\u0010æ\u0001\u001a\u00020V*\u00070Uj\u0003`ç\u0001H\u0002\u001a\u0012\u0010è\u0001\u001a\u00020Y*\u00070Xj\u0003`é\u0001H\u0002\u001a\u0012\u0010ê\u0001\u001a\u00020\\*\u00070[j\u0003`ë\u0001H\u0002\u001a\u0012\u0010ì\u0001\u001a\u00020_*\u00070^j\u0003`í\u0001H\u0002\u001a\u0012\u0010î\u0001\u001a\u00020b*\u00070aj\u0003`ï\u0001H\u0002\u001a\u0012\u0010ð\u0001\u001a\u00020e*\u00070dj\u0003`ñ\u0001H\u0002\u001a\u0012\u0010ò\u0001\u001a\u00020h*\u00070gj\u0003`ó\u0001H\u0003\u001a\u0012\u0010ô\u0001\u001a\u00020k*\u00070jj\u0003`õ\u0001H\u0001\u001a\u0012\u0010ö\u0001\u001a\u00020n*\u00070mj\u0003`÷\u0001H\u0003\u001a\u0012\u0010ø\u0001\u001a\u00020q*\u00070pj\u0003`ù\u0001H\u0002\u001a\u0011\u0010ú\u0001\u001a\u00020u*\u00060sj\u0002`tH\u0002\u001a\u000f\u0010û\u0001\u001a\u00020y*\u00060wj\u0002`x\u001a\u0013\u0010ü\u0001\u001a\u0004\u0018\u00010y*\u00060wj\u0002`xH\u0003\u001a\u0014\u0010ý\u0001\u001a\u00030\u0081\u0001*\b0\u0080\u0001j\u0003`þ\u0001H\u0002\u001a\u0014\u0010ÿ\u0001\u001a\u00030\u0084\u0001*\b0\u0083\u0001j\u0003`\u0080\u0002H\u0002\u001a\u0014\u0010\u0081\u0002\u001a\u00030\u0087\u0001*\b0\u0086\u0001j\u0003`\u0082\u0002H\u0002\u001a\u0014\u0010\u0083\u0002\u001a\u00030\u008e\u0001*\b0\u008c\u0001j\u0003`\u008d\u0001H\u0003\u001a\u0014\u0010\u0084\u0002\u001a\u00030\u008a\u0001*\b0\u0089\u0001j\u0003`\u0085\u0002H\u0003\u001a\u0014\u0010\u0086\u0002\u001a\u00030\u0091\u0001*\b0\u0090\u0001j\u0003`\u0087\u0002H\u0002\u001a\u0014\u0010\u0088\u0002\u001a\u00030\u0095\u0001*\b0\u0093\u0001j\u0003`\u0094\u0001H\u0002\u001a\u0014\u0010\u0089\u0002\u001a\u00030\u0098\u0001*\b0\u0097\u0001j\u0003`\u008a\u0002H\u0002\u001a\u0014\u0010\u008b\u0002\u001a\u00030\u009c\u0001*\b0\u009a\u0001j\u0003`\u009b\u0001H\u0002\u001a\u0014\u0010\u008c\u0002\u001a\u00030\u009f\u0001*\b0\u009e\u0001j\u0003`\u008d\u0002H\u0002\u001a\u0014\u0010\u008e\u0002\u001a\u00030£\u0001*\b0¡\u0001j\u0003`¢\u0001H\u0002\u001a\u0014\u0010\u008f\u0002\u001a\u00030¦\u0001*\b0¥\u0001j\u0003`\u0090\u0002H\u0002\u001a\u0014\u0010\u0091\u0002\u001a\u00030©\u0001*\b0¨\u0001j\u0003`\u0092\u0002H\u0002\u001a\u0014\u0010\u0093\u0002\u001a\u00030¬\u0001*\b0«\u0001j\u0003`\u0094\u0002H\u0002\u001a\u0014\u0010\u0095\u0002\u001a\u00030¯\u0001*\b0®\u0001j\u0003`\u0096\u0002H\u0002\u001a\u0014\u0010\u0097\u0002\u001a\u00030²\u0001*\b0±\u0001j\u0003`\u0098\u0002H\u0002¨\u0006\u0099\u0002"}, m287d2 = {"toPlatformActiveCaloriesBurnedRecord", "Landroid/health/connect/datatypes/ActiveCaloriesBurnedRecord;", "Landroidx/health/connect/client/records/ActiveCaloriesBurnedRecord;", "toPlatformBasalBodyTemperatureRecord", "Landroid/health/connect/datatypes/BasalBodyTemperatureRecord;", "Landroidx/health/connect/client/records/BasalBodyTemperatureRecord;", "toPlatformBasalMetabolicRateRecord", "Landroid/health/connect/datatypes/BasalMetabolicRateRecord;", "Landroidx/health/connect/client/records/BasalMetabolicRateRecord;", "toPlatformBloodGlucoseRecord", "Landroid/health/connect/datatypes/BloodGlucoseRecord;", "Landroidx/health/connect/client/records/BloodGlucoseRecord;", "toPlatformBloodPressureRecord", "Landroid/health/connect/datatypes/BloodPressureRecord;", "Landroidx/health/connect/client/records/BloodPressureRecord;", "toPlatformBodyFatRecord", "Landroid/health/connect/datatypes/BodyFatRecord;", "Landroidx/health/connect/client/records/BodyFatRecord;", "toPlatformBodyTemperatureRecord", "Landroid/health/connect/datatypes/BodyTemperatureRecord;", "Landroidx/health/connect/client/records/BodyTemperatureRecord;", "toPlatformBodyWaterMassRecord", "Landroid/health/connect/datatypes/BodyWaterMassRecord;", "Landroidx/health/connect/client/records/BodyWaterMassRecord;", "toPlatformBoneMassRecord", "Landroid/health/connect/datatypes/BoneMassRecord;", "Landroidx/health/connect/client/records/BoneMassRecord;", "toPlatformCervicalMucusRecord", "Landroid/health/connect/datatypes/CervicalMucusRecord;", "Landroidx/health/connect/client/records/CervicalMucusRecord;", "toPlatformCyclingPedalingCadenceRecord", "Landroid/health/connect/datatypes/CyclingPedalingCadenceRecord;", "Landroidx/health/connect/client/records/CyclingPedalingCadenceRecord;", "toPlatformCyclingPedalingCadenceSample", "Landroid/health/connect/datatypes/CyclingPedalingCadenceRecord$CyclingPedalingCadenceRecordSample;", "Landroidx/health/connect/client/impl/platform/records/PlatformCyclingPedalingCadenceSample;", "Landroidx/health/connect/client/records/CyclingPedalingCadenceRecord$Sample;", "toPlatformDistanceRecord", "Landroid/health/connect/datatypes/DistanceRecord;", "Landroidx/health/connect/client/records/DistanceRecord;", "toPlatformElevationGainedRecord", "Landroid/health/connect/datatypes/ElevationGainedRecord;", "Landroidx/health/connect/client/records/ElevationGainedRecord;", "toPlatformExerciseCompletionGoal", "Landroid/health/connect/datatypes/ExerciseCompletionGoal;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "toPlatformExerciseLap", "Landroid/health/connect/datatypes/ExerciseLap;", "Landroidx/health/connect/client/records/ExerciseLap;", "toPlatformExercisePerformanceTarget", "Landroid/health/connect/datatypes/ExercisePerformanceGoal;", "Landroidx/health/connect/client/records/ExercisePerformanceTarget;", "toPlatformExerciseRoute", "Landroid/health/connect/datatypes/ExerciseRoute;", "Landroidx/health/connect/client/impl/platform/records/PlatformExerciseRoute;", "Landroidx/health/connect/client/records/ExerciseRoute;", "toPlatformExerciseSegment", "Landroid/health/connect/datatypes/ExerciseSegment;", "Landroidx/health/connect/client/records/ExerciseSegment;", "toPlatformExerciseSessionRecord", "Landroid/health/connect/datatypes/ExerciseSessionRecord;", "Landroidx/health/connect/client/records/ExerciseSessionRecord;", "toPlatformFloorsClimbedRecord", "Landroid/health/connect/datatypes/FloorsClimbedRecord;", "Landroidx/health/connect/client/records/FloorsClimbedRecord;", "toPlatformHeartRateRecord", "Landroid/health/connect/datatypes/HeartRateRecord;", "Landroidx/health/connect/client/records/HeartRateRecord;", "toPlatformHeartRateSample", "Landroid/health/connect/datatypes/HeartRateRecord$HeartRateSample;", "Landroidx/health/connect/client/impl/platform/records/PlatformHeartRateSample;", "Landroidx/health/connect/client/records/HeartRateRecord$Sample;", "toPlatformHeartRateVariabilityRmssdRecord", "Landroid/health/connect/datatypes/HeartRateVariabilityRmssdRecord;", "Landroidx/health/connect/client/records/HeartRateVariabilityRmssdRecord;", "toPlatformHeightRecord", "Landroid/health/connect/datatypes/HeightRecord;", "Landroidx/health/connect/client/records/HeightRecord;", "toPlatformHydrationRecord", "Landroid/health/connect/datatypes/HydrationRecord;", "Landroidx/health/connect/client/records/HydrationRecord;", "toPlatformIntermenstrualBleedingRecord", "Landroid/health/connect/datatypes/IntermenstrualBleedingRecord;", "Landroidx/health/connect/client/records/IntermenstrualBleedingRecord;", "toPlatformLeanBodyMassRecord", "Landroid/health/connect/datatypes/LeanBodyMassRecord;", "Landroidx/health/connect/client/records/LeanBodyMassRecord;", "toPlatformMenstruationFlowRecord", "Landroid/health/connect/datatypes/MenstruationFlowRecord;", "Landroidx/health/connect/client/records/MenstruationFlowRecord;", "toPlatformMenstruationPeriodRecord", "Landroid/health/connect/datatypes/MenstruationPeriodRecord;", "Landroidx/health/connect/client/records/MenstruationPeriodRecord;", "toPlatformNutritionRecord", "Landroid/health/connect/datatypes/NutritionRecord;", "Landroidx/health/connect/client/records/NutritionRecord;", "toPlatformOvulationTestRecord", "Landroid/health/connect/datatypes/OvulationTestRecord;", "Landroidx/health/connect/client/records/OvulationTestRecord;", "toPlatformOxygenSaturationRecord", "Landroid/health/connect/datatypes/OxygenSaturationRecord;", "Landroidx/health/connect/client/records/OxygenSaturationRecord;", "toPlatformPlannedExerciseBlock", "Landroid/health/connect/datatypes/PlannedExerciseBlock;", "Landroidx/health/connect/client/records/PlannedExerciseBlock;", "toPlatformPlannedExerciseSessionRecord", "Landroid/health/connect/datatypes/PlannedExerciseSessionRecord;", "Landroidx/health/connect/client/records/PlannedExerciseSessionRecord;", "toPlatformPlannedExerciseStep", "Landroid/health/connect/datatypes/PlannedExerciseStep;", "Landroidx/health/connect/client/records/PlannedExerciseStep;", "toPlatformPowerRecord", "Landroid/health/connect/datatypes/PowerRecord;", "Landroidx/health/connect/client/records/PowerRecord;", "toPlatformPowerRecordSample", "Landroid/health/connect/datatypes/PowerRecord$PowerRecordSample;", "Landroidx/health/connect/client/impl/platform/records/PlatformPowerRecordSample;", "Landroidx/health/connect/client/records/PowerRecord$Sample;", "toPlatformRecord", "Landroid/health/connect/datatypes/Record;", "Landroidx/health/connect/client/impl/platform/records/PlatformRecord;", "Landroidx/health/connect/client/records/Record;", "toPlatformRecordClass", "Ljava/lang/Class;", "Lkotlin/reflect/KClass;", "toPlatformRecordClassExt13", "toPlatformRecordExt13", "toPlatformRespiratoryRateRecord", "Landroid/health/connect/datatypes/RespiratoryRateRecord;", "Landroidx/health/connect/client/records/RespiratoryRateRecord;", "toPlatformRestingHeartRateRecord", "Landroid/health/connect/datatypes/RestingHeartRateRecord;", "Landroidx/health/connect/client/records/RestingHeartRateRecord;", "toPlatformSexualActivityRecord", "Landroid/health/connect/datatypes/SexualActivityRecord;", "Landroidx/health/connect/client/records/SexualActivityRecord;", "toPlatformSkinTemperatureRecord", "Landroid/health/connect/datatypes/SkinTemperatureRecord;", "Landroidx/health/connect/client/records/SkinTemperatureRecord;", "toPlatformSkinTemperatureRecordDelta", "Landroid/health/connect/datatypes/SkinTemperatureRecord$Delta;", "Landroidx/health/connect/client/impl/platform/records/PlatformSkinTemperatureDelta;", "Landroidx/health/connect/client/records/SkinTemperatureRecord$Delta;", "toPlatformSleepSessionRecord", "Landroid/health/connect/datatypes/SleepSessionRecord;", "Landroidx/health/connect/client/records/SleepSessionRecord;", "toPlatformSleepSessionStage", "Landroid/health/connect/datatypes/SleepSessionRecord$Stage;", "Landroidx/health/connect/client/impl/platform/records/PlatformSleepSessionStage;", "Landroidx/health/connect/client/records/SleepSessionRecord$Stage;", "toPlatformSpeedRecord", "Landroid/health/connect/datatypes/SpeedRecord;", "Landroidx/health/connect/client/records/SpeedRecord;", "toPlatformSpeedRecordSample", "Landroid/health/connect/datatypes/SpeedRecord$SpeedRecordSample;", "Landroidx/health/connect/client/impl/platform/records/PlatformSpeedSample;", "Landroidx/health/connect/client/records/SpeedRecord$Sample;", "toPlatformStepsCadenceRecord", "Landroid/health/connect/datatypes/StepsCadenceRecord;", "Landroidx/health/connect/client/records/StepsCadenceRecord;", "toPlatformStepsCadenceSample", "Landroid/health/connect/datatypes/StepsCadenceRecord$StepsCadenceRecordSample;", "Landroidx/health/connect/client/impl/platform/records/PlatformStepsCadenceSample;", "Landroidx/health/connect/client/records/StepsCadenceRecord$Sample;", "toPlatformStepsRecord", "Landroid/health/connect/datatypes/StepsRecord;", "Landroidx/health/connect/client/records/StepsRecord;", "toPlatformTotalCaloriesBurnedRecord", "Landroid/health/connect/datatypes/TotalCaloriesBurnedRecord;", "Landroidx/health/connect/client/records/TotalCaloriesBurnedRecord;", "toPlatformVo2MaxRecord", "Landroid/health/connect/datatypes/Vo2MaxRecord;", "Landroidx/health/connect/client/records/Vo2MaxRecord;", "toPlatformWeightRecord", "Landroid/health/connect/datatypes/WeightRecord;", "Landroidx/health/connect/client/records/WeightRecord;", "toPlatformWheelchairPushesRecord", "Landroid/health/connect/datatypes/WheelchairPushesRecord;", "Landroidx/health/connect/client/records/WheelchairPushesRecord;", "toSdkActiveCaloriesBurnedRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformActiveCaloriesBurnedRecord;", "toSdkBasalBodyTemperatureRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformBasalBodyTemperatureRecord;", "toSdkBasalMetabolicRateRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformBasalMetabolicRateRecord;", "toSdkBloodGlucoseRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformBloodGlucoseRecord;", "toSdkBloodPressureRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformBloodPressureRecord;", "toSdkBodyFatRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformBodyFatRecord;", "toSdkBodyTemperatureRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformBodyTemperatureRecord;", "toSdkBodyWaterMassRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformBodyWaterMassRecord;", "toSdkBoneMassRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformBoneMassRecord;", "toSdkCervicalMucusRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformCervicalMucusRecord;", "toSdkCyclingPedalingCadenceRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformCyclingPedalingCadenceRecord;", "toSdkCyclingPedalingCadenceSample", "toSdkDistanceRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformDistanceRecord;", "toSdkElevationGainedRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformElevationGainedRecord;", "toSdkExerciseCompletionGoal", "Landroidx/health/connect/client/impl/platform/records/PlatformExerciseCompletionGoal;", "toSdkExerciseLap", "Landroidx/health/connect/client/impl/platform/records/PlatformExerciseLap;", "toSdkExercisePerformanceTarget", "Landroidx/health/connect/client/impl/platform/records/PlatformExercisePerformanceTarget;", "toSdkExerciseRoute", "toSdkExerciseSegment", "Landroidx/health/connect/client/impl/platform/records/PlatformExerciseSegment;", "toSdkExerciseSessionRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformExerciseSessionRecord;", "toSdkFloorsClimbedRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformFloorsClimbedRecord;", "toSdkHeartRateRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformHeartRateRecord;", "toSdkHeartRateSample", "toSdkHeartRateVariabilityRmssdRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformHeartRateVariabilityRmssdRecord;", "toSdkHeightRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformHeightRecord;", "toSdkHydrationRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformHydrationRecord;", "toSdkIntermenstrualBleedingRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformIntermenstrualBleedingRecord;", "toSdkLeanBodyMassRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformLeanBodyMassRecord;", "toSdkMenstruationFlowRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformMenstruationFlowRecord;", "toSdkMenstruationPeriodRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformMenstruationPeriodRecord;", "toSdkNutritionRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformNutritionRecord;", "toSdkOvulationTestRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformOvulationTestRecord;", "toSdkOxygenSaturationRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformOxygenSaturationRecord;", "toSdkPlannedExerciseBlock", "Landroidx/health/connect/client/impl/platform/records/PlatformPlannedExerciseBlock;", "toSdkPlannedExerciseSessionRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformPlannedExerciseSessionRecord;", "toSdkPlannedExerciseStep", "Landroidx/health/connect/client/impl/platform/records/PlatformPlannedExerciseStep;", "toSdkPowerRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformPowerRecord;", "toSdkPowerRecordSample", "toSdkRecord", "toSdkRecordExt13", "toSdkRespiratoryRateRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformRespiratoryRateRecord;", "toSdkRestingHeartRateRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformRestingHeartRateRecord;", "toSdkSexualActivityRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformSexualActivityRecord;", "toSdkSkinTemperatureDelta", "toSdkSkinTemperatureRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformSkinTemperatureRecord;", "toSdkSleepSessionRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformSleepSessionRecord;", "toSdkSleepSessionStage", "toSdkSpeedRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformSpeedRecord;", "toSdkSpeedSample", "toSdkStepsCadenceRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformStepsCadenceRecord;", "toSdkStepsCadenceSample", "toSdkStepsRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformStepsRecord;", "toSdkTotalCaloriesBurnedRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformTotalCaloriesBurnedRecord;", "toSdkVo2MaxRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformVo2MaxRecord;", "toSdkWeightRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformWeightRecord;", "toWheelchairPushesRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformWheelchairPushesRecord;", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class RecordConvertersKt {
    public static final Class<? extends Record> toPlatformRecordClass(KClass<? extends androidx.health.connect.client.records.Record> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Class<? extends Record> platformRecordClassExt13 = toPlatformRecordClassExt13(kClass);
        if (platformRecordClassExt13 != null || (platformRecordClassExt13 = RecordMappingsKt.getSDK_TO_PLATFORM_RECORD_CLASS().get(kClass)) != null) {
            return platformRecordClassExt13;
        }
        throw new IllegalArgumentException("Unsupported record type " + kClass);
    }

    private static final Class<? extends Record> toPlatformRecordClassExt13(KClass<? extends androidx.health.connect.client.records.Record> kClass) {
        if (!UtilsKt.isAtLeastSdkExtension13()) {
            return null;
        }
        return RecordMappingsKt.getSDK_TO_PLATFORM_RECORD_CLASS_EXT_13().get(kClass);
    }

    public static final Record toPlatformRecord(androidx.health.connect.client.records.Record $this$toPlatformRecord) {
        Intrinsics.checkNotNullParameter($this$toPlatformRecord, "<this>");
        Record platformRecordExt13 = toPlatformRecordExt13($this$toPlatformRecord);
        if (platformRecordExt13 != null) {
            return platformRecordExt13;
        }
        if ($this$toPlatformRecord instanceof ActiveCaloriesBurnedRecord) {
            return toPlatformActiveCaloriesBurnedRecord((ActiveCaloriesBurnedRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof BasalBodyTemperatureRecord) {
            return toPlatformBasalBodyTemperatureRecord((BasalBodyTemperatureRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof BasalMetabolicRateRecord) {
            return toPlatformBasalMetabolicRateRecord((BasalMetabolicRateRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof BloodGlucoseRecord) {
            return toPlatformBloodGlucoseRecord((BloodGlucoseRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof BloodPressureRecord) {
            return toPlatformBloodPressureRecord((BloodPressureRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof BodyFatRecord) {
            return toPlatformBodyFatRecord((BodyFatRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof BodyTemperatureRecord) {
            return toPlatformBodyTemperatureRecord((BodyTemperatureRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof BodyWaterMassRecord) {
            return toPlatformBodyWaterMassRecord((BodyWaterMassRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof BoneMassRecord) {
            return toPlatformBoneMassRecord((BoneMassRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof CervicalMucusRecord) {
            return toPlatformCervicalMucusRecord((CervicalMucusRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof CyclingPedalingCadenceRecord) {
            return toPlatformCyclingPedalingCadenceRecord((CyclingPedalingCadenceRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof DistanceRecord) {
            return toPlatformDistanceRecord((DistanceRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof ElevationGainedRecord) {
            return toPlatformElevationGainedRecord((ElevationGainedRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof ExerciseSessionRecord) {
            return toPlatformExerciseSessionRecord((ExerciseSessionRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof FloorsClimbedRecord) {
            return toPlatformFloorsClimbedRecord((FloorsClimbedRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof HeartRateRecord) {
            return toPlatformHeartRateRecord((HeartRateRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof HeartRateVariabilityRmssdRecord) {
            return toPlatformHeartRateVariabilityRmssdRecord((HeartRateVariabilityRmssdRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof HeightRecord) {
            return toPlatformHeightRecord((HeightRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof HydrationRecord) {
            return toPlatformHydrationRecord((HydrationRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof IntermenstrualBleedingRecord) {
            return toPlatformIntermenstrualBleedingRecord((IntermenstrualBleedingRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof LeanBodyMassRecord) {
            return toPlatformLeanBodyMassRecord((LeanBodyMassRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof MenstruationFlowRecord) {
            return toPlatformMenstruationFlowRecord((MenstruationFlowRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof MenstruationPeriodRecord) {
            return toPlatformMenstruationPeriodRecord((MenstruationPeriodRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof NutritionRecord) {
            return toPlatformNutritionRecord((NutritionRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof OvulationTestRecord) {
            return toPlatformOvulationTestRecord((OvulationTestRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof OxygenSaturationRecord) {
            return toPlatformOxygenSaturationRecord((OxygenSaturationRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof PowerRecord) {
            return toPlatformPowerRecord((PowerRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof RespiratoryRateRecord) {
            return toPlatformRespiratoryRateRecord((RespiratoryRateRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof RestingHeartRateRecord) {
            return toPlatformRestingHeartRateRecord((RestingHeartRateRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof SexualActivityRecord) {
            return toPlatformSexualActivityRecord((SexualActivityRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof SleepSessionRecord) {
            return toPlatformSleepSessionRecord((SleepSessionRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof SpeedRecord) {
            return toPlatformSpeedRecord((SpeedRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof StepsCadenceRecord) {
            return toPlatformStepsCadenceRecord((StepsCadenceRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof StepsRecord) {
            return toPlatformStepsRecord((StepsRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof TotalCaloriesBurnedRecord) {
            return toPlatformTotalCaloriesBurnedRecord((TotalCaloriesBurnedRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof Vo2MaxRecord) {
            return toPlatformVo2MaxRecord((Vo2MaxRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof WeightRecord) {
            return toPlatformWeightRecord((WeightRecord) $this$toPlatformRecord);
        }
        if ($this$toPlatformRecord instanceof WheelchairPushesRecord) {
            return toPlatformWheelchairPushesRecord((WheelchairPushesRecord) $this$toPlatformRecord);
        }
        throw new IllegalArgumentException("Unsupported record " + $this$toPlatformRecord);
    }

    private static final Record toPlatformRecordExt13(androidx.health.connect.client.records.Record $this$toPlatformRecordExt13) {
        if (!UtilsKt.isAtLeastSdkExtension13()) {
            return null;
        }
        if ($this$toPlatformRecordExt13 instanceof PlannedExerciseSessionRecord) {
            return toPlatformPlannedExerciseSessionRecord((PlannedExerciseSessionRecord) $this$toPlatformRecordExt13);
        }
        if ($this$toPlatformRecordExt13 instanceof SkinTemperatureRecord) {
            return toPlatformSkinTemperatureRecord((SkinTemperatureRecord) $this$toPlatformRecordExt13);
        }
        return null;
    }

    public static final androidx.health.connect.client.records.Record toSdkRecord(Record $this$toSdkRecord) {
        Intrinsics.checkNotNullParameter($this$toSdkRecord, "<this>");
        androidx.health.connect.client.records.Record sdkRecordExt13 = toSdkRecordExt13($this$toSdkRecord);
        if (sdkRecordExt13 != null) {
            return sdkRecordExt13;
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.ActiveCaloriesBurnedRecord) {
            return toSdkActiveCaloriesBurnedRecord((android.health.connect.datatypes.ActiveCaloriesBurnedRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.BasalBodyTemperatureRecord) {
            return toSdkBasalBodyTemperatureRecord((android.health.connect.datatypes.BasalBodyTemperatureRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.BasalMetabolicRateRecord) {
            return toSdkBasalMetabolicRateRecord((android.health.connect.datatypes.BasalMetabolicRateRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.BloodGlucoseRecord) {
            return toSdkBloodGlucoseRecord((android.health.connect.datatypes.BloodGlucoseRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.BloodPressureRecord) {
            return toSdkBloodPressureRecord((android.health.connect.datatypes.BloodPressureRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.BodyFatRecord) {
            return toSdkBodyFatRecord((android.health.connect.datatypes.BodyFatRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.BodyTemperatureRecord) {
            return toSdkBodyTemperatureRecord((android.health.connect.datatypes.BodyTemperatureRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.BodyWaterMassRecord) {
            return toSdkBodyWaterMassRecord((android.health.connect.datatypes.BodyWaterMassRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.BoneMassRecord) {
            return toSdkBoneMassRecord((android.health.connect.datatypes.BoneMassRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.CervicalMucusRecord) {
            return toSdkCervicalMucusRecord((android.health.connect.datatypes.CervicalMucusRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.CyclingPedalingCadenceRecord) {
            return toSdkCyclingPedalingCadenceRecord((android.health.connect.datatypes.CyclingPedalingCadenceRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.DistanceRecord) {
            return toSdkDistanceRecord((android.health.connect.datatypes.DistanceRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.ElevationGainedRecord) {
            return toSdkElevationGainedRecord((android.health.connect.datatypes.ElevationGainedRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.ExerciseSessionRecord) {
            return toSdkExerciseSessionRecord((android.health.connect.datatypes.ExerciseSessionRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.FloorsClimbedRecord) {
            return toSdkFloorsClimbedRecord((android.health.connect.datatypes.FloorsClimbedRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.HeartRateRecord) {
            return toSdkHeartRateRecord((android.health.connect.datatypes.HeartRateRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.HeartRateVariabilityRmssdRecord) {
            return toSdkHeartRateVariabilityRmssdRecord((android.health.connect.datatypes.HeartRateVariabilityRmssdRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.HeightRecord) {
            return toSdkHeightRecord((android.health.connect.datatypes.HeightRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.HydrationRecord) {
            return toSdkHydrationRecord((android.health.connect.datatypes.HydrationRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.IntermenstrualBleedingRecord) {
            return toSdkIntermenstrualBleedingRecord((android.health.connect.datatypes.IntermenstrualBleedingRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.LeanBodyMassRecord) {
            return toSdkLeanBodyMassRecord((android.health.connect.datatypes.LeanBodyMassRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.MenstruationFlowRecord) {
            return toSdkMenstruationFlowRecord((android.health.connect.datatypes.MenstruationFlowRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.MenstruationPeriodRecord) {
            return toSdkMenstruationPeriodRecord((android.health.connect.datatypes.MenstruationPeriodRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.NutritionRecord) {
            return toSdkNutritionRecord((android.health.connect.datatypes.NutritionRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.OvulationTestRecord) {
            return toSdkOvulationTestRecord((android.health.connect.datatypes.OvulationTestRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.OxygenSaturationRecord) {
            return toSdkOxygenSaturationRecord((android.health.connect.datatypes.OxygenSaturationRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.PowerRecord) {
            return toSdkPowerRecord((android.health.connect.datatypes.PowerRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.RespiratoryRateRecord) {
            return toSdkRespiratoryRateRecord((android.health.connect.datatypes.RespiratoryRateRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.RestingHeartRateRecord) {
            return toSdkRestingHeartRateRecord((android.health.connect.datatypes.RestingHeartRateRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.SexualActivityRecord) {
            return toSdkSexualActivityRecord((android.health.connect.datatypes.SexualActivityRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.SleepSessionRecord) {
            return toSdkSleepSessionRecord((android.health.connect.datatypes.SleepSessionRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.SpeedRecord) {
            return toSdkSpeedRecord((android.health.connect.datatypes.SpeedRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.StepsCadenceRecord) {
            return toSdkStepsCadenceRecord((android.health.connect.datatypes.StepsCadenceRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.StepsRecord) {
            return toSdkStepsRecord((android.health.connect.datatypes.StepsRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.TotalCaloriesBurnedRecord) {
            return toSdkTotalCaloriesBurnedRecord((android.health.connect.datatypes.TotalCaloriesBurnedRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.Vo2MaxRecord) {
            return toSdkVo2MaxRecord((android.health.connect.datatypes.Vo2MaxRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.WeightRecord) {
            return toSdkWeightRecord((android.health.connect.datatypes.WeightRecord) $this$toSdkRecord);
        }
        if ($this$toSdkRecord instanceof android.health.connect.datatypes.WheelchairPushesRecord) {
            return toWheelchairPushesRecord((android.health.connect.datatypes.WheelchairPushesRecord) $this$toSdkRecord);
        }
        throw new IllegalArgumentException("Unsupported record " + $this$toSdkRecord);
    }

    private static final androidx.health.connect.client.records.Record toSdkRecordExt13(Record $this$toSdkRecordExt13) {
        if (!UtilsKt.isAtLeastSdkExtension13()) {
            return null;
        }
        if ($this$toSdkRecordExt13 instanceof android.health.connect.datatypes.PlannedExerciseSessionRecord) {
            return toSdkPlannedExerciseSessionRecord((android.health.connect.datatypes.PlannedExerciseSessionRecord) $this$toSdkRecordExt13);
        }
        if ($this$toSdkRecordExt13 instanceof android.health.connect.datatypes.SkinTemperatureRecord) {
            return toSdkSkinTemperatureRecord((android.health.connect.datatypes.SkinTemperatureRecord) $this$toSdkRecordExt13);
        }
        return null;
    }

    private static final ActiveCaloriesBurnedRecord toSdkActiveCaloriesBurnedRecord(android.health.connect.datatypes.ActiveCaloriesBurnedRecord $this$toSdkActiveCaloriesBurnedRecord) {
        Instant startTime = $this$toSdkActiveCaloriesBurnedRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = $this$toSdkActiveCaloriesBurnedRecord.getStartZoneOffset();
        Instant endTime = $this$toSdkActiveCaloriesBurnedRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = $this$toSdkActiveCaloriesBurnedRecord.getEndZoneOffset();
        Energy energy = $this$toSdkActiveCaloriesBurnedRecord.getEnergy();
        Intrinsics.checkNotNullExpressionValue(energy, "energy");
        androidx.health.connect.client.units.Energy sdkEnergy = UnitConvertersKt.toSdkEnergy(energy);
        android.health.connect.datatypes.Metadata metadata = $this$toSdkActiveCaloriesBurnedRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new ActiveCaloriesBurnedRecord(startTime, startZoneOffset, endTime, endZoneOffset, sdkEnergy, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final BasalBodyTemperatureRecord toSdkBasalBodyTemperatureRecord(android.health.connect.datatypes.BasalBodyTemperatureRecord $this$toSdkBasalBodyTemperatureRecord) {
        Instant time = $this$toSdkBasalBodyTemperatureRecord.getTime();
        ZoneOffset zoneOffset = $this$toSdkBasalBodyTemperatureRecord.getZoneOffset();
        Temperature temperature = $this$toSdkBasalBodyTemperatureRecord.getTemperature();
        Intrinsics.checkNotNullExpressionValue(temperature, "temperature");
        androidx.health.connect.client.units.Temperature sdkTemperature = UnitConvertersKt.toSdkTemperature(temperature);
        int measurementLocation = $this$toSdkBasalBodyTemperatureRecord.getMeasurementLocation();
        android.health.connect.datatypes.Metadata metadata = $this$toSdkBasalBodyTemperatureRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        Intrinsics.checkNotNullExpressionValue(time, "time");
        return new BasalBodyTemperatureRecord(time, zoneOffset, sdkMetadata, sdkTemperature, measurementLocation);
    }

    private static final BasalMetabolicRateRecord toSdkBasalMetabolicRateRecord(android.health.connect.datatypes.BasalMetabolicRateRecord $this$toSdkBasalMetabolicRateRecord) {
        Instant time = $this$toSdkBasalMetabolicRateRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = $this$toSdkBasalMetabolicRateRecord.getZoneOffset();
        Power basalMetabolicRate = $this$toSdkBasalMetabolicRateRecord.getBasalMetabolicRate();
        Intrinsics.checkNotNullExpressionValue(basalMetabolicRate, "basalMetabolicRate");
        androidx.health.connect.client.units.Power sdkPower = UnitConvertersKt.toSdkPower(basalMetabolicRate);
        android.health.connect.datatypes.Metadata metadata = $this$toSdkBasalMetabolicRateRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new BasalMetabolicRateRecord(time, zoneOffset, sdkPower, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final BloodGlucoseRecord toSdkBloodGlucoseRecord(android.health.connect.datatypes.BloodGlucoseRecord $this$toSdkBloodGlucoseRecord) {
        Instant time = $this$toSdkBloodGlucoseRecord.getTime();
        ZoneOffset zoneOffset = $this$toSdkBloodGlucoseRecord.getZoneOffset();
        BloodGlucose level = $this$toSdkBloodGlucoseRecord.getLevel();
        Intrinsics.checkNotNullExpressionValue(level, "level");
        androidx.health.connect.client.units.BloodGlucose sdkBloodGlucose = UnitConvertersKt.toSdkBloodGlucose(level);
        int sdkBloodGlucoseSpecimenSource = IntDefMappingsKt.toSdkBloodGlucoseSpecimenSource($this$toSdkBloodGlucoseRecord.getSpecimenSource());
        int sdkMealType = IntDefMappingsKt.toSdkMealType($this$toSdkBloodGlucoseRecord.getMealType());
        int sdkRelationToMeal = IntDefMappingsKt.toSdkRelationToMeal($this$toSdkBloodGlucoseRecord.getRelationToMeal());
        android.health.connect.datatypes.Metadata metadata = $this$toSdkBloodGlucoseRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        Intrinsics.checkNotNullExpressionValue(time, "time");
        return new BloodGlucoseRecord(time, zoneOffset, sdkMetadata, sdkBloodGlucose, sdkBloodGlucoseSpecimenSource, sdkMealType, sdkRelationToMeal);
    }

    private static final BloodPressureRecord toSdkBloodPressureRecord(android.health.connect.datatypes.BloodPressureRecord $this$toSdkBloodPressureRecord) {
        Instant time = $this$toSdkBloodPressureRecord.getTime();
        ZoneOffset zoneOffset = $this$toSdkBloodPressureRecord.getZoneOffset();
        Pressure systolic = $this$toSdkBloodPressureRecord.getSystolic();
        Intrinsics.checkNotNullExpressionValue(systolic, "systolic");
        androidx.health.connect.client.units.Pressure sdkPressure = UnitConvertersKt.toSdkPressure(systolic);
        Pressure diastolic = $this$toSdkBloodPressureRecord.getDiastolic();
        Intrinsics.checkNotNullExpressionValue(diastolic, "diastolic");
        androidx.health.connect.client.units.Pressure sdkPressure2 = UnitConvertersKt.toSdkPressure(diastolic);
        int sdkBloodPressureBodyPosition = IntDefMappingsKt.toSdkBloodPressureBodyPosition($this$toSdkBloodPressureRecord.getBodyPosition());
        int sdkBloodPressureMeasurementLocation = IntDefMappingsKt.toSdkBloodPressureMeasurementLocation($this$toSdkBloodPressureRecord.getMeasurementLocation());
        android.health.connect.datatypes.Metadata metadata = $this$toSdkBloodPressureRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        Intrinsics.checkNotNullExpressionValue(time, "time");
        return new BloodPressureRecord(time, zoneOffset, sdkMetadata, sdkPressure, sdkPressure2, sdkBloodPressureBodyPosition, sdkBloodPressureMeasurementLocation);
    }

    private static final BodyFatRecord toSdkBodyFatRecord(android.health.connect.datatypes.BodyFatRecord $this$toSdkBodyFatRecord) {
        Instant time = $this$toSdkBodyFatRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = $this$toSdkBodyFatRecord.getZoneOffset();
        Percentage percentage = $this$toSdkBodyFatRecord.getPercentage();
        Intrinsics.checkNotNullExpressionValue(percentage, "percentage");
        androidx.health.connect.client.units.Percentage sdkPercentage = UnitConvertersKt.toSdkPercentage(percentage);
        android.health.connect.datatypes.Metadata metadata = $this$toSdkBodyFatRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new BodyFatRecord(time, zoneOffset, sdkPercentage, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final BodyTemperatureRecord toSdkBodyTemperatureRecord(android.health.connect.datatypes.BodyTemperatureRecord $this$toSdkBodyTemperatureRecord) {
        Instant time = $this$toSdkBodyTemperatureRecord.getTime();
        ZoneOffset zoneOffset = $this$toSdkBodyTemperatureRecord.getZoneOffset();
        Temperature temperature = $this$toSdkBodyTemperatureRecord.getTemperature();
        Intrinsics.checkNotNullExpressionValue(temperature, "temperature");
        androidx.health.connect.client.units.Temperature sdkTemperature = UnitConvertersKt.toSdkTemperature(temperature);
        int sdkBodyTemperatureMeasurementLocation = IntDefMappingsKt.toSdkBodyTemperatureMeasurementLocation($this$toSdkBodyTemperatureRecord.getMeasurementLocation());
        android.health.connect.datatypes.Metadata metadata = $this$toSdkBodyTemperatureRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        Intrinsics.checkNotNullExpressionValue(time, "time");
        return new BodyTemperatureRecord(time, zoneOffset, sdkMetadata, sdkTemperature, sdkBodyTemperatureMeasurementLocation);
    }

    private static final BodyWaterMassRecord toSdkBodyWaterMassRecord(android.health.connect.datatypes.BodyWaterMassRecord $this$toSdkBodyWaterMassRecord) {
        Instant time = $this$toSdkBodyWaterMassRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = $this$toSdkBodyWaterMassRecord.getZoneOffset();
        Mass bodyWaterMass = $this$toSdkBodyWaterMassRecord.getBodyWaterMass();
        Intrinsics.checkNotNullExpressionValue(bodyWaterMass, "bodyWaterMass");
        androidx.health.connect.client.units.Mass sdkMass = UnitConvertersKt.toSdkMass(bodyWaterMass);
        android.health.connect.datatypes.Metadata metadata = $this$toSdkBodyWaterMassRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new BodyWaterMassRecord(time, zoneOffset, sdkMass, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final BoneMassRecord toSdkBoneMassRecord(android.health.connect.datatypes.BoneMassRecord $this$toSdkBoneMassRecord) {
        Instant time = $this$toSdkBoneMassRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = $this$toSdkBoneMassRecord.getZoneOffset();
        Mass mass = $this$toSdkBoneMassRecord.getMass();
        Intrinsics.checkNotNullExpressionValue(mass, "mass");
        androidx.health.connect.client.units.Mass sdkMass = UnitConvertersKt.toSdkMass(mass);
        android.health.connect.datatypes.Metadata metadata = $this$toSdkBoneMassRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new BoneMassRecord(time, zoneOffset, sdkMass, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final CervicalMucusRecord toSdkCervicalMucusRecord(android.health.connect.datatypes.CervicalMucusRecord $this$toSdkCervicalMucusRecord) {
        Instant time = $this$toSdkCervicalMucusRecord.getTime();
        ZoneOffset zoneOffset = $this$toSdkCervicalMucusRecord.getZoneOffset();
        int sdkCervicalMucusAppearance = IntDefMappingsKt.toSdkCervicalMucusAppearance($this$toSdkCervicalMucusRecord.getAppearance());
        int sdkCervicalMucusSensation = IntDefMappingsKt.toSdkCervicalMucusSensation($this$toSdkCervicalMucusRecord.getSensation());
        android.health.connect.datatypes.Metadata metadata = $this$toSdkCervicalMucusRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        Intrinsics.checkNotNullExpressionValue(time, "time");
        return new CervicalMucusRecord(time, zoneOffset, sdkMetadata, sdkCervicalMucusAppearance, sdkCervicalMucusSensation);
    }

    private static final CyclingPedalingCadenceRecord toSdkCyclingPedalingCadenceRecord(android.health.connect.datatypes.CyclingPedalingCadenceRecord $this$toSdkCyclingPedalingCadenceRecord) {
        Instant startTime = $this$toSdkCyclingPedalingCadenceRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = $this$toSdkCyclingPedalingCadenceRecord.getStartZoneOffset();
        Instant endTime = $this$toSdkCyclingPedalingCadenceRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = $this$toSdkCyclingPedalingCadenceRecord.getEndZoneOffset();
        Iterable samples = $this$toSdkCyclingPedalingCadenceRecord.getSamples();
        Intrinsics.checkNotNullExpressionValue(samples, "samples");
        Iterable $this$map$iv = samples;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            CyclingPedalingCadenceRecord.CyclingPedalingCadenceRecordSample it = (CyclingPedalingCadenceRecord.CyclingPedalingCadenceRecordSample) item$iv$iv;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            destination$iv$iv.add(toSdkCyclingPedalingCadenceSample(it));
        }
        Iterable $this$sortedBy$iv = (List) destination$iv$iv;
        List sortedWith = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkCyclingPedalingCadenceRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                CyclingPedalingCadenceRecord.Sample it2 = (CyclingPedalingCadenceRecord.Sample) t;
                CyclingPedalingCadenceRecord.Sample it3 = (CyclingPedalingCadenceRecord.Sample) t2;
                return ComparisonsKt.compareValues(it2.getTime(), it3.getTime());
            }
        });
        android.health.connect.datatypes.Metadata metadata = $this$toSdkCyclingPedalingCadenceRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new androidx.health.connect.client.records.CyclingPedalingCadenceRecord(startTime, startZoneOffset, endTime, endZoneOffset, sortedWith, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final DistanceRecord toSdkDistanceRecord(android.health.connect.datatypes.DistanceRecord $this$toSdkDistanceRecord) {
        Instant startTime = $this$toSdkDistanceRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = $this$toSdkDistanceRecord.getStartZoneOffset();
        Instant endTime = $this$toSdkDistanceRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = $this$toSdkDistanceRecord.getEndZoneOffset();
        Length distance = $this$toSdkDistanceRecord.getDistance();
        Intrinsics.checkNotNullExpressionValue(distance, "distance");
        androidx.health.connect.client.units.Length sdkLength = UnitConvertersKt.toSdkLength(distance);
        android.health.connect.datatypes.Metadata metadata = $this$toSdkDistanceRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new DistanceRecord(startTime, startZoneOffset, endTime, endZoneOffset, sdkLength, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final ElevationGainedRecord toSdkElevationGainedRecord(android.health.connect.datatypes.ElevationGainedRecord $this$toSdkElevationGainedRecord) {
        Instant startTime = $this$toSdkElevationGainedRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = $this$toSdkElevationGainedRecord.getStartZoneOffset();
        Instant endTime = $this$toSdkElevationGainedRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = $this$toSdkElevationGainedRecord.getEndZoneOffset();
        Length elevation = $this$toSdkElevationGainedRecord.getElevation();
        Intrinsics.checkNotNullExpressionValue(elevation, "elevation");
        androidx.health.connect.client.units.Length sdkLength = UnitConvertersKt.toSdkLength(elevation);
        android.health.connect.datatypes.Metadata metadata = $this$toSdkElevationGainedRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new ElevationGainedRecord(startTime, startZoneOffset, endTime, endZoneOffset, sdkLength, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final ExerciseSessionRecord toSdkExerciseSessionRecord(android.health.connect.datatypes.ExerciseSessionRecord $this$toSdkExerciseSessionRecord) {
        Instant startTime = $this$toSdkExerciseSessionRecord.getStartTime();
        ZoneOffset startZoneOffset = $this$toSdkExerciseSessionRecord.getStartZoneOffset();
        Instant endTime = $this$toSdkExerciseSessionRecord.getEndTime();
        ZoneOffset endZoneOffset = $this$toSdkExerciseSessionRecord.getEndZoneOffset();
        int sdkExerciseSessionType = IntDefMappingsKt.toSdkExerciseSessionType($this$toSdkExerciseSessionRecord.getExerciseType());
        CharSequence title = $this$toSdkExerciseSessionRecord.getTitle();
        String obj = title != null ? title.toString() : null;
        CharSequence notes = $this$toSdkExerciseSessionRecord.getNotes();
        String obj2 = notes != null ? notes.toString() : null;
        Iterable laps = $this$toSdkExerciseSessionRecord.getLaps();
        Intrinsics.checkNotNullExpressionValue(laps, "laps");
        Iterable $this$map$iv = laps;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ExerciseLap it = (ExerciseLap) item$iv$iv;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            destination$iv$iv.add(toSdkExerciseLap(it));
        }
        Iterable $this$sortedBy$iv = (List) destination$iv$iv;
        List sortedWith = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkExerciseSessionRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                androidx.health.connect.client.records.ExerciseLap it2 = (androidx.health.connect.client.records.ExerciseLap) t;
                androidx.health.connect.client.records.ExerciseLap it3 = (androidx.health.connect.client.records.ExerciseLap) t2;
                return ComparisonsKt.compareValues(it2.getStartTime(), it3.getStartTime());
            }
        });
        Iterable segments = $this$toSdkExerciseSessionRecord.getSegments();
        Intrinsics.checkNotNullExpressionValue(segments, "segments");
        Iterable $this$map$iv2 = segments;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            Iterable $this$map$iv3 = $this$map$iv2;
            ExerciseSegment it2 = (ExerciseSegment) item$iv$iv2;
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            destination$iv$iv2.add(toSdkExerciseSegment(it2));
            $this$map$iv2 = $this$map$iv3;
        }
        Iterable $this$sortedBy$iv2 = (List) destination$iv$iv2;
        List sortedWith2 = CollectionsKt.sortedWith($this$sortedBy$iv2, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkExerciseSessionRecord$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                androidx.health.connect.client.records.ExerciseSegment it3 = (androidx.health.connect.client.records.ExerciseSegment) t;
                androidx.health.connect.client.records.ExerciseSegment it4 = (androidx.health.connect.client.records.ExerciseSegment) t2;
                return ComparisonsKt.compareValues(it3.getStartTime(), it4.getStartTime());
            }
        });
        android.health.connect.datatypes.Metadata metadata = $this$toSdkExerciseSessionRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        ExerciseRoute it3 = $this$toSdkExerciseSessionRecord.getRoute();
        ExerciseRouteResult data = it3 != null ? new ExerciseRouteResult.Data(toSdkExerciseRoute(it3)) : $this$toSdkExerciseSessionRecord.hasRoute() ? new ExerciseRouteResult.ConsentRequired() : new ExerciseRouteResult.NoData();
        String plannedExerciseSessionId = UtilsKt.isAtLeastSdkExtension13() ? $this$toSdkExerciseSessionRecord.getPlannedExerciseSessionId() : null;
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        return new ExerciseSessionRecord(startTime, startZoneOffset, endTime, endZoneOffset, sdkMetadata, sdkExerciseSessionType, obj, obj2, (List<androidx.health.connect.client.records.ExerciseSegment>) sortedWith2, (List<androidx.health.connect.client.records.ExerciseLap>) sortedWith, data, plannedExerciseSessionId);
    }

    private static final FloorsClimbedRecord toSdkFloorsClimbedRecord(android.health.connect.datatypes.FloorsClimbedRecord $this$toSdkFloorsClimbedRecord) {
        Instant startTime = $this$toSdkFloorsClimbedRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = $this$toSdkFloorsClimbedRecord.getStartZoneOffset();
        Instant endTime = $this$toSdkFloorsClimbedRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = $this$toSdkFloorsClimbedRecord.getEndZoneOffset();
        double floors = $this$toSdkFloorsClimbedRecord.getFloors();
        android.health.connect.datatypes.Metadata metadata = $this$toSdkFloorsClimbedRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new FloorsClimbedRecord(startTime, startZoneOffset, endTime, endZoneOffset, floors, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final HeartRateRecord toSdkHeartRateRecord(android.health.connect.datatypes.HeartRateRecord $this$toSdkHeartRateRecord) {
        Instant startTime = $this$toSdkHeartRateRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = $this$toSdkHeartRateRecord.getStartZoneOffset();
        Instant endTime = $this$toSdkHeartRateRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = $this$toSdkHeartRateRecord.getEndZoneOffset();
        Iterable samples = $this$toSdkHeartRateRecord.getSamples();
        Intrinsics.checkNotNullExpressionValue(samples, "samples");
        Iterable $this$map$iv = samples;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            HeartRateRecord.HeartRateSample it = (HeartRateRecord.HeartRateSample) item$iv$iv;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            destination$iv$iv.add(toSdkHeartRateSample(it));
        }
        Iterable $this$sortedBy$iv = (List) destination$iv$iv;
        List sortedWith = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkHeartRateRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                HeartRateRecord.Sample it2 = (HeartRateRecord.Sample) t;
                HeartRateRecord.Sample it3 = (HeartRateRecord.Sample) t2;
                return ComparisonsKt.compareValues(it2.getTime(), it3.getTime());
            }
        });
        android.health.connect.datatypes.Metadata metadata = $this$toSdkHeartRateRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new androidx.health.connect.client.records.HeartRateRecord(startTime, startZoneOffset, endTime, endZoneOffset, sortedWith, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final HeartRateVariabilityRmssdRecord toSdkHeartRateVariabilityRmssdRecord(android.health.connect.datatypes.HeartRateVariabilityRmssdRecord $this$toSdkHeartRateVariabilityRmssdRecord) {
        Instant time = $this$toSdkHeartRateVariabilityRmssdRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = $this$toSdkHeartRateVariabilityRmssdRecord.getZoneOffset();
        double heartRateVariabilityMillis = $this$toSdkHeartRateVariabilityRmssdRecord.getHeartRateVariabilityMillis();
        android.health.connect.datatypes.Metadata metadata = $this$toSdkHeartRateVariabilityRmssdRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new HeartRateVariabilityRmssdRecord(time, zoneOffset, heartRateVariabilityMillis, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final HeightRecord toSdkHeightRecord(android.health.connect.datatypes.HeightRecord $this$toSdkHeightRecord) {
        Instant time = $this$toSdkHeightRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = $this$toSdkHeightRecord.getZoneOffset();
        Length height = $this$toSdkHeightRecord.getHeight();
        Intrinsics.checkNotNullExpressionValue(height, "height");
        androidx.health.connect.client.units.Length sdkLength = UnitConvertersKt.toSdkLength(height);
        android.health.connect.datatypes.Metadata metadata = $this$toSdkHeightRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new HeightRecord(time, zoneOffset, sdkLength, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final HydrationRecord toSdkHydrationRecord(android.health.connect.datatypes.HydrationRecord $this$toSdkHydrationRecord) {
        Instant startTime = $this$toSdkHydrationRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = $this$toSdkHydrationRecord.getStartZoneOffset();
        Instant endTime = $this$toSdkHydrationRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = $this$toSdkHydrationRecord.getEndZoneOffset();
        Volume volume = $this$toSdkHydrationRecord.getVolume();
        Intrinsics.checkNotNullExpressionValue(volume, "volume");
        androidx.health.connect.client.units.Volume sdkVolume = UnitConvertersKt.toSdkVolume(volume);
        android.health.connect.datatypes.Metadata metadata = $this$toSdkHydrationRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new HydrationRecord(startTime, startZoneOffset, endTime, endZoneOffset, sdkVolume, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final IntermenstrualBleedingRecord toSdkIntermenstrualBleedingRecord(android.health.connect.datatypes.IntermenstrualBleedingRecord $this$toSdkIntermenstrualBleedingRecord) {
        Instant time = $this$toSdkIntermenstrualBleedingRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = $this$toSdkIntermenstrualBleedingRecord.getZoneOffset();
        android.health.connect.datatypes.Metadata metadata = $this$toSdkIntermenstrualBleedingRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new IntermenstrualBleedingRecord(time, zoneOffset, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final LeanBodyMassRecord toSdkLeanBodyMassRecord(android.health.connect.datatypes.LeanBodyMassRecord $this$toSdkLeanBodyMassRecord) {
        Instant time = $this$toSdkLeanBodyMassRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = $this$toSdkLeanBodyMassRecord.getZoneOffset();
        Mass mass = $this$toSdkLeanBodyMassRecord.getMass();
        Intrinsics.checkNotNullExpressionValue(mass, "mass");
        androidx.health.connect.client.units.Mass sdkMass = UnitConvertersKt.toSdkMass(mass);
        android.health.connect.datatypes.Metadata metadata = $this$toSdkLeanBodyMassRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new LeanBodyMassRecord(time, zoneOffset, sdkMass, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final MenstruationFlowRecord toSdkMenstruationFlowRecord(android.health.connect.datatypes.MenstruationFlowRecord $this$toSdkMenstruationFlowRecord) {
        Instant time = $this$toSdkMenstruationFlowRecord.getTime();
        ZoneOffset zoneOffset = $this$toSdkMenstruationFlowRecord.getZoneOffset();
        int sdkMenstruationFlow = IntDefMappingsKt.toSdkMenstruationFlow($this$toSdkMenstruationFlowRecord.getFlow());
        android.health.connect.datatypes.Metadata metadata = $this$toSdkMenstruationFlowRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        Intrinsics.checkNotNullExpressionValue(time, "time");
        return new MenstruationFlowRecord(time, zoneOffset, sdkMetadata, sdkMenstruationFlow);
    }

    private static final MenstruationPeriodRecord toSdkMenstruationPeriodRecord(android.health.connect.datatypes.MenstruationPeriodRecord $this$toSdkMenstruationPeriodRecord) {
        Instant startTime = $this$toSdkMenstruationPeriodRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = $this$toSdkMenstruationPeriodRecord.getStartZoneOffset();
        Instant endTime = $this$toSdkMenstruationPeriodRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = $this$toSdkMenstruationPeriodRecord.getEndZoneOffset();
        android.health.connect.datatypes.Metadata metadata = $this$toSdkMenstruationPeriodRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new MenstruationPeriodRecord(startTime, startZoneOffset, endTime, endZoneOffset, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final NutritionRecord toSdkNutritionRecord(android.health.connect.datatypes.NutritionRecord $this$toSdkNutritionRecord) {
        Instant startTime = $this$toSdkNutritionRecord.getStartTime();
        ZoneOffset startZoneOffset = $this$toSdkNutritionRecord.getStartZoneOffset();
        Instant endTime = $this$toSdkNutritionRecord.getEndTime();
        ZoneOffset endZoneOffset = $this$toSdkNutritionRecord.getEndZoneOffset();
        String mealName = $this$toSdkNutritionRecord.getMealName();
        int sdkMealType = IntDefMappingsKt.toSdkMealType($this$toSdkNutritionRecord.getMealType());
        android.health.connect.datatypes.Metadata metadata = $this$toSdkNutritionRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        Mass biotin = $this$toSdkNutritionRecord.getBiotin();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass = biotin != null ? UnitConvertersKt.toNonDefaultSdkMass(biotin) : null;
        Mass caffeine = $this$toSdkNutritionRecord.getCaffeine();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass2 = caffeine != null ? UnitConvertersKt.toNonDefaultSdkMass(caffeine) : null;
        Mass calcium = $this$toSdkNutritionRecord.getCalcium();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass3 = calcium != null ? UnitConvertersKt.toNonDefaultSdkMass(calcium) : null;
        Energy energy = $this$toSdkNutritionRecord.getEnergy();
        androidx.health.connect.client.units.Energy nonDefaultSdkEnergy = energy != null ? UnitConvertersKt.toNonDefaultSdkEnergy(energy) : null;
        Energy energyFromFat = $this$toSdkNutritionRecord.getEnergyFromFat();
        androidx.health.connect.client.units.Energy nonDefaultSdkEnergy2 = energyFromFat != null ? UnitConvertersKt.toNonDefaultSdkEnergy(energyFromFat) : null;
        Mass chloride = $this$toSdkNutritionRecord.getChloride();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass4 = chloride != null ? UnitConvertersKt.toNonDefaultSdkMass(chloride) : null;
        Mass cholesterol = $this$toSdkNutritionRecord.getCholesterol();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass5 = cholesterol != null ? UnitConvertersKt.toNonDefaultSdkMass(cholesterol) : null;
        Mass chromium = $this$toSdkNutritionRecord.getChromium();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass6 = chromium != null ? UnitConvertersKt.toNonDefaultSdkMass(chromium) : null;
        Mass copper = $this$toSdkNutritionRecord.getCopper();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass7 = copper != null ? UnitConvertersKt.toNonDefaultSdkMass(copper) : null;
        Mass dietaryFiber = $this$toSdkNutritionRecord.getDietaryFiber();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass8 = dietaryFiber != null ? UnitConvertersKt.toNonDefaultSdkMass(dietaryFiber) : null;
        Mass folate = $this$toSdkNutritionRecord.getFolate();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass9 = folate != null ? UnitConvertersKt.toNonDefaultSdkMass(folate) : null;
        Mass folicAcid = $this$toSdkNutritionRecord.getFolicAcid();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass10 = folicAcid != null ? UnitConvertersKt.toNonDefaultSdkMass(folicAcid) : null;
        Mass iodine = $this$toSdkNutritionRecord.getIodine();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass11 = iodine != null ? UnitConvertersKt.toNonDefaultSdkMass(iodine) : null;
        Mass iron = $this$toSdkNutritionRecord.getIron();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass12 = iron != null ? UnitConvertersKt.toNonDefaultSdkMass(iron) : null;
        Mass magnesium = $this$toSdkNutritionRecord.getMagnesium();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass13 = magnesium != null ? UnitConvertersKt.toNonDefaultSdkMass(magnesium) : null;
        Mass manganese = $this$toSdkNutritionRecord.getManganese();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass14 = manganese != null ? UnitConvertersKt.toNonDefaultSdkMass(manganese) : null;
        Mass molybdenum = $this$toSdkNutritionRecord.getMolybdenum();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass15 = molybdenum != null ? UnitConvertersKt.toNonDefaultSdkMass(molybdenum) : null;
        Mass monounsaturatedFat = $this$toSdkNutritionRecord.getMonounsaturatedFat();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass16 = monounsaturatedFat != null ? UnitConvertersKt.toNonDefaultSdkMass(monounsaturatedFat) : null;
        Mass niacin = $this$toSdkNutritionRecord.getNiacin();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass17 = niacin != null ? UnitConvertersKt.toNonDefaultSdkMass(niacin) : null;
        Mass pantothenicAcid = $this$toSdkNutritionRecord.getPantothenicAcid();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass18 = pantothenicAcid != null ? UnitConvertersKt.toNonDefaultSdkMass(pantothenicAcid) : null;
        Mass phosphorus = $this$toSdkNutritionRecord.getPhosphorus();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass19 = phosphorus != null ? UnitConvertersKt.toNonDefaultSdkMass(phosphorus) : null;
        Mass polyunsaturatedFat = $this$toSdkNutritionRecord.getPolyunsaturatedFat();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass20 = polyunsaturatedFat != null ? UnitConvertersKt.toNonDefaultSdkMass(polyunsaturatedFat) : null;
        Mass potassium = $this$toSdkNutritionRecord.getPotassium();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass21 = potassium != null ? UnitConvertersKt.toNonDefaultSdkMass(potassium) : null;
        Mass protein = $this$toSdkNutritionRecord.getProtein();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass22 = protein != null ? UnitConvertersKt.toNonDefaultSdkMass(protein) : null;
        Mass riboflavin = $this$toSdkNutritionRecord.getRiboflavin();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass23 = riboflavin != null ? UnitConvertersKt.toNonDefaultSdkMass(riboflavin) : null;
        Mass saturatedFat = $this$toSdkNutritionRecord.getSaturatedFat();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass24 = saturatedFat != null ? UnitConvertersKt.toNonDefaultSdkMass(saturatedFat) : null;
        Mass selenium = $this$toSdkNutritionRecord.getSelenium();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass25 = selenium != null ? UnitConvertersKt.toNonDefaultSdkMass(selenium) : null;
        Mass sodium = $this$toSdkNutritionRecord.getSodium();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass26 = sodium != null ? UnitConvertersKt.toNonDefaultSdkMass(sodium) : null;
        Mass sugar = $this$toSdkNutritionRecord.getSugar();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass27 = sugar != null ? UnitConvertersKt.toNonDefaultSdkMass(sugar) : null;
        Mass thiamin = $this$toSdkNutritionRecord.getThiamin();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass28 = thiamin != null ? UnitConvertersKt.toNonDefaultSdkMass(thiamin) : null;
        Mass totalCarbohydrate = $this$toSdkNutritionRecord.getTotalCarbohydrate();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass29 = totalCarbohydrate != null ? UnitConvertersKt.toNonDefaultSdkMass(totalCarbohydrate) : null;
        Mass totalFat = $this$toSdkNutritionRecord.getTotalFat();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass30 = totalFat != null ? UnitConvertersKt.toNonDefaultSdkMass(totalFat) : null;
        Mass transFat = $this$toSdkNutritionRecord.getTransFat();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass31 = transFat != null ? UnitConvertersKt.toNonDefaultSdkMass(transFat) : null;
        Mass unsaturatedFat = $this$toSdkNutritionRecord.getUnsaturatedFat();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass32 = unsaturatedFat != null ? UnitConvertersKt.toNonDefaultSdkMass(unsaturatedFat) : null;
        Mass vitaminA = $this$toSdkNutritionRecord.getVitaminA();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass33 = vitaminA != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminA) : null;
        Mass vitaminB12 = $this$toSdkNutritionRecord.getVitaminB12();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass34 = vitaminB12 != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminB12) : null;
        Mass vitaminB6 = $this$toSdkNutritionRecord.getVitaminB6();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass35 = vitaminB6 != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminB6) : null;
        Mass vitaminC = $this$toSdkNutritionRecord.getVitaminC();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass36 = vitaminC != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminC) : null;
        Mass vitaminD = $this$toSdkNutritionRecord.getVitaminD();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass37 = vitaminD != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminD) : null;
        Mass vitaminE = $this$toSdkNutritionRecord.getVitaminE();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass38 = vitaminE != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminE) : null;
        Mass vitaminK = $this$toSdkNutritionRecord.getVitaminK();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass39 = vitaminK != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminK) : null;
        Mass zinc = $this$toSdkNutritionRecord.getZinc();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass40 = zinc != null ? UnitConvertersKt.toNonDefaultSdkMass(zinc) : null;
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        return new NutritionRecord(startTime, startZoneOffset, endTime, endZoneOffset, sdkMetadata, nonDefaultSdkMass, nonDefaultSdkMass2, nonDefaultSdkMass3, nonDefaultSdkEnergy, nonDefaultSdkEnergy2, nonDefaultSdkMass4, nonDefaultSdkMass5, nonDefaultSdkMass6, nonDefaultSdkMass7, nonDefaultSdkMass8, nonDefaultSdkMass9, nonDefaultSdkMass10, nonDefaultSdkMass11, nonDefaultSdkMass12, nonDefaultSdkMass13, nonDefaultSdkMass14, nonDefaultSdkMass15, nonDefaultSdkMass16, nonDefaultSdkMass17, nonDefaultSdkMass18, nonDefaultSdkMass19, nonDefaultSdkMass20, nonDefaultSdkMass21, nonDefaultSdkMass22, nonDefaultSdkMass23, nonDefaultSdkMass24, nonDefaultSdkMass25, nonDefaultSdkMass26, nonDefaultSdkMass27, nonDefaultSdkMass28, nonDefaultSdkMass29, nonDefaultSdkMass30, nonDefaultSdkMass31, nonDefaultSdkMass32, nonDefaultSdkMass33, nonDefaultSdkMass34, nonDefaultSdkMass35, nonDefaultSdkMass36, nonDefaultSdkMass37, nonDefaultSdkMass38, nonDefaultSdkMass39, nonDefaultSdkMass40, mealName, sdkMealType);
    }

    private static final OvulationTestRecord toSdkOvulationTestRecord(android.health.connect.datatypes.OvulationTestRecord $this$toSdkOvulationTestRecord) {
        Instant time = $this$toSdkOvulationTestRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = $this$toSdkOvulationTestRecord.getZoneOffset();
        int sdkOvulationTestResult = IntDefMappingsKt.toSdkOvulationTestResult($this$toSdkOvulationTestRecord.getResult());
        android.health.connect.datatypes.Metadata metadata = $this$toSdkOvulationTestRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new OvulationTestRecord(time, zoneOffset, sdkOvulationTestResult, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final OxygenSaturationRecord toSdkOxygenSaturationRecord(android.health.connect.datatypes.OxygenSaturationRecord $this$toSdkOxygenSaturationRecord) {
        Instant time = $this$toSdkOxygenSaturationRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = $this$toSdkOxygenSaturationRecord.getZoneOffset();
        Percentage percentage = $this$toSdkOxygenSaturationRecord.getPercentage();
        Intrinsics.checkNotNullExpressionValue(percentage, "percentage");
        androidx.health.connect.client.units.Percentage sdkPercentage = UnitConvertersKt.toSdkPercentage(percentage);
        android.health.connect.datatypes.Metadata metadata = $this$toSdkOxygenSaturationRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new OxygenSaturationRecord(time, zoneOffset, sdkPercentage, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final PowerRecord toSdkPowerRecord(android.health.connect.datatypes.PowerRecord $this$toSdkPowerRecord) {
        Instant startTime = $this$toSdkPowerRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = $this$toSdkPowerRecord.getStartZoneOffset();
        Instant endTime = $this$toSdkPowerRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = $this$toSdkPowerRecord.getEndZoneOffset();
        Iterable samples = $this$toSdkPowerRecord.getSamples();
        Intrinsics.checkNotNullExpressionValue(samples, "samples");
        Iterable $this$map$iv = samples;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            PowerRecord.PowerRecordSample it = (PowerRecord.PowerRecordSample) item$iv$iv;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            destination$iv$iv.add(toSdkPowerRecordSample(it));
        }
        Iterable $this$sortedBy$iv = (List) destination$iv$iv;
        List sortedWith = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkPowerRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                PowerRecord.Sample it2 = (PowerRecord.Sample) t;
                PowerRecord.Sample it3 = (PowerRecord.Sample) t2;
                return ComparisonsKt.compareValues(it2.getTime(), it3.getTime());
            }
        });
        android.health.connect.datatypes.Metadata metadata = $this$toSdkPowerRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new androidx.health.connect.client.records.PowerRecord(startTime, startZoneOffset, endTime, endZoneOffset, sortedWith, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final RespiratoryRateRecord toSdkRespiratoryRateRecord(android.health.connect.datatypes.RespiratoryRateRecord $this$toSdkRespiratoryRateRecord) {
        Instant time = $this$toSdkRespiratoryRateRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = $this$toSdkRespiratoryRateRecord.getZoneOffset();
        double rate = $this$toSdkRespiratoryRateRecord.getRate();
        android.health.connect.datatypes.Metadata metadata = $this$toSdkRespiratoryRateRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new RespiratoryRateRecord(time, zoneOffset, rate, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final RestingHeartRateRecord toSdkRestingHeartRateRecord(android.health.connect.datatypes.RestingHeartRateRecord $this$toSdkRestingHeartRateRecord) {
        Instant time = $this$toSdkRestingHeartRateRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = $this$toSdkRestingHeartRateRecord.getZoneOffset();
        long beatsPerMinute = $this$toSdkRestingHeartRateRecord.getBeatsPerMinute();
        android.health.connect.datatypes.Metadata metadata = $this$toSdkRestingHeartRateRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new RestingHeartRateRecord(time, zoneOffset, beatsPerMinute, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final SexualActivityRecord toSdkSexualActivityRecord(android.health.connect.datatypes.SexualActivityRecord $this$toSdkSexualActivityRecord) {
        Instant time = $this$toSdkSexualActivityRecord.getTime();
        ZoneOffset zoneOffset = $this$toSdkSexualActivityRecord.getZoneOffset();
        int sdkProtectionUsed = IntDefMappingsKt.toSdkProtectionUsed($this$toSdkSexualActivityRecord.getProtectionUsed());
        android.health.connect.datatypes.Metadata metadata = $this$toSdkSexualActivityRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        Intrinsics.checkNotNullExpressionValue(time, "time");
        return new SexualActivityRecord(time, zoneOffset, sdkMetadata, sdkProtectionUsed);
    }

    private static final SleepSessionRecord toSdkSleepSessionRecord(android.health.connect.datatypes.SleepSessionRecord $this$toSdkSleepSessionRecord) {
        Instant startTime = $this$toSdkSleepSessionRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = $this$toSdkSleepSessionRecord.getStartZoneOffset();
        Instant endTime = $this$toSdkSleepSessionRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = $this$toSdkSleepSessionRecord.getEndZoneOffset();
        android.health.connect.datatypes.Metadata metadata = $this$toSdkSleepSessionRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        CharSequence title = $this$toSdkSleepSessionRecord.getTitle();
        String obj = title != null ? title.toString() : null;
        CharSequence notes = $this$toSdkSleepSessionRecord.getNotes();
        String obj2 = notes != null ? notes.toString() : null;
        Iterable stages = $this$toSdkSleepSessionRecord.getStages();
        Intrinsics.checkNotNullExpressionValue(stages, "stages");
        Iterable $this$map$iv = stages;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            SleepSessionRecord.Stage it = (SleepSessionRecord.Stage) item$iv$iv;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            destination$iv$iv.add(toSdkSleepSessionStage(it));
            $this$map$iv = $this$map$iv;
        }
        Iterable $this$sortedBy$iv = (List) destination$iv$iv;
        return new androidx.health.connect.client.records.SleepSessionRecord(startTime, startZoneOffset, endTime, endZoneOffset, sdkMetadata, obj, obj2, CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkSleepSessionRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                SleepSessionRecord.Stage it2 = (SleepSessionRecord.Stage) t;
                SleepSessionRecord.Stage it3 = (SleepSessionRecord.Stage) t2;
                return ComparisonsKt.compareValues(it2.getStartTime(), it3.getStartTime());
            }
        }));
    }

    private static final SkinTemperatureRecord toSdkSkinTemperatureRecord(android.health.connect.datatypes.SkinTemperatureRecord $this$toSdkSkinTemperatureRecord) {
        Instant startTime = $this$toSdkSkinTemperatureRecord.getStartTime();
        ZoneOffset startZoneOffset = $this$toSdkSkinTemperatureRecord.getStartZoneOffset();
        Instant endTime = $this$toSdkSkinTemperatureRecord.getEndTime();
        ZoneOffset endZoneOffset = $this$toSdkSkinTemperatureRecord.getEndZoneOffset();
        android.health.connect.datatypes.Metadata metadata = $this$toSdkSkinTemperatureRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        int sdkSkinTemperatureMeasurementLocation = IntDefMappingsKt.toSdkSkinTemperatureMeasurementLocation($this$toSdkSkinTemperatureRecord.getMeasurementLocation());
        Iterable deltas = $this$toSdkSkinTemperatureRecord.getDeltas();
        Intrinsics.checkNotNullExpressionValue(deltas, "deltas");
        Iterable $this$map$iv = deltas;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            SkinTemperatureRecord.Delta it = (SkinTemperatureRecord.Delta) item$iv$iv;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            destination$iv$iv.add(toSdkSkinTemperatureDelta(it));
        }
        ArrayList arrayList = (List) destination$iv$iv;
        Temperature baseline = $this$toSdkSkinTemperatureRecord.getBaseline();
        androidx.health.connect.client.units.Temperature sdkTemperature = baseline != null ? UnitConvertersKt.toSdkTemperature(baseline) : null;
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        return new androidx.health.connect.client.records.SkinTemperatureRecord(startTime, startZoneOffset, endTime, endZoneOffset, sdkMetadata, arrayList, sdkTemperature, sdkSkinTemperatureMeasurementLocation);
    }

    private static final SpeedRecord toSdkSpeedRecord(android.health.connect.datatypes.SpeedRecord $this$toSdkSpeedRecord) {
        Instant startTime = $this$toSdkSpeedRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = $this$toSdkSpeedRecord.getStartZoneOffset();
        Instant endTime = $this$toSdkSpeedRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = $this$toSdkSpeedRecord.getEndZoneOffset();
        Iterable samples = $this$toSdkSpeedRecord.getSamples();
        Intrinsics.checkNotNullExpressionValue(samples, "samples");
        Iterable $this$map$iv = samples;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            SpeedRecord.SpeedRecordSample it = (SpeedRecord.SpeedRecordSample) item$iv$iv;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            destination$iv$iv.add(toSdkSpeedSample(it));
        }
        Iterable $this$sortedBy$iv = (List) destination$iv$iv;
        List sortedWith = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkSpeedRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                SpeedRecord.Sample it2 = (SpeedRecord.Sample) t;
                SpeedRecord.Sample it3 = (SpeedRecord.Sample) t2;
                return ComparisonsKt.compareValues(it2.getTime(), it3.getTime());
            }
        });
        android.health.connect.datatypes.Metadata metadata = $this$toSdkSpeedRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new androidx.health.connect.client.records.SpeedRecord(startTime, startZoneOffset, endTime, endZoneOffset, sortedWith, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final StepsCadenceRecord toSdkStepsCadenceRecord(android.health.connect.datatypes.StepsCadenceRecord $this$toSdkStepsCadenceRecord) {
        Instant startTime = $this$toSdkStepsCadenceRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = $this$toSdkStepsCadenceRecord.getStartZoneOffset();
        Instant endTime = $this$toSdkStepsCadenceRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = $this$toSdkStepsCadenceRecord.getEndZoneOffset();
        Iterable samples = $this$toSdkStepsCadenceRecord.getSamples();
        Intrinsics.checkNotNullExpressionValue(samples, "samples");
        Iterable $this$map$iv = samples;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            StepsCadenceRecord.StepsCadenceRecordSample it = (StepsCadenceRecord.StepsCadenceRecordSample) item$iv$iv;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            destination$iv$iv.add(toSdkStepsCadenceSample(it));
        }
        Iterable $this$sortedBy$iv = (List) destination$iv$iv;
        List sortedWith = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkStepsCadenceRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                StepsCadenceRecord.Sample it2 = (StepsCadenceRecord.Sample) t;
                StepsCadenceRecord.Sample it3 = (StepsCadenceRecord.Sample) t2;
                return ComparisonsKt.compareValues(it2.getTime(), it3.getTime());
            }
        });
        android.health.connect.datatypes.Metadata metadata = $this$toSdkStepsCadenceRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new androidx.health.connect.client.records.StepsCadenceRecord(startTime, startZoneOffset, endTime, endZoneOffset, sortedWith, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final StepsRecord toSdkStepsRecord(android.health.connect.datatypes.StepsRecord $this$toSdkStepsRecord) {
        Instant startTime = $this$toSdkStepsRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = $this$toSdkStepsRecord.getStartZoneOffset();
        Instant endTime = $this$toSdkStepsRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = $this$toSdkStepsRecord.getEndZoneOffset();
        long count = $this$toSdkStepsRecord.getCount();
        android.health.connect.datatypes.Metadata metadata = $this$toSdkStepsRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new StepsRecord(startTime, startZoneOffset, endTime, endZoneOffset, count, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final TotalCaloriesBurnedRecord toSdkTotalCaloriesBurnedRecord(android.health.connect.datatypes.TotalCaloriesBurnedRecord $this$toSdkTotalCaloriesBurnedRecord) {
        Instant startTime = $this$toSdkTotalCaloriesBurnedRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = $this$toSdkTotalCaloriesBurnedRecord.getStartZoneOffset();
        Instant endTime = $this$toSdkTotalCaloriesBurnedRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = $this$toSdkTotalCaloriesBurnedRecord.getEndZoneOffset();
        Energy energy = $this$toSdkTotalCaloriesBurnedRecord.getEnergy();
        Intrinsics.checkNotNullExpressionValue(energy, "energy");
        androidx.health.connect.client.units.Energy sdkEnergy = UnitConvertersKt.toSdkEnergy(energy);
        android.health.connect.datatypes.Metadata metadata = $this$toSdkTotalCaloriesBurnedRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new TotalCaloriesBurnedRecord(startTime, startZoneOffset, endTime, endZoneOffset, sdkEnergy, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final Vo2MaxRecord toSdkVo2MaxRecord(android.health.connect.datatypes.Vo2MaxRecord $this$toSdkVo2MaxRecord) {
        Instant time = $this$toSdkVo2MaxRecord.getTime();
        ZoneOffset zoneOffset = $this$toSdkVo2MaxRecord.getZoneOffset();
        double vo2MillilitersPerMinuteKilogram = $this$toSdkVo2MaxRecord.getVo2MillilitersPerMinuteKilogram();
        int sdkVo2MaxMeasurementMethod = IntDefMappingsKt.toSdkVo2MaxMeasurementMethod($this$toSdkVo2MaxRecord.getMeasurementMethod());
        android.health.connect.datatypes.Metadata metadata = $this$toSdkVo2MaxRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        Intrinsics.checkNotNullExpressionValue(time, "time");
        return new Vo2MaxRecord(time, zoneOffset, sdkMetadata, vo2MillilitersPerMinuteKilogram, sdkVo2MaxMeasurementMethod);
    }

    private static final WeightRecord toSdkWeightRecord(android.health.connect.datatypes.WeightRecord $this$toSdkWeightRecord) {
        Instant time = $this$toSdkWeightRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = $this$toSdkWeightRecord.getZoneOffset();
        Mass weight = $this$toSdkWeightRecord.getWeight();
        Intrinsics.checkNotNullExpressionValue(weight, "weight");
        androidx.health.connect.client.units.Mass sdkMass = UnitConvertersKt.toSdkMass(weight);
        android.health.connect.datatypes.Metadata metadata = $this$toSdkWeightRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new WeightRecord(time, zoneOffset, sdkMass, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final WheelchairPushesRecord toWheelchairPushesRecord(android.health.connect.datatypes.WheelchairPushesRecord $this$toWheelchairPushesRecord) {
        Instant startTime = $this$toWheelchairPushesRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = $this$toWheelchairPushesRecord.getStartZoneOffset();
        Instant endTime = $this$toWheelchairPushesRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = $this$toWheelchairPushesRecord.getEndZoneOffset();
        long count = $this$toWheelchairPushesRecord.getCount();
        android.health.connect.datatypes.Metadata metadata = $this$toWheelchairPushesRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new WheelchairPushesRecord(startTime, startZoneOffset, endTime, endZoneOffset, count, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final android.health.connect.datatypes.ActiveCaloriesBurnedRecord toPlatformActiveCaloriesBurnedRecord(ActiveCaloriesBurnedRecord $this$toPlatformActiveCaloriesBurnedRecord) {
        ActiveCaloriesBurnedRecord.Builder $this$toPlatformActiveCaloriesBurnedRecord_u24lambda_u2420 = new ActiveCaloriesBurnedRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformActiveCaloriesBurnedRecord.getMetadata()), $this$toPlatformActiveCaloriesBurnedRecord.getStartTime(), $this$toPlatformActiveCaloriesBurnedRecord.getEndTime(), UnitConvertersKt.toPlatformEnergy($this$toPlatformActiveCaloriesBurnedRecord.getEnergy()));
        ZoneOffset it = $this$toPlatformActiveCaloriesBurnedRecord.getStartZoneOffset();
        if (it != null) {
            $this$toPlatformActiveCaloriesBurnedRecord_u24lambda_u2420.setStartZoneOffset(it);
        }
        ZoneOffset it2 = $this$toPlatformActiveCaloriesBurnedRecord.getEndZoneOffset();
        if (it2 != null) {
            $this$toPlatformActiveCaloriesBurnedRecord_u24lambda_u2420.setEndZoneOffset(it2);
        }
        android.health.connect.datatypes.ActiveCaloriesBurnedRecord build = $this$toPlatformActiveCaloriesBurnedRecord_u24lambda_u2420.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformActiveCaloriesBu…       }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.BasalBodyTemperatureRecord toPlatformBasalBodyTemperatureRecord(BasalBodyTemperatureRecord $this$toPlatformBasalBodyTemperatureRecord) {
        BasalBodyTemperatureRecord.Builder $this$toPlatformBasalBodyTemperatureRecord_u24lambda_u2422 = new BasalBodyTemperatureRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformBasalBodyTemperatureRecord.getMetadata()), $this$toPlatformBasalBodyTemperatureRecord.getTime(), IntDefMappingsKt.toPlatformBodyTemperatureMeasurementLocation($this$toPlatformBasalBodyTemperatureRecord.getMeasurementLocation()), UnitConvertersKt.toPlatformTemperature($this$toPlatformBasalBodyTemperatureRecord.getTemperature()));
        ZoneOffset it = $this$toPlatformBasalBodyTemperatureRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformBasalBodyTemperatureRecord_u24lambda_u2422.setZoneOffset(it);
        }
        android.health.connect.datatypes.BasalBodyTemperatureRecord build = $this$toPlatformBasalBodyTemperatureRecord_u24lambda_u2422.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformBasalBodyTempera…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.BasalMetabolicRateRecord toPlatformBasalMetabolicRateRecord(BasalMetabolicRateRecord $this$toPlatformBasalMetabolicRateRecord) {
        BasalMetabolicRateRecord.Builder $this$toPlatformBasalMetabolicRateRecord_u24lambda_u2424 = new BasalMetabolicRateRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformBasalMetabolicRateRecord.getMetadata()), $this$toPlatformBasalMetabolicRateRecord.getTime(), UnitConvertersKt.toPlatformPower($this$toPlatformBasalMetabolicRateRecord.getBasalMetabolicRate()));
        ZoneOffset it = $this$toPlatformBasalMetabolicRateRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformBasalMetabolicRateRecord_u24lambda_u2424.setZoneOffset(it);
        }
        android.health.connect.datatypes.BasalMetabolicRateRecord build = $this$toPlatformBasalMetabolicRateRecord_u24lambda_u2424.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformBasalMetabolicRa…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.BloodGlucoseRecord toPlatformBloodGlucoseRecord(BloodGlucoseRecord $this$toPlatformBloodGlucoseRecord) {
        BloodGlucoseRecord.Builder $this$toPlatformBloodGlucoseRecord_u24lambda_u2426 = new BloodGlucoseRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformBloodGlucoseRecord.getMetadata()), $this$toPlatformBloodGlucoseRecord.getTime(), IntDefMappingsKt.toPlatformBloodGlucoseSpecimenSource($this$toPlatformBloodGlucoseRecord.getSpecimenSource()), UnitConvertersKt.toPlatformBloodGlucose($this$toPlatformBloodGlucoseRecord.getLevel()), IntDefMappingsKt.toPlatformBloodGlucoseRelationToMeal($this$toPlatformBloodGlucoseRecord.getRelationToMeal()), IntDefMappingsKt.toPlatformMealType($this$toPlatformBloodGlucoseRecord.getMealType()));
        ZoneOffset it = $this$toPlatformBloodGlucoseRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformBloodGlucoseRecord_u24lambda_u2426.setZoneOffset(it);
        }
        android.health.connect.datatypes.BloodGlucoseRecord build = $this$toPlatformBloodGlucoseRecord_u24lambda_u2426.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformBloodGlucoseReco…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.BloodPressureRecord toPlatformBloodPressureRecord(BloodPressureRecord $this$toPlatformBloodPressureRecord) {
        BloodPressureRecord.Builder $this$toPlatformBloodPressureRecord_u24lambda_u2428 = new BloodPressureRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformBloodPressureRecord.getMetadata()), $this$toPlatformBloodPressureRecord.getTime(), IntDefMappingsKt.toPlatformBloodPressureMeasurementLocation($this$toPlatformBloodPressureRecord.getMeasurementLocation()), UnitConvertersKt.toPlatformPressure($this$toPlatformBloodPressureRecord.getSystolic()), UnitConvertersKt.toPlatformPressure($this$toPlatformBloodPressureRecord.getDiastolic()), IntDefMappingsKt.toPlatformBloodPressureBodyPosition($this$toPlatformBloodPressureRecord.getBodyPosition()));
        ZoneOffset it = $this$toPlatformBloodPressureRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformBloodPressureRecord_u24lambda_u2428.setZoneOffset(it);
        }
        android.health.connect.datatypes.BloodPressureRecord build = $this$toPlatformBloodPressureRecord_u24lambda_u2428.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformBloodPressureRec…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.BodyFatRecord toPlatformBodyFatRecord(BodyFatRecord $this$toPlatformBodyFatRecord) {
        BodyFatRecord.Builder $this$toPlatformBodyFatRecord_u24lambda_u2430 = new BodyFatRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformBodyFatRecord.getMetadata()), $this$toPlatformBodyFatRecord.getTime(), UnitConvertersKt.toPlatformPercentage($this$toPlatformBodyFatRecord.getPercentage()));
        ZoneOffset it = $this$toPlatformBodyFatRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformBodyFatRecord_u24lambda_u2430.setZoneOffset(it);
        }
        android.health.connect.datatypes.BodyFatRecord build = $this$toPlatformBodyFatRecord_u24lambda_u2430.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformBodyFatRecordBui…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.BodyTemperatureRecord toPlatformBodyTemperatureRecord(BodyTemperatureRecord $this$toPlatformBodyTemperatureRecord) {
        BodyTemperatureRecord.Builder $this$toPlatformBodyTemperatureRecord_u24lambda_u2432 = new BodyTemperatureRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformBodyTemperatureRecord.getMetadata()), $this$toPlatformBodyTemperatureRecord.getTime(), IntDefMappingsKt.toPlatformBodyTemperatureMeasurementLocation($this$toPlatformBodyTemperatureRecord.getMeasurementLocation()), UnitConvertersKt.toPlatformTemperature($this$toPlatformBodyTemperatureRecord.getTemperature()));
        ZoneOffset it = $this$toPlatformBodyTemperatureRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformBodyTemperatureRecord_u24lambda_u2432.setZoneOffset(it);
        }
        android.health.connect.datatypes.BodyTemperatureRecord build = $this$toPlatformBodyTemperatureRecord_u24lambda_u2432.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformBodyTemperatureR…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.BodyWaterMassRecord toPlatformBodyWaterMassRecord(BodyWaterMassRecord $this$toPlatformBodyWaterMassRecord) {
        BodyWaterMassRecord.Builder $this$toPlatformBodyWaterMassRecord_u24lambda_u2434 = new BodyWaterMassRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformBodyWaterMassRecord.getMetadata()), $this$toPlatformBodyWaterMassRecord.getTime(), UnitConvertersKt.toPlatformMass($this$toPlatformBodyWaterMassRecord.getMass()));
        ZoneOffset it = $this$toPlatformBodyWaterMassRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformBodyWaterMassRecord_u24lambda_u2434.setZoneOffset(it);
        }
        android.health.connect.datatypes.BodyWaterMassRecord build = $this$toPlatformBodyWaterMassRecord_u24lambda_u2434.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformBodyWaterMassRec…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.BoneMassRecord toPlatformBoneMassRecord(BoneMassRecord $this$toPlatformBoneMassRecord) {
        BoneMassRecord.Builder $this$toPlatformBoneMassRecord_u24lambda_u2436 = new BoneMassRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformBoneMassRecord.getMetadata()), $this$toPlatformBoneMassRecord.getTime(), UnitConvertersKt.toPlatformMass($this$toPlatformBoneMassRecord.getMass()));
        ZoneOffset it = $this$toPlatformBoneMassRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformBoneMassRecord_u24lambda_u2436.setZoneOffset(it);
        }
        android.health.connect.datatypes.BoneMassRecord build = $this$toPlatformBoneMassRecord_u24lambda_u2436.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformBoneMassRecordBu…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.CervicalMucusRecord toPlatformCervicalMucusRecord(CervicalMucusRecord $this$toPlatformCervicalMucusRecord) {
        CervicalMucusRecord.Builder $this$toPlatformCervicalMucusRecord_u24lambda_u2438 = new CervicalMucusRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformCervicalMucusRecord.getMetadata()), $this$toPlatformCervicalMucusRecord.getTime(), IntDefMappingsKt.toPlatformCervicalMucusSensation($this$toPlatformCervicalMucusRecord.getSensation()), IntDefMappingsKt.toPlatformCervicalMucusAppearance($this$toPlatformCervicalMucusRecord.getAppearance()));
        ZoneOffset it = $this$toPlatformCervicalMucusRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformCervicalMucusRecord_u24lambda_u2438.setZoneOffset(it);
        }
        android.health.connect.datatypes.CervicalMucusRecord build = $this$toPlatformCervicalMucusRecord_u24lambda_u2438.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformCervicalMucusRec…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.CyclingPedalingCadenceRecord toPlatformCyclingPedalingCadenceRecord(androidx.health.connect.client.records.CyclingPedalingCadenceRecord $this$toPlatformCyclingPedalingCadenceRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata($this$toPlatformCyclingPedalingCadenceRecord.getMetadata());
        Instant startTime = $this$toPlatformCyclingPedalingCadenceRecord.getStartTime();
        Instant endTime = $this$toPlatformCyclingPedalingCadenceRecord.getEndTime();
        Iterable $this$map$iv = $this$toPlatformCyclingPedalingCadenceRecord.getSamples();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(toPlatformCyclingPedalingCadenceSample((CyclingPedalingCadenceRecord.Sample) item$iv$iv));
        }
        CyclingPedalingCadenceRecord.Builder $this$toPlatformCyclingPedalingCadenceRecord_u24lambda_u2442 = new CyclingPedalingCadenceRecord.Builder(platformMetadata, startTime, endTime, (List) destination$iv$iv);
        ZoneOffset it = $this$toPlatformCyclingPedalingCadenceRecord.getStartZoneOffset();
        if (it != null) {
            $this$toPlatformCyclingPedalingCadenceRecord_u24lambda_u2442.setStartZoneOffset(it);
        }
        ZoneOffset it2 = $this$toPlatformCyclingPedalingCadenceRecord.getEndZoneOffset();
        if (it2 != null) {
            $this$toPlatformCyclingPedalingCadenceRecord_u24lambda_u2442.setEndZoneOffset(it2);
        }
        android.health.connect.datatypes.CyclingPedalingCadenceRecord build = $this$toPlatformCyclingPedalingCadenceRecord_u24lambda_u2442.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformCyclingPedalingC…       }\n        .build()");
        return build;
    }

    private static final CyclingPedalingCadenceRecord.CyclingPedalingCadenceRecordSample toPlatformCyclingPedalingCadenceSample(CyclingPedalingCadenceRecord.Sample $this$toPlatformCyclingPedalingCadenceSample) {
        return new CyclingPedalingCadenceRecord.CyclingPedalingCadenceRecordSample($this$toPlatformCyclingPedalingCadenceSample.getRevolutionsPerMinute(), $this$toPlatformCyclingPedalingCadenceSample.getTime());
    }

    private static final android.health.connect.datatypes.DistanceRecord toPlatformDistanceRecord(DistanceRecord $this$toPlatformDistanceRecord) {
        DistanceRecord.Builder $this$toPlatformDistanceRecord_u24lambda_u2445 = new DistanceRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformDistanceRecord.getMetadata()), $this$toPlatformDistanceRecord.getStartTime(), $this$toPlatformDistanceRecord.getEndTime(), UnitConvertersKt.toPlatformLength($this$toPlatformDistanceRecord.getDistance()));
        ZoneOffset it = $this$toPlatformDistanceRecord.getStartZoneOffset();
        if (it != null) {
            $this$toPlatformDistanceRecord_u24lambda_u2445.setStartZoneOffset(it);
        }
        ZoneOffset it2 = $this$toPlatformDistanceRecord.getEndZoneOffset();
        if (it2 != null) {
            $this$toPlatformDistanceRecord_u24lambda_u2445.setEndZoneOffset(it2);
        }
        android.health.connect.datatypes.DistanceRecord build = $this$toPlatformDistanceRecord_u24lambda_u2445.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformDistanceRecordBu…       }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.ElevationGainedRecord toPlatformElevationGainedRecord(ElevationGainedRecord $this$toPlatformElevationGainedRecord) {
        ElevationGainedRecord.Builder $this$toPlatformElevationGainedRecord_u24lambda_u2448 = new ElevationGainedRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformElevationGainedRecord.getMetadata()), $this$toPlatformElevationGainedRecord.getStartTime(), $this$toPlatformElevationGainedRecord.getEndTime(), UnitConvertersKt.toPlatformLength($this$toPlatformElevationGainedRecord.getElevation()));
        ZoneOffset it = $this$toPlatformElevationGainedRecord.getStartZoneOffset();
        if (it != null) {
            $this$toPlatformElevationGainedRecord_u24lambda_u2448.setStartZoneOffset(it);
        }
        ZoneOffset it2 = $this$toPlatformElevationGainedRecord.getEndZoneOffset();
        if (it2 != null) {
            $this$toPlatformElevationGainedRecord_u24lambda_u2448.setEndZoneOffset(it2);
        }
        android.health.connect.datatypes.ElevationGainedRecord build = $this$toPlatformElevationGainedRecord_u24lambda_u2448.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformElevationGainedR…       }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.ExerciseSessionRecord toPlatformExerciseSessionRecord(ExerciseSessionRecord $this$toPlatformExerciseSessionRecord) {
        ExerciseSessionRecord.Builder $this$toPlatformExerciseSessionRecord_u24lambda_u2456 = new ExerciseSessionRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformExerciseSessionRecord.getMetadata()), $this$toPlatformExerciseSessionRecord.getStartTime(), $this$toPlatformExerciseSessionRecord.getEndTime(), IntDefMappingsKt.toPlatformExerciseSessionType($this$toPlatformExerciseSessionRecord.getExerciseType()));
        ZoneOffset it = $this$toPlatformExerciseSessionRecord.getStartZoneOffset();
        if (it != null) {
            $this$toPlatformExerciseSessionRecord_u24lambda_u2456.setStartZoneOffset(it);
        }
        ZoneOffset it2 = $this$toPlatformExerciseSessionRecord.getEndZoneOffset();
        if (it2 != null) {
            $this$toPlatformExerciseSessionRecord_u24lambda_u2456.setEndZoneOffset(it2);
        }
        String it3 = $this$toPlatformExerciseSessionRecord.getNotes();
        if (it3 != null) {
            $this$toPlatformExerciseSessionRecord_u24lambda_u2456.setNotes(it3);
        }
        String it4 = $this$toPlatformExerciseSessionRecord.getTitle();
        if (it4 != null) {
            $this$toPlatformExerciseSessionRecord_u24lambda_u2456.setTitle(it4);
        }
        Iterable $this$map$iv = $this$toPlatformExerciseSessionRecord.getLaps();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(toPlatformExerciseLap((androidx.health.connect.client.records.ExerciseLap) item$iv$iv));
        }
        $this$toPlatformExerciseSessionRecord_u24lambda_u2456.setLaps((List) destination$iv$iv);
        Iterable $this$map$iv2 = $this$toPlatformExerciseSessionRecord.getSegments();
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            destination$iv$iv2.add(toPlatformExerciseSegment((androidx.health.connect.client.records.ExerciseSegment) item$iv$iv2));
        }
        $this$toPlatformExerciseSessionRecord_u24lambda_u2456.setSegments((List) destination$iv$iv2);
        if ($this$toPlatformExerciseSessionRecord.getExerciseRouteResult() instanceof ExerciseRouteResult.Data) {
            $this$toPlatformExerciseSessionRecord_u24lambda_u2456.setRoute(toPlatformExerciseRoute(((ExerciseRouteResult.Data) $this$toPlatformExerciseSessionRecord.getExerciseRouteResult()).getExerciseRoute()));
        }
        String it5 = $this$toPlatformExerciseSessionRecord.getPlannedExerciseSessionId();
        if (it5 != null) {
            $this$toPlatformExerciseSessionRecord_u24lambda_u2456.setPlannedExerciseSessionId(it5);
        }
        android.health.connect.datatypes.ExerciseSessionRecord build = $this$toPlatformExerciseSessionRecord_u24lambda_u2456.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformExerciseSessionR…       }\n        .build()");
        return build;
    }

    private static final ExerciseLap toPlatformExerciseLap(androidx.health.connect.client.records.ExerciseLap $this$toPlatformExerciseLap) {
        ExerciseLap.Builder $this$toPlatformExerciseLap_u24lambda_u2458 = new ExerciseLap.Builder($this$toPlatformExerciseLap.getStartTime(), $this$toPlatformExerciseLap.getEndTime());
        androidx.health.connect.client.units.Length it = $this$toPlatformExerciseLap.getLength();
        if (it != null) {
            $this$toPlatformExerciseLap_u24lambda_u2458.setLength(UnitConvertersKt.toPlatformLength(it));
        }
        ExerciseLap build = $this$toPlatformExerciseLap_u24lambda_u2458.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformExerciseLapBuild…h()) } }\n        .build()");
        return build;
    }

    private static final ExerciseRoute toPlatformExerciseRoute(androidx.health.connect.client.records.ExerciseRoute $this$toPlatformExerciseRoute) {
        Iterable $this$map$iv = $this$toPlatformExerciseRoute.getRoute();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ExerciseRoute.Location location = (ExerciseRoute.Location) item$iv$iv;
            ExerciseRoute.Location.Builder $this$toPlatformExerciseRoute_u24lambda_u2463_u24lambda_u2462 = new ExerciseRoute.Location.Builder(location.getTime(), location.getLatitude(), location.getLongitude());
            androidx.health.connect.client.units.Length it = location.getHorizontalAccuracy();
            if (it != null) {
                $this$toPlatformExerciseRoute_u24lambda_u2463_u24lambda_u2462.setHorizontalAccuracy(UnitConvertersKt.toPlatformLength(it));
            }
            androidx.health.connect.client.units.Length it2 = location.getVerticalAccuracy();
            if (it2 != null) {
                $this$toPlatformExerciseRoute_u24lambda_u2463_u24lambda_u2462.setVerticalAccuracy(UnitConvertersKt.toPlatformLength(it2));
            }
            androidx.health.connect.client.units.Length it3 = location.getAltitude();
            if (it3 != null) {
                $this$toPlatformExerciseRoute_u24lambda_u2463_u24lambda_u2462.setAltitude(UnitConvertersKt.toPlatformLength(it3));
            }
            destination$iv$iv.add($this$toPlatformExerciseRoute_u24lambda_u2463_u24lambda_u2462.build());
        }
        return new android.health.connect.datatypes.ExerciseRoute((List) destination$iv$iv);
    }

    private static final ExerciseSegment toPlatformExerciseSegment(androidx.health.connect.client.records.ExerciseSegment $this$toPlatformExerciseSegment) {
        ExerciseSegment build = new ExerciseSegment.Builder($this$toPlatformExerciseSegment.getStartTime(), $this$toPlatformExerciseSegment.getEndTime(), IntDefMappingsKt.toPlatformExerciseSegmentType($this$toPlatformExerciseSegment.getSegmentType())).setRepetitionsCount($this$toPlatformExerciseSegment.getRepetitions()).build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformExerciseSegmentB…titions)\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.FloorsClimbedRecord toPlatformFloorsClimbedRecord(FloorsClimbedRecord $this$toPlatformFloorsClimbedRecord) {
        FloorsClimbedRecord.Builder $this$toPlatformFloorsClimbedRecord_u24lambda_u2466 = new FloorsClimbedRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformFloorsClimbedRecord.getMetadata()), $this$toPlatformFloorsClimbedRecord.getStartTime(), $this$toPlatformFloorsClimbedRecord.getEndTime(), $this$toPlatformFloorsClimbedRecord.getFloors());
        ZoneOffset it = $this$toPlatformFloorsClimbedRecord.getStartZoneOffset();
        if (it != null) {
            $this$toPlatformFloorsClimbedRecord_u24lambda_u2466.setStartZoneOffset(it);
        }
        ZoneOffset it2 = $this$toPlatformFloorsClimbedRecord.getEndZoneOffset();
        if (it2 != null) {
            $this$toPlatformFloorsClimbedRecord_u24lambda_u2466.setEndZoneOffset(it2);
        }
        android.health.connect.datatypes.FloorsClimbedRecord build = $this$toPlatformFloorsClimbedRecord_u24lambda_u2466.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformFloorsClimbedRec…       }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.HeartRateRecord toPlatformHeartRateRecord(androidx.health.connect.client.records.HeartRateRecord $this$toPlatformHeartRateRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata($this$toPlatformHeartRateRecord.getMetadata());
        Instant startTime = $this$toPlatformHeartRateRecord.getStartTime();
        Instant endTime = $this$toPlatformHeartRateRecord.getEndTime();
        Iterable $this$map$iv = $this$toPlatformHeartRateRecord.getSamples();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(toPlatformHeartRateSample((HeartRateRecord.Sample) item$iv$iv));
        }
        HeartRateRecord.Builder $this$toPlatformHeartRateRecord_u24lambda_u2470 = new HeartRateRecord.Builder(platformMetadata, startTime, endTime, (List) destination$iv$iv);
        ZoneOffset it = $this$toPlatformHeartRateRecord.getStartZoneOffset();
        if (it != null) {
            $this$toPlatformHeartRateRecord_u24lambda_u2470.setStartZoneOffset(it);
        }
        ZoneOffset it2 = $this$toPlatformHeartRateRecord.getEndZoneOffset();
        if (it2 != null) {
            $this$toPlatformHeartRateRecord_u24lambda_u2470.setEndZoneOffset(it2);
        }
        android.health.connect.datatypes.HeartRateRecord build = $this$toPlatformHeartRateRecord_u24lambda_u2470.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformHeartRateRecordB…       }\n        .build()");
        return build;
    }

    private static final HeartRateRecord.HeartRateSample toPlatformHeartRateSample(HeartRateRecord.Sample $this$toPlatformHeartRateSample) {
        return new HeartRateRecord.HeartRateSample($this$toPlatformHeartRateSample.getBeatsPerMinute(), $this$toPlatformHeartRateSample.getTime());
    }

    private static final android.health.connect.datatypes.HeartRateVariabilityRmssdRecord toPlatformHeartRateVariabilityRmssdRecord(HeartRateVariabilityRmssdRecord $this$toPlatformHeartRateVariabilityRmssdRecord) {
        HeartRateVariabilityRmssdRecord.Builder $this$toPlatformHeartRateVariabilityRmssdRecord_u24lambda_u2472 = new HeartRateVariabilityRmssdRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformHeartRateVariabilityRmssdRecord.getMetadata()), $this$toPlatformHeartRateVariabilityRmssdRecord.getTime(), $this$toPlatformHeartRateVariabilityRmssdRecord.getHeartRateVariabilityMillis());
        ZoneOffset it = $this$toPlatformHeartRateVariabilityRmssdRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformHeartRateVariabilityRmssdRecord_u24lambda_u2472.setZoneOffset(it);
        }
        android.health.connect.datatypes.HeartRateVariabilityRmssdRecord build = $this$toPlatformHeartRateVariabilityRmssdRecord_u24lambda_u2472.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformHeartRateVariabi…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.HeightRecord toPlatformHeightRecord(HeightRecord $this$toPlatformHeightRecord) {
        HeightRecord.Builder $this$toPlatformHeightRecord_u24lambda_u2474 = new HeightRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformHeightRecord.getMetadata()), $this$toPlatformHeightRecord.getTime(), UnitConvertersKt.toPlatformLength($this$toPlatformHeightRecord.getHeight()));
        ZoneOffset it = $this$toPlatformHeightRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformHeightRecord_u24lambda_u2474.setZoneOffset(it);
        }
        android.health.connect.datatypes.HeightRecord build = $this$toPlatformHeightRecord_u24lambda_u2474.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformHeightRecordBuil…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.HydrationRecord toPlatformHydrationRecord(HydrationRecord $this$toPlatformHydrationRecord) {
        HydrationRecord.Builder $this$toPlatformHydrationRecord_u24lambda_u2477 = new HydrationRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformHydrationRecord.getMetadata()), $this$toPlatformHydrationRecord.getStartTime(), $this$toPlatformHydrationRecord.getEndTime(), UnitConvertersKt.toPlatformVolume($this$toPlatformHydrationRecord.getVolume()));
        ZoneOffset it = $this$toPlatformHydrationRecord.getStartZoneOffset();
        if (it != null) {
            $this$toPlatformHydrationRecord_u24lambda_u2477.setStartZoneOffset(it);
        }
        ZoneOffset it2 = $this$toPlatformHydrationRecord.getEndZoneOffset();
        if (it2 != null) {
            $this$toPlatformHydrationRecord_u24lambda_u2477.setEndZoneOffset(it2);
        }
        android.health.connect.datatypes.HydrationRecord build = $this$toPlatformHydrationRecord_u24lambda_u2477.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformHydrationRecordB…       }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.IntermenstrualBleedingRecord toPlatformIntermenstrualBleedingRecord(IntermenstrualBleedingRecord $this$toPlatformIntermenstrualBleedingRecord) {
        IntermenstrualBleedingRecord.Builder $this$toPlatformIntermenstrualBleedingRecord_u24lambda_u2479 = new IntermenstrualBleedingRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformIntermenstrualBleedingRecord.getMetadata()), $this$toPlatformIntermenstrualBleedingRecord.getTime());
        ZoneOffset it = $this$toPlatformIntermenstrualBleedingRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformIntermenstrualBleedingRecord_u24lambda_u2479.setZoneOffset(it);
        }
        android.health.connect.datatypes.IntermenstrualBleedingRecord build = $this$toPlatformIntermenstrualBleedingRecord_u24lambda_u2479.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformIntermenstrualBl…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.LeanBodyMassRecord toPlatformLeanBodyMassRecord(LeanBodyMassRecord $this$toPlatformLeanBodyMassRecord) {
        LeanBodyMassRecord.Builder $this$toPlatformLeanBodyMassRecord_u24lambda_u2481 = new LeanBodyMassRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformLeanBodyMassRecord.getMetadata()), $this$toPlatformLeanBodyMassRecord.getTime(), UnitConvertersKt.toPlatformMass($this$toPlatformLeanBodyMassRecord.getMass()));
        ZoneOffset it = $this$toPlatformLeanBodyMassRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformLeanBodyMassRecord_u24lambda_u2481.setZoneOffset(it);
        }
        android.health.connect.datatypes.LeanBodyMassRecord build = $this$toPlatformLeanBodyMassRecord_u24lambda_u2481.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformLeanBodyMassReco…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.MenstruationFlowRecord toPlatformMenstruationFlowRecord(MenstruationFlowRecord $this$toPlatformMenstruationFlowRecord) {
        MenstruationFlowRecord.Builder $this$toPlatformMenstruationFlowRecord_u24lambda_u2483 = new MenstruationFlowRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformMenstruationFlowRecord.getMetadata()), $this$toPlatformMenstruationFlowRecord.getTime(), IntDefMappingsKt.toPlatformMenstruationFlow($this$toPlatformMenstruationFlowRecord.getFlow()));
        ZoneOffset it = $this$toPlatformMenstruationFlowRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformMenstruationFlowRecord_u24lambda_u2483.setZoneOffset(it);
        }
        android.health.connect.datatypes.MenstruationFlowRecord build = $this$toPlatformMenstruationFlowRecord_u24lambda_u2483.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformMenstruationFlow…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.MenstruationPeriodRecord toPlatformMenstruationPeriodRecord(MenstruationPeriodRecord $this$toPlatformMenstruationPeriodRecord) {
        MenstruationPeriodRecord.Builder $this$toPlatformMenstruationPeriodRecord_u24lambda_u2486 = new MenstruationPeriodRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformMenstruationPeriodRecord.getMetadata()), $this$toPlatformMenstruationPeriodRecord.getStartTime(), $this$toPlatformMenstruationPeriodRecord.getEndTime());
        ZoneOffset it = $this$toPlatformMenstruationPeriodRecord.getStartZoneOffset();
        if (it != null) {
            $this$toPlatformMenstruationPeriodRecord_u24lambda_u2486.setStartZoneOffset(it);
        }
        ZoneOffset it2 = $this$toPlatformMenstruationPeriodRecord.getEndZoneOffset();
        if (it2 != null) {
            $this$toPlatformMenstruationPeriodRecord_u24lambda_u2486.setEndZoneOffset(it2);
        }
        android.health.connect.datatypes.MenstruationPeriodRecord build = $this$toPlatformMenstruationPeriodRecord_u24lambda_u2486.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformMenstruationPeri…       }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.NutritionRecord toPlatformNutritionRecord(NutritionRecord $this$toPlatformNutritionRecord) {
        NutritionRecord.Builder $this$toPlatformNutritionRecord_u24lambda_u24132 = new NutritionRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformNutritionRecord.getMetadata()), $this$toPlatformNutritionRecord.getStartTime(), $this$toPlatformNutritionRecord.getEndTime()).setMealType(IntDefMappingsKt.toPlatformMealType($this$toPlatformNutritionRecord.getMealType()));
        ZoneOffset it = $this$toPlatformNutritionRecord.getStartZoneOffset();
        if (it != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setStartZoneOffset(it);
        }
        ZoneOffset it2 = $this$toPlatformNutritionRecord.getEndZoneOffset();
        if (it2 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setEndZoneOffset(it2);
        }
        androidx.health.connect.client.units.Mass it3 = $this$toPlatformNutritionRecord.getBiotin();
        if (it3 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setBiotin(UnitConvertersKt.toPlatformMass(it3));
        }
        androidx.health.connect.client.units.Mass it4 = $this$toPlatformNutritionRecord.getCaffeine();
        if (it4 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setCaffeine(UnitConvertersKt.toPlatformMass(it4));
        }
        androidx.health.connect.client.units.Mass it5 = $this$toPlatformNutritionRecord.getCalcium();
        if (it5 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setCalcium(UnitConvertersKt.toPlatformMass(it5));
        }
        androidx.health.connect.client.units.Mass it6 = $this$toPlatformNutritionRecord.getChloride();
        if (it6 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setChloride(UnitConvertersKt.toPlatformMass(it6));
        }
        androidx.health.connect.client.units.Mass it7 = $this$toPlatformNutritionRecord.getCholesterol();
        if (it7 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setCholesterol(UnitConvertersKt.toPlatformMass(it7));
        }
        androidx.health.connect.client.units.Mass it8 = $this$toPlatformNutritionRecord.getChromium();
        if (it8 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setChromium(UnitConvertersKt.toPlatformMass(it8));
        }
        androidx.health.connect.client.units.Mass it9 = $this$toPlatformNutritionRecord.getCopper();
        if (it9 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setCopper(UnitConvertersKt.toPlatformMass(it9));
        }
        androidx.health.connect.client.units.Mass it10 = $this$toPlatformNutritionRecord.getDietaryFiber();
        if (it10 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setDietaryFiber(UnitConvertersKt.toPlatformMass(it10));
        }
        androidx.health.connect.client.units.Energy it11 = $this$toPlatformNutritionRecord.getEnergy();
        if (it11 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setEnergy(UnitConvertersKt.toPlatformEnergy(it11));
        }
        androidx.health.connect.client.units.Energy it12 = $this$toPlatformNutritionRecord.getEnergyFromFat();
        if (it12 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setEnergyFromFat(UnitConvertersKt.toPlatformEnergy(it12));
        }
        androidx.health.connect.client.units.Mass it13 = $this$toPlatformNutritionRecord.getFolate();
        if (it13 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setFolate(UnitConvertersKt.toPlatformMass(it13));
        }
        androidx.health.connect.client.units.Mass it14 = $this$toPlatformNutritionRecord.getFolicAcid();
        if (it14 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setFolicAcid(UnitConvertersKt.toPlatformMass(it14));
        }
        androidx.health.connect.client.units.Mass it15 = $this$toPlatformNutritionRecord.getIodine();
        if (it15 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setIodine(UnitConvertersKt.toPlatformMass(it15));
        }
        androidx.health.connect.client.units.Mass it16 = $this$toPlatformNutritionRecord.getIron();
        if (it16 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setIron(UnitConvertersKt.toPlatformMass(it16));
        }
        androidx.health.connect.client.units.Mass it17 = $this$toPlatformNutritionRecord.getMagnesium();
        if (it17 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setMagnesium(UnitConvertersKt.toPlatformMass(it17));
        }
        androidx.health.connect.client.units.Mass it18 = $this$toPlatformNutritionRecord.getManganese();
        if (it18 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setManganese(UnitConvertersKt.toPlatformMass(it18));
        }
        androidx.health.connect.client.units.Mass it19 = $this$toPlatformNutritionRecord.getMolybdenum();
        if (it19 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setMolybdenum(UnitConvertersKt.toPlatformMass(it19));
        }
        androidx.health.connect.client.units.Mass it20 = $this$toPlatformNutritionRecord.getMonounsaturatedFat();
        if (it20 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setMonounsaturatedFat(UnitConvertersKt.toPlatformMass(it20));
        }
        String it21 = $this$toPlatformNutritionRecord.getName();
        if (it21 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setMealName(it21);
        }
        androidx.health.connect.client.units.Mass it22 = $this$toPlatformNutritionRecord.getNiacin();
        if (it22 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setNiacin(UnitConvertersKt.toPlatformMass(it22));
        }
        androidx.health.connect.client.units.Mass it23 = $this$toPlatformNutritionRecord.getPantothenicAcid();
        if (it23 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setPantothenicAcid(UnitConvertersKt.toPlatformMass(it23));
        }
        androidx.health.connect.client.units.Mass it24 = $this$toPlatformNutritionRecord.getPhosphorus();
        if (it24 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setPhosphorus(UnitConvertersKt.toPlatformMass(it24));
        }
        androidx.health.connect.client.units.Mass it25 = $this$toPlatformNutritionRecord.getPolyunsaturatedFat();
        if (it25 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setPolyunsaturatedFat(UnitConvertersKt.toPlatformMass(it25));
        }
        androidx.health.connect.client.units.Mass it26 = $this$toPlatformNutritionRecord.getPotassium();
        if (it26 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setPotassium(UnitConvertersKt.toPlatformMass(it26));
        }
        androidx.health.connect.client.units.Mass it27 = $this$toPlatformNutritionRecord.getProtein();
        if (it27 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setProtein(UnitConvertersKt.toPlatformMass(it27));
        }
        androidx.health.connect.client.units.Mass it28 = $this$toPlatformNutritionRecord.getRiboflavin();
        if (it28 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setRiboflavin(UnitConvertersKt.toPlatformMass(it28));
        }
        androidx.health.connect.client.units.Mass it29 = $this$toPlatformNutritionRecord.getSaturatedFat();
        if (it29 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setSaturatedFat(UnitConvertersKt.toPlatformMass(it29));
        }
        androidx.health.connect.client.units.Mass it30 = $this$toPlatformNutritionRecord.getSelenium();
        if (it30 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setSelenium(UnitConvertersKt.toPlatformMass(it30));
        }
        androidx.health.connect.client.units.Mass it31 = $this$toPlatformNutritionRecord.getSodium();
        if (it31 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setSodium(UnitConvertersKt.toPlatformMass(it31));
        }
        androidx.health.connect.client.units.Mass it32 = $this$toPlatformNutritionRecord.getSugar();
        if (it32 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setSugar(UnitConvertersKt.toPlatformMass(it32));
        }
        androidx.health.connect.client.units.Mass it33 = $this$toPlatformNutritionRecord.getThiamin();
        if (it33 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setThiamin(UnitConvertersKt.toPlatformMass(it33));
        }
        androidx.health.connect.client.units.Mass it34 = $this$toPlatformNutritionRecord.getTotalCarbohydrate();
        if (it34 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setTotalCarbohydrate(UnitConvertersKt.toPlatformMass(it34));
        }
        androidx.health.connect.client.units.Mass it35 = $this$toPlatformNutritionRecord.getTotalFat();
        if (it35 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setTotalFat(UnitConvertersKt.toPlatformMass(it35));
        }
        androidx.health.connect.client.units.Mass it36 = $this$toPlatformNutritionRecord.getTransFat();
        if (it36 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setTransFat(UnitConvertersKt.toPlatformMass(it36));
        }
        androidx.health.connect.client.units.Mass it37 = $this$toPlatformNutritionRecord.getUnsaturatedFat();
        if (it37 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setUnsaturatedFat(UnitConvertersKt.toPlatformMass(it37));
        }
        androidx.health.connect.client.units.Mass it38 = $this$toPlatformNutritionRecord.getVitaminA();
        if (it38 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setVitaminA(UnitConvertersKt.toPlatformMass(it38));
        }
        androidx.health.connect.client.units.Mass it39 = $this$toPlatformNutritionRecord.getVitaminB6();
        if (it39 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setVitaminB6(UnitConvertersKt.toPlatformMass(it39));
        }
        androidx.health.connect.client.units.Mass it40 = $this$toPlatformNutritionRecord.getVitaminB12();
        if (it40 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setVitaminB12(UnitConvertersKt.toPlatformMass(it40));
        }
        androidx.health.connect.client.units.Mass it41 = $this$toPlatformNutritionRecord.getVitaminC();
        if (it41 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setVitaminC(UnitConvertersKt.toPlatformMass(it41));
        }
        androidx.health.connect.client.units.Mass it42 = $this$toPlatformNutritionRecord.getVitaminD();
        if (it42 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setVitaminD(UnitConvertersKt.toPlatformMass(it42));
        }
        androidx.health.connect.client.units.Mass it43 = $this$toPlatformNutritionRecord.getVitaminE();
        if (it43 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setVitaminE(UnitConvertersKt.toPlatformMass(it43));
        }
        androidx.health.connect.client.units.Mass it44 = $this$toPlatformNutritionRecord.getVitaminK();
        if (it44 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setVitaminK(UnitConvertersKt.toPlatformMass(it44));
        }
        androidx.health.connect.client.units.Mass it45 = $this$toPlatformNutritionRecord.getZinc();
        if (it45 != null) {
            $this$toPlatformNutritionRecord_u24lambda_u24132.setZinc(UnitConvertersKt.toPlatformMass(it45));
        }
        android.health.connect.datatypes.NutritionRecord build = $this$toPlatformNutritionRecord_u24lambda_u24132.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformNutritionRecordB…       }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.OvulationTestRecord toPlatformOvulationTestRecord(OvulationTestRecord $this$toPlatformOvulationTestRecord) {
        OvulationTestRecord.Builder $this$toPlatformOvulationTestRecord_u24lambda_u24134 = new OvulationTestRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformOvulationTestRecord.getMetadata()), $this$toPlatformOvulationTestRecord.getTime(), IntDefMappingsKt.toPlatformOvulationTestResult($this$toPlatformOvulationTestRecord.getResult()));
        ZoneOffset it = $this$toPlatformOvulationTestRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformOvulationTestRecord_u24lambda_u24134.setZoneOffset(it);
        }
        android.health.connect.datatypes.OvulationTestRecord build = $this$toPlatformOvulationTestRecord_u24lambda_u24134.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformOvulationTestRec…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.OxygenSaturationRecord toPlatformOxygenSaturationRecord(OxygenSaturationRecord $this$toPlatformOxygenSaturationRecord) {
        OxygenSaturationRecord.Builder $this$toPlatformOxygenSaturationRecord_u24lambda_u24136 = new OxygenSaturationRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformOxygenSaturationRecord.getMetadata()), $this$toPlatformOxygenSaturationRecord.getTime(), UnitConvertersKt.toPlatformPercentage($this$toPlatformOxygenSaturationRecord.getPercentage()));
        ZoneOffset it = $this$toPlatformOxygenSaturationRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformOxygenSaturationRecord_u24lambda_u24136.setZoneOffset(it);
        }
        android.health.connect.datatypes.OxygenSaturationRecord build = $this$toPlatformOxygenSaturationRecord_u24lambda_u24136.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformOxygenSaturation…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.PlannedExerciseSessionRecord toPlatformPlannedExerciseSessionRecord(PlannedExerciseSessionRecord $this$toPlatformPlannedExerciseSessionRecord) {
        PlannedExerciseSessionRecord.Builder builder = $this$toPlatformPlannedExerciseSessionRecord.getHasExplicitTime() ? new PlannedExerciseSessionRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformPlannedExerciseSessionRecord.getMetadata()), IntDefMappingsKt.toPlatformExerciseSessionType($this$toPlatformPlannedExerciseSessionRecord.getExerciseType()), $this$toPlatformPlannedExerciseSessionRecord.getStartTime(), $this$toPlatformPlannedExerciseSessionRecord.getEndTime()) : new PlannedExerciseSessionRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformPlannedExerciseSessionRecord.getMetadata()), IntDefMappingsKt.toPlatformExerciseSessionType($this$toPlatformPlannedExerciseSessionRecord.getExerciseType()), $this$toPlatformPlannedExerciseSessionRecord.getStartTime().atZone($this$toPlatformPlannedExerciseSessionRecord.getStartZoneOffset()).toLocalDate(), Duration.between($this$toPlatformPlannedExerciseSessionRecord.getStartTime(), $this$toPlatformPlannedExerciseSessionRecord.getEndTime()));
        PlannedExerciseSessionRecord.Builder $this$toPlatformPlannedExerciseSessionRecord_u24lambda_u24142 = builder;
        ZoneOffset it = $this$toPlatformPlannedExerciseSessionRecord.getStartZoneOffset();
        if (it != null) {
            $this$toPlatformPlannedExerciseSessionRecord_u24lambda_u24142.setStartZoneOffset(it);
        }
        ZoneOffset it2 = $this$toPlatformPlannedExerciseSessionRecord.getEndZoneOffset();
        if (it2 != null) {
            $this$toPlatformPlannedExerciseSessionRecord_u24lambda_u24142.setEndZoneOffset(it2);
        }
        String it3 = $this$toPlatformPlannedExerciseSessionRecord.getTitle();
        if (it3 != null) {
            $this$toPlatformPlannedExerciseSessionRecord_u24lambda_u24142.setTitle(it3);
        }
        String it4 = $this$toPlatformPlannedExerciseSessionRecord.getNotes();
        if (it4 != null) {
            $this$toPlatformPlannedExerciseSessionRecord_u24lambda_u24142.setNotes(it4);
        }
        Iterable $this$map$iv = $this$toPlatformPlannedExerciseSessionRecord.getBlocks();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(toPlatformPlannedExerciseBlock((PlannedExerciseBlock) item$iv$iv));
        }
        $this$toPlatformPlannedExerciseSessionRecord_u24lambda_u24142.setBlocks((List) destination$iv$iv);
        android.health.connect.datatypes.PlannedExerciseSessionRecord build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "if (hasExplicitTime) {\n …       }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.PlannedExerciseBlock toPlatformPlannedExerciseBlock(PlannedExerciseBlock $this$toPlatformPlannedExerciseBlock) {
        PlannedExerciseBlock.Builder $this$toPlatformPlannedExerciseBlock_u24lambda_u24144 = new PlannedExerciseBlock.Builder($this$toPlatformPlannedExerciseBlock.getRepetitions());
        $this$toPlatformPlannedExerciseBlock_u24lambda_u24144.setDescription($this$toPlatformPlannedExerciseBlock.getDescription());
        Iterable $this$map$iv = $this$toPlatformPlannedExerciseBlock.getSteps();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            PlannedExerciseStep it = (PlannedExerciseStep) item$iv$iv;
            destination$iv$iv.add(toPlatformPlannedExerciseStep(it));
        }
        $this$toPlatformPlannedExerciseBlock_u24lambda_u24144.setSteps((List) destination$iv$iv);
        android.health.connect.datatypes.PlannedExerciseBlock build = $this$toPlatformPlannedExerciseBlock_u24lambda_u24144.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformPlannedExerciseB…       }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.PlannedExerciseStep toPlatformPlannedExerciseStep(PlannedExerciseStep $this$toPlatformPlannedExerciseStep) {
        PlannedExerciseStep.Builder $this$toPlatformPlannedExerciseStep_u24lambda_u24146 = new PlannedExerciseStep.Builder(IntDefMappingsKt.toPlatformExerciseSegmentType($this$toPlatformPlannedExerciseStep.getExerciseType()), IntDefMappingsKt.toPlatformExerciseCategory($this$toPlatformPlannedExerciseStep.getExerciseCategory()), toPlatformExerciseCompletionGoal($this$toPlatformPlannedExerciseStep.getCompletionGoal()));
        $this$toPlatformPlannedExerciseStep_u24lambda_u24146.setDescription($this$toPlatformPlannedExerciseStep.getDescription());
        Iterable $this$map$iv = $this$toPlatformPlannedExerciseStep.getPerformanceTargets();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ExercisePerformanceTarget it = (ExercisePerformanceTarget) item$iv$iv;
            destination$iv$iv.add(toPlatformExercisePerformanceTarget(it));
        }
        $this$toPlatformPlannedExerciseStep_u24lambda_u24146.setPerformanceGoals((List) destination$iv$iv);
        android.health.connect.datatypes.PlannedExerciseStep build = $this$toPlatformPlannedExerciseStep_u24lambda_u24146.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformPlannedExerciseS…       }\n        .build()");
        return build;
    }

    public static final ExerciseCompletionGoal toPlatformExerciseCompletionGoal(androidx.health.connect.client.records.ExerciseCompletionGoal $this$toPlatformExerciseCompletionGoal) {
        Intrinsics.checkNotNullParameter($this$toPlatformExerciseCompletionGoal, "<this>");
        if ($this$toPlatformExerciseCompletionGoal instanceof ExerciseCompletionGoal.DistanceGoal) {
            return new ExerciseCompletionGoal.DistanceGoal(UnitConvertersKt.toPlatformLength(((ExerciseCompletionGoal.DistanceGoal) $this$toPlatformExerciseCompletionGoal).getDistance()));
        }
        if ($this$toPlatformExerciseCompletionGoal instanceof ExerciseCompletionGoal.DistanceAndDurationGoal) {
            return new ExerciseCompletionGoal.DistanceWithVariableRestGoal(UnitConvertersKt.toPlatformLength(((ExerciseCompletionGoal.DistanceAndDurationGoal) $this$toPlatformExerciseCompletionGoal).getDistance()), ((ExerciseCompletionGoal.DistanceAndDurationGoal) $this$toPlatformExerciseCompletionGoal).getDuration());
        }
        if ($this$toPlatformExerciseCompletionGoal instanceof ExerciseCompletionGoal.StepsGoal) {
            return new ExerciseCompletionGoal.StepsGoal(((ExerciseCompletionGoal.StepsGoal) $this$toPlatformExerciseCompletionGoal).getSteps());
        }
        if ($this$toPlatformExerciseCompletionGoal instanceof ExerciseCompletionGoal.DurationGoal) {
            return new ExerciseCompletionGoal.DurationGoal(((ExerciseCompletionGoal.DurationGoal) $this$toPlatformExerciseCompletionGoal).getDuration());
        }
        if ($this$toPlatformExerciseCompletionGoal instanceof ExerciseCompletionGoal.RepetitionsGoal) {
            return new ExerciseCompletionGoal.RepetitionsGoal(((ExerciseCompletionGoal.RepetitionsGoal) $this$toPlatformExerciseCompletionGoal).getRepetitions());
        }
        if ($this$toPlatformExerciseCompletionGoal instanceof ExerciseCompletionGoal.TotalCaloriesBurnedGoal) {
            return new ExerciseCompletionGoal.TotalCaloriesBurnedGoal(UnitConvertersKt.toPlatformEnergy(((ExerciseCompletionGoal.TotalCaloriesBurnedGoal) $this$toPlatformExerciseCompletionGoal).getTotalCalories()));
        }
        if ($this$toPlatformExerciseCompletionGoal instanceof ExerciseCompletionGoal.ActiveCaloriesBurnedGoal) {
            return new ExerciseCompletionGoal.ActiveCaloriesBurnedGoal(UnitConvertersKt.toPlatformEnergy(((ExerciseCompletionGoal.ActiveCaloriesBurnedGoal) $this$toPlatformExerciseCompletionGoal).getActiveCalories()));
        }
        if ($this$toPlatformExerciseCompletionGoal instanceof ExerciseCompletionGoal.UnknownGoal) {
            android.health.connect.datatypes.ExerciseCompletionGoal INSTANCE = ExerciseCompletionGoal.UnknownGoal.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(INSTANCE, "INSTANCE");
            return INSTANCE;
        }
        if (!($this$toPlatformExerciseCompletionGoal instanceof ExerciseCompletionGoal.ManualCompletion)) {
            throw new IllegalArgumentException("Unsupported exercise completion goal " + $this$toPlatformExerciseCompletionGoal);
        }
        android.health.connect.datatypes.ExerciseCompletionGoal INSTANCE2 = ExerciseCompletionGoal.UnspecifiedGoal.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
        return INSTANCE2;
    }

    public static final ExercisePerformanceGoal toPlatformExercisePerformanceTarget(ExercisePerformanceTarget $this$toPlatformExercisePerformanceTarget) {
        Intrinsics.checkNotNullParameter($this$toPlatformExercisePerformanceTarget, "<this>");
        if ($this$toPlatformExercisePerformanceTarget instanceof ExercisePerformanceTarget.PowerTarget) {
            return new ExercisePerformanceGoal.PowerGoal(UnitConvertersKt.toPlatformPower(((ExercisePerformanceTarget.PowerTarget) $this$toPlatformExercisePerformanceTarget).getMinPower()), UnitConvertersKt.toPlatformPower(((ExercisePerformanceTarget.PowerTarget) $this$toPlatformExercisePerformanceTarget).getMaxPower()));
        }
        if ($this$toPlatformExercisePerformanceTarget instanceof ExercisePerformanceTarget.SpeedTarget) {
            return new ExercisePerformanceGoal.SpeedGoal(UnitConvertersKt.toPlatformVelocity(((ExercisePerformanceTarget.SpeedTarget) $this$toPlatformExercisePerformanceTarget).getMinSpeed()), UnitConvertersKt.toPlatformVelocity(((ExercisePerformanceTarget.SpeedTarget) $this$toPlatformExercisePerformanceTarget).getMaxSpeed()));
        }
        if ($this$toPlatformExercisePerformanceTarget instanceof ExercisePerformanceTarget.CadenceTarget) {
            return new ExercisePerformanceGoal.CadenceGoal(((ExercisePerformanceTarget.CadenceTarget) $this$toPlatformExercisePerformanceTarget).getMinCadence(), ((ExercisePerformanceTarget.CadenceTarget) $this$toPlatformExercisePerformanceTarget).getMaxCadence());
        }
        if ($this$toPlatformExercisePerformanceTarget instanceof ExercisePerformanceTarget.HeartRateTarget) {
            return new ExercisePerformanceGoal.HeartRateGoal(MathKt.roundToInt(((ExercisePerformanceTarget.HeartRateTarget) $this$toPlatformExercisePerformanceTarget).getMinHeartRate()), MathKt.roundToInt(((ExercisePerformanceTarget.HeartRateTarget) $this$toPlatformExercisePerformanceTarget).getMaxHeartRate()));
        }
        if ($this$toPlatformExercisePerformanceTarget instanceof ExercisePerformanceTarget.WeightTarget) {
            return new ExercisePerformanceGoal.WeightGoal(UnitConvertersKt.toPlatformMass(((ExercisePerformanceTarget.WeightTarget) $this$toPlatformExercisePerformanceTarget).getMass()));
        }
        if ($this$toPlatformExercisePerformanceTarget instanceof ExercisePerformanceTarget.RateOfPerceivedExertionTarget) {
            return new ExercisePerformanceGoal.RateOfPerceivedExertionGoal(((ExercisePerformanceTarget.RateOfPerceivedExertionTarget) $this$toPlatformExercisePerformanceTarget).getRpe());
        }
        if ($this$toPlatformExercisePerformanceTarget instanceof ExercisePerformanceTarget.AmrapTarget) {
            ExercisePerformanceGoal INSTANCE = ExercisePerformanceGoal.AmrapGoal.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(INSTANCE, "INSTANCE");
            return INSTANCE;
        }
        if (!($this$toPlatformExercisePerformanceTarget instanceof ExercisePerformanceTarget.UnknownTarget)) {
            throw new IllegalArgumentException("Unsupported exercise performance target " + $this$toPlatformExercisePerformanceTarget);
        }
        ExercisePerformanceGoal INSTANCE2 = ExercisePerformanceGoal.UnknownGoal.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
        return INSTANCE2;
    }

    public static final androidx.health.connect.client.records.PlannedExerciseSessionRecord toSdkPlannedExerciseSessionRecord(android.health.connect.datatypes.PlannedExerciseSessionRecord $this$toSdkPlannedExerciseSessionRecord) {
        Intrinsics.checkNotNullParameter($this$toSdkPlannedExerciseSessionRecord, "<this>");
        Instant startTime = $this$toSdkPlannedExerciseSessionRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = $this$toSdkPlannedExerciseSessionRecord.getStartZoneOffset();
        Instant endTime = $this$toSdkPlannedExerciseSessionRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = $this$toSdkPlannedExerciseSessionRecord.getEndZoneOffset();
        android.health.connect.datatypes.Metadata metadata = $this$toSdkPlannedExerciseSessionRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        boolean hasExplicitTime = $this$toSdkPlannedExerciseSessionRecord.hasExplicitTime();
        int sdkExerciseSessionType = IntDefMappingsKt.toSdkExerciseSessionType($this$toSdkPlannedExerciseSessionRecord.getExerciseType());
        String completedExerciseSessionId = $this$toSdkPlannedExerciseSessionRecord.getCompletedExerciseSessionId();
        Iterable blocks = $this$toSdkPlannedExerciseSessionRecord.getBlocks();
        Intrinsics.checkNotNullExpressionValue(blocks, "blocks");
        Iterable $this$map$iv = blocks;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Iterable $this$map$iv2 = $this$map$iv;
            android.health.connect.datatypes.PlannedExerciseBlock it = (android.health.connect.datatypes.PlannedExerciseBlock) item$iv$iv;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            destination$iv$iv.add(toSdkPlannedExerciseBlock(it));
            $this$map$iv = $this$map$iv2;
        }
        ArrayList arrayList = (List) destination$iv$iv;
        CharSequence title = $this$toSdkPlannedExerciseSessionRecord.getTitle();
        String obj = title != null ? title.toString() : null;
        CharSequence notes = $this$toSdkPlannedExerciseSessionRecord.getNotes();
        return new androidx.health.connect.client.records.PlannedExerciseSessionRecord(startTime, startZoneOffset, endTime, endZoneOffset, sdkMetadata, hasExplicitTime, sdkExerciseSessionType, completedExerciseSessionId, arrayList, obj, notes != null ? notes.toString() : null);
    }

    private static final androidx.health.connect.client.records.PlannedExerciseBlock toSdkPlannedExerciseBlock(android.health.connect.datatypes.PlannedExerciseBlock $this$toSdkPlannedExerciseBlock) {
        int repetitions = $this$toSdkPlannedExerciseBlock.getRepetitions();
        CharSequence description = $this$toSdkPlannedExerciseBlock.getDescription();
        String obj = description != null ? description.toString() : null;
        Iterable steps = $this$toSdkPlannedExerciseBlock.getSteps();
        Intrinsics.checkNotNullExpressionValue(steps, "steps");
        Iterable $this$map$iv = steps;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            android.health.connect.datatypes.PlannedExerciseStep it = (android.health.connect.datatypes.PlannedExerciseStep) item$iv$iv;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            destination$iv$iv.add(toSdkPlannedExerciseStep(it));
        }
        return new androidx.health.connect.client.records.PlannedExerciseBlock(repetitions, (List) destination$iv$iv, obj);
    }

    private static final androidx.health.connect.client.records.PlannedExerciseStep toSdkPlannedExerciseStep(android.health.connect.datatypes.PlannedExerciseStep $this$toSdkPlannedExerciseStep) {
        CharSequence description = $this$toSdkPlannedExerciseStep.getDescription();
        String obj = description != null ? description.toString() : null;
        int sdkExerciseSegmentType = IntDefMappingsKt.toSdkExerciseSegmentType($this$toSdkPlannedExerciseStep.getExerciseType());
        int sdkExerciseCategory = IntDefMappingsKt.toSdkExerciseCategory($this$toSdkPlannedExerciseStep.getExerciseCategory());
        android.health.connect.datatypes.ExerciseCompletionGoal completionGoal = $this$toSdkPlannedExerciseStep.getCompletionGoal();
        Intrinsics.checkNotNullExpressionValue(completionGoal, "completionGoal");
        androidx.health.connect.client.records.ExerciseCompletionGoal sdkExerciseCompletionGoal = toSdkExerciseCompletionGoal(completionGoal);
        Iterable performanceGoals = $this$toSdkPlannedExerciseStep.getPerformanceGoals();
        Intrinsics.checkNotNullExpressionValue(performanceGoals, "performanceGoals");
        Iterable $this$map$iv = performanceGoals;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ExercisePerformanceGoal it = (ExercisePerformanceGoal) item$iv$iv;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            destination$iv$iv.add(toSdkExercisePerformanceTarget(it));
        }
        return new androidx.health.connect.client.records.PlannedExerciseStep(sdkExerciseSegmentType, sdkExerciseCategory, sdkExerciseCompletionGoal, (List) destination$iv$iv, obj);
    }

    public static final androidx.health.connect.client.records.ExerciseCompletionGoal toSdkExerciseCompletionGoal(android.health.connect.datatypes.ExerciseCompletionGoal $this$toSdkExerciseCompletionGoal) {
        Intrinsics.checkNotNullParameter($this$toSdkExerciseCompletionGoal, "<this>");
        if ($this$toSdkExerciseCompletionGoal instanceof ExerciseCompletionGoal.DistanceGoal) {
            Length distance = ((ExerciseCompletionGoal.DistanceGoal) $this$toSdkExerciseCompletionGoal).getDistance();
            Intrinsics.checkNotNullExpressionValue(distance, "distance");
            return new ExerciseCompletionGoal.DistanceGoal(UnitConvertersKt.toSdkLength(distance));
        }
        if ($this$toSdkExerciseCompletionGoal instanceof ExerciseCompletionGoal.DistanceWithVariableRestGoal) {
            Length distance2 = ((ExerciseCompletionGoal.DistanceWithVariableRestGoal) $this$toSdkExerciseCompletionGoal).getDistance();
            Intrinsics.checkNotNullExpressionValue(distance2, "distance");
            androidx.health.connect.client.units.Length sdkLength = UnitConvertersKt.toSdkLength(distance2);
            Duration duration = ((ExerciseCompletionGoal.DistanceWithVariableRestGoal) $this$toSdkExerciseCompletionGoal).getDuration();
            Intrinsics.checkNotNullExpressionValue(duration, "duration");
            return new ExerciseCompletionGoal.DistanceAndDurationGoal(sdkLength, duration);
        }
        if ($this$toSdkExerciseCompletionGoal instanceof ExerciseCompletionGoal.StepsGoal) {
            return new ExerciseCompletionGoal.StepsGoal(((ExerciseCompletionGoal.StepsGoal) $this$toSdkExerciseCompletionGoal).getSteps());
        }
        if ($this$toSdkExerciseCompletionGoal instanceof ExerciseCompletionGoal.DurationGoal) {
            Duration duration2 = ((ExerciseCompletionGoal.DurationGoal) $this$toSdkExerciseCompletionGoal).getDuration();
            Intrinsics.checkNotNullExpressionValue(duration2, "duration");
            return new ExerciseCompletionGoal.DurationGoal(duration2);
        }
        if ($this$toSdkExerciseCompletionGoal instanceof ExerciseCompletionGoal.RepetitionsGoal) {
            return new ExerciseCompletionGoal.RepetitionsGoal(((ExerciseCompletionGoal.RepetitionsGoal) $this$toSdkExerciseCompletionGoal).getRepetitions());
        }
        if ($this$toSdkExerciseCompletionGoal instanceof ExerciseCompletionGoal.TotalCaloriesBurnedGoal) {
            Energy totalCalories = ((ExerciseCompletionGoal.TotalCaloriesBurnedGoal) $this$toSdkExerciseCompletionGoal).getTotalCalories();
            Intrinsics.checkNotNullExpressionValue(totalCalories, "totalCalories");
            return new ExerciseCompletionGoal.TotalCaloriesBurnedGoal(UnitConvertersKt.toSdkEnergy(totalCalories));
        }
        if ($this$toSdkExerciseCompletionGoal instanceof ExerciseCompletionGoal.ActiveCaloriesBurnedGoal) {
            Energy activeCalories = ((ExerciseCompletionGoal.ActiveCaloriesBurnedGoal) $this$toSdkExerciseCompletionGoal).getActiveCalories();
            Intrinsics.checkNotNullExpressionValue(activeCalories, "activeCalories");
            return new ExerciseCompletionGoal.ActiveCaloriesBurnedGoal(UnitConvertersKt.toSdkEnergy(activeCalories));
        }
        if ($this$toSdkExerciseCompletionGoal instanceof ExerciseCompletionGoal.UnknownGoal) {
            return ExerciseCompletionGoal.UnknownGoal.INSTANCE;
        }
        if ($this$toSdkExerciseCompletionGoal instanceof ExerciseCompletionGoal.UnspecifiedGoal) {
            return ExerciseCompletionGoal.ManualCompletion.INSTANCE;
        }
        throw new IllegalArgumentException("Unsupported exercise completion goal " + $this$toSdkExerciseCompletionGoal);
    }

    public static final ExercisePerformanceTarget toSdkExercisePerformanceTarget(ExercisePerformanceGoal $this$toSdkExercisePerformanceTarget) {
        Intrinsics.checkNotNullParameter($this$toSdkExercisePerformanceTarget, "<this>");
        if ($this$toSdkExercisePerformanceTarget instanceof ExercisePerformanceGoal.PowerGoal) {
            Power minPower = ((ExercisePerformanceGoal.PowerGoal) $this$toSdkExercisePerformanceTarget).getMinPower();
            Intrinsics.checkNotNullExpressionValue(minPower, "minPower");
            androidx.health.connect.client.units.Power sdkPower = UnitConvertersKt.toSdkPower(minPower);
            Power maxPower = ((ExercisePerformanceGoal.PowerGoal) $this$toSdkExercisePerformanceTarget).getMaxPower();
            Intrinsics.checkNotNullExpressionValue(maxPower, "maxPower");
            return new ExercisePerformanceTarget.PowerTarget(sdkPower, UnitConvertersKt.toSdkPower(maxPower));
        }
        if ($this$toSdkExercisePerformanceTarget instanceof ExercisePerformanceGoal.SpeedGoal) {
            Velocity minSpeed = ((ExercisePerformanceGoal.SpeedGoal) $this$toSdkExercisePerformanceTarget).getMinSpeed();
            Intrinsics.checkNotNullExpressionValue(minSpeed, "minSpeed");
            androidx.health.connect.client.units.Velocity sdkVelocity = UnitConvertersKt.toSdkVelocity(minSpeed);
            Velocity maxSpeed = ((ExercisePerformanceGoal.SpeedGoal) $this$toSdkExercisePerformanceTarget).getMaxSpeed();
            Intrinsics.checkNotNullExpressionValue(maxSpeed, "maxSpeed");
            return new ExercisePerformanceTarget.SpeedTarget(sdkVelocity, UnitConvertersKt.toSdkVelocity(maxSpeed));
        }
        if ($this$toSdkExercisePerformanceTarget instanceof ExercisePerformanceGoal.CadenceGoal) {
            return new ExercisePerformanceTarget.CadenceTarget(((ExercisePerformanceGoal.CadenceGoal) $this$toSdkExercisePerformanceTarget).getMinRpm(), ((ExercisePerformanceGoal.CadenceGoal) $this$toSdkExercisePerformanceTarget).getMaxRpm());
        }
        if ($this$toSdkExercisePerformanceTarget instanceof ExercisePerformanceGoal.HeartRateGoal) {
            return new ExercisePerformanceTarget.HeartRateTarget(((ExercisePerformanceGoal.HeartRateGoal) $this$toSdkExercisePerformanceTarget).getMinBpm(), ((ExercisePerformanceGoal.HeartRateGoal) $this$toSdkExercisePerformanceTarget).getMaxBpm());
        }
        if ($this$toSdkExercisePerformanceTarget instanceof ExercisePerformanceGoal.WeightGoal) {
            Mass mass = ((ExercisePerformanceGoal.WeightGoal) $this$toSdkExercisePerformanceTarget).getMass();
            Intrinsics.checkNotNullExpressionValue(mass, "mass");
            return new ExercisePerformanceTarget.WeightTarget(UnitConvertersKt.toSdkMass(mass));
        }
        if ($this$toSdkExercisePerformanceTarget instanceof ExercisePerformanceGoal.RateOfPerceivedExertionGoal) {
            return new ExercisePerformanceTarget.RateOfPerceivedExertionTarget(((ExercisePerformanceGoal.RateOfPerceivedExertionGoal) $this$toSdkExercisePerformanceTarget).getRpe());
        }
        if ($this$toSdkExercisePerformanceTarget instanceof ExercisePerformanceGoal.AmrapGoal) {
            return ExercisePerformanceTarget.AmrapTarget.INSTANCE;
        }
        if ($this$toSdkExercisePerformanceTarget instanceof ExercisePerformanceGoal.UnknownGoal) {
            return ExercisePerformanceTarget.UnknownTarget.INSTANCE;
        }
        throw new IllegalArgumentException("Unsupported exercise performance target " + $this$toSdkExercisePerformanceTarget);
    }

    private static final android.health.connect.datatypes.PowerRecord toPlatformPowerRecord(androidx.health.connect.client.records.PowerRecord $this$toPlatformPowerRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata($this$toPlatformPowerRecord.getMetadata());
        Instant startTime = $this$toPlatformPowerRecord.getStartTime();
        Instant endTime = $this$toPlatformPowerRecord.getEndTime();
        Iterable $this$map$iv = $this$toPlatformPowerRecord.getSamples();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(toPlatformPowerRecordSample((PowerRecord.Sample) item$iv$iv));
        }
        PowerRecord.Builder $this$toPlatformPowerRecord_u24lambda_u24153 = new PowerRecord.Builder(platformMetadata, startTime, endTime, (List) destination$iv$iv);
        ZoneOffset it = $this$toPlatformPowerRecord.getStartZoneOffset();
        if (it != null) {
            $this$toPlatformPowerRecord_u24lambda_u24153.setStartZoneOffset(it);
        }
        ZoneOffset it2 = $this$toPlatformPowerRecord.getEndZoneOffset();
        if (it2 != null) {
            $this$toPlatformPowerRecord_u24lambda_u24153.setEndZoneOffset(it2);
        }
        android.health.connect.datatypes.PowerRecord build = $this$toPlatformPowerRecord_u24lambda_u24153.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformPowerRecordBuild…       }\n        .build()");
        return build;
    }

    private static final PowerRecord.PowerRecordSample toPlatformPowerRecordSample(PowerRecord.Sample $this$toPlatformPowerRecordSample) {
        return new PowerRecord.PowerRecordSample(UnitConvertersKt.toPlatformPower($this$toPlatformPowerRecordSample.getPower()), $this$toPlatformPowerRecordSample.getTime());
    }

    private static final android.health.connect.datatypes.RespiratoryRateRecord toPlatformRespiratoryRateRecord(RespiratoryRateRecord $this$toPlatformRespiratoryRateRecord) {
        RespiratoryRateRecord.Builder $this$toPlatformRespiratoryRateRecord_u24lambda_u24155 = new RespiratoryRateRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformRespiratoryRateRecord.getMetadata()), $this$toPlatformRespiratoryRateRecord.getTime(), $this$toPlatformRespiratoryRateRecord.getRate());
        ZoneOffset it = $this$toPlatformRespiratoryRateRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformRespiratoryRateRecord_u24lambda_u24155.setZoneOffset(it);
        }
        android.health.connect.datatypes.RespiratoryRateRecord build = $this$toPlatformRespiratoryRateRecord_u24lambda_u24155.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformRespiratoryRateR…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.RestingHeartRateRecord toPlatformRestingHeartRateRecord(RestingHeartRateRecord $this$toPlatformRestingHeartRateRecord) {
        RestingHeartRateRecord.Builder $this$toPlatformRestingHeartRateRecord_u24lambda_u24157 = new RestingHeartRateRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformRestingHeartRateRecord.getMetadata()), $this$toPlatformRestingHeartRateRecord.getTime(), $this$toPlatformRestingHeartRateRecord.getBeatsPerMinute());
        ZoneOffset it = $this$toPlatformRestingHeartRateRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformRestingHeartRateRecord_u24lambda_u24157.setZoneOffset(it);
        }
        android.health.connect.datatypes.RestingHeartRateRecord build = $this$toPlatformRestingHeartRateRecord_u24lambda_u24157.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformRestingHeartRate…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.SexualActivityRecord toPlatformSexualActivityRecord(SexualActivityRecord $this$toPlatformSexualActivityRecord) {
        SexualActivityRecord.Builder $this$toPlatformSexualActivityRecord_u24lambda_u24159 = new SexualActivityRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformSexualActivityRecord.getMetadata()), $this$toPlatformSexualActivityRecord.getTime(), IntDefMappingsKt.toPlatformSexualActivityProtectionUsed($this$toPlatformSexualActivityRecord.getProtectionUsed()));
        ZoneOffset it = $this$toPlatformSexualActivityRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformSexualActivityRecord_u24lambda_u24159.setZoneOffset(it);
        }
        android.health.connect.datatypes.SexualActivityRecord build = $this$toPlatformSexualActivityRecord_u24lambda_u24159.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformSexualActivityRe…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.SkinTemperatureRecord toPlatformSkinTemperatureRecord(androidx.health.connect.client.records.SkinTemperatureRecord $this$toPlatformSkinTemperatureRecord) {
        SkinTemperatureRecord.Builder $this$toPlatformSkinTemperatureRecord_u24lambda_u24164 = new SkinTemperatureRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformSkinTemperatureRecord.getMetadata()), $this$toPlatformSkinTemperatureRecord.getStartTime(), $this$toPlatformSkinTemperatureRecord.getEndTime());
        ZoneOffset it = $this$toPlatformSkinTemperatureRecord.getStartZoneOffset();
        if (it != null) {
            $this$toPlatformSkinTemperatureRecord_u24lambda_u24164.setStartZoneOffset(it);
        }
        ZoneOffset it2 = $this$toPlatformSkinTemperatureRecord.getEndZoneOffset();
        if (it2 != null) {
            $this$toPlatformSkinTemperatureRecord_u24lambda_u24164.setEndZoneOffset(it2);
        }
        androidx.health.connect.client.units.Temperature it3 = $this$toPlatformSkinTemperatureRecord.getBaseline();
        if (it3 != null) {
            $this$toPlatformSkinTemperatureRecord_u24lambda_u24164.setBaseline(UnitConvertersKt.toPlatformTemperature(it3));
        }
        $this$toPlatformSkinTemperatureRecord_u24lambda_u24164.setMeasurementLocation(IntDefMappingsKt.toPlatformSkinTemperatureMeasurementLocation($this$toPlatformSkinTemperatureRecord.getMeasurementLocation()));
        Iterable $this$map$iv = $this$toPlatformSkinTemperatureRecord.getDeltas();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(toPlatformSkinTemperatureRecordDelta((SkinTemperatureRecord.Delta) item$iv$iv));
        }
        $this$toPlatformSkinTemperatureRecord_u24lambda_u24164.setDeltas((List) destination$iv$iv);
        android.health.connect.datatypes.SkinTemperatureRecord build = $this$toPlatformSkinTemperatureRecord_u24lambda_u24164.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformSkinTemperatureR…       }\n        .build()");
        return build;
    }

    private static final SkinTemperatureRecord.Delta toPlatformSkinTemperatureRecordDelta(SkinTemperatureRecord.Delta $this$toPlatformSkinTemperatureRecordDelta) {
        return new SkinTemperatureRecord.Delta(UnitConvertersKt.toPlatformTemperatureDelta($this$toPlatformSkinTemperatureRecordDelta.getDelta()), $this$toPlatformSkinTemperatureRecordDelta.getTime());
    }

    private static final android.health.connect.datatypes.SleepSessionRecord toPlatformSleepSessionRecord(androidx.health.connect.client.records.SleepSessionRecord $this$toPlatformSleepSessionRecord) {
        SleepSessionRecord.Builder $this$toPlatformSleepSessionRecord_u24lambda_u24170 = new SleepSessionRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformSleepSessionRecord.getMetadata()), $this$toPlatformSleepSessionRecord.getStartTime(), $this$toPlatformSleepSessionRecord.getEndTime());
        ZoneOffset it = $this$toPlatformSleepSessionRecord.getStartZoneOffset();
        if (it != null) {
            $this$toPlatformSleepSessionRecord_u24lambda_u24170.setStartZoneOffset(it);
        }
        ZoneOffset it2 = $this$toPlatformSleepSessionRecord.getEndZoneOffset();
        if (it2 != null) {
            $this$toPlatformSleepSessionRecord_u24lambda_u24170.setEndZoneOffset(it2);
        }
        String it3 = $this$toPlatformSleepSessionRecord.getNotes();
        if (it3 != null) {
            $this$toPlatformSleepSessionRecord_u24lambda_u24170.setNotes(it3);
        }
        String it4 = $this$toPlatformSleepSessionRecord.getTitle();
        if (it4 != null) {
            $this$toPlatformSleepSessionRecord_u24lambda_u24170.setTitle(it4);
        }
        Iterable $this$map$iv = $this$toPlatformSleepSessionRecord.getStages();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(toPlatformSleepSessionStage((SleepSessionRecord.Stage) item$iv$iv));
        }
        $this$toPlatformSleepSessionRecord_u24lambda_u24170.setStages((List) destination$iv$iv);
        android.health.connect.datatypes.SleepSessionRecord build = $this$toPlatformSleepSessionRecord_u24lambda_u24170.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformSleepSessionReco…       }\n        .build()");
        return build;
    }

    private static final SleepSessionRecord.Stage toPlatformSleepSessionStage(SleepSessionRecord.Stage $this$toPlatformSleepSessionStage) {
        return new SleepSessionRecord.Stage($this$toPlatformSleepSessionStage.getStartTime(), $this$toPlatformSleepSessionStage.getEndTime(), IntDefMappingsKt.toPlatformSleepStageType($this$toPlatformSleepSessionStage.getStage()));
    }

    private static final android.health.connect.datatypes.SpeedRecord toPlatformSpeedRecord(androidx.health.connect.client.records.SpeedRecord $this$toPlatformSpeedRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata($this$toPlatformSpeedRecord.getMetadata());
        Instant startTime = $this$toPlatformSpeedRecord.getStartTime();
        Instant endTime = $this$toPlatformSpeedRecord.getEndTime();
        Iterable $this$map$iv = $this$toPlatformSpeedRecord.getSamples();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(toPlatformSpeedRecordSample((SpeedRecord.Sample) item$iv$iv));
        }
        SpeedRecord.Builder $this$toPlatformSpeedRecord_u24lambda_u24174 = new SpeedRecord.Builder(platformMetadata, startTime, endTime, (List) destination$iv$iv);
        ZoneOffset it = $this$toPlatformSpeedRecord.getStartZoneOffset();
        if (it != null) {
            $this$toPlatformSpeedRecord_u24lambda_u24174.setStartZoneOffset(it);
        }
        ZoneOffset it2 = $this$toPlatformSpeedRecord.getEndZoneOffset();
        if (it2 != null) {
            $this$toPlatformSpeedRecord_u24lambda_u24174.setEndZoneOffset(it2);
        }
        android.health.connect.datatypes.SpeedRecord build = $this$toPlatformSpeedRecord_u24lambda_u24174.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformSpeedRecordBuild…       }\n        .build()");
        return build;
    }

    private static final SpeedRecord.SpeedRecordSample toPlatformSpeedRecordSample(SpeedRecord.Sample $this$toPlatformSpeedRecordSample) {
        return new SpeedRecord.SpeedRecordSample(UnitConvertersKt.toPlatformVelocity($this$toPlatformSpeedRecordSample.getSpeed()), $this$toPlatformSpeedRecordSample.getTime());
    }

    private static final android.health.connect.datatypes.StepsRecord toPlatformStepsRecord(StepsRecord $this$toPlatformStepsRecord) {
        StepsRecord.Builder $this$toPlatformStepsRecord_u24lambda_u24177 = new StepsRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformStepsRecord.getMetadata()), $this$toPlatformStepsRecord.getStartTime(), $this$toPlatformStepsRecord.getEndTime(), $this$toPlatformStepsRecord.getCount());
        ZoneOffset it = $this$toPlatformStepsRecord.getStartZoneOffset();
        if (it != null) {
            $this$toPlatformStepsRecord_u24lambda_u24177.setStartZoneOffset(it);
        }
        ZoneOffset it2 = $this$toPlatformStepsRecord.getEndZoneOffset();
        if (it2 != null) {
            $this$toPlatformStepsRecord_u24lambda_u24177.setEndZoneOffset(it2);
        }
        android.health.connect.datatypes.StepsRecord build = $this$toPlatformStepsRecord_u24lambda_u24177.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformStepsRecordBuild…       }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.StepsCadenceRecord toPlatformStepsCadenceRecord(androidx.health.connect.client.records.StepsCadenceRecord $this$toPlatformStepsCadenceRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata($this$toPlatformStepsCadenceRecord.getMetadata());
        Instant startTime = $this$toPlatformStepsCadenceRecord.getStartTime();
        Instant endTime = $this$toPlatformStepsCadenceRecord.getEndTime();
        Iterable $this$map$iv = $this$toPlatformStepsCadenceRecord.getSamples();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(toPlatformStepsCadenceSample((StepsCadenceRecord.Sample) item$iv$iv));
        }
        StepsCadenceRecord.Builder $this$toPlatformStepsCadenceRecord_u24lambda_u24181 = new StepsCadenceRecord.Builder(platformMetadata, startTime, endTime, (List) destination$iv$iv);
        ZoneOffset it = $this$toPlatformStepsCadenceRecord.getStartZoneOffset();
        if (it != null) {
            $this$toPlatformStepsCadenceRecord_u24lambda_u24181.setStartZoneOffset(it);
        }
        ZoneOffset it2 = $this$toPlatformStepsCadenceRecord.getEndZoneOffset();
        if (it2 != null) {
            $this$toPlatformStepsCadenceRecord_u24lambda_u24181.setEndZoneOffset(it2);
        }
        android.health.connect.datatypes.StepsCadenceRecord build = $this$toPlatformStepsCadenceRecord_u24lambda_u24181.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformStepsCadenceReco…       }\n        .build()");
        return build;
    }

    private static final StepsCadenceRecord.StepsCadenceRecordSample toPlatformStepsCadenceSample(StepsCadenceRecord.Sample $this$toPlatformStepsCadenceSample) {
        return new StepsCadenceRecord.StepsCadenceRecordSample($this$toPlatformStepsCadenceSample.getRate(), $this$toPlatformStepsCadenceSample.getTime());
    }

    private static final android.health.connect.datatypes.TotalCaloriesBurnedRecord toPlatformTotalCaloriesBurnedRecord(TotalCaloriesBurnedRecord $this$toPlatformTotalCaloriesBurnedRecord) {
        TotalCaloriesBurnedRecord.Builder $this$toPlatformTotalCaloriesBurnedRecord_u24lambda_u24184 = new TotalCaloriesBurnedRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformTotalCaloriesBurnedRecord.getMetadata()), $this$toPlatformTotalCaloriesBurnedRecord.getStartTime(), $this$toPlatformTotalCaloriesBurnedRecord.getEndTime(), UnitConvertersKt.toPlatformEnergy($this$toPlatformTotalCaloriesBurnedRecord.getEnergy()));
        ZoneOffset it = $this$toPlatformTotalCaloriesBurnedRecord.getStartZoneOffset();
        if (it != null) {
            $this$toPlatformTotalCaloriesBurnedRecord_u24lambda_u24184.setStartZoneOffset(it);
        }
        ZoneOffset it2 = $this$toPlatformTotalCaloriesBurnedRecord.getEndZoneOffset();
        if (it2 != null) {
            $this$toPlatformTotalCaloriesBurnedRecord_u24lambda_u24184.setEndZoneOffset(it2);
        }
        android.health.connect.datatypes.TotalCaloriesBurnedRecord build = $this$toPlatformTotalCaloriesBurnedRecord_u24lambda_u24184.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformTotalCaloriesBur…       }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.Vo2MaxRecord toPlatformVo2MaxRecord(Vo2MaxRecord $this$toPlatformVo2MaxRecord) {
        Vo2MaxRecord.Builder $this$toPlatformVo2MaxRecord_u24lambda_u24186 = new Vo2MaxRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformVo2MaxRecord.getMetadata()), $this$toPlatformVo2MaxRecord.getTime(), IntDefMappingsKt.toPlatformVo2MaxMeasurementMethod($this$toPlatformVo2MaxRecord.getMeasurementMethod()), $this$toPlatformVo2MaxRecord.getVo2MillilitersPerMinuteKilogram());
        ZoneOffset it = $this$toPlatformVo2MaxRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformVo2MaxRecord_u24lambda_u24186.setZoneOffset(it);
        }
        android.health.connect.datatypes.Vo2MaxRecord build = $this$toPlatformVo2MaxRecord_u24lambda_u24186.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformVo2MaxRecordBuil…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.WeightRecord toPlatformWeightRecord(WeightRecord $this$toPlatformWeightRecord) {
        WeightRecord.Builder $this$toPlatformWeightRecord_u24lambda_u24188 = new WeightRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformWeightRecord.getMetadata()), $this$toPlatformWeightRecord.getTime(), UnitConvertersKt.toPlatformMass($this$toPlatformWeightRecord.getWeight()));
        ZoneOffset it = $this$toPlatformWeightRecord.getZoneOffset();
        if (it != null) {
            $this$toPlatformWeightRecord_u24lambda_u24188.setZoneOffset(it);
        }
        android.health.connect.datatypes.WeightRecord build = $this$toPlatformWeightRecord_u24lambda_u24188.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformWeightRecordBuil…(it) } }\n        .build()");
        return build;
    }

    private static final android.health.connect.datatypes.WheelchairPushesRecord toPlatformWheelchairPushesRecord(WheelchairPushesRecord $this$toPlatformWheelchairPushesRecord) {
        WheelchairPushesRecord.Builder $this$toPlatformWheelchairPushesRecord_u24lambda_u24191 = new WheelchairPushesRecord.Builder(MetadataConvertersKt.toPlatformMetadata($this$toPlatformWheelchairPushesRecord.getMetadata()), $this$toPlatformWheelchairPushesRecord.getStartTime(), $this$toPlatformWheelchairPushesRecord.getEndTime(), $this$toPlatformWheelchairPushesRecord.getCount());
        ZoneOffset it = $this$toPlatformWheelchairPushesRecord.getStartZoneOffset();
        if (it != null) {
            $this$toPlatformWheelchairPushesRecord_u24lambda_u24191.setStartZoneOffset(it);
        }
        ZoneOffset it2 = $this$toPlatformWheelchairPushesRecord.getEndZoneOffset();
        if (it2 != null) {
            $this$toPlatformWheelchairPushesRecord_u24lambda_u24191.setEndZoneOffset(it2);
        }
        android.health.connect.datatypes.WheelchairPushesRecord build = $this$toPlatformWheelchairPushesRecord_u24lambda_u24191.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformWheelchairPushes…       }\n        .build()");
        return build;
    }

    private static final CyclingPedalingCadenceRecord.Sample toSdkCyclingPedalingCadenceSample(CyclingPedalingCadenceRecord.CyclingPedalingCadenceRecordSample $this$toSdkCyclingPedalingCadenceSample) {
        Instant time = $this$toSdkCyclingPedalingCadenceSample.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        return new CyclingPedalingCadenceRecord.Sample(time, $this$toSdkCyclingPedalingCadenceSample.getRevolutionsPerMinute());
    }

    private static final HeartRateRecord.Sample toSdkHeartRateSample(HeartRateRecord.HeartRateSample $this$toSdkHeartRateSample) {
        Instant time = $this$toSdkHeartRateSample.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        return new HeartRateRecord.Sample(time, $this$toSdkHeartRateSample.getBeatsPerMinute());
    }

    private static final PowerRecord.Sample toSdkPowerRecordSample(PowerRecord.PowerRecordSample $this$toSdkPowerRecordSample) {
        Instant time = $this$toSdkPowerRecordSample.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        Power power = $this$toSdkPowerRecordSample.getPower();
        Intrinsics.checkNotNullExpressionValue(power, "power");
        return new PowerRecord.Sample(time, UnitConvertersKt.toSdkPower(power));
    }

    private static final SkinTemperatureRecord.Delta toSdkSkinTemperatureDelta(SkinTemperatureRecord.Delta $this$toSdkSkinTemperatureDelta) {
        Instant time = $this$toSdkSkinTemperatureDelta.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        TemperatureDelta delta = $this$toSdkSkinTemperatureDelta.getDelta();
        Intrinsics.checkNotNullExpressionValue(delta, "delta");
        return new SkinTemperatureRecord.Delta(time, UnitConvertersKt.toSdkTemperatureDelta(delta));
    }

    private static final SpeedRecord.Sample toSdkSpeedSample(SpeedRecord.SpeedRecordSample $this$toSdkSpeedSample) {
        Instant time = $this$toSdkSpeedSample.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        Velocity speed = $this$toSdkSpeedSample.getSpeed();
        Intrinsics.checkNotNullExpressionValue(speed, "speed");
        return new SpeedRecord.Sample(time, UnitConvertersKt.toSdkVelocity(speed));
    }

    private static final StepsCadenceRecord.Sample toSdkStepsCadenceSample(StepsCadenceRecord.StepsCadenceRecordSample $this$toSdkStepsCadenceSample) {
        Instant time = $this$toSdkStepsCadenceSample.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        return new StepsCadenceRecord.Sample(time, $this$toSdkStepsCadenceSample.getRate());
    }

    private static final SleepSessionRecord.Stage toSdkSleepSessionStage(SleepSessionRecord.Stage $this$toSdkSleepSessionStage) {
        Instant startTime = $this$toSdkSleepSessionStage.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        Instant endTime = $this$toSdkSleepSessionStage.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        return new SleepSessionRecord.Stage(startTime, endTime, IntDefMappingsKt.toSdkSleepStageType($this$toSdkSleepSessionStage.getType()));
    }

    public static final androidx.health.connect.client.records.ExerciseRoute toSdkExerciseRoute(android.health.connect.datatypes.ExerciseRoute $this$toSdkExerciseRoute) {
        Iterable $this$map$iv;
        androidx.health.connect.client.units.Length length;
        androidx.health.connect.client.units.Length length2;
        int $i$f$map;
        androidx.health.connect.client.units.Length length3;
        Intrinsics.checkNotNullParameter($this$toSdkExerciseRoute, "<this>");
        Iterable routeLocations = $this$toSdkExerciseRoute.getRouteLocations();
        Intrinsics.checkNotNullExpressionValue(routeLocations, "routeLocations");
        Iterable $this$map$iv2 = routeLocations;
        int $i$f$map2 = 0;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv : $this$map$iv2) {
            ExerciseRoute.Location value = (ExerciseRoute.Location) item$iv$iv;
            Instant time = value.getTime();
            Intrinsics.checkNotNullExpressionValue(time, "value.time");
            double latitude = value.getLatitude();
            double longitude = value.getLongitude();
            Length horizontalAccuracy = value.getHorizontalAccuracy();
            if (horizontalAccuracy != null) {
                $this$map$iv = $this$map$iv2;
                Intrinsics.checkNotNullExpressionValue(horizontalAccuracy, "horizontalAccuracy");
                length = UnitConvertersKt.toSdkLength(horizontalAccuracy);
            } else {
                $this$map$iv = $this$map$iv2;
                length = null;
            }
            Length verticalAccuracy = value.getVerticalAccuracy();
            if (verticalAccuracy != null) {
                Intrinsics.checkNotNullExpressionValue(verticalAccuracy, "verticalAccuracy");
                length2 = UnitConvertersKt.toSdkLength(verticalAccuracy);
            } else {
                length2 = null;
            }
            Length altitude = value.getAltitude();
            if (altitude != null) {
                $i$f$map = $i$f$map2;
                Intrinsics.checkNotNullExpressionValue(altitude, "altitude");
                length3 = UnitConvertersKt.toSdkLength(altitude);
            } else {
                $i$f$map = $i$f$map2;
                length3 = null;
            }
            destination$iv$iv.add(new ExerciseRoute.Location(time, latitude, longitude, length, length2, length3));
            $this$map$iv2 = $this$map$iv;
            $i$f$map2 = $i$f$map;
        }
        return new androidx.health.connect.client.records.ExerciseRoute((List) destination$iv$iv);
    }

    public static final androidx.health.connect.client.records.ExerciseLap toSdkExerciseLap(ExerciseLap $this$toSdkExerciseLap) {
        Intrinsics.checkNotNullParameter($this$toSdkExerciseLap, "<this>");
        Instant startTime = $this$toSdkExerciseLap.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        Instant endTime = $this$toSdkExerciseLap.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        Length length = $this$toSdkExerciseLap.getLength();
        return new androidx.health.connect.client.records.ExerciseLap(startTime, endTime, length != null ? UnitConvertersKt.toSdkLength(length) : null);
    }

    public static final androidx.health.connect.client.records.ExerciseSegment toSdkExerciseSegment(ExerciseSegment $this$toSdkExerciseSegment) {
        Intrinsics.checkNotNullParameter($this$toSdkExerciseSegment, "<this>");
        Instant startTime = $this$toSdkExerciseSegment.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        Instant endTime = $this$toSdkExerciseSegment.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        return new androidx.health.connect.client.records.ExerciseSegment(startTime, endTime, IntDefMappingsKt.toSdkExerciseSegmentType($this$toSdkExerciseSegment.getSegmentType()), $this$toSdkExerciseSegment.getRepetitionsCount());
    }
}
