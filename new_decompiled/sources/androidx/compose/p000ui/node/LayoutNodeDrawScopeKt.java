package androidx.compose.p000ui.node;

import androidx.compose.p000ui.Modifier;
import kotlin.Metadata;

/* compiled from: LayoutNodeDrawScope.kt */
@Metadata(m286d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, m287d2 = {"nextDrawNode", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LayoutNodeDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawModifierNode nextDrawNode(DelegatableNode $this$nextDrawNode) {
        int drawMask = Nodes.INSTANCE.m3705getDrawOLwlOKw();
        int measureMask = Nodes.INSTANCE.m3708getLayoutOLwlOKw();
        Modifier.Node child = $this$nextDrawNode.getNode().getChild();
        if (child == null || (child.getAggregateChildKindSet() & drawMask) == 0) {
            return null;
        }
        for (Modifier.Node next = child; next != null && (next.getKindSet() & measureMask) == 0; next = next.getChild()) {
            if ((next.getKindSet() & drawMask) != 0) {
                return (DrawModifierNode) next;
            }
        }
        return null;
    }
}
