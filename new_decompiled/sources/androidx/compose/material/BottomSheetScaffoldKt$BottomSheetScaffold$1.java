package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BottomSheetScaffold.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class BottomSheetScaffoldKt$BottomSheetScaffold$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ int $$dirty2;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ boolean $drawerGesturesEnabled;
    final /* synthetic */ long $drawerScrimColor;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $sheetBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ float $sheetElevation;
    final /* synthetic */ boolean $sheetGesturesEnabled;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BottomSheetScaffoldKt$BottomSheetScaffold$1(BottomSheetScaffoldState bottomSheetScaffoldState, boolean z, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, boolean z2, Shape shape, float f, long j, long j2, long j3, int i, float f2, CoroutineScope coroutineScope, int i2, int i3, long j4, long j5, int i4, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32, Shape shape2, long j6, long j7, float f3, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34) {
        super(3);
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$sheetGesturesEnabled = z;
        this.$drawerContent = function3;
        this.$drawerGesturesEnabled = z2;
        this.$drawerShape = shape;
        this.$drawerElevation = f;
        this.$drawerBackgroundColor = j;
        this.$drawerContentColor = j2;
        this.$drawerScrimColor = j3;
        this.$$dirty1 = i;
        this.$sheetPeekHeight = f2;
        this.$scope = coroutineScope;
        this.$floatingActionButtonPosition = i2;
        this.$$dirty = i3;
        this.$backgroundColor = j4;
        this.$contentColor = j5;
        this.$$dirty2 = i4;
        this.$topBar = function2;
        this.$content = function32;
        this.$sheetShape = shape2;
        this.$sheetBackgroundColor = j6;
        this.$sheetContentColor = j7;
        this.$sheetElevation = f3;
        this.$sheetContent = function33;
        this.$floatingActionButton = function22;
        this.$snackbarHost = function34;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
        invoke(boxWithConstraintsScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(BoxWithConstraintsScope BoxWithConstraints, Composer $composer, int $changed) {
        Object value$iv$iv;
        Modifier m1523swipeablepPrIpRY;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C*286@12153L7,287@12222L39:BottomSheetScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer.changed(BoxWithConstraints) ? 4 : 2;
        }
        if (($dirty & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-440488519, $changed, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:284)");
            }
            float fullHeight = Constraints.m4337getMaxHeightimpl(BoxWithConstraints.getConstraints());
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density $this$invoke_u24lambda_u2d0 = (Density) consume;
            final float peekHeightPx = $this$invoke_u24lambda_u2d0.mo648toPx0680j_4(this.$sheetPeekHeight);
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(fullHeight), null, 2, null);
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            final MutableState bottomSheetHeight$delegate = (MutableState) value$iv$iv;
            m1523swipeablepPrIpRY = SwipeableKt.m1523swipeablepPrIpRY(NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, this.$scaffoldState.getBottomSheetState().getNestedScrollConnection(), null, 2, null), this.$scaffoldState.getBottomSheetState(), r21, Orientation.Vertical, (r26 & 8) != 0 ? true : this.$sheetGesturesEnabled, (r26 & 16) != 0 ? false : false, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function2
                public final FixedThreshold invoke(T t, T t2) {
                    return new FixedThreshold(C0504Dp.m4382constructorimpl(56), null);
                }
            } : null, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, MapsKt.mapOf(TuplesKt.m294to(Float.valueOf(fullHeight - peekHeightPx), BottomSheetValue.Collapsed), TuplesKt.m294to(Float.valueOf(fullHeight - m1265invoke$lambda2(bottomSheetHeight$delegate)), BottomSheetValue.Expanded)).keySet(), 0.0f, 0.0f, 6, null) : null, (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1522getVelocityThresholdD9Ej5fM() : 0.0f);
            final BottomSheetScaffoldState bottomSheetScaffoldState = this.$scaffoldState;
            final CoroutineScope coroutineScope = this.$scope;
            final Modifier swipeable = SemanticsModifierKt.semantics$default(m1523swipeablepPrIpRY, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1
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
                    float m1265invoke$lambda2;
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    float f = peekHeightPx;
                    m1265invoke$lambda2 = BottomSheetScaffoldKt$BottomSheetScaffold$1.m1265invoke$lambda2(bottomSheetHeight$delegate);
                    if (!(f == m1265invoke$lambda2)) {
                        if (bottomSheetScaffoldState.getBottomSheetState().isCollapsed()) {
                            final BottomSheetScaffoldState bottomSheetScaffoldState2 = bottomSheetScaffoldState;
                            final CoroutineScope coroutineScope2 = coroutineScope;
                            SemanticsPropertiesKt.expand$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    if (BottomSheetScaffoldState.this.getBottomSheetState().getConfirmStateChange$material_release().invoke(BottomSheetValue.Expanded).booleanValue()) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(BottomSheetScaffoldState.this, null), 3, null);
                                    }
                                    return true;
                                }

                                /* compiled from: BottomSheetScaffold.kt */
                                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                @DebugMetadata(m296c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1$1$1", m297f = "BottomSheetScaffold.kt", m298i = {}, m299l = {307}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1$1$1, reason: invalid class name */
                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(BottomSheetScaffoldState bottomSheetScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$scaffoldState = bottomSheetScaffoldState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$scaffoldState, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object $result) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                this.label = 1;
                                                if (this.$scaffoldState.getBottomSheetState().expand(this) != coroutine_suspended) {
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
                            }, 1, null);
                        } else {
                            final BottomSheetScaffoldState bottomSheetScaffoldState3 = bottomSheetScaffoldState;
                            final CoroutineScope coroutineScope3 = coroutineScope;
                            SemanticsPropertiesKt.collapse$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    if (BottomSheetScaffoldState.this.getBottomSheetState().getConfirmStateChange$material_release().invoke(BottomSheetValue.Collapsed).booleanValue()) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(BottomSheetScaffoldState.this, null), 3, null);
                                    }
                                    return true;
                                }

                                /* compiled from: BottomSheetScaffold.kt */
                                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                @DebugMetadata(m296c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1$2$1", m297f = "BottomSheetScaffold.kt", m298i = {}, m299l = {314}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1$2$1, reason: invalid class name */
                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(BottomSheetScaffoldState bottomSheetScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$scaffoldState = bottomSheetScaffoldState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$scaffoldState, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object $result) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                this.label = 1;
                                                if (this.$scaffoldState.getBottomSheetState().collapse(this) != coroutine_suspended) {
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
                            }, 1, null);
                        }
                    }
                }
            }, 1, null);
            final BottomSheetScaffoldState bottomSheetScaffoldState2 = this.$scaffoldState;
            final int i = this.$floatingActionButtonPosition;
            final int i2 = this.$$dirty;
            final long j = this.$backgroundColor;
            final long j2 = this.$contentColor;
            final int i3 = this.$$dirty2;
            final Function2<Composer, Integer, Unit> function2 = this.$topBar;
            final Function3<PaddingValues, Composer, Integer, Unit> function3 = this.$content;
            final float f = this.$sheetPeekHeight;
            final Shape shape = this.$sheetShape;
            final long j3 = this.$sheetBackgroundColor;
            final long j4 = this.$sheetContentColor;
            final float f2 = this.$sheetElevation;
            final int i4 = this.$$dirty1;
            final Function3<ColumnScope, Composer, Integer, Unit> function32 = this.$sheetContent;
            final Function2<Composer, Integer, Unit> function22 = this.$floatingActionButton;
            final Function3<SnackbarHostState, Composer, Integer, Unit> function33 = this.$snackbarHost;
            Function2 child = ComposableLambdaKt.composableLambda($composer, -455982883, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer2, int $changed2) {
                    ComposerKt.sourceInformation($composer2, "C322@13696L1634:BottomSheetScaffold.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-455982883, $changed2, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:321)");
                        }
                        final long j5 = j;
                        final long j6 = j2;
                        final int i5 = i3;
                        final Function2<Composer, Integer, Unit> function23 = function2;
                        final int i6 = i2;
                        final Function3<PaddingValues, Composer, Integer, Unit> function34 = function3;
                        final float f3 = f;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda($composer2, 729683080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer3, int $changed3) {
                                ComposerKt.sourceInformation($composer3, "C324@13767L360:BottomSheetScaffold.kt#jmzs0o");
                                if (($changed3 & 11) != 2 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(729683080, $changed3, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:323)");
                                    }
                                    long j7 = j5;
                                    long j8 = j6;
                                    final Function2<Composer, Integer, Unit> function24 = function23;
                                    final int i7 = i6;
                                    final Function3<PaddingValues, Composer, Integer, Unit> function35 = function34;
                                    final float f4 = f3;
                                    final int i8 = i5;
                                    SurfaceKt.m1513SurfaceFjzlyU(null, null, j7, j8, null, 0.0f, ComposableLambdaKt.composableLambda($composer3, 2013303492, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.BottomSheetScaffold.1.child.1.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                            invoke(composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer $composer4, int $changed4) {
                                            Composer $composer$iv;
                                            Composer $composer5;
                                            ComposerKt.sourceInformation($composer4, "C328@13925L180:BottomSheetScaffold.kt#jmzs0o");
                                            if (($changed4 & 11) != 2 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(2013303492, $changed4, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:327)");
                                                }
                                                Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                Function2<Composer, Integer, Unit> function25 = function24;
                                                int i9 = i7;
                                                Function3<PaddingValues, Composer, Integer, Unit> function36 = function35;
                                                float f5 = f4;
                                                int i10 = i8;
                                                $composer4.startReplaceableGroup(-483455358);
                                                ComposerKt.sourceInformation($composer4, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & SdkConfig.SDK_VERSION));
                                                int $changed$iv$iv = (6 << 3) & SdkConfig.SDK_VERSION;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object consume2 = $composer4.consume(localDensity2);
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                Density density$iv$iv = (Density) consume2;
                                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object consume3 = $composer4.consume(localLayoutDirection);
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
                                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object consume4 = $composer4.consume(localViewConfiguration);
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
                                                Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    $composer4.createNode(factory$iv$iv$iv);
                                                } else {
                                                    $composer4.useNode();
                                                }
                                                $composer4.disableReusing();
                                                Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer4);
                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                $composer4.enableReusing();
                                                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                                                $composer4.startReplaceableGroup(-1163856341);
                                                ComposerKt.sourceInformation($composer4, "C79@3994L9:Column.kt#2w3rfo");
                                                if (($changed$iv & 11) == 2 && $composer4.getSkipping()) {
                                                    $composer4.skipToGroupEnd();
                                                    $composer$iv = $composer4;
                                                } else {
                                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                                    int $changed5 = ((6 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                                    $composer4.startReplaceableGroup(521184014);
                                                    ComposerKt.sourceInformation($composer4, "C330@14031L48:BottomSheetScaffold.kt#jmzs0o");
                                                    if (($changed5 & 81) != 16 || !$composer4.getSkipping()) {
                                                        $composer4.startReplaceableGroup(-1579943829);
                                                        ComposerKt.sourceInformation($composer4, "329@13994L8");
                                                        if (function25 != null) {
                                                            function25.invoke($composer4, Integer.valueOf((i9 >> 9) & 14));
                                                        }
                                                        $composer4.endReplaceableGroup();
                                                        $composer$iv = $composer4;
                                                        $composer5 = $composer4;
                                                        function36.invoke(PaddingKt.m756PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f5, 7, null), $composer5, Integer.valueOf((i10 >> 3) & SdkConfig.SDK_VERSION));
                                                    } else {
                                                        $composer4.skipToGroupEnd();
                                                        $composer$iv = $composer4;
                                                        $composer5 = $composer4;
                                                    }
                                                    $composer5.endReplaceableGroup();
                                                }
                                                $composer$iv.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), $composer3, ((i5 << 6) & 896) | 1572864 | ((i5 << 6) & 7168), 51);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer3.skipToGroupEnd();
                            }
                        });
                        final Modifier modifier = swipeable;
                        final float f4 = f;
                        final MutableState<Float> mutableState = bottomSheetHeight$delegate;
                        final Shape shape2 = shape;
                        final long j7 = j3;
                        final long j8 = j4;
                        final float f5 = f2;
                        final int i7 = i2;
                        final int i8 = i4;
                        final Function3<ColumnScope, Composer, Integer, Unit> function35 = function32;
                        ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda($composer2, -1113066167, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer3, int $changed3) {
                                Object value$iv$iv2;
                                ComposerKt.sourceInformation($composer3, "C339@14405L108,335@14199L614:BottomSheetScaffold.kt#jmzs0o");
                                if (($changed3 & 11) != 2 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1113066167, $changed3, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:334)");
                                    }
                                    Modifier m791requiredHeightInVpY3zN4$default = SizeKt.m791requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.this, 0.0f, 1, null), f4, 0.0f, 2, null);
                                    Object key1$iv = mutableState;
                                    final MutableState<Float> mutableState2 = mutableState;
                                    $composer3.startReplaceableGroup(1157296644);
                                    ComposerKt.sourceInformation($composer3, "C(remember)P(1):Composables.kt#9igjgp");
                                    boolean invalid$iv$iv = $composer3.changed(key1$iv);
                                    Object it$iv$iv2 = $composer3.rememberedValue();
                                    if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                                        value$iv$iv2 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1$2$1$1
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
                                                BottomSheetScaffoldKt$BottomSheetScaffold$1.m1266invoke$lambda3(mutableState2, IntSize.m4541getHeightimpl(it.mo3497getSizeYbymL2g()));
                                            }
                                        };
                                        $composer3.updateRememberedValue(value$iv$iv2);
                                    } else {
                                        value$iv$iv2 = it$iv$iv2;
                                    }
                                    $composer3.endReplaceableGroup();
                                    Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(m791requiredHeightInVpY3zN4$default, (Function1) value$iv$iv2);
                                    Shape shape3 = shape2;
                                    long j9 = j7;
                                    long j10 = j8;
                                    float f6 = f5;
                                    final Function3<ColumnScope, Composer, Integer, Unit> function36 = function35;
                                    final int i9 = i7;
                                    SurfaceKt.m1513SurfaceFjzlyU(onGloballyPositioned, shape3, j9, j10, null, f6, ComposableLambdaKt.composableLambda($composer3, 170554245, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.BottomSheetScaffold.1.child.1.2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                            invoke(composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer $composer4, int $changed4) {
                                            ComposerKt.sourceInformation($composer4, "C346@14759L30:BottomSheetScaffold.kt#jmzs0o");
                                            if (($changed4 & 11) == 2 && $composer4.getSkipping()) {
                                                $composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(170554245, $changed4, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:346)");
                                            }
                                            Function3 content$iv = function36;
                                            int $changed$iv = (i9 << 9) & 7168;
                                            $composer4.startReplaceableGroup(-483455358);
                                            ComposerKt.sourceInformation($composer4, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                            Modifier modifier$iv = Modifier.INSTANCE;
                                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & SdkConfig.SDK_VERSION));
                                            int $changed$iv$iv = ($changed$iv << 3) & SdkConfig.SDK_VERSION;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object consume2 = $composer4.consume(localDensity2);
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            Density density$iv$iv = (Density) consume2;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object consume3 = $composer4.consume(localLayoutDirection);
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object consume4 = $composer4.consume(localViewConfiguration);
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
                                            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                $composer4.createNode(factory$iv$iv$iv);
                                            } else {
                                                $composer4.useNode();
                                            }
                                            $composer4.disableReusing();
                                            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer4);
                                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            $composer4.enableReusing();
                                            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                                            $composer4.startReplaceableGroup(2058660585);
                                            $composer4.startReplaceableGroup(-1163856341);
                                            ComposerKt.sourceInformation($composer4, "C79@3994L9:Column.kt#2w3rfo");
                                            if ((($changed$iv$iv$iv >> 9) & 14 & 11) == 2 && $composer4.getSkipping()) {
                                                $composer4.skipToGroupEnd();
                                            } else {
                                                content$iv.invoke(ColumnScopeInstance.INSTANCE, $composer4, Integer.valueOf((($changed$iv >> 6) & SdkConfig.SDK_VERSION) | 6));
                                            }
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), $composer3, ((i7 >> 21) & SdkConfig.SDK_VERSION) | 1572864 | ((i8 << 6) & 896) | ((i8 << 6) & 7168) | ((i7 >> 12) & 458752), 16);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer3.skipToGroupEnd();
                            }
                        });
                        final Function2<Composer, Integer, Unit> function24 = function22;
                        final int i9 = i2;
                        ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda($composer2, 1339151882, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer3, int $changed3) {
                                ComposerKt.sourceInformation($composer3, "C350@14894L82:BottomSheetScaffold.kt#jmzs0o");
                                if (($changed3 & 11) != 2 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1339151882, $changed3, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:349)");
                                    }
                                    Function2<Composer, Integer, Unit> function25 = function24;
                                    int i10 = i9;
                                    $composer3.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                    Modifier modifier$iv = Modifier.INSTANCE;
                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                                    int $changed$iv$iv = (0 << 3) & SdkConfig.SDK_VERSION;
                                    $composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume2 = $composer3.consume(localDensity2);
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    Density density$iv$iv = (Density) consume2;
                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume3 = $composer3.consume(localLayoutDirection);
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume4 = $composer3.consume(localViewConfiguration);
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
                                    Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                                    int $i$f$Box = $changed$iv$iv << 9;
                                    int $changed$iv$iv$iv = ($i$f$Box & 7168) | 6;
                                    if (!($composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer3.startReusableNode();
                                    if ($composer3.getInserting()) {
                                        $composer3.createNode(factory$iv$iv$iv);
                                    } else {
                                        $composer3.useNode();
                                    }
                                    $composer3.disableReusing();
                                    Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer3);
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                    $composer3.enableReusing();
                                    skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                                    $composer3.startReplaceableGroup(2058660585);
                                    int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                                    $composer3.startReplaceableGroup(-2137368960);
                                    ComposerKt.sourceInformation($composer3, "C72@3384L9:Box.kt#2w3rfo");
                                    if (($changed$iv & 11) == 2 && $composer3.getSkipping()) {
                                        $composer3.skipToGroupEnd();
                                    } else {
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        int $changed4 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                        $composer3.startReplaceableGroup(-1521336816);
                                        ComposerKt.sourceInformation($composer3, "C351@14946L8:BottomSheetScaffold.kt#jmzs0o");
                                        if (($changed4 & 81) == 16 && $composer3.getSkipping()) {
                                            $composer3.skipToGroupEnd();
                                        } else if (function25 != null) {
                                            function25.invoke($composer3, Integer.valueOf((i10 >> 15) & 14));
                                        }
                                        $composer3.endReplaceableGroup();
                                    }
                                    $composer3.endReplaceableGroup();
                                    $composer3.endReplaceableGroup();
                                    $composer3.endNode();
                                    $composer3.endReplaceableGroup();
                                    $composer3.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer3.skipToGroupEnd();
                            }
                        });
                        final Function3<SnackbarHostState, Composer, Integer, Unit> function36 = function33;
                        final BottomSheetScaffoldState bottomSheetScaffoldState3 = BottomSheetScaffoldState.this;
                        final int i10 = i2;
                        BottomSheetScaffoldKt.m1261BottomSheetScaffoldStackSlNgfk0(composableLambda, composableLambda2, composableLambda3, ComposableLambdaKt.composableLambda($composer2, -503597365, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer3, int $changed3) {
                                ComposerKt.sourceInformation($composer3, "C355@15049L97:BottomSheetScaffold.kt#jmzs0o");
                                if (($changed3 & 11) != 2 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-503597365, $changed3, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:354)");
                                    }
                                    Function3<SnackbarHostState, Composer, Integer, Unit> function37 = function36;
                                    BottomSheetScaffoldState bottomSheetScaffoldState4 = bottomSheetScaffoldState3;
                                    int i11 = i10;
                                    $composer3.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                    Modifier modifier$iv = Modifier.INSTANCE;
                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                                    int $changed$iv$iv = (0 << 3) & SdkConfig.SDK_VERSION;
                                    $composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume2 = $composer3.consume(localDensity2);
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    Density density$iv$iv = (Density) consume2;
                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume3 = $composer3.consume(localLayoutDirection);
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume4 = $composer3.consume(localViewConfiguration);
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
                                    Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                                    int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                    if (!($composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer3.startReusableNode();
                                    if ($composer3.getInserting()) {
                                        $composer3.createNode(factory$iv$iv$iv);
                                    } else {
                                        $composer3.useNode();
                                    }
                                    $composer3.disableReusing();
                                    Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer3);
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                    $composer3.enableReusing();
                                    skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                                    $composer3.startReplaceableGroup(2058660585);
                                    int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                                    $composer3.startReplaceableGroup(-2137368960);
                                    ComposerKt.sourceInformation($composer3, "C72@3384L9:Box.kt#2w3rfo");
                                    if (($changed$iv & 11) == 2 && $composer3.getSkipping()) {
                                        $composer3.skipToGroupEnd();
                                    } else {
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        int $changed4 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                        $composer3.startReplaceableGroup(930881233);
                                        ComposerKt.sourceInformation($composer3, "C356@15079L45:BottomSheetScaffold.kt#jmzs0o");
                                        if (($changed4 & 81) == 16 && $composer3.getSkipping()) {
                                            $composer3.skipToGroupEnd();
                                        } else {
                                            function37.invoke(bottomSheetScaffoldState4.getSnackbarHostState(), $composer3, Integer.valueOf((i11 >> 9) & SdkConfig.SDK_VERSION));
                                        }
                                        $composer3.endReplaceableGroup();
                                    }
                                    $composer3.endReplaceableGroup();
                                    $composer3.endReplaceableGroup();
                                    $composer3.endNode();
                                    $composer3.endReplaceableGroup();
                                    $composer3.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer3.skipToGroupEnd();
                            }
                        }), BottomSheetScaffoldState.this.getBottomSheetState().getOffset(), i, $composer2, ((i2 >> 3) & 458752) | 3510);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer2.skipToGroupEnd();
                }
            });
            if (this.$drawerContent == null) {
                $composer.startReplaceableGroup(-249545651);
                ComposerKt.sourceInformation($composer, "364@15390L7");
                child.invoke($composer, 6);
                $composer.endReplaceableGroup();
            } else {
                $composer.startReplaceableGroup(-249545614);
                ComposerKt.sourceInformation($composer, "366@15427L480");
                DrawerKt.m1366ModalDrawerGs3lGvM(this.$drawerContent, null, this.$scaffoldState.getDrawerState(), this.$drawerGesturesEnabled, this.$drawerShape, this.$drawerElevation, this.$drawerBackgroundColor, this.$drawerContentColor, this.$drawerScrimColor, child, $composer, ((this.$$dirty1 >> 9) & 14) | 805306368 | ((this.$$dirty1 >> 3) & 7168) | ((this.$$dirty1 >> 3) & 57344) | ((this.$$dirty1 >> 3) & 458752) | ((this.$$dirty1 >> 3) & 3670016) | ((this.$$dirty1 >> 3) & 29360128) | ((this.$$dirty1 >> 3) & 234881024), 2);
                $composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2, reason: not valid java name */
    public static final float m1265invoke$lambda2(MutableState<Float> mutableState) {
        MutableState<Float> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-3, reason: not valid java name */
    public static final void m1266invoke$lambda3(MutableState<Float> mutableState, float value) {
        mutableState.setValue(Float.valueOf(value));
    }
}
