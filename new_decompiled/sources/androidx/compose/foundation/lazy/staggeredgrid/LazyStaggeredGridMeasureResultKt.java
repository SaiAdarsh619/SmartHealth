package androidx.compose.foundation.lazy.staggeredgrid;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyStaggeredGridMeasureResult.kt */
@Metadata(m286d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, m287d2 = {"findVisibleItem", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "itemIndex", "", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridMeasureResultKt {
    public static final LazyStaggeredGridItemInfo findVisibleItem(LazyStaggeredGridLayoutInfo $this$findVisibleItem, final int itemIndex) {
        Intrinsics.checkNotNullParameter($this$findVisibleItem, "<this>");
        if ($this$findVisibleItem.getVisibleItemsInfo().isEmpty()) {
            return null;
        }
        int index = ((LazyStaggeredGridItemInfo) CollectionsKt.first((List) $this$findVisibleItem.getVisibleItemsInfo())).getIndex();
        boolean z = false;
        if (itemIndex <= ((LazyStaggeredGridItemInfo) CollectionsKt.last((List) $this$findVisibleItem.getVisibleItemsInfo())).getIndex() && index <= itemIndex) {
            z = true;
        }
        if (!z) {
            return null;
        }
        int index2 = CollectionsKt.binarySearch$default($this$findVisibleItem.getVisibleItemsInfo(), 0, 0, new Function1<LazyStaggeredGridItemInfo, Integer>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResultKt$findVisibleItem$index$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(LazyStaggeredGridItemInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(it.getIndex() - itemIndex);
            }
        }, 3, (Object) null);
        return (LazyStaggeredGridItemInfo) CollectionsKt.getOrNull($this$findVisibleItem.getVisibleItemsInfo(), index2);
    }
}
