package com.example.healthconnect.codelab.presentation;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.AppBarKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.health.connect.client.records.ExerciseSessionRecord;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavHostControllerKt;
import com.example.healthconnect.codelab.data.HealthConnectAvailability;
import com.example.healthconnect.codelab.data.HealthConnectManager;
import com.example.healthconnect.codelab.presentation.navigation.DrawerKt;
import com.example.healthconnect.codelab.presentation.navigation.HealthConnectNavigationKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HealthConnectApp.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes10.dex */
final class HealthConnectAppKt$HealthConnectApp$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ HealthConnectManager $healthConnectManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HealthConnectAppKt$HealthConnectApp$1(HealthConnectManager healthConnectManager) {
        super(2);
        this.$healthConnectManager = healthConnectManager;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Object value$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C49@2220L23,50@2272L23,51@2316L24,55@2413L1664:HealthConnectApp.kt#v9vxs7");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1213180265, $changed, -1, "com.example.healthconnect.codelab.presentation.HealthConnectApp.<anonymous> (HealthConnectApp.kt:48)");
            }
            final ScaffoldState scaffoldState = ScaffoldKt.rememberScaffoldState(null, null, $composer, 0, 3);
            final NavHostController navController = NavHostControllerKt.rememberNavController(new Navigator[0], $composer, 8);
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
            final MutableState availability$delegate = this.$healthConnectManager.getAvailability();
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda($composer, -2136182798, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.HealthConnectAppKt$HealthConnectApp$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer2, int $changed2) {
                    ComposerKt.sourceInformation($composer2, "C58@2505L886:HealthConnectApp.kt#v9vxs7");
                    if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2136182798, $changed2, -1, "com.example.healthconnect.codelab.presentation.HealthConnectApp.<anonymous>.<anonymous> (HealthConnectApp.kt:57)");
                        }
                        Function2<Composer, Integer, Unit> m4694getLambda1$finished_debug = ComposableSingletons$HealthConnectAppKt.INSTANCE.m4694getLambda1$finished_debug();
                        final MutableState<HealthConnectAvailability> mutableState = availability$delegate;
                        final CoroutineScope coroutineScope = scope;
                        final ScaffoldState scaffoldState2 = scaffoldState;
                        AppBarKt.m1230TopAppBarxWeB9s(m4694getLambda1$finished_debug, null, ComposableLambdaKt.composableLambda($composer2, 1131219384, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.HealthConnectAppKt.HealthConnectApp.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer3, int $changed3) {
                                ComposerKt.sourceInformation($composer3, "C64@2783L542:HealthConnectApp.kt#v9vxs7");
                                if (($changed3 & 11) != 2 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1131219384, $changed3, -1, "com.example.healthconnect.codelab.presentation.HealthConnectApp.<anonymous>.<anonymous>.<anonymous> (HealthConnectApp.kt:62)");
                                    }
                                    if (HealthConnectAppKt$HealthConnectApp$1.invoke$lambda$0(mutableState) == HealthConnectAvailability.INSTALLED) {
                                        final CoroutineScope coroutineScope2 = coroutineScope;
                                        final ScaffoldState scaffoldState3 = scaffoldState2;
                                        IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.HealthConnectAppKt.HealthConnectApp.1.1.1.1
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
                                                BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new C16791(scaffoldState3, null), 3, null);
                                            }

                                            /* compiled from: HealthConnectApp.kt */
                                            @Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
                                            @DebugMetadata(m296c = "com.example.healthconnect.codelab.presentation.HealthConnectAppKt$HealthConnectApp$1$1$1$1$1", m297f = "HealthConnectApp.kt", m298i = {}, m299l = {ExerciseSessionRecord.EXERCISE_TYPE_STAIR_CLIMBING}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                            /* renamed from: com.example.healthconnect.codelab.presentation.HealthConnectAppKt$HealthConnectApp$1$1$1$1$1, reason: invalid class name and collision with other inner class name */
                                            static final class C16791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ ScaffoldState $scaffoldState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                C16791(ScaffoldState scaffoldState, Continuation<? super C16791> continuation) {
                                                    super(2, continuation);
                                                    this.$scaffoldState = scaffoldState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new C16791(this.$scaffoldState, continuation);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                    return ((C16791) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object $result) {
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    switch (this.label) {
                                                        case 0:
                                                            ResultKt.throwOnFailure($result);
                                                            this.label = 1;
                                                            if (this.$scaffoldState.getDrawerState().open(this) != coroutine_suspended) {
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
                                        }, null, false, null, ComposableSingletons$HealthConnectAppKt.INSTANCE.m4695getLambda2$finished_debug(), $composer3, 24576, 14);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer3.skipToGroupEnd();
                            }
                        }), null, 0L, 0L, 0.0f, $composer2, 390, 122);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer2.skipToGroupEnd();
                }
            });
            Function3<SnackbarHostState, Composer, Integer, Unit> m4697getLambda4$finished_debug = ComposableSingletons$HealthConnectAppKt.INSTANCE.m4697getLambda4$finished_debug();
            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda($composer, 387790876, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.HealthConnectAppKt$HealthConnectApp$1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope Scaffold, Composer $composer2, int $changed2) {
                    Intrinsics.checkNotNullParameter(Scaffold, "$this$Scaffold");
                    ComposerKt.sourceInformation($composer2, "C82@3532L177:HealthConnectApp.kt#v9vxs7");
                    if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(387790876, $changed2, -1, "com.example.healthconnect.codelab.presentation.HealthConnectApp.<anonymous>.<anonymous> (HealthConnectApp.kt:80)");
                        }
                        if (HealthConnectAppKt$HealthConnectApp$1.invoke$lambda$0(availability$delegate) == HealthConnectAvailability.INSTALLED) {
                            DrawerKt.Drawer(CoroutineScope.this, scaffoldState, navController, $composer2, 520);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer2.skipToGroupEnd();
                }
            });
            final HealthConnectManager healthConnectManager = this.$healthConnectManager;
            ScaffoldKt.m1484Scaffold27mzLpw(null, scaffoldState, composableLambda, null, m4697getLambda4$finished_debug, null, 0, false, composableLambda2, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.composableLambda($composer, 123494041, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.HealthConnectAppKt$HealthConnectApp$1.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
                    invoke(paddingValues, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues it, Composer $composer2, int $changed2) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer2, "C95@3921L146:HealthConnectApp.kt#v9vxs7");
                    if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(123494041, $changed2, -1, "com.example.healthconnect.codelab.presentation.HealthConnectApp.<anonymous>.<anonymous> (HealthConnectApp.kt:94)");
                        }
                        HealthConnectNavigationKt.HealthConnectNavigation(NavHostController.this, healthConnectManager, $composer2, 72);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer2.skipToGroupEnd();
                }
            }), $composer, 100688256, 12582912, 130793);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HealthConnectAvailability invoke$lambda$0(MutableState<HealthConnectAvailability> mutableState) {
        MutableState<HealthConnectAvailability> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }
}
