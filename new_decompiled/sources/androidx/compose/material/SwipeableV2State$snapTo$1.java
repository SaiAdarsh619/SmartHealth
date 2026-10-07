package androidx.compose.material;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SwipeableV2.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.material.SwipeableV2State", m297f = "SwipeableV2.kt", m298i = {0, 0}, m299l = {229}, m300m = "snapTo", m301n = {"this", "targetState"}, m302s = {"L$0", "L$1"})
/* loaded from: classes.dex */
final class SwipeableV2State$snapTo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeableV2State$snapTo$1(SwipeableV2State<T> swipeableV2State, Continuation<? super SwipeableV2State$snapTo$1> continuation) {
        super(continuation);
        this.this$0 = swipeableV2State;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.snapTo(null, this);
    }
}
