package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.p000ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyStaggeredGridMeasure.kt */
@Metadata(m286d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, m287d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "", "isVertical", "", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "resolvedSlotSums", "", "measuredItemFactory", "Landroidx/compose/foundation/lazy/staggeredgrid/MeasuredItemFactory;", "(ZLandroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;[ILandroidx/compose/foundation/lazy/staggeredgrid/MeasuredItemFactory;)V", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "slot", "", "childConstraints-OenEA2s", "(I)J", "getAndMeasure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "index", "lane", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class LazyStaggeredGridMeasureProvider {
    private final boolean isVertical;
    private final LazyLayoutItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;
    private final MeasuredItemFactory measuredItemFactory;
    private final int[] resolvedSlotSums;

    public LazyStaggeredGridMeasureProvider(boolean isVertical, LazyLayoutItemProvider itemProvider, LazyLayoutMeasureScope measureScope, int[] resolvedSlotSums, MeasuredItemFactory measuredItemFactory) {
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(measureScope, "measureScope");
        Intrinsics.checkNotNullParameter(resolvedSlotSums, "resolvedSlotSums");
        Intrinsics.checkNotNullParameter(measuredItemFactory, "measuredItemFactory");
        this.isVertical = isVertical;
        this.itemProvider = itemProvider;
        this.measureScope = measureScope;
        this.resolvedSlotSums = resolvedSlotSums;
        this.measuredItemFactory = measuredItemFactory;
    }

    /* renamed from: childConstraints-OenEA2s, reason: not valid java name */
    private final long m978childConstraintsOenEA2s(int slot) {
        int previousSum = slot == 0 ? 0 : this.resolvedSlotSums[slot - 1];
        int crossAxisSize = this.resolvedSlotSums[slot] - previousSum;
        if (this.isVertical) {
            return Constraints.INSTANCE.m4348fixedWidthOenEA2s(crossAxisSize);
        }
        return Constraints.INSTANCE.m4347fixedHeightOenEA2s(crossAxisSize);
    }

    public final LazyStaggeredGridMeasuredItem getAndMeasure(int index, int lane) {
        Object key = this.itemProvider.getKey(index);
        List placeables = this.measureScope.mo962measure0kLqBqw(index, m978childConstraintsOenEA2s(lane));
        return this.measuredItemFactory.createItem(index, lane, key, placeables);
    }
}
