package androidx.compose.p000ui.semantics;

import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.LayoutCoordinatesKt;
import androidx.compose.p000ui.node.LayoutNode;
import androidx.compose.p000ui.node.NodeCoordinator;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.health.connect.client.records.Vo2MaxRecord;
import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsSort.kt */
@Metadata(m286d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0010\u0011B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0000H\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0012"}, m287d2 = {"Landroidx/compose/ui/semantics/NodeLocationHolder;", "", "subtreeRoot", "Landroidx/compose/ui/node/LayoutNode;", "node", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/LayoutNode;)V", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "location", "Landroidx/compose/ui/geometry/Rect;", "getNode$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "getSubtreeRoot$ui_release", "compareTo", "", Vo2MaxRecord.MeasurementMethod.OTHER, "Companion", "ComparisonStrategy", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class NodeLocationHolder implements Comparable<NodeLocationHolder> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ComparisonStrategy comparisonStrategy = ComparisonStrategy.Stripe;
    private final LayoutDirection layoutDirection;
    private final Rect location;
    private final LayoutNode node;
    private final LayoutNode subtreeRoot;

    /* compiled from: SemanticsSort.kt */
    @Metadata(m286d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m287d2 = {"Landroidx/compose/ui/semantics/NodeLocationHolder$ComparisonStrategy;", "", "(Ljava/lang/String;I)V", "Stripe", HttpHeaders.LOCATION, "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public enum ComparisonStrategy {
        Stripe,
        Location
    }

    public NodeLocationHolder(LayoutNode subtreeRoot, LayoutNode node) {
        Intrinsics.checkNotNullParameter(subtreeRoot, "subtreeRoot");
        Intrinsics.checkNotNullParameter(node, "node");
        this.subtreeRoot = subtreeRoot;
        this.node = node;
        this.layoutDirection = this.subtreeRoot.getLayoutDirection();
        NodeCoordinator subtreeRootCoordinator = this.subtreeRoot.getInnerCoordinator$ui_release();
        NodeCoordinator coordinator = SemanticsSortKt.findCoordinatorToGetBounds(this.node);
        Rect rect = null;
        if (subtreeRootCoordinator.isAttached() && coordinator.isAttached()) {
            rect = LayoutCoordinates.localBoundingBoxOf$default(subtreeRootCoordinator, coordinator, false, 2, null);
        }
        this.location = rect;
    }

    /* renamed from: getSubtreeRoot$ui_release, reason: from getter */
    public final LayoutNode getSubtreeRoot() {
        return this.subtreeRoot;
    }

    /* renamed from: getNode$ui_release, reason: from getter */
    public final LayoutNode getNode() {
        return this.node;
    }

    /* compiled from: SemanticsSort.kt */
    @Metadata(m286d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, m287d2 = {"Landroidx/compose/ui/semantics/NodeLocationHolder$Companion;", "", "()V", "comparisonStrategy", "Landroidx/compose/ui/semantics/NodeLocationHolder$ComparisonStrategy;", "getComparisonStrategy$ui_release", "()Landroidx/compose/ui/semantics/NodeLocationHolder$ComparisonStrategy;", "setComparisonStrategy$ui_release", "(Landroidx/compose/ui/semantics/NodeLocationHolder$ComparisonStrategy;)V", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ComparisonStrategy getComparisonStrategy$ui_release() {
            return NodeLocationHolder.comparisonStrategy;
        }

        public final void setComparisonStrategy$ui_release(ComparisonStrategy comparisonStrategy) {
            Intrinsics.checkNotNullParameter(comparisonStrategy, "<set-?>");
            NodeLocationHolder.comparisonStrategy = comparisonStrategy;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(NodeLocationHolder other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.location == null) {
            return 1;
        }
        if (other.location == null) {
            return -1;
        }
        if (comparisonStrategy == ComparisonStrategy.Stripe) {
            if (this.location.getBottom() - other.location.getTop() <= 0.0f) {
                return -1;
            }
            if (this.location.getTop() - other.location.getBottom() >= 0.0f) {
                return 1;
            }
        }
        if (this.layoutDirection == LayoutDirection.Ltr) {
            float leftDifference = this.location.getLeft() - other.location.getLeft();
            if (!(leftDifference == 0.0f)) {
                return leftDifference < 0.0f ? -1 : 1;
            }
        } else {
            float rightDifference = this.location.getRight() - other.location.getRight();
            if (!(rightDifference == 0.0f)) {
                return rightDifference < 0.0f ? 1 : -1;
            }
        }
        float topDifference = this.location.getTop() - other.location.getTop();
        if (!(topDifference == 0.0f)) {
            return topDifference < 0.0f ? -1 : 1;
        }
        final Rect view1Bounds = LayoutCoordinatesKt.boundsInRoot(SemanticsSortKt.findCoordinatorToGetBounds(this.node));
        final Rect view2Bounds = LayoutCoordinatesKt.boundsInRoot(SemanticsSortKt.findCoordinatorToGetBounds(other.node));
        LayoutNode child1 = SemanticsSortKt.findNodeByPredicateTraversal(this.node, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.semantics.NodeLocationHolder$compareTo$child1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(LayoutNode it) {
                Intrinsics.checkNotNullParameter(it, "it");
                NodeCoordinator wrapper = SemanticsSortKt.findCoordinatorToGetBounds(it);
                return Boolean.valueOf(wrapper.isAttached() && !Intrinsics.areEqual(Rect.this, LayoutCoordinatesKt.boundsInRoot(wrapper)));
            }
        });
        LayoutNode child2 = SemanticsSortKt.findNodeByPredicateTraversal(other.node, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.semantics.NodeLocationHolder$compareTo$child2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(LayoutNode it) {
                Intrinsics.checkNotNullParameter(it, "it");
                NodeCoordinator wrapper = SemanticsSortKt.findCoordinatorToGetBounds(it);
                return Boolean.valueOf(wrapper.isAttached() && !Intrinsics.areEqual(Rect.this, LayoutCoordinatesKt.boundsInRoot(wrapper)));
            }
        });
        if (child1 != null && child2 != null) {
            NodeLocationHolder childHolder1 = new NodeLocationHolder(this.subtreeRoot, child1);
            NodeLocationHolder childHolder2 = new NodeLocationHolder(other.subtreeRoot, child2);
            return childHolder1.compareTo(childHolder2);
        }
        if (child1 != null) {
            return 1;
        }
        if (child2 != null) {
            return -1;
        }
        int zDifference = LayoutNode.INSTANCE.getZComparator$ui_release().compare(this.node, other.node);
        if (zDifference != 0) {
            return -zDifference;
        }
        return this.node.getSemanticsId() - other.node.getSemanticsId();
    }
}
