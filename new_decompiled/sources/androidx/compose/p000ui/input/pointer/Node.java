package androidx.compose.p000ui.input.pointer;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.node.PointerInputModifierNode;
import androidx.compose.p000ui.node.PointerInputModifierNodeKt;
import androidx.compose.runtime.collection.MutableVector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HitPathTracker.kt */
@Metadata(m286d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J7\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0017\u0010#\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0%H\u0082\bJ7\u0010&\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u001a\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\u000b2\u0006\u0010)\u001a\u00020\u000bH\u0002J\u0006\u0010*\u001a\u00020\u001fJ\b\u0010+\u001a\u00020,H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, m287d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "pointerInputNode", "Landroidx/compose/ui/node/PointerInputModifierNode;", "(Landroidx/compose/ui/node/PointerInputModifierNode;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "hasExited", "", "isIn", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerIds", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/PointerId;", "getPointerIds", "()Landroidx/compose/runtime/collection/MutableVector;", "getPointerInputNode", "()Landroidx/compose/ui/node/PointerInputModifierNode;", "relevantChanges", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "wasIn", "buildCache", "changes", "", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clearCache", "dispatchCancel", "dispatchFinalEventPass", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchMainEventPass", "hasPositionChanged", "oldEvent", "newEvent", "markIsIn", "toString", "", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class Node extends NodeParent {
    private LayoutCoordinates coordinates;
    private boolean hasExited;
    private boolean isIn;
    private PointerEvent pointerEvent;
    private final MutableVector<PointerId> pointerIds;

    /* renamed from: pointerInputNode, reason: from kotlin metadata and from toString */
    private final PointerInputModifierNode pointerInputFilter;
    private final Map<PointerId, PointerInputChange> relevantChanges;
    private boolean wasIn;

    public Node(PointerInputModifierNode pointerInputNode) {
        Intrinsics.checkNotNullParameter(pointerInputNode, "pointerInputNode");
        this.pointerInputFilter = pointerInputNode;
        this.pointerIds = new MutableVector<>(new PointerId[16], 0);
        this.relevantChanges = new LinkedHashMap();
        this.isIn = true;
        this.hasExited = true;
    }

    /* renamed from: getPointerInputNode, reason: from getter */
    public final PointerInputModifierNode getPointerInputFilter() {
        return this.pointerInputFilter;
    }

    public final MutableVector<PointerId> getPointerIds() {
        return this.pointerIds;
    }

    @Override // androidx.compose.p000ui.input.pointer.NodeParent
    public boolean dispatchMainEventPass(Map<PointerId, PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        boolean z;
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(parentCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        Node this_$iv = this;
        if (!this_$iv.relevantChanges.isEmpty() && PointerInputModifierNodeKt.isAttached(this_$iv.pointerInputFilter)) {
            PointerEvent event = this.pointerEvent;
            Intrinsics.checkNotNull(event);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            long size = layoutCoordinates.mo3497getSizeYbymL2g();
            this.pointerInputFilter.mo3580onPointerEventH0pRuoY(event, PointerEventPass.Initial, size);
            if (PointerInputModifierNodeKt.isAttached(this.pointerInputFilter)) {
                MutableVector this_$iv2 = getChildren();
                int size$iv = this_$iv2.getSize();
                if (size$iv > 0) {
                    int i$iv = 0;
                    Object[] content$iv = this_$iv2.getContent();
                    Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                    while (true) {
                        Node it = (Node) content$iv[i$iv];
                        Node this_$iv3 = this_$iv;
                        Map<PointerId, PointerInputChange> map = this.relevantChanges;
                        LayoutCoordinates layoutCoordinates2 = this.coordinates;
                        Intrinsics.checkNotNull(layoutCoordinates2);
                        it.dispatchMainEventPass(map, layoutCoordinates2, internalPointerEvent, isInBounds);
                        z = true;
                        i$iv++;
                        if (i$iv >= size$iv) {
                            break;
                        }
                        this_$iv = this_$iv3;
                    }
                } else {
                    z = true;
                }
            } else {
                z = true;
            }
            if (PointerInputModifierNodeKt.isAttached(this.pointerInputFilter)) {
                this.pointerInputFilter.mo3580onPointerEventH0pRuoY(event, PointerEventPass.Main, size);
            }
            return z;
        }
        return false;
    }

    @Override // androidx.compose.p000ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        MutableVector this_$iv;
        int size$iv;
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        boolean z = false;
        if (!this.relevantChanges.isEmpty() && PointerInputModifierNodeKt.isAttached(this.pointerInputFilter)) {
            PointerEvent event = this.pointerEvent;
            Intrinsics.checkNotNull(event);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            long size = layoutCoordinates.mo3497getSizeYbymL2g();
            this.pointerInputFilter.mo3580onPointerEventH0pRuoY(event, PointerEventPass.Final, size);
            if (PointerInputModifierNodeKt.isAttached(this.pointerInputFilter) && (size$iv = (this_$iv = getChildren()).getSize()) > 0) {
                int i$iv = 0;
                Object[] content$iv = this_$iv.getContent();
                Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                do {
                    Node it = (Node) content$iv[i$iv];
                    it.dispatchFinalEventPass(internalPointerEvent);
                    i$iv++;
                } while (i$iv < size$iv);
            }
            z = true;
        }
        boolean result = z;
        cleanUpHits(internalPointerEvent);
        clearCache();
        return result;
    }

    @Override // androidx.compose.p000ui.input.pointer.NodeParent
    public boolean buildCache(Map<PointerId, PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        Object it$iv;
        boolean z;
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(parentCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        boolean childChanged = super.buildCache(changes, parentCoordinates, internalPointerEvent, isInBounds);
        if (!PointerInputModifierNodeKt.isAttached(this.pointerInputFilter)) {
            return true;
        }
        this.coordinates = PointerInputModifierNodeKt.getLayoutCoordinates(this.pointerInputFilter);
        Iterator<Map.Entry<PointerId, PointerInputChange>> it = changes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<PointerId, PointerInputChange> next = it.next();
            long key = next.getKey().m3352unboximpl();
            PointerInputChange change = next.getValue();
            if (this.pointerIds.contains(PointerId.m3346boximpl(key))) {
                List historical = new ArrayList();
                List $this$fastForEach$iv = change.getHistorical();
                int $i$f$fastForEach = 0;
                int index$iv = 0;
                int size = $this$fastForEach$iv.size();
                while (index$iv < size) {
                    Object item$iv = $this$fastForEach$iv.get(index$iv);
                    HistoricalChange it2 = (HistoricalChange) item$iv;
                    long uptimeMillis = it2.getUptimeMillis();
                    Iterator<Map.Entry<PointerId, PointerInputChange>> it3 = it;
                    LayoutCoordinates layoutCoordinates = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates);
                    historical.add(new HistoricalChange(uptimeMillis, layoutCoordinates.mo3498localPositionOfR5De75A(parentCoordinates, it2.getPosition()), null));
                    index$iv++;
                    $this$fastForEach$iv = $this$fastForEach$iv;
                    $i$f$fastForEach = $i$f$fastForEach;
                    it = it3;
                }
                Iterator<Map.Entry<PointerId, PointerInputChange>> it4 = it;
                Map<PointerId, PointerInputChange> map = this.relevantChanges;
                PointerId m3346boximpl = PointerId.m3346boximpl(key);
                LayoutCoordinates layoutCoordinates2 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates2);
                long mo3498localPositionOfR5De75A = layoutCoordinates2.mo3498localPositionOfR5De75A(parentCoordinates, change.getPreviousPosition());
                LayoutCoordinates layoutCoordinates3 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates3);
                map.put(m3346boximpl, PointerInputChange.m3356copyOHpmEuE$default(change, 0L, 0L, layoutCoordinates3.mo3498localPositionOfR5De75A(parentCoordinates, change.getPosition()), false, 0L, mo3498localPositionOfR5De75A, false, 0, historical, 0L, 731, null));
                it = it4;
            }
        }
        if (this.relevantChanges.isEmpty()) {
            this.pointerIds.clear();
            getChildren().clear();
            return true;
        }
        MutableVector this_$iv = this.pointerIds;
        for (int i = this_$iv.getSize() - 1; -1 < i; i--) {
            MutableVector this_$iv2 = this.pointerIds;
            long pointerId = this_$iv2.getContent()[i].m3352unboximpl();
            if (!changes.containsKey(PointerId.m3346boximpl(pointerId))) {
                this.pointerIds.removeAt(i);
            }
        }
        PointerEvent event = new PointerEvent(CollectionsKt.toList(this.relevantChanges.values()), internalPointerEvent);
        List $this$fastFirstOrNull$iv = event.getChanges();
        int index$iv$iv = 0;
        int size2 = $this$fastFirstOrNull$iv.size();
        while (true) {
            if (index$iv$iv >= size2) {
                it$iv = null;
                break;
            }
            Object item$iv$iv = $this$fastFirstOrNull$iv.get(index$iv$iv);
            it$iv = item$iv$iv;
            if (internalPointerEvent.m3296issuesEnterExitEvent0FcD4WY(((PointerInputChange) it$iv).getId())) {
                break;
            }
            index$iv$iv++;
        }
        PointerInputChange enterExitChange = (PointerInputChange) it$iv;
        if (enterExitChange != null) {
            if (!isInBounds) {
                this.isIn = false;
                z = true;
            } else if (this.isIn) {
                z = true;
            } else if (enterExitChange.getPressed() || enterExitChange.getPreviousPressed()) {
                LayoutCoordinates layoutCoordinates4 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates4);
                long size3 = layoutCoordinates4.mo3497getSizeYbymL2g();
                z = true;
                this.isIn = !PointerEventKt.m3311isOutOfBoundsO0kMr_c(enterExitChange, size3);
            } else {
                z = true;
            }
            if (this.isIn != this.wasIn && (PointerEventType.m3316equalsimpl0(event.getType(), PointerEventType.INSTANCE.m3322getMove7fucELk()) || PointerEventType.m3316equalsimpl0(event.getType(), PointerEventType.INSTANCE.m3320getEnter7fucELk()) || PointerEventType.m3316equalsimpl0(event.getType(), PointerEventType.INSTANCE.m3321getExit7fucELk()))) {
                event.m3310setTypeEhbLWgg$ui_release(this.isIn ? PointerEventType.INSTANCE.m3320getEnter7fucELk() : PointerEventType.INSTANCE.m3321getExit7fucELk());
            } else if (PointerEventType.m3316equalsimpl0(event.getType(), PointerEventType.INSTANCE.m3320getEnter7fucELk()) && this.wasIn && !this.hasExited) {
                event.m3310setTypeEhbLWgg$ui_release(PointerEventType.INSTANCE.m3322getMove7fucELk());
            } else if (PointerEventType.m3316equalsimpl0(event.getType(), PointerEventType.INSTANCE.m3321getExit7fucELk()) && this.isIn && enterExitChange.getPressed()) {
                event.m3310setTypeEhbLWgg$ui_release(PointerEventType.INSTANCE.m3322getMove7fucELk());
            }
        } else {
            z = true;
        }
        boolean changed = (childChanged || !PointerEventType.m3316equalsimpl0(event.getType(), PointerEventType.INSTANCE.m3322getMove7fucELk()) || hasPositionChanged(this.pointerEvent, event)) ? z : false;
        this.pointerEvent = event;
        return changed;
    }

    private final boolean hasPositionChanged(PointerEvent oldEvent, PointerEvent newEvent) {
        if (oldEvent == null || oldEvent.getChanges().size() != newEvent.getChanges().size()) {
            return true;
        }
        int size = newEvent.getChanges().size();
        for (int i = 0; i < size; i++) {
            PointerInputChange old = oldEvent.getChanges().get(i);
            PointerInputChange current = newEvent.getChanges().get(i);
            if (!Offset.m1757equalsimpl0(old.getPosition(), current.getPosition())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> block) {
        if (this.relevantChanges.isEmpty() || !PointerInputModifierNodeKt.isAttached(this.pointerInputFilter)) {
            return false;
        }
        block.invoke();
        return true;
    }

    @Override // androidx.compose.p000ui.input.pointer.NodeParent
    public void dispatchCancel() {
        MutableVector this_$iv = getChildren();
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                Node it = (Node) content$iv[i$iv];
                it.dispatchCancel();
                i$iv++;
            } while (i$iv < size$iv);
        }
        this.pointerInputFilter.onCancelPointerInput();
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    @Override // androidx.compose.p000ui.input.pointer.NodeParent
    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        super.cleanUpHits(internalPointerEvent);
        PointerEvent event = this.pointerEvent;
        if (event == null) {
            return;
        }
        this.wasIn = this.isIn;
        List $this$fastForEach$iv = event.getChanges();
        int index$iv = 0;
        int size = $this$fastForEach$iv.size();
        while (true) {
            boolean remove = false;
            if (index$iv >= size) {
                this.isIn = false;
                this.hasExited = PointerEventType.m3316equalsimpl0(event.getType(), PointerEventType.INSTANCE.m3321getExit7fucELk());
                return;
            }
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            PointerInputChange change = (PointerInputChange) item$iv;
            if (!change.getPressed() && (!internalPointerEvent.m3296issuesEnterExitEvent0FcD4WY(change.getId()) || !this.isIn)) {
                remove = true;
            }
            if (remove) {
                this.pointerIds.remove(PointerId.m3346boximpl(change.getId()));
            }
            index$iv++;
        }
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.pointerInputFilter + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }
}
