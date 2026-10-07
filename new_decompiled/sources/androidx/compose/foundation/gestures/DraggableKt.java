package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerEventKt;
import androidx.compose.p000ui.input.pointer.PointerEventPass;
import androidx.compose.p000ui.input.pointer.PointerId;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p000ui.input.pointer.util.VelocityTracker;
import androidx.compose.p000ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.p000ui.unit.Velocity;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.core.app.NotificationCompat;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: Draggable.kt */
@Metadata(m286d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u001a!\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0007\u001ad\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t*\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u00030\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00110\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001aS\u0010\u0017\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001aé\u0001\u0010 \u001a\u00020!*\u00020!2\u0006\u0010\"\u001a\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020\u000f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112>\b\u0002\u0010&\u001a8\b\u0001\u0012\u0004\u0012\u00020(\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050,\u0012\u0006\u0012\u0004\u0018\u00010-0'¢\u0006\u0002\b.2>\b\u0002\u0010/\u001a8\b\u0001\u0012\u0004\u0012\u00020(\u0012\u0013\u0012\u001100¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(1\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050,\u0012\u0006\u0012\u0004\u0018\u00010-0'¢\u0006\u0002\b.2\b\b\u0002\u0010\u001d\u001a\u00020\u000fH\u0000ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u00102\u001aÏ\u0001\u0010 \u001a\u00020!*\u00020!2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020\u000f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2>\b\u0002\u0010&\u001a8\b\u0001\u0012\u0004\u0012\u00020(\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050,\u0012\u0006\u0012\u0004\u0018\u00010-0'¢\u0006\u0002\b.2>\b\u0002\u0010/\u001a8\b\u0001\u0012\u0004\u0012\u00020(\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(1\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050,\u0012\u0006\u0012\u0004\u0018\u00010-0'¢\u0006\u0002\b.2\b\b\u0002\u0010\u001d\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u00103\u001a!\u00104\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a!\u00104\u001a\u00020\u0004*\u0002002\u0006\u0010\u0014\u001a\u00020\u0015H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b7\u00106\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00068"}, m287d2 = {"DraggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "onDelta", "Lkotlin/Function1;", "", "", "rememberDraggableState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/DraggableState;", "awaitDownAndSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "canDrag", "Landroidx/compose/runtime/State;", "", "startDragImmediately", "Lkotlin/Function0;", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/ui/input/pointer/util/VelocityTracker;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDrag", "startEvent", "initialDelta", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "Landroidx/compose/foundation/gestures/DragEvent;", "reverseDirection", "awaitDrag-Su4bsnU", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;JLandroidx/compose/ui/input/pointer/util/VelocityTracker;Lkotlinx/coroutines/channels/SendChannel;ZLandroidx/compose/foundation/gestures/Orientation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "draggable", "Landroidx/compose/ui/Modifier;", "state", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "startedPosition", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "Landroidx/compose/ui/unit/Velocity;", "velocity", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/DraggableState;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/DraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "toFloat", "toFloat-3MmeM6k", "(JLandroidx/compose/foundation/gestures/Orientation;)F", "toFloat-sF-c-tU", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class DraggableKt {
    public static final DraggableState DraggableState(Function1<? super Float, Unit> onDelta) {
        Intrinsics.checkNotNullParameter(onDelta, "onDelta");
        return new DefaultDraggableState(onDelta);
    }

    public static final DraggableState rememberDraggableState(Function1<? super Float, Unit> onDelta, Composer $composer, int $changed) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(onDelta, "onDelta");
        $composer.startReplaceableGroup(-183245213);
        ComposerKt.sourceInformation($composer, "C(rememberDraggableState)136@5795L29,137@5836L61:Draggable.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-183245213, $changed, -1, "androidx.compose.foundation.gestures.rememberDraggableState (Draggable.kt:135)");
        }
        final State onDeltaState = SnapshotStateKt.rememberUpdatedState(onDelta, $composer, $changed & 14);
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = DraggableState(new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.DraggableKt$rememberDraggableState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                    invoke(f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float it) {
                    onDeltaState.getValue().invoke(Float.valueOf(it));
                }
            });
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        DraggableState draggableState = (DraggableState) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return draggableState;
    }

    public static final Modifier draggable(Modifier $this$draggable, DraggableState state, Orientation orientation, boolean enabled, MutableInteractionSource interactionSource, final boolean startDragImmediately, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, boolean reverseDirection) {
        Intrinsics.checkNotNullParameter($this$draggable, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(onDragStarted, "onDragStarted");
        Intrinsics.checkNotNullParameter(onDragStopped, "onDragStopped");
        return draggable($this$draggable, state, new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.DraggableKt$draggable$3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PointerInputChange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return true;
            }
        }, orientation, enabled, interactionSource, new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.DraggableKt$draggable$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(startDragImmediately);
            }
        }, onDragStarted, new DraggableKt$draggable$5(onDragStopped, orientation, null), reverseDirection);
    }

    public static final Modifier draggable(Modifier $this$draggable, final DraggableState state, final Function1<? super PointerInputChange, Boolean> canDrag, final Orientation orientation, final boolean enabled, final MutableInteractionSource interactionSource, final Function0<Boolean> startDragImmediately, final Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, final Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, final boolean reverseDirection) {
        Intrinsics.checkNotNullParameter($this$draggable, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(canDrag, "canDrag");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(startDragImmediately, "startDragImmediately");
        Intrinsics.checkNotNullParameter(onDragStarted, "onDragStarted");
        Intrinsics.checkNotNullParameter(onDragStopped, "onDragStopped");
        return ComposedModifierKt.composed($this$draggable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.gestures.DraggableKt$draggable$$inlined$debugInspectorInfo$1
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
                $this$null.setName("draggable");
                $this$null.getProperties().set("canDrag", Function1.this);
                $this$null.getProperties().set("orientation", orientation);
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
                $this$null.getProperties().set("reverseDirection", Boolean.valueOf(reverseDirection));
                $this$null.getProperties().set("interactionSource", interactionSource);
                $this$null.getProperties().set("startDragImmediately", startDragImmediately);
                $this$null.getProperties().set("onDragStarted", onDragStarted);
                $this$null.getProperties().set("onDragStopped", onDragStopped);
                $this$null.getProperties().set("state", state);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.gestures.DraggableKt$draggable$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Object value$iv$iv;
                Object value$iv$iv2;
                Object value$iv$iv3;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(597193710);
                ComposerKt.sourceInformation($composer, "C218@9842L57,219@9940L238,219@9904L274,227@10197L61,228@10291L42,229@10357L29,230@10408L114,233@10527L966:Draggable.kt#8bwon0");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(597193710, $changed, -1, "androidx.compose.foundation.gestures.draggable.<anonymous> (Draggable.kt:217)");
                }
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv = $composer.rememberedValue();
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                final MutableState draggedInteraction = (MutableState) value$iv$iv;
                MutableInteractionSource mutableInteractionSource = MutableInteractionSource.this;
                Object key2$iv = MutableInteractionSource.this;
                final MutableInteractionSource mutableInteractionSource2 = MutableInteractionSource.this;
                $composer.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer.changed(draggedInteraction) | $composer.changed(key2$iv);
                Object it$iv$iv2 = $composer.rememberedValue();
                if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.gestures.DraggableKt$draggable$9$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                            final MutableState<DragInteraction.Start> mutableState = draggedInteraction;
                            final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.gestures.DraggableKt$draggable$9$1$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    DragInteraction.Start interaction = (DragInteraction.Start) MutableState.this.getValue();
                                    if (interaction == null) {
                                        return;
                                    }
                                    if (mutableInteractionSource3 != null) {
                                        mutableInteractionSource3.tryEmit(new DragInteraction.Cancel(interaction));
                                    }
                                    MutableState.this.setValue(null);
                                }
                            };
                        }
                    };
                    $composer.updateRememberedValue(value$iv$iv2);
                } else {
                    value$iv$iv2 = it$iv$iv2;
                }
                $composer.endReplaceableGroup();
                EffectsKt.DisposableEffect(mutableInteractionSource, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv$iv2, $composer, 0);
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv3 = $composer.rememberedValue();
                if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv3 = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
                    $composer.updateRememberedValue(value$iv$iv3);
                } else {
                    value$iv$iv3 = it$iv$iv3;
                }
                $composer.endReplaceableGroup();
                Channel channel = (Channel) value$iv$iv3;
                State startImmediatelyState = SnapshotStateKt.rememberUpdatedState(startDragImmediately, $composer, 0);
                State canDragState = SnapshotStateKt.rememberUpdatedState(canDrag, $composer, 0);
                State dragLogic$delegate = SnapshotStateKt.rememberUpdatedState(new DragLogic(onDragStarted, onDragStopped, draggedInteraction, MutableInteractionSource.this), $composer, 8);
                EffectsKt.LaunchedEffect(state, new C00962(channel, state, dragLogic$delegate, orientation, null), $composer, 64);
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.INSTANCE, new Object[]{orientation, Boolean.valueOf(enabled), Boolean.valueOf(reverseDirection)}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new C00973(enabled, canDragState, startImmediatelyState, orientation, channel, reverseDirection, null));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return pointerInput;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: invoke$lambda-3, reason: not valid java name */
            public static final DragLogic m616invoke$lambda3(State<DragLogic> state2) {
                Object thisObj$iv = state2.getValue();
                return (DragLogic) thisObj$iv;
            }

            /* compiled from: Draggable.kt */
            @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            @DebugMetadata(m296c = "androidx.compose.foundation.gestures.DraggableKt$draggable$9$3", m297f = "Draggable.kt", m298i = {}, m299l = {260}, m300m = "invokeSuspend", m301n = {}, m302s = {})
            /* renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$9$3 */
            static final class C00973 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ State<Function1<PointerInputChange, Boolean>> $canDragState;
                final /* synthetic */ Channel<DragEvent> $channel;
                final /* synthetic */ boolean $enabled;
                final /* synthetic */ Orientation $orientation;
                final /* synthetic */ boolean $reverseDirection;
                final /* synthetic */ State<Function0<Boolean>> $startImmediatelyState;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00973(boolean z, State<? extends Function1<? super PointerInputChange, Boolean>> state, State<? extends Function0<Boolean>> state2, Orientation orientation, Channel<DragEvent> channel, boolean z2, Continuation<? super C00973> continuation) {
                    super(2, continuation);
                    this.$enabled = z;
                    this.$canDragState = state;
                    this.$startImmediatelyState = state2;
                    this.$orientation = orientation;
                    this.$channel = channel;
                    this.$reverseDirection = z2;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00973 c00973 = new C00973(this.$enabled, this.$canDragState, this.$startImmediatelyState, this.$orientation, this.$channel, this.$reverseDirection, continuation);
                    c00973.L$0 = obj;
                    return c00973;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                    return ((C00973) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* compiled from: Draggable.kt */
                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                @DebugMetadata(m296c = "androidx.compose.foundation.gestures.DraggableKt$draggable$9$3$1", m297f = "Draggable.kt", m298i = {0}, m299l = {262}, m300m = "invokeSuspend", m301n = {"$this$coroutineScope"}, m302s = {"L$0"})
                /* renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$9$3$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ PointerInputScope $$this$pointerInput;
                    final /* synthetic */ State<Function1<PointerInputChange, Boolean>> $canDragState;
                    final /* synthetic */ Channel<DragEvent> $channel;
                    final /* synthetic */ Orientation $orientation;
                    final /* synthetic */ boolean $reverseDirection;
                    final /* synthetic */ State<Function0<Boolean>> $startImmediatelyState;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(PointerInputScope pointerInputScope, State<? extends Function1<? super PointerInputChange, Boolean>> state, State<? extends Function0<Boolean>> state2, Orientation orientation, Channel<DragEvent> channel, boolean z, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$$this$pointerInput = pointerInputScope;
                        this.$canDragState = state;
                        this.$startImmediatelyState = state2;
                        this.$orientation = orientation;
                        this.$channel = channel;
                        this.$reverseDirection = z;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$pointerInput, this.$canDragState, this.$startImmediatelyState, this.$orientation, this.$channel, this.$reverseDirection, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* compiled from: Draggable.kt */
                    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                    @DebugMetadata(m296c = "androidx.compose.foundation.gestures.DraggableKt$draggable$9$3$1$1", m297f = "Draggable.kt", m298i = {0, 0, 1, 1, 1}, m299l = {265, 273}, m300m = "invokeSuspend", m301n = {"$this$awaitPointerEventScope", "velocityTracker", "$this$awaitPointerEventScope", "velocityTracker", "isDragSuccessful"}, m302s = {"L$0", "L$1", "L$0", "L$1", "I$0"})
                    /* renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$9$3$1$1, reason: invalid class name and collision with other inner class name */
                    static final class C16701 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ CoroutineScope $$this$coroutineScope;
                        final /* synthetic */ State<Function1<PointerInputChange, Boolean>> $canDragState;
                        final /* synthetic */ Channel<DragEvent> $channel;
                        final /* synthetic */ Orientation $orientation;
                        final /* synthetic */ boolean $reverseDirection;
                        final /* synthetic */ State<Function0<Boolean>> $startImmediatelyState;
                        int I$0;
                        private /* synthetic */ Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        boolean Z$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        C16701(CoroutineScope coroutineScope, State<? extends Function1<? super PointerInputChange, Boolean>> state, State<? extends Function0<Boolean>> state2, Orientation orientation, Channel<DragEvent> channel, boolean z, Continuation<? super C16701> continuation) {
                            super(2, continuation);
                            this.$$this$coroutineScope = coroutineScope;
                            this.$canDragState = state;
                            this.$startImmediatelyState = state2;
                            this.$orientation = orientation;
                            this.$channel = channel;
                            this.$reverseDirection = z;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            C16701 c16701 = new C16701(this.$$this$coroutineScope, this.$canDragState, this.$startImmediatelyState, this.$orientation, this.$channel, this.$reverseDirection, continuation);
                            c16701.L$0 = obj;
                            return c16701;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                            return ((C16701) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:13:0x00f8  */
                        /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
                        /* JADX WARN: Removed duplicated region for block: B:26:0x009c  */
                        /* JADX WARN: Removed duplicated region for block: B:42:0x013f  */
                        /* JADX WARN: Removed duplicated region for block: B:43:0x014e A[Catch: all -> 0x003d, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x003d, blocks: (B:8:0x0035, B:40:0x0138, B:43:0x014e), top: B:7:0x0035 }] */
                        /* JADX WARN: Removed duplicated region for block: B:48:0x0151  */
                        /* JADX WARN: Removed duplicated region for block: B:55:0x0168  */
                        /* JADX WARN: Removed duplicated region for block: B:56:0x0171  */
                        /* JADX WARN: Removed duplicated region for block: B:57:0x0177  */
                        /* JADX WARN: Removed duplicated region for block: B:60:0x0112  */
                        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00e6 -> B:10:0x00f0). Please report as a decompilation issue!!! */
                        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x013f -> B:18:0x0065). Please report as a decompilation issue!!! */
                        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0171 -> B:18:0x0065). Please report as a decompilation issue!!! */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object invokeSuspend(Object $result) {
                            C16701 c16701;
                            Object $result2;
                            AwaitPointerEventScope $this$awaitPointerEventScope;
                            VelocityTracker velocityTracker;
                            AwaitPointerEventScope $this$awaitPointerEventScope2;
                            Object obj;
                            Object $result3;
                            Object $result4;
                            C16701 c167012;
                            Channel<DragEvent> channel;
                            boolean z;
                            int i;
                            DragEvent.DragCancelled event;
                            AwaitPointerEventScope $this$awaitPointerEventScope3;
                            CoroutineScope coroutineScope;
                            int i2;
                            Object $result5;
                            C16701 c167013;
                            CancellationException cancellation;
                            Pair it;
                            int i3;
                            AwaitPointerEventScope $this$awaitPointerEventScope4;
                            boolean isDragSuccessful;
                            DragEvent.DragCancelled event2;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    c16701 = this;
                                    $result2 = $result;
                                    $this$awaitPointerEventScope = (AwaitPointerEventScope) c16701.L$0;
                                    if (CoroutineScopeKt.isActive(c16701.$$this$coroutineScope)) {
                                        VelocityTracker velocityTracker2 = new VelocityTracker();
                                        c16701.L$0 = $this$awaitPointerEventScope;
                                        c16701.L$1 = velocityTracker2;
                                        c16701.L$2 = null;
                                        c16701.L$3 = null;
                                        c16701.label = 1;
                                        obj = DraggableKt.awaitDownAndSlop($this$awaitPointerEventScope, c16701.$canDragState, c16701.$startImmediatelyState, velocityTracker2, c16701.$orientation, c16701);
                                        if (obj == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        $result3 = $result2;
                                        $this$awaitPointerEventScope2 = $this$awaitPointerEventScope;
                                        velocityTracker = velocityTracker2;
                                        $result4 = coroutine_suspended;
                                        c167012 = c16701;
                                        it = (Pair) obj;
                                        if (it == null) {
                                            channel = c167012.$channel;
                                            z = c167012.$reverseDirection;
                                            Orientation orientation = c167012.$orientation;
                                            coroutineScope = c167012.$$this$coroutineScope;
                                            i3 = 0;
                                            try {
                                            } catch (CancellationException e) {
                                                cancellation = e;
                                                $result5 = $result3;
                                                i2 = 0;
                                                $this$awaitPointerEventScope3 = $this$awaitPointerEventScope2;
                                                Object obj2 = $result4;
                                                c167013 = c167012;
                                                coroutine_suspended = obj2;
                                                i = 0;
                                                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                                                }
                                            } catch (Throwable th) {
                                                cancellation = th;
                                                i = 0;
                                                if (i != 0) {
                                                }
                                                channel.mo6233trySendJP2dKIU(event);
                                                throw cancellation;
                                            }
                                            PointerInputChange pointerInputChange = (PointerInputChange) it.getFirst();
                                            long packedValue = ((Offset) it.getSecond()).getPackedValue();
                                            Channel<DragEvent> channel2 = channel;
                                            boolean z2 = z;
                                            c167012.L$0 = $this$awaitPointerEventScope2;
                                            c167012.L$1 = velocityTracker;
                                            c167012.L$2 = channel;
                                            c167012.L$3 = coroutineScope;
                                            c167012.Z$0 = z;
                                            c167012.I$0 = 0;
                                            c167012.label = 2;
                                            $result5 = DraggableKt.m607awaitDragSu4bsnU($this$awaitPointerEventScope2, pointerInputChange, packedValue, velocityTracker, channel2, z2, orientation, c167012);
                                            if ($result5 == $result4) {
                                                return $result4;
                                            }
                                            Object obj3 = $result4;
                                            c167013 = c167012;
                                            coroutine_suspended = obj3;
                                            AwaitPointerEventScope awaitPointerEventScope = $this$awaitPointerEventScope2;
                                            i = 0;
                                            $this$awaitPointerEventScope4 = awaitPointerEventScope;
                                            try {
                                            } catch (CancellationException e2) {
                                                cancellation = e2;
                                                $result5 = $result3;
                                                i2 = i3;
                                                $this$awaitPointerEventScope3 = $this$awaitPointerEventScope4;
                                                i = 0;
                                                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                                                }
                                            } catch (Throwable th2) {
                                                cancellation = th2;
                                                if (i != 0) {
                                                }
                                                channel.mo6233trySendJP2dKIU(event);
                                                throw cancellation;
                                            }
                                            isDragSuccessful = ((Boolean) $result5).booleanValue();
                                            if (isDragSuccessful) {
                                                event2 = DragEvent.DragCancelled.INSTANCE;
                                            } else {
                                                long velocity = velocityTracker.m3466calculateVelocity9UxMQ8M();
                                                event2 = new DragEvent.DragStopped(Velocity.m4613timesadjELrA(velocity, z ? -1.0f : 1.0f), null);
                                            }
                                            channel.mo6233trySendJP2dKIU(event2);
                                            $this$awaitPointerEventScope = $this$awaitPointerEventScope4;
                                            c16701 = c167013;
                                            $result2 = $result3;
                                            if (CoroutineScopeKt.isActive(c16701.$$this$coroutineScope)) {
                                                return Unit.INSTANCE;
                                            }
                                        } else {
                                            c16701 = c167012;
                                            coroutine_suspended = $result4;
                                            $result2 = $result3;
                                            $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                                            if (CoroutineScopeKt.isActive(c16701.$$this$coroutineScope)) {
                                            }
                                        }
                                    }
                                    break;
                                case 1:
                                    VelocityTracker velocityTracker3 = (VelocityTracker) this.L$1;
                                    AwaitPointerEventScope $this$awaitPointerEventScope5 = (AwaitPointerEventScope) this.L$0;
                                    ResultKt.throwOnFailure($result);
                                    velocityTracker = velocityTracker3;
                                    $this$awaitPointerEventScope2 = $this$awaitPointerEventScope5;
                                    obj = $result;
                                    $result3 = obj;
                                    $result4 = coroutine_suspended;
                                    c167012 = this;
                                    it = (Pair) obj;
                                    if (it == null) {
                                    }
                                    break;
                                case 2:
                                    c167013 = this;
                                    $result5 = $result;
                                    i2 = 0;
                                    i = c167013.I$0;
                                    z = c167013.Z$0;
                                    coroutineScope = (CoroutineScope) c167013.L$3;
                                    channel = (Channel) c167013.L$2;
                                    velocityTracker = (VelocityTracker) c167013.L$1;
                                    $this$awaitPointerEventScope3 = (AwaitPointerEventScope) c167013.L$0;
                                    try {
                                        try {
                                            ResultKt.throwOnFailure($result5);
                                            $this$awaitPointerEventScope4 = $this$awaitPointerEventScope3;
                                            i3 = 0;
                                            $result3 = $result5;
                                        } catch (CancellationException e3) {
                                            cancellation = e3;
                                            i = 0;
                                            if (!CoroutineScopeKt.isActive(coroutineScope)) {
                                                throw cancellation;
                                            }
                                            DragEvent event3 = DragEvent.DragCancelled.INSTANCE;
                                            channel.mo6233trySendJP2dKIU(event3);
                                            c16701 = c167013;
                                            $result2 = $result5;
                                            $this$awaitPointerEventScope = $this$awaitPointerEventScope3;
                                            if (CoroutineScopeKt.isActive(c16701.$$this$coroutineScope)) {
                                            }
                                        }
                                        isDragSuccessful = ((Boolean) $result5).booleanValue();
                                        if (isDragSuccessful) {
                                        }
                                        channel.mo6233trySendJP2dKIU(event2);
                                        $this$awaitPointerEventScope = $this$awaitPointerEventScope4;
                                        c16701 = c167013;
                                        $result2 = $result3;
                                        if (CoroutineScopeKt.isActive(c16701.$$this$coroutineScope)) {
                                        }
                                    } catch (Throwable th3) {
                                        cancellation = th3;
                                        if (i != 0) {
                                            long velocity2 = velocityTracker.m3466calculateVelocity9UxMQ8M();
                                            event = new DragEvent.DragStopped(Velocity.m4613timesadjELrA(velocity2, z ? -1.0f : 1.0f), null);
                                        } else {
                                            event = DragEvent.DragCancelled.INSTANCE;
                                        }
                                        channel.mo6233trySendJP2dKIU(event);
                                        throw cancellation;
                                    }
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x005c  */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invokeSuspend(Object $result) {
                        CancellationException exception;
                        CoroutineScope $this$coroutineScope;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                CoroutineScope $this$coroutineScope2 = (CoroutineScope) this.L$0;
                                try {
                                    this.L$0 = $this$coroutineScope2;
                                    this.label = 1;
                                } catch (CancellationException e) {
                                    exception = e;
                                    $this$coroutineScope = $this$coroutineScope2;
                                    if (!CoroutineScopeKt.isActive($this$coroutineScope)) {
                                    }
                                }
                                return this.$$this$pointerInput.awaitPointerEventScope(new C16701($this$coroutineScope2, this.$canDragState, this.$startImmediatelyState, this.$orientation, this.$channel, this.$reverseDirection, null), this) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                            case 1:
                                $this$coroutineScope = (CoroutineScope) this.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                } catch (CancellationException e2) {
                                    exception = e2;
                                    if (!CoroutineScopeKt.isActive($this$coroutineScope)) {
                                        throw exception;
                                    }
                                }
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
                            PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                            if (!this.$enabled) {
                                return Unit.INSTANCE;
                            }
                            this.label = 1;
                            if (CoroutineScopeKt.coroutineScope(new AnonymousClass1($this$pointerInput, this.$canDragState, this.$startImmediatelyState, this.$orientation, this.$channel, this.$reverseDirection, null), this) != coroutine_suspended) {
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

            /* compiled from: Draggable.kt */
            @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            @DebugMetadata(m296c = "androidx.compose.foundation.gestures.DraggableKt$draggable$9$2", m297f = "Draggable.kt", m298i = {0, 0, 1, 1, 2, 2, 3, 4, 5}, m299l = {236, 238, 240, 248, 250, 254}, m300m = "invokeSuspend", m301n = {"$this$LaunchedEffect", NotificationCompat.CATEGORY_EVENT, "$this$LaunchedEffect", NotificationCompat.CATEGORY_EVENT, "$this$LaunchedEffect", NotificationCompat.CATEGORY_EVENT, "$this$LaunchedEffect", "$this$LaunchedEffect", "$this$LaunchedEffect"}, m302s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$0"})
            /* renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$9$2 */
            static final class C00962 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Channel<DragEvent> $channel;
                final /* synthetic */ State<DragLogic> $dragLogic$delegate;
                final /* synthetic */ Orientation $orientation;
                final /* synthetic */ DraggableState $state;
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00962(Channel<DragEvent> channel, DraggableState draggableState, State<DragLogic> state, Orientation orientation, Continuation<? super C00962> continuation) {
                    super(2, continuation);
                    this.$channel = channel;
                    this.$state = draggableState;
                    this.$dragLogic$delegate = state;
                    this.$orientation = orientation;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00962 c00962 = new C00962(this.$channel, this.$state, this.$dragLogic$delegate, this.$orientation, continuation);
                    c00962.L$0 = obj;
                    return c00962;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00962) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* compiled from: Draggable.kt */
                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                @DebugMetadata(m296c = "androidx.compose.foundation.gestures.DraggableKt$draggable$9$2$2", m297f = "Draggable.kt", m298i = {0}, m299l = {243}, m300m = "invokeSuspend", m301n = {"$this$drag"}, m302s = {"L$0"})
                /* renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$9$2$2, reason: invalid class name */
                static final class AnonymousClass2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Channel<DragEvent> $channel;
                    final /* synthetic */ Ref.ObjectRef<DragEvent> $event;
                    final /* synthetic */ Orientation $orientation;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(Ref.ObjectRef<DragEvent> objectRef, Channel<DragEvent> channel, Orientation orientation, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.$event = objectRef;
                        this.$channel = channel;
                        this.$orientation = orientation;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$event, this.$channel, this.$orientation, continuation);
                        anonymousClass2.L$0 = obj;
                        return anonymousClass2;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x006e -> B:7:0x0075). Please report as a decompilation issue!!! */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invokeSuspend(Object obj) {
                        AnonymousClass2 anonymousClass2;
                        DragScope dragScope;
                        Object obj2;
                        Object obj3;
                        T t;
                        DragScope dragScope2;
                        Ref.ObjectRef<DragEvent> objectRef;
                        AnonymousClass2 anonymousClass22;
                        Object obj4;
                        float m608toFloat3MmeM6k;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure(obj);
                                anonymousClass2 = this;
                                dragScope = (DragScope) anonymousClass2.L$0;
                                obj2 = obj;
                                if ((anonymousClass2.$event.element instanceof DragEvent.DragStopped) && !(anonymousClass2.$event.element instanceof DragEvent.DragCancelled)) {
                                    DragEvent dragEvent = anonymousClass2.$event.element;
                                    DragEvent.DragDelta dragDelta = dragEvent instanceof DragEvent.DragDelta ? (DragEvent.DragDelta) dragEvent : null;
                                    if (dragDelta != null) {
                                        m608toFloat3MmeM6k = DraggableKt.m608toFloat3MmeM6k(dragDelta.getDelta(), anonymousClass2.$orientation);
                                        dragScope.dragBy(m608toFloat3MmeM6k);
                                    }
                                    Ref.ObjectRef<DragEvent> objectRef2 = anonymousClass2.$event;
                                    anonymousClass2.L$0 = dragScope;
                                    anonymousClass2.L$1 = objectRef2;
                                    anonymousClass2.label = 1;
                                    Object receive = anonymousClass2.$channel.receive(anonymousClass2);
                                    if (receive != coroutine_suspended) {
                                        Object obj5 = coroutine_suspended;
                                        obj3 = obj2;
                                        t = receive;
                                        dragScope2 = dragScope;
                                        objectRef = objectRef2;
                                        anonymousClass22 = anonymousClass2;
                                        obj4 = obj5;
                                        objectRef.element = t;
                                        obj2 = obj3;
                                        coroutine_suspended = obj4;
                                        anonymousClass2 = anonymousClass22;
                                        dragScope = dragScope2;
                                        if (anonymousClass2.$event.element instanceof DragEvent.DragStopped) {
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            case 1:
                                Ref.ObjectRef<DragEvent> objectRef3 = (Ref.ObjectRef) this.L$1;
                                DragScope dragScope3 = (DragScope) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                dragScope2 = dragScope3;
                                objectRef = objectRef3;
                                anonymousClass22 = this;
                                obj4 = coroutine_suspended;
                                obj3 = obj;
                                t = obj;
                                objectRef.element = t;
                                obj2 = obj3;
                                coroutine_suspended = obj4;
                                anonymousClass2 = anonymousClass22;
                                dragScope = dragScope2;
                                if (anonymousClass2.$event.element instanceof DragEvent.DragStopped) {
                                }
                                return Unit.INSTANCE;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:11:0x0078  */
                /* JADX WARN: Removed duplicated region for block: B:17:0x00a1  */
                /* JADX WARN: Removed duplicated region for block: B:24:0x00e8 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:25:0x00e9  */
                /* JADX WARN: Removed duplicated region for block: B:28:0x00f8 A[Catch: CancellationException -> 0x0042, TryCatch #0 {CancellationException -> 0x0042, blocks: (B:26:0x00eb, B:28:0x00f8, B:33:0x0113, B:35:0x0119, B:53:0x0024, B:56:0x002f, B:59:0x003d), top: B:2:0x0007 }] */
                /* JADX WARN: Removed duplicated region for block: B:33:0x0113 A[Catch: CancellationException -> 0x0042, TryCatch #0 {CancellationException -> 0x0042, blocks: (B:26:0x00eb, B:28:0x00f8, B:33:0x0113, B:35:0x0119, B:53:0x0024, B:56:0x002f, B:59:0x003d), top: B:2:0x0007 }] */
                /* JADX WARN: Removed duplicated region for block: B:47:0x0143 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:48:0x0144  */
                /* JADX WARN: Removed duplicated region for block: B:49:0x0148  */
                /* JADX WARN: Removed duplicated region for block: B:50:0x014e  */
                /* JADX WARN: Type inference failed for: r1v0, types: [int] */
                /* JADX WARN: Type inference failed for: r1v10 */
                /* JADX WARN: Type inference failed for: r1v11, types: [androidx.compose.foundation.gestures.DraggableKt$draggable$9$2] */
                /* JADX WARN: Type inference failed for: r1v16, types: [androidx.compose.foundation.gestures.DraggableKt$draggable$9$2] */
                /* JADX WARN: Type inference failed for: r1v17, types: [androidx.compose.foundation.gestures.DraggableKt$draggable$9$2] */
                /* JADX WARN: Type inference failed for: r1v19 */
                /* JADX WARN: Type inference failed for: r1v20 */
                /* JADX WARN: Type inference failed for: r1v22 */
                /* JADX WARN: Type inference failed for: r1v23 */
                /* JADX WARN: Type inference failed for: r1v3, types: [androidx.compose.foundation.gestures.DraggableKt$draggable$9$2, kotlin.coroutines.Continuation] */
                /* JADX WARN: Type inference failed for: r1v6 */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x012a -> B:9:0x0072). Please report as a decompilation issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0144 -> B:8:0x0145). Please report as a decompilation issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0148 -> B:9:0x0072). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    CoroutineScope coroutineScope;
                    DragLogic m616invoke$lambda3;
                    Ref.ObjectRef objectRef;
                    CoroutineScope coroutineScope2;
                    CoroutineScope coroutineScope3;
                    Ref.ObjectRef objectRef2;
                    T t;
                    Ref.ObjectRef objectRef3;
                    Ref.ObjectRef objectRef4;
                    C00962 c00962;
                    Object obj2;
                    Object obj3;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    C00962 c009622 = this.label;
                    try {
                    } catch (CancellationException e) {
                        m616invoke$lambda3 = DraggableKt$draggable$9.m616invoke$lambda3(c009622.$dragLogic$delegate);
                        c009622.L$0 = coroutineScope;
                        c009622.L$1 = null;
                        c009622.label = 6;
                        if (m616invoke$lambda3.processDragCancel(coroutineScope, c009622) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c009622 = c009622;
                        obj = obj;
                        coroutineScope2 = coroutineScope;
                        if (!CoroutineScopeKt.isActive(coroutineScope2)) {
                        }
                    }
                    switch (c009622) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            c009622 = this;
                            coroutineScope2 = (CoroutineScope) c009622.L$0;
                            if (!CoroutineScopeKt.isActive(coroutineScope2)) {
                                objectRef4 = new Ref.ObjectRef();
                                c009622.L$0 = coroutineScope2;
                                c009622.L$1 = objectRef4;
                                c009622.L$2 = objectRef4;
                                c009622.label = 1;
                                Object receive = c009622.$channel.receive(c009622);
                                if (receive == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                objectRef3 = objectRef4;
                                Object obj4 = coroutine_suspended;
                                obj3 = obj;
                                t = receive;
                                coroutineScope3 = coroutineScope2;
                                c00962 = c009622;
                                obj2 = obj4;
                                objectRef4.element = t;
                                if (objectRef3.element instanceof DragEvent.DragStarted) {
                                    obj = obj3;
                                    coroutine_suspended = obj2;
                                    c009622 = c00962;
                                    coroutineScope2 = coroutineScope3;
                                    if (!CoroutineScopeKt.isActive(coroutineScope2)) {
                                    }
                                } else {
                                    DragLogic m616invoke$lambda32 = DraggableKt$draggable$9.m616invoke$lambda3(c00962.$dragLogic$delegate);
                                    T t2 = objectRef3.element;
                                    Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type androidx.compose.foundation.gestures.DragEvent.DragStarted");
                                    c00962.L$0 = coroutineScope3;
                                    c00962.L$1 = objectRef3;
                                    c00962.L$2 = null;
                                    c00962.label = 2;
                                    if (m616invoke$lambda32.processDragStart(coroutineScope3, (DragEvent.DragStarted) t2, c00962) == obj2) {
                                        return obj2;
                                    }
                                    obj = obj3;
                                    coroutine_suspended = obj2;
                                    c009622 = c00962;
                                    objectRef2 = objectRef3;
                                    try {
                                    } catch (CancellationException e2) {
                                        coroutineScope = coroutineScope3;
                                        m616invoke$lambda3 = DraggableKt$draggable$9.m616invoke$lambda3(c009622.$dragLogic$delegate);
                                        c009622.L$0 = coroutineScope;
                                        c009622.L$1 = null;
                                        c009622.label = 6;
                                        if (m616invoke$lambda3.processDragCancel(coroutineScope, c009622) != coroutine_suspended) {
                                        }
                                    }
                                    c009622.L$0 = coroutineScope3;
                                    c009622.L$1 = objectRef2;
                                    c009622.label = 3;
                                    if (c009622.$state.drag(MutatePriority.UserInput, new AnonymousClass2(objectRef2, c009622.$channel, c009622.$orientation, null), c009622) != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    objectRef = objectRef2;
                                    coroutineScope = coroutineScope3;
                                    c009622 = c009622;
                                    obj = obj;
                                    DragLogic m616invoke$lambda33 = DraggableKt$draggable$9.m616invoke$lambda3(c009622.$dragLogic$delegate);
                                    if (objectRef.element instanceof DragEvent.DragStopped) {
                                        T t3 = objectRef.element;
                                        Intrinsics.checkNotNull(t3, "null cannot be cast to non-null type androidx.compose.foundation.gestures.DragEvent.DragStopped");
                                        c009622.L$0 = coroutineScope;
                                        c009622.L$1 = null;
                                        c009622.label = 4;
                                        if (m616invoke$lambda33.processDragStop(coroutineScope, (DragEvent.DragStopped) t3, c009622) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        coroutineScope2 = coroutineScope;
                                    } else if (objectRef.element instanceof DragEvent.DragCancelled) {
                                        c009622.L$0 = coroutineScope;
                                        c009622.L$1 = null;
                                        c009622.label = 5;
                                        if (m616invoke$lambda33.processDragCancel(coroutineScope, c009622) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        coroutineScope2 = coroutineScope;
                                    } else {
                                        coroutineScope2 = coroutineScope;
                                    }
                                    if (!CoroutineScopeKt.isActive(coroutineScope2)) {
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                            break;
                        case 1:
                            Ref.ObjectRef objectRef5 = (Ref.ObjectRef) this.L$2;
                            Ref.ObjectRef objectRef6 = (Ref.ObjectRef) this.L$1;
                            coroutineScope3 = (CoroutineScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            objectRef3 = objectRef6;
                            objectRef4 = objectRef5;
                            c00962 = this;
                            obj2 = coroutine_suspended;
                            obj3 = obj;
                            t = obj;
                            objectRef4.element = t;
                            if (objectRef3.element instanceof DragEvent.DragStarted) {
                            }
                            break;
                        case 2:
                            C00962 c009623 = this;
                            objectRef2 = (Ref.ObjectRef) c009623.L$1;
                            coroutineScope3 = (CoroutineScope) c009623.L$0;
                            ResultKt.throwOnFailure(obj);
                            c009622 = c009623;
                            obj = obj;
                            c009622.L$0 = coroutineScope3;
                            c009622.L$1 = objectRef2;
                            c009622.label = 3;
                            if (c009622.$state.drag(MutatePriority.UserInput, new AnonymousClass2(objectRef2, c009622.$channel, c009622.$orientation, null), c009622) != coroutine_suspended) {
                            }
                            break;
                        case 3:
                            C00962 c009624 = this;
                            objectRef = (Ref.ObjectRef) c009624.L$1;
                            coroutineScope = (CoroutineScope) c009624.L$0;
                            ResultKt.throwOnFailure(obj);
                            c009622 = c009624;
                            obj = obj;
                            DragLogic m616invoke$lambda332 = DraggableKt$draggable$9.m616invoke$lambda3(c009622.$dragLogic$delegate);
                            if (objectRef.element instanceof DragEvent.DragStopped) {
                            }
                            if (!CoroutineScopeKt.isActive(coroutineScope2)) {
                            }
                            break;
                        case 4:
                            c009622 = this;
                            CoroutineScope coroutineScope4 = (CoroutineScope) c009622.L$0;
                            ResultKt.throwOnFailure(obj);
                            coroutineScope2 = coroutineScope4;
                            if (!CoroutineScopeKt.isActive(coroutineScope2)) {
                            }
                            break;
                        case 5:
                            c009622 = this;
                            CoroutineScope coroutineScope5 = (CoroutineScope) c009622.L$0;
                            ResultKt.throwOnFailure(obj);
                            coroutineScope2 = coroutineScope5;
                            if (!CoroutineScopeKt.isActive(coroutineScope2)) {
                            }
                            break;
                        case 6:
                            C00962 c009625 = this;
                            coroutineScope = (CoroutineScope) c009625.L$0;
                            ResultKt.throwOnFailure(obj);
                            c009622 = c009625;
                            obj = obj;
                            coroutineScope2 = coroutineScope;
                            if (!CoroutineScopeKt.isActive(coroutineScope2)) {
                            }
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0339 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01fe A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0260 -> B:20:0x0188). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x02d2 -> B:12:0x02dd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x033b -> B:20:0x0188). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitDownAndSlop(AwaitPointerEventScope $this$awaitDownAndSlop, State<? extends Function1<? super PointerInputChange, Boolean>> state, State<? extends Function0<Boolean>> state2, VelocityTracker velocityTracker, Orientation orientation, Continuation<? super Pair<PointerInputChange, Offset>> continuation) {
        DraggableKt$awaitDownAndSlop$1 draggableKt$awaitDownAndSlop$1;
        DraggableKt$awaitDownAndSlop$1 draggableKt$awaitDownAndSlop$12;
        State startDragImmediately;
        State canDrag;
        final VelocityTracker velocityTracker2;
        Object awaitFirstDownOnPass;
        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
        Orientation orientation2;
        PointerInputChange initialDown;
        Object awaitFirstDown;
        final Ref.LongRef initialDelta;
        Function2 postPointerSlop;
        long pointerId$iv;
        PointerDirectionConfig pointerDirectionConfig$iv;
        int i;
        int i2;
        float totalCrossPositionChange$iv;
        Ref.LongRef pointer$iv;
        float totalMainPositionChange$iv;
        float totalCrossPositionChange$iv2;
        PointerInputChange afterSlopResult;
        PointerDirectionConfig pointerDirectionConfig$iv2;
        Ref.LongRef pointer$iv2;
        float totalCrossPositionChange$iv3;
        int i3;
        Object obj;
        Object $result;
        int i4;
        List $this$fastForEach$iv$iv$iv;
        int size;
        int index$iv$iv$iv;
        Object $result2;
        Object obj2;
        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
        Ref.LongRef initialDelta2;
        Object it$iv$iv;
        PointerInputChange pointerInputChange;
        DraggableKt$awaitDownAndSlop$1 draggableKt$awaitDownAndSlop$13;
        long offset$iv;
        PointerInputChange dragEvent$iv;
        float totalMainPositionChange$iv2;
        Object it$iv$iv2;
        List $this$fastForEach$iv$iv$iv2;
        if (continuation instanceof DraggableKt$awaitDownAndSlop$1) {
            draggableKt$awaitDownAndSlop$1 = (DraggableKt$awaitDownAndSlop$1) continuation;
            if ((draggableKt$awaitDownAndSlop$1.label & Integer.MIN_VALUE) != 0) {
                draggableKt$awaitDownAndSlop$1.label -= Integer.MIN_VALUE;
                draggableKt$awaitDownAndSlop$12 = draggableKt$awaitDownAndSlop$1;
                Object $result3 = draggableKt$awaitDownAndSlop$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = 1;
                PointerEventPass pointerEventPass = null;
                switch (draggableKt$awaitDownAndSlop$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result3);
                        startDragImmediately = state2;
                        canDrag = state;
                        velocityTracker2 = velocityTracker;
                        PointerEventPass pointerEventPass2 = PointerEventPass.Initial;
                        draggableKt$awaitDownAndSlop$12.L$0 = $this$awaitDownAndSlop;
                        draggableKt$awaitDownAndSlop$12.L$1 = canDrag;
                        draggableKt$awaitDownAndSlop$12.L$2 = startDragImmediately;
                        draggableKt$awaitDownAndSlop$12.L$3 = velocityTracker2;
                        draggableKt$awaitDownAndSlop$12.L$4 = orientation;
                        draggableKt$awaitDownAndSlop$12.label = 1;
                        awaitFirstDownOnPass = TapGestureDetectorKt.awaitFirstDownOnPass($this$awaitDownAndSlop, pointerEventPass2, false, draggableKt$awaitDownAndSlop$12);
                        if (awaitFirstDownOnPass == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitDownAndSlop;
                        orientation2 = orientation;
                        initialDown = (PointerInputChange) awaitFirstDownOnPass;
                        if (canDrag.getValue().invoke(initialDown).booleanValue()) {
                            return null;
                        }
                        if (startDragImmediately.getValue().invoke().booleanValue()) {
                            initialDown.consume();
                            VelocityTrackerKt.addPointerInputChange(velocityTracker2, initialDown);
                            return TuplesKt.m294to(initialDown, Offset.m1749boximpl(Offset.INSTANCE.m1776getZeroF1C5BW0()));
                        }
                        draggableKt$awaitDownAndSlop$12.L$0 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                        draggableKt$awaitDownAndSlop$12.L$1 = velocityTracker2;
                        draggableKt$awaitDownAndSlop$12.L$2 = orientation2;
                        draggableKt$awaitDownAndSlop$12.L$3 = null;
                        draggableKt$awaitDownAndSlop$12.L$4 = null;
                        draggableKt$awaitDownAndSlop$12.label = 2;
                        awaitFirstDown = TapGestureDetectorKt.awaitFirstDown($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, false, draggableKt$awaitDownAndSlop$12);
                        if (awaitFirstDown == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        PointerInputChange down = (PointerInputChange) awaitFirstDown;
                        VelocityTrackerKt.addPointerInputChange(velocityTracker2, down);
                        initialDelta = new Ref.LongRef();
                        initialDelta.element = Offset.INSTANCE.m1776getZeroF1C5BW0();
                        postPointerSlop = new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$postPointerSlop$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange2, Offset offset) {
                                m610invokeUv8p0NA(pointerInputChange2, offset.getPackedValue());
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                            public final void m610invokeUv8p0NA(PointerInputChange event, long offset) {
                                Intrinsics.checkNotNullParameter(event, "event");
                                VelocityTrackerKt.addPointerInputChange(VelocityTracker.this, event);
                                event.consume();
                                initialDelta.element = offset;
                            }
                        };
                        pointerId$iv = down.getId();
                        int pointerType$iv = down.getType();
                        pointerDirectionConfig$iv = DragGestureDetectorKt.toPointerDirectionConfig(orientation2);
                        i = 1;
                        i2 = 0;
                        if (!DragGestureDetectorKt.m594isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv.getCurrentEvent(), pointerId$iv)) {
                            afterSlopResult = null;
                            if (afterSlopResult != null) {
                                return TuplesKt.m294to(afterSlopResult, Offset.m1749boximpl(initialDelta.element));
                            }
                            return null;
                        }
                        totalCrossPositionChange$iv = DragGestureDetectorKt.m595pointerSlopE8SPZFQ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv.getViewConfiguration(), pointerType$iv);
                        pointer$iv = new Ref.LongRef();
                        pointer$iv.element = pointerId$iv;
                        totalMainPositionChange$iv = 0.0f;
                        totalCrossPositionChange$iv2 = 0.0f;
                        draggableKt$awaitDownAndSlop$12.L$0 = initialDelta;
                        draggableKt$awaitDownAndSlop$12.L$1 = postPointerSlop;
                        draggableKt$awaitDownAndSlop$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                        draggableKt$awaitDownAndSlop$12.L$3 = pointerDirectionConfig$iv;
                        draggableKt$awaitDownAndSlop$12.L$4 = pointer$iv;
                        draggableKt$awaitDownAndSlop$12.L$5 = pointerEventPass;
                        draggableKt$awaitDownAndSlop$12.I$0 = i;
                        draggableKt$awaitDownAndSlop$12.F$0 = totalCrossPositionChange$iv;
                        draggableKt$awaitDownAndSlop$12.F$1 = totalMainPositionChange$iv;
                        draggableKt$awaitDownAndSlop$12.F$2 = totalCrossPositionChange$iv2;
                        draggableKt$awaitDownAndSlop$12.label = 3;
                        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, pointerEventPass, draggableKt$awaitDownAndSlop$12, i5, pointerEventPass);
                        if (awaitPointerEvent$default != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj3 = coroutine_suspended;
                        $result = $result3;
                        $result3 = awaitPointerEvent$default;
                        pointer$iv2 = pointer$iv;
                        i3 = i2;
                        i4 = i;
                        totalCrossPositionChange$iv3 = totalCrossPositionChange$iv2;
                        pointerDirectionConfig$iv2 = pointerDirectionConfig$iv;
                        obj = obj3;
                        PointerEvent event$iv = (PointerEvent) $result3;
                        List $this$fastFirstOrNull$iv$iv = event$iv.getChanges();
                        $this$fastForEach$iv$iv$iv = $this$fastFirstOrNull$iv$iv;
                        size = $this$fastForEach$iv$iv$iv.size();
                        index$iv$iv$iv = 0;
                        while (true) {
                            if (index$iv$iv$iv < size) {
                                $result2 = $result;
                                $this$fastForEach$iv$iv$iv2 = $this$fastForEach$iv$iv$iv;
                                Object item$iv$iv$iv = $this$fastForEach$iv$iv$iv2.get(index$iv$iv$iv);
                                it$iv$iv = item$iv$iv$iv;
                                PointerInputChange it$iv = (PointerInputChange) it$iv$iv;
                                obj2 = obj;
                                $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                                initialDelta2 = initialDelta;
                                if (!PointerId.m3349equalsimpl0(it$iv.getId(), pointer$iv2.element)) {
                                    index$iv$iv$iv++;
                                    obj = obj2;
                                    $result = $result2;
                                    $this$fastForEach$iv$iv$iv = $this$fastForEach$iv$iv$iv2;
                                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                    initialDelta = initialDelta2;
                                }
                            } else {
                                $result2 = $result;
                                obj2 = obj;
                                $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                                initialDelta2 = initialDelta;
                                it$iv$iv = null;
                            }
                        }
                        pointerInputChange = (PointerInputChange) it$iv$iv;
                        if (pointerInputChange == null) {
                            initialDelta = initialDelta2;
                            afterSlopResult = null;
                        } else {
                            afterSlopResult = pointerInputChange;
                            if (afterSlopResult.isConsumed()) {
                                initialDelta = initialDelta2;
                                afterSlopResult = null;
                            } else {
                                if (PointerEventKt.changedToUpIgnoreConsumed(afterSlopResult)) {
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
                                        initialDelta = initialDelta2;
                                        afterSlopResult = null;
                                    } else {
                                        pointer$iv2.element = otherDown$iv.getId();
                                        coroutine_suspended = obj2;
                                        $result3 = $result2;
                                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                        initialDelta = initialDelta2;
                                        pointerDirectionConfig$iv = pointerDirectionConfig$iv2;
                                        totalCrossPositionChange$iv2 = totalCrossPositionChange$iv3;
                                        i = i4;
                                        i2 = i3;
                                        pointer$iv = pointer$iv2;
                                        i5 = 1;
                                        pointerEventPass = null;
                                        draggableKt$awaitDownAndSlop$12.L$0 = initialDelta;
                                        draggableKt$awaitDownAndSlop$12.L$1 = postPointerSlop;
                                        draggableKt$awaitDownAndSlop$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                                        draggableKt$awaitDownAndSlop$12.L$3 = pointerDirectionConfig$iv;
                                        draggableKt$awaitDownAndSlop$12.L$4 = pointer$iv;
                                        draggableKt$awaitDownAndSlop$12.L$5 = pointerEventPass;
                                        draggableKt$awaitDownAndSlop$12.I$0 = i;
                                        draggableKt$awaitDownAndSlop$12.F$0 = totalCrossPositionChange$iv;
                                        draggableKt$awaitDownAndSlop$12.F$1 = totalMainPositionChange$iv;
                                        draggableKt$awaitDownAndSlop$12.F$2 = totalCrossPositionChange$iv2;
                                        draggableKt$awaitDownAndSlop$12.label = 3;
                                        Object awaitPointerEvent$default2 = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, pointerEventPass, draggableKt$awaitDownAndSlop$12, i5, pointerEventPass);
                                        if (awaitPointerEvent$default2 != coroutine_suspended) {
                                        }
                                    }
                                } else {
                                    long currentPosition$iv = afterSlopResult.getPosition();
                                    long previousPosition$iv = afterSlopResult.getPreviousPosition();
                                    float mainPositionChange$iv = pointerDirectionConfig$iv2.mo598mainAxisDeltak4lQ0M(currentPosition$iv) - pointerDirectionConfig$iv2.mo598mainAxisDeltak4lQ0M(previousPosition$iv);
                                    float crossPositionChange$iv = pointerDirectionConfig$iv2.mo597crossAxisDeltak4lQ0M(currentPosition$iv) - pointerDirectionConfig$iv2.mo597crossAxisDeltak4lQ0M(previousPosition$iv);
                                    float totalMainPositionChange$iv3 = totalMainPositionChange$iv + mainPositionChange$iv;
                                    float mainPositionChange$iv2 = totalCrossPositionChange$iv3 + crossPositionChange$iv;
                                    float inDirection$iv = i4 != 0 ? Math.abs(totalMainPositionChange$iv3) : Offset.m1758getDistanceimpl(pointerDirectionConfig$iv2.mo599offsetFromChangesdBAh8RU(totalMainPositionChange$iv3, mainPositionChange$iv2));
                                    if (inDirection$iv < totalCrossPositionChange$iv) {
                                        PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                                        initialDelta = initialDelta2;
                                        draggableKt$awaitDownAndSlop$12.L$0 = initialDelta;
                                        draggableKt$awaitDownAndSlop$12.L$1 = postPointerSlop;
                                        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv3 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                        draggableKt$awaitDownAndSlop$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv3;
                                        draggableKt$awaitDownAndSlop$12.L$3 = pointerDirectionConfig$iv2;
                                        draggableKt$awaitDownAndSlop$12.L$4 = pointer$iv2;
                                        draggableKt$awaitDownAndSlop$12.L$5 = afterSlopResult;
                                        draggableKt$awaitDownAndSlop$12.I$0 = i4;
                                        draggableKt$awaitDownAndSlop$12.F$0 = totalCrossPositionChange$iv;
                                        draggableKt$awaitDownAndSlop$12.F$1 = totalMainPositionChange$iv3;
                                        draggableKt$awaitDownAndSlop$12.F$2 = mainPositionChange$iv2;
                                        draggableKt$awaitDownAndSlop$12.label = 4;
                                        Object obj4 = obj2;
                                        if ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv3.awaitPointerEvent(pointerEventPass3, draggableKt$awaitDownAndSlop$12) == obj4) {
                                            return obj4;
                                        }
                                        dragEvent$iv = afterSlopResult;
                                        coroutine_suspended = obj4;
                                        totalMainPositionChange$iv2 = totalMainPositionChange$iv3;
                                        pointerDirectionConfig$iv = pointerDirectionConfig$iv2;
                                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv3;
                                        i = i4;
                                        i2 = i3;
                                        pointer$iv = pointer$iv2;
                                        totalCrossPositionChange$iv2 = mainPositionChange$iv2;
                                        $result3 = $result2;
                                        if (dragEvent$iv.isConsumed()) {
                                            totalMainPositionChange$iv = totalMainPositionChange$iv2;
                                            i5 = 1;
                                            pointerEventPass = null;
                                            draggableKt$awaitDownAndSlop$12.L$0 = initialDelta;
                                            draggableKt$awaitDownAndSlop$12.L$1 = postPointerSlop;
                                            draggableKt$awaitDownAndSlop$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                                            draggableKt$awaitDownAndSlop$12.L$3 = pointerDirectionConfig$iv;
                                            draggableKt$awaitDownAndSlop$12.L$4 = pointer$iv;
                                            draggableKt$awaitDownAndSlop$12.L$5 = pointerEventPass;
                                            draggableKt$awaitDownAndSlop$12.I$0 = i;
                                            draggableKt$awaitDownAndSlop$12.F$0 = totalCrossPositionChange$iv;
                                            draggableKt$awaitDownAndSlop$12.F$1 = totalMainPositionChange$iv;
                                            draggableKt$awaitDownAndSlop$12.F$2 = totalCrossPositionChange$iv2;
                                            draggableKt$awaitDownAndSlop$12.label = 3;
                                            Object awaitPointerEvent$default22 = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, pointerEventPass, draggableKt$awaitDownAndSlop$12, i5, pointerEventPass);
                                            if (awaitPointerEvent$default22 != coroutine_suspended) {
                                            }
                                        } else {
                                            afterSlopResult = null;
                                        }
                                    } else {
                                        Object obj5 = obj2;
                                        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv4 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                        initialDelta = initialDelta2;
                                        if (i4 != 0) {
                                            float finalMainPositionChange$iv = totalMainPositionChange$iv3 - (Math.signum(totalMainPositionChange$iv3) * totalCrossPositionChange$iv);
                                            offset$iv = pointerDirectionConfig$iv2.mo599offsetFromChangesdBAh8RU(finalMainPositionChange$iv, mainPositionChange$iv2);
                                            draggableKt$awaitDownAndSlop$13 = draggableKt$awaitDownAndSlop$12;
                                        } else {
                                            long offset$iv2 = pointerDirectionConfig$iv2.mo599offsetFromChangesdBAh8RU(totalMainPositionChange$iv3, mainPositionChange$iv2);
                                            draggableKt$awaitDownAndSlop$13 = draggableKt$awaitDownAndSlop$12;
                                            long touchSlopOffset$iv = Offset.m1767timestuRUvjQ(Offset.m1755divtuRUvjQ(offset$iv2, inDirection$iv), totalCrossPositionChange$iv);
                                            offset$iv = Offset.m1764minusMKHz9U(offset$iv2, touchSlopOffset$iv);
                                        }
                                        long touchSlopOffset$iv2 = offset$iv;
                                        postPointerSlop.invoke(afterSlopResult, Offset.m1749boximpl(touchSlopOffset$iv2));
                                        if (!afterSlopResult.isConsumed()) {
                                            $result3 = $result2;
                                            coroutine_suspended = obj5;
                                            $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv4;
                                            i = i4;
                                            i2 = i3;
                                            pointer$iv = pointer$iv2;
                                            i5 = 1;
                                            pointerEventPass = null;
                                            PointerDirectionConfig pointerDirectionConfig = pointerDirectionConfig$iv2;
                                            totalCrossPositionChange$iv2 = 0.0f;
                                            draggableKt$awaitDownAndSlop$12 = draggableKt$awaitDownAndSlop$13;
                                            totalMainPositionChange$iv = 0.0f;
                                            pointerDirectionConfig$iv = pointerDirectionConfig;
                                            draggableKt$awaitDownAndSlop$12.L$0 = initialDelta;
                                            draggableKt$awaitDownAndSlop$12.L$1 = postPointerSlop;
                                            draggableKt$awaitDownAndSlop$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                                            draggableKt$awaitDownAndSlop$12.L$3 = pointerDirectionConfig$iv;
                                            draggableKt$awaitDownAndSlop$12.L$4 = pointer$iv;
                                            draggableKt$awaitDownAndSlop$12.L$5 = pointerEventPass;
                                            draggableKt$awaitDownAndSlop$12.I$0 = i;
                                            draggableKt$awaitDownAndSlop$12.F$0 = totalCrossPositionChange$iv;
                                            draggableKt$awaitDownAndSlop$12.F$1 = totalMainPositionChange$iv;
                                            draggableKt$awaitDownAndSlop$12.F$2 = totalCrossPositionChange$iv2;
                                            draggableKt$awaitDownAndSlop$12.label = 3;
                                            Object awaitPointerEvent$default222 = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, pointerEventPass, draggableKt$awaitDownAndSlop$12, i5, pointerEventPass);
                                            if (awaitPointerEvent$default222 != coroutine_suspended) {
                                            }
                                        }
                                    }
                                }
                                PointerEvent event$iv2 = (PointerEvent) $result3;
                                List $this$fastFirstOrNull$iv$iv2 = event$iv2.getChanges();
                                $this$fastForEach$iv$iv$iv = $this$fastFirstOrNull$iv$iv2;
                                size = $this$fastForEach$iv$iv$iv.size();
                                index$iv$iv$iv = 0;
                                while (true) {
                                    if (index$iv$iv$iv < size) {
                                    }
                                    index$iv$iv$iv++;
                                    obj = obj2;
                                    $result = $result2;
                                    $this$fastForEach$iv$iv$iv = $this$fastForEach$iv$iv$iv2;
                                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                    initialDelta = initialDelta2;
                                }
                                pointerInputChange = (PointerInputChange) it$iv$iv;
                                if (pointerInputChange == null) {
                                }
                            }
                        }
                        if (afterSlopResult != null) {
                        }
                    case 1:
                        orientation2 = (Orientation) draggableKt$awaitDownAndSlop$12.L$4;
                        VelocityTracker velocityTracker3 = (VelocityTracker) draggableKt$awaitDownAndSlop$12.L$3;
                        startDragImmediately = (State) draggableKt$awaitDownAndSlop$12.L$2;
                        canDrag = (State) draggableKt$awaitDownAndSlop$12.L$1;
                        AwaitPointerEventScope $this$awaitDownAndSlop2 = (AwaitPointerEventScope) draggableKt$awaitDownAndSlop$12.L$0;
                        ResultKt.throwOnFailure($result3);
                        awaitFirstDownOnPass = $result3;
                        velocityTracker2 = velocityTracker3;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitDownAndSlop2;
                        initialDown = (PointerInputChange) awaitFirstDownOnPass;
                        if (canDrag.getValue().invoke(initialDown).booleanValue()) {
                        }
                        break;
                    case 2:
                        orientation2 = (Orientation) draggableKt$awaitDownAndSlop$12.L$2;
                        VelocityTracker velocityTracker4 = (VelocityTracker) draggableKt$awaitDownAndSlop$12.L$1;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = (AwaitPointerEventScope) draggableKt$awaitDownAndSlop$12.L$0;
                        ResultKt.throwOnFailure($result3);
                        velocityTracker2 = velocityTracker4;
                        awaitFirstDown = $result3;
                        PointerInputChange down2 = (PointerInputChange) awaitFirstDown;
                        VelocityTrackerKt.addPointerInputChange(velocityTracker2, down2);
                        initialDelta = new Ref.LongRef();
                        initialDelta.element = Offset.INSTANCE.m1776getZeroF1C5BW0();
                        postPointerSlop = new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$postPointerSlop$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange2, Offset offset) {
                                m610invokeUv8p0NA(pointerInputChange2, offset.getPackedValue());
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                            public final void m610invokeUv8p0NA(PointerInputChange event, long offset) {
                                Intrinsics.checkNotNullParameter(event, "event");
                                VelocityTrackerKt.addPointerInputChange(VelocityTracker.this, event);
                                event.consume();
                                initialDelta.element = offset;
                            }
                        };
                        pointerId$iv = down2.getId();
                        int pointerType$iv2 = down2.getType();
                        pointerDirectionConfig$iv = DragGestureDetectorKt.toPointerDirectionConfig(orientation2);
                        i = 1;
                        i2 = 0;
                        if (!DragGestureDetectorKt.m594isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv.getCurrentEvent(), pointerId$iv)) {
                        }
                        break;
                    case 3:
                        float totalCrossPositionChange$iv4 = draggableKt$awaitDownAndSlop$12.F$2;
                        float totalMainPositionChange$iv4 = draggableKt$awaitDownAndSlop$12.F$1;
                        float touchSlop$iv = draggableKt$awaitDownAndSlop$12.F$0;
                        int i6 = draggableKt$awaitDownAndSlop$12.I$0;
                        Ref.LongRef pointer$iv3 = (Ref.LongRef) draggableKt$awaitDownAndSlop$12.L$4;
                        pointerDirectionConfig$iv2 = (PointerDirectionConfig) draggableKt$awaitDownAndSlop$12.L$3;
                        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv5 = (AwaitPointerEventScope) draggableKt$awaitDownAndSlop$12.L$2;
                        Function2 postPointerSlop2 = (Function2) draggableKt$awaitDownAndSlop$12.L$1;
                        Ref.LongRef initialDelta3 = (Ref.LongRef) draggableKt$awaitDownAndSlop$12.L$0;
                        ResultKt.throwOnFailure($result3);
                        pointer$iv2 = pointer$iv3;
                        totalMainPositionChange$iv = totalMainPositionChange$iv4;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv5;
                        totalCrossPositionChange$iv3 = totalCrossPositionChange$iv4;
                        totalCrossPositionChange$iv = touchSlop$iv;
                        initialDelta = initialDelta3;
                        i3 = 0;
                        obj = coroutine_suspended;
                        $result = $result3;
                        i4 = i6;
                        postPointerSlop = postPointerSlop2;
                        PointerEvent event$iv22 = (PointerEvent) $result3;
                        List $this$fastFirstOrNull$iv$iv22 = event$iv22.getChanges();
                        $this$fastForEach$iv$iv$iv = $this$fastFirstOrNull$iv$iv22;
                        size = $this$fastForEach$iv$iv$iv.size();
                        index$iv$iv$iv = 0;
                        while (true) {
                            if (index$iv$iv$iv < size) {
                            }
                            index$iv$iv$iv++;
                            obj = obj2;
                            $result = $result2;
                            $this$fastForEach$iv$iv$iv = $this$fastForEach$iv$iv$iv2;
                            $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                            initialDelta = initialDelta2;
                        }
                        pointerInputChange = (PointerInputChange) it$iv$iv;
                        if (pointerInputChange == null) {
                        }
                        if (afterSlopResult != null) {
                        }
                        break;
                    case 4:
                        float totalCrossPositionChange$iv5 = draggableKt$awaitDownAndSlop$12.F$2;
                        float totalMainPositionChange$iv5 = draggableKt$awaitDownAndSlop$12.F$1;
                        float touchSlop$iv2 = draggableKt$awaitDownAndSlop$12.F$0;
                        int i7 = draggableKt$awaitDownAndSlop$12.I$0;
                        dragEvent$iv = (PointerInputChange) draggableKt$awaitDownAndSlop$12.L$5;
                        Ref.LongRef pointer$iv4 = (Ref.LongRef) draggableKt$awaitDownAndSlop$12.L$4;
                        PointerDirectionConfig pointerDirectionConfig$iv3 = (PointerDirectionConfig) draggableKt$awaitDownAndSlop$12.L$3;
                        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv6 = (AwaitPointerEventScope) draggableKt$awaitDownAndSlop$12.L$2;
                        Function2 postPointerSlop3 = (Function2) draggableKt$awaitDownAndSlop$12.L$1;
                        Ref.LongRef initialDelta4 = (Ref.LongRef) draggableKt$awaitDownAndSlop$12.L$0;
                        ResultKt.throwOnFailure($result3);
                        totalMainPositionChange$iv2 = totalMainPositionChange$iv5;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv6;
                        i2 = 0;
                        pointerDirectionConfig$iv = pointerDirectionConfig$iv3;
                        i = i7;
                        postPointerSlop = postPointerSlop3;
                        pointer$iv = pointer$iv4;
                        totalCrossPositionChange$iv2 = totalCrossPositionChange$iv5;
                        totalCrossPositionChange$iv = touchSlop$iv2;
                        initialDelta = initialDelta4;
                        if (dragEvent$iv.isConsumed()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        draggableKt$awaitDownAndSlop$1 = new DraggableKt$awaitDownAndSlop$1(continuation);
        draggableKt$awaitDownAndSlop$12 = draggableKt$awaitDownAndSlop$1;
        Object $result32 = draggableKt$awaitDownAndSlop$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i52 = 1;
        PointerEventPass pointerEventPass4 = null;
        switch (draggableKt$awaitDownAndSlop$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: awaitDrag-Su4bsnU, reason: not valid java name */
    public static final Object m607awaitDragSu4bsnU(AwaitPointerEventScope $this$awaitDrag_u2dSu4bsnU, PointerInputChange startEvent, long initialDelta, final VelocityTracker velocityTracker, final SendChannel<? super DragEvent> sendChannel, final boolean reverseDirection, Orientation orientation, Continuation<? super Boolean> continuation) {
        float xSign = Math.signum(Offset.m1760getXimpl(startEvent.getPosition()));
        float ySign = Math.signum(Offset.m1761getYimpl(startEvent.getPosition()));
        long adjustedStart = Offset.m1764minusMKHz9U(startEvent.getPosition(), OffsetKt.Offset(Offset.m1760getXimpl(initialDelta) * xSign, Offset.m1761getYimpl(initialDelta) * ySign));
        sendChannel.mo6233trySendJP2dKIU(new DragEvent.DragStarted(adjustedStart, null));
        long overSlopOffset = reverseDirection ? Offset.m1767timestuRUvjQ(initialDelta, -1.0f) : initialDelta;
        sendChannel.mo6233trySendJP2dKIU(new DragEvent.DragDelta(overSlopOffset, null));
        Function1 dragTick = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DraggableKt$awaitDrag$dragTick$1
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
            public final void invoke2(PointerInputChange event) {
                Intrinsics.checkNotNullParameter(event, "event");
                VelocityTrackerKt.addPointerInputChange(VelocityTracker.this, event);
                long delta = PointerEventKt.positionChange(event);
                event.consume();
                sendChannel.mo6233trySendJP2dKIU(new DragEvent.DragDelta(reverseDirection ? Offset.m1767timestuRUvjQ(delta, -1.0f) : delta, null));
            }
        };
        return orientation == Orientation.Vertical ? DragGestureDetectorKt.m596verticalDragjO51t88($this$awaitDrag_u2dSu4bsnU, startEvent.getId(), dragTick, continuation) : DragGestureDetectorKt.m593horizontalDragjO51t88($this$awaitDrag_u2dSu4bsnU, startEvent.getId(), dragTick, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toFloat-3MmeM6k, reason: not valid java name */
    public static final float m608toFloat3MmeM6k(long $this$toFloat_u2d3MmeM6k, Orientation orientation) {
        return orientation == Orientation.Vertical ? Offset.m1761getYimpl($this$toFloat_u2d3MmeM6k) : Offset.m1760getXimpl($this$toFloat_u2d3MmeM6k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toFloat-sF-c-tU, reason: not valid java name */
    public static final float m609toFloatsFctU(long $this$toFloat_u2dsF_u2dc_u2dtU, Orientation orientation) {
        return orientation == Orientation.Vertical ? Velocity.m4608getYimpl($this$toFloat_u2dsF_u2dc_u2dtU) : Velocity.m4607getXimpl($this$toFloat_u2dsF_u2dc_u2dtU);
    }
}
