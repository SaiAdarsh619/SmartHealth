package androidx.compose.foundation.gestures;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p000ui.unit.Velocity;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: Scrollable.kt */
@Metadata(m286d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, m287d2 = {"androidx/compose/foundation/gestures/ScrollableKt$scrollableNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ScrollableKt$scrollableNestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ State<ScrollingLogic> $scrollLogic;

    ScrollableKt$scrollableNestedScrollConnection$1(State<ScrollingLogic> state, boolean $enabled) {
        this.$scrollLogic = state;
        this.$enabled = $enabled;
    }

    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public long mo656onPreScrollOzD1aCk(long available, int source) {
        if (NestedScrollSource.m3258equalsimpl0(source, NestedScrollSource.INSTANCE.m3264getFlingWNlRxjI())) {
            this.$scrollLogic.getValue().registerNestedFling(true);
        }
        return Offset.INSTANCE.m1776getZeroF1C5BW0();
    }

    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long mo655onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (this.$enabled) {
            return this.$scrollLogic.getValue().m662performRawScrollMKHz9U(available);
        }
        return Offset.INSTANCE.m1776getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo654onPostFlingRZ2iAVY(long j, long available, Continuation<? super Velocity> continuation) {
        ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1;
        ScrollableKt$scrollableNestedScrollConnection$1 scrollableKt$scrollableNestedScrollConnection$1;
        long available2;
        Object m659doFlingAnimationQWom1Mo;
        ScrollableKt$scrollableNestedScrollConnection$1 scrollableKt$scrollableNestedScrollConnection$12;
        if (continuation instanceof ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1) {
            scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 = (ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1) continuation;
            if ((scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.label -= Integer.MIN_VALUE;
                Object $result = scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        scrollableKt$scrollableNestedScrollConnection$1 = this;
                        if (scrollableKt$scrollableNestedScrollConnection$1.$enabled) {
                            ScrollingLogic value = scrollableKt$scrollableNestedScrollConnection$1.$scrollLogic.getValue();
                            scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.L$0 = scrollableKt$scrollableNestedScrollConnection$1;
                            scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.J$0 = available;
                            scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.label = 1;
                            m659doFlingAnimationQWom1Mo = value.m659doFlingAnimationQWom1Mo(available, scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1);
                            if (m659doFlingAnimationQWom1Mo == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            scrollableKt$scrollableNestedScrollConnection$12 = scrollableKt$scrollableNestedScrollConnection$1;
                            long velocityLeft = ((Velocity) m659doFlingAnimationQWom1Mo).getPackedValue();
                            available2 = Velocity.m4610minusAH228Gc(available, velocityLeft);
                            scrollableKt$scrollableNestedScrollConnection$1 = scrollableKt$scrollableNestedScrollConnection$12;
                            Velocity m4598boximpl = Velocity.m4598boximpl(available2);
                            State<ScrollingLogic> state = scrollableKt$scrollableNestedScrollConnection$1.$scrollLogic;
                            m4598boximpl.getPackedValue();
                            state.getValue().registerNestedFling(false);
                            return m4598boximpl;
                        }
                        available2 = Velocity.INSTANCE.m4618getZero9UxMQ8M();
                        Velocity m4598boximpl2 = Velocity.m4598boximpl(available2);
                        State<ScrollingLogic> state2 = scrollableKt$scrollableNestedScrollConnection$1.$scrollLogic;
                        m4598boximpl2.getPackedValue();
                        state2.getValue().registerNestedFling(false);
                        return m4598boximpl2;
                    case 1:
                        available = scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.J$0;
                        scrollableKt$scrollableNestedScrollConnection$12 = (ScrollableKt$scrollableNestedScrollConnection$1) scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.L$0;
                        ResultKt.throwOnFailure($result);
                        m659doFlingAnimationQWom1Mo = $result;
                        long velocityLeft2 = ((Velocity) m659doFlingAnimationQWom1Mo).getPackedValue();
                        available2 = Velocity.m4610minusAH228Gc(available, velocityLeft2);
                        scrollableKt$scrollableNestedScrollConnection$1 = scrollableKt$scrollableNestedScrollConnection$12;
                        Velocity m4598boximpl22 = Velocity.m4598boximpl(available2);
                        State<ScrollingLogic> state22 = scrollableKt$scrollableNestedScrollConnection$1.$scrollLogic;
                        m4598boximpl22.getPackedValue();
                        state22.getValue().registerNestedFling(false);
                        return m4598boximpl22;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 = new ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1(this, continuation);
        Object $result2 = scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.label) {
        }
    }
}
