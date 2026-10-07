package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DragGestureDetector.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", m297f = "DragGestureDetector.kt", m298i = {0, 0}, m299l = {884}, m300m = "awaitHorizontalDragOrCancellation-rnUCldI", m301n = {"$this$awaitDragOrUp_u2djO51t88$iv", "pointer$iv"}, m302s = {"L$0", "L$1"})
/* loaded from: classes.dex */
final class DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1(Continuation<? super DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m580awaitHorizontalDragOrCancellationrnUCldI(null, 0L, this);
    }
}
