package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
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
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.IntOffsetKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.health.platform.client.SdkConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Drawer.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class DrawerKt$BottomDrawer$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ BottomDrawerState $drawerState;
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $scrimColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DrawerKt$BottomDrawer$1(boolean z, BottomDrawerState bottomDrawerState, Function2<? super Composer, ? super Integer, Unit> function2, int i, long j, Shape shape, long j2, long j3, float f, CoroutineScope coroutineScope, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.$gesturesEnabled = z;
        this.$drawerState = bottomDrawerState;
        this.$content = function2;
        this.$$dirty = i;
        this.$scrimColor = j;
        this.$drawerShape = shape;
        this.$drawerBackgroundColor = j2;
        this.$drawerContentColor = j3;
        this.$drawerElevation = f;
        this.$scope = coroutineScope;
        this.$drawerContent = function3;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
        invoke(boxWithConstraintsScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x03ed A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke(BoxWithConstraintsScope BoxWithConstraints, Composer $composer, int $changed) {
        Object value$iv$iv;
        int i;
        Map anchors;
        Modifier.Companion nestedScroll;
        Modifier swipeable;
        int $changed$iv;
        int $changed2;
        boolean invalid$iv$iv;
        boolean invalid$iv$iv2;
        Object it$iv$iv;
        Object value$iv$iv2;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C512@19019L51,*531@19859L7,553@20546L1672:Drawer.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer.changed(BoxWithConstraints) ? 4 : 2;
        }
        if (($dirty & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1220102512, $changed, -1, "androidx.compose.material.BottomDrawer.<anonymous> (Drawer.kt:510)");
            }
            float fullHeight = Constraints.m4337getMaxHeightimpl(BoxWithConstraints.getConstraints());
            Object key1$iv = Float.valueOf(fullHeight);
            $composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv3 = $composer.changed(key1$iv);
            Object it$iv$iv2 = $composer.rememberedValue();
            if (invalid$iv$iv3 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(fullHeight), null, 2, null);
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv2;
            }
            $composer.endReplaceableGroup();
            final MutableState drawerHeight$delegate = (MutableState) value$iv$iv;
            boolean isLandscape = Constraints.m4338getMaxWidthimpl(BoxWithConstraints.getConstraints()) > Constraints.m4337getMaxHeightimpl(BoxWithConstraints.getConstraints());
            float peekHeight = 0.5f * fullHeight;
            float expandedHeight = Math.max(0.0f, fullHeight - m1372invoke$lambda1(drawerHeight$delegate));
            if (m1372invoke$lambda1(drawerHeight$delegate) < peekHeight) {
                i = 2;
            } else {
                if (!isLandscape) {
                    anchors = MapsKt.mapOf(TuplesKt.m294to(Float.valueOf(fullHeight), BottomDrawerValue.Closed), TuplesKt.m294to(Float.valueOf(peekHeight), BottomDrawerValue.Open), TuplesKt.m294to(Float.valueOf(expandedHeight), BottomDrawerValue.Expanded));
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume = $composer.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Density $this$invoke_u24lambda_u2d3 = (Density) consume;
                    Modifier drawerConstraints = SizeKt.m804sizeInqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, $this$invoke_u24lambda_u2d3.mo645toDpu2uoSUM(Constraints.m4338getMaxWidthimpl(BoxWithConstraints.getConstraints())), $this$invoke_u24lambda_u2d3.mo645toDpu2uoSUM(Constraints.m4337getMaxHeightimpl(BoxWithConstraints.getConstraints())), 3, null);
                    if (this.$gesturesEnabled) {
                        nestedScroll = Modifier.INSTANCE;
                    } else {
                        nestedScroll = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, this.$drawerState.getNestedScrollConnection(), null, 2, null);
                    }
                    swipeable = SwipeableKt.m1523swipeablepPrIpRY(Modifier.INSTANCE.then(nestedScroll), this.$drawerState, anchors, Orientation.Vertical, (r26 & 8) != 0 ? true : this.$gesturesEnabled, (r26 & 16) != 0 ? false : false, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function2
                        public final FixedThreshold invoke(T t, T t2) {
                            return new FixedThreshold(C0504Dp.m4382constructorimpl(56), null);
                        }
                    } : null, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, anchors.keySet(), 0.0f, 0.0f, 6, null) : null, (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1522getVelocityThresholdD9Ej5fM() : 0.0f);
                    Function2<Composer, Integer, Unit> function2 = this.$content;
                    final int i2 = this.$$dirty;
                    long j = this.$scrimColor;
                    final BottomDrawerState bottomDrawerState = this.$drawerState;
                    Shape shape = this.$drawerShape;
                    long j2 = this.$drawerBackgroundColor;
                    long j3 = this.$drawerContentColor;
                    float f = this.$drawerElevation;
                    final boolean z = this.$gesturesEnabled;
                    final CoroutineScope coroutineScope = this.$scope;
                    final Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$drawerContent;
                    $composer.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv = (0 << 3) & SdkConfig.SDK_VERSION;
                    $composer.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Density density$iv$iv = (Density) consume2;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume3 = $composer.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume4 = $composer.consume(localViewConfiguration);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
                    Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(swipeable);
                    int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if (!$composer.getInserting()) {
                        $composer.createNode(factory$iv$iv$iv);
                    } else {
                        $composer.useNode();
                    }
                    $composer.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer);
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    $composer.enableReusing();
                    skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                    $composer.startReplaceableGroup(2058660585);
                    $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                    $composer.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer, "C72@3384L9:Box.kt#2w3rfo");
                    if (($changed$iv & 11) != 2 && $composer.getSkipping()) {
                        $composer.skipToGroupEnd();
                    } else {
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        $changed2 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        $composer.startReplaceableGroup(-1660053078);
                        ComposerKt.sourceInformation($composer, "C554@20575L9,555@20597L427,566@21058L33,569@21175L63,570@21281L105,567@21104L1104:Drawer.kt#jmzs0o");
                        if (($changed2 & 81) == 16 || !$composer.getSkipping()) {
                            function2.invoke($composer, Integer.valueOf((i2 >> 27) & 14));
                            DrawerKt.m1364BottomDrawerScrim3JVO9M(j, new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    if (z && bottomDrawerState.getConfirmStateChange$material_release().invoke(BottomDrawerValue.Closed).booleanValue()) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C03091(bottomDrawerState, null), 3, null);
                                    }
                                }

                                /* compiled from: Drawer.kt */
                                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                @DebugMetadata(m296c = "androidx.compose.material.DrawerKt$BottomDrawer$1$1$1$1", m297f = "Drawer.kt", m298i = {}, m299l = {562}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                /* renamed from: androidx.compose.material.DrawerKt$BottomDrawer$1$1$1$1 */
                                static final class C03091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ BottomDrawerState $drawerState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    C03091(BottomDrawerState bottomDrawerState, Continuation<? super C03091> continuation) {
                                        super(2, continuation);
                                        this.$drawerState = bottomDrawerState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new C03091(this.$drawerState, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((C03091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object $result) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                this.label = 1;
                                                if (this.$drawerState.close(this) != coroutine_suspended) {
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
                            }, bottomDrawerState.getTargetValue() == BottomDrawerValue.Closed, $composer, (i2 >> 24) & 14);
                            final String navigationMenu = Strings_androidKt.m1511getString4foXLRw(Strings.INSTANCE.m1508getNavigationMenuUdPEhr4(), $composer, 6);
                            int i3 = (i2 >> 6) & 14;
                            $composer.startReplaceableGroup(1157296644);
                            ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                            invalid$iv$iv = $composer.changed(bottomDrawerState);
                            Object value$iv$iv3 = $composer.rememberedValue();
                            if (!invalid$iv$iv && value$iv$iv3 != Composer.INSTANCE.getEmpty()) {
                                $composer.endReplaceableGroup();
                                Modifier offset = OffsetKt.offset(drawerConstraints, (Function1) value$iv$iv3);
                                $composer.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                                invalid$iv$iv2 = $composer.changed(drawerHeight$delegate);
                                it$iv$iv = $composer.rememberedValue();
                                if (!invalid$iv$iv2 && it$iv$iv != Composer.INSTANCE.getEmpty()) {
                                    value$iv$iv2 = it$iv$iv;
                                    $composer.endReplaceableGroup();
                                    int i4 = i2 >> 12;
                                    SurfaceKt.m1513SurfaceFjzlyU(SemanticsModifierKt.semantics$default(OnGloballyPositionedModifierKt.onGloballyPositioned(offset, (Function1) value$iv$iv2), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4
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
                                            SemanticsPropertiesKt.setPaneTitle(semantics, navigationMenu);
                                            if (bottomDrawerState.isOpen()) {
                                                final BottomDrawerState bottomDrawerState2 = bottomDrawerState;
                                                final CoroutineScope coroutineScope2 = coroutineScope;
                                                SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Boolean invoke() {
                                                        if (BottomDrawerState.this.getConfirmStateChange$material_release().invoke(BottomDrawerValue.Closed).booleanValue()) {
                                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(BottomDrawerState.this, null), 3, null);
                                                        }
                                                        return true;
                                                    }

                                                    /* compiled from: Drawer.kt */
                                                    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                                    @DebugMetadata(m296c = "androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1$1", m297f = "Drawer.kt", m298i = {}, m299l = {580}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                                    /* renamed from: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1$1, reason: invalid class name */
                                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                        final /* synthetic */ BottomDrawerState $drawerState;
                                                        int label;

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        AnonymousClass1(BottomDrawerState bottomDrawerState, Continuation<? super AnonymousClass1> continuation) {
                                                            super(2, continuation);
                                                            this.$drawerState = bottomDrawerState;
                                                        }

                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                            return new AnonymousClass1(this.$drawerState, continuation);
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
                                                                    if (this.$drawerState.close(this) != coroutine_suspended) {
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
                                    }, 1, null), shape, j2, j3, null, f, ComposableLambdaKt.composableLambda($composer, 457750254, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$5
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

                                        public final void invoke(Composer $composer2, int $changed3) {
                                            ComposerKt.sourceInformation($composer2, "C589@22163L31:Drawer.kt#jmzs0o");
                                            if (($changed3 & 11) == 2 && $composer2.getSkipping()) {
                                                $composer2.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(457750254, $changed3, -1, "androidx.compose.material.BottomDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:588)");
                                            }
                                            Function3 content$iv = function3;
                                            int $changed$iv2 = (i2 << 9) & 7168;
                                            $composer2.startReplaceableGroup(-483455358);
                                            ComposerKt.sourceInformation($composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                            Modifier modifier$iv = Modifier.INSTANCE;
                                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv2 >> 3) & 14) | (($changed$iv2 >> 3) & SdkConfig.SDK_VERSION));
                                            int $changed$iv$iv2 = ($changed$iv2 << 3) & SdkConfig.SDK_VERSION;
                                            $composer2.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object consume5 = $composer2.consume(localDensity3);
                                            ComposerKt.sourceInformationMarkerEnd($composer2);
                                            Density density$iv$iv2 = (Density) consume5;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object consume6 = $composer2.consume(localLayoutDirection2);
                                            ComposerKt.sourceInformationMarkerEnd($composer2);
                                            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume6;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object consume7 = $composer2.consume(localViewConfiguration2);
                                            ComposerKt.sourceInformationMarkerEnd($composer2);
                                            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume7;
                                            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv);
                                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                                            if (!($composer2.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer2.startReusableNode();
                                            if ($composer2.getInserting()) {
                                                $composer2.createNode(factory$iv$iv$iv2);
                                            } else {
                                                $composer2.useNode();
                                            }
                                            $composer2.disableReusing();
                                            Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer2);
                                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            $composer2.enableReusing();
                                            skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                                            $composer2.startReplaceableGroup(2058660585);
                                            $composer2.startReplaceableGroup(-1163856341);
                                            ComposerKt.sourceInformation($composer2, "C79@3994L9:Column.kt#2w3rfo");
                                            if ((($changed$iv$iv$iv2 >> 9) & 14 & 11) == 2 && $composer2.getSkipping()) {
                                                $composer2.skipToGroupEnd();
                                            } else {
                                                content$iv.invoke(ColumnScopeInstance.INSTANCE, $composer2, Integer.valueOf((($changed$iv2 >> 6) & SdkConfig.SDK_VERSION) | 6));
                                            }
                                            $composer2.endReplaceableGroup();
                                            $composer2.endReplaceableGroup();
                                            $composer2.endNode();
                                            $composer2.endReplaceableGroup();
                                            $composer2.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), $composer, ((i2 >> 9) & SdkConfig.SDK_VERSION) | 1572864 | (i4 & 896) | (i4 & 7168) | (458752 & i2), 16);
                                }
                                value$iv$iv2 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$3$1
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
                                    public final void invoke2(LayoutCoordinates position) {
                                        Intrinsics.checkNotNullParameter(position, "position");
                                        DrawerKt$BottomDrawer$1.m1373invoke$lambda2(drawerHeight$delegate, IntSize.m4541getHeightimpl(position.mo3497getSizeYbymL2g()));
                                    }
                                };
                                $composer.updateRememberedValue(value$iv$iv2);
                                $composer.endReplaceableGroup();
                                int i42 = i2 >> 12;
                                SurfaceKt.m1513SurfaceFjzlyU(SemanticsModifierKt.semantics$default(OnGloballyPositionedModifierKt.onGloballyPositioned(offset, (Function1) value$iv$iv2), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4
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
                                        SemanticsPropertiesKt.setPaneTitle(semantics, navigationMenu);
                                        if (bottomDrawerState.isOpen()) {
                                            final BottomDrawerState bottomDrawerState2 = bottomDrawerState;
                                            final CoroutineScope coroutineScope2 = coroutineScope;
                                            SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    if (BottomDrawerState.this.getConfirmStateChange$material_release().invoke(BottomDrawerValue.Closed).booleanValue()) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(BottomDrawerState.this, null), 3, null);
                                                    }
                                                    return true;
                                                }

                                                /* compiled from: Drawer.kt */
                                                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                                @DebugMetadata(m296c = "androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1$1", m297f = "Drawer.kt", m298i = {}, m299l = {580}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                                /* renamed from: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1$1, reason: invalid class name */
                                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ BottomDrawerState $drawerState;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    AnonymousClass1(BottomDrawerState bottomDrawerState, Continuation<? super AnonymousClass1> continuation) {
                                                        super(2, continuation);
                                                        this.$drawerState = bottomDrawerState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new AnonymousClass1(this.$drawerState, continuation);
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
                                                                if (this.$drawerState.close(this) != coroutine_suspended) {
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
                                }, 1, null), shape, j2, j3, null, f, ComposableLambdaKt.composableLambda($composer, 457750254, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$5
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

                                    public final void invoke(Composer $composer2, int $changed3) {
                                        ComposerKt.sourceInformation($composer2, "C589@22163L31:Drawer.kt#jmzs0o");
                                        if (($changed3 & 11) == 2 && $composer2.getSkipping()) {
                                            $composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(457750254, $changed3, -1, "androidx.compose.material.BottomDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:588)");
                                        }
                                        Function3 content$iv = function3;
                                        int $changed$iv2 = (i2 << 9) & 7168;
                                        $composer2.startReplaceableGroup(-483455358);
                                        ComposerKt.sourceInformation($composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                        Modifier modifier$iv = Modifier.INSTANCE;
                                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv2 >> 3) & 14) | (($changed$iv2 >> 3) & SdkConfig.SDK_VERSION));
                                        int $changed$iv$iv2 = ($changed$iv2 << 3) & SdkConfig.SDK_VERSION;
                                        $composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume5 = $composer2.consume(localDensity3);
                                        ComposerKt.sourceInformationMarkerEnd($composer2);
                                        Density density$iv$iv2 = (Density) consume5;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume6 = $composer2.consume(localLayoutDirection2);
                                        ComposerKt.sourceInformationMarkerEnd($composer2);
                                        LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume6;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume7 = $composer2.consume(localViewConfiguration2);
                                        ComposerKt.sourceInformationMarkerEnd($composer2);
                                        ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume7;
                                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv);
                                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                                        if (!($composer2.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer2.startReusableNode();
                                        if ($composer2.getInserting()) {
                                            $composer2.createNode(factory$iv$iv$iv2);
                                        } else {
                                            $composer2.useNode();
                                        }
                                        $composer2.disableReusing();
                                        Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer2);
                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        $composer2.enableReusing();
                                        skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                                        $composer2.startReplaceableGroup(2058660585);
                                        $composer2.startReplaceableGroup(-1163856341);
                                        ComposerKt.sourceInformation($composer2, "C79@3994L9:Column.kt#2w3rfo");
                                        if ((($changed$iv$iv$iv2 >> 9) & 14 & 11) == 2 && $composer2.getSkipping()) {
                                            $composer2.skipToGroupEnd();
                                        } else {
                                            content$iv.invoke(ColumnScopeInstance.INSTANCE, $composer2, Integer.valueOf((($changed$iv2 >> 6) & SdkConfig.SDK_VERSION) | 6));
                                        }
                                        $composer2.endReplaceableGroup();
                                        $composer2.endReplaceableGroup();
                                        $composer2.endNode();
                                        $composer2.endReplaceableGroup();
                                        $composer2.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), $composer, ((i2 >> 9) & SdkConfig.SDK_VERSION) | 1572864 | (i42 & 896) | (i42 & 7168) | (458752 & i2), 16);
                            }
                            value$iv$iv3 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$2$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                    return IntOffset.m4491boximpl(m1374invokeBjo55l4(density));
                                }

                                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                public final long m1374invokeBjo55l4(Density offset2) {
                                    Intrinsics.checkNotNullParameter(offset2, "$this$offset");
                                    return IntOffsetKt.IntOffset(0, MathKt.roundToInt(BottomDrawerState.this.getOffset().getValue().floatValue()));
                                }
                            };
                            $composer.updateRememberedValue(value$iv$iv3);
                            $composer.endReplaceableGroup();
                            Modifier offset2 = OffsetKt.offset(drawerConstraints, (Function1) value$iv$iv3);
                            $composer.startReplaceableGroup(1157296644);
                            ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                            invalid$iv$iv2 = $composer.changed(drawerHeight$delegate);
                            it$iv$iv = $composer.rememberedValue();
                            if (!invalid$iv$iv2) {
                                value$iv$iv2 = it$iv$iv;
                                $composer.endReplaceableGroup();
                                int i422 = i2 >> 12;
                                SurfaceKt.m1513SurfaceFjzlyU(SemanticsModifierKt.semantics$default(OnGloballyPositionedModifierKt.onGloballyPositioned(offset2, (Function1) value$iv$iv2), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4
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
                                        SemanticsPropertiesKt.setPaneTitle(semantics, navigationMenu);
                                        if (bottomDrawerState.isOpen()) {
                                            final BottomDrawerState bottomDrawerState2 = bottomDrawerState;
                                            final CoroutineScope coroutineScope2 = coroutineScope;
                                            SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    if (BottomDrawerState.this.getConfirmStateChange$material_release().invoke(BottomDrawerValue.Closed).booleanValue()) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(BottomDrawerState.this, null), 3, null);
                                                    }
                                                    return true;
                                                }

                                                /* compiled from: Drawer.kt */
                                                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                                @DebugMetadata(m296c = "androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1$1", m297f = "Drawer.kt", m298i = {}, m299l = {580}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                                /* renamed from: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1$1, reason: invalid class name */
                                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ BottomDrawerState $drawerState;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    AnonymousClass1(BottomDrawerState bottomDrawerState, Continuation<? super AnonymousClass1> continuation) {
                                                        super(2, continuation);
                                                        this.$drawerState = bottomDrawerState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new AnonymousClass1(this.$drawerState, continuation);
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
                                                                if (this.$drawerState.close(this) != coroutine_suspended) {
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
                                }, 1, null), shape, j2, j3, null, f, ComposableLambdaKt.composableLambda($composer, 457750254, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$5
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

                                    public final void invoke(Composer $composer2, int $changed3) {
                                        ComposerKt.sourceInformation($composer2, "C589@22163L31:Drawer.kt#jmzs0o");
                                        if (($changed3 & 11) == 2 && $composer2.getSkipping()) {
                                            $composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(457750254, $changed3, -1, "androidx.compose.material.BottomDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:588)");
                                        }
                                        Function3 content$iv = function3;
                                        int $changed$iv2 = (i2 << 9) & 7168;
                                        $composer2.startReplaceableGroup(-483455358);
                                        ComposerKt.sourceInformation($composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                        Modifier modifier$iv = Modifier.INSTANCE;
                                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv2 >> 3) & 14) | (($changed$iv2 >> 3) & SdkConfig.SDK_VERSION));
                                        int $changed$iv$iv2 = ($changed$iv2 << 3) & SdkConfig.SDK_VERSION;
                                        $composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume5 = $composer2.consume(localDensity3);
                                        ComposerKt.sourceInformationMarkerEnd($composer2);
                                        Density density$iv$iv2 = (Density) consume5;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume6 = $composer2.consume(localLayoutDirection2);
                                        ComposerKt.sourceInformationMarkerEnd($composer2);
                                        LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume6;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume7 = $composer2.consume(localViewConfiguration2);
                                        ComposerKt.sourceInformationMarkerEnd($composer2);
                                        ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume7;
                                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv);
                                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                                        if (!($composer2.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer2.startReusableNode();
                                        if ($composer2.getInserting()) {
                                            $composer2.createNode(factory$iv$iv$iv2);
                                        } else {
                                            $composer2.useNode();
                                        }
                                        $composer2.disableReusing();
                                        Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer2);
                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        $composer2.enableReusing();
                                        skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                                        $composer2.startReplaceableGroup(2058660585);
                                        $composer2.startReplaceableGroup(-1163856341);
                                        ComposerKt.sourceInformation($composer2, "C79@3994L9:Column.kt#2w3rfo");
                                        if ((($changed$iv$iv$iv2 >> 9) & 14 & 11) == 2 && $composer2.getSkipping()) {
                                            $composer2.skipToGroupEnd();
                                        } else {
                                            content$iv.invoke(ColumnScopeInstance.INSTANCE, $composer2, Integer.valueOf((($changed$iv2 >> 6) & SdkConfig.SDK_VERSION) | 6));
                                        }
                                        $composer2.endReplaceableGroup();
                                        $composer2.endReplaceableGroup();
                                        $composer2.endNode();
                                        $composer2.endReplaceableGroup();
                                        $composer2.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), $composer, ((i2 >> 9) & SdkConfig.SDK_VERSION) | 1572864 | (i422 & 896) | (i422 & 7168) | (458752 & i2), 16);
                            }
                            value$iv$iv2 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$3$1
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
                                public final void invoke2(LayoutCoordinates position) {
                                    Intrinsics.checkNotNullParameter(position, "position");
                                    DrawerKt$BottomDrawer$1.m1373invoke$lambda2(drawerHeight$delegate, IntSize.m4541getHeightimpl(position.mo3497getSizeYbymL2g()));
                                }
                            };
                            $composer.updateRememberedValue(value$iv$iv2);
                            $composer.endReplaceableGroup();
                            int i4222 = i2 >> 12;
                            SurfaceKt.m1513SurfaceFjzlyU(SemanticsModifierKt.semantics$default(OnGloballyPositionedModifierKt.onGloballyPositioned(offset2, (Function1) value$iv$iv2), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4
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
                                    SemanticsPropertiesKt.setPaneTitle(semantics, navigationMenu);
                                    if (bottomDrawerState.isOpen()) {
                                        final BottomDrawerState bottomDrawerState2 = bottomDrawerState;
                                        final CoroutineScope coroutineScope2 = coroutineScope;
                                        SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                if (BottomDrawerState.this.getConfirmStateChange$material_release().invoke(BottomDrawerValue.Closed).booleanValue()) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(BottomDrawerState.this, null), 3, null);
                                                }
                                                return true;
                                            }

                                            /* compiled from: Drawer.kt */
                                            @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                            @DebugMetadata(m296c = "androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1$1", m297f = "Drawer.kt", m298i = {}, m299l = {580}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                            /* renamed from: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1$1, reason: invalid class name */
                                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ BottomDrawerState $drawerState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                AnonymousClass1(BottomDrawerState bottomDrawerState, Continuation<? super AnonymousClass1> continuation) {
                                                    super(2, continuation);
                                                    this.$drawerState = bottomDrawerState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new AnonymousClass1(this.$drawerState, continuation);
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
                                                            if (this.$drawerState.close(this) != coroutine_suspended) {
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
                            }, 1, null), shape, j2, j3, null, f, ComposableLambdaKt.composableLambda($composer, 457750254, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$5
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

                                public final void invoke(Composer $composer2, int $changed3) {
                                    ComposerKt.sourceInformation($composer2, "C589@22163L31:Drawer.kt#jmzs0o");
                                    if (($changed3 & 11) == 2 && $composer2.getSkipping()) {
                                        $composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(457750254, $changed3, -1, "androidx.compose.material.BottomDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:588)");
                                    }
                                    Function3 content$iv = function3;
                                    int $changed$iv2 = (i2 << 9) & 7168;
                                    $composer2.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation($composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                    Modifier modifier$iv = Modifier.INSTANCE;
                                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                    Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                    MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv2 >> 3) & 14) | (($changed$iv2 >> 3) & SdkConfig.SDK_VERSION));
                                    int $changed$iv$iv2 = ($changed$iv2 << 3) & SdkConfig.SDK_VERSION;
                                    $composer2.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume5 = $composer2.consume(localDensity3);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    Density density$iv$iv2 = (Density) consume5;
                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume6 = $composer2.consume(localLayoutDirection2);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume6;
                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume7 = $composer2.consume(localViewConfiguration2);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume7;
                                    Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv);
                                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                                    if (!($composer2.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer2.startReusableNode();
                                    if ($composer2.getInserting()) {
                                        $composer2.createNode(factory$iv$iv$iv2);
                                    } else {
                                        $composer2.useNode();
                                    }
                                    $composer2.disableReusing();
                                    Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer2);
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                    $composer2.enableReusing();
                                    skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                                    $composer2.startReplaceableGroup(2058660585);
                                    $composer2.startReplaceableGroup(-1163856341);
                                    ComposerKt.sourceInformation($composer2, "C79@3994L9:Column.kt#2w3rfo");
                                    if ((($changed$iv$iv$iv2 >> 9) & 14 & 11) == 2 && $composer2.getSkipping()) {
                                        $composer2.skipToGroupEnd();
                                    } else {
                                        content$iv.invoke(ColumnScopeInstance.INSTANCE, $composer2, Integer.valueOf((($changed$iv2 >> 6) & SdkConfig.SDK_VERSION) | 6));
                                    }
                                    $composer2.endReplaceableGroup();
                                    $composer2.endReplaceableGroup();
                                    $composer2.endNode();
                                    $composer2.endReplaceableGroup();
                                    $composer2.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), $composer, ((i2 >> 9) & SdkConfig.SDK_VERSION) | 1572864 | (i4222 & 896) | (i4222 & 7168) | (458752 & i2), 16);
                        } else {
                            $composer.skipToGroupEnd();
                        }
                        $composer.endReplaceableGroup();
                    }
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    $composer.endNode();
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                i = 2;
            }
            Pair[] pairArr = new Pair[i];
            pairArr[0] = TuplesKt.m294to(Float.valueOf(fullHeight), BottomDrawerValue.Closed);
            pairArr[1] = TuplesKt.m294to(Float.valueOf(expandedHeight), BottomDrawerValue.Expanded);
            anchors = MapsKt.mapOf(pairArr);
            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer.consume(localDensity3);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density $this$invoke_u24lambda_u2d32 = (Density) consume5;
            Modifier drawerConstraints2 = SizeKt.m804sizeInqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, $this$invoke_u24lambda_u2d32.mo645toDpu2uoSUM(Constraints.m4338getMaxWidthimpl(BoxWithConstraints.getConstraints())), $this$invoke_u24lambda_u2d32.mo645toDpu2uoSUM(Constraints.m4337getMaxHeightimpl(BoxWithConstraints.getConstraints())), 3, null);
            if (this.$gesturesEnabled) {
            }
            swipeable = SwipeableKt.m1523swipeablepPrIpRY(Modifier.INSTANCE.then(nestedScroll), this.$drawerState, anchors, Orientation.Vertical, (r26 & 8) != 0 ? true : this.$gesturesEnabled, (r26 & 16) != 0 ? false : false, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function2
                public final FixedThreshold invoke(T t, T t2) {
                    return new FixedThreshold(C0504Dp.m4382constructorimpl(56), null);
                }
            } : null, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, anchors.keySet(), 0.0f, 0.0f, 6, null) : null, (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1522getVelocityThresholdD9Ej5fM() : 0.0f);
            Function2<Composer, Integer, Unit> function22 = this.$content;
            final int i22 = this.$$dirty;
            long j4 = this.$scrimColor;
            final BottomDrawerState bottomDrawerState2 = this.$drawerState;
            Shape shape2 = this.$drawerShape;
            long j22 = this.$drawerBackgroundColor;
            long j32 = this.$drawerContentColor;
            float f2 = this.$drawerElevation;
            final boolean z2 = this.$gesturesEnabled;
            final CoroutineScope coroutineScope2 = this.$scope;
            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = this.$drawerContent;
            $composer.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
            int $changed$iv$iv2 = (0 << 3) & SdkConfig.SDK_VERSION;
            $composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume22 = $composer.consume(localDensity22);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density$iv$iv2 = (Density) consume22;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume32 = $composer.consume(localLayoutDirection2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume32;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume42 = $composer.consume(localViewConfiguration2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume42;
            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(swipeable);
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
            if (!($composer.getApplier() instanceof Applier)) {
            }
            $composer.startReusableNode();
            if (!$composer.getInserting()) {
            }
            $composer.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer);
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer.enableReusing();
            skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
            $composer.startReplaceableGroup(2058660585);
            $changed$iv = ($changed$iv$iv$iv2 >> 9) & 14;
            $composer.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation($composer, "C72@3384L9:Box.kt#2w3rfo");
            if (($changed$iv & 11) != 2) {
            }
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            $changed2 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
            $composer.startReplaceableGroup(-1660053078);
            ComposerKt.sourceInformation($composer, "C554@20575L9,555@20597L427,566@21058L33,569@21175L63,570@21281L105,567@21104L1104:Drawer.kt#jmzs0o");
            if (($changed2 & 81) == 16) {
            }
            function22.invoke($composer, Integer.valueOf((i22 >> 27) & 14));
            DrawerKt.m1364BottomDrawerScrim3JVO9M(j4, new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    if (z2 && bottomDrawerState2.getConfirmStateChange$material_release().invoke(BottomDrawerValue.Closed).booleanValue()) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C03091(bottomDrawerState2, null), 3, null);
                    }
                }

                /* compiled from: Drawer.kt */
                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                @DebugMetadata(m296c = "androidx.compose.material.DrawerKt$BottomDrawer$1$1$1$1", m297f = "Drawer.kt", m298i = {}, m299l = {562}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                /* renamed from: androidx.compose.material.DrawerKt$BottomDrawer$1$1$1$1 */
                static final class C03091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ BottomDrawerState $drawerState;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C03091(BottomDrawerState bottomDrawerState, Continuation<? super C03091> continuation) {
                        super(2, continuation);
                        this.$drawerState = bottomDrawerState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C03091(this.$drawerState, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C03091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                this.label = 1;
                                if (this.$drawerState.close(this) != coroutine_suspended) {
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
            }, bottomDrawerState2.getTargetValue() == BottomDrawerValue.Closed, $composer, (i22 >> 24) & 14);
            final String navigationMenu2 = Strings_androidKt.m1511getString4foXLRw(Strings.INSTANCE.m1508getNavigationMenuUdPEhr4(), $composer, 6);
            int i32 = (i22 >> 6) & 14;
            $composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
            invalid$iv$iv = $composer.changed(bottomDrawerState2);
            Object value$iv$iv32 = $composer.rememberedValue();
            if (!invalid$iv$iv) {
                $composer.endReplaceableGroup();
                Modifier offset22 = OffsetKt.offset(drawerConstraints2, (Function1) value$iv$iv32);
                $composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                invalid$iv$iv2 = $composer.changed(drawerHeight$delegate);
                it$iv$iv = $composer.rememberedValue();
                if (!invalid$iv$iv2) {
                }
                value$iv$iv2 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$3$1
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
                    public final void invoke2(LayoutCoordinates position) {
                        Intrinsics.checkNotNullParameter(position, "position");
                        DrawerKt$BottomDrawer$1.m1373invoke$lambda2(drawerHeight$delegate, IntSize.m4541getHeightimpl(position.mo3497getSizeYbymL2g()));
                    }
                };
                $composer.updateRememberedValue(value$iv$iv2);
                $composer.endReplaceableGroup();
                int i42222 = i22 >> 12;
                SurfaceKt.m1513SurfaceFjzlyU(SemanticsModifierKt.semantics$default(OnGloballyPositionedModifierKt.onGloballyPositioned(offset22, (Function1) value$iv$iv2), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4
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
                        SemanticsPropertiesKt.setPaneTitle(semantics, navigationMenu2);
                        if (bottomDrawerState2.isOpen()) {
                            final BottomDrawerState bottomDrawerState22 = bottomDrawerState2;
                            final CoroutineScope coroutineScope22 = coroutineScope2;
                            SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    if (BottomDrawerState.this.getConfirmStateChange$material_release().invoke(BottomDrawerValue.Closed).booleanValue()) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new AnonymousClass1(BottomDrawerState.this, null), 3, null);
                                    }
                                    return true;
                                }

                                /* compiled from: Drawer.kt */
                                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                @DebugMetadata(m296c = "androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1$1", m297f = "Drawer.kt", m298i = {}, m299l = {580}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                /* renamed from: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1$1, reason: invalid class name */
                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ BottomDrawerState $drawerState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(BottomDrawerState bottomDrawerState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$drawerState = bottomDrawerState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$drawerState, continuation);
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
                                                if (this.$drawerState.close(this) != coroutine_suspended) {
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
                }, 1, null), shape2, j22, j32, null, f2, ComposableLambdaKt.composableLambda($composer, 457750254, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$5
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

                    public final void invoke(Composer $composer2, int $changed3) {
                        ComposerKt.sourceInformation($composer2, "C589@22163L31:Drawer.kt#jmzs0o");
                        if (($changed3 & 11) == 2 && $composer2.getSkipping()) {
                            $composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(457750254, $changed3, -1, "androidx.compose.material.BottomDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:588)");
                        }
                        Function3 content$iv = function32;
                        int $changed$iv2 = (i22 << 9) & 7168;
                        $composer2.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation($composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv22 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv2 >> 3) & 14) | (($changed$iv2 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv22 = ($changed$iv2 << 3) & SdkConfig.SDK_VERSION;
                        $composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity32 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume52 = $composer2.consume(localDensity32);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        Density density$iv$iv22 = (Density) consume52;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume6 = $composer2.consume(localLayoutDirection22);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        LayoutDirection layoutDirection$iv$iv22 = (LayoutDirection) consume6;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration22 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume7 = $composer2.consume(localViewConfiguration22);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ViewConfiguration viewConfiguration$iv$iv22 = (ViewConfiguration) consume7;
                        Function0 factory$iv$iv$iv22 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv22 = LayoutKt.materializerOf(modifier$iv);
                        int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 9) & 7168) | 6;
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if ($composer2.getInserting()) {
                            $composer2.createNode(factory$iv$iv$iv22);
                        } else {
                            $composer2.useNode();
                        }
                        $composer2.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv22 = Updater.m1639constructorimpl($composer2);
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, measurePolicy$iv22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, density$iv$iv22, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, layoutDirection$iv$iv22, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, viewConfiguration$iv$iv22, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer2.enableReusing();
                        skippableUpdate$iv$iv$iv22.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv22 >> 3) & SdkConfig.SDK_VERSION));
                        $composer2.startReplaceableGroup(2058660585);
                        $composer2.startReplaceableGroup(-1163856341);
                        ComposerKt.sourceInformation($composer2, "C79@3994L9:Column.kt#2w3rfo");
                        if ((($changed$iv$iv$iv22 >> 9) & 14 & 11) == 2 && $composer2.getSkipping()) {
                            $composer2.skipToGroupEnd();
                        } else {
                            content$iv.invoke(ColumnScopeInstance.INSTANCE, $composer2, Integer.valueOf((($changed$iv2 >> 6) & SdkConfig.SDK_VERSION) | 6));
                        }
                        $composer2.endReplaceableGroup();
                        $composer2.endReplaceableGroup();
                        $composer2.endNode();
                        $composer2.endReplaceableGroup();
                        $composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), $composer, ((i22 >> 9) & SdkConfig.SDK_VERSION) | 1572864 | (i42222 & 896) | (i42222 & 7168) | (458752 & i22), 16);
                $composer.endReplaceableGroup();
                $composer.endReplaceableGroup();
                $composer.endReplaceableGroup();
                $composer.endNode();
                $composer.endReplaceableGroup();
                $composer.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            value$iv$iv32 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$2$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                    return IntOffset.m4491boximpl(m1374invokeBjo55l4(density));
                }

                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                public final long m1374invokeBjo55l4(Density offset23) {
                    Intrinsics.checkNotNullParameter(offset23, "$this$offset");
                    return IntOffsetKt.IntOffset(0, MathKt.roundToInt(BottomDrawerState.this.getOffset().getValue().floatValue()));
                }
            };
            $composer.updateRememberedValue(value$iv$iv32);
            $composer.endReplaceableGroup();
            Modifier offset222 = OffsetKt.offset(drawerConstraints2, (Function1) value$iv$iv32);
            $composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
            invalid$iv$iv2 = $composer.changed(drawerHeight$delegate);
            it$iv$iv = $composer.rememberedValue();
            if (!invalid$iv$iv2) {
            }
            value$iv$iv2 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$3$1
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
                public final void invoke2(LayoutCoordinates position) {
                    Intrinsics.checkNotNullParameter(position, "position");
                    DrawerKt$BottomDrawer$1.m1373invoke$lambda2(drawerHeight$delegate, IntSize.m4541getHeightimpl(position.mo3497getSizeYbymL2g()));
                }
            };
            $composer.updateRememberedValue(value$iv$iv2);
            $composer.endReplaceableGroup();
            int i422222 = i22 >> 12;
            SurfaceKt.m1513SurfaceFjzlyU(SemanticsModifierKt.semantics$default(OnGloballyPositionedModifierKt.onGloballyPositioned(offset222, (Function1) value$iv$iv2), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4
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
                    SemanticsPropertiesKt.setPaneTitle(semantics, navigationMenu2);
                    if (bottomDrawerState2.isOpen()) {
                        final BottomDrawerState bottomDrawerState22 = bottomDrawerState2;
                        final CoroutineScope coroutineScope22 = coroutineScope2;
                        SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                if (BottomDrawerState.this.getConfirmStateChange$material_release().invoke(BottomDrawerValue.Closed).booleanValue()) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new AnonymousClass1(BottomDrawerState.this, null), 3, null);
                                }
                                return true;
                            }

                            /* compiled from: Drawer.kt */
                            @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                            @DebugMetadata(m296c = "androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1$1", m297f = "Drawer.kt", m298i = {}, m299l = {580}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                            /* renamed from: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1$1, reason: invalid class name */
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ BottomDrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(BottomDrawerState bottomDrawerState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = bottomDrawerState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$drawerState, continuation);
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
                                            if (this.$drawerState.close(this) != coroutine_suspended) {
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
            }, 1, null), shape2, j22, j32, null, f2, ComposableLambdaKt.composableLambda($composer, 457750254, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1$1$5
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

                public final void invoke(Composer $composer2, int $changed3) {
                    ComposerKt.sourceInformation($composer2, "C589@22163L31:Drawer.kt#jmzs0o");
                    if (($changed3 & 11) == 2 && $composer2.getSkipping()) {
                        $composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(457750254, $changed3, -1, "androidx.compose.material.BottomDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:588)");
                    }
                    Function3 content$iv = function32;
                    int $changed$iv2 = (i22 << 9) & 7168;
                    $composer2.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation($composer2, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                    Modifier modifier$iv = Modifier.INSTANCE;
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv22 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv2 >> 3) & 14) | (($changed$iv2 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv22 = ($changed$iv2 << 3) & SdkConfig.SDK_VERSION;
                    $composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity32 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume52 = $composer2.consume(localDensity32);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Density density$iv$iv22 = (Density) consume52;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume6 = $composer2.consume(localLayoutDirection22);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    LayoutDirection layoutDirection$iv$iv22 = (LayoutDirection) consume6;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration22 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume7 = $composer2.consume(localViewConfiguration22);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ViewConfiguration viewConfiguration$iv$iv22 = (ViewConfiguration) consume7;
                    Function0 factory$iv$iv$iv22 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv22 = LayoutKt.materializerOf(modifier$iv);
                    int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 9) & 7168) | 6;
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        $composer2.createNode(factory$iv$iv$iv22);
                    } else {
                        $composer2.useNode();
                    }
                    $composer2.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv22 = Updater.m1639constructorimpl($composer2);
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, measurePolicy$iv22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, density$iv$iv22, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, layoutDirection$iv$iv22, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, viewConfiguration$iv$iv22, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    $composer2.enableReusing();
                    skippableUpdate$iv$iv$iv22.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv22 >> 3) & SdkConfig.SDK_VERSION));
                    $composer2.startReplaceableGroup(2058660585);
                    $composer2.startReplaceableGroup(-1163856341);
                    ComposerKt.sourceInformation($composer2, "C79@3994L9:Column.kt#2w3rfo");
                    if ((($changed$iv$iv$iv22 >> 9) & 14 & 11) == 2 && $composer2.getSkipping()) {
                        $composer2.skipToGroupEnd();
                    } else {
                        content$iv.invoke(ColumnScopeInstance.INSTANCE, $composer2, Integer.valueOf((($changed$iv2 >> 6) & SdkConfig.SDK_VERSION) | 6));
                    }
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    $composer2.endNode();
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), $composer, ((i22 >> 9) & SdkConfig.SDK_VERSION) | 1572864 | (i422222 & 896) | (i422222 & 7168) | (458752 & i22), 16);
            $composer.endReplaceableGroup();
            $composer.endReplaceableGroup();
            $composer.endReplaceableGroup();
            $composer.endNode();
            $composer.endReplaceableGroup();
            $composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer.skipToGroupEnd();
        }
    }

    /* renamed from: invoke$lambda-1, reason: not valid java name */
    private static final float m1372invoke$lambda1(MutableState<Float> mutableState) {
        MutableState<Float> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2, reason: not valid java name */
    public static final void m1373invoke$lambda2(MutableState<Float> mutableState, float value) {
        mutableState.setValue(Float.valueOf(value));
    }
}
