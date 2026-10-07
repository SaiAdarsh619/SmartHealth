package androidx.compose.material;

import androidx.compose.foundation.gestures.DragScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: SwipeableV2.kt */
@Metadata(m286d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m287d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/DragScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.material.SwipeableV2State$snapTo$2", m297f = "SwipeableV2.kt", m298i = {}, m299l = {}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes.dex */
final class SwipeableV2State$snapTo$2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $targetOffset;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeableV2State$snapTo$2(float f, SwipeableV2State<T> swipeableV2State, Continuation<? super SwipeableV2State$snapTo$2> continuation) {
        super(2, continuation);
        this.$targetOffset = f;
        this.this$0 = swipeableV2State;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SwipeableV2State$snapTo$2 swipeableV2State$snapTo$2 = new SwipeableV2State$snapTo$2(this.$targetOffset, this.this$0, continuation);
        swipeableV2State$snapTo$2.L$0 = obj;
        return swipeableV2State$snapTo$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
        return ((SwipeableV2State$snapTo$2) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                DragScope $this$drag = (DragScope) this.L$0;
                $this$drag.dragBy(this.$targetOffset - this.this$0.getOffset().getValue().floatValue());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
