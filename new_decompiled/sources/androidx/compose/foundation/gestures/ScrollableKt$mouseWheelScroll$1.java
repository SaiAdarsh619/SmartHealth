package androidx.compose.foundation.gestures;

import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.runtime.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: Scrollable.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.ScrollableKt$mouseWheelScroll$1", m297f = "Scrollable.kt", m298i = {}, m299l = {289}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes.dex */
final class ScrollableKt$mouseWheelScroll$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ScrollConfig $mouseWheelScrollConfig;
    final /* synthetic */ State<ScrollingLogic> $scrollingLogicState;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollableKt$mouseWheelScroll$1(ScrollConfig scrollConfig, State<ScrollingLogic> state, Continuation<? super ScrollableKt$mouseWheelScroll$1> continuation) {
        super(2, continuation);
        this.$mouseWheelScrollConfig = scrollConfig;
        this.$scrollingLogicState = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollableKt$mouseWheelScroll$1 scrollableKt$mouseWheelScroll$1 = new ScrollableKt$mouseWheelScroll$1(this.$mouseWheelScrollConfig, this.$scrollingLogicState, continuation);
        scrollableKt$mouseWheelScroll$1.L$0 = obj;
        return scrollableKt$mouseWheelScroll$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((ScrollableKt$mouseWheelScroll$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: Scrollable.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.compose.foundation.gestures.ScrollableKt$mouseWheelScroll$1$1", m297f = "Scrollable.kt", m298i = {0}, m299l = {291}, m300m = "invokeSuspend", m301n = {"$this$awaitPointerEventScope"}, m302s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.ScrollableKt$mouseWheelScroll$1$1 */
    static final class C00991 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ScrollConfig $mouseWheelScrollConfig;
        final /* synthetic */ State<ScrollingLogic> $scrollingLogicState;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00991(ScrollConfig scrollConfig, State<ScrollingLogic> state, Continuation<? super C00991> continuation) {
            super(2, continuation);
            this.$mouseWheelScrollConfig = scrollConfig;
            this.$scrollingLogicState = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00991 c00991 = new C00991(this.$mouseWheelScrollConfig, this.$scrollingLogicState, continuation);
            c00991.L$0 = obj;
            return c00991;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C00991) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x003c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x006f A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x003d -> B:7:0x0043). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            C00991 c00991;
            Object $result;
            AwaitPointerEventScope $this$awaitPointerEventScope;
            Object awaitScrollEvent;
            Object $result2;
            Object $result3;
            AwaitPointerEventScope $this$awaitPointerEventScope2;
            int index$iv$iv;
            int size;
            List $this$fastForEach$iv$iv;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    c00991 = this;
                    $result = obj;
                    $this$awaitPointerEventScope = (AwaitPointerEventScope) c00991.L$0;
                    c00991.L$0 = $this$awaitPointerEventScope;
                    c00991.label = 1;
                    awaitScrollEvent = ScrollableKt.awaitScrollEvent($this$awaitPointerEventScope, c00991);
                    if (awaitScrollEvent == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    AwaitPointerEventScope awaitPointerEventScope = $this$awaitPointerEventScope;
                    $result2 = $result;
                    $result3 = awaitScrollEvent;
                    $this$awaitPointerEventScope2 = awaitPointerEventScope;
                    PointerEvent event = (PointerEvent) $result3;
                    List $this$fastForEach$iv$iv2 = event.getChanges();
                    index$iv$iv = 0;
                    size = $this$fastForEach$iv$iv2.size();
                    while (true) {
                        if (index$iv$iv >= size) {
                            Object it$iv = $this$fastForEach$iv$iv2.get(index$iv$iv);
                            PointerInputChange it = (PointerInputChange) it$iv;
                            PointerInputChange it2 = !it.isConsumed() ? 1 : null;
                            if (it2 == null) {
                                $this$fastForEach$iv$iv = null;
                            } else {
                                index$iv$iv++;
                            }
                        } else {
                            $this$fastForEach$iv$iv = 1;
                        }
                    }
                    if ($this$fastForEach$iv$iv != null) {
                        ScrollConfig $this$invokeSuspend_u24lambda_u2d3 = c00991.$mouseWheelScrollConfig;
                        State<ScrollingLogic> state = c00991.$scrollingLogicState;
                        long scrollAmount = $this$invokeSuspend_u24lambda_u2d3.mo569calculateMouseWheelScroll8xgXZGE($this$awaitPointerEventScope2, event, $this$awaitPointerEventScope2.mo3280getSizeYbymL2g());
                        ScrollingLogic $this$invokeSuspend_u24lambda_u2d3_u24lambda_u2d2 = state.getValue();
                        float delta = $this$invokeSuspend_u24lambda_u2d3_u24lambda_u2d2.reverseIfNeeded($this$invokeSuspend_u24lambda_u2d3_u24lambda_u2d2.m667toFloatk4lQ0M(scrollAmount));
                        float consumedDelta = $this$invokeSuspend_u24lambda_u2d3_u24lambda_u2d2.getScrollableState().dispatchRawDelta(delta);
                        if (!(consumedDelta == 0.0f)) {
                            List $this$fastForEach$iv = event.getChanges();
                            int size2 = $this$fastForEach$iv.size();
                            for (int index$iv = 0; index$iv < size2; index$iv++) {
                                Object item$iv = $this$fastForEach$iv.get(index$iv);
                                PointerInputChange it3 = (PointerInputChange) item$iv;
                                it3.consume();
                            }
                        }
                    }
                    $result = $result2;
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                    c00991.L$0 = $this$awaitPointerEventScope;
                    c00991.label = 1;
                    awaitScrollEvent = ScrollableKt.awaitScrollEvent($this$awaitPointerEventScope, c00991);
                    if (awaitScrollEvent == coroutine_suspended) {
                    }
                case 1:
                    c00991 = this;
                    $result3 = obj;
                    AwaitPointerEventScope $this$awaitPointerEventScope3 = (AwaitPointerEventScope) c00991.L$0;
                    ResultKt.throwOnFailure($result3);
                    $this$awaitPointerEventScope2 = $this$awaitPointerEventScope3;
                    $result2 = $result3;
                    PointerEvent event2 = (PointerEvent) $result3;
                    List $this$fastForEach$iv$iv22 = event2.getChanges();
                    index$iv$iv = 0;
                    size = $this$fastForEach$iv$iv22.size();
                    while (true) {
                        if (index$iv$iv >= size) {
                        }
                        index$iv$iv++;
                    }
                    if ($this$fastForEach$iv$iv != null) {
                    }
                    $result = $result2;
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                    c00991.L$0 = $this$awaitPointerEventScope;
                    c00991.label = 1;
                    awaitScrollEvent = ScrollableKt.awaitScrollEvent($this$awaitPointerEventScope, c00991);
                    if (awaitScrollEvent == coroutine_suspended) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                this.label = 1;
                if ($this$pointerInput.awaitPointerEventScope(new C00991(this.$mouseWheelScrollConfig, this.$scrollingLogicState, null), this) != coroutine_suspended) {
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
