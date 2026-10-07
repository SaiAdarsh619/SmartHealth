package androidx.compose.material;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p000ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: Swipeable.kt */
@Metadata(m286d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u0015*\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\t*\u00020\u0015H\u0002ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0018\u0082\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0019"}, m287d2 = {"androidx/compose/material/SwipeableKt$PreUpPostDownNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "(J)F", "toOffset", "(F)J", "material_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SwipeableKt$PreUpPostDownNestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ SwipeableState<T> $this_PreUpPostDownNestedScrollConnection;

    SwipeableKt$PreUpPostDownNestedScrollConnection$1(SwipeableState<T> swipeableState) {
        this.$this_PreUpPostDownNestedScrollConnection = swipeableState;
    }

    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo656onPreScrollOzD1aCk(long available, int source) {
        float delta = toFloat(available);
        if (delta < 0.0f && NestedScrollSource.m3258equalsimpl0(source, NestedScrollSource.INSTANCE.m3263getDragWNlRxjI())) {
            return toOffset(this.$this_PreUpPostDownNestedScrollConnection.performDrag(delta));
        }
        return Offset.INSTANCE.m1776getZeroF1C5BW0();
    }

    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo655onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (NestedScrollSource.m3258equalsimpl0(source, NestedScrollSource.INSTANCE.m3263getDragWNlRxjI())) {
            return toOffset(this.$this_PreUpPostDownNestedScrollConnection.performDrag(toFloat(available)));
        }
        return Offset.INSTANCE.m1776getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo821onPreFlingQWom1Mo(long available, Continuation<? super Velocity> continuation) {
        SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1 swipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1;
        SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1 swipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$12;
        if (continuation instanceof SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1) {
            swipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1 = (SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1) continuation;
            if ((swipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                swipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1.label -= Integer.MIN_VALUE;
                swipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$12 = swipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1;
                Object $result = swipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (swipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        float toFling = toFloat(OffsetKt.Offset(Velocity.m4607getXimpl(available), Velocity.m4608getYimpl(available)));
                        if (toFling < 0.0f && this.$this_PreUpPostDownNestedScrollConnection.getOffset().getValue().floatValue() > this.$this_PreUpPostDownNestedScrollConnection.getMinBound()) {
                            SwipeableState<T> swipeableState = this.$this_PreUpPostDownNestedScrollConnection;
                            swipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$12.J$0 = available;
                            swipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$12.label = 1;
                            if (swipeableState.performFling(toFling, swipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            available = Velocity.INSTANCE.m4618getZero9UxMQ8M();
                            break;
                        }
                        break;
                    case 1:
                        available = swipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$12.J$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Velocity.m4598boximpl(available);
            }
        }
        swipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1 = new SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1(this, continuation);
        swipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$12 = swipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1;
        Object $result2 = swipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (swipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$12.label) {
        }
        return Velocity.m4598boximpl(available);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo654onPostFlingRZ2iAVY(long j, long available, Continuation<? super Velocity> continuation) {
        SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1 swipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1;
        if (continuation instanceof SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1) {
            swipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1 = (SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1) continuation;
            if ((swipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                swipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1.label -= Integer.MIN_VALUE;
                Object $result = swipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (swipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        SwipeableState<T> swipeableState = this.$this_PreUpPostDownNestedScrollConnection;
                        float f = toFloat(OffsetKt.Offset(Velocity.m4607getXimpl(available), Velocity.m4608getYimpl(available)));
                        swipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1.J$0 = available;
                        swipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1.label = 1;
                        if (swipeableState.performFling(f, swipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        available = swipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1.J$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Velocity.m4598boximpl(available);
            }
        }
        swipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1 = new SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1(this, continuation);
        Object $result2 = swipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (swipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1.label) {
        }
        return Velocity.m4598boximpl(available);
    }

    private final long toOffset(float $this$toOffset) {
        return OffsetKt.Offset(0.0f, $this$toOffset);
    }

    private final float toFloat(long $this$toFloat) {
        return Offset.m1761getYimpl($this$toFloat);
    }
}
