package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Hoverable.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.HoverableKt$hoverable$2", m297f = "Hoverable.kt", m298i = {0, 0}, m299l = {62}, m300m = "invoke$emitEnter", m301n = {"hoverInteraction$delegate", "interaction"}, m302s = {"L$0", "L$1"})
/* loaded from: classes.dex */
final class HoverableKt$hoverable$2$invoke$emitEnter$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    HoverableKt$hoverable$2$invoke$emitEnter$1(Continuation<? super HoverableKt$hoverable$2$invoke$emitEnter$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HoverableKt$hoverable$2.invoke$emitEnter(null, null, this);
    }
}
