package androidx.navigation.compose;

import androidx.compose.p000ui.window.DialogProperties;
import androidx.compose.runtime.Composer;
import androidx.core.app.NotificationCompat;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavArgument;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.compose.ComposeNavigator;
import androidx.navigation.compose.DialogNavigator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavGraphBuilder.kt */
@Metadata(m286d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aP\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u000e\u001aZ\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u0012\u001aS\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0016¨\u0006\u0017"}, m287d2 = {ComposeNavigator.NAME, "", "Landroidx/navigation/NavGraphBuilder;", "route", "", "arguments", "", "Landroidx/navigation/NamedNavArgument;", "deepLinks", "Landroidx/navigation/NavDeepLink;", "content", "Lkotlin/Function1;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/runtime/Composable;", "(Landroidx/navigation/NavGraphBuilder;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function3;)V", DialogNavigator.NAME, "dialogProperties", "Landroidx/compose/ui/window/DialogProperties;", "(Landroidx/navigation/NavGraphBuilder;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function3;)V", NotificationCompat.CATEGORY_NAVIGATION, "startDestination", "builder", "Lkotlin/ExtensionFunctionType;", "navigation-compose_release"}, m288k = 2, m289mv = {1, 6, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class NavGraphBuilderKt {
    public static /* synthetic */ void composable$default(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function3 function3, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        composable(navGraphBuilder, str, list, list2, function3);
    }

    public static final void composable(NavGraphBuilder $this$composable, String route, List<NamedNavArgument> arguments, List<NavDeepLink> deepLinks, Function3<? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter($this$composable, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(deepLinks, "deepLinks");
        Intrinsics.checkNotNullParameter(content, "content");
        NavigatorProvider $this$get$iv = $this$composable.getProvider();
        ComposeNavigator.Destination $this$composable_u24lambda_u2d2 = new ComposeNavigator.Destination((ComposeNavigator) $this$get$iv.getNavigator(ComposeNavigator.class), content);
        $this$composable_u24lambda_u2d2.setRoute(route);
        List<NamedNavArgument> $this$forEach$iv = arguments;
        for (Object element$iv : $this$forEach$iv) {
            NamedNavArgument namedNavArgument = (NamedNavArgument) element$iv;
            String argumentName = namedNavArgument.getName();
            NavArgument argument = namedNavArgument.getArgument();
            $this$composable_u24lambda_u2d2.addArgument(argumentName, argument);
        }
        List<NavDeepLink> $this$forEach$iv2 = deepLinks;
        for (Object element$iv2 : $this$forEach$iv2) {
            NavDeepLink deepLink = (NavDeepLink) element$iv2;
            $this$composable_u24lambda_u2d2.addDeepLink(deepLink);
        }
        $this$composable.addDestination($this$composable_u24lambda_u2d2);
    }

    public static /* synthetic */ void navigation$default(NavGraphBuilder navGraphBuilder, String str, String str2, List list, List list2, Function1 function1, int i, Object obj) {
        List list3;
        List list4;
        if ((i & 4) == 0) {
            list3 = list;
        } else {
            list3 = CollectionsKt.emptyList();
        }
        if ((i & 8) == 0) {
            list4 = list2;
        } else {
            list4 = CollectionsKt.emptyList();
        }
        navigation(navGraphBuilder, str, str2, list3, list4, function1);
    }

    public static final void navigation(NavGraphBuilder $this$navigation, String startDestination, String route, List<NamedNavArgument> arguments, List<NavDeepLink> deepLinks, Function1<? super NavGraphBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter($this$navigation, "<this>");
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(deepLinks, "deepLinks");
        Intrinsics.checkNotNullParameter(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder($this$navigation.getProvider(), startDestination, route);
        builder.invoke(navGraphBuilder);
        NavGraph $this$navigation_u24lambda_u2d5 = navGraphBuilder.build();
        List<NamedNavArgument> $this$forEach$iv = arguments;
        for (Object element$iv : $this$forEach$iv) {
            NamedNavArgument namedNavArgument = (NamedNavArgument) element$iv;
            String argumentName = namedNavArgument.getName();
            NavArgument argument = namedNavArgument.getArgument();
            $this$navigation_u24lambda_u2d5.addArgument(argumentName, argument);
        }
        List<NavDeepLink> $this$forEach$iv2 = deepLinks;
        for (Object element$iv2 : $this$forEach$iv2) {
            NavDeepLink deepLink = (NavDeepLink) element$iv2;
            $this$navigation_u24lambda_u2d5.addDeepLink(deepLink);
        }
        $this$navigation.addDestination($this$navigation_u24lambda_u2d5);
    }

    public static final void dialog(NavGraphBuilder $this$dialog, String route, List<NamedNavArgument> arguments, List<NavDeepLink> deepLinks, DialogProperties dialogProperties, Function3<? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter($this$dialog, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(deepLinks, "deepLinks");
        Intrinsics.checkNotNullParameter(dialogProperties, "dialogProperties");
        Intrinsics.checkNotNullParameter(content, "content");
        NavigatorProvider $this$get$iv = $this$dialog.getProvider();
        DialogNavigator.Destination $this$dialog_u24lambda_u2d8 = new DialogNavigator.Destination((DialogNavigator) $this$get$iv.getNavigator(DialogNavigator.class), dialogProperties, content);
        $this$dialog_u24lambda_u2d8.setRoute(route);
        List<NamedNavArgument> $this$forEach$iv = arguments;
        for (Object element$iv : $this$forEach$iv) {
            NamedNavArgument namedNavArgument = (NamedNavArgument) element$iv;
            String argumentName = namedNavArgument.getName();
            NavArgument argument = namedNavArgument.getArgument();
            $this$dialog_u24lambda_u2d8.addArgument(argumentName, argument);
        }
        List<NavDeepLink> $this$forEach$iv2 = deepLinks;
        for (Object element$iv2 : $this$forEach$iv2) {
            NavDeepLink deepLink = (NavDeepLink) element$iv2;
            $this$dialog_u24lambda_u2d8.addDeepLink(deepLink);
        }
        $this$dialog.addDestination($this$dialog_u24lambda_u2d8);
    }
}
