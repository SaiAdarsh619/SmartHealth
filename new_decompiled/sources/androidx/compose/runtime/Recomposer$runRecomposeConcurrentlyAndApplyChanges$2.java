package androidx.compose.runtime;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* compiled from: Recomposer.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2", m297f = "Recomposer.kt", m298i = {0, 0, 0, 1}, m299l = {730, 750, 751}, m300m = "invokeSuspend", m301n = {"recomposeCoroutineScope", "frameSignal", "frameLoop", "frameLoop"}, m302s = {"L$0", "L$1", "L$2", "L$0"})
/* loaded from: classes.dex */
final class Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineContext $recomposeCoroutineContext;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(CoroutineContext coroutineContext, Recomposer recomposer, Continuation<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.$recomposeCoroutineContext = coroutineContext;
        this.this$0 = recomposer;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 recomposer$runRecomposeConcurrentlyAndApplyChanges$2 = new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(this.$recomposeCoroutineContext, this.this$0, continuation);
        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0 = coroutineScope;
        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$1 = monotonicFrameClock;
        return recomposer$runRecomposeConcurrentlyAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0213 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01e3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00c9 -> B:15:0x00ca). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 recomposer$runRecomposeConcurrentlyAndApplyChanges$2;
        Job launch$default;
        Object $result2;
        Job frameLoop;
        ProduceFrameSignal frameSignal;
        boolean shouldKeepRecomposing;
        Object obj;
        Object $result3;
        Object obj2;
        Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 recomposer$runRecomposeConcurrentlyAndApplyChanges$22;
        Object awaitWorkAvailable;
        CoroutineScope recomposeCoroutineScope;
        Object lock$iv;
        Object obj3;
        boolean hasConcurrentFrameWorkLocked;
        Continuation<Unit> requestFrameLocked;
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = 1;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2 = this;
                CoroutineScope $this$recompositionRunner = (CoroutineScope) recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0;
                MonotonicFrameClock parentFrameClock = (MonotonicFrameClock) recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$1;
                boolean z = recomposer$runRecomposeConcurrentlyAndApplyChanges$2.$recomposeCoroutineContext.get(Job.INSTANCE) == null;
                CoroutineContext coroutineContext = recomposer$runRecomposeConcurrentlyAndApplyChanges$2.$recomposeCoroutineContext;
                if (!z) {
                    throw new IllegalArgumentException(("recomposeCoroutineContext may not contain a Job; found " + coroutineContext.get(Job.INSTANCE)).toString());
                }
                CoroutineScope recomposeCoroutineScope2 = CoroutineScopeKt.CoroutineScope($this$recompositionRunner.getCoroutineContext().plus(recomposer$runRecomposeConcurrentlyAndApplyChanges$2.$recomposeCoroutineContext).plus(JobKt.Job(JobKt.getJob($this$recompositionRunner.getCoroutineContext()))));
                ProduceFrameSignal frameSignal2 = new ProduceFrameSignal();
                launch$default = BuildersKt__Builders_commonKt.launch$default($this$recompositionRunner, null, null, new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1(recomposer$runRecomposeConcurrentlyAndApplyChanges$2.this$0, parentFrameClock, frameSignal2, null), 3, null);
                $result2 = $result;
                frameLoop = launch$default;
                CoroutineScope recomposeCoroutineScope3 = recomposeCoroutineScope2;
                frameSignal = frameSignal2;
                shouldKeepRecomposing = recomposer$runRecomposeConcurrentlyAndApplyChanges$2.this$0.getShouldKeepRecomposing();
                if (!shouldKeepRecomposing) {
                    recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0 = recomposeCoroutineScope3;
                    recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$1 = frameSignal;
                    recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$2 = frameLoop;
                    recomposer$runRecomposeConcurrentlyAndApplyChanges$2.label = i2;
                    awaitWorkAvailable = recomposer$runRecomposeConcurrentlyAndApplyChanges$2.this$0.awaitWorkAvailable(recomposer$runRecomposeConcurrentlyAndApplyChanges$2);
                    if (awaitWorkAvailable == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    recomposeCoroutineScope = recomposeCoroutineScope3;
                    lock$iv = recomposer$runRecomposeConcurrentlyAndApplyChanges$2.this$0.stateLock;
                    Recomposer this_$iv = recomposer$runRecomposeConcurrentlyAndApplyChanges$2.this$0;
                    synchronized (lock$iv) {
                        if (this_$iv.snapshotInvalidations.isEmpty()) {
                            obj3 = coroutine_suspended;
                        } else {
                            List $this$fastForEach$iv$iv = this_$iv.snapshotInvalidations;
                            int size = $this$fastForEach$iv$iv.size();
                            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                                Object item$iv$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
                                Set changes$iv = (Set) item$iv$iv;
                                List $this$fastForEach$iv$iv2 = this_$iv.knownCompositions;
                                int size2 = $this$fastForEach$iv$iv2.size();
                                int index$iv$iv2 = 0;
                                while (index$iv$iv2 < size2) {
                                    Object obj4 = coroutine_suspended;
                                    List $this$fastForEach$iv$iv3 = $this$fastForEach$iv$iv2;
                                    Object item$iv$iv2 = $this$fastForEach$iv$iv3.get(index$iv$iv2);
                                    ControlledComposition composition$iv = (ControlledComposition) item$iv$iv2;
                                    composition$iv.recordModificationsOf(changes$iv);
                                    index$iv$iv2++;
                                    coroutine_suspended = obj4;
                                    $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv3;
                                }
                            }
                            obj3 = coroutine_suspended;
                            this_$iv.snapshotInvalidations.clear();
                        }
                        List $this$fastForEach$iv$iv4 = this_$iv.compositionInvalidations;
                        int index$iv$iv3 = 0;
                        int size3 = $this$fastForEach$iv$iv4.size();
                        while (index$iv$iv3 < size3) {
                            Object item$iv$iv3 = $this$fastForEach$iv$iv4.get(index$iv$iv3);
                            ControlledComposition composition = (ControlledComposition) item$iv$iv3;
                            i = this_$iv.concurrentCompositionsOutstanding;
                            this_$iv.concurrentCompositionsOutstanding = i + 1;
                            BuildersKt__Builders_commonKt.launch$default(recomposeCoroutineScope, CompositionKt.getRecomposeCoroutineContext(composition), null, new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1(this_$iv, composition, null), 2, null);
                            index$iv$iv3++;
                            size3 = size3;
                            this_$iv = this_$iv;
                        }
                        Recomposer recomposer = this_$iv;
                        this_$iv.compositionInvalidations.clear();
                        if (this_$iv.deriveStateLocked() != null) {
                            throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
                        }
                        hasConcurrentFrameWorkLocked = recomposer.getHasConcurrentFrameWorkLocked();
                        requestFrameLocked = hasConcurrentFrameWorkLocked ? frameSignal.requestFrameLocked() : null;
                    }
                    if (requestFrameLocked != null) {
                        Result.Companion companion = Result.INSTANCE;
                        requestFrameLocked.resumeWith(Result.m4732constructorimpl(Unit.INSTANCE));
                    }
                    recomposeCoroutineScope3 = recomposeCoroutineScope;
                    coroutine_suspended = obj3;
                    i2 = 1;
                    shouldKeepRecomposing = recomposer$runRecomposeConcurrentlyAndApplyChanges$2.this$0.getShouldKeepRecomposing();
                    if (!shouldKeepRecomposing) {
                        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0 = frameLoop;
                        obj = null;
                        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$1 = null;
                        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$2 = null;
                        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.label = 2;
                        if (JobKt.cancelAndJoin(JobKt.getJob(recomposeCoroutineScope3.getCoroutineContext()), recomposer$runRecomposeConcurrentlyAndApplyChanges$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result3 = $result2;
                        Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 recomposer$runRecomposeConcurrentlyAndApplyChanges$23 = recomposer$runRecomposeConcurrentlyAndApplyChanges$2;
                        obj2 = coroutine_suspended;
                        recomposer$runRecomposeConcurrentlyAndApplyChanges$22 = recomposer$runRecomposeConcurrentlyAndApplyChanges$23;
                        recomposer$runRecomposeConcurrentlyAndApplyChanges$22.L$0 = obj;
                        recomposer$runRecomposeConcurrentlyAndApplyChanges$22.label = 3;
                        return JobKt.cancelAndJoin(frameLoop, recomposer$runRecomposeConcurrentlyAndApplyChanges$22) != obj2 ? obj2 : Unit.INSTANCE;
                    }
                }
            case 1:
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2 = this;
                Job frameLoop2 = (Job) recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$2;
                frameSignal = (ProduceFrameSignal) recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$1;
                CoroutineScope recomposeCoroutineScope4 = (CoroutineScope) recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0;
                ResultKt.throwOnFailure($result);
                recomposeCoroutineScope = recomposeCoroutineScope4;
                $result2 = $result;
                frameLoop = frameLoop2;
                lock$iv = recomposer$runRecomposeConcurrentlyAndApplyChanges$2.this$0.stateLock;
                Recomposer this_$iv2 = recomposer$runRecomposeConcurrentlyAndApplyChanges$2.this$0;
                synchronized (lock$iv) {
                }
                break;
            case 2:
                $result3 = $result;
                frameLoop = (Job) this.L$0;
                ResultKt.throwOnFailure($result3);
                obj = null;
                obj2 = coroutine_suspended;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$22 = this;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$22.L$0 = obj;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$22.label = 3;
                if (JobKt.cancelAndJoin(frameLoop, recomposer$runRecomposeConcurrentlyAndApplyChanges$22) != obj2) {
                }
                break;
            case 3:
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
