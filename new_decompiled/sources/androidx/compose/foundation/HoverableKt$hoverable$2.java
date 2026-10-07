package androidx.compose.foundation;

import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerEventType;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* compiled from: Hoverable.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, m287d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class HoverableKt$hoverable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HoverableKt$hoverable$2(MutableInteractionSource mutableInteractionSource, boolean z) {
        super(3);
        this.$interactionSource = mutableInteractionSource;
        this.$enabled = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x017c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
        Object value$iv$iv$iv;
        Object value$iv$iv;
        Object value$iv$iv2;
        HoverableKt$hoverable$2$2$1 value$iv$iv3;
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        $composer.startReplaceableGroup(1294013553);
        ComposerKt.sourceInformation($composer, "C55@2170L24,56@2223L58,82@3026L43,82@2990L79,85@3098L64,85@3074L88:Hoverable.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1294013553, $changed, -1, "androidx.compose.foundation.hoverable.<anonymous> (Hoverable.kt:54)");
        }
        $composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation($composer, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv$iv = $composer.rememberedValue();
        if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
            $composer.updateRememberedValue(value$iv$iv$iv);
        } else {
            value$iv$iv$iv = it$iv$iv$iv;
        }
        $composer.endReplaceableGroup();
        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
        CoroutineScope scope = wrapper$iv.getCoroutineScope();
        $composer.endReplaceableGroup();
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        final MutableState hoverInteraction$delegate = (MutableState) value$iv$iv;
        MutableInteractionSource mutableInteractionSource = this.$interactionSource;
        Object key2$iv = this.$interactionSource;
        final MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(hoverInteraction$delegate) | $composer.changed(key2$iv);
        Object it$iv$iv2 = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.HoverableKt$hoverable$2$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    final MutableState<HoverInteraction.Enter> mutableState = hoverInteraction$delegate;
                    final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.HoverableKt$hoverable$2$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            HoverableKt$hoverable$2.invoke$tryEmitExit(MutableState.this, mutableInteractionSource3);
                        }
                    };
                }
            };
            $composer.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(mutableInteractionSource, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv$iv2, $composer, 0);
        Boolean valueOf = Boolean.valueOf(this.$enabled);
        Object key1$iv = Boolean.valueOf(this.$enabled);
        Object key3$iv = this.$interactionSource;
        boolean z = this.$enabled;
        MutableInteractionSource mutableInteractionSource3 = this.$interactionSource;
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = $composer.changed(key1$iv) | $composer.changed(hoverInteraction$delegate) | $composer.changed(key3$iv);
        Object it$iv$iv3 = $composer.rememberedValue();
        if (!invalid$iv$iv2) {
            Object key1$iv2 = Composer.INSTANCE.getEmpty();
            if (it$iv$iv3 != key1$iv2) {
                value$iv$iv3 = it$iv$iv3;
                $composer.endReplaceableGroup();
                EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv3, $composer, 64);
                Modifier.Companion pointerInput = !this.$enabled ? SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, this.$interactionSource, new C00813(scope, this.$interactionSource, hoverInteraction$delegate, null)) : Modifier.INSTANCE;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return pointerInput;
            }
        }
        value$iv$iv3 = new HoverableKt$hoverable$2$2$1(z, hoverInteraction$delegate, mutableInteractionSource3, null);
        $composer.updateRememberedValue(value$iv$iv3);
        $composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv3, $composer, 64);
        if (!this.$enabled) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        $composer.endReplaceableGroup();
        return pointerInput;
    }

    /* renamed from: invoke$lambda-1, reason: not valid java name */
    private static final HoverInteraction.Enter m541invoke$lambda1(MutableState<HoverInteraction.Enter> mutableState) {
        MutableState<HoverInteraction.Enter> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object invoke$emitEnter(MutableInteractionSource $interactionSource, MutableState<HoverInteraction.Enter> mutableState, Continuation<? super Unit> continuation) {
        HoverableKt$hoverable$2$invoke$emitEnter$1 hoverableKt$hoverable$2$invoke$emitEnter$1;
        HoverableKt$hoverable$2$invoke$emitEnter$1 hoverableKt$hoverable$2$invoke$emitEnter$12;
        HoverInteraction.Enter interaction;
        if (continuation instanceof HoverableKt$hoverable$2$invoke$emitEnter$1) {
            hoverableKt$hoverable$2$invoke$emitEnter$1 = (HoverableKt$hoverable$2$invoke$emitEnter$1) continuation;
            if ((hoverableKt$hoverable$2$invoke$emitEnter$1.label & Integer.MIN_VALUE) != 0) {
                hoverableKt$hoverable$2$invoke$emitEnter$1.label -= Integer.MIN_VALUE;
                hoverableKt$hoverable$2$invoke$emitEnter$12 = hoverableKt$hoverable$2$invoke$emitEnter$1;
                Object $result = hoverableKt$hoverable$2$invoke$emitEnter$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (hoverableKt$hoverable$2$invoke$emitEnter$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (m541invoke$lambda1(mutableState) == null) {
                            HoverInteraction.Enter interaction2 = new HoverInteraction.Enter();
                            hoverableKt$hoverable$2$invoke$emitEnter$12.L$0 = mutableState;
                            hoverableKt$hoverable$2$invoke$emitEnter$12.L$1 = interaction2;
                            hoverableKt$hoverable$2$invoke$emitEnter$12.label = 1;
                            if ($interactionSource.emit(interaction2, hoverableKt$hoverable$2$invoke$emitEnter$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            interaction = interaction2;
                            mutableState.setValue(interaction);
                        }
                        return Unit.INSTANCE;
                    case 1:
                        interaction = (HoverInteraction.Enter) hoverableKt$hoverable$2$invoke$emitEnter$12.L$1;
                        mutableState = (MutableState) hoverableKt$hoverable$2$invoke$emitEnter$12.L$0;
                        ResultKt.throwOnFailure($result);
                        mutableState.setValue(interaction);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        hoverableKt$hoverable$2$invoke$emitEnter$1 = new HoverableKt$hoverable$2$invoke$emitEnter$1(continuation);
        hoverableKt$hoverable$2$invoke$emitEnter$12 = hoverableKt$hoverable$2$invoke$emitEnter$1;
        Object $result2 = hoverableKt$hoverable$2$invoke$emitEnter$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (hoverableKt$hoverable$2$invoke$emitEnter$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object invoke$emitExit(MutableState<HoverInteraction.Enter> mutableState, MutableInteractionSource $interactionSource, Continuation<? super Unit> continuation) {
        HoverableKt$hoverable$2$invoke$emitExit$1 hoverableKt$hoverable$2$invoke$emitExit$1;
        HoverableKt$hoverable$2$invoke$emitExit$1 hoverableKt$hoverable$2$invoke$emitExit$12;
        MutableState hoverInteraction$delegate;
        if (continuation instanceof HoverableKt$hoverable$2$invoke$emitExit$1) {
            hoverableKt$hoverable$2$invoke$emitExit$1 = (HoverableKt$hoverable$2$invoke$emitExit$1) continuation;
            if ((hoverableKt$hoverable$2$invoke$emitExit$1.label & Integer.MIN_VALUE) != 0) {
                hoverableKt$hoverable$2$invoke$emitExit$1.label -= Integer.MIN_VALUE;
                hoverableKt$hoverable$2$invoke$emitExit$12 = hoverableKt$hoverable$2$invoke$emitExit$1;
                Object $result = hoverableKt$hoverable$2$invoke$emitExit$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (hoverableKt$hoverable$2$invoke$emitExit$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        HoverInteraction.Enter oldValue = m541invoke$lambda1(mutableState);
                        if (oldValue != null) {
                            HoverInteraction.Exit interaction = new HoverInteraction.Exit(oldValue);
                            hoverableKt$hoverable$2$invoke$emitExit$12.L$0 = mutableState;
                            hoverableKt$hoverable$2$invoke$emitExit$12.label = 1;
                            if ($interactionSource.emit(interaction, hoverableKt$hoverable$2$invoke$emitExit$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            hoverInteraction$delegate = mutableState;
                            hoverInteraction$delegate.setValue(null);
                        }
                        return Unit.INSTANCE;
                    case 1:
                        hoverInteraction$delegate = (MutableState) hoverableKt$hoverable$2$invoke$emitExit$12.L$0;
                        ResultKt.throwOnFailure($result);
                        hoverInteraction$delegate.setValue(null);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        hoverableKt$hoverable$2$invoke$emitExit$1 = new HoverableKt$hoverable$2$invoke$emitExit$1(continuation);
        hoverableKt$hoverable$2$invoke$emitExit$12 = hoverableKt$hoverable$2$invoke$emitExit$1;
        Object $result2 = hoverableKt$hoverable$2$invoke$emitExit$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (hoverableKt$hoverable$2$invoke$emitExit$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$tryEmitExit(MutableState<HoverInteraction.Enter> mutableState, MutableInteractionSource $interactionSource) {
        HoverInteraction.Enter oldValue = m541invoke$lambda1(mutableState);
        if (oldValue != null) {
            HoverInteraction.Exit interaction = new HoverInteraction.Exit(oldValue);
            $interactionSource.tryEmit(interaction);
            mutableState.setValue(null);
        }
    }

    /* compiled from: Hoverable.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.compose.foundation.HoverableKt$hoverable$2$3", m297f = "Hoverable.kt", m298i = {}, m299l = {102}, m300m = "invokeSuspend", m301n = {}, m302s = {})
    /* renamed from: androidx.compose.foundation.HoverableKt$hoverable$2$3 */
    static final class C00813 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<HoverInteraction.Enter> $hoverInteraction$delegate;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ CoroutineScope $scope;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00813(CoroutineScope coroutineScope, MutableInteractionSource mutableInteractionSource, MutableState<HoverInteraction.Enter> mutableState, Continuation<? super C00813> continuation) {
            super(2, continuation);
            this.$scope = coroutineScope;
            this.$interactionSource = mutableInteractionSource;
            this.$hoverInteraction$delegate = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00813 c00813 = new C00813(this.$scope, this.$interactionSource, this.$hoverInteraction$delegate, continuation);
            c00813.L$0 = obj;
            return c00813;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C00813) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: Hoverable.kt */
        @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
        @DebugMetadata(m296c = "androidx.compose.foundation.HoverableKt$hoverable$2$3$1", m297f = "Hoverable.kt", m298i = {0}, m299l = {104}, m300m = "invokeSuspend", m301n = {"$this$awaitPointerEventScope"}, m302s = {"L$0"})
        /* renamed from: androidx.compose.foundation.HoverableKt$hoverable$2$3$1, reason: invalid class name */
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineContext $currentContext;
            final /* synthetic */ MutableState<HoverInteraction.Enter> $hoverInteraction$delegate;
            final /* synthetic */ MutableInteractionSource $interactionSource;
            final /* synthetic */ CoroutineScope $scope;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(CoroutineContext coroutineContext, CoroutineScope coroutineScope, MutableInteractionSource mutableInteractionSource, MutableState<HoverInteraction.Enter> mutableState, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$currentContext = coroutineContext;
                this.$scope = coroutineScope;
                this.$interactionSource = mutableInteractionSource;
                this.$hoverInteraction$delegate = mutableState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentContext, this.$scope, this.$interactionSource, this.$hoverInteraction$delegate, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* compiled from: Hoverable.kt */
            @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            @DebugMetadata(m296c = "androidx.compose.foundation.HoverableKt$hoverable$2$3$1$1", m297f = "Hoverable.kt", m298i = {}, m299l = {106}, m300m = "invokeSuspend", m301n = {}, m302s = {})
            /* renamed from: androidx.compose.foundation.HoverableKt$hoverable$2$3$1$1, reason: invalid class name and collision with other inner class name */
            static final class C16691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ MutableState<HoverInteraction.Enter> $hoverInteraction$delegate;
                final /* synthetic */ MutableInteractionSource $interactionSource;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C16691(MutableInteractionSource mutableInteractionSource, MutableState<HoverInteraction.Enter> mutableState, Continuation<? super C16691> continuation) {
                    super(2, continuation);
                    this.$interactionSource = mutableInteractionSource;
                    this.$hoverInteraction$delegate = mutableState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C16691(this.$interactionSource, this.$hoverInteraction$delegate, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C16691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            this.label = 1;
                            if (HoverableKt$hoverable$2.invoke$emitEnter(this.$interactionSource, this.$hoverInteraction$delegate, this) != coroutine_suspended) {
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

            /* compiled from: Hoverable.kt */
            @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            @DebugMetadata(m296c = "androidx.compose.foundation.HoverableKt$hoverable$2$3$1$2", m297f = "Hoverable.kt", m298i = {}, m299l = {107}, m300m = "invokeSuspend", m301n = {}, m302s = {})
            /* renamed from: androidx.compose.foundation.HoverableKt$hoverable$2$3$1$2, reason: invalid class name */
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ MutableState<HoverInteraction.Enter> $hoverInteraction$delegate;
                final /* synthetic */ MutableInteractionSource $interactionSource;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(MutableState<HoverInteraction.Enter> mutableState, MutableInteractionSource mutableInteractionSource, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$hoverInteraction$delegate = mutableState;
                    this.$interactionSource = mutableInteractionSource;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.$hoverInteraction$delegate, this.$interactionSource, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            this.label = 1;
                            if (HoverableKt$hoverable$2.invoke$emitExit(this.$hoverInteraction$delegate, this.$interactionSource, this) != coroutine_suspended) {
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

            /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0093  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
            /* JADX WARN: Removed duplicated region for block: B:9:0x0057  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x003f -> B:7:0x0045). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object $result) {
                AnonymousClass1 anonymousClass1;
                AwaitPointerEventScope $this$awaitPointerEventScope;
                Object $result2;
                AwaitPointerEventScope $this$awaitPointerEventScope2;
                AnonymousClass1 anonymousClass12;
                Object obj;
                int type;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        anonymousClass1 = this;
                        $this$awaitPointerEventScope = (AwaitPointerEventScope) anonymousClass1.L$0;
                        if (JobKt.isActive(anonymousClass1.$currentContext)) {
                            anonymousClass1.L$0 = $this$awaitPointerEventScope;
                            anonymousClass1.label = 1;
                            Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerEventScope, null, anonymousClass1, 1, null);
                            if (awaitPointerEvent$default == $result3) {
                                return $result3;
                            }
                            Object obj2 = $result3;
                            $result2 = $result;
                            $result = awaitPointerEvent$default;
                            $this$awaitPointerEventScope2 = $this$awaitPointerEventScope;
                            anonymousClass12 = anonymousClass1;
                            obj = obj2;
                            PointerEvent event = (PointerEvent) $result;
                            type = event.getType();
                            if (PointerEventType.m3316equalsimpl0(type, PointerEventType.INSTANCE.m3320getEnter7fucELk())) {
                                BuildersKt__Builders_commonKt.launch$default(anonymousClass12.$scope, null, null, new C16691(anonymousClass12.$interactionSource, anonymousClass12.$hoverInteraction$delegate, null), 3, null);
                            } else if (PointerEventType.m3316equalsimpl0(type, PointerEventType.INSTANCE.m3321getExit7fucELk())) {
                                BuildersKt__Builders_commonKt.launch$default(anonymousClass12.$scope, null, null, new AnonymousClass2(anonymousClass12.$hoverInteraction$delegate, anonymousClass12.$interactionSource, null), 3, null);
                            }
                            $result = $result2;
                            $result3 = obj;
                            anonymousClass1 = anonymousClass12;
                            $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                            if (JobKt.isActive(anonymousClass1.$currentContext)) {
                                return Unit.INSTANCE;
                            }
                        }
                    case 1:
                        AwaitPointerEventScope $this$awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure($result);
                        $this$awaitPointerEventScope2 = $this$awaitPointerEventScope3;
                        anonymousClass12 = this;
                        obj = $result3;
                        $result2 = $result;
                        PointerEvent event2 = (PointerEvent) $result;
                        type = event2.getType();
                        if (PointerEventType.m3316equalsimpl0(type, PointerEventType.INSTANCE.m3320getEnter7fucELk())) {
                        }
                        $result = $result2;
                        $result3 = obj;
                        anonymousClass1 = anonymousClass12;
                        $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                        if (JobKt.isActive(anonymousClass1.$currentContext)) {
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
                    CoroutineContext currentContext = getContext();
                    this.label = 1;
                    if ($this$pointerInput.awaitPointerEventScope(new AnonymousClass1(currentContext, this.$scope, this.$interactionSource, this.$hoverInteraction$delegate, null), this) != coroutine_suspended) {
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
