package androidx.compose.foundation.gestures;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerEventKt;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* compiled from: TransformGestureDetector.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2", m297f = "TransformGestureDetector.kt", m298i = {}, m299l = {52}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes.dex */
final class TransformGestureDetectorKt$detectTransformGestures$2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function4<Offset, Offset, Float, Float, Unit> $onGesture;
    final /* synthetic */ boolean $panZoomLock;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TransformGestureDetectorKt$detectTransformGestures$2(boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super TransformGestureDetectorKt$detectTransformGestures$2> continuation) {
        super(2, continuation);
        this.$panZoomLock = z;
        this.$onGesture = function4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformGestureDetectorKt$detectTransformGestures$2 transformGestureDetectorKt$detectTransformGestures$2 = new TransformGestureDetectorKt$detectTransformGestures$2(this.$panZoomLock, this.$onGesture, continuation);
        transformGestureDetectorKt$detectTransformGestures$2.L$0 = obj;
        return transformGestureDetectorKt$detectTransformGestures$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((TransformGestureDetectorKt$detectTransformGestures$2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: TransformGestureDetector.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2$1", m297f = "TransformGestureDetector.kt", m298i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m299l = {60, 62}, m300m = "invokeSuspend", m301n = {"$this$awaitPointerEventScope", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$awaitPointerEventScope", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom"}, m302s = {"L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1"})
    /* renamed from: androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2$1 */
    static final class C01031 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function4<Offset, Offset, Float, Float, Unit> $onGesture;
        final /* synthetic */ boolean $panZoomLock;
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01031(boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super C01031> continuation) {
            super(2, continuation);
            this.$panZoomLock = z;
            this.$onGesture = function4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01031 c01031 = new C01031(this.$panZoomLock, this.$onGesture, continuation);
            c01031.L$0 = obj;
            return c01031;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C01031) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x01a5  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x01cf  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x00a4 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x01c3  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x00e1 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x00c8  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00a5 -> B:7:0x00b1). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            C01031 c01031;
            Object $result;
            AwaitPointerEventScope $this$awaitPointerEventScope;
            float zoom;
            float zoom2;
            long pan;
            int i;
            float touchSlop;
            int i2;
            Object awaitPointerEvent$default;
            Object $result2;
            Object $result3;
            AwaitPointerEventScope $this$awaitPointerEventScope2;
            float rotation;
            float rotation2;
            long pan2;
            int i3;
            float touchSlop2;
            int i4;
            int size;
            int index$iv$iv;
            boolean canceled;
            Object obj2;
            C01031 c010312;
            Object $result4;
            boolean z;
            int i5;
            int index$iv;
            int size2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i6 = 1;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    c01031 = this;
                    $result = obj;
                    $this$awaitPointerEventScope = (AwaitPointerEventScope) c01031.L$0;
                    zoom = 0.0f;
                    zoom2 = 1.0f;
                    pan = Offset.INSTANCE.m1776getZeroF1C5BW0();
                    i = 0;
                    touchSlop = $this$awaitPointerEventScope.getViewConfiguration().getTouchSlop();
                    i2 = 0;
                    c01031.L$0 = $this$awaitPointerEventScope;
                    c01031.F$0 = 0.0f;
                    c01031.F$1 = 1.0f;
                    c01031.J$0 = pan;
                    c01031.I$0 = 0;
                    c01031.F$2 = touchSlop;
                    c01031.I$1 = 0;
                    c01031.label = 1;
                    if (TapGestureDetectorKt.awaitFirstDown($this$awaitPointerEventScope, false, c01031) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c01031.L$0 = $this$awaitPointerEventScope;
                    c01031.F$0 = zoom;
                    c01031.F$1 = zoom2;
                    c01031.J$0 = pan;
                    c01031.I$0 = i;
                    c01031.F$2 = touchSlop;
                    c01031.I$1 = i2;
                    c01031.label = 2;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerEventScope, null, c01031, i6, null);
                    if (awaitPointerEvent$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i7 = i2;
                    $result2 = $result;
                    $result3 = awaitPointerEvent$default;
                    $this$awaitPointerEventScope2 = $this$awaitPointerEventScope;
                    rotation = zoom;
                    rotation2 = zoom2;
                    pan2 = pan;
                    i3 = i;
                    touchSlop2 = touchSlop;
                    i4 = i7;
                    PointerEvent event = (PointerEvent) $result3;
                    List $this$fastForEach$iv$iv = event.getChanges();
                    size = $this$fastForEach$iv$iv.size();
                    index$iv$iv = 0;
                    while (true) {
                        if (index$iv$iv >= size) {
                            Object item$iv$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
                            if (((PointerInputChange) item$iv$iv).isConsumed()) {
                                canceled = true;
                            } else {
                                index$iv$iv++;
                            }
                        } else {
                            canceled = false;
                        }
                    }
                    if (canceled) {
                        float zoomChange = TransformGestureDetectorKt.calculateZoom(event);
                        float rotationChange = TransformGestureDetectorKt.calculateRotation(event);
                        obj2 = coroutine_suspended;
                        long panChange = TransformGestureDetectorKt.calculatePan(event);
                        if (i3 == 0) {
                            rotation2 *= zoomChange;
                            rotation += rotationChange;
                            pan2 = Offset.m1765plusMKHz9U(pan2, panChange);
                            $result4 = $result2;
                            float centroidSize = TransformGestureDetectorKt.calculateCentroidSize(event, false);
                            int i8 = i4;
                            float zoomMotion = Math.abs(1 - rotation2) * centroidSize;
                            float rotationMotion = Math.abs(((3.1415927f * rotation) * centroidSize) / 180.0f);
                            float panMotion = Offset.m1758getDistanceimpl(pan2);
                            if (zoomMotion > touchSlop2 || rotationMotion > touchSlop2 || panMotion > touchSlop2) {
                                i3 = 1;
                                i4 = (!c01031.$panZoomLock || rotationMotion >= touchSlop2) ? 0 : 1;
                            } else {
                                i4 = i8;
                            }
                        } else {
                            $result4 = $result2;
                        }
                        if (i3 != 0) {
                            long centroid = TransformGestureDetectorKt.calculateCentroid(event, false);
                            if (i4 != 0) {
                                rotationChange = 0.0f;
                            }
                            if (!(rotationChange == 0.0f)) {
                                i5 = i4;
                            } else if (zoomChange == 1.0f) {
                                i5 = i4;
                                if (Offset.m1757equalsimpl0(panChange, Offset.INSTANCE.m1776getZeroF1C5BW0())) {
                                    c010312 = c01031;
                                    List $this$fastForEach$iv = event.getChanges();
                                    size2 = $this$fastForEach$iv.size();
                                    for (index$iv = 0; index$iv < size2; index$iv++) {
                                        Object item$iv = $this$fastForEach$iv.get(index$iv);
                                        PointerInputChange it = (PointerInputChange) item$iv;
                                        if (PointerEventKt.positionChanged(it)) {
                                            it.consume();
                                        }
                                    }
                                }
                            } else {
                                i5 = i4;
                            }
                            c010312 = c01031;
                            c01031.$onGesture.invoke(Offset.m1749boximpl(centroid), Offset.m1749boximpl(panChange), Boxing.boxFloat(zoomChange), Boxing.boxFloat(rotationChange));
                            List $this$fastForEach$iv2 = event.getChanges();
                            size2 = $this$fastForEach$iv2.size();
                            while (index$iv < size2) {
                            }
                        } else {
                            c010312 = c01031;
                            i5 = i4;
                        }
                        i2 = i5;
                    } else {
                        obj2 = coroutine_suspended;
                        c010312 = c01031;
                        $result4 = $result2;
                        i2 = i4;
                    }
                    if (!canceled) {
                        List $this$fastForEach$iv$iv2 = event.getChanges();
                        int index$iv$iv2 = 0;
                        int size3 = $this$fastForEach$iv$iv2.size();
                        while (true) {
                            if (index$iv$iv2 < size3) {
                                Object item$iv$iv2 = $this$fastForEach$iv$iv2.get(index$iv$iv2);
                                if (((PointerInputChange) item$iv$iv2).getPressed()) {
                                    z = true;
                                } else {
                                    index$iv$iv2++;
                                }
                            } else {
                                z = false;
                            }
                        }
                        if (z) {
                            coroutine_suspended = obj2;
                            touchSlop = touchSlop2;
                            i = i3;
                            pan = pan2;
                            zoom2 = rotation2;
                            zoom = rotation;
                            $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                            $result = $result4;
                            c01031 = c010312;
                            i6 = 1;
                            c01031.L$0 = $this$awaitPointerEventScope;
                            c01031.F$0 = zoom;
                            c01031.F$1 = zoom2;
                            c01031.J$0 = pan;
                            c01031.I$0 = i;
                            c01031.F$2 = touchSlop;
                            c01031.I$1 = i2;
                            c01031.label = 2;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerEventScope, null, c01031, i6, null);
                            if (awaitPointerEvent$default == coroutine_suspended) {
                            }
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    c01031 = this;
                    $result = obj;
                    i2 = c01031.I$1;
                    touchSlop = c01031.F$2;
                    i = c01031.I$0;
                    pan = c01031.J$0;
                    zoom2 = c01031.F$1;
                    zoom = c01031.F$0;
                    $this$awaitPointerEventScope = (AwaitPointerEventScope) c01031.L$0;
                    ResultKt.throwOnFailure($result);
                    c01031.L$0 = $this$awaitPointerEventScope;
                    c01031.F$0 = zoom;
                    c01031.F$1 = zoom2;
                    c01031.J$0 = pan;
                    c01031.I$0 = i;
                    c01031.F$2 = touchSlop;
                    c01031.I$1 = i2;
                    c01031.label = 2;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerEventScope, null, c01031, i6, null);
                    if (awaitPointerEvent$default == coroutine_suspended) {
                    }
                    break;
                case 2:
                    c01031 = this;
                    $result3 = obj;
                    int i9 = c01031.I$1;
                    float touchSlop3 = c01031.F$2;
                    int i10 = c01031.I$0;
                    long pan3 = c01031.J$0;
                    float zoom3 = c01031.F$1;
                    float rotation3 = c01031.F$0;
                    AwaitPointerEventScope $this$awaitPointerEventScope3 = (AwaitPointerEventScope) c01031.L$0;
                    ResultKt.throwOnFailure($result3);
                    $this$awaitPointerEventScope2 = $this$awaitPointerEventScope3;
                    rotation = rotation3;
                    rotation2 = zoom3;
                    pan2 = pan3;
                    i3 = i10;
                    touchSlop2 = touchSlop3;
                    i4 = i9;
                    $result2 = $result3;
                    PointerEvent event2 = (PointerEvent) $result3;
                    List $this$fastForEach$iv$iv3 = event2.getChanges();
                    size = $this$fastForEach$iv$iv3.size();
                    index$iv$iv = 0;
                    while (true) {
                        if (index$iv$iv >= size) {
                        }
                        index$iv$iv++;
                    }
                    if (canceled) {
                    }
                    if (!canceled) {
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
                if ($this$forEachGesture.awaitPointerEventScope(new C01031(this.$panZoomLock, this.$onGesture, null), this) != coroutine_suspended) {
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
