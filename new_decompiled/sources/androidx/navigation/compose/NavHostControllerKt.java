package androidx.navigation.compose;

import android.content.Context;
import android.os.Bundle;
import androidx.compose.p000ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavHostController.kt */
@Metadata(m286d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a1\u0010\u0006\u001a\u00020\u00022\"\u0010\u0007\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t0\b\"\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0007¢\u0006\u0002\u0010\u000b\u001a\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r*\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, m287d2 = {"NavControllerSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/navigation/NavHostController;", "context", "Landroid/content/Context;", "createNavController", "rememberNavController", "navigators", "", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "([Landroidx/navigation/Navigator;Landroidx/compose/runtime/Composer;I)Landroidx/navigation/NavHostController;", "currentBackStackEntryAsState", "Landroidx/compose/runtime/State;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/navigation/NavController;", "(Landroidx/navigation/NavController;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "navigation-compose_release"}, m288k = 2, m289mv = {1, 6, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class NavHostControllerKt {
    public static final State<NavBackStackEntry> currentBackStackEntryAsState(NavController $this$currentBackStackEntryAsState, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$currentBackStackEntryAsState, "<this>");
        $composer.startReplaceableGroup(-120375203);
        ComposerKt.sourceInformation($composer, "C(currentBackStackEntryAsState)42@1719L20:NavHostController.kt#opm8kd");
        State<NavBackStackEntry> collectAsState = SnapshotStateKt.collectAsState($this$currentBackStackEntryAsState.getCurrentBackStackEntryFlow(), null, null, $composer, 56, 2);
        $composer.endReplaceableGroup();
        return collectAsState;
    }

    public static final NavHostController rememberNavController(Navigator<? extends NavDestination>[] navigators, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(navigators, "navigators");
        $composer.startReplaceableGroup(-312215566);
        ComposerKt.sourceInformation($composer, "C(rememberNavController)58@2312L7,*59@2331L119:NavHostController.kt#opm8kd");
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Context context = (Context) consume;
        Object m1652rememberSaveable = RememberSaveableKt.m1652rememberSaveable(Arrays.copyOf(navigators, navigators.length), (Saver<Object, ? extends Object>) NavControllerSaver(context), (String) null, (Function0<? extends Object>) new Function0<NavHostController>() { // from class: androidx.navigation.compose.NavHostControllerKt$rememberNavController$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NavHostController invoke() {
                NavHostController createNavController;
                createNavController = NavHostControllerKt.createNavController(context);
                return createNavController;
            }
        }, $composer, 72, 4);
        NavHostController $this$rememberNavController_u24lambda_u2d0 = (NavHostController) m1652rememberSaveable;
        for (Navigator<? extends NavDestination> navigator : navigators) {
            $this$rememberNavController_u24lambda_u2d0.get_navigatorProvider().addNavigator(navigator);
        }
        NavHostController navHostController = (NavHostController) m1652rememberSaveable;
        $composer.endReplaceableGroup();
        return navHostController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavHostController createNavController(Context context) {
        NavHostController $this$createNavController_u24lambda_u2d1 = new NavHostController(context);
        $this$createNavController_u24lambda_u2d1.get_navigatorProvider().addNavigator(new ComposeNavigator());
        $this$createNavController_u24lambda_u2d1.get_navigatorProvider().addNavigator(new DialogNavigator());
        return $this$createNavController_u24lambda_u2d1;
    }

    private static final Saver<NavHostController, ?> NavControllerSaver(final Context context) {
        return SaverKt.Saver(new Function2<SaverScope, NavHostController, Bundle>() { // from class: androidx.navigation.compose.NavHostControllerKt$NavControllerSaver$1
            @Override // kotlin.jvm.functions.Function2
            public final Bundle invoke(SaverScope Saver, NavHostController it) {
                Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                Intrinsics.checkNotNullParameter(it, "it");
                return it.saveState();
            }
        }, new Function1<Bundle, NavHostController>() { // from class: androidx.navigation.compose.NavHostControllerKt$NavControllerSaver$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final NavHostController invoke(Bundle it) {
                NavHostController $this$invoke_u24lambda_u2d0;
                Intrinsics.checkNotNullParameter(it, "it");
                $this$invoke_u24lambda_u2d0 = NavHostControllerKt.createNavController(context);
                $this$invoke_u24lambda_u2d0.restoreState(it);
                return $this$invoke_u24lambda_u2d0;
            }
        });
    }
}
