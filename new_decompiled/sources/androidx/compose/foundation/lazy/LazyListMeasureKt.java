package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: LazyListMeasure.kt */
@Metadata(m286d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u008c\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001aà\u0001\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2/\u0010,\u001a+\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.¢\u0006\u0002\b1\u0012\u0004\u0012\u0002020-H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00065"}, m287d2 = {"calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/LazyListPositionedItem;", "items", "", "Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "itemsCount", "itemProvider", "Landroidx/compose/foundation/lazy/LazyMeasuredItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "Landroidx/compose/foundation/lazy/DataIndex;", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "headerIndexes", "placementAnimator", "Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-nXYdgZc", "(ILandroidx/compose/foundation/lazy/LazyMeasuredItemProvider;IIIIIIFJZLjava/util/List;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyListMeasureKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x030e  */
    /* renamed from: measureLazyList-nXYdgZc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final LazyListMeasureResult m873measureLazyListnXYdgZc(int itemsCount, LazyMeasuredItemProvider itemProvider, int mainAxisAvailableSize, int beforeContentPadding, int afterContentPadding, int spaceBetweenItems, int firstVisibleItemIndex, int firstVisibleItemScrollOffset, float scrollToBeConsumed, long constraints, boolean isVertical, List<Integer> headerIndexes, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, boolean reverseLayout, Density density, LazyListItemPlacementAnimator placementAnimator, LazyListBeyondBoundsInfo beyondBoundsInfo, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> layout) {
        int index;
        int scrollDelta;
        int maxCrossAxis;
        LazyMeasuredItem firstItem;
        int currentFirstItemScrollOffset;
        LazyMeasuredItem firstItem2;
        LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo;
        int scrollDelta2;
        List extraItemsBefore;
        List extraItemsAfter;
        boolean noExtraItems;
        LazyListPositionedItem lazyListPositionedItem;
        int i;
        int currentMainAxisOffset;
        List list;
        int currentFirstItemIndex;
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(headerIndexes, "headerIndexes");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(placementAnimator, "placementAnimator");
        Intrinsics.checkNotNullParameter(beyondBoundsInfo, "beyondBoundsInfo");
        Intrinsics.checkNotNullParameter(layout, "layout");
        if (!(beforeContentPadding >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(afterContentPadding >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (itemsCount <= 0) {
            return new LazyListMeasureResult(null, 0, false, 0.0f, layout.invoke(Integer.valueOf(Constraints.m4340getMinWidthimpl(constraints)), Integer.valueOf(Constraints.m4339getMinHeightimpl(constraints)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                }
            }), CollectionsKt.emptyList(), -beforeContentPadding, mainAxisAvailableSize + afterContentPadding, 0, reverseLayout, isVertical ? Orientation.Vertical : Orientation.Horizontal, afterContentPadding);
        }
        int currentFirstItemIndex2 = firstVisibleItemIndex;
        int currentFirstItemScrollOffset2 = firstVisibleItemScrollOffset;
        if (currentFirstItemIndex2 >= itemsCount) {
            currentFirstItemIndex2 = DataIndex.m847constructorimpl(itemsCount - 1);
            currentFirstItemScrollOffset2 = 0;
        }
        int scrollDelta3 = MathKt.roundToInt(scrollToBeConsumed);
        int currentFirstItemScrollOffset3 = currentFirstItemScrollOffset2 - scrollDelta3;
        if (DataIndex.m850equalsimpl0(currentFirstItemIndex2, DataIndex.m847constructorimpl(0)) && currentFirstItemScrollOffset3 < 0) {
            scrollDelta3 += currentFirstItemScrollOffset3;
            currentFirstItemScrollOffset3 = 0;
        }
        List visibleItems = new ArrayList();
        int minOffset = (-beforeContentPadding) + (spaceBetweenItems < 0 ? spaceBetweenItems : 0);
        int currentFirstItemScrollOffset4 = currentFirstItemScrollOffset3 + minOffset;
        int maxCrossAxis2 = 0;
        while (currentFirstItemScrollOffset4 < 0) {
            int other$iv = DataIndex.m847constructorimpl(0);
            if (currentFirstItemIndex2 - other$iv <= 0) {
                break;
            }
            int previous = DataIndex.m847constructorimpl(currentFirstItemIndex2 - 1);
            LazyMeasuredItem measuredItem = itemProvider.m882getAndMeasureZjPyQlc(previous);
            visibleItems.add(0, measuredItem);
            maxCrossAxis2 = Math.max(maxCrossAxis2, measuredItem.getCrossAxisSize());
            currentFirstItemScrollOffset4 += measuredItem.getSizeWithSpacings();
            currentFirstItemIndex2 = previous;
        }
        if (currentFirstItemScrollOffset4 < minOffset) {
            scrollDelta3 += currentFirstItemScrollOffset4;
            currentFirstItemScrollOffset4 = minOffset;
        }
        int currentFirstItemScrollOffset5 = currentFirstItemScrollOffset4 - minOffset;
        int index2 = currentFirstItemIndex2;
        int maxMainAxis = RangesKt.coerceAtLeast(mainAxisAvailableSize + afterContentPadding, 0);
        int currentMainAxisOffset2 = -currentFirstItemScrollOffset5;
        int size = visibleItems.size();
        int index$iv = currentFirstItemIndex2;
        for (int currentFirstItemIndex3 = 0; currentFirstItemIndex3 < size; currentFirstItemIndex3++) {
            Object item$iv = visibleItems.get(currentFirstItemIndex3);
            index2 = DataIndex.m847constructorimpl(index2 + 1);
            currentMainAxisOffset2 += ((LazyMeasuredItem) item$iv).getSizeWithSpacings();
        }
        int index3 = index2;
        int currentFirstItemIndex4 = index$iv;
        while (true) {
            if ((currentMainAxisOffset2 <= maxMainAxis || visibleItems.isEmpty()) && index3 < itemsCount) {
                LazyMeasuredItem measuredItem2 = itemProvider.m882getAndMeasureZjPyQlc(index3);
                currentMainAxisOffset2 += measuredItem2.getSizeWithSpacings();
                if (currentMainAxisOffset2 > minOffset || index3 == itemsCount - 1) {
                    maxCrossAxis2 = Math.max(maxCrossAxis2, measuredItem2.getCrossAxisSize());
                    visibleItems.add(measuredItem2);
                } else {
                    int arg0$iv = index3;
                    int i$iv = DataIndex.m847constructorimpl(arg0$iv + 1);
                    currentFirstItemIndex4 = i$iv;
                    currentFirstItemScrollOffset5 -= measuredItem2.getSizeWithSpacings();
                }
                index3 = DataIndex.m847constructorimpl(index3 + 1);
            }
        }
        if (currentMainAxisOffset2 >= mainAxisAvailableSize) {
            index = index3;
            scrollDelta = scrollDelta3;
            maxCrossAxis = maxCrossAxis2;
        } else {
            int toScrollBack = mainAxisAvailableSize - currentMainAxisOffset2;
            currentFirstItemScrollOffset5 -= toScrollBack;
            currentMainAxisOffset2 += toScrollBack;
            while (true) {
                if (currentFirstItemScrollOffset5 >= beforeContentPadding) {
                    currentFirstItemIndex = currentFirstItemIndex4;
                    index = index3;
                    break;
                }
                int other$iv2 = DataIndex.m847constructorimpl(0);
                if (currentFirstItemIndex4 - other$iv2 <= 0) {
                    currentFirstItemIndex = currentFirstItemIndex4;
                    index = index3;
                    break;
                }
                int previousIndex = DataIndex.m847constructorimpl(currentFirstItemIndex4 - 1);
                LazyMeasuredItem measuredItem3 = itemProvider.m882getAndMeasureZjPyQlc(previousIndex);
                visibleItems.add(0, measuredItem3);
                maxCrossAxis2 = Math.max(maxCrossAxis2, measuredItem3.getCrossAxisSize());
                currentFirstItemScrollOffset5 += measuredItem3.getSizeWithSpacings();
                currentFirstItemIndex4 = previousIndex;
                index3 = index3;
            }
            int scrollDelta4 = scrollDelta3 + toScrollBack;
            if (currentFirstItemScrollOffset5 >= 0) {
                scrollDelta = scrollDelta4;
                maxCrossAxis = maxCrossAxis2;
            } else {
                int scrollDelta5 = scrollDelta4 + currentFirstItemScrollOffset5;
                currentMainAxisOffset2 += currentFirstItemScrollOffset5;
                currentFirstItemScrollOffset5 = 0;
                scrollDelta = scrollDelta5;
                maxCrossAxis = maxCrossAxis2;
            }
        }
        float consumedScroll = (MathKt.getSign(MathKt.roundToInt(scrollToBeConsumed)) == MathKt.getSign(scrollDelta) && Math.abs(MathKt.roundToInt(scrollToBeConsumed)) >= Math.abs(scrollDelta)) ? scrollDelta : scrollToBeConsumed;
        if (!(currentFirstItemScrollOffset5 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int visibleItemsScrollOffset = -currentFirstItemScrollOffset5;
        LazyMeasuredItem firstItem3 = (LazyMeasuredItem) CollectionsKt.first(visibleItems);
        if (beforeContentPadding > 0 || spaceBetweenItems < 0) {
            int i2 = 0;
            int size2 = visibleItems.size();
            while (true) {
                if (i2 >= size2) {
                    firstItem = firstItem3;
                    break;
                }
                int size3 = ((LazyMeasuredItem) visibleItems.get(i2)).getSizeWithSpacings();
                if (currentFirstItemScrollOffset5 == 0 || size3 > currentFirstItemScrollOffset5) {
                    break;
                }
                firstItem = firstItem3;
                if (i2 == CollectionsKt.getLastIndex(visibleItems)) {
                    break;
                }
                currentFirstItemScrollOffset5 -= size3;
                firstItem3 = (LazyMeasuredItem) visibleItems.get(i2 + 1);
                i2++;
            }
            firstItem = firstItem3;
            currentFirstItemScrollOffset = currentFirstItemScrollOffset5;
            firstItem2 = firstItem;
        } else {
            firstItem2 = firstItem3;
            currentFirstItemScrollOffset = currentFirstItemScrollOffset5;
        }
        if (!beyondBoundsInfo.hasIntervals()) {
            lazyListBeyondBoundsInfo = beyondBoundsInfo;
            scrollDelta2 = scrollDelta;
        } else {
            lazyListBeyondBoundsInfo = beyondBoundsInfo;
            if (((LazyMeasuredItem) CollectionsKt.first(visibleItems)).getIndex() <= measureLazyList_nXYdgZc$startIndex(lazyListBeyondBoundsInfo, itemsCount)) {
                scrollDelta2 = scrollDelta;
            } else {
                List $this$measureLazyList_nXYdgZc_u24lambda_u2d1 = new ArrayList();
                extraItemsBefore = $this$measureLazyList_nXYdgZc_u24lambda_u2d1;
                int i3 = ((LazyMeasuredItem) CollectionsKt.first(visibleItems)).getIndex() - 1;
                int measureLazyList_nXYdgZc$startIndex = measureLazyList_nXYdgZc$startIndex(lazyListBeyondBoundsInfo, itemsCount);
                if (measureLazyList_nXYdgZc$startIndex <= i3) {
                    while (true) {
                        scrollDelta2 = scrollDelta;
                        $this$measureLazyList_nXYdgZc_u24lambda_u2d1.add(itemProvider.m882getAndMeasureZjPyQlc(DataIndex.m847constructorimpl(i3)));
                        if (i3 == measureLazyList_nXYdgZc$startIndex) {
                            break;
                        }
                        i3--;
                        scrollDelta = scrollDelta2;
                    }
                } else {
                    scrollDelta2 = scrollDelta;
                }
                Unit unit = Unit.INSTANCE;
                if (!beyondBoundsInfo.hasIntervals() && ((LazyMeasuredItem) CollectionsKt.last(visibleItems)).getIndex() < measureLazyList_nXYdgZc$endIndex(lazyListBeyondBoundsInfo, itemsCount)) {
                    List $this$measureLazyList_nXYdgZc_u24lambda_u2d2 = new ArrayList();
                    int i4 = ((LazyMeasuredItem) CollectionsKt.last(visibleItems)).getIndex();
                    for (int measureLazyList_nXYdgZc$endIndex = measureLazyList_nXYdgZc$endIndex(lazyListBeyondBoundsInfo, itemsCount); i4 < measureLazyList_nXYdgZc$endIndex; measureLazyList_nXYdgZc$endIndex = measureLazyList_nXYdgZc$endIndex) {
                        $this$measureLazyList_nXYdgZc_u24lambda_u2d2.add(itemProvider.m882getAndMeasureZjPyQlc(DataIndex.m847constructorimpl(i4 + 1)));
                        i4++;
                    }
                    Unit unit2 = Unit.INSTANCE;
                    extraItemsAfter = $this$measureLazyList_nXYdgZc_u24lambda_u2d2;
                } else {
                    extraItemsAfter = CollectionsKt.emptyList();
                }
                noExtraItems = !Intrinsics.areEqual(firstItem2, CollectionsKt.first(visibleItems)) && extraItemsBefore.isEmpty() && extraItemsAfter.isEmpty();
                int layoutWidth = ConstraintsKt.m4352constrainWidthK40F9xA(constraints, !isVertical ? maxCrossAxis : currentMainAxisOffset2);
                int layoutHeight = ConstraintsKt.m4351constrainHeightK40F9xA(constraints, !isVertical ? currentMainAxisOffset2 : maxCrossAxis);
                final List positionedItems = calculateItemsOffsets(visibleItems, extraItemsBefore, extraItemsAfter, layoutWidth, layoutHeight, currentMainAxisOffset2, mainAxisAvailableSize, visibleItemsScrollOffset, isVertical, verticalArrangement, horizontalArrangement, reverseLayout, density);
                LazyMeasuredItem firstItem4 = firstItem2;
                placementAnimator.onMeasured((int) consumedScroll, layoutWidth, layoutHeight, reverseLayout, positionedItems, itemProvider);
                if (headerIndexes.isEmpty()) {
                    lazyListPositionedItem = LazyListHeadersKt.findOrComposeLazyListHeader(positionedItems, itemProvider, headerIndexes, beforeContentPadding, layoutWidth, layoutHeight);
                } else {
                    lazyListPositionedItem = null;
                }
                final LazyListPositionedItem headerItem = lazyListPositionedItem;
                boolean z = currentMainAxisOffset2 <= mainAxisAvailableSize;
                MeasureResult invoke = layout.invoke(Integer.valueOf(layoutWidth), Integer.valueOf(layoutHeight), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$3
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
                    public final void invoke2(Placeable.PlacementScope invoke2) {
                        Intrinsics.checkNotNullParameter(invoke2, "$this$invoke");
                        List $this$fastForEach$iv = positionedItems;
                        LazyListPositionedItem lazyListPositionedItem2 = headerItem;
                        int size4 = $this$fastForEach$iv.size();
                        for (int index$iv2 = 0; index$iv2 < size4; index$iv2++) {
                            Object item$iv2 = $this$fastForEach$iv.get(index$iv2);
                            LazyListPositionedItem it = (LazyListPositionedItem) item$iv2;
                            if (it != lazyListPositionedItem2) {
                                it.place(invoke2);
                            }
                        }
                        LazyListPositionedItem lazyListPositionedItem3 = headerItem;
                        if (lazyListPositionedItem3 != null) {
                            lazyListPositionedItem3.place(invoke2);
                        }
                    }
                });
                int i5 = -beforeContentPadding;
                int maxMainAxis2 = mainAxisAvailableSize + afterContentPadding;
                if (noExtraItems) {
                    int $i$f$fastFilter = positionedItems.size();
                    ArrayList target$iv = new ArrayList($i$f$fastFilter);
                    List $this$fastForEach$iv$iv = positionedItems;
                    int size4 = $this$fastForEach$iv$iv.size();
                    i = i5;
                    int index$iv$iv = 0;
                    while (index$iv$iv < size4) {
                        LazyListPositionedItem lazyListPositionedItem2 = $this$fastForEach$iv$iv.get(index$iv$iv);
                        int i6 = size4;
                        List $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                        LazyListPositionedItem it = lazyListPositionedItem2;
                        int index4 = it.getIndex();
                        int currentMainAxisOffset3 = currentMainAxisOffset2;
                        int currentMainAxisOffset4 = ((LazyMeasuredItem) CollectionsKt.first(visibleItems)).getIndex();
                        if ((index4 >= currentMainAxisOffset4 && it.getIndex() <= ((LazyMeasuredItem) CollectionsKt.last(visibleItems)).getIndex()) || it == headerItem) {
                            target$iv.add(lazyListPositionedItem2);
                        }
                        index$iv$iv++;
                        $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                        size4 = i6;
                        currentMainAxisOffset2 = currentMainAxisOffset3;
                    }
                    currentMainAxisOffset = currentMainAxisOffset2;
                    list = target$iv;
                } else {
                    i = i5;
                    currentMainAxisOffset = currentMainAxisOffset2;
                    list = positionedItems;
                }
                int index5 = i;
                return new LazyListMeasureResult(firstItem4, currentFirstItemScrollOffset, z, consumedScroll, invoke, list, index5, maxMainAxis2, itemsCount, reverseLayout, !isVertical ? Orientation.Vertical : Orientation.Horizontal, afterContentPadding);
            }
        }
        extraItemsBefore = CollectionsKt.emptyList();
        if (!beyondBoundsInfo.hasIntervals()) {
        }
        extraItemsAfter = CollectionsKt.emptyList();
        noExtraItems = !Intrinsics.areEqual(firstItem2, CollectionsKt.first(visibleItems)) && extraItemsBefore.isEmpty() && extraItemsAfter.isEmpty();
        int layoutWidth2 = ConstraintsKt.m4352constrainWidthK40F9xA(constraints, !isVertical ? maxCrossAxis : currentMainAxisOffset2);
        int layoutHeight2 = ConstraintsKt.m4351constrainHeightK40F9xA(constraints, !isVertical ? currentMainAxisOffset2 : maxCrossAxis);
        final List<LazyListPositionedItem> positionedItems2 = calculateItemsOffsets(visibleItems, extraItemsBefore, extraItemsAfter, layoutWidth2, layoutHeight2, currentMainAxisOffset2, mainAxisAvailableSize, visibleItemsScrollOffset, isVertical, verticalArrangement, horizontalArrangement, reverseLayout, density);
        LazyMeasuredItem firstItem42 = firstItem2;
        placementAnimator.onMeasured((int) consumedScroll, layoutWidth2, layoutHeight2, reverseLayout, positionedItems2, itemProvider);
        if (headerIndexes.isEmpty()) {
        }
        final LazyListPositionedItem headerItem2 = lazyListPositionedItem;
        if (currentMainAxisOffset2 <= mainAxisAvailableSize) {
        }
        MeasureResult invoke2 = layout.invoke(Integer.valueOf(layoutWidth2), Integer.valueOf(layoutHeight2), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$3
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
            public final void invoke2(Placeable.PlacementScope invoke22) {
                Intrinsics.checkNotNullParameter(invoke22, "$this$invoke");
                List $this$fastForEach$iv = positionedItems2;
                LazyListPositionedItem lazyListPositionedItem22 = headerItem2;
                int size42 = $this$fastForEach$iv.size();
                for (int index$iv2 = 0; index$iv2 < size42; index$iv2++) {
                    Object item$iv2 = $this$fastForEach$iv.get(index$iv2);
                    LazyListPositionedItem it2 = (LazyListPositionedItem) item$iv2;
                    if (it2 != lazyListPositionedItem22) {
                        it2.place(invoke22);
                    }
                }
                LazyListPositionedItem lazyListPositionedItem3 = headerItem2;
                if (lazyListPositionedItem3 != null) {
                    lazyListPositionedItem3.place(invoke22);
                }
            }
        });
        int i52 = -beforeContentPadding;
        int maxMainAxis22 = mainAxisAvailableSize + afterContentPadding;
        if (noExtraItems) {
        }
        int index52 = i;
        return new LazyListMeasureResult(firstItem42, currentFirstItemScrollOffset, z, consumedScroll, invoke2, list, index52, maxMainAxis22, itemsCount, reverseLayout, !isVertical ? Orientation.Vertical : Orientation.Horizontal, afterContentPadding);
    }

    private static final int measureLazyList_nXYdgZc$startIndex(LazyListBeyondBoundsInfo $this$measureLazyList_nXYdgZc_u24startIndex, int $itemsCount) {
        return Math.min($this$measureLazyList_nXYdgZc_u24startIndex.getStart(), $itemsCount - 1);
    }

    private static final int measureLazyList_nXYdgZc$endIndex(LazyListBeyondBoundsInfo $this$measureLazyList_nXYdgZc_u24endIndex, int $itemsCount) {
        return Math.min($this$measureLazyList_nXYdgZc_u24endIndex.getEnd(), $itemsCount - 1);
    }

    private static final List<LazyListPositionedItem> calculateItemsOffsets(List<LazyMeasuredItem> list, List<LazyMeasuredItem> list2, List<LazyMeasuredItem> list3, int layoutWidth, int layoutHeight, int finalMainAxisOffset, int maxOffset, int itemsScrollOffset, boolean isVertical, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, boolean reverseLayout, Density density) {
        int[] offsets;
        int i;
        List<LazyMeasuredItem> list4 = list;
        boolean z = reverseLayout;
        int mainAxisLayoutSize = isVertical ? layoutHeight : layoutWidth;
        boolean hasSpareSpace = finalMainAxisOffset < Math.min(mainAxisLayoutSize, maxOffset);
        if (hasSpareSpace) {
            if (!(itemsScrollOffset == 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        ArrayList positionedItems = new ArrayList(list.size() + list2.size() + list3.size());
        if (hasSpareSpace) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            int itemsCount = list.size();
            int[] sizes = new int[itemsCount];
            for (int i2 = 0; i2 < itemsCount; i2++) {
                sizes[i2] = list4.get(calculateItemsOffsets$reverseAware(i2, z, itemsCount)).getSize();
            }
            int[] offsets2 = new int[itemsCount];
            for (int i3 = 0; i3 < itemsCount; i3++) {
                offsets2[i3] = 0;
            }
            if (isVertical) {
                if (verticalArrangement == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                verticalArrangement.arrange(density, mainAxisLayoutSize, sizes, offsets2);
                offsets = offsets2;
            } else {
                if (horizontalArrangement == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                offsets = offsets2;
                horizontalArrangement.arrange(density, mainAxisLayoutSize, sizes, LayoutDirection.Ltr, offsets);
            }
            IntRange reverseAwareOffsetIndices = ArraysKt.getIndices(offsets);
            if (z) {
                reverseAwareOffsetIndices = RangesKt.reversed(reverseAwareOffsetIndices);
            }
            int index = reverseAwareOffsetIndices.getFirst();
            int last = reverseAwareOffsetIndices.getLast();
            int step = reverseAwareOffsetIndices.getStep();
            if ((step > 0 && index <= last) || (step < 0 && last <= index)) {
                while (true) {
                    int absoluteOffset = offsets[index];
                    LazyMeasuredItem item = list4.get(calculateItemsOffsets$reverseAware(index, z, itemsCount));
                    if (z) {
                        i = (mainAxisLayoutSize - absoluteOffset) - item.getSize();
                    } else {
                        i = absoluteOffset;
                    }
                    int relativeOffset = i;
                    positionedItems.add(item.position(relativeOffset, layoutWidth, layoutHeight));
                    if (index == last) {
                        break;
                    }
                    index += step;
                    list4 = list;
                    z = reverseLayout;
                }
            }
        } else {
            int currentMainAxis = itemsScrollOffset;
            int size = list2.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = list2.get(index$iv);
                LazyMeasuredItem it = (LazyMeasuredItem) item$iv;
                currentMainAxis -= it.getSizeWithSpacings();
                positionedItems.add(it.position(currentMainAxis, layoutWidth, layoutHeight));
            }
            int currentMainAxis2 = itemsScrollOffset;
            int size2 = list.size();
            for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                Object item$iv2 = list.get(index$iv2);
                LazyMeasuredItem it2 = (LazyMeasuredItem) item$iv2;
                positionedItems.add(it2.position(currentMainAxis2, layoutWidth, layoutHeight));
                currentMainAxis2 += it2.getSizeWithSpacings();
            }
            int size3 = list3.size();
            for (int index$iv3 = 0; index$iv3 < size3; index$iv3++) {
                Object item$iv3 = list3.get(index$iv3);
                LazyMeasuredItem it3 = (LazyMeasuredItem) item$iv3;
                positionedItems.add(it3.position(currentMainAxis2, layoutWidth, layoutHeight));
                currentMainAxis2 += it3.getSizeWithSpacings();
            }
        }
        return positionedItems;
    }

    private static final int calculateItemsOffsets$reverseAware(int $this$calculateItemsOffsets_u24reverseAware, boolean $reverseLayout, int itemsCount) {
        return !$reverseLayout ? $this$calculateItemsOffsets_u24reverseAware : (itemsCount - $this$calculateItemsOffsets_u24reverseAware) - 1;
    }
}
