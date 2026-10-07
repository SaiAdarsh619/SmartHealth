package androidx.compose.foundation.gestures;

import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: TapGestureDetector.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2", m297f = "TapGestureDetector.kt", m298i = {0, 0}, m299l = {198}, m300m = "invokeSuspend", m301n = {"$this$withTimeoutOrNull", "minUptime"}, m302s = {"L$0", "J$0"})
/* loaded from: classes.dex */
final class TapGestureDetectorKt$awaitSecondDown$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
    final /* synthetic */ PointerInputChange $firstUp;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TapGestureDetectorKt$awaitSecondDown$2(PointerInputChange pointerInputChange, Continuation<? super TapGestureDetectorKt$awaitSecondDown$2> continuation) {
        super(2, continuation);
        this.$firstUp = pointerInputChange;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TapGestureDetectorKt$awaitSecondDown$2 tapGestureDetectorKt$awaitSecondDown$2 = new TapGestureDetectorKt$awaitSecondDown$2(this.$firstUp, continuation);
        tapGestureDetectorKt$awaitSecondDown$2.L$0 = obj;
        return tapGestureDetectorKt$awaitSecondDown$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
        return ((TapGestureDetectorKt$awaitSecondDown$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004f -> B:7:0x0056). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object $result2;
        AwaitPointerEventScope $this$withTimeoutOrNull;
        long minUptime;
        TapGestureDetectorKt$awaitSecondDown$2 tapGestureDetectorKt$awaitSecondDown$2;
        Object obj;
        PointerInputChange change;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                TapGestureDetectorKt$awaitSecondDown$2 tapGestureDetectorKt$awaitSecondDown$22 = this;
                AwaitPointerEventScope $this$withTimeoutOrNull2 = (AwaitPointerEventScope) tapGestureDetectorKt$awaitSecondDown$22.L$0;
                AwaitPointerEventScope $this$withTimeoutOrNull3 = $this$withTimeoutOrNull2;
                long minUptime2 = tapGestureDetectorKt$awaitSecondDown$22.$firstUp.getUptimeMillis() + $this$withTimeoutOrNull2.getViewConfiguration().getDoubleTapMinTimeMillis();
                tapGestureDetectorKt$awaitSecondDown$22.L$0 = $this$withTimeoutOrNull3;
                tapGestureDetectorKt$awaitSecondDown$22.J$0 = minUptime2;
                tapGestureDetectorKt$awaitSecondDown$22.label = 1;
                Object awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default($this$withTimeoutOrNull3, false, tapGestureDetectorKt$awaitSecondDown$22, 1, null);
                if (awaitFirstDown$default != $result3) {
                    return $result3;
                }
                Object obj2 = $result3;
                $result2 = $result;
                $result = awaitFirstDown$default;
                $this$withTimeoutOrNull = $this$withTimeoutOrNull3;
                minUptime = minUptime2;
                tapGestureDetectorKt$awaitSecondDown$2 = tapGestureDetectorKt$awaitSecondDown$22;
                obj = obj2;
                change = (PointerInputChange) $result;
                if (change.getUptimeMillis() < minUptime) {
                    return change;
                }
                $result = $result2;
                $result3 = obj;
                tapGestureDetectorKt$awaitSecondDown$22 = tapGestureDetectorKt$awaitSecondDown$2;
                minUptime2 = minUptime;
                $this$withTimeoutOrNull3 = $this$withTimeoutOrNull;
                tapGestureDetectorKt$awaitSecondDown$22.L$0 = $this$withTimeoutOrNull3;
                tapGestureDetectorKt$awaitSecondDown$22.J$0 = minUptime2;
                tapGestureDetectorKt$awaitSecondDown$22.label = 1;
                Object awaitFirstDown$default2 = TapGestureDetectorKt.awaitFirstDown$default($this$withTimeoutOrNull3, false, tapGestureDetectorKt$awaitSecondDown$22, 1, null);
                if (awaitFirstDown$default2 != $result3) {
                }
            case 1:
                long minUptime3 = this.J$0;
                AwaitPointerEventScope $this$withTimeoutOrNull4 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$withTimeoutOrNull = $this$withTimeoutOrNull4;
                minUptime = minUptime3;
                tapGestureDetectorKt$awaitSecondDown$2 = this;
                obj = $result3;
                $result2 = $result;
                change = (PointerInputChange) $result;
                if (change.getUptimeMillis() < minUptime) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
