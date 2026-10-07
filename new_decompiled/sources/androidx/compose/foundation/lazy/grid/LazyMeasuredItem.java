package androidx.compose.foundation.lazy.grid;

import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.unit.IntOffsetKt;
import androidx.compose.p000ui.unit.IntSizeKt;
import androidx.compose.p000ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* compiled from: LazyMeasuredItem.kt */
@Metadata(m286d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001Bn\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0002\u0010\u0016J>\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\bR\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0019\u0010\u0018R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u001f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\u00020\u0015X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010$\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, m287d2 = {"Landroidx/compose/foundation/lazy/grid/LazyMeasuredItem;", "", "index", "Landroidx/compose/foundation/lazy/grid/ItemIndex;", "key", "isVertical", "", "crossAxisSize", "", "mainAxisSpacing", "reverseLayout", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "beforeContentPadding", "afterContentPadding", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "(ILjava/lang/Object;ZIIZLandroidx/compose/ui/unit/LayoutDirection;IILjava/util/List;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCrossAxisSize", "()I", "getIndex-VZbfaAc", "I", "getKey", "()Ljava/lang/Object;", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "getMainAxisSpacing", "getPlaceables", "()Ljava/util/List;", "J", "position", "Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "rawMainAxisOffset", "rawCrossAxisOffset", "layoutWidth", "layoutHeight", "row", "column", "lineMainAxisSize", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyMeasuredItem {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private final int mainAxisSpacing;
    private final List<Placeable> placeables;
    private final LazyGridItemPlacementAnimator placementAnimator;
    private final boolean reverseLayout;
    private final long visualOffset;

    public /* synthetic */ LazyMeasuredItem(int i, Object obj, boolean z, int i2, int i3, boolean z2, LayoutDirection layoutDirection, int i4, int i5, List list, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, obj, z, i2, i3, z2, layoutDirection, i4, i5, list, lazyGridItemPlacementAnimator, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LazyMeasuredItem(int index, Object key, boolean isVertical, int crossAxisSize, int mainAxisSpacing, boolean reverseLayout, LayoutDirection layoutDirection, int beforeContentPadding, int afterContentPadding, List<? extends Placeable> list, LazyGridItemPlacementAnimator placementAnimator, long visualOffset) {
        this.index = index;
        this.key = key;
        this.isVertical = isVertical;
        this.crossAxisSize = crossAxisSize;
        this.mainAxisSpacing = mainAxisSpacing;
        this.reverseLayout = reverseLayout;
        this.layoutDirection = layoutDirection;
        this.beforeContentPadding = beforeContentPadding;
        this.afterContentPadding = afterContentPadding;
        this.placeables = list;
        this.placementAnimator = placementAnimator;
        this.visualOffset = visualOffset;
        int maxMainAxis = 0;
        List $this$fastForEach$iv = this.placeables;
        int size = $this$fastForEach$iv.size();
        int index$iv = 0;
        while (index$iv < size) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            Placeable it = (Placeable) item$iv;
            int i = size;
            maxMainAxis = Math.max(maxMainAxis, this.isVertical ? it.getHeight() : it.getWidth());
            index$iv++;
            size = i;
        }
        this.mainAxisSize = maxMainAxis;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(this.mainAxisSpacing + maxMainAxis, 0);
    }

    /* renamed from: getIndex-VZbfaAc, reason: not valid java name and from getter */
    public final int getIndex() {
        return this.index;
    }

    public final Object getKey() {
        return this.key;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final int getMainAxisSpacing() {
        return this.mainAxisSpacing;
    }

    public final List<Placeable> getPlaceables() {
        return this.placeables;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final LazyGridPositionedItem position(int rawMainAxisOffset, int rawCrossAxisOffset, int layoutWidth, int layoutHeight, int row, int column, int lineMainAxisSize) {
        int i;
        int i2;
        long placeableOffset;
        long IntOffset;
        int i3;
        List wrappers = new ArrayList();
        int mainAxisLayoutSize = this.isVertical ? layoutHeight : layoutWidth;
        if (this.reverseLayout) {
            i = (mainAxisLayoutSize - rawMainAxisOffset) - this.mainAxisSize;
        } else {
            i = rawMainAxisOffset;
        }
        int mainAxisOffset = i;
        int crossAxisLayoutSize = this.isVertical ? layoutWidth : layoutHeight;
        if (this.isVertical && this.layoutDirection == LayoutDirection.Rtl) {
            i2 = (crossAxisLayoutSize - rawCrossAxisOffset) - this.crossAxisSize;
        } else {
            i2 = rawCrossAxisOffset;
        }
        int crossAxisOffset = i2;
        if (this.isVertical) {
            placeableOffset = IntOffsetKt.IntOffset(crossAxisOffset, mainAxisOffset);
        } else {
            placeableOffset = IntOffsetKt.IntOffset(mainAxisOffset, crossAxisOffset);
        }
        int placeableIndex = this.reverseLayout ? CollectionsKt.getLastIndex(this.placeables) : 0;
        while (true) {
            boolean z = true;
            if (!this.reverseLayout ? placeableIndex >= this.placeables.size() : placeableIndex < 0) {
                z = false;
            }
            if (!z) {
                break;
            }
            Placeable it = this.placeables.get(placeableIndex);
            int addIndex = this.reverseLayout ? 0 : wrappers.size();
            wrappers.add(addIndex, new LazyGridPlaceableWrapper(placeableOffset, it, this.placeables.get(placeableIndex).getParentData(), null));
            placeableIndex = this.reverseLayout ? placeableIndex - 1 : placeableIndex + 1;
        }
        if (this.isVertical) {
            IntOffset = IntOffsetKt.IntOffset(rawCrossAxisOffset, rawMainAxisOffset);
        } else {
            IntOffset = IntOffsetKt.IntOffset(rawMainAxisOffset, rawCrossAxisOffset);
        }
        int i4 = this.index;
        Object obj = this.key;
        long IntSize = this.isVertical ? IntSizeKt.IntSize(this.crossAxisSize, this.mainAxisSize) : IntSizeKt.IntSize(this.mainAxisSize, this.crossAxisSize);
        int i5 = this.mainAxisSpacing;
        if (!this.reverseLayout) {
            i3 = this.beforeContentPadding;
        } else {
            i3 = this.afterContentPadding;
        }
        return new LazyGridPositionedItem(IntOffset, placeableOffset, i4, obj, row, column, IntSize, lineMainAxisSize, i5, -i3, mainAxisLayoutSize + (!this.reverseLayout ? this.afterContentPadding : this.beforeContentPadding), this.isVertical, wrappers, this.placementAnimator, this.visualOffset, null);
    }
}
