package androidx.compose.foundation.lazy.grid;

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

/* compiled from: LazyGridMeasure.kt */
@Metadata(m286d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ap\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001aÚ\u0001\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2/\u0010+\u001a+\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-¢\u0006\u0002\b0\u0012\u0004\u0012\u0002010,H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00064"}, m287d2 = {"calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "lines", "", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredLine;", "layoutWidth", "", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredLineProvider;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "Landroidx/compose/foundation/lazy/grid/LineIndex;", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-0cYbdkg", "(ILandroidx/compose/foundation/lazy/grid/LazyMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyGridMeasureKt {
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01ee, code lost:
    
        r29 = r0;
     */
    /* renamed from: measureLazyGrid-0cYbdkg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final LazyGridMeasureResult m928measureLazyGrid0cYbdkg(int itemsCount, LazyMeasuredLineProvider measuredLineProvider, LazyMeasuredItemProvider measuredItemProvider, int mainAxisAvailableSize, int beforeContentPadding, int afterContentPadding, int spaceBetweenLines, int firstVisibleLineIndex, int firstVisibleLineScrollOffset, float scrollToBeConsumed, long constraints, boolean isVertical, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, boolean reverseLayout, Density density, LazyGridItemPlacementAnimator placementAnimator, LazyGridSpanLayoutProvider spanLayoutProvider, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        boolean z;
        int toScrollBack;
        int currentMainAxisOffset;
        int scrollDelta;
        LazyMeasuredLine firstLine;
        int currentFirstLineScrollOffset;
        long j;
        int layoutWidth;
        int layoutHeight;
        LazyMeasuredLineProvider measuredLineProvider2 = measuredLineProvider;
        int i = beforeContentPadding;
        Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> layout = function3;
        Intrinsics.checkNotNullParameter(measuredLineProvider2, "measuredLineProvider");
        Intrinsics.checkNotNullParameter(measuredItemProvider, "measuredItemProvider");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(placementAnimator, "placementAnimator");
        Intrinsics.checkNotNullParameter(spanLayoutProvider, "spanLayoutProvider");
        Intrinsics.checkNotNullParameter(layout, "layout");
        if (!(i >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(afterContentPadding >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (itemsCount <= 0) {
            return new LazyGridMeasureResult(null, 0, false, 0.0f, layout.invoke(Integer.valueOf(Constraints.m4340getMinWidthimpl(constraints)), Integer.valueOf(Constraints.m4339getMinHeightimpl(constraints)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                }
            }), CollectionsKt.emptyList(), -i, mainAxisAvailableSize + afterContentPadding, 0, reverseLayout, isVertical ? Orientation.Vertical : Orientation.Horizontal, afterContentPadding);
        }
        int currentFirstLineIndex = firstVisibleLineIndex;
        int scrollDelta2 = MathKt.roundToInt(scrollToBeConsumed);
        int currentFirstLineScrollOffset2 = firstVisibleLineScrollOffset - scrollDelta2;
        if (LineIndex.m951equalsimpl0(currentFirstLineIndex, LineIndex.m948constructorimpl(0)) && currentFirstLineScrollOffset2 < 0) {
            scrollDelta2 += currentFirstLineScrollOffset2;
            currentFirstLineScrollOffset2 = 0;
        }
        List visibleLines = new ArrayList();
        int minOffset = (-i) + (spaceBetweenLines < 0 ? spaceBetweenLines : 0);
        int maxOffset = mainAxisAvailableSize;
        int currentFirstLineScrollOffset3 = currentFirstLineScrollOffset2 + minOffset;
        while (currentFirstLineScrollOffset3 < 0) {
            int other$iv = LineIndex.m948constructorimpl(0);
            if (currentFirstLineIndex - other$iv <= 0) {
                break;
            }
            int previous = LineIndex.m948constructorimpl(currentFirstLineIndex - 1);
            LazyMeasuredLine measuredLine = measuredLineProvider2.m945getAndMeasurebKFJvoY(previous);
            visibleLines.add(0, measuredLine);
            currentFirstLineScrollOffset3 += measuredLine.getMainAxisSizeWithSpacings();
            currentFirstLineIndex = previous;
        }
        if (currentFirstLineScrollOffset3 < minOffset) {
            scrollDelta2 += currentFirstLineScrollOffset3;
            currentFirstLineScrollOffset3 = minOffset;
        }
        int currentFirstLineScrollOffset4 = currentFirstLineScrollOffset3 - minOffset;
        int index = currentFirstLineIndex;
        int maxMainAxis = RangesKt.coerceAtLeast(maxOffset + afterContentPadding, 0);
        int currentMainAxisOffset2 = -currentFirstLineScrollOffset4;
        int size = visibleLines.size();
        int index$iv = currentFirstLineIndex;
        for (int currentFirstLineIndex2 = 0; currentFirstLineIndex2 < size; currentFirstLineIndex2++) {
            Object item$iv = visibleLines.get(currentFirstLineIndex2);
            LazyMeasuredLine it = (LazyMeasuredLine) item$iv;
            index = LineIndex.m948constructorimpl(index + 1);
            currentMainAxisOffset2 += it.getMainAxisSizeWithSpacings();
        }
        int currentFirstLineIndex3 = index$iv;
        while (true) {
            if (currentMainAxisOffset2 > maxMainAxis && !visibleLines.isEmpty()) {
                break;
            }
            LazyMeasuredLine measuredLine2 = measuredLineProvider2.m945getAndMeasurebKFJvoY(index);
            if (measuredLine2.isEmpty()) {
                int arg0$iv = index;
                LineIndex.m948constructorimpl(arg0$iv - 1);
                break;
            }
            int maxMainAxis2 = maxMainAxis;
            int maxOffset2 = maxOffset;
            int minOffset2 = minOffset;
            List visibleLines2 = visibleLines;
            currentMainAxisOffset2 += measuredLine2.getMainAxisSizeWithSpacings();
            if (currentMainAxisOffset2 > minOffset2 || ((LazyMeasuredItem) ArraysKt.last(measuredLine2.getItems())).getIndex() == itemsCount - 1) {
                visibleLines2.add(measuredLine2);
            } else {
                int arg0$iv2 = index;
                int i$iv = LineIndex.m948constructorimpl(arg0$iv2 + 1);
                currentFirstLineIndex3 = i$iv;
                currentFirstLineScrollOffset4 -= measuredLine2.getMainAxisSizeWithSpacings();
            }
            index = LineIndex.m948constructorimpl(index + 1);
            layout = function3;
            minOffset = minOffset2;
            visibleLines = visibleLines2;
            maxMainAxis = maxMainAxis2;
            maxOffset = maxOffset2;
            measuredLineProvider2 = measuredLineProvider;
            i = beforeContentPadding;
        }
        if (currentMainAxisOffset2 >= maxOffset) {
            z = false;
            toScrollBack = scrollDelta2;
            currentMainAxisOffset = currentMainAxisOffset2;
        } else {
            int toScrollBack2 = maxOffset - currentMainAxisOffset2;
            currentFirstLineScrollOffset4 -= toScrollBack2;
            int currentMainAxisOffset3 = currentMainAxisOffset2 + toScrollBack2;
            while (true) {
                if (currentFirstLineScrollOffset4 >= i) {
                    z = false;
                    break;
                }
                int other$iv2 = LineIndex.m948constructorimpl(0);
                if (currentFirstLineIndex3 - other$iv2 <= 0) {
                    z = false;
                    break;
                }
                int previousIndex = LineIndex.m948constructorimpl(currentFirstLineIndex3 - 1);
                LazyMeasuredLine measuredLine3 = measuredLineProvider2.m945getAndMeasurebKFJvoY(previousIndex);
                visibleLines.add(0, measuredLine3);
                currentFirstLineScrollOffset4 += measuredLine3.getMainAxisSizeWithSpacings();
                currentFirstLineIndex3 = previousIndex;
            }
            int scrollDelta3 = scrollDelta2 + toScrollBack2;
            if (currentFirstLineScrollOffset4 < 0) {
                int scrollDelta4 = scrollDelta3 + currentFirstLineScrollOffset4;
                int currentMainAxisOffset4 = currentMainAxisOffset3 + currentFirstLineScrollOffset4;
                currentFirstLineScrollOffset4 = 0;
                toScrollBack = scrollDelta4;
                currentMainAxisOffset = currentMainAxisOffset4;
            } else {
                toScrollBack = scrollDelta3;
                currentMainAxisOffset = currentMainAxisOffset3;
            }
        }
        float consumedScroll = (MathKt.getSign(MathKt.roundToInt(scrollToBeConsumed)) == MathKt.getSign(toScrollBack) && Math.abs(MathKt.roundToInt(scrollToBeConsumed)) >= Math.abs(toScrollBack)) ? toScrollBack : scrollToBeConsumed;
        if (!(currentFirstLineScrollOffset4 >= 0 ? true : z)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int visibleLinesScrollOffset = -currentFirstLineScrollOffset4;
        LazyMeasuredLine firstLine2 = (LazyMeasuredLine) CollectionsKt.first(visibleLines);
        if (i > 0 || spaceBetweenLines < 0) {
            int i2 = 0;
            int size2 = visibleLines.size();
            while (true) {
                if (i2 >= size2) {
                    scrollDelta = toScrollBack;
                    break;
                }
                int size3 = ((LazyMeasuredLine) visibleLines.get(i2)).getMainAxisSizeWithSpacings();
                if (currentFirstLineScrollOffset4 == 0 || size3 > currentFirstLineScrollOffset4) {
                    break;
                }
                scrollDelta = toScrollBack;
                if (i2 == CollectionsKt.getLastIndex(visibleLines)) {
                    break;
                }
                currentFirstLineScrollOffset4 -= size3;
                firstLine2 = (LazyMeasuredLine) visibleLines.get(i2 + 1);
                i2++;
                toScrollBack = scrollDelta;
            }
            firstLine = firstLine2;
            currentFirstLineScrollOffset = currentFirstLineScrollOffset4;
        } else {
            scrollDelta = toScrollBack;
            firstLine = firstLine2;
            currentFirstLineScrollOffset = currentFirstLineScrollOffset4;
        }
        if (isVertical) {
            j = constraints;
            layoutWidth = Constraints.m4338getMaxWidthimpl(constraints);
        } else {
            j = constraints;
            layoutWidth = ConstraintsKt.m4352constrainWidthK40F9xA(j, currentMainAxisOffset);
        }
        if (isVertical) {
            layoutHeight = ConstraintsKt.m4351constrainHeightK40F9xA(j, currentMainAxisOffset);
        } else {
            layoutHeight = Constraints.m4337getMaxHeightimpl(constraints);
        }
        Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function32 = layout;
        final List positionedItems = calculateItemsOffsets(visibleLines, layoutWidth, layoutHeight, currentMainAxisOffset, maxOffset, visibleLinesScrollOffset, isVertical, verticalArrangement, horizontalArrangement, reverseLayout, density);
        int currentMainAxisOffset5 = currentMainAxisOffset;
        placementAnimator.onMeasured((int) consumedScroll, layoutWidth, layoutHeight, reverseLayout, positionedItems, measuredItemProvider, spanLayoutProvider);
        return new LazyGridMeasureResult(firstLine, currentFirstLineScrollOffset, currentMainAxisOffset5 > maxOffset, consumedScroll, function32.invoke(Integer.valueOf(layoutWidth), Integer.valueOf(layoutHeight), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$3
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
            public final void invoke2(Placeable.PlacementScope invoke) {
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                List $this$fastForEach$iv = positionedItems;
                int size4 = $this$fastForEach$iv.size();
                for (int index$iv2 = 0; index$iv2 < size4; index$iv2++) {
                    Object item$iv2 = $this$fastForEach$iv.get(index$iv2);
                    LazyGridPositionedItem it2 = (LazyGridPositionedItem) item$iv2;
                    it2.place(invoke);
                }
            }
        }), positionedItems, -i, mainAxisAvailableSize + afterContentPadding, itemsCount, reverseLayout, isVertical ? Orientation.Vertical : Orientation.Horizontal, afterContentPadding);
    }

    private static final List<LazyGridPositionedItem> calculateItemsOffsets(List<LazyMeasuredLine> list, int layoutWidth, int layoutHeight, int finalMainAxisOffset, int maxOffset, int firstLineScrollOffset, boolean isVertical, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, boolean reverseLayout, Density density) {
        int[] offsets;
        int i;
        List<LazyMeasuredLine> list2 = list;
        int i2 = layoutWidth;
        int mainAxisLayoutSize = isVertical ? layoutHeight : i2;
        boolean hasSpareSpace = finalMainAxisOffset < Math.min(mainAxisLayoutSize, maxOffset);
        if (hasSpareSpace) {
            if (!(firstLineScrollOffset == 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        int sum$iv = 0;
        int size = list.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            Object item$iv$iv = list.get(index$iv$iv);
            sum$iv += ((LazyMeasuredLine) item$iv$iv).getItems().length;
        }
        ArrayList positionedItems = new ArrayList(sum$iv);
        if (hasSpareSpace) {
            int linesCount = list.size();
            int[] sizes = new int[linesCount];
            for (int i3 = 0; i3 < linesCount; i3++) {
                sizes[i3] = list2.get(calculateItemsOffsets$reverseAware(i3, reverseLayout, linesCount)).getMainAxisSize();
            }
            int[] offsets2 = new int[linesCount];
            for (int i4 = 0; i4 < linesCount; i4++) {
                offsets2[i4] = 0;
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
            if (reverseLayout) {
                reverseAwareOffsetIndices = RangesKt.reversed(reverseAwareOffsetIndices);
            }
            int index = reverseAwareOffsetIndices.getFirst();
            int last = reverseAwareOffsetIndices.getLast();
            int step = reverseAwareOffsetIndices.getStep();
            if ((step > 0 && index <= last) || (step < 0 && last <= index)) {
                while (true) {
                    int absoluteOffset = offsets[index];
                    LazyMeasuredLine line = list2.get(calculateItemsOffsets$reverseAware(index, reverseLayout, linesCount));
                    if (reverseLayout) {
                        i = (mainAxisLayoutSize - absoluteOffset) - line.getMainAxisSize();
                    } else {
                        i = absoluteOffset;
                    }
                    int relativeOffset = i;
                    positionedItems.addAll(line.position(relativeOffset, i2, layoutHeight));
                    if (index == last) {
                        break;
                    }
                    index += step;
                    list2 = list;
                }
            }
        } else {
            int currentMainAxis = firstLineScrollOffset;
            int index$iv = 0;
            int size2 = list.size();
            while (index$iv < size2) {
                Object item$iv = list.get(index$iv);
                LazyMeasuredLine it = (LazyMeasuredLine) item$iv;
                positionedItems.addAll(it.position(currentMainAxis, i2, layoutHeight));
                currentMainAxis += it.getMainAxisSizeWithSpacings();
                index$iv++;
                i2 = layoutWidth;
            }
        }
        return positionedItems;
    }

    private static final int calculateItemsOffsets$reverseAware(int $this$calculateItemsOffsets_u24reverseAware, boolean $reverseLayout, int linesCount) {
        return !$reverseLayout ? $this$calculateItemsOffsets_u24reverseAware : (linesCount - $this$calculateItemsOffsets_u24reverseAware) - 1;
    }
}
