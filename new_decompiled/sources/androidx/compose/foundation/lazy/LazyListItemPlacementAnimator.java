package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.IntOffsetKt;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyListItemPlacementAnimator.kt */
@Metadata(m286d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J[\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J;\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J<\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00052\f\u00101\u001a\b\u0012\u0004\u0012\u00020!022\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u00020-J\u0018\u00106\u001a\u00020-2\u0006\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\fH\u0002J\"\u00109\u001a\u00020\t*\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010:\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u001c\u0010;\u001a\u00020\u0014*\u00020\tH\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\t*\u00020\u00148BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006>"}, m287d2 = {"Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isVertical", "", "(Lkotlinx/coroutines/CoroutineScope;Z)V", "keyToIndexMap", "", "", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/ItemInfo;", "positionedKeys", "", "viewportEndItemIndex", "viewportEndItemNotVisiblePartSize", "viewportStartItemIndex", "viewportStartItemNotVisiblePartSize", "mainAxis", "Landroidx/compose/ui/unit/IntOffset;", "getMainAxis--gyyYBs", "(J)I", "calculateExpectedOffset", "index", "sizeWithSpacings", "averageItemsSize", "scrolledBy", "reverseLayout", "mainAxisLayoutSize", "fallback", "visibleItems", "", "Landroidx/compose/foundation/lazy/LazyListPositionedItem;", "calculateExpectedOffset-diAxcj4", "(IIIJZIILjava/util/List;)I", "getAnimatedOffset", "key", "placeableIndex", "minOffset", "maxOffset", "rawOffset", "getAnimatedOffset-YT5a7pE", "(Ljava/lang/Object;IIIJ)J", "onMeasured", "", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "", "itemProvider", "Landroidx/compose/foundation/lazy/LazyMeasuredItemProvider;", "reset", "startAnimationsIfNeeded", "item", "itemInfo", "getItemSize", "itemIndex", "toOffset", "toOffset-Bjo55l4", "(I)J", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyListItemPlacementAnimator {
    private final boolean isVertical;
    private Map<Object, Integer> keyToIndexMap;
    private final Map<Object, ItemInfo> keyToItemInfoMap;
    private final Set<Object> positionedKeys;
    private final CoroutineScope scope;
    private int viewportEndItemIndex;
    private int viewportEndItemNotVisiblePartSize;
    private int viewportStartItemIndex;
    private int viewportStartItemNotVisiblePartSize;

    public LazyListItemPlacementAnimator(CoroutineScope scope, boolean isVertical) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this.isVertical = isVertical;
        this.keyToItemInfoMap = new LinkedHashMap();
        this.keyToIndexMap = MapsKt.emptyMap();
        this.viewportStartItemIndex = -1;
        this.viewportEndItemIndex = -1;
        this.positionedKeys = new LinkedHashSet();
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0361 A[LOOP:5: B:79:0x030e->B:86:0x0361, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x035f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, boolean reverseLayout, List<LazyListPositionedItem> positionedItems, LazyMeasuredItemProvider itemProvider) {
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        int targetOffset;
        List $this$fastForEach$iv$iv;
        boolean z4;
        int index$iv;
        int i2;
        List $this$fastForEach$iv;
        int fallback;
        long firstPlaceableOffset;
        ItemInfo newItemInfo;
        ItemInfo itemInfo;
        LazyListPositionedItem item;
        int i3;
        int targetFirstPlaceableOffsetMainAxis;
        long targetFirstPlaceableOffset;
        LazyMeasuredItemProvider itemProvider2 = itemProvider;
        Intrinsics.checkNotNullParameter(positionedItems, "positionedItems");
        Intrinsics.checkNotNullParameter(itemProvider2, "itemProvider");
        int index$iv$iv = 0;
        int size = positionedItems.size();
        while (true) {
            i = 0;
            if (index$iv$iv < size) {
                Object item$iv$iv = positionedItems.get(index$iv$iv);
                if (((LazyListPositionedItem) item$iv$iv).getHasAnimations()) {
                    z = true;
                    break;
                }
                index$iv$iv++;
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            reset();
            return;
        }
        int mainAxisLayoutSize = this.isVertical ? layoutHeight : layoutWidth;
        long notAnimatableDelta = m867toOffsetBjo55l4(reverseLayout ? -consumedScroll : consumedScroll);
        LazyListPositionedItem newFirstItem = (LazyListPositionedItem) CollectionsKt.first((List) positionedItems);
        LazyListPositionedItem newLastItem = (LazyListPositionedItem) CollectionsKt.last((List) positionedItems);
        int size2 = positionedItems.size();
        int totalItemsSize = 0;
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv = positionedItems.get(index$iv2);
            LazyListPositionedItem item2 = (LazyListPositionedItem) item$iv;
            ItemInfo itemInfo2 = this.keyToItemInfoMap.get(item2.getKey());
            if (itemInfo2 != null) {
                itemInfo2.setIndex(item2.getIndex());
            }
            totalItemsSize += item2.getSizeWithSpacings();
        }
        int averageItemSize = totalItemsSize / positionedItems.size();
        this.positionedKeys.clear();
        List $this$fastForEach$iv2 = positionedItems;
        int size3 = $this$fastForEach$iv2.size();
        int index$iv3 = 0;
        while (index$iv3 < size3) {
            Object item$iv2 = $this$fastForEach$iv2.get(index$iv3);
            LazyListPositionedItem item3 = (LazyListPositionedItem) item$iv2;
            this.positionedKeys.add(item3.getKey());
            ItemInfo itemInfo3 = this.keyToItemInfoMap.get(item3.getKey());
            if (itemInfo3 != null) {
                index$iv = index$iv3;
                i2 = size3;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                if (item3.getHasAnimations()) {
                    long arg0$iv = itemInfo3.getNotAnimatableDelta();
                    itemInfo3.m860setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(arg0$iv) + IntOffset.m4500getXimpl(notAnimatableDelta), IntOffset.m4501getYimpl(arg0$iv) + IntOffset.m4501getYimpl(notAnimatableDelta)));
                    startAnimationsIfNeeded(item3, itemInfo3);
                } else {
                    this.keyToItemInfoMap.remove(item3.getKey());
                }
            } else if (item3.getHasAnimations()) {
                ItemInfo newItemInfo2 = new ItemInfo(item3.getIndex());
                Integer previousIndex = this.keyToIndexMap.get(item3.getKey());
                long firstPlaceableOffset2 = item3.m875getOffsetBjo55l4(i);
                int firstPlaceableSize = item3.getMainAxisSize(i);
                if (previousIndex == null) {
                    firstPlaceableOffset = firstPlaceableOffset2;
                    newItemInfo = newItemInfo2;
                    itemInfo = itemInfo3;
                    index$iv = index$iv3;
                    item = item3;
                    i2 = size3;
                    $this$fastForEach$iv = $this$fastForEach$iv2;
                    targetFirstPlaceableOffsetMainAxis = m866getMainAxisgyyYBs(firstPlaceableOffset2);
                } else {
                    if (!reverseLayout) {
                        fallback = m866getMainAxisgyyYBs(firstPlaceableOffset2);
                    } else {
                        fallback = (m866getMainAxisgyyYBs(firstPlaceableOffset2) - item3.getSizeWithSpacings()) + firstPlaceableSize;
                    }
                    firstPlaceableOffset = firstPlaceableOffset2;
                    newItemInfo = newItemInfo2;
                    itemInfo = itemInfo3;
                    index$iv = index$iv3;
                    item = item3;
                    i2 = size3;
                    $this$fastForEach$iv = $this$fastForEach$iv2;
                    int m865calculateExpectedOffsetdiAxcj4 = m865calculateExpectedOffsetdiAxcj4(previousIndex.intValue(), item3.getSizeWithSpacings(), averageItemSize, notAnimatableDelta, reverseLayout, mainAxisLayoutSize, fallback, positionedItems);
                    if (reverseLayout) {
                        i3 = item.getSize() - firstPlaceableSize;
                    } else {
                        i3 = i;
                    }
                    targetFirstPlaceableOffsetMainAxis = m865calculateExpectedOffsetdiAxcj4 + i3;
                }
                if (this.isVertical) {
                    targetFirstPlaceableOffset = IntOffset.m4496copyiSbpLlY$default(firstPlaceableOffset, 0, targetFirstPlaceableOffsetMainAxis, 1, null);
                } else {
                    targetFirstPlaceableOffset = IntOffset.m4496copyiSbpLlY$default(firstPlaceableOffset, targetFirstPlaceableOffsetMainAxis, 0, 2, null);
                }
                int placeablesCount = item.getPlaceablesCount();
                int i4 = i;
                while (i4 < placeablesCount) {
                    int placeableIndex = i4;
                    LazyListPositionedItem item4 = item;
                    long arg0$iv2 = item4.m875getOffsetBjo55l4(placeableIndex);
                    long arg0$iv3 = IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(arg0$iv2) - IntOffset.m4500getXimpl(firstPlaceableOffset), IntOffset.m4501getYimpl(arg0$iv2) - IntOffset.m4501getYimpl(firstPlaceableOffset));
                    long targetFirstPlaceableOffset2 = targetFirstPlaceableOffset;
                    newItemInfo.getPlaceables().add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(targetFirstPlaceableOffset) + IntOffset.m4500getXimpl(arg0$iv3), IntOffset.m4501getYimpl(targetFirstPlaceableOffset) + IntOffset.m4501getYimpl(arg0$iv3)), item4.getMainAxisSize(placeableIndex), null));
                    Unit unit = Unit.INSTANCE;
                    i4++;
                    placeablesCount = placeablesCount;
                    targetFirstPlaceableOffset = targetFirstPlaceableOffset2;
                }
                LazyListPositionedItem item5 = item;
                ItemInfo newItemInfo3 = newItemInfo;
                this.keyToItemInfoMap.put(item5.getKey(), newItemInfo3);
                startAnimationsIfNeeded(item5, newItemInfo3);
            } else {
                index$iv = index$iv3;
                i2 = size3;
                $this$fastForEach$iv = $this$fastForEach$iv2;
            }
            index$iv3 = index$iv + 1;
            size3 = i2;
            $this$fastForEach$iv2 = $this$fastForEach$iv;
            i = 0;
        }
        if (!reverseLayout) {
            this.viewportStartItemIndex = newFirstItem.getIndex();
            this.viewportStartItemNotVisiblePartSize = newFirstItem.getOffset();
            this.viewportEndItemIndex = newLastItem.getIndex();
            this.viewportEndItemNotVisiblePartSize = (newLastItem.getOffset() + newLastItem.getSizeWithSpacings()) - mainAxisLayoutSize;
        } else {
            this.viewportStartItemIndex = newLastItem.getIndex();
            this.viewportStartItemNotVisiblePartSize = (mainAxisLayoutSize - newLastItem.getOffset()) - newLastItem.getSize();
            this.viewportEndItemIndex = newFirstItem.getIndex();
            this.viewportEndItemNotVisiblePartSize = (-newFirstItem.getOffset()) + (newFirstItem.getSizeWithSpacings() - newFirstItem.getSize());
        }
        Iterator iterator = this.keyToItemInfoMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, ItemInfo> entry = iterator.next();
            if (this.positionedKeys.contains(entry.getKey())) {
                itemProvider2 = itemProvider;
            } else {
                ItemInfo itemInfo4 = entry.getValue();
                long arg0$iv4 = itemInfo4.getNotAnimatableDelta();
                itemInfo4.m860setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(arg0$iv4) + IntOffset.m4500getXimpl(notAnimatableDelta), IntOffset.m4501getYimpl(arg0$iv4) + IntOffset.m4501getYimpl(notAnimatableDelta)));
                Integer index = itemProvider.getKeyToIndexMap().get(entry.getKey());
                List $this$fastAny$iv = itemInfo4.getPlaceables();
                int $i$f$fastAny = 0;
                List $this$fastForEach$iv$iv2 = $this$fastAny$iv;
                int index$iv$iv2 = 0;
                int size4 = $this$fastForEach$iv$iv2.size();
                while (true) {
                    if (index$iv$iv2 < size4) {
                        Object item$iv$iv2 = $this$fastForEach$iv$iv2.get(index$iv$iv2);
                        PlaceableInfo it = (PlaceableInfo) item$iv$iv2;
                        long arg0$iv5 = it.getTargetOffset();
                        long other$iv = itemInfo4.getNotAnimatableDelta();
                        List $this$fastAny$iv2 = $this$fastAny$iv;
                        int m4500getXimpl = IntOffset.m4500getXimpl(arg0$iv5) + IntOffset.m4500getXimpl(other$iv);
                        int $i$f$fastAny2 = $i$f$fastAny;
                        int $i$f$fastAny3 = IntOffset.m4501getYimpl(arg0$iv5) + IntOffset.m4501getYimpl(other$iv);
                        long currentTarget = IntOffsetKt.IntOffset(m4500getXimpl, $i$f$fastAny3);
                        if (m866getMainAxisgyyYBs(currentTarget) + it.getSize() <= 0) {
                            $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                        } else {
                            $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                            if (m866getMainAxisgyyYBs(currentTarget) < mainAxisLayoutSize) {
                                z4 = true;
                                if (!z4) {
                                    z2 = true;
                                    break;
                                }
                                index$iv$iv2++;
                                $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                                $this$fastAny$iv = $this$fastAny$iv2;
                                $i$f$fastAny = $i$f$fastAny2;
                            }
                        }
                        z4 = false;
                        if (!z4) {
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                }
                boolean withinBounds = z2;
                List $this$fastAny$iv3 = itemInfo4.getPlaceables();
                int index$iv$iv3 = 0;
                int size5 = $this$fastAny$iv3.size();
                while (true) {
                    if (index$iv$iv3 < size5) {
                        Object item$iv$iv3 = $this$fastAny$iv3.get(index$iv$iv3);
                        if (((PlaceableInfo) item$iv$iv3).getInProgress()) {
                            z3 = true;
                            break;
                        }
                        index$iv$iv3++;
                    } else {
                        z3 = false;
                        break;
                    }
                }
                boolean isFinished = !z3;
                if ((!withinBounds && isFinished) || index == null || itemInfo4.getPlaceables().isEmpty()) {
                    iterator.remove();
                    itemProvider2 = itemProvider;
                } else {
                    LazyMeasuredItem measuredItem = itemProvider2.m882getAndMeasureZjPyQlc(DataIndex.m847constructorimpl(index.intValue()));
                    int absoluteTargetOffset = m865calculateExpectedOffsetdiAxcj4(index.intValue(), measuredItem.getSizeWithSpacings(), averageItemSize, notAnimatableDelta, reverseLayout, mainAxisLayoutSize, mainAxisLayoutSize, positionedItems);
                    if (reverseLayout) {
                        targetOffset = (mainAxisLayoutSize - absoluteTargetOffset) - measuredItem.getSize();
                    } else {
                        targetOffset = absoluteTargetOffset;
                    }
                    LazyListPositionedItem item6 = measuredItem.position(targetOffset, layoutWidth, layoutHeight);
                    positionedItems.add(item6);
                    startAnimationsIfNeeded(item6, itemInfo4);
                    itemProvider2 = itemProvider;
                }
            }
        }
        this.keyToIndexMap = itemProvider.getKeyToIndexMap();
    }

    /* renamed from: getAnimatedOffset-YT5a7pE, reason: not valid java name */
    public final long m868getAnimatedOffsetYT5a7pE(Object key, int placeableIndex, int minOffset, int maxOffset, long rawOffset) {
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
        if (item.getInProgress() && ((m866getMainAxisgyyYBs(arg0$iv4) < minOffset && m866getMainAxisgyyYBs(arg0$iv2) < minOffset) || (m866getMainAxisgyyYBs(arg0$iv4) > maxOffset && m866getMainAxisgyyYBs(arg0$iv2) > maxOffset))) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LazyListItemPlacementAnimator$getAnimatedOffset$1(item, null), 3, null);
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

    /* renamed from: calculateExpectedOffset-diAxcj4, reason: not valid java name */
    private final int m865calculateExpectedOffsetdiAxcj4(int index, int sizeWithSpacings, int averageItemsSize, long scrolledBy, boolean reverseLayout, int mainAxisLayoutSize, int fallback, List<LazyListPositionedItem> visibleItems) {
        IntRange range;
        IntRange range2;
        boolean beforeViewportStart = false;
        int i = this.viewportEndItemIndex;
        boolean afterViewportEnd = reverseLayout ? i > index : i < index;
        int i2 = this.viewportStartItemIndex;
        if (reverseLayout ? i2 < index : i2 > index) {
            beforeViewportStart = true;
        }
        if (afterViewportEnd) {
            int itemsSizes = 0;
            if (reverseLayout) {
                range2 = RangesKt.until(index + 1, this.viewportEndItemIndex);
            } else {
                range2 = RangesKt.until(this.viewportEndItemIndex + 1, index);
            }
            int i3 = range2.getFirst();
            int last = range2.getLast();
            if (i3 <= last) {
                while (true) {
                    itemsSizes += getItemSize(visibleItems, i3, averageItemsSize);
                    if (i3 == last) {
                        break;
                    }
                    i3++;
                }
            }
            return mainAxisLayoutSize + this.viewportEndItemNotVisiblePartSize + itemsSizes + m866getMainAxisgyyYBs(scrolledBy);
        }
        if (beforeViewportStart) {
            int itemsSizes2 = sizeWithSpacings;
            if (!reverseLayout) {
                range = RangesKt.until(index + 1, this.viewportStartItemIndex);
            } else {
                range = RangesKt.until(this.viewportStartItemIndex + 1, index);
            }
            int i4 = range.getFirst();
            int last2 = range.getLast();
            if (i4 <= last2) {
                while (true) {
                    itemsSizes2 += getItemSize(visibleItems, i4, averageItemsSize);
                    if (i4 == last2) {
                        break;
                    }
                    i4++;
                }
            }
            return (this.viewportStartItemNotVisiblePartSize - itemsSizes2) + m866getMainAxisgyyYBs(scrolledBy);
        }
        return fallback;
    }

    private final int getItemSize(List<LazyListPositionedItem> list, int itemIndex, int fallback) {
        if (list.isEmpty() || itemIndex < ((LazyListPositionedItem) CollectionsKt.first((List) list)).getIndex() || itemIndex > ((LazyListPositionedItem) CollectionsKt.last((List) list)).getIndex()) {
            return fallback;
        }
        if (itemIndex - ((LazyListPositionedItem) CollectionsKt.first((List) list)).getIndex() < ((LazyListPositionedItem) CollectionsKt.last((List) list)).getIndex() - itemIndex) {
            int size = list.size();
            for (int index = 0; index < size; index++) {
                LazyListPositionedItem item = list.get(index);
                if (item.getIndex() == itemIndex) {
                    return item.getSizeWithSpacings();
                }
                if (item.getIndex() > itemIndex) {
                    break;
                }
            }
        } else {
            for (int index2 = CollectionsKt.getLastIndex(list); -1 < index2; index2--) {
                LazyListPositionedItem item2 = list.get(index2);
                if (item2.getIndex() == itemIndex) {
                    return item2.getSizeWithSpacings();
                }
                if (item2.getIndex() < itemIndex) {
                    break;
                }
            }
        }
        return fallback;
    }

    private final void startAnimationsIfNeeded(LazyListPositionedItem item, ItemInfo itemInfo) {
        Object obj;
        List $this$fastForEachIndexed$iv;
        LazyListPositionedItem lazyListPositionedItem = item;
        while (itemInfo.getPlaceables().size() > item.getPlaceablesCount()) {
            CollectionsKt.removeLast(itemInfo.getPlaceables());
        }
        while (true) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (itemInfo.getPlaceables().size() >= item.getPlaceablesCount()) {
                break;
            }
            int newPlaceableInfoIndex = itemInfo.getPlaceables().size();
            long rawOffset = lazyListPositionedItem.m875getOffsetBjo55l4(newPlaceableInfoIndex);
            List<PlaceableInfo> placeables = itemInfo.getPlaceables();
            long other$iv = itemInfo.getNotAnimatableDelta();
            placeables.add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(rawOffset) - IntOffset.m4500getXimpl(other$iv), IntOffset.m4501getYimpl(rawOffset) - IntOffset.m4501getYimpl(other$iv)), lazyListPositionedItem.getMainAxisSize(newPlaceableInfoIndex), defaultConstructorMarker));
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
            long currentOffset = lazyListPositionedItem.m875getOffsetBjo55l4(index);
            placeableInfo.setSize(lazyListPositionedItem.getMainAxisSize(index));
            FiniteAnimationSpec animationSpec = lazyListPositionedItem.getAnimationSpec(index);
            if (IntOffset.m4499equalsimpl0(arg0$iv2, currentOffset)) {
                obj = null;
                $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv2;
            } else {
                long other$iv3 = itemInfo.getNotAnimatableDelta();
                $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv2;
                placeableInfo.m885setTargetOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(currentOffset) - IntOffset.m4500getXimpl(other$iv3), IntOffset.m4501getYimpl(currentOffset) - IntOffset.m4501getYimpl(other$iv3)));
                if (animationSpec == null) {
                    obj = null;
                } else {
                    placeableInfo.setInProgress(true);
                    obj = null;
                    BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1(placeableInfo, animationSpec, null), 3, null);
                }
            }
            index$iv++;
            lazyListPositionedItem = item;
            $this$fastForEachIndexed$iv2 = $this$fastForEachIndexed$iv;
        }
    }

    /* renamed from: toOffset-Bjo55l4, reason: not valid java name */
    private final long m867toOffsetBjo55l4(int $this$toOffset_u2dBjo55l4) {
        return IntOffsetKt.IntOffset(this.isVertical ? 0 : $this$toOffset_u2dBjo55l4, this.isVertical ? $this$toOffset_u2dBjo55l4 : 0);
    }

    /* renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m866getMainAxisgyyYBs(long $this$mainAxis) {
        return this.isVertical ? IntOffset.m4501getYimpl($this$mainAxis) : IntOffset.m4500getXimpl($this$mainAxis);
    }
}
