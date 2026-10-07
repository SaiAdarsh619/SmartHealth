package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.p000ui.unit.Density;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* compiled from: LazyAnimateScroll.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2", m297f = "LazyAnimateScroll.kt", m298i = {0, 0, 0, 0, 0, 0, 0, 1}, m299l = {134, 230}, m300m = "invokeSuspend", m301n = {"$this$scroll", "loop", "anim", "loops", "targetDistancePx", "boundDistancePx", "forward", "$this$scroll"}, m302s = {"L$0", "L$1", "L$2", "L$3", "F$0", "F$1", "I$0", "L$0"})
/* loaded from: classes.dex */
final class LazyAnimateScrollKt$animateScrollToItem$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ int $scrollOffset;
    final /* synthetic */ LazyAnimateScrollScope $this_animateScrollToItem;
    float F$0;
    float F$1;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyAnimateScrollKt$animateScrollToItem$2(int i, LazyAnimateScrollScope lazyAnimateScrollScope, int i2, Continuation<? super LazyAnimateScrollKt$animateScrollToItem$2> continuation) {
        super(2, continuation);
        this.$index = i;
        this.$this_animateScrollToItem = lazyAnimateScrollScope;
        this.$scrollOffset = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LazyAnimateScrollKt$animateScrollToItem$2 lazyAnimateScrollKt$animateScrollToItem$2 = new LazyAnimateScrollKt$animateScrollToItem$2(this.$index, this.$this_animateScrollToItem, this.$scrollOffset, continuation);
        lazyAnimateScrollKt$animateScrollToItem$2.L$0 = obj;
        return lazyAnimateScrollKt$animateScrollToItem$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((LazyAnimateScrollKt$animateScrollToItem$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d0 A[Catch: ItemFoundInScroll -> 0x01c6, TryCatch #0 {ItemFoundInScroll -> 0x01c6, blocks: (B:16:0x00cc, B:18:0x00d0, B:20:0x00d8, B:23:0x00f2, B:28:0x0142, B:31:0x014f), top: B:15:0x00cc }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0243 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0219  */
    /* JADX WARN: Type inference failed for: r12v1, types: [T, androidx.compose.animation.core.AnimationState] */
    /* JADX WARN: Type inference failed for: r4v12, types: [T, androidx.compose.animation.core.AnimationState] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x019c -> B:14:0x01a3). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        LazyAnimateScrollKt$animateScrollToItem$2 lazyAnimateScrollKt$animateScrollToItem$2;
        Object $result;
        ScrollScope $this$scroll;
        ItemFoundInScroll itemFound;
        LazyAnimateScrollKt$animateScrollToItem$2 lazyAnimateScrollKt$animateScrollToItem$22;
        Object $result2;
        final ScrollScope $this$scroll2;
        float f;
        float targetDistancePx;
        float f2;
        float boundDistancePx;
        Ref.BooleanRef loop;
        Ref.ObjectRef anim;
        Integer targetItemInitialOffset;
        Ref.IntRef loops;
        float targetDistancePx2;
        float boundDistancePx2;
        Ref.BooleanRef loop2;
        Ref.ObjectRef anim2;
        int i;
        Object animateTo;
        Object $result3;
        boolean z;
        final ScrollScope $this$scroll3;
        final Ref.BooleanRef loop3;
        final Ref.ObjectRef anim3;
        final Ref.IntRef loops2;
        float targetDistancePx3;
        final float boundDistancePx3;
        final boolean z2;
        Object animateTo2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        float f3 = 0.0f;
        boolean z3 = true;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                lazyAnimateScrollKt$animateScrollToItem$2 = this;
                $result = obj;
                $this$scroll = (ScrollScope) lazyAnimateScrollKt$animateScrollToItem$2.L$0;
                boolean z4 = ((float) lazyAnimateScrollKt$animateScrollToItem$2.$index) >= 0.0f;
                int i2 = lazyAnimateScrollKt$animateScrollToItem$2.$index;
                if (!z4) {
                    throw new IllegalArgumentException(("Index should be non-negative (" + i2 + ')').toString());
                }
                try {
                    Density $this$invokeSuspend_u24lambda_u2d1 = lazyAnimateScrollKt$animateScrollToItem$2.$this_animateScrollToItem.getDensity();
                    f = LazyAnimateScrollKt.TargetDistance;
                    targetDistancePx = $this$invokeSuspend_u24lambda_u2d1.mo648toPx0680j_4(f);
                    Density $this$invokeSuspend_u24lambda_u2d2 = lazyAnimateScrollKt$animateScrollToItem$2.$this_animateScrollToItem.getDensity();
                    f2 = LazyAnimateScrollKt.BoundDistance;
                    boundDistancePx = $this$invokeSuspend_u24lambda_u2d2.mo648toPx0680j_4(f2);
                    loop = new Ref.BooleanRef();
                    loop.element = true;
                    anim = new Ref.ObjectRef();
                    anim.element = AnimationStateKt.AnimationState$default(0.0f, 0.0f, 0L, 0L, false, 30, null);
                    targetItemInitialOffset = lazyAnimateScrollKt$animateScrollToItem$2.$this_animateScrollToItem.getTargetItemOffset(lazyAnimateScrollKt$animateScrollToItem$2.$index);
                } catch (ItemFoundInScroll e) {
                    itemFound = e;
                    lazyAnimateScrollKt$animateScrollToItem$22 = lazyAnimateScrollKt$animateScrollToItem$2;
                    $result2 = $result;
                    $this$scroll2 = $this$scroll;
                    AnimationState anim4 = AnimationStateKt.copy$default((AnimationState) itemFound.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                    final float target = itemFound.getItemOffset() + lazyAnimateScrollKt$animateScrollToItem$22.$scrollOffset;
                    final Ref.FloatRef prevValue = new Ref.FloatRef();
                    Float boxFloat = Boxing.boxFloat(target);
                    if (((Number) anim4.getVelocity()).floatValue() == 0.0f) {
                    }
                    Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            invoke2(animationScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:11:0x0064, code lost:
                        
                            if ((r0 == r7.getValue().floatValue()) == false) goto L19;
                         */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void invoke2(AnimationScope<Float, AnimationVector1D> animateTo3) {
                            Intrinsics.checkNotNullParameter(animateTo3, "$this$animateTo");
                            float f4 = 0.0f;
                            if (target > 0.0f) {
                                f4 = RangesKt.coerceAtMost(animateTo3.getValue().floatValue(), target);
                            } else if (target < 0.0f) {
                                f4 = RangesKt.coerceAtLeast(animateTo3.getValue().floatValue(), target);
                            }
                            float coercedValue = f4;
                            float delta = coercedValue - prevValue.element;
                            float consumed = $this$scroll2.scrollBy(delta);
                            if (delta == consumed) {
                            }
                            animateTo3.cancelAnimation();
                            prevValue.element += delta;
                        }
                    };
                    lazyAnimateScrollKt$animateScrollToItem$22.L$0 = $this$scroll2;
                    lazyAnimateScrollKt$animateScrollToItem$22.L$1 = null;
                    lazyAnimateScrollKt$animateScrollToItem$22.L$2 = null;
                    lazyAnimateScrollKt$animateScrollToItem$22.L$3 = null;
                    lazyAnimateScrollKt$animateScrollToItem$22.label = 2;
                    animateTo = SuspendAnimationKt.animateTo(anim4, boxFloat, (r12 & 2) != 0 ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : null, (r12 & 4) != 0 ? false : !r20, (r12 & 8) != 0 ? new Function1<AnimationScope<T, V>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateTo$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                            invoke((AnimationScope) p1);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimationScope<T, V> animationScope) {
                            Intrinsics.checkNotNullParameter(animationScope, "$this$null");
                        }
                    } : function1, lazyAnimateScrollKt$animateScrollToItem$22);
                    if (animateTo == coroutine_suspended) {
                    }
                }
                if (targetItemInitialOffset != null) {
                    throw new ItemFoundInScroll(targetItemInitialOffset.intValue(), (AnimationState) anim.element);
                }
                int i3 = lazyAnimateScrollKt$animateScrollToItem$2.$index > lazyAnimateScrollKt$animateScrollToItem$2.$this_animateScrollToItem.getFirstVisibleItemIndex() ? 1 : 0;
                loops = new Ref.IntRef();
                loops.element = 1;
                targetDistancePx2 = targetDistancePx;
                boundDistancePx2 = boundDistancePx;
                loop2 = loop;
                anim2 = anim;
                i = i3;
                try {
                } catch (ItemFoundInScroll e2) {
                    $result2 = $result;
                    itemFound = e2;
                    lazyAnimateScrollKt$animateScrollToItem$22 = lazyAnimateScrollKt$animateScrollToItem$2;
                    $this$scroll2 = $this$scroll;
                }
                if (loop2.element || lazyAnimateScrollKt$animateScrollToItem$2.$this_animateScrollToItem.getItemCount() <= 0) {
                    return Unit.INSTANCE;
                }
                try {
                    try {
                        float expectedDistance = lazyAnimateScrollKt$animateScrollToItem$2.$this_animateScrollToItem.expectedDistanceTo(lazyAnimateScrollKt$animateScrollToItem$2.$index, lazyAnimateScrollKt$animateScrollToItem$2.$scrollOffset);
                        final float target2 = Math.abs(expectedDistance) >= targetDistancePx2 ? i != 0 ? targetDistancePx2 : -targetDistancePx2 : expectedDistance;
                        int i4 = lazyAnimateScrollKt$animateScrollToItem$2.$index;
                        int i5 = lazyAnimateScrollKt$animateScrollToItem$2.$scrollOffset;
                        LazyAnimateScrollScope lazyAnimateScrollScope = lazyAnimateScrollKt$animateScrollToItem$2.$this_animateScrollToItem;
                        anim2.element = AnimationStateKt.copy$default((AnimationState) anim2.element, 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                        final Ref.FloatRef floatRef = new Ref.FloatRef();
                        AnimationState animationState = (AnimationState) anim2.element;
                        Float boxFloat2 = Boxing.boxFloat(target2);
                        boolean z5 = !((((Number) ((AnimationState) anim2.element).getVelocity()).floatValue() > f3 ? 1 : (((Number) ((AnimationState) anim2.element).getVelocity()).floatValue() == f3 ? 0 : -1)) == 0 ? z3 : false) ? z3 : false;
                        final LazyAnimateScrollScope lazyAnimateScrollScope2 = lazyAnimateScrollKt$animateScrollToItem$2.$this_animateScrollToItem;
                        final int i6 = lazyAnimateScrollKt$animateScrollToItem$2.$index;
                        z = i != 0;
                        final int i7 = lazyAnimateScrollKt$animateScrollToItem$2.$scrollOffset;
                        Function1<AnimationScope<Float, AnimationVector1D>, Unit> function12 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.3
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
                            public final void invoke2(AnimationScope<Float, AnimationVector1D> animateTo3) {
                                float coercedValue;
                                Intrinsics.checkNotNullParameter(animateTo3, "$this$animateTo");
                                Integer targetItemOffset = LazyAnimateScrollScope.this.getTargetItemOffset(i6);
                                if (targetItemOffset == null) {
                                    if (target2 > 0.0f) {
                                        coercedValue = RangesKt.coerceAtMost(animateTo3.getValue().floatValue(), target2);
                                    } else {
                                        coercedValue = RangesKt.coerceAtLeast(animateTo3.getValue().floatValue(), target2);
                                    }
                                    float delta = coercedValue - floatRef.element;
                                    float consumed = $this$scroll3.scrollBy(delta);
                                    targetItemOffset = LazyAnimateScrollScope.this.getTargetItemOffset(i6);
                                    if (targetItemOffset == null && !LazyAnimateScrollKt$animateScrollToItem$2.invokeSuspend$isOvershot(z2, LazyAnimateScrollScope.this, i6, i7)) {
                                        if (!(delta == consumed)) {
                                            animateTo3.cancelAnimation();
                                            loop3.element = false;
                                            return;
                                        }
                                        floatRef.element += delta;
                                        if (z2) {
                                            if (animateTo3.getValue().floatValue() > boundDistancePx3) {
                                                animateTo3.cancelAnimation();
                                            }
                                        } else if (animateTo3.getValue().floatValue() < (-boundDistancePx3)) {
                                            animateTo3.cancelAnimation();
                                        }
                                        if (z2) {
                                            if (loops2.element >= 2 && i6 - LazyAnimateScrollScope.this.getLastVisibleItemIndex() > LazyAnimateScrollScope.this.getNumOfItemsForTeleport()) {
                                                LazyAnimateScrollScope.this.snapToItem($this$scroll3, i6 - LazyAnimateScrollScope.this.getNumOfItemsForTeleport(), 0);
                                            }
                                        } else if (loops2.element >= 2 && LazyAnimateScrollScope.this.getFirstVisibleItemIndex() - i6 > LazyAnimateScrollScope.this.getNumOfItemsForTeleport()) {
                                            LazyAnimateScrollScope.this.snapToItem($this$scroll3, i6 + LazyAnimateScrollScope.this.getNumOfItemsForTeleport(), 0);
                                        }
                                    }
                                }
                                if (LazyAnimateScrollKt$animateScrollToItem$2.invokeSuspend$isOvershot(z2, LazyAnimateScrollScope.this, i6, i7)) {
                                    LazyAnimateScrollScope.this.snapToItem($this$scroll3, i6, i7);
                                    loop3.element = false;
                                    animateTo3.cancelAnimation();
                                } else if (targetItemOffset != null) {
                                    throw new ItemFoundInScroll(targetItemOffset.intValue(), anim3.element);
                                }
                            }
                        };
                        LazyAnimateScrollKt$animateScrollToItem$2 lazyAnimateScrollKt$animateScrollToItem$23 = lazyAnimateScrollKt$animateScrollToItem$2;
                        lazyAnimateScrollKt$animateScrollToItem$2.L$0 = $this$scroll;
                        lazyAnimateScrollKt$animateScrollToItem$2.L$1 = loop3;
                        lazyAnimateScrollKt$animateScrollToItem$2.L$2 = anim3;
                        lazyAnimateScrollKt$animateScrollToItem$2.L$3 = loops2;
                        lazyAnimateScrollKt$animateScrollToItem$2.F$0 = targetDistancePx3;
                        lazyAnimateScrollKt$animateScrollToItem$2.F$1 = boundDistancePx3;
                        lazyAnimateScrollKt$animateScrollToItem$2.I$0 = i;
                        lazyAnimateScrollKt$animateScrollToItem$2.label = 1;
                        animateTo2 = SuspendAnimationKt.animateTo(animationState, boxFloat2, (r12 & 2) != 0 ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : null, (r12 & 4) != 0 ? false : z5, (r12 & 8) != 0 ? new Function1<AnimationScope<T, V>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateTo$2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                                invoke((AnimationScope) p1);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimationScope<T, V> animationScope) {
                                Intrinsics.checkNotNullParameter(animationScope, "$this$null");
                            }
                        } : function12, lazyAnimateScrollKt$animateScrollToItem$23);
                    } catch (ItemFoundInScroll e3) {
                        itemFound = e3;
                        lazyAnimateScrollKt$animateScrollToItem$22 = lazyAnimateScrollKt$animateScrollToItem$2;
                        $this$scroll2 = $this$scroll3;
                    }
                    $this$scroll3 = $this$scroll;
                    loop3 = loop2;
                    anim3 = anim2;
                    loops2 = loops;
                    $result2 = $result;
                    targetDistancePx3 = targetDistancePx2;
                    boundDistancePx3 = boundDistancePx2;
                    z2 = z;
                } catch (ItemFoundInScroll e4) {
                    itemFound = e4;
                    lazyAnimateScrollKt$animateScrollToItem$22 = lazyAnimateScrollKt$animateScrollToItem$2;
                    $this$scroll2 = $this$scroll;
                    AnimationState anim42 = AnimationStateKt.copy$default((AnimationState) itemFound.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                    final float target3 = itemFound.getItemOffset() + lazyAnimateScrollKt$animateScrollToItem$22.$scrollOffset;
                    final Ref.FloatRef prevValue2 = new Ref.FloatRef();
                    Float boxFloat3 = Boxing.boxFloat(target3);
                    if (((Number) anim42.getVelocity()).floatValue() == 0.0f) {
                    }
                    Function1<AnimationScope<Float, AnimationVector1D>, Unit> function13 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            invoke2(animationScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:11:0x0064, code lost:
                        
                            if ((r0 == r7.getValue().floatValue()) == false) goto L19;
                         */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void invoke2(AnimationScope<Float, AnimationVector1D> animateTo3) {
                            Intrinsics.checkNotNullParameter(animateTo3, "$this$animateTo");
                            float f4 = 0.0f;
                            if (target3 > 0.0f) {
                                f4 = RangesKt.coerceAtMost(animateTo3.getValue().floatValue(), target3);
                            } else if (target3 < 0.0f) {
                                f4 = RangesKt.coerceAtLeast(animateTo3.getValue().floatValue(), target3);
                            }
                            float coercedValue = f4;
                            float delta = coercedValue - prevValue2.element;
                            float consumed = $this$scroll2.scrollBy(delta);
                            if (delta == consumed) {
                            }
                            animateTo3.cancelAnimation();
                            prevValue2.element += delta;
                        }
                    };
                    lazyAnimateScrollKt$animateScrollToItem$22.L$0 = $this$scroll2;
                    lazyAnimateScrollKt$animateScrollToItem$22.L$1 = null;
                    lazyAnimateScrollKt$animateScrollToItem$22.L$2 = null;
                    lazyAnimateScrollKt$animateScrollToItem$22.L$3 = null;
                    lazyAnimateScrollKt$animateScrollToItem$22.label = 2;
                    animateTo = SuspendAnimationKt.animateTo(anim42, boxFloat3, (r12 & 2) != 0 ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : null, (r12 & 4) != 0 ? false : !r20, (r12 & 8) != 0 ? new Function1<AnimationScope<T, V>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateTo$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                            invoke((AnimationScope) p1);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimationScope<T, V> animationScope) {
                            Intrinsics.checkNotNullParameter(animationScope, "$this$null");
                        }
                    } : function13, lazyAnimateScrollKt$animateScrollToItem$22);
                    if (animateTo == coroutine_suspended) {
                    }
                }
                $this$scroll = $this$scroll3;
                if (animateTo2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                loops = loops2;
                targetDistancePx2 = targetDistancePx3;
                boundDistancePx2 = boundDistancePx3;
                loop2 = loop3;
                $result = $result2;
                anim2 = anim3;
                loops.element++;
                f3 = 0.0f;
                z3 = true;
                if (loop2.element) {
                }
                return Unit.INSTANCE;
            case 1:
                lazyAnimateScrollKt$animateScrollToItem$2 = this;
                $result = obj;
                i = lazyAnimateScrollKt$animateScrollToItem$2.I$0;
                float boundDistancePx4 = lazyAnimateScrollKt$animateScrollToItem$2.F$1;
                float targetDistancePx4 = lazyAnimateScrollKt$animateScrollToItem$2.F$0;
                Ref.IntRef loops3 = (Ref.IntRef) lazyAnimateScrollKt$animateScrollToItem$2.L$3;
                Ref.ObjectRef anim5 = (Ref.ObjectRef) lazyAnimateScrollKt$animateScrollToItem$2.L$2;
                Ref.BooleanRef loop4 = (Ref.BooleanRef) lazyAnimateScrollKt$animateScrollToItem$2.L$1;
                ScrollScope $this$scroll4 = (ScrollScope) lazyAnimateScrollKt$animateScrollToItem$2.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    boundDistancePx2 = boundDistancePx4;
                    targetDistancePx2 = targetDistancePx4;
                    loop2 = loop4;
                    $this$scroll = $this$scroll4;
                    loops = loops3;
                    anim2 = anim5;
                    loops.element++;
                    f3 = 0.0f;
                    z3 = true;
                    if (loop2.element) {
                    }
                } catch (ItemFoundInScroll e5) {
                    itemFound = e5;
                    lazyAnimateScrollKt$animateScrollToItem$22 = lazyAnimateScrollKt$animateScrollToItem$2;
                    $result2 = $result;
                    $this$scroll2 = $this$scroll4;
                    AnimationState anim422 = AnimationStateKt.copy$default((AnimationState) itemFound.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                    final float target32 = itemFound.getItemOffset() + lazyAnimateScrollKt$animateScrollToItem$22.$scrollOffset;
                    final Ref.FloatRef prevValue22 = new Ref.FloatRef();
                    Float boxFloat32 = Boxing.boxFloat(target32);
                    boolean z6 = ((Number) anim422.getVelocity()).floatValue() == 0.0f;
                    Function1<AnimationScope<Float, AnimationVector1D>, Unit> function132 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            invoke2(animationScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:11:0x0064, code lost:
                        
                            if ((r0 == r7.getValue().floatValue()) == false) goto L19;
                         */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void invoke2(AnimationScope<Float, AnimationVector1D> animateTo3) {
                            Intrinsics.checkNotNullParameter(animateTo3, "$this$animateTo");
                            float f4 = 0.0f;
                            if (target32 > 0.0f) {
                                f4 = RangesKt.coerceAtMost(animateTo3.getValue().floatValue(), target32);
                            } else if (target32 < 0.0f) {
                                f4 = RangesKt.coerceAtLeast(animateTo3.getValue().floatValue(), target32);
                            }
                            float coercedValue = f4;
                            float delta = coercedValue - prevValue22.element;
                            float consumed = $this$scroll2.scrollBy(delta);
                            if (delta == consumed) {
                            }
                            animateTo3.cancelAnimation();
                            prevValue22.element += delta;
                        }
                    };
                    lazyAnimateScrollKt$animateScrollToItem$22.L$0 = $this$scroll2;
                    lazyAnimateScrollKt$animateScrollToItem$22.L$1 = null;
                    lazyAnimateScrollKt$animateScrollToItem$22.L$2 = null;
                    lazyAnimateScrollKt$animateScrollToItem$22.L$3 = null;
                    lazyAnimateScrollKt$animateScrollToItem$22.label = 2;
                    animateTo = SuspendAnimationKt.animateTo(anim422, boxFloat32, (r12 & 2) != 0 ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : null, (r12 & 4) != 0 ? false : !z6, (r12 & 8) != 0 ? new Function1<AnimationScope<T, V>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateTo$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                            invoke((AnimationScope) p1);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimationScope<T, V> animationScope) {
                            Intrinsics.checkNotNullParameter(animationScope, "$this$null");
                        }
                    } : function132, lazyAnimateScrollKt$animateScrollToItem$22);
                    if (animateTo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result3 = $result2;
                    lazyAnimateScrollKt$animateScrollToItem$22.$this_animateScrollToItem.snapToItem($this$scroll2, lazyAnimateScrollKt$animateScrollToItem$22.$index, lazyAnimateScrollKt$animateScrollToItem$22.$scrollOffset);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 2:
                lazyAnimateScrollKt$animateScrollToItem$22 = this;
                $result3 = obj;
                $this$scroll2 = (ScrollScope) lazyAnimateScrollKt$animateScrollToItem$22.L$0;
                ResultKt.throwOnFailure($result3);
                lazyAnimateScrollKt$animateScrollToItem$22.$this_animateScrollToItem.snapToItem($this$scroll2, lazyAnimateScrollKt$animateScrollToItem$22.$index, lazyAnimateScrollKt$animateScrollToItem$22.$scrollOffset);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$isOvershot(boolean forward, LazyAnimateScrollScope $this_animateScrollToItem, int $index, int $scrollOffset) {
        if (forward) {
            if ($this_animateScrollToItem.getFirstVisibleItemIndex() > $index) {
                return true;
            }
            return $this_animateScrollToItem.getFirstVisibleItemIndex() == $index && $this_animateScrollToItem.getFirstVisibleItemScrollOffset() > $scrollOffset;
        }
        if ($this_animateScrollToItem.getFirstVisibleItemIndex() < $index) {
            return true;
        }
        return $this_animateScrollToItem.getFirstVisibleItemIndex() == $index && $this_animateScrollToItem.getFirstVisibleItemScrollOffset() < $scrollOffset;
    }
}
