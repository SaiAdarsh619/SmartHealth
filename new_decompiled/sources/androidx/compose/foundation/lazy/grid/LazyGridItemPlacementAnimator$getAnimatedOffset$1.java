package androidx.compose.foundation.lazy.grid;

import androidx.compose.p000ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyGridItemPlacementAnimator.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$getAnimatedOffset$1", m297f = "LazyGridItemPlacementAnimator.kt", m298i = {}, m299l = {321}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes.dex */
final class LazyGridItemPlacementAnimator$getAnimatedOffset$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PlaceableInfo $item;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyGridItemPlacementAnimator$getAnimatedOffset$1(PlaceableInfo placeableInfo, Continuation<? super LazyGridItemPlacementAnimator$getAnimatedOffset$1> continuation) {
        super(2, continuation);
        this.$item = placeableInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyGridItemPlacementAnimator$getAnimatedOffset$1(this.$item, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyGridItemPlacementAnimator$getAnimatedOffset$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        LazyGridItemPlacementAnimator$getAnimatedOffset$1 lazyGridItemPlacementAnimator$getAnimatedOffset$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$item.getAnimatedOffset().snapTo(IntOffset.m4491boximpl(this.$item.getTargetOffset()), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                lazyGridItemPlacementAnimator$getAnimatedOffset$1 = this;
                break;
            case 1:
                lazyGridItemPlacementAnimator$getAnimatedOffset$1 = this;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        lazyGridItemPlacementAnimator$getAnimatedOffset$1.$item.setInProgress(false);
        return Unit.INSTANCE;
    }
}
