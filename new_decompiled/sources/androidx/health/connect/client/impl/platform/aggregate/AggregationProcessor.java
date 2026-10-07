package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.records.Record;
import kotlin.Metadata;

/* compiled from: AggregationProcessor.kt */
@Metadata(m286d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, m287d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/AggregationProcessor;", "T", "Landroidx/health/connect/client/records/Record;", "", "getProcessedAggregationResult", "Landroidx/health/connect/client/aggregate/AggregationResult;", "processRecord", "", "record", "(Landroidx/health/connect/client/records/Record;)V", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public interface AggregationProcessor<T extends Record> {
    AggregationResult getProcessedAggregationResult();

    void processRecord(T record);
}
