package androidx.compose.material;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEventKt;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.runtime.State;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: Slider.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1", m297f = "Slider.kt", m298i = {}, m299l = {982}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes.dex */
final class SliderKt$rangeSliderPressDragModifier$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableInteractionSource $endInteractionSource;
    final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
    final /* synthetic */ boolean $isRtl;
    final /* synthetic */ float $maxPx;
    final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
    final /* synthetic */ State<Float> $rawOffsetEnd;
    final /* synthetic */ State<Float> $rawOffsetStart;
    final /* synthetic */ MutableInteractionSource $startInteractionSource;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SliderKt$rangeSliderPressDragModifier$1(MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, State<Float> state, State<Float> state2, State<? extends Function2<? super Boolean, ? super Float, Unit>> state3, boolean z, float f, State<? extends Function1<? super Boolean, Unit>> state4, Continuation<? super SliderKt$rangeSliderPressDragModifier$1> continuation) {
        super(2, continuation);
        this.$startInteractionSource = mutableInteractionSource;
        this.$endInteractionSource = mutableInteractionSource2;
        this.$rawOffsetStart = state;
        this.$rawOffsetEnd = state2;
        this.$onDrag = state3;
        this.$isRtl = z;
        this.$maxPx = f;
        this.$gestureEndAction = state4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SliderKt$rangeSliderPressDragModifier$1 sliderKt$rangeSliderPressDragModifier$1 = new SliderKt$rangeSliderPressDragModifier$1(this.$startInteractionSource, this.$endInteractionSource, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onDrag, this.$isRtl, this.$maxPx, this.$gestureEndAction, continuation);
        sliderKt$rangeSliderPressDragModifier$1.L$0 = obj;
        return sliderKt$rangeSliderPressDragModifier$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((SliderKt$rangeSliderPressDragModifier$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                RangeSliderLogic rangeSliderLogic = new RangeSliderLogic(this.$startInteractionSource, this.$endInteractionSource, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onDrag);
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(new C03491($this$pointerInput, this.$isRtl, this.$maxPx, rangeSliderLogic, this.$rawOffsetStart, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null), this) != coroutine_suspended) {
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

    /* compiled from: Slider.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1", m297f = "Slider.kt", m298i = {}, m299l = {983}, m300m = "invokeSuspend", m301n = {}, m302s = {})
    /* renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1 */
    static final class C03491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputScope $$this$pointerInput;
        final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
        final /* synthetic */ boolean $isRtl;
        final /* synthetic */ float $maxPx;
        final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
        final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
        final /* synthetic */ State<Float> $rawOffsetEnd;
        final /* synthetic */ State<Float> $rawOffsetStart;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03491(PointerInputScope pointerInputScope, boolean z, float f, RangeSliderLogic rangeSliderLogic, State<Float> state, State<? extends Function1<? super Boolean, Unit>> state2, State<Float> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4, Continuation<? super C03491> continuation) {
            super(2, continuation);
            this.$$this$pointerInput = pointerInputScope;
            this.$isRtl = z;
            this.$maxPx = f;
            this.$rangeSliderLogic = rangeSliderLogic;
            this.$rawOffsetStart = state;
            this.$gestureEndAction = state2;
            this.$rawOffsetEnd = state3;
            this.$onDrag = state4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03491 c03491 = new C03491(this.$$this$pointerInput, this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
            c03491.L$0 = obj;
            return c03491;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: Slider.kt */
        @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
        @DebugMetadata(m296c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1", m297f = "Slider.kt", m298i = {}, m299l = {984}, m300m = "invokeSuspend", m301n = {}, m302s = {})
        /* renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
            final /* synthetic */ boolean $isRtl;
            final /* synthetic */ float $maxPx;
            final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
            final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
            final /* synthetic */ State<Float> $rawOffsetEnd;
            final /* synthetic */ State<Float> $rawOffsetStart;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(boolean z, float f, RangeSliderLogic rangeSliderLogic, State<Float> state, CoroutineScope coroutineScope, State<? extends Function1<? super Boolean, Unit>> state2, State<Float> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$isRtl = z;
                this.$maxPx = f;
                this.$rangeSliderLogic = rangeSliderLogic;
                this.$rawOffsetStart = state;
                this.$$this$coroutineScope = coroutineScope;
                this.$gestureEndAction = state2;
                this.$rawOffsetEnd = state3;
                this.$onDrag = state4;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* compiled from: Slider.kt */
            @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            @DebugMetadata(m296c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1", m297f = "Slider.kt", m298i = {0, 1, 1, 1, 1, 1, 2, 2}, m299l = {985, 995, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW}, m300m = "invokeSuspend", m301n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", NotificationCompat.CATEGORY_EVENT, "interaction", "posX", "draggingStart", "interaction", "draggingStart"}, m302s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1"})
            /* renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1, reason: invalid class name and collision with other inner class name */
            static final class C16761 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
                final /* synthetic */ boolean $isRtl;
                final /* synthetic */ float $maxPx;
                final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
                final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                final /* synthetic */ State<Float> $rawOffsetEnd;
                final /* synthetic */ State<Float> $rawOffsetStart;
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C16761(boolean z, float f, RangeSliderLogic rangeSliderLogic, State<Float> state, CoroutineScope coroutineScope, State<? extends Function1<? super Boolean, Unit>> state2, State<Float> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4, Continuation<? super C16761> continuation) {
                    super(2, continuation);
                    this.$isRtl = z;
                    this.$maxPx = f;
                    this.$rangeSliderLogic = rangeSliderLogic;
                    this.$rawOffsetStart = state;
                    this.$$this$coroutineScope = coroutineScope;
                    this.$gestureEndAction = state2;
                    this.$rawOffsetEnd = state3;
                    this.$onDrag = state4;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C16761 c16761 = new C16761(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
                    c16761.L$0 = obj;
                    return c16761;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((C16761) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:13:0x01a8 A[Catch: CancellationException -> 0x01b9, TryCatch #1 {CancellationException -> 0x01b9, blocks: (B:11:0x019f, B:13:0x01a8, B:18:0x01b0), top: B:10:0x019f }] */
                /* JADX WARN: Removed duplicated region for block: B:18:0x01b0 A[Catch: CancellationException -> 0x01b9, TRY_LEAVE, TryCatch #1 {CancellationException -> 0x01b9, blocks: (B:11:0x019f, B:13:0x01a8, B:18:0x01b0), top: B:10:0x019f }] */
                /* JADX WARN: Removed duplicated region for block: B:27:0x00ef  */
                /* JADX WARN: Removed duplicated region for block: B:47:0x0197 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:48:0x0198  */
                /* JADX WARN: Removed duplicated region for block: B:55:0x0086  */
                /* JADX WARN: Removed duplicated region for block: B:58:0x00ab  */
                /* JADX WARN: Removed duplicated region for block: B:62:0x00e6 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:63:0x00e7  */
                /* JADX WARN: Removed duplicated region for block: B:65:0x00b1  */
                /* JADX WARN: Removed duplicated region for block: B:69:0x0092  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object $result) {
                    C16761 c16761;
                    AwaitPointerEventScope $this$awaitPointerEventScope;
                    Object $result2;
                    Object $result3;
                    PointerInputChange event;
                    Ref.FloatRef posX;
                    Object m1492awaitSlop8vUncbI;
                    DragInteraction.Start interaction;
                    Object $result4;
                    Object $result5;
                    final Ref.BooleanRef draggingStart;
                    Pair it;
                    Ref.BooleanRef draggingStart2;
                    DragInteraction.Start interaction2;
                    Object m593horizontalDragjO51t88;
                    Object $result6;
                    DragInteraction.Cancel finishInteraction;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            c16761 = this;
                            AwaitPointerEventScope $this$awaitPointerEventScope2 = (AwaitPointerEventScope) c16761.L$0;
                            c16761.L$0 = $this$awaitPointerEventScope2;
                            c16761.label = 1;
                            Object awaitFirstDown = TapGestureDetectorKt.awaitFirstDown($this$awaitPointerEventScope2, false, c16761);
                            if (awaitFirstDown == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                            $result2 = $result;
                            $result3 = awaitFirstDown;
                            event = (PointerInputChange) $result3;
                            DragInteraction.Start interaction3 = new DragInteraction.Start();
                            posX = new Ref.FloatRef();
                            posX.element = !c16761.$isRtl ? c16761.$maxPx - Offset.m1760getXimpl(event.getPosition()) : Offset.m1760getXimpl(event.getPosition());
                            int compare = c16761.$rangeSliderLogic.compareOffsets(posX.element);
                            Ref.BooleanRef draggingStart3 = new Ref.BooleanRef();
                            draggingStart3.element = compare == 0 ? compare < 0 : c16761.$rawOffsetStart.getValue().floatValue() > posX.element;
                            c16761.L$0 = $this$awaitPointerEventScope;
                            c16761.L$1 = event;
                            c16761.L$2 = interaction3;
                            c16761.L$3 = posX;
                            c16761.L$4 = draggingStart3;
                            c16761.label = 2;
                            m1492awaitSlop8vUncbI = SliderKt.m1492awaitSlop8vUncbI($this$awaitPointerEventScope, event.getId(), event.getType(), c16761);
                            if (m1492awaitSlop8vUncbI != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            interaction = interaction3;
                            $result4 = m1492awaitSlop8vUncbI;
                            $result5 = $result2;
                            draggingStart = draggingStart3;
                            it = (Pair) $result4;
                            if (it != null) {
                                State<Float> state = c16761.$rawOffsetEnd;
                                State<Float> state2 = c16761.$rawOffsetStart;
                                boolean z = c16761.$isRtl;
                                float slop = DragGestureDetectorCopyKt.m1361pointerSlopE8SPZFQ($this$awaitPointerEventScope.getViewConfiguration(), event.getType());
                                boolean shouldUpdateCapturedThumb = Math.abs(state.getValue().floatValue() - posX.element) < slop && Math.abs(state2.getValue().floatValue() - posX.element) < slop;
                                if (shouldUpdateCapturedThumb) {
                                    float dir = ((Number) it.getSecond()).floatValue();
                                    draggingStart.element = !z ? dir >= 0.0f : dir < 0.0f;
                                    posX.element += Offset.m1760getXimpl(PointerEventKt.positionChange((PointerInputChange) it.getFirst()));
                                }
                            }
                            c16761.$rangeSliderLogic.captureThumb(draggingStart.element, posX.element, interaction, c16761.$$this$coroutineScope);
                            try {
                                long id = event.getId();
                                final State<Function2<Boolean, Float, Unit>> state3 = c16761.$onDrag;
                                final boolean z2 = c16761.$isRtl;
                                c16761.L$0 = interaction;
                                c16761.L$1 = draggingStart;
                                c16761.L$2 = null;
                                c16761.L$3 = null;
                                c16761.L$4 = null;
                                c16761.label = 3;
                                m593horizontalDragjO51t88 = DragGestureDetectorKt.m593horizontalDragjO51t88($this$awaitPointerEventScope, id, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1$finishInteraction$success$1
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
                                    public final void invoke2(PointerInputChange it2) {
                                        Intrinsics.checkNotNullParameter(it2, "it");
                                        float deltaX = Offset.m1760getXimpl(PointerEventKt.positionChange(it2));
                                        state3.getValue().invoke(Boolean.valueOf(draggingStart.element), Float.valueOf(z2 ? -deltaX : deltaX));
                                    }
                                }, c16761);
                            } catch (CancellationException e) {
                                draggingStart2 = draggingStart;
                                interaction2 = interaction;
                                finishInteraction = new DragInteraction.Cancel(interaction2);
                                c16761.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(draggingStart2.element));
                                BuildersKt__Builders_commonKt.launch$default(c16761.$$this$coroutineScope, null, null, new AnonymousClass2(c16761.$rangeSliderLogic, draggingStart2, finishInteraction, null), 3, null);
                                return Unit.INSTANCE;
                            }
                            if (m593horizontalDragjO51t88 != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            draggingStart2 = draggingStart;
                            interaction2 = interaction;
                            Object obj = $result5;
                            $result5 = m593horizontalDragjO51t88;
                            $result6 = obj;
                            try {
                                boolean success = ((Boolean) $result5).booleanValue();
                                finishInteraction = !success ? new DragInteraction.Stop(interaction2) : new DragInteraction.Cancel(interaction2);
                            } catch (CancellationException e2) {
                                $result5 = $result6;
                                finishInteraction = new DragInteraction.Cancel(interaction2);
                                c16761.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(draggingStart2.element));
                                BuildersKt__Builders_commonKt.launch$default(c16761.$$this$coroutineScope, null, null, new AnonymousClass2(c16761.$rangeSliderLogic, draggingStart2, finishInteraction, null), 3, null);
                                return Unit.INSTANCE;
                            }
                            c16761.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(draggingStart2.element));
                            BuildersKt__Builders_commonKt.launch$default(c16761.$$this$coroutineScope, null, null, new AnonymousClass2(c16761.$rangeSliderLogic, draggingStart2, finishInteraction, null), 3, null);
                            return Unit.INSTANCE;
                        case 1:
                            c16761 = this;
                            $result3 = $result;
                            AwaitPointerEventScope $this$awaitPointerEventScope3 = (AwaitPointerEventScope) c16761.L$0;
                            ResultKt.throwOnFailure($result3);
                            $this$awaitPointerEventScope = $this$awaitPointerEventScope3;
                            $result2 = $result3;
                            event = (PointerInputChange) $result3;
                            DragInteraction.Start interaction32 = new DragInteraction.Start();
                            posX = new Ref.FloatRef();
                            posX.element = !c16761.$isRtl ? c16761.$maxPx - Offset.m1760getXimpl(event.getPosition()) : Offset.m1760getXimpl(event.getPosition());
                            int compare2 = c16761.$rangeSliderLogic.compareOffsets(posX.element);
                            Ref.BooleanRef draggingStart32 = new Ref.BooleanRef();
                            draggingStart32.element = compare2 == 0 ? compare2 < 0 : c16761.$rawOffsetStart.getValue().floatValue() > posX.element;
                            c16761.L$0 = $this$awaitPointerEventScope;
                            c16761.L$1 = event;
                            c16761.L$2 = interaction32;
                            c16761.L$3 = posX;
                            c16761.L$4 = draggingStart32;
                            c16761.label = 2;
                            m1492awaitSlop8vUncbI = SliderKt.m1492awaitSlop8vUncbI($this$awaitPointerEventScope, event.getId(), event.getType(), c16761);
                            if (m1492awaitSlop8vUncbI != coroutine_suspended) {
                            }
                            break;
                        case 2:
                            c16761 = this;
                            $result4 = $result;
                            draggingStart = (Ref.BooleanRef) c16761.L$4;
                            posX = (Ref.FloatRef) c16761.L$3;
                            interaction = (DragInteraction.Start) c16761.L$2;
                            event = (PointerInputChange) c16761.L$1;
                            $this$awaitPointerEventScope = (AwaitPointerEventScope) c16761.L$0;
                            ResultKt.throwOnFailure($result4);
                            $result5 = $result4;
                            it = (Pair) $result4;
                            if (it != null) {
                            }
                            c16761.$rangeSliderLogic.captureThumb(draggingStart.element, posX.element, interaction, c16761.$$this$coroutineScope);
                            long id2 = event.getId();
                            final State<? extends Function2<? super Boolean, ? super Float, Unit>> state32 = c16761.$onDrag;
                            final boolean z22 = c16761.$isRtl;
                            c16761.L$0 = interaction;
                            c16761.L$1 = draggingStart;
                            c16761.L$2 = null;
                            c16761.L$3 = null;
                            c16761.L$4 = null;
                            c16761.label = 3;
                            m593horizontalDragjO51t88 = DragGestureDetectorKt.m593horizontalDragjO51t88($this$awaitPointerEventScope, id2, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1$finishInteraction$success$1
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
                                public final void invoke2(PointerInputChange it2) {
                                    Intrinsics.checkNotNullParameter(it2, "it");
                                    float deltaX = Offset.m1760getXimpl(PointerEventKt.positionChange(it2));
                                    state32.getValue().invoke(Boolean.valueOf(draggingStart.element), Float.valueOf(z22 ? -deltaX : deltaX));
                                }
                            }, c16761);
                            if (m593horizontalDragjO51t88 != coroutine_suspended) {
                            }
                            break;
                        case 3:
                            c16761 = this;
                            $result5 = $result;
                            draggingStart2 = (Ref.BooleanRef) c16761.L$1;
                            interaction2 = (DragInteraction.Start) c16761.L$0;
                            try {
                                ResultKt.throwOnFailure($result5);
                                $result6 = $result5;
                                boolean success2 = ((Boolean) $result5).booleanValue();
                                if (!success2) {
                                }
                            } catch (CancellationException e3) {
                                finishInteraction = new DragInteraction.Cancel(interaction2);
                                c16761.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(draggingStart2.element));
                                BuildersKt__Builders_commonKt.launch$default(c16761.$$this$coroutineScope, null, null, new AnonymousClass2(c16761.$rangeSliderLogic, draggingStart2, finishInteraction, null), 3, null);
                                return Unit.INSTANCE;
                            }
                            c16761.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(draggingStart2.element));
                            BuildersKt__Builders_commonKt.launch$default(c16761.$$this$coroutineScope, null, null, new AnonymousClass2(c16761.$rangeSliderLogic, draggingStart2, finishInteraction, null), 3, null);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }

                /* compiled from: Slider.kt */
                @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                @DebugMetadata(m296c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1$2", m297f = "Slider.kt", m298i = {}, m299l = {1031}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                /* renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1$2, reason: invalid class name */
                static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Ref.BooleanRef $draggingStart;
                    final /* synthetic */ DragInteraction $finishInteraction;
                    final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(RangeSliderLogic rangeSliderLogic, Ref.BooleanRef booleanRef, DragInteraction dragInteraction, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.$rangeSliderLogic = rangeSliderLogic;
                        this.$draggingStart = booleanRef;
                        this.$finishInteraction = dragInteraction;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass2(this.$rangeSliderLogic, this.$draggingStart, this.$finishInteraction, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                this.label = 1;
                                if (this.$rangeSliderLogic.activeInteraction(this.$draggingStart.element).emit(this.$finishInteraction, this) != coroutine_suspended) {
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
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        PointerInputScope $this$forEachGesture = (PointerInputScope) this.L$0;
                        this.label = 1;
                        if ($this$forEachGesture.awaitPointerEventScope(new C16761(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null), this) != coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    this.label = 1;
                    if (ForEachGestureKt.forEachGesture(this.$$this$pointerInput, new AnonymousClass1(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, $this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null), this) != coroutine_suspended) {
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
}
