package androidx.compose.foundation.gestures;

import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerEventPass;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* compiled from: ForEachGesture.kt */
@Metadata(m286d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u0006H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a>\u0010\b\u001a\u00020\u0004*\u00020\u00062'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n¢\u0006\u0002\b\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, m287d2 = {"allPointersUp", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "awaitAllPointersUp", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forEachGesture", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ForEachGestureKt {
    /* JADX WARN: Can't wrap try/catch for region: R(7:0|1|(2:3|(4:5|6|7|8))|44|6|7|8) */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0065, code lost:
    
        r3 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.ui.input.pointer.PointerInputScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.ui.input.pointer.PointerInputScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.compose.ui.input.pointer.PointerInputScope] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x009a -> B:13:0x0070). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00b8 -> B:13:0x0070). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object forEachGesture(PointerInputScope pointerInputScope, Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        ForEachGestureKt$forEachGesture$1 forEachGestureKt$forEachGesture$1;
        ?? r2;
        CoroutineContext coroutineContext;
        PointerInputScope pointerInputScope2;
        if (continuation instanceof ForEachGestureKt$forEachGesture$1) {
            forEachGestureKt$forEachGesture$1 = (ForEachGestureKt$forEachGesture$1) continuation;
            if ((forEachGestureKt$forEachGesture$1.label & Integer.MIN_VALUE) != 0) {
                forEachGestureKt$forEachGesture$1.label -= Integer.MIN_VALUE;
                ForEachGestureKt$forEachGesture$1 forEachGestureKt$forEachGesture$12 = forEachGestureKt$forEachGesture$1;
                Object obj = forEachGestureKt$forEachGesture$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                r2 = forEachGestureKt$forEachGesture$12.label;
                switch (r2) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        coroutineContext = forEachGestureKt$forEachGesture$12.get$context();
                        pointerInputScope2 = pointerInputScope;
                        if (JobKt.isActive(coroutineContext)) {
                            try {
                            } catch (CancellationException e) {
                                e = e;
                                CoroutineContext coroutineContext2 = coroutineContext;
                                r2 = pointerInputScope2;
                                pointerInputScope = coroutineContext2;
                                if (JobKt.isActive(pointerInputScope)) {
                                    throw e;
                                }
                                forEachGestureKt$forEachGesture$12.L$0 = r2;
                                forEachGestureKt$forEachGesture$12.L$1 = function2;
                                forEachGestureKt$forEachGesture$12.L$2 = pointerInputScope;
                                forEachGestureKt$forEachGesture$12.label = 3;
                                if (awaitAllPointersUp((PointerInputScope) r2, forEachGestureKt$forEachGesture$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                PointerInputScope pointerInputScope3 = r2;
                                coroutineContext = pointerInputScope;
                                pointerInputScope2 = pointerInputScope3;
                                if (JobKt.isActive(coroutineContext)) {
                                }
                            }
                            forEachGestureKt$forEachGesture$12.L$0 = pointerInputScope2;
                            forEachGestureKt$forEachGesture$12.L$1 = function2;
                            forEachGestureKt$forEachGesture$12.L$2 = coroutineContext;
                            forEachGestureKt$forEachGesture$12.label = 1;
                            if (function2.invoke(pointerInputScope2, forEachGestureKt$forEachGesture$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            CoroutineContext coroutineContext3 = coroutineContext;
                            r2 = pointerInputScope2;
                            pointerInputScope = coroutineContext3;
                            forEachGestureKt$forEachGesture$12.L$0 = r2;
                            forEachGestureKt$forEachGesture$12.L$1 = function2;
                            forEachGestureKt$forEachGesture$12.L$2 = pointerInputScope;
                            forEachGestureKt$forEachGesture$12.label = 2;
                            if (awaitAllPointersUp((PointerInputScope) r2, forEachGestureKt$forEachGesture$12) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            PointerInputScope pointerInputScope4 = r2;
                            coroutineContext = pointerInputScope;
                            pointerInputScope2 = pointerInputScope4;
                            if (JobKt.isActive(coroutineContext)) {
                                return Unit.INSTANCE;
                            }
                        }
                    case 1:
                        CoroutineContext coroutineContext4 = (CoroutineContext) forEachGestureKt$forEachGesture$12.L$2;
                        function2 = (Function2) forEachGestureKt$forEachGesture$12.L$1;
                        PointerInputScope pointerInputScope5 = (PointerInputScope) forEachGestureKt$forEachGesture$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        r2 = pointerInputScope5;
                        pointerInputScope = coroutineContext4;
                        forEachGestureKt$forEachGesture$12.L$0 = r2;
                        forEachGestureKt$forEachGesture$12.L$1 = function2;
                        forEachGestureKt$forEachGesture$12.L$2 = pointerInputScope;
                        forEachGestureKt$forEachGesture$12.label = 2;
                        if (awaitAllPointersUp((PointerInputScope) r2, forEachGestureKt$forEachGesture$12) != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        CoroutineContext coroutineContext5 = (CoroutineContext) forEachGestureKt$forEachGesture$12.L$2;
                        function2 = (Function2) forEachGestureKt$forEachGesture$12.L$1;
                        PointerInputScope pointerInputScope6 = (PointerInputScope) forEachGestureKt$forEachGesture$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        coroutineContext = coroutineContext5;
                        pointerInputScope2 = pointerInputScope6;
                        if (JobKt.isActive(coroutineContext)) {
                        }
                        break;
                    case 3:
                        CoroutineContext coroutineContext6 = (CoroutineContext) forEachGestureKt$forEachGesture$12.L$2;
                        function2 = (Function2) forEachGestureKt$forEachGesture$12.L$1;
                        PointerInputScope pointerInputScope7 = (PointerInputScope) forEachGestureKt$forEachGesture$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        coroutineContext = coroutineContext6;
                        pointerInputScope2 = pointerInputScope7;
                        if (JobKt.isActive(coroutineContext)) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        forEachGestureKt$forEachGesture$1 = new ForEachGestureKt$forEachGesture$1(continuation);
        ForEachGestureKt$forEachGesture$1 forEachGestureKt$forEachGesture$122 = forEachGestureKt$forEachGesture$1;
        Object obj2 = forEachGestureKt$forEachGesture$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r2 = forEachGestureKt$forEachGesture$122.label;
        switch (r2) {
        }
    }

    public static final boolean allPointersUp(AwaitPointerEventScope $this$allPointersUp) {
        boolean z;
        Intrinsics.checkNotNullParameter($this$allPointersUp, "<this>");
        List $this$fastAny$iv = $this$allPointersUp.getCurrentEvent().getChanges();
        int index$iv$iv = 0;
        int size = $this$fastAny$iv.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = $this$fastAny$iv.get(index$iv$iv);
                PointerInputChange it = (PointerInputChange) item$iv$iv;
                if (it.getPressed()) {
                    z = true;
                    break;
                }
                index$iv$iv++;
            } else {
                z = false;
                break;
            }
        }
        return !z;
    }

    public static final Object awaitAllPointersUp(PointerInputScope $this$awaitAllPointersUp, Continuation<? super Unit> continuation) {
        Object awaitPointerEventScope = $this$awaitAllPointersUp.awaitPointerEventScope(new ForEachGestureKt$awaitAllPointersUp$2(null), continuation);
        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0040, code lost:
    
        if (allPointersUp(r14) == false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x004f -> B:12:0x0053). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitAllPointersUp(AwaitPointerEventScope $this$awaitAllPointersUp, Continuation<? super Unit> continuation) {
        ForEachGestureKt$awaitAllPointersUp$3 forEachGestureKt$awaitAllPointersUp$3;
        ForEachGestureKt$awaitAllPointersUp$3 forEachGestureKt$awaitAllPointersUp$32;
        List $this$fastForEach$iv$iv;
        if (continuation instanceof ForEachGestureKt$awaitAllPointersUp$3) {
            forEachGestureKt$awaitAllPointersUp$3 = (ForEachGestureKt$awaitAllPointersUp$3) continuation;
            if ((forEachGestureKt$awaitAllPointersUp$3.label & Integer.MIN_VALUE) != 0) {
                forEachGestureKt$awaitAllPointersUp$3.label -= Integer.MIN_VALUE;
                forEachGestureKt$awaitAllPointersUp$32 = forEachGestureKt$awaitAllPointersUp$3;
                Object $result = forEachGestureKt$awaitAllPointersUp$32.result;
                Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (forEachGestureKt$awaitAllPointersUp$32.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        break;
                    case 1:
                        $this$awaitAllPointersUp = (AwaitPointerEventScope) forEachGestureKt$awaitAllPointersUp$32.L$0;
                        ResultKt.throwOnFailure($result);
                        Object obj = $result2;
                        Object $result3 = $result;
                        PointerEvent events = (PointerEvent) $result;
                        List $this$fastForEach$iv$iv2 = events.getChanges();
                        int index$iv$iv = 0;
                        int size = $this$fastForEach$iv$iv2.size();
                        while (true) {
                            if (index$iv$iv >= size) {
                                Object item$iv$iv = $this$fastForEach$iv$iv2.get(index$iv$iv);
                                PointerInputChange it = (PointerInputChange) item$iv$iv;
                                if (it.getPressed()) {
                                    $this$fastForEach$iv$iv = 1;
                                } else {
                                    index$iv$iv++;
                                }
                            } else {
                                $this$fastForEach$iv$iv = null;
                            }
                        }
                        if ($this$fastForEach$iv$iv != null) {
                            return Unit.INSTANCE;
                        }
                        $result = $result3;
                        $result2 = obj;
                        PointerEventPass pointerEventPass = PointerEventPass.Final;
                        forEachGestureKt$awaitAllPointersUp$32.L$0 = $this$awaitAllPointersUp;
                        forEachGestureKt$awaitAllPointersUp$32.label = 1;
                        Object awaitPointerEvent = $this$awaitAllPointersUp.awaitPointerEvent(pointerEventPass, forEachGestureKt$awaitAllPointersUp$32);
                        if (awaitPointerEvent == $result2) {
                            return $result2;
                        }
                        Object obj2 = $result2;
                        $result3 = $result;
                        $result = awaitPointerEvent;
                        obj = obj2;
                        PointerEvent events2 = (PointerEvent) $result;
                        List $this$fastForEach$iv$iv22 = events2.getChanges();
                        int index$iv$iv2 = 0;
                        int size2 = $this$fastForEach$iv$iv22.size();
                        while (true) {
                            if (index$iv$iv2 >= size2) {
                            }
                            index$iv$iv2++;
                        }
                        if ($this$fastForEach$iv$iv != null) {
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        forEachGestureKt$awaitAllPointersUp$3 = new ForEachGestureKt$awaitAllPointersUp$3(continuation);
        forEachGestureKt$awaitAllPointersUp$32 = forEachGestureKt$awaitAllPointersUp$3;
        Object $result4 = forEachGestureKt$awaitAllPointersUp$32.result;
        Object $result22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (forEachGestureKt$awaitAllPointersUp$32.label) {
        }
    }
}
