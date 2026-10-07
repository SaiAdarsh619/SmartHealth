package androidx.navigation.compose;

import androidx.compose.p000ui.window.AndroidDialog_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.compose.DialogNavigator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DialogHost.kt */
@Metadata(m286d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0001¢\u0006\u0002\u0010\n\u001a%\u0010\u000b\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00070\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m287d2 = {"DialogHost", "", "dialogNavigator", "Landroidx/navigation/compose/DialogNavigator;", "(Landroidx/navigation/compose/DialogNavigator;Landroidx/compose/runtime/Composer;I)V", "rememberVisibleList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/navigation/NavBackStackEntry;", "transitionsInProgress", "", "(Ljava/util/Collection;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/snapshots/SnapshotStateList;", "PopulateVisibleList", "", "(Ljava/util/List;Ljava/util/Collection;Landroidx/compose/runtime/Composer;I)V", "navigation-compose_release"}, m288k = 2, m289mv = {1, 6, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class DialogHostKt {
    public static final void DialogHost(final DialogNavigator dialogNavigator, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(dialogNavigator, "dialogNavigator");
        Composer $composer2 = $composer.startRestartGroup(294589392);
        ComposerKt.sourceInformation($composer2, "C(DialogHost)38@1505L29,39@1588L16,40@1632L36,41@1690L36,*45@1853L623:DialogHost.kt#opm8kd");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(dialogNavigator) ? 4 : 2;
        }
        if (($dirty & 11) != 2 || !$composer2.getSkipping()) {
            final SaveableStateHolder saveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder($composer2, 0);
            State dialogBackStack$delegate = SnapshotStateKt.collectAsState(dialogNavigator.getBackStack$navigation_compose_release(), null, $composer2, 8, 1);
            Iterable visibleBackStack = rememberVisibleList(m4663DialogHost$lambda0(dialogBackStack$delegate), $composer2, 8);
            PopulateVisibleList((List) visibleBackStack, m4663DialogHost$lambda0(dialogBackStack$delegate), $composer2, 64);
            Iterable $this$forEach$iv = visibleBackStack;
            for (Object element$iv : $this$forEach$iv) {
                final NavBackStackEntry backStackEntry = (NavBackStackEntry) element$iv;
                final DialogNavigator.Destination destination = (DialogNavigator.Destination) backStackEntry.getDestination();
                AndroidDialog_androidKt.Dialog(new Function0<Unit>() { // from class: androidx.navigation.compose.DialogHostKt$DialogHost$1$1
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
                        DialogNavigator.this.dismiss$navigation_compose_release(backStackEntry);
                    }
                }, destination.getDialogProperties(), ComposableLambdaKt.composableLambda($composer2, 1129586364, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.DialogHostKt$DialogHost$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer3, int $changed2) {
                        ComposerKt.sourceInformation($composer3, "C49@2015L167,57@2358L108:DialogHost.kt#opm8kd");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            NavBackStackEntry navBackStackEntry = NavBackStackEntry.this;
                            final DialogNavigator dialogNavigator2 = dialogNavigator;
                            final NavBackStackEntry navBackStackEntry2 = NavBackStackEntry.this;
                            EffectsKt.DisposableEffect(navBackStackEntry, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.navigation.compose.DialogHostKt$DialogHost$1$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                    final DialogNavigator dialogNavigator3 = DialogNavigator.this;
                                    final NavBackStackEntry navBackStackEntry3 = navBackStackEntry2;
                                    return new DisposableEffectResult() { // from class: androidx.navigation.compose.DialogHostKt$DialogHost$1$2$1$invoke$$inlined$onDispose$1
                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                        public void dispose() {
                                            DialogNavigator.this.onTransitionComplete$navigation_compose_release(navBackStackEntry3);
                                        }
                                    };
                                }
                            }, $composer3, 8);
                            NavBackStackEntry navBackStackEntry3 = NavBackStackEntry.this;
                            SaveableStateHolder saveableStateHolder2 = saveableStateHolder;
                            final DialogNavigator.Destination destination2 = destination;
                            final NavBackStackEntry navBackStackEntry4 = NavBackStackEntry.this;
                            NavBackStackEntryProviderKt.LocalOwnersProvider(navBackStackEntry3, saveableStateHolder2, ComposableLambdaKt.composableLambda($composer3, -497631156, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.DialogHostKt$DialogHost$1$2.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                    invoke(composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer $composer4, int $changed3) {
                                    ComposerKt.sourceInformation($composer4, "C58@2429L23:DialogHost.kt#opm8kd");
                                    if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                        DialogNavigator.Destination.this.getContent$navigation_compose_release().invoke(navBackStackEntry4, $composer4, 8);
                                    } else {
                                        $composer4.skipToGroupEnd();
                                    }
                                }
                            }), $composer3, 456);
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }), $composer2, 384, 0);
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.DialogHostKt$DialogHost$2
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
                DialogHostKt.DialogHost(DialogNavigator.this, composer, $changed | 1);
            }
        });
    }

    /* renamed from: DialogHost$lambda-0, reason: not valid java name */
    private static final List<NavBackStackEntry> m4663DialogHost$lambda0(State<? extends List<NavBackStackEntry>> state) {
        Object thisObj$iv = state.getValue();
        return (List) thisObj$iv;
    }

    public static final void PopulateVisibleList(final List<NavBackStackEntry> list, final Collection<NavBackStackEntry> transitionsInProgress, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(transitionsInProgress, "transitionsInProgress");
        Composer $composer2 = $composer.startRestartGroup(1537894851);
        ComposerKt.sourceInformation($composer2, "C(PopulateVisibleList)*69@2677L876:DialogHost.kt#opm8kd");
        Collection<NavBackStackEntry> $this$forEach$iv = transitionsInProgress;
        for (Object element$iv : $this$forEach$iv) {
            NavBackStackEntry entry = (NavBackStackEntry) element$iv;
            EffectsKt.DisposableEffect(entry.getLifecycle(), new DialogHostKt$PopulateVisibleList$1$1(entry, list), $composer2, 8);
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.DialogHostKt$PopulateVisibleList$2
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
                DialogHostKt.PopulateVisibleList(list, transitionsInProgress, composer, $changed | 1);
            }
        });
    }

    public static final SnapshotStateList<NavBackStackEntry> rememberVisibleList(Collection<NavBackStackEntry> transitionsInProgress, Composer $composer, int $changed) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(transitionsInProgress, "transitionsInProgress");
        $composer.startReplaceableGroup(467378629);
        ComposerKt.sourceInformation($composer, "C(rememberVisibleList)94@3668L299:DialogHost.kt#opm8kd");
        int $changed$iv = 8;
        $composer.startReplaceableGroup(-3686930);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(transitionsInProgress);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            SnapshotStateList it = SnapshotStateKt.mutableStateListOf();
            Collection<NavBackStackEntry> $this$filter$iv = transitionsInProgress;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                NavBackStackEntry entry = (NavBackStackEntry) element$iv$iv;
                int $changed$iv2 = $changed$iv;
                if (entry.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                    destination$iv$iv.add(element$iv$iv);
                }
                $changed$iv = $changed$iv2;
            }
            it.addAll((List) destination$iv$iv);
            value$iv$iv = it;
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        SnapshotStateList<NavBackStackEntry> snapshotStateList = (SnapshotStateList) value$iv$iv;
        $composer.endReplaceableGroup();
        return snapshotStateList;
    }
}
