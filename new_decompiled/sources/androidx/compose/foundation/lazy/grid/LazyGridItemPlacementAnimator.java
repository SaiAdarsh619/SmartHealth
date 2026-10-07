package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.IntOffsetKt;
import androidx.compose.p000ui.unit.IntSize;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyGridItemPlacementAnimator.kt */
@Metadata(m286d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006Jc\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%J;\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-JD\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00052\f\u00103\u001a\b\u0012\u0004\u0012\u00020!042\u0006\u00105\u001a\u0002062\u0006\u0010\"\u001a\u00020#J\u0006\u00107\u001a\u00020/J\u0018\u00108\u001a\u00020/2\u0006\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020\fH\u0002J\u001c\u0010;\u001a\u00020\u0014*\u00020\tH\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\t*\u00020\u00148BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006>"}, m287d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isVertical", "", "(Lkotlinx/coroutines/CoroutineScope;Z)V", "keyToIndexMap", "", "", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/grid/ItemInfo;", "positionedKeys", "", "viewportEndItemIndex", "viewportEndItemNotVisiblePartSize", "viewportStartItemIndex", "viewportStartItemNotVisiblePartSize", "mainAxis", "Landroidx/compose/ui/unit/IntOffset;", "getMainAxis--gyyYBs", "(J)I", "calculateExpectedOffset", "index", "mainAxisSizeWithSpacings", "averageLineMainAxisSize", "scrolledBy", "reverseLayout", "mainAxisLayoutSize", "fallback", "visibleItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "calculateExpectedOffset-xfIKQeg", "(IIIJZIILjava/util/List;Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;)I", "getAnimatedOffset", "key", "placeableIndex", "minOffset", "maxOffset", "rawOffset", "getAnimatedOffset-YT5a7pE", "(Ljava/lang/Object;IIIJ)J", "onMeasured", "", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;", "reset", "startAnimationsIfNeeded", "item", "itemInfo", "toOffset", "toOffset-Bjo55l4", "(I)J", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyGridItemPlacementAnimator {
    private final boolean isVertical;
    private Map<Object, Integer> keyToIndexMap;
    private final Map<Object, ItemInfo> keyToItemInfoMap;
    private final Set<Object> positionedKeys;
    private final CoroutineScope scope;
    private int viewportEndItemIndex;
    private int viewportEndItemNotVisiblePartSize;
    private int viewportStartItemIndex;
    private int viewportStartItemNotVisiblePartSize;

    public LazyGridItemPlacementAnimator(CoroutineScope scope, boolean isVertical) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this.isVertical = isVertical;
        this.keyToItemInfoMap = new LinkedHashMap();
        this.keyToIndexMap = MapsKt.emptyMap();
        this.viewportStartItemIndex = -1;
        this.viewportEndItemIndex = -1;
        this.positionedKeys = new LinkedHashSet();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x03a5 A[LOOP:7: B:96:0x0349->B:103:0x03a5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x03a2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, boolean reverseLayout, List<LazyGridPositionedItem> positionedItems, LazyMeasuredItemProvider measuredItemProvider, LazyGridSpanLayoutProvider spanLayoutProvider) {
        List $this$fastAny$iv;
        boolean withinBounds;
        boolean z;
        long m4347fixedHeightOenEA2s;
        int targetOffset;
        int $i$f$fastAny;
        int $i$f$fastAny2;
        int index$iv;
        int i;
        List $this$fastForEach$iv;
        int fallback;
        long offset;
        ItemInfo newItemInfo;
        LazyGridPositionedItem item;
        ItemInfo itemInfo;
        int targetPlaceableOffsetMainAxis;
        long targetPlaceableOffset;
        final List<LazyGridPositionedItem> positionedItems2 = positionedItems;
        Intrinsics.checkNotNullParameter(positionedItems2, "positionedItems");
        Intrinsics.checkNotNullParameter(measuredItemProvider, "measuredItemProvider");
        Intrinsics.checkNotNullParameter(spanLayoutProvider, "spanLayoutProvider");
        int index$iv$iv = 0;
        int size = positionedItems.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = positionedItems.get(index$iv$iv);
                if (((LazyGridPositionedItem) item$iv$iv).getHasAnimations()) {
                    $this$fastAny$iv = 1;
                    break;
                }
                index$iv$iv++;
            } else {
                $this$fastAny$iv = null;
                break;
            }
        }
        if ($this$fastAny$iv == null) {
            reset();
            return;
        }
        int mainAxisLayoutSize = this.isVertical ? layoutHeight : layoutWidth;
        long notAnimatableDelta = m921toOffsetBjo55l4(reverseLayout ? -consumedScroll : consumedScroll);
        LazyGridPositionedItem newFirstItem = (LazyGridPositionedItem) CollectionsKt.first((List) positionedItems);
        LazyGridPositionedItem newLastItem = (LazyGridPositionedItem) CollectionsKt.last((List) positionedItems);
        int size2 = positionedItems.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv = positionedItems.get(index$iv2);
            LazyGridPositionedItem item2 = (LazyGridPositionedItem) item$iv;
            ItemInfo itemInfo2 = this.keyToItemInfoMap.get(item2.getKey());
            if (itemInfo2 != null) {
                itemInfo2.setIndex(item2.getIndex());
                itemInfo2.setCrossAxisSize(item2.getCrossAxisSize());
                itemInfo2.setCrossAxisOffset(item2.getCrossAxisOffset());
            }
        }
        final LazyGridItemPlacementAnimator $this$onMeasured_u24lambda_u2d2 = this;
        Function1 lineOf = new Function1<Integer, Integer>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Integer invoke(int it) {
                boolean z2;
                z2 = LazyGridItemPlacementAnimator.this.isVertical;
                return Integer.valueOf(z2 ? positionedItems2.get(it).getRow() : positionedItems2.get(it).getColumn());
            }
        };
        int totalLinesMainAxisSize = 0;
        int linesCount = 0;
        int lineStartIndex = 0;
        while (lineStartIndex < positionedItems.size()) {
            int currentLine = lineOf.invoke(Integer.valueOf(lineStartIndex)).intValue();
            if (currentLine == -1) {
                lineStartIndex++;
            } else {
                int lineMainAxisSize = 0;
                int lineEndIndex = lineStartIndex;
                while (lineEndIndex < positionedItems.size() && lineOf.invoke(Integer.valueOf(lineEndIndex)).intValue() == currentLine) {
                    lineMainAxisSize = Math.max(lineMainAxisSize, positionedItems2.get(lineEndIndex).getMainAxisSizeWithSpacings());
                    lineEndIndex++;
                }
                totalLinesMainAxisSize += lineMainAxisSize;
                linesCount++;
                lineStartIndex = lineEndIndex;
            }
        }
        int averageLineMainAxisSize = totalLinesMainAxisSize / linesCount;
        this.positionedKeys.clear();
        List $this$fastForEach$iv2 = positionedItems;
        int size3 = $this$fastForEach$iv2.size();
        int index$iv3 = 0;
        while (index$iv3 < size3) {
            Object item$iv2 = $this$fastForEach$iv2.get(index$iv3);
            LazyGridPositionedItem item3 = (LazyGridPositionedItem) item$iv2;
            this.positionedKeys.add(item3.getKey());
            ItemInfo itemInfo3 = this.keyToItemInfoMap.get(item3.getKey());
            if (itemInfo3 != null) {
                index$iv = index$iv3;
                i = size3;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                if (item3.getHasAnimations()) {
                    long arg0$iv = itemInfo3.getNotAnimatableDelta();
                    itemInfo3.m910setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(arg0$iv) + IntOffset.m4500getXimpl(notAnimatableDelta), IntOffset.m4501getYimpl(arg0$iv) + IntOffset.m4501getYimpl(notAnimatableDelta)));
                    startAnimationsIfNeeded(item3, itemInfo3);
                } else {
                    this.keyToItemInfoMap.remove(item3.getKey());
                }
            } else if (item3.getHasAnimations()) {
                ItemInfo newItemInfo2 = new ItemInfo(item3.getIndex(), item3.getCrossAxisSize(), item3.getCrossAxisOffset());
                Integer previousIndex = this.keyToIndexMap.get(item3.getKey());
                long offset2 = item3.getPlaceableOffset();
                if (previousIndex == null) {
                    offset = offset2;
                    newItemInfo = newItemInfo2;
                    item = item3;
                    itemInfo = itemInfo3;
                    index$iv = index$iv3;
                    i = size3;
                    targetPlaceableOffsetMainAxis = m920getMainAxisgyyYBs(offset2);
                    $this$fastForEach$iv = $this$fastForEach$iv2;
                } else {
                    if (!reverseLayout) {
                        fallback = m920getMainAxisgyyYBs(offset2);
                    } else {
                        fallback = m920getMainAxisgyyYBs(offset2) - item3.getMainAxisSizeWithSpacings();
                    }
                    offset = offset2;
                    newItemInfo = newItemInfo2;
                    item = item3;
                    itemInfo = itemInfo3;
                    index$iv = index$iv3;
                    i = size3;
                    $this$fastForEach$iv = $this$fastForEach$iv2;
                    targetPlaceableOffsetMainAxis = m919calculateExpectedOffsetxfIKQeg(previousIndex.intValue(), item3.getMainAxisSizeWithSpacings(), averageLineMainAxisSize, notAnimatableDelta, reverseLayout, mainAxisLayoutSize, fallback, positionedItems, spanLayoutProvider);
                }
                if (this.isVertical) {
                    targetPlaceableOffset = IntOffset.m4496copyiSbpLlY$default(offset, 0, targetPlaceableOffsetMainAxis, 1, null);
                } else {
                    targetPlaceableOffset = IntOffset.m4496copyiSbpLlY$default(offset, targetPlaceableOffsetMainAxis, 0, 2, null);
                }
                int placeablesCount = item.getPlaceablesCount();
                int i2 = 0;
                while (i2 < placeablesCount) {
                    int placeableIndex = i2;
                    int i3 = placeablesCount;
                    newItemInfo.getPlaceables().add(new PlaceableInfo(targetPlaceableOffset, item.getMainAxisSize(placeableIndex), null));
                    Unit unit = Unit.INSTANCE;
                    i2++;
                    placeablesCount = i3;
                }
                LazyGridPositionedItem item4 = item;
                ItemInfo newItemInfo3 = newItemInfo;
                this.keyToItemInfoMap.put(item4.getKey(), newItemInfo3);
                startAnimationsIfNeeded(item4, newItemInfo3);
            } else {
                index$iv = index$iv3;
                i = size3;
                $this$fastForEach$iv = $this$fastForEach$iv2;
            }
            index$iv3 = index$iv + 1;
            size3 = i;
            $this$fastForEach$iv2 = $this$fastForEach$iv;
        }
        if (!reverseLayout) {
            this.viewportStartItemIndex = newFirstItem.getIndex();
            this.viewportStartItemNotVisiblePartSize = m920getMainAxisgyyYBs(newFirstItem.getOffset());
            this.viewportEndItemIndex = newLastItem.getIndex();
            this.viewportEndItemNotVisiblePartSize = (m920getMainAxisgyyYBs(newLastItem.getOffset()) + newLastItem.getLineMainAxisSizeWithSpacings()) - mainAxisLayoutSize;
        } else {
            this.viewportStartItemIndex = newLastItem.getIndex();
            this.viewportStartItemNotVisiblePartSize = (mainAxisLayoutSize - m920getMainAxisgyyYBs(newLastItem.getOffset())) - newLastItem.getLineMainAxisSize();
            this.viewportEndItemIndex = newFirstItem.getIndex();
            int i4 = -m920getMainAxisgyyYBs(newFirstItem.getOffset());
            int lineMainAxisSizeWithSpacings = newFirstItem.getLineMainAxisSizeWithSpacings();
            boolean z2 = this.isVertical;
            long size4 = newFirstItem.getSize();
            this.viewportEndItemNotVisiblePartSize = i4 + (lineMainAxisSizeWithSpacings - (z2 ? IntSize.m4541getHeightimpl(size4) : IntSize.m4542getWidthimpl(size4)));
        }
        Iterator iterator = this.keyToItemInfoMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, ItemInfo> entry = iterator.next();
            if (!this.positionedKeys.contains(entry.getKey())) {
                ItemInfo itemInfo4 = entry.getValue();
                long arg0$iv2 = itemInfo4.getNotAnimatableDelta();
                itemInfo4.m910setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(arg0$iv2) + IntOffset.m4500getXimpl(notAnimatableDelta), IntOffset.m4501getYimpl(arg0$iv2) + IntOffset.m4501getYimpl(notAnimatableDelta)));
                Integer index = measuredItemProvider.getKeyToIndexMap().get(entry.getKey());
                List $this$fastAny$iv2 = itemInfo4.getPlaceables();
                int $i$f$fastAny3 = 0;
                int index$iv$iv2 = 0;
                int size5 = $this$fastAny$iv2.size();
                while (true) {
                    if (index$iv$iv2 < size5) {
                        Object item$iv$iv2 = $this$fastAny$iv2.get(index$iv$iv2);
                        PlaceableInfo it = (PlaceableInfo) item$iv$iv2;
                        long arg0$iv3 = it.getTargetOffset();
                        long other$iv = itemInfo4.getNotAnimatableDelta();
                        Map.Entry entry2 = entry;
                        List $this$fastAny$iv3 = $this$fastAny$iv2;
                        long arg0$iv4 = IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(arg0$iv3) + IntOffset.m4500getXimpl(other$iv), IntOffset.m4501getYimpl(arg0$iv3) + IntOffset.m4501getYimpl(other$iv));
                        int $i$f$fastAny4 = $i$f$fastAny3;
                        if (m920getMainAxisgyyYBs(arg0$iv4) + it.getMainAxisSize() <= 0) {
                            $i$f$fastAny = $i$f$fastAny4;
                        } else {
                            $i$f$fastAny = $i$f$fastAny4;
                            int $i$f$fastAny5 = m920getMainAxisgyyYBs(arg0$iv4);
                            if ($i$f$fastAny5 < mainAxisLayoutSize) {
                                $i$f$fastAny2 = 1;
                                if ($i$f$fastAny2 == 0) {
                                    withinBounds = true;
                                    break;
                                }
                                index$iv$iv2++;
                                $i$f$fastAny3 = $i$f$fastAny;
                                entry = entry2;
                                $this$fastAny$iv2 = $this$fastAny$iv3;
                            }
                        }
                        $i$f$fastAny2 = 0;
                        if ($i$f$fastAny2 == 0) {
                        }
                    } else {
                        withinBounds = false;
                        break;
                    }
                }
                List $this$fastAny$iv4 = itemInfo4.getPlaceables();
                int index$iv$iv3 = 0;
                int size6 = $this$fastAny$iv4.size();
                while (true) {
                    if (index$iv$iv3 < size6) {
                        Object item$iv$iv3 = $this$fastAny$iv4.get(index$iv$iv3);
                        if (((PlaceableInfo) item$iv$iv3).getInProgress()) {
                            z = true;
                            break;
                        }
                        index$iv$iv3++;
                    } else {
                        z = false;
                        break;
                    }
                }
                boolean isFinished = !z;
                if ((!withinBounds && isFinished) || index == null || itemInfo4.getPlaceables().isEmpty()) {
                    iterator.remove();
                    positionedItems2 = positionedItems2;
                    mainAxisLayoutSize = mainAxisLayoutSize;
                } else {
                    int m898constructorimpl = ItemIndex.m898constructorimpl(index.intValue());
                    if (this.isVertical) {
                        m4347fixedHeightOenEA2s = Constraints.INSTANCE.m4348fixedWidthOenEA2s(itemInfo4.getCrossAxisSize());
                    } else {
                        m4347fixedHeightOenEA2s = Constraints.INSTANCE.m4347fixedHeightOenEA2s(itemInfo4.getCrossAxisSize());
                    }
                    LazyMeasuredItem measuredItem = LazyMeasuredItemProvider.m941getAndMeasureednRnyU$default(measuredItemProvider, m898constructorimpl, 0, m4347fixedHeightOenEA2s, 2, null);
                    int mainAxisLayoutSize2 = mainAxisLayoutSize;
                    List<LazyGridPositionedItem> list = positionedItems2;
                    int absoluteTargetOffset = m919calculateExpectedOffsetxfIKQeg(index.intValue(), measuredItem.getMainAxisSizeWithSpacings(), averageLineMainAxisSize, notAnimatableDelta, reverseLayout, mainAxisLayoutSize, mainAxisLayoutSize2, positionedItems, spanLayoutProvider);
                    if (reverseLayout) {
                        targetOffset = (mainAxisLayoutSize2 - absoluteTargetOffset) - measuredItem.getMainAxisSize();
                    } else {
                        targetOffset = absoluteTargetOffset;
                    }
                    LazyGridPositionedItem item5 = measuredItem.position(targetOffset, itemInfo4.getCrossAxisOffset(), layoutWidth, layoutHeight, -1, -1, measuredItem.getMainAxisSize());
                    list.add(item5);
                    startAnimationsIfNeeded(item5, itemInfo4);
                    positionedItems2 = list;
                    mainAxisLayoutSize = mainAxisLayoutSize2;
                }
            }
        }
        this.keyToIndexMap = measuredItemProvider.getKeyToIndexMap();
    }

    /* renamed from: getAnimatedOffset-YT5a7pE, reason: not valid java name */
    public final long m922getAnimatedOffsetYT5a7pE(Object key, int placeableIndex, int minOffset, int maxOffset, long rawOffset) {
        Intrinsics.checkNotNullParameter(key, "key");
        ItemInfo itemInfo = this.keyToItemInfoMap.get(key);
        if (itemInfo == null) {
            return rawOffset;
        }
        PlaceableInfo item = itemInfo.getPlaceables().get(placeableIndex);
        long arg0$iv = item.getAnimatedOffset().getValue().getPackedValue();
        long other$iv = itemInfo.getNotAnimatableDelta();
        long arg0$iv2 = IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(arg0$iv) + IntOffset.m4500getXimpl(other$iv), IntOffset.m4501getYimpl(arg0$iv) + IntOffset.m4501getYimpl(other$iv));
        long arg0$iv3 = item.getTargetOffset();
        long other$iv2 = itemInfo.getNotAnimatableDelta();
        long arg0$iv4 = IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(arg0$iv3) + IntOffset.m4500getXimpl(other$iv2), IntOffset.m4501getYimpl(arg0$iv3) + IntOffset.m4501getYimpl(other$iv2));
        if (item.getInProgress() && ((m920getMainAxisgyyYBs(arg0$iv4) < minOffset && m920getMainAxisgyyYBs(arg0$iv2) < minOffset) || (m920getMainAxisgyyYBs(arg0$iv4) > maxOffset && m920getMainAxisgyyYBs(arg0$iv2) > maxOffset))) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LazyGridItemPlacementAnimator$getAnimatedOffset$1(item, null), 3, null);
        }
        return arg0$iv2;
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyToIndexMap = MapsKt.emptyMap();
        this.viewportStartItemIndex = -1;
        this.viewportStartItemNotVisiblePartSize = 0;
        this.viewportEndItemIndex = -1;
        this.viewportEndItemNotVisiblePartSize = 0;
    }

    /* renamed from: calculateExpectedOffset-xfIKQeg, reason: not valid java name */
    private final int m919calculateExpectedOffsetxfIKQeg(int index, int mainAxisSizeWithSpacings, int averageLineMainAxisSize, long scrolledBy, boolean reverseLayout, int mainAxisLayoutSize, int fallback, List<LazyGridPositionedItem> visibleItems, LazyGridSpanLayoutProvider spanLayoutProvider) {
        int fromIndex;
        int lastIndexInPreviousLineBefore;
        int linesMainAxisSizesSum;
        int firstIndexInNextLineAfter;
        int toIndex;
        int linesMainAxisSizesSum2;
        boolean beforeViewportStart = false;
        int i = this.viewportEndItemIndex;
        boolean afterViewportEnd = reverseLayout ? i > index : i < index;
        int i2 = this.viewportStartItemIndex;
        if (reverseLayout ? i2 < index : i2 > index) {
            beforeViewportStart = true;
        }
        if (afterViewportEnd) {
            if (reverseLayout) {
                firstIndexInNextLineAfter = LazyGridItemPlacementAnimatorKt.firstIndexInNextLineAfter(spanLayoutProvider, index);
            } else {
                firstIndexInNextLineAfter = this.viewportEndItemIndex + 1;
            }
            int fromIndex2 = firstIndexInNextLineAfter;
            toIndex = LazyGridItemPlacementAnimatorKt.lastIndexInPreviousLineBefore(spanLayoutProvider, !reverseLayout ? index : this.viewportEndItemIndex);
            int m920getMainAxisgyyYBs = mainAxisLayoutSize + this.viewportEndItemNotVisiblePartSize + m920getMainAxisgyyYBs(scrolledBy);
            linesMainAxisSizesSum2 = LazyGridItemPlacementAnimatorKt.getLinesMainAxisSizesSum(spanLayoutProvider, fromIndex2, toIndex, averageLineMainAxisSize, visibleItems);
            return m920getMainAxisgyyYBs + linesMainAxisSizesSum2;
        }
        if (!beforeViewportStart) {
            return fallback;
        }
        fromIndex = LazyGridItemPlacementAnimatorKt.firstIndexInNextLineAfter(spanLayoutProvider, !reverseLayout ? index : this.viewportStartItemIndex);
        if (reverseLayout) {
            lastIndexInPreviousLineBefore = LazyGridItemPlacementAnimatorKt.lastIndexInPreviousLineBefore(spanLayoutProvider, index);
        } else {
            lastIndexInPreviousLineBefore = this.viewportStartItemIndex - 1;
        }
        int toIndex2 = lastIndexInPreviousLineBefore;
        int m920getMainAxisgyyYBs2 = this.viewportStartItemNotVisiblePartSize + m920getMainAxisgyyYBs(scrolledBy) + (-mainAxisSizeWithSpacings);
        linesMainAxisSizesSum = LazyGridItemPlacementAnimatorKt.getLinesMainAxisSizesSum(spanLayoutProvider, fromIndex, toIndex2, averageLineMainAxisSize, visibleItems);
        return m920getMainAxisgyyYBs2 + (-linesMainAxisSizesSum);
    }

    private final void startAnimationsIfNeeded(LazyGridPositionedItem item, ItemInfo itemInfo) {
        Object obj;
        List $this$fastForEachIndexed$iv;
        LazyGridPositionedItem lazyGridPositionedItem = item;
        while (itemInfo.getPlaceables().size() > item.getPlaceablesCount()) {
            CollectionsKt.removeLast(itemInfo.getPlaceables());
        }
        while (true) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (itemInfo.getPlaceables().size() >= item.getPlaceablesCount()) {
                break;
            }
            int newPlaceableInfoIndex = itemInfo.getPlaceables().size();
            long rawOffset = item.getOffset();
            List<PlaceableInfo> placeables = itemInfo.getPlaceables();
            long other$iv = itemInfo.getNotAnimatableDelta();
            placeables.add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(rawOffset) - IntOffset.m4500getXimpl(other$iv), IntOffset.m4501getYimpl(rawOffset) - IntOffset.m4501getYimpl(other$iv)), lazyGridPositionedItem.getMainAxisSize(newPlaceableInfoIndex), defaultConstructorMarker));
        }
        List $this$fastForEachIndexed$iv2 = itemInfo.getPlaceables();
        int index$iv = 0;
        int size = $this$fastForEachIndexed$iv2.size();
        while (index$iv < size) {
            Object item$iv = $this$fastForEachIndexed$iv2.get(index$iv);
            PlaceableInfo placeableInfo = (PlaceableInfo) item$iv;
            int index = index$iv;
            long arg0$iv = placeableInfo.getTargetOffset();
            long other$iv2 = itemInfo.getNotAnimatableDelta();
            long arg0$iv2 = IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(arg0$iv) + IntOffset.m4500getXimpl(other$iv2), IntOffset.m4501getYimpl(arg0$iv) + IntOffset.m4501getYimpl(other$iv2));
            long currentOffset = item.getPlaceableOffset();
            placeableInfo.setMainAxisSize(lazyGridPositionedItem.getMainAxisSize(index));
            FiniteAnimationSpec animationSpec = lazyGridPositionedItem.getAnimationSpec(index);
            if (IntOffset.m4499equalsimpl0(arg0$iv2, currentOffset)) {
                obj = null;
                $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv2;
            } else {
                long other$iv3 = itemInfo.getNotAnimatableDelta();
                $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv2;
                placeableInfo.m960setTargetOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(currentOffset) - IntOffset.m4500getXimpl(other$iv3), IntOffset.m4501getYimpl(currentOffset) - IntOffset.m4501getYimpl(other$iv3)));
                if (animationSpec == null) {
                    obj = null;
                } else {
                    placeableInfo.setInProgress(true);
                    obj = null;
                    BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LazyGridItemPlacementAnimator$startAnimationsIfNeeded$1$1(placeableInfo, animationSpec, null), 3, null);
                }
            }
            index$iv++;
            lazyGridPositionedItem = item;
            $this$fastForEachIndexed$iv2 = $this$fastForEachIndexed$iv;
        }
    }

    /* renamed from: toOffset-Bjo55l4, reason: not valid java name */
    private final long m921toOffsetBjo55l4(int $this$toOffset_u2dBjo55l4) {
        return IntOffsetKt.IntOffset(this.isVertical ? 0 : $this$toOffset_u2dBjo55l4, this.isVertical ? $this$toOffset_u2dBjo55l4 : 0);
    }

    /* renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m920getMainAxisgyyYBs(long $this$mainAxis) {
        return this.isVertical ? IntOffset.m4501getYimpl($this$mainAxis) : IntOffset.m4500getXimpl($this$mainAxis);
    }
}
