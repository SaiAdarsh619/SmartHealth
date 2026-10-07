package androidx.compose.foundation.gestures.snapping;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SnapFlingBehavior.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", m297f = "SnapFlingBehavior.kt", m298i = {0}, m299l = {301}, m300m = "animateDecay", m301n = {"animationState"}, m302s = {"L$0"})
/* loaded from: classes.dex */
final class SnapFlingBehaviorKt$animateDecay$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    SnapFlingBehaviorKt$animateDecay$1(Continuation<? super SnapFlingBehaviorKt$animateDecay$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object animateDecay;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        animateDecay = SnapFlingBehaviorKt.animateDecay(null, 0.0f, null, null, this);
        return animateDecay;
    }
}
