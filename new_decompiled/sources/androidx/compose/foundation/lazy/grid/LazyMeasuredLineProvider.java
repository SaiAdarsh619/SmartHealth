package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.p000ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: LazyMeasuredLineProvider.kt */
@Metadata(m286d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001f\u0010 R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006!"}, m287d2 = {"Landroidx/compose/foundation/lazy/grid/LazyMeasuredLineProvider;", "", "isVertical", "", "slotSizesSums", "", "", "crossAxisSpacing", "gridItemsCount", "spaceBetweenLines", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "measuredLineFactory", "Landroidx/compose/foundation/lazy/grid/MeasuredLineFactory;", "(ZLjava/util/List;IIILandroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;Landroidx/compose/foundation/lazy/grid/MeasuredLineFactory;)V", "keyToIndexMap", "", "getKeyToIndexMap", "()Ljava/util/Map;", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "startSlot", "span", "childConstraints-JhjzzOo$foundation_release", "(II)J", "getAndMeasure", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredLine;", "lineIndex", "Landroidx/compose/foundation/lazy/grid/LineIndex;", "getAndMeasure-bKFJvoY", "(I)Landroidx/compose/foundation/lazy/grid/LazyMeasuredLine;", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyMeasuredLineProvider {
    private final int crossAxisSpacing;
    private final int gridItemsCount;
    private final boolean isVertical;
    private final LazyMeasuredItemProvider measuredItemProvider;
    private final MeasuredLineFactory measuredLineFactory;
    private final List<Integer> slotSizesSums;
    private final int spaceBetweenLines;
    private final LazyGridSpanLayoutProvider spanLayoutProvider;

    public LazyMeasuredLineProvider(boolean isVertical, List<Integer> slotSizesSums, int crossAxisSpacing, int gridItemsCount, int spaceBetweenLines, LazyMeasuredItemProvider measuredItemProvider, LazyGridSpanLayoutProvider spanLayoutProvider, MeasuredLineFactory measuredLineFactory) {
        Intrinsics.checkNotNullParameter(slotSizesSums, "slotSizesSums");
        Intrinsics.checkNotNullParameter(measuredItemProvider, "measuredItemProvider");
        Intrinsics.checkNotNullParameter(spanLayoutProvider, "spanLayoutProvider");
        Intrinsics.checkNotNullParameter(measuredLineFactory, "measuredLineFactory");
        this.isVertical = isVertical;
        this.slotSizesSums = slotSizesSums;
        this.crossAxisSpacing = crossAxisSpacing;
        this.gridItemsCount = gridItemsCount;
        this.spaceBetweenLines = spaceBetweenLines;
        this.measuredItemProvider = measuredItemProvider;
        this.spanLayoutProvider = spanLayoutProvider;
        this.measuredLineFactory = measuredLineFactory;
    }

    /* renamed from: childConstraints-JhjzzOo$foundation_release, reason: not valid java name */
    public final long m944childConstraintsJhjzzOo$foundation_release(int startSlot, int span) {
        int lastSlotSum = this.slotSizesSums.get((startSlot + span) - 1).intValue();
        int prevSlotSum = startSlot == 0 ? 0 : this.slotSizesSums.get(startSlot - 1).intValue();
        int slotsSize = lastSlotSum - prevSlotSum;
        int crossAxisSize = RangesKt.coerceAtLeast((this.crossAxisSpacing * (span - 1)) + slotsSize, 0);
        if (this.isVertical) {
            return Constraints.INSTANCE.m4348fixedWidthOenEA2s(crossAxisSize);
        }
        return Constraints.INSTANCE.m4347fixedHeightOenEA2s(crossAxisSize);
    }

    /* renamed from: getAndMeasure-bKFJvoY, reason: not valid java name */
    public final LazyMeasuredLine m945getAndMeasurebKFJvoY(int lineIndex) {
        int mainAxisSpacing;
        LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = this.spanLayoutProvider.getLineConfiguration(lineIndex);
        int lineItemsCount = lineConfiguration.getSpans().size();
        if (lineItemsCount == 0 || lineConfiguration.getFirstItemIndex() + lineItemsCount == this.gridItemsCount) {
            mainAxisSpacing = 0;
        } else {
            mainAxisSpacing = this.spaceBetweenLines;
        }
        int startSlot = 0;
        LazyMeasuredItem[] items = new LazyMeasuredItem[lineItemsCount];
        for (int i = 0; i < lineItemsCount; i++) {
            int span = GridItemSpan.m892getCurrentLineSpanimpl(lineConfiguration.getSpans().get(i).getPackedValue());
            long constraints = m944childConstraintsJhjzzOo$foundation_release(startSlot, span);
            LazyMeasuredItem m942getAndMeasureednRnyU = this.measuredItemProvider.m942getAndMeasureednRnyU(ItemIndex.m898constructorimpl(lineConfiguration.getFirstItemIndex() + i), mainAxisSpacing, constraints);
            startSlot += span;
            Unit unit = Unit.INSTANCE;
            items[i] = m942getAndMeasureednRnyU;
        }
        return this.measuredLineFactory.mo927createLineH9FfpSk(lineIndex, items, lineConfiguration.getSpans(), mainAxisSpacing);
    }

    public final Map<Object, Integer> getKeyToIndexMap() {
        return this.measuredItemProvider.getKeyToIndexMap();
    }
}
