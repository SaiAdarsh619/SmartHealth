package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Scrollable.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.ScrollingLogic", m297f = "Scrollable.kt", m298i = {0, 0, 1, 1, 2, 2, 3, 3, 4}, m299l = {421, 427, 429, 431, 437}, m300m = "onDragStopped-sF-c-tU", m301n = {"this", "availableVelocity", "this", "velocity", "this", "available", "this", "velocityLeft", "this"}, m302s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0", "L$0", "J$0", "L$0"})
/* loaded from: classes.dex */
final class ScrollingLogic$onDragStopped$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollingLogic$onDragStopped$1(ScrollingLogic scrollingLogic, Continuation<? super ScrollingLogic$onDragStopped$1> continuation) {
        super(continuation);
        this.this$0 = scrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m660onDragStoppedsFctU(0L, this);
    }
}
