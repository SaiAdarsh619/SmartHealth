package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Transformable.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.TransformableKt", m297f = "Transformable.kt", m298i = {0, 0, 0}, m299l = {162}, m300m = "awaitTwoDowns", m301n = {"$this$awaitTwoDowns", "firstDown", "requireUnconsumed"}, m302s = {"L$0", "L$1", "Z$0"})
/* loaded from: classes.dex */
final class TransformableKt$awaitTwoDowns$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    TransformableKt$awaitTwoDowns$1(Continuation<? super TransformableKt$awaitTwoDowns$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object awaitTwoDowns;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        awaitTwoDowns = TransformableKt.awaitTwoDowns(null, false, this);
        return awaitTwoDowns;
    }
}
