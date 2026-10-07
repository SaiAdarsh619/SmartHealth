package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.request.AggregateRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HealthConnectClientAggregationExtensions.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt", m297f = "HealthConnectClientAggregationExtensions.kt", m298i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4}, m299l = {63, 190, 66, 200, 210}, m300m = "aggregateFallback", m301n = {"$this$aggregateFallback", "destination$iv$iv", "$this$aggregateFallback", "destination$iv$iv", "$this$aggregateFallback", "destination$iv$iv", "$this$aggregateFallback", "destination$iv$iv", "$this$aggregateFallback", "destination$iv$iv"}, m302s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes14.dex */
final class HealthConnectClientAggregationExtensionsKt$aggregateFallback$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    HealthConnectClientAggregationExtensionsKt$aggregateFallback$1(Continuation<? super HealthConnectClientAggregationExtensionsKt$aggregateFallback$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HealthConnectClientAggregationExtensionsKt.aggregateFallback((HealthConnectClient) null, (AggregateRequest) null, this);
    }
}
