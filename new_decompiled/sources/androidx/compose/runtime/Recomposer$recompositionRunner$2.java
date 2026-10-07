package androidx.compose.runtime;

import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: Recomposer.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.runtime.Recomposer$recompositionRunner$2", m297f = "Recomposer.kt", m298i = {0, 0}, m299l = {882}, m300m = "invokeSuspend", m301n = {"callingJob", "unregisterApplyObserver"}, m302s = {"L$0", "L$1"})
/* loaded from: classes.dex */
final class Recomposer$recompositionRunner$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ MonotonicFrameClock $parentFrameClock;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    Recomposer$recompositionRunner$2(Recomposer recomposer, Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super Recomposer$recompositionRunner$2> continuation) {
        super(2, continuation);
        this.this$0 = recomposer;
        this.$block = function3;
        this.$parentFrameClock = monotonicFrameClock;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Recomposer$recompositionRunner$2 recomposer$recompositionRunner$2 = new Recomposer$recompositionRunner$2(this.this$0, this.$block, this.$parentFrameClock, continuation);
        recomposer$recompositionRunner$2.L$0 = obj;
        return recomposer$recompositionRunner$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Recomposer$recompositionRunner$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00b1  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.runtime.Recomposer$recompositionRunner$2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Job job;
        Recomposer.RecomposerInfoImpl recomposerInfoImpl;
        Job job2;
        ObserverHandle registerApplyObserver;
        Recomposer.RecomposerInfoImpl recomposerInfoImpl2;
        Recomposer$recompositionRunner$2 recomposer$recompositionRunner$2;
        Object obj2;
        Job job3;
        Recomposer.RecomposerInfoImpl recomposerInfoImpl3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Recomposer$recompositionRunner$2 recomposer$recompositionRunner$22 = this.label;
        try {
            switch (recomposer$recompositionRunner$22) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    recomposer$recompositionRunner$22 = this;
                    job2 = JobKt.getJob(((CoroutineScope) recomposer$recompositionRunner$22.L$0).getCoroutineContext());
                    recomposer$recompositionRunner$22.this$0.registerRunnerJob(job2);
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    final Recomposer recomposer = recomposer$recompositionRunner$22.this$0;
                    registerApplyObserver = companion.registerApplyObserver(new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.Recomposer$recompositionRunner$2$unregisterApplyObserver$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set, Snapshot snapshot) {
                            invoke2(set, snapshot);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Set<? extends Object> changed, Snapshot snapshot) {
                            MutableStateFlow mutableStateFlow;
                            CancellableContinuation cancellableContinuation;
                            Intrinsics.checkNotNullParameter(changed, "changed");
                            Intrinsics.checkNotNullParameter(snapshot, "<anonymous parameter 1>");
                            Object lock$iv = Recomposer.this.stateLock;
                            Recomposer recomposer2 = Recomposer.this;
                            synchronized (lock$iv) {
                                mutableStateFlow = recomposer2._state;
                                if (((Recomposer.State) mutableStateFlow.getValue()).compareTo(Recomposer.State.Idle) >= 0) {
                                    recomposer2.snapshotInvalidations.add(changed);
                                    cancellableContinuation = recomposer2.deriveStateLocked();
                                } else {
                                    cancellableContinuation = null;
                                }
                            }
                            if (cancellableContinuation != null) {
                                Result.Companion companion2 = Result.INSTANCE;
                                cancellableContinuation.resumeWith(Result.m4732constructorimpl(Unit.INSTANCE));
                            }
                        }
                    });
                    Recomposer.Companion companion2 = Recomposer.INSTANCE;
                    recomposerInfoImpl2 = recomposer$recompositionRunner$22.this$0.recomposerInfo;
                    companion2.addRunning(recomposerInfoImpl2);
                    Object obj3 = recomposer$recompositionRunner$22.this$0.stateLock;
                    Recomposer recomposer2 = recomposer$recompositionRunner$22.this$0;
                    synchronized (obj3) {
                        List list = recomposer2.knownCompositions;
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            ((ControlledComposition) list.get(i)).invalidateAll();
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    recomposer$recompositionRunner$22.L$0 = job2;
                    recomposer$recompositionRunner$22.L$1 = registerApplyObserver;
                    recomposer$recompositionRunner$22.label = 1;
                    Object coroutineScope = CoroutineScopeKt.coroutineScope(new C03952(recomposer$recompositionRunner$22.$block, recomposer$recompositionRunner$22.$parentFrameClock, null), (Continuation) recomposer$recompositionRunner$22);
                    recomposer$recompositionRunner$2 = recomposer$recompositionRunner$22;
                    if (coroutineScope == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    registerApplyObserver.dispose();
                    obj2 = recomposer$recompositionRunner$2.this$0.stateLock;
                    Recomposer recomposer3 = recomposer$recompositionRunner$2.this$0;
                    synchronized (obj2) {
                        job3 = recomposer3.runnerJob;
                        if (job3 == job2) {
                            recomposer3.runnerJob = null;
                        }
                        recomposer3.deriveStateLocked();
                    }
                    Recomposer.Companion companion3 = Recomposer.INSTANCE;
                    recomposerInfoImpl3 = recomposer$recompositionRunner$2.this$0.recomposerInfo;
                    companion3.removeRunning(recomposerInfoImpl3);
                    return Unit.INSTANCE;
                case 1:
                    Recomposer$recompositionRunner$2 recomposer$recompositionRunner$23 = this;
                    registerApplyObserver = (ObserverHandle) recomposer$recompositionRunner$23.L$1;
                    job2 = (Job) recomposer$recompositionRunner$23.L$0;
                    ResultKt.throwOnFailure(obj);
                    recomposer$recompositionRunner$2 = recomposer$recompositionRunner$23;
                    registerApplyObserver.dispose();
                    obj2 = recomposer$recompositionRunner$2.this$0.stateLock;
                    Recomposer recomposer32 = recomposer$recompositionRunner$2.this$0;
                    synchronized (obj2) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th) {
            registerApplyObserver.dispose();
            Object obj4 = recomposer$recompositionRunner$22.this$0.stateLock;
            Recomposer recomposer4 = recomposer$recompositionRunner$22.this$0;
            synchronized (obj4) {
                job = recomposer4.runnerJob;
                if (job == job2) {
                    recomposer4.runnerJob = null;
                }
                recomposer4.deriveStateLocked();
                Recomposer.Companion companion4 = Recomposer.INSTANCE;
                recomposerInfoImpl = recomposer$recompositionRunner$22.this$0.recomposerInfo;
                companion4.removeRunning(recomposerInfoImpl);
                throw th;
            }
        }
    }

    /* compiled from: Recomposer.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.compose.runtime.Recomposer$recompositionRunner$2$2", m297f = "Recomposer.kt", m298i = {}, m299l = {883}, m300m = "invokeSuspend", m301n = {}, m302s = {})
    /* renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2$2 */
    static final class C03952 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ MonotonicFrameClock $parentFrameClock;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03952(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super C03952> continuation) {
            super(2, continuation);
            this.$block = function3;
            this.$parentFrameClock = monotonicFrameClock;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03952 c03952 = new C03952(this.$block, this.$parentFrameClock, continuation);
            c03952.L$0 = obj;
            return c03952;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03952) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> function3 = this.$block;
                    MonotonicFrameClock monotonicFrameClock = this.$parentFrameClock;
                    this.label = 1;
                    if (function3.invoke($this$coroutineScope, monotonicFrameClock, this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }
}
