package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerEventKt;
import androidx.compose.p000ui.input.pointer.PointerEventPass;
import androidx.compose.p000ui.input.pointer.PointerId;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerType;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.unit.C0504Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: DragGestureDetectorCopy.kt */
@Metadata(m286d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ag\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f26\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000eH\u0080@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a]\u0010\u0016\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00050\u0018H\u0082Hø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a!\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a!\u0010!\u001a\u00020\u0005*\u00020\"2\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006%"}, m287d2 = {"defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitHorizontalPointerSlopOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPointerSlopOrCancellation", "getDragDirectionValue", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPointerUp", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class DragGestureDetectorCopyKt {
    private static final float mouseToTouchSlopRatio;
    private static final float mouseSlop = C0504Dp.m4382constructorimpl((float) 0.125d);
    private static final float defaultTouchSlop = C0504Dp.m4382constructorimpl(18);

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01a2 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0149 -> B:17:0x009c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0192 -> B:12:0x019c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x01c0 -> B:17:0x009c). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m1358awaitHorizontalPointerSlopOrCancellationgDDlDlE(AwaitPointerEventScope awaitPointerEventScope, long pointerId, int pointerType, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        C0308x2966ccbb c0308x2966ccbb;
        C0308x2966ccbb c0308x2966ccbb2;
        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
        Function2 onPointerSlopReached;
        float touchSlop$iv;
        Ref.LongRef pointer$iv;
        float touchSlop$iv2;
        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2;
        float touchSlop$iv3;
        Object obj;
        Object $result;
        List $this$fastForEach$iv$iv$iv;
        int $i$f$fastFirstOrNull;
        int index$iv$iv$iv;
        int size;
        Function2 onPointerSlopReached2;
        Object it$iv$iv;
        PointerInputChange dragEvent$iv;
        PointerInputChange dragEvent$iv2;
        Object it$iv$iv2;
        List $this$fastForEach$iv$iv$iv2;
        int $i$f$fastFirstOrNull2;
        if (continuation instanceof C0308x2966ccbb) {
            c0308x2966ccbb = (C0308x2966ccbb) continuation;
            if ((c0308x2966ccbb.label & Integer.MIN_VALUE) != 0) {
                c0308x2966ccbb.label -= Integer.MIN_VALUE;
                c0308x2966ccbb2 = c0308x2966ccbb;
                Object $result2 = c0308x2966ccbb2.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                PointerEventPass pointerEventPass = null;
                switch (c0308x2966ccbb2.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = awaitPointerEventScope;
                        onPointerSlopReached = function2;
                        if (m1360isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv.getCurrentEvent(), pointerId)) {
                            return null;
                        }
                        touchSlop$iv = m1361pointerSlopE8SPZFQ($this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv.getViewConfiguration(), pointerType);
                        pointer$iv = new Ref.LongRef();
                        pointer$iv.element = pointerId;
                        touchSlop$iv2 = 0.0f;
                        c0308x2966ccbb2.L$0 = onPointerSlopReached;
                        c0308x2966ccbb2.L$1 = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
                        c0308x2966ccbb2.L$2 = pointer$iv;
                        c0308x2966ccbb2.L$3 = pointerEventPass;
                        c0308x2966ccbb2.F$0 = touchSlop$iv;
                        c0308x2966ccbb2.F$1 = touchSlop$iv2;
                        c0308x2966ccbb2.label = 1;
                        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv, pointerEventPass, c0308x2966ccbb2, 1, pointerEventPass);
                        if (awaitPointerEvent$default != $result3) {
                            return $result3;
                        }
                        Object obj2 = $result3;
                        $result = $result2;
                        $result2 = awaitPointerEvent$default;
                        touchSlop$iv3 = touchSlop$iv;
                        $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2 = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
                        obj = obj2;
                        PointerEvent event$iv = (PointerEvent) $result2;
                        $this$fastForEach$iv$iv$iv = event$iv.getChanges();
                        $i$f$fastFirstOrNull = 0;
                        index$iv$iv$iv = 0;
                        size = $this$fastForEach$iv$iv$iv.size();
                        while (true) {
                            if (index$iv$iv$iv >= size) {
                                Object item$iv$iv$iv = $this$fastForEach$iv$iv$iv.get(index$iv$iv$iv);
                                it$iv$iv = item$iv$iv$iv;
                                PointerInputChange it$iv = (PointerInputChange) it$iv$iv;
                                onPointerSlopReached2 = onPointerSlopReached;
                                $this$fastForEach$iv$iv$iv2 = $this$fastForEach$iv$iv$iv;
                                $i$f$fastFirstOrNull2 = $i$f$fastFirstOrNull;
                                if (!PointerId.m3349equalsimpl0(it$iv.getId(), pointer$iv.element)) {
                                    index$iv$iv$iv++;
                                    onPointerSlopReached = onPointerSlopReached2;
                                    $i$f$fastFirstOrNull = $i$f$fastFirstOrNull2;
                                    $this$fastForEach$iv$iv$iv = $this$fastForEach$iv$iv$iv2;
                                }
                            } else {
                                onPointerSlopReached2 = onPointerSlopReached;
                                it$iv$iv = null;
                            }
                        }
                        Intrinsics.checkNotNull(it$iv$iv);
                        dragEvent$iv = (PointerInputChange) it$iv$iv;
                        if (dragEvent$iv.isConsumed()) {
                            return null;
                        }
                        if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                            List $this$fastForEach$iv$iv$iv3 = event$iv.getChanges();
                            int index$iv$iv$iv2 = 0;
                            int size2 = $this$fastForEach$iv$iv$iv3.size();
                            while (true) {
                                if (index$iv$iv$iv2 < size2) {
                                    Object item$iv$iv$iv2 = $this$fastForEach$iv$iv$iv3.get(index$iv$iv$iv2);
                                    it$iv$iv2 = item$iv$iv$iv2;
                                    PointerInputChange it$iv2 = (PointerInputChange) it$iv$iv2;
                                    if (!it$iv2.getPressed()) {
                                        index$iv$iv$iv2++;
                                    }
                                } else {
                                    it$iv$iv2 = null;
                                }
                            }
                            PointerInputChange otherDown$iv = (PointerInputChange) it$iv$iv2;
                            if (otherDown$iv == null) {
                                return null;
                            }
                            pointer$iv.element = otherDown$iv.getId();
                            onPointerSlopReached = onPointerSlopReached2;
                            $result2 = $result;
                            $result3 = obj;
                            $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2;
                            pointerEventPass = null;
                            touchSlop$iv = touchSlop$iv3;
                        } else {
                            long it = dragEvent$iv.getPosition();
                            long previousPosition$iv = dragEvent$iv.getPreviousPosition();
                            float positionChange$iv = Offset.m1760getXimpl(it) - Offset.m1760getXimpl(previousPosition$iv);
                            float totalPositionChange$iv = touchSlop$iv2 + positionChange$iv;
                            float inDirection$iv = Math.abs(totalPositionChange$iv);
                            if (inDirection$iv < touchSlop$iv3) {
                                PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                                Function2 onPointerSlopReached3 = onPointerSlopReached2;
                                c0308x2966ccbb2.L$0 = onPointerSlopReached3;
                                c0308x2966ccbb2.L$1 = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2;
                                c0308x2966ccbb2.L$2 = pointer$iv;
                                c0308x2966ccbb2.L$3 = dragEvent$iv;
                                c0308x2966ccbb2.F$0 = touchSlop$iv3;
                                c0308x2966ccbb2.F$1 = totalPositionChange$iv;
                                c0308x2966ccbb2.label = 2;
                                if ($this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2.awaitPointerEvent(pointerEventPass2, c0308x2966ccbb2) == obj) {
                                    return obj;
                                }
                                $result2 = $result;
                                $result3 = obj;
                                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2;
                                touchSlop$iv = touchSlop$iv3;
                                dragEvent$iv2 = dragEvent$iv;
                                touchSlop$iv2 = totalPositionChange$iv;
                                onPointerSlopReached = onPointerSlopReached3;
                                if (!dragEvent$iv2.isConsumed()) {
                                    return null;
                                }
                                pointerEventPass = null;
                            } else {
                                Function2 onPointerSlopReached4 = onPointerSlopReached2;
                                onPointerSlopReached4.invoke(dragEvent$iv, Boxing.boxFloat(totalPositionChange$iv - (Math.signum(totalPositionChange$iv) * touchSlop$iv3)));
                                if (dragEvent$iv.isConsumed()) {
                                    return dragEvent$iv;
                                }
                                onPointerSlopReached = onPointerSlopReached4;
                                pointerEventPass = null;
                                touchSlop$iv2 = 0.0f;
                                $result2 = $result;
                                $result3 = obj;
                                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2;
                                touchSlop$iv = touchSlop$iv3;
                            }
                        }
                        c0308x2966ccbb2.L$0 = onPointerSlopReached;
                        c0308x2966ccbb2.L$1 = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
                        c0308x2966ccbb2.L$2 = pointer$iv;
                        c0308x2966ccbb2.L$3 = pointerEventPass;
                        c0308x2966ccbb2.F$0 = touchSlop$iv;
                        c0308x2966ccbb2.F$1 = touchSlop$iv2;
                        c0308x2966ccbb2.label = 1;
                        Object awaitPointerEvent$default2 = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv, pointerEventPass, c0308x2966ccbb2, 1, pointerEventPass);
                        if (awaitPointerEvent$default2 != $result3) {
                        }
                    case 1:
                        float totalPositionChange$iv2 = c0308x2966ccbb2.F$1;
                        float touchSlop$iv4 = c0308x2966ccbb2.F$0;
                        Ref.LongRef pointer$iv2 = (Ref.LongRef) c0308x2966ccbb2.L$2;
                        $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2 = (AwaitPointerEventScope) c0308x2966ccbb2.L$1;
                        Function2 onPointerSlopReached5 = (Function2) c0308x2966ccbb2.L$0;
                        ResultKt.throwOnFailure($result2);
                        pointer$iv = pointer$iv2;
                        touchSlop$iv3 = touchSlop$iv4;
                        touchSlop$iv2 = totalPositionChange$iv2;
                        onPointerSlopReached = onPointerSlopReached5;
                        obj = $result3;
                        $result = $result2;
                        PointerEvent event$iv2 = (PointerEvent) $result2;
                        $this$fastForEach$iv$iv$iv = event$iv2.getChanges();
                        $i$f$fastFirstOrNull = 0;
                        index$iv$iv$iv = 0;
                        size = $this$fastForEach$iv$iv$iv.size();
                        while (true) {
                            if (index$iv$iv$iv >= size) {
                            }
                            index$iv$iv$iv++;
                            onPointerSlopReached = onPointerSlopReached2;
                            $i$f$fastFirstOrNull = $i$f$fastFirstOrNull2;
                            $this$fastForEach$iv$iv$iv = $this$fastForEach$iv$iv$iv2;
                        }
                        Intrinsics.checkNotNull(it$iv$iv);
                        dragEvent$iv = (PointerInputChange) it$iv$iv;
                        if (dragEvent$iv.isConsumed()) {
                        }
                        break;
                    case 2:
                        float totalPositionChange$iv3 = c0308x2966ccbb2.F$1;
                        float touchSlop$iv5 = c0308x2966ccbb2.F$0;
                        dragEvent$iv2 = (PointerInputChange) c0308x2966ccbb2.L$3;
                        Ref.LongRef pointer$iv3 = (Ref.LongRef) c0308x2966ccbb2.L$2;
                        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv3 = (AwaitPointerEventScope) c0308x2966ccbb2.L$1;
                        Function2 onPointerSlopReached6 = (Function2) c0308x2966ccbb2.L$0;
                        ResultKt.throwOnFailure($result2);
                        $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv3;
                        touchSlop$iv2 = totalPositionChange$iv3;
                        onPointerSlopReached = onPointerSlopReached6;
                        pointer$iv = pointer$iv3;
                        touchSlop$iv = touchSlop$iv5;
                        if (!dragEvent$iv2.isConsumed()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        c0308x2966ccbb = new C0308x2966ccbb(continuation);
        c0308x2966ccbb2 = c0308x2966ccbb;
        Object $result22 = c0308x2966ccbb2.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        PointerEventPass pointerEventPass3 = null;
        switch (c0308x2966ccbb2.label) {
        }
    }

    /* renamed from: awaitPointerSlopOrCancellation-pn7EDYM, reason: not valid java name */
    private static final Object m1359awaitPointerSlopOrCancellationpn7EDYM(AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dpn7EDYM, long pointerId, int pointerType, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function1<? super Offset, Float> function1, Continuation<? super PointerInputChange> continuation) {
        Object it$iv;
        Object it$iv2;
        AwaitPointerEventScope awaitPointerEventScope = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM;
        Function1<? super Offset, Float> function12 = function1;
        float positionChange = 0.0f;
        PointerEventPass pointerEventPass = null;
        if (m1360isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dpn7EDYM.getCurrentEvent(), pointerId)) {
            return null;
        }
        float touchSlop = m1361pointerSlopE8SPZFQ($this$awaitPointerSlopOrCancellation_u2dpn7EDYM.getViewConfiguration(), pointerType);
        long pointer = pointerId;
        float totalPositionChange = 0.0f;
        while (true) {
            InlineMarker.mark(0);
            Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, pointerEventPass, continuation, 1, pointerEventPass);
            InlineMarker.mark(1);
            PointerEvent event = (PointerEvent) awaitPointerEvent$default;
            List $this$fastForEach$iv$iv = event.getChanges();
            int size = $this$fastForEach$iv$iv.size();
            int index$iv$iv = 0;
            while (true) {
                if (index$iv$iv < size) {
                    List $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                    Object item$iv$iv = $this$fastForEach$iv$iv2.get(index$iv$iv);
                    it$iv = item$iv$iv;
                    PointerInputChange it = (PointerInputChange) it$iv;
                    if (PointerId.m3349equalsimpl0(it.getId(), pointer)) {
                        break;
                    }
                    index$iv$iv++;
                    $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                } else {
                    it$iv = null;
                    break;
                }
            }
            Intrinsics.checkNotNull(it$iv);
            PointerInputChange dragEvent = (PointerInputChange) it$iv;
            if (dragEvent.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent)) {
                List $this$fastFirstOrNull$iv = event.getChanges();
                int index$iv$iv2 = 0;
                float f = positionChange;
                int size2 = $this$fastFirstOrNull$iv.size();
                while (true) {
                    if (index$iv$iv2 < size2) {
                        Object item$iv$iv2 = $this$fastFirstOrNull$iv.get(index$iv$iv2);
                        it$iv2 = item$iv$iv2;
                        PointerInputChange it2 = (PointerInputChange) it$iv2;
                        if (it2.getPressed()) {
                            break;
                        }
                        index$iv$iv2++;
                    } else {
                        it$iv2 = null;
                        break;
                    }
                }
                PointerInputChange otherDown = (PointerInputChange) it$iv2;
                if (otherDown == null) {
                    return null;
                }
                pointer = otherDown.getId();
                positionChange = f;
                pointerEventPass = null;
            } else {
                float f2 = positionChange;
                long currentPosition = dragEvent.getPosition();
                long previousPosition = dragEvent.getPreviousPosition();
                float positionChange2 = function12.invoke(Offset.m1749boximpl(currentPosition)).floatValue() - function12.invoke(Offset.m1749boximpl(previousPosition)).floatValue();
                totalPositionChange += positionChange2;
                float inDirection = Math.abs(totalPositionChange);
                if (inDirection < touchSlop) {
                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                    InlineMarker.mark(0);
                    awaitPointerEventScope.awaitPointerEvent(pointerEventPass2, continuation);
                    InlineMarker.mark(1);
                    if (!dragEvent.isConsumed()) {
                        pointerEventPass = null;
                        positionChange = f2;
                        function12 = function1;
                    } else {
                        return null;
                    }
                } else {
                    function2.invoke(dragEvent, Float.valueOf(totalPositionChange - (Math.signum(totalPositionChange) * touchSlop)));
                    if (dragEvent.isConsumed()) {
                        return dragEvent;
                    }
                    totalPositionChange = 0.0f;
                    awaitPointerEventScope = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM;
                    function12 = function1;
                    positionChange = f2;
                    pointerEventPass = null;
                }
            }
        }
    }

    /* renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    private static final boolean m1360isPointerUpDmW0f2w(PointerEvent $this$isPointerUp_u2dDmW0f2w, long pointerId) {
        Object it$iv;
        List $this$fastFirstOrNull$iv = $this$isPointerUp_u2dDmW0f2w.getChanges();
        int index$iv$iv = 0;
        int size = $this$fastFirstOrNull$iv.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = $this$fastFirstOrNull$iv.get(index$iv$iv);
                it$iv = item$iv$iv;
                PointerInputChange it = (PointerInputChange) it$iv;
                if (PointerId.m3349equalsimpl0(it.getId(), pointerId)) {
                    break;
                }
                index$iv$iv++;
            } else {
                it$iv = null;
                break;
            }
        }
        PointerInputChange pointerInputChange = (PointerInputChange) it$iv;
        boolean z = false;
        if (pointerInputChange != null && pointerInputChange.getPressed()) {
            z = true;
        }
        return !z;
    }

    static {
        float arg0$iv = mouseSlop;
        float other$iv = defaultTouchSlop;
        mouseToTouchSlopRatio = arg0$iv / other$iv;
    }

    /* renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m1361pointerSlopE8SPZFQ(ViewConfiguration pointerSlop, int pointerType) {
        Intrinsics.checkNotNullParameter(pointerSlop, "$this$pointerSlop");
        return PointerType.m3435equalsimpl0(pointerType, PointerType.INSTANCE.m3440getMouseT8wyACA()) ? pointerSlop.getTouchSlop() * mouseToTouchSlopRatio : pointerSlop.getTouchSlop();
    }
}
