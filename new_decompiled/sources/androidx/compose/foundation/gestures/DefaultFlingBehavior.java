package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: Scrollable.kt */
@Metadata(m286d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\u00020\u0004*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, m287d2 = {"Landroidx/compose/foundation/gestures/DefaultFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "flingDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "(Landroidx/compose/animation/core/DecayAnimationSpec;)V", "performFling", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class DefaultFlingBehavior implements FlingBehavior {
    private final DecayAnimationSpec<Float> flingDecay;

    public DefaultFlingBehavior(DecayAnimationSpec<Float> flingDecay) {
        Intrinsics.checkNotNullParameter(flingDecay, "flingDecay");
        this.flingDecay = flingDecay;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object performFling(final ScrollScope $this$performFling, float f, Continuation<? super Float> continuation) {
        DefaultFlingBehavior$performFling$1 defaultFlingBehavior$performFling$1;
        float initialVelocity;
        Ref.FloatRef velocityLeft;
        if (continuation instanceof DefaultFlingBehavior$performFling$1) {
            DefaultFlingBehavior$performFling$1 defaultFlingBehavior$performFling$12 = (DefaultFlingBehavior$performFling$1) continuation;
            if ((defaultFlingBehavior$performFling$12.label & Integer.MIN_VALUE) != 0) {
                defaultFlingBehavior$performFling$12.label -= Integer.MIN_VALUE;
                defaultFlingBehavior$performFling$1 = defaultFlingBehavior$performFling$12;
                Object $result = defaultFlingBehavior$performFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (defaultFlingBehavior$performFling$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        initialVelocity = f;
                        if (Math.abs(initialVelocity) <= 1.0f) {
                            return Boxing.boxFloat(initialVelocity);
                        }
                        final Ref.FloatRef velocityLeft2 = new Ref.FloatRef();
                        velocityLeft2.element = initialVelocity;
                        final Ref.FloatRef lastValue = new Ref.FloatRef();
                        AnimationState AnimationState$default = AnimationStateKt.AnimationState$default(0.0f, initialVelocity, 0L, 0L, false, 28, null);
                        DecayAnimationSpec<Float> decayAnimationSpec = this.flingDecay;
                        Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2
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
                                Intrinsics.checkNotNullParameter(animateDecay, "$this$animateDecay");
                                float delta = animateDecay.getValue().floatValue() - Ref.FloatRef.this.element;
                                float consumed = $this$performFling.scrollBy(delta);
                                Ref.FloatRef.this.element = animateDecay.getValue().floatValue();
                                velocityLeft2.element = animateDecay.getVelocity().floatValue();
                                if (Math.abs(delta - consumed) > 0.5f) {
                                    animateDecay.cancelAnimation();
                                }
                            }
                        };
                        defaultFlingBehavior$performFling$1.L$0 = velocityLeft2;
                        defaultFlingBehavior$performFling$1.label = 1;
                        if (SuspendAnimationKt.animateDecay$default(AnimationState$default, decayAnimationSpec, false, function1, defaultFlingBehavior$performFling$1, 2, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        velocityLeft = velocityLeft2;
                        initialVelocity = velocityLeft.element;
                        return Boxing.boxFloat(initialVelocity);
                    case 1:
                        velocityLeft = (Ref.FloatRef) defaultFlingBehavior$performFling$1.L$0;
                        ResultKt.throwOnFailure($result);
                        initialVelocity = velocityLeft.element;
                        return Boxing.boxFloat(initialVelocity);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        defaultFlingBehavior$performFling$1 = new DefaultFlingBehavior$performFling$1(this, continuation);
        Object $result2 = defaultFlingBehavior$performFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (defaultFlingBehavior$performFling$1.label) {
        }
    }
}
