package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: SwipeableV2.kt */
@Metadata(m286d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m287d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/DragScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.material.SwipeableV2State$animateTo$2", m297f = "SwipeableV2.kt", m298i = {}, m299l = {254}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes.dex */
final class SwipeableV2State$animateTo$2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $targetOffset;
    final /* synthetic */ float $velocity;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeableV2State$animateTo$2(SwipeableV2State<T> swipeableV2State, float f, float f2, Continuation<? super SwipeableV2State$animateTo$2> continuation) {
        super(2, continuation);
        this.this$0 = swipeableV2State;
        this.$targetOffset = f;
        this.$velocity = f2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SwipeableV2State$animateTo$2 swipeableV2State$animateTo$2 = new SwipeableV2State$animateTo$2(this.this$0, this.$targetOffset, this.$velocity, continuation);
        swipeableV2State$animateTo$2.L$0 = obj;
        return swipeableV2State$animateTo$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
        return ((SwipeableV2State$animateTo$2) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        MutableState mutableState;
        Throwable th;
        SwipeableV2State$animateTo$2 swipeableV2State$animateTo$2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final DragScope $this$drag = (DragScope) this.L$0;
                this.this$0.setAnimationRunning(true);
                final Ref.FloatRef prev = new Ref.FloatRef();
                mutableState = ((SwipeableV2State) this.this$0).dragPosition;
                prev.element = ((Number) mutableState.getValue()).floatValue();
                try {
                    float f = prev.element;
                    float f2 = this.$targetOffset;
                    float f3 = this.$velocity;
                    AnimationSpec<Float> animationSpec = this.this$0.getAnimationSpec();
                    final SwipeableV2State<T> swipeableV2State = this.this$0;
                    this.label = 1;
                    if (SuspendAnimationKt.animate(f, f2, f3, animationSpec, new Function2<Float, Float, Unit>() { // from class: androidx.compose.material.SwipeableV2State$animateTo$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Float f4, Float f5) {
                            invoke(f4.floatValue(), f5.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float value, float velocity) {
                            DragScope.this.dragBy(value - prev.element);
                            prev.element = value;
                            swipeableV2State.setLastVelocity(velocity);
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    swipeableV2State$animateTo$2 = this;
                    swipeableV2State$animateTo$2.this$0.setAnimationRunning(false);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    swipeableV2State$animateTo$2 = this;
                    swipeableV2State$animateTo$2.this$0.setAnimationRunning(false);
                    throw th;
                }
            case 1:
                swipeableV2State$animateTo$2 = this;
                try {
                    ResultKt.throwOnFailure($result);
                    swipeableV2State$animateTo$2.this$0.setAnimationRunning(false);
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    swipeableV2State$animateTo$2.this$0.setAnimationRunning(false);
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
