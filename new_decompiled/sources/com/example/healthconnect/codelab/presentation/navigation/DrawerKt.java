package com.example.healthconnect.codelab.presentation.navigation;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.health.platform.client.SdkConfig;
import androidx.navigation.NavController;
import androidx.navigation.NavOptionsBuilder;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Drawer.kt */
@Metadata(m286d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, m287d2 = {"Drawer", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "scaffoldState", "Landroidx/compose/material/ScaffoldState;", "navController", "Landroidx/navigation/NavController;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/material/ScaffoldState;Landroidx/navigation/NavController;Landroidx/compose/runtime/Composer;I)V", "finished_debug"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes11.dex */
public final class DrawerKt {
    public static final void Drawer(final CoroutineScope scope, final ScaffoldState scaffoldState, final NavController navController, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(scaffoldState, "scaffoldState");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer $composer3 = $composer.startRestartGroup(1532019333);
        ComposerKt.sourceInformation($composer3, "C(Drawer)P(2,1)22@754L2151:Drawer.kt#n2bxm1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1532019333, $changed, -1, "com.example.healthconnect.codelab.presentation.navigation.Drawer (Drawer.kt:17)");
        }
        Modifier modifier$iv = PaddingKt.m759padding3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(16));
        $composer3.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation($composer3, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & SdkConfig.SDK_VERSION));
        int $changed$iv$iv = (6 << 3) & SdkConfig.SDK_VERSION;
        $composer3.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer3.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer3);
        Density density$iv$iv = (Density) consume;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer3.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd($composer3);
        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = $composer3.consume(localViewConfiguration);
        ComposerKt.sourceInformationMarkerEnd($composer3);
        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
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
        $composer3.startReplaceableGroup(-1163856341);
        ComposerKt.sourceInformation($composer3, "C79@4027L9:Column.kt#2w3rfo");
        if (($changed$iv & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int $changed2 = ((6 >> 6) & SdkConfig.SDK_VERSION) | 6;
            $composer3.startReplaceableGroup(272903547);
            ComposerKt.sourceInformation($composer3, "C25@885L606,46@1582L629,67@2291L608:Drawer.kt#n2bxm1");
            if (($changed2 & 81) == 16 && $composer3.getSkipping()) {
                $composer3.skipToGroupEnd();
                $composer2 = $composer3;
            } else {
                Modifier modifier$iv2 = PaddingKt.m761paddingVpY3zN4$default(ClickableKt.m514clickableXHw0xAI$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, null, null, new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.DrawerKt$Drawer$1$1
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
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new C09701(navController, scaffoldState, null), 3, null);
                    }

                    /* compiled from: Drawer.kt */
                    @Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
                    @DebugMetadata(m296c = "com.example.healthconnect.codelab.presentation.navigation.DrawerKt$Drawer$1$1$1", m297f = "Drawer.kt", m298i = {}, m299l = {34}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                    /* renamed from: com.example.healthconnect.codelab.presentation.navigation.DrawerKt$Drawer$1$1$1 */
                    static final class C09701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ NavController $navController;
                        final /* synthetic */ ScaffoldState $scaffoldState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C09701(NavController navController, ScaffoldState scaffoldState, Continuation<? super C09701> continuation) {
                            super(2, continuation);
                            this.$navController = navController;
                            this.$scaffoldState = scaffoldState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C09701(this.$navController, this.$scaffoldState, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C09701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    this.$navController.navigate(Screen.Vitals.getRoute(), new Function1<NavOptionsBuilder, Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.DrawerKt.Drawer.1.1.1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                                            invoke2(navOptionsBuilder);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(NavOptionsBuilder navigate) {
                                            Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
                                            NavOptionsBuilder.popUpTo$default(navigate, 0, (Function1) null, 2, (Object) null);
                                        }
                                    });
                                    this.label = 1;
                                    if (this.$scaffoldState.getDrawerState().close(this) != coroutine_suspended) {
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
                }, 7, null), 0.0f, C0504Dp.m4382constructorimpl(12), 1, null);
                $composer3.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation($composer3, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                int $changed$iv$iv2 = (0 << 3) & SdkConfig.SDK_VERSION;
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer3.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv2 = (Density) consume4;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = $composer3.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = $composer3.consume(localViewConfiguration2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                $composer2 = $composer3;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(factory$iv$iv$iv2);
                } else {
                    $composer3.useNode();
                }
                $composer3.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer3);
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer3.enableReusing();
                skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                $composer3.startReplaceableGroup(2058660585);
                int $changed$iv2 = ($changed$iv$iv$iv2 >> 9) & 14;
                $composer3.startReplaceableGroup(-678309503);
                ComposerKt.sourceInformation($composer3, "C80@4021L9:Row.kt#2w3rfo");
                if (($changed$iv2 & 11) == 2 && $composer3.getSkipping()) {
                    $composer3.skipToGroupEnd();
                } else {
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    int $changed3 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                    $composer3.startReplaceableGroup(999947487);
                    ComposerKt.sourceInformation($composer3, "C40@1395L10,41@1448L6,38@1318L163:Drawer.kt#n2bxm1");
                    if (($changed3 & 81) != 16 || !$composer3.getSkipping()) {
                        TextKt.m1585TextfLXpl1I("Vitals", null, MaterialTheme.INSTANCE.getColors($composer3, MaterialTheme.$stable).m1312getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getH6(), $composer3, 6, 0, 32762);
                    } else {
                        $composer3.skipToGroupEnd();
                    }
                    $composer3.endReplaceableGroup();
                }
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
                Modifier modifier$iv3 = PaddingKt.m761paddingVpY3zN4$default(ClickableKt.m514clickableXHw0xAI$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, null, null, new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.DrawerKt$Drawer$1$3
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
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new C09711(navController, scaffoldState, null), 3, null);
                    }

                    /* compiled from: Drawer.kt */
                    @Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
                    @DebugMetadata(m296c = "com.example.healthconnect.codelab.presentation.navigation.DrawerKt$Drawer$1$3$1", m297f = "Drawer.kt", m298i = {}, m299l = {55}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                    /* renamed from: com.example.healthconnect.codelab.presentation.navigation.DrawerKt$Drawer$1$3$1 */
                    static final class C09711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ NavController $navController;
                        final /* synthetic */ ScaffoldState $scaffoldState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C09711(NavController navController, ScaffoldState scaffoldState, Continuation<? super C09711> continuation) {
                            super(2, continuation);
                            this.$navController = navController;
                            this.$scaffoldState = scaffoldState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C09711(this.$navController, this.$scaffoldState, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C09711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    this.$navController.navigate(Screen.EmergencyContacts.getRoute(), new Function1<NavOptionsBuilder, Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.DrawerKt.Drawer.1.3.1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                                            invoke2(navOptionsBuilder);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(NavOptionsBuilder navigate) {
                                            Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
                                            NavOptionsBuilder.popUpTo$default(navigate, 0, (Function1) null, 2, (Object) null);
                                        }
                                    });
                                    this.label = 1;
                                    if (this.$scaffoldState.getDrawerState().close(this) != coroutine_suspended) {
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
                }, 7, null), 0.0f, C0504Dp.m4382constructorimpl(12), 1, null);
                $composer3.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation($composer3, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                int $changed$iv$iv3 = (0 << 3) & SdkConfig.SDK_VERSION;
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume7 = $composer3.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv3 = (Density) consume7;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume8 = $composer3.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume8;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume9 = $composer3.consume(localViewConfiguration3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume9;
                Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv3 = LayoutKt.materializerOf(modifier$iv3);
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 9) & 7168) | 6;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(factory$iv$iv$iv3);
                } else {
                    $composer3.useNode();
                }
                $composer3.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m1639constructorimpl($composer3);
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer3.enableReusing();
                skippableUpdate$iv$iv$iv3.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & SdkConfig.SDK_VERSION));
                $composer3.startReplaceableGroup(2058660585);
                int $changed$iv3 = ($changed$iv$iv$iv3 >> 9) & 14;
                $composer3.startReplaceableGroup(-678309503);
                ComposerKt.sourceInformation($composer3, "C80@4021L9:Row.kt#2w3rfo");
                if (($changed$iv3 & 11) == 2 && $composer3.getSkipping()) {
                    $composer3.skipToGroupEnd();
                } else {
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    int $changed4 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                    $composer3.startReplaceableGroup(-52289834);
                    ComposerKt.sourceInformation($composer3, "C61@2115L10,62@2168L6,59@2026L175:Drawer.kt#n2bxm1");
                    if (($changed4 & 81) != 16 || !$composer3.getSkipping()) {
                        TextKt.m1585TextfLXpl1I("Emergency Contacts", null, MaterialTheme.INSTANCE.getColors($composer3, MaterialTheme.$stable).m1312getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getH6(), $composer3, 6, 0, 32762);
                    } else {
                        $composer3.skipToGroupEnd();
                    }
                    $composer3.endReplaceableGroup();
                }
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
                Modifier modifier$iv4 = PaddingKt.m761paddingVpY3zN4$default(ClickableKt.m514clickableXHw0xAI$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, null, null, new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.DrawerKt$Drawer$1$5
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
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new C09721(navController, scaffoldState, null), 3, null);
                    }

                    /* compiled from: Drawer.kt */
                    @Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
                    @DebugMetadata(m296c = "com.example.healthconnect.codelab.presentation.navigation.DrawerKt$Drawer$1$5$1", m297f = "Drawer.kt", m298i = {}, m299l = {76}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                    /* renamed from: com.example.healthconnect.codelab.presentation.navigation.DrawerKt$Drawer$1$5$1 */
                    static final class C09721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ NavController $navController;
                        final /* synthetic */ ScaffoldState $scaffoldState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C09721(NavController navController, ScaffoldState scaffoldState, Continuation<? super C09721> continuation) {
                            super(2, continuation);
                            this.$navController = navController;
                            this.$scaffoldState = scaffoldState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C09721(this.$navController, this.$scaffoldState, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C09721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    this.$navController.navigate(Screen.Profile.getRoute(), new Function1<NavOptionsBuilder, Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.DrawerKt.Drawer.1.5.1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                                            invoke2(navOptionsBuilder);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(NavOptionsBuilder navigate) {
                                            Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
                                            NavOptionsBuilder.popUpTo$default(navigate, 0, (Function1) null, 2, (Object) null);
                                        }
                                    });
                                    this.label = 1;
                                    if (this.$scaffoldState.getDrawerState().close(this) != coroutine_suspended) {
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
                }, 7, null), 0.0f, C0504Dp.m4382constructorimpl(12), 1, null);
                $composer3.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation($composer3, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv3 = Alignment.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                int $changed$iv$iv4 = (0 << 3) & SdkConfig.SDK_VERSION;
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume10 = $composer3.consume(localDensity4);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv4 = (Density) consume10;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume11 = $composer3.consume(localLayoutDirection4);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv4 = (LayoutDirection) consume11;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration4 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume12 = $composer3.consume(localViewConfiguration4);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv4 = (ViewConfiguration) consume12;
                Function0 factory$iv$iv$iv4 = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv4 = LayoutKt.materializerOf(modifier$iv4);
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 9) & 7168) | 6;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(factory$iv$iv$iv4);
                } else {
                    $composer3.useNode();
                }
                $composer3.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv4 = Updater.m1639constructorimpl($composer3);
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv4, density$iv$iv4, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv4, layoutDirection$iv$iv4, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv4, viewConfiguration$iv$iv4, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer3.enableReusing();
                skippableUpdate$iv$iv$iv4.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv4 >> 3) & SdkConfig.SDK_VERSION));
                $composer3.startReplaceableGroup(2058660585);
                int $changed$iv4 = ($changed$iv$iv$iv4 >> 9) & 14;
                $composer3.startReplaceableGroup(-678309503);
                ComposerKt.sourceInformation($composer3, "C80@4021L9:Row.kt#2w3rfo");
                if (($changed$iv4 & 11) == 2 && $composer3.getSkipping()) {
                    $composer3.skipToGroupEnd();
                } else {
                    RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                    int $changed5 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                    $composer3.startReplaceableGroup(-2138132649);
                    ComposerKt.sourceInformation($composer3, "C82@2803L10,83@2856L6,80@2725L164:Drawer.kt#n2bxm1");
                    if (($changed5 & 81) != 16 || !$composer3.getSkipping()) {
                        TextKt.m1585TextfLXpl1I("Profile", null, MaterialTheme.INSTANCE.getColors($composer3, MaterialTheme.$stable).m1312getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getH6(), $composer3, 6, 0, 32762);
                    } else {
                        $composer3.skipToGroupEnd();
                    }
                    $composer3.endReplaceableGroup();
                }
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            }
            $composer3.endReplaceableGroup();
        }
        $composer3.endReplaceableGroup();
        $composer2.endReplaceableGroup();
        $composer2.endNode();
        $composer2.endReplaceableGroup();
        $composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.DrawerKt$Drawer$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                DrawerKt.Drawer(CoroutineScope.this, scaffoldState, navController, composer, $changed | 1);
            }
        });
    }
}
