package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.health.platform.client.SdkConfig;
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
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextSelectionMouseDetector.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2", m297f = "TextSelectionMouseDetector.kt", m298i = {}, m299l = {87}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes.dex */
final class TextSelectionMouseDetectorKt$mouseSelectionDetector$2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MouseSelectionObserver $observer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextSelectionMouseDetectorKt$mouseSelectionDetector$2(MouseSelectionObserver mouseSelectionObserver, Continuation<? super TextSelectionMouseDetectorKt$mouseSelectionDetector$2> continuation) {
        super(2, continuation);
        this.$observer = mouseSelectionObserver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TextSelectionMouseDetectorKt$mouseSelectionDetector$2 textSelectionMouseDetectorKt$mouseSelectionDetector$2 = new TextSelectionMouseDetectorKt$mouseSelectionDetector$2(this.$observer, continuation);
        textSelectionMouseDetectorKt$mouseSelectionDetector$2.L$0 = obj;
        return textSelectionMouseDetectorKt$mouseSelectionDetector$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((TextSelectionMouseDetectorKt$mouseSelectionDetector$2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: TextSelectionMouseDetector.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$1", m297f = "TextSelectionMouseDetector.kt", m298i = {0, 0, 1, 1, 2, 2}, m299l = {90, 97, SdkConfig.SDK_VERSION}, m300m = "invokeSuspend", m301n = {"$this$awaitPointerEventScope", "clicksCounter", "$this$awaitPointerEventScope", "clicksCounter", "$this$awaitPointerEventScope", "clicksCounter"}, m302s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt$mouseSelectionDetector$2$1 */
    static final class C02801 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MouseSelectionObserver $observer;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02801(MouseSelectionObserver mouseSelectionObserver, Continuation<? super C02801> continuation) {
            super(2, continuation);
            this.$observer = mouseSelectionObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02801 c02801 = new C02801(this.$observer, continuation);
            c02801.L$0 = obj;
            return c02801;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C02801) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
        
            r13 = r0;
            r0 = r1;
            r1 = r2;
            r2 = r3;
            r3 = r4;
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00b8  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0067 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00b2 -> B:7:0x0056). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0101 -> B:7:0x0056). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            C02801 c02801;
            AwaitPointerEventScope $this$awaitPointerEventScope;
            ClicksCounter clicksCounter;
            AwaitPointerEventScope $this$awaitPointerEventScope2;
            ClicksCounter clicksCounter2;
            C02801 c028012;
            Object obj;
            Object $result2;
            PointerEvent down;
            final SelectionAdjustment selectionMode;
            Object awaitMouseEventDown;
            Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c02801 = this;
                    $this$awaitPointerEventScope = (AwaitPointerEventScope) c02801.L$0;
                    clicksCounter = new ClicksCounter($this$awaitPointerEventScope.getViewConfiguration());
                    c02801.L$0 = $this$awaitPointerEventScope;
                    c02801.L$1 = clicksCounter;
                    c02801.label = 1;
                    awaitMouseEventDown = TextSelectionMouseDetectorKt.awaitMouseEventDown($this$awaitPointerEventScope, c02801);
                    if (awaitMouseEventDown == $result3) {
                        return $result3;
                    }
                    Object obj2 = $result3;
                    $result2 = $result;
                    $result = awaitMouseEventDown;
                    clicksCounter2 = clicksCounter;
                    $this$awaitPointerEventScope2 = $this$awaitPointerEventScope;
                    c028012 = c02801;
                    obj = obj2;
                    down = (PointerEvent) $result;
                    clicksCounter2.update(down);
                    PointerInputChange downChange = down.getChanges().get(0);
                    if (TextFieldSelectionManager_androidKt.isShiftPressed(down)) {
                        switch (clicksCounter2.getClicks()) {
                            case 1:
                                selectionMode = SelectionAdjustment.INSTANCE.getNone();
                                break;
                            case 2:
                                selectionMode = SelectionAdjustment.INSTANCE.getWord();
                                break;
                            default:
                                selectionMode = SelectionAdjustment.INSTANCE.getParagraph();
                                break;
                        }
                        boolean started = c028012.$observer.mo1079onStart3MmeM6k(downChange.getPosition(), selectionMode);
                        if (started) {
                            downChange.consume();
                            long id = downChange.getId();
                            final MouseSelectionObserver mouseSelectionObserver = c028012.$observer;
                            c028012.L$0 = $this$awaitPointerEventScope2;
                            c028012.L$1 = clicksCounter2;
                            c028012.label = 3;
                            if (DragGestureDetectorKt.m592dragjO51t88($this$awaitPointerEventScope2, id, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt.mouseSelectionDetector.2.1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange) {
                                    invoke2(pointerInputChange);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(PointerInputChange it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    if (MouseSelectionObserver.this.mo1076onDrag3MmeM6k(it.getPosition(), selectionMode)) {
                                        it.consume();
                                    }
                                }
                            }, c028012) == obj) {
                                return obj;
                            }
                            $result = $result2;
                            $result3 = obj;
                            c02801 = c028012;
                            $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                            clicksCounter = clicksCounter2;
                        }
                        $result = $result2;
                        $result3 = obj;
                        c02801 = c028012;
                        $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                        clicksCounter = clicksCounter2;
                    } else {
                        boolean started2 = c028012.$observer.mo1077onExtendk4lQ0M(downChange.getPosition());
                        if (started2) {
                            downChange.consume();
                            long id2 = downChange.getId();
                            final MouseSelectionObserver mouseSelectionObserver2 = c028012.$observer;
                            c028012.L$0 = $this$awaitPointerEventScope2;
                            c028012.L$1 = clicksCounter2;
                            c028012.label = 2;
                            if (DragGestureDetectorKt.m592dragjO51t88($this$awaitPointerEventScope2, id2, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt.mouseSelectionDetector.2.1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange) {
                                    invoke2(pointerInputChange);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(PointerInputChange it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    if (MouseSelectionObserver.this.mo1078onExtendDragk4lQ0M(it.getPosition())) {
                                        it.consume();
                                    }
                                }
                            }, c028012) == obj) {
                                return obj;
                            }
                            $result = $result2;
                            $result3 = obj;
                            c02801 = c028012;
                            $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                            clicksCounter = clicksCounter2;
                        } else {
                            $result = $result2;
                            $result3 = obj;
                            c02801 = c028012;
                            $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                            clicksCounter = clicksCounter2;
                        }
                    }
                    c02801.L$0 = $this$awaitPointerEventScope;
                    c02801.L$1 = clicksCounter;
                    c02801.label = 1;
                    awaitMouseEventDown = TextSelectionMouseDetectorKt.awaitMouseEventDown($this$awaitPointerEventScope, c02801);
                    if (awaitMouseEventDown == $result3) {
                    }
                    break;
                case 1:
                    ClicksCounter clicksCounter3 = (ClicksCounter) this.L$1;
                    $this$awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    clicksCounter2 = clicksCounter3;
                    c028012 = this;
                    obj = $result3;
                    $result2 = $result;
                    down = (PointerEvent) $result;
                    clicksCounter2.update(down);
                    PointerInputChange downChange2 = down.getChanges().get(0);
                    if (TextFieldSelectionManager_androidKt.isShiftPressed(down)) {
                    }
                    c02801.L$0 = $this$awaitPointerEventScope;
                    c02801.L$1 = clicksCounter;
                    c02801.label = 1;
                    awaitMouseEventDown = TextSelectionMouseDetectorKt.awaitMouseEventDown($this$awaitPointerEventScope, c02801);
                    if (awaitMouseEventDown == $result3) {
                    }
                    break;
                case 2:
                    c02801 = this;
                    ClicksCounter clicksCounter4 = (ClicksCounter) c02801.L$1;
                    AwaitPointerEventScope $this$awaitPointerEventScope3 = (AwaitPointerEventScope) c02801.L$0;
                    ResultKt.throwOnFailure($result);
                    clicksCounter = clicksCounter4;
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope3;
                    c02801.L$0 = $this$awaitPointerEventScope;
                    c02801.L$1 = clicksCounter;
                    c02801.label = 1;
                    awaitMouseEventDown = TextSelectionMouseDetectorKt.awaitMouseEventDown($this$awaitPointerEventScope, c02801);
                    if (awaitMouseEventDown == $result3) {
                    }
                    break;
                case 3:
                    c02801 = this;
                    ClicksCounter clicksCounter5 = (ClicksCounter) c02801.L$1;
                    AwaitPointerEventScope $this$awaitPointerEventScope4 = (AwaitPointerEventScope) c02801.L$0;
                    ResultKt.throwOnFailure($result);
                    clicksCounter = clicksCounter5;
                    $this$awaitPointerEventScope = $this$awaitPointerEventScope4;
                    c02801.L$0 = $this$awaitPointerEventScope;
                    c02801.L$1 = clicksCounter;
                    c02801.label = 1;
                    awaitMouseEventDown = TextSelectionMouseDetectorKt.awaitMouseEventDown($this$awaitPointerEventScope, c02801);
                    if (awaitMouseEventDown == $result3) {
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
                if ($this$forEachGesture.awaitPointerEventScope(new C02801(this.$observer, null), this) != coroutine_suspended) {
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
