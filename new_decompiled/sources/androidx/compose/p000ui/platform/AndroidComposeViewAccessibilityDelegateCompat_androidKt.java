package androidx.compose.p000ui.platform;

import android.graphics.Region;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.graphics.RectHelper_androidKt;
import androidx.compose.p000ui.layout.LayoutInfo;
import androidx.compose.p000ui.node.LayoutNode;
import androidx.compose.p000ui.node.SemanticsModifierNode;
import androidx.compose.p000ui.node.SemanticsModifierNodeKt;
import androidx.compose.p000ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.p000ui.semantics.AccessibilityAction;
import androidx.compose.p000ui.semantics.SemanticsActions;
import androidx.compose.p000ui.semantics.SemanticsConfiguration;
import androidx.compose.p000ui.semantics.SemanticsConfigurationKt;
import androidx.compose.p000ui.semantics.SemanticsNode;
import androidx.compose.p000ui.semantics.SemanticsNodeKt;
import androidx.compose.p000ui.semantics.SemanticsOwner;
import androidx.compose.p000ui.semantics.SemanticsProperties;
import androidx.compose.p000ui.semantics.SemanticsPropertyKey;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.health.connect.client.records.Vo2MaxRecord;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
@Metadata(m286d1 = {"\u0000N\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0006\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002\u001a\f\u0010\n\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u000b\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u001c\u0010\f\u001a\u0004\u0018\u00010\r*\b\u0012\u0004\u0012\u00020\r0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\"\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0014H\u0002\u001a\u0018\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u0018H\u0000\u001a\f\u0010\u0019\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0014\u0010\u001a\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003¨\u0006\u001d"}, m287d2 = {"isPassword", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "isRtl", "isTextField", "accessibilityEquals", "Landroidx/compose/ui/semantics/AccessibilityAction;", Vo2MaxRecord.MeasurementMethod.OTHER, "", "enabled", "excludeLineAndPageGranularities", "findById", "Landroidx/compose/ui/platform/ScrollObservationScope;", "", "id", "", "findClosestParentNode", "Landroidx/compose/ui/node/LayoutNode;", "selector", "Lkotlin/Function1;", "getAllUncoveredSemanticsNodesToMap", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "Landroidx/compose/ui/semantics/SemanticsOwner;", "hasPaneTitle", "propertiesDeleted", "oldNode", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutNode findClosestParentNode(LayoutNode $this$findClosestParentNode, Function1<? super LayoutNode, Boolean> function1) {
        for (LayoutNode currentParent = $this$findClosestParentNode.getParent$ui_release(); currentParent != null; currentParent = currentParent.getParent$ui_release()) {
            if (function1.invoke(currentParent).booleanValue()) {
                return currentParent;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enabled(SemanticsNode $this$enabled) {
        return SemanticsConfigurationKt.getOrNull($this$enabled.getConfig(), SemanticsProperties.INSTANCE.getDisabled()) == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean propertiesDeleted(SemanticsNode $this$propertiesDeleted, AndroidComposeViewAccessibilityDelegateCompat.SemanticsNodeCopy oldNode) {
        Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> it = oldNode.getUnmergedConfig().iterator();
        while (it.hasNext()) {
            Map.Entry entry = it.next();
            if (!$this$propertiesDeleted.getConfig().contains(entry.getKey())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasPaneTitle(SemanticsNode $this$hasPaneTitle) {
        return $this$hasPaneTitle.getConfig().contains(SemanticsProperties.INSTANCE.getPaneTitle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isPassword(SemanticsNode $this$isPassword) {
        return $this$isPassword.getConfig().contains(SemanticsProperties.INSTANCE.getPassword());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isTextField(SemanticsNode $this$isTextField) {
        return $this$isTextField.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isRtl(SemanticsNode $this$isRtl) {
        return $this$isRtl.getLayoutInfo().getLayoutDirection() == LayoutDirection.Rtl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean excludeLineAndPageGranularities(SemanticsNode $this$excludeLineAndPageGranularities) {
        SemanticsConfiguration collapsedSemanticsConfiguration;
        if (isTextField($this$excludeLineAndPageGranularities) && !Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull($this$excludeLineAndPageGranularities.getUnmergedConfig(), SemanticsProperties.INSTANCE.getFocused()), (Object) true)) {
            return true;
        }
        LayoutNode ancestor = findClosestParentNode($this$excludeLineAndPageGranularities.getLayoutNode(), new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(LayoutNode it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(it);
                SemanticsConfiguration ancestorSemanticsConfiguration = outerSemantics != null ? SemanticsModifierNodeKt.collapsedSemanticsConfiguration(outerSemantics) : null;
                return Boolean.valueOf((ancestorSemanticsConfiguration != null && ancestorSemanticsConfiguration.getIsMergingSemanticsOfDescendants()) && ancestorSemanticsConfiguration.contains(SemanticsActions.INSTANCE.getSetText()));
            }
        });
        if (ancestor != null) {
            SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(ancestor);
            if (!((outerSemantics == null || (collapsedSemanticsConfiguration = SemanticsModifierNodeKt.collapsedSemanticsConfiguration(outerSemantics)) == null) ? false : Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(collapsedSemanticsConfiguration, SemanticsProperties.INSTANCE.getFocused()), (Object) true))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean accessibilityEquals(AccessibilityAction<?> accessibilityAction, Object other) {
        if (accessibilityAction == other) {
            return true;
        }
        if (!(other instanceof AccessibilityAction) || !Intrinsics.areEqual(accessibilityAction.getLabel(), ((AccessibilityAction) other).getLabel())) {
            return false;
        }
        if (accessibilityAction.getAction() != null || ((AccessibilityAction) other).getAction() == null) {
            return accessibilityAction.getAction() == null || ((AccessibilityAction) other).getAction() != null;
        }
        return false;
    }

    public static final Map<Integer, SemanticsNodeWithAdjustedBounds> getAllUncoveredSemanticsNodesToMap(SemanticsOwner $this$getAllUncoveredSemanticsNodesToMap) {
        Intrinsics.checkNotNullParameter($this$getAllUncoveredSemanticsNodesToMap, "<this>");
        SemanticsNode root = $this$getAllUncoveredSemanticsNodesToMap.getUnmergedRootSemanticsNode();
        Map nodes = new LinkedHashMap();
        if (!root.getLayoutNode().getIsPlaced() || !root.getLayoutNode().isAttached()) {
            return nodes;
        }
        Region unaccountedSpace = new Region();
        unaccountedSpace.set(RectHelper_androidKt.toAndroidRect(root.getBoundsInRoot()));
        getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(unaccountedSpace, root, nodes, root);
        return nodes;
    }

    private static final void getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(Region unaccountedSpace, SemanticsNode root, Map<Integer, SemanticsNodeWithAdjustedBounds> map, SemanticsNode currentNode) {
        int virtualViewId;
        Rect boundsForFakeNode;
        LayoutInfo layoutInfo;
        boolean z = false;
        boolean notAttachedOrPlaced = (currentNode.getLayoutNode().getIsPlaced() && currentNode.getLayoutNode().isAttached()) ? false : true;
        if (!unaccountedSpace.isEmpty() || currentNode.getId() == root.getId()) {
            if (notAttachedOrPlaced && !currentNode.getIsFake()) {
                return;
            }
            android.graphics.Rect boundsInRoot = RectHelper_androidKt.toAndroidRect(currentNode.getTouchBoundsInRoot());
            Region region = new Region();
            region.set(boundsInRoot);
            if (currentNode.getId() == root.getId()) {
                virtualViewId = -1;
            } else {
                virtualViewId = currentNode.getId();
            }
            if (region.op(unaccountedSpace, region, Region.Op.INTERSECT)) {
                Integer valueOf = Integer.valueOf(virtualViewId);
                android.graphics.Rect bounds = region.getBounds();
                Intrinsics.checkNotNullExpressionValue(bounds, "region.bounds");
                map.put(valueOf, new SemanticsNodeWithAdjustedBounds(currentNode, bounds));
                List children = currentNode.getReplacedChildren$ui_release();
                for (int i = children.size() - 1; -1 < i; i--) {
                    getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(unaccountedSpace, root, map, children.get(i));
                }
                unaccountedSpace.op(boundsInRoot, unaccountedSpace, Region.Op.REVERSE_DIFFERENCE);
                return;
            }
            if (currentNode.getIsFake()) {
                SemanticsNode parentNode = currentNode.getParent();
                if (parentNode != null && (layoutInfo = parentNode.getLayoutInfo()) != null && layoutInfo.getIsPlaced()) {
                    z = true;
                }
                if (z) {
                    boundsForFakeNode = parentNode.getBoundsInRoot();
                } else {
                    boundsForFakeNode = new Rect(0.0f, 0.0f, 10.0f, 10.0f);
                }
                map.put(Integer.valueOf(virtualViewId), new SemanticsNodeWithAdjustedBounds(currentNode, RectHelper_androidKt.toAndroidRect(boundsForFakeNode)));
                return;
            }
            if (virtualViewId == -1) {
                Integer valueOf2 = Integer.valueOf(virtualViewId);
                android.graphics.Rect bounds2 = region.getBounds();
                Intrinsics.checkNotNullExpressionValue(bounds2, "region.bounds");
                map.put(valueOf2, new SemanticsNodeWithAdjustedBounds(currentNode, bounds2));
            }
        }
    }

    public static final ScrollObservationScope findById(List<ScrollObservationScope> list, int id) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int size = list.size();
        for (int index = 0; index < size; index++) {
            if (list.get(index).getSemanticsNodeId() == id) {
                return list.get(index);
            }
        }
        return null;
    }
}
