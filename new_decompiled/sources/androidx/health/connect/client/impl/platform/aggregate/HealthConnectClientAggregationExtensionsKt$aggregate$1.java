package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.records.Record;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HealthConnectClientAggregationExtensions.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt", m297f = "HealthConnectClientAggregationExtensions.kt", m298i = {0}, m299l = {153}, m300m = "aggregate", m301n = {"aggregator"}, m302s = {"L$0"})
/* loaded from: classes14.dex */
final class HealthConnectClientAggregationExtensionsKt$aggregate$1<T extends Record, R> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    HealthConnectClientAggregationExtensionsKt$aggregate$1(Continuation<? super HealthConnectClientAggregationExtensionsKt$aggregate$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HealthConnectClientAggregationExtensionsKt.aggregate(null, null, null, this);
    }
}
