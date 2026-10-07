package androidx.compose.material;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerEventKt;
import androidx.compose.p000ui.input.pointer.PointerEventPass;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: ExposedDropdownMenu.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.material.ExposedDropdownMenuKt$expandable$1", m297f = "ExposedDropdownMenu.kt", m298i = {}, m299l = {516}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes.dex */
final class ExposedDropdownMenuKt$expandable$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onExpandedChange;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenuKt$expandable$1(Function0<Unit> function0, Continuation<? super ExposedDropdownMenuKt$expandable$1> continuation) {
        super(2, continuation);
        this.$onExpandedChange = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ExposedDropdownMenuKt$expandable$1 exposedDropdownMenuKt$expandable$1 = new ExposedDropdownMenuKt$expandable$1(this.$onExpandedChange, continuation);
        exposedDropdownMenuKt$expandable$1.L$0 = obj;
        return exposedDropdownMenuKt$expandable$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((ExposedDropdownMenuKt$expandable$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: ExposedDropdownMenu.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1", m297f = "ExposedDropdownMenu.kt", m298i = {}, m299l = {517}, m300m = "invokeSuspend", m301n = {}, m302s = {})
    /* renamed from: androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1 */
    static final class C03241 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onExpandedChange;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03241(Function0<Unit> function0, Continuation<? super C03241> continuation) {
            super(2, continuation);
            this.$onExpandedChange = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03241 c03241 = new C03241(this.$onExpandedChange, continuation);
            c03241.L$0 = obj;
            return c03241;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C03241) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ExposedDropdownMenu.kt */
        @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
        @DebugMetadata(m296c = "androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1$1", m297f = "ExposedDropdownMenu.kt", m298i = {}, m299l = {518}, m300m = "invokeSuspend", m301n = {}, m302s = {})
        /* renamed from: androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $$this$forEachGesture;
            final /* synthetic */ Function0<Unit> $onExpandedChange;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PointerInputScope pointerInputScope, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$forEachGesture = pointerInputScope;
                this.$onExpandedChange = function0;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$$this$forEachGesture, this.$onExpandedChange, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* compiled from: ExposedDropdownMenu.kt */
            @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            @DebugMetadata(m296c = "androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1$1$1", m297f = "ExposedDropdownMenu.kt", m298i = {0}, m299l = {521}, m300m = "invokeSuspend", m301n = {"$this$awaitPointerEventScope"}, m302s = {"L$0"})
            /* renamed from: androidx.compose.material.ExposedDropdownMenuKt$expandable$1$1$1$1, reason: invalid class name and collision with other inner class name */
            static final class C16741 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function0<Unit> $onExpandedChange;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C16741(Function0<Unit> function0, Continuation<? super C16741> continuation) {
                    super(2, continuation);
                    this.$onExpandedChange = function0;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C16741 c16741 = new C16741(this.$onExpandedChange, continuation);
                    c16741.L$0 = obj;
                    return c16741;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((C16741) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x006f  */
                /* JADX WARN: Removed duplicated region for block: B:17:0x0077  */
                /* JADX WARN: Removed duplicated region for block: B:20:0x003d A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x006b A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:9:0x0056  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x003e -> B:7:0x0044). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    C16741 c16741;
                    Object $result;
                    Object $result2;
                    AwaitPointerEventScope $this$awaitPointerEventScope;
                    int index$iv$iv;
                    int size;
                    boolean z;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            c16741 = this;
                            Object $result3 = obj;
                            AwaitPointerEventScope $this$awaitPointerEventScope2 = (AwaitPointerEventScope) c16741.L$0;
                            c16741.L$0 = $this$awaitPointerEventScope2;
                            c16741.label = 1;
                            Object awaitPointerEvent = $this$awaitPointerEventScope2.awaitPointerEvent(PointerEventPass.Initial, c16741);
                            if (awaitPointerEvent != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            AwaitPointerEventScope awaitPointerEventScope = $this$awaitPointerEventScope2;
                            $result = $result3;
                            $result2 = awaitPointerEvent;
                            $this$awaitPointerEventScope = awaitPointerEventScope;
                            PointerEvent event = (PointerEvent) $result2;
                            List $this$fastForEach$iv$iv = event.getChanges();
                            index$iv$iv = 0;
                            size = $this$fastForEach$iv$iv.size();
                            while (true) {
                                if (index$iv$iv >= size) {
                                    Object item$iv$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
                                    PointerInputChange it = (PointerInputChange) item$iv$iv;
                                    if (PointerEventKt.changedToUp(it)) {
                                        index$iv$iv++;
                                    } else {
                                        z = false;
                                    }
                                } else {
                                    z = true;
                                }
                            }
                            if (!z) {
                                c16741.$onExpandedChange.invoke();
                                return Unit.INSTANCE;
                            }
                            $result3 = $result;
                            $this$awaitPointerEventScope2 = $this$awaitPointerEventScope;
                            c16741.L$0 = $this$awaitPointerEventScope2;
                            c16741.label = 1;
                            Object awaitPointerEvent2 = $this$awaitPointerEventScope2.awaitPointerEvent(PointerEventPass.Initial, c16741);
                            if (awaitPointerEvent2 != coroutine_suspended) {
                            }
                        case 1:
                            c16741 = this;
                            $result2 = obj;
                            AwaitPointerEventScope $this$awaitPointerEventScope3 = (AwaitPointerEventScope) c16741.L$0;
                            ResultKt.throwOnFailure($result2);
                            $this$awaitPointerEventScope = $this$awaitPointerEventScope3;
                            $result = $result2;
                            PointerEvent event2 = (PointerEvent) $result2;
                            List $this$fastForEach$iv$iv2 = event2.getChanges();
                            index$iv$iv = 0;
                            size = $this$fastForEach$iv$iv2.size();
                            while (true) {
                                if (index$iv$iv >= size) {
                                }
                                index$iv$iv++;
                            }
                            if (!z) {
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
                        this.label = 1;
                        if (this.$$this$forEachGesture.awaitPointerEventScope(new C16741(this.$onExpandedChange, null), this) != coroutine_suspended) {
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
                    PointerInputScope $this$forEachGesture = (PointerInputScope) this.L$0;
                    this.label = 1;
                    if (CoroutineScopeKt.coroutineScope(new AnonymousClass1($this$forEachGesture, this.$onExpandedChange, null), this) != coroutine_suspended) {
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
                PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                this.label = 1;
                if (ForEachGestureKt.forEachGesture($this$pointerInput, new C03241(this.$onExpandedChange, null), this) != coroutine_suspended) {
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
