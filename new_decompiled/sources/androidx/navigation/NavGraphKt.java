package androidx.navigation;

import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavGraph.kt */
@Metadata(m286d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0086\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0002\u001a\u0017\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0086\n\u001a\u0015\u0010\f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0086\n\u001a\u0015\u0010\f\u001a\u00020\n*\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0086\n¨\u0006\u000e"}, m287d2 = {"contains", "", "Landroidx/navigation/NavGraph;", "id", "", "route", "", "get", "Landroidx/navigation/NavDestination;", "minusAssign", "", "node", "plusAssign", Vo2MaxRecord.MeasurementMethod.OTHER, "navigation-common_release"}, m288k = 2, m289mv = {1, 6, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class NavGraphKt {
    public static final NavDestination get(NavGraph $this$get, int id) {
        Intrinsics.checkNotNullParameter($this$get, "<this>");
        NavDestination findNode = $this$get.findNode(id);
        if (findNode != null) {
            return findNode;
        }
        throw new IllegalArgumentException("No destination for " + id + " was found in " + $this$get);
    }

    public static final NavDestination get(NavGraph $this$get, String route) {
        Intrinsics.checkNotNullParameter($this$get, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        NavDestination findNode = $this$get.findNode(route);
        if (findNode != null) {
            return findNode;
        }
        throw new IllegalArgumentException("No destination for " + route + " was found in " + $this$get);
    }

    public static final boolean contains(NavGraph $this$contains, int id) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.findNode(id) != null;
    }

    public static final boolean contains(NavGraph $this$contains, String route) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        return $this$contains.findNode(route) != null;
    }

    public static final void plusAssign(NavGraph $this$plusAssign, NavDestination node) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        $this$plusAssign.addDestination(node);
    }

    public static final void plusAssign(NavGraph $this$plusAssign, NavGraph other) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        $this$plusAssign.addAll(other);
    }

    public static final void minusAssign(NavGraph $this$minusAssign, NavDestination node) {
        Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        $this$minusAssign.remove(node);
    }
}
