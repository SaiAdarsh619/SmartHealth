package androidx.health.connect.client.impl;

import android.health.connect.HealthConnectManager;
import android.health.connect.InsertRecordsResponse;
import androidx.core.os.OutcomeReceiverKt;
import androidx.health.connect.client.impl.platform.records.RecordConvertersKt;
import androidx.health.connect.client.records.Record;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: HealthConnectClientUpsideDownImpl.kt */
@Metadata(m286d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\u008a@"}, m287d2 = {"<anonymous>", "Landroid/health/connect/InsertRecordsResponse;", "kotlin.jvm.PlatformType"}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$insertRecords$response$1", m297f = "HealthConnectClientUpsideDownImpl.kt", m298i = {}, m299l = {393}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes14.dex */
final class HealthConnectClientUpsideDownImpl$insertRecords$response$1 extends SuspendLambda implements Function1<Continuation<? super InsertRecordsResponse>, Object> {
    final /* synthetic */ List<Record> $records;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ HealthConnectClientUpsideDownImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    HealthConnectClientUpsideDownImpl$insertRecords$response$1(HealthConnectClientUpsideDownImpl healthConnectClientUpsideDownImpl, List<? extends Record> list, Continuation<? super HealthConnectClientUpsideDownImpl$insertRecords$response$1> continuation) {
        super(1, continuation);
        this.this$0 = healthConnectClientUpsideDownImpl;
        this.$records = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new HealthConnectClientUpsideDownImpl$insertRecords$response$1(this.this$0, this.$records, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super InsertRecordsResponse> continuation) {
        return ((HealthConnectClientUpsideDownImpl$insertRecords$response$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                HealthConnectClientUpsideDownImpl healthConnectClientUpsideDownImpl = this.this$0;
                Iterable iterable = this.$records;
                this.L$0 = healthConnectClientUpsideDownImpl;
                this.L$1 = iterable;
                this.label = 1;
                HealthConnectClientUpsideDownImpl$insertRecords$response$1 uCont$iv = this;
                CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                cancellable$iv.initCancellability();
                CancellableContinuationImpl continuation = cancellable$iv;
                HealthConnectManager healthConnectManager = healthConnectClientUpsideDownImpl.healthConnectManager;
                Iterable $this$map$iv = iterable;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Record it = (Record) item$iv$iv;
                    destination$iv$iv.add(RecordConvertersKt.toPlatformRecord(it));
                }
                healthConnectManager.insertRecords((List) destination$iv$iv, healthConnectClientUpsideDownImpl.executor, OutcomeReceiverKt.asOutcomeReceiver(continuation));
                Object result = cancellable$iv.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(this);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return result;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
