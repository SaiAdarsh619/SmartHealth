package androidx.compose.foundation.gestures;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerEventKt;
import androidx.compose.p000ui.input.pointer.PointerEventPass;
import androidx.compose.p000ui.input.pointer.PointerId;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: DragGestureDetector.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5", m297f = "DragGestureDetector.kt", m298i = {}, m299l = {176}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes.dex */
final class DragGestureDetectorKt$detectDragGestures$5 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function0<Unit> $onDragEnd;
    final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DragGestureDetectorKt$detectDragGestures$5(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super DragGestureDetectorKt$detectDragGestures$5> continuation) {
        super(2, continuation);
        this.$onDragStart = function1;
        this.$onDrag = function2;
        this.$onDragCancel = function0;
        this.$onDragEnd = function02;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGestures$5 dragGestureDetectorKt$detectDragGestures$5 = new DragGestureDetectorKt$detectDragGestures$5(this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
        dragGestureDetectorKt$detectDragGestures$5.L$0 = obj;
        return dragGestureDetectorKt$detectDragGestures$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGestures$5) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: DragGestureDetector.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1", m297f = "DragGestureDetector.kt", m298i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, m299l = {177, 898, 948, 194}, m300m = "invokeSuspend", m301n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv", "pointerDirectionConfig$iv", "pointer$iv", "triggerOnMainAxisSlop$iv", "touchSlop$iv", "totalMainPositionChange$iv", "totalCrossPositionChange$iv", "$this$awaitPointerEventScope", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv", "pointerDirectionConfig$iv", "pointer$iv", "dragEvent$iv", "triggerOnMainAxisSlop$iv", "touchSlop$iv", "totalMainPositionChange$iv", "totalCrossPositionChange$iv"}, m302s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "F$0", "F$1", "F$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "F$0", "F$1", "F$2"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1 */
    static final class C00921 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C00921(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super C00921> continuation) {
            super(2, continuation);
            this.$onDragStart = function1;
            this.$onDrag = function2;
            this.$onDragCancel = function0;
            this.$onDragEnd = function02;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00921 c00921 = new C00921(this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
            c00921.L$0 = obj;
            return c00921;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C00921) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Path cross not found for [B:45:0x01a9, B:58:0x01f4], limit reached: 91 */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0314  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0267  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x02b5  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00f0  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00f3  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x012b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x012c  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0149  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x018d  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0195  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x017f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:79:0x02c2  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0269  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x030e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00f0 -> B:18:0x02b3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x018d -> B:18:0x02b3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x019b -> B:18:0x02b3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x01d9 -> B:18:0x02b3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x01e1 -> B:26:0x0104). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0252 -> B:15:0x0261). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x02ae -> B:18:0x02b3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x031d -> B:26:0x0104). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            C00921 c00921;
            Object $result2;
            Object $result3;
            AwaitPointerEventScope $this$awaitPointerEventScope;
            PointerInputChange down;
            Ref.LongRef overSlop;
            PointerInputChange down2;
            Object obj;
            int i;
            float touchSlop$iv;
            Ref.LongRef pointer$iv;
            float totalMainPositionChange$iv;
            PointerDirectionConfig pointerDirectionConfig$iv;
            float touchSlop$iv2;
            AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
            int i2;
            List $this$fastForEach$iv$iv$iv;
            int size;
            int index$iv$iv$iv;
            Object $result4;
            Ref.LongRef overSlop2;
            AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
            Object obj2;
            PointerInputChange drag;
            AwaitPointerEventScope $this$awaitPointerEventScope2;
            long touchSlopOffset$iv;
            int i3;
            PointerInputChange dragEvent$iv;
            int i4;
            Object obj3;
            int i5;
            List $this$fastForEach$iv$iv$iv2;
            long pointerId$iv;
            C00921 c009212;
            Object $result5;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c00921 = this;
                    AwaitPointerEventScope $this$awaitPointerEventScope3 = (AwaitPointerEventScope) c00921.L$0;
                    c00921.L$0 = $this$awaitPointerEventScope3;
                    c00921.label = 1;
                    Object awaitFirstDown = TapGestureDetectorKt.awaitFirstDown($this$awaitPointerEventScope3, false, c00921);
                    if (awaitFirstDown == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    $result3 = awaitFirstDown;
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope3;
                    down = (PointerInputChange) $result3;
                    overSlop = new Ref.LongRef();
                    overSlop.element = Offset.INSTANCE.m1776getZeroF1C5BW0();
                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerEventScope;
                    pointerId$iv = down.getId();
                    int pointerType$iv = down.getType();
                    i2 = 0;
                    pointerDirectionConfig$iv = DragGestureDetectorKt.getHorizontalPointerDirectionConfig();
                    i3 = 0;
                    if (DragGestureDetectorKt.m594isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv.getCurrentEvent(), pointerId$iv)) {
                        drag = null;
                        if (drag != null || drag.isConsumed()) {
                            if (drag != null) {
                                c00921.$onDragStart.invoke(Offset.m1749boximpl(drag.getPosition()));
                                c00921.$onDrag.invoke(drag, Offset.m1749boximpl(overSlop.element));
                                long id = drag.getId();
                                final Function2<PointerInputChange, Offset, Unit> function2 = c00921.$onDrag;
                                c00921.L$0 = null;
                                c00921.L$1 = null;
                                c00921.L$2 = null;
                                c00921.L$3 = null;
                                c00921.L$4 = null;
                                c00921.L$5 = null;
                                c00921.L$6 = null;
                                c00921.label = 4;
                                Object m592dragjO51t88 = DragGestureDetectorKt.m592dragjO51t88($this$awaitPointerEventScope, id, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.5.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange) {
                                        invoke2(pointerInputChange);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(PointerInputChange it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        function2.invoke(it, Offset.m1749boximpl(PointerEventKt.positionChange(it)));
                                        it.consume();
                                    }
                                }, c00921);
                                if (m592dragjO51t88 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                c009212 = c00921;
                                $result5 = m592dragjO51t88;
                                if (((Boolean) $result5).booleanValue()) {
                                    c009212.$onDragCancel.invoke();
                                } else {
                                    c009212.$onDragEnd.invoke();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerEventScope;
                        pointerId$iv = down.getId();
                        int pointerType$iv2 = down.getType();
                        i2 = 0;
                        pointerDirectionConfig$iv = DragGestureDetectorKt.getHorizontalPointerDirectionConfig();
                        i3 = 0;
                        if (DragGestureDetectorKt.m594isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv.getCurrentEvent(), pointerId$iv)) {
                            touchSlop$iv2 = DragGestureDetectorKt.m595pointerSlopE8SPZFQ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv.getViewConfiguration(), pointerType$iv2);
                            pointer$iv = new Ref.LongRef();
                            pointer$iv.element = pointerId$iv;
                            totalMainPositionChange$iv = 0.0f;
                            touchSlop$iv = 0.0f;
                            c00921.L$0 = $this$awaitPointerEventScope;
                            c00921.L$1 = down;
                            c00921.L$2 = overSlop;
                            c00921.L$3 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                            c00921.L$4 = pointerDirectionConfig$iv;
                            c00921.L$5 = pointer$iv;
                            c00921.L$6 = null;
                            c00921.I$0 = i2;
                            c00921.F$0 = touchSlop$iv2;
                            c00921.F$1 = totalMainPositionChange$iv;
                            c00921.F$2 = touchSlop$iv;
                            PointerInputChange down3 = down;
                            c00921.label = 2;
                            obj = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, null, c00921, 1, null);
                            if (obj != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            i = i3;
                            down2 = down3;
                            PointerEvent event$iv = (PointerEvent) obj;
                            List $this$fastFirstOrNull$iv$iv = event$iv.getChanges();
                            $this$fastForEach$iv$iv$iv = $this$fastFirstOrNull$iv$iv;
                            size = $this$fastForEach$iv$iv$iv.size();
                            int i6 = i;
                            index$iv$iv$iv = 0;
                            while (true) {
                                if (index$iv$iv$iv >= size) {
                                    i5 = size;
                                    $this$fastForEach$iv$iv$iv2 = $this$fastForEach$iv$iv$iv;
                                    Object item$iv$iv$iv = $this$fastForEach$iv$iv$iv2.get(index$iv$iv$iv);
                                    PointerInputChange it$iv = (PointerInputChange) item$iv$iv$iv;
                                    $result4 = $result2;
                                    overSlop2 = overSlop;
                                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                                    if (PointerId.m3349equalsimpl0(it$iv.getId(), pointer$iv.element)) {
                                        obj2 = item$iv$iv$iv;
                                    } else {
                                        index$iv$iv$iv++;
                                        $result2 = $result4;
                                        size = i5;
                                        $this$fastForEach$iv$iv$iv = $this$fastForEach$iv$iv$iv2;
                                        overSlop = overSlop2;
                                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                    }
                                } else {
                                    $result4 = $result2;
                                    overSlop2 = overSlop;
                                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                                    obj2 = null;
                                }
                            }
                            drag = (PointerInputChange) obj2;
                            if (drag == null) {
                                $result2 = $result4;
                                down = down2;
                                overSlop = overSlop2;
                                drag = null;
                            } else if (drag.isConsumed()) {
                                $result2 = $result4;
                                down = down2;
                                overSlop = overSlop2;
                                drag = null;
                            } else if (PointerEventKt.changedToUpIgnoreConsumed(drag)) {
                                List $this$fastForEach$iv$iv$iv3 = event$iv.getChanges();
                                int index$iv$iv$iv2 = 0;
                                int size2 = $this$fastForEach$iv$iv$iv3.size();
                                while (true) {
                                    if (index$iv$iv$iv2 < size2) {
                                        Object item$iv$iv$iv2 = $this$fastForEach$iv$iv$iv3.get(index$iv$iv$iv2);
                                        PointerInputChange it$iv2 = (PointerInputChange) item$iv$iv$iv2;
                                        if (it$iv2.getPressed()) {
                                            obj3 = item$iv$iv$iv2;
                                        } else {
                                            index$iv$iv$iv2++;
                                        }
                                    } else {
                                        obj3 = null;
                                    }
                                }
                                PointerInputChange otherDown$iv = (PointerInputChange) obj3;
                                if (otherDown$iv == null) {
                                    $result2 = $result4;
                                    down = down2;
                                    overSlop = overSlop2;
                                    drag = null;
                                } else {
                                    pointer$iv.element = otherDown$iv.getId();
                                    $result2 = $result4;
                                    down = down2;
                                    i3 = i6;
                                    overSlop = overSlop2;
                                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                    c00921.L$0 = $this$awaitPointerEventScope;
                                    c00921.L$1 = down;
                                    c00921.L$2 = overSlop;
                                    c00921.L$3 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                                    c00921.L$4 = pointerDirectionConfig$iv;
                                    c00921.L$5 = pointer$iv;
                                    c00921.L$6 = null;
                                    c00921.I$0 = i2;
                                    c00921.F$0 = touchSlop$iv2;
                                    c00921.F$1 = totalMainPositionChange$iv;
                                    c00921.F$2 = touchSlop$iv;
                                    PointerInputChange down32 = down;
                                    c00921.label = 2;
                                    obj = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, null, c00921, 1, null);
                                    if (obj != coroutine_suspended) {
                                    }
                                }
                            } else {
                                long currentPosition$iv = drag.getPosition();
                                long previousPosition$iv = drag.getPreviousPosition();
                                float mainPositionChange$iv = pointerDirectionConfig$iv.mo598mainAxisDeltak4lQ0M(currentPosition$iv) - pointerDirectionConfig$iv.mo598mainAxisDeltak4lQ0M(previousPosition$iv);
                                float crossPositionChange$iv = pointerDirectionConfig$iv.mo597crossAxisDeltak4lQ0M(currentPosition$iv) - pointerDirectionConfig$iv.mo597crossAxisDeltak4lQ0M(previousPosition$iv);
                                totalMainPositionChange$iv += mainPositionChange$iv;
                                float totalCrossPositionChange$iv = touchSlop$iv + crossPositionChange$iv;
                                float inDirection$iv = i2 != 0 ? Math.abs(totalMainPositionChange$iv) : Offset.m1758getDistanceimpl(pointerDirectionConfig$iv.mo599offsetFromChangesdBAh8RU(totalMainPositionChange$iv, totalCrossPositionChange$iv));
                                if (inDirection$iv < touchSlop$iv2) {
                                    c00921.L$0 = $this$awaitPointerEventScope;
                                    c00921.L$1 = down2;
                                    overSlop = overSlop2;
                                    c00921.L$2 = overSlop;
                                    AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv3 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                    c00921.L$3 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv3;
                                    c00921.L$4 = pointerDirectionConfig$iv;
                                    c00921.L$5 = pointer$iv;
                                    c00921.L$6 = drag;
                                    c00921.I$0 = i2;
                                    c00921.F$0 = touchSlop$iv2;
                                    c00921.F$1 = totalMainPositionChange$iv;
                                    c00921.F$2 = totalCrossPositionChange$iv;
                                    c00921.label = 3;
                                    if ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv3.awaitPointerEvent(PointerEventPass.Final, c00921) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $result2 = $result4;
                                    down = down2;
                                    i3 = i6;
                                    int i7 = i2;
                                    dragEvent$iv = drag;
                                    i4 = i7;
                                    touchSlop$iv = totalCrossPositionChange$iv;
                                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv3;
                                    if (dragEvent$iv.isConsumed()) {
                                        i2 = i4;
                                        c00921.L$0 = $this$awaitPointerEventScope;
                                        c00921.L$1 = down;
                                        c00921.L$2 = overSlop;
                                        c00921.L$3 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                                        c00921.L$4 = pointerDirectionConfig$iv;
                                        c00921.L$5 = pointer$iv;
                                        c00921.L$6 = null;
                                        c00921.I$0 = i2;
                                        c00921.F$0 = touchSlop$iv2;
                                        c00921.F$1 = totalMainPositionChange$iv;
                                        c00921.F$2 = touchSlop$iv;
                                        PointerInputChange down322 = down;
                                        c00921.label = 2;
                                        obj = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, null, c00921, 1, null);
                                        if (obj != coroutine_suspended) {
                                        }
                                    } else {
                                        drag = null;
                                    }
                                } else {
                                    overSlop = overSlop2;
                                    AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv4 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                    if (i2 != 0) {
                                        float finalMainPositionChange$iv = totalMainPositionChange$iv - (Math.signum(totalMainPositionChange$iv) * touchSlop$iv2);
                                        touchSlopOffset$iv = pointerDirectionConfig$iv.mo599offsetFromChangesdBAh8RU(finalMainPositionChange$iv, totalCrossPositionChange$iv);
                                        $this$awaitPointerEventScope2 = $this$awaitPointerEventScope;
                                    } else {
                                        long offset$iv = pointerDirectionConfig$iv.mo599offsetFromChangesdBAh8RU(totalMainPositionChange$iv, totalCrossPositionChange$iv);
                                        $this$awaitPointerEventScope2 = $this$awaitPointerEventScope;
                                        long touchSlopOffset$iv2 = Offset.m1767timestuRUvjQ(Offset.m1755divtuRUvjQ(offset$iv, inDirection$iv), touchSlop$iv2);
                                        touchSlopOffset$iv = Offset.m1764minusMKHz9U(offset$iv, touchSlopOffset$iv2);
                                    }
                                    long over = touchSlopOffset$iv;
                                    drag.consume();
                                    overSlop.element = over;
                                    if (drag.isConsumed()) {
                                        $result2 = $result4;
                                        down = down2;
                                        $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                                    } else {
                                        totalMainPositionChange$iv = 0.0f;
                                        $result2 = $result4;
                                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv4;
                                        down = down2;
                                        $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                                        i3 = i6;
                                        touchSlop$iv = 0.0f;
                                        c00921.L$0 = $this$awaitPointerEventScope;
                                        c00921.L$1 = down;
                                        c00921.L$2 = overSlop;
                                        c00921.L$3 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                                        c00921.L$4 = pointerDirectionConfig$iv;
                                        c00921.L$5 = pointer$iv;
                                        c00921.L$6 = null;
                                        c00921.I$0 = i2;
                                        c00921.F$0 = touchSlop$iv2;
                                        c00921.F$1 = totalMainPositionChange$iv;
                                        c00921.F$2 = touchSlop$iv;
                                        PointerInputChange down3222 = down;
                                        c00921.label = 2;
                                        obj = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, null, c00921, 1, null);
                                        if (obj != coroutine_suspended) {
                                        }
                                    }
                                }
                            }
                            if (drag != null) {
                            }
                            if (drag != null) {
                            }
                            return Unit.INSTANCE;
                        }
                    }
                case 1:
                    c00921 = this;
                    $result3 = $result;
                    AwaitPointerEventScope $this$awaitPointerEventScope4 = (AwaitPointerEventScope) c00921.L$0;
                    ResultKt.throwOnFailure($result3);
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope4;
                    $result2 = $result3;
                    down = (PointerInputChange) $result3;
                    overSlop = new Ref.LongRef();
                    overSlop.element = Offset.INSTANCE.m1776getZeroF1C5BW0();
                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerEventScope;
                    pointerId$iv = down.getId();
                    int pointerType$iv22 = down.getType();
                    i2 = 0;
                    pointerDirectionConfig$iv = DragGestureDetectorKt.getHorizontalPointerDirectionConfig();
                    i3 = 0;
                    if (DragGestureDetectorKt.m594isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv.getCurrentEvent(), pointerId$iv)) {
                    }
                    break;
                case 2:
                    c00921 = this;
                    float totalCrossPositionChange$iv2 = c00921.F$2;
                    float totalMainPositionChange$iv2 = c00921.F$1;
                    float touchSlop$iv3 = c00921.F$0;
                    int i8 = c00921.I$0;
                    Ref.LongRef pointer$iv2 = (Ref.LongRef) c00921.L$5;
                    PointerDirectionConfig pointerDirectionConfig$iv2 = (PointerDirectionConfig) c00921.L$4;
                    AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv5 = (AwaitPointerEventScope) c00921.L$3;
                    Ref.LongRef overSlop3 = (Ref.LongRef) c00921.L$2;
                    down2 = (PointerInputChange) c00921.L$1;
                    AwaitPointerEventScope $this$awaitPointerEventScope5 = (AwaitPointerEventScope) c00921.L$0;
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    i = 0;
                    $result2 = obj;
                    touchSlop$iv = totalCrossPositionChange$iv2;
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope5;
                    pointer$iv = pointer$iv2;
                    totalMainPositionChange$iv = totalMainPositionChange$iv2;
                    overSlop = overSlop3;
                    pointerDirectionConfig$iv = pointerDirectionConfig$iv2;
                    touchSlop$iv2 = touchSlop$iv3;
                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv5;
                    i2 = i8;
                    PointerEvent event$iv2 = (PointerEvent) obj;
                    List $this$fastFirstOrNull$iv$iv2 = event$iv2.getChanges();
                    $this$fastForEach$iv$iv$iv = $this$fastFirstOrNull$iv$iv2;
                    size = $this$fastForEach$iv$iv$iv.size();
                    int i62 = i;
                    index$iv$iv$iv = 0;
                    while (true) {
                        if (index$iv$iv$iv >= size) {
                        }
                        index$iv$iv$iv++;
                        $result2 = $result4;
                        size = i5;
                        $this$fastForEach$iv$iv$iv = $this$fastForEach$iv$iv$iv2;
                        overSlop = overSlop2;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                    }
                    drag = (PointerInputChange) obj2;
                    if (drag == null) {
                    }
                    if (drag != null) {
                    }
                    if (drag != null) {
                    }
                    return Unit.INSTANCE;
                case 3:
                    c00921 = this;
                    float totalCrossPositionChange$iv3 = c00921.F$2;
                    totalMainPositionChange$iv = c00921.F$1;
                    float touchSlop$iv4 = c00921.F$0;
                    int i9 = c00921.I$0;
                    dragEvent$iv = (PointerInputChange) c00921.L$6;
                    Ref.LongRef pointer$iv3 = (Ref.LongRef) c00921.L$5;
                    PointerDirectionConfig pointerDirectionConfig$iv3 = (PointerDirectionConfig) c00921.L$4;
                    AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv6 = (AwaitPointerEventScope) c00921.L$3;
                    Ref.LongRef overSlop4 = (Ref.LongRef) c00921.L$2;
                    PointerInputChange down4 = (PointerInputChange) c00921.L$1;
                    AwaitPointerEventScope $this$awaitPointerEventScope6 = (AwaitPointerEventScope) c00921.L$0;
                    ResultKt.throwOnFailure($result);
                    i4 = i9;
                    touchSlop$iv2 = touchSlop$iv4;
                    touchSlop$iv = totalCrossPositionChange$iv3;
                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv6;
                    pointer$iv = pointer$iv3;
                    pointerDirectionConfig$iv = pointerDirectionConfig$iv3;
                    i3 = 0;
                    overSlop = overSlop4;
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope6;
                    down = down4;
                    $result2 = $result;
                    if (dragEvent$iv.isConsumed()) {
                    }
                    break;
                case 4:
                    c009212 = this;
                    $result5 = $result;
                    ResultKt.throwOnFailure($result5);
                    if (((Boolean) $result5).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$forEachGesture = (PointerInputScope) this.L$0;
                this.label = 1;
                if ($this$forEachGesture.awaitPointerEventScope(new C00921(this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, null), this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
