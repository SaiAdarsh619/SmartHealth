package androidx.compose.p000ui.input.pointer;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: PointerInteropFilter.android.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$motionEventSpy$1", m297f = "PointerInteropFilter.android.kt", m298i = {}, m299l = {343}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes.dex */
final class PointerInteropFilter_androidKt$motionEventSpy$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<MotionEvent, Unit> $watcher;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PointerInteropFilter_androidKt$motionEventSpy$1(Function1<? super MotionEvent, Unit> function1, Continuation<? super PointerInteropFilter_androidKt$motionEventSpy$1> continuation) {
        super(2, continuation);
        this.$watcher = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PointerInteropFilter_androidKt$motionEventSpy$1 pointerInteropFilter_androidKt$motionEventSpy$1 = new PointerInteropFilter_androidKt$motionEventSpy$1(this.$watcher, continuation);
        pointerInteropFilter_androidKt$motionEventSpy$1.L$0 = obj;
        return pointerInteropFilter_androidKt$motionEventSpy$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((PointerInteropFilter_androidKt$motionEventSpy$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                $this$pointerInput.setInterceptOutOfBoundsChildEvents(true);
                this.label = 1;
                if ($this$pointerInput.awaitPointerEventScope(new C04251(this.$watcher, null), this) != coroutine_suspended) {
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

    /* compiled from: PointerInteropFilter.android.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$motionEventSpy$1$1", m297f = "PointerInteropFilter.android.kt", m298i = {0}, m299l = {345}, m300m = "invokeSuspend", m301n = {"$this$awaitPointerEventScope"}, m302s = {"L$0"})
    /* renamed from: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$motionEventSpy$1$1 */
    static final class C04251 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<MotionEvent, Unit> $watcher;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C04251(Function1<? super MotionEvent, Unit> function1, Continuation<? super C04251> continuation) {
            super(2, continuation);
            this.$watcher = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04251 c04251 = new C04251(this.$watcher, continuation);
            c04251.L$0 = obj;
            return c04251;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C04251) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0038 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0047  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0039 -> B:7:0x003f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            C04251 c04251;
            AwaitPointerEventScope $this$awaitPointerEventScope;
            Object awaitPointerEvent;
            Object $result2;
            AwaitPointerEventScope $this$awaitPointerEventScope2;
            C04251 c042512;
            Object obj;
            MotionEvent motionEvent$ui_release;
            Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c04251 = this;
                    $this$awaitPointerEventScope = (AwaitPointerEventScope) c04251.L$0;
                    c04251.L$0 = $this$awaitPointerEventScope;
                    c04251.label = 1;
                    awaitPointerEvent = $this$awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Initial, c04251);
                    if (awaitPointerEvent == $result3) {
                        return $result3;
                    }
                    Object obj2 = $result3;
                    $result2 = $result;
                    $result = awaitPointerEvent;
                    $this$awaitPointerEventScope2 = $this$awaitPointerEventScope;
                    c042512 = c04251;
                    obj = obj2;
                    PointerEvent event = (PointerEvent) $result;
                    motionEvent$ui_release = event.getMotionEvent$ui_release();
                    if (motionEvent$ui_release != null) {
                        c042512.$watcher.invoke(motionEvent$ui_release);
                    }
                    $result = $result2;
                    $result3 = obj;
                    c04251 = c042512;
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                    c04251.L$0 = $this$awaitPointerEventScope;
                    c04251.label = 1;
                    awaitPointerEvent = $this$awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Initial, c04251);
                    if (awaitPointerEvent == $result3) {
                    }
                case 1:
                    AwaitPointerEventScope $this$awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $this$awaitPointerEventScope2 = $this$awaitPointerEventScope3;
                    c042512 = this;
                    obj = $result3;
                    $result2 = $result;
                    PointerEvent event2 = (PointerEvent) $result;
                    motionEvent$ui_release = event2.getMotionEvent$ui_release();
                    if (motionEvent$ui_release != null) {
                    }
                    $result = $result2;
                    $result3 = obj;
                    c04251 = c042512;
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                    c04251.L$0 = $this$awaitPointerEventScope;
                    c04251.label = 1;
                    awaitPointerEvent = $this$awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Initial, c04251);
                    if (awaitPointerEvent == $result3) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
