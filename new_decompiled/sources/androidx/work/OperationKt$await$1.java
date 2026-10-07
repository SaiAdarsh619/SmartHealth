package androidx.work;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Operation.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 176)
@DebugMetadata(m296c = "androidx.work.OperationKt", m297f = "Operation.kt", m298i = {0}, m299l = {39}, m300m = "await", m301n = {"$this$await$iv"}, m302s = {"L$0"})
/* loaded from: classes14.dex */
final class OperationKt$await$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    OperationKt$await$1(Continuation<? super OperationKt$await$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OperationKt.await(null, this);
    }
}
