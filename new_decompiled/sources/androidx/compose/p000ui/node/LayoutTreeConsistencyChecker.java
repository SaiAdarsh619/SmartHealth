package androidx.compose.p000ui.node;

import androidx.compose.p000ui.layout.LookaheadScope;
import androidx.compose.p000ui.node.LayoutNode;
import androidx.compose.p000ui.node.MeasureAndLayoutDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutTreeConsistencyChecker.kt */
@Metadata(m286d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\f\u0010\u0012\u001a\u00020\r*\u00020\u0003H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m287d2 = {"Landroidx/compose/ui/node/LayoutTreeConsistencyChecker;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "relayoutNodes", "Landroidx/compose/ui/node/DepthSortedSet;", "postponedMeasureRequests", "", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/DepthSortedSet;Ljava/util/List;)V", "assertConsistent", "", "isTreeConsistent", "", "node", "logTree", "", "nodeToString", "consistentLayoutState", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LayoutTreeConsistencyChecker {
    private final List<MeasureAndLayoutDelegate.PostponedRequest> postponedMeasureRequests;
    private final DepthSortedSet relayoutNodes;
    private final LayoutNode root;

    public LayoutTreeConsistencyChecker(LayoutNode root, DepthSortedSet relayoutNodes, List<MeasureAndLayoutDelegate.PostponedRequest> postponedMeasureRequests) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(relayoutNodes, "relayoutNodes");
        Intrinsics.checkNotNullParameter(postponedMeasureRequests, "postponedMeasureRequests");
        this.root = root;
        this.relayoutNodes = relayoutNodes;
        this.postponedMeasureRequests = postponedMeasureRequests;
    }

    public final void assertConsistent() {
        boolean inconsistencyFound = !isTreeConsistent(this.root);
        if (inconsistencyFound) {
            System.out.println((Object) logTree());
            throw new IllegalStateException("Inconsistency found!");
        }
    }

    private final boolean isTreeConsistent(LayoutNode node) {
        if (!consistentLayoutState(node)) {
            return false;
        }
        List $this$fastForEach$iv = node.getChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            LayoutNode it = (LayoutNode) item$iv;
            if (!isTreeConsistent(it)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        if ((r2 != null && r2.getIsPlaced()) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0141, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r3.getRoot(), r19) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0181, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r3.getRoot(), r19) != false) goto L126;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean consistentLayoutState(LayoutNode $this$consistentLayoutState) {
        Object it$iv;
        Object obj;
        LayoutNode parent = $this$consistentLayoutState.getParent$ui_release();
        LayoutNode.LayoutState parentLayoutState = parent != null ? parent.getLayoutState$ui_release() : null;
        if (!$this$consistentLayoutState.getIsPlaced()) {
            if ($this$consistentLayoutState.getPlaceOrder() != Integer.MAX_VALUE) {
            }
            if (Intrinsics.areEqual((Object) $this$consistentLayoutState.isPlacedInLookahead(), (Object) true)) {
                if ($this$consistentLayoutState.getLookaheadMeasurePending$ui_release()) {
                    List $this$fastFirstOrNull$iv = this.postponedMeasureRequests;
                    int index$iv$iv = 0;
                    int size = $this$fastFirstOrNull$iv.size();
                    while (true) {
                        if (index$iv$iv < size) {
                            Object item$iv$iv = $this$fastFirstOrNull$iv.get(index$iv$iv);
                            MeasureAndLayoutDelegate.PostponedRequest it = (MeasureAndLayoutDelegate.PostponedRequest) item$iv$iv;
                            if (!(Intrinsics.areEqual(it.getNode(), $this$consistentLayoutState) && it.getIsLookahead())) {
                                index$iv$iv++;
                            } else {
                                obj = item$iv$iv;
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    if (obj != null) {
                        return true;
                    }
                }
                if ($this$consistentLayoutState.getLookaheadMeasurePending$ui_release()) {
                    if (!this.relayoutNodes.contains($this$consistentLayoutState)) {
                        if (!(parent != null && parent.getLookaheadMeasurePending$ui_release()) && parentLayoutState != LayoutNode.LayoutState.LookaheadMeasuring) {
                            if (parent != null && parent.getMeasurePending$ui_release()) {
                                LookaheadScope mLookaheadScope = $this$consistentLayoutState.getMLookaheadScope();
                                Intrinsics.checkNotNull(mLookaheadScope);
                            }
                            return false;
                        }
                    }
                    return true;
                }
                if ($this$consistentLayoutState.getLookaheadLayoutPending$ui_release()) {
                    if (!this.relayoutNodes.contains($this$consistentLayoutState) && parent != null && !parent.getLookaheadMeasurePending$ui_release() && !parent.getLookaheadLayoutPending$ui_release() && parentLayoutState != LayoutNode.LayoutState.LookaheadMeasuring && parentLayoutState != LayoutNode.LayoutState.LookaheadLayingOut) {
                        if (parent.getLayoutPending$ui_release()) {
                            LookaheadScope mLookaheadScope2 = $this$consistentLayoutState.getMLookaheadScope();
                            Intrinsics.checkNotNull(mLookaheadScope2);
                        }
                        return false;
                    }
                    return true;
                }
            }
            return true;
        }
        if ($this$consistentLayoutState.getMeasurePending$ui_release()) {
            List $this$fastFirstOrNull$iv2 = this.postponedMeasureRequests;
            int index$iv$iv2 = 0;
            int size2 = $this$fastFirstOrNull$iv2.size();
            while (true) {
                if (index$iv$iv2 < size2) {
                    it$iv = $this$fastFirstOrNull$iv2.get(index$iv$iv2);
                    MeasureAndLayoutDelegate.PostponedRequest it2 = (MeasureAndLayoutDelegate.PostponedRequest) it$iv;
                    if (Intrinsics.areEqual(it2.getNode(), $this$consistentLayoutState) && !it2.getIsLookahead()) {
                        break;
                    }
                    index$iv$iv2++;
                } else {
                    it$iv = null;
                    break;
                }
            }
            if (it$iv != null) {
                return true;
            }
        }
        if ($this$consistentLayoutState.getMeasurePending$ui_release()) {
            if (!this.relayoutNodes.contains($this$consistentLayoutState)) {
                if (!(parent != null && parent.getMeasurePending$ui_release()) && parentLayoutState != LayoutNode.LayoutState.Measuring) {
                    return false;
                }
            }
            return true;
        }
        if ($this$consistentLayoutState.getLayoutPending$ui_release()) {
            return this.relayoutNodes.contains($this$consistentLayoutState) || parent == null || parent.getMeasurePending$ui_release() || parent.getLayoutPending$ui_release() || parentLayoutState == LayoutNode.LayoutState.Measuring || parentLayoutState == LayoutNode.LayoutState.LayingOut;
        }
        if (Intrinsics.areEqual((Object) $this$consistentLayoutState.isPlacedInLookahead(), (Object) true)) {
        }
        return true;
    }

    private final String nodeToString(LayoutNode node) {
        StringBuilder $this$nodeToString_u24lambda_u2d3 = new StringBuilder();
        $this$nodeToString_u24lambda_u2d3.append(node);
        $this$nodeToString_u24lambda_u2d3.append(new StringBuilder().append('[').append(node.getLayoutState$ui_release()).append(']').toString());
        if (!node.getIsPlaced()) {
            $this$nodeToString_u24lambda_u2d3.append("[!isPlaced]");
        }
        $this$nodeToString_u24lambda_u2d3.append("[measuredByParent=" + node.getMeasuredByParent() + ']');
        if (!consistentLayoutState(node)) {
            $this$nodeToString_u24lambda_u2d3.append("[INCONSISTENT]");
        }
        String sb = $this$nodeToString_u24lambda_u2d3.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "with(StringBuilder()) {\n…     toString()\n        }");
        return sb;
    }

    private final String logTree() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append("Tree state:");
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append('\\n')");
        logTree$printSubTree(this, stringBuilder, this.root, 0);
        String sb = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "stringBuilder.toString()");
        return sb;
    }

    private static final void logTree$printSubTree(LayoutTreeConsistencyChecker this$0, StringBuilder stringBuilder, LayoutNode node, int depth) {
        int childrenDepth = depth;
        String nodeRepresentation = this$0.nodeToString(node);
        if (nodeRepresentation.length() > 0) {
            for (int i = 0; i < depth; i++) {
                stringBuilder.append("..");
            }
            StringBuilder append = stringBuilder.append(nodeRepresentation);
            Intrinsics.checkNotNullExpressionValue(append, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append('\\n')");
            childrenDepth++;
        }
        List $this$fastForEach$iv = node.getChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            LayoutNode it = (LayoutNode) item$iv;
            logTree$printSubTree(this$0, stringBuilder, it, childrenDepth);
        }
    }
}
