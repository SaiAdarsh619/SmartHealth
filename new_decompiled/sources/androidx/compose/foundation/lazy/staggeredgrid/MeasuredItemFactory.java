package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.p000ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;

/* compiled from: LazyStaggeredGridMeasure.kt */
@Metadata(m286d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bâ\u0080\u0001\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, m287d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/MeasuredItemFactory;", "", "createItem", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "index", "", "lane", "key", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
interface MeasuredItemFactory {
    LazyStaggeredGridMeasuredItem createItem(int index, int lane, Object key, List<? extends Placeable> placeables);
}
