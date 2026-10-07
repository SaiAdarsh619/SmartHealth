package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BufferedChannel.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "kotlinx.coroutines.channels.BufferedChannel", m297f = "BufferedChannel.kt", m298i = {0, 0, 0, 0}, m299l = {3056}, m300m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk", m301n = {"this", "segment", "index", "r"}, m302s = {"L$0", "L$1", "I$0", "J$0"})
/* loaded from: classes15.dex */
final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel<E> bufferedChannel, Continuation<? super BufferedChannel$receiveCatchingOnNoWaiterSuspend$1> continuation) {
        super(continuation);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m6236receiveCatchingOnNoWaiterSuspendGKJJFZk;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m6236receiveCatchingOnNoWaiterSuspendGKJJFZk = this.this$0.m6236receiveCatchingOnNoWaiterSuspendGKJJFZk(null, 0, 0L, this);
        return m6236receiveCatchingOnNoWaiterSuspendGKJJFZk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m6236receiveCatchingOnNoWaiterSuspendGKJJFZk : ChannelResult.m6243boximpl(m6236receiveCatchingOnNoWaiterSuspendGKJJFZk);
    }
}
