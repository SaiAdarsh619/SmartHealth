package androidx.compose.p000ui.semantics;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.node.LayoutNode;
import androidx.compose.p000ui.node.NodeCoordinator;
import androidx.compose.p000ui.node.SemanticsModifierNode;
import androidx.compose.p000ui.semantics.NodeLocationHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsSort.kt */
@Metadata(m286d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\"\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\u001a\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0000¨\u0006\f"}, m287d2 = {"findCoordinatorToGetBounds", "Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LayoutNode;", "findNodeByPredicateTraversal", "predicate", "Lkotlin/Function1;", "", "findOneLayerOfSemanticsWrappersSortedByBounds", "", "Landroidx/compose/ui/node/SemanticsModifierNode;", "list", "", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SemanticsSortKt {
    public static /* synthetic */ List findOneLayerOfSemanticsWrappersSortedByBounds$default(LayoutNode layoutNode, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return findOneLayerOfSemanticsWrappersSortedByBounds(layoutNode, list);
    }

    private static final List<NodeLocationHolder> findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy(List<NodeLocationHolder> list) {
        try {
            NodeLocationHolder.INSTANCE.setComparisonStrategy$ui_release(NodeLocationHolder.ComparisonStrategy.Stripe);
            List $this$findOneLayerOfSemanticsWrappersSortedByBounds_u24sortWithStrategy_u24lambda_u2d0 = CollectionsKt.toMutableList((Collection) list);
            CollectionsKt.sort($this$findOneLayerOfSemanticsWrappersSortedByBounds_u24sortWithStrategy_u24lambda_u2d0);
            return $this$findOneLayerOfSemanticsWrappersSortedByBounds_u24sortWithStrategy_u24lambda_u2d0;
        } catch (IllegalArgumentException e) {
            NodeLocationHolder.INSTANCE.setComparisonStrategy$ui_release(NodeLocationHolder.ComparisonStrategy.Location);
            List $this$findOneLayerOfSemanticsWrappersSortedByBounds_u24sortWithStrategy_u24lambda_u2d1 = CollectionsKt.toMutableList((Collection) list);
            CollectionsKt.sort($this$findOneLayerOfSemanticsWrappersSortedByBounds_u24sortWithStrategy_u24lambda_u2d1);
            return $this$findOneLayerOfSemanticsWrappersSortedByBounds_u24sortWithStrategy_u24lambda_u2d1;
        }
    }

    public static final List<SemanticsModifierNode> findOneLayerOfSemanticsWrappersSortedByBounds(LayoutNode $this$findOneLayerOfSemanticsWrappersSortedByBounds, List<SemanticsModifierNode> list) {
        Intrinsics.checkNotNullParameter($this$findOneLayerOfSemanticsWrappersSortedByBounds, "<this>");
        Intrinsics.checkNotNullParameter(list, "list");
        if (!$this$findOneLayerOfSemanticsWrappersSortedByBounds.isAttached()) {
            return list;
        }
        ArrayList holders = new ArrayList();
        List $this$fastForEach$iv = $this$findOneLayerOfSemanticsWrappersSortedByBounds.getChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            LayoutNode it = (LayoutNode) item$iv;
            if (it.isAttached()) {
                holders.add(new NodeLocationHolder($this$findOneLayerOfSemanticsWrappersSortedByBounds, it));
            }
        }
        List $this$fastMap$iv = findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy(holders);
        List target$iv = new ArrayList($this$fastMap$iv.size());
        int size2 = $this$fastMap$iv.size();
        for (int index$iv$iv = 0; index$iv$iv < size2; index$iv$iv++) {
            Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
            target$iv.add(((NodeLocationHolder) item$iv$iv).getNode());
        }
        List sortedChildren = target$iv;
        int size3 = sortedChildren.size();
        for (int index$iv2 = 0; index$iv2 < size3; index$iv2++) {
            Object item$iv2 = sortedChildren.get(index$iv2);
            LayoutNode child = (LayoutNode) item$iv2;
            SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(child);
            if (outerSemantics != null) {
                list.add(outerSemantics);
            } else {
                findOneLayerOfSemanticsWrappersSortedByBounds(child, list);
            }
        }
        return list;
    }

    public static final LayoutNode findNodeByPredicateTraversal(LayoutNode $this$findNodeByPredicateTraversal, Function1<? super LayoutNode, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$findNodeByPredicateTraversal, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (predicate.invoke($this$findNodeByPredicateTraversal).booleanValue()) {
            return $this$findNodeByPredicateTraversal;
        }
        List $this$fastForEach$iv = $this$findNodeByPredicateTraversal.getChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            LayoutNode it = (LayoutNode) item$iv;
            LayoutNode result = findNodeByPredicateTraversal(it, predicate);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public static final NodeCoordinator findCoordinatorToGetBounds(LayoutNode $this$findCoordinatorToGetBounds) {
        Modifier.Node node;
        NodeCoordinator coordinator;
        Intrinsics.checkNotNullParameter($this$findCoordinatorToGetBounds, "<this>");
        SemanticsModifierNode outerMergingSemantics = SemanticsNodeKt.getOuterMergingSemantics($this$findCoordinatorToGetBounds);
        if (outerMergingSemantics == null) {
            outerMergingSemantics = SemanticsNodeKt.getOuterSemantics($this$findCoordinatorToGetBounds);
        }
        return (outerMergingSemantics == null || (node = outerMergingSemantics.getNode()) == null || (coordinator = node.getCoordinator()) == null) ? $this$findCoordinatorToGetBounds.getInnerCoordinator$ui_release() : coordinator;
    }
}
