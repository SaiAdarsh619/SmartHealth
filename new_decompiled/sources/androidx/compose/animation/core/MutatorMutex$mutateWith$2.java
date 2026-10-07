package androidx.compose.animation.core;

import androidx.compose.animation.core.MutatorMutex;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: InternalMutatorMutex.kt */
@Metadata(m286d1 = {"\u0000\b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u00020\u0003H\u008a@"}, m287d2 = {"<anonymous>", "R", "T", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.animation.core.MutatorMutex$mutateWith$2", m297f = "InternalMutatorMutex.kt", m298i = {0, 0, 1, 1}, m299l = {171, 158}, m300m = "invokeSuspend", m301n = {"mutator", "$this$withLock_u24default$iv", "mutator", "$this$withLock_u24default$iv"}, m302s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes.dex */
final class MutatorMutex$mutateWith$2<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Function2<T, Continuation<? super R>, Object> $block;
    final /* synthetic */ MutatePriority $priority;
    final /* synthetic */ T $receiver;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ MutatorMutex this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MutatorMutex$mutateWith$2(MutatePriority mutatePriority, MutatorMutex mutatorMutex, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, T t, Continuation<? super MutatorMutex$mutateWith$2> continuation) {
        super(2, continuation);
        this.$priority = mutatePriority;
        this.this$0 = mutatorMutex;
        this.$block = function2;
        this.$receiver = t;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MutatorMutex$mutateWith$2 mutatorMutex$mutateWith$2 = new MutatorMutex$mutateWith$2(this.$priority, this.this$0, this.$block, this.$receiver, continuation);
        mutatorMutex$mutateWith$2.L$0 = obj;
        return mutatorMutex$mutateWith$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((MutatorMutex$mutateWith$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        MutatorMutex$mutateWith$2 mutatorMutex$mutateWith$2;
        Mutex $this$withLock_u24default$iv;
        Function2 function2;
        Object obj;
        Object mutator;
        MutatorMutex.Mutator mutator2;
        Mutex $this$withLock_u24default$iv2;
        MutatorMutex mutatorMutex;
        Object owner$iv;
        Object owner$iv2;
        Mutex $this$withLock_u24default$iv3;
        Object owner$iv3;
        Throwable th;
        MutatorMutex$mutateWith$2 mutatorMutex$mutateWith$22;
        MutatorMutex.Mutator mutator3;
        Object invoke;
        Throwable th2;
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                mutatorMutex$mutateWith$2 = this;
                CoroutineScope $this$coroutineScope = (CoroutineScope) mutatorMutex$mutateWith$2.L$0;
                MutatePriority mutatePriority = mutatorMutex$mutateWith$2.$priority;
                CoroutineContext.Element element = $this$coroutineScope.getCoroutineContext().get(Job.INSTANCE);
                Intrinsics.checkNotNull(element);
                MutatorMutex.Mutator mutator4 = new MutatorMutex.Mutator(mutatePriority, (Job) element);
                mutatorMutex$mutateWith$2.this$0.tryMutateOrCancel(mutator4);
                $this$withLock_u24default$iv = mutatorMutex$mutateWith$2.this$0.mutex;
                function2 = mutatorMutex$mutateWith$2.$block;
                obj = mutatorMutex$mutateWith$2.$receiver;
                MutatorMutex mutatorMutex2 = mutatorMutex$mutateWith$2.this$0;
                mutatorMutex$mutateWith$2.L$0 = mutator4;
                mutatorMutex$mutateWith$2.L$1 = $this$withLock_u24default$iv;
                mutatorMutex$mutateWith$2.L$2 = function2;
                mutatorMutex$mutateWith$2.L$3 = obj;
                mutatorMutex$mutateWith$2.L$4 = mutatorMutex2;
                mutatorMutex$mutateWith$2.label = 1;
                if ($this$withLock_u24default$iv.lock(null, mutatorMutex$mutateWith$2) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutator = mutator4;
                mutator2 = null;
                $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                mutatorMutex = mutatorMutex2;
                owner$iv = null;
                try {
                    mutatorMutex$mutateWith$2.L$0 = mutator;
                    mutatorMutex$mutateWith$2.L$1 = $this$withLock_u24default$iv2;
                    mutatorMutex$mutateWith$2.L$2 = mutatorMutex;
                    mutatorMutex$mutateWith$2.L$3 = null;
                    mutatorMutex$mutateWith$2.L$4 = null;
                    mutatorMutex$mutateWith$2.label = 2;
                    invoke = function2.invoke(obj, mutatorMutex$mutateWith$2);
                    if (invoke != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = invoke;
                    owner$iv2 = owner$iv;
                    $this$withLock_u24default$iv3 = $this$withLock_u24default$iv2;
                    owner$iv3 = mutator;
                    try {
                        atomicReference2 = mutatorMutex.currentMutator;
                        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m5m(atomicReference2, owner$iv3, null);
                        $this$withLock_u24default$iv3.unlock(owner$iv2);
                        return $result;
                    } catch (Throwable th3) {
                        th2 = th3;
                        $this$withLock_u24default$iv3.unlock(owner$iv2);
                        throw th2;
                    }
                } catch (Throwable th4) {
                    owner$iv2 = owner$iv;
                    $this$withLock_u24default$iv3 = $this$withLock_u24default$iv2;
                    owner$iv3 = mutator;
                    th = th4;
                    mutatorMutex$mutateWith$22 = mutatorMutex$mutateWith$2;
                    mutator3 = mutator2;
                    try {
                        atomicReference = mutatorMutex.currentMutator;
                        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m5m(atomicReference, owner$iv3, null);
                        throw th;
                    } catch (Throwable th5) {
                        th2 = th5;
                        $this$withLock_u24default$iv3.unlock(owner$iv2);
                        throw th2;
                    }
                }
            case 1:
                mutatorMutex$mutateWith$2 = this;
                mutator2 = null;
                mutatorMutex = (MutatorMutex) mutatorMutex$mutateWith$2.L$4;
                obj = mutatorMutex$mutateWith$2.L$3;
                function2 = (Function2) mutatorMutex$mutateWith$2.L$2;
                owner$iv = null;
                $this$withLock_u24default$iv2 = (Mutex) mutatorMutex$mutateWith$2.L$1;
                mutator = (MutatorMutex.Mutator) mutatorMutex$mutateWith$2.L$0;
                ResultKt.throwOnFailure($result);
                mutatorMutex$mutateWith$2.L$0 = mutator;
                mutatorMutex$mutateWith$2.L$1 = $this$withLock_u24default$iv2;
                mutatorMutex$mutateWith$2.L$2 = mutatorMutex;
                mutatorMutex$mutateWith$2.L$3 = null;
                mutatorMutex$mutateWith$2.L$4 = null;
                mutatorMutex$mutateWith$2.label = 2;
                invoke = function2.invoke(obj, mutatorMutex$mutateWith$2);
                if (invoke != coroutine_suspended) {
                }
                break;
            case 2:
                mutatorMutex$mutateWith$22 = this;
                mutator3 = null;
                mutatorMutex = (MutatorMutex) mutatorMutex$mutateWith$22.L$2;
                owner$iv2 = null;
                $this$withLock_u24default$iv3 = (Mutex) mutatorMutex$mutateWith$22.L$1;
                owner$iv3 = (MutatorMutex.Mutator) mutatorMutex$mutateWith$22.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    atomicReference2 = mutatorMutex.currentMutator;
                    MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m5m(atomicReference2, owner$iv3, null);
                    $this$withLock_u24default$iv3.unlock(owner$iv2);
                    return $result;
                } catch (Throwable th6) {
                    th = th6;
                    atomicReference = mutatorMutex.currentMutator;
                    MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m5m(atomicReference, owner$iv3, null);
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
