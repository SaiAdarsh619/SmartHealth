package com.example.healthconnect.codelab.presentation.navigation;

import android.content.Context;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.p000ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostKt;
import com.example.healthconnect.codelab.data.EmergencyContactsManager;
import com.example.healthconnect.codelab.data.HealthConnectManager;
import com.example.healthconnect.codelab.data.UserProfileManager;
import com.example.healthconnect.codelab.presentation.model.VitalUiModel;
import com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt;
import com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreenKt;
import com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel;
import com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModelFactory;
import com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt;
import com.example.healthconnect.codelab.presentation.screen.profile.ProfileViewModel;
import com.example.healthconnect.codelab.presentation.screen.profile.ProfileViewModelFactory;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import java.util.List;
import java.util.Set;
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
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HealthConnectNavigation.kt */
@Metadata(m286d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m287d2 = {"HealthConnectNavigation", "", "navController", "Landroidx/navigation/NavHostController;", "healthConnectManager", "Lcom/example/healthconnect/codelab/data/HealthConnectManager;", "(Landroidx/navigation/NavHostController;Lcom/example/healthconnect/codelab/data/HealthConnectManager;Landroidx/compose/runtime/Composer;I)V", "finished_debug"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes11.dex */
public final class HealthConnectNavigationKt {
    public static final void HealthConnectNavigation(final NavHostController navController, final HealthConnectManager healthConnectManager, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(healthConnectManager, "healthConnectManager");
        Composer $composer2 = $composer.startRestartGroup(918092645);
        ComposerKt.sourceInformation($composer2, "C(HealthConnectNavigation)P(1)61@3469L3559:HealthConnectNavigation.kt#n2bxm1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(918092645, $changed, -1, "com.example.healthconnect.codelab.presentation.navigation.HealthConnectNavigation (HealthConnectNavigation.kt:56)");
        }
        NavHostKt.NavHost(navController, Screen.Vitals.getRoute(), null, null, new Function1<NavGraphBuilder, Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.HealthConnectNavigationKt$HealthConnectNavigation$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavGraphBuilder navGraphBuilder) {
                invoke2(navGraphBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavGraphBuilder NavHost) {
                Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
                String route = Screen.Vitals.getRoute();
                final HealthConnectManager healthConnectManager2 = HealthConnectManager.this;
                NavGraphBuilderKt.composable$default(NavHost, route, null, null, ComposableLambdaKt.composableLambdaInstance(137719616, true, new Function3<NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.HealthConnectNavigationKt$HealthConnectNavigation$1.1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                        invoke(navBackStackEntry, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(NavBackStackEntry it, Composer $composer3, int $changed2) {
                        Object value$iv$iv;
                        Object value$iv$iv2;
                        Object value$iv$iv3;
                        CreationExtras extras$iv;
                        Intrinsics.checkNotNullParameter(it, "it");
                        ComposerKt.sourceInformation($composer3, "C66@3653L7,67@3720L46,68@3804L40,69@3883L69,70@4005L160,79@4392L137,83@4543L610:HealthConnectNavigation.kt#n2bxm1");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(137719616, $changed2, -1, "com.example.healthconnect.codelab.presentation.navigation.HealthConnectNavigation.<anonymous>.<anonymous> (HealthConnectNavigation.kt:65)");
                        }
                        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume = $composer3.consume(localContext);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Context context = (Context) consume;
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                        Object it$iv$iv = $composer3.rememberedValue();
                        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv = new EmergencyContactsManager(context);
                            $composer3.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                        }
                        $composer3.endReplaceableGroup();
                        EmergencyContactsManager contactsManager = (EmergencyContactsManager) value$iv$iv;
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                        Object it$iv$iv2 = $composer3.rememberedValue();
                        if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv2 = new UserProfileManager(context);
                            $composer3.updateRememberedValue(value$iv$iv2);
                        } else {
                            value$iv$iv2 = it$iv$iv2;
                        }
                        $composer3.endReplaceableGroup();
                        UserProfileManager userProfileManager = (UserProfileManager) value$iv$iv2;
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                        Object it$iv$iv3 = $composer3.rememberedValue();
                        if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv3 = LocationServices.getFusedLocationProviderClient(context);
                            $composer3.updateRememberedValue(value$iv$iv3);
                        } else {
                            value$iv$iv3 = it$iv$iv3;
                        }
                        $composer3.endReplaceableGroup();
                        Intrinsics.checkNotNullExpressionValue(value$iv$iv3, "remember { LocationServi…ProviderClient(context) }");
                        FusedLocationProviderClient fusedLocationClient = (FusedLocationProviderClient) value$iv$iv3;
                        ViewModelProvider.Factory factory$iv = new InputReadingsViewModelFactory(HealthConnectManager.this, contactsManager, userProfileManager, fusedLocationClient);
                        $composer3.startReplaceableGroup(1729797275);
                        ComposerKt.sourceInformation($composer3, "C(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                        ViewModelStoreOwner viewModelStoreOwner$iv = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer3, 6);
                        if (viewModelStoreOwner$iv == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                        }
                        if (viewModelStoreOwner$iv instanceof HasDefaultViewModelProviderFactory) {
                            CreationExtras defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner$iv).getDefaultViewModelCreationExtras();
                            Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "{\n        viewModelStore…ModelCreationExtras\n    }");
                            extras$iv = defaultViewModelCreationExtras;
                        } else {
                            extras$iv = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel = ViewModelKt.viewModel(InputReadingsViewModel.class, viewModelStoreOwner$iv, null, factory$iv, extras$iv, $composer3, ((512 << 3) & 896) | 36936, 0);
                        $composer3.endReplaceableGroup();
                        final InputReadingsViewModel viewModel2 = (InputReadingsViewModel) viewModel;
                        MutableState permissionsGranted$delegate = viewModel2.getPermissionsGranted();
                        MutableState vitals$delegate = viewModel2.getVitals();
                        Set requiredPermissions = viewModel2.getPermissions();
                        final ManagedActivityResultLauncher permissionsLauncher = ActivityResultRegistryKt.rememberLauncherForActivityResult(viewModel2.getPermissionsLauncher(), new Function1<Set<? extends String>, Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.HealthConnectNavigationKt$HealthConnectNavigation$1$1$permissionsLauncher$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Set<? extends String> set) {
                                invoke2((Set<String>) set);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Set<String> it2) {
                                Intrinsics.checkNotNullParameter(it2, "it");
                                InputReadingsViewModel.this.onPermissionsGranted();
                            }
                        }, $composer3, 8);
                        InputReadingsScreenKt.InputReadingsScreen(requiredPermissions, invoke$lambda$3(permissionsGranted$delegate), invoke$lambda$4(vitals$delegate), viewModel2.getUiState(), viewModel2.getSimulationResult(), new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.HealthConnectNavigationKt.HealthConnectNavigation.1.1.1
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
                                InputReadingsViewModel.this.initialLoad();
                            }
                        }, new Function1<Set<? extends String>, Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.HealthConnectNavigationKt.HealthConnectNavigation.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Set<? extends String> set) {
                                invoke2((Set<String>) set);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Set<String> perms) {
                                Intrinsics.checkNotNullParameter(perms, "perms");
                                permissionsLauncher.launch(perms);
                            }
                        }, new Function2<Integer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.HealthConnectNavigationKt.HealthConnectNavigation.1.1.3
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                                invoke(num.intValue(), num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int hr, int spo2) {
                                InputReadingsViewModel.this.simulateVital(hr, spo2);
                            }
                        }, new Function1<Throwable, Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.HealthConnectNavigationKt.HealthConnectNavigation.1.1.4
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                invoke2(th);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it2) {
                            }
                        }, $composer3, 100663816, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }

                    private static final boolean invoke$lambda$3(MutableState<Boolean> mutableState) {
                        MutableState<Boolean> $this$getValue$iv = mutableState;
                        return $this$getValue$iv.getValue().booleanValue();
                    }

                    private static final List<VitalUiModel> invoke$lambda$4(MutableState<List<VitalUiModel>> mutableState) {
                        MutableState<List<VitalUiModel>> $this$getValue$iv = mutableState;
                        return $this$getValue$iv.getValue();
                    }
                }), 6, null);
                String route2 = Screen.EmergencyContacts.getRoute();
                final HealthConnectManager healthConnectManager3 = HealthConnectManager.this;
                NavGraphBuilderKt.composable$default(NavHost, route2, null, null, ComposableLambdaKt.composableLambdaInstance(1551010985, true, new Function3<NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.HealthConnectNavigationKt$HealthConnectNavigation$1.2
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                        invoke(navBackStackEntry, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(NavBackStackEntry it, Composer $composer3, int $changed2) {
                        Object value$iv$iv;
                        Object value$iv$iv2;
                        Object value$iv$iv3;
                        CreationExtras extras$iv;
                        Intrinsics.checkNotNullParameter(it, "it");
                        ComposerKt.sourceInformation($composer3, "C99@5257L7,100@5324L46,101@5408L40,102@5487L69,107@5923L160,111@6109L81:HealthConnectNavigation.kt#n2bxm1");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1551010985, $changed2, -1, "com.example.healthconnect.codelab.presentation.navigation.HealthConnectNavigation.<anonymous>.<anonymous> (HealthConnectNavigation.kt:98)");
                        }
                        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume = $composer3.consume(localContext);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Context context = (Context) consume;
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                        Object it$iv$iv = $composer3.rememberedValue();
                        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv = new EmergencyContactsManager(context);
                            $composer3.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                        }
                        $composer3.endReplaceableGroup();
                        EmergencyContactsManager contactsManager = (EmergencyContactsManager) value$iv$iv;
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                        Object it$iv$iv2 = $composer3.rememberedValue();
                        if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv2 = new UserProfileManager(context);
                            $composer3.updateRememberedValue(value$iv$iv2);
                        } else {
                            value$iv$iv2 = it$iv$iv2;
                        }
                        $composer3.endReplaceableGroup();
                        UserProfileManager userProfileManager = (UserProfileManager) value$iv$iv2;
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                        Object it$iv$iv3 = $composer3.rememberedValue();
                        if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv3 = LocationServices.getFusedLocationProviderClient(context);
                            $composer3.updateRememberedValue(value$iv$iv3);
                        } else {
                            value$iv$iv3 = it$iv$iv3;
                        }
                        $composer3.endReplaceableGroup();
                        Intrinsics.checkNotNullExpressionValue(value$iv$iv3, "remember { LocationServi…ProviderClient(context) }");
                        FusedLocationProviderClient fusedLocationClient = (FusedLocationProviderClient) value$iv$iv3;
                        ViewModelProvider.Factory factory$iv = new InputReadingsViewModelFactory(HealthConnectManager.this, contactsManager, userProfileManager, fusedLocationClient);
                        $composer3.startReplaceableGroup(1729797275);
                        ComposerKt.sourceInformation($composer3, "C(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                        ViewModelStoreOwner viewModelStoreOwner$iv = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer3, 6);
                        if (viewModelStoreOwner$iv == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                        }
                        if (viewModelStoreOwner$iv instanceof HasDefaultViewModelProviderFactory) {
                            CreationExtras defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner$iv).getDefaultViewModelCreationExtras();
                            Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "{\n        viewModelStore…ModelCreationExtras\n    }");
                            extras$iv = defaultViewModelCreationExtras;
                        } else {
                            extras$iv = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel = ViewModelKt.viewModel(InputReadingsViewModel.class, viewModelStoreOwner$iv, null, factory$iv, extras$iv, $composer3, ((512 << 3) & 896) | 36936, 0);
                        $composer3.endReplaceableGroup();
                        InputReadingsViewModel viewModel2 = (InputReadingsViewModel) viewModel;
                        EmergencyContactsScreenKt.EmergencyContactsScreen(contactsManager, viewModel2, $composer3, 72);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), 6, null);
                String route3 = Screen.Profile.getRoute();
                final HealthConnectManager healthConnectManager4 = HealthConnectManager.this;
                NavGraphBuilderKt.composable$default(NavHost, route3, null, null, ComposableLambdaKt.composableLambdaInstance(-52992888, true, new Function3<NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.HealthConnectNavigationKt$HealthConnectNavigation$1.3
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                        invoke(navBackStackEntry, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(NavBackStackEntry it, Composer $composer3, int $changed2) {
                        Object value$iv$iv;
                        CreationExtras extras$iv;
                        Intrinsics.checkNotNullParameter(it, "it");
                        ComposerKt.sourceInformation($composer3, "C115@6284L7,116@6329L40,117@6478L178,122@6727L80,128@6882L130:HealthConnectNavigation.kt#n2bxm1");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-52992888, $changed2, -1, "com.example.healthconnect.codelab.presentation.navigation.HealthConnectNavigation.<anonymous>.<anonymous> (HealthConnectNavigation.kt:114)");
                        }
                        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume = $composer3.consume(localContext);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Context context = (Context) consume;
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                        Object it$iv$iv = $composer3.rememberedValue();
                        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv = new UserProfileManager(context);
                            $composer3.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                        }
                        $composer3.endReplaceableGroup();
                        UserProfileManager userProfileManager = (UserProfileManager) value$iv$iv;
                        ViewModelProvider.Factory factory$iv = new ProfileViewModelFactory(HealthConnectManager.this, userProfileManager);
                        $composer3.startReplaceableGroup(1729797275);
                        ComposerKt.sourceInformation($composer3, "C(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                        ViewModelStoreOwner viewModelStoreOwner$iv = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer3, 6);
                        if (viewModelStoreOwner$iv == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                        }
                        if (viewModelStoreOwner$iv instanceof HasDefaultViewModelProviderFactory) {
                            CreationExtras defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner$iv).getDefaultViewModelCreationExtras();
                            Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "{\n        viewModelStore…ModelCreationExtras\n    }");
                            extras$iv = defaultViewModelCreationExtras;
                        } else {
                            extras$iv = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel = ViewModelKt.viewModel(ProfileViewModel.class, viewModelStoreOwner$iv, null, factory$iv, extras$iv, $composer3, ((512 << 3) & 896) | 36936, 0);
                        $composer3.endReplaceableGroup();
                        ProfileViewModel viewModel2 = (ProfileViewModel) viewModel;
                        EffectsKt.LaunchedEffect(Unit.INSTANCE, new AnonymousClass1(viewModel2, null), $composer3, 70);
                        MutableState systemStatus$delegate = viewModel2.getSystemPhaseResult();
                        ProfileScreenKt.ProfileScreen(userProfileManager, invoke$lambda$1(systemStatus$delegate), $composer3, 8, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }

                    private static final String invoke$lambda$1(MutableState<String> mutableState) {
                        MutableState<String> $this$getValue$iv = mutableState;
                        return $this$getValue$iv.getValue();
                    }

                    /* compiled from: HealthConnectNavigation.kt */
                    @Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
                    @DebugMetadata(m296c = "com.example.healthconnect.codelab.presentation.navigation.HealthConnectNavigationKt$HealthConnectNavigation$1$3$1", m297f = "HealthConnectNavigation.kt", m298i = {}, m299l = {}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                    /* renamed from: com.example.healthconnect.codelab.presentation.navigation.HealthConnectNavigationKt$HealthConnectNavigation$1$3$1, reason: invalid class name */
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ ProfileViewModel $viewModel;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(ProfileViewModel profileViewModel, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$viewModel = profileViewModel;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$viewModel, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure(obj);
                                    this.$viewModel.loadSystemStatus();
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }
                }), 6, null);
            }
        }, $composer2, 56, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.HealthConnectNavigationKt$HealthConnectNavigation$2
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
                HealthConnectNavigationKt.HealthConnectNavigation(NavHostController.this, healthConnectManager, composer, $changed | 1);
            }
        });
    }
}
