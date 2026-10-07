package androidx.compose.foundation.gestures;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerEventKt;
import androidx.compose.p000ui.input.pointer.PointerEventPass;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: TapGestureDetector.kt */
@Metadata(m286d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001f\u0010\t\u001a\u00020\n*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a%\u0010\u000f\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u001f\u0010\u0013\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u0005*\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001aa\u0010\u0018\u001a\u00020\u0005*\u00020\u00192/\b\u0002\u0010\u001a\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001cH\u0080@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a\u0091\u0001\u0010\u001e\u001a\u00020\u0005*\u00020\u00192\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c2\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c2/\b\u0002\u0010\u001a\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001cH\u0086@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010!\u001a\u0017\u0010\"\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\"=\u0010\u0000\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, m287d2 = {"NoPressGesture", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "awaitFirstDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "requireUnconsumed", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstDownOnPass", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEventPass;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSecondDown", "firstUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeUntilUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapAndPress", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onPress", "onTap", "Lkotlin/Function1;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapGestures", "onDoubleTap", "onLongPress", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForUpOrCancellation", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TapGestureDetectorKt {
    private static final Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> NoPressGesture = new TapGestureDetectorKt$NoPressGesture$1(null);

    public static final Object detectTapGestures(PointerInputScope $this$detectTapGestures, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function13, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TapGestureDetectorKt$detectTapGestures$2($this$detectTapGestures, function3, function12, function1, function13, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b A[LOOP:0: B:13:0x0059->B:14:0x005b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0047 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0048 -> B:12:0x004c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object consumeUntilUp(AwaitPointerEventScope $this$consumeUntilUp, Continuation<? super Unit> continuation) {
        TapGestureDetectorKt$consumeUntilUp$1 tapGestureDetectorKt$consumeUntilUp$1;
        TapGestureDetectorKt$consumeUntilUp$1 tapGestureDetectorKt$consumeUntilUp$12;
        Object $result;
        Object obj;
        int index$iv;
        int size;
        int index$iv$iv;
        int size2;
        List $this$fastForEach$iv$iv;
        if (continuation instanceof TapGestureDetectorKt$consumeUntilUp$1) {
            tapGestureDetectorKt$consumeUntilUp$1 = (TapGestureDetectorKt$consumeUntilUp$1) continuation;
            if ((tapGestureDetectorKt$consumeUntilUp$1.label & Integer.MIN_VALUE) != 0) {
                tapGestureDetectorKt$consumeUntilUp$1.label -= Integer.MIN_VALUE;
                tapGestureDetectorKt$consumeUntilUp$12 = tapGestureDetectorKt$consumeUntilUp$1;
                Object $result2 = tapGestureDetectorKt$consumeUntilUp$12.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (tapGestureDetectorKt$consumeUntilUp$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        tapGestureDetectorKt$consumeUntilUp$12.L$0 = $this$consumeUntilUp;
                        tapGestureDetectorKt$consumeUntilUp$12.label = 1;
                        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$consumeUntilUp, null, tapGestureDetectorKt$consumeUntilUp$12, 1, null);
                        if (awaitPointerEvent$default != $result3) {
                            return $result3;
                        }
                        Object obj2 = $result3;
                        $result = $result2;
                        $result2 = awaitPointerEvent$default;
                        obj = obj2;
                        PointerEvent event = (PointerEvent) $result2;
                        List $this$fastForEach$iv = event.getChanges();
                        size = $this$fastForEach$iv.size();
                        for (index$iv = 0; index$iv < size; index$iv++) {
                            Object item$iv = $this$fastForEach$iv.get(index$iv);
                            PointerInputChange it = (PointerInputChange) item$iv;
                            it.consume();
                        }
                        List $this$fastForEach$iv$iv2 = event.getChanges();
                        index$iv$iv = 0;
                        size2 = $this$fastForEach$iv$iv2.size();
                        while (true) {
                            if (index$iv$iv >= size2) {
                                Object item$iv$iv = $this$fastForEach$iv$iv2.get(index$iv$iv);
                                PointerInputChange it2 = (PointerInputChange) item$iv$iv;
                                if (it2.getPressed()) {
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
                        $result2 = $result;
                        $result3 = obj;
                        tapGestureDetectorKt$consumeUntilUp$12.L$0 = $this$consumeUntilUp;
                        tapGestureDetectorKt$consumeUntilUp$12.label = 1;
                        Object awaitPointerEvent$default2 = AwaitPointerEventScope.awaitPointerEvent$default($this$consumeUntilUp, null, tapGestureDetectorKt$consumeUntilUp$12, 1, null);
                        if (awaitPointerEvent$default2 != $result3) {
                        }
                    case 1:
                        $this$consumeUntilUp = (AwaitPointerEventScope) tapGestureDetectorKt$consumeUntilUp$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        obj = $result3;
                        $result = $result2;
                        PointerEvent event2 = (PointerEvent) $result2;
                        List $this$fastForEach$iv2 = event2.getChanges();
                        size = $this$fastForEach$iv2.size();
                        while (index$iv < size) {
                        }
                        List $this$fastForEach$iv$iv22 = event2.getChanges();
                        index$iv$iv = 0;
                        size2 = $this$fastForEach$iv$iv22.size();
                        while (true) {
                            if (index$iv$iv >= size2) {
                            }
                            index$iv$iv++;
                        }
                        if ($this$fastForEach$iv$iv != null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        tapGestureDetectorKt$consumeUntilUp$1 = new TapGestureDetectorKt$consumeUntilUp$1(continuation);
        tapGestureDetectorKt$consumeUntilUp$12 = tapGestureDetectorKt$consumeUntilUp$1;
        Object $result22 = tapGestureDetectorKt$consumeUntilUp$12.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tapGestureDetectorKt$consumeUntilUp$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object awaitSecondDown(AwaitPointerEventScope $this$awaitSecondDown, PointerInputChange firstUp, Continuation<? super PointerInputChange> continuation) {
        return $this$awaitSecondDown.withTimeoutOrNull($this$awaitSecondDown.getViewConfiguration().getDoubleTapTimeoutMillis(), new TapGestureDetectorKt$awaitSecondDown$2(firstUp, null), continuation);
    }

    public static /* synthetic */ Object detectTapAndPress$default(PointerInputScope pointerInputScope, Function3 function3, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function3 = NoPressGesture;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        return detectTapAndPress(pointerInputScope, function3, function1, continuation);
    }

    public static final Object detectTapAndPress(PointerInputScope $this$detectTapAndPress, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Continuation<? super Unit> continuation) {
        PressGestureScopeImpl pressScope = new PressGestureScopeImpl($this$detectTapAndPress);
        Object forEachGesture = ForEachGestureKt.forEachGesture($this$detectTapAndPress, new TapGestureDetectorKt$detectTapAndPress$2(pressScope, function3, function1, null), continuation);
        return forEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return awaitFirstDown(awaitPointerEventScope, z, continuation);
    }

    public static final Object awaitFirstDown(AwaitPointerEventScope $this$awaitFirstDown, boolean requireUnconsumed, Continuation<? super PointerInputChange> continuation) {
        return awaitFirstDownOnPass($this$awaitFirstDown, PointerEventPass.Main, requireUnconsumed, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0062 -> B:12:0x006b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitFirstDownOnPass(AwaitPointerEventScope $this$awaitFirstDownOnPass, PointerEventPass pointerEventPass, boolean requireUnconsumed, Continuation<? super PointerInputChange> continuation) {
        TapGestureDetectorKt$awaitFirstDownOnPass$1 tapGestureDetectorKt$awaitFirstDownOnPass$1;
        TapGestureDetectorKt$awaitFirstDownOnPass$1 tapGestureDetectorKt$awaitFirstDownOnPass$12;
        Object $result;
        AwaitPointerEventScope $this$awaitFirstDownOnPass2;
        PointerEventPass pass;
        boolean requireUnconsumed2;
        Object obj;
        int index$iv$iv;
        int size;
        List $this$fastForEach$iv$iv;
        if (continuation instanceof TapGestureDetectorKt$awaitFirstDownOnPass$1) {
            tapGestureDetectorKt$awaitFirstDownOnPass$1 = (TapGestureDetectorKt$awaitFirstDownOnPass$1) continuation;
            if ((tapGestureDetectorKt$awaitFirstDownOnPass$1.label & Integer.MIN_VALUE) != 0) {
                tapGestureDetectorKt$awaitFirstDownOnPass$1.label -= Integer.MIN_VALUE;
                tapGestureDetectorKt$awaitFirstDownOnPass$12 = tapGestureDetectorKt$awaitFirstDownOnPass$1;
                Object $result2 = tapGestureDetectorKt$awaitFirstDownOnPass$12.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (tapGestureDetectorKt$awaitFirstDownOnPass$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        AwaitPointerEventScope $this$awaitFirstDownOnPass3 = $this$awaitFirstDownOnPass;
                        boolean requireUnconsumed3 = requireUnconsumed;
                        PointerEventPass pass2 = pointerEventPass;
                        tapGestureDetectorKt$awaitFirstDownOnPass$12.L$0 = $this$awaitFirstDownOnPass3;
                        tapGestureDetectorKt$awaitFirstDownOnPass$12.L$1 = pass2;
                        tapGestureDetectorKt$awaitFirstDownOnPass$12.Z$0 = requireUnconsumed3;
                        tapGestureDetectorKt$awaitFirstDownOnPass$12.label = 1;
                        Object awaitPointerEvent = $this$awaitFirstDownOnPass3.awaitPointerEvent(pass2, tapGestureDetectorKt$awaitFirstDownOnPass$12);
                        if (awaitPointerEvent != $result3) {
                            return $result3;
                        }
                        Object obj2 = $result3;
                        $result = $result2;
                        $result2 = awaitPointerEvent;
                        $this$awaitFirstDownOnPass2 = $this$awaitFirstDownOnPass3;
                        pass = pass2;
                        requireUnconsumed2 = requireUnconsumed3;
                        obj = obj2;
                        PointerEvent event = (PointerEvent) $result2;
                        List $this$fastForEach$iv$iv2 = event.getChanges();
                        index$iv$iv = 0;
                        size = $this$fastForEach$iv$iv2.size();
                        while (true) {
                            if (index$iv$iv >= size) {
                                Object it$iv = $this$fastForEach$iv$iv2.get(index$iv$iv);
                                PointerInputChange it = (PointerInputChange) it$iv;
                                if (requireUnconsumed2 ? PointerEventKt.changedToDown(it) : PointerEventKt.changedToDownIgnoreConsumed(it)) {
                                    index$iv$iv++;
                                } else {
                                    $this$fastForEach$iv$iv = null;
                                }
                            } else {
                                $this$fastForEach$iv$iv = 1;
                            }
                        }
                        if ($this$fastForEach$iv$iv == null) {
                            return event.getChanges().get(0);
                        }
                        $result2 = $result;
                        $result3 = obj;
                        requireUnconsumed3 = requireUnconsumed2;
                        pass2 = pass;
                        $this$awaitFirstDownOnPass3 = $this$awaitFirstDownOnPass2;
                        tapGestureDetectorKt$awaitFirstDownOnPass$12.L$0 = $this$awaitFirstDownOnPass3;
                        tapGestureDetectorKt$awaitFirstDownOnPass$12.L$1 = pass2;
                        tapGestureDetectorKt$awaitFirstDownOnPass$12.Z$0 = requireUnconsumed3;
                        tapGestureDetectorKt$awaitFirstDownOnPass$12.label = 1;
                        Object awaitPointerEvent2 = $this$awaitFirstDownOnPass3.awaitPointerEvent(pass2, tapGestureDetectorKt$awaitFirstDownOnPass$12);
                        if (awaitPointerEvent2 != $result3) {
                        }
                    case 1:
                        boolean requireUnconsumed4 = tapGestureDetectorKt$awaitFirstDownOnPass$12.Z$0;
                        PointerEventPass pass3 = (PointerEventPass) tapGestureDetectorKt$awaitFirstDownOnPass$12.L$1;
                        AwaitPointerEventScope $this$awaitFirstDownOnPass4 = (AwaitPointerEventScope) tapGestureDetectorKt$awaitFirstDownOnPass$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        $this$awaitFirstDownOnPass2 = $this$awaitFirstDownOnPass4;
                        pass = pass3;
                        requireUnconsumed2 = requireUnconsumed4;
                        obj = $result3;
                        $result = $result2;
                        PointerEvent event2 = (PointerEvent) $result2;
                        List $this$fastForEach$iv$iv22 = event2.getChanges();
                        index$iv$iv = 0;
                        size = $this$fastForEach$iv$iv22.size();
                        while (true) {
                            if (index$iv$iv >= size) {
                            }
                            index$iv$iv++;
                        }
                        if ($this$fastForEach$iv$iv == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        tapGestureDetectorKt$awaitFirstDownOnPass$1 = new TapGestureDetectorKt$awaitFirstDownOnPass$1(continuation);
        tapGestureDetectorKt$awaitFirstDownOnPass$12 = tapGestureDetectorKt$awaitFirstDownOnPass$1;
        Object $result22 = tapGestureDetectorKt$awaitFirstDownOnPass$12.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tapGestureDetectorKt$awaitFirstDownOnPass$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0124 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d7 A[LOOP:2: B:37:0x00a8->B:44:0x00d7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x008d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00f7 -> B:12:0x00f9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object waitForUpOrCancellation(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
        TapGestureDetectorKt$waitForUpOrCancellation$1 tapGestureDetectorKt$waitForUpOrCancellation$1;
        TapGestureDetectorKt$waitForUpOrCancellation$1 tapGestureDetectorKt$waitForUpOrCancellation$12;
        AwaitPointerEventScope $this$waitForUpOrCancellation;
        Object obj;
        Object $result;
        int index$iv$iv;
        int size;
        int i;
        Object $result2;
        boolean z;
        Object $result3;
        List $this$fastForEach$iv$iv;
        boolean z2;
        int index$iv$iv2;
        int size2;
        boolean z3;
        if (continuation instanceof TapGestureDetectorKt$waitForUpOrCancellation$1) {
            tapGestureDetectorKt$waitForUpOrCancellation$1 = (TapGestureDetectorKt$waitForUpOrCancellation$1) continuation;
            if ((tapGestureDetectorKt$waitForUpOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                tapGestureDetectorKt$waitForUpOrCancellation$1.label -= Integer.MIN_VALUE;
                tapGestureDetectorKt$waitForUpOrCancellation$12 = tapGestureDetectorKt$waitForUpOrCancellation$1;
                Object $result4 = tapGestureDetectorKt$waitForUpOrCancellation$12.result;
                Object $result5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = 0;
                int i3 = 1;
                switch (tapGestureDetectorKt$waitForUpOrCancellation$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result4);
                        AwaitPointerEventScope $this$waitForUpOrCancellation2 = awaitPointerEventScope;
                        PointerEventPass pointerEventPass = PointerEventPass.Main;
                        tapGestureDetectorKt$waitForUpOrCancellation$12.L$0 = $this$waitForUpOrCancellation2;
                        tapGestureDetectorKt$waitForUpOrCancellation$12.label = i3;
                        Object awaitPointerEvent = $this$waitForUpOrCancellation2.awaitPointerEvent(pointerEventPass, tapGestureDetectorKt$waitForUpOrCancellation$12);
                        if (awaitPointerEvent != $result5) {
                            return $result5;
                        }
                        Object obj2 = $result5;
                        $result = $result4;
                        $result4 = awaitPointerEvent;
                        $this$waitForUpOrCancellation = $this$waitForUpOrCancellation2;
                        obj = obj2;
                        PointerEvent event = (PointerEvent) $result4;
                        List $this$fastForEach$iv$iv2 = event.getChanges();
                        index$iv$iv = 0;
                        size = $this$fastForEach$iv$iv2.size();
                        while (true) {
                            if (index$iv$iv >= size) {
                                Object item$iv$iv = $this$fastForEach$iv$iv2.get(index$iv$iv);
                                if (PointerEventKt.changedToUp((PointerInputChange) item$iv$iv)) {
                                    index$iv$iv++;
                                } else {
                                    i = i2;
                                }
                            } else {
                                i = i3;
                            }
                        }
                        if (i == 0) {
                            return event.getChanges().get(i2);
                        }
                        List $this$fastForEach$iv$iv3 = event.getChanges();
                        int index$iv$iv3 = 0;
                        int size3 = $this$fastForEach$iv$iv3.size();
                        while (true) {
                            if (index$iv$iv3 < size3) {
                                Object it$iv = $this$fastForEach$iv$iv3.get(index$iv$iv3);
                                PointerInputChange it = (PointerInputChange) it$iv;
                                if (it.isConsumed()) {
                                    $this$fastForEach$iv$iv = $this$fastForEach$iv$iv3;
                                    $result2 = $result;
                                } else {
                                    $this$fastForEach$iv$iv = $this$fastForEach$iv$iv3;
                                    $result2 = $result;
                                    if (!PointerEventKt.m3312isOutOfBoundsjwHxaWs(it, $this$waitForUpOrCancellation.mo3280getSizeYbymL2g(), $this$waitForUpOrCancellation.mo3279getExtendedTouchPaddingNHjbRc())) {
                                        z2 = false;
                                        if (z2) {
                                            index$iv$iv3++;
                                            $result = $result2;
                                            $this$fastForEach$iv$iv3 = $this$fastForEach$iv$iv;
                                        } else {
                                            z = true;
                                        }
                                    }
                                }
                                z2 = true;
                                if (z2) {
                                }
                            } else {
                                $result2 = $result;
                                z = false;
                            }
                        }
                        if (z) {
                            return null;
                        }
                        PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                        tapGestureDetectorKt$waitForUpOrCancellation$12.L$0 = $this$waitForUpOrCancellation;
                        tapGestureDetectorKt$waitForUpOrCancellation$12.label = 2;
                        $result4 = $this$waitForUpOrCancellation.awaitPointerEvent(pointerEventPass2, tapGestureDetectorKt$waitForUpOrCancellation$12);
                        if ($result4 == obj) {
                            return obj;
                        }
                        $result3 = $result2;
                        PointerEvent consumeCheck = (PointerEvent) $result4;
                        List $this$fastForEach$iv$iv4 = consumeCheck.getChanges();
                        index$iv$iv2 = 0;
                        size2 = $this$fastForEach$iv$iv4.size();
                        while (true) {
                            if (index$iv$iv2 >= size2) {
                                Object item$iv$iv2 = $this$fastForEach$iv$iv4.get(index$iv$iv2);
                                if (((PointerInputChange) item$iv$iv2).isConsumed()) {
                                    z3 = true;
                                } else {
                                    index$iv$iv2++;
                                }
                            } else {
                                z3 = false;
                            }
                        }
                        if (!z3) {
                            return null;
                        }
                        $result4 = $result3;
                        $result5 = obj;
                        $this$waitForUpOrCancellation2 = $this$waitForUpOrCancellation;
                        i2 = 0;
                        i3 = 1;
                        PointerEventPass pointerEventPass3 = PointerEventPass.Main;
                        tapGestureDetectorKt$waitForUpOrCancellation$12.L$0 = $this$waitForUpOrCancellation2;
                        tapGestureDetectorKt$waitForUpOrCancellation$12.label = i3;
                        Object awaitPointerEvent2 = $this$waitForUpOrCancellation2.awaitPointerEvent(pointerEventPass3, tapGestureDetectorKt$waitForUpOrCancellation$12);
                        if (awaitPointerEvent2 != $result5) {
                        }
                    case 1:
                        AwaitPointerEventScope $this$waitForUpOrCancellation3 = (AwaitPointerEventScope) tapGestureDetectorKt$waitForUpOrCancellation$12.L$0;
                        ResultKt.throwOnFailure($result4);
                        $this$waitForUpOrCancellation = $this$waitForUpOrCancellation3;
                        obj = $result5;
                        $result = $result4;
                        PointerEvent event2 = (PointerEvent) $result4;
                        List $this$fastForEach$iv$iv22 = event2.getChanges();
                        index$iv$iv = 0;
                        size = $this$fastForEach$iv$iv22.size();
                        while (true) {
                            if (index$iv$iv >= size) {
                            }
                            index$iv$iv++;
                        }
                        if (i == 0) {
                        }
                        break;
                    case 2:
                        AwaitPointerEventScope $this$waitForUpOrCancellation4 = (AwaitPointerEventScope) tapGestureDetectorKt$waitForUpOrCancellation$12.L$0;
                        ResultKt.throwOnFailure($result4);
                        $this$waitForUpOrCancellation = $this$waitForUpOrCancellation4;
                        obj = $result5;
                        $result3 = $result4;
                        PointerEvent consumeCheck2 = (PointerEvent) $result4;
                        List $this$fastForEach$iv$iv42 = consumeCheck2.getChanges();
                        index$iv$iv2 = 0;
                        size2 = $this$fastForEach$iv$iv42.size();
                        while (true) {
                            if (index$iv$iv2 >= size2) {
                            }
                            index$iv$iv2++;
                        }
                        if (!z3) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        tapGestureDetectorKt$waitForUpOrCancellation$1 = new TapGestureDetectorKt$waitForUpOrCancellation$1(continuation);
        tapGestureDetectorKt$waitForUpOrCancellation$12 = tapGestureDetectorKt$waitForUpOrCancellation$1;
        Object $result42 = tapGestureDetectorKt$waitForUpOrCancellation$12.result;
        Object $result52 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i22 = 0;
        int i32 = 1;
        switch (tapGestureDetectorKt$waitForUpOrCancellation$12.label) {
        }
    }
}
