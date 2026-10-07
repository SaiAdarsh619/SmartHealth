package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.compose.p000ui.unit.IntSizeKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: LazyStaggeredGridMeasure.kt */
@Metadata(m286d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u001c\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a\u001c\u0010\n\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a\f\u0010\u000b\u001a\u00020\u0006*\u00020\u0004H\u0002\u001a2\u0010\f\u001a\u00020\u0006\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00060\u0010H\u0082\b¢\u0006\u0002\u0010\u0011\u001a\f\u0010\u0012\u001a\u00020\u0006*\u00020\u0004H\u0000\u001a,\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0003\u001aq\u0010\u001a\u001a\u00020\u0014*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,\u001a\u0014\u0010-\u001a\u00020\u0001*\u00020\u00042\u0006\u0010.\u001a\u00020\u0006H\u0002\u001a!\u0010/\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0010H\u0082\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, m287d2 = {"ensureIndicesInRange", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "indices", "", "itemCount", "", "findNextItemIndex", "item", "lane", "findPreviousItemIndex", "indexOfMaxValue", "indexOfMinBy", "T", "", "block", "Lkotlin/Function1;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMinValue", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "initialScrollDelta", "initialItemIndices", "initialItemOffsets", "canRestartMeasure", "", "measureStaggeredGrid", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "resolvedSlotSums", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "crossAxisSpacing", "beforeContentPadding", "afterContentPadding", "measureStaggeredGrid-yR9pz_M", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;[IJZJIIIII)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "offsetBy", "delta", "transform", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridMeasureKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [int[]] */
    /* JADX WARN: Type inference failed for: r0v30 */
    @ExperimentalFoundationApi
    /* renamed from: measureStaggeredGrid-yR9pz_M, reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m976measureStaggeredGridyR9pz_M(LazyLayoutMeasureScope measureStaggeredGrid, LazyStaggeredGridState state, LazyLayoutItemProvider itemProvider, int[] resolvedSlotSums, long j, boolean z, long j2, int i, int i2, int i3, int i4, int i5) {
        int i6;
        T t;
        T t2;
        Intrinsics.checkNotNullParameter(measureStaggeredGrid, "$this$measureStaggeredGrid");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(resolvedSlotSums, "resolvedSlotSums");
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(state, itemProvider, resolvedSlotSums, j, z, measureStaggeredGrid, i, j2, i4, i5, i2, i3, null);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Snapshot.Companion companion = Snapshot.INSTANCE;
        int i7 = 0;
        Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
        try {
            Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
            try {
                try {
                    int[] indices = state.getScrollPosition().getIndices();
                    int[] offsets = state.getScrollPosition().getOffsets();
                    try {
                        if (indices.length == resolvedSlotSums.length) {
                            t = indices;
                        } else {
                            lazyStaggeredGridMeasureContext.getSpans().reset();
                            int[] iArr = new int[resolvedSlotSums.length];
                            int length = iArr.length;
                            int i8 = 0;
                            while (i8 < length) {
                                Snapshot.Companion companion2 = companion;
                                try {
                                    if (i8 < indices.length) {
                                        try {
                                            i6 = indices[i8];
                                        } catch (Throwable th) {
                                            th = th;
                                            createNonObservableSnapshot.restoreCurrent(makeCurrent);
                                            throw th;
                                        }
                                    } else {
                                        i6 = i8 == 0 ? 0 : findNextItemIndex(lazyStaggeredGridMeasureContext, iArr[i8 - 1], i8);
                                    }
                                    iArr[i8] = i6;
                                    int i9 = i7;
                                    try {
                                        lazyStaggeredGridMeasureContext.getSpans().setSpan(iArr[i8], i8);
                                        i8++;
                                        companion = companion2;
                                        i7 = i9;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        createNonObservableSnapshot.restoreCurrent(makeCurrent);
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                            t = iArr;
                        }
                        objectRef.element = t;
                        if (offsets.length == resolvedSlotSums.length) {
                            t2 = offsets;
                        } else {
                            t2 = new int[resolvedSlotSums.length];
                            int i10 = 0;
                            int length2 = t2.length;
                            while (i10 < length2) {
                                t2[i10] = i10 < offsets.length ? offsets[i10] : i10 == 0 ? 0 : t2[i10 - 1];
                                i10++;
                            }
                        }
                        objectRef2.element = t2;
                        Unit unit = Unit.INSTANCE;
                        createNonObservableSnapshot.restoreCurrent(makeCurrent);
                        createNonObservableSnapshot.dispose();
                        return measure(lazyStaggeredGridMeasureContext, MathKt.roundToInt(state.getScrollToBeConsumed()), (int[]) objectRef.element, (int[]) objectRef2.element, true);
                    } catch (Throwable th4) {
                        th = th4;
                        createNonObservableSnapshot.restoreCurrent(makeCurrent);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    createNonObservableSnapshot.dispose();
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    @ExperimentalFoundationApi
    private static final LazyStaggeredGridMeasureResult measure(LazyStaggeredGridMeasureContext $this$measure, int initialScrollDelta, int[] initialItemIndices, int[] initialItemOffsets, boolean canRestartMeasure) {
        boolean z;
        int nextItemIndex;
        int[] $this$forEachIndexed$iv;
        boolean z2;
        int scrollDelta;
        boolean z3;
        boolean canScrollForward;
        int scrollDelta2;
        boolean z4;
        int scrollDelta3;
        int i;
        int i2;
        boolean z5;
        int scrollDelta4;
        String str;
        int[] $this$forEachIndexed$iv2;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = $this$measure;
        int[] iArr = initialItemIndices;
        int[] iArr2 = initialItemOffsets;
        LazyLayoutMeasureScope $this$measure_u24lambda_u2d17 = $this$measure.getMeasureScope();
        int itemCount = $this$measure.getItemProvider().getItemCount();
        if (itemCount > 0) {
            if (!($this$measure.getResolvedSlotSums().length == 0)) {
                int scrollDelta5 = initialScrollDelta;
                int[] firstItemIndices = Arrays.copyOf(iArr, iArr.length);
                String str2 = "copyOf(this, size)";
                Intrinsics.checkNotNullExpressionValue(firstItemIndices, "copyOf(this, size)");
                int[] firstItemOffsets = Arrays.copyOf(iArr2, iArr2.length);
                Intrinsics.checkNotNullExpressionValue(firstItemOffsets, "copyOf(this, size)");
                ensureIndicesInRange(lazyStaggeredGridMeasureContext, firstItemIndices, itemCount);
                offsetBy(firstItemOffsets, -scrollDelta5);
                int length = $this$measure.getResolvedSlotSums().length;
                ArrayDeque[] measuredItems = new ArrayDeque[length];
                for (int i3 = 0; i3 < length; i3++) {
                    measuredItems[i3] = new ArrayDeque();
                }
                offsetBy(firstItemOffsets, -$this$measure.getBeforeContentPadding());
                int laneToCheckForGaps = -1;
                while (true) {
                    if (!m974measure$lambda17$hasSpaceBeforeFirst(firstItemIndices, firstItemOffsets, lazyStaggeredGridMeasureContext)) {
                        break;
                    }
                    int laneIndex = indexOfMinValue(firstItemOffsets);
                    int previousItemIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext, firstItemIndices[laneIndex], laneIndex);
                    if (previousItemIndex < 0) {
                        laneToCheckForGaps = laneIndex;
                        break;
                    }
                    if ($this$measure.getSpans().getSpan(previousItemIndex) == -1) {
                        $this$measure.getSpans().setSpan(previousItemIndex, laneIndex);
                    }
                    LazyStaggeredGridMeasuredItem measuredItem = $this$measure.getMeasuredItemProvider().getAndMeasure(previousItemIndex, laneIndex);
                    measuredItems[laneIndex].addFirst(measuredItem);
                    firstItemIndices[laneIndex] = previousItemIndex;
                    firstItemOffsets[laneIndex] = firstItemOffsets[laneIndex] + measuredItem.getSizeWithSpacings();
                }
                int minOffset = -$this$measure.getBeforeContentPadding();
                if (firstItemOffsets[0] < minOffset) {
                    scrollDelta5 += firstItemOffsets[0];
                    offsetBy(firstItemOffsets, minOffset - firstItemOffsets[0]);
                }
                offsetBy(firstItemOffsets, $this$measure.getBeforeContentPadding());
                int laneToCheckForGaps2 = laneToCheckForGaps == -1 ? ArraysKt.indexOf(firstItemIndices, 0) : laneToCheckForGaps;
                if (laneToCheckForGaps2 != -1 && m975measure$lambda17$misalignedStart(firstItemIndices, lazyStaggeredGridMeasureContext, firstItemOffsets, laneToCheckForGaps2) && canRestartMeasure) {
                    $this$measure.getSpans().reset();
                    int length2 = firstItemIndices.length;
                    int[] iArr3 = new int[length2];
                    for (int i4 = 0; i4 < length2; i4++) {
                        iArr3[i4] = -1;
                    }
                    int length3 = firstItemOffsets.length;
                    int[] iArr4 = new int[length3];
                    for (int i5 = 0; i5 < length3; i5++) {
                        iArr4[i5] = firstItemOffsets[laneToCheckForGaps2];
                    }
                    return measure(lazyStaggeredGridMeasureContext, scrollDelta5, iArr3, iArr4, false);
                }
                int lane = iArr.length;
                int[] currentItemIndices = Arrays.copyOf(iArr, lane);
                Intrinsics.checkNotNullExpressionValue(currentItemIndices, "copyOf(this, size)");
                ensureIndicesInRange(lazyStaggeredGridMeasureContext, currentItemIndices, itemCount);
                Unit unit = Unit.INSTANCE;
                int length4 = iArr2.length;
                int[] currentItemOffsets = new int[length4];
                for (int i6 = 0; i6 < length4; i6++) {
                    currentItemOffsets[i6] = -(iArr2[i6] - scrollDelta5);
                }
                int maxOffset = RangesKt.coerceAtLeast($this$measure.getMainAxisAvailableSize() + $this$measure.getAfterContentPadding(), 0);
                int[] $this$forEachIndexed$iv3 = currentItemIndices;
                int index$iv = 0;
                int laneToCheckForGaps3 = $this$forEachIndexed$iv3.length;
                int $i$f$forEachIndexed = 0;
                while ($i$f$forEachIndexed < laneToCheckForGaps3) {
                    int item$iv = $this$forEachIndexed$iv3[$i$f$forEachIndexed];
                    int index$iv2 = index$iv + 1;
                    int i7 = laneToCheckForGaps3;
                    if (item$iv >= 0) {
                        $this$forEachIndexed$iv2 = $this$forEachIndexed$iv3;
                        str = str2;
                        int laneIndex2 = index$iv;
                        LazyStaggeredGridMeasuredItem measuredItem2 = $this$measure.getMeasuredItemProvider().getAndMeasure(item$iv, laneIndex2);
                        currentItemOffsets[laneIndex2] = currentItemOffsets[laneIndex2] + measuredItem2.getSizeWithSpacings();
                        scrollDelta4 = scrollDelta5;
                        measuredItems[laneIndex2].addLast(measuredItem2);
                        $this$measure.getSpans().setSpan(item$iv, laneIndex2);
                    } else {
                        scrollDelta4 = scrollDelta5;
                        str = str2;
                        $this$forEachIndexed$iv2 = $this$forEachIndexed$iv3;
                    }
                    $i$f$forEachIndexed++;
                    index$iv = index$iv2;
                    $this$forEachIndexed$iv3 = $this$forEachIndexed$iv2;
                    laneToCheckForGaps3 = i7;
                    str2 = str;
                    scrollDelta5 = scrollDelta4;
                }
                int scrollDelta6 = scrollDelta5;
                String str3 = str2;
                while (true) {
                    int[] $this$any$iv = currentItemOffsets;
                    int length5 = $this$any$iv.length;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length5) {
                            z = false;
                            break;
                        }
                        int element$iv = $this$any$iv[i8];
                        int[] $this$any$iv2 = $this$any$iv;
                        int it = element$iv <= maxOffset ? 1 : 0;
                        if (it != 0) {
                            z = true;
                            break;
                        }
                        i8++;
                        $this$any$iv = $this$any$iv2;
                    }
                    if (!z) {
                        int length6 = measuredItems.length;
                        int i9 = 0;
                        while (true) {
                            if (i9 >= length6) {
                                z5 = true;
                                break;
                            }
                            if (!measuredItems[i9].isEmpty()) {
                                z5 = false;
                                break;
                            }
                            i9++;
                        }
                        if (!z5) {
                            break;
                        }
                    }
                    int currentLaneIndex = indexOfMinValue(currentItemOffsets);
                    int nextItemIndex2 = findNextItemIndex(lazyStaggeredGridMeasureContext, currentItemIndices[currentLaneIndex], currentLaneIndex);
                    if (nextItemIndex2 >= itemCount) {
                        int missedItemIndex = Integer.MAX_VALUE;
                        int[] $this$forEachIndexed$iv4 = currentItemIndices;
                        int index$iv3 = 0;
                        int length7 = $this$forEachIndexed$iv4.length;
                        int i10 = 0;
                        while (i10 < length7) {
                            int item$iv2 = $this$forEachIndexed$iv4[i10];
                            int index$iv4 = index$iv3 + 1;
                            int laneIndex3 = index$iv3;
                            int i11 = length7;
                            if (laneIndex3 != currentLaneIndex) {
                                $this$forEachIndexed$iv = $this$forEachIndexed$iv4;
                                int i12 = findNextItemIndex(lazyStaggeredGridMeasureContext, item$iv2, laneIndex3);
                                int itemIndex = i12;
                                while (itemIndex < itemCount) {
                                    int missedItemIndex2 = Math.min(itemIndex, missedItemIndex);
                                    $this$measure.getSpans().setSpan(itemIndex, -1);
                                    itemIndex = findNextItemIndex(lazyStaggeredGridMeasureContext, itemIndex, laneIndex3);
                                    missedItemIndex = missedItemIndex2;
                                    nextItemIndex2 = nextItemIndex2;
                                }
                                nextItemIndex = nextItemIndex2;
                            } else {
                                nextItemIndex = nextItemIndex2;
                                $this$forEachIndexed$iv = $this$forEachIndexed$iv4;
                            }
                            i10++;
                            index$iv3 = index$iv4;
                            $this$forEachIndexed$iv4 = $this$forEachIndexed$iv;
                            length7 = i11;
                            nextItemIndex2 = nextItemIndex;
                        }
                        if (missedItemIndex != Integer.MAX_VALUE && canRestartMeasure) {
                            iArr[currentLaneIndex] = Math.min(iArr[currentLaneIndex], missedItemIndex);
                            return measure(lazyStaggeredGridMeasureContext, initialScrollDelta, iArr, iArr2, false);
                        }
                    } else {
                        int[] currentItemIndices2 = currentItemIndices;
                        String str4 = str3;
                        int scrollDelta7 = scrollDelta6;
                        if (firstItemIndices[currentLaneIndex] == -1) {
                            firstItemIndices[currentLaneIndex] = nextItemIndex2;
                        }
                        $this$measure.getSpans().setSpan(nextItemIndex2, currentLaneIndex);
                        LazyStaggeredGridMeasuredItem measuredItem3 = $this$measure.getMeasuredItemProvider().getAndMeasure(nextItemIndex2, currentLaneIndex);
                        currentItemOffsets[currentLaneIndex] = currentItemOffsets[currentLaneIndex] + measuredItem3.getSizeWithSpacings();
                        measuredItems[currentLaneIndex].addLast(measuredItem3);
                        currentItemIndices2[currentLaneIndex] = nextItemIndex2;
                        lazyStaggeredGridMeasureContext = $this$measure;
                        iArr = initialItemIndices;
                        iArr2 = initialItemOffsets;
                        str3 = str4;
                        scrollDelta6 = scrollDelta7;
                        currentItemIndices = currentItemIndices2;
                    }
                }
                int laneIndex4 = 0;
                int length8 = measuredItems.length;
                while (laneIndex4 < length8) {
                    ArrayDeque laneItems = measuredItems[laneIndex4];
                    int offset = currentItemOffsets[laneIndex4];
                    int inBoundsIndex = 0;
                    int i13 = CollectionsKt.getLastIndex(laneItems);
                    while (true) {
                        i = length8;
                        if (-1 >= i13) {
                            i2 = inBoundsIndex;
                            break;
                        }
                        offset -= ((LazyStaggeredGridMeasuredItem) laneItems.get(i13)).getSizeWithSpacings();
                        inBoundsIndex = i13;
                        if (offset <= minOffset + $this$measure.getMainAxisSpacing()) {
                            i2 = inBoundsIndex;
                            break;
                        }
                        i13--;
                        length8 = i;
                    }
                    for (int i14 = 0; i14 < i2; i14++) {
                        firstItemOffsets[laneIndex4] = firstItemOffsets[laneIndex4] - ((LazyStaggeredGridMeasuredItem) laneItems.removeFirst()).getSizeWithSpacings();
                    }
                    if (!laneItems.isEmpty()) {
                        firstItemIndices[laneIndex4] = ((LazyStaggeredGridMeasuredItem) laneItems.first()).getIndex();
                    }
                    laneIndex4++;
                    length8 = i;
                }
                int[] $this$all$iv = currentItemOffsets;
                int $i$f$all = 0;
                int length9 = $this$all$iv.length;
                int i15 = 0;
                while (true) {
                    if (i15 >= length9) {
                        z2 = true;
                        break;
                    }
                    int element$iv2 = $this$all$iv[i15];
                    int[] $this$all$iv2 = $this$all$iv;
                    int $i$f$all2 = $i$f$all;
                    if (!(element$iv2 < $this$measure.getMainAxisAvailableSize())) {
                        z2 = false;
                        break;
                    }
                    i15++;
                    $this$all$iv = $this$all$iv2;
                    $i$f$all = $i$f$all2;
                }
                if (z2) {
                    int laneIndex5 = indexOfMaxValue(currentItemOffsets);
                    int toScrollBack = $this$measure.getMainAxisAvailableSize() - currentItemOffsets[laneIndex5];
                    offsetBy(firstItemOffsets, -toScrollBack);
                    offsetBy(currentItemOffsets, toScrollBack);
                    while (true) {
                        int[] $this$any$iv3 = firstItemOffsets;
                        int $i$f$any = 0;
                        int length10 = $this$any$iv3.length;
                        int maxOffsetLane = laneIndex5;
                        int maxOffsetLane2 = 0;
                        while (true) {
                            if (maxOffsetLane2 >= length10) {
                                z4 = false;
                                break;
                            }
                            int element$iv3 = $this$any$iv3[maxOffsetLane2];
                            int[] $this$any$iv4 = $this$any$iv3;
                            int $i$f$any2 = $i$f$any;
                            if (element$iv3 < $this$measure.getBeforeContentPadding()) {
                                z4 = true;
                                break;
                            }
                            maxOffsetLane2++;
                            $this$any$iv3 = $this$any$iv4;
                            $i$f$any = $i$f$any2;
                        }
                        if (!z4) {
                            scrollDelta3 = scrollDelta6;
                            break;
                        }
                        int laneIndex6 = indexOfMinValue(firstItemOffsets);
                        int currentIndex = firstItemIndices[laneIndex6] == -1 ? itemCount : firstItemIndices[laneIndex6];
                        int previousIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext, currentIndex, laneIndex6);
                        if (previousIndex >= 0) {
                            $this$measure.getSpans().setSpan(previousIndex, laneIndex6);
                            LazyStaggeredGridMeasuredItem measuredItem4 = $this$measure.getMeasuredItemProvider().getAndMeasure(previousIndex, laneIndex6);
                            measuredItems[laneIndex6].addFirst(measuredItem4);
                            firstItemOffsets[laneIndex6] = firstItemOffsets[laneIndex6] + measuredItem4.getSizeWithSpacings();
                            firstItemIndices[laneIndex6] = previousIndex;
                            laneIndex5 = maxOffsetLane;
                        } else {
                            if (m975measure$lambda17$misalignedStart(firstItemIndices, lazyStaggeredGridMeasureContext, firstItemOffsets, laneIndex6) && canRestartMeasure) {
                                $this$measure.getSpans().reset();
                                int length11 = firstItemIndices.length;
                                int[] iArr5 = new int[length11];
                                for (int i16 = 0; i16 < length11; i16++) {
                                    iArr5[i16] = -1;
                                }
                                int length12 = firstItemOffsets.length;
                                int[] iArr6 = new int[length12];
                                for (int i17 = 0; i17 < length12; i17++) {
                                    iArr6[i17] = firstItemOffsets[laneIndex6];
                                }
                                return measure(lazyStaggeredGridMeasureContext, scrollDelta6, iArr5, iArr6, false);
                            }
                            scrollDelta3 = scrollDelta6;
                        }
                    }
                    scrollDelta = scrollDelta3 + toScrollBack;
                    int minOffsetLane = indexOfMinValue(firstItemOffsets);
                    if (firstItemOffsets[minOffsetLane] < 0) {
                        int offsetValue = firstItemOffsets[minOffsetLane];
                        scrollDelta += offsetValue;
                        offsetBy(currentItemOffsets, offsetValue);
                        offsetBy(firstItemOffsets, -offsetValue);
                    }
                } else {
                    scrollDelta = scrollDelta6;
                }
                float consumedScroll = (MathKt.getSign(MathKt.roundToInt($this$measure.getState().getScrollToBeConsumed())) != MathKt.getSign(scrollDelta) || Math.abs(MathKt.roundToInt($this$measure.getState().getScrollToBeConsumed())) < Math.abs(scrollDelta)) ? $this$measure.getState().getScrollToBeConsumed() : scrollDelta;
                int[] itemScrollOffsets = Arrays.copyOf(firstItemOffsets, firstItemOffsets.length);
                Intrinsics.checkNotNullExpressionValue(itemScrollOffsets, str3);
                int length13 = itemScrollOffsets.length;
                for (int i$iv = 0; i$iv < length13; i$iv++) {
                    int it2 = itemScrollOffsets[i$iv];
                    itemScrollOffsets[i$iv] = -it2;
                }
                if ($this$measure.getBeforeContentPadding() > 0) {
                    int laneIndex7 = 0;
                    int length14 = measuredItems.length;
                    while (laneIndex7 < length14) {
                        ArrayDeque laneItems2 = measuredItems[laneIndex7];
                        int i18 = 0;
                        int size = laneItems2.size();
                        while (true) {
                            if (i18 >= size) {
                                scrollDelta2 = scrollDelta;
                                break;
                            }
                            int size2 = ((LazyStaggeredGridMeasuredItem) laneItems2.get(i18)).getSizeWithSpacings();
                            scrollDelta2 = scrollDelta;
                            if (i18 != CollectionsKt.getLastIndex(laneItems2) && firstItemOffsets[laneIndex7] != 0 && firstItemOffsets[laneIndex7] >= size2) {
                                firstItemOffsets[laneIndex7] = firstItemOffsets[laneIndex7] - size2;
                                firstItemIndices[laneIndex7] = ((LazyStaggeredGridMeasuredItem) laneItems2.get(i18 + 1)).getIndex();
                                i18++;
                                scrollDelta = scrollDelta2;
                            }
                        }
                        laneIndex7++;
                        scrollDelta = scrollDelta2;
                    }
                }
                int layoutWidth = $this$measure.getIsVertical() ? Constraints.m4338getMaxWidthimpl($this$measure.getConstraints()) : ConstraintsKt.m4352constrainWidthK40F9xA($this$measure.getConstraints(), ArraysKt.maxOrThrow(currentItemOffsets));
                int layoutHeight = $this$measure.getIsVertical() ? ConstraintsKt.m4351constrainHeightK40F9xA($this$measure.getConstraints(), ArraysKt.maxOrThrow(currentItemOffsets)) : Constraints.m4337getMaxHeightimpl($this$measure.getConstraints());
                int i19 = 0;
                for (ArrayDeque it3 : measuredItems) {
                    i19 += it3.size();
                }
                int capacity$iv = i19;
                final MutableVector positionedItems = new MutableVector(new LazyStaggeredGridPositionedItem[capacity$iv], 0);
                while (true) {
                    int length15 = measuredItems.length;
                    int i20 = 0;
                    while (true) {
                        if (i20 >= length15) {
                            z3 = false;
                            break;
                        }
                        if (!measuredItems[i20].isEmpty()) {
                            z3 = true;
                            break;
                        }
                        i20++;
                    }
                    if (!z3) {
                        break;
                    }
                    ArrayDeque[] arrayDequeArr = measuredItems;
                    int result$iv = -1;
                    int min$iv = Integer.MAX_VALUE;
                    int $i$f$indexOfMinBy = arrayDequeArr.length;
                    int i$iv2 = 0;
                    while (i$iv2 < $i$f$indexOfMinBy) {
                        ArrayDeque it4 = arrayDequeArr[i$iv2];
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) it4.firstOrNull();
                        int value$iv = lazyStaggeredGridMeasuredItem != null ? lazyStaggeredGridMeasuredItem.getIndex() : Integer.MAX_VALUE;
                        ArrayDeque[] arrayDequeArr2 = arrayDequeArr;
                        if (min$iv > value$iv) {
                            min$iv = value$iv;
                            result$iv = i$iv2;
                        }
                        i$iv2++;
                        arrayDequeArr = arrayDequeArr2;
                    }
                    int laneIndex8 = result$iv;
                    LazyStaggeredGridMeasuredItem item = (LazyStaggeredGridMeasuredItem) measuredItems[laneIndex8].removeFirst();
                    int mainAxisOffset = itemScrollOffsets[laneIndex8];
                    int crossAxisOffset = laneIndex8 == 0 ? 0 : $this$measure.getResolvedSlotSums()[laneIndex8 - 1] + ($this$measure.getCrossAxisSpacing() * laneIndex8);
                    positionedItems.add(item.position(laneIndex8, mainAxisOffset, crossAxisOffset));
                    itemScrollOffsets[laneIndex8] = itemScrollOffsets[laneIndex8] + item.getSizeWithSpacings();
                }
                boolean canScrollBackward = firstItemIndices[0] != 0 || firstItemOffsets[0] > 0;
                int length16 = currentItemOffsets.length;
                int i21 = 0;
                while (true) {
                    if (i21 >= length16) {
                        canScrollForward = false;
                        break;
                    }
                    int element$iv4 = currentItemOffsets[i21];
                    int[] itemScrollOffsets2 = itemScrollOffsets;
                    if (element$iv4 > $this$measure.getMainAxisAvailableSize()) {
                        canScrollForward = true;
                        break;
                    }
                    i21++;
                    itemScrollOffsets = itemScrollOffsets2;
                }
                return new LazyStaggeredGridMeasureResult(firstItemIndices, firstItemOffsets, consumedScroll, MeasureScope.layout$default($this$measure_u24lambda_u2d17, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$13
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope layout) {
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        MutableVector this_$iv = positionedItems;
                        int size$iv = this_$iv.getSize();
                        if (size$iv <= 0) {
                            return;
                        }
                        int i$iv3 = 0;
                        Object[] content$iv = this_$iv.getContent();
                        Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                        do {
                            LazyStaggeredGridPositionedItem item2 = (LazyStaggeredGridPositionedItem) content$iv[i$iv3];
                            item2.place(layout);
                            i$iv3++;
                        } while (i$iv3 < size$iv);
                    }
                }, 4, null), canScrollForward, canScrollBackward, itemCount, positionedItems.asMutableList(), IntSizeKt.IntSize(layoutWidth, layoutHeight), minOffset, maxOffset, $this$measure.getBeforeContentPadding(), $this$measure.getAfterContentPadding(), null);
            }
        }
        return new LazyStaggeredGridMeasureResult(initialItemIndices, initialItemOffsets, 0.0f, MeasureScope.layout$default($this$measure_u24lambda_u2d17, Constraints.m4340getMinWidthimpl($this$measure.getConstraints()), Constraints.m4339getMinHeightimpl($this$measure.getConstraints()), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
            }
        }, 4, null), false, false, itemCount, CollectionsKt.emptyList(), IntSizeKt.IntSize(Constraints.m4340getMinWidthimpl($this$measure.getConstraints()), Constraints.m4339getMinHeightimpl($this$measure.getConstraints())), -$this$measure.getBeforeContentPadding(), $this$measure.getMainAxisAvailableSize() + $this$measure.getAfterContentPadding(), $this$measure.getBeforeContentPadding(), $this$measure.getAfterContentPadding(), null);
    }

    /* renamed from: measure$lambda-17$hasSpaceBeforeFirst, reason: not valid java name */
    private static final boolean m974measure$lambda17$hasSpaceBeforeFirst(int[] firstItemIndices, int[] firstItemOffsets, LazyStaggeredGridMeasureContext $this_measure) {
        int length = firstItemIndices.length;
        for (int lane = 0; lane < length; lane++) {
            int itemIndex = firstItemIndices[lane];
            int itemOffset = firstItemOffsets[lane];
            if (itemOffset < (-$this_measure.getMainAxisSpacing()) && itemIndex > 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: measure$lambda-17$misalignedStart, reason: not valid java name */
    private static final boolean m975measure$lambda17$misalignedStart(int[] firstItemIndices, LazyStaggeredGridMeasureContext $this_measure, int[] firstItemOffsets, int referenceLane) {
        Iterable $this$any$iv;
        Iterable $this$any$iv2;
        Iterable laneRange = ArraysKt.getIndices(firstItemIndices);
        Iterable $this$any$iv3 = laneRange;
        if (!($this$any$iv3 instanceof Collection) || !((Collection) $this$any$iv3).isEmpty()) {
            Iterator it = $this$any$iv3.iterator();
            while (true) {
                if (it.hasNext()) {
                    int element$iv = ((IntIterator) it).nextInt();
                    if (findPreviousItemIndex($this_measure, firstItemIndices[element$iv], element$iv) == -1 && firstItemOffsets[element$iv] != firstItemOffsets[referenceLane]) {
                        $this$any$iv = 1;
                        break;
                    }
                } else {
                    $this$any$iv = null;
                    break;
                }
            }
        } else {
            $this$any$iv = null;
        }
        Iterable $this$any$iv4 = laneRange;
        if (!($this$any$iv4 instanceof Collection) || !((Collection) $this$any$iv4).isEmpty()) {
            Iterator it2 = $this$any$iv4.iterator();
            while (true) {
                if (it2.hasNext()) {
                    int element$iv2 = ((IntIterator) it2).nextInt();
                    if (findPreviousItemIndex($this_measure, firstItemIndices[element$iv2], element$iv2) != -1 && firstItemOffsets[element$iv2] >= firstItemOffsets[referenceLane]) {
                        $this$any$iv2 = 1;
                        break;
                    }
                } else {
                    $this$any$iv2 = null;
                    break;
                }
            }
        } else {
            $this$any$iv2 = null;
        }
        boolean firstItemInWrongLane = $this_measure.getSpans().getSpan(0) != 0;
        return ($this$any$iv == null && $this$any$iv2 == null && !firstItemInWrongLane) ? false : true;
    }

    private static final void offsetBy(int[] $this$offsetBy, int delta) {
        int length = $this$offsetBy.length;
        for (int i = 0; i < length; i++) {
            $this$offsetBy[i] = $this$offsetBy[i] + delta;
        }
    }

    public static final int indexOfMinValue(int[] $this$indexOfMinValue) {
        Intrinsics.checkNotNullParameter($this$indexOfMinValue, "<this>");
        int result = -1;
        int min = Integer.MAX_VALUE;
        int length = $this$indexOfMinValue.length;
        for (int i = 0; i < length; i++) {
            if (min > $this$indexOfMinValue[i]) {
                min = $this$indexOfMinValue[i];
                result = i;
            }
        }
        return result;
    }

    private static final <T> int indexOfMinBy(T[] tArr, Function1<? super T, Integer> function1) {
        int result = -1;
        int min = Integer.MAX_VALUE;
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            int value = function1.invoke(tArr[i]).intValue();
            if (min > value) {
                min = value;
                result = i;
            }
        }
        return result;
    }

    private static final int indexOfMaxValue(int[] $this$indexOfMaxValue) {
        int result = -1;
        int max = Integer.MIN_VALUE;
        int length = $this$indexOfMaxValue.length;
        for (int i = 0; i < length; i++) {
            if (max < $this$indexOfMaxValue[i]) {
                max = $this$indexOfMaxValue[i];
                result = i;
            }
        }
        return result;
    }

    private static final int[] transform(int[] $this$transform, Function1<? super Integer, Integer> function1) {
        int length = $this$transform.length;
        for (int i = 0; i < length; i++) {
            $this$transform[i] = function1.invoke(Integer.valueOf($this$transform[i])).intValue();
        }
        return $this$transform;
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext $this$ensureIndicesInRange, int[] indices, int itemCount) {
        int length = indices.length - 1;
        if (length >= 0) {
            do {
                int i = length;
                length--;
                while (indices[i] >= itemCount) {
                    indices[i] = findPreviousItemIndex($this$ensureIndicesInRange, indices[i], i);
                }
                if (indices[i] != -1) {
                    $this$ensureIndicesInRange.getSpans().setSpan(indices[i], i);
                }
            } while (length >= 0);
        }
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext $this$findPreviousItemIndex, int item, int lane) {
        return $this$findPreviousItemIndex.getSpans().findPreviousItemIndex(item, lane);
    }

    private static final int findNextItemIndex(LazyStaggeredGridMeasureContext $this$findNextItemIndex, int item, int lane) {
        return $this$findNextItemIndex.getSpans().findNextItemIndex(item, lane);
    }
}
