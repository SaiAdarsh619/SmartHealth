package androidx.compose.foundation.gestures;

import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: TapGestureDetector.kt */
@Metadata(m286d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0011\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0010J\u0011\u0010\u0015\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0016\u001a\u00020\u0017*\u00020\u0018H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0016\u001a\u00020\u0017*\u00020\u001bH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u0018*\u00020\u001bH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\u001e\u001a\u00020\u0018*\u00020\u0005H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001d\u0010\u001e\u001a\u00020\u0018*\u00020\u0017H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010#J\u001a\u0010$\u001a\u00020%*\u00020&H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001a\u0010)\u001a\u00020\u0005*\u00020\u0018H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010\"J\u001a\u0010)\u001a\u00020\u0005*\u00020\u001bH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010 J\r\u0010,\u001a\u00020-*\u00020.H\u0097\u0001J\u001a\u0010/\u001a\u00020&*\u00020%H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010(J\u001a\u00101\u001a\u00020\u001b*\u00020\u0018H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103J\u001d\u00101\u001a\u00020\u001b*\u00020\u0005H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00103J\u001d\u00101\u001a\u00020\u001b*\u00020\u0017H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105R\u0014\u0010\u0003\u001a\u00020\u00058\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, m287d2 = {"Landroidx/compose/foundation/gestures/PressGestureScopeImpl;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "density", "(Landroidx/compose/ui/unit/Density;)V", "", "getDensity", "()F", "fontScale", "getFontScale", "isCanceled", "", "isReleased", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "release", "reset", "tryAwaitRelease", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class PressGestureScopeImpl implements PressGestureScope, Density {
    private final /* synthetic */ Density $$delegate_0;
    private boolean isCanceled;
    private boolean isReleased;
    private final Mutex mutex;

    @Override // androidx.compose.p000ui.unit.Density
    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.p000ui.unit.Density
    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
    public int mo641roundToPxR2X_6o(long j) {
        return this.$$delegate_0.mo641roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: roundToPx-0680j_4, reason: not valid java name */
    public int mo642roundToPx0680j_4(float f) {
        return this.$$delegate_0.mo642roundToPx0680j_4(f);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toDp-GaN1DYA, reason: not valid java name */
    public float mo643toDpGaN1DYA(long j) {
        return this.$$delegate_0.mo643toDpGaN1DYA(j);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public float mo644toDpu2uoSUM(float f) {
        return this.$$delegate_0.mo644toDpu2uoSUM(f);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public float mo645toDpu2uoSUM(int i) {
        return this.$$delegate_0.mo645toDpu2uoSUM(i);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public long mo646toDpSizekrfVVM(long j) {
        return this.$$delegate_0.mo646toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toPx--R2X_6o, reason: not valid java name */
    public float mo647toPxR2X_6o(long j) {
        return this.$$delegate_0.mo647toPxR2X_6o(j);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toPx-0680j_4, reason: not valid java name */
    public float mo648toPx0680j_4(float f) {
        return this.$$delegate_0.mo648toPx0680j_4(f);
    }

    @Override // androidx.compose.p000ui.unit.Density
    public Rect toRect(DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.$$delegate_0.toRect(dpRect);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public long mo649toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.mo649toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toSp-0xMU5do, reason: not valid java name */
    public long mo650toSp0xMU5do(float f) {
        return this.$$delegate_0.mo650toSp0xMU5do(f);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public long mo651toSpkPz2Gy4(float f) {
        return this.$$delegate_0.mo651toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public long mo652toSpkPz2Gy4(int i) {
        return this.$$delegate_0.mo652toSpkPz2Gy4(i);
    }

    public PressGestureScopeImpl(Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        this.$$delegate_0 = density;
        this.mutex = MutexKt.Mutex(false);
    }

    public final void cancel() {
        this.isCanceled = true;
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
    }

    public final void release() {
        this.isReleased = true;
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
    }

    public final void reset() {
        Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null);
        this.isReleased = false;
        this.isCanceled = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.foundation.gestures.PressGestureScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object awaitRelease(Continuation<? super Unit> continuation) {
        PressGestureScopeImpl$awaitRelease$1 pressGestureScopeImpl$awaitRelease$1;
        PressGestureScopeImpl$awaitRelease$1 pressGestureScopeImpl$awaitRelease$12;
        Object tryAwaitRelease;
        if (continuation instanceof PressGestureScopeImpl$awaitRelease$1) {
            pressGestureScopeImpl$awaitRelease$1 = (PressGestureScopeImpl$awaitRelease$1) continuation;
            if ((pressGestureScopeImpl$awaitRelease$1.label & Integer.MIN_VALUE) != 0) {
                pressGestureScopeImpl$awaitRelease$1.label -= Integer.MIN_VALUE;
                pressGestureScopeImpl$awaitRelease$12 = pressGestureScopeImpl$awaitRelease$1;
                Object $result = pressGestureScopeImpl$awaitRelease$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (pressGestureScopeImpl$awaitRelease$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        pressGestureScopeImpl$awaitRelease$12.label = 1;
                        tryAwaitRelease = tryAwaitRelease(pressGestureScopeImpl$awaitRelease$12);
                        if (tryAwaitRelease == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        tryAwaitRelease = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((Boolean) tryAwaitRelease).booleanValue()) {
                    throw new GestureCancellationException("The press gesture was canceled.");
                }
                return Unit.INSTANCE;
            }
        }
        pressGestureScopeImpl$awaitRelease$1 = new PressGestureScopeImpl$awaitRelease$1(this, continuation);
        pressGestureScopeImpl$awaitRelease$12 = pressGestureScopeImpl$awaitRelease$1;
        Object $result2 = pressGestureScopeImpl$awaitRelease$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (pressGestureScopeImpl$awaitRelease$12.label) {
        }
        if (((Boolean) tryAwaitRelease).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.foundation.gestures.PressGestureScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object tryAwaitRelease(Continuation<? super Boolean> continuation) {
        PressGestureScopeImpl$tryAwaitRelease$1 pressGestureScopeImpl$tryAwaitRelease$1;
        PressGestureScopeImpl$tryAwaitRelease$1 pressGestureScopeImpl$tryAwaitRelease$12;
        PressGestureScopeImpl pressGestureScopeImpl;
        PressGestureScopeImpl pressGestureScopeImpl2;
        if (continuation instanceof PressGestureScopeImpl$tryAwaitRelease$1) {
            pressGestureScopeImpl$tryAwaitRelease$1 = (PressGestureScopeImpl$tryAwaitRelease$1) continuation;
            if ((pressGestureScopeImpl$tryAwaitRelease$1.label & Integer.MIN_VALUE) != 0) {
                pressGestureScopeImpl$tryAwaitRelease$1.label -= Integer.MIN_VALUE;
                pressGestureScopeImpl$tryAwaitRelease$12 = pressGestureScopeImpl$tryAwaitRelease$1;
                Object $result = pressGestureScopeImpl$tryAwaitRelease$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (pressGestureScopeImpl$tryAwaitRelease$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        pressGestureScopeImpl = this;
                        if (!pressGestureScopeImpl.isReleased && !pressGestureScopeImpl.isCanceled) {
                            Mutex mutex = pressGestureScopeImpl.mutex;
                            pressGestureScopeImpl$tryAwaitRelease$12.L$0 = pressGestureScopeImpl;
                            pressGestureScopeImpl$tryAwaitRelease$12.label = 1;
                            if (Mutex.DefaultImpls.lock$default(mutex, null, pressGestureScopeImpl$tryAwaitRelease$12, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            pressGestureScopeImpl2 = pressGestureScopeImpl;
                            pressGestureScopeImpl = pressGestureScopeImpl2;
                        }
                        return Boxing.boxBoolean(pressGestureScopeImpl.isReleased);
                    case 1:
                        pressGestureScopeImpl2 = (PressGestureScopeImpl) pressGestureScopeImpl$tryAwaitRelease$12.L$0;
                        ResultKt.throwOnFailure($result);
                        pressGestureScopeImpl = pressGestureScopeImpl2;
                        return Boxing.boxBoolean(pressGestureScopeImpl.isReleased);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        pressGestureScopeImpl$tryAwaitRelease$1 = new PressGestureScopeImpl$tryAwaitRelease$1(this, continuation);
        pressGestureScopeImpl$tryAwaitRelease$12 = pressGestureScopeImpl$tryAwaitRelease$1;
        Object $result2 = pressGestureScopeImpl$tryAwaitRelease$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (pressGestureScopeImpl$tryAwaitRelease$12.label) {
        }
    }
}
