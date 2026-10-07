package androidx.compose.p000ui.platform;

import android.view.View;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p000ui.unit.Velocity;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NestedScrollInteropConnection.kt */
@Metadata(m286d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J)\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001d"}, m287d2 = {"Landroidx/compose/ui/platform/NestedScrollInteropConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "consumedScrollCache", "", "nestedScrollChildHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "interruptOngoingScrolls", "", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class NestedScrollInteropConnection implements NestedScrollConnection {
    private final int[] consumedScrollCache;
    private final NestedScrollingChildHelper nestedScrollChildHelper;
    private final View view;

    public NestedScrollInteropConnection(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        NestedScrollingChildHelper $this$nestedScrollChildHelper_u24lambda_u2d0 = new NestedScrollingChildHelper(this.view);
        $this$nestedScrollChildHelper_u24lambda_u2d0.setNestedScrollingEnabled(true);
        this.nestedScrollChildHelper = $this$nestedScrollChildHelper_u24lambda_u2d0;
        this.consumedScrollCache = new int[2];
        ViewCompat.setNestedScrollingEnabled(this.view, true);
    }

    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo656onPreScrollOzD1aCk(long available, int source) {
        int m3801getScrollAxesk4lQ0M;
        int m3803toViewTypeGyEprt8;
        int m3803toViewTypeGyEprt82;
        long m3802toOffsetUv8p0NA;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.nestedScrollChildHelper;
        m3801getScrollAxesk4lQ0M = NestedScrollInteropConnectionKt.m3801getScrollAxesk4lQ0M(available);
        m3803toViewTypeGyEprt8 = NestedScrollInteropConnectionKt.m3803toViewTypeGyEprt8(source);
        if (!nestedScrollingChildHelper.startNestedScroll(m3801getScrollAxesk4lQ0M, m3803toViewTypeGyEprt8)) {
            return Offset.INSTANCE.m1776getZeroF1C5BW0();
        }
        ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
        NestedScrollingChildHelper nestedScrollingChildHelper2 = this.nestedScrollChildHelper;
        int composeToViewOffset = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1760getXimpl(available));
        int composeToViewOffset2 = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1761getYimpl(available));
        int[] iArr = this.consumedScrollCache;
        m3803toViewTypeGyEprt82 = NestedScrollInteropConnectionKt.m3803toViewTypeGyEprt8(source);
        nestedScrollingChildHelper2.dispatchNestedPreScroll(composeToViewOffset, composeToViewOffset2, iArr, null, m3803toViewTypeGyEprt82);
        m3802toOffsetUv8p0NA = NestedScrollInteropConnectionKt.m3802toOffsetUv8p0NA(this.consumedScrollCache, available);
        return m3802toOffsetUv8p0NA;
    }

    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo655onPostScrollDzOQY0M(long consumed, long available, int source) {
        int m3801getScrollAxesk4lQ0M;
        int m3803toViewTypeGyEprt8;
        int m3803toViewTypeGyEprt82;
        long m3802toOffsetUv8p0NA;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.nestedScrollChildHelper;
        m3801getScrollAxesk4lQ0M = NestedScrollInteropConnectionKt.m3801getScrollAxesk4lQ0M(available);
        m3803toViewTypeGyEprt8 = NestedScrollInteropConnectionKt.m3803toViewTypeGyEprt8(source);
        if (!nestedScrollingChildHelper.startNestedScroll(m3801getScrollAxesk4lQ0M, m3803toViewTypeGyEprt8)) {
            return Offset.INSTANCE.m1776getZeroF1C5BW0();
        }
        ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
        NestedScrollingChildHelper nestedScrollingChildHelper2 = this.nestedScrollChildHelper;
        int composeToViewOffset = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1760getXimpl(consumed));
        int composeToViewOffset2 = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1761getYimpl(consumed));
        int composeToViewOffset3 = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1760getXimpl(available));
        int composeToViewOffset4 = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1761getYimpl(available));
        m3803toViewTypeGyEprt82 = NestedScrollInteropConnectionKt.m3803toViewTypeGyEprt8(source);
        nestedScrollingChildHelper2.dispatchNestedScroll(composeToViewOffset, composeToViewOffset2, composeToViewOffset3, composeToViewOffset4, null, m3803toViewTypeGyEprt82, this.consumedScrollCache);
        m3802toOffsetUv8p0NA = NestedScrollInteropConnectionKt.m3802toOffsetUv8p0NA(this.consumedScrollCache, available);
        return m3802toOffsetUv8p0NA;
    }

    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo */
    public Object mo821onPreFlingQWom1Mo(long available, Continuation<? super Velocity> continuation) {
        float viewVelocity;
        float viewVelocity2;
        long result;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.nestedScrollChildHelper;
        viewVelocity = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m4607getXimpl(available));
        viewVelocity2 = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m4608getYimpl(available));
        if (nestedScrollingChildHelper.dispatchNestedPreFling(viewVelocity, viewVelocity2)) {
            result = available;
        } else {
            result = Velocity.INSTANCE.m4618getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m4598boximpl(result);
    }

    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    public Object mo654onPostFlingRZ2iAVY(long consumed, long available, Continuation<? super Velocity> continuation) {
        float viewVelocity;
        float viewVelocity2;
        long result;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.nestedScrollChildHelper;
        viewVelocity = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m4607getXimpl(available));
        viewVelocity2 = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m4608getYimpl(available));
        if (nestedScrollingChildHelper.dispatchNestedFling(viewVelocity, viewVelocity2, true)) {
            result = available;
        } else {
            result = Velocity.INSTANCE.m4618getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m4598boximpl(result);
    }

    private final void interruptOngoingScrolls() {
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(0)) {
            this.nestedScrollChildHelper.stopNestedScroll(0);
        }
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(1)) {
            this.nestedScrollChildHelper.stopNestedScroll(1);
        }
    }
}
