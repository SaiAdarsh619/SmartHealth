package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Deprecated.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m297f = "Deprecated.kt", m298i = {0, 0, 1, 1, 1}, m299l = {97, 100}, m300m = "last", m301n = {"$this$consume$iv", "iterator", "$this$consume$iv", "iterator", "last"}, m302s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* loaded from: classes15.dex */
final class ChannelsKt__DeprecatedKt$last$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    ChannelsKt__DeprecatedKt$last$1(Continuation<? super ChannelsKt__DeprecatedKt$last$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object last;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        last = ChannelsKt__DeprecatedKt.last(null, this);
        return last;
    }
}
