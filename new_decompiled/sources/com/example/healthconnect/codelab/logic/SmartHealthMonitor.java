package com.example.healthconnect.codelab.logic;

import androidx.health.connect.client.records.HeartRateRecord;
import androidx.health.connect.client.records.Vo2MaxRecord;
import com.example.healthconnect.codelab.data.UserProfileManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: SmartHealthMonitor.kt */
@Metadata(m286d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001c\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ$\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m287d2 = {"Lcom/example/healthconnect/codelab/logic/SmartHealthMonitor;", "", "userProfile", "Lcom/example/healthconnect/codelab/data/UserProfileManager;", "(Lcom/example/healthconnect/codelab/data/UserProfileManager;)V", "assessSpO2Status", "Lcom/example/healthconnect/codelab/logic/HealthAlert;", "currentSpO2", "", "assessStatus", "Lcom/example/healthconnect/codelab/logic/MonitorResult;", "currentHr", "history", "", "Landroidx/health/connect/client/records/HeartRateRecord;", "computeBaseline", "Lcom/example/healthconnect/codelab/logic/SmartHealthMonitor$Baseline;", "getHistoryDurationDays", "", "getMedicalReferenceRange", "Lkotlin/Pair;", "age", "isAthlete", "", "getPhase", "Lcom/example/healthconnect/codelab/logic/SystemPhase;", "dataDurationDays", "recordCount", "Baseline", "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes5.dex */
public final class SmartHealthMonitor {
    public static final int $stable = 8;
    private final UserProfileManager userProfile;

    /* compiled from: SmartHealthMonitor.kt */
    @Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SystemPhase.values().length];
            try {
                iArr[SystemPhase.COLD_START.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SystemPhase.HYBRID.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SystemPhase.PERSONALIZED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SmartHealthMonitor(UserProfileManager userProfile) {
        Intrinsics.checkNotNullParameter(userProfile, "userProfile");
        this.userProfile = userProfile;
    }

    private final Pair<Integer, Integer> getMedicalReferenceRange(int age, boolean isAthlete) {
        if (isAthlete) {
            return TuplesKt.m294to(45, 90);
        }
        if (age >= 18 && age >= 60) {
            return TuplesKt.m294to(55, 95);
        }
        return TuplesKt.m294to(60, 100);
    }

    /* compiled from: SmartHealthMonitor.kt */
    @Metadata(m286d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, m287d2 = {"Lcom/example/healthconnect/codelab/logic/SmartHealthMonitor$Baseline;", "", "min", "", "max", "average", "dataDurationDays", "", "(IIID)V", "getAverage", "()I", "getDataDurationDays", "()D", "getMax", "getMin", "component1", "component2", "component3", "component4", "copy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "toString", "", "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final /* data */ class Baseline {
        public static final int $stable = 0;
        private final int average;
        private final double dataDurationDays;
        private final int max;
        private final int min;

        public static /* synthetic */ Baseline copy$default(Baseline baseline, int i, int i2, int i3, double d, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = baseline.min;
            }
            if ((i4 & 2) != 0) {
                i2 = baseline.max;
            }
            int i5 = i2;
            if ((i4 & 4) != 0) {
                i3 = baseline.average;
            }
            int i6 = i3;
            if ((i4 & 8) != 0) {
                d = baseline.dataDurationDays;
            }
            return baseline.copy(i, i5, i6, d);
        }

        /* renamed from: component1, reason: from getter */
        public final int getMin() {
            return this.min;
        }

        /* renamed from: component2, reason: from getter */
        public final int getMax() {
            return this.max;
        }

        /* renamed from: component3, reason: from getter */
        public final int getAverage() {
            return this.average;
        }

        /* renamed from: component4, reason: from getter */
        public final double getDataDurationDays() {
            return this.dataDurationDays;
        }

        public final Baseline copy(int min, int max, int average, double dataDurationDays) {
            return new Baseline(min, max, average, dataDurationDays);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Baseline)) {
                return false;
            }
            Baseline baseline = (Baseline) other;
            return this.min == baseline.min && this.max == baseline.max && this.average == baseline.average && Double.compare(this.dataDurationDays, baseline.dataDurationDays) == 0;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.min) * 31) + Integer.hashCode(this.max)) * 31) + Integer.hashCode(this.average)) * 31) + Double.hashCode(this.dataDurationDays);
        }

        public String toString() {
            return "Baseline(min=" + this.min + ", max=" + this.max + ", average=" + this.average + ", dataDurationDays=" + this.dataDurationDays + ')';
        }

        public Baseline(int min, int max, int average, double dataDurationDays) {
            this.min = min;
            this.max = max;
            this.average = average;
            this.dataDurationDays = dataDurationDays;
        }

        public final int getAverage() {
            return this.average;
        }

        public final double getDataDurationDays() {
            return this.dataDurationDays;
        }

        public final int getMax() {
            return this.max;
        }

        public final int getMin() {
            return this.min;
        }
    }

    public final SystemPhase getPhase(double dataDurationDays, int recordCount) {
        if (dataDurationDays < 1.0d || recordCount < 10) {
            return SystemPhase.COLD_START;
        }
        if (dataDurationDays < 7.0d || recordCount < 30) {
            return SystemPhase.HYBRID;
        }
        return SystemPhase.PERSONALIZED;
    }

    public final double getHistoryDurationDays(List<HeartRateRecord> history) {
        Intrinsics.checkNotNullParameter(history, "history");
        if (history.isEmpty()) {
            return 0.0d;
        }
        List<HeartRateRecord> $this$map$iv = history;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            HeartRateRecord it = (HeartRateRecord) item$iv$iv;
            destination$iv$iv.add(Long.valueOf(it.getStartTime().getEpochSecond()));
        }
        List startTimes = (List) destination$iv$iv;
        Long l = (Long) CollectionsKt.minOrNull((Iterable) startTimes);
        long earliest = l != null ? l.longValue() : 0L;
        Long l2 = (Long) CollectionsKt.maxOrNull((Iterable) startTimes);
        long latest = l2 != null ? l2.longValue() : 0L;
        long diffSeconds = RangesKt.coerceAtLeast(latest - earliest, 0L);
        return diffSeconds / 86400.0d;
    }

    public final Baseline computeBaseline(List<HeartRateRecord> history) {
        Intrinsics.checkNotNullParameter(history, "history");
        if (history.isEmpty()) {
            return null;
        }
        double days = getHistoryDurationDays(history);
        List<HeartRateRecord> $this$flatMap$iv = history;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            HeartRateRecord it = (HeartRateRecord) element$iv$iv;
            Iterable list$iv$iv = it.getSamples();
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            HeartRateRecord.Sample it2 = (HeartRateRecord.Sample) item$iv$iv;
            destination$iv$iv2.add(Integer.valueOf((int) it2.getBeatsPerMinute()));
        }
        List allSamples = (List) destination$iv$iv2;
        if (allSamples.size() < 5) {
            return null;
        }
        Integer num = (Integer) CollectionsKt.minOrNull((Iterable) allSamples);
        int min = num != null ? num.intValue() : 60;
        Integer num2 = (Integer) CollectionsKt.maxOrNull((Iterable) allSamples);
        int max = num2 != null ? num2.intValue() : 100;
        int average = (int) CollectionsKt.averageOfInt(allSamples);
        return new Baseline(min, max, average, days);
    }

    public final MonitorResult assessStatus(int currentHr, List<HeartRateRecord> history) {
        HealthAlert healthAlert;
        Intrinsics.checkNotNullParameter(history, "history");
        int age = this.userProfile.getAge();
        boolean hasCondition = this.userProfile.getHasHeartCondition();
        boolean isAthlete = this.userProfile.isAthlete();
        Pair<Integer, Integer> medicalReferenceRange = getMedicalReferenceRange(age, isAthlete);
        int safeMin = medicalReferenceRange.component1().intValue();
        int safeMax = medicalReferenceRange.component2().intValue();
        if (currentHr >= 40 && currentHr <= 180) {
            Baseline baseline = computeBaseline(history);
            double daysHistory = baseline != null ? baseline.getDataDurationDays() : 0.0d;
            SystemPhase phase = getPhase(daysHistory, history.size());
            switch (WhenMappings.$EnumSwitchMapping$0[phase.ordinal()]) {
                case 1:
                    if (currentHr <= safeMax && currentHr >= safeMin) {
                        healthAlert = new HealthAlert(AlertStatus.NORMAL, "Vitals are normal.", "Ph1 [Cold Start]: Within Medical Range (" + safeMin + '-' + safeMax + ')');
                        break;
                    } else {
                        AlertStatus status = (currentHr > safeMax + 15 || currentHr < safeMin + (-10)) ? AlertStatus.CRITICAL : AlertStatus.WARNING;
                        healthAlert = new HealthAlert(status, "Warning: Heart Rate " + currentHr + " bpm is outside medical norms (" + safeMin + '-' + safeMax + ").", "Ph1 [Cold Start]: Medical Range Check");
                        break;
                    }
                    break;
                case 2:
                    if (currentHr <= safeMax && currentHr >= safeMin) {
                        HealthAlert alert = new HealthAlert(AlertStatus.NORMAL, "Vitals are normal.", "Ph2 [Hybrid]: Normal");
                        if (baseline != null && (currentHr > baseline.getMax() + 15 || currentHr < baseline.getMin() - 15)) {
                            HealthAlert alert2 = new HealthAlert(AlertStatus.WARNING, "Notice: Unusual activity detected (" + currentHr + "). Learning your baseline...", "Ph2 [Hybrid]: Weak Baseline Deviation");
                            healthAlert = alert2;
                            break;
                        } else {
                            healthAlert = alert;
                            break;
                        }
                    } else {
                        AlertStatus status2 = currentHr > safeMax + 20 ? AlertStatus.CRITICAL : AlertStatus.WARNING;
                        healthAlert = new HealthAlert(status2, "Warning: Heart Rate " + currentHr + " bpm is outside medical norms.", "Ph2 [Hybrid]: Medical Range Exceeded");
                        break;
                    }
                    break;
                case 3:
                    int padding = hasCondition ? 5 : 10;
                    if (isAthlete) {
                        padding = 12;
                    }
                    if (age > 60) {
                        padding = 12;
                    }
                    if (baseline == null) {
                        healthAlert = new HealthAlert(AlertStatus.NORMAL, "Vitals are normal.", "Ph3 [Personalized]: Missing Baseline Data");
                        break;
                    } else {
                        int pMin = baseline.getMin() - padding;
                        int age2 = baseline.getMax() + padding;
                        if (currentHr <= age2 && currentHr >= pMin) {
                            healthAlert = new HealthAlert(AlertStatus.NORMAL, "Vitals are normal.", "Ph3 [Personalized]: Within Personal Range");
                            break;
                        }
                        if (currentHr <= safeMax + 10 && currentHr >= safeMin - 5) {
                            healthAlert = new HealthAlert(AlertStatus.WARNING, "Warning: Rate " + currentHr + " is unusual for your history (" + pMin + '-' + age2 + ").", "Ph3 [Personalized]: Baseline Anomaly");
                            break;
                        }
                        healthAlert = new HealthAlert(AlertStatus.CRITICAL, "Critical: Heart Rate " + currentHr + " is abnormal for you AND medically high.", "Ph3 [Personalized]: Baseline + Medical Critical");
                        break;
                    }
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            HealthAlert resultAlert = healthAlert;
            return new MonitorResult(resultAlert, baseline, phase, MapsKt.mapOf(TuplesKt.m294to("hr", Integer.valueOf(currentHr)), TuplesKt.m294to("safeMin", Integer.valueOf(safeMin)), TuplesKt.m294to("safeMax", Integer.valueOf(safeMax)), TuplesKt.m294to("historyCount", Integer.valueOf(history.size())), TuplesKt.m294to("daysHistory", Double.valueOf(daysHistory))));
        }
        HealthAlert alert3 = new HealthAlert(AlertStatus.CRITICAL, "Critical: Heart Rate " + currentHr + " bpm is EXTREME (Danger Zone).", "L1: Hard Safety Limit Hit (<40 or >180)");
        return new MonitorResult(alert3, null, SystemPhase.COLD_START, MapsKt.mapOf(TuplesKt.m294to("hr", Integer.valueOf(currentHr)), TuplesKt.m294to("trigger", "hard_limit")));
    }

    public final HealthAlert assessSpO2Status(int currentSpO2) {
        return currentSpO2 < 90 ? new HealthAlert(AlertStatus.CRITICAL, "CRITICAL: SpO2 " + currentSpO2 + "% is Dangerously LOW.", "SpO2 Hard Limit (<90%)") : currentSpO2 < 92 ? new HealthAlert(AlertStatus.WARNING, "Warning: SpO2 " + currentSpO2 + "% is Low (Hypoxia risk).", "SpO2 Warning (<92%)") : currentSpO2 < 95 ? new HealthAlert(AlertStatus.WARNING, "Notice: SpO2 " + currentSpO2 + "% is slightly below normal.", "SpO2 Notice (<95%)") : new HealthAlert(AlertStatus.NORMAL, "SpO2 is normal.", "SpO2 Normal (>=95%)");
    }
}
