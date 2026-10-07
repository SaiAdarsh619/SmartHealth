package androidx.compose.foundation.gestures;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Draggable.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.DragLogic", m297f = "Draggable.kt", m298i = {0, 0, 0}, m299l = {392, 395}, m300m = "processDragStop", m301n = {"this", "$this$processDragStop", NotificationCompat.CATEGORY_EVENT}, m302s = {"L$0", "L$1", "L$2"})
/* loaded from: classes.dex */
final class DragLogic$processDragStop$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DragLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DragLogic$processDragStop$1(DragLogic dragLogic, Continuation<? super DragLogic$processDragStop$1> continuation) {
        super(continuation);
        this.this$0 = dragLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.processDragStop(null, null, this);
    }
}
