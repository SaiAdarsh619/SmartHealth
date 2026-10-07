package androidx.health.connect.client.impl.platform.aggregate;

import android.os.ext.SdkExtensions;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.records.CyclingPedalingCadenceRecord;
import androidx.health.connect.client.records.NutritionRecord;
import androidx.health.connect.client.records.SpeedRecord;
import androidx.health.connect.client.records.StepsCadenceRecord;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.AggregateGroupByPeriodRequest;
import androidx.health.connect.client.request.AggregateRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AggregationExtensions.kt */
@Metadata(m286d1 = {"\u0000(\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u0002H\u0000\u001a$\u0010\u0007\u001a\u00020\b*\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00060\nH\u0000\u001a$\u0010\u0007\u001a\u00020\u000b*\u00020\u000b2\u0016\u0010\t\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00060\nH\u0000\u001a$\u0010\u0007\u001a\u00020\f*\u00020\f2\u0016\u0010\t\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00060\nH\u0000\"\u001e\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\r"}, m287d2 = {"AGGREGATE_METRICS_ADDED_IN_SDK_EXT_10", "", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "getAGGREGATE_METRICS_ADDED_IN_SDK_EXT_10", "()Ljava/util/Set;", "isPlatformSupportedMetric", "", "withFilteredMetrics", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "predicate", "Lkotlin/Function1;", "Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;", "Landroidx/health/connect/client/request/AggregateRequest;", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class AggregationExtensionsKt {
    private static final Set<AggregateMetric<?>> AGGREGATE_METRICS_ADDED_IN_SDK_EXT_10 = SetsKt.setOf((Object[]) new AggregateMetric[]{BloodPressureRecord.DIASTOLIC_AVG, BloodPressureRecord.DIASTOLIC_MAX, BloodPressureRecord.DIASTOLIC_MIN, BloodPressureRecord.SYSTOLIC_AVG, BloodPressureRecord.SYSTOLIC_MAX, BloodPressureRecord.SYSTOLIC_MIN, CyclingPedalingCadenceRecord.RPM_AVG, CyclingPedalingCadenceRecord.RPM_MAX, CyclingPedalingCadenceRecord.RPM_MIN, NutritionRecord.TRANS_FAT_TOTAL, SpeedRecord.SPEED_AVG, SpeedRecord.SPEED_MAX, SpeedRecord.SPEED_MIN, StepsCadenceRecord.RATE_AVG, StepsCadenceRecord.RATE_MAX, StepsCadenceRecord.RATE_MIN});

    public static final AggregateRequest withFilteredMetrics(AggregateRequest $this$withFilteredMetrics, Function1<? super AggregateMetric<?>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$withFilteredMetrics, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Iterable $this$filter$iv = $this$withFilteredMetrics.getMetrics$connect_client_release();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (predicate.invoke(element$iv$iv).booleanValue()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return new AggregateRequest(CollectionsKt.toSet((List) destination$iv$iv), $this$withFilteredMetrics.getTimeRangeFilter(), $this$withFilteredMetrics.getDataOriginFilter$connect_client_release());
    }

    public static final AggregateGroupByPeriodRequest withFilteredMetrics(AggregateGroupByPeriodRequest $this$withFilteredMetrics, Function1<? super AggregateMetric<?>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$withFilteredMetrics, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Iterable $this$filter$iv = $this$withFilteredMetrics.getMetrics$connect_client_release();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (predicate.invoke(element$iv$iv).booleanValue()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return new AggregateGroupByPeriodRequest(CollectionsKt.toSet((List) destination$iv$iv), $this$withFilteredMetrics.getTimeRangeFilter(), $this$withFilteredMetrics.getTimeRangeSlicer(), $this$withFilteredMetrics.getDataOriginFilter$connect_client_release());
    }

    public static final AggregateGroupByDurationRequest withFilteredMetrics(AggregateGroupByDurationRequest $this$withFilteredMetrics, Function1<? super AggregateMetric<?>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$withFilteredMetrics, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Iterable $this$filter$iv = $this$withFilteredMetrics.getMetrics$connect_client_release();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (predicate.invoke(element$iv$iv).booleanValue()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return new AggregateGroupByDurationRequest(CollectionsKt.toSet((List) destination$iv$iv), $this$withFilteredMetrics.getTimeRangeFilter(), $this$withFilteredMetrics.getTimeRangeSlicer(), $this$withFilteredMetrics.getDataOriginFilter$connect_client_release());
    }

    public static final boolean isPlatformSupportedMetric(AggregateMetric<?> aggregateMetric) {
        Intrinsics.checkNotNullParameter(aggregateMetric, "<this>");
        return SdkExtensions.getExtensionVersion(34) >= 10 || !AGGREGATE_METRICS_ADDED_IN_SDK_EXT_10.contains(aggregateMetric);
    }

    public static final Set<AggregateMetric<?>> getAGGREGATE_METRICS_ADDED_IN_SDK_EXT_10() {
        return AGGREGATE_METRICS_ADDED_IN_SDK_EXT_10;
    }
}
