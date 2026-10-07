package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerEventPass;
import androidx.compose.p000ui.input.pointer.PointerId;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
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

/* compiled from: LongPressTextDragObserver.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2", m297f = "LongPressTextDragObserver.kt", m298i = {}, m299l = {98}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes.dex */
final class LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextDragObserver $observer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2(TextDragObserver textDragObserver, Continuation<? super LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2> continuation) {
        super(2, continuation);
        this.$observer = textDragObserver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2 longPressTextDragObserverKt$detectPreDragGesturesWithObserver$2 = new LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2(this.$observer, continuation);
        longPressTextDragObserverKt$detectPreDragGesturesWithObserver$2.L$0 = obj;
        return longPressTextDragObserverKt$detectPreDragGesturesWithObserver$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: LongPressTextDragObserver.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2$1", m297f = "LongPressTextDragObserver.kt", m298i = {0, 1, 1}, m299l = {99, 103}, m300m = "invokeSuspend", m301n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "down"}, m302s = {"L$0", "L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2$1 */
    static final class C02401 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextDragObserver $observer;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02401(TextDragObserver textDragObserver, Continuation<? super C02401> continuation) {
            super(2, continuation);
            this.$observer = textDragObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02401 c02401 = new C02401(this.$observer, continuation);
            c02401.L$0 = obj;
            return c02401;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C02401) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0077 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00c0 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0091  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0078 -> B:7:0x007f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            C02401 c02401;
            Object $result2;
            Object $result3;
            AwaitPointerEventScope $this$awaitPointerEventScope;
            Object awaitPointerEvent$default;
            Object $result4;
            Object $result5;
            AwaitPointerEventScope $this$awaitPointerEventScope2;
            PointerInputChange down;
            List $this$fastForEach$iv$iv;
            int index$iv$iv;
            int size;
            boolean z;
            List $this$fastForEach$iv$iv2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            PointerEventPass pointerEventPass = null;
            int i = 1;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c02401 = this;
                    AwaitPointerEventScope $this$awaitPointerEventScope3 = (AwaitPointerEventScope) c02401.L$0;
                    c02401.L$0 = $this$awaitPointerEventScope3;
                    c02401.label = 1;
                    Object awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default($this$awaitPointerEventScope3, false, c02401, 1, null);
                    if (awaitFirstDown$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    $result3 = awaitFirstDown$default;
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope3;
                    PointerInputChange down2 = (PointerInputChange) $result3;
                    c02401.$observer.mo1073onDownk4lQ0M(down2.getPosition());
                    Object obj = $result2;
                    PointerInputChange down3 = down2;
                    Object $result6 = obj;
                    c02401.L$0 = $this$awaitPointerEventScope;
                    c02401.L$1 = down3;
                    c02401.label = 2;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerEventScope, pointerEventPass, c02401, i, pointerEventPass);
                    if (awaitPointerEvent$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    PointerInputChange pointerInputChange = down3;
                    $result4 = $result6;
                    $result5 = awaitPointerEvent$default;
                    $this$awaitPointerEventScope2 = $this$awaitPointerEventScope;
                    down = pointerInputChange;
                    PointerEvent event = (PointerEvent) $result5;
                    $this$fastForEach$iv$iv = event.getChanges();
                    index$iv$iv = 0;
                    size = $this$fastForEach$iv$iv.size();
                    while (true) {
                        if (index$iv$iv >= size) {
                            Object it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
                            PointerInputChange it = (PointerInputChange) it$iv;
                            $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                            if (PointerId.m3349equalsimpl0(it.getId(), down.getId()) && it.getPressed()) {
                                z = true;
                            } else {
                                index$iv$iv++;
                                $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                            }
                        } else {
                            z = false;
                        }
                    }
                    if (z) {
                        c02401.$observer.onUp();
                        return Unit.INSTANCE;
                    }
                    $result6 = $result4;
                    down3 = down;
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                    pointerEventPass = null;
                    i = 1;
                    c02401.L$0 = $this$awaitPointerEventScope;
                    c02401.L$1 = down3;
                    c02401.label = 2;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerEventScope, pointerEventPass, c02401, i, pointerEventPass);
                    if (awaitPointerEvent$default == coroutine_suspended) {
                    }
                    break;
                case 1:
                    c02401 = this;
                    $result3 = $result;
                    AwaitPointerEventScope $this$awaitPointerEventScope4 = (AwaitPointerEventScope) c02401.L$0;
                    ResultKt.throwOnFailure($result3);
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope4;
                    $result2 = $result3;
                    PointerInputChange down22 = (PointerInputChange) $result3;
                    c02401.$observer.mo1073onDownk4lQ0M(down22.getPosition());
                    Object obj2 = $result2;
                    PointerInputChange down32 = down22;
                    Object $result62 = obj2;
                    c02401.L$0 = $this$awaitPointerEventScope;
                    c02401.L$1 = down32;
                    c02401.label = 2;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerEventScope, pointerEventPass, c02401, i, pointerEventPass);
                    if (awaitPointerEvent$default == coroutine_suspended) {
                    }
                    break;
                case 2:
                    c02401 = this;
                    $result5 = $result;
                    PointerInputChange down4 = (PointerInputChange) c02401.L$1;
                    AwaitPointerEventScope $this$awaitPointerEventScope5 = (AwaitPointerEventScope) c02401.L$0;
                    ResultKt.throwOnFailure($result5);
                    $this$awaitPointerEventScope2 = $this$awaitPointerEventScope5;
                    down = down4;
                    $result4 = $result5;
                    PointerEvent event2 = (PointerEvent) $result5;
                    $this$fastForEach$iv$iv = event2.getChanges();
                    index$iv$iv = 0;
                    size = $this$fastForEach$iv$iv.size();
                    while (true) {
                        if (index$iv$iv >= size) {
                        }
                        index$iv$iv++;
                        $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                    }
                    if (z) {
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
                PointerInputScope $this$forEachGesture = (PointerInputScope) this.L$0;
                this.label = 1;
                if ($this$forEachGesture.awaitPointerEventScope(new C02401(this.$observer, null), this) != coroutine_suspended) {
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
