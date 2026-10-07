package androidx.compose.p000ui.input.nestedscroll;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: NestedScrollModifier.kt */
@Metadata(m286d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J!\u0010#\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b$\u0010%J#\u0010&\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006)"}, m287d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "", "()V", "calculateNestedScrollScope", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "getCalculateNestedScrollScope$ui_release", "()Lkotlin/jvm/functions/Function0;", "setCalculateNestedScrollScope$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "coroutineScope", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "originNestedScrollScope", "getOriginNestedScrollScope$ui_release", "setOriginNestedScrollScope$ui_release", "(Lkotlinx/coroutines/CoroutineScope;)V", "parent", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getParent$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setParent$ui_release", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "dispatchPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "dispatchPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchPostScroll-DzOQY0M", "(JJI)J", "dispatchPreFling", "dispatchPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPreScroll", "dispatchPreScroll-OzD1aCk", "(JI)J", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class NestedScrollDispatcher {
    public static final int $stable = 8;
    private Function0<? extends CoroutineScope> calculateNestedScrollScope = new Function0<CoroutineScope>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$calculateNestedScrollScope$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final CoroutineScope invoke() {
            return NestedScrollDispatcher.this.getOriginNestedScrollScope();
        }
    };
    private CoroutineScope originNestedScrollScope;
    private NestedScrollConnection parent;

    public final Function0<CoroutineScope> getCalculateNestedScrollScope$ui_release() {
        return this.calculateNestedScrollScope;
    }

    public final void setCalculateNestedScrollScope$ui_release(Function0<? extends CoroutineScope> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.calculateNestedScrollScope = function0;
    }

    /* renamed from: getOriginNestedScrollScope$ui_release, reason: from getter */
    public final CoroutineScope getOriginNestedScrollScope() {
        return this.originNestedScrollScope;
    }

    public final void setOriginNestedScrollScope$ui_release(CoroutineScope coroutineScope) {
        this.originNestedScrollScope = coroutineScope;
    }

    public final CoroutineScope getCoroutineScope() {
        CoroutineScope invoke = this.calculateNestedScrollScope.invoke();
        if (invoke == null) {
            throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        }
        return invoke;
    }

    /* renamed from: getParent$ui_release, reason: from getter */
    public final NestedScrollConnection getParent() {
        return this.parent;
    }

    public final void setParent$ui_release(NestedScrollConnection nestedScrollConnection) {
        this.parent = nestedScrollConnection;
    }

    /* renamed from: dispatchPreScroll-OzD1aCk, reason: not valid java name */
    public final long m3254dispatchPreScrollOzD1aCk(long available, int source) {
        NestedScrollConnection nestedScrollConnection = this.parent;
        return nestedScrollConnection != null ? nestedScrollConnection.mo656onPreScrollOzD1aCk(available, source) : Offset.INSTANCE.m1776getZeroF1C5BW0();
    }

    /* renamed from: dispatchPostScroll-DzOQY0M, reason: not valid java name */
    public final long m3252dispatchPostScrollDzOQY0M(long consumed, long available, int source) {
        NestedScrollConnection nestedScrollConnection = this.parent;
        return nestedScrollConnection != null ? nestedScrollConnection.mo655onPostScrollDzOQY0M(consumed, available, source) : Offset.INSTANCE.m1776getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: dispatchPreFling-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3253dispatchPreFlingQWom1Mo(long available, Continuation<? super Velocity> continuation) {
        NestedScrollDispatcher$dispatchPreFling$1 nestedScrollDispatcher$dispatchPreFling$1;
        NestedScrollDispatcher$dispatchPreFling$1 nestedScrollDispatcher$dispatchPreFling$12;
        long m4618getZero9UxMQ8M;
        Object mo821onPreFlingQWom1Mo;
        if (continuation instanceof NestedScrollDispatcher$dispatchPreFling$1) {
            nestedScrollDispatcher$dispatchPreFling$1 = (NestedScrollDispatcher$dispatchPreFling$1) continuation;
            if ((nestedScrollDispatcher$dispatchPreFling$1.label & Integer.MIN_VALUE) != 0) {
                nestedScrollDispatcher$dispatchPreFling$1.label -= Integer.MIN_VALUE;
                nestedScrollDispatcher$dispatchPreFling$12 = nestedScrollDispatcher$dispatchPreFling$1;
                Object $result = nestedScrollDispatcher$dispatchPreFling$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (nestedScrollDispatcher$dispatchPreFling$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        NestedScrollConnection nestedScrollConnection = this.parent;
                        if (nestedScrollConnection == null) {
                            m4618getZero9UxMQ8M = Velocity.INSTANCE.m4618getZero9UxMQ8M();
                            return Velocity.m4598boximpl(m4618getZero9UxMQ8M);
                        }
                        nestedScrollDispatcher$dispatchPreFling$12.label = 1;
                        mo821onPreFlingQWom1Mo = nestedScrollConnection.mo821onPreFlingQWom1Mo(available, nestedScrollDispatcher$dispatchPreFling$12);
                        if (mo821onPreFlingQWom1Mo == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        m4618getZero9UxMQ8M = ((Velocity) mo821onPreFlingQWom1Mo).getPackedValue();
                        return Velocity.m4598boximpl(m4618getZero9UxMQ8M);
                    case 1:
                        ResultKt.throwOnFailure($result);
                        mo821onPreFlingQWom1Mo = $result;
                        m4618getZero9UxMQ8M = ((Velocity) mo821onPreFlingQWom1Mo).getPackedValue();
                        return Velocity.m4598boximpl(m4618getZero9UxMQ8M);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        nestedScrollDispatcher$dispatchPreFling$1 = new NestedScrollDispatcher$dispatchPreFling$1(this, continuation);
        nestedScrollDispatcher$dispatchPreFling$12 = nestedScrollDispatcher$dispatchPreFling$1;
        Object $result2 = nestedScrollDispatcher$dispatchPreFling$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (nestedScrollDispatcher$dispatchPreFling$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: dispatchPostFling-RZ2iAVY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3251dispatchPostFlingRZ2iAVY(long consumed, long available, Continuation<? super Velocity> continuation) {
        NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$1;
        NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$12;
        long m4618getZero9UxMQ8M;
        Object mo654onPostFlingRZ2iAVY;
        if (continuation instanceof NestedScrollDispatcher$dispatchPostFling$1) {
            nestedScrollDispatcher$dispatchPostFling$1 = (NestedScrollDispatcher$dispatchPostFling$1) continuation;
            if ((nestedScrollDispatcher$dispatchPostFling$1.label & Integer.MIN_VALUE) != 0) {
                nestedScrollDispatcher$dispatchPostFling$1.label -= Integer.MIN_VALUE;
                nestedScrollDispatcher$dispatchPostFling$12 = nestedScrollDispatcher$dispatchPostFling$1;
                Object $result = nestedScrollDispatcher$dispatchPostFling$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (nestedScrollDispatcher$dispatchPostFling$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        NestedScrollConnection nestedScrollConnection = this.parent;
                        if (nestedScrollConnection == null) {
                            m4618getZero9UxMQ8M = Velocity.INSTANCE.m4618getZero9UxMQ8M();
                            return Velocity.m4598boximpl(m4618getZero9UxMQ8M);
                        }
                        nestedScrollDispatcher$dispatchPostFling$12.label = 1;
                        mo654onPostFlingRZ2iAVY = nestedScrollConnection.mo654onPostFlingRZ2iAVY(consumed, available, nestedScrollDispatcher$dispatchPostFling$12);
                        if (mo654onPostFlingRZ2iAVY == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        m4618getZero9UxMQ8M = ((Velocity) mo654onPostFlingRZ2iAVY).getPackedValue();
                        return Velocity.m4598boximpl(m4618getZero9UxMQ8M);
                    case 1:
                        ResultKt.throwOnFailure($result);
                        mo654onPostFlingRZ2iAVY = $result;
                        m4618getZero9UxMQ8M = ((Velocity) mo654onPostFlingRZ2iAVY).getPackedValue();
                        return Velocity.m4598boximpl(m4618getZero9UxMQ8M);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        nestedScrollDispatcher$dispatchPostFling$1 = new NestedScrollDispatcher$dispatchPostFling$1(this, continuation);
        nestedScrollDispatcher$dispatchPostFling$12 = nestedScrollDispatcher$dispatchPostFling$1;
        Object $result2 = nestedScrollDispatcher$dispatchPostFling$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (nestedScrollDispatcher$dispatchPostFling$12.label) {
        }
    }
}
