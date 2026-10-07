package androidx.compose.foundation.gestures;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEventKt;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import java.util.List;
import java.util.concurrent.CancellationException;
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

/* compiled from: DragGestureDetector.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5", m297f = "DragGestureDetector.kt", m298i = {}, m299l = {237}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes.dex */
final class DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function0<Unit> $onDragEnd;
    final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(Function0<Unit> function0, Function1<? super Offset, Unit> function1, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super DragGestureDetectorKt$detectDragGesturesAfterLongPress$5> continuation) {
        super(2, continuation);
        this.$onDragCancel = function0;
        this.$onDragStart = function1;
        this.$onDragEnd = function02;
        this.$onDrag = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 dragGestureDetectorKt$detectDragGesturesAfterLongPress$5 = new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(this.$onDragCancel, this.$onDragStart, this.$onDragEnd, this.$onDrag, continuation);
        dragGestureDetectorKt$detectDragGesturesAfterLongPress$5.L$0 = obj;
        return dragGestureDetectorKt$detectDragGesturesAfterLongPress$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGesturesAfterLongPress$5) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        CancellationException c;
        DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 dragGestureDetectorKt$detectDragGesturesAfterLongPress$5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$forEachGesture = (PointerInputScope) this.L$0;
                try {
                    this.label = 1;
                    return $this$forEachGesture.awaitPointerEventScope(new C00931(this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$onDrag, null), this) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                } catch (CancellationException e) {
                    c = e;
                    dragGestureDetectorKt$detectDragGesturesAfterLongPress$5 = this;
                    dragGestureDetectorKt$detectDragGesturesAfterLongPress$5.$onDragCancel.invoke();
                    throw c;
                }
            case 1:
                dragGestureDetectorKt$detectDragGesturesAfterLongPress$5 = this;
                try {
                    ResultKt.throwOnFailure($result);
                } catch (CancellationException e2) {
                    c = e2;
                    dragGestureDetectorKt$detectDragGesturesAfterLongPress$5.$onDragCancel.invoke();
                    throw c;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: DragGestureDetector.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1", m297f = "DragGestureDetector.kt", m298i = {0, 1, 2}, m299l = {238, 239, 244}, m300m = "invokeSuspend", m301n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, m302s = {"L$0", "L$0", "L$0"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1 */
    static final class C00931 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C00931(Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super C00931> continuation) {
            super(2, continuation);
            this.$onDragStart = function1;
            this.$onDragEnd = function0;
            this.$onDragCancel = function02;
            this.$onDrag = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00931 c00931 = new C00931(this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$onDrag, continuation);
            c00931.L$0 = obj;
            return c00931;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C00931) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00cb  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0067 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x009f  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            AwaitPointerEventScope $this$awaitPointerEventScope;
            C00931 c00931;
            PointerInputChange drag;
            C00931 c009312;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    AwaitPointerEventScope $this$awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                    this.L$0 = $this$awaitPointerEventScope2;
                    this.label = 1;
                    Object awaitFirstDown = TapGestureDetectorKt.awaitFirstDown($this$awaitPointerEventScope2, false, this);
                    if (awaitFirstDown == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = awaitFirstDown;
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                    c00931 = this;
                    PointerInputChange down = (PointerInputChange) $result;
                    c00931.L$0 = $this$awaitPointerEventScope;
                    c00931.label = 2;
                    $result = DragGestureDetectorKt.m583awaitLongPressOrCancellationrnUCldI($this$awaitPointerEventScope, down.getId(), c00931);
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    drag = (PointerInputChange) $result;
                    if (drag != null) {
                        c00931.$onDragStart.invoke(Offset.m1749boximpl(drag.getPosition()));
                        long id = drag.getId();
                        final Function2<PointerInputChange, Offset, Unit> function2 = c00931.$onDrag;
                        c00931.L$0 = $this$awaitPointerEventScope;
                        c00931.label = 3;
                        $result = DragGestureDetectorKt.m592dragjO51t88($this$awaitPointerEventScope, id, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGesturesAfterLongPress.5.1.1
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
                        }, c00931);
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c009312 = c00931;
                        if (((Boolean) $result).booleanValue()) {
                            c009312.$onDragCancel.invoke();
                        } else {
                            List $this$fastForEach$iv = $this$awaitPointerEventScope.getCurrentEvent().getChanges();
                            int size = $this$fastForEach$iv.size();
                            for (int index$iv = 0; index$iv < size; index$iv++) {
                                Object item$iv = $this$fastForEach$iv.get(index$iv);
                                PointerInputChange it = (PointerInputChange) item$iv;
                                if (PointerEventKt.changedToUp(it)) {
                                    it.consume();
                                }
                            }
                            c009312.$onDragEnd.invoke();
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    AwaitPointerEventScope $this$awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope3;
                    c00931 = this;
                    PointerInputChange down2 = (PointerInputChange) $result;
                    c00931.L$0 = $this$awaitPointerEventScope;
                    c00931.label = 2;
                    $result = DragGestureDetectorKt.m583awaitLongPressOrCancellationrnUCldI($this$awaitPointerEventScope, down2.getId(), c00931);
                    if ($result == coroutine_suspended) {
                    }
                    drag = (PointerInputChange) $result;
                    if (drag != null) {
                    }
                    return Unit.INSTANCE;
                case 2:
                    AwaitPointerEventScope $this$awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope4;
                    c00931 = this;
                    drag = (PointerInputChange) $result;
                    if (drag != null) {
                    }
                    return Unit.INSTANCE;
                case 3:
                    c009312 = this;
                    AwaitPointerEventScope $this$awaitPointerEventScope5 = (AwaitPointerEventScope) c009312.L$0;
                    ResultKt.throwOnFailure($result);
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope5;
                    if (((Boolean) $result).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
