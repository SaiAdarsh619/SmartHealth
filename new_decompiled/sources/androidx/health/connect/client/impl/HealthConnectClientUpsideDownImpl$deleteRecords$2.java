package androidx.health.connect.client.impl;

import android.health.connect.HealthConnectManager;
import android.health.connect.RecordIdFilter;
import androidx.core.os.OutcomeReceiverKt;
import androidx.health.connect.client.impl.platform.records.RecordConvertersKt;
import androidx.health.connect.client.records.Record;
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
import kotlin.reflect.KClass;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: HealthConnectClientUpsideDownImpl.kt */
@Metadata(m286d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\u008a@"}, m287d2 = {"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType"}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$deleteRecords$2", m297f = "HealthConnectClientUpsideDownImpl.kt", m298i = {}, m299l = {393}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes14.dex */
final class HealthConnectClientUpsideDownImpl$deleteRecords$2 extends SuspendLambda implements Function1<Continuation<? super Void>, Object> {
    final /* synthetic */ List<String> $clientRecordIdsList;
    final /* synthetic */ List<String> $recordIdsList;
    final /* synthetic */ KClass<? extends Record> $recordType;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ HealthConnectClientUpsideDownImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HealthConnectClientUpsideDownImpl$deleteRecords$2(HealthConnectClientUpsideDownImpl healthConnectClientUpsideDownImpl, List<String> list, List<String> list2, KClass<? extends Record> kClass, Continuation<? super HealthConnectClientUpsideDownImpl$deleteRecords$2> continuation) {
        super(1, continuation);
        this.this$0 = healthConnectClientUpsideDownImpl;
        this.$recordIdsList = list;
        this.$clientRecordIdsList = list2;
        this.$recordType = kClass;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new HealthConnectClientUpsideDownImpl$deleteRecords$2(this.this$0, this.$recordIdsList, this.$clientRecordIdsList, this.$recordType, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Void> continuation) {
        return ((HealthConnectClientUpsideDownImpl$deleteRecords$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Object $result2 = $result;
                HealthConnectClientUpsideDownImpl healthConnectClientUpsideDownImpl = this.this$0;
                Iterable iterable = this.$recordIdsList;
                Iterable iterable2 = this.$clientRecordIdsList;
                KClass<? extends Record> kClass = this.$recordType;
                this.L$0 = healthConnectClientUpsideDownImpl;
                this.L$1 = iterable;
                this.L$2 = iterable2;
                this.L$3 = kClass;
                this.label = 1;
                HealthConnectClientUpsideDownImpl$deleteRecords$2 uCont$iv = this;
                CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                cancellable$iv.initCancellability();
                CancellableContinuationImpl continuation = cancellable$iv;
                HealthConnectManager healthConnectManager = healthConnectClientUpsideDownImpl.healthConnectManager;
                List $this$invokeSuspend_u24lambda_u243_u24lambda_u242 = CollectionsKt.createListBuilder();
                Iterable $this$forEach$iv = iterable;
                for (Object element$iv : $this$forEach$iv) {
                    Object $result3 = $result2;
                    String it = (String) element$iv;
                    $this$invokeSuspend_u24lambda_u243_u24lambda_u242.add(RecordIdFilter.fromId(RecordConvertersKt.toPlatformRecordClass(kClass), it));
                    $result2 = $result3;
                }
                Iterable $this$forEach$iv2 = iterable2;
                int $i$f$forEach = 0;
                for (Object element$iv2 : $this$forEach$iv2) {
                    int $i$f$forEach2 = $i$f$forEach;
                    String it2 = (String) element$iv2;
                    $this$invokeSuspend_u24lambda_u243_u24lambda_u242.add(RecordIdFilter.fromClientRecordId(RecordConvertersKt.toPlatformRecordClass(kClass), it2));
                    $i$f$forEach = $i$f$forEach2;
                }
                healthConnectManager.deleteRecords(CollectionsKt.build($this$invokeSuspend_u24lambda_u243_u24lambda_u242), healthConnectClientUpsideDownImpl.executor, OutcomeReceiverKt.asOutcomeReceiver(continuation));
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
