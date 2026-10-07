package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerEventPass;
import androidx.compose.p000ui.input.pointer.PointerId;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: AndroidOverscroll.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1", m297f = "AndroidOverscroll.kt", m298i = {}, m299l = {322}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes.dex */
final class AndroidEdgeEffectOverscrollEffect$effectModifier$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidEdgeEffectOverscrollEffect$effectModifier$1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Continuation<? super AndroidEdgeEffectOverscrollEffect$effectModifier$1> continuation) {
        super(2, continuation);
        this.this$0 = androidEdgeEffectOverscrollEffect;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidEdgeEffectOverscrollEffect$effectModifier$1 androidEdgeEffectOverscrollEffect$effectModifier$1 = new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this.this$0, continuation);
        androidEdgeEffectOverscrollEffect$effectModifier$1.L$0 = obj;
        return androidEdgeEffectOverscrollEffect$effectModifier$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((AndroidEdgeEffectOverscrollEffect$effectModifier$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: AndroidOverscroll.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1$1", m297f = "AndroidOverscroll.kt", m298i = {}, m299l = {323}, m300m = "invokeSuspend", m301n = {}, m302s = {})
    /* renamed from: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1$1 */
    static final class C00571 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00571(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Continuation<? super C00571> continuation) {
            super(2, continuation);
            this.this$0 = androidEdgeEffectOverscrollEffect;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00571 c00571 = new C00571(this.this$0, continuation);
            c00571.L$0 = obj;
            return c00571;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C00571) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: AndroidOverscroll.kt */
        @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
        @DebugMetadata(m296c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1$1$1", m297f = "AndroidOverscroll.kt", m298i = {0, 1}, m299l = {324, 328}, m300m = "invokeSuspend", m301n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, m302s = {"L$0", "L$0"})
        /* renamed from: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1$1$1, reason: invalid class name */
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = androidEdgeEffectOverscrollEffect;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x00d0  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x00fd  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0107  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x012b  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0134  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x007f A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:36:0x0080  */
            /* JADX WARN: Removed duplicated region for block: B:37:0x00f5 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:9:0x00a1  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0080 -> B:7:0x0086). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object $result) {
                AnonymousClass1 anonymousClass1;
                Object $result2;
                Object $result3;
                AwaitPointerEventScope $this$awaitPointerEventScope;
                Object awaitPointerEvent$default;
                Object $result4;
                Object $result5;
                AwaitPointerEventScope $this$awaitPointerEventScope2;
                int index$iv$iv;
                int size;
                List pressedChanges;
                int index$iv$iv2;
                int size2;
                Object obj;
                Object it$iv;
                PointerInputChange pointerInputChange;
                PointerInputChange change;
                PointerId pointerId;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                PointerEventPass pointerEventPass = null;
                int i = 1;
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        anonymousClass1 = this;
                        AwaitPointerEventScope $this$awaitPointerEventScope3 = (AwaitPointerEventScope) anonymousClass1.L$0;
                        anonymousClass1.L$0 = $this$awaitPointerEventScope3;
                        anonymousClass1.label = 1;
                        Object awaitFirstDown = TapGestureDetectorKt.awaitFirstDown($this$awaitPointerEventScope3, false, anonymousClass1);
                        if (awaitFirstDown == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result2 = $result;
                        $result3 = awaitFirstDown;
                        $this$awaitPointerEventScope = $this$awaitPointerEventScope3;
                        PointerInputChange down = (PointerInputChange) $result3;
                        anonymousClass1.this$0.pointerId = PointerId.m3346boximpl(down.getId());
                        anonymousClass1.this$0.pointerPosition = Offset.m1749boximpl(down.getPosition());
                        Object $result6 = $result2;
                        AwaitPointerEventScope $this$awaitPointerEventScope4 = $this$awaitPointerEventScope;
                        anonymousClass1.L$0 = $this$awaitPointerEventScope4;
                        anonymousClass1.label = 2;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerEventScope4, pointerEventPass, anonymousClass1, i, pointerEventPass);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        AwaitPointerEventScope awaitPointerEventScope = $this$awaitPointerEventScope4;
                        $result4 = $result6;
                        $result5 = awaitPointerEvent$default;
                        $this$awaitPointerEventScope2 = awaitPointerEventScope;
                        List $this$fastFilter$iv = ((PointerEvent) $result5).getChanges();
                        List target$iv = new ArrayList($this$fastFilter$iv.size());
                        size = $this$fastFilter$iv.size();
                        for (index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                            PointerInputChange pointerInputChange2 = $this$fastFilter$iv.get(index$iv$iv);
                            PointerInputChange it = pointerInputChange2;
                            if (it.getPressed()) {
                                target$iv.add(pointerInputChange2);
                            }
                        }
                        pressedChanges = target$iv;
                        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = anonymousClass1.this$0;
                        index$iv$iv2 = 0;
                        size2 = pressedChanges.size();
                        while (true) {
                            if (index$iv$iv2 >= size2) {
                                Object item$iv$iv = pressedChanges.get(index$iv$iv2);
                                it$iv = item$iv$iv;
                                PointerInputChange it2 = (PointerInputChange) it$iv;
                                long id = it2.getId();
                                obj = coroutine_suspended;
                                pointerId = androidEdgeEffectOverscrollEffect.pointerId;
                                if (!PointerId.m3348equalsimpl(id, pointerId)) {
                                    index$iv$iv2++;
                                    coroutine_suspended = obj;
                                }
                            } else {
                                obj = coroutine_suspended;
                                it$iv = null;
                            }
                        }
                        pointerInputChange = (PointerInputChange) it$iv;
                        if (pointerInputChange == null) {
                            pointerInputChange = (PointerInputChange) CollectionsKt.firstOrNull(pressedChanges);
                        }
                        change = pointerInputChange;
                        if (change != null) {
                            anonymousClass1.this$0.pointerId = PointerId.m3346boximpl(change.getId());
                            anonymousClass1.this$0.pointerPosition = Offset.m1749boximpl(change.getPosition());
                        }
                        if (!pressedChanges.isEmpty()) {
                            anonymousClass1.this$0.pointerId = null;
                            return Unit.INSTANCE;
                        }
                        pointerEventPass = null;
                        coroutine_suspended = obj;
                        $result6 = $result4;
                        $this$awaitPointerEventScope4 = $this$awaitPointerEventScope2;
                        i = 1;
                        anonymousClass1.L$0 = $this$awaitPointerEventScope4;
                        anonymousClass1.label = 2;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerEventScope4, pointerEventPass, anonymousClass1, i, pointerEventPass);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                        }
                    case 1:
                        anonymousClass1 = this;
                        $result3 = $result;
                        AwaitPointerEventScope $this$awaitPointerEventScope5 = (AwaitPointerEventScope) anonymousClass1.L$0;
                        ResultKt.throwOnFailure($result3);
                        $this$awaitPointerEventScope = $this$awaitPointerEventScope5;
                        $result2 = $result3;
                        PointerInputChange down2 = (PointerInputChange) $result3;
                        anonymousClass1.this$0.pointerId = PointerId.m3346boximpl(down2.getId());
                        anonymousClass1.this$0.pointerPosition = Offset.m1749boximpl(down2.getPosition());
                        Object $result62 = $result2;
                        AwaitPointerEventScope $this$awaitPointerEventScope42 = $this$awaitPointerEventScope;
                        anonymousClass1.L$0 = $this$awaitPointerEventScope42;
                        anonymousClass1.label = 2;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerEventScope42, pointerEventPass, anonymousClass1, i, pointerEventPass);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                        }
                        break;
                    case 2:
                        anonymousClass1 = this;
                        $result5 = $result;
                        AwaitPointerEventScope $this$awaitPointerEventScope6 = (AwaitPointerEventScope) anonymousClass1.L$0;
                        ResultKt.throwOnFailure($result5);
                        $this$awaitPointerEventScope2 = $this$awaitPointerEventScope6;
                        $result4 = $result5;
                        List $this$fastFilter$iv2 = ((PointerEvent) $result5).getChanges();
                        List target$iv2 = new ArrayList($this$fastFilter$iv2.size());
                        size = $this$fastFilter$iv2.size();
                        while (index$iv$iv < size) {
                        }
                        pressedChanges = target$iv2;
                        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect2 = anonymousClass1.this$0;
                        index$iv$iv2 = 0;
                        size2 = pressedChanges.size();
                        while (true) {
                            if (index$iv$iv2 >= size2) {
                            }
                            index$iv$iv2++;
                            coroutine_suspended = obj;
                        }
                        pointerInputChange = (PointerInputChange) it$iv;
                        if (pointerInputChange == null) {
                        }
                        change = pointerInputChange;
                        if (change != null) {
                        }
                        if (!pressedChanges.isEmpty()) {
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
                    if ($this$forEachGesture.awaitPointerEventScope(new AnonymousClass1(this.this$0, null), this) != coroutine_suspended) {
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
                if (ForEachGestureKt.forEachGesture($this$pointerInput, new C00571(this.this$0, null), this) != coroutine_suspended) {
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
