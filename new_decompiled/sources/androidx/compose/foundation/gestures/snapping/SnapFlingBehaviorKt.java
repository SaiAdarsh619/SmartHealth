package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* compiled from: SnapFlingBehavior.kt */
@Metadata(m286d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0010\u001aK\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001aS\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001dH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001aI\u0010\u001f\u001a\u00020 *\u00020\u00142\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130$2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%\u001a\u0014\u0010&\u001a\u00020\u0006*\u00020\u00062\u0006\u0010'\u001a\u00020\u0006H\u0002\u001a(\u0010(\u001a\u0002H)\"\u000e\b\u0000\u0010)*\b\u0012\u0004\u0012\u0002H)0**\b\u0012\u0004\u0012\u0002H)0+H\u0082\u0002¢\u0006\u0002\u0010,\u001a(\u0010-\u001a\u0002H)\"\u000e\b\u0000\u0010)*\b\u0012\u0004\u0012\u0002H)0**\b\u0012\u0004\u0012\u0002H)0+H\u0082\u0002¢\u0006\u0002\u0010,\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, m287d2 = {"MinFlingVelocityDp", "Landroidx/compose/ui/unit/Dp;", "getMinFlingVelocityDp", "()F", "F", "NoDistance", "", "NoVelocity", "findClosestOffset", "velocity", "snapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "density", "Landroidx/compose/ui/unit/Density;", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "animateDecay", "Landroidx/compose/animation/core/AnimationState;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/foundation/gestures/ScrollScope;", "targetOffset", "animationState", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/foundation/gestures/ScrollScope;FLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateSnap", "cancelOffset", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "approach", "Landroidx/compose/foundation/gestures/snapping/ApproachStepResult;", "initialTargetOffset", "initialVelocity", "animation", "Landroidx/compose/foundation/gestures/snapping/ApproachAnimation;", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/foundation/gestures/snapping/ApproachAnimation;Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/ui/unit/Density;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coerceToTarget", "target", "component1", "T", "", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "component2", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SnapFlingBehaviorKt {
    private static final float MinFlingVelocityDp = C0504Dp.m4382constructorimpl(400);
    public static final float NoDistance = 0.0f;
    public static final float NoVelocity = 0.0f;

    @ExperimentalFoundationApi
    public static final SnapFlingBehavior rememberSnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(snapLayoutInfoProvider, "snapLayoutInfoProvider");
        $composer.startReplaceableGroup(-473984552);
        ComposerKt.sourceInformation($composer, "C(rememberSnapFlingBehavior)185@7875L7,186@7945L26,187@7983L447:SnapFlingBehavior.kt#ppz6w6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-473984552, $changed, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (SnapFlingBehavior.kt:182)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume;
        DecayAnimationSpec highVelocityApproachSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay($composer, 0);
        int i = ($changed & 14) | 64;
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(snapLayoutInfoProvider) | $composer.changed(highVelocityApproachSpec) | $composer.changed(density);
        Object value$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new SnapFlingBehavior(snapLayoutInfoProvider, AnimationSpecKt.tween$default(0, 0, EasingKt.getLinearEasing(), 3, null), highVelocityApproachSpec, AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null), density, 0.0f, 32, null);
            $composer.updateRememberedValue(value$iv$iv);
        }
        $composer.endReplaceableGroup();
        SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return snapFlingBehavior;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object approach(ScrollScope $this$approach, float initialTargetOffset, float initialVelocity, ApproachAnimation<Float, AnimationVector1D> approachAnimation, SnapLayoutInfoProvider snapLayoutInfoProvider, Density density, Continuation<? super ApproachStepResult> continuation) {
        SnapFlingBehaviorKt$approach$1 snapFlingBehaviorKt$approach$1;
        SnapFlingBehaviorKt$approach$1 snapFlingBehaviorKt$approach$12;
        Object approachAnimation2;
        SnapLayoutInfoProvider snapLayoutInfoProvider2;
        if (continuation instanceof SnapFlingBehaviorKt$approach$1) {
            snapFlingBehaviorKt$approach$1 = (SnapFlingBehaviorKt$approach$1) continuation;
            if ((snapFlingBehaviorKt$approach$1.label & Integer.MIN_VALUE) != 0) {
                snapFlingBehaviorKt$approach$1.label -= Integer.MIN_VALUE;
                snapFlingBehaviorKt$approach$12 = snapFlingBehaviorKt$approach$1;
                Object $result = snapFlingBehaviorKt$approach$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (snapFlingBehaviorKt$approach$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Float boxFloat = Boxing.boxFloat(initialTargetOffset);
                        Float boxFloat2 = Boxing.boxFloat(initialVelocity);
                        snapFlingBehaviorKt$approach$12.L$0 = snapLayoutInfoProvider;
                        snapFlingBehaviorKt$approach$12.L$1 = density;
                        snapFlingBehaviorKt$approach$12.label = 1;
                        approachAnimation2 = approachAnimation.approachAnimation($this$approach, boxFloat, boxFloat2, snapFlingBehaviorKt$approach$12);
                        if (approachAnimation2 != coroutine_suspended) {
                            snapLayoutInfoProvider2 = snapLayoutInfoProvider;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        Density density2 = (Density) snapFlingBehaviorKt$approach$12.L$1;
                        snapLayoutInfoProvider2 = (SnapLayoutInfoProvider) snapFlingBehaviorKt$approach$12.L$0;
                        ResultKt.throwOnFailure($result);
                        density = density2;
                        approachAnimation2 = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AnimationState currentAnimationState = (AnimationState) approachAnimation2;
                float remainingOffset = findClosestOffset(((Number) currentAnimationState.getVelocity()).floatValue(), snapLayoutInfoProvider2, density);
                return new ApproachStepResult(remainingOffset, currentAnimationState);
            }
        }
        snapFlingBehaviorKt$approach$1 = new SnapFlingBehaviorKt$approach$1(continuation);
        snapFlingBehaviorKt$approach$12 = snapFlingBehaviorKt$approach$1;
        Object $result2 = snapFlingBehaviorKt$approach$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (snapFlingBehaviorKt$approach$12.label) {
        }
        AnimationState currentAnimationState2 = (AnimationState) approachAnimation2;
        float remainingOffset2 = findClosestOffset(((Number) currentAnimationState2.getVelocity()).floatValue(), snapLayoutInfoProvider2, density);
        return new ApproachStepResult(remainingOffset2, currentAnimationState2);
    }

    private static final boolean findClosestOffset$isValidDistance(float $this$findClosestOffset_u24isValidDistance) {
        if (!($this$findClosestOffset_u24isValidDistance == Float.POSITIVE_INFINITY)) {
            if (!($this$findClosestOffset_u24isValidDistance == Float.NEGATIVE_INFINITY)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0040, code lost:
    
        if (java.lang.Math.abs(r0) <= java.lang.Math.abs(r1)) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final float findClosestOffset(float velocity, SnapLayoutInfoProvider snapLayoutInfoProvider, Density density) {
        float finalDistance;
        Intrinsics.checkNotNullParameter(snapLayoutInfoProvider, "snapLayoutInfoProvider");
        Intrinsics.checkNotNullParameter(density, "density");
        ClosedFloatingPointRange<Float> calculateSnappingOffsetBounds = snapLayoutInfoProvider.calculateSnappingOffsetBounds(density);
        float lowerBound = ((Number) component1(calculateSnappingOffsetBounds)).floatValue();
        float upperBound = ((Number) component2(calculateSnappingOffsetBounds)).floatValue();
        float signum = Math.signum(velocity);
        if (!(signum == 0.0f)) {
            if (!(signum == 1.0f)) {
                if (!(signum == -1.0f)) {
                    finalDistance = 0.0f;
                }
                finalDistance = lowerBound;
            }
            finalDistance = upperBound;
        }
        if (findClosestOffset$isValidDistance(finalDistance)) {
            return finalDistance;
        }
        return 0.0f;
    }

    private static final <T extends Comparable<? super T>> T component1(ClosedFloatingPointRange<T> closedFloatingPointRange) {
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, "<this>");
        return closedFloatingPointRange.getStart();
    }

    private static final <T extends Comparable<? super T>> T component2(ClosedFloatingPointRange<T> closedFloatingPointRange) {
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, "<this>");
        return closedFloatingPointRange.getEndInclusive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object animateDecay(final ScrollScope $this$animateDecay, final float targetOffset, AnimationState<Float, AnimationVector1D> animationState, DecayAnimationSpec<Float> decayAnimationSpec, Continuation<? super AnimationState<Float, AnimationVector1D>> continuation) {
        SnapFlingBehaviorKt$animateDecay$1 snapFlingBehaviorKt$animateDecay$1;
        SnapFlingBehaviorKt$animateDecay$1 snapFlingBehaviorKt$animateDecay$12;
        if (continuation instanceof SnapFlingBehaviorKt$animateDecay$1) {
            snapFlingBehaviorKt$animateDecay$1 = (SnapFlingBehaviorKt$animateDecay$1) continuation;
            if ((snapFlingBehaviorKt$animateDecay$1.label & Integer.MIN_VALUE) != 0) {
                snapFlingBehaviorKt$animateDecay$1.label -= Integer.MIN_VALUE;
                snapFlingBehaviorKt$animateDecay$12 = snapFlingBehaviorKt$animateDecay$1;
                Object $result = snapFlingBehaviorKt$animateDecay$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (snapFlingBehaviorKt$animateDecay$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        final Ref.FloatRef previousValue = new Ref.FloatRef();
                        boolean z = animationState.getVelocity().floatValue() == 0.0f;
                        Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                invoke2(animationScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(AnimationScope<Float, AnimationVector1D> animateDecay) {
                                float finalValue;
                                Intrinsics.checkNotNullParameter(animateDecay, "$this$animateDecay");
                                if (Math.abs(animateDecay.getValue().floatValue()) >= Math.abs(targetOffset)) {
                                    finalValue = SnapFlingBehaviorKt.coerceToTarget(animateDecay.getValue().floatValue(), targetOffset);
                                    float finalDelta = finalValue - previousValue.element;
                                    SnapFlingBehaviorKt.animateDecay$consumeDelta(animateDecay, $this$animateDecay, finalDelta);
                                    animateDecay.cancelAnimation();
                                    return;
                                }
                                float delta = animateDecay.getValue().floatValue() - previousValue.element;
                                SnapFlingBehaviorKt.animateDecay$consumeDelta(animateDecay, $this$animateDecay, delta);
                                previousValue.element = animateDecay.getValue().floatValue();
                            }
                        };
                        snapFlingBehaviorKt$animateDecay$12.L$0 = animationState;
                        snapFlingBehaviorKt$animateDecay$12.label = 1;
                        if (SuspendAnimationKt.animateDecay(animationState, decayAnimationSpec, !z, function1, snapFlingBehaviorKt$animateDecay$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return animationState;
                    case 1:
                        AnimationState animationState2 = (AnimationState) snapFlingBehaviorKt$animateDecay$12.L$0;
                        ResultKt.throwOnFailure($result);
                        return animationState2;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        snapFlingBehaviorKt$animateDecay$1 = new SnapFlingBehaviorKt$animateDecay$1(continuation);
        snapFlingBehaviorKt$animateDecay$12 = snapFlingBehaviorKt$animateDecay$1;
        Object $result2 = snapFlingBehaviorKt$animateDecay$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (snapFlingBehaviorKt$animateDecay$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateDecay$consumeDelta(AnimationScope<Float, AnimationVector1D> animationScope, ScrollScope $this_animateDecay, float delta) {
        float consumed = $this_animateDecay.scrollBy(delta);
        if (Math.abs(delta - consumed) > 0.5f) {
            animationScope.cancelAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object animateSnap(final ScrollScope $this$animateSnap, float targetOffset, final float cancelOffset, AnimationState<Float, AnimationVector1D> animationState, AnimationSpec<Float> animationSpec, Continuation<? super AnimationState<Float, AnimationVector1D>> continuation) {
        SnapFlingBehaviorKt$animateSnap$1 snapFlingBehaviorKt$animateSnap$1;
        SnapFlingBehaviorKt$animateSnap$1 snapFlingBehaviorKt$animateSnap$12;
        AnimationState animationState2;
        float initialVelocity;
        if (continuation instanceof SnapFlingBehaviorKt$animateSnap$1) {
            snapFlingBehaviorKt$animateSnap$1 = (SnapFlingBehaviorKt$animateSnap$1) continuation;
            if ((snapFlingBehaviorKt$animateSnap$1.label & Integer.MIN_VALUE) != 0) {
                snapFlingBehaviorKt$animateSnap$1.label -= Integer.MIN_VALUE;
                snapFlingBehaviorKt$animateSnap$12 = snapFlingBehaviorKt$animateSnap$1;
                Object $result = snapFlingBehaviorKt$animateSnap$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (snapFlingBehaviorKt$animateSnap$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        final Ref.FloatRef consumedUpToNow = new Ref.FloatRef();
                        float initialVelocity2 = animationState.getVelocity().floatValue();
                        Float boxFloat = Boxing.boxFloat(targetOffset);
                        boolean z = !(animationState.getVelocity().floatValue() == 0.0f);
                        Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                invoke2(animationScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:6:0x003e, code lost:
                            
                                if ((r0 == r6.getValue().floatValue()) == false) goto L9;
                             */
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final void invoke2(AnimationScope<Float, AnimationVector1D> animateTo) {
                                float realValue;
                                Intrinsics.checkNotNullParameter(animateTo, "$this$animateTo");
                                realValue = SnapFlingBehaviorKt.coerceToTarget(animateTo.getValue().floatValue(), cancelOffset);
                                float delta = realValue - consumedUpToNow.element;
                                float consumed = $this$animateSnap.scrollBy(delta);
                                if (Math.abs(delta - consumed) <= 0.5f) {
                                }
                                animateTo.cancelAnimation();
                                consumedUpToNow.element += delta;
                            }
                        };
                        snapFlingBehaviorKt$animateSnap$12.L$0 = animationState;
                        snapFlingBehaviorKt$animateSnap$12.F$0 = initialVelocity2;
                        snapFlingBehaviorKt$animateSnap$12.label = 1;
                        if (SuspendAnimationKt.animateTo(animationState, boxFloat, animationSpec, z, function1, snapFlingBehaviorKt$animateSnap$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        animationState2 = animationState;
                        initialVelocity = initialVelocity2;
                        break;
                    case 1:
                        initialVelocity = snapFlingBehaviorKt$animateSnap$12.F$0;
                        animationState2 = (AnimationState) snapFlingBehaviorKt$animateSnap$12.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                float finalVelocity = coerceToTarget(animationState2.getVelocity().floatValue(), initialVelocity);
                return AnimationStateKt.copy$default(animationState2, 0.0f, finalVelocity, 0L, 0L, false, 29, (Object) null);
            }
        }
        snapFlingBehaviorKt$animateSnap$1 = new SnapFlingBehaviorKt$animateSnap$1(continuation);
        snapFlingBehaviorKt$animateSnap$12 = snapFlingBehaviorKt$animateSnap$1;
        Object $result2 = snapFlingBehaviorKt$animateSnap$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (snapFlingBehaviorKt$animateSnap$12.label) {
        }
        float finalVelocity2 = coerceToTarget(animationState2.getVelocity().floatValue(), initialVelocity);
        return AnimationStateKt.copy$default(animationState2, 0.0f, finalVelocity2, 0L, 0L, false, 29, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float coerceToTarget(float $this$coerceToTarget, float target) {
        if (target == 0.0f) {
            return 0.0f;
        }
        return target > 0.0f ? RangesKt.coerceAtMost($this$coerceToTarget, target) : RangesKt.coerceAtLeast($this$coerceToTarget, target);
    }

    public static final float getMinFlingVelocityDp() {
        return MinFlingVelocityDp;
    }
}
