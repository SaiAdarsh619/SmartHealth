package androidx.compose.p000ui.focus;

import androidx.compose.p000ui.node.LayoutNode;
import androidx.compose.p000ui.node.NodeCoordinator;
import androidx.compose.runtime.collection.MutableVector;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OneDimensionalFocusSearch.kt */
@Metadata(m286d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000bH\u0002¨\u0006\r"}, m287d2 = {"Landroidx/compose/ui/focus/FocusableChildrenComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/focus/FocusModifier;", "Lkotlin/Comparator;", "()V", "compare", "", "focusModifier1", "focusModifier2", "pathFromRoot", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class FocusableChildrenComparator implements Comparator<FocusModifier> {
    public static final FocusableChildrenComparator INSTANCE = new FocusableChildrenComparator();

    private FocusableChildrenComparator() {
    }

    @Override // java.util.Comparator
    public int compare(FocusModifier focusModifier1, FocusModifier focusModifier2) {
        if (focusModifier1 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        if (focusModifier2 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        if (!FocusTraversalKt.isEligibleForFocusSearch(focusModifier1) || !FocusTraversalKt.isEligibleForFocusSearch(focusModifier2)) {
            return 0;
        }
        NodeCoordinator coordinator = focusModifier1.getCoordinator();
        LayoutNode layoutNode1 = coordinator != null ? coordinator.getLayoutNode() : null;
        if (layoutNode1 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        NodeCoordinator coordinator2 = focusModifier2.getCoordinator();
        LayoutNode layoutNode = coordinator2 != null ? coordinator2.getLayoutNode() : null;
        if (layoutNode == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        LayoutNode layoutNode2 = layoutNode;
        if (Intrinsics.areEqual(layoutNode1, layoutNode2)) {
            return 0;
        }
        MutableVector pathFromRoot1 = pathFromRoot(layoutNode1);
        MutableVector pathFromRoot2 = pathFromRoot(layoutNode2);
        int depth = 0;
        int min = Math.min(pathFromRoot1.getSize() - 1, pathFromRoot2.getSize() - 1);
        if (0 <= min) {
            while (Intrinsics.areEqual(pathFromRoot1.getContent()[depth], pathFromRoot2.getContent()[depth])) {
                if (depth != min) {
                    depth++;
                }
            }
            return Intrinsics.compare(pathFromRoot1.getContent()[depth].getPlaceOrder(), pathFromRoot2.getContent()[depth].getPlaceOrder());
        }
        throw new IllegalStateException("Could not find a common ancestor between the two FocusModifiers.".toString());
    }

    private final MutableVector<LayoutNode> pathFromRoot(LayoutNode layoutNode) {
        MutableVector path = new MutableVector(new LayoutNode[16], 0);
        for (LayoutNode current = layoutNode; current != null; current = current.getParent$ui_release()) {
            path.add(0, current);
        }
        return path;
    }
}
