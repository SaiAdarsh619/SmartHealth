package androidx.compose.foundation.gestures;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerEventKt;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.runtime.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: Transformable.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.TransformableKt$detectZoom$3", m297f = "Transformable.kt", m298i = {}, m299l = {103}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes.dex */
final class TransformableKt$detectZoom$3 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $lockedToPanZoom;
    final /* synthetic */ Ref.LongRef $pan;
    final /* synthetic */ State<Boolean> $panZoomLock;
    final /* synthetic */ Ref.BooleanRef $pastTouchSlop;
    final /* synthetic */ Ref.FloatRef $rotation;
    final /* synthetic */ PointerInputScope $this_detectZoom;
    final /* synthetic */ float $touchSlop;
    final /* synthetic */ Ref.FloatRef $zoom;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransformableKt$detectZoom$3(PointerInputScope pointerInputScope, Ref.BooleanRef booleanRef, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.LongRef longRef, float f, Ref.BooleanRef booleanRef2, State<Boolean> state, Continuation<? super TransformableKt$detectZoom$3> continuation) {
        super(2, continuation);
        this.$this_detectZoom = pointerInputScope;
        this.$pastTouchSlop = booleanRef;
        this.$zoom = floatRef;
        this.$rotation = floatRef2;
        this.$pan = longRef;
        this.$touchSlop = f;
        this.$lockedToPanZoom = booleanRef2;
        this.$panZoomLock = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformableKt$detectZoom$3 transformableKt$detectZoom$3 = new TransformableKt$detectZoom$3(this.$this_detectZoom, this.$pastTouchSlop, this.$zoom, this.$rotation, this.$pan, this.$touchSlop, this.$lockedToPanZoom, this.$panZoomLock, continuation);
        transformableKt$detectZoom$3.L$0 = obj;
        return transformableKt$detectZoom$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
        return ((TransformableKt$detectZoom$3) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: Transformable.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.compose.foundation.gestures.TransformableKt$detectZoom$3$1", m297f = "Transformable.kt", m298i = {0}, m299l = {105}, m300m = "invokeSuspend", m301n = {"$this$awaitPointerEventScope"}, m302s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.TransformableKt$detectZoom$3$1 */
    static final class C01041 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TransformScope $$this$transform;
        final /* synthetic */ Ref.BooleanRef $lockedToPanZoom;
        final /* synthetic */ Ref.LongRef $pan;
        final /* synthetic */ State<Boolean> $panZoomLock;
        final /* synthetic */ Ref.BooleanRef $pastTouchSlop;
        final /* synthetic */ Ref.FloatRef $rotation;
        final /* synthetic */ float $touchSlop;
        final /* synthetic */ Ref.FloatRef $zoom;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01041(Ref.BooleanRef booleanRef, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.LongRef longRef, float f, Ref.BooleanRef booleanRef2, State<Boolean> state, TransformScope transformScope, Continuation<? super C01041> continuation) {
            super(2, continuation);
            this.$pastTouchSlop = booleanRef;
            this.$zoom = floatRef;
            this.$rotation = floatRef2;
            this.$pan = longRef;
            this.$touchSlop = f;
            this.$lockedToPanZoom = booleanRef2;
            this.$panZoomLock = state;
            this.$$this$transform = transformScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01041 c01041 = new C01041(this.$pastTouchSlop, this.$zoom, this.$rotation, this.$pan, this.$touchSlop, this.$lockedToPanZoom, this.$panZoomLock, this.$$this$transform, continuation);
            c01041.L$0 = obj;
            return c01041;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C01041) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x0132, code lost:
        
            if (androidx.compose.p000ui.geometry.Offset.m1757equalsimpl0(r10, androidx.compose.p000ui.geometry.Offset.INSTANCE.m1776getZeroF1C5BW0()) != false) goto L58;
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0160  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x003c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x015b  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x006d A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x003d -> B:7:0x0043). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            C01041 c01041;
            Object $result;
            Object $result2;
            AwaitPointerEventScope $this$awaitPointerEventScope;
            int index$iv$iv;
            int size;
            int i;
            int i2;
            PointerEvent event;
            int i3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = 1;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    c01041 = this;
                    Object $result3 = obj;
                    AwaitPointerEventScope $this$awaitPointerEventScope2 = (AwaitPointerEventScope) c01041.L$0;
                    c01041.L$0 = $this$awaitPointerEventScope2;
                    c01041.label = i4;
                    Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerEventScope2, null, c01041, i4, null);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    AwaitPointerEventScope awaitPointerEventScope = $this$awaitPointerEventScope2;
                    $result = $result3;
                    $result2 = awaitPointerEvent$default;
                    $this$awaitPointerEventScope = awaitPointerEventScope;
                    PointerEvent event2 = (PointerEvent) $result2;
                    List $this$fastForEach$iv$iv = event2.getChanges();
                    index$iv$iv = 0;
                    size = $this$fastForEach$iv$iv.size();
                    while (true) {
                        i = 0;
                        if (index$iv$iv >= size) {
                            Object item$iv$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
                            if (((PointerInputChange) item$iv$iv).isConsumed()) {
                                i2 = i4;
                            } else {
                                index$iv$iv++;
                            }
                        } else {
                            i2 = 0;
                        }
                    }
                    if (i2 != 0) {
                        float zoomChange = TransformGestureDetectorKt.calculateZoom(event2);
                        float rotationChange = TransformGestureDetectorKt.calculateRotation(event2);
                        long panChange = TransformGestureDetectorKt.calculatePan(event2);
                        if (c01041.$pastTouchSlop.element) {
                            event = event2;
                            i3 = i4;
                        } else {
                            c01041.$zoom.element *= zoomChange;
                            c01041.$rotation.element += rotationChange;
                            c01041.$pan.element = Offset.m1765plusMKHz9U(c01041.$pan.element, panChange);
                            float centroidSize = TransformGestureDetectorKt.calculateCentroidSize(event2, false);
                            float zoomMotion = Math.abs(i4 - c01041.$zoom.element) * centroidSize;
                            float rotationMotion = Math.abs(((c01041.$rotation.element * 3.1415927f) * centroidSize) / 180.0f);
                            event = event2;
                            float panMotion = Offset.m1758getDistanceimpl(c01041.$pan.element);
                            if (zoomMotion > c01041.$touchSlop || rotationMotion > c01041.$touchSlop || panMotion > c01041.$touchSlop) {
                                i3 = 1;
                                c01041.$pastTouchSlop.element = true;
                                c01041.$lockedToPanZoom.element = c01041.$panZoomLock.getValue().booleanValue() && rotationMotion < c01041.$touchSlop;
                            } else {
                                i3 = 1;
                            }
                        }
                        if (c01041.$pastTouchSlop.element) {
                            if (c01041.$lockedToPanZoom.element) {
                                rotationChange = 0.0f;
                            }
                            float effectiveRotation = rotationChange;
                            if ((effectiveRotation == 0.0f ? i3 : 0) != 0) {
                                if ((zoomChange == 1.0f ? i3 : 0) != 0) {
                                    break;
                                }
                            }
                            c01041.$$this$transform.mo573transformByd4ec7I(zoomChange, panChange, effectiveRotation);
                            List $this$fastForEach$iv = event.getChanges();
                            int size2 = $this$fastForEach$iv.size();
                            for (int index$iv = 0; index$iv < size2; index$iv++) {
                                Object item$iv = $this$fastForEach$iv.get(index$iv);
                                PointerInputChange it = (PointerInputChange) item$iv;
                                if (PointerEventKt.positionChanged(it)) {
                                    it.consume();
                                }
                            }
                        }
                    } else {
                        event = event2;
                        i3 = i4;
                    }
                    if (i2 == 0) {
                        List $this$fastForEach$iv$iv2 = event.getChanges();
                        int index$iv$iv2 = 0;
                        int size3 = $this$fastForEach$iv$iv2.size();
                        while (true) {
                            if (index$iv$iv2 < size3) {
                                Object item$iv$iv2 = $this$fastForEach$iv$iv2.get(index$iv$iv2);
                                if (((PointerInputChange) item$iv$iv2).getPressed()) {
                                    i = i3;
                                } else {
                                    index$iv$iv2++;
                                }
                            }
                        }
                        if (i != 0) {
                            i4 = i3;
                            $result3 = $result;
                            $this$awaitPointerEventScope2 = $this$awaitPointerEventScope;
                            c01041.L$0 = $this$awaitPointerEventScope2;
                            c01041.label = i4;
                            Object awaitPointerEvent$default2 = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerEventScope2, null, c01041, i4, null);
                            if (awaitPointerEvent$default2 != coroutine_suspended) {
                            }
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    c01041 = this;
                    $result2 = obj;
                    AwaitPointerEventScope $this$awaitPointerEventScope3 = (AwaitPointerEventScope) c01041.L$0;
                    ResultKt.throwOnFailure($result2);
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope3;
                    $result = $result2;
                    PointerEvent event22 = (PointerEvent) $result2;
                    List $this$fastForEach$iv$iv3 = event22.getChanges();
                    index$iv$iv = 0;
                    size = $this$fastForEach$iv$iv3.size();
                    while (true) {
                        i = 0;
                        if (index$iv$iv >= size) {
                        }
                        index$iv$iv++;
                    }
                    if (i2 != 0) {
                    }
                    if (i2 == 0) {
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
                TransformScope $this$transform = (TransformScope) this.L$0;
                this.label = 1;
                if (this.$this_detectZoom.awaitPointerEventScope(new C01041(this.$pastTouchSlop, this.$zoom, this.$rotation, this.$pan, this.$touchSlop, this.$lockedToPanZoom, this.$panZoomLock, $this$transform, null), this) != coroutine_suspended) {
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
