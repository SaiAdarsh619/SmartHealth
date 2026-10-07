package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Semaphore.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 176)
@DebugMetadata(m296c = "kotlinx.coroutines.sync.SemaphoreKt", m297f = "Semaphore.kt", m298i = {0, 0}, m299l = {86}, m300m = "withPermit", m301n = {"$this$withPermit", "action"}, m302s = {"L$0", "L$1"})
/* loaded from: classes15.dex */
final class SemaphoreKt$withPermit$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    SemaphoreKt$withPermit$1(Continuation<? super SemaphoreKt$withPermit$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SemaphoreKt.withPermit(null, null, this);
    }
}
