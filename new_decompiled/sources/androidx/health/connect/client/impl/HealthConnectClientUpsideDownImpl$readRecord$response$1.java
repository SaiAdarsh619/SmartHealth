package androidx.health.connect.client.impl;

import android.health.connect.ReadRecordsRequestUsingIds;
import android.health.connect.ReadRecordsResponse;
import android.health.connect.datatypes.Record;
import androidx.core.os.OutcomeReceiverKt;
import androidx.health.connect.client.impl.platform.records.RecordConvertersKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: HealthConnectClientUpsideDownImpl.kt */
@Metadata(m286d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a>\u0012\u0018\b\u0001\u0012\u0014 \u0004*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u0003 \u0004*\u001e\u0012\u0018\b\u0001\u0012\u0014 \u0004*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u0003\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0006H\u008a@"}, m287d2 = {"<anonymous>", "Landroid/health/connect/ReadRecordsResponse;", "Landroid/health/connect/datatypes/Record;", "Landroidx/health/connect/client/impl/platform/records/PlatformRecord;", "kotlin.jvm.PlatformType", "T", "Landroidx/health/connect/client/records/Record;"}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$readRecord$response$1", m297f = "HealthConnectClientUpsideDownImpl.kt", m298i = {}, m299l = {393}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes14.dex */
final class HealthConnectClientUpsideDownImpl$readRecord$response$1 extends SuspendLambda implements Function1<Continuation<? super ReadRecordsResponse<? extends Record>>, Object> {
    final /* synthetic */ String $recordId;
    final /* synthetic */ KClass<T> $recordType;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ HealthConnectClientUpsideDownImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HealthConnectClientUpsideDownImpl$readRecord$response$1(HealthConnectClientUpsideDownImpl healthConnectClientUpsideDownImpl, KClass<T> kClass, String str, Continuation<? super HealthConnectClientUpsideDownImpl$readRecord$response$1> continuation) {
        super(1, continuation);
        this.this$0 = healthConnectClientUpsideDownImpl;
        this.$recordType = kClass;
        this.$recordId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new HealthConnectClientUpsideDownImpl$readRecord$response$1(this.this$0, this.$recordType, this.$recordId, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super ReadRecordsResponse<? extends Record>> continuation) {
        return ((HealthConnectClientUpsideDownImpl$readRecord$response$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                HealthConnectClientUpsideDownImpl healthConnectClientUpsideDownImpl = this.this$0;
                KClass<T> kClass = this.$recordType;
                String str = this.$recordId;
                this.L$0 = healthConnectClientUpsideDownImpl;
                this.L$1 = kClass;
                this.L$2 = str;
                this.label = 1;
                HealthConnectClientUpsideDownImpl$readRecord$response$1 uCont$iv = this;
                CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                cancellable$iv.initCancellability();
                CancellableContinuationImpl continuation = cancellable$iv;
                healthConnectClientUpsideDownImpl.healthConnectManager.readRecords(new ReadRecordsRequestUsingIds.Builder(RecordConvertersKt.toPlatformRecordClass(kClass)).addId(str).build(), healthConnectClientUpsideDownImpl.executor, OutcomeReceiverKt.asOutcomeReceiver(continuation));
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
