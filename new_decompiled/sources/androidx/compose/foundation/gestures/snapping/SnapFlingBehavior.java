package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapFlingBehavior.kt */
@ExperimentalFoundationApi
@Metadata(m286d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BL\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\rø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u001d\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\u0006*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ%\u0010 \u001a\u00020!*\u00020\u001c2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010#J\u001d\u0010$\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\u00020\rX\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, m287d2 = {"Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "snapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "lowVelocityAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "highVelocityAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "density", "Landroidx/compose/ui/unit/Density;", "shortSnapVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/ui/unit/Density;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "velocityThreshold", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "isDecayApproachPossible", "offset", "velocity", "longSnap", "", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performFling", "runApproach", "Landroidx/compose/foundation/gestures/snapping/ApproachStepResult;", "initialTargetOffset", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shortSnap", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SnapFlingBehavior implements FlingBehavior {
    public static final int $stable = 0;
    private final Density density;
    private final DecayAnimationSpec<Float> highVelocityAnimationSpec;
    private final AnimationSpec<Float> lowVelocityAnimationSpec;
    private final float shortSnapVelocityThreshold;
    private final AnimationSpec<Float> snapAnimationSpec;
    private final SnapLayoutInfoProvider snapLayoutInfoProvider;
    private final float velocityThreshold;

    public /* synthetic */ SnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, AnimationSpec animationSpec2, Density density, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(snapLayoutInfoProvider, animationSpec, decayAnimationSpec, animationSpec2, density, f);
    }

    private SnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec2, Density density, float shortSnapVelocityThreshold) {
        this.snapLayoutInfoProvider = snapLayoutInfoProvider;
        this.lowVelocityAnimationSpec = animationSpec;
        this.highVelocityAnimationSpec = decayAnimationSpec;
        this.snapAnimationSpec = animationSpec2;
        this.density = density;
        this.shortSnapVelocityThreshold = shortSnapVelocityThreshold;
        Density $this$velocityThreshold_u24lambda_u2d0 = this.density;
        this.velocityThreshold = $this$velocityThreshold_u24lambda_u2d0.mo648toPx0680j_4(this.shortSnapVelocityThreshold);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, AnimationSpec animationSpec2, Density density, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(snapLayoutInfoProvider, animationSpec, decayAnimationSpec, animationSpec2, density, r7, null);
        float f2;
        if ((i & 32) == 0) {
            f2 = f;
        } else {
            f2 = SnapFlingBehaviorKt.getMinFlingVelocityDp();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object performFling(ScrollScope $this$performFling, float initialVelocity, Continuation<? super Float> continuation) {
        SnapFlingBehavior$performFling$1 snapFlingBehavior$performFling$1;
        SnapFlingBehavior$performFling$1 snapFlingBehavior$performFling$12;
        if (continuation instanceof SnapFlingBehavior$performFling$1) {
            snapFlingBehavior$performFling$1 = (SnapFlingBehavior$performFling$1) continuation;
            if ((snapFlingBehavior$performFling$1.label & Integer.MIN_VALUE) != 0) {
                snapFlingBehavior$performFling$1.label -= Integer.MIN_VALUE;
                snapFlingBehavior$performFling$12 = snapFlingBehavior$performFling$1;
                Object $result = snapFlingBehavior$performFling$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (snapFlingBehavior$performFling$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (Math.abs(initialVelocity) <= Math.abs(this.velocityThreshold)) {
                            snapFlingBehavior$performFling$12.label = 1;
                            if (shortSnap($this$performFling, initialVelocity, snapFlingBehavior$performFling$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            snapFlingBehavior$performFling$12.label = 2;
                            if (longSnap($this$performFling, initialVelocity, snapFlingBehavior$performFling$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Boxing.boxFloat(0.0f);
            }
        }
        snapFlingBehavior$performFling$1 = new SnapFlingBehavior$performFling$1(this, continuation);
        snapFlingBehavior$performFling$12 = snapFlingBehavior$performFling$1;
        Object $result2 = snapFlingBehavior$performFling$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (snapFlingBehavior$performFling$12.label) {
        }
        return Boxing.boxFloat(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object shortSnap(ScrollScope $this$shortSnap, float velocity, Continuation<? super Unit> continuation) {
        float closestOffset = SnapFlingBehaviorKt.findClosestOffset(0.0f, this.snapLayoutInfoProvider, this.density);
        AnimationState animationState = AnimationStateKt.AnimationState$default(0.0f, velocity, 0L, 0L, false, 28, null);
        Object animateSnap = SnapFlingBehaviorKt.animateSnap($this$shortSnap, closestOffset, closestOffset, animationState, this.snapAnimationSpec, continuation);
        return animateSnap == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateSnap : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object longSnap(ScrollScope $this$longSnap, float initialVelocity, Continuation<? super Unit> continuation) {
        SnapFlingBehavior$longSnap$1 snapFlingBehavior$longSnap$1;
        SnapFlingBehavior$longSnap$1 snapFlingBehavior$longSnap$12;
        Object runApproach;
        SnapFlingBehavior snapFlingBehavior;
        float remainingOffset;
        AnimationState animationState;
        AnimationSpec<Float> animationSpec;
        if (continuation instanceof SnapFlingBehavior$longSnap$1) {
            snapFlingBehavior$longSnap$1 = (SnapFlingBehavior$longSnap$1) continuation;
            if ((snapFlingBehavior$longSnap$1.label & Integer.MIN_VALUE) != 0) {
                snapFlingBehavior$longSnap$1.label -= Integer.MIN_VALUE;
                snapFlingBehavior$longSnap$12 = snapFlingBehavior$longSnap$1;
                Object $result = snapFlingBehavior$longSnap$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (snapFlingBehavior$longSnap$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        SnapLayoutInfoProvider $this$longSnap_u24lambda_u2d1 = this.snapLayoutInfoProvider;
                        float it = $this$longSnap_u24lambda_u2d1.calculateApproachOffset(this.density, initialVelocity);
                        float initialOffset = Math.abs(it) * Math.signum(initialVelocity);
                        snapFlingBehavior$longSnap$12.L$0 = this;
                        snapFlingBehavior$longSnap$12.L$1 = $this$longSnap;
                        snapFlingBehavior$longSnap$12.label = 1;
                        runApproach = runApproach($this$longSnap, initialOffset, initialVelocity, snapFlingBehavior$longSnap$12);
                        if (runApproach == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        snapFlingBehavior = this;
                        ApproachStepResult approachStepResult = (ApproachStepResult) runApproach;
                        remainingOffset = approachStepResult.getRemainingOffset();
                        animationState = approachStepResult.component2();
                        animationSpec = snapFlingBehavior.snapAnimationSpec;
                        snapFlingBehavior$longSnap$12.L$0 = null;
                        snapFlingBehavior$longSnap$12.L$1 = null;
                        snapFlingBehavior$longSnap$12.label = 2;
                        if (SnapFlingBehaviorKt.animateSnap($this$longSnap, remainingOffset, remainingOffset, animationState, animationSpec, snapFlingBehavior$longSnap$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        $this$longSnap = (ScrollScope) snapFlingBehavior$longSnap$12.L$1;
                        SnapFlingBehavior snapFlingBehavior2 = (SnapFlingBehavior) snapFlingBehavior$longSnap$12.L$0;
                        ResultKt.throwOnFailure($result);
                        snapFlingBehavior = snapFlingBehavior2;
                        runApproach = $result;
                        ApproachStepResult approachStepResult2 = (ApproachStepResult) runApproach;
                        remainingOffset = approachStepResult2.getRemainingOffset();
                        animationState = approachStepResult2.component2();
                        animationSpec = snapFlingBehavior.snapAnimationSpec;
                        snapFlingBehavior$longSnap$12.L$0 = null;
                        snapFlingBehavior$longSnap$12.L$1 = null;
                        snapFlingBehavior$longSnap$12.label = 2;
                        if (SnapFlingBehaviorKt.animateSnap($this$longSnap, remainingOffset, remainingOffset, animationState, animationSpec, snapFlingBehavior$longSnap$12) == coroutine_suspended) {
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
        snapFlingBehavior$longSnap$1 = new SnapFlingBehavior$longSnap$1(this, continuation);
        snapFlingBehavior$longSnap$12 = snapFlingBehavior$longSnap$1;
        Object $result2 = snapFlingBehavior$longSnap$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (snapFlingBehavior$longSnap$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object runApproach(ScrollScope $this$runApproach, float initialTargetOffset, float initialVelocity, Continuation<? super ApproachStepResult> continuation) {
        ApproachAnimation animation;
        if (isDecayApproachPossible(initialTargetOffset, initialVelocity)) {
            animation = new HighVelocityApproachAnimation(this.highVelocityAnimationSpec);
        } else {
            animation = new LowVelocityApproachAnimation(this.lowVelocityAnimationSpec, this.snapLayoutInfoProvider, this.density);
        }
        return SnapFlingBehaviorKt.approach($this$runApproach, initialTargetOffset, initialVelocity, animation, this.snapLayoutInfoProvider, this.density, continuation);
    }

    private final boolean isDecayApproachPossible(float offset, float velocity) {
        float decayOffset = DecayAnimationSpecKt.calculateTargetValue(this.highVelocityAnimationSpec, 0.0f, velocity);
        return Math.abs(decayOffset) > Math.abs(offset);
    }

    public boolean equals(Object other) {
        return (other instanceof SnapFlingBehavior) && Intrinsics.areEqual(((SnapFlingBehavior) other).snapAnimationSpec, this.snapAnimationSpec) && Intrinsics.areEqual(((SnapFlingBehavior) other).highVelocityAnimationSpec, this.highVelocityAnimationSpec) && Intrinsics.areEqual(((SnapFlingBehavior) other).lowVelocityAnimationSpec, this.lowVelocityAnimationSpec) && Intrinsics.areEqual(((SnapFlingBehavior) other).snapLayoutInfoProvider, this.snapLayoutInfoProvider) && Intrinsics.areEqual(((SnapFlingBehavior) other).density, this.density) && C0504Dp.m4387equalsimpl0(((SnapFlingBehavior) other).shortSnapVelocityThreshold, this.shortSnapVelocityThreshold);
    }

    public int hashCode() {
        int it = (0 * 31) + this.snapAnimationSpec.hashCode();
        return (((((((((it * 31) + this.highVelocityAnimationSpec.hashCode()) * 31) + this.lowVelocityAnimationSpec.hashCode()) * 31) + this.snapLayoutInfoProvider.hashCode()) * 31) + this.density.hashCode()) * 31) + C0504Dp.m4388hashCodeimpl(this.shortSnapVelocityThreshold);
    }
}
