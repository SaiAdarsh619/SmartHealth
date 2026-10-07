package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.IntOffsetKt;
import androidx.compose.p000ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyMeasuredItem.kt */
@Metadata(m286d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0086\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0019\u00106\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001072\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000J\u0006\u00108\u001a\u00020\u0006J\u0006\u00109\u001a\u00020\u0006J\u000e\u00104\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=R\u0014\u0010\n\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010#\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b$\u0010\u001bR\u0011\u0010%\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b&\u0010\u001bR\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0002\u001a\u00020\u0003X\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010)\u001a\u0004\b*\u0010(R\u0011\u0010+\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b,\u0010\u001bR\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\u001f\u0010\u000b\u001a\u00020\fX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010)\u001a\u0004\b.\u0010(R\u0019\u0010\u0018\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010)R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u00020\u0006*\u00020\u00038BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b0\u00101R\u0018\u00102\u001a\u00020\u0006*\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006>"}, m287d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "placeableOffset", "index", "", "key", "", "row", "column", "size", "Landroidx/compose/ui/unit/IntSize;", "lineMainAxisSize", "mainAxisSpacing", "minMainAxisOffset", "maxMainAxisOffset", "isVertical", "", "wrappers", "", "Landroidx/compose/foundation/lazy/grid/LazyGridPlaceableWrapper;", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "visualOffset", "(JJILjava/lang/Object;IIJIIIIZLjava/util/List;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColumn", "()I", "hasAnimations", "getHasAnimations", "()Z", "getIndex", "getKey", "()Ljava/lang/Object;", "getLineMainAxisSize", "lineMainAxisSizeWithSpacings", "getLineMainAxisSizeWithSpacings", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "getOffset-nOcc-ac", "()J", "J", "getPlaceableOffset-nOcc-ac", "placeablesCount", "getPlaceablesCount", "getRow", "getSize-YbymL2g", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "mainAxisSize", "Landroidx/compose/ui/layout/Placeable;", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "getAnimationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "getCrossAxisOffset", "getCrossAxisSize", "place", "", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyGridPositionedItem implements LazyGridItemInfo {
    private final int column;
    private final boolean hasAnimations;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int lineMainAxisSize;
    private final int mainAxisSpacing;
    private final int maxMainAxisOffset;
    private final int minMainAxisOffset;
    private final long offset;
    private final long placeableOffset;
    private final LazyGridItemPlacementAnimator placementAnimator;
    private final int row;
    private final long size;
    private final long visualOffset;
    private final List<LazyGridPlaceableWrapper> wrappers;

    public /* synthetic */ LazyGridPositionedItem(long j, long j2, int i, Object obj, int i2, int i3, long j3, int i4, int i5, int i6, int i7, boolean z, List list, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, i, obj, i2, i3, j3, i4, i5, i6, i7, z, list, lazyGridItemPlacementAnimator, j4);
    }

    private LazyGridPositionedItem(long offset, long placeableOffset, int index, Object key, int row, int column, long size, int lineMainAxisSize, int mainAxisSpacing, int minMainAxisOffset, int maxMainAxisOffset, boolean isVertical, List<LazyGridPlaceableWrapper> list, LazyGridItemPlacementAnimator placementAnimator, long visualOffset) {
        boolean z;
        this.offset = offset;
        this.placeableOffset = placeableOffset;
        this.index = index;
        this.key = key;
        this.row = row;
        this.column = column;
        this.size = size;
        this.lineMainAxisSize = lineMainAxisSize;
        this.mainAxisSpacing = mainAxisSpacing;
        this.minMainAxisOffset = minMainAxisOffset;
        this.maxMainAxisOffset = maxMainAxisOffset;
        this.isVertical = isVertical;
        this.wrappers = list;
        this.placementAnimator = placementAnimator;
        this.visualOffset = visualOffset;
        LazyGridPositionedItem $this$hasAnimations_u24lambda_u2d1 = this;
        int placeablesCount = $this$hasAnimations_u24lambda_u2d1.getPlaceablesCount();
        int i = 0;
        while (true) {
            if (i < placeablesCount) {
                int index2 = i;
                if ($this$hasAnimations_u24lambda_u2d1.getAnimationSpec(index2) == null) {
                    i++;
                } else {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        this.hasAnimations = z;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    /* renamed from: getOffset-nOcc-ac, reason: from getter */
    public long getOffset() {
        return this.offset;
    }

    /* renamed from: getPlaceableOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getPlaceableOffset() {
        return this.placeableOffset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getRow() {
        return this.row;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getColumn() {
        return this.column;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    /* renamed from: getSize-YbymL2g, reason: from getter */
    public long getSize() {
        return this.size;
    }

    public final int getLineMainAxisSize() {
        return this.lineMainAxisSize;
    }

    public final int getPlaceablesCount() {
        return this.wrappers.size();
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSpacing + (this.isVertical ? IntSize.m4541getHeightimpl(getSize()) : IntSize.m4542getWidthimpl(getSize()));
    }

    public final int getLineMainAxisSizeWithSpacings() {
        return this.mainAxisSpacing + this.lineMainAxisSize;
    }

    public final int getMainAxisSize(int index) {
        return getMainAxisSize(this.wrappers.get(index).getPlaceable());
    }

    public final int getCrossAxisSize() {
        return this.isVertical ? IntSize.m4542getWidthimpl(getSize()) : IntSize.m4541getHeightimpl(getSize());
    }

    public final int getCrossAxisOffset() {
        return this.isVertical ? IntOffset.m4500getXimpl(getOffset()) : IntOffset.m4501getYimpl(getOffset());
    }

    public final FiniteAnimationSpec<IntOffset> getAnimationSpec(int index) {
        Object parentData = this.wrappers.get(index).getParentData();
        if (parentData instanceof FiniteAnimationSpec) {
            return (FiniteAnimationSpec) parentData;
        }
        return null;
    }

    public final boolean getHasAnimations() {
        return this.hasAnimations;
    }

    public final void place(Placeable.PlacementScope scope) {
        int i;
        int minOffset;
        int maxOffset;
        long j;
        Intrinsics.checkNotNullParameter(scope, "scope");
        int i2 = 0;
        int placeablesCount = getPlaceablesCount();
        int i3 = 0;
        while (i3 < placeablesCount) {
            int index = i3;
            Placeable placeable = this.wrappers.get(index).getPlaceable();
            int minOffset2 = this.minMainAxisOffset - getMainAxisSize(placeable);
            int maxOffset2 = this.maxMainAxisOffset;
            if (getAnimationSpec(index) != null) {
                i = i2;
                minOffset = minOffset2;
                maxOffset = maxOffset2;
                j = this.placementAnimator.m922getAnimatedOffsetYT5a7pE(getKey(), index, minOffset2, maxOffset2, this.placeableOffset);
            } else {
                i = i2;
                minOffset = minOffset2;
                maxOffset = maxOffset2;
                j = this.placeableOffset;
            }
            long offset = j;
            if (m930getMainAxisgyyYBs(offset) > minOffset && m930getMainAxisgyyYBs(offset) < maxOffset) {
                if (!this.isVertical) {
                    long other$iv = this.visualOffset;
                    Placeable.PlacementScope.m3542placeRelativeWithLayeraW9wM$default(scope, placeable, IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(offset) + IntOffset.m4500getXimpl(other$iv), IntOffset.m4501getYimpl(offset) + IntOffset.m4501getYimpl(other$iv)), 0.0f, null, 6, null);
                } else {
                    long other$iv2 = this.visualOffset;
                    Placeable.PlacementScope.m3543placeWithLayeraW9wM$default(scope, placeable, IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(offset) + IntOffset.m4500getXimpl(other$iv2), IntOffset.m4501getYimpl(offset) + IntOffset.m4501getYimpl(other$iv2)), 0.0f, null, 6, null);
                }
            }
            i3++;
            i2 = i;
        }
    }

    /* renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m930getMainAxisgyyYBs(long $this$mainAxis) {
        return this.isVertical ? IntOffset.m4501getYimpl($this$mainAxis) : IntOffset.m4500getXimpl($this$mainAxis);
    }

    private final int getMainAxisSize(Placeable $this$mainAxisSize) {
        return this.isVertical ? $this$mainAxisSize.getHeight() : $this$mainAxisSize.getWidth();
    }
}
