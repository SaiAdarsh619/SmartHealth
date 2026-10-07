package androidx.compose.foundation.gestures;

import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.runtime.State;
import androidx.health.connect.client.records.ExerciseSessionRecord;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: Transformable.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.TransformableKt$transformable$2$block$1$1", m297f = "Transformable.kt", m298i = {}, m299l = {ExerciseSessionRecord.EXERCISE_TYPE_STRETCHING}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes.dex */
final class TransformableKt$transformable$2$block$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Boolean> $updatePanZoomLock;
    final /* synthetic */ State<TransformableState> $updatedState;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TransformableKt$transformable$2$block$1$1(State<Boolean> state, State<? extends TransformableState> state2, Continuation<? super TransformableKt$transformable$2$block$1$1> continuation) {
        super(2, continuation);
        this.$updatePanZoomLock = state;
        this.$updatedState = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformableKt$transformable$2$block$1$1 transformableKt$transformable$2$block$1$1 = new TransformableKt$transformable$2$block$1$1(this.$updatePanZoomLock, this.$updatedState, continuation);
        transformableKt$transformable$2$block$1$1.L$0 = obj;
        return transformableKt$transformable$2$block$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((TransformableKt$transformable$2$block$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: Transformable.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.compose.foundation.gestures.TransformableKt$transformable$2$block$1$1$1", m297f = "Transformable.kt", m298i = {}, m299l = {ExerciseSessionRecord.EXERCISE_TYPE_SURFING}, m300m = "invokeSuspend", m301n = {}, m302s = {})
    /* renamed from: androidx.compose.foundation.gestures.TransformableKt$transformable$2$block$1$1$1 */
    static final class C01051 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ State<Boolean> $updatePanZoomLock;
        final /* synthetic */ State<TransformableState> $updatedState;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01051(State<Boolean> state, State<? extends TransformableState> state2, Continuation<? super C01051> continuation) {
            super(2, continuation);
            this.$updatePanZoomLock = state;
            this.$updatedState = state2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01051 c01051 = new C01051(this.$updatePanZoomLock, this.$updatedState, continuation);
            c01051.L$0 = obj;
            return c01051;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C01051) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object detectZoom;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PointerInputScope $this$forEachGesture = (PointerInputScope) this.L$0;
                    this.label = 1;
                    detectZoom = TransformableKt.detectZoom($this$forEachGesture, this.$updatePanZoomLock, this.$updatedState, this);
                    if (detectZoom != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$null = (PointerInputScope) this.L$0;
                this.label = 1;
                if (ForEachGestureKt.forEachGesture($this$null, new C01051(this.$updatePanZoomLock, this.$updatedState, null), this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
