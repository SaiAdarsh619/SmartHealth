package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Deprecated.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m297f = "Deprecated.kt", m298i = {0, 0}, m299l = {75}, m300m = "firstOrNull", m301n = {"$this$consume$iv", "iterator"}, m302s = {"L$0", "L$1"})
/* loaded from: classes15.dex */
final class ChannelsKt__DeprecatedKt$firstOrNull$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    ChannelsKt__DeprecatedKt$firstOrNull$1(Continuation<? super ChannelsKt__DeprecatedKt$firstOrNull$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object firstOrNull;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        firstOrNull = ChannelsKt__DeprecatedKt.firstOrNull(null, this);
        return firstOrNull;
    }
}
