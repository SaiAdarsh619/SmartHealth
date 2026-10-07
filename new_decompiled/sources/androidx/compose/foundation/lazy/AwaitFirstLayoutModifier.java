package androidx.compose.foundation.lazy;

import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.OnGloballyPositionedModifier;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyListState.kt */
@Metadata(m286d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0011\u0010\u000b\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m287d2 = {"Landroidx/compose/foundation/lazy/AwaitFirstLayoutModifier;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "()V", "continuation", "Lkotlin/coroutines/Continuation;", "", "wasPositioned", "", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "waitForFirstLayout", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AwaitFirstLayoutModifier implements OnGloballyPositionedModifier {
    private Continuation<? super Unit> continuation;
    private boolean wasPositioned;

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object waitForFirstLayout(Continuation<? super Unit> continuation) {
        AwaitFirstLayoutModifier$waitForFirstLayout$1 awaitFirstLayoutModifier$waitForFirstLayout$1;
        AwaitFirstLayoutModifier$waitForFirstLayout$1 awaitFirstLayoutModifier$waitForFirstLayout$12;
        Continuation oldContinuation;
        if (continuation instanceof AwaitFirstLayoutModifier$waitForFirstLayout$1) {
            awaitFirstLayoutModifier$waitForFirstLayout$1 = (AwaitFirstLayoutModifier$waitForFirstLayout$1) continuation;
            if ((awaitFirstLayoutModifier$waitForFirstLayout$1.label & Integer.MIN_VALUE) != 0) {
                awaitFirstLayoutModifier$waitForFirstLayout$1.label -= Integer.MIN_VALUE;
                awaitFirstLayoutModifier$waitForFirstLayout$12 = awaitFirstLayoutModifier$waitForFirstLayout$1;
                Object $result = awaitFirstLayoutModifier$waitForFirstLayout$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (awaitFirstLayoutModifier$waitForFirstLayout$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!this.wasPositioned) {
                            Continuation oldContinuation2 = this.continuation;
                            awaitFirstLayoutModifier$waitForFirstLayout$12.L$0 = this;
                            awaitFirstLayoutModifier$waitForFirstLayout$12.L$1 = oldContinuation2;
                            awaitFirstLayoutModifier$waitForFirstLayout$12.label = 1;
                            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(awaitFirstLayoutModifier$waitForFirstLayout$12));
                            SafeContinuation it = safeContinuation;
                            this.continuation = it;
                            Object orThrow = safeContinuation.getOrThrow();
                            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                DebugProbesKt.probeCoroutineSuspended(awaitFirstLayoutModifier$waitForFirstLayout$12);
                            }
                            if (orThrow == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            oldContinuation = oldContinuation2;
                            if (oldContinuation != null) {
                                Result.Companion companion = Result.INSTANCE;
                                oldContinuation.resumeWith(Result.m4732constructorimpl(Unit.INSTANCE));
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        oldContinuation = (Continuation) awaitFirstLayoutModifier$waitForFirstLayout$12.L$1;
                        ResultKt.throwOnFailure($result);
                        if (oldContinuation != null) {
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        awaitFirstLayoutModifier$waitForFirstLayout$1 = new AwaitFirstLayoutModifier$waitForFirstLayout$1(this, continuation);
        awaitFirstLayoutModifier$waitForFirstLayout$12 = awaitFirstLayoutModifier$waitForFirstLayout$1;
        Object $result2 = awaitFirstLayoutModifier$waitForFirstLayout$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (awaitFirstLayoutModifier$waitForFirstLayout$12.label) {
        }
    }

    @Override // androidx.compose.p000ui.layout.OnGloballyPositionedModifier
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        if (!this.wasPositioned) {
            this.wasPositioned = true;
            Continuation<? super Unit> continuation = this.continuation;
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m4732constructorimpl(Unit.INSTANCE));
            }
            this.continuation = null;
        }
    }
}
