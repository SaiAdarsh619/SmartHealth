package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyListScrollPosition.kt */
@Metadata(m286d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J#\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0005J%\u0010\u0019\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, m287d2 = {"Landroidx/compose/foundation/lazy/LazyListScrollPosition;", "", "initialIndex", "", "initialScrollOffset", "(II)V", "hadFirstNotEmptyLayout", "", "<set-?>", "Landroidx/compose/foundation/lazy/DataIndex;", "index", "getIndex-jQJCoq8", "()I", "setIndex-ZjPyQlc", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableState;", "lastKnownFirstItemKey", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "requestPosition", "", "requestPosition-AhXoVpI", "update", "update-AhXoVpI", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyListScrollPosition {
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
    public LazyListScrollPosition() {
        this(r2, r2, 3, null);
        int i = 0;
    }

    public LazyListScrollPosition(int initialIndex, int initialScrollOffset) {
        this.index = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DataIndex.m845boximpl(DataIndex.m847constructorimpl(initialIndex)), null, 2, null);
        this.scrollOffset = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(initialScrollOffset), null, 2, null);
    }

    public /* synthetic */ LazyListScrollPosition(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    /* renamed from: getIndex-jQJCoq8, reason: not valid java name */
    public final int m877getIndexjQJCoq8() {
        State $this$getValue$iv = this.index;
        return ((DataIndex) $this$getValue$iv.getValue()).m857unboximpl();
    }

    /* renamed from: setIndex-ZjPyQlc, reason: not valid java name */
    public final void m879setIndexZjPyQlc(int i) {
        MutableState $this$setValue$iv = this.index;
        $this$setValue$iv.setValue(DataIndex.m845boximpl(i));
    }

    private final void setScrollOffset(int i) {
        MutableState $this$setValue$iv = this.scrollOffset;
        $this$setValue$iv.setValue(Integer.valueOf(i));
    }

    public final int getScrollOffset() {
        State $this$getValue$iv = this.scrollOffset;
        return ((Number) $this$getValue$iv.getValue()).intValue();
    }

    public final void updateFromMeasureResult(LazyListMeasureResult measureResult) {
        Intrinsics.checkNotNullParameter(measureResult, "measureResult");
        LazyMeasuredItem firstVisibleItem = measureResult.getFirstVisibleItem();
        this.lastKnownFirstItemKey = firstVisibleItem != null ? firstVisibleItem.getKey() : null;
        if (this.hadFirstNotEmptyLayout || measureResult.getTotalItemsCount() > 0) {
            this.hadFirstNotEmptyLayout = true;
            int scrollOffset = measureResult.getFirstVisibleItemScrollOffset();
            if (!(((float) scrollOffset) >= 0.0f)) {
                throw new IllegalStateException(("scrollOffset should be non-negative (" + scrollOffset + ')').toString());
            }
            Snapshot.Companion this_$iv = Snapshot.INSTANCE;
            Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
            try {
                Snapshot previous$iv$iv = snapshot$iv.makeCurrent();
                try {
                    LazyMeasuredItem firstVisibleItem2 = measureResult.getFirstVisibleItem();
                    m876updateAhXoVpI(DataIndex.m847constructorimpl(firstVisibleItem2 != null ? firstVisibleItem2.getIndex() : 0), scrollOffset);
                    Unit unit = Unit.INSTANCE;
                } finally {
                    snapshot$iv.restoreCurrent(previous$iv$iv);
                }
            } finally {
                snapshot$iv.dispose();
            }
        }
    }

    /* renamed from: requestPosition-AhXoVpI, reason: not valid java name */
    public final void m878requestPositionAhXoVpI(int index, int scrollOffset) {
        m876updateAhXoVpI(index, scrollOffset);
        this.lastKnownFirstItemKey = null;
    }

    @ExperimentalFoundationApi
    public final void updateScrollPositionIfTheFirstItemWasMoved(LazyListItemProvider itemProvider) {
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Snapshot.Companion this_$iv = Snapshot.INSTANCE;
        Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
        try {
            Snapshot previous$iv$iv = snapshot$iv.makeCurrent();
            try {
                m876updateAhXoVpI(DataIndex.m847constructorimpl(LazyLayoutItemProviderKt.findIndexByKey(itemProvider, this.lastKnownFirstItemKey, m877getIndexjQJCoq8())), getScrollOffset());
                Unit unit = Unit.INSTANCE;
            } finally {
                snapshot$iv.restoreCurrent(previous$iv$iv);
            }
        } finally {
            snapshot$iv.dispose();
        }
    }

    /* renamed from: update-AhXoVpI, reason: not valid java name */
    private final void m876updateAhXoVpI(int index, int scrollOffset) {
        if (!(((float) index) >= 0.0f)) {
            throw new IllegalArgumentException(("Index should be non-negative (" + index + ')').toString());
        }
        if (!DataIndex.m850equalsimpl0(index, m877getIndexjQJCoq8())) {
            m879setIndexZjPyQlc(index);
        }
        if (scrollOffset != getScrollOffset()) {
            setScrollOffset(scrollOffset);
        }
    }
}
