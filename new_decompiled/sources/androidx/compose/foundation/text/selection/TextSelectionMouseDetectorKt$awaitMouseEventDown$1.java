package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: TextSelectionMouseDetector.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt", m297f = "TextSelectionMouseDetector.kt", m298i = {0}, m299l = {WorkQueueKt.MASK}, m300m = "awaitMouseEventDown", m301n = {"$this$awaitMouseEventDown"}, m302s = {"L$0"})
/* loaded from: classes.dex */
final class TextSelectionMouseDetectorKt$awaitMouseEventDown$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    TextSelectionMouseDetectorKt$awaitMouseEventDown$1(Continuation<? super TextSelectionMouseDetectorKt$awaitMouseEventDown$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object awaitMouseEventDown;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        awaitMouseEventDown = TextSelectionMouseDetectorKt.awaitMouseEventDown(null, this);
        return awaitMouseEventDown;
    }
}
