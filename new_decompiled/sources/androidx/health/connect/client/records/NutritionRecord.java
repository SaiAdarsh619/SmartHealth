package androidx.health.connect.client.records;

import androidx.autofill.HintConstants;
import androidx.compose.p000ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.units.Energy;
import androidx.health.connect.client.units.EnergyKt;
import androidx.health.connect.client.units.Mass;
import androidx.health.connect.client.units.MassKt;
import java.time.Instant;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NutritionRecord.kt */
@Metadata(m286d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b<\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 {2\u00020\u0001:\u0001{B¿\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000107\u0012\b\b\u0002\u00108\u001a\u000209¢\u0006\u0002\u0010:J\u0013\u0010u\u001a\u00020v2\b\u0010w\u001a\u0004\u0018\u00010xH\u0096\u0002J\b\u0010y\u001a\u000209H\u0016J\b\u0010z\u001a\u000207H\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010<R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b>\u0010<R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b?\u0010<R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b@\u0010<R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bA\u0010<R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bB\u0010<R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bC\u0010<R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010IR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bK\u0010<R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bL\u0010<R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bM\u0010<R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bN\u0010<R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bO\u0010<R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bP\u0010<R\u0017\u00108\u001a\u000209¢\u0006\u000e\n\u0000\u0012\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bW\u0010<R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bX\u0010<R\u0013\u00106\u001a\u0004\u0018\u000107¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b[\u0010<R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010<R\u0013\u0010 \u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b]\u0010<R\u0013\u0010!\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b^\u0010<R\u0013\u0010\"\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b_\u0010<R\u0013\u0010#\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b`\u0010<R\u0013\u0010$\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\ba\u0010<R\u0013\u0010%\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bb\u0010<R\u0013\u0010&\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bc\u0010<R\u0013\u0010'\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bd\u0010<R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010ER\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010GR\u0013\u0010(\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bg\u0010<R\u0013\u0010)\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bh\u0010<R\u0013\u0010*\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bi\u0010<R\u0013\u0010+\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bj\u0010<R\u0013\u0010,\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bk\u0010<R\u0013\u0010-\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bl\u0010<R\u0013\u0010.\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bm\u0010<R\u0013\u0010/\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bn\u0010<R\u0013\u00100\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bo\u0010<R\u0013\u00101\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bp\u0010<R\u0013\u00102\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bq\u0010<R\u0013\u00103\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\br\u0010<R\u0013\u00104\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bs\u0010<R\u0013\u00105\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bt\u0010<¨\u0006|"}, m287d2 = {"Landroidx/health/connect/client/records/NutritionRecord;", "Landroidx/health/connect/client/records/IntervalRecord;", "startTime", "Ljava/time/Instant;", "startZoneOffset", "Ljava/time/ZoneOffset;", "endTime", "endZoneOffset", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "biotin", "Landroidx/health/connect/client/units/Mass;", "caffeine", "calcium", "energy", "Landroidx/health/connect/client/units/Energy;", "energyFromFat", "chloride", "cholesterol", "chromium", "copper", "dietaryFiber", "folate", "folicAcid", "iodine", "iron", "magnesium", "manganese", "molybdenum", "monounsaturatedFat", "niacin", "pantothenicAcid", "phosphorus", "polyunsaturatedFat", "potassium", "protein", "riboflavin", "saturatedFat", "selenium", "sodium", "sugar", "thiamin", "totalCarbohydrate", "totalFat", "transFat", "unsaturatedFat", "vitaminA", "vitaminB12", "vitaminB6", "vitaminC", "vitaminD", "vitaminE", "vitaminK", "zinc", HintConstants.AUTOFILL_HINT_NAME, "", "mealType", "", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Energy;Landroidx/health/connect/client/units/Energy;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Ljava/lang/String;I)V", "getBiotin", "()Landroidx/health/connect/client/units/Mass;", "getCaffeine", "getCalcium", "getChloride", "getCholesterol", "getChromium", "getCopper", "getDietaryFiber", "getEndTime", "()Ljava/time/Instant;", "getEndZoneOffset", "()Ljava/time/ZoneOffset;", "getEnergy", "()Landroidx/health/connect/client/units/Energy;", "getEnergyFromFat", "getFolate", "getFolicAcid", "getIodine", "getIron", "getMagnesium", "getManganese", "getMealType$annotations", "()V", "getMealType", "()I", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getMolybdenum", "getMonounsaturatedFat", "getName", "()Ljava/lang/String;", "getNiacin", "getPantothenicAcid", "getPhosphorus", "getPolyunsaturatedFat", "getPotassium", "getProtein", "getRiboflavin", "getSaturatedFat", "getSelenium", "getSodium", "getStartTime", "getStartZoneOffset", "getSugar", "getThiamin", "getTotalCarbohydrate", "getTotalFat", "getTransFat", "getUnsaturatedFat", "getVitaminA", "getVitaminB12", "getVitaminB6", "getVitaminC", "getVitaminD", "getVitaminE", "getVitaminK", "getZinc", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "toString", "Companion", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class NutritionRecord implements IntervalRecord {
    public static final AggregateMetric<Mass> BIOTIN_TOTAL;
    public static final AggregateMetric<Mass> CAFFEINE_TOTAL;
    public static final AggregateMetric<Mass> CALCIUM_TOTAL;
    public static final AggregateMetric<Mass> CHLORIDE_TOTAL;
    public static final AggregateMetric<Mass> CHOLESTEROL_TOTAL;
    public static final AggregateMetric<Mass> CHROMIUM_TOTAL;
    public static final AggregateMetric<Mass> COPPER_TOTAL;
    public static final AggregateMetric<Mass> DIETARY_FIBER_TOTAL;
    public static final AggregateMetric<Energy> ENERGY_FROM_FAT_TOTAL;
    public static final AggregateMetric<Energy> ENERGY_TOTAL;
    public static final AggregateMetric<Mass> FOLATE_TOTAL;
    public static final AggregateMetric<Mass> FOLIC_ACID_TOTAL;
    public static final AggregateMetric<Mass> IODINE_TOTAL;
    public static final AggregateMetric<Mass> IRON_TOTAL;
    public static final AggregateMetric<Mass> MAGNESIUM_TOTAL;
    public static final AggregateMetric<Mass> MANGANESE_TOTAL;
    private static final Energy MAX_ENERGY;
    private static final Mass MAX_MASS_100;
    private static final Mass MAX_MASS_100K;
    private static final Energy MIN_ENERGY;
    private static final Mass MIN_MASS;
    public static final AggregateMetric<Mass> MOLYBDENUM_TOTAL;
    public static final AggregateMetric<Mass> MONOUNSATURATED_FAT_TOTAL;
    public static final AggregateMetric<Mass> NIACIN_TOTAL;
    public static final AggregateMetric<Mass> PANTOTHENIC_ACID_TOTAL;
    public static final AggregateMetric<Mass> PHOSPHORUS_TOTAL;
    public static final AggregateMetric<Mass> POLYUNSATURATED_FAT_TOTAL;
    public static final AggregateMetric<Mass> POTASSIUM_TOTAL;
    public static final AggregateMetric<Mass> PROTEIN_TOTAL;
    public static final AggregateMetric<Mass> RIBOFLAVIN_TOTAL;
    public static final AggregateMetric<Mass> SATURATED_FAT_TOTAL;
    public static final AggregateMetric<Mass> SELENIUM_TOTAL;
    public static final AggregateMetric<Mass> SODIUM_TOTAL;
    public static final AggregateMetric<Mass> SUGAR_TOTAL;
    public static final AggregateMetric<Mass> THIAMIN_TOTAL;
    public static final AggregateMetric<Mass> TOTAL_CARBOHYDRATE_TOTAL;
    public static final AggregateMetric<Mass> TOTAL_FAT_TOTAL;
    public static final AggregateMetric<Mass> TRANS_FAT_TOTAL;
    private static final String TYPE_NAME = "Nutrition";
    public static final AggregateMetric<Mass> UNSATURATED_FAT_TOTAL;
    public static final AggregateMetric<Mass> VITAMIN_A_TOTAL;
    public static final AggregateMetric<Mass> VITAMIN_B12_TOTAL;
    public static final AggregateMetric<Mass> VITAMIN_B6_TOTAL;
    public static final AggregateMetric<Mass> VITAMIN_C_TOTAL;
    public static final AggregateMetric<Mass> VITAMIN_D_TOTAL;
    public static final AggregateMetric<Mass> VITAMIN_E_TOTAL;
    public static final AggregateMetric<Mass> VITAMIN_K_TOTAL;
    public static final AggregateMetric<Mass> ZINC_TOTAL;
    private final Mass biotin;
    private final Mass caffeine;
    private final Mass calcium;
    private final Mass chloride;
    private final Mass cholesterol;
    private final Mass chromium;
    private final Mass copper;
    private final Mass dietaryFiber;
    private final Instant endTime;
    private final ZoneOffset endZoneOffset;
    private final Energy energy;
    private final Energy energyFromFat;
    private final Mass folate;
    private final Mass folicAcid;
    private final Mass iodine;
    private final Mass iron;
    private final Mass magnesium;
    private final Mass manganese;
    private final int mealType;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Mass molybdenum;
    private final Mass monounsaturatedFat;
    private final String name;
    private final Mass niacin;
    private final Mass pantothenicAcid;
    private final Mass phosphorus;
    private final Mass polyunsaturatedFat;
    private final Mass potassium;
    private final Mass protein;
    private final Mass riboflavin;
    private final Mass saturatedFat;
    private final Mass selenium;
    private final Mass sodium;
    private final Instant startTime;
    private final ZoneOffset startZoneOffset;
    private final Mass sugar;
    private final Mass thiamin;
    private final Mass totalCarbohydrate;
    private final Mass totalFat;
    private final Mass transFat;
    private final Mass unsaturatedFat;
    private final Mass vitaminA;
    private final Mass vitaminB12;
    private final Mass vitaminB6;
    private final Mass vitaminC;
    private final Mass vitaminD;
    private final Mass vitaminE;
    private final Mass vitaminK;
    private final Mass zinc;

    public static /* synthetic */ void getMealType$annotations() {
    }

    public NutritionRecord(Instant startTime, ZoneOffset startZoneOffset, Instant endTime, ZoneOffset endZoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, Mass biotin, Mass caffeine, Mass calcium, Energy energy, Energy energyFromFat, Mass chloride, Mass cholesterol, Mass chromium, Mass copper, Mass dietaryFiber, Mass folate, Mass folicAcid, Mass iodine, Mass iron, Mass magnesium, Mass manganese, Mass molybdenum, Mass monounsaturatedFat, Mass niacin, Mass pantothenicAcid, Mass phosphorus, Mass polyunsaturatedFat, Mass potassium, Mass protein, Mass riboflavin, Mass saturatedFat, Mass selenium, Mass sodium, Mass sugar, Mass thiamin, Mass totalCarbohydrate, Mass totalFat, Mass transFat, Mass unsaturatedFat, Mass vitaminA, Mass vitaminB12, Mass vitaminB6, Mass vitaminC, Mass vitaminD, Mass vitaminE, Mass vitaminK, Mass zinc, String name, int mealType) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.startTime = startTime;
        this.startZoneOffset = startZoneOffset;
        this.endTime = endTime;
        this.endZoneOffset = endZoneOffset;
        this.metadata = metadata;
        this.biotin = biotin;
        this.caffeine = caffeine;
        this.calcium = calcium;
        this.energy = energy;
        this.energyFromFat = energyFromFat;
        this.chloride = chloride;
        this.cholesterol = cholesterol;
        this.chromium = chromium;
        this.copper = copper;
        this.dietaryFiber = dietaryFiber;
        this.folate = folate;
        this.folicAcid = folicAcid;
        this.iodine = iodine;
        this.iron = iron;
        this.magnesium = magnesium;
        this.manganese = manganese;
        this.molybdenum = molybdenum;
        this.monounsaturatedFat = monounsaturatedFat;
        this.niacin = niacin;
        this.pantothenicAcid = pantothenicAcid;
        this.phosphorus = phosphorus;
        this.polyunsaturatedFat = polyunsaturatedFat;
        this.potassium = potassium;
        this.protein = protein;
        this.riboflavin = riboflavin;
        this.saturatedFat = saturatedFat;
        this.selenium = selenium;
        this.sodium = sodium;
        this.sugar = sugar;
        this.thiamin = thiamin;
        this.totalCarbohydrate = totalCarbohydrate;
        this.totalFat = totalFat;
        this.transFat = transFat;
        this.unsaturatedFat = unsaturatedFat;
        this.vitaminA = vitaminA;
        this.vitaminB12 = vitaminB12;
        this.vitaminB6 = vitaminB6;
        this.vitaminC = vitaminC;
        this.vitaminD = vitaminD;
        this.vitaminE = vitaminE;
        this.vitaminK = vitaminK;
        this.zinc = zinc;
        this.name = name;
        this.mealType = mealType;
        if (!getStartTime().isBefore(getEndTime())) {
            throw new IllegalArgumentException("startTime must be before endTime.".toString());
        }
        Mass mass = this.biotin;
        if (mass != null) {
            UtilsKt.requireInRange(mass, MIN_MASS, MAX_MASS_100, "biotin");
        }
        Mass mass2 = this.caffeine;
        if (mass2 != null) {
            UtilsKt.requireInRange(mass2, MIN_MASS, MAX_MASS_100, "caffeine");
        }
        Mass mass3 = this.calcium;
        if (mass3 != null) {
            UtilsKt.requireInRange(mass3, MIN_MASS, MAX_MASS_100, "calcium");
        }
        Energy energy2 = this.energy;
        if (energy2 != null) {
            UtilsKt.requireInRange(energy2, MIN_ENERGY, MAX_ENERGY, "energy");
        }
        Energy energy3 = this.energyFromFat;
        if (energy3 != null) {
            UtilsKt.requireInRange(energy3, MIN_ENERGY, MAX_ENERGY, "energyFromFat");
        }
        Mass mass4 = this.chloride;
        if (mass4 != null) {
            UtilsKt.requireInRange(mass4, MIN_MASS, MAX_MASS_100, "chloride");
        }
        Mass mass5 = this.cholesterol;
        if (mass5 != null) {
            UtilsKt.requireInRange(mass5, MIN_MASS, MAX_MASS_100, "cholesterol");
        }
        Mass mass6 = this.chromium;
        if (mass6 != null) {
            UtilsKt.requireInRange(mass6, MIN_MASS, MAX_MASS_100, "chromium");
        }
        Mass mass7 = this.copper;
        if (mass7 != null) {
            UtilsKt.requireInRange(mass7, MIN_MASS, MAX_MASS_100, "copper");
        }
        Mass mass8 = this.dietaryFiber;
        if (mass8 != null) {
            UtilsKt.requireInRange(mass8, MIN_MASS, MAX_MASS_100K, "dietaryFiber");
        }
        Mass mass9 = this.folate;
        if (mass9 != null) {
            UtilsKt.requireInRange(mass9, MIN_MASS, MAX_MASS_100, "chloride");
        }
        Mass mass10 = this.folicAcid;
        if (mass10 != null) {
            UtilsKt.requireInRange(mass10, MIN_MASS, MAX_MASS_100, "folicAcid");
        }
        Mass mass11 = this.iodine;
        if (mass11 != null) {
            UtilsKt.requireInRange(mass11, MIN_MASS, MAX_MASS_100, "iodine");
        }
        Mass mass12 = this.iron;
        if (mass12 != null) {
            UtilsKt.requireInRange(mass12, MIN_MASS, MAX_MASS_100, "iron");
        }
        Mass mass13 = this.magnesium;
        if (mass13 != null) {
            UtilsKt.requireInRange(mass13, MIN_MASS, MAX_MASS_100, "magnesium");
        }
        Mass mass14 = this.manganese;
        if (mass14 != null) {
            UtilsKt.requireInRange(mass14, MIN_MASS, MAX_MASS_100, "manganese");
        }
        Mass mass15 = this.molybdenum;
        if (mass15 != null) {
            UtilsKt.requireInRange(mass15, MIN_MASS, MAX_MASS_100, "molybdenum");
        }
        Mass mass16 = this.monounsaturatedFat;
        if (mass16 != null) {
            UtilsKt.requireInRange(mass16, MIN_MASS, MAX_MASS_100K, "monounsaturatedFat");
        }
        Mass mass17 = this.niacin;
        if (mass17 != null) {
            UtilsKt.requireInRange(mass17, MIN_MASS, MAX_MASS_100, "niacin");
        }
        Mass mass18 = this.pantothenicAcid;
        if (mass18 != null) {
            UtilsKt.requireInRange(mass18, MIN_MASS, MAX_MASS_100, "pantothenicAcid");
        }
        Mass mass19 = this.phosphorus;
        if (mass19 != null) {
            UtilsKt.requireInRange(mass19, MIN_MASS, MAX_MASS_100, "phosphorus");
        }
        Mass mass20 = this.polyunsaturatedFat;
        if (mass20 != null) {
            UtilsKt.requireInRange(mass20, MIN_MASS, MAX_MASS_100K, "polyunsaturatedFat");
        }
        Mass mass21 = this.potassium;
        if (mass21 != null) {
            UtilsKt.requireInRange(mass21, MIN_MASS, MAX_MASS_100, "potassium");
        }
        Mass mass22 = this.protein;
        if (mass22 != null) {
            UtilsKt.requireInRange(mass22, MIN_MASS, MAX_MASS_100K, "protein");
        }
        Mass mass23 = this.riboflavin;
        if (mass23 != null) {
            UtilsKt.requireInRange(mass23, MIN_MASS, MAX_MASS_100, "riboflavin");
        }
        Mass mass24 = this.saturatedFat;
        if (mass24 != null) {
            UtilsKt.requireInRange(mass24, MIN_MASS, MAX_MASS_100K, "saturatedFat");
        }
        Mass mass25 = this.selenium;
        if (mass25 != null) {
            UtilsKt.requireInRange(mass25, MIN_MASS, MAX_MASS_100, "selenium");
        }
        Mass mass26 = this.sodium;
        if (mass26 != null) {
            UtilsKt.requireInRange(mass26, MIN_MASS, MAX_MASS_100, "sodium");
        }
        Mass mass27 = this.sugar;
        if (mass27 != null) {
            UtilsKt.requireInRange(mass27, MIN_MASS, MAX_MASS_100K, "sugar");
        }
        Mass mass28 = this.thiamin;
        if (mass28 != null) {
            UtilsKt.requireInRange(mass28, MIN_MASS, MAX_MASS_100, "thiamin");
        }
        Mass mass29 = this.totalCarbohydrate;
        if (mass29 != null) {
            UtilsKt.requireInRange(mass29, MIN_MASS, MAX_MASS_100K, "totalCarbohydrate");
        }
        Mass mass30 = this.totalFat;
        if (mass30 != null) {
            UtilsKt.requireInRange(mass30, MIN_MASS, MAX_MASS_100K, "totalFat");
        }
        Mass mass31 = this.transFat;
        if (mass31 != null) {
            UtilsKt.requireInRange(mass31, MIN_MASS, MAX_MASS_100K, "transFat");
        }
        Mass mass32 = this.unsaturatedFat;
        if (mass32 != null) {
            UtilsKt.requireInRange(mass32, MIN_MASS, MAX_MASS_100K, "unsaturatedFat");
        }
        Mass mass33 = this.vitaminA;
        if (mass33 != null) {
            UtilsKt.requireInRange(mass33, MIN_MASS, MAX_MASS_100, "vitaminA");
        }
        Mass mass34 = this.vitaminB12;
        if (mass34 != null) {
            UtilsKt.requireInRange(mass34, MIN_MASS, MAX_MASS_100, "vitaminB12");
        }
        Mass mass35 = this.vitaminB6;
        if (mass35 != null) {
            UtilsKt.requireInRange(mass35, MIN_MASS, MAX_MASS_100, "vitaminB6");
        }
        Mass mass36 = this.vitaminC;
        if (mass36 != null) {
            UtilsKt.requireInRange(mass36, MIN_MASS, MAX_MASS_100, "vitaminC");
        }
        Mass mass37 = this.vitaminD;
        if (mass37 != null) {
            UtilsKt.requireInRange(mass37, MIN_MASS, MAX_MASS_100, "vitaminD");
        }
        Mass mass38 = this.vitaminE;
        if (mass38 != null) {
            UtilsKt.requireInRange(mass38, MIN_MASS, MAX_MASS_100, "vitaminE");
        }
        Mass mass39 = this.vitaminK;
        if (mass39 != null) {
            UtilsKt.requireInRange(mass39, MIN_MASS, MAX_MASS_100, "vitaminK");
        }
        Mass mass40 = this.zinc;
        if (mass40 != null) {
            UtilsKt.requireInRange(mass40, MIN_MASS, MAX_MASS_100, "zinc");
        }
    }

    public /* synthetic */ NutritionRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, androidx.health.connect.client.records.metadata.Metadata metadata, Mass mass, Mass mass2, Mass mass3, Energy energy, Energy energy2, Mass mass4, Mass mass5, Mass mass6, Mass mass7, Mass mass8, Mass mass9, Mass mass10, Mass mass11, Mass mass12, Mass mass13, Mass mass14, Mass mass15, Mass mass16, Mass mass17, Mass mass18, Mass mass19, Mass mass20, Mass mass21, Mass mass22, Mass mass23, Mass mass24, Mass mass25, Mass mass26, Mass mass27, Mass mass28, Mass mass29, Mass mass30, Mass mass31, Mass mass32, Mass mass33, Mass mass34, Mass mass35, Mass mass36, Mass mass37, Mass mass38, Mass mass39, Mass mass40, String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, instant2, zoneOffset2, metadata, (i2 & 32) != 0 ? null : mass, (i2 & 64) != 0 ? null : mass2, (i2 & 128) != 0 ? null : mass3, (i2 & 256) != 0 ? null : energy, (i2 & 512) != 0 ? null : energy2, (i2 & 1024) != 0 ? null : mass4, (i2 & 2048) != 0 ? null : mass5, (i2 & 4096) != 0 ? null : mass6, (i2 & 8192) != 0 ? null : mass7, (i2 & 16384) != 0 ? null : mass8, (i2 & 32768) != 0 ? null : mass9, (i2 & 65536) != 0 ? null : mass10, (131072 & i2) != 0 ? null : mass11, (262144 & i2) != 0 ? null : mass12, (524288 & i2) != 0 ? null : mass13, (1048576 & i2) != 0 ? null : mass14, (2097152 & i2) != 0 ? null : mass15, (4194304 & i2) != 0 ? null : mass16, (8388608 & i2) != 0 ? null : mass17, (16777216 & i2) != 0 ? null : mass18, (33554432 & i2) != 0 ? null : mass19, (67108864 & i2) != 0 ? null : mass20, (134217728 & i2) != 0 ? null : mass21, (268435456 & i2) != 0 ? null : mass22, (536870912 & i2) != 0 ? null : mass23, (1073741824 & i2) != 0 ? null : mass24, (i2 & Integer.MIN_VALUE) != 0 ? null : mass25, (i3 & 1) != 0 ? null : mass26, (i3 & 2) != 0 ? null : mass27, (i3 & 4) != 0 ? null : mass28, (i3 & 8) != 0 ? null : mass29, (i3 & 16) != 0 ? null : mass30, (i3 & 32) != 0 ? null : mass31, (i3 & 64) != 0 ? null : mass32, (i3 & 128) != 0 ? null : mass33, (i3 & 256) != 0 ? null : mass34, (i3 & 512) != 0 ? null : mass35, (i3 & 1024) != 0 ? null : mass36, (i3 & 2048) != 0 ? null : mass37, (i3 & 4096) != 0 ? null : mass38, (i3 & 8192) != 0 ? null : mass39, (i3 & 16384) != 0 ? null : mass40, (i3 & 32768) != 0 ? null : str, (i3 & 65536) != 0 ? 0 : i);
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public Instant getStartTime() {
        return this.startTime;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public ZoneOffset getStartZoneOffset() {
        return this.startZoneOffset;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public Instant getEndTime() {
        return this.endTime;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public ZoneOffset getEndZoneOffset() {
        return this.endZoneOffset;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public final Mass getBiotin() {
        return this.biotin;
    }

    public final Mass getCaffeine() {
        return this.caffeine;
    }

    public final Mass getCalcium() {
        return this.calcium;
    }

    public final Energy getEnergy() {
        return this.energy;
    }

    public final Energy getEnergyFromFat() {
        return this.energyFromFat;
    }

    public final Mass getChloride() {
        return this.chloride;
    }

    public final Mass getCholesterol() {
        return this.cholesterol;
    }

    public final Mass getChromium() {
        return this.chromium;
    }

    public final Mass getCopper() {
        return this.copper;
    }

    public final Mass getDietaryFiber() {
        return this.dietaryFiber;
    }

    public final Mass getFolate() {
        return this.folate;
    }

    public final Mass getFolicAcid() {
        return this.folicAcid;
    }

    public final Mass getIodine() {
        return this.iodine;
    }

    public final Mass getIron() {
        return this.iron;
    }

    public final Mass getMagnesium() {
        return this.magnesium;
    }

    public final Mass getManganese() {
        return this.manganese;
    }

    public final Mass getMolybdenum() {
        return this.molybdenum;
    }

    public final Mass getMonounsaturatedFat() {
        return this.monounsaturatedFat;
    }

    public final Mass getNiacin() {
        return this.niacin;
    }

    public final Mass getPantothenicAcid() {
        return this.pantothenicAcid;
    }

    public final Mass getPhosphorus() {
        return this.phosphorus;
    }

    public final Mass getPolyunsaturatedFat() {
        return this.polyunsaturatedFat;
    }

    public final Mass getPotassium() {
        return this.potassium;
    }

    public final Mass getProtein() {
        return this.protein;
    }

    public final Mass getRiboflavin() {
        return this.riboflavin;
    }

    public final Mass getSaturatedFat() {
        return this.saturatedFat;
    }

    public final Mass getSelenium() {
        return this.selenium;
    }

    public final Mass getSodium() {
        return this.sodium;
    }

    public final Mass getSugar() {
        return this.sugar;
    }

    public final Mass getThiamin() {
        return this.thiamin;
    }

    public final Mass getTotalCarbohydrate() {
        return this.totalCarbohydrate;
    }

    public final Mass getTotalFat() {
        return this.totalFat;
    }

    public final Mass getTransFat() {
        return this.transFat;
    }

    public final Mass getUnsaturatedFat() {
        return this.unsaturatedFat;
    }

    public final Mass getVitaminA() {
        return this.vitaminA;
    }

    public final Mass getVitaminB12() {
        return this.vitaminB12;
    }

    public final Mass getVitaminB6() {
        return this.vitaminB6;
    }

    public final Mass getVitaminC() {
        return this.vitaminC;
    }

    public final Mass getVitaminD() {
        return this.vitaminD;
    }

    public final Mass getVitaminE() {
        return this.vitaminE;
    }

    public final Mass getVitaminK() {
        return this.vitaminK;
    }

    public final Mass getZinc() {
        return this.zinc;
    }

    public final String getName() {
        return this.name;
    }

    public final int getMealType() {
        return this.mealType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof NutritionRecord) && Intrinsics.areEqual(this.biotin, ((NutritionRecord) other).biotin) && Intrinsics.areEqual(this.caffeine, ((NutritionRecord) other).caffeine) && Intrinsics.areEqual(this.calcium, ((NutritionRecord) other).calcium) && Intrinsics.areEqual(this.energy, ((NutritionRecord) other).energy) && Intrinsics.areEqual(this.energyFromFat, ((NutritionRecord) other).energyFromFat) && Intrinsics.areEqual(this.chloride, ((NutritionRecord) other).chloride) && Intrinsics.areEqual(this.cholesterol, ((NutritionRecord) other).cholesterol) && Intrinsics.areEqual(this.chromium, ((NutritionRecord) other).chromium) && Intrinsics.areEqual(this.copper, ((NutritionRecord) other).copper) && Intrinsics.areEqual(this.dietaryFiber, ((NutritionRecord) other).dietaryFiber) && Intrinsics.areEqual(this.folate, ((NutritionRecord) other).folate) && Intrinsics.areEqual(this.folicAcid, ((NutritionRecord) other).folicAcid) && Intrinsics.areEqual(this.iodine, ((NutritionRecord) other).iodine) && Intrinsics.areEqual(this.iron, ((NutritionRecord) other).iron) && Intrinsics.areEqual(this.magnesium, ((NutritionRecord) other).magnesium) && Intrinsics.areEqual(this.manganese, ((NutritionRecord) other).manganese) && Intrinsics.areEqual(this.molybdenum, ((NutritionRecord) other).molybdenum) && Intrinsics.areEqual(this.monounsaturatedFat, ((NutritionRecord) other).monounsaturatedFat) && Intrinsics.areEqual(this.niacin, ((NutritionRecord) other).niacin) && Intrinsics.areEqual(this.pantothenicAcid, ((NutritionRecord) other).pantothenicAcid) && Intrinsics.areEqual(this.phosphorus, ((NutritionRecord) other).phosphorus) && Intrinsics.areEqual(this.polyunsaturatedFat, ((NutritionRecord) other).polyunsaturatedFat) && Intrinsics.areEqual(this.potassium, ((NutritionRecord) other).potassium) && Intrinsics.areEqual(this.protein, ((NutritionRecord) other).protein) && Intrinsics.areEqual(this.riboflavin, ((NutritionRecord) other).riboflavin) && Intrinsics.areEqual(this.saturatedFat, ((NutritionRecord) other).saturatedFat) && Intrinsics.areEqual(this.selenium, ((NutritionRecord) other).selenium) && Intrinsics.areEqual(this.sodium, ((NutritionRecord) other).sodium) && Intrinsics.areEqual(this.sugar, ((NutritionRecord) other).sugar) && Intrinsics.areEqual(this.thiamin, ((NutritionRecord) other).thiamin) && Intrinsics.areEqual(this.totalCarbohydrate, ((NutritionRecord) other).totalCarbohydrate) && Intrinsics.areEqual(this.totalFat, ((NutritionRecord) other).totalFat) && Intrinsics.areEqual(this.transFat, ((NutritionRecord) other).transFat) && Intrinsics.areEqual(this.unsaturatedFat, ((NutritionRecord) other).unsaturatedFat) && Intrinsics.areEqual(this.vitaminA, ((NutritionRecord) other).vitaminA) && Intrinsics.areEqual(this.vitaminB12, ((NutritionRecord) other).vitaminB12) && Intrinsics.areEqual(this.vitaminB6, ((NutritionRecord) other).vitaminB6) && Intrinsics.areEqual(this.vitaminC, ((NutritionRecord) other).vitaminC) && Intrinsics.areEqual(this.vitaminD, ((NutritionRecord) other).vitaminD) && Intrinsics.areEqual(this.vitaminE, ((NutritionRecord) other).vitaminE) && Intrinsics.areEqual(this.vitaminK, ((NutritionRecord) other).vitaminK) && Intrinsics.areEqual(this.zinc, ((NutritionRecord) other).zinc) && Intrinsics.areEqual(this.name, ((NutritionRecord) other).name) && this.mealType == ((NutritionRecord) other).mealType && Intrinsics.areEqual(getStartTime(), ((NutritionRecord) other).getStartTime()) && Intrinsics.areEqual(getStartZoneOffset(), ((NutritionRecord) other).getStartZoneOffset()) && Intrinsics.areEqual(getEndTime(), ((NutritionRecord) other).getEndTime()) && Intrinsics.areEqual(getEndZoneOffset(), ((NutritionRecord) other).getEndZoneOffset()) && Intrinsics.areEqual(getMetadata(), ((NutritionRecord) other).getMetadata());
    }

    public int hashCode() {
        Mass mass = this.biotin;
        int result = mass != null ? mass.hashCode() : 0;
        int i = result * 31;
        Mass mass2 = this.caffeine;
        int result2 = i + (mass2 != null ? mass2.hashCode() : 0);
        int result3 = result2 * 31;
        Mass mass3 = this.calcium;
        int result4 = (result3 + (mass3 != null ? mass3.hashCode() : 0)) * 31;
        Energy energy = this.energy;
        int result5 = (result4 + (energy != null ? energy.hashCode() : 0)) * 31;
        Energy energy2 = this.energyFromFat;
        int result6 = (result5 + (energy2 != null ? energy2.hashCode() : 0)) * 31;
        Mass mass4 = this.chloride;
        int result7 = (result6 + (mass4 != null ? mass4.hashCode() : 0)) * 31;
        Mass mass5 = this.cholesterol;
        int result8 = (result7 + (mass5 != null ? mass5.hashCode() : 0)) * 31;
        Mass mass6 = this.chromium;
        int result9 = (result8 + (mass6 != null ? mass6.hashCode() : 0)) * 31;
        Mass mass7 = this.copper;
        int result10 = (result9 + (mass7 != null ? mass7.hashCode() : 0)) * 31;
        Mass mass8 = this.dietaryFiber;
        int result11 = (result10 + (mass8 != null ? mass8.hashCode() : 0)) * 31;
        Mass mass9 = this.folate;
        int result12 = (result11 + (mass9 != null ? mass9.hashCode() : 0)) * 31;
        Mass mass10 = this.folicAcid;
        int result13 = (result12 + (mass10 != null ? mass10.hashCode() : 0)) * 31;
        Mass mass11 = this.iodine;
        int result14 = (result13 + (mass11 != null ? mass11.hashCode() : 0)) * 31;
        Mass mass12 = this.iron;
        int result15 = (result14 + (mass12 != null ? mass12.hashCode() : 0)) * 31;
        Mass mass13 = this.magnesium;
        int result16 = (result15 + (mass13 != null ? mass13.hashCode() : 0)) * 31;
        Mass mass14 = this.manganese;
        int result17 = (result16 + (mass14 != null ? mass14.hashCode() : 0)) * 31;
        Mass mass15 = this.molybdenum;
        int result18 = (result17 + (mass15 != null ? mass15.hashCode() : 0)) * 31;
        Mass mass16 = this.monounsaturatedFat;
        int result19 = (result18 + (mass16 != null ? mass16.hashCode() : 0)) * 31;
        Mass mass17 = this.niacin;
        int result20 = (result19 + (mass17 != null ? mass17.hashCode() : 0)) * 31;
        Mass mass18 = this.pantothenicAcid;
        int result21 = (result20 + (mass18 != null ? mass18.hashCode() : 0)) * 31;
        Mass mass19 = this.phosphorus;
        int result22 = (result21 + (mass19 != null ? mass19.hashCode() : 0)) * 31;
        Mass mass20 = this.polyunsaturatedFat;
        int result23 = (result22 + (mass20 != null ? mass20.hashCode() : 0)) * 31;
        Mass mass21 = this.potassium;
        int result24 = (result23 + (mass21 != null ? mass21.hashCode() : 0)) * 31;
        Mass mass22 = this.protein;
        int result25 = (result24 + (mass22 != null ? mass22.hashCode() : 0)) * 31;
        Mass mass23 = this.riboflavin;
        int result26 = (result25 + (mass23 != null ? mass23.hashCode() : 0)) * 31;
        Mass mass24 = this.saturatedFat;
        int result27 = (result26 + (mass24 != null ? mass24.hashCode() : 0)) * 31;
        Mass mass25 = this.selenium;
        int result28 = (result27 + (mass25 != null ? mass25.hashCode() : 0)) * 31;
        Mass mass26 = this.sodium;
        int result29 = (result28 + (mass26 != null ? mass26.hashCode() : 0)) * 31;
        Mass mass27 = this.sugar;
        int result30 = (result29 + (mass27 != null ? mass27.hashCode() : 0)) * 31;
        Mass mass28 = this.thiamin;
        int result31 = (result30 + (mass28 != null ? mass28.hashCode() : 0)) * 31;
        Mass mass29 = this.totalCarbohydrate;
        int result32 = (result31 + (mass29 != null ? mass29.hashCode() : 0)) * 31;
        Mass mass30 = this.totalFat;
        int result33 = (result32 + (mass30 != null ? mass30.hashCode() : 0)) * 31;
        Mass mass31 = this.transFat;
        int result34 = (result33 + (mass31 != null ? mass31.hashCode() : 0)) * 31;
        Mass mass32 = this.unsaturatedFat;
        int result35 = (result34 + (mass32 != null ? mass32.hashCode() : 0)) * 31;
        Mass mass33 = this.vitaminA;
        int result36 = (result35 + (mass33 != null ? mass33.hashCode() : 0)) * 31;
        Mass mass34 = this.vitaminB12;
        int result37 = (result36 + (mass34 != null ? mass34.hashCode() : 0)) * 31;
        Mass mass35 = this.vitaminB6;
        int result38 = (result37 + (mass35 != null ? mass35.hashCode() : 0)) * 31;
        Mass mass36 = this.vitaminC;
        int result39 = (result38 + (mass36 != null ? mass36.hashCode() : 0)) * 31;
        Mass mass37 = this.vitaminD;
        int result40 = (result39 + (mass37 != null ? mass37.hashCode() : 0)) * 31;
        Mass mass38 = this.vitaminE;
        int result41 = (result40 + (mass38 != null ? mass38.hashCode() : 0)) * 31;
        Mass mass39 = this.vitaminK;
        int result42 = (result41 + (mass39 != null ? mass39.hashCode() : 0)) * 31;
        Mass mass40 = this.zinc;
        int result43 = (result42 + (mass40 != null ? mass40.hashCode() : 0)) * 31;
        String str = this.name;
        int result44 = (((((result43 + (str != null ? str.hashCode() : 0)) * 31) + this.mealType) * 31) + getStartTime().hashCode()) * 31;
        ZoneOffset startZoneOffset = getStartZoneOffset();
        int result45 = (((result44 + (startZoneOffset != null ? startZoneOffset.hashCode() : 0)) * 31) + getEndTime().hashCode()) * 31;
        ZoneOffset endZoneOffset = getEndZoneOffset();
        return ((result45 + (endZoneOffset != null ? endZoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NutritionRecord(startTime=").append(getStartTime()).append(", startZoneOffset=").append(getStartZoneOffset()).append(", endTime=").append(getEndTime()).append(", endZoneOffset=").append(getEndZoneOffset()).append(", biotin=").append(this.biotin).append(", caffeine=").append(this.caffeine).append(", calcium=").append(this.calcium).append(", energy=").append(this.energy).append(", energyFromFat=").append(this.energyFromFat).append(", chloride=").append(this.chloride).append(", cholesterol=").append(this.cholesterol).append(", chromium=");
        sb.append(this.chromium).append(", copper=").append(this.copper).append(", dietaryFiber=").append(this.dietaryFiber).append(", folate=").append(this.folate).append(", folicAcid=").append(this.folicAcid).append(", iodine=").append(this.iodine).append(", iron=").append(this.iron).append(", magnesium=").append(this.magnesium).append(", manganese=").append(this.manganese).append(", molybdenum=").append(this.molybdenum).append(", monounsaturatedFat=").append(this.monounsaturatedFat).append(", niacin=").append(this.niacin);
        sb.append(", pantothenicAcid=").append(this.pantothenicAcid).append(", phosphorus=").append(this.phosphorus).append(", polyunsaturatedFat=").append(this.polyunsaturatedFat).append(", potassium=").append(this.potassium).append(", protein=").append(this.protein).append(", riboflavin=").append(this.riboflavin).append(", saturatedFat=").append(this.saturatedFat).append(", selenium=").append(this.selenium).append(", sodium=").append(this.sodium).append(", sugar=").append(this.sugar).append(", thiamin=").append(this.thiamin).append(", totalCarbohydrate=");
        sb.append(this.totalCarbohydrate).append(", totalFat=").append(this.totalFat).append(", transFat=").append(this.transFat).append(", unsaturatedFat=").append(this.unsaturatedFat).append(", vitaminA=").append(this.vitaminA).append(", vitaminB12=").append(this.vitaminB12).append(", vitaminB6=").append(this.vitaminB6).append(", vitaminC=").append(this.vitaminC).append(", vitaminD=").append(this.vitaminD).append(", vitaminE=").append(this.vitaminE).append(", vitaminK=").append(this.vitaminK).append(", zinc=").append(this.zinc);
        sb.append(", name=").append(this.name).append(", mealType=").append(this.mealType).append(", metadata=").append(getMetadata()).append(')');
        return sb.toString();
    }

    static {
        Mass grams;
        Mass grams2;
        Mass grams3;
        Energy calories;
        Energy calories2;
        grams = MassKt.getGrams(0.0d);
        MIN_MASS = grams;
        grams2 = MassKt.getGrams(4.94E-322d);
        MAX_MASS_100 = grams2;
        grams3 = MassKt.getGrams((double) AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength);
        MAX_MASS_100K = grams3;
        calories = EnergyKt.getCalories(0.0d);
        MIN_ENERGY = calories;
        calories2 = EnergyKt.getCalories(4.94065646E-316d);
        MAX_ENERGY = calories2;
        BIOTIN_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "biotin", new NutritionRecord$Companion$BIOTIN_TOTAL$1(Mass.INSTANCE));
        CAFFEINE_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "caffeine", new NutritionRecord$Companion$CAFFEINE_TOTAL$1(Mass.INSTANCE));
        CALCIUM_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "calcium", new NutritionRecord$Companion$CALCIUM_TOTAL$1(Mass.INSTANCE));
        ENERGY_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "calories", new NutritionRecord$Companion$ENERGY_TOTAL$1(Energy.INSTANCE));
        ENERGY_FROM_FAT_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "caloriesFromFat", new NutritionRecord$Companion$ENERGY_FROM_FAT_TOTAL$1(Energy.INSTANCE));
        CHLORIDE_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "chloride", new NutritionRecord$Companion$CHLORIDE_TOTAL$1(Mass.INSTANCE));
        CHOLESTEROL_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "cholesterol", new NutritionRecord$Companion$CHOLESTEROL_TOTAL$1(Mass.INSTANCE));
        CHROMIUM_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "chromium", new NutritionRecord$Companion$CHROMIUM_TOTAL$1(Mass.INSTANCE));
        COPPER_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "copper", new NutritionRecord$Companion$COPPER_TOTAL$1(Mass.INSTANCE));
        DIETARY_FIBER_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "dietaryFiber", new NutritionRecord$Companion$DIETARY_FIBER_TOTAL$1(Mass.INSTANCE));
        FOLATE_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "folate", new NutritionRecord$Companion$FOLATE_TOTAL$1(Mass.INSTANCE));
        FOLIC_ACID_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "folicAcid", new NutritionRecord$Companion$FOLIC_ACID_TOTAL$1(Mass.INSTANCE));
        IODINE_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "iodine", new NutritionRecord$Companion$IODINE_TOTAL$1(Mass.INSTANCE));
        IRON_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "iron", new NutritionRecord$Companion$IRON_TOTAL$1(Mass.INSTANCE));
        MAGNESIUM_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "magnesium", new NutritionRecord$Companion$MAGNESIUM_TOTAL$1(Mass.INSTANCE));
        MANGANESE_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "manganese", new NutritionRecord$Companion$MANGANESE_TOTAL$1(Mass.INSTANCE));
        MOLYBDENUM_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "molybdenum", new NutritionRecord$Companion$MOLYBDENUM_TOTAL$1(Mass.INSTANCE));
        MONOUNSATURATED_FAT_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "monounsaturatedFat", new NutritionRecord$Companion$MONOUNSATURATED_FAT_TOTAL$1(Mass.INSTANCE));
        NIACIN_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "niacin", new NutritionRecord$Companion$NIACIN_TOTAL$1(Mass.INSTANCE));
        PANTOTHENIC_ACID_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "pantothenicAcid", new NutritionRecord$Companion$PANTOTHENIC_ACID_TOTAL$1(Mass.INSTANCE));
        PHOSPHORUS_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "phosphorus", new NutritionRecord$Companion$PHOSPHORUS_TOTAL$1(Mass.INSTANCE));
        POLYUNSATURATED_FAT_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "polyunsaturatedFat", new NutritionRecord$Companion$POLYUNSATURATED_FAT_TOTAL$1(Mass.INSTANCE));
        POTASSIUM_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "potassium", new NutritionRecord$Companion$POTASSIUM_TOTAL$1(Mass.INSTANCE));
        PROTEIN_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "protein", new NutritionRecord$Companion$PROTEIN_TOTAL$1(Mass.INSTANCE));
        RIBOFLAVIN_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "riboflavin", new NutritionRecord$Companion$RIBOFLAVIN_TOTAL$1(Mass.INSTANCE));
        SATURATED_FAT_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "saturatedFat", new NutritionRecord$Companion$SATURATED_FAT_TOTAL$1(Mass.INSTANCE));
        SELENIUM_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "selenium", new NutritionRecord$Companion$SELENIUM_TOTAL$1(Mass.INSTANCE));
        SODIUM_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "sodium", new NutritionRecord$Companion$SODIUM_TOTAL$1(Mass.INSTANCE));
        SUGAR_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "sugar", new NutritionRecord$Companion$SUGAR_TOTAL$1(Mass.INSTANCE));
        THIAMIN_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "thiamin", new NutritionRecord$Companion$THIAMIN_TOTAL$1(Mass.INSTANCE));
        TOTAL_CARBOHYDRATE_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "totalCarbohydrate", new NutritionRecord$Companion$TOTAL_CARBOHYDRATE_TOTAL$1(Mass.INSTANCE));
        TOTAL_FAT_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "totalFat", new NutritionRecord$Companion$TOTAL_FAT_TOTAL$1(Mass.INSTANCE));
        TRANS_FAT_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "transFat", new NutritionRecord$Companion$TRANS_FAT_TOTAL$1(Mass.INSTANCE));
        UNSATURATED_FAT_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "unsaturatedFat", new NutritionRecord$Companion$UNSATURATED_FAT_TOTAL$1(Mass.INSTANCE));
        VITAMIN_A_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "vitaminA", new NutritionRecord$Companion$VITAMIN_A_TOTAL$1(Mass.INSTANCE));
        VITAMIN_B12_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "vitaminB12", new NutritionRecord$Companion$VITAMIN_B12_TOTAL$1(Mass.INSTANCE));
        VITAMIN_B6_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "vitaminB6", new NutritionRecord$Companion$VITAMIN_B6_TOTAL$1(Mass.INSTANCE));
        VITAMIN_C_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "vitaminC", new NutritionRecord$Companion$VITAMIN_C_TOTAL$1(Mass.INSTANCE));
        VITAMIN_D_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "vitaminD", new NutritionRecord$Companion$VITAMIN_D_TOTAL$1(Mass.INSTANCE));
        VITAMIN_E_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "vitaminE", new NutritionRecord$Companion$VITAMIN_E_TOTAL$1(Mass.INSTANCE));
        VITAMIN_K_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "vitaminK", new NutritionRecord$Companion$VITAMIN_K_TOTAL$1(Mass.INSTANCE));
        ZINC_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, "zinc", new NutritionRecord$Companion$ZINC_TOTAL$1(Mass.INSTANCE));
    }
}
