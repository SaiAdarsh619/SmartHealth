package androidx.compose.p000ui.input.pointer;

import androidx.compose.p000ui.node.HitTestResult;
import androidx.compose.p000ui.node.LayoutNode;
import androidx.compose.p000ui.node.PointerInputModifierNode;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PointerInputEventProcessor.kt */
@Metadata(m286d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, m287d2 = {"Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "hitPathTracker", "Landroidx/compose/ui/input/pointer/HitPathTracker;", "hitResult", "Landroidx/compose/ui/node/HitTestResult;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "isProcessing", "", "pointerInputChangeEventProducer", "Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "process", "Landroidx/compose/ui/input/pointer/ProcessResult;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "isInBounds", "process-BIzXfog", "(Landroidx/compose/ui/input/pointer/PointerInputEvent;Landroidx/compose/ui/input/pointer/PositionCalculator;Z)I", "processCancel", "", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class PointerInputEventProcessor {
    private final HitPathTracker hitPathTracker;
    private final HitTestResult<PointerInputModifierNode> hitResult;
    private boolean isProcessing;
    private final PointerInputChangeEventProducer pointerInputChangeEventProducer;
    private final LayoutNode root;

    public PointerInputEventProcessor(LayoutNode root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        this.hitPathTracker = new HitPathTracker(this.root.getCoordinates());
        this.pointerInputChangeEventProducer = new PointerInputChangeEventProducer();
        this.hitResult = new HitTestResult<>();
    }

    public final LayoutNode getRoot() {
        return this.root;
    }

    /* renamed from: process-BIzXfog$default, reason: not valid java name */
    public static /* synthetic */ int m3382processBIzXfog$default(PointerInputEventProcessor pointerInputEventProcessor, PointerInputEvent pointerInputEvent, PositionCalculator positionCalculator, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return pointerInputEventProcessor.m3383processBIzXfog(pointerInputEvent, positionCalculator, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0067 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[LOOP:2: B:68:0x0047->B:80:?, LOOP_END, SYNTHETIC] */
    /* renamed from: process-BIzXfog, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m3383processBIzXfog(PointerInputEvent pointerEvent, PositionCalculator positionCalculator, boolean isInBounds) {
        Iterable $this$any$iv;
        PointerInputChange it;
        boolean z;
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(positionCalculator, "positionCalculator");
        if (this.isProcessing) {
            return PointerInputEventProcessorKt.ProcessResult(false, false);
        }
        try {
            this.isProcessing = true;
            InternalPointerEvent internalPointerEvent = this.pointerInputChangeEventProducer.produce(pointerEvent, positionCalculator);
            Iterable $this$any$iv2 = internalPointerEvent.getChanges().values();
            if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                Iterator it2 = $this$any$iv2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Object element$iv = it2.next();
                        PointerInputChange it3 = (PointerInputChange) element$iv;
                        if (!it3.getPressed() && !it3.getPreviousPressed()) {
                            it = null;
                            if (it == null) {
                                $this$any$iv = 1;
                                break;
                            }
                        }
                        it = 1;
                        if (it == null) {
                        }
                    } else {
                        $this$any$iv = null;
                        break;
                    }
                }
            } else {
                $this$any$iv = null;
            }
            boolean isHover = $this$any$iv == null;
            Iterable $this$forEach$iv = internalPointerEvent.getChanges().values();
            for (Object element$iv2 : $this$forEach$iv) {
                PointerInputChange pointerInputChange = (PointerInputChange) element$iv2;
                if (isHover || PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange)) {
                    boolean isTouchEvent = PointerType.m3435equalsimpl0(pointerInputChange.getType(), PointerType.INSTANCE.m3442getTouchT8wyACA());
                    LayoutNode.m3617hitTestM_7yMNQ$ui_release$default(this.root, pointerInputChange.getPosition(), this.hitResult, isTouchEvent, false, 8, null);
                    if (!this.hitResult.isEmpty()) {
                        this.hitPathTracker.m3295addHitPathKNwqfcY(pointerInputChange.getId(), this.hitResult);
                        this.hitResult.clear();
                    }
                }
            }
            this.hitPathTracker.removeDetachedPointerInputFilters();
            try {
                boolean dispatchedToSomething = this.hitPathTracker.dispatchChanges(internalPointerEvent, isInBounds);
                if (internalPointerEvent.getSuppressMovementConsumption()) {
                    z = false;
                } else {
                    Iterable $this$any$iv3 = internalPointerEvent.getChanges().values();
                    if (!($this$any$iv3 instanceof Collection) || !((Collection) $this$any$iv3).isEmpty()) {
                        Iterator it4 = $this$any$iv3.iterator();
                        while (true) {
                            if (it4.hasNext()) {
                                Object element$iv3 = it4.next();
                                PointerInputChange it5 = (PointerInputChange) element$iv3;
                                if (PointerEventKt.positionChangedIgnoreConsumed(it5) && it5.isConsumed()) {
                                    z = true;
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                    } else {
                        z = false;
                    }
                }
                boolean anyMovementConsumed = z;
                int ProcessResult = PointerInputEventProcessorKt.ProcessResult(dispatchedToSomething, anyMovementConsumed);
                this.isProcessing = false;
                return ProcessResult;
            } catch (Throwable th) {
                th = th;
                this.isProcessing = false;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void processCancel() {
        if (!this.isProcessing) {
            this.pointerInputChangeEventProducer.clear();
            this.hitPathTracker.processCancel();
        }
    }
}
