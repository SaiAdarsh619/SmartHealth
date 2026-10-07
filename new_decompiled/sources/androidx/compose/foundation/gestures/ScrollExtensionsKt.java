package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Ref;

/* compiled from: ScrollExtensions.kt */
@Metadata(m286d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a\u001d\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u001f\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, m287d2 = {"animateScrollBy", "", "Landroidx/compose/foundation/gestures/ScrollableState;", "value", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/ScrollableState;FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollBy", "(Landroidx/compose/foundation/gestures/ScrollableState;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopScroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ScrollExtensionsKt {
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object animateScrollBy(ScrollableState $this$animateScrollBy, float value, AnimationSpec<Float> animationSpec, Continuation<? super Float> continuation) {
        ScrollExtensionsKt$animateScrollBy$1 scrollExtensionsKt$animateScrollBy$1;
        ScrollExtensionsKt$animateScrollBy$1 scrollExtensionsKt$animateScrollBy$12;
        Ref.FloatRef previousValue;
        if (continuation instanceof ScrollExtensionsKt$animateScrollBy$1) {
            scrollExtensionsKt$animateScrollBy$1 = (ScrollExtensionsKt$animateScrollBy$1) continuation;
            if ((scrollExtensionsKt$animateScrollBy$1.label & Integer.MIN_VALUE) != 0) {
                scrollExtensionsKt$animateScrollBy$1.label -= Integer.MIN_VALUE;
                scrollExtensionsKt$animateScrollBy$12 = scrollExtensionsKt$animateScrollBy$1;
                Object $result = scrollExtensionsKt$animateScrollBy$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (scrollExtensionsKt$animateScrollBy$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Ref.FloatRef previousValue2 = new Ref.FloatRef();
                        ScrollExtensionsKt$animateScrollBy$2 scrollExtensionsKt$animateScrollBy$2 = new ScrollExtensionsKt$animateScrollBy$2(value, animationSpec, previousValue2, null);
                        scrollExtensionsKt$animateScrollBy$12.L$0 = previousValue2;
                        scrollExtensionsKt$animateScrollBy$12.label = 1;
                        if (ScrollableState.scroll$default($this$animateScrollBy, null, scrollExtensionsKt$animateScrollBy$2, scrollExtensionsKt$animateScrollBy$12, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        previousValue = previousValue2;
                        break;
                    case 1:
                        previousValue = (Ref.FloatRef) scrollExtensionsKt$animateScrollBy$12.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Boxing.boxFloat(previousValue.element);
            }
        }
        scrollExtensionsKt$animateScrollBy$1 = new ScrollExtensionsKt$animateScrollBy$1(continuation);
        scrollExtensionsKt$animateScrollBy$12 = scrollExtensionsKt$animateScrollBy$1;
        Object $result2 = scrollExtensionsKt$animateScrollBy$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (scrollExtensionsKt$animateScrollBy$12.label) {
        }
        return Boxing.boxFloat(previousValue.element);
    }

    public static /* synthetic */ Object animateScrollBy$default(ScrollableState scrollableState, float f, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return animateScrollBy(scrollableState, f, animationSpec, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object scrollBy(ScrollableState $this$scrollBy, float value, Continuation<? super Float> continuation) {
        ScrollExtensionsKt$scrollBy$1 scrollExtensionsKt$scrollBy$1;
        ScrollExtensionsKt$scrollBy$1 scrollExtensionsKt$scrollBy$12;
        Ref.FloatRef consumed;
        if (continuation instanceof ScrollExtensionsKt$scrollBy$1) {
            scrollExtensionsKt$scrollBy$1 = (ScrollExtensionsKt$scrollBy$1) continuation;
            if ((scrollExtensionsKt$scrollBy$1.label & Integer.MIN_VALUE) != 0) {
                scrollExtensionsKt$scrollBy$1.label -= Integer.MIN_VALUE;
                scrollExtensionsKt$scrollBy$12 = scrollExtensionsKt$scrollBy$1;
                Object $result = scrollExtensionsKt$scrollBy$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (scrollExtensionsKt$scrollBy$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Ref.FloatRef consumed2 = new Ref.FloatRef();
                        ScrollExtensionsKt$scrollBy$2 scrollExtensionsKt$scrollBy$2 = new ScrollExtensionsKt$scrollBy$2(consumed2, value, null);
                        scrollExtensionsKt$scrollBy$12.L$0 = consumed2;
                        scrollExtensionsKt$scrollBy$12.label = 1;
                        if (ScrollableState.scroll$default($this$scrollBy, null, scrollExtensionsKt$scrollBy$2, scrollExtensionsKt$scrollBy$12, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        consumed = consumed2;
                        break;
                    case 1:
                        consumed = (Ref.FloatRef) scrollExtensionsKt$scrollBy$12.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Boxing.boxFloat(consumed.element);
            }
        }
        scrollExtensionsKt$scrollBy$1 = new ScrollExtensionsKt$scrollBy$1(continuation);
        scrollExtensionsKt$scrollBy$12 = scrollExtensionsKt$scrollBy$1;
        Object $result2 = scrollExtensionsKt$scrollBy$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (scrollExtensionsKt$scrollBy$12.label) {
        }
        return Boxing.boxFloat(consumed.element);
    }

    public static /* synthetic */ Object stopScroll$default(ScrollableState scrollableState, MutatePriority mutatePriority, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return stopScroll(scrollableState, mutatePriority, continuation);
    }

    public static final Object stopScroll(ScrollableState $this$stopScroll, MutatePriority scrollPriority, Continuation<? super Unit> continuation) {
        Object scroll = $this$stopScroll.scroll(scrollPriority, new ScrollExtensionsKt$stopScroll$2(null), continuation);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }
}
