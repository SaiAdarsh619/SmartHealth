package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Transformable.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.TransformableKt", m297f = "Transformable.kt", m298i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, m299l = {98, 102}, m300m = "detectZoom", m301n = {"$this$detectZoom", "panZoomLock", "state", "rotation", "zoom", "pan", "pastTouchSlop", "lockedToPanZoom", "touchSlop"}, m302s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "F$0"})
/* loaded from: classes.dex */
final class TransformableKt$detectZoom$1 extends ContinuationImpl {
    float F$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;

    TransformableKt$detectZoom$1(Continuation<? super TransformableKt$detectZoom$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object detectZoom;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        detectZoom = TransformableKt.detectZoom(null, null, null, this);
        return detectZoom;
    }
}
