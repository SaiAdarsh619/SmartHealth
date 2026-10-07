package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.health.connect.client.records.ExerciseSessionRecord;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TextFieldPressGestureFilter.kt */
@Metadata(m286d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a7\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0000ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, m287d2 = {"tapPressTextFieldModifier", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "onTap", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TextFieldPressGestureFilterKt {
    public static /* synthetic */ Modifier tapPressTextFieldModifier$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return tapPressTextFieldModifier(modifier, mutableInteractionSource, z, function1);
    }

    public static final Modifier tapPressTextFieldModifier(Modifier $this$tapPressTextFieldModifier, final MutableInteractionSource interactionSource, boolean enabled, final Function1<? super Offset, Unit> onTap) {
        Intrinsics.checkNotNullParameter($this$tapPressTextFieldModifier, "<this>");
        Intrinsics.checkNotNullParameter(onTap, "onTap");
        return enabled ? ComposedModifierKt.composed$default($this$tapPressTextFieldModifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Object value$iv$iv$iv;
                Object value$iv$iv;
                Object value$iv$iv2;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(-102778667);
                ComposerKt.sourceInformation($composer, "C41@1646L24,42@1700L58,43@1780L27,44@1848L279,44@1812L315:TextFieldPressGestureFilter.kt#423gt5");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-102778667, $changed, -1, "androidx.compose.foundation.text.tapPressTextFieldModifier.<anonymous> (TextFieldPressGestureFilter.kt:40)");
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
                final MutableState pressedInteraction = (MutableState) value$iv$iv;
                State onTapState = SnapshotStateKt.rememberUpdatedState(onTap, $composer, 0);
                MutableInteractionSource mutableInteractionSource = interactionSource;
                Object key2$iv = interactionSource;
                final MutableInteractionSource mutableInteractionSource2 = interactionSource;
                $composer.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer.changed(pressedInteraction) | $composer.changed(key2$iv);
                Object it$iv$iv2 = $composer.rememberedValue();
                if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                            final MutableState<PressInteraction.Press> mutableState = pressedInteraction;
                            final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$1$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    PressInteraction.Press oldValue = (PressInteraction.Press) MutableState.this.getValue();
                                    if (oldValue == null) {
                                        return;
                                    }
                                    PressInteraction.Cancel interaction = new PressInteraction.Cancel(oldValue);
                                    if (mutableInteractionSource3 != null) {
                                        mutableInteractionSource3.tryEmit(interaction);
                                    }
                                    MutableState.this.setValue(null);
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
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, interactionSource, new C02562(scope, pressedInteraction, interactionSource, onTapState, null));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return pointerInput;
            }

            /* compiled from: TextFieldPressGestureFilter.kt */
            @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            @DebugMetadata(m296c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2", m297f = "TextFieldPressGestureFilter.kt", m298i = {}, m299l = {55}, m300m = "invokeSuspend", m301n = {}, m302s = {})
            /* renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2 */
            static final class C02562 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ MutableInteractionSource $interactionSource;
                final /* synthetic */ State<Function1<Offset, Unit>> $onTapState;
                final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
                final /* synthetic */ CoroutineScope $scope;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C02562(CoroutineScope coroutineScope, MutableState<PressInteraction.Press> mutableState, MutableInteractionSource mutableInteractionSource, State<? extends Function1<? super Offset, Unit>> state, Continuation<? super C02562> continuation) {
                    super(2, continuation);
                    this.$scope = coroutineScope;
                    this.$pressedInteraction = mutableState;
                    this.$interactionSource = mutableInteractionSource;
                    this.$onTapState = state;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C02562 c02562 = new C02562(this.$scope, this.$pressedInteraction, this.$interactionSource, this.$onTapState, continuation);
                    c02562.L$0 = obj;
                    return c02562;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                    return ((C02562) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* compiled from: TextFieldPressGestureFilter.kt */
                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                @DebugMetadata(m296c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1", m297f = "TextFieldPressGestureFilter.kt", m298i = {}, m299l = {ExerciseSessionRecord.EXERCISE_TYPE_STAIR_CLIMBING}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                /* renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                    final /* synthetic */ MutableInteractionSource $interactionSource;
                    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
                    final /* synthetic */ CoroutineScope $scope;
                    /* synthetic */ long J$0;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(CoroutineScope coroutineScope, MutableState<PressInteraction.Press> mutableState, MutableInteractionSource mutableInteractionSource, Continuation<? super AnonymousClass1> continuation) {
                        super(3, continuation);
                        this.$scope = coroutineScope;
                        this.$pressedInteraction = mutableState;
                        this.$interactionSource = mutableInteractionSource;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                        return m1094invoked4ec7I(pressGestureScope, offset.getPackedValue(), continuation);
                    }

                    /* renamed from: invoke-d-4ec7I, reason: not valid java name */
                    public final Object m1094invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scope, this.$pressedInteraction, this.$interactionSource, continuation);
                        anonymousClass1.L$0 = pressGestureScope;
                        anonymousClass1.J$0 = j;
                        return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                    }

                    /* compiled from: TextFieldPressGestureFilter.kt */
                    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                    @DebugMetadata(m296c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1", m297f = "TextFieldPressGestureFilter.kt", m298i = {1}, m299l = {61, 65}, m300m = "invokeSuspend", m301n = {"interaction"}, m302s = {"L$0"})
                    /* renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1, reason: invalid class name and collision with other inner class name */
                    static final class C16731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableInteractionSource $interactionSource;
                        final /* synthetic */ long $it;
                        final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
                        Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C16731(MutableState<PressInteraction.Press> mutableState, long j, MutableInteractionSource mutableInteractionSource, Continuation<? super C16731> continuation) {
                            super(2, continuation);
                            this.$pressedInteraction = mutableState;
                            this.$it = j;
                            this.$interactionSource = mutableInteractionSource;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C16731(this.$pressedInteraction, this.$it, this.$interactionSource, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C16731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object invokeSuspend(Object $result) {
                            C16731 c16731;
                            MutableState<PressInteraction.Press> mutableState;
                            MutableState<PressInteraction.Press> mutableState2;
                            int i;
                            PressInteraction.Press interaction;
                            MutableInteractionSource mutableInteractionSource;
                            C16731 c167312;
                            PressInteraction.Press interaction2;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    c16731 = this;
                                    PressInteraction.Press oldValue = c16731.$pressedInteraction.getValue();
                                    if (oldValue != null) {
                                        MutableInteractionSource mutableInteractionSource2 = c16731.$interactionSource;
                                        mutableState = c16731.$pressedInteraction;
                                        PressInteraction.Cancel interaction3 = new PressInteraction.Cancel(oldValue);
                                        if (mutableInteractionSource2 != null) {
                                            c16731.L$0 = mutableState;
                                            c16731.label = 1;
                                            if (mutableInteractionSource2.emit(interaction3, c16731) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            mutableState2 = mutableState;
                                            i = 0;
                                            mutableState = mutableState2;
                                        }
                                        mutableState.setValue(null);
                                    }
                                    interaction = new PressInteraction.Press(c16731.$it, null);
                                    mutableInteractionSource = c16731.$interactionSource;
                                    if (mutableInteractionSource != null) {
                                        c16731.L$0 = interaction;
                                        c16731.label = 2;
                                        if (mutableInteractionSource.emit(interaction, c16731) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        c167312 = c16731;
                                        interaction2 = interaction;
                                        interaction = interaction2;
                                        c16731 = c167312;
                                    }
                                    c16731.$pressedInteraction.setValue(interaction);
                                    return Unit.INSTANCE;
                                case 1:
                                    c16731 = this;
                                    i = 0;
                                    mutableState2 = (MutableState) c16731.L$0;
                                    ResultKt.throwOnFailure($result);
                                    mutableState = mutableState2;
                                    mutableState.setValue(null);
                                    interaction = new PressInteraction.Press(c16731.$it, null);
                                    mutableInteractionSource = c16731.$interactionSource;
                                    if (mutableInteractionSource != null) {
                                    }
                                    c16731.$pressedInteraction.setValue(interaction);
                                    return Unit.INSTANCE;
                                case 2:
                                    c167312 = this;
                                    interaction2 = (PressInteraction.Press) c167312.L$0;
                                    ResultKt.throwOnFailure($result);
                                    interaction = interaction2;
                                    c16731 = c167312;
                                    c16731.$pressedInteraction.setValue(interaction);
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }

                    /* compiled from: TextFieldPressGestureFilter.kt */
                    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                    @DebugMetadata(m296c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$2", m297f = "TextFieldPressGestureFilter.kt", m298i = {}, m299l = {77}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                    /* renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$2, reason: invalid class name */
                    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableInteractionSource $interactionSource;
                        final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
                        final /* synthetic */ boolean $success;
                        Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(MutableState<PressInteraction.Press> mutableState, boolean z, MutableInteractionSource mutableInteractionSource, Continuation<? super AnonymousClass2> continuation) {
                            super(2, continuation);
                            this.$pressedInteraction = mutableState;
                            this.$success = z;
                            this.$interactionSource = mutableInteractionSource;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass2(this.$pressedInteraction, this.$success, this.$interactionSource, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            MutableState<PressInteraction.Press> mutableState;
                            PressInteraction cancel;
                            AnonymousClass2 anonymousClass2;
                            MutableState<PressInteraction.Press> mutableState2;
                            AnonymousClass2 anonymousClass22;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    PressInteraction.Press oldValue = this.$pressedInteraction.getValue();
                                    if (oldValue != null) {
                                        boolean z = this.$success;
                                        MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                                        mutableState = this.$pressedInteraction;
                                        if (z) {
                                            cancel = new PressInteraction.Release(oldValue);
                                        } else {
                                            cancel = new PressInteraction.Cancel(oldValue);
                                        }
                                        PressInteraction interaction = cancel;
                                        if (mutableInteractionSource != null) {
                                            this.L$0 = mutableState;
                                            this.label = 1;
                                            if (mutableInteractionSource.emit(interaction, this) != coroutine_suspended) {
                                                anonymousClass2 = this;
                                                mutableState2 = mutableState;
                                                anonymousClass22 = null;
                                                mutableState = mutableState2;
                                            } else {
                                                return coroutine_suspended;
                                            }
                                        }
                                        mutableState.setValue(null);
                                    }
                                    return Unit.INSTANCE;
                                case 1:
                                    anonymousClass2 = this;
                                    anonymousClass22 = null;
                                    mutableState2 = (MutableState) anonymousClass2.L$0;
                                    ResultKt.throwOnFailure($result);
                                    mutableState = mutableState2;
                                    mutableState.setValue(null);
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) {
                        AnonymousClass1 anonymousClass1;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                anonymousClass1 = this;
                                PressGestureScope $this$detectTapAndPress = (PressGestureScope) anonymousClass1.L$0;
                                long it = anonymousClass1.J$0;
                                BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$scope, null, null, new C16731(anonymousClass1.$pressedInteraction, it, anonymousClass1.$interactionSource, null), 3, null);
                                anonymousClass1.label = 1;
                                Object tryAwaitRelease = $this$detectTapAndPress.tryAwaitRelease(anonymousClass1);
                                if (tryAwaitRelease != coroutine_suspended) {
                                    $result = tryAwaitRelease;
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                            case 1:
                                ResultKt.throwOnFailure($result);
                                anonymousClass1 = this;
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        boolean success = ((Boolean) $result).booleanValue();
                        BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$scope, null, null, new AnonymousClass2(anonymousClass1.$pressedInteraction, success, anonymousClass1.$interactionSource, null), 3, null);
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
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scope, this.$pressedInteraction, this.$interactionSource, null);
                            final State<Function1<Offset, Unit>> state = this.$onTapState;
                            this.label = 1;
                            if (TapGestureDetectorKt.detectTapAndPress($this$pointerInput, anonymousClass1, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt.tapPressTextFieldModifier.1.2.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                    m1095invokek4lQ0M(offset.getPackedValue());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                                public final void m1095invokek4lQ0M(long it) {
                                    state.getValue().invoke(Offset.m1749boximpl(it));
                                }
                            }, this) != coroutine_suspended) {
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
        }, 1, null) : $this$tapPressTextFieldModifier;
    }
}
