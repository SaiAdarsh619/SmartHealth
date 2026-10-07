package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.p000ui.unit.IntOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: LazyGridItemPlacementAnimator.kt */
@Metadata(m286d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0004H\u0002\u001a\"\u0010\u0007\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002\u001a2\u0010\f\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002\u001a\u0014\u0010\u0011\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0004H\u0002\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m287d2 = {"InterruptionSpec", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/unit/IntOffset;", "firstIndexInNextLineAfter", "", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "index", "getLineSize", "", "Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "itemIndex", "fallback", "getLinesMainAxisSizesSum", "fromIndex", "toIndex", "averageLineMainAxisSize", "visibleItems", "lastIndexInPreviousLineBefore", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyGridItemPlacementAnimatorKt {
    private static final SpringSpec<IntOffset> InterruptionSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m4491boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final int lastIndexInPreviousLineBefore(LazyGridSpanLayoutProvider $this$lastIndexInPreviousLineBefore, int index) {
        int lineIndex = $this$lastIndexInPreviousLineBefore.m938getLineIndexOfItem_Ze7BM(index);
        LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = $this$lastIndexInPreviousLineBefore.getLineConfiguration(lineIndex);
        return lineConfiguration.getFirstItemIndex() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int firstIndexInNextLineAfter(LazyGridSpanLayoutProvider $this$firstIndexInNextLineAfter, int index) {
        int lineIndex = $this$firstIndexInNextLineAfter.m938getLineIndexOfItem_Ze7BM(index);
        LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = $this$firstIndexInNextLineAfter.getLineConfiguration(lineIndex);
        return lineConfiguration.getFirstItemIndex() + lineConfiguration.getSpans().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getLinesMainAxisSizesSum(LazyGridSpanLayoutProvider $this$getLinesMainAxisSizesSum, int fromIndex, int toIndex, int averageLineMainAxisSize, List<LazyGridPositionedItem> list) {
        int index = fromIndex;
        int sizes = 0;
        while (index <= toIndex) {
            int lastItemInTheLine = firstIndexInNextLineAfter($this$getLinesMainAxisSizesSum, index) - 1;
            if (lastItemInTheLine <= toIndex) {
                sizes += getLineSize(list, lastItemInTheLine, averageLineMainAxisSize);
            }
            index = lastItemInTheLine + 1;
        }
        return sizes;
    }

    private static final int getLineSize(List<LazyGridPositionedItem> list, int itemIndex, int fallback) {
        if (list.isEmpty() || itemIndex < ((LazyGridPositionedItem) CollectionsKt.first((List) list)).getIndex() || itemIndex > ((LazyGridPositionedItem) CollectionsKt.last((List) list)).getIndex()) {
            return fallback;
        }
        if (itemIndex - ((LazyGridPositionedItem) CollectionsKt.first((List) list)).getIndex() < ((LazyGridPositionedItem) CollectionsKt.last((List) list)).getIndex() - itemIndex) {
            int size = list.size();
            for (int index = 0; index < size; index++) {
                LazyGridPositionedItem item = list.get(index);
                if (item.getIndex() == itemIndex) {
                    return item.getLineMainAxisSizeWithSpacings();
                }
                if (item.getIndex() > itemIndex) {
                    break;
                }
            }
        } else {
            for (int index2 = CollectionsKt.getLastIndex(list); -1 < index2; index2--) {
                LazyGridPositionedItem item2 = list.get(index2);
                if (item2.getIndex() == itemIndex) {
                    return item2.getLineMainAxisSizeWithSpacings();
                }
                if (item2.getIndex() < itemIndex) {
                    break;
                }
            }
        }
        return fallback;
    }
}
