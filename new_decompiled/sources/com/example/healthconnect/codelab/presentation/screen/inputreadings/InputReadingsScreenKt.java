package com.example.healthconnect.codelab.presentation.screen.inputreadings;

import android.content.Context;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.DirectionsWalkKt;
import androidx.compose.material.icons.filled.FavoriteKt;
import androidx.compose.material.icons.filled.InfoKt;
import androidx.compose.material.icons.filled.OpacityKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.vector.ImageVector;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.p000ui.unit.TextUnitKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.health.platform.client.SdkConfig;
import com.example.healthconnect.codelab.presentation.model.VitalType;
import com.example.healthconnect.codelab.presentation.model.VitalUiModel;
import com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel;
import com.example.healthconnect.codelab.presentation.theme.ThemeKt;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputReadingsScreen.kt */
@Metadata(m286d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a¥\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00010\u00102\u001a\b\u0002\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u00122\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0016\u001a\r\u0010\u0017\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0018\u001a\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u001b\u001a\u001b\u0010\u001c\u001a\u00020\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0003¢\u0006\u0002\u0010\u001e\u001a\u0015\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0003¢\u0006\u0002\u0010#¨\u0006$"}, m287d2 = {"InputReadingsScreen", "", "permissions", "", "", "permissionsGranted", "", "vitalsList", "", "Lcom/example/healthconnect/codelab/presentation/model/VitalUiModel;", "uiState", "Lcom/example/healthconnect/codelab/presentation/screen/inputreadings/InputReadingsViewModel$UiState;", "simulationResult", "onPermissionsResult", "Lkotlin/Function0;", "onPermissionsLaunch", "Lkotlin/Function1;", "onSimulate", "Lkotlin/Function2;", "", "onError", "", "(Ljava/util/Set;ZLjava/util/List;Lcom/example/healthconnect/codelab/presentation/screen/inputreadings/InputReadingsViewModel$UiState;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "InputReadingsScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "VitalCard", "vital", "(Lcom/example/healthconnect/codelab/presentation/model/VitalUiModel;Landroidx/compose/runtime/Composer;I)V", "VitalsSection", "vitals", "(Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "getIconForVital", "Landroidx/compose/ui/graphics/vector/ImageVector;", "type", "Lcom/example/healthconnect/codelab/presentation/model/VitalType;", "(Lcom/example/healthconnect/codelab/presentation/model/VitalType;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/ImageVector;", "finished_debug"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes12.dex */
public final class InputReadingsScreenKt {

    /* compiled from: InputReadingsScreen.kt */
    @Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VitalType.values().length];
            try {
                iArr[VitalType.HEART_RATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[VitalType.SPO2.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[VitalType.STEPS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void InputReadingsScreen(final Set<String> permissions, final boolean permissionsGranted, final List<VitalUiModel> vitalsList, final InputReadingsViewModel.UiState uiState, String simulationResult, Function0<Unit> function0, Function1<? super Set<String>, Unit> function1, Function2<? super Integer, ? super Integer, Unit> function2, Function1<? super Throwable, Unit> function12, Composer $composer, final int $changed, final int i) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(vitalsList, "vitalsList");
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Composer $composer2 = $composer.startRestartGroup(-758707102);
        ComposerKt.sourceInformation($composer2, "C(InputReadingsScreen)P(4,5,8,7,6,2,1,3)81@3644L54,83@3731L7,84@3769L160,90@3935L579,110@4587L573:InputReadingsScreen.kt#ddqsl8");
        String simulationResult2 = (i & 16) != 0 ? null : simulationResult;
        Function0 onPermissionsResult = (i & 32) != 0 ? new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreenKt$InputReadingsScreen$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        } : function0;
        final Function1 onPermissionsLaunch = (i & 64) != 0 ? new Function1<Set<? extends String>, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreenKt$InputReadingsScreen$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Set<? extends String> set) {
                invoke2((Set<String>) set);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Set<String> it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }
        } : function1;
        Function2 onSimulate = (i & 128) != 0 ? new Function2<Integer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreenKt$InputReadingsScreen$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2, int i3) {
            }
        } : function2;
        Function1 onError = (i & 256) != 0 ? new Function1<Throwable, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreenKt$InputReadingsScreen$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
            }
        } : function12;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-758707102, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreen (InputReadingsScreen.kt:67)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer2.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        Context context = (Context) consume;
        ManagedActivityResultLauncher permissionsLauncher = ActivityResultRegistryKt.rememberLauncherForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new Function1<Map<String, Boolean>, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreenKt$InputReadingsScreen$permissionsLauncher$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, Boolean> map) {
                invoke2(map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, Boolean> permissions2) {
                Intrinsics.checkNotNullParameter(permissions2, "permissions");
            }
        }, $composer2, 56);
        EffectsKt.LaunchedEffect(Unit.INSTANCE, new InputReadingsScreenKt$InputReadingsScreen$5(permissionsLauncher, onPermissionsResult, context, null), $composer2, 70);
        if (!Intrinsics.areEqual(uiState, InputReadingsViewModel.UiState.Uninitialized.INSTANCE)) {
            LazyDslKt.LazyColumn(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, false, Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), null, false, new Function1<LazyListScope, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreenKt$InputReadingsScreen$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                    invoke2(lazyListScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LazyListScope LazyColumn) {
                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                    if (!permissionsGranted) {
                        final List<VitalUiModel> list = vitalsList;
                        final Function1<Set<String>, Unit> function13 = onPermissionsLaunch;
                        final Set<String> set = permissions;
                        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1449841816, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreenKt$InputReadingsScreen$6.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                invoke(lazyItemScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(LazyItemScope item, Composer $composer3, int $changed2) {
                                Intrinsics.checkNotNullParameter(item, "$this$item");
                                ComposerKt.sourceInformation($composer3, "C118@4812L25,120@4849L167:InputReadingsScreen.kt#ddqsl8");
                                if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1449841816, $changed2, -1, "com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreen.<anonymous>.<anonymous> (InputReadingsScreen.kt:116)");
                                    }
                                    InputReadingsScreenKt.VitalsSection(list, $composer3, 8);
                                    final Function1<Set<String>, Unit> function14 = function13;
                                    final Set<String> set2 = set;
                                    ButtonKt.Button(new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreenKt.InputReadingsScreen.6.1.1
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
                                            function14.invoke(set2);
                                        }
                                    }, null, false, null, null, null, null, null, null, ComposableSingletons$InputReadingsScreenKt.INSTANCE.m4713getLambda1$finished_debug(), $composer3, 805306368, 510);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer3.skipToGroupEnd();
                            }
                        }), 3, null);
                        return;
                    }
                    final List<VitalUiModel> list2 = vitalsList;
                    LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1941155345, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreenKt$InputReadingsScreen$6.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                            invoke(lazyItemScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LazyItemScope item, Composer $composer3, int $changed2) {
                            Intrinsics.checkNotNullParameter(item, "$this$item");
                            ComposerKt.sourceInformation($composer3, "C130@5107L25:InputReadingsScreen.kt#ddqsl8");
                            if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1941155345, $changed2, -1, "com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreen.<anonymous>.<anonymous> (InputReadingsScreen.kt:129)");
                                }
                                InputReadingsScreenKt.VitalsSection(list2, $composer3, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer3.skipToGroupEnd();
                        }
                    }), 3, null);
                }
            }, $composer2, 221190, ComposerKt.referenceKey);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final String str = simulationResult2;
        final Function0 function02 = onPermissionsResult;
        final Function1 function13 = onPermissionsLaunch;
        final Function2 function22 = onSimulate;
        final Function1 function14 = onError;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreenKt$InputReadingsScreen$7
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

            public final void invoke(Composer composer, int i2) {
                InputReadingsScreenKt.InputReadingsScreen(permissions, permissionsGranted, vitalsList, uiState, str, function02, function13, function22, function14, composer, $changed | 1, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VitalCard(final VitalUiModel vital, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-813579462);
        ComposerKt.sourceInformation($composer2, "C(VitalCard)146@5326L6,144@5264L1716:InputReadingsScreen.kt#ddqsl8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-813579462, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.inputreadings.VitalCard (InputReadingsScreen.kt:143)");
        }
        CardKt.m1280CardFjzlyU(PaddingKt.m760paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C0504Dp.m4382constructorimpl(4), C0504Dp.m4382constructorimpl(8)), MaterialTheme.INSTANCE.getShapes($composer2, MaterialTheme.$stable).getMedium(), 0L, 0L, null, C0504Dp.m4382constructorimpl(4), ComposableLambdaKt.composableLambda($composer2, -1203560739, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreenKt$VitalCard$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer3, int $changed2) {
                ImageVector iconForVital;
                long m1994copywmQWz5c;
                long m1994copywmQWz5c2;
                ComposerKt.sourceInformation($composer3, "C151@5470L1504:InputReadingsScreen.kt#ddqsl8");
                if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1203560739, $changed2, -1, "com.example.healthconnect.codelab.presentation.screen.inputreadings.VitalCard.<anonymous> (InputReadingsScreen.kt:150)");
                    }
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m759padding3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(16)), 0.0f, 1, null);
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                    VitalUiModel vitalUiModel = VitalUiModel.this;
                    $composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation($composer3, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv = (438 << 3) & SdkConfig.SDK_VERSION;
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
                    Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(fillMaxWidth$default);
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
                    $composer3.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation($composer3, "C80@4021L9:Row.kt#2w3rfo");
                    if (($changed$iv & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                    } else {
                        RowScope rowScope = RowScopeInstance.INSTANCE;
                        int $changed3 = ((438 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        RowScope $this$invoke_u24lambda_u242 = rowScope;
                        $composer3.startReplaceableGroup(-307052735);
                        ComposerKt.sourceInformation($composer3, "C158@5717L987,184@6857L10,185@6915L6,182@6730L234:InputReadingsScreen.kt#ddqsl8");
                        int $dirty = $changed3;
                        if (($changed3 & 14) == 0) {
                            $dirty |= $composer3.changed($this$invoke_u24lambda_u242) ? 4 : 2;
                        }
                        if (($dirty & 91) != 18 || !$composer3.getSkipping()) {
                            Modifier modifier$iv = RowScope.weight$default($this$invoke_u24lambda_u242, Modifier.INSTANCE, 1.0f, false, 2, null);
                            $composer3.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation($composer3, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
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
                            Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv);
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
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
                            $composer3.startReplaceableGroup(-1163856341);
                            ComposerKt.sourceInformation($composer3, "C79@4027L9:Column.kt#2w3rfo");
                            if (($changed$iv2 & 11) == 2 && $composer3.getSkipping()) {
                                $composer3.skipToGroupEnd();
                            } else {
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                int $changed4 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                $composer3.startReplaceableGroup(920309303);
                                ComposerKt.sourceInformation($composer3, "C161@5804L609,174@6430L40,177@6599L10,178@6656L6,175@6487L203:InputReadingsScreen.kt#ddqsl8");
                                if (($changed4 & 81) != 16 || !$composer3.getSkipping()) {
                                    Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                                    $composer3.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation($composer3, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                                    Modifier modifier$iv2 = Modifier.INSTANCE;
                                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                    MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & SdkConfig.SDK_VERSION));
                                    int $changed$iv$iv3 = (384 << 3) & SdkConfig.SDK_VERSION;
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
                                    Function3 skippableUpdate$iv$iv$iv3 = LayoutKt.materializerOf(modifier$iv2);
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
                                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                        int $changed5 = ((384 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                        $composer3.startReplaceableGroup(-1138739813);
                                        ComposerKt.sourceInformation($composer3, "C163@5922L27,165@6047L6,162@5878L270,170@6270L10,171@6338L6,168@6169L226:InputReadingsScreen.kt#ddqsl8");
                                        if (($changed5 & 81) != 16 || !$composer3.getSkipping()) {
                                            iconForVital = InputReadingsScreenKt.getIconForVital(vitalUiModel.getType(), $composer3, 0);
                                            IconKt.m1415Iconww6aTOc(iconForVital, (String) null, PaddingKt.m763paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, C0504Dp.m4382constructorimpl(8), 0.0f, 11, null), MaterialTheme.INSTANCE.getColors($composer3, MaterialTheme.$stable).m1317getPrimary0d7_KjU(), $composer3, 432, 0);
                                            String title = vitalUiModel.getType().getTitle();
                                            TextStyle subtitle1 = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getSubtitle1();
                                            m1994copywmQWz5c = Color.m1994copywmQWz5c(r67, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r67) : 0.6f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r67) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r67) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer3, MaterialTheme.$stable).m1316getOnSurface0d7_KjU()) : 0.0f);
                                            TextKt.m1585TextfLXpl1I(title, null, m1994copywmQWz5c, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, subtitle1, $composer3, 0, 0, 32762);
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
                                    SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(8)), $composer3, 6);
                                    TextKt.m1585TextfLXpl1I(vitalUiModel.getValue() + ' ' + vitalUiModel.getType().getUnit(), null, MaterialTheme.INSTANCE.getColors($composer3, MaterialTheme.$stable).m1316getOnSurface0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getH4(), $composer3, 0, 0, 32762);
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
                            TextStyle caption = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getCaption();
                            m1994copywmQWz5c2 = Color.m1994copywmQWz5c(r29, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r29) : 0.4f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r29) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r29) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer3, MaterialTheme.$stable).m1316getOnSurface0d7_KjU()) : 0.0f);
                            TextKt.m1585TextfLXpl1I("Just Now", null, m1994copywmQWz5c2, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, caption, $composer3, 6, 0, 32762);
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
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer3.skipToGroupEnd();
            }
        }), $composer2, 1769472, 28);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreenKt$VitalCard$2
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
                InputReadingsScreenKt.VitalCard(VitalUiModel.this, composer, $changed | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageVector getIconForVital(VitalType type, Composer $composer, int $changed) {
        ImageVector favorite;
        $composer.startReplaceableGroup(-891602745);
        ComposerKt.sourceInformation($composer, "C(getIconForVital):InputReadingsScreen.kt#ddqsl8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-891602745, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.inputreadings.getIconForVital (InputReadingsScreen.kt:192)");
        }
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                favorite = FavoriteKt.getFavorite(Icons.INSTANCE.getDefault());
                break;
            case 2:
                favorite = OpacityKt.getOpacity(Icons.INSTANCE.getDefault());
                break;
            case 3:
                favorite = DirectionsWalkKt.getDirectionsWalk(Icons.INSTANCE.getDefault());
                break;
            default:
                favorite = InfoKt.getInfo(Icons.INSTANCE.getDefault());
                break;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return favorite;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VitalsSection(final List<VitalUiModel> list, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1057569991);
        ComposerKt.sourceInformation($composer2, "C(VitalsSection)209@7882L6,206@7795L162,213@7963L309:InputReadingsScreen.kt#ddqsl8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1057569991, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.inputreadings.VitalsSection (InputReadingsScreen.kt:203)");
        }
        if (list.isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreenKt$VitalsSection$1
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
                    InputReadingsScreenKt.VitalsSection(list, composer, $changed | 1);
                }
            });
            return;
        }
        TextKt.m1585TextfLXpl1I("Vitals", PaddingKt.m761paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, C0504Dp.m4382constructorimpl(12), 1, null), MaterialTheme.INSTANCE.getColors($composer2, MaterialTheme.$stable).m1317getPrimary0d7_KjU(), TextUnitKt.getSp(24), null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer2, 3126, 0, 65520);
        Modifier modifier$iv = SizeKt.fillMaxWidth$default(PaddingKt.m761paddingVpY3zN4$default(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(16), 0.0f, 2, null), 0.0f, 1, null);
        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.m704spacedBy0680j_4(C0504Dp.m4382constructorimpl(8));
        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getCenterHorizontally();
        $composer2.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation($composer2, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & SdkConfig.SDK_VERSION));
        int $changed$iv$iv = (438 << 3) & SdkConfig.SDK_VERSION;
        $composer2.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer2.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        Density density$iv$iv = (Density) consume;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer2.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = $composer2.consume(localViewConfiguration);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
        Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
        Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
        if (!($composer2.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer2.startReusableNode();
        if ($composer2.getInserting()) {
            $composer2.createNode(factory$iv$iv$iv);
        } else {
            $composer2.useNode();
        }
        $composer2.disableReusing();
        Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer2);
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
        $composer2.enableReusing();
        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
        $composer2.startReplaceableGroup(2058660585);
        int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
        $composer2.startReplaceableGroup(-1163856341);
        ComposerKt.sourceInformation($composer2, "C79@4027L9:Column.kt#2w3rfo");
        if (($changed$iv & 11) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int $changed2 = ((438 >> 6) & SdkConfig.SDK_VERSION) | 6;
            $composer2.startReplaceableGroup(385482173);
            ComposerKt.sourceInformation($composer2, "C*221@8240L16:InputReadingsScreen.kt#ddqsl8");
            if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                List<VitalUiModel> $this$forEach$iv = list;
                int $i$f$forEach = 0;
                for (Object element$iv : $this$forEach$iv) {
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    VitalUiModel vital = (VitalUiModel) element$iv;
                    VitalCard(vital, $composer2, 8);
                    $this$forEach$iv = $this$forEach$iv2;
                    $i$f$forEach = $i$f$forEach;
                }
            } else {
                $composer2.skipToGroupEnd();
            }
            $composer2.endReplaceableGroup();
        }
        $composer2.endReplaceableGroup();
        $composer2.endReplaceableGroup();
        $composer2.endNode();
        $composer2.endReplaceableGroup();
        $composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreenKt$VitalsSection$3
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
                    InputReadingsScreenKt.VitalsSection(list, composer, $changed | 1);
                }
            });
        }
    }

    public static final void InputReadingsScreenPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-23959922);
        ComposerKt.sourceInformation($composer2, "C(InputReadingsScreenPreview)229@8334L660:InputReadingsScreen.kt#ddqsl8");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-23959922, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreenPreview (InputReadingsScreen.kt:228)");
            }
            ThemeKt.HealthConnectTheme(false, ComposableSingletons$InputReadingsScreenKt.INSTANCE.m4714getLambda2$finished_debug(), $composer2, 54, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreenKt$InputReadingsScreenPreview$1
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
                InputReadingsScreenKt.InputReadingsScreenPreview(composer, $changed | 1);
            }
        });
    }
}
