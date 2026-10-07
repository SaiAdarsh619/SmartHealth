package androidx.compose.p000ui.node;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.DrawModifier;
import androidx.compose.p000ui.focus.FocusOrderModifier;
import androidx.compose.p000ui.input.pointer.PointerInputModifier;
import androidx.compose.p000ui.layout.IntermediateLayoutModifier;
import androidx.compose.p000ui.layout.LayoutModifier;
import androidx.compose.p000ui.layout.LookaheadOnPlacedModifier;
import androidx.compose.p000ui.layout.OnGloballyPositionedModifier;
import androidx.compose.p000ui.layout.OnPlacedModifier;
import androidx.compose.p000ui.layout.OnRemeasuredModifier;
import androidx.compose.p000ui.layout.ParentDataModifier;
import androidx.compose.p000ui.modifier.ModifierLocalConsumer;
import androidx.compose.p000ui.modifier.ModifierLocalNode;
import androidx.compose.p000ui.modifier.ModifierLocalProvider;
import androidx.compose.p000ui.semantics.SemanticsModifier;
import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NodeKind.kt */
@Metadata(m286d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a&\u0010\r\u001a\u00020\b*\u00020\b2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0080\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\"%\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028@X\u0080\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, m287d2 = {"includeSelfInTraversal", "", "Landroidx/compose/ui/node/NodeKind;", "getIncludeSelfInTraversal-H91voCI$annotations", "(I)V", "getIncludeSelfInTraversal-H91voCI", "(I)Z", "calculateNodeKindSetFrom", "", "element", "Landroidx/compose/ui/Modifier$Element;", "node", "Landroidx/compose/ui/Modifier$Node;", "or", Vo2MaxRecord.MeasurementMethod.OTHER, "or-64DMado", "(II)I", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class NodeKindKt {
    /* renamed from: getIncludeSelfInTraversal-H91voCI$annotations, reason: not valid java name */
    public static /* synthetic */ void m3702getIncludeSelfInTraversalH91voCI$annotations(int i) {
    }

    /* renamed from: or-64DMado, reason: not valid java name */
    public static final int m3703or64DMado(int $this$or_u2d64DMado, int other) {
        return $this$or_u2d64DMado | other;
    }

    /* renamed from: getIncludeSelfInTraversal-H91voCI, reason: not valid java name */
    public static final boolean m3701getIncludeSelfInTraversalH91voCI(int $this$includeSelfInTraversal) {
        return (Nodes.INSTANCE.m3709getLayoutAwareOLwlOKw() & $this$includeSelfInTraversal) != 0;
    }

    public static final int calculateNodeKindSetFrom(Modifier.Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        int mask = Nodes.INSTANCE.m3704getAnyOLwlOKw();
        if (element instanceof LayoutModifier) {
            mask = m3703or64DMado(mask, Nodes.INSTANCE.m3708getLayoutOLwlOKw());
        }
        if (element instanceof IntermediateLayoutModifier) {
            mask = m3703or64DMado(mask, Nodes.INSTANCE.m3707getIntermediateMeasureOLwlOKw());
        }
        if (element instanceof DrawModifier) {
            mask = m3703or64DMado(mask, Nodes.INSTANCE.m3705getDrawOLwlOKw());
        }
        if (element instanceof SemanticsModifier) {
            mask = m3703or64DMado(mask, Nodes.INSTANCE.m3713getSemanticsOLwlOKw());
        }
        if (element instanceof PointerInputModifier) {
            mask = m3703or64DMado(mask, Nodes.INSTANCE.m3712getPointerInputOLwlOKw());
        }
        if ((element instanceof ModifierLocalConsumer) || (element instanceof ModifierLocalProvider) || (element instanceof FocusOrderModifier)) {
            mask = m3703or64DMado(mask, Nodes.INSTANCE.m3710getLocalsOLwlOKw());
        }
        if (element instanceof OnGloballyPositionedModifier) {
            mask = m3703or64DMado(mask, Nodes.INSTANCE.m3706getGlobalPositionAwareOLwlOKw());
        }
        if (element instanceof ParentDataModifier) {
            mask = m3703or64DMado(mask, Nodes.INSTANCE.m3711getParentDataOLwlOKw());
        }
        if ((element instanceof OnPlacedModifier) || (element instanceof OnRemeasuredModifier) || (element instanceof LookaheadOnPlacedModifier)) {
            return m3703or64DMado(mask, Nodes.INSTANCE.m3709getLayoutAwareOLwlOKw());
        }
        return mask;
    }

    public static final int calculateNodeKindSetFrom(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        int mask = Nodes.INSTANCE.m3704getAnyOLwlOKw();
        if (node instanceof LayoutModifierNode) {
            mask = m3703or64DMado(mask, Nodes.INSTANCE.m3708getLayoutOLwlOKw());
        }
        if (node instanceof DrawModifierNode) {
            mask = m3703or64DMado(mask, Nodes.INSTANCE.m3705getDrawOLwlOKw());
        }
        if (node instanceof SemanticsModifierNode) {
            mask = m3703or64DMado(mask, Nodes.INSTANCE.m3713getSemanticsOLwlOKw());
        }
        if (node instanceof PointerInputModifierNode) {
            mask = m3703or64DMado(mask, Nodes.INSTANCE.m3712getPointerInputOLwlOKw());
        }
        if (node instanceof ModifierLocalNode) {
            mask = m3703or64DMado(mask, Nodes.INSTANCE.m3710getLocalsOLwlOKw());
        }
        if (node instanceof ParentDataModifierNode) {
            mask = m3703or64DMado(mask, Nodes.INSTANCE.m3711getParentDataOLwlOKw());
        }
        if (node instanceof LayoutAwareModifierNode) {
            mask = m3703or64DMado(mask, Nodes.INSTANCE.m3709getLayoutAwareOLwlOKw());
        }
        if (node instanceof GlobalPositionAwareModifierNode) {
            mask = m3703or64DMado(mask, Nodes.INSTANCE.m3706getGlobalPositionAwareOLwlOKw());
        }
        if (node instanceof IntermediateLayoutModifierNode) {
            return m3703or64DMado(mask, Nodes.INSTANCE.m3707getIntermediateMeasureOLwlOKw());
        }
        return mask;
    }
}
