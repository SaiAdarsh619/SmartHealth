package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerEventKt;
import androidx.compose.p000ui.input.pointer.PointerEventPass;
import androidx.compose.p000ui.input.pointer.PointerId;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: Transformable.kt */
@Metadata(m286d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a1\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\tH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a&\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, m287d2 = {"awaitTwoDowns", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "requireUnconsumed", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectZoom", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "panZoomLock", "Landroidx/compose/runtime/State;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformable", "Landroidx/compose/ui/Modifier;", "lockRotationOnZoomPan", "enabled", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TransformableKt {
    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, z, z2);
    }

    public static final Modifier transformable(Modifier $this$transformable, final TransformableState state, final boolean lockRotationOnZoomPan, final boolean enabled) {
        Intrinsics.checkNotNullParameter($this$transformable, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        return ComposedModifierKt.composed($this$transformable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.gestures.TransformableKt$transformable$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("transformable");
                $this$null.getProperties().set("state", TransformableState.this);
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
                $this$null.getProperties().set("lockRotationOnZoomPan", Boolean.valueOf(lockRotationOnZoomPan));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.gestures.TransformableKt$transformable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                TransformableKt$transformable$2$block$1$1 value$iv$iv;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(1509335853);
                ComposerKt.sourceInformation($composer, "C66@3002L27,67@3062L43,68@3164L163:Transformable.kt#8bwon0");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1509335853, $changed, -1, "androidx.compose.foundation.gestures.transformable.<anonymous> (Transformable.kt:65)");
                }
                State updatedState = SnapshotStateKt.rememberUpdatedState(TransformableState.this, $composer, 0);
                State updatePanZoomLock = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(lockRotationOnZoomPan), $composer, 0);
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv = $composer.rememberedValue();
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = new TransformableKt$transformable$2$block$1$1(updatePanZoomLock, updatedState, null);
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                Function2 block = (Function2) value$iv$iv;
                Modifier.Companion pointerInput = enabled ? SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, Unit.INSTANCE, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) block) : Modifier.INSTANCE;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return pointerInput;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:0|1|(2:3|(4:5|6|7|8))|25|6|7|8) */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031 A[Catch: CancellationException -> 0x0036, TRY_ENTER, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x0036, blocks: (B:12:0x0031, B:18:0x00bd), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00fe A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object detectZoom(PointerInputScope pointerInputScope, State<Boolean> state, State<? extends TransformableState> state2, Continuation<? super Unit> continuation) {
        TransformableKt$detectZoom$1 transformableKt$detectZoom$1;
        PointerInputScope $this$detectZoom;
        State state3;
        State panZoomLock;
        Ref.FloatRef rotation;
        Ref.FloatRef zoom;
        Ref.LongRef pan;
        Ref.BooleanRef pastTouchSlop;
        float touchSlop;
        Ref.BooleanRef lockedToPanZoom;
        TransformableState value;
        MutatePriority mutatePriority;
        TransformableKt$detectZoom$3 transformableKt$detectZoom$3;
        if (continuation instanceof TransformableKt$detectZoom$1) {
            transformableKt$detectZoom$1 = (TransformableKt$detectZoom$1) continuation;
            if ((transformableKt$detectZoom$1.label & Integer.MIN_VALUE) != 0) {
                transformableKt$detectZoom$1.label -= Integer.MIN_VALUE;
                Object $result = transformableKt$detectZoom$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (transformableKt$detectZoom$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$detectZoom = pointerInputScope;
                        state3 = state2;
                        panZoomLock = state;
                        rotation = new Ref.FloatRef();
                        zoom = new Ref.FloatRef();
                        zoom.element = 1.0f;
                        pan = new Ref.LongRef();
                        pan.element = Offset.INSTANCE.m1776getZeroF1C5BW0();
                        pastTouchSlop = new Ref.BooleanRef();
                        touchSlop = $this$detectZoom.getViewConfiguration().getTouchSlop();
                        lockedToPanZoom = new Ref.BooleanRef();
                        TransformableKt$detectZoom$2 transformableKt$detectZoom$2 = new TransformableKt$detectZoom$2(null);
                        transformableKt$detectZoom$1.L$0 = $this$detectZoom;
                        transformableKt$detectZoom$1.L$1 = panZoomLock;
                        transformableKt$detectZoom$1.L$2 = state3;
                        transformableKt$detectZoom$1.L$3 = rotation;
                        transformableKt$detectZoom$1.L$4 = zoom;
                        transformableKt$detectZoom$1.L$5 = pan;
                        transformableKt$detectZoom$1.L$6 = pastTouchSlop;
                        transformableKt$detectZoom$1.L$7 = lockedToPanZoom;
                        transformableKt$detectZoom$1.F$0 = touchSlop;
                        transformableKt$detectZoom$1.label = 1;
                        if ($this$detectZoom.awaitPointerEventScope(transformableKt$detectZoom$2, transformableKt$detectZoom$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        value = state3.getValue();
                        mutatePriority = MutatePriority.UserInput;
                        transformableKt$detectZoom$3 = new TransformableKt$detectZoom$3($this$detectZoom, pastTouchSlop, zoom, rotation, pan, touchSlop, lockedToPanZoom, panZoomLock, null);
                        transformableKt$detectZoom$1.L$0 = null;
                        transformableKt$detectZoom$1.L$1 = null;
                        transformableKt$detectZoom$1.L$2 = null;
                        transformableKt$detectZoom$1.L$3 = null;
                        transformableKt$detectZoom$1.L$4 = null;
                        transformableKt$detectZoom$1.L$5 = null;
                        transformableKt$detectZoom$1.L$6 = null;
                        transformableKt$detectZoom$1.L$7 = null;
                        transformableKt$detectZoom$1.label = 2;
                        if (value.transform(mutatePriority, transformableKt$detectZoom$3, transformableKt$detectZoom$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        touchSlop = transformableKt$detectZoom$1.F$0;
                        lockedToPanZoom = (Ref.BooleanRef) transformableKt$detectZoom$1.L$7;
                        pastTouchSlop = (Ref.BooleanRef) transformableKt$detectZoom$1.L$6;
                        pan = (Ref.LongRef) transformableKt$detectZoom$1.L$5;
                        zoom = (Ref.FloatRef) transformableKt$detectZoom$1.L$4;
                        rotation = (Ref.FloatRef) transformableKt$detectZoom$1.L$3;
                        state3 = (State) transformableKt$detectZoom$1.L$2;
                        panZoomLock = (State) transformableKt$detectZoom$1.L$1;
                        $this$detectZoom = (PointerInputScope) transformableKt$detectZoom$1.L$0;
                        ResultKt.throwOnFailure($result);
                        value = state3.getValue();
                        mutatePriority = MutatePriority.UserInput;
                        transformableKt$detectZoom$3 = new TransformableKt$detectZoom$3($this$detectZoom, pastTouchSlop, zoom, rotation, pan, touchSlop, lockedToPanZoom, panZoomLock, null);
                        transformableKt$detectZoom$1.L$0 = null;
                        transformableKt$detectZoom$1.L$1 = null;
                        transformableKt$detectZoom$1.L$2 = null;
                        transformableKt$detectZoom$1.L$3 = null;
                        transformableKt$detectZoom$1.L$4 = null;
                        transformableKt$detectZoom$1.L$5 = null;
                        transformableKt$detectZoom$1.L$6 = null;
                        transformableKt$detectZoom$1.L$7 = null;
                        transformableKt$detectZoom$1.label = 2;
                        if (value.transform(mutatePriority, transformableKt$detectZoom$3, transformableKt$detectZoom$1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        transformableKt$detectZoom$1 = new TransformableKt$detectZoom$1(continuation);
        Object $result2 = transformableKt$detectZoom$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (transformableKt$detectZoom$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Type inference failed for: r5v5, types: [T, androidx.compose.ui.input.pointer.PointerId] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0066 -> B:12:0x006f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitTwoDowns(AwaitPointerEventScope $this$awaitTwoDowns, boolean requireUnconsumed, Continuation<? super Unit> continuation) {
        TransformableKt$awaitTwoDowns$1 transformableKt$awaitTwoDowns$1;
        TransformableKt$awaitTwoDowns$1 transformableKt$awaitTwoDowns$12;
        Object $result;
        AwaitPointerEventScope $this$awaitTwoDowns2;
        Ref.ObjectRef firstDown;
        boolean requireUnconsumed2;
        Object obj;
        int index$iv;
        int size;
        boolean satisfied;
        int index$iv2;
        if (continuation instanceof TransformableKt$awaitTwoDowns$1) {
            transformableKt$awaitTwoDowns$1 = (TransformableKt$awaitTwoDowns$1) continuation;
            if ((transformableKt$awaitTwoDowns$1.label & Integer.MIN_VALUE) != 0) {
                transformableKt$awaitTwoDowns$1.label -= Integer.MIN_VALUE;
                transformableKt$awaitTwoDowns$12 = transformableKt$awaitTwoDowns$1;
                Object $result2 = transformableKt$awaitTwoDowns$12.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                PointerEventPass pointerEventPass = null;
                int i = 1;
                switch (transformableKt$awaitTwoDowns$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        AwaitPointerEventScope $this$awaitTwoDowns3 = $this$awaitTwoDowns;
                        boolean requireUnconsumed3 = requireUnconsumed;
                        Ref.ObjectRef firstDown2 = new Ref.ObjectRef();
                        transformableKt$awaitTwoDowns$12.L$0 = $this$awaitTwoDowns3;
                        transformableKt$awaitTwoDowns$12.L$1 = firstDown2;
                        transformableKt$awaitTwoDowns$12.Z$0 = requireUnconsumed3;
                        transformableKt$awaitTwoDowns$12.label = i;
                        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitTwoDowns3, pointerEventPass, transformableKt$awaitTwoDowns$12, i, pointerEventPass);
                        if (awaitPointerEvent$default != $result3) {
                            return $result3;
                        }
                        Object obj2 = $result3;
                        $result = $result2;
                        $result2 = awaitPointerEvent$default;
                        $this$awaitTwoDowns2 = $this$awaitTwoDowns3;
                        firstDown = firstDown2;
                        requireUnconsumed2 = requireUnconsumed3;
                        obj = obj2;
                        PointerEvent event = (PointerEvent) $result2;
                        Ref.IntRef downPointers = new Ref.IntRef();
                        downPointers.element = firstDown.element == 0 ? i : 0;
                        List $this$fastForEach$iv = event.getChanges();
                        index$iv = 0;
                        size = $this$fastForEach$iv.size();
                        while (index$iv < size) {
                            Object item$iv = $this$fastForEach$iv.get(index$iv);
                            PointerInputChange it = (PointerInputChange) item$iv;
                            boolean isDown = requireUnconsumed2 ? PointerEventKt.changedToDown(it) : PointerEventKt.changedToDownIgnoreConsumed(it);
                            boolean isUp = requireUnconsumed2 ? PointerEventKt.changedToUp(it) : PointerEventKt.changedToUpIgnoreConsumed(it);
                            if (isUp) {
                                index$iv2 = index$iv;
                                if (firstDown.element == 0 ? false : PointerId.m3349equalsimpl0(((PointerId) firstDown.element).m3352unboximpl(), it.getId())) {
                                    pointerEventPass = null;
                                    firstDown.element = null;
                                    downPointers.element--;
                                } else {
                                    pointerEventPass = null;
                                }
                            } else {
                                index$iv2 = index$iv;
                            }
                            if (isDown) {
                                firstDown.element = PointerId.m3346boximpl(it.getId());
                                downPointers.element++;
                            }
                            index$iv = index$iv2 + 1;
                        }
                        i = 1;
                        satisfied = downPointers.element <= 1;
                        if (!satisfied) {
                            return Unit.INSTANCE;
                        }
                        $result2 = $result;
                        $result3 = obj;
                        requireUnconsumed3 = requireUnconsumed2;
                        firstDown2 = firstDown;
                        $this$awaitTwoDowns3 = $this$awaitTwoDowns2;
                        transformableKt$awaitTwoDowns$12.L$0 = $this$awaitTwoDowns3;
                        transformableKt$awaitTwoDowns$12.L$1 = firstDown2;
                        transformableKt$awaitTwoDowns$12.Z$0 = requireUnconsumed3;
                        transformableKt$awaitTwoDowns$12.label = i;
                        Object awaitPointerEvent$default2 = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitTwoDowns3, pointerEventPass, transformableKt$awaitTwoDowns$12, i, pointerEventPass);
                        if (awaitPointerEvent$default2 != $result3) {
                        }
                    case 1:
                        boolean requireUnconsumed4 = transformableKt$awaitTwoDowns$12.Z$0;
                        Ref.ObjectRef firstDown3 = (Ref.ObjectRef) transformableKt$awaitTwoDowns$12.L$1;
                        AwaitPointerEventScope $this$awaitTwoDowns4 = (AwaitPointerEventScope) transformableKt$awaitTwoDowns$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        $this$awaitTwoDowns2 = $this$awaitTwoDowns4;
                        firstDown = firstDown3;
                        requireUnconsumed2 = requireUnconsumed4;
                        obj = $result3;
                        $result = $result2;
                        PointerEvent event2 = (PointerEvent) $result2;
                        Ref.IntRef downPointers2 = new Ref.IntRef();
                        downPointers2.element = firstDown.element == 0 ? i : 0;
                        List $this$fastForEach$iv2 = event2.getChanges();
                        index$iv = 0;
                        size = $this$fastForEach$iv2.size();
                        while (index$iv < size) {
                        }
                        i = 1;
                        satisfied = downPointers2.element <= 1;
                        if (!satisfied) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        transformableKt$awaitTwoDowns$1 = new TransformableKt$awaitTwoDowns$1(continuation);
        transformableKt$awaitTwoDowns$12 = transformableKt$awaitTwoDowns$1;
        Object $result22 = transformableKt$awaitTwoDowns$12.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        PointerEventPass pointerEventPass2 = null;
        int i2 = 1;
        switch (transformableKt$awaitTwoDowns$12.label) {
        }
    }

    static /* synthetic */ Object awaitTwoDowns$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return awaitTwoDowns(awaitPointerEventScope, z, continuation);
    }
}
