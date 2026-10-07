package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* compiled from: Channels.common.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 176)
@DebugMetadata(m296c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", m297f = "Channels.common.kt", m298i = {0, 0}, m299l = {106}, m300m = "consumeEach", m301n = {"action", "$this$consume$iv"}, m302s = {"L$0", "L$1"})
/* loaded from: classes15.dex */
final class ChannelsKt__Channels_commonKt$consumeEach$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    ChannelsKt__Channels_commonKt$consumeEach$1(Continuation<? super ChannelsKt__Channels_commonKt$consumeEach$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt__Channels_commonKt.consumeEach((ReceiveChannel) null, (Function1) null, this);
    }
}
