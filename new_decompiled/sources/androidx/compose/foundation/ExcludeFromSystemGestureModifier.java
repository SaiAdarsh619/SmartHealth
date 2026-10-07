package androidx.compose.foundation;

import android.view.View;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.graphics.RectHelper_androidKt;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.LayoutCoordinatesKt;
import androidx.compose.p000ui.layout.OnGloballyPositionedModifier;
import androidx.compose.runtime.collection.MutableVector;
import java.util.List;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: SystemGestureExclusion.kt */
@Metadata(m286d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0006\u0010\u0019\u001a\u00020\u0017J\u0010\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\fR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, m287d2 = {"Landroidx/compose/foundation/ExcludeFromSystemGestureModifier;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "view", "Landroid/view/View;", "exclusion", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "getExclusion", "()Lkotlin/jvm/functions/Function1;", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "setRect", "(Landroid/graphics/Rect;)V", "getView", "()Landroid/view/View;", "calcBounds", "layoutCoordinates", "findRoot", "onGloballyPositioned", "", "coordinates", "removeRect", "replaceRect", "newRect", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class ExcludeFromSystemGestureModifier implements OnGloballyPositionedModifier {
    private final Function1<LayoutCoordinates, Rect> exclusion;
    private android.graphics.Rect rect;
    private final View view;

    /* JADX WARN: Multi-variable type inference failed */
    public ExcludeFromSystemGestureModifier(View view, Function1<? super LayoutCoordinates, Rect> function1) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.exclusion = function1;
    }

    public final View getView() {
        return this.view;
    }

    public final Function1<LayoutCoordinates, Rect> getExclusion() {
        return this.exclusion;
    }

    public final android.graphics.Rect getRect() {
        return this.rect;
    }

    public final void setRect(android.graphics.Rect rect) {
        this.rect = rect;
    }

    @Override // androidx.compose.p000ui.layout.OnGloballyPositionedModifier
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        android.graphics.Rect newRect;
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        if (this.exclusion == null) {
            newRect = RectHelper_androidKt.toAndroidRect(LayoutCoordinatesKt.boundsInRoot(coordinates));
        } else {
            newRect = calcBounds(coordinates, this.exclusion.invoke(coordinates));
        }
        replaceRect(newRect);
    }

    public final void removeRect() {
        replaceRect(null);
    }

    public final void replaceRect(android.graphics.Rect newRect) {
        boolean z = false;
        MutableVector rects = new MutableVector(new android.graphics.Rect[16], 0);
        List elements$iv = this.view.getSystemGestureExclusionRects();
        Intrinsics.checkNotNullExpressionValue(elements$iv, "view.systemGestureExclusionRects");
        rects.addAll(rects.getSize(), elements$iv);
        android.graphics.Rect it = this.rect;
        if (it != null) {
            rects.remove(it);
        }
        if (newRect != null && !newRect.isEmpty()) {
            z = true;
        }
        if (z) {
            rects.add(newRect);
        }
        this.view.setSystemGestureExclusionRects(rects.asMutableList());
        this.rect = newRect;
    }

    private final android.graphics.Rect calcBounds(LayoutCoordinates layoutCoordinates, Rect rect) {
        LayoutCoordinates root = findRoot(layoutCoordinates);
        long topLeft = root.mo3498localPositionOfR5De75A(layoutCoordinates, rect.m1795getTopLeftF1C5BW0());
        long topRight = root.mo3498localPositionOfR5De75A(layoutCoordinates, rect.m1796getTopRightF1C5BW0());
        long bottomLeft = root.mo3498localPositionOfR5De75A(layoutCoordinates, rect.m1788getBottomLeftF1C5BW0());
        long bottomRight = root.mo3498localPositionOfR5De75A(layoutCoordinates, rect.m1789getBottomRightF1C5BW0());
        float left = ComparisonsKt.minOf(Offset.m1760getXimpl(topLeft), Offset.m1760getXimpl(topRight), Offset.m1760getXimpl(bottomLeft), Offset.m1760getXimpl(bottomRight));
        float top = ComparisonsKt.minOf(Offset.m1761getYimpl(topLeft), Offset.m1761getYimpl(topRight), Offset.m1761getYimpl(bottomLeft), Offset.m1761getYimpl(bottomRight));
        float right = ComparisonsKt.maxOf(Offset.m1760getXimpl(topLeft), Offset.m1760getXimpl(topRight), Offset.m1760getXimpl(bottomLeft), Offset.m1760getXimpl(bottomRight));
        float bottom = ComparisonsKt.maxOf(Offset.m1761getYimpl(topLeft), Offset.m1761getYimpl(topRight), Offset.m1761getYimpl(bottomLeft), Offset.m1761getYimpl(bottomRight));
        return new android.graphics.Rect(MathKt.roundToInt(left), MathKt.roundToInt(top), MathKt.roundToInt(right), MathKt.roundToInt(bottom));
    }

    private final LayoutCoordinates findRoot(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates coordinates = layoutCoordinates;
        LayoutCoordinates parent = layoutCoordinates.getParentLayoutCoordinates();
        while (parent != null) {
            coordinates = parent;
            parent = coordinates.getParentLayoutCoordinates();
        }
        return coordinates;
    }
}
