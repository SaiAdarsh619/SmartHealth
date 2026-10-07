package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Deprecated.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m297f = "Deprecated.kt", m298i = {0}, m299l = {447}, m300m = "none", m301n = {"$this$consume$iv"}, m302s = {"L$0"})
/* loaded from: classes15.dex */
final class ChannelsKt__DeprecatedKt$none$1<E> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    ChannelsKt__DeprecatedKt$none$1(Continuation<? super ChannelsKt__DeprecatedKt$none$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object none;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        none = ChannelsKt__DeprecatedKt.none(null, this);
        return none;
    }
}
