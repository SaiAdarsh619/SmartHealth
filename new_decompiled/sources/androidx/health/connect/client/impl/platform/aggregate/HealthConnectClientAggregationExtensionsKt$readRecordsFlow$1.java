package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.request.ReadRecordsRequest;
import androidx.health.connect.client.response.ReadRecordsResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: HealthConnectClientAggregationExtensions.kt */
@Metadata(m286d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u008a@"}, m287d2 = {"<anonymous>", "", "T", "Landroidx/health/connect/client/records/Record;", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$readRecordsFlow$1", m297f = "HealthConnectClientAggregationExtensions.kt", m298i = {0, 0, 1, 1, 1}, m299l = {166, 167}, m300m = "invokeSuspend", m301n = {"$this$flow", "currentRequest", "$this$flow", "currentRequest", "response"}, m302s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* loaded from: classes14.dex */
final class HealthConnectClientAggregationExtensionsKt$readRecordsFlow$1<T> extends SuspendLambda implements Function2<FlowCollector<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReadRecordsRequest<T> $request;
    final /* synthetic */ HealthConnectClient $this_readRecordsFlow;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HealthConnectClientAggregationExtensionsKt$readRecordsFlow$1(ReadRecordsRequest<T> readRecordsRequest, HealthConnectClient healthConnectClient, Continuation<? super HealthConnectClientAggregationExtensionsKt$readRecordsFlow$1> continuation) {
        super(2, continuation);
        this.$request = readRecordsRequest;
        this.$this_readRecordsFlow = healthConnectClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HealthConnectClientAggregationExtensionsKt$readRecordsFlow$1 healthConnectClientAggregationExtensionsKt$readRecordsFlow$1 = new HealthConnectClientAggregationExtensionsKt$readRecordsFlow$1(this.$request, this.$this_readRecordsFlow, continuation);
        healthConnectClientAggregationExtensionsKt$readRecordsFlow$1.L$0 = obj;
        return healthConnectClientAggregationExtensionsKt$readRecordsFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super List<? extends T>> flowCollector, Continuation<? super Unit> continuation) {
        return ((HealthConnectClientAggregationExtensionsKt$readRecordsFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0084  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0072 -> B:7:0x0076). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ReadRecordsRequest currentRequest;
        HealthConnectClientAggregationExtensionsKt$readRecordsFlow$1 healthConnectClientAggregationExtensionsKt$readRecordsFlow$1;
        FlowCollector $this$flow;
        Object obj;
        Object $result2;
        ReadRecordsResponse response;
        ReadRecordsResponse response2;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                FlowCollector $this$flow2 = (FlowCollector) this.L$0;
                currentRequest = this.$request;
                HealthConnectClientAggregationExtensionsKt$readRecordsFlow$1 healthConnectClientAggregationExtensionsKt$readRecordsFlow$12 = this;
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$12.L$0 = $this$flow2;
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$12.L$1 = currentRequest;
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$12.L$2 = null;
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$12.label = 1;
                Object readRecords = healthConnectClientAggregationExtensionsKt$readRecordsFlow$12.$this_readRecordsFlow.readRecords(currentRequest, healthConnectClientAggregationExtensionsKt$readRecordsFlow$12);
                if (readRecords != $result3) {
                    return $result3;
                }
                Object obj2 = $result3;
                $result2 = $result;
                $result = readRecords;
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$1 = healthConnectClientAggregationExtensionsKt$readRecordsFlow$12;
                $this$flow = $this$flow2;
                obj = obj2;
                response = (ReadRecordsResponse) $result;
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$1.L$0 = $this$flow;
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$1.L$1 = currentRequest;
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$1.L$2 = response;
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$1.label = 2;
                if ($this$flow.emit(response.getRecords(), healthConnectClientAggregationExtensionsKt$readRecordsFlow$1) != obj) {
                    return obj;
                }
                Object obj3 = obj;
                response2 = response;
                $result = $result2;
                $result3 = obj3;
                currentRequest = currentRequest.withPageToken$connect_client_release(response2.getPageToken());
                if (currentRequest.getPageToken() != null) {
                    return Unit.INSTANCE;
                }
                $this$flow2 = $this$flow;
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$12 = healthConnectClientAggregationExtensionsKt$readRecordsFlow$1;
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$12.L$0 = $this$flow2;
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$12.L$1 = currentRequest;
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$12.L$2 = null;
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$12.label = 1;
                Object readRecords2 = healthConnectClientAggregationExtensionsKt$readRecordsFlow$12.$this_readRecordsFlow.readRecords(currentRequest, healthConnectClientAggregationExtensionsKt$readRecordsFlow$12);
                if (readRecords2 != $result3) {
                }
            case 1:
                ReadRecordsRequest currentRequest2 = (ReadRecordsRequest) this.L$1;
                FlowCollector $this$flow3 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$1 = this;
                $this$flow = $this$flow3;
                currentRequest = currentRequest2;
                obj = $result3;
                $result2 = $result;
                response = (ReadRecordsResponse) $result;
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$1.L$0 = $this$flow;
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$1.L$1 = currentRequest;
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$1.L$2 = response;
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$1.label = 2;
                if ($this$flow.emit(response.getRecords(), healthConnectClientAggregationExtensionsKt$readRecordsFlow$1) != obj) {
                }
                break;
            case 2:
                response2 = (ReadRecordsResponse) this.L$2;
                currentRequest = (ReadRecordsRequest) this.L$1;
                $this$flow = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
                healthConnectClientAggregationExtensionsKt$readRecordsFlow$1 = this;
                currentRequest = currentRequest.withPageToken$connect_client_release(response2.getPageToken());
                if (currentRequest.getPageToken() != null) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
