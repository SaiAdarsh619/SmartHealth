package androidx.compose.animation.core;

import androidx.autofill.HintConstants;
import androidx.compose.p000ui.MotionDurationScale;
import androidx.compose.runtime.MonotonicFrameClockKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: SuspendAnimation.kt */
@Metadata(m286d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u001a\u0099\u0001\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u000b2\u0006\u0010\f\u001a\u0002H\u00072\u0006\u0010\r\u001a\u0002H\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u0001H\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u0011H\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001as\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aa\u0010\u0019\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u001a26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001av\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010$\u001ap\u0010\u0019\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070%2\b\b\u0002\u0010&\u001a\u00020'2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010(\u001az\u0010)\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2\u0006\u0010\r\u001a\u0002H\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00102\b\b\u0002\u0010&\u001a\u00020'2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010*\u001aZ\u0010+\u001a\u0002H,\"\u0004\b\u0000\u0010,\"\u0004\b\u0001\u0010\u0007\"\b\b\u0002\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2!\u0010-\u001a\u001d\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(.\u0012\u0004\u0012\u0002H,0!H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010/\u001a\u0085\u0001\u00100\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"2\u0006\u0010.\u001a\u00020 2\u0006\u00101\u001a\u00020 2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2#\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0002\u001a\u0085\u0001\u00104\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"2\u0006\u0010.\u001a\u00020 2\u0006\u0010\u0000\u001a\u00020\u00012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2#\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0002\u001a<\u00105\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001cH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, m287d2 = {"durationScale", "", "Lkotlin/coroutines/CoroutineContext;", "getDurationScale", "(Lkotlin/coroutines/CoroutineContext;)F", "animate", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "targetValue", "initialVelocity", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "value", "velocity", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(FFFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateDecay", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "(FFLandroidx/compose/animation/core/FloatDecayAnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/AnimationState;", "animation", "Landroidx/compose/animation/core/Animation;", "startTimeNanos", "", "Lkotlin/Function1;", "Landroidx/compose/animation/core/AnimationScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/Animation;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "sequentialAnimation", "", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callWithFrameNanos", "R", "onFrame", "frameTimeNanos", "(Landroidx/compose/animation/core/Animation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doAnimationFrame", "playTimeNanos", "anim", "state", "doAnimationFrameWithScale", "updateState", "animation-core_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SuspendAnimationKt {
    public static /* synthetic */ Object animate$default(float f, float f2, float f3, AnimationSpec animationSpec, Function2 function2, Continuation continuation, int i, Object obj) {
        float f4;
        AnimationSpec animationSpec2;
        if ((i & 4) == 0) {
            f4 = f3;
        } else {
            f4 = 0.0f;
        }
        if ((i & 8) == 0) {
            animationSpec2 = animationSpec;
        } else {
            animationSpec2 = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return animate(f, f2, f4, animationSpec2, function2, continuation);
    }

    public static final Object animate(float initialValue, float targetValue, float initialVelocity, AnimationSpec<Float> animationSpec, Function2<? super Float, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object animate = animate(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Boxing.boxFloat(initialValue), Boxing.boxFloat(targetValue), Boxing.boxFloat(initialVelocity), animationSpec, function2, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    public static final Object animateDecay(float initialValue, float initialVelocity, FloatDecayAnimationSpec animationSpec, final Function2<? super Float, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        DecayAnimation anim = AnimationKt.DecayAnimation(animationSpec, initialValue, initialVelocity);
        Object animate$default = animate$default(AnimationStateKt.AnimationState$default(initialValue, initialVelocity, 0L, 0L, false, 28, null), anim, 0L, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateDecay$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                invoke2(animationScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AnimationScope<Float, AnimationVector1D> animate) {
                Intrinsics.checkNotNullParameter(animate, "$this$animate");
                function2.invoke(animate.getValue(), Float.valueOf(animate.getVelocityVector().getValue()));
            }
        }, continuation, 2, null);
        return animate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animate$default(TwoWayConverter twoWayConverter, Object obj, Object obj2, Object obj3, AnimationSpec animationSpec, Function2 function2, Continuation continuation, int i, Object obj4) {
        Object obj5;
        AnimationSpec animationSpec2;
        if ((i & 8) == 0) {
            obj5 = obj3;
        } else {
            obj5 = null;
        }
        if ((i & 16) == 0) {
            animationSpec2 = animationSpec;
        } else {
            animationSpec2 = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return animate(twoWayConverter, obj, obj2, obj5, animationSpec2, function2, continuation);
    }

    public static final <T, V extends AnimationVector> Object animate(final TwoWayConverter<T, V> twoWayConverter, T t, T t2, T t3, AnimationSpec<T> animationSpec, final Function2<? super T, ? super T, Unit> function2, Continuation<? super Unit> continuation) {
        V invoke;
        AnimationVector initialVelocityVector = (t3 == null || (invoke = twoWayConverter.getConvertToVector().invoke(t3)) == null) ? AnimationVectorsKt.newInstance(twoWayConverter.getConvertToVector().invoke(t)) : invoke;
        TargetBasedAnimation anim = new TargetBasedAnimation(animationSpec, twoWayConverter, t, t2, initialVelocityVector);
        Object animate$default = animate$default(new AnimationState(twoWayConverter, t, initialVelocityVector, 0L, 0L, false, 56, null), anim, 0L, new Function1<AnimationScope<T, V>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke((AnimationScope) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(AnimationScope<T, V> animate) {
                Intrinsics.checkNotNullParameter(animate, "$this$animate");
                function2.invoke(animate.getValue(), twoWayConverter.getConvertFromVector().invoke(animate.getVelocityVector()));
            }
        }, continuation, 2, null);
        return animate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate$default : Unit.INSTANCE;
    }

    public static final <T, V extends AnimationVector> Object animateTo(AnimationState<T, V> animationState, T t, AnimationSpec<T> animationSpec, boolean sequentialAnimation, Function1<? super AnimationScope<T, V>, Unit> function1, Continuation<? super Unit> continuation) {
        TargetBasedAnimation anim = new TargetBasedAnimation(animationSpec, animationState.getTypeConverter(), animationState.getValue(), t, animationState.getVelocityVector());
        Object animate = animate(animationState, anim, sequentialAnimation ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, function1, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateDecay$default(AnimationState animationState, DecayAnimationSpec decayAnimationSpec, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function1 = new Function1<AnimationScope<T, V>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateDecay$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                    invoke((AnimationScope) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimationScope<T, V> animationScope) {
                    Intrinsics.checkNotNullParameter(animationScope, "$this$null");
                }
            };
        }
        return animateDecay(animationState, decayAnimationSpec, z, function1, (Continuation<? super Unit>) continuation);
    }

    public static final <T, V extends AnimationVector> Object animateDecay(AnimationState<T, V> animationState, DecayAnimationSpec<T> decayAnimationSpec, boolean sequentialAnimation, Function1<? super AnimationScope<T, V>, Unit> function1, Continuation<? super Unit> continuation) {
        DecayAnimation anim = new DecayAnimation((DecayAnimationSpec) decayAnimationSpec, (TwoWayConverter) animationState.getTypeConverter(), (Object) animationState.getValue(), (AnimationVector) animationState.getVelocityVector());
        Object animate = animate(animationState, anim, sequentialAnimation ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, function1, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|1|(2:3|(4:5|6|7|8))|82|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x005c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x005d, code lost:
    
        r21 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x012a A[Catch: CancellationException -> 0x015b, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x015b, blocks: (B:17:0x011d, B:19:0x012a), top: B:16:0x011d }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0158 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /* JADX WARN: Type inference failed for: r12v1, types: [T, androidx.compose.animation.core.AnimationScope] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, V extends AnimationVector> Object animate(AnimationState<T, V> animationState, final Animation<T, V> animation, long j, final Function1<? super AnimationScope<T, V>, Unit> function1, Continuation<? super Unit> continuation) {
        SuspendAnimationKt$animate$4 suspendAnimationKt$animate$4;
        Ref.ObjectRef objectRef;
        boolean z;
        final AnimationState<T, V> animationState2;
        AnimationScope animationScope;
        AnimationScope animationScope2;
        boolean z2;
        Function1<Long, Unit> function12;
        Function1<? super AnimationScope<T, V>, Unit> function13;
        Ref.ObjectRef objectRef2;
        Animation<T, V> animation2;
        T t;
        Function1<Long, Unit> function14;
        if (continuation instanceof SuspendAnimationKt$animate$4) {
            suspendAnimationKt$animate$4 = (SuspendAnimationKt$animate$4) continuation;
            if ((suspendAnimationKt$animate$4.label & Integer.MIN_VALUE) != 0) {
                suspendAnimationKt$animate$4.label -= Integer.MIN_VALUE;
                Object obj = suspendAnimationKt$animate$4.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                objectRef = suspendAnimationKt$animate$4.label;
                switch (objectRef) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        animationState2 = animationState;
                        final T valueFromNanos = animation.getValueFromNanos(0L);
                        final V velocityVectorFromNanos = animation.getVelocityVectorFromNanos(0L);
                        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                        if (j == Long.MIN_VALUE) {
                            try {
                                final float durationScale = getDurationScale(suspendAnimationKt$animate$4.getContext());
                                try {
                                    function12 = new Function1<Long, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$6
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/internal/Ref$ObjectRef<Landroidx/compose/animation/core/AnimationScope<TT;TV;>;>;TT;Landroidx/compose/animation/core/Animation<TT;TV;>;TV;Landroidx/compose/animation/core/AnimationState<TT;TV;>;FLkotlin/jvm/functions/Function1<-Landroidx/compose/animation/core/AnimationScope<TT;TV;>;Lkotlin/Unit;>;)V */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                            invoke(l.longValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX WARN: Type inference failed for: r12v0, types: [T, androidx.compose.animation.core.AnimationScope] */
                                        public final void invoke(long it) {
                                            Ref.ObjectRef<AnimationScope<T, V>> objectRef4 = Ref.ObjectRef.this;
                                            T t2 = valueFromNanos;
                                            TwoWayConverter typeConverter = animation.getTypeConverter();
                                            AnimationVector animationVector = velocityVectorFromNanos;
                                            Object targetValue = animation.getTargetValue();
                                            final AnimationState<T, V> animationState3 = animationState2;
                                            ?? animationScope3 = new AnimationScope(t2, typeConverter, animationVector, it, targetValue, it, true, new Function0<Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$6.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2() {
                                                    animationState3.setRunning$animation_core_release(false);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public /* bridge */ /* synthetic */ Unit invoke() {
                                                    invoke2();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            SuspendAnimationKt.doAnimationFrameWithScale(animationScope3, it, durationScale, animation, animationState2, function1);
                                            objectRef4.element = animationScope3;
                                        }
                                    };
                                    suspendAnimationKt$animate$4.L$0 = animationState2;
                                    suspendAnimationKt$animate$4.L$1 = animation;
                                    suspendAnimationKt$animate$4.L$2 = function1;
                                    suspendAnimationKt$animate$4.L$3 = objectRef3;
                                    z2 = true;
                                } catch (CancellationException e) {
                                    e = e;
                                    z2 = true;
                                }
                            } catch (CancellationException e2) {
                                e = e2;
                                objectRef = objectRef3;
                                z = true;
                            }
                            try {
                                suspendAnimationKt$animate$4.label = 1;
                                if (callWithFrameNanos(animation, function12, suspendAnimationKt$animate$4) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                function13 = function1;
                                objectRef2 = objectRef3;
                                animation2 = animation;
                                z = z2;
                                objectRef = objectRef2;
                                do {
                                    try {
                                        t = objectRef.element;
                                        Intrinsics.checkNotNull(t);
                                        if (((AnimationScope) t).isRunning()) {
                                            return Unit.INSTANCE;
                                        }
                                        final float durationScale2 = getDurationScale(suspendAnimationKt$animate$4.getContext());
                                        final Ref.ObjectRef objectRef4 = objectRef;
                                        final Animation<T, V> animation3 = animation2;
                                        final AnimationState<T, V> animationState3 = animationState2;
                                        final Function1<? super AnimationScope<T, V>, Unit> function15 = function13;
                                        function14 = new Function1<Long, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$9
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                                invoke(l.longValue());
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX WARN: Multi-variable type inference failed */
                                            public final void invoke(long it) {
                                                T t2 = objectRef4.element;
                                                Intrinsics.checkNotNull(t2);
                                                SuspendAnimationKt.doAnimationFrameWithScale((AnimationScope) t2, it, durationScale2, animation3, animationState3, function15);
                                            }
                                        };
                                        suspendAnimationKt$animate$4.L$0 = animationState2;
                                        suspendAnimationKt$animate$4.L$1 = animation2;
                                        suspendAnimationKt$animate$4.L$2 = function13;
                                        suspendAnimationKt$animate$4.L$3 = objectRef;
                                        suspendAnimationKt$animate$4.label = 2;
                                    } catch (CancellationException e3) {
                                        e = e3;
                                    }
                                } while (callWithFrameNanos(animation2, function14, suspendAnimationKt$animate$4) != coroutine_suspended);
                                return coroutine_suspended;
                            } catch (CancellationException e4) {
                                e = e4;
                                objectRef = objectRef3;
                                z = z2;
                                animationScope = (AnimationScope) objectRef.element;
                                if (animationScope != null) {
                                }
                                animationScope2 = (AnimationScope) objectRef.element;
                                if ((animationScope2 == null && animationScope2.getLastFrameTimeNanos() == animationState2.getLastFrameTimeNanos()) ? z : false) {
                                }
                                throw e;
                            }
                        }
                        try {
                            z = true;
                            try {
                                ?? r12 = (T) new AnimationScope(valueFromNanos, animation.getTypeConverter(), velocityVectorFromNanos, j, animation.getTargetValue(), j, true, new Function0<Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$7
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        animationState2.setRunning$animation_core_release(false);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }
                                });
                                doAnimationFrameWithScale(r12, j, getDurationScale(suspendAnimationKt$animate$4.getContext()), animation, animationState2, function1);
                                objectRef3.element = r12;
                                function13 = function1;
                                animation2 = animation;
                                objectRef = objectRef3;
                                do {
                                    t = objectRef.element;
                                    Intrinsics.checkNotNull(t);
                                    if (((AnimationScope) t).isRunning()) {
                                    }
                                } while (callWithFrameNanos(animation2, function14, suspendAnimationKt$animate$4) != coroutine_suspended);
                                return coroutine_suspended;
                            } catch (CancellationException e5) {
                                e = e5;
                                objectRef = objectRef3;
                            }
                        } catch (CancellationException e6) {
                            e = e6;
                            z = true;
                            objectRef = objectRef3;
                        }
                        animationScope = (AnimationScope) objectRef.element;
                        if (animationScope != null) {
                            animationScope.setRunning$animation_core_release(false);
                        }
                        animationScope2 = (AnimationScope) objectRef.element;
                        if ((animationScope2 == null && animationScope2.getLastFrameTimeNanos() == animationState2.getLastFrameTimeNanos()) ? z : false) {
                            animationState2.setRunning$animation_core_release(false);
                        }
                        throw e;
                    case 1:
                        Ref.ObjectRef objectRef5 = (Ref.ObjectRef) suspendAnimationKt$animate$4.L$3;
                        function13 = (Function1) suspendAnimationKt$animate$4.L$2;
                        animation2 = (Animation) suspendAnimationKt$animate$4.L$1;
                        animationState2 = (AnimationState) suspendAnimationKt$animate$4.L$0;
                        ResultKt.throwOnFailure(obj);
                        z2 = true;
                        objectRef2 = objectRef5;
                        z = z2;
                        objectRef = objectRef2;
                        do {
                            t = objectRef.element;
                            Intrinsics.checkNotNull(t);
                            if (((AnimationScope) t).isRunning()) {
                            }
                        } while (callWithFrameNanos(animation2, function14, suspendAnimationKt$animate$4) != coroutine_suspended);
                        return coroutine_suspended;
                    case 2:
                        Ref.ObjectRef objectRef6 = (Ref.ObjectRef) suspendAnimationKt$animate$4.L$3;
                        function13 = (Function1) suspendAnimationKt$animate$4.L$2;
                        animation2 = (Animation) suspendAnimationKt$animate$4.L$1;
                        animationState2 = (AnimationState) suspendAnimationKt$animate$4.L$0;
                        ResultKt.throwOnFailure(obj);
                        z = true;
                        objectRef = objectRef6;
                        do {
                            t = objectRef.element;
                            Intrinsics.checkNotNull(t);
                            if (((AnimationScope) t).isRunning()) {
                            }
                        } while (callWithFrameNanos(animation2, function14, suspendAnimationKt$animate$4) != coroutine_suspended);
                        return coroutine_suspended;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        suspendAnimationKt$animate$4 = new SuspendAnimationKt$animate$4(continuation);
        Object obj2 = suspendAnimationKt$animate$4.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        objectRef = suspendAnimationKt$animate$4.label;
        switch (objectRef) {
        }
    }

    public static /* synthetic */ Object animate$default(AnimationState animationState, Animation animation, long j, Function1 function1, Continuation continuation, int i, Object obj) {
        long j2;
        Function1 function12;
        if ((i & 2) == 0) {
            j2 = j;
        } else {
            j2 = Long.MIN_VALUE;
        }
        if ((i & 4) == 0) {
            function12 = function1;
        } else {
            function12 = new Function1<AnimationScope<T, V>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$5
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                    invoke((AnimationScope) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimationScope<T, V> animationScope) {
                    Intrinsics.checkNotNullParameter(animationScope, "$this$null");
                }
            };
        }
        return animate(animationState, animation, j2, function12, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <R, T, V extends AnimationVector> Object callWithFrameNanos(Animation<T, V> animation, final Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        if (animation.getIsInfinite()) {
            return InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(function1, continuation);
        }
        return MonotonicFrameClockKt.withFrameNanos(new Function1<Long, R>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$callWithFrameNanos$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Long l) {
                return invoke(l.longValue());
            }

            public final R invoke(long it) {
                return function1.invoke(Long.valueOf(it / 1));
            }
        }, continuation);
    }

    public static final float getDurationScale(CoroutineContext $this$durationScale) {
        Intrinsics.checkNotNullParameter($this$durationScale, "<this>");
        MotionDurationScale motionDurationScale = (MotionDurationScale) $this$durationScale.get(MotionDurationScale.INSTANCE);
        float scale = motionDurationScale != null ? motionDurationScale.getScaleFactor() : 1.0f;
        if (!(scale >= 0.0f)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        return scale;
    }

    public static final <T, V extends AnimationVector> void updateState(AnimationScope<T, V> animationScope, AnimationState<T, V> state) {
        Intrinsics.checkNotNullParameter(animationScope, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        state.setValue$animation_core_release(animationScope.getValue());
        AnimationVectorsKt.copyFrom(state.getVelocityVector(), animationScope.getVelocityVector());
        state.setFinishedTimeNanos$animation_core_release(animationScope.getFinishedTimeNanos());
        state.setLastFrameTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
        state.setRunning$animation_core_release(animationScope.isRunning());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T, V extends AnimationVector> void doAnimationFrameWithScale(AnimationScope<T, V> animationScope, long frameTimeNanos, float durationScale, Animation<T, V> animation, AnimationState<T, V> animationState, Function1<? super AnimationScope<T, V>, Unit> function1) {
        long playTimeNanos;
        if (durationScale == 0.0f) {
            playTimeNanos = animation.getDurationNanos();
        } else {
            playTimeNanos = (long) ((frameTimeNanos - animationScope.getStartTimeNanos()) / durationScale);
        }
        doAnimationFrame(animationScope, frameTimeNanos, playTimeNanos, animation, animationState, function1);
    }

    private static final <T, V extends AnimationVector> void doAnimationFrame(AnimationScope<T, V> animationScope, long frameTimeNanos, long playTimeNanos, Animation<T, V> animation, AnimationState<T, V> animationState, Function1<? super AnimationScope<T, V>, Unit> function1) {
        animationScope.setLastFrameTimeNanos$animation_core_release(frameTimeNanos);
        animationScope.setValue$animation_core_release(animation.getValueFromNanos(playTimeNanos));
        animationScope.setVelocityVector$animation_core_release(animation.getVelocityVectorFromNanos(playTimeNanos));
        boolean isLastFrame = animation.isFinishedFromNanos(playTimeNanos);
        if (isLastFrame) {
            animationScope.setFinishedTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
            animationScope.setRunning$animation_core_release(false);
        }
        updateState(animationScope, animationState);
        function1.invoke(animationScope);
    }
}
