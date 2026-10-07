package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.p000ui.unit.Velocity;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: Scrollable.kt */
@Metadata(m286d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ!\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J!\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001fH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b&\u0010\"J-\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.J#\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020)2\u0006\u0010+\u001a\u00020,ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102J\u001b\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020)ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106J\u000e\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020\u0005J\u0006\u00109\u001a\u00020\u0005J'\u0010:\u001a\u00020)*\u00020;2\u0006\u0010<\u001a\u00020)2\u0006\u0010+\u001a\u00020,ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020)*\u00020)ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u00106J\n\u0010?\u001a\u00020A*\u00020AJ\u0017\u0010B\u001a\u00020)*\u00020)ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u00106J\u0017\u0010D\u001a\u00020\u001f*\u00020\u001fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bE\u00106J\u0017\u0010F\u001a\u00020A*\u00020)ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010HJ\u0017\u0010F\u001a\u00020A*\u00020\u001fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bI\u0010HJ\u001a\u0010J\u001a\u00020)*\u00020Aø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bK\u0010LJ\u001f\u0010M\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010N\u001a\u00020Aø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bO\u0010PR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u0082\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006Q"}, m287d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "", "nestedScrollDispatcher", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/runtime/State;Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/OverscrollEffect;)V", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "isNestedFlinging", "Landroidx/compose/runtime/MutableState;", "getNestedScrollDispatcher", "()Landroidx/compose/runtime/State;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getOverscrollEffect", "()Landroidx/compose/foundation/OverscrollEffect;", "getReverseDirection", "()Z", "getScrollableState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "doFlingAnimation", "Landroidx/compose/ui/unit/Velocity;", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped", "", "initialVelocity", "onDragStopped-sF-c-tU", "overscrollPostConsumeDelta", "consumedByChain", "Landroidx/compose/ui/geometry/Offset;", "availableForOverscroll", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "overscrollPostConsumeDelta-OMhpSzk", "(JJI)V", "overscrollPreConsumeDelta", "scrollDelta", "overscrollPreConsumeDelta-OzD1aCk", "(JI)J", "performRawScroll", "scroll", "performRawScroll-MK-Hz9U", "(J)J", "registerNestedFling", "isFlinging", "shouldScrollImmediately", "dispatchScroll", "Landroidx/compose/foundation/gestures/ScrollScope;", "availableDelta", "dispatchScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "", "singleAxisOffset", "singleAxisOffset-MK-Hz9U", "singleAxisVelocity", "singleAxisVelocity-AH228Gc", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "update", "newValue", "update-QWom1Mo", "(JF)J", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class ScrollingLogic {
    private final FlingBehavior flingBehavior;
    private final MutableState<Boolean> isNestedFlinging;
    private final State<NestedScrollDispatcher> nestedScrollDispatcher;
    private final Orientation orientation;
    private final OverscrollEffect overscrollEffect;
    private final boolean reverseDirection;
    private final ScrollableState scrollableState;

    public ScrollingLogic(Orientation orientation, boolean reverseDirection, State<NestedScrollDispatcher> nestedScrollDispatcher, ScrollableState scrollableState, FlingBehavior flingBehavior, OverscrollEffect overscrollEffect) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(nestedScrollDispatcher, "nestedScrollDispatcher");
        Intrinsics.checkNotNullParameter(scrollableState, "scrollableState");
        Intrinsics.checkNotNullParameter(flingBehavior, "flingBehavior");
        this.orientation = orientation;
        this.reverseDirection = reverseDirection;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        this.scrollableState = scrollableState;
        this.flingBehavior = flingBehavior;
        this.overscrollEffect = overscrollEffect;
        this.isNestedFlinging = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    public final State<NestedScrollDispatcher> getNestedScrollDispatcher() {
        return this.nestedScrollDispatcher;
    }

    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    public final OverscrollEffect getOverscrollEffect() {
        return this.overscrollEffect;
    }

    /* renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m668toOffsettuRUvjQ(float $this$toOffset_u2dtuRUvjQ) {
        if ($this$toOffset_u2dtuRUvjQ == 0.0f) {
            return Offset.INSTANCE.m1776getZeroF1C5BW0();
        }
        if (this.orientation == Orientation.Horizontal) {
            return OffsetKt.Offset($this$toOffset_u2dtuRUvjQ, 0.0f);
        }
        return OffsetKt.Offset(0.0f, $this$toOffset_u2dtuRUvjQ);
    }

    /* renamed from: singleAxisOffset-MK-Hz9U, reason: not valid java name */
    public final long m664singleAxisOffsetMKHz9U(long $this$singleAxisOffset_u2dMK_u2dHz9U) {
        return Offset.m1754copydBAh8RU$default($this$singleAxisOffset_u2dMK_u2dHz9U, 0.0f, 0.0f, this.orientation == Orientation.Horizontal ? 1 : 2, null);
    }

    /* renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m667toFloatk4lQ0M(long $this$toFloat_u2dk_u2d4lQ0M) {
        return this.orientation == Orientation.Horizontal ? Offset.m1760getXimpl($this$toFloat_u2dk_u2d4lQ0M) : Offset.m1761getYimpl($this$toFloat_u2dk_u2d4lQ0M);
    }

    /* renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m666toFloatTH1AsA0(long $this$toFloat_u2dTH1AsA0) {
        return this.orientation == Orientation.Horizontal ? Velocity.m4607getXimpl($this$toFloat_u2dTH1AsA0) : Velocity.m4608getYimpl($this$toFloat_u2dTH1AsA0);
    }

    /* renamed from: singleAxisVelocity-AH228Gc, reason: not valid java name */
    public final long m665singleAxisVelocityAH228Gc(long $this$singleAxisVelocity_u2dAH228Gc) {
        return Velocity.m4603copyOhffZ5M$default($this$singleAxisVelocity_u2dAH228Gc, 0.0f, 0.0f, this.orientation == Orientation.Horizontal ? 1 : 2, null);
    }

    /* renamed from: update-QWom1Mo, reason: not valid java name */
    public final long m669updateQWom1Mo(long $this$update_u2dQWom1Mo, float newValue) {
        int i;
        Object obj;
        float f;
        long j;
        float f2;
        if (this.orientation == Orientation.Horizontal) {
            i = 2;
            obj = null;
            f2 = 0.0f;
            j = $this$update_u2dQWom1Mo;
            f = newValue;
        } else {
            i = 1;
            obj = null;
            f = 0.0f;
            j = $this$update_u2dQWom1Mo;
            f2 = newValue;
        }
        return Velocity.m4603copyOhffZ5M$default(j, f, f2, i, obj);
    }

    public final float reverseIfNeeded(float $this$reverseIfNeeded) {
        return this.reverseDirection ? (-1) * $this$reverseIfNeeded : $this$reverseIfNeeded;
    }

    /* renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m663reverseIfNeededMKHz9U(long $this$reverseIfNeeded_u2dMK_u2dHz9U) {
        return this.reverseDirection ? Offset.m1767timestuRUvjQ($this$reverseIfNeeded_u2dMK_u2dHz9U, -1.0f) : $this$reverseIfNeeded_u2dMK_u2dHz9U;
    }

    /* renamed from: dispatchScroll-3eAAhYA, reason: not valid java name */
    public final long m658dispatchScroll3eAAhYA(ScrollScope dispatchScroll, long availableDelta, int source) {
        Intrinsics.checkNotNullParameter(dispatchScroll, "$this$dispatchScroll");
        long scrollDelta = m664singleAxisOffsetMKHz9U(availableDelta);
        long overscrollPreConsumed = m661overscrollPreConsumeDeltaOzD1aCk(scrollDelta, source);
        long afterPreOverscroll = Offset.m1764minusMKHz9U(scrollDelta, overscrollPreConsumed);
        NestedScrollDispatcher nestedScrollDispatcher = this.nestedScrollDispatcher.getValue();
        long preConsumedByParent = nestedScrollDispatcher.m3254dispatchPreScrollOzD1aCk(afterPreOverscroll, source);
        long scrollAvailable = Offset.m1764minusMKHz9U(afterPreOverscroll, preConsumedByParent);
        long axisConsumed = m663reverseIfNeededMKHz9U(m668toOffsettuRUvjQ(dispatchScroll.scrollBy(m667toFloatk4lQ0M(m663reverseIfNeededMKHz9U(scrollAvailable)))));
        long leftForParent = Offset.m1764minusMKHz9U(scrollAvailable, axisConsumed);
        long parentConsumed = nestedScrollDispatcher.m3252dispatchPostScrollDzOQY0M(axisConsumed, leftForParent, source);
        m657overscrollPostConsumeDeltaOMhpSzk(scrollAvailable, Offset.m1764minusMKHz9U(leftForParent, parentConsumed), source);
        return Offset.m1764minusMKHz9U(leftForParent, parentConsumed);
    }

    /* renamed from: overscrollPreConsumeDelta-OzD1aCk, reason: not valid java name */
    public final long m661overscrollPreConsumeDeltaOzD1aCk(long scrollDelta, int source) {
        if (this.overscrollEffect != null && this.overscrollEffect.isEnabled()) {
            return this.overscrollEffect.mo490consumePreScrollOzD1aCk(scrollDelta, source);
        }
        return Offset.INSTANCE.m1776getZeroF1C5BW0();
    }

    /* renamed from: overscrollPostConsumeDelta-OMhpSzk, reason: not valid java name */
    private final void m657overscrollPostConsumeDeltaOMhpSzk(long consumedByChain, long availableForOverscroll, int source) {
        if (this.overscrollEffect != null && this.overscrollEffect.isEnabled()) {
            this.overscrollEffect.mo488consumePostScrollOMhpSzk(consumedByChain, availableForOverscroll, source);
        }
    }

    /* renamed from: performRawScroll-MK-Hz9U, reason: not valid java name */
    public final long m662performRawScrollMKHz9U(long scroll) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.INSTANCE.m1776getZeroF1C5BW0();
        }
        return m668toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m667toFloatk4lQ0M(scroll)))));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0119 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: onDragStopped-sF-c-tU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m660onDragStoppedsFctU(long initialVelocity, Continuation<? super Unit> continuation) {
        ScrollingLogic$onDragStopped$1 scrollingLogic$onDragStopped$1;
        ScrollingLogic$onDragStopped$1 scrollingLogic$onDragStopped$12;
        ScrollingLogic scrollingLogic;
        long velocity;
        long preOverscrollConsumed;
        Object mo489consumePreFlingQWom1Mo;
        long available;
        Object m3253dispatchPreFlingQWom1Mo;
        long velocityLeft;
        Object m659doFlingAnimationQWom1Mo;
        ScrollingLogic scrollingLogic2;
        long velocityLeft2;
        Object m3251dispatchPostFlingRZ2iAVY;
        ScrollingLogic scrollingLogic3;
        long consumedPost;
        OverscrollEffect overscrollEffect;
        ScrollingLogic scrollingLogic4;
        if (continuation instanceof ScrollingLogic$onDragStopped$1) {
            scrollingLogic$onDragStopped$1 = (ScrollingLogic$onDragStopped$1) continuation;
            if ((scrollingLogic$onDragStopped$1.label & Integer.MIN_VALUE) != 0) {
                scrollingLogic$onDragStopped$1.label -= Integer.MIN_VALUE;
                scrollingLogic$onDragStopped$12 = scrollingLogic$onDragStopped$1;
                Object $result = scrollingLogic$onDragStopped$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (scrollingLogic$onDragStopped$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        scrollingLogic = this;
                        scrollingLogic.registerNestedFling(true);
                        velocity = scrollingLogic.m665singleAxisVelocityAH228Gc(initialVelocity);
                        if (scrollingLogic.overscrollEffect == null || !scrollingLogic.overscrollEffect.isEnabled()) {
                            preOverscrollConsumed = Velocity.INSTANCE.m4618getZero9UxMQ8M();
                            available = Velocity.m4610minusAH228Gc(velocity, preOverscrollConsumed);
                            NestedScrollDispatcher value = scrollingLogic.nestedScrollDispatcher.getValue();
                            scrollingLogic$onDragStopped$12.L$0 = scrollingLogic;
                            scrollingLogic$onDragStopped$12.J$0 = available;
                            scrollingLogic$onDragStopped$12.label = 2;
                            m3253dispatchPreFlingQWom1Mo = value.m3253dispatchPreFlingQWom1Mo(available, scrollingLogic$onDragStopped$12);
                            if (m3253dispatchPreFlingQWom1Mo == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            long preConsumedByParent = ((Velocity) m3253dispatchPreFlingQWom1Mo).getPackedValue();
                            velocityLeft = Velocity.m4610minusAH228Gc(available, preConsumedByParent);
                            scrollingLogic$onDragStopped$12.L$0 = scrollingLogic;
                            scrollingLogic$onDragStopped$12.J$0 = velocityLeft;
                            scrollingLogic$onDragStopped$12.label = 3;
                            m659doFlingAnimationQWom1Mo = scrollingLogic.m659doFlingAnimationQWom1Mo(velocityLeft, scrollingLogic$onDragStopped$12);
                            if (m659doFlingAnimationQWom1Mo != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            scrollingLogic2 = scrollingLogic;
                            velocityLeft2 = ((Velocity) m659doFlingAnimationQWom1Mo).getPackedValue();
                            NestedScrollDispatcher value2 = scrollingLogic2.nestedScrollDispatcher.getValue();
                            long m4610minusAH228Gc = Velocity.m4610minusAH228Gc(velocityLeft, velocityLeft2);
                            scrollingLogic$onDragStopped$12.L$0 = scrollingLogic2;
                            scrollingLogic$onDragStopped$12.J$0 = velocityLeft2;
                            scrollingLogic$onDragStopped$12.label = 4;
                            m3251dispatchPostFlingRZ2iAVY = value2.m3251dispatchPostFlingRZ2iAVY(m4610minusAH228Gc, velocityLeft2, scrollingLogic$onDragStopped$12);
                            if (m3251dispatchPostFlingRZ2iAVY != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            scrollingLogic3 = scrollingLogic2;
                            long consumedPost2 = ((Velocity) m3251dispatchPostFlingRZ2iAVY).getPackedValue();
                            consumedPost = Velocity.m4610minusAH228Gc(velocityLeft2, consumedPost2);
                            if (scrollingLogic3.overscrollEffect != null && scrollingLogic3.overscrollEffect.isEnabled()) {
                                overscrollEffect = scrollingLogic3.overscrollEffect;
                                scrollingLogic$onDragStopped$12.L$0 = scrollingLogic3;
                                scrollingLogic$onDragStopped$12.label = 5;
                                if (overscrollEffect.mo487consumePostFlingsFctU(consumedPost, scrollingLogic$onDragStopped$12) != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                scrollingLogic4 = scrollingLogic3;
                                scrollingLogic3 = scrollingLogic4;
                            }
                            scrollingLogic3.registerNestedFling(false);
                            return Unit.INSTANCE;
                        }
                        OverscrollEffect overscrollEffect2 = scrollingLogic.overscrollEffect;
                        scrollingLogic$onDragStopped$12.L$0 = scrollingLogic;
                        scrollingLogic$onDragStopped$12.J$0 = velocity;
                        scrollingLogic$onDragStopped$12.label = 1;
                        mo489consumePreFlingQWom1Mo = overscrollEffect2.mo489consumePreFlingQWom1Mo(velocity, scrollingLogic$onDragStopped$12);
                        if (mo489consumePreFlingQWom1Mo == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        preOverscrollConsumed = ((Velocity) mo489consumePreFlingQWom1Mo).getPackedValue();
                        available = Velocity.m4610minusAH228Gc(velocity, preOverscrollConsumed);
                        NestedScrollDispatcher value3 = scrollingLogic.nestedScrollDispatcher.getValue();
                        scrollingLogic$onDragStopped$12.L$0 = scrollingLogic;
                        scrollingLogic$onDragStopped$12.J$0 = available;
                        scrollingLogic$onDragStopped$12.label = 2;
                        m3253dispatchPreFlingQWom1Mo = value3.m3253dispatchPreFlingQWom1Mo(available, scrollingLogic$onDragStopped$12);
                        if (m3253dispatchPreFlingQWom1Mo == coroutine_suspended) {
                        }
                        long preConsumedByParent2 = ((Velocity) m3253dispatchPreFlingQWom1Mo).getPackedValue();
                        velocityLeft = Velocity.m4610minusAH228Gc(available, preConsumedByParent2);
                        scrollingLogic$onDragStopped$12.L$0 = scrollingLogic;
                        scrollingLogic$onDragStopped$12.J$0 = velocityLeft;
                        scrollingLogic$onDragStopped$12.label = 3;
                        m659doFlingAnimationQWom1Mo = scrollingLogic.m659doFlingAnimationQWom1Mo(velocityLeft, scrollingLogic$onDragStopped$12);
                        if (m659doFlingAnimationQWom1Mo != coroutine_suspended) {
                        }
                        break;
                    case 1:
                        velocity = scrollingLogic$onDragStopped$12.J$0;
                        scrollingLogic = (ScrollingLogic) scrollingLogic$onDragStopped$12.L$0;
                        ResultKt.throwOnFailure($result);
                        mo489consumePreFlingQWom1Mo = $result;
                        preOverscrollConsumed = ((Velocity) mo489consumePreFlingQWom1Mo).getPackedValue();
                        available = Velocity.m4610minusAH228Gc(velocity, preOverscrollConsumed);
                        NestedScrollDispatcher value32 = scrollingLogic.nestedScrollDispatcher.getValue();
                        scrollingLogic$onDragStopped$12.L$0 = scrollingLogic;
                        scrollingLogic$onDragStopped$12.J$0 = available;
                        scrollingLogic$onDragStopped$12.label = 2;
                        m3253dispatchPreFlingQWom1Mo = value32.m3253dispatchPreFlingQWom1Mo(available, scrollingLogic$onDragStopped$12);
                        if (m3253dispatchPreFlingQWom1Mo == coroutine_suspended) {
                        }
                        long preConsumedByParent22 = ((Velocity) m3253dispatchPreFlingQWom1Mo).getPackedValue();
                        velocityLeft = Velocity.m4610minusAH228Gc(available, preConsumedByParent22);
                        scrollingLogic$onDragStopped$12.L$0 = scrollingLogic;
                        scrollingLogic$onDragStopped$12.J$0 = velocityLeft;
                        scrollingLogic$onDragStopped$12.label = 3;
                        m659doFlingAnimationQWom1Mo = scrollingLogic.m659doFlingAnimationQWom1Mo(velocityLeft, scrollingLogic$onDragStopped$12);
                        if (m659doFlingAnimationQWom1Mo != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        available = scrollingLogic$onDragStopped$12.J$0;
                        scrollingLogic = (ScrollingLogic) scrollingLogic$onDragStopped$12.L$0;
                        ResultKt.throwOnFailure($result);
                        m3253dispatchPreFlingQWom1Mo = $result;
                        long preConsumedByParent222 = ((Velocity) m3253dispatchPreFlingQWom1Mo).getPackedValue();
                        velocityLeft = Velocity.m4610minusAH228Gc(available, preConsumedByParent222);
                        scrollingLogic$onDragStopped$12.L$0 = scrollingLogic;
                        scrollingLogic$onDragStopped$12.J$0 = velocityLeft;
                        scrollingLogic$onDragStopped$12.label = 3;
                        m659doFlingAnimationQWom1Mo = scrollingLogic.m659doFlingAnimationQWom1Mo(velocityLeft, scrollingLogic$onDragStopped$12);
                        if (m659doFlingAnimationQWom1Mo != coroutine_suspended) {
                        }
                        break;
                    case 3:
                        velocityLeft = scrollingLogic$onDragStopped$12.J$0;
                        ScrollingLogic scrollingLogic5 = (ScrollingLogic) scrollingLogic$onDragStopped$12.L$0;
                        ResultKt.throwOnFailure($result);
                        scrollingLogic2 = scrollingLogic5;
                        m659doFlingAnimationQWom1Mo = $result;
                        velocityLeft2 = ((Velocity) m659doFlingAnimationQWom1Mo).getPackedValue();
                        NestedScrollDispatcher value22 = scrollingLogic2.nestedScrollDispatcher.getValue();
                        long m4610minusAH228Gc2 = Velocity.m4610minusAH228Gc(velocityLeft, velocityLeft2);
                        scrollingLogic$onDragStopped$12.L$0 = scrollingLogic2;
                        scrollingLogic$onDragStopped$12.J$0 = velocityLeft2;
                        scrollingLogic$onDragStopped$12.label = 4;
                        m3251dispatchPostFlingRZ2iAVY = value22.m3251dispatchPostFlingRZ2iAVY(m4610minusAH228Gc2, velocityLeft2, scrollingLogic$onDragStopped$12);
                        if (m3251dispatchPostFlingRZ2iAVY != coroutine_suspended) {
                        }
                        break;
                    case 4:
                        long velocityLeft3 = scrollingLogic$onDragStopped$12.J$0;
                        scrollingLogic3 = (ScrollingLogic) scrollingLogic$onDragStopped$12.L$0;
                        ResultKt.throwOnFailure($result);
                        velocityLeft2 = velocityLeft3;
                        m3251dispatchPostFlingRZ2iAVY = $result;
                        long consumedPost22 = ((Velocity) m3251dispatchPostFlingRZ2iAVY).getPackedValue();
                        consumedPost = Velocity.m4610minusAH228Gc(velocityLeft2, consumedPost22);
                        if (scrollingLogic3.overscrollEffect != null) {
                            overscrollEffect = scrollingLogic3.overscrollEffect;
                            scrollingLogic$onDragStopped$12.L$0 = scrollingLogic3;
                            scrollingLogic$onDragStopped$12.label = 5;
                            if (overscrollEffect.mo487consumePostFlingsFctU(consumedPost, scrollingLogic$onDragStopped$12) != coroutine_suspended) {
                            }
                            break;
                        }
                        scrollingLogic3.registerNestedFling(false);
                        return Unit.INSTANCE;
                    case 5:
                        scrollingLogic4 = (ScrollingLogic) scrollingLogic$onDragStopped$12.L$0;
                        ResultKt.throwOnFailure($result);
                        scrollingLogic3 = scrollingLogic4;
                        scrollingLogic3.registerNestedFling(false);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        scrollingLogic$onDragStopped$1 = new ScrollingLogic$onDragStopped$1(this, continuation);
        scrollingLogic$onDragStopped$12 = scrollingLogic$onDragStopped$1;
        Object $result2 = scrollingLogic$onDragStopped$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (scrollingLogic$onDragStopped$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: doFlingAnimation-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m659doFlingAnimationQWom1Mo(long available, Continuation<? super Velocity> continuation) {
        ScrollingLogic$doFlingAnimation$1 scrollingLogic$doFlingAnimation$1;
        ScrollingLogic$doFlingAnimation$1 scrollingLogic$doFlingAnimation$12;
        Ref.LongRef result;
        if (continuation instanceof ScrollingLogic$doFlingAnimation$1) {
            scrollingLogic$doFlingAnimation$1 = (ScrollingLogic$doFlingAnimation$1) continuation;
            if ((scrollingLogic$doFlingAnimation$1.label & Integer.MIN_VALUE) != 0) {
                scrollingLogic$doFlingAnimation$1.label -= Integer.MIN_VALUE;
                scrollingLogic$doFlingAnimation$12 = scrollingLogic$doFlingAnimation$1;
                Object $result = scrollingLogic$doFlingAnimation$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (scrollingLogic$doFlingAnimation$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Ref.LongRef result2 = new Ref.LongRef();
                        result2.element = available;
                        ScrollableState scrollableState = this.scrollableState;
                        ScrollingLogic$doFlingAnimation$2 scrollingLogic$doFlingAnimation$2 = new ScrollingLogic$doFlingAnimation$2(this, result2, available, null);
                        scrollingLogic$doFlingAnimation$12.L$0 = result2;
                        scrollingLogic$doFlingAnimation$12.label = 1;
                        if (ScrollableState.scroll$default(scrollableState, null, scrollingLogic$doFlingAnimation$2, scrollingLogic$doFlingAnimation$12, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        result = result2;
                        break;
                    case 1:
                        result = (Ref.LongRef) scrollingLogic$doFlingAnimation$12.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Velocity.m4598boximpl(result.element);
            }
        }
        scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, continuation);
        scrollingLogic$doFlingAnimation$12 = scrollingLogic$doFlingAnimation$1;
        Object $result2 = scrollingLogic$doFlingAnimation$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (scrollingLogic$doFlingAnimation$12.label) {
        }
        return Velocity.m4598boximpl(result.element);
    }

    public final boolean shouldScrollImmediately() {
        if (!this.scrollableState.isScrollInProgress() && !this.isNestedFlinging.getValue().booleanValue()) {
            OverscrollEffect overscrollEffect = this.overscrollEffect;
            if (!(overscrollEffect != null ? overscrollEffect.isInProgress() : false)) {
                return false;
            }
        }
        return true;
    }

    public final void registerNestedFling(boolean isFlinging) {
        this.isNestedFlinging.setValue(Boolean.valueOf(isFlinging));
    }
}
