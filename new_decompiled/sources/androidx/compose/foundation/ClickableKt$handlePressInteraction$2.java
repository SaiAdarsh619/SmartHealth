package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* compiled from: Clickable.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.ClickableKt$handlePressInteraction$2", m297f = "Clickable.kt", m298i = {0, 1, 2}, m299l = {445, 447, 454, 455, 464}, m300m = "invokeSuspend", m301n = {"delayJob", "success", "releaseInteraction"}, m302s = {"L$0", "Z$0", "L$0"})
/* loaded from: classes.dex */
final class ClickableKt$handlePressInteraction$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function0<Boolean>> $delayPressInteraction;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $pressPoint;
    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
    final /* synthetic */ PressGestureScope $this_handlePressInteraction;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ClickableKt$handlePressInteraction$2(PressGestureScope pressGestureScope, long j, MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState, State<? extends Function0<Boolean>> state, Continuation<? super ClickableKt$handlePressInteraction$2> continuation) {
        super(2, continuation);
        this.$this_handlePressInteraction = pressGestureScope;
        this.$pressPoint = j;
        this.$interactionSource = mutableInteractionSource;
        this.$pressedInteraction = mutableState;
        this.$delayPressInteraction = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ClickableKt$handlePressInteraction$2 clickableKt$handlePressInteraction$2 = new ClickableKt$handlePressInteraction$2(this.$this_handlePressInteraction, this.$pressPoint, this.$interactionSource, this.$pressedInteraction, this.$delayPressInteraction, continuation);
        clickableKt$handlePressInteraction$2.L$0 = obj;
        return clickableKt$handlePressInteraction$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClickableKt$handlePressInteraction$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d6  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Job delayJob;
        Object $result2;
        Job delayJob2;
        ClickableKt$handlePressInteraction$2 clickableKt$handlePressInteraction$2;
        ClickableKt$handlePressInteraction$2 clickableKt$handlePressInteraction$22;
        boolean success;
        ClickableKt$handlePressInteraction$2 clickableKt$handlePressInteraction$23;
        PressInteraction.Release releaseInteraction;
        ClickableKt$handlePressInteraction$2 clickableKt$handlePressInteraction$24;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                delayJob = BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, null, new ClickableKt$handlePressInteraction$2$delayJob$1(this.$delayPressInteraction, this.$pressPoint, this.$interactionSource, this.$pressedInteraction, null), 3, null);
                this.L$0 = delayJob;
                this.label = 1;
                Object tryAwaitRelease = this.$this_handlePressInteraction.tryAwaitRelease(this);
                if (tryAwaitRelease == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = tryAwaitRelease;
                delayJob2 = delayJob;
                clickableKt$handlePressInteraction$2 = this;
                boolean success2 = ((Boolean) $result).booleanValue();
                if (delayJob2.isActive()) {
                    PressInteraction.Press pressInteraction = clickableKt$handlePressInteraction$2.$pressedInteraction.getValue();
                    if (pressInteraction != null) {
                        MutableInteractionSource mutableInteractionSource = clickableKt$handlePressInteraction$2.$interactionSource;
                        PressInteraction endInteraction = success2 ? new PressInteraction.Release(pressInteraction) : new PressInteraction.Cancel(pressInteraction);
                        clickableKt$handlePressInteraction$2.L$0 = null;
                        clickableKt$handlePressInteraction$2.label = 5;
                        if (mutableInteractionSource.emit(endInteraction, clickableKt$handlePressInteraction$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = $result2;
                        clickableKt$handlePressInteraction$22 = clickableKt$handlePressInteraction$2;
                        clickableKt$handlePressInteraction$2 = clickableKt$handlePressInteraction$22;
                    }
                    clickableKt$handlePressInteraction$2.$pressedInteraction.setValue(null);
                    return Unit.INSTANCE;
                }
                clickableKt$handlePressInteraction$2.L$0 = null;
                clickableKt$handlePressInteraction$2.Z$0 = success2;
                clickableKt$handlePressInteraction$2.label = 2;
                if (JobKt.cancelAndJoin(delayJob2, clickableKt$handlePressInteraction$2) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ClickableKt$handlePressInteraction$2 clickableKt$handlePressInteraction$25 = clickableKt$handlePressInteraction$2;
                success = success2;
                $result = $result2;
                clickableKt$handlePressInteraction$23 = clickableKt$handlePressInteraction$25;
                if (success) {
                    clickableKt$handlePressInteraction$2 = clickableKt$handlePressInteraction$23;
                    clickableKt$handlePressInteraction$2.$pressedInteraction.setValue(null);
                    return Unit.INSTANCE;
                }
                PressInteraction.Press pressInteraction2 = new PressInteraction.Press(clickableKt$handlePressInteraction$23.$pressPoint, null);
                PressInteraction.Release releaseInteraction2 = new PressInteraction.Release(pressInteraction2);
                clickableKt$handlePressInteraction$23.L$0 = releaseInteraction2;
                clickableKt$handlePressInteraction$23.label = 3;
                if (clickableKt$handlePressInteraction$23.$interactionSource.emit(pressInteraction2, clickableKt$handlePressInteraction$23) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                releaseInteraction = releaseInteraction2;
                clickableKt$handlePressInteraction$23.L$0 = null;
                clickableKt$handlePressInteraction$23.label = 4;
                if (clickableKt$handlePressInteraction$23.$interactionSource.emit(releaseInteraction, clickableKt$handlePressInteraction$23) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                clickableKt$handlePressInteraction$24 = clickableKt$handlePressInteraction$23;
                clickableKt$handlePressInteraction$2 = clickableKt$handlePressInteraction$24;
                clickableKt$handlePressInteraction$2.$pressedInteraction.setValue(null);
                return Unit.INSTANCE;
            case 1:
                Job delayJob3 = (Job) this.L$0;
                ResultKt.throwOnFailure($result);
                delayJob2 = delayJob3;
                clickableKt$handlePressInteraction$2 = this;
                $result2 = $result;
                boolean success22 = ((Boolean) $result).booleanValue();
                if (delayJob2.isActive()) {
                }
                break;
            case 2:
                clickableKt$handlePressInteraction$23 = this;
                success = clickableKt$handlePressInteraction$23.Z$0;
                ResultKt.throwOnFailure($result);
                if (success) {
                }
                break;
            case 3:
                clickableKt$handlePressInteraction$23 = this;
                releaseInteraction = (PressInteraction.Release) clickableKt$handlePressInteraction$23.L$0;
                ResultKt.throwOnFailure($result);
                clickableKt$handlePressInteraction$23.L$0 = null;
                clickableKt$handlePressInteraction$23.label = 4;
                if (clickableKt$handlePressInteraction$23.$interactionSource.emit(releaseInteraction, clickableKt$handlePressInteraction$23) != coroutine_suspended) {
                }
                break;
            case 4:
                clickableKt$handlePressInteraction$24 = this;
                ResultKt.throwOnFailure($result);
                clickableKt$handlePressInteraction$2 = clickableKt$handlePressInteraction$24;
                clickableKt$handlePressInteraction$2.$pressedInteraction.setValue(null);
                return Unit.INSTANCE;
            case 5:
                clickableKt$handlePressInteraction$22 = this;
                ResultKt.throwOnFailure($result);
                clickableKt$handlePressInteraction$2 = clickableKt$handlePressInteraction$22;
                clickableKt$handlePressInteraction$2.$pressedInteraction.setValue(null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
