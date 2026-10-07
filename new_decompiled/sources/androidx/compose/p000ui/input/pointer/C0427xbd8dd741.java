package androidx.compose.p000ui.input.pointer;

import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilter;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: SuspendingPointerInputFilter.kt */
@Metadata(m286d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, m287d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1", m297f = "SuspendingPointerInputFilter.kt", m298i = {}, m299l = {620, 621}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* renamed from: androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1 */
/* loaded from: classes.dex */
final class C0427xbd8dd741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $timeMillis;
    int label;
    final /* synthetic */ SuspendingPointerInputFilter.PointerEventHandlerCoroutine<R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0427xbd8dd741(long j, SuspendingPointerInputFilter.PointerEventHandlerCoroutine<R> pointerEventHandlerCoroutine, Continuation<? super C0427xbd8dd741> continuation) {
        super(2, continuation);
        this.$timeMillis = j;
        this.this$0 = pointerEventHandlerCoroutine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0427xbd8dd741(this.$timeMillis, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C0427xbd8dd741) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0048  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        C0427xbd8dd741 c0427xbd8dd741;
        C0427xbd8dd741 c0427xbd8dd7412;
        CancellableContinuation cancellableContinuation;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c0427xbd8dd741 = this;
                c0427xbd8dd741.label = 1;
                if (DelayKt.delay(c0427xbd8dd741.$timeMillis - 1, c0427xbd8dd741) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                c0427xbd8dd741.label = 2;
                if (DelayKt.delay(1L, c0427xbd8dd741) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                c0427xbd8dd7412 = c0427xbd8dd741;
                cancellableContinuation = ((SuspendingPointerInputFilter.PointerEventHandlerCoroutine) c0427xbd8dd7412.this$0).pointerAwaiter;
                if (cancellableContinuation != null) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m4732constructorimpl(ResultKt.createFailure(new PointerEventTimeoutCancellationException(c0427xbd8dd7412.$timeMillis))));
                }
                return Unit.INSTANCE;
            case 1:
                c0427xbd8dd741 = this;
                ResultKt.throwOnFailure($result);
                c0427xbd8dd741.label = 2;
                if (DelayKt.delay(1L, c0427xbd8dd741) != coroutine_suspended) {
                }
                break;
            case 2:
                c0427xbd8dd7412 = this;
                ResultKt.throwOnFailure($result);
                cancellableContinuation = ((SuspendingPointerInputFilter.PointerEventHandlerCoroutine) c0427xbd8dd7412.this$0).pointerAwaiter;
                if (cancellableContinuation != null) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
