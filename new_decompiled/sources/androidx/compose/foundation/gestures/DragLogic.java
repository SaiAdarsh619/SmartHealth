package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.unit.Velocity;
import androidx.compose.runtime.MutableState;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Draggable.kt */
@Metadata(m286d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B¡\u0001\u0012<\u0010\u0002\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\b\u000b\u0012<\u0010\f\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\b\u000b\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0015\u0010\u001d\u001a\u00020\n*\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\n*\u00020\u00042\u0006\u0010 \u001a\u00020!H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u001d\u0010#\u001a\u00020\n*\u00020\u00042\u0006\u0010 \u001a\u00020$H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018RO\u0010\u0002\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\b\u000bø\u0001\u0000ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aRO\u0010\f\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\b\u000bø\u0001\u0000ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, m287d2 = {"Landroidx/compose/foundation/gestures/DragLogic;", "", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "startedPosition", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "Landroidx/compose/ui/unit/Velocity;", "velocity", "dragStartInteraction", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/MutableState;Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "getDragStartInteraction", "()Landroidx/compose/runtime/MutableState;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getOnDragStarted", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "getOnDragStopped", "processDragCancel", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStart", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/DragEvent$DragStarted;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStop", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/DragEvent$DragStopped;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class DragLogic {
    private final MutableState<DragInteraction.Start> dragStartInteraction;
    private final MutableInteractionSource interactionSource;
    private final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> onDragStarted;
    private final Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> onDragStopped;

    /* JADX WARN: Multi-variable type inference failed */
    public DragLogic(Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, MutableState<DragInteraction.Start> dragStartInteraction, MutableInteractionSource interactionSource) {
        Intrinsics.checkNotNullParameter(onDragStarted, "onDragStarted");
        Intrinsics.checkNotNullParameter(onDragStopped, "onDragStopped");
        Intrinsics.checkNotNullParameter(dragStartInteraction, "dragStartInteraction");
        this.onDragStarted = onDragStarted;
        this.onDragStopped = onDragStopped;
        this.dragStartInteraction = dragStartInteraction;
        this.interactionSource = interactionSource;
    }

    public final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> getOnDragStarted() {
        return this.onDragStarted;
    }

    public final Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> getOnDragStopped() {
        return this.onDragStopped;
    }

    public final MutableState<DragInteraction.Start> getDragStartInteraction() {
        return this.dragStartInteraction;
    }

    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processDragStart(CoroutineScope coroutineScope, DragEvent.DragStarted event, Continuation<? super Unit> continuation) {
        DragLogic$processDragStart$1 dragLogic$processDragStart$1;
        DragLogic$processDragStart$1 dragLogic$processDragStart$12;
        DragLogic dragLogic;
        CoroutineScope $this$processDragStart;
        MutableInteractionSource mutableInteractionSource;
        DragInteraction.Start interaction;
        MutableInteractionSource mutableInteractionSource2;
        Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> function3;
        Offset m1749boximpl;
        if (continuation instanceof DragLogic$processDragStart$1) {
            dragLogic$processDragStart$1 = (DragLogic$processDragStart$1) continuation;
            if ((dragLogic$processDragStart$1.label & Integer.MIN_VALUE) != 0) {
                dragLogic$processDragStart$1.label -= Integer.MIN_VALUE;
                dragLogic$processDragStart$12 = dragLogic$processDragStart$1;
                Object $result = dragLogic$processDragStart$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dragLogic$processDragStart$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        dragLogic = this;
                        $this$processDragStart = coroutineScope;
                        DragInteraction.Start oldInteraction = dragLogic.dragStartInteraction.getValue();
                        if (oldInteraction != null && (mutableInteractionSource = dragLogic.interactionSource) != null) {
                            DragInteraction.Cancel cancel = new DragInteraction.Cancel(oldInteraction);
                            dragLogic$processDragStart$12.L$0 = dragLogic;
                            dragLogic$processDragStart$12.L$1 = $this$processDragStart;
                            dragLogic$processDragStart$12.L$2 = event;
                            dragLogic$processDragStart$12.label = 1;
                            if (mutableInteractionSource.emit(cancel, dragLogic$processDragStart$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        interaction = new DragInteraction.Start();
                        mutableInteractionSource2 = dragLogic.interactionSource;
                        if (mutableInteractionSource2 != null) {
                            dragLogic$processDragStart$12.L$0 = dragLogic;
                            dragLogic$processDragStart$12.L$1 = $this$processDragStart;
                            dragLogic$processDragStart$12.L$2 = event;
                            dragLogic$processDragStart$12.L$3 = interaction;
                            dragLogic$processDragStart$12.label = 2;
                            if (mutableInteractionSource2.emit(interaction, dragLogic$processDragStart$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        dragLogic.dragStartInteraction.setValue(interaction);
                        function3 = dragLogic.onDragStarted;
                        m1749boximpl = Offset.m1749boximpl(event.getStartPoint());
                        dragLogic$processDragStart$12.L$0 = null;
                        dragLogic$processDragStart$12.L$1 = null;
                        dragLogic$processDragStart$12.L$2 = null;
                        dragLogic$processDragStart$12.L$3 = null;
                        dragLogic$processDragStart$12.label = 3;
                        if (function3.invoke($this$processDragStart, m1749boximpl, dragLogic$processDragStart$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        event = (DragEvent.DragStarted) dragLogic$processDragStart$12.L$2;
                        $this$processDragStart = (CoroutineScope) dragLogic$processDragStart$12.L$1;
                        dragLogic = (DragLogic) dragLogic$processDragStart$12.L$0;
                        ResultKt.throwOnFailure($result);
                        interaction = new DragInteraction.Start();
                        mutableInteractionSource2 = dragLogic.interactionSource;
                        if (mutableInteractionSource2 != null) {
                        }
                        dragLogic.dragStartInteraction.setValue(interaction);
                        function3 = dragLogic.onDragStarted;
                        m1749boximpl = Offset.m1749boximpl(event.getStartPoint());
                        dragLogic$processDragStart$12.L$0 = null;
                        dragLogic$processDragStart$12.L$1 = null;
                        dragLogic$processDragStart$12.L$2 = null;
                        dragLogic$processDragStart$12.L$3 = null;
                        dragLogic$processDragStart$12.label = 3;
                        if (function3.invoke($this$processDragStart, m1749boximpl, dragLogic$processDragStart$12) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        interaction = (DragInteraction.Start) dragLogic$processDragStart$12.L$3;
                        event = (DragEvent.DragStarted) dragLogic$processDragStart$12.L$2;
                        $this$processDragStart = (CoroutineScope) dragLogic$processDragStart$12.L$1;
                        dragLogic = (DragLogic) dragLogic$processDragStart$12.L$0;
                        ResultKt.throwOnFailure($result);
                        dragLogic.dragStartInteraction.setValue(interaction);
                        function3 = dragLogic.onDragStarted;
                        m1749boximpl = Offset.m1749boximpl(event.getStartPoint());
                        dragLogic$processDragStart$12.L$0 = null;
                        dragLogic$processDragStart$12.L$1 = null;
                        dragLogic$processDragStart$12.L$2 = null;
                        dragLogic$processDragStart$12.L$3 = null;
                        dragLogic$processDragStart$12.label = 3;
                        if (function3.invoke($this$processDragStart, m1749boximpl, dragLogic$processDragStart$12) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 3:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragLogic$processDragStart$1 = new DragLogic$processDragStart$1(this, continuation);
        dragLogic$processDragStart$12 = dragLogic$processDragStart$1;
        Object $result2 = dragLogic$processDragStart$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dragLogic$processDragStart$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processDragStop(CoroutineScope coroutineScope, DragEvent.DragStopped event, Continuation<? super Unit> continuation) {
        DragLogic$processDragStop$1 dragLogic$processDragStop$1;
        DragLogic$processDragStop$1 dragLogic$processDragStop$12;
        DragLogic dragLogic;
        CoroutineScope $this$processDragStop;
        int i;
        Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> function3;
        Velocity m4598boximpl;
        if (continuation instanceof DragLogic$processDragStop$1) {
            dragLogic$processDragStop$1 = (DragLogic$processDragStop$1) continuation;
            if ((dragLogic$processDragStop$1.label & Integer.MIN_VALUE) != 0) {
                dragLogic$processDragStop$1.label -= Integer.MIN_VALUE;
                dragLogic$processDragStop$12 = dragLogic$processDragStop$1;
                Object $result = dragLogic$processDragStop$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dragLogic$processDragStop$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        dragLogic = this;
                        $this$processDragStop = coroutineScope;
                        DragInteraction.Start interaction = dragLogic.dragStartInteraction.getValue();
                        if (interaction != null) {
                            MutableInteractionSource mutableInteractionSource = dragLogic.interactionSource;
                            if (mutableInteractionSource != null) {
                                DragInteraction.Stop stop = new DragInteraction.Stop(interaction);
                                dragLogic$processDragStop$12.L$0 = dragLogic;
                                dragLogic$processDragStop$12.L$1 = $this$processDragStop;
                                dragLogic$processDragStop$12.L$2 = event;
                                dragLogic$processDragStop$12.label = 1;
                                if (mutableInteractionSource.emit(stop, dragLogic$processDragStop$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                i = 0;
                            }
                            dragLogic.dragStartInteraction.setValue(null);
                        }
                        function3 = dragLogic.onDragStopped;
                        m4598boximpl = Velocity.m4598boximpl(event.getVelocity());
                        dragLogic$processDragStop$12.L$0 = null;
                        dragLogic$processDragStop$12.L$1 = null;
                        dragLogic$processDragStop$12.L$2 = null;
                        dragLogic$processDragStop$12.label = 2;
                        if (function3.invoke($this$processDragStop, m4598boximpl, dragLogic$processDragStop$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        i = 0;
                        event = (DragEvent.DragStopped) dragLogic$processDragStop$12.L$2;
                        $this$processDragStop = (CoroutineScope) dragLogic$processDragStop$12.L$1;
                        dragLogic = (DragLogic) dragLogic$processDragStop$12.L$0;
                        ResultKt.throwOnFailure($result);
                        dragLogic.dragStartInteraction.setValue(null);
                        function3 = dragLogic.onDragStopped;
                        m4598boximpl = Velocity.m4598boximpl(event.getVelocity());
                        dragLogic$processDragStop$12.L$0 = null;
                        dragLogic$processDragStop$12.L$1 = null;
                        dragLogic$processDragStop$12.L$2 = null;
                        dragLogic$processDragStop$12.label = 2;
                        if (function3.invoke($this$processDragStop, m4598boximpl, dragLogic$processDragStop$12) == coroutine_suspended) {
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
        dragLogic$processDragStop$1 = new DragLogic$processDragStop$1(this, continuation);
        dragLogic$processDragStop$12 = dragLogic$processDragStop$1;
        Object $result2 = dragLogic$processDragStop$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dragLogic$processDragStop$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processDragCancel(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        DragLogic$processDragCancel$1 dragLogic$processDragCancel$1;
        DragLogic$processDragCancel$1 dragLogic$processDragCancel$12;
        DragLogic dragLogic;
        CoroutineScope $this$processDragCancel;
        int i;
        Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> function3;
        Velocity m4598boximpl;
        if (continuation instanceof DragLogic$processDragCancel$1) {
            dragLogic$processDragCancel$1 = (DragLogic$processDragCancel$1) continuation;
            if ((dragLogic$processDragCancel$1.label & Integer.MIN_VALUE) != 0) {
                dragLogic$processDragCancel$1.label -= Integer.MIN_VALUE;
                dragLogic$processDragCancel$12 = dragLogic$processDragCancel$1;
                Object $result = dragLogic$processDragCancel$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dragLogic$processDragCancel$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        dragLogic = this;
                        $this$processDragCancel = coroutineScope;
                        DragInteraction.Start interaction = dragLogic.dragStartInteraction.getValue();
                        if (interaction != null) {
                            MutableInteractionSource mutableInteractionSource = dragLogic.interactionSource;
                            if (mutableInteractionSource != null) {
                                DragInteraction.Cancel cancel = new DragInteraction.Cancel(interaction);
                                dragLogic$processDragCancel$12.L$0 = dragLogic;
                                dragLogic$processDragCancel$12.L$1 = $this$processDragCancel;
                                dragLogic$processDragCancel$12.label = 1;
                                if (mutableInteractionSource.emit(cancel, dragLogic$processDragCancel$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                i = 0;
                            }
                            dragLogic.dragStartInteraction.setValue(null);
                        }
                        function3 = dragLogic.onDragStopped;
                        m4598boximpl = Velocity.m4598boximpl(Velocity.INSTANCE.m4618getZero9UxMQ8M());
                        dragLogic$processDragCancel$12.L$0 = null;
                        dragLogic$processDragCancel$12.L$1 = null;
                        dragLogic$processDragCancel$12.label = 2;
                        if (function3.invoke($this$processDragCancel, m4598boximpl, dragLogic$processDragCancel$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        i = 0;
                        $this$processDragCancel = (CoroutineScope) dragLogic$processDragCancel$12.L$1;
                        dragLogic = (DragLogic) dragLogic$processDragCancel$12.L$0;
                        ResultKt.throwOnFailure($result);
                        dragLogic.dragStartInteraction.setValue(null);
                        function3 = dragLogic.onDragStopped;
                        m4598boximpl = Velocity.m4598boximpl(Velocity.INSTANCE.m4618getZero9UxMQ8M());
                        dragLogic$processDragCancel$12.L$0 = null;
                        dragLogic$processDragCancel$12.L$1 = null;
                        dragLogic$processDragCancel$12.label = 2;
                        if (function3.invoke($this$processDragCancel, m4598boximpl, dragLogic$processDragCancel$12) == coroutine_suspended) {
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
        dragLogic$processDragCancel$1 = new DragLogic$processDragCancel$1(this, continuation);
        dragLogic$processDragCancel$12 = dragLogic$processDragCancel$1;
        Object $result2 = dragLogic$processDragCancel$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dragLogic$processDragCancel$12.label) {
        }
    }
}
