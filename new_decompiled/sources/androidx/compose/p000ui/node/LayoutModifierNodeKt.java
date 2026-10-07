package androidx.compose.p000ui.node;

import androidx.compose.p000ui.ExperimentalComposeUiApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutModifierNode.kt */
@Metadata(m286d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0001\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0001\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0001¨\u0006\u0005"}, m287d2 = {"invalidateLayer", "", "Landroidx/compose/ui/node/LayoutModifierNode;", "requestRelayout", "requestRemeasure", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LayoutModifierNodeKt {
    @ExperimentalComposeUiApi
    public static final void invalidateLayer(LayoutModifierNode $this$invalidateLayer) {
        Intrinsics.checkNotNullParameter($this$invalidateLayer, "<this>");
        DelegatableNodeKt.m3597requireCoordinator64DMado($this$invalidateLayer, Nodes.INSTANCE.m3708getLayoutOLwlOKw()).invalidateLayer();
    }

    @ExperimentalComposeUiApi
    public static final void requestRelayout(LayoutModifierNode $this$requestRelayout) {
        Intrinsics.checkNotNullParameter($this$requestRelayout, "<this>");
        LayoutNode.requestRelayout$ui_release$default(DelegatableNodeKt.requireLayoutNode($this$requestRelayout), false, 1, null);
    }

    @ExperimentalComposeUiApi
    public static final void requestRemeasure(LayoutModifierNode $this$requestRemeasure) {
        Intrinsics.checkNotNullParameter($this$requestRemeasure, "<this>");
        LayoutNode.requestRemeasure$ui_release$default(DelegatableNodeKt.requireLayoutNode($this$requestRemeasure), false, 1, null);
    }
}
