package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.records.NutritionRecord;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.units.Mass;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NutritionAggregationExtensions.kt */
@Metadata(m286d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m287d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/TransFatTotalAggregationProcessor;", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationProcessor;", "Landroidx/health/connect/client/records/NutritionRecord;", "timeRange", "Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;", "(Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;)V", "dataOrigins", "", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "total", "", "getProcessedAggregationResult", "Landroidx/health/connect/client/aggregate/AggregationResult;", "processRecord", "", "record", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class TransFatTotalAggregationProcessor implements AggregationProcessor<NutritionRecord> {
    private final Set<DataOrigin> dataOrigins;
    private final TimeRange<?> timeRange;
    private double total;

    public TransFatTotalAggregationProcessor(TimeRange<?> timeRange) {
        Intrinsics.checkNotNullParameter(timeRange, "timeRange");
        this.timeRange = timeRange;
        this.dataOrigins = new LinkedHashSet();
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.AggregationProcessor
    public void processRecord(NutritionRecord record) {
        Intrinsics.checkNotNullParameter(record, "record");
        double d = this.total;
        Mass transFat = record.getTransFat();
        Intrinsics.checkNotNull(transFat);
        this.total = d + (transFat.getGrams() * AggregatorUtils.INSTANCE.sliceFactor$connect_client_release(record, this.timeRange));
        this.dataOrigins.add(record.getMetadata().getDataOrigin());
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.AggregationProcessor
    public AggregationResult getProcessedAggregationResult() {
        Map doubleValues = this.dataOrigins.isEmpty() ? MapsKt.emptyMap() : MapsKt.mapOf(TuplesKt.m294to(NutritionRecord.TRANS_FAT_TOTAL.getMetricKey(), Double.valueOf(this.total)));
        return new AggregationResult(MapsKt.emptyMap(), doubleValues, this.dataOrigins);
    }
}
