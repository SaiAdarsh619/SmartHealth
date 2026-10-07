package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
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
import kotlin.coroutines.jvm.internal.Boxing;
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
final class SliderKt$RangeSlider$2 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $endInteractionSource;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
    final /* synthetic */ MutableInteractionSource $startInteractionSource;
    final /* synthetic */ int $steps;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ ClosedFloatingPointRange<Float> $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SliderKt$RangeSlider$2(ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z, int i2, Function0<Unit> function0, List<Float> list, SliderColors sliderColors) {
        super(3);
        this.$valueRange = closedFloatingPointRange;
        this.$value = closedFloatingPointRange2;
        this.$$dirty = i;
        this.$onValueChangeState = state;
        this.$startInteractionSource = mutableInteractionSource;
        this.$endInteractionSource = mutableInteractionSource2;
        this.$enabled = z;
        this.$steps = i2;
        this.$onValueChangeFinished = function0;
        this.$tickFractions = list;
        this.$colors = sliderColors;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
        invoke(boxWithConstraintsScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0449 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x03cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke(BoxWithConstraintsScope BoxWithConstraints, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv$iv;
        Object value$iv$iv3;
        Modifier pressDrag;
        float fractionStart;
        float fractionEnd;
        boolean invalid$iv$iv;
        Modifier startThumbSemantics;
        boolean invalid$iv$iv2;
        Object it$iv$iv;
        Object value$iv$iv4;
        Modifier endThumbSemantics;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C314@14053L7,*319@14214L7,330@14642L55,331@14725L62,333@14797L164,340@14970L169,348@15161L24,349@15217L944,373@16231L807,373@16184L854,415@18057L63,423@18347L65,429@18540L340:Slider.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer.changed(BoxWithConstraints) ? 4 : 2;
        }
        if (($dirty & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(652589923, $changed, -1, "androidx.compose.material.RangeSlider.<anonymous> (Slider.kt:313)");
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
            maxPx.element = widthPx - $this$invoke_u24lambda_u2d0.mo648toPx0680j_4(SliderKt.getThumbRadius());
            minPx.element = $this$invoke_u24lambda_u2d0.mo648toPx0680j_4(SliderKt.getThumbRadius());
            Unit unit = Unit.INSTANCE;
            ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$value;
            ClosedFloatingPointRange<Float> closedFloatingPointRange2 = this.$valueRange;
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv2 = $composer.rememberedValue();
            if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(invoke$scaleToOffset(closedFloatingPointRange2, minPx, maxPx, closedFloatingPointRange.getStart().floatValue())), null, 2, null);
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv2;
            }
            $composer.endReplaceableGroup();
            final MutableState rawOffsetStart = (MutableState) value$iv$iv;
            ClosedFloatingPointRange<Float> closedFloatingPointRange3 = this.$value;
            ClosedFloatingPointRange<Float> closedFloatingPointRange4 = this.$valueRange;
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv3 = $composer.rememberedValue();
            if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(invoke$scaleToOffset(closedFloatingPointRange4, minPx, maxPx, closedFloatingPointRange3.getEndInclusive().floatValue())), null, 2, null);
                $composer.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv3;
            }
            $composer.endReplaceableGroup();
            final MutableState rawOffsetEnd = (MutableState) value$iv$iv2;
            SliderKt.CorrectValueSideEffect(new C03422(this.$valueRange, minPx, maxPx), this.$valueRange, RangesKt.rangeTo(minPx.element, maxPx.element), rawOffsetStart, this.$value.getStart().floatValue(), $composer, ((this.$$dirty >> 9) & SdkConfig.SDK_VERSION) | 3072);
            SliderKt.CorrectValueSideEffect(new C03433(this.$valueRange, minPx, maxPx), this.$valueRange, RangesKt.rangeTo(minPx.element, maxPx.element), rawOffsetEnd, this.$value.getEndInclusive().floatValue(), $composer, ((this.$$dirty >> 9) & SdkConfig.SDK_VERSION) | 3072);
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
            final List<Float> list = this.$tickFractions;
            final Function0<Unit> function0 = this.$onValueChangeFinished;
            final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state = this.$onValueChangeState;
            final ClosedFloatingPointRange<Float> closedFloatingPointRange5 = this.$valueRange;
            State gestureEndAction = SnapshotStateKt.rememberUpdatedState(new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean isStart) {
                    float target;
                    float current = (isStart ? rawOffsetStart : rawOffsetEnd).getValue().floatValue();
                    target = SliderKt.snapValueToTick(current, list, minPx.element, maxPx.element);
                    if (!(current == target)) {
                        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C03441(current, target, function0, isStart, rawOffsetStart, rawOffsetEnd, state, minPx, maxPx, closedFloatingPointRange5, null), 3, null);
                        return;
                    }
                    Function0<Unit> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                }

                /* compiled from: Slider.kt */
                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                @DebugMetadata(m296c = "androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1", m297f = "Slider.kt", m298i = {}, m299l = {360}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                /* renamed from: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1 */
                static final class C03441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ float $current;
                    final /* synthetic */ boolean $isStart;
                    final /* synthetic */ Ref.FloatRef $maxPx;
                    final /* synthetic */ Ref.FloatRef $minPx;
                    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
                    final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
                    final /* synthetic */ MutableState<Float> $rawOffsetEnd;
                    final /* synthetic */ MutableState<Float> $rawOffsetStart;
                    final /* synthetic */ float $target;
                    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C03441(float f, float f2, Function0<Unit> function0, boolean z, MutableState<Float> mutableState, MutableState<Float> mutableState2, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, Continuation<? super C03441> continuation) {
                        super(2, continuation);
                        this.$current = f;
                        this.$target = f2;
                        this.$onValueChangeFinished = function0;
                        this.$isStart = z;
                        this.$rawOffsetStart = mutableState;
                        this.$rawOffsetEnd = mutableState2;
                        this.$onValueChangeState = state;
                        this.$minPx = floatRef;
                        this.$maxPx = floatRef2;
                        this.$valueRange = closedFloatingPointRange;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C03441(this.$current, this.$target, this.$onValueChangeFinished, this.$isStart, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onValueChangeState, this.$minPx, this.$maxPx, this.$valueRange, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C03441) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) {
                        TweenSpec tweenSpec;
                        C03441 c03441;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                Animatable Animatable$default = AnimatableKt.Animatable$default(this.$current, 0.0f, 2, null);
                                Float boxFloat = Boxing.boxFloat(this.$target);
                                tweenSpec = SliderKt.SliderToTickAnimation;
                                Float boxFloat2 = Boxing.boxFloat(0.0f);
                                final boolean z = this.$isStart;
                                final MutableState<Float> mutableState = this.$rawOffsetStart;
                                final MutableState<Float> mutableState2 = this.$rawOffsetEnd;
                                final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state = this.$onValueChangeState;
                                final Ref.FloatRef floatRef = this.$minPx;
                                final Ref.FloatRef floatRef2 = this.$maxPx;
                                final ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$valueRange;
                                this.label = 1;
                                if (Animatable$default.animateTo(boxFloat, tweenSpec, boxFloat2, new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSlider.2.gestureEndAction.1.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, AnimationVector1D> animatable) {
                                        invoke2(animatable);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Animatable<Float, AnimationVector1D> animateTo) {
                                        ClosedFloatingPointRange<Float> invoke$scaleToUserValue;
                                        Intrinsics.checkNotNullParameter(animateTo, "$this$animateTo");
                                        (z ? mutableState : mutableState2).setValue(animateTo.getValue());
                                        Function1<ClosedFloatingPointRange<Float>, Unit> value = state.getValue();
                                        invoke$scaleToUserValue = SliderKt$RangeSlider$2.invoke$scaleToUserValue(floatRef, floatRef2, closedFloatingPointRange, RangesKt.rangeTo(mutableState.getValue().floatValue(), mutableState2.getValue().floatValue()));
                                        value.invoke(invoke$scaleToUserValue);
                                    }
                                }, this) != coroutine_suspended) {
                                    c03441 = this;
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                            case 1:
                                c03441 = this;
                                ResultKt.throwOnFailure($result);
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Function0<Unit> function0 = c03441.$onValueChangeFinished;
                        if (function0 != null) {
                            function0.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                }
            }, $composer, 0);
            Object[] keys$iv = {rawOffsetStart, rawOffsetEnd, this.$valueRange, Float.valueOf(minPx.element), Float.valueOf(maxPx.element), this.$value, this.$onValueChangeState};
            final ClosedFloatingPointRange<Float> closedFloatingPointRange6 = this.$value;
            final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state2 = this.$onValueChangeState;
            final ClosedFloatingPointRange<Float> closedFloatingPointRange7 = this.$valueRange;
            int $changed$iv = 8;
            $composer.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
            int length = keys$iv.length;
            boolean invalid$iv = false;
            int i = 0;
            while (i < length) {
                int $changed$iv2 = $changed$iv;
                Object key$iv = keys$iv[i];
                invalid$iv |= $composer.changed(key$iv);
                i++;
                $changed$iv = $changed$iv2;
            }
            Object it$iv$iv4 = $composer.rememberedValue();
            if (!invalid$iv && it$iv$iv4 != Composer.INSTANCE.getEmpty()) {
                value$iv$iv3 = it$iv$iv4;
                $composer.endReplaceableGroup();
                State onDrag = SnapshotStateKt.rememberUpdatedState(value$iv$iv3, $composer, 0);
                pressDrag = SliderKt.rangeSliderPressDragModifier(Modifier.INSTANCE, this.$startInteractionSource, this.$endInteractionSource, rawOffsetStart, rawOffsetEnd, this.$enabled, isRtl, widthPx, this.$valueRange, gestureEndAction, onDrag);
                final float coercedStart = RangesKt.coerceIn(this.$value.getStart().floatValue(), this.$valueRange.getStart().floatValue(), this.$value.getEndInclusive().floatValue());
                final float coercedEnd = RangesKt.coerceIn(this.$value.getEndInclusive().floatValue(), this.$value.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue());
                fractionStart = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), coercedStart);
                fractionEnd = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), coercedEnd);
                int startSteps = (int) Math.floor(this.$steps * fractionEnd);
                int endSteps = (int) Math.floor(this.$steps * (1.0f - fractionStart));
                Modifier.Companion companion = Modifier.INSTANCE;
                boolean z = this.$enabled;
                Object key1$iv = this.$onValueChangeState;
                Object key2$iv = Float.valueOf(coercedEnd);
                final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state3 = this.$onValueChangeState;
                $composer.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer, "C(remember)P(1,2):Composables.kt#9igjgp");
                invalid$iv$iv = $composer.changed(key1$iv) | $composer.changed(key2$iv);
                Object value$iv$iv5 = $composer.rememberedValue();
                if (invalid$iv$iv) {
                    Object key2$iv2 = Composer.INSTANCE.getEmpty();
                    if (value$iv$iv5 != key2$iv2) {
                        $composer.endReplaceableGroup();
                        startThumbSemantics = SliderKt.sliderSemantics(companion, coercedStart, z, (Function1) value$iv$iv5, this.$onValueChangeFinished, RangesKt.rangeTo(this.$valueRange.getStart().floatValue(), coercedEnd), startSteps);
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        boolean z2 = this.$enabled;
                        Object key1$iv2 = this.$onValueChangeState;
                        Object key2$iv3 = Float.valueOf(coercedStart);
                        final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state4 = this.$onValueChangeState;
                        $composer.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation($composer, "C(remember)P(1,2):Composables.kt#9igjgp");
                        invalid$iv$iv2 = $composer.changed(key1$iv2) | $composer.changed(key2$iv3);
                        it$iv$iv = $composer.rememberedValue();
                        if (invalid$iv$iv2 && it$iv$iv != Composer.INSTANCE.getEmpty()) {
                            value$iv$iv4 = it$iv$iv;
                            $composer.endReplaceableGroup();
                            endThumbSemantics = SliderKt.sliderSemantics(companion2, coercedEnd, z2, (Function1) value$iv$iv4, this.$onValueChangeFinished, RangesKt.rangeTo(coercedStart, this.$valueRange.getEndInclusive().floatValue()), endSteps);
                            SliderKt.RangeSliderImpl(this.$enabled, fractionStart, fractionEnd, this.$tickFractions, this.$colors, maxPx.element - minPx.element, this.$startInteractionSource, this.$endInteractionSource, pressDrag, startThumbSemantics, endThumbSemantics, $composer, ((this.$$dirty >> 9) & 14) | 14159872 | ((this.$$dirty >> 9) & 57344), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        value$iv$iv4 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$endThumbSemantics$1$1
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

                            public final void invoke(float value) {
                                state4.getValue().invoke(RangesKt.rangeTo(coercedStart, value));
                            }
                        };
                        $composer.updateRememberedValue(value$iv$iv4);
                        $composer.endReplaceableGroup();
                        endThumbSemantics = SliderKt.sliderSemantics(companion2, coercedEnd, z2, (Function1) value$iv$iv4, this.$onValueChangeFinished, RangesKt.rangeTo(coercedStart, this.$valueRange.getEndInclusive().floatValue()), endSteps);
                        SliderKt.RangeSliderImpl(this.$enabled, fractionStart, fractionEnd, this.$tickFractions, this.$colors, maxPx.element - minPx.element, this.$startInteractionSource, this.$endInteractionSource, pressDrag, startThumbSemantics, endThumbSemantics, $composer, ((this.$$dirty >> 9) & 14) | 14159872 | ((this.$$dirty >> 9) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                }
                value$iv$iv5 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$startThumbSemantics$1$1
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

                    public final void invoke(float value) {
                        state3.getValue().invoke(RangesKt.rangeTo(value, coercedEnd));
                    }
                };
                $composer.updateRememberedValue(value$iv$iv5);
                $composer.endReplaceableGroup();
                startThumbSemantics = SliderKt.sliderSemantics(companion, coercedStart, z, (Function1) value$iv$iv5, this.$onValueChangeFinished, RangesKt.rangeTo(this.$valueRange.getStart().floatValue(), coercedEnd), startSteps);
                Modifier.Companion companion22 = Modifier.INSTANCE;
                boolean z22 = this.$enabled;
                Object key1$iv22 = this.$onValueChangeState;
                Object key2$iv32 = Float.valueOf(coercedStart);
                final State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state42 = this.$onValueChangeState;
                $composer.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer, "C(remember)P(1,2):Composables.kt#9igjgp");
                invalid$iv$iv2 = $composer.changed(key1$iv22) | $composer.changed(key2$iv32);
                it$iv$iv = $composer.rememberedValue();
                if (invalid$iv$iv2) {
                    value$iv$iv4 = it$iv$iv;
                    $composer.endReplaceableGroup();
                    endThumbSemantics = SliderKt.sliderSemantics(companion22, coercedEnd, z22, (Function1) value$iv$iv4, this.$onValueChangeFinished, RangesKt.rangeTo(coercedStart, this.$valueRange.getEndInclusive().floatValue()), endSteps);
                    SliderKt.RangeSliderImpl(this.$enabled, fractionStart, fractionEnd, this.$tickFractions, this.$colors, maxPx.element - minPx.element, this.$startInteractionSource, this.$endInteractionSource, pressDrag, startThumbSemantics, endThumbSemantics, $composer, ((this.$$dirty >> 9) & 14) | 14159872 | ((this.$$dirty >> 9) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
                value$iv$iv4 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$endThumbSemantics$1$1
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

                    public final void invoke(float value) {
                        state42.getValue().invoke(RangesKt.rangeTo(coercedStart, value));
                    }
                };
                $composer.updateRememberedValue(value$iv$iv4);
                $composer.endReplaceableGroup();
                endThumbSemantics = SliderKt.sliderSemantics(companion22, coercedEnd, z22, (Function1) value$iv$iv4, this.$onValueChangeFinished, RangesKt.rangeTo(coercedStart, this.$valueRange.getEndInclusive().floatValue()), endSteps);
                SliderKt.RangeSliderImpl(this.$enabled, fractionStart, fractionEnd, this.$tickFractions, this.$colors, maxPx.element - minPx.element, this.$startInteractionSource, this.$endInteractionSource, pressDrag, startThumbSemantics, endThumbSemantics, $composer, ((this.$$dirty >> 9) & 14) | 14159872 | ((this.$$dirty >> 9) & 57344), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            value$iv$iv3 = (Function2) new Function2<Boolean, Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$onDrag$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Float f) {
                    invoke(bool.booleanValue(), f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean isStart, float offset) {
                    ClosedFloatingPointRange offsetRange;
                    ClosedFloatingPointRange<Float> invoke$scaleToUserValue;
                    if (isStart) {
                        rawOffsetStart.setValue(Float.valueOf(rawOffsetStart.getValue().floatValue() + offset));
                        rawOffsetEnd.setValue(Float.valueOf(SliderKt$RangeSlider$2.invoke$scaleToOffset(closedFloatingPointRange7, minPx, maxPx, closedFloatingPointRange6.getEndInclusive().floatValue())));
                        float offsetEnd = rawOffsetEnd.getValue().floatValue();
                        offsetRange = RangesKt.rangeTo(RangesKt.coerceIn(rawOffsetStart.getValue().floatValue(), minPx.element, offsetEnd), offsetEnd);
                    } else {
                        rawOffsetEnd.setValue(Float.valueOf(rawOffsetEnd.getValue().floatValue() + offset));
                        rawOffsetStart.setValue(Float.valueOf(SliderKt$RangeSlider$2.invoke$scaleToOffset(closedFloatingPointRange7, minPx, maxPx, closedFloatingPointRange6.getStart().floatValue())));
                        float offsetStart = rawOffsetStart.getValue().floatValue();
                        offsetRange = RangesKt.rangeTo(offsetStart, RangesKt.coerceIn(rawOffsetEnd.getValue().floatValue(), offsetStart, maxPx.element));
                    }
                    Function1<ClosedFloatingPointRange<Float>, Unit> value = state2.getValue();
                    invoke$scaleToUserValue = SliderKt$RangeSlider$2.invoke$scaleToUserValue(minPx, maxPx, closedFloatingPointRange7, offsetRange);
                    value.invoke(invoke$scaleToUserValue);
                }
            };
            $composer.updateRememberedValue(value$iv$iv3);
            $composer.endReplaceableGroup();
            State onDrag2 = SnapshotStateKt.rememberUpdatedState(value$iv$iv3, $composer, 0);
            pressDrag = SliderKt.rangeSliderPressDragModifier(Modifier.INSTANCE, this.$startInteractionSource, this.$endInteractionSource, rawOffsetStart, rawOffsetEnd, this.$enabled, isRtl, widthPx, this.$valueRange, gestureEndAction, onDrag2);
            final float coercedStart2 = RangesKt.coerceIn(this.$value.getStart().floatValue(), this.$valueRange.getStart().floatValue(), this.$value.getEndInclusive().floatValue());
            final float coercedEnd2 = RangesKt.coerceIn(this.$value.getEndInclusive().floatValue(), this.$value.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue());
            fractionStart = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), coercedStart2);
            fractionEnd = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), coercedEnd2);
            int startSteps2 = (int) Math.floor(this.$steps * fractionEnd);
            int endSteps2 = (int) Math.floor(this.$steps * (1.0f - fractionStart));
            Modifier.Companion companion3 = Modifier.INSTANCE;
            boolean z3 = this.$enabled;
            Object key1$iv3 = this.$onValueChangeState;
            Object key2$iv4 = Float.valueOf(coercedEnd2);
            final State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state32 = this.$onValueChangeState;
            $composer.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer, "C(remember)P(1,2):Composables.kt#9igjgp");
            invalid$iv$iv = $composer.changed(key1$iv3) | $composer.changed(key2$iv4);
            Object value$iv$iv52 = $composer.rememberedValue();
            if (invalid$iv$iv) {
            }
            value$iv$iv52 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$startThumbSemantics$1$1
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

                public final void invoke(float value) {
                    state32.getValue().invoke(RangesKt.rangeTo(value, coercedEnd2));
                }
            };
            $composer.updateRememberedValue(value$iv$iv52);
            $composer.endReplaceableGroup();
            startThumbSemantics = SliderKt.sliderSemantics(companion3, coercedStart2, z3, (Function1) value$iv$iv52, this.$onValueChangeFinished, RangesKt.rangeTo(this.$valueRange.getStart().floatValue(), coercedEnd2), startSteps2);
            Modifier.Companion companion222 = Modifier.INSTANCE;
            boolean z222 = this.$enabled;
            Object key1$iv222 = this.$onValueChangeState;
            Object key2$iv322 = Float.valueOf(coercedStart2);
            final State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state422 = this.$onValueChangeState;
            $composer.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer, "C(remember)P(1,2):Composables.kt#9igjgp");
            invalid$iv$iv2 = $composer.changed(key1$iv222) | $composer.changed(key2$iv322);
            it$iv$iv = $composer.rememberedValue();
            if (invalid$iv$iv2) {
            }
            value$iv$iv4 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$endThumbSemantics$1$1
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

                public final void invoke(float value) {
                    state422.getValue().invoke(RangesKt.rangeTo(coercedStart2, value));
                }
            };
            $composer.updateRememberedValue(value$iv$iv4);
            $composer.endReplaceableGroup();
            endThumbSemantics = SliderKt.sliderSemantics(companion222, coercedEnd2, z222, (Function1) value$iv$iv4, this.$onValueChangeFinished, RangesKt.rangeTo(coercedStart2, this.$valueRange.getEndInclusive().floatValue()), endSteps2);
            SliderKt.RangeSliderImpl(this.$enabled, fractionStart, fractionEnd, this.$tickFractions, this.$colors, maxPx.element - minPx.element, this.$startInteractionSource, this.$endInteractionSource, pressDrag, startThumbSemantics, endThumbSemantics, $composer, ((this.$$dirty >> 9) & 14) | 14159872 | ((this.$$dirty >> 9) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer.skipToGroupEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> invoke$scaleToUserValue(Ref.FloatRef minPx, Ref.FloatRef maxPx, ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        ClosedFloatingPointRange<Float> scale;
        scale = SliderKt.scale(minPx.element, maxPx.element, (ClosedFloatingPointRange<Float>) closedFloatingPointRange2, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
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
    /* renamed from: androidx.compose.material.SliderKt$RangeSlider$2$2 */
    /* synthetic */ class C03422 extends FunctionReferenceImpl implements Function1<Float, Float> {
        final /* synthetic */ Ref.FloatRef $maxPx;
        final /* synthetic */ Ref.FloatRef $minPx;
        final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03422(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2) {
            super(1, Intrinsics.Kotlin.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
            this.$valueRange = closedFloatingPointRange;
            this.$minPx = floatRef;
            this.$maxPx = floatRef2;
        }

        public final Float invoke(float p0) {
            return Float.valueOf(SliderKt$RangeSlider$2.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, p0));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Float invoke(Float f) {
            return invoke(f.floatValue());
        }
    }

    /* compiled from: Slider.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    /* renamed from: androidx.compose.material.SliderKt$RangeSlider$2$3 */
    /* synthetic */ class C03433 extends FunctionReferenceImpl implements Function1<Float, Float> {
        final /* synthetic */ Ref.FloatRef $maxPx;
        final /* synthetic */ Ref.FloatRef $minPx;
        final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03433(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2) {
            super(1, Intrinsics.Kotlin.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
            this.$valueRange = closedFloatingPointRange;
            this.$minPx = floatRef;
            this.$maxPx = floatRef2;
        }

        public final Float invoke(float p0) {
            return Float.valueOf(SliderKt$RangeSlider$2.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, p0));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Float invoke(Float f) {
            return invoke(f.floatValue());
        }
    }
}
