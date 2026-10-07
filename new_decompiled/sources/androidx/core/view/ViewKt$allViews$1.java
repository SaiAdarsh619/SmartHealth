package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* compiled from: View.kt */
@Metadata(m286d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Landroid/view/View;"}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "androidx.core.view.ViewKt$allViews$1", m297f = "View.kt", m298i = {0}, m299l = {414, 416}, m300m = "invokeSuspend", m301n = {"$this$sequence"}, m302s = {"L$0"})
/* loaded from: classes14.dex */
final class ViewKt$allViews$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super View>, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ViewKt$allViews$1(View view, Continuation<? super ViewKt$allViews$1> continuation) {
        super(2, continuation);
        this.$this_allViews = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, continuation);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super View> sequenceScope, Continuation<? super Unit> continuation) {
        return ((ViewKt$allViews$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ViewKt$allViews$1 viewKt$allViews$1;
        SequenceScope $this$sequence;
        ViewKt$allViews$1 viewKt$allViews$12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                viewKt$allViews$1 = this;
                $this$sequence = (SequenceScope) viewKt$allViews$1.L$0;
                viewKt$allViews$1.L$0 = $this$sequence;
                viewKt$allViews$1.label = 1;
                if ($this$sequence.yield(viewKt$allViews$1.$this_allViews, viewKt$allViews$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (viewKt$allViews$1.$this_allViews instanceof ViewGroup) {
                    viewKt$allViews$1.L$0 = null;
                    viewKt$allViews$1.label = 2;
                    if ($this$sequence.yieldAll(ViewGroupKt.getDescendants((ViewGroup) viewKt$allViews$1.$this_allViews), viewKt$allViews$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    viewKt$allViews$12 = viewKt$allViews$1;
                }
                return Unit.INSTANCE;
            case 1:
                viewKt$allViews$1 = this;
                $this$sequence = (SequenceScope) viewKt$allViews$1.L$0;
                ResultKt.throwOnFailure($result);
                if (viewKt$allViews$1.$this_allViews instanceof ViewGroup) {
                }
                return Unit.INSTANCE;
            case 2:
                viewKt$allViews$12 = this;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
