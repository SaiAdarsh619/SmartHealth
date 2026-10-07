package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BufferedChannel.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "kotlinx.coroutines.channels.BufferedChannel", m297f = "BufferedChannel.kt", m298i = {}, m299l = {739}, m300m = "receiveCatching-JP2dKIU$suspendImpl", m301n = {}, m302s = {})
/* loaded from: classes15.dex */
final class BufferedChannel$receiveCatching$1<E> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BufferedChannel$receiveCatching$1(BufferedChannel<E> bufferedChannel, Continuation<? super BufferedChannel$receiveCatching$1> continuation) {
        super(continuation);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m6235receiveCatchingJP2dKIU$suspendImpl = BufferedChannel.m6235receiveCatchingJP2dKIU$suspendImpl(this.this$0, this);
        return m6235receiveCatchingJP2dKIU$suspendImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m6235receiveCatchingJP2dKIU$suspendImpl : ChannelResult.m6243boximpl(m6235receiveCatchingJP2dKIU$suspendImpl);
    }
}
