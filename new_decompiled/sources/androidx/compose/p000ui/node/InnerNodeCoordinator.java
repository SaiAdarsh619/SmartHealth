package androidx.compose.p000ui.node;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.AndroidPaint_androidKt;
import androidx.compose.p000ui.graphics.Canvas;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.GraphicsLayerScope;
import androidx.compose.p000ui.graphics.Paint;
import androidx.compose.p000ui.graphics.PaintingStyle;
import androidx.compose.p000ui.layout.AlignmentLine;
import androidx.compose.p000ui.layout.LookaheadScope;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.node.LayoutNode;
import androidx.compose.p000ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.p000ui.node.NodeCoordinator;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InnerNodeCoordinator.kt */
@Metadata(m286d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 <2\u00020\u0001:\u0002<=B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016JS\u0010\u0013\u001a\u00020\u0014\"\b\b\u0000\u0010\u0015*\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00150\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\fH\u0016J\u0010\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH\u0016J\u001d\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\f2\u0006\u0010#\u001a\u00020\fH\u0016J\u0010\u0010-\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH\u0016J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u000200H\u0016J@\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0019\u00106\u001a\u0015\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u0014\u0018\u000107¢\u0006\u0002\b9H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u0010;R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006>"}, m287d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator;", "Landroidx/compose/ui/node/NodeCoordinator;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail$annotations", "()V", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "createLookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "scope", "Landroidx/compose/ui/layout/LookaheadScope;", "hitTestChild", "", "T", "Landroidx/compose/ui/node/DelegatableNode;", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "hitTestChild-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "Companion", "LookaheadDelegateImpl", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class InnerNodeCoordinator extends NodeCoordinator {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Paint innerBoundsPaint;
    private final Modifier.Node tail;

    public static /* synthetic */ void getTail$annotations() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerNodeCoordinator(LayoutNode layoutNode) {
        super(layoutNode);
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.tail = new Modifier.Node() { // from class: androidx.compose.ui.node.InnerNodeCoordinator$tail$1
            public String toString() {
                return "<tail>";
            }
        };
        getTail().updateCoordinator$ui_release(this);
    }

    @Override // androidx.compose.p000ui.node.NodeCoordinator
    public Modifier.Node getTail() {
        return this.tail;
    }

    /* compiled from: InnerNodeCoordinator.kt */
    @Metadata(m286d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0014\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, m287d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator$LookaheadDelegateImpl;", "Landroidx/compose/ui/node/LookaheadDelegate;", "scope", "Landroidx/compose/ui/layout/LookaheadScope;", "(Landroidx/compose/ui/node/InnerNodeCoordinator;Landroidx/compose/ui/layout/LookaheadScope;)V", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "placeChildren", "", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    private final class LookaheadDelegateImpl extends LookaheadDelegate {
        final /* synthetic */ InnerNodeCoordinator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LookaheadDelegateImpl(InnerNodeCoordinator this$0, LookaheadScope scope) {
            super(this$0, scope);
            Intrinsics.checkNotNullParameter(scope, "scope");
            this.this$0 = this$0;
        }

        @Override // androidx.compose.p000ui.layout.Measurable
        /* renamed from: measure-BRTryo0 */
        public Placeable mo3492measureBRTryo0(long constraints) {
            LookaheadDelegateImpl this_$iv = this;
            this_$iv.m3539setMeasurementConstraintsBRTryo0(constraints);
            MutableVector this_$iv$iv = getLayoutNode().get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                do {
                    LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                    it.setMeasuredByParentInLookahead$ui_release(LayoutNode.UsageByParent.NotUsed);
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
            MeasurePolicy $this$measure_BRTryo0_u24lambda_u2d2_u24lambda_u2d1 = getLayoutNode().getMeasurePolicy();
            MeasureResult measureResult = $this$measure_BRTryo0_u24lambda_u2d2_u24lambda_u2d1.mo331measure3p2s80s(this, getLayoutNode().getChildLookaheadMeasurables$ui_release(), constraints);
            this_$iv.set_measureResult(measureResult);
            return this_$iv;
        }

        @Override // androidx.compose.p000ui.node.LookaheadCapablePlaceable
        public int calculateAlignmentLine(AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            Integer num = getAlignmentLinesOwner().calculateAlignmentLines().get(alignmentLine);
            int intValue = num != null ? num.intValue() : Integer.MIN_VALUE;
            int it = intValue;
            getCachedAlignmentLinesMap().put(alignmentLine, Integer.valueOf(it));
            return intValue;
        }

        @Override // androidx.compose.p000ui.node.LookaheadDelegate
        protected void placeChildren() {
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLayoutNode().getLayoutDelegate().getLookaheadPassDelegate();
            Intrinsics.checkNotNull(lookaheadPassDelegate);
            lookaheadPassDelegate.onPlaced();
            getAlignmentLinesOwner().layoutChildren();
        }

        @Override // androidx.compose.p000ui.node.LookaheadDelegate, androidx.compose.p000ui.layout.IntrinsicMeasurable
        public int minIntrinsicWidth(int height) {
            return getLayoutNode().getIntrinsicsPolicy().minLookaheadIntrinsicWidth(height);
        }

        @Override // androidx.compose.p000ui.node.LookaheadDelegate, androidx.compose.p000ui.layout.IntrinsicMeasurable
        public int minIntrinsicHeight(int width) {
            return getLayoutNode().getIntrinsicsPolicy().minLookaheadIntrinsicHeight(width);
        }

        @Override // androidx.compose.p000ui.node.LookaheadDelegate, androidx.compose.p000ui.layout.IntrinsicMeasurable
        public int maxIntrinsicWidth(int height) {
            return getLayoutNode().getIntrinsicsPolicy().maxLookaheadIntrinsicWidth(height);
        }

        @Override // androidx.compose.p000ui.node.LookaheadDelegate, androidx.compose.p000ui.layout.IntrinsicMeasurable
        public int maxIntrinsicHeight(int width) {
            return getLayoutNode().getIntrinsicsPolicy().maxLookaheadIntrinsicHeight(width);
        }
    }

    @Override // androidx.compose.p000ui.node.NodeCoordinator
    public LookaheadDelegate createLookaheadDelegate(LookaheadScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        return new LookaheadDelegateImpl(this, scope);
    }

    @Override // androidx.compose.p000ui.layout.Measurable
    /* renamed from: measure-BRTryo0 */
    public Placeable mo3492measureBRTryo0(long constraints) {
        InnerNodeCoordinator this_$iv = this;
        this_$iv.m3539setMeasurementConstraintsBRTryo0(constraints);
        LayoutNode this_$iv2 = getLayoutNode();
        MutableVector this_$iv$iv = this_$iv2.get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                it.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
        LayoutNode this_$iv3 = getLayoutNode();
        MeasurePolicy $this$measure_BRTryo0_u24lambda_u2d2_u24lambda_u2d1 = this_$iv3.getMeasurePolicy();
        setMeasureResult$ui_release($this$measure_BRTryo0_u24lambda_u2d2_u24lambda_u2d1.mo331measure3p2s80s(this, getLayoutNode().getChildMeasurables$ui_release(), constraints));
        onMeasured();
        return this;
    }

    @Override // androidx.compose.p000ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int height) {
        return getLayoutNode().getIntrinsicsPolicy().minIntrinsicWidth(height);
    }

    @Override // androidx.compose.p000ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int width) {
        return getLayoutNode().getIntrinsicsPolicy().minIntrinsicHeight(width);
    }

    @Override // androidx.compose.p000ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int height) {
        return getLayoutNode().getIntrinsicsPolicy().maxIntrinsicWidth(height);
    }

    @Override // androidx.compose.p000ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int width) {
        return getLayoutNode().getIntrinsicsPolicy().maxIntrinsicHeight(width);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.p000ui.node.NodeCoordinator, androidx.compose.p000ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo3493placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        super.mo3493placeAtf8xVGno(position, zIndex, layerBlock);
        if (getIsShallowPlacing()) {
            return;
        }
        onPlaced();
        getLayoutNode().onNodePlaced$ui_release();
    }

    @Override // androidx.compose.p000ui.node.LookaheadCapablePlaceable
    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        LookaheadDelegate lookaheadDelegate$ui_release = getLookaheadDelegate();
        if (lookaheadDelegate$ui_release != null) {
            return lookaheadDelegate$ui_release.calculateAlignmentLine(alignmentLine);
        }
        Integer num = getAlignmentLinesOwner().calculateAlignmentLines().get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.compose.p000ui.node.NodeCoordinator
    public void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Owner owner = LayoutNodeKt.requireOwner(getLayoutNode());
        MutableVector this_$iv = getLayoutNode().getZSortedChildren();
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                LayoutNode child = (LayoutNode) content$iv[i$iv];
                if (child.getIsPlaced()) {
                    child.draw$ui_release(canvas);
                }
                i$iv++;
            } while (i$iv < size$iv);
        }
        if (owner.getShowLayoutBounds()) {
            drawBorder(canvas, innerBoundsPaint);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0050  */
    @Override // androidx.compose.p000ui.node.NodeCoordinator
    /* renamed from: hitTestChild-YqVAtuI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T extends DelegatableNode> void mo3615hitTestChildYqVAtuI(NodeCoordinator.HitTestSource<T> hitTestSource, long pointerPosition, HitTestResult<T> hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        boolean inLayer;
        boolean hitTestChildren;
        int depth$iv;
        HitTestResult this_$iv;
        boolean wasHit;
        boolean continueHitTest;
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        if (hitTestSource.shouldHitTestChildren(getLayoutNode())) {
            if (m3687withinLayerBoundsk4lQ0M(pointerPosition)) {
                inLayer = isInLayer;
                hitTestChildren = true;
            } else if (isTouchEvent) {
                float f = m3675distanceInMinimumTouchTargettz77jQw(pointerPosition, m3677getMinimumTouchTargetSizeNHjbRc());
                if ((Float.isInfinite(f) || Float.isNaN(f)) ? false : true) {
                    inLayer = false;
                    hitTestChildren = true;
                }
            }
            if (!hitTestChildren) {
                HitTestResult this_$iv2 = hitTestResult;
                int depth$iv2 = this_$iv2.hitDepth;
                MutableVector this_$iv3 = getLayoutNode().getZSortedChildren();
                int size$iv = this_$iv3.getSize();
                if (size$iv <= 0) {
                    depth$iv = depth$iv2;
                    this_$iv = this_$iv2;
                } else {
                    int i$iv = size$iv - 1;
                    Object[] content$iv = this_$iv3.getContent();
                    Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                    int i$iv2 = i$iv;
                    while (true) {
                        LayoutNode child = (LayoutNode) content$iv[i$iv2];
                        if (child.getIsPlaced()) {
                            depth$iv = depth$iv2;
                            this_$iv = this_$iv2;
                            hitTestSource.mo3688childHitTestYqVAtuI(child, pointerPosition, hitTestResult, isTouchEvent, inLayer);
                            boolean wasHit2 = hitTestResult.hasHit();
                            if (!wasHit2) {
                                continueHitTest = true;
                            } else if (child.getOuterCoordinator$ui_release().shouldSharePointerInputWithSiblings()) {
                                hitTestResult.acceptHits();
                                continueHitTest = true;
                            } else {
                                continueHitTest = false;
                            }
                            wasHit = !continueHitTest;
                        } else {
                            depth$iv = depth$iv2;
                            this_$iv = this_$iv2;
                            wasHit = false;
                        }
                        if (wasHit || i$iv2 - 1 < 0) {
                            break;
                        }
                        depth$iv2 = depth$iv;
                        this_$iv2 = this_$iv;
                    }
                }
                this_$iv.hitDepth = depth$iv;
                return;
            }
            return;
        }
        inLayer = isInLayer;
        hitTestChildren = false;
        if (!hitTestChildren) {
        }
    }

    /* compiled from: InnerNodeCoordinator.kt */
    @Metadata(m286d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m287d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator$Companion;", "", "()V", "innerBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getInnerBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Paint getInnerBoundsPaint() {
            return InnerNodeCoordinator.innerBoundsPaint;
        }
    }

    static {
        Paint paint = AndroidPaint_androidKt.Paint();
        paint.mo1880setColor8_81llA(Color.INSTANCE.m2030getRed0d7_KjU());
        paint.setStrokeWidth(1.0f);
        paint.mo1884setStylek9PVt8s(PaintingStyle.INSTANCE.m2227getStrokeTiuSbCo());
        innerBoundsPaint = paint;
    }
}
