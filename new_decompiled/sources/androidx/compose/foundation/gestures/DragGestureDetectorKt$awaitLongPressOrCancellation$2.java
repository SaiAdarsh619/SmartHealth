package androidx.compose.foundation.gestures;

import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerEventKt;
import androidx.compose.p000ui.input.pointer.PointerEventPass;
import androidx.compose.p000ui.input.pointer.PointerId;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: DragGestureDetector.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2", m297f = "DragGestureDetector.kt", m298i = {0, 0, 1, 1, 1}, m299l = {819, 836}, m300m = "invokeSuspend", m301n = {"$this$withTimeout", "finished", "$this$withTimeout", NotificationCompat.CATEGORY_EVENT, "finished"}, m302s = {"L$0", "I$0", "L$0", "L$1", "I$0"})
/* loaded from: classes.dex */
final class DragGestureDetectorKt$awaitLongPressOrCancellation$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $currentDown;
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $longPress;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$awaitLongPressOrCancellation$2(Ref.ObjectRef<PointerInputChange> objectRef, Ref.ObjectRef<PointerInputChange> objectRef2, Continuation<? super DragGestureDetectorKt$awaitLongPressOrCancellation$2> continuation) {
        super(2, continuation);
        this.$currentDown = objectRef;
        this.$longPress = objectRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(this.$currentDown, this.$longPress, continuation);
        dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$0 = obj;
        return dragGestureDetectorKt$awaitLongPressOrCancellation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$awaitLongPressOrCancellation$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d6 A[LOOP:3: B:43:0x00a9->B:50:0x00d6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00dd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0112  */
    /* JADX WARN: Type inference failed for: r4v15, types: [T, androidx.compose.ui.input.pointer.PointerInputChange] */
    /* JADX WARN: Type inference failed for: r5v14, types: [T] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00fd -> B:7:0x00ff). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$2;
        Object $result;
        AwaitPointerEventScope $this$withTimeout;
        int i;
        Object $result2;
        AwaitPointerEventScope $this$withTimeout2;
        int i2;
        Object $result3;
        PointerEvent event;
        int index$iv$iv;
        int size;
        int i3;
        int index$iv$iv2;
        int size2;
        PointerEvent event2;
        boolean z;
        int i4;
        Object awaitPointerEvent;
        PointerEvent event3;
        Object $result4;
        boolean z2;
        int index$iv$iv3;
        int size3;
        boolean z3;
        Object obj2;
        DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$22;
        int i5;
        T t;
        Object it$iv;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Object obj3 = null;
        int i6 = 1;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                dragGestureDetectorKt$awaitLongPressOrCancellation$2 = this;
                $result = obj;
                AwaitPointerEventScope $this$withTimeout3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$0;
                $this$withTimeout = $this$withTimeout3;
                i = 0;
                if (i != 0) {
                    dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$0 = $this$withTimeout;
                    dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$1 = obj3;
                    dragGestureDetectorKt$awaitLongPressOrCancellation$2.I$0 = i;
                    dragGestureDetectorKt$awaitLongPressOrCancellation$2.label = i6;
                    Object awaitPointerEvent2 = $this$withTimeout.awaitPointerEvent(PointerEventPass.Main, dragGestureDetectorKt$awaitLongPressOrCancellation$2);
                    if (awaitPointerEvent2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i7 = i;
                    $result3 = $result;
                    $result2 = awaitPointerEvent2;
                    $this$withTimeout2 = $this$withTimeout;
                    i2 = i7;
                    event = (PointerEvent) $result2;
                    List $this$fastForEach$iv$iv = event.getChanges();
                    index$iv$iv = 0;
                    size = $this$fastForEach$iv$iv.size();
                    while (true) {
                        if (index$iv$iv >= size) {
                            Object item$iv$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
                            if (PointerEventKt.changedToUpIgnoreConsumed((PointerInputChange) item$iv$iv)) {
                                index$iv$iv++;
                            } else {
                                i3 = 0;
                            }
                        } else {
                            i3 = i6;
                        }
                    }
                    if (i3 != 0) {
                        i2 = 1;
                    }
                    List $this$fastForEach$iv$iv2 = event.getChanges();
                    index$iv$iv2 = 0;
                    size2 = $this$fastForEach$iv$iv2.size();
                    while (true) {
                        if (index$iv$iv2 >= size2) {
                            Object it$iv2 = $this$fastForEach$iv$iv2.get(index$iv$iv2);
                            PointerInputChange it = (PointerInputChange) it$iv2;
                            if (it.isConsumed()) {
                                event2 = event;
                            } else {
                                event2 = event;
                                if (!PointerEventKt.m3312isOutOfBoundsjwHxaWs(it, $this$withTimeout2.mo3280getSizeYbymL2g(), $this$withTimeout2.mo3279getExtendedTouchPaddingNHjbRc())) {
                                    z2 = false;
                                    if (z2) {
                                        index$iv$iv2++;
                                        event = event2;
                                    } else {
                                        z = true;
                                    }
                                }
                            }
                            z2 = true;
                            if (z2) {
                            }
                        } else {
                            event2 = event;
                            z = false;
                        }
                    }
                    i4 = !z ? 1 : i2;
                    dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$0 = $this$withTimeout2;
                    PointerEvent event4 = event2;
                    dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$1 = event4;
                    dragGestureDetectorKt$awaitLongPressOrCancellation$2.I$0 = i4;
                    dragGestureDetectorKt$awaitLongPressOrCancellation$2.label = 2;
                    awaitPointerEvent = $this$withTimeout2.awaitPointerEvent(PointerEventPass.Final, dragGestureDetectorKt$awaitLongPressOrCancellation$2);
                    if (awaitPointerEvent != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    event3 = event4;
                    $result4 = awaitPointerEvent;
                    PointerEvent consumeCheck = (PointerEvent) $result4;
                    List $this$fastForEach$iv$iv3 = consumeCheck.getChanges();
                    index$iv$iv3 = 0;
                    size3 = $this$fastForEach$iv$iv3.size();
                    while (true) {
                        if (index$iv$iv3 >= size3) {
                            Object item$iv$iv2 = $this$fastForEach$iv$iv3.get(index$iv$iv3);
                            if (((PointerInputChange) item$iv$iv2).isConsumed()) {
                                z3 = true;
                            } else {
                                index$iv$iv3++;
                            }
                        } else {
                            z3 = false;
                        }
                    }
                    if (z3) {
                        i4 = 1;
                    }
                    if (DragGestureDetectorKt.m594isPointerUpDmW0f2w(event3, dragGestureDetectorKt$awaitLongPressOrCancellation$2.$currentDown.element.getId())) {
                        Ref.ObjectRef<PointerInputChange> objectRef = dragGestureDetectorKt$awaitLongPressOrCancellation$2.$longPress;
                        List $this$fastForEach$iv$iv4 = event3.getChanges();
                        Ref.ObjectRef<PointerInputChange> objectRef2 = dragGestureDetectorKt$awaitLongPressOrCancellation$2.$currentDown;
                        int index$iv$iv4 = 0;
                        int size4 = $this$fastForEach$iv$iv4.size();
                        while (true) {
                            if (index$iv$iv4 < size4) {
                                Object item$iv$iv3 = $this$fastForEach$iv$iv4.get(index$iv$iv4);
                                t = item$iv$iv3;
                                obj2 = coroutine_suspended;
                                dragGestureDetectorKt$awaitLongPressOrCancellation$22 = dragGestureDetectorKt$awaitLongPressOrCancellation$2;
                                i5 = i4;
                                if (!PointerId.m3349equalsimpl0(((PointerInputChange) t).getId(), objectRef2.element.getId())) {
                                    index$iv$iv4++;
                                    coroutine_suspended = obj2;
                                    dragGestureDetectorKt$awaitLongPressOrCancellation$2 = dragGestureDetectorKt$awaitLongPressOrCancellation$22;
                                    i4 = i5;
                                }
                            } else {
                                obj2 = coroutine_suspended;
                                dragGestureDetectorKt$awaitLongPressOrCancellation$22 = dragGestureDetectorKt$awaitLongPressOrCancellation$2;
                                i5 = i4;
                                t = 0;
                            }
                        }
                        objectRef.element = t;
                    } else {
                        List $this$fastForEach$iv$iv5 = event3.getChanges();
                        int index$iv$iv5 = 0;
                        int size5 = $this$fastForEach$iv$iv5.size();
                        while (true) {
                            if (index$iv$iv5 < size5) {
                                Object item$iv$iv4 = $this$fastForEach$iv$iv5.get(index$iv$iv5);
                                it$iv = item$iv$iv4;
                                if (!((PointerInputChange) it$iv).getPressed()) {
                                    index$iv$iv5++;
                                }
                            } else {
                                it$iv = null;
                            }
                        }
                        ?? r4 = (PointerInputChange) it$iv;
                        if (r4 != 0) {
                            dragGestureDetectorKt$awaitLongPressOrCancellation$2.$currentDown.element = r4;
                            dragGestureDetectorKt$awaitLongPressOrCancellation$2.$longPress.element = dragGestureDetectorKt$awaitLongPressOrCancellation$2.$currentDown.element;
                            obj2 = coroutine_suspended;
                            dragGestureDetectorKt$awaitLongPressOrCancellation$22 = dragGestureDetectorKt$awaitLongPressOrCancellation$2;
                            i5 = i4;
                        } else {
                            $result = $result3;
                            $this$withTimeout = $this$withTimeout2;
                            i6 = 1;
                            i = 1;
                            obj3 = null;
                            if (i != 0) {
                                return Unit.INSTANCE;
                            }
                        }
                    }
                    coroutine_suspended = obj2;
                    $result = $result3;
                    $this$withTimeout = $this$withTimeout2;
                    dragGestureDetectorKt$awaitLongPressOrCancellation$2 = dragGestureDetectorKt$awaitLongPressOrCancellation$22;
                    i = i5;
                    obj3 = null;
                    i6 = 1;
                    if (i != 0) {
                    }
                }
            case 1:
                dragGestureDetectorKt$awaitLongPressOrCancellation$2 = this;
                $result2 = obj;
                int i8 = dragGestureDetectorKt$awaitLongPressOrCancellation$2.I$0;
                AwaitPointerEventScope $this$withTimeout4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$0;
                ResultKt.throwOnFailure($result2);
                $this$withTimeout2 = $this$withTimeout4;
                i2 = i8;
                $result3 = $result2;
                event = (PointerEvent) $result2;
                List $this$fastForEach$iv$iv6 = event.getChanges();
                index$iv$iv = 0;
                size = $this$fastForEach$iv$iv6.size();
                while (true) {
                    if (index$iv$iv >= size) {
                    }
                    index$iv$iv++;
                }
                if (i3 != 0) {
                }
                List $this$fastForEach$iv$iv22 = event.getChanges();
                index$iv$iv2 = 0;
                size2 = $this$fastForEach$iv$iv22.size();
                while (true) {
                    if (index$iv$iv2 >= size2) {
                    }
                    index$iv$iv2++;
                    event = event2;
                }
                if (!z) {
                }
                dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$0 = $this$withTimeout2;
                PointerEvent event42 = event2;
                dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$1 = event42;
                dragGestureDetectorKt$awaitLongPressOrCancellation$2.I$0 = i4;
                dragGestureDetectorKt$awaitLongPressOrCancellation$2.label = 2;
                awaitPointerEvent = $this$withTimeout2.awaitPointerEvent(PointerEventPass.Final, dragGestureDetectorKt$awaitLongPressOrCancellation$2);
                if (awaitPointerEvent != coroutine_suspended) {
                }
                break;
            case 2:
                dragGestureDetectorKt$awaitLongPressOrCancellation$2 = this;
                $result4 = obj;
                int i9 = dragGestureDetectorKt$awaitLongPressOrCancellation$2.I$0;
                event3 = (PointerEvent) dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$1;
                $this$withTimeout2 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$0;
                ResultKt.throwOnFailure($result4);
                i4 = i9;
                $result3 = $result4;
                PointerEvent consumeCheck2 = (PointerEvent) $result4;
                List $this$fastForEach$iv$iv32 = consumeCheck2.getChanges();
                index$iv$iv3 = 0;
                size3 = $this$fastForEach$iv$iv32.size();
                while (true) {
                    if (index$iv$iv3 >= size3) {
                    }
                    index$iv$iv3++;
                }
                if (z3) {
                }
                if (DragGestureDetectorKt.m594isPointerUpDmW0f2w(event3, dragGestureDetectorKt$awaitLongPressOrCancellation$2.$currentDown.element.getId())) {
                }
                coroutine_suspended = obj2;
                $result = $result3;
                $this$withTimeout = $this$withTimeout2;
                dragGestureDetectorKt$awaitLongPressOrCancellation$2 = dragGestureDetectorKt$awaitLongPressOrCancellation$22;
                i = i5;
                obj3 = null;
                i6 = 1;
                if (i != 0) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
