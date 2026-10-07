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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: InternalMutatorMutex.kt */
@Metadata(m286d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.animation.core.MutatorMutex$mutate$2", m297f = "InternalMutatorMutex.kt", m298i = {0, 0, 1, 1}, m299l = {171, 119}, m300m = "invokeSuspend", m301n = {"mutator", "$this$withLock_u24default$iv", "mutator", "$this$withLock_u24default$iv"}, m302s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes.dex */
final class MutatorMutex$mutate$2<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
    final /* synthetic */ MutatePriority $priority;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MutatorMutex this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MutatorMutex$mutate$2(MutatePriority mutatePriority, MutatorMutex mutatorMutex, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super MutatorMutex$mutate$2> continuation) {
        super(2, continuation);
        this.$priority = mutatePriority;
        this.this$0 = mutatorMutex;
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MutatorMutex$mutate$2 mutatorMutex$mutate$2 = new MutatorMutex$mutate$2(this.$priority, this.this$0, this.$block, continuation);
        mutatorMutex$mutate$2.L$0 = obj;
        return mutatorMutex$mutate$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((MutatorMutex$mutate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00aa  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        MutatorMutex$mutate$2 mutatorMutex$mutate$2;
        Mutex $this$withLock_u24default$iv;
        Function1<Continuation<? super R>, Object> function1;
        MutatorMutex.Mutator mutator;
        MutatorMutex.Mutator mutator2;
        Mutex $this$withLock_u24default$iv2;
        MutatorMutex mutatorMutex;
        Object owner$iv;
        Object owner$iv2;
        Mutex $this$withLock_u24default$iv3;
        MutatorMutex.Mutator mutator3;
        Throwable th;
        MutatorMutex$mutate$2 mutatorMutex$mutate$22;
        MutatorMutex.Mutator mutator4;
        Object invoke;
        Throwable th2;
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                mutatorMutex$mutate$2 = this;
                CoroutineScope $this$coroutineScope = (CoroutineScope) mutatorMutex$mutate$2.L$0;
                MutatePriority mutatePriority = mutatorMutex$mutate$2.$priority;
                CoroutineContext.Element element = $this$coroutineScope.getCoroutineContext().get(Job.INSTANCE);
                Intrinsics.checkNotNull(element);
                MutatorMutex.Mutator mutator5 = new MutatorMutex.Mutator(mutatePriority, (Job) element);
                mutatorMutex$mutate$2.this$0.tryMutateOrCancel(mutator5);
                $this$withLock_u24default$iv = mutatorMutex$mutate$2.this$0.mutex;
                function1 = mutatorMutex$mutate$2.$block;
                MutatorMutex mutatorMutex2 = mutatorMutex$mutate$2.this$0;
                mutatorMutex$mutate$2.L$0 = mutator5;
                mutatorMutex$mutate$2.L$1 = $this$withLock_u24default$iv;
                mutatorMutex$mutate$2.L$2 = function1;
                mutatorMutex$mutate$2.L$3 = mutatorMutex2;
                mutatorMutex$mutate$2.label = 1;
                if ($this$withLock_u24default$iv.lock(null, mutatorMutex$mutate$2) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutator = mutator5;
                mutator2 = null;
                $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                mutatorMutex = mutatorMutex2;
                owner$iv = null;
                try {
                    mutatorMutex$mutate$2.L$0 = mutator;
                    mutatorMutex$mutate$2.L$1 = $this$withLock_u24default$iv2;
                    mutatorMutex$mutate$2.L$2 = mutatorMutex;
                    mutatorMutex$mutate$2.L$3 = null;
                    mutatorMutex$mutate$2.label = 2;
                    invoke = function1.invoke(mutatorMutex$mutate$2);
                    if (invoke != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = invoke;
                    owner$iv2 = owner$iv;
                    $this$withLock_u24default$iv3 = $this$withLock_u24default$iv2;
                    mutator3 = mutator;
                    try {
                        atomicReference2 = mutatorMutex.currentMutator;
                        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m5m(atomicReference2, mutator3, null);
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
                    mutator3 = mutator;
                    th = th4;
                    mutatorMutex$mutate$22 = mutatorMutex$mutate$2;
                    mutator4 = mutator2;
                    try {
                        atomicReference = mutatorMutex.currentMutator;
                        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m5m(atomicReference, mutator3, null);
                        throw th;
                    } catch (Throwable th5) {
                        th2 = th5;
                        $this$withLock_u24default$iv3.unlock(owner$iv2);
                        throw th2;
                    }
                }
            case 1:
                mutatorMutex$mutate$2 = this;
                mutator2 = null;
                mutatorMutex = (MutatorMutex) mutatorMutex$mutate$2.L$3;
                function1 = (Function1) mutatorMutex$mutate$2.L$2;
                owner$iv = null;
                $this$withLock_u24default$iv2 = (Mutex) mutatorMutex$mutate$2.L$1;
                mutator = (MutatorMutex.Mutator) mutatorMutex$mutate$2.L$0;
                ResultKt.throwOnFailure($result);
                mutatorMutex$mutate$2.L$0 = mutator;
                mutatorMutex$mutate$2.L$1 = $this$withLock_u24default$iv2;
                mutatorMutex$mutate$2.L$2 = mutatorMutex;
                mutatorMutex$mutate$2.L$3 = null;
                mutatorMutex$mutate$2.label = 2;
                invoke = function1.invoke(mutatorMutex$mutate$2);
                if (invoke != coroutine_suspended) {
                }
                break;
            case 2:
                mutatorMutex$mutate$22 = this;
                mutator4 = null;
                mutatorMutex = (MutatorMutex) mutatorMutex$mutate$22.L$2;
                owner$iv2 = null;
                $this$withLock_u24default$iv3 = (Mutex) mutatorMutex$mutate$22.L$1;
                mutator3 = (MutatorMutex.Mutator) mutatorMutex$mutate$22.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    atomicReference2 = mutatorMutex.currentMutator;
                    MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m5m(atomicReference2, mutator3, null);
                    $this$withLock_u24default$iv3.unlock(owner$iv2);
                    return $result;
                } catch (Throwable th6) {
                    th = th6;
                    atomicReference = mutatorMutex.currentMutator;
                    MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m5m(atomicReference, mutator3, null);
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
