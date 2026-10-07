package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: Clickable.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.ClickableKt$handlePressInteraction$2$delayJob$1", m297f = "Clickable.kt", m298i = {1}, m299l = {439, 442}, m300m = "invokeSuspend", m301n = {"pressInteraction"}, m302s = {"L$0"})
/* loaded from: classes.dex */
final class ClickableKt$handlePressInteraction$2$delayJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function0<Boolean>> $delayPressInteraction;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $pressPoint;
    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ClickableKt$handlePressInteraction$2$delayJob$1(State<? extends Function0<Boolean>> state, long j, MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState, Continuation<? super ClickableKt$handlePressInteraction$2$delayJob$1> continuation) {
        super(2, continuation);
        this.$delayPressInteraction = state;
        this.$pressPoint = j;
        this.$interactionSource = mutableInteractionSource;
        this.$pressedInteraction = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClickableKt$handlePressInteraction$2$delayJob$1(this.$delayPressInteraction, this.$pressPoint, this.$interactionSource, this.$pressedInteraction, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClickableKt$handlePressInteraction$2$delayJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ClickableKt$handlePressInteraction$2$delayJob$1 clickableKt$handlePressInteraction$2$delayJob$1;
        PressInteraction.Press pressInteraction;
        ClickableKt$handlePressInteraction$2$delayJob$1 clickableKt$handlePressInteraction$2$delayJob$12;
        PressInteraction.Press pressInteraction2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                clickableKt$handlePressInteraction$2$delayJob$1 = this;
                if (clickableKt$handlePressInteraction$2$delayJob$1.$delayPressInteraction.getValue().invoke().booleanValue()) {
                    clickableKt$handlePressInteraction$2$delayJob$1.label = 1;
                    if (DelayKt.delay(Clickable_androidKt.getTapIndicationDelay(), clickableKt$handlePressInteraction$2$delayJob$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                pressInteraction = new PressInteraction.Press(clickableKt$handlePressInteraction$2$delayJob$1.$pressPoint, null);
                clickableKt$handlePressInteraction$2$delayJob$1.L$0 = pressInteraction;
                clickableKt$handlePressInteraction$2$delayJob$1.label = 2;
                if (clickableKt$handlePressInteraction$2$delayJob$1.$interactionSource.emit(pressInteraction, clickableKt$handlePressInteraction$2$delayJob$1) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                clickableKt$handlePressInteraction$2$delayJob$12 = clickableKt$handlePressInteraction$2$delayJob$1;
                pressInteraction2 = pressInteraction;
                clickableKt$handlePressInteraction$2$delayJob$12.$pressedInteraction.setValue(pressInteraction2);
                return Unit.INSTANCE;
            case 1:
                clickableKt$handlePressInteraction$2$delayJob$1 = this;
                ResultKt.throwOnFailure($result);
                pressInteraction = new PressInteraction.Press(clickableKt$handlePressInteraction$2$delayJob$1.$pressPoint, null);
                clickableKt$handlePressInteraction$2$delayJob$1.L$0 = pressInteraction;
                clickableKt$handlePressInteraction$2$delayJob$1.label = 2;
                if (clickableKt$handlePressInteraction$2$delayJob$1.$interactionSource.emit(pressInteraction, clickableKt$handlePressInteraction$2$delayJob$1) != coroutine_suspended) {
                }
                break;
            case 2:
                clickableKt$handlePressInteraction$2$delayJob$12 = this;
                pressInteraction2 = (PressInteraction.Press) clickableKt$handlePressInteraction$2$delayJob$12.L$0;
                ResultKt.throwOnFailure($result);
                clickableKt$handlePressInteraction$2$delayJob$12.$pressedInteraction.setValue(pressInteraction2);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
