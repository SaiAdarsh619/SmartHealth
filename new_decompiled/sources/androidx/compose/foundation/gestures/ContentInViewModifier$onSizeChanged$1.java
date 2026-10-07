package androidx.compose.foundation.gestures;

import androidx.compose.p000ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* compiled from: ContentInViewModifier.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.ContentInViewModifier$onSizeChanged$1", m297f = "ContentInViewModifier.kt", m298i = {0}, m299l = {195}, m300m = "invokeSuspend", m301n = {"job"}, m302s = {"L$0"})
/* loaded from: classes.dex */
final class ContentInViewModifier$onSizeChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Rect $focusedBounds;
    final /* synthetic */ Rect $targetBounds;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ContentInViewModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContentInViewModifier$onSizeChanged$1(ContentInViewModifier contentInViewModifier, Rect rect, Rect rect2, Continuation<? super ContentInViewModifier$onSizeChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = contentInViewModifier;
        this.$focusedBounds = rect;
        this.$targetBounds = rect2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ContentInViewModifier$onSizeChanged$1 contentInViewModifier$onSizeChanged$1 = new ContentInViewModifier$onSizeChanged$1(this.this$0, this.$focusedBounds, this.$targetBounds, continuation);
        contentInViewModifier$onSizeChanged$1.L$0 = obj;
        return contentInViewModifier$onSizeChanged$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ContentInViewModifier$onSizeChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Job job;
        Throwable th;
        ContentInViewModifier$onSizeChanged$1 contentInViewModifier$onSizeChanged$1;
        Job job2;
        Job job3;
        Job job4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineScope $this$launch = (CoroutineScope) this.L$0;
                job = BuildersKt__Builders_commonKt.launch$default($this$launch, null, null, new ContentInViewModifier$onSizeChanged$1$job$1(this.this$0, this.$focusedBounds, this.$targetBounds, null), 3, null);
                this.this$0.focusAnimationJob = job;
                try {
                    this.L$0 = job;
                    this.label = 1;
                    if (job.join(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    contentInViewModifier$onSizeChanged$1 = this;
                    job2 = job;
                    job4 = contentInViewModifier$onSizeChanged$1.this$0.focusAnimationJob;
                    if (job4 == job2) {
                        contentInViewModifier$onSizeChanged$1.this$0.focusedChildBeingAnimated = null;
                        contentInViewModifier$onSizeChanged$1.this$0.setFocusTargetBounds(null);
                        contentInViewModifier$onSizeChanged$1.this$0.focusAnimationJob = null;
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    contentInViewModifier$onSizeChanged$1 = this;
                    job2 = job;
                    job3 = contentInViewModifier$onSizeChanged$1.this$0.focusAnimationJob;
                    if (job3 == job2) {
                    }
                    throw th;
                }
            case 1:
                contentInViewModifier$onSizeChanged$1 = this;
                job2 = (Job) contentInViewModifier$onSizeChanged$1.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    job4 = contentInViewModifier$onSizeChanged$1.this$0.focusAnimationJob;
                    if (job4 == job2) {
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    job3 = contentInViewModifier$onSizeChanged$1.this$0.focusAnimationJob;
                    if (job3 == job2) {
                        contentInViewModifier$onSizeChanged$1.this$0.focusedChildBeingAnimated = null;
                        contentInViewModifier$onSizeChanged$1.this$0.setFocusTargetBounds(null);
                        contentInViewModifier$onSizeChanged$1.this$0.focusAnimationJob = null;
                    }
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
