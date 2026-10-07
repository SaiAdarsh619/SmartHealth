package androidx.compose.foundation;

import android.view.View;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.DrawModifierKt;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.LayoutCoordinatesKt;
import androidx.compose.p000ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p000ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyKey;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.DpSize;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.IntSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: Magnifier.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, m287d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class MagnifierKt$magnifier$4 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Function1<Density, Offset> $magnifierCenter;
    final /* synthetic */ Function1<DpSize, Unit> $onSizeChanged;
    final /* synthetic */ PlatformMagnifierFactory $platformMagnifierFactory;
    final /* synthetic */ Function1<Density, Offset> $sourceCenter;
    final /* synthetic */ MagnifierStyle $style;
    final /* synthetic */ float $zoom;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MagnifierKt$magnifier$4(Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, float f, Function1<? super DpSize, Unit> function13, PlatformMagnifierFactory platformMagnifierFactory, MagnifierStyle magnifierStyle) {
        super(3);
        this.$sourceCenter = function1;
        this.$magnifierCenter = function12;
        this.$zoom = f;
        this.$onSizeChanged = function13;
        this.$platformMagnifierFactory = platformMagnifierFactory;
        this.$style = magnifierStyle;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Object value$iv$iv4;
        Object value$iv$iv5;
        Object value$iv$iv6;
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        $composer.startReplaceableGroup(-454877003);
        ComposerKt.sourceInformation($composer, "C273@11641L7,274@11680L7,275@11728L47,276@11807L34,277@11876L37,278@11937L26,279@11996L35,280@12062L331,290@12422L62,295@12614L107,307@13298L2602,373@15957L344,385@16670L78:Magnifier.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-454877003, $changed, -1, "androidx.compose.foundation.magnifier.<anonymous> (Magnifier.kt:272)");
        }
        ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localView);
        ComposerKt.sourceInformationMarkerEnd($composer);
        View view = (View) consume;
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Density density = (Density) consume2;
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m1749boximpl(Offset.INSTANCE.m1775getUnspecifiedF1C5BW0()), null, 2, null);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        final MutableState anchorPositionInRoot$delegate = (MutableState) value$iv$iv;
        final State updatedSourceCenter$delegate = SnapshotStateKt.rememberUpdatedState(this.$sourceCenter, $composer, 0);
        State updatedMagnifierCenter$delegate = SnapshotStateKt.rememberUpdatedState(this.$magnifierCenter, $composer, 0);
        State updatedZoom$delegate = SnapshotStateKt.rememberUpdatedState(Float.valueOf(this.$zoom), $composer, 0);
        State updatedOnSizeChanged$delegate = SnapshotStateKt.rememberUpdatedState(this.$onSizeChanged, $composer, 0);
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv2 = $composer.rememberedValue();
        if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv2 = SnapshotStateKt.derivedStateOf(new Function0<Offset>() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$4$sourceCenterInRoot$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Offset invoke() {
                    return Offset.m1749boximpl(m562invokeF1C5BW0());
                }

                /* renamed from: invoke-F1C5BW0, reason: not valid java name */
                public final long m562invokeF1C5BW0() {
                    Function1 m556invoke$lambda3;
                    m556invoke$lambda3 = MagnifierKt$magnifier$4.m556invoke$lambda3(updatedSourceCenter$delegate);
                    long sourceCenterOffset = ((Offset) m556invoke$lambda3.invoke(Density.this)).getPackedValue();
                    if (OffsetKt.m1779isSpecifiedk4lQ0M(MagnifierKt$magnifier$4.m553invoke$lambda1(anchorPositionInRoot$delegate)) && OffsetKt.m1779isSpecifiedk4lQ0M(sourceCenterOffset)) {
                        return Offset.m1765plusMKHz9U(MagnifierKt$magnifier$4.m553invoke$lambda1(anchorPositionInRoot$delegate), sourceCenterOffset);
                    }
                    return Offset.INSTANCE.m1775getUnspecifiedF1C5BW0();
                }
            });
            $composer.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        final State sourceCenterInRoot$delegate = (State) value$iv$iv2;
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv3 = $composer.rememberedValue();
        if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv3 = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$4$isMagnifierShown$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(OffsetKt.m1779isSpecifiedk4lQ0M(MagnifierKt$magnifier$4.m560invoke$lambda8(sourceCenterInRoot$delegate)));
                }
            });
            $composer.updateRememberedValue(value$iv$iv3);
        } else {
            value$iv$iv3 = it$iv$iv3;
        }
        $composer.endReplaceableGroup();
        State isMagnifierShown$delegate = (State) value$iv$iv3;
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv4 = $composer.rememberedValue();
        if (it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv4 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
            $composer.updateRememberedValue(value$iv$iv4);
        } else {
            value$iv$iv4 = it$iv$iv4;
        }
        $composer.endReplaceableGroup();
        final MutableSharedFlow onNeedsUpdate = (MutableSharedFlow) value$iv$iv4;
        float zoomEffectKey = this.$platformMagnifierFactory.getCanUpdateZoom() ? 0.0f : this.$zoom;
        EffectsKt.LaunchedEffect(new Object[]{view, density, Float.valueOf(zoomEffectKey), this.$style, Boolean.valueOf(Intrinsics.areEqual(this.$style, MagnifierStyle.INSTANCE.getTextDefault()))}, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new C00821(this.$platformMagnifierFactory, this.$style, view, density, this.$zoom, onNeedsUpdate, updatedOnSizeChanged$delegate, isMagnifierShown$delegate, sourceCenterInRoot$delegate, updatedMagnifierCenter$delegate, anchorPositionInRoot$delegate, updatedZoom$delegate, null), $composer, 72);
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(anchorPositionInRoot$delegate);
        Object it$iv$iv5 = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv5 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv5 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$4$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                    invoke2(layoutCoordinates);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutCoordinates it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    MagnifierKt$magnifier$4.m555invoke$lambda2(anchorPositionInRoot$delegate, LayoutCoordinatesKt.positionInRoot(it));
                }
            };
            $composer.updateRememberedValue(value$iv$iv5);
        } else {
            value$iv$iv5 = it$iv$iv5;
        }
        $composer.endReplaceableGroup();
        Modifier drawBehind = DrawModifierKt.drawBehind(OnGloballyPositionedModifierKt.onGloballyPositioned(composed, (Function1) value$iv$iv5), new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$4.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawBehind2) {
                Intrinsics.checkNotNullParameter(drawBehind2, "$this$drawBehind");
                onNeedsUpdate.tryEmit(Unit.INSTANCE);
            }
        });
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = $composer.changed(sourceCenterInRoot$delegate);
        Object it$iv$iv6 = $composer.rememberedValue();
        if (invalid$iv$iv2 || it$iv$iv6 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv6 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$4$4$1
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
                    SemanticsPropertyKey<Function0<Offset>> magnifierPositionInRoot = MagnifierKt.getMagnifierPositionInRoot();
                    final State<Offset> state = sourceCenterInRoot$delegate;
                    semantics.set(magnifierPositionInRoot, new Function0<Offset>() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$4$4$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Offset invoke() {
                            return Offset.m1749boximpl(m561invokeF1C5BW0());
                        }

                        /* renamed from: invoke-F1C5BW0, reason: not valid java name */
                        public final long m561invokeF1C5BW0() {
                            return MagnifierKt$magnifier$4.m560invoke$lambda8(state);
                        }
                    });
                }
            };
            $composer.updateRememberedValue(value$iv$iv6);
        } else {
            value$iv$iv6 = it$iv$iv6;
        }
        $composer.endReplaceableGroup();
        Modifier semantics$default = SemanticsModifierKt.semantics$default(drawBehind, false, (Function1) value$iv$iv6, 1, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return semantics$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-1, reason: not valid java name */
    public static final long m553invoke$lambda1(MutableState<Offset> mutableState) {
        MutableState<Offset> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().getPackedValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2, reason: not valid java name */
    public static final void m555invoke$lambda2(MutableState<Offset> mutableState, long value) {
        mutableState.setValue(Offset.m1749boximpl(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-3, reason: not valid java name */
    public static final Function1<Density, Offset> m556invoke$lambda3(State<? extends Function1<? super Density, Offset>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-4, reason: not valid java name */
    public static final Function1<Density, Offset> m557invoke$lambda4(State<? extends Function1<? super Density, Offset>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-5, reason: not valid java name */
    public static final float m558invoke$lambda5(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-6, reason: not valid java name */
    public static final Function1<DpSize, Unit> m559invoke$lambda6(State<? extends Function1<? super DpSize, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-8, reason: not valid java name */
    public static final long m560invoke$lambda8(State<Offset> state) {
        Object thisObj$iv = state.getValue();
        return ((Offset) thisObj$iv).getPackedValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-10, reason: not valid java name */
    public static final boolean m554invoke$lambda10(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* compiled from: Magnifier.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.compose.foundation.MagnifierKt$magnifier$4$1", m297f = "Magnifier.kt", m298i = {0}, m299l = {365}, m300m = "invokeSuspend", m301n = {"magnifier"}, m302s = {"L$0"})
    /* renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$1 */
    static final class C00821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<Offset> $anchorPositionInRoot$delegate;
        final /* synthetic */ Density $density;
        final /* synthetic */ State<Boolean> $isMagnifierShown$delegate;
        final /* synthetic */ MutableSharedFlow<Unit> $onNeedsUpdate;
        final /* synthetic */ PlatformMagnifierFactory $platformMagnifierFactory;
        final /* synthetic */ State<Offset> $sourceCenterInRoot$delegate;
        final /* synthetic */ MagnifierStyle $style;
        final /* synthetic */ State<Function1<Density, Offset>> $updatedMagnifierCenter$delegate;
        final /* synthetic */ State<Function1<DpSize, Unit>> $updatedOnSizeChanged$delegate;
        final /* synthetic */ State<Float> $updatedZoom$delegate;
        final /* synthetic */ View $view;
        final /* synthetic */ float $zoom;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C00821(PlatformMagnifierFactory platformMagnifierFactory, MagnifierStyle magnifierStyle, View view, Density density, float f, MutableSharedFlow<Unit> mutableSharedFlow, State<? extends Function1<? super DpSize, Unit>> state, State<Boolean> state2, State<Offset> state3, State<? extends Function1<? super Density, Offset>> state4, MutableState<Offset> mutableState, State<Float> state5, Continuation<? super C00821> continuation) {
            super(2, continuation);
            this.$platformMagnifierFactory = platformMagnifierFactory;
            this.$style = magnifierStyle;
            this.$view = view;
            this.$density = density;
            this.$zoom = f;
            this.$onNeedsUpdate = mutableSharedFlow;
            this.$updatedOnSizeChanged$delegate = state;
            this.$isMagnifierShown$delegate = state2;
            this.$sourceCenterInRoot$delegate = state3;
            this.$updatedMagnifierCenter$delegate = state4;
            this.$anchorPositionInRoot$delegate = mutableState;
            this.$updatedZoom$delegate = state5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00821 c00821 = new C00821(this.$platformMagnifierFactory, this.$style, this.$view, this.$density, this.$zoom, this.$onNeedsUpdate, this.$updatedOnSizeChanged$delegate, this.$isMagnifierShown$delegate, this.$sourceCenterInRoot$delegate, this.$updatedMagnifierCenter$delegate, this.$anchorPositionInRoot$delegate, this.$updatedZoom$delegate, continuation);
            c00821.L$0 = obj;
            return c00821;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C00821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: Magnifier.kt */
        @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
        @DebugMetadata(m296c = "androidx.compose.foundation.MagnifierKt$magnifier$4$1$1", m297f = "Magnifier.kt", m298i = {}, m299l = {}, m300m = "invokeSuspend", m301n = {}, m302s = {})
        /* renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$1$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
            final /* synthetic */ PlatformMagnifier $magnifier;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PlatformMagnifier platformMagnifier, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$magnifier = platformMagnifier;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$magnifier, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        this.$magnifier.updateContent();
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            PlatformMagnifier magnifier;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$LaunchedEffect = (CoroutineScope) this.L$0;
                    final PlatformMagnifier magnifier2 = this.$platformMagnifierFactory.create(this.$style, this.$view, this.$density, this.$zoom);
                    final Ref.LongRef previousSize = new Ref.LongRef();
                    long newSize = magnifier2.mo567getSizeYbymL2g();
                    Density $this$invokeSuspend_u24lambda_u2d1_u24lambda_u2d0 = this.$density;
                    Function1 m559invoke$lambda6 = MagnifierKt$magnifier$4.m559invoke$lambda6(this.$updatedOnSizeChanged$delegate);
                    if (m559invoke$lambda6 != null) {
                        m559invoke$lambda6.invoke(DpSize.m4468boximpl($this$invokeSuspend_u24lambda_u2d1_u24lambda_u2d0.mo646toDpSizekrfVVM(IntSizeKt.m4552toSizeozmzZPI(newSize))));
                    }
                    previousSize.element = newSize;
                    FlowKt.launchIn(FlowKt.onEach(this.$onNeedsUpdate, new AnonymousClass1(magnifier2, null)), $this$LaunchedEffect);
                    try {
                        final Density density = this.$density;
                        final State<Boolean> state = this.$isMagnifierShown$delegate;
                        final State<Offset> state2 = this.$sourceCenterInRoot$delegate;
                        final State<Function1<Density, Offset>> state3 = this.$updatedMagnifierCenter$delegate;
                        final MutableState<Offset> mutableState = this.$anchorPositionInRoot$delegate;
                        final State<Float> state4 = this.$updatedZoom$delegate;
                        final State<Function1<DpSize, Unit>> state5 = this.$updatedOnSizeChanged$delegate;
                        this.L$0 = magnifier2;
                        this.label = 1;
                        if (FlowKt.collect(SnapshotStateKt.snapshotFlow(new Function0<Unit>() { // from class: androidx.compose.foundation.MagnifierKt.magnifier.4.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                long m1775getUnspecifiedF1C5BW0;
                                if (MagnifierKt$magnifier$4.m554invoke$lambda10(state)) {
                                    PlatformMagnifier platformMagnifier = PlatformMagnifier.this;
                                    long m560invoke$lambda8 = MagnifierKt$magnifier$4.m560invoke$lambda8(state2);
                                    Object invoke = MagnifierKt$magnifier$4.m557invoke$lambda4(state3).invoke(density);
                                    MutableState<Offset> mutableState2 = mutableState;
                                    long it = ((Offset) invoke).getPackedValue();
                                    if (OffsetKt.m1779isSpecifiedk4lQ0M(it)) {
                                        m1775getUnspecifiedF1C5BW0 = Offset.m1765plusMKHz9U(MagnifierKt$magnifier$4.m553invoke$lambda1(mutableState2), it);
                                    } else {
                                        m1775getUnspecifiedF1C5BW0 = Offset.INSTANCE.m1775getUnspecifiedF1C5BW0();
                                    }
                                    platformMagnifier.mo568updateWko1d7g(m560invoke$lambda8, m1775getUnspecifiedF1C5BW0, MagnifierKt$magnifier$4.m558invoke$lambda5(state4));
                                    long size = PlatformMagnifier.this.mo567getSizeYbymL2g();
                                    Ref.LongRef longRef = previousSize;
                                    Density $this$invoke_u24lambda_u2d2_u24lambda_u2d1 = density;
                                    State<Function1<DpSize, Unit>> state6 = state5;
                                    if (!IntSize.m4540equalsimpl0(size, longRef.element)) {
                                        longRef.element = size;
                                        Function1 m559invoke$lambda62 = MagnifierKt$magnifier$4.m559invoke$lambda6(state6);
                                        if (m559invoke$lambda62 != null) {
                                            m559invoke$lambda62.invoke(DpSize.m4468boximpl($this$invoke_u24lambda_u2d2_u24lambda_u2d1.mo646toDpSizekrfVVM(IntSizeKt.m4552toSizeozmzZPI(size))));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                PlatformMagnifier.this.dismiss();
                            }
                        }), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        magnifier = magnifier2;
                        magnifier.dismiss();
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        magnifier = magnifier2;
                        magnifier.dismiss();
                        throw th;
                    }
                case 1:
                    magnifier = (PlatformMagnifier) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        magnifier.dismiss();
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        magnifier.dismiss();
                        throw th;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
