package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerEventKt;
import androidx.compose.p000ui.input.pointer.PointerEventPass;
import androidx.compose.p000ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.input.pointer.PointerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: TextSelectionMouseDetector.kt */
@Metadata(m286d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u001d\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m287d2 = {"ClicksSlop", "", "awaitMouseEventDown", "Landroidx/compose/ui/input/pointer/PointerEvent;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelectionDetector", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "observer", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TextSelectionMouseDetectorKt {
    public static final double ClicksSlop = 100.0d;

    public static final Object mouseSelectionDetector(PointerInputScope $this$mouseSelectionDetector, MouseSelectionObserver observer, Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture($this$mouseSelectionDetector, new TextSelectionMouseDetectorKt$mouseSelectionDetector$2(observer, null), continuation);
        return forEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x004e -> B:12:0x0055). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitMouseEventDown(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerEvent> continuation) {
        TextSelectionMouseDetectorKt$awaitMouseEventDown$1 textSelectionMouseDetectorKt$awaitMouseEventDown$1;
        TextSelectionMouseDetectorKt$awaitMouseEventDown$1 textSelectionMouseDetectorKt$awaitMouseEventDown$12;
        AwaitPointerEventScope $this$awaitMouseEventDown;
        Object awaitPointerEvent;
        Object $result;
        AwaitPointerEventScope $this$awaitMouseEventDown2;
        Object obj;
        PointerEvent event;
        boolean z;
        if (continuation instanceof TextSelectionMouseDetectorKt$awaitMouseEventDown$1) {
            textSelectionMouseDetectorKt$awaitMouseEventDown$1 = (TextSelectionMouseDetectorKt$awaitMouseEventDown$1) continuation;
            if ((textSelectionMouseDetectorKt$awaitMouseEventDown$1.label & Integer.MIN_VALUE) != 0) {
                textSelectionMouseDetectorKt$awaitMouseEventDown$1.label -= Integer.MIN_VALUE;
                textSelectionMouseDetectorKt$awaitMouseEventDown$12 = textSelectionMouseDetectorKt$awaitMouseEventDown$1;
                Object $result2 = textSelectionMouseDetectorKt$awaitMouseEventDown$12.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (textSelectionMouseDetectorKt$awaitMouseEventDown$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        $this$awaitMouseEventDown = awaitPointerEventScope;
                        PointerEventPass pointerEventPass = PointerEventPass.Main;
                        textSelectionMouseDetectorKt$awaitMouseEventDown$12.L$0 = $this$awaitMouseEventDown;
                        textSelectionMouseDetectorKt$awaitMouseEventDown$12.label = 1;
                        awaitPointerEvent = $this$awaitMouseEventDown.awaitPointerEvent(pointerEventPass, textSelectionMouseDetectorKt$awaitMouseEventDown$12);
                        if (awaitPointerEvent == $result3) {
                            return $result3;
                        }
                        Object obj2 = $result3;
                        $result = $result2;
                        $result2 = awaitPointerEvent;
                        $this$awaitMouseEventDown2 = $this$awaitMouseEventDown;
                        obj = obj2;
                        event = (PointerEvent) $result2;
                        if (PointerEvent_androidKt.m3340isPrimaryPressedaHzCxE(event.getButtons())) {
                            List $this$fastForEach$iv$iv = event.getChanges();
                            int index$iv$iv = 0;
                            int size = $this$fastForEach$iv$iv.size();
                            while (true) {
                                if (index$iv$iv < size) {
                                    Object it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
                                    PointerInputChange it = (PointerInputChange) it$iv;
                                    z = false;
                                    if (((PointerType.m3435equalsimpl0(it.getType(), PointerType.INSTANCE.m3440getMouseT8wyACA()) && PointerEventKt.changedToDown(it)) ? 1 : null) != null) {
                                        index$iv$iv++;
                                    }
                                } else {
                                    z = true;
                                }
                            }
                            if (z) {
                                return event;
                            }
                        }
                        $result2 = $result;
                        $result3 = obj;
                        $this$awaitMouseEventDown = $this$awaitMouseEventDown2;
                        PointerEventPass pointerEventPass2 = PointerEventPass.Main;
                        textSelectionMouseDetectorKt$awaitMouseEventDown$12.L$0 = $this$awaitMouseEventDown;
                        textSelectionMouseDetectorKt$awaitMouseEventDown$12.label = 1;
                        awaitPointerEvent = $this$awaitMouseEventDown.awaitPointerEvent(pointerEventPass2, textSelectionMouseDetectorKt$awaitMouseEventDown$12);
                        if (awaitPointerEvent == $result3) {
                        }
                        break;
                    case 1:
                        AwaitPointerEventScope $this$awaitMouseEventDown3 = (AwaitPointerEventScope) textSelectionMouseDetectorKt$awaitMouseEventDown$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        $this$awaitMouseEventDown2 = $this$awaitMouseEventDown3;
                        obj = $result3;
                        $result = $result2;
                        event = (PointerEvent) $result2;
                        if (PointerEvent_androidKt.m3340isPrimaryPressedaHzCxE(event.getButtons())) {
                        }
                        $result2 = $result;
                        $result3 = obj;
                        $this$awaitMouseEventDown = $this$awaitMouseEventDown2;
                        PointerEventPass pointerEventPass22 = PointerEventPass.Main;
                        textSelectionMouseDetectorKt$awaitMouseEventDown$12.L$0 = $this$awaitMouseEventDown;
                        textSelectionMouseDetectorKt$awaitMouseEventDown$12.label = 1;
                        awaitPointerEvent = $this$awaitMouseEventDown.awaitPointerEvent(pointerEventPass22, textSelectionMouseDetectorKt$awaitMouseEventDown$12);
                        if (awaitPointerEvent == $result3) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        textSelectionMouseDetectorKt$awaitMouseEventDown$1 = new TextSelectionMouseDetectorKt$awaitMouseEventDown$1(continuation);
        textSelectionMouseDetectorKt$awaitMouseEventDown$12 = textSelectionMouseDetectorKt$awaitMouseEventDown$1;
        Object $result22 = textSelectionMouseDetectorKt$awaitMouseEventDown$12.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (textSelectionMouseDetectorKt$awaitMouseEventDown$12.label) {
        }
    }
}
