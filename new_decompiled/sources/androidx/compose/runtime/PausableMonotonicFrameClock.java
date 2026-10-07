package androidx.compose.runtime;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.MonotonicFrameClock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PausableMonotonicFrameClock.kt */
@Metadata(m286d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ:\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H\r0\u000fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, m287d2 = {"Landroidx/compose/runtime/PausableMonotonicFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "frameClock", "(Landroidx/compose/runtime/MonotonicFrameClock;)V", "isPaused", "", "()Z", "latch", "Landroidx/compose/runtime/Latch;", "pause", "", "resume", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runtime_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class PausableMonotonicFrameClock implements MonotonicFrameClock {
    public static final int $stable = 8;
    private final MonotonicFrameClock frameClock;
    private final Latch latch;

    public PausableMonotonicFrameClock(MonotonicFrameClock frameClock) {
        Intrinsics.checkNotNullParameter(frameClock, "frameClock");
        this.frameClock = frameClock;
        this.latch = new Latch();
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) MonotonicFrameClock.DefaultImpls.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) MonotonicFrameClock.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext context) {
        return MonotonicFrameClock.DefaultImpls.plus(this, context);
    }

    public final boolean isPaused() {
        return !this.latch.isOpen();
    }

    public final void pause() {
        this.latch.closeLatch();
    }

    public final void resume() {
        this.latch.openLatch();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.runtime.MonotonicFrameClock
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object withFrameNanos(Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        PausableMonotonicFrameClock$withFrameNanos$1 pausableMonotonicFrameClock$withFrameNanos$1;
        PausableMonotonicFrameClock$withFrameNanos$1 pausableMonotonicFrameClock$withFrameNanos$12;
        PausableMonotonicFrameClock pausableMonotonicFrameClock;
        if (continuation instanceof PausableMonotonicFrameClock$withFrameNanos$1) {
            pausableMonotonicFrameClock$withFrameNanos$1 = (PausableMonotonicFrameClock$withFrameNanos$1) continuation;
            if ((pausableMonotonicFrameClock$withFrameNanos$1.label & Integer.MIN_VALUE) != 0) {
                pausableMonotonicFrameClock$withFrameNanos$1.label -= Integer.MIN_VALUE;
                pausableMonotonicFrameClock$withFrameNanos$12 = pausableMonotonicFrameClock$withFrameNanos$1;
                Object $result = pausableMonotonicFrameClock$withFrameNanos$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (pausableMonotonicFrameClock$withFrameNanos$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        pausableMonotonicFrameClock = this;
                        Latch latch = pausableMonotonicFrameClock.latch;
                        pausableMonotonicFrameClock$withFrameNanos$12.L$0 = pausableMonotonicFrameClock;
                        pausableMonotonicFrameClock$withFrameNanos$12.L$1 = function1;
                        pausableMonotonicFrameClock$withFrameNanos$12.label = 1;
                        if (latch.await(pausableMonotonicFrameClock$withFrameNanos$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        function1 = (Function1) pausableMonotonicFrameClock$withFrameNanos$12.L$1;
                        pausableMonotonicFrameClock = (PausableMonotonicFrameClock) pausableMonotonicFrameClock$withFrameNanos$12.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                MonotonicFrameClock monotonicFrameClock = pausableMonotonicFrameClock.frameClock;
                pausableMonotonicFrameClock$withFrameNanos$12.L$0 = null;
                pausableMonotonicFrameClock$withFrameNanos$12.L$1 = null;
                pausableMonotonicFrameClock$withFrameNanos$12.label = 2;
                Object withFrameNanos = monotonicFrameClock.withFrameNanos(function1, pausableMonotonicFrameClock$withFrameNanos$12);
                return withFrameNanos != coroutine_suspended ? coroutine_suspended : withFrameNanos;
            }
        }
        pausableMonotonicFrameClock$withFrameNanos$1 = new PausableMonotonicFrameClock$withFrameNanos$1(this, continuation);
        pausableMonotonicFrameClock$withFrameNanos$12 = pausableMonotonicFrameClock$withFrameNanos$1;
        Object $result2 = pausableMonotonicFrameClock$withFrameNanos$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (pausableMonotonicFrameClock$withFrameNanos$12.label) {
        }
        MonotonicFrameClock monotonicFrameClock2 = pausableMonotonicFrameClock.frameClock;
        pausableMonotonicFrameClock$withFrameNanos$12.L$0 = null;
        pausableMonotonicFrameClock$withFrameNanos$12.L$1 = null;
        pausableMonotonicFrameClock$withFrameNanos$12.label = 2;
        Object withFrameNanos2 = monotonicFrameClock2.withFrameNanos(function1, pausableMonotonicFrameClock$withFrameNanos$12);
        if (withFrameNanos2 != coroutine_suspended2) {
        }
    }
}
