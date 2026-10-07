package androidx.compose.foundation.relocation;

import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* compiled from: BringIntoViewResponder.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.relocation.BringIntoViewResponderModifier$bringChildIntoView$2", m297f = "BringIntoViewResponder.kt", m298i = {0, 1, 1, 1, 2}, m299l = {224, 233, 240}, m300m = "invokeSuspend", m301n = {"thisRequest", "layoutCoordinates", "thisRequest", "previousRequest", "thisRequest"}, m302s = {"L$0", "L$0", "L$1", "L$2", "L$0"})
/* loaded from: classes.dex */
final class BringIntoViewResponderModifier$bringChildIntoView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Rect> $boundsProvider;
    final /* synthetic */ LayoutCoordinates $childCoordinates;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ BringIntoViewResponderModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BringIntoViewResponderModifier$bringChildIntoView$2(BringIntoViewResponderModifier bringIntoViewResponderModifier, LayoutCoordinates layoutCoordinates, Function0<Rect> function0, Continuation<? super BringIntoViewResponderModifier$bringChildIntoView$2> continuation) {
        super(2, continuation);
        this.this$0 = bringIntoViewResponderModifier;
        this.$childCoordinates = layoutCoordinates;
        this.$boundsProvider = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BringIntoViewResponderModifier$bringChildIntoView$2 bringIntoViewResponderModifier$bringChildIntoView$2 = new BringIntoViewResponderModifier$bringChildIntoView$2(this.this$0, this.$childCoordinates, this.$boundsProvider, continuation);
        bringIntoViewResponderModifier$bringChildIntoView$2.L$0 = obj;
        return bringIntoViewResponderModifier$bringChildIntoView$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BringIntoViewResponderModifier$bringChildIntoView$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c0 A[Catch: all -> 0x00fd, TRY_LEAVE, TryCatch #2 {all -> 0x00fd, blocks: (B:22:0x00b8, B:24:0x00c0, B:67:0x0092, B:70:0x009f, B:62:0x0103), top: B:66:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0133  */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.foundation.relocation.BringIntoViewResponderModifier$bringChildIntoView$2] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Pair pair;
        Pair pair2;
        Pair pair3;
        BringIntoViewResponderModifier$bringChildIntoView$2 bringIntoViewResponderModifier$bringChildIntoView$2;
        LayoutCoordinates layoutCoordinates;
        Rect localRect;
        Pair thisRequest;
        Pair previousRequest;
        boolean completelyOverlaps;
        Object dispatchRequest;
        BringIntoViewResponderModifier$bringChildIntoView$2 bringIntoViewResponderModifier$bringChildIntoView$22;
        Pair thisRequest2;
        Pair pair4;
        Pair pair5;
        Pair pair6;
        Pair pair7;
        Object dispatchRequest2;
        BringIntoViewResponderModifier$bringChildIntoView$2 bringIntoViewResponderModifier$bringChildIntoView$23;
        Pair thisRequest3;
        Pair pair8;
        Pair pair9;
        Pair pair10;
        ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        try {
            switch (r1) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    bringIntoViewResponderModifier$bringChildIntoView$2 = this;
                    CoroutineScope $this$coroutineScope = (CoroutineScope) bringIntoViewResponderModifier$bringChildIntoView$2.L$0;
                    LayoutCoordinates layoutCoordinates2 = bringIntoViewResponderModifier$bringChildIntoView$2.this$0.getLayoutCoordinates();
                    if (layoutCoordinates2 == null) {
                        return Unit.INSTANCE;
                    }
                    layoutCoordinates = layoutCoordinates2;
                    if (!bringIntoViewResponderModifier$bringChildIntoView$2.$childCoordinates.isAttached()) {
                        return Unit.INSTANCE;
                    }
                    LayoutCoordinates layoutCoordinates3 = bringIntoViewResponderModifier$bringChildIntoView$2.$childCoordinates;
                    Rect invoke = bringIntoViewResponderModifier$bringChildIntoView$2.$boundsProvider.invoke();
                    if (invoke == null) {
                        return Unit.INSTANCE;
                    }
                    localRect = BringIntoViewResponderKt.localRectOf(layoutCoordinates, layoutCoordinates3, invoke);
                    Job requestJob = JobKt.getJob($this$coroutineScope.getCoroutineContext());
                    thisRequest = new Pair(localRect, requestJob);
                    previousRequest = bringIntoViewResponderModifier$bringChildIntoView$2.this$0.newestReceivedRequest;
                    bringIntoViewResponderModifier$bringChildIntoView$2.this$0.newestReceivedRequest = thisRequest;
                    if (previousRequest != null) {
                        try {
                            completelyOverlaps = BringIntoViewResponderKt.completelyOverlaps((Rect) previousRequest.getFirst(), localRect);
                            if (completelyOverlaps) {
                                bringIntoViewResponderModifier$bringChildIntoView$2.L$0 = layoutCoordinates;
                                bringIntoViewResponderModifier$bringChildIntoView$2.L$1 = thisRequest;
                                bringIntoViewResponderModifier$bringChildIntoView$2.L$2 = previousRequest;
                                bringIntoViewResponderModifier$bringChildIntoView$2.label = 2;
                                if (((Job) previousRequest.getSecond()).join(bringIntoViewResponderModifier$bringChildIntoView$2) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                pair7 = bringIntoViewResponderModifier$bringChildIntoView$2.this$0.newestDispatchedRequest;
                                if (pair7 == previousRequest) {
                                    bringIntoViewResponderModifier$bringChildIntoView$2.L$0 = thisRequest;
                                    bringIntoViewResponderModifier$bringChildIntoView$2.L$1 = null;
                                    bringIntoViewResponderModifier$bringChildIntoView$2.L$2 = null;
                                    bringIntoViewResponderModifier$bringChildIntoView$2.label = 3;
                                    dispatchRequest2 = bringIntoViewResponderModifier$bringChildIntoView$2.this$0.dispatchRequest(thisRequest, layoutCoordinates, bringIntoViewResponderModifier$bringChildIntoView$2);
                                    if (dispatchRequest2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    bringIntoViewResponderModifier$bringChildIntoView$23 = bringIntoViewResponderModifier$bringChildIntoView$2;
                                    thisRequest3 = thisRequest;
                                    thisRequest = thisRequest3;
                                    bringIntoViewResponderModifier$bringChildIntoView$2 = bringIntoViewResponderModifier$bringChildIntoView$23;
                                }
                                pair8 = bringIntoViewResponderModifier$bringChildIntoView$2.this$0.newestDispatchedRequest;
                                pair9 = bringIntoViewResponderModifier$bringChildIntoView$2.this$0.newestReceivedRequest;
                                if (pair8 == pair9) {
                                    bringIntoViewResponderModifier$bringChildIntoView$2.this$0.newestDispatchedRequest = null;
                                }
                                pair10 = bringIntoViewResponderModifier$bringChildIntoView$2.this$0.newestReceivedRequest;
                                if (pair10 == thisRequest) {
                                    bringIntoViewResponderModifier$bringChildIntoView$2.this$0.newestReceivedRequest = null;
                                }
                                return Unit.INSTANCE;
                            }
                        } catch (Throwable th) {
                            th = th;
                            coroutine_suspended = bringIntoViewResponderModifier$bringChildIntoView$2;
                            r1 = thisRequest;
                            pair = coroutine_suspended.this$0.newestDispatchedRequest;
                            pair2 = coroutine_suspended.this$0.newestReceivedRequest;
                            if (pair == pair2) {
                            }
                            pair3 = coroutine_suspended.this$0.newestReceivedRequest;
                            if (pair3 == r1) {
                            }
                            throw th;
                        }
                    }
                    bringIntoViewResponderModifier$bringChildIntoView$2.L$0 = thisRequest;
                    bringIntoViewResponderModifier$bringChildIntoView$2.label = 1;
                    dispatchRequest = bringIntoViewResponderModifier$bringChildIntoView$2.this$0.dispatchRequest(thisRequest, layoutCoordinates, bringIntoViewResponderModifier$bringChildIntoView$2);
                    if (dispatchRequest == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    bringIntoViewResponderModifier$bringChildIntoView$22 = bringIntoViewResponderModifier$bringChildIntoView$2;
                    thisRequest2 = thisRequest;
                    Unit unit = Unit.INSTANCE;
                    pair4 = bringIntoViewResponderModifier$bringChildIntoView$22.this$0.newestDispatchedRequest;
                    pair5 = bringIntoViewResponderModifier$bringChildIntoView$22.this$0.newestReceivedRequest;
                    if (pair4 == pair5) {
                        bringIntoViewResponderModifier$bringChildIntoView$22.this$0.newestDispatchedRequest = null;
                    }
                    pair6 = bringIntoViewResponderModifier$bringChildIntoView$22.this$0.newestReceivedRequest;
                    if (pair6 == thisRequest2) {
                        bringIntoViewResponderModifier$bringChildIntoView$22.this$0.newestReceivedRequest = null;
                    }
                    return unit;
                case 1:
                    bringIntoViewResponderModifier$bringChildIntoView$22 = this;
                    thisRequest2 = (Pair) bringIntoViewResponderModifier$bringChildIntoView$22.L$0;
                    ResultKt.throwOnFailure($result);
                    Unit unit2 = Unit.INSTANCE;
                    pair4 = bringIntoViewResponderModifier$bringChildIntoView$22.this$0.newestDispatchedRequest;
                    pair5 = bringIntoViewResponderModifier$bringChildIntoView$22.this$0.newestReceivedRequest;
                    if (pair4 == pair5) {
                    }
                    pair6 = bringIntoViewResponderModifier$bringChildIntoView$22.this$0.newestReceivedRequest;
                    if (pair6 == thisRequest2) {
                    }
                    return unit2;
                case 2:
                    bringIntoViewResponderModifier$bringChildIntoView$2 = this;
                    Pair previousRequest2 = (Pair) bringIntoViewResponderModifier$bringChildIntoView$2.L$2;
                    Pair thisRequest4 = (Pair) bringIntoViewResponderModifier$bringChildIntoView$2.L$1;
                    layoutCoordinates = (LayoutCoordinates) bringIntoViewResponderModifier$bringChildIntoView$2.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        previousRequest = previousRequest2;
                        thisRequest = thisRequest4;
                        pair7 = bringIntoViewResponderModifier$bringChildIntoView$2.this$0.newestDispatchedRequest;
                        if (pair7 == previousRequest) {
                        }
                        pair8 = bringIntoViewResponderModifier$bringChildIntoView$2.this$0.newestDispatchedRequest;
                        pair9 = bringIntoViewResponderModifier$bringChildIntoView$2.this$0.newestReceivedRequest;
                        if (pair8 == pair9) {
                        }
                        pair10 = bringIntoViewResponderModifier$bringChildIntoView$2.this$0.newestReceivedRequest;
                        if (pair10 == thisRequest) {
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        coroutine_suspended = bringIntoViewResponderModifier$bringChildIntoView$2;
                        r1 = thisRequest4;
                        pair = coroutine_suspended.this$0.newestDispatchedRequest;
                        pair2 = coroutine_suspended.this$0.newestReceivedRequest;
                        if (pair == pair2) {
                            coroutine_suspended.this$0.newestDispatchedRequest = null;
                        }
                        pair3 = coroutine_suspended.this$0.newestReceivedRequest;
                        if (pair3 == r1) {
                            coroutine_suspended.this$0.newestReceivedRequest = null;
                        }
                        throw th;
                    }
                case 3:
                    bringIntoViewResponderModifier$bringChildIntoView$23 = this;
                    thisRequest3 = (Pair) bringIntoViewResponderModifier$bringChildIntoView$23.L$0;
                    ResultKt.throwOnFailure($result);
                    thisRequest = thisRequest3;
                    bringIntoViewResponderModifier$bringChildIntoView$2 = bringIntoViewResponderModifier$bringChildIntoView$23;
                    pair8 = bringIntoViewResponderModifier$bringChildIntoView$2.this$0.newestDispatchedRequest;
                    pair9 = bringIntoViewResponderModifier$bringChildIntoView$2.this$0.newestReceivedRequest;
                    if (pair8 == pair9) {
                    }
                    pair10 = bringIntoViewResponderModifier$bringChildIntoView$2.this$0.newestReceivedRequest;
                    if (pair10 == thisRequest) {
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
