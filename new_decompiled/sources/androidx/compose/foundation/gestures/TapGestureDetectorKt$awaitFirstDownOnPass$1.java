package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: TapGestureDetector.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", m297f = "TapGestureDetector.kt", m298i = {0, 0, 0}, m299l = {256}, m300m = "awaitFirstDownOnPass", m301n = {"$this$awaitFirstDownOnPass", "pass", "requireUnconsumed"}, m302s = {"L$0", "L$1", "Z$0"})
/* loaded from: classes.dex */
final class TapGestureDetectorKt$awaitFirstDownOnPass$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    TapGestureDetectorKt$awaitFirstDownOnPass$1(Continuation<? super TapGestureDetectorKt$awaitFirstDownOnPass$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TapGestureDetectorKt.awaitFirstDownOnPass(null, null, false, this);
    }
}
