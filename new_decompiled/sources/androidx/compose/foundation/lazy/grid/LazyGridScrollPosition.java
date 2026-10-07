package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyGridScrollPosition.kt */
@Metadata(m286d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J#\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0005J%\u0010\u0019\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, m287d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridScrollPosition;", "", "initialIndex", "", "initialScrollOffset", "(II)V", "hadFirstNotEmptyLayout", "", "<set-?>", "Landroidx/compose/foundation/lazy/grid/ItemIndex;", "index", "getIndex-VZbfaAc", "()I", "setIndex-YGsSkvE", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableState;", "lastKnownFirstItemKey", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "requestPosition", "", "requestPosition-yO3Fmg4", "update", "update-yO3Fmg4", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyGridScrollPosition {
    private boolean hadFirstNotEmptyLayout;

    /* renamed from: index$delegate, reason: from kotlin metadata */
    private final MutableState index;
    private Object lastKnownFirstItemKey;

    /* renamed from: scrollOffset$delegate, reason: from kotlin metadata */
    private final MutableState scrollOffset;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LazyGridScrollPosition() {
        this(r2, r2, 3, null);
        int i = 0;
    }

    public LazyGridScrollPosition(int initialIndex, int initialScrollOffset) {
        this.index = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ItemIndex.m896boximpl(ItemIndex.m898constructorimpl(initialIndex)), null, 2, null);
        this.scrollOffset = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(initialScrollOffset), null, 2, null);
    }

    public /* synthetic */ LazyGridScrollPosition(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    /* renamed from: setIndex-YGsSkvE, reason: not valid java name */
    private final void m934setIndexYGsSkvE(int i) {
        MutableState $this$setValue$iv = this.index;
        $this$setValue$iv.setValue(ItemIndex.m896boximpl(i));
    }

    /* renamed from: getIndex-VZbfaAc, reason: not valid java name */
    public final int m936getIndexVZbfaAc() {
        State $this$getValue$iv = this.index;
        return ((ItemIndex) $this$getValue$iv.getValue()).m908unboximpl();
    }

    private final void setScrollOffset(int i) {
        MutableState $this$setValue$iv = this.scrollOffset;
        $this$setValue$iv.setValue(Integer.valueOf(i));
    }

    public final int getScrollOffset() {
        State $this$getValue$iv = this.scrollOffset;
        return ((Number) $this$getValue$iv.getValue()).intValue();
    }

    public final void updateFromMeasureResult(LazyGridMeasureResult measureResult) {
        LazyMeasuredItem[] items;
        LazyMeasuredItem lazyMeasuredItem;
        LazyMeasuredItem[] items2;
        LazyMeasuredItem lazyMeasuredItem2;
        Intrinsics.checkNotNullParameter(measureResult, "measureResult");
        LazyMeasuredLine firstVisibleLine = measureResult.getFirstVisibleLine();
        this.lastKnownFirstItemKey = (firstVisibleLine == null || (items2 = firstVisibleLine.getItems()) == null || (lazyMeasuredItem2 = (LazyMeasuredItem) ArraysKt.firstOrNull(items2)) == null) ? null : lazyMeasuredItem2.getKey();
        if (this.hadFirstNotEmptyLayout || measureResult.getTotalItemsCount() > 0) {
            this.hadFirstNotEmptyLayout = true;
            int scrollOffset = measureResult.getFirstVisibleLineScrollOffset();
            int i = 0;
            if (!(((float) scrollOffset) >= 0.0f)) {
                throw new IllegalStateException(("scrollOffset should be non-negative (" + scrollOffset + ')').toString());
            }
            Snapshot.Companion this_$iv = Snapshot.INSTANCE;
            Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
            try {
                Snapshot previous$iv$iv = snapshot$iv.makeCurrent();
                try {
                    LazyMeasuredLine firstVisibleLine2 = measureResult.getFirstVisibleLine();
                    if (firstVisibleLine2 != null && (items = firstVisibleLine2.getItems()) != null && (lazyMeasuredItem = (LazyMeasuredItem) ArraysKt.firstOrNull(items)) != null) {
                        i = lazyMeasuredItem.getIndex();
                    }
                    m935updateyO3Fmg4(ItemIndex.m898constructorimpl(i), scrollOffset);
                    Unit unit = Unit.INSTANCE;
                } finally {
                    snapshot$iv.restoreCurrent(previous$iv$iv);
                }
            } finally {
                snapshot$iv.dispose();
            }
        }
    }

    /* renamed from: requestPosition-yO3Fmg4, reason: not valid java name */
    public final void m937requestPositionyO3Fmg4(int index, int scrollOffset) {
        m935updateyO3Fmg4(index, scrollOffset);
        this.lastKnownFirstItemKey = null;
    }

    public final void updateScrollPositionIfTheFirstItemWasMoved(LazyGridItemProvider itemProvider) {
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Snapshot.Companion this_$iv = Snapshot.INSTANCE;
        Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
        try {
            Snapshot previous$iv$iv = snapshot$iv.makeCurrent();
            try {
                m935updateyO3Fmg4(ItemIndex.m898constructorimpl(LazyLayoutItemProviderKt.findIndexByKey(itemProvider, this.lastKnownFirstItemKey, m936getIndexVZbfaAc())), getScrollOffset());
                Unit unit = Unit.INSTANCE;
            } finally {
                snapshot$iv.restoreCurrent(previous$iv$iv);
            }
        } finally {
            snapshot$iv.dispose();
        }
    }

    /* renamed from: update-yO3Fmg4, reason: not valid java name */
    private final void m935updateyO3Fmg4(int index, int scrollOffset) {
        if (!(((float) index) >= 0.0f)) {
            throw new IllegalArgumentException(("Index should be non-negative (" + index + ')').toString());
        }
        if (!ItemIndex.m901equalsimpl0(index, m936getIndexVZbfaAc())) {
            m934setIndexYGsSkvE(index);
        }
        if (scrollOffset != getScrollOffset()) {
            setScrollOffset(scrollOffset);
        }
    }
}
