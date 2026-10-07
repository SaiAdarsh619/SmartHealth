package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DragGestureDetector.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", m297f = "DragGestureDetector.kt", m298i = {0, 0, 0, 0}, m299l = {890}, m300m = "horizontalDrag-jO51t88", m301n = {"onDrag", "$this$drag_u2dVnAYq1g$iv", "$this$awaitDragOrUp_u2djO51t88$iv$iv", "pointer$iv$iv"}, m302s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes.dex */
final class DragGestureDetectorKt$horizontalDrag$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    DragGestureDetectorKt$horizontalDrag$1(Continuation<? super DragGestureDetectorKt$horizontalDrag$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m593horizontalDragjO51t88(null, 0L, null, this);
    }
}
