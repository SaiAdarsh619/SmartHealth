package androidx.compose.foundation.gestures.snapping;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SnapFlingBehavior.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", m297f = "SnapFlingBehavior.kt", m298i = {0, 0}, m299l = {225}, m300m = "approach", m301n = {"snapLayoutInfoProvider", "density"}, m302s = {"L$0", "L$1"})
/* loaded from: classes.dex */
final class SnapFlingBehaviorKt$approach$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    SnapFlingBehaviorKt$approach$1(Continuation<? super SnapFlingBehaviorKt$approach$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SnapFlingBehaviorKt.approach(null, 0.0f, 0.0f, null, null, null, this);
    }
}
