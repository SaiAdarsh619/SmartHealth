package androidx.navigation.compose;

import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.health.platform.client.SdkConfig;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.compose.ComposeNavigator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: NavHost.kt */
@Metadata(m286d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, m287d2 = {"NavHost", "", "navController", "Landroidx/navigation/NavHostController;", "graph", "Landroidx/navigation/NavGraph;", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "startDestination", "", "route", "builder", "Lkotlin/Function1;", "Landroidx/navigation/NavGraphBuilder;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "navigation-compose_release"}, m288k = 2, m289mv = {1, 6, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class NavHostKt {
    public static final void NavHost(final NavHostController navController, final String startDestination, Modifier modifier, String route, final Function1<? super NavGraphBuilder, Unit> builder, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String route2;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Composer $composer2 = $composer.startRestartGroup(141827520);
        ComposerKt.sourceInformation($composer2, "C(NavHost)P(2,4,1,3)68@2616L126,66@2576L190:NavHost.kt#opm8kd");
        if ((i & 4) != 0) {
            modifier2 = Modifier.INSTANCE;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) == 0) {
            route2 = route;
        } else {
            route2 = null;
        }
        int i2 = (($changed >> 9) & 14) | ($changed & SdkConfig.SDK_VERSION) | (($changed >> 6) & 896);
        $composer2.startReplaceableGroup(-3686095);
        ComposerKt.sourceInformation($composer2, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer2.changed(route2) | $composer2.changed(startDestination) | $composer2.changed(builder);
        Object it$iv$iv = $composer2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            NavHostController $this$createGraph$iv = navController;
            NavigatorProvider $this$navigation$iv$iv = $this$createGraph$iv.get_navigatorProvider();
            NavGraphBuilder navGraphBuilder = new NavGraphBuilder($this$navigation$iv$iv, startDestination, route2);
            builder.invoke(navGraphBuilder);
            value$iv$iv = navGraphBuilder.build();
            $composer2.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer2.endReplaceableGroup();
        NavHost(navController, (NavGraph) value$iv$iv, modifier2, $composer2, ($changed & 896) | 72, 0);
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = modifier2;
        final String str = route2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$2
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

            public final void invoke(Composer composer, int i3) {
                NavHostKt.NavHost(NavHostController.this, startDestination, modifier3, str, builder, composer, $changed | 1, i);
            }
        });
    }

    public static final void NavHost(final NavHostController navController, final NavGraph graph, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Object value$iv$iv;
        LifecycleOwner lifecycleOwner;
        DialogNavigator dialogNavigator;
        Object value$iv$iv2;
        DialogNavigator dialogNavigator2;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(graph, "graph");
        Composer $composer2 = $composer.startRestartGroup(-957014592);
        ComposerKt.sourceInformation($composer2, "C(NavHost)P(2)94@3456L7,*95@3532L7,98@3715L7,109@4219L170,119@4480L29,126@4829L223,132@5053L27,136@5164L33,172@6646L27:NavHost.kt#opm8kd");
        Modifier modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
        ComposerKt.sourceInformationMarkerStart($composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer2.consume(localLifecycleOwner);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        LifecycleOwner lifecycleOwner2 = (LifecycleOwner) consume;
        ViewModelStoreOwner viewModelStoreOwner = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer2, 8);
        if (viewModelStoreOwner == null) {
            throw new IllegalStateException("NavHost requires a ViewModelStoreOwner to be provided via LocalViewModelStoreOwner".toString());
        }
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent($composer2, 8);
        OnBackPressedDispatcher onBackPressedDispatcher = onBackPressedDispatcherOwner != null ? onBackPressedDispatcherOwner.getOnBackPressedDispatcher() : null;
        navController.setLifecycleOwner(lifecycleOwner2);
        ViewModelStore viewModelStore = viewModelStoreOwner.getViewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
        navController.setViewModelStore(viewModelStore);
        if (onBackPressedDispatcher != null) {
            navController.setOnBackPressedDispatcher(onBackPressedDispatcher);
        }
        EffectsKt.DisposableEffect(navController, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                NavHostController.this.enableOnBackPressed(true);
                final NavHostController navHostController = NavHostController.this;
                return new DisposableEffectResult() { // from class: androidx.navigation.compose.NavHostKt$NavHost$3$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        NavHostController.this.enableOnBackPressed(false);
                    }
                };
            }
        }, $composer2, 8);
        navController.setGraph(graph);
        final SaveableStateHolder saveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder($composer2, 0);
        NavigatorProvider $this$get$iv = navController.get_navigatorProvider();
        Navigator navigator = $this$get$iv.getNavigator(ComposeNavigator.NAME);
        ComposeNavigator composeNavigator = navigator instanceof ComposeNavigator ? (ComposeNavigator) navigator : null;
        if (composeNavigator == null) {
            ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            final Modifier modifier3 = modifier2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$composeNavigator$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i2) {
                    NavHostKt.NavHost(NavHostController.this, graph, modifier3, composer, $changed | 1, i);
                }
            });
            return;
        }
        final ComposeNavigator composeNavigator2 = composeNavigator;
        Object key1$iv = navController.getVisibleEntries();
        $composer2.startReplaceableGroup(-3686930);
        ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer2.changed(key1$iv);
        Object it$iv$iv = $composer2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            final Flow $this$map$iv = navController.getVisibleEntries();
            value$iv$iv = new Flow<List<? extends NavBackStackEntry>>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$lambda-4$$inlined$map$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super List<? extends NavBackStackEntry>> flowCollector, Continuation $completion) {
                    Object collect = Flow.this.collect(new C08172(flowCollector), $completion);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }

                /* compiled from: Emitters.kt */
                @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m287d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m288k = 3, m289mv = {1, 6, 0}, m291xi = 48)
                /* renamed from: androidx.navigation.compose.NavHostKt$NavHost$lambda-4$$inlined$map$1$2 */
                public static final class C08172<T> implements FlowCollector, SuspendFunction {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* compiled from: Emitters.kt */
                    @Metadata(m288k = 3, m289mv = {1, 6, 0}, m291xi = 48)
                    @DebugMetadata(m296c = "androidx.navigation.compose.NavHostKt$NavHost$lambda-4$$inlined$map$1$2", m297f = "NavHost.kt", m298i = {}, m299l = {224}, m300m = "emit", m301n = {}, m302s = {})
                    /* renamed from: androidx.navigation.compose.NavHostKt$NavHost$lambda-4$$inlined$map$1$2$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return C08172.this.emit(null, this);
                        }
                    }

                    public C08172(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object value, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        AnonymousClass1 anonymousClass12;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label -= Integer.MIN_VALUE;
                                anonymousClass12 = anonymousClass1;
                                Object $result = anonymousClass12.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (anonymousClass12.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        FlowCollector flowCollector = this.$this_unsafeFlow;
                                        Iterable it = (List) value;
                                        Iterable $this$filterTo$iv$iv = it;
                                        Collection destination$iv$iv = new ArrayList();
                                        for (Object element$iv$iv : $this$filterTo$iv$iv) {
                                            NavBackStackEntry entry = (NavBackStackEntry) element$iv$iv;
                                            if (Intrinsics.areEqual(entry.getDestination().getNavigatorName(), ComposeNavigator.NAME)) {
                                                destination$iv$iv.add(element$iv$iv);
                                            }
                                        }
                                        anonymousClass12.label = 1;
                                        if (flowCollector.emit((List) destination$iv$iv, anonymousClass12) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        break;
                                    case 1:
                                        ResultKt.throwOnFailure($result);
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        anonymousClass1 = new AnonymousClass1(continuation);
                        anonymousClass12 = anonymousClass1;
                        Object $result2 = anonymousClass12.result;
                        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (anonymousClass12.label) {
                        }
                        return Unit.INSTANCE;
                    }
                }
            };
            $composer2.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer2.endReplaceableGroup();
        final State visibleEntries$delegate = SnapshotStateKt.collectAsState((Flow) value$iv$iv, CollectionsKt.emptyList(), null, $composer2, 8, 2);
        NavBackStackEntry backStackEntry = (NavBackStackEntry) CollectionsKt.lastOrNull((List) m4665NavHost$lambda5(visibleEntries$delegate));
        $composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv2 = $composer2.rememberedValue();
        if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            lifecycleOwner = lifecycleOwner2;
            dialogNavigator = null;
            value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
            $composer2.updateRememberedValue(value$iv$iv2);
        } else {
            lifecycleOwner = lifecycleOwner2;
            dialogNavigator = null;
            value$iv$iv2 = it$iv$iv2;
        }
        $composer2.endReplaceableGroup();
        final MutableState initialCrossfade$delegate = (MutableState) value$iv$iv2;
        $composer2.startReplaceableGroup(1822173528);
        ComposerKt.sourceInformation($composer2, "140@5379L1059");
        if (backStackEntry != null) {
            dialogNavigator2 = dialogNavigator;
            CrossfadeKt.Crossfade(backStackEntry.getId(), modifier2, null, ComposableLambdaKt.composableLambda($composer2, 1319254703, true, new Function3<String, Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(String str, Composer composer, Integer num) {
                    invoke(str, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(String it, Composer $composer3, int $changed2) {
                    List $this$last$iv;
                    Object it2 = it;
                    Intrinsics.checkNotNullParameter(it2, "it");
                    ComposerKt.sourceInformation($composer3, "C145@5657L600,145@5634L623,161@6281L147:NavHost.kt#opm8kd");
                    int $dirty = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty |= $composer3.changed(it2) ? 4 : 2;
                    }
                    if (($dirty & 91) != 18 || !$composer3.getSkipping()) {
                        $this$last$iv = NavHostKt.m4665NavHost$lambda5(visibleEntries$delegate);
                        ListIterator iterator$iv = $this$last$iv.listIterator($this$last$iv.size());
                        while (iterator$iv.hasPrevious()) {
                            Object element$iv = iterator$iv.previous();
                            NavBackStackEntry entry = (NavBackStackEntry) element$iv;
                            if (Intrinsics.areEqual(it2, entry.getId())) {
                                final NavBackStackEntry lastEntry = (NavBackStackEntry) element$iv;
                                Unit unit = Unit.INSTANCE;
                                Object key1$iv2 = initialCrossfade$delegate;
                                Object key2$iv = visibleEntries$delegate;
                                Object key3$iv = composeNavigator2;
                                final MutableState<Boolean> mutableState = initialCrossfade$delegate;
                                final State<List<NavBackStackEntry>> state = visibleEntries$delegate;
                                final ComposeNavigator composeNavigator3 = composeNavigator2;
                                $composer3.startReplaceableGroup(-3686095);
                                ComposerKt.sourceInformation($composer3, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                                boolean invalid$iv$iv2 = $composer3.changed(key1$iv2) | $composer3.changed(key2$iv) | $composer3.changed(key3$iv);
                                Object value$iv$iv3 = $composer3.rememberedValue();
                                if (!invalid$iv$iv2 && value$iv$iv3 != Composer.INSTANCE.getEmpty()) {
                                    $composer3.endReplaceableGroup();
                                    EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv$iv3, $composer3, 0);
                                    NavBackStackEntryProviderKt.LocalOwnersProvider(lastEntry, saveableStateHolder, ComposableLambdaKt.composableLambda($composer3, 879893279, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$4.2
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                            invoke(composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer $composer4, int $changed3) {
                                            ComposerKt.sourceInformation($composer4, "C162@6396L18:NavHost.kt#opm8kd");
                                            if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                                ((ComposeNavigator.Destination) NavBackStackEntry.this.getDestination()).getContent$navigation_compose_release().invoke(NavBackStackEntry.this, $composer4, 8);
                                            } else {
                                                $composer4.skipToGroupEnd();
                                            }
                                        }
                                    }), $composer3, 456);
                                    return;
                                }
                                value$iv$iv3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$4$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                        boolean m4666NavHost$lambda7;
                                        Iterable m4665NavHost$lambda5;
                                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                        m4666NavHost$lambda7 = NavHostKt.m4666NavHost$lambda7(mutableState);
                                        if (m4666NavHost$lambda7) {
                                            m4665NavHost$lambda5 = NavHostKt.m4665NavHost$lambda5(state);
                                            Iterable $this$forEach$iv = m4665NavHost$lambda5;
                                            ComposeNavigator composeNavigator4 = composeNavigator3;
                                            for (Object element$iv2 : $this$forEach$iv) {
                                                NavBackStackEntry entry2 = (NavBackStackEntry) element$iv2;
                                                composeNavigator4.onTransitionComplete$navigation_compose_release(entry2);
                                            }
                                            NavHostKt.m4667NavHost$lambda8(mutableState, false);
                                        }
                                        final State<List<NavBackStackEntry>> state2 = state;
                                        final ComposeNavigator composeNavigator5 = composeNavigator3;
                                        return new DisposableEffectResult() { // from class: androidx.navigation.compose.NavHostKt$NavHost$4$1$1$invoke$$inlined$onDispose$1
                                            @Override // androidx.compose.runtime.DisposableEffectResult
                                            public void dispose() {
                                                Iterable m4665NavHost$lambda52;
                                                m4665NavHost$lambda52 = NavHostKt.m4665NavHost$lambda5(State.this);
                                                Iterable $this$forEach$iv2 = m4665NavHost$lambda52;
                                                for (Object element$iv3 : $this$forEach$iv2) {
                                                    NavBackStackEntry entry3 = (NavBackStackEntry) element$iv3;
                                                    composeNavigator5.onTransitionComplete$navigation_compose_release(entry3);
                                                }
                                            }
                                        };
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv$iv3);
                                $composer3.endReplaceableGroup();
                                EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv$iv3, $composer3, 0);
                                NavBackStackEntryProviderKt.LocalOwnersProvider(lastEntry, saveableStateHolder, ComposableLambdaKt.composableLambda($composer3, 879893279, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$4.2
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer4, int $changed3) {
                                        ComposerKt.sourceInformation($composer4, "C162@6396L18:NavHost.kt#opm8kd");
                                        if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                            ((ComposeNavigator.Destination) NavBackStackEntry.this.getDestination()).getContent$navigation_compose_release().invoke(NavBackStackEntry.this, $composer4, 8);
                                        } else {
                                            $composer4.skipToGroupEnd();
                                        }
                                    }
                                }), $composer3, 456);
                                return;
                            }
                            it2 = it;
                        }
                        throw new NoSuchElementException("List contains no element matching the predicate.");
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, (($changed >> 3) & SdkConfig.SDK_VERSION) | 3072, 4);
        } else {
            dialogNavigator2 = dialogNavigator;
        }
        $composer2.endReplaceableGroup();
        NavigatorProvider $this$get$iv2 = navController.get_navigatorProvider();
        Navigator navigator2 = $this$get$iv2.getNavigator(DialogNavigator.NAME);
        DialogNavigator dialogNavigator3 = navigator2 instanceof DialogNavigator ? (DialogNavigator) navigator2 : dialogNavigator2;
        if (dialogNavigator3 == null) {
            ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
            if (endRestartGroup2 == null) {
                return;
            }
            final Modifier modifier4 = modifier2;
            endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$dialogNavigator$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i2) {
                    NavHostKt.NavHost(NavHostController.this, graph, modifier4, composer, $changed | 1, i);
                }
            });
            return;
        }
        DialogNavigator dialogNavigator4 = dialogNavigator3;
        DialogHostKt.DialogHost(dialogNavigator4, $composer2, 0);
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 == null) {
            return;
        }
        final Modifier modifier5 = modifier2;
        endRestartGroup3.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i2) {
                NavHostKt.NavHost(NavHostController.this, graph, modifier5, composer, $changed | 1, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: NavHost$lambda-5, reason: not valid java name */
    public static final List<NavBackStackEntry> m4665NavHost$lambda5(State<? extends List<NavBackStackEntry>> state) {
        Object thisObj$iv = state.getValue();
        return (List) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: NavHost$lambda-7, reason: not valid java name */
    public static final boolean m4666NavHost$lambda7(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: NavHost$lambda-8, reason: not valid java name */
    public static final void m4667NavHost$lambda8(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }
}
