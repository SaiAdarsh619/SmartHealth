package androidx.compose.material;

import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableKt$draggable$1;
import androidx.compose.foundation.gestures.DraggableKt$draggable$2;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.health.platform.client.SdkConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Slider.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class SliderKt$Slider$3 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ State<Function1<Float, Unit>> $onValueChangeState;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ float $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SliderKt$Slider$3(ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, float f, MutableInteractionSource mutableInteractionSource, boolean z, List<Float> list, SliderColors sliderColors, State<? extends Function1<? super Float, Unit>> state, Function0<Unit> function0) {
        super(3);
        this.$valueRange = closedFloatingPointRange;
        this.$$dirty = i;
        this.$value = f;
        this.$interactionSource = mutableInteractionSource;
        this.$enabled = z;
        this.$tickFractions = list;
        this.$colors = sliderColors;
        this.$onValueChangeState = state;
        this.$onValueChangeFinished = function0;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
        invoke(boxWithConstraintsScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke(BoxWithConstraintsScope BoxWithConstraints, Composer $composer, int $changed) {
        Object value$iv$iv$iv;
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Modifier press;
        boolean invalid$iv$iv;
        Modifier drag;
        float fraction;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C175@8154L7,*180@8315L7,191@8729L24,192@8778L49,193@8854L31,195@8916L367,204@9293L83,206@9409L618,235@10521L55,242@10862L209:Slider.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer.changed(BoxWithConstraints) ? 4 : 2;
        }
        if (($dirty & 91) == 18 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2085116814, $changed, -1, "androidx.compose.material.Slider.<anonymous> (Slider.kt:174)");
        }
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd($composer);
        boolean isRtl = consume == LayoutDirection.Rtl;
        float widthPx = Constraints.m4338getMaxWidthimpl(BoxWithConstraints.getConstraints());
        final Ref.FloatRef maxPx = new Ref.FloatRef();
        final Ref.FloatRef minPx = new Ref.FloatRef();
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density $this$invoke_u24lambda_u2d0 = (Density) consume2;
        maxPx.element = Math.max(widthPx - $this$invoke_u24lambda_u2d0.mo648toPx0680j_4(SliderKt.getThumbRadius()), 0.0f);
        minPx.element = Math.min($this$invoke_u24lambda_u2d0.mo648toPx0680j_4(SliderKt.getThumbRadius()), maxPx.element);
        $composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation($composer, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv$iv = $composer.rememberedValue();
        if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
            $composer.updateRememberedValue(value$iv$iv$iv);
        } else {
            value$iv$iv$iv = it$iv$iv$iv;
        }
        $composer.endReplaceableGroup();
        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
        final CoroutineScope scope = wrapper$iv.getCoroutineScope();
        $composer.endReplaceableGroup();
        float f = this.$value;
        ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$valueRange;
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(invoke$scaleToOffset(closedFloatingPointRange, minPx, maxPx, f)), null, 2, null);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        final MutableState rawOffset = (MutableState) value$iv$iv;
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv2 = $composer.rememberedValue();
        if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
            $composer.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        final MutableState pressOffset = (MutableState) value$iv$iv2;
        Object key1$iv = Float.valueOf(minPx.element);
        Object key2$iv = Float.valueOf(maxPx.element);
        Object key3$iv = this.$valueRange;
        final State<Function1<Float, Unit>> state = this.$onValueChangeState;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange2 = this.$valueRange;
        int i = (this.$$dirty >> 6) & 896;
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = $composer.changed(key1$iv) | $composer.changed(key2$iv) | $composer.changed(key3$iv);
        Object it$iv$iv3 = $composer.rememberedValue();
        if (!invalid$iv$iv2) {
            Object key1$iv2 = Composer.INSTANCE.getEmpty();
            if (it$iv$iv3 != key1$iv2) {
                value$iv$iv3 = it$iv$iv3;
                $composer.endReplaceableGroup();
                final SliderDraggableState draggableState = (SliderDraggableState) value$iv$iv3;
                SliderKt.CorrectValueSideEffect(new C03452(this.$valueRange, minPx, maxPx), this.$valueRange, RangesKt.rangeTo(minPx.element, maxPx.element), rawOffset, this.$value, $composer, ((this.$$dirty >> 9) & SdkConfig.SDK_VERSION) | 3072 | ((this.$$dirty << 12) & 57344));
                final List<Float> list = this.$tickFractions;
                final Function0<Unit> function0 = this.$onValueChangeFinished;
                State gestureEndAction = SnapshotStateKt.rememberUpdatedState(new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f2) {
                        invoke(f2.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float velocity) {
                        float target;
                        Function0<Unit> function02;
                        float current = rawOffset.getValue().floatValue();
                        target = SliderKt.snapValueToTick(current, list, minPx.element, maxPx.element);
                        if (!(current == target)) {
                            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C03461(draggableState, current, target, velocity, function0, null), 3, null);
                        } else {
                            if (draggableState.isDragging() || (function02 = function0) == null) {
                                return;
                            }
                            function02.invoke();
                        }
                    }

                    /* compiled from: Slider.kt */
                    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                    @DebugMetadata(m296c = "androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1", m297f = "Slider.kt", m298i = {}, m299l = {212}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                    /* renamed from: androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1 */
                    static final class C03461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ float $current;
                        final /* synthetic */ SliderDraggableState $draggableState;
                        final /* synthetic */ Function0<Unit> $onValueChangeFinished;
                        final /* synthetic */ float $target;
                        final /* synthetic */ float $velocity;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C03461(SliderDraggableState sliderDraggableState, float f, float f2, float f3, Function0<Unit> function0, Continuation<? super C03461> continuation) {
                            super(2, continuation);
                            this.$draggableState = sliderDraggableState;
                            this.$current = f;
                            this.$target = f2;
                            this.$velocity = f3;
                            this.$onValueChangeFinished = function0;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C03461(this.$draggableState, this.$current, this.$target, this.$velocity, this.$onValueChangeFinished, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C03461) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            Object animateToTarget;
                            C03461 c03461;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    this.label = 1;
                                    animateToTarget = SliderKt.animateToTarget(this.$draggableState, this.$current, this.$target, this.$velocity, this);
                                    if (animateToTarget != coroutine_suspended) {
                                        c03461 = this;
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    c03461 = this;
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Function0<Unit> function0 = c03461.$onValueChangeFinished;
                            if (function0 != null) {
                                function0.invoke();
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }, $composer, 0);
                press = SliderKt.sliderTapModifier(Modifier.INSTANCE, draggableState, this.$interactionSource, widthPx, isRtl, rawOffset, gestureEndAction, pressOffset, this.$enabled);
                Modifier.Companion companion = Modifier.INSTANCE;
                Orientation orientation = Orientation.Horizontal;
                boolean isDragging = draggableState.isDragging();
                Modifier.Companion companion2 = companion;
                SliderDraggableState sliderDraggableState = draggableState;
                boolean z = this.$enabled;
                MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                $composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                invalid$iv$iv = $composer.changed(gestureEndAction);
                Object value$iv$iv4 = $composer.rememberedValue();
                if (!invalid$iv$iv && value$iv$iv4 != Composer.INSTANCE.getEmpty()) {
                    $composer.endReplaceableGroup();
                    drag = DraggableKt.draggable(companion2, sliderDraggableState, orientation, (r20 & 4) != 0 ? true : z, (r20 & 8) != 0 ? null : mutableInteractionSource, (r20 & 16) != 0 ? false : isDragging, (r20 & 32) != 0 ? new DraggableKt$draggable$1(null) : null, (r20 & 64) != 0 ? new DraggableKt$draggable$2(null) : (Function3) value$iv$iv4, (r20 & 128) != 0 ? false : isRtl);
                    float coerced = RangesKt.coerceIn(this.$value, this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue());
                    fraction = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), coerced);
                    SliderKt.SliderImpl(this.$enabled, fraction, this.$tickFractions, this.$colors, maxPx.element - minPx.element, this.$interactionSource, press.then(drag), $composer, ((this.$$dirty >> 9) & 14) | 512 | ((this.$$dirty >> 15) & 7168) | ((this.$$dirty >> 6) & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        return;
                    }
                    ComposerKt.traceEventEnd();
                    return;
                }
                value$iv$iv4 = (Function3) new SliderKt$Slider$3$drag$1$1(gestureEndAction, null);
                $composer.updateRememberedValue(value$iv$iv4);
                $composer.endReplaceableGroup();
                drag = DraggableKt.draggable(companion2, sliderDraggableState, orientation, (r20 & 4) != 0 ? true : z, (r20 & 8) != 0 ? null : mutableInteractionSource, (r20 & 16) != 0 ? false : isDragging, (r20 & 32) != 0 ? new DraggableKt$draggable$1(null) : null, (r20 & 64) != 0 ? new DraggableKt$draggable$2(null) : (Function3) value$iv$iv4, (r20 & 128) != 0 ? false : isRtl);
                float coerced2 = RangesKt.coerceIn(this.$value, this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue());
                fraction = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), coerced2);
                SliderKt.SliderImpl(this.$enabled, fraction, this.$tickFractions, this.$colors, maxPx.element - minPx.element, this.$interactionSource, press.then(drag), $composer, ((this.$$dirty >> 9) & 14) | 512 | ((this.$$dirty >> 15) & 7168) | ((this.$$dirty >> 6) & 458752));
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        }
        value$iv$iv3 = new SliderDraggableState(new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$Slider$3$draggableState$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f2) {
                invoke(f2.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float it) {
                float invoke$scaleToUserValue;
                rawOffset.setValue(Float.valueOf(rawOffset.getValue().floatValue() + it + pressOffset.getValue().floatValue()));
                pressOffset.setValue(Float.valueOf(0.0f));
                float offsetInTrack = RangesKt.coerceIn(rawOffset.getValue().floatValue(), minPx.element, maxPx.element);
                Function1<Float, Unit> value = state.getValue();
                invoke$scaleToUserValue = SliderKt$Slider$3.invoke$scaleToUserValue(minPx, maxPx, closedFloatingPointRange2, offsetInTrack);
                value.invoke(Float.valueOf(invoke$scaleToUserValue));
            }
        });
        $composer.updateRememberedValue(value$iv$iv3);
        $composer.endReplaceableGroup();
        final SliderDraggableState draggableState2 = (SliderDraggableState) value$iv$iv3;
        SliderKt.CorrectValueSideEffect(new C03452(this.$valueRange, minPx, maxPx), this.$valueRange, RangesKt.rangeTo(minPx.element, maxPx.element), rawOffset, this.$value, $composer, ((this.$$dirty >> 9) & SdkConfig.SDK_VERSION) | 3072 | ((this.$$dirty << 12) & 57344));
        final List<Float> list2 = this.$tickFractions;
        final Function0<Unit> function02 = this.$onValueChangeFinished;
        State gestureEndAction2 = SnapshotStateKt.rememberUpdatedState(new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f2) {
                invoke(f2.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float velocity) {
                float target;
                Function0<Unit> function022;
                float current = rawOffset.getValue().floatValue();
                target = SliderKt.snapValueToTick(current, list2, minPx.element, maxPx.element);
                if (!(current == target)) {
                    BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C03461(draggableState2, current, target, velocity, function02, null), 3, null);
                } else {
                    if (draggableState2.isDragging() || (function022 = function02) == null) {
                        return;
                    }
                    function022.invoke();
                }
            }

            /* compiled from: Slider.kt */
            @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            @DebugMetadata(m296c = "androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1", m297f = "Slider.kt", m298i = {}, m299l = {212}, m300m = "invokeSuspend", m301n = {}, m302s = {})
            /* renamed from: androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1 */
            static final class C03461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ float $current;
                final /* synthetic */ SliderDraggableState $draggableState;
                final /* synthetic */ Function0<Unit> $onValueChangeFinished;
                final /* synthetic */ float $target;
                final /* synthetic */ float $velocity;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C03461(SliderDraggableState sliderDraggableState, float f, float f2, float f3, Function0<Unit> function0, Continuation<? super C03461> continuation) {
                    super(2, continuation);
                    this.$draggableState = sliderDraggableState;
                    this.$current = f;
                    this.$target = f2;
                    this.$velocity = f3;
                    this.$onValueChangeFinished = function0;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C03461(this.$draggableState, this.$current, this.$target, this.$velocity, this.$onValueChangeFinished, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C03461) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object animateToTarget;
                    C03461 c03461;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            this.label = 1;
                            animateToTarget = SliderKt.animateToTarget(this.$draggableState, this.$current, this.$target, this.$velocity, this);
                            if (animateToTarget != coroutine_suspended) {
                                c03461 = this;
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        case 1:
                            c03461 = this;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Function0<Unit> function0 = c03461.$onValueChangeFinished;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    return Unit.INSTANCE;
                }
            }
        }, $composer, 0);
        press = SliderKt.sliderTapModifier(Modifier.INSTANCE, draggableState2, this.$interactionSource, widthPx, isRtl, rawOffset, gestureEndAction2, pressOffset, this.$enabled);
        Modifier.Companion companion3 = Modifier.INSTANCE;
        Orientation orientation2 = Orientation.Horizontal;
        boolean isDragging2 = draggableState2.isDragging();
        Modifier.Companion companion22 = companion3;
        SliderDraggableState sliderDraggableState2 = draggableState2;
        boolean z2 = this.$enabled;
        MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        invalid$iv$iv = $composer.changed(gestureEndAction2);
        Object value$iv$iv42 = $composer.rememberedValue();
        if (!invalid$iv$iv) {
            $composer.endReplaceableGroup();
            drag = DraggableKt.draggable(companion22, sliderDraggableState2, orientation2, (r20 & 4) != 0 ? true : z2, (r20 & 8) != 0 ? null : mutableInteractionSource2, (r20 & 16) != 0 ? false : isDragging2, (r20 & 32) != 0 ? new DraggableKt$draggable$1(null) : null, (r20 & 64) != 0 ? new DraggableKt$draggable$2(null) : (Function3) value$iv$iv42, (r20 & 128) != 0 ? false : isRtl);
            float coerced22 = RangesKt.coerceIn(this.$value, this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue());
            fraction = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), coerced22);
            SliderKt.SliderImpl(this.$enabled, fraction, this.$tickFractions, this.$colors, maxPx.element - minPx.element, this.$interactionSource, press.then(drag), $composer, ((this.$$dirty >> 9) & 14) | 512 | ((this.$$dirty >> 15) & 7168) | ((this.$$dirty >> 6) & 458752));
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        value$iv$iv42 = (Function3) new SliderKt$Slider$3$drag$1$1(gestureEndAction2, null);
        $composer.updateRememberedValue(value$iv$iv42);
        $composer.endReplaceableGroup();
        drag = DraggableKt.draggable(companion22, sliderDraggableState2, orientation2, (r20 & 4) != 0 ? true : z2, (r20 & 8) != 0 ? null : mutableInteractionSource2, (r20 & 16) != 0 ? false : isDragging2, (r20 & 32) != 0 ? new DraggableKt$draggable$1(null) : null, (r20 & 64) != 0 ? new DraggableKt$draggable$2(null) : (Function3) value$iv$iv42, (r20 & 128) != 0 ? false : isRtl);
        float coerced222 = RangesKt.coerceIn(this.$value, this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue());
        fraction = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), coerced222);
        SliderKt.SliderImpl(this.$enabled, fraction, this.$tickFractions, this.$colors, maxPx.element - minPx.element, this.$interactionSource, press.then(drag), $composer, ((this.$$dirty >> 9) & 14) | 512 | ((this.$$dirty >> 15) & 7168) | ((this.$$dirty >> 6) & 458752));
        if (ComposerKt.isTraceInProgress()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$scaleToUserValue(Ref.FloatRef minPx, Ref.FloatRef maxPx, ClosedFloatingPointRange<Float> closedFloatingPointRange, float offset) {
        float scale;
        scale = SliderKt.scale(minPx.element, maxPx.element, offset, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
        return scale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef minPx, Ref.FloatRef maxPx, float userValue) {
        float scale;
        scale = SliderKt.scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), userValue, minPx.element, maxPx.element);
        return scale;
    }

    /* compiled from: Slider.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    /* renamed from: androidx.compose.material.SliderKt$Slider$3$2 */
    /* synthetic */ class C03452 extends FunctionReferenceImpl implements Function1<Float, Float> {
        final /* synthetic */ Ref.FloatRef $maxPx;
        final /* synthetic */ Ref.FloatRef $minPx;
        final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03452(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2) {
            super(1, Intrinsics.Kotlin.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
            this.$valueRange = closedFloatingPointRange;
            this.$minPx = floatRef;
            this.$maxPx = floatRef2;
        }

        public final Float invoke(float p0) {
            return Float.valueOf(SliderKt$Slider$3.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, p0));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Float invoke(Float f) {
            return invoke(f.floatValue());
        }
    }
}
