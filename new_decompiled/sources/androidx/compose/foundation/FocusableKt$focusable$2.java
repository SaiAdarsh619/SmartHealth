package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.PinnableParent;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.focus.FocusChangedModifierKt;
import androidx.compose.p000ui.focus.FocusModifierKt;
import androidx.compose.p000ui.focus.FocusRequester;
import androidx.compose.p000ui.focus.FocusRequesterModifierKt;
import androidx.compose.p000ui.focus.FocusState;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
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
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: Focusable.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, m287d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class FocusableKt$focusable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FocusableKt$focusable$2(MutableInteractionSource mutableInteractionSource, boolean z) {
        super(3);
        this.$interactionSource = mutableInteractionSource;
        this.$enabled = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
        Object value$iv$iv$iv;
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Object value$iv$iv4;
        Object value$iv$iv5;
        Modifier.Companion companion;
        Modifier.Companion companion2;
        Object value$iv$iv6;
        Modifier onPinnableParentAvailable;
        Object value$iv$iv7;
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        $composer.startReplaceableGroup(1871352361);
        ComposerKt.sourceInformation($composer, "C73@3129L24,74@3183L58,75@3268L50,76@3340L34,77@3400L29,89@4173L37,90@4251L280,90@4215L316,99@4536L390,130@5589L23:Focusable.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1871352361, $changed, -1, "androidx.compose.foundation.focusable.<anonymous> (Focusable.kt:72)");
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
        final CoroutineScope scope = wrapper$iv.getCoroutineScope();
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
        final MutableState focusedInteraction = (MutableState) value$iv$iv;
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv2 = $composer.rememberedValue();
        if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            $composer.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        final MutableState pinnableParent$delegate = (MutableState) value$iv$iv2;
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv3 = $composer.rememberedValue();
        if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            $composer.updateRememberedValue(value$iv$iv3);
        } else {
            value$iv$iv3 = it$iv$iv3;
        }
        $composer.endReplaceableGroup();
        final MutableState isFocused$delegate = (MutableState) value$iv$iv3;
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv4 = $composer.rememberedValue();
        if (it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv4 = new FocusRequester();
            $composer.updateRememberedValue(value$iv$iv4);
        } else {
            value$iv$iv4 = it$iv$iv4;
        }
        $composer.endReplaceableGroup();
        final FocusRequester focusRequester = (FocusRequester) value$iv$iv4;
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv5 = $composer.rememberedValue();
        if (it$iv$iv5 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv5 = BringIntoViewRequesterKt.BringIntoViewRequester();
            $composer.updateRememberedValue(value$iv$iv5);
        } else {
            value$iv$iv5 = it$iv$iv5;
        }
        $composer.endReplaceableGroup();
        final BringIntoViewRequester bringIntoViewRequester = (BringIntoViewRequester) value$iv$iv5;
        MutableInteractionSource mutableInteractionSource = this.$interactionSource;
        Object key2$iv = this.$interactionSource;
        final MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(focusedInteraction) | $composer.changed(key2$iv);
        Object value$iv$iv8 = $composer.rememberedValue();
        if (!invalid$iv$iv && value$iv$iv8 != Composer.INSTANCE.getEmpty()) {
            $composer.endReplaceableGroup();
            EffectsKt.DisposableEffect(mutableInteractionSource, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv$iv8, $composer, 0);
            Boolean valueOf = Boolean.valueOf(this.$enabled);
            final boolean z = this.$enabled;
            final MutableInteractionSource mutableInteractionSource3 = this.$interactionSource;
            EffectsKt.DisposableEffect(valueOf, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.FocusableKt$focusable$2.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    if (!z) {
                        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(focusedInteraction, mutableInteractionSource3, null), 3, null);
                    }
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$2$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                        }
                    };
                }

                /* compiled from: Focusable.kt */
                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                @DebugMetadata(m296c = "androidx.compose.foundation.FocusableKt$focusable$2$2$1", m297f = "Focusable.kt", m298i = {}, m299l = {105}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                /* renamed from: androidx.compose.foundation.FocusableKt$focusable$2$2$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ MutableState<FocusInteraction.Focus> $focusedInteraction;
                    final /* synthetic */ MutableInteractionSource $interactionSource;
                    Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(MutableState<FocusInteraction.Focus> mutableState, MutableInteractionSource mutableInteractionSource, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$focusedInteraction = mutableState;
                        this.$interactionSource = mutableInteractionSource;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$focusedInteraction, this.$interactionSource, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) {
                        MutableState<FocusInteraction.Focus> mutableState;
                        AnonymousClass1 anonymousClass1;
                        MutableState<FocusInteraction.Focus> mutableState2;
                        AnonymousClass1 anonymousClass12;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                FocusInteraction.Focus oldValue = this.$focusedInteraction.getValue();
                                if (oldValue != null) {
                                    MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                                    mutableState = this.$focusedInteraction;
                                    FocusInteraction.Unfocus interaction = new FocusInteraction.Unfocus(oldValue);
                                    if (mutableInteractionSource != null) {
                                        this.L$0 = mutableState;
                                        this.label = 1;
                                        if (mutableInteractionSource.emit(interaction, this) != coroutine_suspended) {
                                            anonymousClass1 = this;
                                            mutableState2 = mutableState;
                                            anonymousClass12 = null;
                                            mutableState = mutableState2;
                                        } else {
                                            return coroutine_suspended;
                                        }
                                    }
                                    mutableState.setValue(null);
                                }
                                return Unit.INSTANCE;
                            case 1:
                                anonymousClass1 = this;
                                anonymousClass12 = null;
                                mutableState2 = (MutableState) anonymousClass1.L$0;
                                ResultKt.throwOnFailure($result);
                                mutableState = mutableState2;
                                mutableState.setValue(null);
                                return Unit.INSTANCE;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
            }, $composer, 0);
            if (this.$enabled) {
                companion = Modifier.INSTANCE;
            } else {
                $composer.startReplaceableGroup(1407541023);
                ComposerKt.sourceInformation($composer, "114@5011L36");
                if (m539invoke$lambda5(isFocused$delegate)) {
                    $composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                    Object it$iv$iv6 = $composer.rememberedValue();
                    if (it$iv$iv6 == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv7 = new FocusedBoundsModifier();
                        $composer.updateRememberedValue(value$iv$iv7);
                    } else {
                        value$iv$iv7 = it$iv$iv6;
                    }
                    $composer.endReplaceableGroup();
                    companion2 = (Modifier) value$iv$iv7;
                } else {
                    companion2 = Modifier.INSTANCE;
                }
                $composer.endReplaceableGroup();
                Modifier focusedChildModifier = companion2;
                Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.FocusableKt$focusable$2.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        SemanticsPropertiesKt.setFocused(semantics, FocusableKt$focusable$2.m539invoke$lambda5(isFocused$delegate));
                        final FocusRequester focusRequester2 = focusRequester;
                        final MutableState<Boolean> mutableState = isFocused$delegate;
                        SemanticsPropertiesKt.requestFocus$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.FocusableKt.focusable.2.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                FocusRequester.this.requestFocus();
                                return Boolean.valueOf(FocusableKt$focusable$2.m539invoke$lambda5(mutableState));
                            }
                        }, 1, null);
                    }
                }, 1, null);
                $composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv2 = $composer.changed(pinnableParent$delegate);
                Object it$iv$iv7 = $composer.rememberedValue();
                if (invalid$iv$iv2 || it$iv$iv7 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv6 = (Function1) new Function1<PinnableParent, Unit>() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PinnableParent pinnableParent) {
                            invoke2(pinnableParent);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PinnableParent it) {
                            pinnableParent$delegate.setValue(it);
                        }
                    };
                    $composer.updateRememberedValue(value$iv$iv6);
                } else {
                    value$iv$iv6 = it$iv$iv7;
                }
                $composer.endReplaceableGroup();
                onPinnableParentAvailable = FocusableKt.onPinnableParentAvailable(semantics$default, (Function1) value$iv$iv6);
                Modifier then = FocusRequesterModifierKt.focusRequester(BringIntoViewRequesterKt.bringIntoViewRequester(onPinnableParentAvailable, bringIntoViewRequester), focusRequester).then(focusedChildModifier);
                final MutableInteractionSource mutableInteractionSource4 = this.$interactionSource;
                companion = FocusModifierKt.focusTarget(FocusChangedModifierKt.onFocusChanged(then, new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.FocusableKt$focusable$2.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                        invoke2(focusState);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(FocusState it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        FocusableKt$focusable$2.m540invoke$lambda6(isFocused$delegate, it.isFocused());
                        if (FocusableKt$focusable$2.m539invoke$lambda5(isFocused$delegate)) {
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(bringIntoViewRequester, pinnableParent$delegate, null), 1, null);
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass2(focusedInteraction, mutableInteractionSource4, null), 3, null);
                        } else {
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass3(focusedInteraction, mutableInteractionSource4, null), 3, null);
                        }
                    }

                    /* compiled from: Focusable.kt */
                    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                    @DebugMetadata(m296c = "androidx.compose.foundation.FocusableKt$focusable$2$5$1", m297f = "Focusable.kt", m298i = {0}, m299l = {144}, m300m = "invokeSuspend", m301n = {"pinnedItemsHandle"}, m302s = {"L$0"})
                    /* renamed from: androidx.compose.foundation.FocusableKt$focusable$2$5$1, reason: invalid class name */
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
                        final /* synthetic */ MutableState<PinnableParent> $pinnableParent$delegate;
                        Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(BringIntoViewRequester bringIntoViewRequester, MutableState<PinnableParent> mutableState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$bringIntoViewRequester = bringIntoViewRequester;
                            this.$pinnableParent$delegate = mutableState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$bringIntoViewRequester, this.$pinnableParent$delegate, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
                        /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object invokeSuspend(Object $result) {
                            PinnableParent.PinnedItemsHandle pinnedItemsHandle;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    PinnableParent.PinnedItemsHandle pinnedItemsHandle2 = (PinnableParent.PinnedItemsHandle) null;
                                    try {
                                        PinnableParent m537invoke$lambda2 = FocusableKt$focusable$2.m537invoke$lambda2(this.$pinnableParent$delegate);
                                        pinnedItemsHandle2 = m537invoke$lambda2 != null ? m537invoke$lambda2.pinItems() : null;
                                        this.L$0 = pinnedItemsHandle2;
                                        this.label = 1;
                                        if (BringIntoViewRequester.bringIntoView$default(this.$bringIntoViewRequester, null, this, 1, null) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        pinnedItemsHandle = pinnedItemsHandle2;
                                        if (pinnedItemsHandle != null) {
                                            pinnedItemsHandle.unpin();
                                        }
                                        return Unit.INSTANCE;
                                    } catch (Throwable th) {
                                        th = th;
                                        pinnedItemsHandle = pinnedItemsHandle2;
                                        if (pinnedItemsHandle != null) {
                                            pinnedItemsHandle.unpin();
                                        }
                                        throw th;
                                    }
                                case 1:
                                    pinnedItemsHandle = (PinnableParent.PinnedItemsHandle) this.L$0;
                                    try {
                                        ResultKt.throwOnFailure($result);
                                        if (pinnedItemsHandle != null) {
                                        }
                                        return Unit.INSTANCE;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (pinnedItemsHandle != null) {
                                        }
                                        throw th;
                                    }
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }

                    /* compiled from: Focusable.kt */
                    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                    @DebugMetadata(m296c = "androidx.compose.foundation.FocusableKt$focusable$2$5$2", m297f = "Focusable.kt", m298i = {1}, m299l = {152, 156}, m300m = "invokeSuspend", m301n = {"interaction"}, m302s = {"L$0"})
                    /* renamed from: androidx.compose.foundation.FocusableKt$focusable$2$5$2, reason: invalid class name */
                    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableState<FocusInteraction.Focus> $focusedInteraction;
                        final /* synthetic */ MutableInteractionSource $interactionSource;
                        Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(MutableState<FocusInteraction.Focus> mutableState, MutableInteractionSource mutableInteractionSource, Continuation<? super AnonymousClass2> continuation) {
                            super(2, continuation);
                            this.$focusedInteraction = mutableState;
                            this.$interactionSource = mutableInteractionSource;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass2(this.$focusedInteraction, this.$interactionSource, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object invokeSuspend(Object $result) {
                            AnonymousClass2 anonymousClass2;
                            MutableState<FocusInteraction.Focus> mutableState;
                            MutableState<FocusInteraction.Focus> mutableState2;
                            int i;
                            FocusInteraction.Focus interaction;
                            MutableInteractionSource mutableInteractionSource;
                            AnonymousClass2 anonymousClass22;
                            FocusInteraction.Focus interaction2;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    anonymousClass2 = this;
                                    FocusInteraction.Focus oldValue = anonymousClass2.$focusedInteraction.getValue();
                                    if (oldValue != null) {
                                        MutableInteractionSource mutableInteractionSource2 = anonymousClass2.$interactionSource;
                                        mutableState = anonymousClass2.$focusedInteraction;
                                        FocusInteraction.Unfocus interaction3 = new FocusInteraction.Unfocus(oldValue);
                                        if (mutableInteractionSource2 != null) {
                                            anonymousClass2.L$0 = mutableState;
                                            anonymousClass2.label = 1;
                                            if (mutableInteractionSource2.emit(interaction3, anonymousClass2) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            mutableState2 = mutableState;
                                            i = 0;
                                            mutableState = mutableState2;
                                        }
                                        mutableState.setValue(null);
                                    }
                                    interaction = new FocusInteraction.Focus();
                                    mutableInteractionSource = anonymousClass2.$interactionSource;
                                    if (mutableInteractionSource != null) {
                                        anonymousClass2.L$0 = interaction;
                                        anonymousClass2.label = 2;
                                        if (mutableInteractionSource.emit(interaction, anonymousClass2) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        anonymousClass22 = anonymousClass2;
                                        interaction2 = interaction;
                                        interaction = interaction2;
                                        anonymousClass2 = anonymousClass22;
                                    }
                                    anonymousClass2.$focusedInteraction.setValue(interaction);
                                    return Unit.INSTANCE;
                                case 1:
                                    anonymousClass2 = this;
                                    i = 0;
                                    mutableState2 = (MutableState) anonymousClass2.L$0;
                                    ResultKt.throwOnFailure($result);
                                    mutableState = mutableState2;
                                    mutableState.setValue(null);
                                    interaction = new FocusInteraction.Focus();
                                    mutableInteractionSource = anonymousClass2.$interactionSource;
                                    if (mutableInteractionSource != null) {
                                    }
                                    anonymousClass2.$focusedInteraction.setValue(interaction);
                                    return Unit.INSTANCE;
                                case 2:
                                    anonymousClass22 = this;
                                    interaction2 = (FocusInteraction.Focus) anonymousClass22.L$0;
                                    ResultKt.throwOnFailure($result);
                                    interaction = interaction2;
                                    anonymousClass2 = anonymousClass22;
                                    anonymousClass2.$focusedInteraction.setValue(interaction);
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }

                    /* compiled from: Focusable.kt */
                    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                    @DebugMetadata(m296c = "androidx.compose.foundation.FocusableKt$focusable$2$5$3", m297f = "Focusable.kt", m298i = {}, m299l = {163}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                    /* renamed from: androidx.compose.foundation.FocusableKt$focusable$2$5$3, reason: invalid class name */
                    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableState<FocusInteraction.Focus> $focusedInteraction;
                        final /* synthetic */ MutableInteractionSource $interactionSource;
                        Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass3(MutableState<FocusInteraction.Focus> mutableState, MutableInteractionSource mutableInteractionSource, Continuation<? super AnonymousClass3> continuation) {
                            super(2, continuation);
                            this.$focusedInteraction = mutableState;
                            this.$interactionSource = mutableInteractionSource;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass3(this.$focusedInteraction, this.$interactionSource, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            MutableState<FocusInteraction.Focus> mutableState;
                            AnonymousClass3 anonymousClass3;
                            MutableState<FocusInteraction.Focus> mutableState2;
                            AnonymousClass3 anonymousClass32;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FocusInteraction.Focus oldValue = this.$focusedInteraction.getValue();
                                    if (oldValue != null) {
                                        MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                                        mutableState = this.$focusedInteraction;
                                        FocusInteraction.Unfocus interaction = new FocusInteraction.Unfocus(oldValue);
                                        if (mutableInteractionSource != null) {
                                            this.L$0 = mutableState;
                                            this.label = 1;
                                            if (mutableInteractionSource.emit(interaction, this) != coroutine_suspended) {
                                                anonymousClass3 = this;
                                                mutableState2 = mutableState;
                                                anonymousClass32 = null;
                                                mutableState = mutableState2;
                                            } else {
                                                return coroutine_suspended;
                                            }
                                        }
                                        mutableState.setValue(null);
                                    }
                                    return Unit.INSTANCE;
                                case 1:
                                    anonymousClass3 = this;
                                    anonymousClass32 = null;
                                    mutableState2 = (MutableState) anonymousClass3.L$0;
                                    ResultKt.throwOnFailure($result);
                                    mutableState = mutableState2;
                                    mutableState.setValue(null);
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }
                }));
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceableGroup();
            return companion;
        }
        value$iv$iv8 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                final MutableState<FocusInteraction.Focus> mutableState = focusedInteraction;
                final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$1$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        FocusInteraction.Focus oldValue = (FocusInteraction.Focus) MutableState.this.getValue();
                        if (oldValue == null) {
                            return;
                        }
                        FocusInteraction.Unfocus interaction = new FocusInteraction.Unfocus(oldValue);
                        if (mutableInteractionSource5 != null) {
                            mutableInteractionSource5.tryEmit(interaction);
                        }
                        MutableState.this.setValue(null);
                    }
                };
            }
        };
        $composer.updateRememberedValue(value$iv$iv8);
        $composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(mutableInteractionSource, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv$iv8, $composer, 0);
        Boolean valueOf2 = Boolean.valueOf(this.$enabled);
        final boolean z2 = this.$enabled;
        final MutableInteractionSource mutableInteractionSource32 = this.$interactionSource;
        EffectsKt.DisposableEffect(valueOf2, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.FocusableKt$focusable$2.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                if (!z2) {
                    BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(focusedInteraction, mutableInteractionSource32, null), 3, null);
                }
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$2$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                    }
                };
            }

            /* compiled from: Focusable.kt */
            @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            @DebugMetadata(m296c = "androidx.compose.foundation.FocusableKt$focusable$2$2$1", m297f = "Focusable.kt", m298i = {}, m299l = {105}, m300m = "invokeSuspend", m301n = {}, m302s = {})
            /* renamed from: androidx.compose.foundation.FocusableKt$focusable$2$2$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ MutableState<FocusInteraction.Focus> $focusedInteraction;
                final /* synthetic */ MutableInteractionSource $interactionSource;
                Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(MutableState<FocusInteraction.Focus> mutableState, MutableInteractionSource mutableInteractionSource, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$focusedInteraction = mutableState;
                    this.$interactionSource = mutableInteractionSource;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$focusedInteraction, this.$interactionSource, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    MutableState<FocusInteraction.Focus> mutableState;
                    AnonymousClass1 anonymousClass1;
                    MutableState<FocusInteraction.Focus> mutableState2;
                    AnonymousClass1 anonymousClass12;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            FocusInteraction.Focus oldValue = this.$focusedInteraction.getValue();
                            if (oldValue != null) {
                                MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                                mutableState = this.$focusedInteraction;
                                FocusInteraction.Unfocus interaction = new FocusInteraction.Unfocus(oldValue);
                                if (mutableInteractionSource != null) {
                                    this.L$0 = mutableState;
                                    this.label = 1;
                                    if (mutableInteractionSource.emit(interaction, this) != coroutine_suspended) {
                                        anonymousClass1 = this;
                                        mutableState2 = mutableState;
                                        anonymousClass12 = null;
                                        mutableState = mutableState2;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                }
                                mutableState.setValue(null);
                            }
                            return Unit.INSTANCE;
                        case 1:
                            anonymousClass1 = this;
                            anonymousClass12 = null;
                            mutableState2 = (MutableState) anonymousClass1.L$0;
                            ResultKt.throwOnFailure($result);
                            mutableState = mutableState2;
                            mutableState.setValue(null);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
        }, $composer, 0);
        if (this.$enabled) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        $composer.endReplaceableGroup();
        return companion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2, reason: not valid java name */
    public static final PinnableParent m537invoke$lambda2(MutableState<PinnableParent> mutableState) {
        MutableState<PinnableParent> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-5, reason: not valid java name */
    public static final boolean m539invoke$lambda5(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-6, reason: not valid java name */
    public static final void m540invoke$lambda6(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }
}
