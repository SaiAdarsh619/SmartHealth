package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: LazyStaggeredGridMeasure.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B>\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003R\u001c\u0010\n\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "", "index", "", "key", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "spacing", "(ILjava/lang/Object;Ljava/util/List;ZJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentOffset-nOcc-ac", "()J", "J", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "()Z", "getKey", "()Ljava/lang/Object;", "mainAxisSize", "getMainAxisSize", "getPlaceables", "()Ljava/util/List;", "sizeWithSpacings", "getSizeWithSpacings", "getSpacing", "position", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridPositionedItem;", "lane", "mainAxis", "crossAxis", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
final class LazyStaggeredGridMeasuredItem {
    private final long contentOffset;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int mainAxisSize;
    private final List<Placeable> placeables;
    private final int sizeWithSpacings;
    private final int spacing;

    public /* synthetic */ LazyStaggeredGridMeasuredItem(int i, Object obj, List list, boolean z, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, obj, list, z, j, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LazyStaggeredGridMeasuredItem(int index, Object key, List<? extends Placeable> list, boolean isVertical, long contentOffset, int spacing) {
        Integer valueOf;
        this.index = index;
        this.key = key;
        this.placeables = list;
        this.isVertical = isVertical;
        this.contentOffset = contentOffset;
        this.spacing = spacing;
        List $this$fastFold$iv = this.placeables;
        Object accumulator$iv = 0;
        int size = $this$fastFold$iv.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            Object item$iv$iv = $this$fastFold$iv.get(index$iv$iv);
            Placeable placeable = (Placeable) item$iv$iv;
            int size2 = ((Number) accumulator$iv).intValue();
            accumulator$iv = Integer.valueOf(size2 + (this.isVertical ? placeable.getHeight() : placeable.getWidth()));
        }
        this.mainAxisSize = ((Number) accumulator$iv).intValue();
        this.sizeWithSpacings = RangesKt.coerceAtLeast(this.mainAxisSize + this.spacing, 0);
        List $this$fastMaxOfOrNull$iv = this.placeables;
        if ($this$fastMaxOfOrNull$iv.isEmpty()) {
            valueOf = null;
        } else {
            Placeable it = $this$fastMaxOfOrNull$iv.get(0);
            valueOf = Integer.valueOf(this.isVertical ? it.getWidth() : it.getHeight());
            int i$iv = 1;
            int lastIndex = CollectionsKt.getLastIndex($this$fastMaxOfOrNull$iv);
            if (1 <= lastIndex) {
                while (true) {
                    Placeable it2 = $this$fastMaxOfOrNull$iv.get(i$iv);
                    Integer valueOf2 = Integer.valueOf(this.isVertical ? it2.getWidth() : it2.getHeight());
                    valueOf = valueOf2.compareTo(valueOf) > 0 ? valueOf2 : valueOf;
                    if (i$iv == lastIndex) {
                        break;
                    }
                    i$iv++;
                }
            }
        }
        Intrinsics.checkNotNull(valueOf);
        this.crossAxisSize = valueOf.intValue();
    }

    public final int getIndex() {
        return this.index;
    }

    public final Object getKey() {
        return this.key;
    }

    public final List<Placeable> getPlaceables() {
        return this.placeables;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    /* renamed from: getContentOffset-nOcc-ac  reason: not valid java name */
    public final long m663getContentOffsetnOccac() {
        return this.contentOffset;
    }

    public final int getSpacing() {
        return this.spacing;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final LazyStaggeredGridPositionedItem position(int lane, int mainAxis, int crossAxis) {
        return new LazyStaggeredGridPositionedItem(this.isVertical ? IntOffsetKt.IntOffset(crossAxis, mainAxis) : IntOffsetKt.IntOffset(mainAxis, crossAxis), this.index, lane, this.key, IntSizeKt.IntSize(this.sizeWithSpacings, this.crossAxisSize), this.placeables, this.contentOffset, this.isVertical, null);
    }
}
