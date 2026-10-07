package androidx.compose.p000ui.node;

import androidx.compose.p000ui.ExperimentalComposeUiApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawModifierNode.kt */
@Metadata(m286d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0001¨\u0006\u0003"}, m287d2 = {"requestDraw", "", "Landroidx/compose/ui/node/DrawModifierNode;", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class DrawModifierNodeKt {
    @ExperimentalComposeUiApi
    public static final void requestDraw(DrawModifierNode $this$requestDraw) {
        Intrinsics.checkNotNullParameter($this$requestDraw, "<this>");
        DelegatableNodeKt.requireLayoutNode($this$requestDraw).invalidateLayer$ui_release();
    }
}
