package androidx.compose.p000ui.node;

import androidx.compose.p000ui.ExperimentalComposeUiApi;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.layout.LayoutCoordinatesKt;
import androidx.compose.p000ui.semantics.SemanticsActions;
import androidx.compose.p000ui.semantics.SemanticsConfiguration;
import androidx.compose.p000ui.semantics.SemanticsConfigurationKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsModifierNode.kt */
@Metadata(m286d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0007\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0002H\u0007\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0002H\u0000\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, m287d2 = {"useMinimumTouchTarget", "", "Landroidx/compose/ui/node/SemanticsModifierNode;", "getUseMinimumTouchTarget$annotations", "(Landroidx/compose/ui/node/SemanticsModifierNode;)V", "getUseMinimumTouchTarget", "(Landroidx/compose/ui/node/SemanticsModifierNode;)Z", "collapsedSemanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "invalidateSemantics", "", "touchBoundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SemanticsModifierNodeKt {
    public static /* synthetic */ void getUseMinimumTouchTarget$annotations(SemanticsModifierNode semanticsModifierNode) {
    }

    @ExperimentalComposeUiApi
    public static final void invalidateSemantics(SemanticsModifierNode $this$invalidateSemantics) {
        Intrinsics.checkNotNullParameter($this$invalidateSemantics, "<this>");
        DelegatableNodeKt.requireOwner($this$invalidateSemantics).onSemanticsChange();
    }

    @ExperimentalComposeUiApi
    public static final SemanticsConfiguration collapsedSemanticsConfiguration(SemanticsModifierNode $this$collapsedSemanticsConfiguration) {
        Intrinsics.checkNotNullParameter($this$collapsedSemanticsConfiguration, "<this>");
        SemanticsModifierNode $this$localChild_u2d64DMado$iv = $this$collapsedSemanticsConfiguration;
        int type$iv = Nodes.INSTANCE.m3713getSemanticsOLwlOKw();
        Object localChild = DelegatableNodeKt.localChild($this$localChild_u2d64DMado$iv, type$iv);
        if (!(localChild instanceof SemanticsModifierNode)) {
            localChild = null;
        }
        SemanticsModifierNode next = (SemanticsModifierNode) localChild;
        if (next == null || $this$collapsedSemanticsConfiguration.getSemanticsConfiguration().getIsClearingSemantics()) {
            return $this$collapsedSemanticsConfiguration.getSemanticsConfiguration();
        }
        SemanticsConfiguration config = $this$collapsedSemanticsConfiguration.getSemanticsConfiguration().copy();
        config.collapsePeer$ui_release(collapsedSemanticsConfiguration(next));
        return config;
    }

    public static final boolean getUseMinimumTouchTarget(SemanticsModifierNode $this$useMinimumTouchTarget) {
        Intrinsics.checkNotNullParameter($this$useMinimumTouchTarget, "<this>");
        return SemanticsConfigurationKt.getOrNull($this$useMinimumTouchTarget.getSemanticsConfiguration(), SemanticsActions.INSTANCE.getOnClick()) != null;
    }

    public static final Rect touchBoundsInRoot(SemanticsModifierNode $this$touchBoundsInRoot) {
        Intrinsics.checkNotNullParameter($this$touchBoundsInRoot, "<this>");
        if (!$this$touchBoundsInRoot.getNode().getIsAttached()) {
            return Rect.INSTANCE.getZero();
        }
        if (!getUseMinimumTouchTarget($this$touchBoundsInRoot)) {
            return LayoutCoordinatesKt.boundsInRoot(DelegatableNodeKt.m3597requireCoordinator64DMado($this$touchBoundsInRoot, Nodes.INSTANCE.m3713getSemanticsOLwlOKw()));
        }
        return DelegatableNodeKt.m3597requireCoordinator64DMado($this$touchBoundsInRoot, Nodes.INSTANCE.m3713getSemanticsOLwlOKw()).touchBoundsInRoot();
    }
}
