package androidx.compose.foundation.gestures;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.time.DurationKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TapGestureDetector.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2", m297f = "TapGestureDetector.kt", m298i = {}, m299l = {99}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes.dex */
final class TapGestureDetectorKt$detectTapGestures$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
    final /* synthetic */ Function1<Offset, Unit> $onLongPress;
    final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
    final /* synthetic */ Function1<Offset, Unit> $onTap;
    final /* synthetic */ PointerInputScope $this_detectTapGestures;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TapGestureDetectorKt$detectTapGestures$2(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function1<? super Offset, Unit> function13, Continuation<? super TapGestureDetectorKt$detectTapGestures$2> continuation) {
        super(2, continuation);
        this.$this_detectTapGestures = pointerInputScope;
        this.$onPress = function3;
        this.$onLongPress = function1;
        this.$onDoubleTap = function12;
        this.$onTap = function13;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TapGestureDetectorKt$detectTapGestures$2 tapGestureDetectorKt$detectTapGestures$2 = new TapGestureDetectorKt$detectTapGestures$2(this.$this_detectTapGestures, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, continuation);
        tapGestureDetectorKt$detectTapGestures$2.L$0 = obj;
        return tapGestureDetectorKt$detectTapGestures$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TapGestureDetectorKt$detectTapGestures$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                PressGestureScopeImpl pressScope = new PressGestureScopeImpl(this.$this_detectTapGestures);
                this.label = 1;
                if (ForEachGestureKt.forEachGesture(this.$this_detectTapGestures, new C01021(pressScope, this.$onPress, $this$coroutineScope, this.$onLongPress, this.$onDoubleTap, this.$onTap, null), this) != coroutine_suspended) {
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

    /* compiled from: TapGestureDetector.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1", m297f = "TapGestureDetector.kt", m298i = {}, m299l = {100}, m300m = "invokeSuspend", m301n = {}, m302s = {})
    /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1 */
    static final class C01021 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$coroutineScope;
        final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
        final /* synthetic */ Function1<Offset, Unit> $onLongPress;
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ Function1<Offset, Unit> $onTap;
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01021(PressGestureScopeImpl pressGestureScopeImpl, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, CoroutineScope coroutineScope, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function1<? super Offset, Unit> function13, Continuation<? super C01021> continuation) {
            super(2, continuation);
            this.$pressScope = pressGestureScopeImpl;
            this.$onPress = function3;
            this.$$this$coroutineScope = coroutineScope;
            this.$onLongPress = function1;
            this.$onDoubleTap = function12;
            this.$onTap = function13;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01021 c01021 = new C01021(this.$pressScope, this.$onPress, this.$$this$coroutineScope, this.$onLongPress, this.$onDoubleTap, this.$onTap, continuation);
            c01021.L$0 = obj;
            return c01021;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C01021) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: TapGestureDetector.kt */
        @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
        @DebugMetadata(m296c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1", m297f = "TapGestureDetector.kt", m298i = {0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}, m299l = {101, 113, 124, 134, 147, 165}, m300m = "invokeSuspend", m301n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "down", "upOrCancel", "longPressTimeout", "$this$awaitPointerEventScope", "upOrCancel", "longPressTimeout", "$this$awaitPointerEventScope", "upOrCancel", "longPressTimeout", "$this$awaitPointerEventScope", "upOrCancel", "secondDown"}, m302s = {"L$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2"})
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1, reason: invalid class name */
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
            final /* synthetic */ Function1<Offset, Unit> $onLongPress;
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ Function1<Offset, Unit> $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            long J$0;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(PressGestureScopeImpl pressGestureScopeImpl, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, CoroutineScope coroutineScope, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function1<? super Offset, Unit> function13, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
                this.$onPress = function3;
                this.$$this$coroutineScope = coroutineScope;
                this.$onLongPress = function1;
                this.$onDoubleTap = function12;
                this.$onTap = function13;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$pressScope, this.$onPress, this.$$this$coroutineScope, this.$onLongPress, this.$onDoubleTap, this.$onTap, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:101:0x00f7  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x024c  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0260  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x027f A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0280  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x01ce  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x01e6  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x018b  */
            /* JADX WARN: Removed duplicated region for block: B:71:0x012e A[Catch: PointerEventTimeoutCancellationException -> 0x0143, TryCatch #3 {PointerEventTimeoutCancellationException -> 0x0143, blocks: (B:69:0x0128, B:71:0x012e, B:73:0x0134), top: B:68:0x0128 }] */
            /* JADX WARN: Removed duplicated region for block: B:73:0x0134 A[Catch: PointerEventTimeoutCancellationException -> 0x0143, TRY_LEAVE, TryCatch #3 {PointerEventTimeoutCancellationException -> 0x0143, blocks: (B:69:0x0128, B:71:0x012e, B:73:0x0134), top: B:68:0x0128 }] */
            /* JADX WARN: Removed duplicated region for block: B:78:0x0158  */
            /* JADX WARN: Removed duplicated region for block: B:81:0x017a A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:88:0x00d3  */
            /* JADX WARN: Removed duplicated region for block: B:91:0x00ed  */
            /* JADX WARN: Removed duplicated region for block: B:96:0x0121 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:97:0x0122  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                AwaitPointerEventScope awaitPointerEventScope;
                AnonymousClass1 anonymousClass1;
                Object obj2;
                Object obj3;
                PointerInputChange pointerInputChange;
                Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3;
                Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function32;
                long longPressTimeoutMillis;
                Ref.ObjectRef objectRef;
                AnonymousClass1 anonymousClass12;
                Ref.ObjectRef objectRef2;
                Object obj4;
                long j;
                AwaitPointerEventScope awaitPointerEventScope2;
                Object withTimeout;
                AwaitPointerEventScope awaitPointerEventScope3;
                PointerInputChange pointerInputChange2;
                Ref.ObjectRef objectRef3;
                AnonymousClass1 anonymousClass13;
                T t;
                Ref.ObjectRef objectRef4;
                Function1<Offset, Unit> function1;
                Object consumeUntilUp;
                Object obj5;
                Object awaitSecondDown;
                Object obj6;
                Ref.ObjectRef objectRef5;
                AwaitPointerEventScope awaitPointerEventScope4;
                AnonymousClass1 anonymousClass14;
                Object obj7;
                long j2;
                PointerInputChange pointerInputChange3;
                Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function33;
                AwaitPointerEventScope awaitPointerEventScope5;
                PointerInputChange pointerInputChange4;
                AnonymousClass1 anonymousClass15;
                Ref.ObjectRef objectRef6;
                Object obj8;
                Function1<Offset, Unit> function12;
                Function1<Offset, Unit> function13;
                Object consumeUntilUp2;
                Object obj9;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        AwaitPointerEventScope awaitPointerEventScope6 = (AwaitPointerEventScope) this.L$0;
                        this.L$0 = awaitPointerEventScope6;
                        this.label = 1;
                        Object awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope6, false, this, 1, null);
                        if (awaitFirstDown$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        awaitPointerEventScope = awaitPointerEventScope6;
                        anonymousClass1 = this;
                        obj2 = obj;
                        obj3 = awaitFirstDown$default;
                        pointerInputChange = (PointerInputChange) obj3;
                        pointerInputChange.consume();
                        anonymousClass1.$pressScope.reset();
                        function3 = anonymousClass1.$onPress;
                        function32 = TapGestureDetectorKt.NoPressGesture;
                        if (function3 != function32) {
                            BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, null, new C16721(anonymousClass1.$onPress, anonymousClass1.$pressScope, pointerInputChange, null), 3, null);
                        }
                        longPressTimeoutMillis = anonymousClass1.$onLongPress == null ? awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis() : DurationKt.MAX_MILLIS;
                        objectRef = new Ref.ObjectRef();
                        try {
                            anonymousClass1.L$0 = awaitPointerEventScope;
                            anonymousClass1.L$1 = pointerInputChange;
                            anonymousClass1.L$2 = objectRef;
                            anonymousClass1.L$3 = objectRef;
                            anonymousClass1.J$0 = longPressTimeoutMillis;
                            anonymousClass1.label = 2;
                            withTimeout = awaitPointerEventScope.withTimeout(longPressTimeoutMillis, new AnonymousClass2(null), anonymousClass1);
                        } catch (PointerEventTimeoutCancellationException e) {
                            anonymousClass12 = anonymousClass1;
                            long j3 = longPressTimeoutMillis;
                            objectRef2 = objectRef;
                            obj4 = obj2;
                            j = j3;
                            awaitPointerEventScope2 = awaitPointerEventScope;
                            function1 = anonymousClass12.$onLongPress;
                            if (function1 != null) {
                                function1.invoke(Offset.m1749boximpl(pointerInputChange.getPosition()));
                            }
                            anonymousClass12.L$0 = awaitPointerEventScope2;
                            anonymousClass12.L$1 = objectRef2;
                            anonymousClass12.L$2 = null;
                            anonymousClass12.L$3 = null;
                            anonymousClass12.J$0 = j;
                            anonymousClass12.label = 3;
                            consumeUntilUp = TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope2, anonymousClass12);
                            if (consumeUntilUp == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            anonymousClass12.$pressScope.release();
                            objectRef3 = objectRef2;
                            awaitPointerEventScope3 = awaitPointerEventScope2;
                            Object obj10 = obj4;
                            anonymousClass13 = anonymousClass12;
                            obj5 = obj10;
                            if (objectRef3.element != 0) {
                            }
                            return Unit.INSTANCE;
                        }
                        if (withTimeout != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        awaitPointerEventScope3 = awaitPointerEventScope;
                        pointerInputChange2 = pointerInputChange;
                        objectRef3 = objectRef;
                        anonymousClass13 = anonymousClass1;
                        t = withTimeout;
                        objectRef4 = objectRef3;
                        try {
                            objectRef4.element = t;
                            if (objectRef3.element != 0) {
                                anonymousClass13.$pressScope.cancel();
                            } else {
                                ((PointerInputChange) objectRef3.element).consume();
                                anonymousClass13.$pressScope.release();
                            }
                            obj5 = obj2;
                            j = longPressTimeoutMillis;
                        } catch (PointerEventTimeoutCancellationException e2) {
                            anonymousClass12 = anonymousClass13;
                            obj4 = obj2;
                            j = longPressTimeoutMillis;
                            objectRef2 = objectRef3;
                            pointerInputChange = pointerInputChange2;
                            awaitPointerEventScope2 = awaitPointerEventScope3;
                            function1 = anonymousClass12.$onLongPress;
                            if (function1 != null) {
                            }
                            anonymousClass12.L$0 = awaitPointerEventScope2;
                            anonymousClass12.L$1 = objectRef2;
                            anonymousClass12.L$2 = null;
                            anonymousClass12.L$3 = null;
                            anonymousClass12.J$0 = j;
                            anonymousClass12.label = 3;
                            consumeUntilUp = TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope2, anonymousClass12);
                            if (consumeUntilUp == coroutine_suspended) {
                            }
                            anonymousClass12.$pressScope.release();
                            objectRef3 = objectRef2;
                            awaitPointerEventScope3 = awaitPointerEventScope2;
                            Object obj102 = obj4;
                            anonymousClass13 = anonymousClass12;
                            obj5 = obj102;
                            if (objectRef3.element != 0) {
                            }
                            return Unit.INSTANCE;
                        }
                        if (objectRef3.element != 0) {
                            if (anonymousClass13.$onDoubleTap == null) {
                                Function1<Offset, Unit> function14 = anonymousClass13.$onTap;
                                if (function14 != null) {
                                    function14.invoke(Offset.m1749boximpl(((PointerInputChange) objectRef3.element).getPosition()));
                                }
                            } else {
                                anonymousClass13.L$0 = awaitPointerEventScope3;
                                anonymousClass13.L$1 = objectRef3;
                                anonymousClass13.L$2 = null;
                                anonymousClass13.L$3 = null;
                                anonymousClass13.J$0 = j;
                                anonymousClass13.label = 4;
                                awaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope3, (PointerInputChange) objectRef3.element, anonymousClass13);
                                if (awaitSecondDown == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj6 = obj5;
                                objectRef5 = objectRef3;
                                awaitPointerEventScope4 = awaitPointerEventScope3;
                                long j4 = j;
                                anonymousClass14 = anonymousClass13;
                                obj7 = awaitSecondDown;
                                j2 = j4;
                                pointerInputChange3 = (PointerInputChange) obj7;
                                if (pointerInputChange3 != null) {
                                    Function1<Offset, Unit> function15 = anonymousClass14.$onTap;
                                    if (function15 != null) {
                                        function15.invoke(Offset.m1749boximpl(((PointerInputChange) objectRef5.element).getPosition()));
                                    }
                                } else {
                                    anonymousClass14.$pressScope.reset();
                                    Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function34 = anonymousClass14.$onPress;
                                    function33 = TapGestureDetectorKt.NoPressGesture;
                                    if (function34 != function33) {
                                        BuildersKt__Builders_commonKt.launch$default(anonymousClass14.$$this$coroutineScope, null, null, new AnonymousClass3(anonymousClass14.$onPress, anonymousClass14.$pressScope, pointerInputChange3, null), 3, null);
                                    }
                                    try {
                                        awaitPointerEventScope5 = awaitPointerEventScope4;
                                    } catch (PointerEventTimeoutCancellationException e3) {
                                        awaitPointerEventScope5 = awaitPointerEventScope4;
                                        pointerInputChange4 = pointerInputChange3;
                                        anonymousClass15 = anonymousClass14;
                                        objectRef6 = objectRef5;
                                    }
                                    try {
                                        anonymousClass14.L$0 = awaitPointerEventScope5;
                                        anonymousClass14.L$1 = objectRef5;
                                        anonymousClass14.L$2 = pointerInputChange3;
                                        anonymousClass14.label = 5;
                                        if (awaitPointerEventScope5.withTimeout(j2, new AnonymousClass4(anonymousClass14.$pressScope, anonymousClass14.$onDoubleTap, anonymousClass14.$onTap, objectRef5, null), anonymousClass14) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        obj8 = obj6;
                                    } catch (PointerEventTimeoutCancellationException e4) {
                                        pointerInputChange4 = pointerInputChange3;
                                        anonymousClass15 = anonymousClass14;
                                        objectRef6 = objectRef5;
                                        function12 = anonymousClass15.$onTap;
                                        if (function12 != null) {
                                        }
                                        function13 = anonymousClass15.$onLongPress;
                                        if (function13 != null) {
                                        }
                                        anonymousClass15.L$0 = null;
                                        anonymousClass15.L$1 = null;
                                        anonymousClass15.L$2 = null;
                                        anonymousClass15.label = 6;
                                        consumeUntilUp2 = TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope5, anonymousClass15);
                                        if (consumeUntilUp2 != coroutine_suspended) {
                                        }
                                    }
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        obj3 = obj;
                        AwaitPointerEventScope awaitPointerEventScope7 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj3);
                        obj2 = obj3;
                        awaitPointerEventScope = awaitPointerEventScope7;
                        anonymousClass1 = this;
                        pointerInputChange = (PointerInputChange) obj3;
                        pointerInputChange.consume();
                        anonymousClass1.$pressScope.reset();
                        function3 = anonymousClass1.$onPress;
                        function32 = TapGestureDetectorKt.NoPressGesture;
                        if (function3 != function32) {
                        }
                        if (anonymousClass1.$onLongPress == null) {
                        }
                        objectRef = new Ref.ObjectRef();
                        anonymousClass1.L$0 = awaitPointerEventScope;
                        anonymousClass1.L$1 = pointerInputChange;
                        anonymousClass1.L$2 = objectRef;
                        anonymousClass1.L$3 = objectRef;
                        anonymousClass1.J$0 = longPressTimeoutMillis;
                        anonymousClass1.label = 2;
                        withTimeout = awaitPointerEventScope.withTimeout(longPressTimeoutMillis, new AnonymousClass2(null), anonymousClass1);
                        if (withTimeout != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        anonymousClass13 = this;
                        Object obj11 = obj;
                        long j5 = anonymousClass13.J$0;
                        objectRef4 = (Ref.ObjectRef) anonymousClass13.L$3;
                        Ref.ObjectRef objectRef7 = (Ref.ObjectRef) anonymousClass13.L$2;
                        pointerInputChange = (PointerInputChange) anonymousClass13.L$1;
                        AwaitPointerEventScope awaitPointerEventScope8 = (AwaitPointerEventScope) anonymousClass13.L$0;
                        try {
                            ResultKt.throwOnFailure(obj11);
                            awaitPointerEventScope3 = awaitPointerEventScope8;
                            pointerInputChange2 = pointerInputChange;
                            objectRef3 = objectRef7;
                            longPressTimeoutMillis = j5;
                            obj2 = obj11;
                            t = obj11;
                            objectRef4.element = t;
                            if (objectRef3.element != 0) {
                            }
                            obj5 = obj2;
                            j = longPressTimeoutMillis;
                        } catch (PointerEventTimeoutCancellationException e5) {
                            anonymousClass12 = anonymousClass13;
                            obj4 = obj11;
                            j = j5;
                            objectRef2 = objectRef7;
                            awaitPointerEventScope2 = awaitPointerEventScope8;
                            function1 = anonymousClass12.$onLongPress;
                            if (function1 != null) {
                            }
                            anonymousClass12.L$0 = awaitPointerEventScope2;
                            anonymousClass12.L$1 = objectRef2;
                            anonymousClass12.L$2 = null;
                            anonymousClass12.L$3 = null;
                            anonymousClass12.J$0 = j;
                            anonymousClass12.label = 3;
                            consumeUntilUp = TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope2, anonymousClass12);
                            if (consumeUntilUp == coroutine_suspended) {
                            }
                            anonymousClass12.$pressScope.release();
                            objectRef3 = objectRef2;
                            awaitPointerEventScope3 = awaitPointerEventScope2;
                            Object obj1022 = obj4;
                            anonymousClass13 = anonymousClass12;
                            obj5 = obj1022;
                            if (objectRef3.element != 0) {
                            }
                            return Unit.INSTANCE;
                        }
                        if (objectRef3.element != 0) {
                        }
                        return Unit.INSTANCE;
                    case 3:
                        anonymousClass12 = this;
                        obj4 = obj;
                        j = anonymousClass12.J$0;
                        objectRef2 = (Ref.ObjectRef) anonymousClass12.L$1;
                        awaitPointerEventScope2 = (AwaitPointerEventScope) anonymousClass12.L$0;
                        ResultKt.throwOnFailure(obj4);
                        anonymousClass12.$pressScope.release();
                        objectRef3 = objectRef2;
                        awaitPointerEventScope3 = awaitPointerEventScope2;
                        Object obj10222 = obj4;
                        anonymousClass13 = anonymousClass12;
                        obj5 = obj10222;
                        if (objectRef3.element != 0) {
                        }
                        return Unit.INSTANCE;
                    case 4:
                        obj7 = obj;
                        long j6 = this.J$0;
                        Ref.ObjectRef objectRef8 = (Ref.ObjectRef) this.L$1;
                        AwaitPointerEventScope awaitPointerEventScope9 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj7);
                        objectRef5 = objectRef8;
                        awaitPointerEventScope4 = awaitPointerEventScope9;
                        obj6 = obj7;
                        j2 = j6;
                        anonymousClass14 = this;
                        pointerInputChange3 = (PointerInputChange) obj7;
                        if (pointerInputChange3 != null) {
                        }
                        break;
                    case 5:
                        obj8 = obj;
                        pointerInputChange4 = (PointerInputChange) this.L$2;
                        objectRef6 = (Ref.ObjectRef) this.L$1;
                        AwaitPointerEventScope awaitPointerEventScope10 = (AwaitPointerEventScope) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj8);
                        } catch (PointerEventTimeoutCancellationException e6) {
                            anonymousClass15 = this;
                            awaitPointerEventScope5 = awaitPointerEventScope10;
                            obj6 = obj8;
                            function12 = anonymousClass15.$onTap;
                            if (function12 != null) {
                                function12.invoke(Offset.m1749boximpl(((PointerInputChange) objectRef6.element).getPosition()));
                            }
                            function13 = anonymousClass15.$onLongPress;
                            if (function13 != null) {
                                function13.invoke(Offset.m1749boximpl(pointerInputChange4.getPosition()));
                            }
                            anonymousClass15.L$0 = null;
                            anonymousClass15.L$1 = null;
                            anonymousClass15.L$2 = null;
                            anonymousClass15.label = 6;
                            consumeUntilUp2 = TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope5, anonymousClass15);
                            if (consumeUntilUp2 != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj9 = obj6;
                            anonymousClass15.$pressScope.release();
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    case 6:
                        anonymousClass15 = this;
                        obj9 = obj;
                        ResultKt.throwOnFailure(obj9);
                        anonymousClass15.$pressScope.release();
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* compiled from: TapGestureDetector.kt */
            @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            @DebugMetadata(m296c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1$1", m297f = "TapGestureDetector.kt", m298i = {}, m299l = {105}, m300m = "invokeSuspend", m301n = {}, m302s = {})
            /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1$1, reason: invalid class name and collision with other inner class name */
            static final class C16721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PointerInputChange $down;
                final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C16721(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super C16721> continuation) {
                    super(2, continuation);
                    this.$onPress = function3;
                    this.$pressScope = pressGestureScopeImpl;
                    this.$down = pointerInputChange;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C16721(this.$onPress, this.$pressScope, this.$down, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C16721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                            PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                            Offset m1749boximpl = Offset.m1749boximpl(this.$down.getPosition());
                            this.label = 1;
                            if (function3.invoke(pressGestureScopeImpl, m1749boximpl, this) != coroutine_suspended) {
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

            /* compiled from: TapGestureDetector.kt */
            @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            @DebugMetadata(m296c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1$2", m297f = "TapGestureDetector.kt", m298i = {}, m299l = {114}, m300m = "invokeSuspend", m301n = {}, m302s = {})
            /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1$2, reason: invalid class name */
            static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
                private /* synthetic */ Object L$0;
                int label;

                AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
                    return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            AwaitPointerEventScope $this$withTimeout = (AwaitPointerEventScope) this.L$0;
                            this.label = 1;
                            Object waitForUpOrCancellation = TapGestureDetectorKt.waitForUpOrCancellation($this$withTimeout, this);
                            return waitForUpOrCancellation == coroutine_suspended ? coroutine_suspended : waitForUpOrCancellation;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            return $result;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }

            /* compiled from: TapGestureDetector.kt */
            @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            @DebugMetadata(m296c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1$3", m297f = "TapGestureDetector.kt", m298i = {}, m299l = {142}, m300m = "invokeSuspend", m301n = {}, m302s = {})
            /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1$3, reason: invalid class name */
            static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                final /* synthetic */ PointerInputChange $secondDown;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass3(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.$onPress = function3;
                    this.$pressScope = pressGestureScopeImpl;
                    this.$secondDown = pointerInputChange;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass3(this.$onPress, this.$pressScope, this.$secondDown, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                            PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                            Offset m1749boximpl = Offset.m1749boximpl(this.$secondDown.getPosition());
                            this.label = 1;
                            if (function3.invoke(pressGestureScopeImpl, m1749boximpl, this) != coroutine_suspended) {
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

            /* compiled from: TapGestureDetector.kt */
            @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            @DebugMetadata(m296c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1$4", m297f = "TapGestureDetector.kt", m298i = {}, m299l = {148}, m300m = "invokeSuspend", m301n = {}, m302s = {})
            /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1$4, reason: invalid class name */
            static final class AnonymousClass4 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
                final /* synthetic */ Function1<Offset, Unit> $onTap;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                final /* synthetic */ Ref.ObjectRef<PointerInputChange> $upOrCancel;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass4(PressGestureScopeImpl pressGestureScopeImpl, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Ref.ObjectRef<PointerInputChange> objectRef, Continuation<? super AnonymousClass4> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                    this.$onDoubleTap = function1;
                    this.$onTap = function12;
                    this.$upOrCancel = objectRef;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$pressScope, this.$onDoubleTap, this.$onTap, this.$upOrCancel, continuation);
                    anonymousClass4.L$0 = obj;
                    return anonymousClass4;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass4) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    AnonymousClass4 anonymousClass4;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            anonymousClass4 = this;
                            AwaitPointerEventScope $this$withTimeout = (AwaitPointerEventScope) anonymousClass4.L$0;
                            anonymousClass4.label = 1;
                            Object waitForUpOrCancellation = TapGestureDetectorKt.waitForUpOrCancellation($this$withTimeout, anonymousClass4);
                            if (waitForUpOrCancellation != coroutine_suspended) {
                                $result = waitForUpOrCancellation;
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        case 1:
                            ResultKt.throwOnFailure($result);
                            anonymousClass4 = this;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    PointerInputChange secondUp = (PointerInputChange) $result;
                    if (secondUp != null) {
                        secondUp.consume();
                        anonymousClass4.$pressScope.release();
                        anonymousClass4.$onDoubleTap.invoke(Offset.m1749boximpl(secondUp.getPosition()));
                        return Unit.INSTANCE;
                    }
                    anonymousClass4.$pressScope.cancel();
                    Function1<Offset, Unit> function1 = anonymousClass4.$onTap;
                    if (function1 == null) {
                        return null;
                    }
                    function1.invoke(Offset.m1749boximpl(anonymousClass4.$upOrCancel.element.getPosition()));
                    return Unit.INSTANCE;
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
                    if ($this$forEachGesture.awaitPointerEventScope(new AnonymousClass1(this.$pressScope, this.$onPress, this.$$this$coroutineScope, this.$onLongPress, this.$onDoubleTap, this.$onTap, null), this) != coroutine_suspended) {
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
}
