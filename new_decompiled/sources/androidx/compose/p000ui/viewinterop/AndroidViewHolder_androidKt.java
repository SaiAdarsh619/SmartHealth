package androidx.compose.p000ui.viewinterop;

import android.view.View;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p000ui.layout.LayoutCoordinatesKt;
import androidx.compose.p000ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* compiled from: AndroidViewHolder.android.kt */
@Metadata(m286d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0001H\u0002\u001a\f\u0010\r\u001a\u00020\f*\u00020\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, m287d2 = {"Unmeasured", "", "toNestedScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "type", "(I)I", "layoutAccordingTo", "", "Landroid/view/View;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "toComposeOffset", "", "toComposeVelocity", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AndroidViewHolder_androidKt {
    private static final int Unmeasured = Integer.MIN_VALUE;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void layoutAccordingTo(View $this$layoutAccordingTo, LayoutNode layoutNode) {
        long position = LayoutCoordinatesKt.positionInRoot(layoutNode.getCoordinates());
        int x = MathKt.roundToInt(Offset.m1760getXimpl(position));
        int y = MathKt.roundToInt(Offset.m1761getYimpl(position));
        $this$layoutAccordingTo.layout(x, y, $this$layoutAccordingTo.getMeasuredWidth() + x, $this$layoutAccordingTo.getMeasuredHeight() + y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float toComposeOffset(int $this$toComposeOffset) {
        return $this$toComposeOffset * (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float toComposeVelocity(float $this$toComposeVelocity) {
        return (-1.0f) * $this$toComposeVelocity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int toNestedScrollSource(int type) {
        return type == 0 ? NestedScrollSource.INSTANCE.m3263getDragWNlRxjI() : NestedScrollSource.INSTANCE.m3264getFlingWNlRxjI();
    }
}
