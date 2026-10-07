package androidx.compose.foundation.gestures;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEventKt;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5", m297f = "DragGestureDetector.kt", m298i = {}, m299l = {545}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes.dex */
final class DragGestureDetectorKt$detectHorizontalDragGestures$5 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function0<Unit> $onDragEnd;
    final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    final /* synthetic */ Function2<PointerInputChange, Float, Unit> $onHorizontalDrag;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DragGestureDetectorKt$detectHorizontalDragGestures$5(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super DragGestureDetectorKt$detectHorizontalDragGestures$5> continuation) {
        super(2, continuation);
        this.$onDragStart = function1;
        this.$onHorizontalDrag = function2;
        this.$onDragEnd = function0;
        this.$onDragCancel = function02;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectHorizontalDragGestures$5 dragGestureDetectorKt$detectHorizontalDragGestures$5 = new DragGestureDetectorKt$detectHorizontalDragGestures$5(this.$onDragStart, this.$onHorizontalDrag, this.$onDragEnd, this.$onDragCancel, continuation);
        dragGestureDetectorKt$detectHorizontalDragGestures$5.L$0 = obj;
        return dragGestureDetectorKt$detectHorizontalDragGestures$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectHorizontalDragGestures$5) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: DragGestureDetector.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1", m297f = "DragGestureDetector.kt", m298i = {0, 1, 1}, m299l = {546, 548, 559}, m300m = "invokeSuspend", m301n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "overSlop"}, m302s = {"L$0", "L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1 */
    static final class C00941 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        final /* synthetic */ Function2<PointerInputChange, Float, Unit> $onHorizontalDrag;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C00941(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super C00941> continuation) {
            super(2, continuation);
            this.$onDragStart = function1;
            this.$onHorizontalDrag = function2;
            this.$onDragEnd = function0;
            this.$onDragCancel = function02;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00941 c00941 = new C00941(this.$onDragStart, this.$onHorizontalDrag, this.$onDragEnd, this.$onDragCancel, continuation);
            c00941.L$0 = obj;
            return c00941;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C00941) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x007b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x00c2  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            AwaitPointerEventScope $this$awaitPointerEventScope;
            C00941 c00941;
            final Ref.FloatRef overSlop;
            AwaitPointerEventScope $this$awaitPointerEventScope2;
            PointerInputChange drag;
            C00941 c009412;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    AwaitPointerEventScope $this$awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                    this.L$0 = $this$awaitPointerEventScope3;
                    this.label = 1;
                    Object awaitFirstDown = TapGestureDetectorKt.awaitFirstDown($this$awaitPointerEventScope3, false, this);
                    if (awaitFirstDown == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope3;
                    c00941 = this;
                    $result = awaitFirstDown;
                    PointerInputChange down = (PointerInputChange) $result;
                    overSlop = new Ref.FloatRef();
                    c00941.L$0 = $this$awaitPointerEventScope;
                    c00941.L$1 = overSlop;
                    c00941.label = 2;
                    $result = DragGestureDetectorKt.m581awaitHorizontalPointerSlopOrCancellationgDDlDlE($this$awaitPointerEventScope, down.getId(), down.getType(), new Function2<PointerInputChange, Float, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1$drag$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Float f) {
                            invoke(pointerInputChange, f.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PointerInputChange change, float over) {
                            Intrinsics.checkNotNullParameter(change, "change");
                            change.consume();
                            Ref.FloatRef.this.element = over;
                        }
                    }, c00941);
                    if ($result != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$awaitPointerEventScope2 = $this$awaitPointerEventScope;
                    drag = (PointerInputChange) $result;
                    if (drag != null) {
                        c00941.$onDragStart.invoke(Offset.m1749boximpl(drag.getPosition()));
                        c00941.$onHorizontalDrag.invoke(drag, Boxing.boxFloat(overSlop.element));
                        long id = drag.getId();
                        final Function2<PointerInputChange, Float, Unit> function2 = c00941.$onHorizontalDrag;
                        c00941.L$0 = null;
                        c00941.L$1 = null;
                        c00941.label = 3;
                        $result = DragGestureDetectorKt.m593horizontalDragjO51t88($this$awaitPointerEventScope2, id, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectHorizontalDragGestures.5.1.1
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
                                function2.invoke(it, Float.valueOf(Offset.m1760getXimpl(PointerEventKt.positionChange(it))));
                                it.consume();
                            }
                        }, c00941);
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c009412 = c00941;
                        if (((Boolean) $result).booleanValue()) {
                            c009412.$onDragCancel.invoke();
                        } else {
                            c009412.$onDragEnd.invoke();
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    AwaitPointerEventScope $this$awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope4;
                    c00941 = this;
                    PointerInputChange down2 = (PointerInputChange) $result;
                    overSlop = new Ref.FloatRef();
                    c00941.L$0 = $this$awaitPointerEventScope;
                    c00941.L$1 = overSlop;
                    c00941.label = 2;
                    $result = DragGestureDetectorKt.m581awaitHorizontalPointerSlopOrCancellationgDDlDlE($this$awaitPointerEventScope, down2.getId(), down2.getType(), new Function2<PointerInputChange, Float, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1$drag$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Float f) {
                            invoke(pointerInputChange, f.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PointerInputChange change, float over) {
                            Intrinsics.checkNotNullParameter(change, "change");
                            change.consume();
                            Ref.FloatRef.this.element = over;
                        }
                    }, c00941);
                    if ($result != coroutine_suspended) {
                    }
                    break;
                case 2:
                    Ref.FloatRef overSlop2 = (Ref.FloatRef) this.L$1;
                    $this$awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    overSlop = overSlop2;
                    c00941 = this;
                    drag = (PointerInputChange) $result;
                    if (drag != null) {
                    }
                    return Unit.INSTANCE;
                case 3:
                    c009412 = this;
                    ResultKt.throwOnFailure($result);
                    if (((Boolean) $result).booleanValue()) {
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
                if ($this$forEachGesture.awaitPointerEventScope(new C00941(this.$onDragStart, this.$onHorizontalDrag, this.$onDragEnd, this.$onDragCancel, null), this) != coroutine_suspended) {
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
