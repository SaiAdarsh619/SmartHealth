package androidx.compose.p000ui.node;

import androidx.compose.p000ui.graphics.GraphicsLayerScope;
import androidx.compose.p000ui.layout.AlignmentLine;
import androidx.compose.p000ui.layout.LookaheadScope;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.node.LayoutNode;
import androidx.compose.p000ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.IntSizeKt;
import androidx.compose.runtime.collection.MutableVector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutNodeLayoutDelegate.kt */
@Metadata(m286d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001:\u0002TUB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010=\u001a\u00020>J\r\u0010?\u001a\u00020>H\u0000¢\u0006\u0002\b@J\r\u0010A\u001a\u00020>H\u0000¢\u0006\u0002\bBJ\r\u0010C\u001a\u00020>H\u0000¢\u0006\u0002\bDJ\r\u0010E\u001a\u00020>H\u0000¢\u0006\u0002\bFJ\u0017\u0010G\u001a\u00020>2\b\u0010H\u001a\u0004\u0018\u00010IH\u0000¢\u0006\u0002\bJJ\u001d\u0010K\u001a\u00020>2\u0006\u0010L\u001a\u00020\u0019H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ\u001d\u0010O\u001a\u00020>2\u0006\u0010L\u001a\u00020\u0019H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010NJ\u0006\u0010Q\u001a\u00020>J\u0006\u0010R\u001a\u00020>J\f\u0010S\u001a\u00020\u0010*\u00020\u0003H\u0002R\u0014\u0010\u0005\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00198Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00198Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u000e\u0010!\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\"@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010&\u001a\u0004\u0018\u00010\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\bR\u001e\u0010(\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0013R\u000e\u0010*\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0013R*\u0010.\u001a\b\u0018\u00010-R\u00020\u00002\f\u0010\u001e\u001a\b\u0018\u00010-R\u00020\u0000@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0018\u00101\u001a\u000602R\u00020\u0000X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001e\u00105\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0013R\u0011\u00107\u001a\u0002088F¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\r\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006V"}, m287d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner$ui_release", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "value", "", "childrenAccessingCoordinatesDuringPlacement", "getChildrenAccessingCoordinatesDuringPlacement", "()I", "setChildrenAccessingCoordinatesDuringPlacement", "(I)V", "", "coordinatesAccessedDuringPlacement", "getCoordinatesAccessedDuringPlacement", "()Z", "setCoordinatesAccessedDuringPlacement", "(Z)V", "height", "getHeight$ui_release", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastLookaheadConstraints", "getLastLookaheadConstraints-DWUhwKw", "<set-?>", "layoutPending", "getLayoutPending$ui_release", "layoutPendingForAlignment", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "layoutState", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "lookaheadAlignmentLinesOwner", "getLookaheadAlignmentLinesOwner$ui_release", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui_release", "lookaheadLayoutPendingForAlignment", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui_release", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "lookaheadPassDelegate", "getLookaheadPassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "measurePassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measurePending", "getMeasurePending$ui_release", "outerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getOuterCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "width", "getWidth$ui_release", "markChildrenDirty", "", "markLayoutPending", "markLayoutPending$ui_release", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui_release", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui_release", "markMeasurePending", "markMeasurePending$ui_release", "onLookaheadScopeChanged", "newScope", "Landroidx/compose/ui/layout/LookaheadScope;", "onLookaheadScopeChanged$ui_release", "performLookaheadMeasure", "constraints", "performLookaheadMeasure-BRTryo0", "(J)V", "performMeasure", "performMeasure-BRTryo0", "resetAlignmentLines", "updateParentData", "isOutMostLookaheadRoot", "LookaheadPassDelegate", "MeasurePassDelegate", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LayoutNodeLayoutDelegate {
    private int childrenAccessingCoordinatesDuringPlacement;
    private boolean coordinatesAccessedDuringPlacement;
    private final LayoutNode layoutNode;
    private boolean layoutPending;
    private boolean layoutPendingForAlignment;
    private LayoutNode.LayoutState layoutState;
    private boolean lookaheadLayoutPending;
    private boolean lookaheadLayoutPendingForAlignment;
    private boolean lookaheadMeasurePending;
    private LookaheadPassDelegate lookaheadPassDelegate;
    private final MeasurePassDelegate measurePassDelegate;
    private boolean measurePending;

    public LayoutNodeLayoutDelegate(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
        this.layoutState = LayoutNode.LayoutState.Idle;
        this.measurePassDelegate = new MeasurePassDelegate();
    }

    public final NodeCoordinator getOuterCoordinator() {
        return this.layoutNode.getNodes().getOuterCoordinator();
    }

    /* renamed from: getLastConstraints-DWUhwKw, reason: not valid java name */
    public final Constraints m3636getLastConstraintsDWUhwKw() {
        return this.measurePassDelegate.m3641getLastConstraintsDWUhwKw();
    }

    /* renamed from: getLastLookaheadConstraints-DWUhwKw, reason: not valid java name */
    public final Constraints m3637getLastLookaheadConstraintsDWUhwKw() {
        LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate != null) {
            return lookaheadPassDelegate.getLookaheadConstraints();
        }
        return null;
    }

    public final int getHeight$ui_release() {
        return this.measurePassDelegate.getHeight();
    }

    public final int getWidth$ui_release() {
        return this.measurePassDelegate.getWidth();
    }

    /* renamed from: getLayoutState$ui_release, reason: from getter */
    public final LayoutNode.LayoutState getLayoutState() {
        return this.layoutState;
    }

    /* renamed from: getMeasurePending$ui_release, reason: from getter */
    public final boolean getMeasurePending() {
        return this.measurePending;
    }

    /* renamed from: getLayoutPending$ui_release, reason: from getter */
    public final boolean getLayoutPending() {
        return this.layoutPending;
    }

    /* renamed from: getLookaheadMeasurePending$ui_release, reason: from getter */
    public final boolean getLookaheadMeasurePending() {
        return this.lookaheadMeasurePending;
    }

    /* renamed from: getLookaheadLayoutPending$ui_release, reason: from getter */
    public final boolean getLookaheadLayoutPending() {
        return this.lookaheadLayoutPending;
    }

    public final void markLayoutPending$ui_release() {
        this.layoutPending = true;
        this.layoutPendingForAlignment = true;
    }

    public final void markMeasurePending$ui_release() {
        this.measurePending = true;
    }

    public final void markLookaheadLayoutPending$ui_release() {
        this.lookaheadLayoutPending = true;
        this.lookaheadLayoutPendingForAlignment = true;
    }

    public final void markLookaheadMeasurePending$ui_release() {
        this.lookaheadMeasurePending = true;
    }

    public final AlignmentLinesOwner getAlignmentLinesOwner$ui_release() {
        return this.measurePassDelegate;
    }

    public final AlignmentLinesOwner getLookaheadAlignmentLinesOwner$ui_release() {
        return this.lookaheadPassDelegate;
    }

    public final boolean getCoordinatesAccessedDuringPlacement() {
        return this.coordinatesAccessedDuringPlacement;
    }

    public final void setCoordinatesAccessedDuringPlacement(boolean value) {
        boolean oldValue = this.coordinatesAccessedDuringPlacement;
        if (oldValue != value) {
            this.coordinatesAccessedDuringPlacement = value;
            if (value) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement + 1);
            } else {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement - 1);
            }
        }
    }

    public final int getChildrenAccessingCoordinatesDuringPlacement() {
        return this.childrenAccessingCoordinatesDuringPlacement;
    }

    public final void setChildrenAccessingCoordinatesDuringPlacement(int value) {
        int oldValue = this.childrenAccessingCoordinatesDuringPlacement;
        this.childrenAccessingCoordinatesDuringPlacement = value;
        if ((oldValue == 0) != (value == 0)) {
            LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
            LayoutNodeLayoutDelegate parentLayoutDelegate = parent$ui_release != null ? parent$ui_release.getLayoutDelegate() : null;
            if (parentLayoutDelegate != null) {
                if (value == 0) {
                    parentLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(parentLayoutDelegate.childrenAccessingCoordinatesDuringPlacement - 1);
                } else {
                    parentLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(parentLayoutDelegate.childrenAccessingCoordinatesDuringPlacement + 1);
                }
            }
        }
    }

    /* renamed from: getMeasurePassDelegate$ui_release, reason: from getter */
    public final MeasurePassDelegate getMeasurePassDelegate() {
        return this.measurePassDelegate;
    }

    /* renamed from: getLookaheadPassDelegate$ui_release, reason: from getter */
    public final LookaheadPassDelegate getLookaheadPassDelegate() {
        return this.lookaheadPassDelegate;
    }

    /* compiled from: LayoutNodeLayoutDelegate.kt */
    @Metadata(m286d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0014\u0010;\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020,0<H\u0016J\u001c\u0010>\u001a\u00020$2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$0\"H\u0016J\u0011\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020=H\u0096\u0002J\u000e\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020\u0010J\b\u0010D\u001a\u00020$H\u0016J\u0010\u0010E\u001a\u00020,2\u0006\u0010F\u001a\u00020,H\u0016J\u0010\u0010G\u001a\u00020,2\u0006\u0010H\u001a\u00020,H\u0016J\u001d\u0010I\u001a\u00020\u00022\u0006\u0010J\u001a\u00020\u001eH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u0010\u0010M\u001a\u00020,2\u0006\u0010F\u001a\u00020,H\u0016J\u0010\u0010N\u001a\u00020,2\u0006\u0010H\u001a\u00020,H\u0016J\u0006\u0010O\u001a\u00020$J\b\u0010P\u001a\u00020$H\u0002J\b\u0010Q\u001a\u00020$H\u0002J@\u0010R\u001a\u00020$2\u0006\u0010S\u001a\u00020'2\u0006\u0010T\u001a\u00020*2\u0019\u0010U\u001a\u0015\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"¢\u0006\u0002\b%H\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ@\u0010X\u001a\u00020$2\u0006\u0010S\u001a\u00020'2\u0006\u0010T\u001a\u00020*2\u0019\u0010U\u001a\u0015\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"¢\u0006\u0002\b%H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bY\u0010WJ\u001b\u0010Z\u001a\u00020\u00102\u0006\u0010J\u001a\u00020\u001eø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b[\u0010\\J\u0006\u0010]\u001a\u00020$J\b\u0010^\u001a\u00020$H\u0016J\b\u0010_\u001a\u00020$H\u0016J\u0006\u0010`\u001a\u00020\u0010J\f\u0010a\u001a\u00020$*\u00020bH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0012R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001e8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R!\u0010!\u001a\u0015\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"¢\u0006\u0002\b%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010&\u001a\u00020'X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010.R\u0016\u00102\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\"\u00107\u001a\u0004\u0018\u0001062\b\u00105\u001a\u0004\u0018\u000106@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u000e\u0010:\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006c"}, m287d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;)V", "_childMeasurables", "Landroidx/compose/runtime/collection/MutableVector;", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "childMeasurables", "", "getChildMeasurables$ui_release", "()Ljava/util/List;", "childMeasurablesDirty", "", "getChildMeasurablesDirty$ui_release", "()Z", "setChildMeasurablesDirty$ui_release", "(Z)V", "duringAlignmentLinesQuery", "getDuringAlignmentLinesQuery$ui_release", "setDuringAlignmentLinesQuery$ui_release", "innerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "isPlaced", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastLayerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "lastPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "lastZIndex", "", "measuredHeight", "", "getMeasuredHeight", "()I", "measuredOnce", "measuredWidth", "getMeasuredWidth", "parentAlignmentLinesOwner", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "<set-?>", "", "parentData", "getParentData", "()Ljava/lang/Object;", "placedOnce", "calculateAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "forEachChildAlignmentLinesOwner", "block", "get", "alignmentLine", "invalidateIntrinsicsParent", "forceRequest", "layoutChildren", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "notifyChildrenUsingCoordinatesWhilePlacing", "onBeforeLayoutChildren", "onIntrinsicsQueried", "placeAt", "position", "zIndex", "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeOuterCoordinator", "placeOuterCoordinator-f8xVGno", "remeasure", "remeasure-BRTryo0", "(J)Z", "replace", "requestLayout", "requestMeasure", "updateParentData", "trackMeasurementByParent", "Landroidx/compose/ui/node/LayoutNode;", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public final class MeasurePassDelegate extends Placeable implements Measurable, AlignmentLinesOwner {
        private boolean duringAlignmentLinesQuery;
        private Function1<? super GraphicsLayerScope, Unit> lastLayerBlock;
        private float lastZIndex;
        private boolean measuredOnce;
        private Object parentData;
        private boolean placedOnce;
        private long lastPosition = IntOffset.INSTANCE.m4510getZeronOccac();
        private final AlignmentLines alignmentLines = new LayoutNodeAlignmentLines(this);
        private final MutableVector<Measurable> _childMeasurables = new MutableVector<>(new Measurable[16], 0);
        private boolean childMeasurablesDirty = true;

        /* compiled from: LayoutNodeLayoutDelegate.kt */
        @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[LayoutNode.LayoutState.values().length];
                iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 1;
                iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
                iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
                iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        public MeasurePassDelegate() {
        }

        /* renamed from: getLastConstraints-DWUhwKw, reason: not valid java name */
        public final Constraints m3641getLastConstraintsDWUhwKw() {
            if (this.measuredOnce) {
                return Constraints.m4326boximpl(getMeasurementConstraints());
            }
            return null;
        }

        /* renamed from: getDuringAlignmentLinesQuery$ui_release, reason: from getter */
        public final boolean getDuringAlignmentLinesQuery() {
            return this.duringAlignmentLinesQuery;
        }

        public final void setDuringAlignmentLinesQuery$ui_release(boolean z) {
            this.duringAlignmentLinesQuery = z;
        }

        @Override // androidx.compose.p000ui.layout.Measured, androidx.compose.p000ui.layout.IntrinsicMeasurable
        public Object getParentData() {
            return this.parentData;
        }

        @Override // androidx.compose.p000ui.node.AlignmentLinesOwner
        /* renamed from: isPlaced */
        public boolean getIsPlaced() {
            return LayoutNodeLayoutDelegate.this.layoutNode.getIsPlaced();
        }

        @Override // androidx.compose.p000ui.node.AlignmentLinesOwner
        public NodeCoordinator getInnerCoordinator() {
            return LayoutNodeLayoutDelegate.this.layoutNode.getInnerCoordinator$ui_release();
        }

        @Override // androidx.compose.p000ui.node.AlignmentLinesOwner
        public AlignmentLines getAlignmentLines() {
            return this.alignmentLines;
        }

        /* renamed from: getChildMeasurablesDirty$ui_release, reason: from getter */
        public final boolean getChildMeasurablesDirty() {
            return this.childMeasurablesDirty;
        }

        public final void setChildMeasurablesDirty$ui_release(boolean z) {
            this.childMeasurablesDirty = z;
        }

        public final List<Measurable> getChildMeasurables$ui_release() {
            LayoutNodeLayoutDelegate.this.layoutNode.updateChildrenIfDirty$ui_release();
            if (!this.childMeasurablesDirty) {
                return this._childMeasurables.asMutableList();
            }
            LayoutNodeLayoutDelegateKt.updateChildMeasurables(LayoutNodeLayoutDelegate.this.layoutNode, this._childMeasurables, new Function1<LayoutNode, Measurable>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$childMeasurables$1
                @Override // kotlin.jvm.functions.Function1
                public final Measurable invoke(LayoutNode it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getLayoutDelegate().getMeasurePassDelegate();
                }
            });
            this.childMeasurablesDirty = false;
            return this._childMeasurables.asMutableList();
        }

        @Override // androidx.compose.p000ui.node.AlignmentLinesOwner
        public void layoutChildren() {
            getAlignmentLines().recalculateQueryOwner();
            if (LayoutNodeLayoutDelegate.this.getLayoutPending()) {
                onBeforeLayoutChildren();
            }
            if (LayoutNodeLayoutDelegate.this.layoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !getInnerCoordinator().getIsPlacingForAlignment() && LayoutNodeLayoutDelegate.this.getLayoutPending())) {
                LayoutNodeLayoutDelegate.this.layoutPending = false;
                LayoutNode.LayoutState oldLayoutState = LayoutNodeLayoutDelegate.this.getLayoutState();
                LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LayingOut;
                final LayoutNode $this$layoutChildren_u24lambda_u2d0 = LayoutNodeLayoutDelegate.this.layoutNode;
                final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
                Owner owner = LayoutNodeKt.requireOwner($this$layoutChildren_u24lambda_u2d0);
                owner.getSnapshotObserver().observeLayoutSnapshotReads$ui_release($this$layoutChildren_u24lambda_u2d0, false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildren$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        LayoutNodeLayoutDelegate.this.layoutNode.clearPlaceOrder$ui_release();
                        this.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildren$1$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                                invoke2(alignmentLinesOwner);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(AlignmentLinesOwner it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                it.getAlignmentLines().getUsedDuringParentLayout();
                            }
                        });
                        $this$layoutChildren_u24lambda_u2d0.getInnerCoordinator$ui_release().getMeasureResult$ui_release().placeChildren();
                        LayoutNodeLayoutDelegate.this.layoutNode.checkChildrenPlaceOrderForUpdates$ui_release();
                        this.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildren$1$1.2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                                invoke2(alignmentLinesOwner);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(AlignmentLinesOwner it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                it.getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(it.getAlignmentLines().getUsedDuringParentLayout());
                            }
                        });
                    }
                });
                LayoutNodeLayoutDelegate.this.layoutState = oldLayoutState;
                if (getInnerCoordinator().getIsPlacingForAlignment() && LayoutNodeLayoutDelegate.this.getCoordinatesAccessedDuringPlacement()) {
                    requestLayout();
                }
                LayoutNodeLayoutDelegate.this.layoutPendingForAlignment = false;
            }
            if (getAlignmentLines().getUsedDuringParentLayout()) {
                getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(true);
            }
            if (!getAlignmentLines().getDirty() || !getAlignmentLines().getRequired$ui_release()) {
                return;
            }
            getAlignmentLines().recalculate();
        }

        @Override // androidx.compose.p000ui.layout.Measurable
        /* renamed from: measure-BRTryo0 */
        public Placeable mo3492measureBRTryo0(long constraints) {
            if (LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent() == LayoutNode.UsageByParent.NotUsed) {
                LayoutNodeLayoutDelegate.this.layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
            }
            if (LayoutNodeLayoutDelegate.this.isOutMostLookaheadRoot(LayoutNodeLayoutDelegate.this.layoutNode)) {
                this.measuredOnce = true;
                m3539setMeasurementConstraintsBRTryo0(constraints);
                LayoutNodeLayoutDelegate.this.layoutNode.setMeasuredByParentInLookahead$ui_release(LayoutNode.UsageByParent.NotUsed);
                LookaheadPassDelegate lookaheadPassDelegate = LayoutNodeLayoutDelegate.this.getLookaheadPassDelegate();
                Intrinsics.checkNotNull(lookaheadPassDelegate);
                lookaheadPassDelegate.mo3492measureBRTryo0(constraints);
            }
            trackMeasurementByParent(LayoutNodeLayoutDelegate.this.layoutNode);
            m3642remeasureBRTryo0(constraints);
            return this;
        }

        /* renamed from: remeasure-BRTryo0, reason: not valid java name */
        public final boolean m3642remeasureBRTryo0(long constraints) {
            Owner owner = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode);
            LayoutNode parent = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            boolean sizeChanged = true;
            LayoutNodeLayoutDelegate.this.layoutNode.setCanMultiMeasure$ui_release(LayoutNodeLayoutDelegate.this.layoutNode.getCanMultiMeasure() || (parent != null && parent.getCanMultiMeasure()));
            if (!LayoutNodeLayoutDelegate.this.layoutNode.getMeasurePending$ui_release() && Constraints.m4331equalsimpl0(getMeasurementConstraints(), constraints)) {
                owner.forceMeasureTheSubtree(LayoutNodeLayoutDelegate.this.layoutNode);
                LayoutNodeLayoutDelegate.this.layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
                return false;
            }
            getAlignmentLines().setUsedByModifierMeasurement$ui_release(false);
            forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$remeasure$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                    invoke2(alignmentLinesOwner);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AlignmentLinesOwner it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.getAlignmentLines().setUsedDuringParentMeasurement$ui_release(false);
                }
            });
            this.measuredOnce = true;
            long outerPreviousMeasuredSize = LayoutNodeLayoutDelegate.this.getOuterCoordinator().mo3497getSizeYbymL2g();
            m3539setMeasurementConstraintsBRTryo0(constraints);
            LayoutNodeLayoutDelegate.this.m3635performMeasureBRTryo0(constraints);
            if (IntSize.m4540equalsimpl0(LayoutNodeLayoutDelegate.this.getOuterCoordinator().mo3497getSizeYbymL2g(), outerPreviousMeasuredSize) && LayoutNodeLayoutDelegate.this.getOuterCoordinator().getWidth() == getWidth() && LayoutNodeLayoutDelegate.this.getOuterCoordinator().getHeight() == getHeight()) {
                sizeChanged = false;
            }
            m3538setMeasuredSizeozmzZPI(IntSizeKt.IntSize(LayoutNodeLayoutDelegate.this.getOuterCoordinator().getWidth(), LayoutNodeLayoutDelegate.this.getOuterCoordinator().getHeight()));
            return sizeChanged;
        }

        private final void trackMeasurementByParent(LayoutNode $this$trackMeasurementByParent) {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode parent = $this$trackMeasurementByParent.getParent$ui_release();
            if (parent == null) {
                $this$trackMeasurementByParent.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                return;
            }
            if (!($this$trackMeasurementByParent.getMeasuredByParent() == LayoutNode.UsageByParent.NotUsed || $this$trackMeasurementByParent.getCanMultiMeasure())) {
                throw new IllegalStateException(("measure() may not be called multiple times on the same Measurable. Current state " + $this$trackMeasurementByParent.getMeasuredByParent() + ". Parent state " + parent.getLayoutState$ui_release() + '.').toString());
            }
            switch (WhenMappings.$EnumSwitchMapping$0[parent.getLayoutState$ui_release().ordinal()]) {
                case 1:
                    usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                    break;
                case 2:
                    usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                    break;
                default:
                    throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + parent.getLayoutState$ui_release());
            }
            $this$trackMeasurementByParent.setMeasuredByParent$ui_release(usageByParent);
        }

        @Override // androidx.compose.p000ui.layout.Placeable, androidx.compose.p000ui.layout.Measured
        public int getMeasuredWidth() {
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().getMeasuredWidth();
        }

        @Override // androidx.compose.p000ui.layout.Placeable, androidx.compose.p000ui.layout.Measured
        public int getMeasuredHeight() {
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().getMeasuredHeight();
        }

        @Override // androidx.compose.p000ui.layout.Measured
        public int get(AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if ((parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null) != LayoutNode.LayoutState.Measuring) {
                LayoutNode parent$ui_release2 = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
                if ((parent$ui_release2 != null ? parent$ui_release2.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.LayingOut) {
                    getAlignmentLines().setUsedDuringParentLayout$ui_release(true);
                }
            } else {
                getAlignmentLines().setUsedDuringParentMeasurement$ui_release(true);
            }
            this.duringAlignmentLinesQuery = true;
            int result = LayoutNodeLayoutDelegate.this.getOuterCoordinator().get(alignmentLine);
            this.duringAlignmentLinesQuery = false;
            return result;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.compose.p000ui.layout.Placeable
        /* renamed from: placeAt-f8xVGno */
        public void mo3493placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            if (!IntOffset.m4499equalsimpl0(position, this.lastPosition)) {
                notifyChildrenUsingCoordinatesWhilePlacing();
            }
            if (LayoutNodeLayoutDelegate.this.isOutMostLookaheadRoot(LayoutNodeLayoutDelegate.this.layoutNode)) {
                Placeable.PlacementScope.Companion $this$placeAt_f8xVGno_u24lambda_u2d2 = Placeable.PlacementScope.INSTANCE;
                LookaheadPassDelegate lookaheadPassDelegate = LayoutNodeLayoutDelegate.this.getLookaheadPassDelegate();
                Intrinsics.checkNotNull(lookaheadPassDelegate);
                Placeable.PlacementScope.place$default($this$placeAt_f8xVGno_u24lambda_u2d2, lookaheadPassDelegate, IntOffset.m4500getXimpl(position), IntOffset.m4501getYimpl(position), 0.0f, 4, null);
            }
            LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LayingOut;
            m3640placeOuterCoordinatorf8xVGno(position, zIndex, layerBlock);
            LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.Idle;
        }

        /* renamed from: placeOuterCoordinator-f8xVGno, reason: not valid java name */
        private final void m3640placeOuterCoordinatorf8xVGno(final long position, final float zIndex, final Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            this.lastPosition = position;
            this.lastZIndex = zIndex;
            this.lastLayerBlock = layerBlock;
            this.placedOnce = true;
            getAlignmentLines().setUsedByModifierLayout$ui_release(false);
            LayoutNodeLayoutDelegate.this.setCoordinatesAccessedDuringPlacement(false);
            Owner owner = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode);
            OwnerSnapshotObserver snapshotObserver = owner.getSnapshotObserver();
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
            final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            snapshotObserver.observeLayoutModifierSnapshotReads$ui_release(layoutNode, false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinator$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Placeable.PlacementScope.Companion $this$invoke_u24lambda_u2d0 = Placeable.PlacementScope.INSTANCE;
                    Function1<GraphicsLayerScope, Unit> function1 = layerBlock;
                    LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = layoutNodeLayoutDelegate;
                    long j = position;
                    float f = zIndex;
                    if (function1 == null) {
                        $this$invoke_u24lambda_u2d0.m3544place70tqf50(layoutNodeLayoutDelegate2.getOuterCoordinator(), j, f);
                    } else {
                        $this$invoke_u24lambda_u2d0.m3549placeWithLayeraW9wM(layoutNodeLayoutDelegate2.getOuterCoordinator(), j, f, function1);
                    }
                }
            });
        }

        public final void replace() {
            if (!this.placedOnce) {
                throw new IllegalStateException("Check failed.".toString());
            }
            m3640placeOuterCoordinatorf8xVGno(this.lastPosition, this.lastZIndex, this.lastLayerBlock);
        }

        @Override // androidx.compose.p000ui.layout.IntrinsicMeasurable
        public int minIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().minIntrinsicWidth(height);
        }

        @Override // androidx.compose.p000ui.layout.IntrinsicMeasurable
        public int maxIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().maxIntrinsicWidth(height);
        }

        @Override // androidx.compose.p000ui.layout.IntrinsicMeasurable
        public int minIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().minIntrinsicHeight(width);
        }

        @Override // androidx.compose.p000ui.layout.IntrinsicMeasurable
        public int maxIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().maxIntrinsicHeight(width);
        }

        private final void onIntrinsicsQueried() {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode.requestRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 1, null);
            LayoutNode parent = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent != null && LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent() == LayoutNode.UsageByParent.NotUsed) {
                LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
                switch (WhenMappings.$EnumSwitchMapping$0[parent.getLayoutState$ui_release().ordinal()]) {
                    case 1:
                        usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                        break;
                    case 2:
                        usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                        break;
                    default:
                        usageByParent = parent.getIntrinsicsUsageByParent();
                        break;
                }
                layoutNode.setIntrinsicsUsageByParent$ui_release(usageByParent);
            }
        }

        public final boolean updateParentData() {
            boolean changed = !Intrinsics.areEqual(getParentData(), LayoutNodeLayoutDelegate.this.getOuterCoordinator().getParentData());
            this.parentData = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getParentData();
            return changed;
        }

        @Override // androidx.compose.p000ui.node.AlignmentLinesOwner
        public Map<AlignmentLine, Integer> calculateAlignmentLines() {
            if (!this.duringAlignmentLinesQuery) {
                if (LayoutNodeLayoutDelegate.this.getLayoutState() == LayoutNode.LayoutState.Measuring) {
                    getAlignmentLines().setUsedByModifierMeasurement$ui_release(true);
                    if (getAlignmentLines().getDirty()) {
                        LayoutNodeLayoutDelegate.this.markLayoutPending$ui_release();
                    }
                } else {
                    getAlignmentLines().setUsedByModifierLayout$ui_release(true);
                }
            }
            getInnerCoordinator().setPlacingForAlignment$ui_release(true);
            layoutChildren();
            getInnerCoordinator().setPlacingForAlignment$ui_release(false);
            return getAlignmentLines().getLastCalculation();
        }

        @Override // androidx.compose.p000ui.node.AlignmentLinesOwner
        public AlignmentLinesOwner getParentAlignmentLinesOwner() {
            LayoutNodeLayoutDelegate layoutDelegate;
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent$ui_release == null || (layoutDelegate = parent$ui_release.getLayoutDelegate()) == null) {
                return null;
            }
            return layoutDelegate.getAlignmentLinesOwner$ui_release();
        }

        @Override // androidx.compose.p000ui.node.AlignmentLinesOwner
        public void forEachChildAlignmentLinesOwner(Function1<? super AlignmentLinesOwner, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            List $this$fastForEach$iv = LayoutNodeLayoutDelegate.this.layoutNode.getChildren$ui_release();
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                LayoutNode it = (LayoutNode) item$iv;
                block.invoke(it.getLayoutDelegate().getAlignmentLinesOwner$ui_release());
            }
        }

        @Override // androidx.compose.p000ui.node.AlignmentLinesOwner
        public void requestLayout() {
            LayoutNode.requestRelayout$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 1, null);
        }

        @Override // androidx.compose.p000ui.node.AlignmentLinesOwner
        public void requestMeasure() {
            LayoutNode.requestRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 1, null);
        }

        public final void notifyChildrenUsingCoordinatesWhilePlacing() {
            if (LayoutNodeLayoutDelegate.this.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                List $this$fastForEach$iv = LayoutNodeLayoutDelegate.this.layoutNode.getChildren$ui_release();
                int size = $this$fastForEach$iv.size();
                for (int index$iv = 0; index$iv < size; index$iv++) {
                    Object item$iv = $this$fastForEach$iv.get(index$iv);
                    LayoutNode child = (LayoutNode) item$iv;
                    LayoutNodeLayoutDelegate childLayoutDelegate = child.getLayoutDelegate();
                    if (childLayoutDelegate.getCoordinatesAccessedDuringPlacement() && !childLayoutDelegate.getLayoutPending()) {
                        LayoutNode.requestRelayout$ui_release$default(child, false, 1, null);
                    }
                    childLayoutDelegate.getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
                }
            }
        }

        private final void onBeforeLayoutChildren() {
            LayoutNode this_$iv = LayoutNodeLayoutDelegate.this.layoutNode;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            MutableVector this_$iv$iv = this_$iv.get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv <= 0) {
                return;
            }
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                if (it.getMeasurePending$ui_release() && it.getMeasuredByParent() == LayoutNode.UsageByParent.InMeasureBlock && LayoutNode.m3620remeasure_Sx5XlM$ui_release$default(it, null, 1, null)) {
                    LayoutNode.requestRemeasure$ui_release$default(layoutNodeLayoutDelegate.layoutNode, false, 1, null);
                }
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }

        public final void invalidateIntrinsicsParent(boolean forceRequest) {
            LayoutNode parent$ui_release;
            LayoutNode parent = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            LayoutNode.UsageByParent intrinsicsUsageByParent = LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent();
            if (parent != null && intrinsicsUsageByParent != LayoutNode.UsageByParent.NotUsed) {
                LayoutNode intrinsicsUsingParent = parent;
                while (intrinsicsUsingParent.getIntrinsicsUsageByParent() == intrinsicsUsageByParent && (parent$ui_release = intrinsicsUsingParent.getParent$ui_release()) != null) {
                    intrinsicsUsingParent = parent$ui_release;
                }
                switch (WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent.ordinal()]) {
                    case 1:
                        intrinsicsUsingParent.requestRemeasure$ui_release(forceRequest);
                        return;
                    case 2:
                        intrinsicsUsingParent.requestRelayout$ui_release(forceRequest);
                        return;
                    default:
                        throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
                }
            }
        }
    }

    /* compiled from: LayoutNodeLayoutDelegate.kt */
    @Metadata(m286d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u00109\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020*0:H\u0016J\u001c\u0010<\u001a\u00020=2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020=0?H\u0016J!\u0010@\u001a\u00020=2\u0016\u0010>\u001a\u0012\u0012\b\u0012\u00060\u0000R\u00020A\u0012\u0004\u0012\u00020=0?H\u0082\bJ\u0011\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020;H\u0096\u0002J\u000e\u0010D\u001a\u00020=2\u0006\u0010E\u001a\u00020\u0012J\b\u0010F\u001a\u00020=H\u0016J\b\u0010G\u001a\u00020=H\u0002J\u0010\u0010H\u001a\u00020*2\u0006\u0010I\u001a\u00020*H\u0016J\u0010\u0010J\u001a\u00020*2\u0006\u0010K\u001a\u00020*H\u0016J\u001d\u0010L\u001a\u00020\u00012\u0006\u0010M\u001a\u00020\"H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010OJ\u0010\u0010P\u001a\u00020*2\u0006\u0010I\u001a\u00020*H\u0016J\u0010\u0010Q\u001a\u00020*2\u0006\u0010K\u001a\u00020*H\u0016J\u0006\u0010R\u001a\u00020=J\b\u0010S\u001a\u00020=H\u0002J\b\u0010T\u001a\u00020=H\u0002J\u0006\u0010U\u001a\u00020=J@\u0010V\u001a\u00020=2\u0006\u0010W\u001a\u00020&2\u0006\u0010X\u001a\u00020Y2\u0019\u0010Z\u001a\u0015\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020=\u0018\u00010?¢\u0006\u0002\b\\H\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b]\u0010^J\u001b\u0010_\u001a\u00020\u00122\u0006\u0010M\u001a\u00020\"ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010aJ\u0006\u0010b\u001a\u00020=J\b\u0010c\u001a\u00020=H\u0016J\b\u0010d\u001a\u00020=H\u0016J\b\u0010e\u001a\u00020=H\u0002J\u0006\u0010f\u001a\u00020\u0012J\f\u0010g\u001a\u00020=*\u00020hH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u000e\u0010 \u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\"8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0019\u0010%\u001a\u00020&X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010'R\u0019\u0010(\u001a\u0004\u0018\u00010\"X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010,R\u0016\u00100\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\"\u00105\u001a\u0004\u0018\u0001042\b\u00103\u001a\u0004\u0018\u000104@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u000e\u00108\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006i"}, m287d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;Landroidx/compose/ui/layout/LookaheadScope;)V", "_childMeasurables", "Landroidx/compose/runtime/collection/MutableVector;", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "childMeasurables", "", "getChildMeasurables$ui_release", "()Ljava/util/List;", "childMeasurablesDirty", "", "getChildMeasurablesDirty$ui_release", "()Z", "setChildMeasurablesDirty$ui_release", "(Z)V", "duringAlignmentLinesQuery", "getDuringAlignmentLinesQuery$ui_release", "setDuringAlignmentLinesQuery$ui_release", "innerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "isPlaced", "setPlaced", "isPreviouslyPlaced", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "lookaheadConstraints", "measuredHeight", "", "getMeasuredHeight", "()I", "measuredOnce", "measuredWidth", "getMeasuredWidth", "parentAlignmentLinesOwner", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "<set-?>", "", "parentData", "getParentData", "()Ljava/lang/Object;", "placedOnce", "calculateAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "forEachChildAlignmentLinesOwner", "", "block", "Lkotlin/Function1;", "forEachChildDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "get", "alignmentLine", "invalidateIntrinsicsParent", "forceRequest", "layoutChildren", "markSubtreeNotPlaced", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "notifyChildrenUsingCoordinatesWhilePlacing", "onBeforeLayoutChildren", "onIntrinsicsQueried", "onPlaced", "placeAt", "position", "zIndex", "", "layerBlock", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "remeasure", "remeasure-BRTryo0", "(J)Z", "replace", "requestLayout", "requestMeasure", "requestSubtreeForLookahead", "updateParentData", "trackLookaheadMeasurementByParent", "Landroidx/compose/ui/node/LayoutNode;", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public final class LookaheadPassDelegate extends Placeable implements Measurable, AlignmentLinesOwner {
        private final MutableVector<Measurable> _childMeasurables;
        private final AlignmentLines alignmentLines;
        private boolean childMeasurablesDirty;
        private boolean duringAlignmentLinesQuery;
        private boolean isPlaced;
        private boolean isPreviouslyPlaced;
        private long lastPosition;
        private Constraints lookaheadConstraints;
        private final LookaheadScope lookaheadScope;
        private boolean measuredOnce;
        private Object parentData;
        private boolean placedOnce;
        final /* synthetic */ LayoutNodeLayoutDelegate this$0;

        /* compiled from: LayoutNodeLayoutDelegate.kt */
        @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[LayoutNode.LayoutState.values().length];
                iArr[LayoutNode.LayoutState.LookaheadMeasuring.ordinal()] = 1;
                iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 2;
                iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 3;
                iArr[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 4;
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
                iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
                iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        public LookaheadPassDelegate(LayoutNodeLayoutDelegate this$0, LookaheadScope lookaheadScope) {
            Intrinsics.checkNotNullParameter(lookaheadScope, "lookaheadScope");
            this.this$0 = this$0;
            this.lookaheadScope = lookaheadScope;
            this.lastPosition = IntOffset.INSTANCE.m4510getZeronOccac();
            this.isPlaced = true;
            this.alignmentLines = new LookaheadAlignmentLines(this);
            this._childMeasurables = new MutableVector<>(new Measurable[16], 0);
            this.childMeasurablesDirty = true;
            this.parentData = this.this$0.getMeasurePassDelegate().getParentData();
        }

        /* renamed from: getDuringAlignmentLinesQuery$ui_release, reason: from getter */
        public final boolean getDuringAlignmentLinesQuery() {
            return this.duringAlignmentLinesQuery;
        }

        public final void setDuringAlignmentLinesQuery$ui_release(boolean z) {
            this.duringAlignmentLinesQuery = z;
        }

        /* renamed from: getLastConstraints-DWUhwKw, reason: not valid java name and from getter */
        public final Constraints getLookaheadConstraints() {
            return this.lookaheadConstraints;
        }

        @Override // androidx.compose.p000ui.node.AlignmentLinesOwner
        /* renamed from: isPlaced, reason: from getter */
        public boolean getIsPlaced() {
            return this.isPlaced;
        }

        public void setPlaced(boolean z) {
            this.isPlaced = z;
        }

        @Override // androidx.compose.p000ui.node.AlignmentLinesOwner
        public NodeCoordinator getInnerCoordinator() {
            return this.this$0.layoutNode.getInnerCoordinator$ui_release();
        }

        @Override // androidx.compose.p000ui.node.AlignmentLinesOwner
        public AlignmentLines getAlignmentLines() {
            return this.alignmentLines;
        }

        /* renamed from: getChildMeasurablesDirty$ui_release, reason: from getter */
        public final boolean getChildMeasurablesDirty() {
            return this.childMeasurablesDirty;
        }

        public final void setChildMeasurablesDirty$ui_release(boolean z) {
            this.childMeasurablesDirty = z;
        }

        public final List<Measurable> getChildMeasurables$ui_release() {
            this.this$0.layoutNode.getChildren$ui_release();
            if (!this.childMeasurablesDirty) {
                return this._childMeasurables.asMutableList();
            }
            LayoutNodeLayoutDelegateKt.updateChildMeasurables(this.this$0.layoutNode, this._childMeasurables, new Function1<LayoutNode, Measurable>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$childMeasurables$2
                @Override // kotlin.jvm.functions.Function1
                public final Measurable invoke(LayoutNode it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = it.getLayoutDelegate().getLookaheadPassDelegate();
                    Intrinsics.checkNotNull(lookaheadPassDelegate);
                    return lookaheadPassDelegate;
                }
            });
            this.childMeasurablesDirty = false;
            return this._childMeasurables.asMutableList();
        }

        private final void forEachChildDelegate(Function1<? super LookaheadPassDelegate, Unit> block) {
            LayoutNode this_$iv = this.this$0.layoutNode;
            MutableVector this_$iv$iv = this_$iv.get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv <= 0) {
                return;
            }
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                LookaheadPassDelegate lookaheadPassDelegate = it.getLayoutDelegate().getLookaheadPassDelegate();
                Intrinsics.checkNotNull(lookaheadPassDelegate);
                block.invoke(lookaheadPassDelegate);
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }

        @Override // androidx.compose.p000ui.node.AlignmentLinesOwner
        public void layoutChildren() {
            getAlignmentLines().recalculateQueryOwner();
            if (this.this$0.getLookaheadLayoutPending()) {
                onBeforeLayoutChildren();
            }
            final LookaheadDelegate lookaheadDelegate = getInnerCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            if (this.this$0.lookaheadLayoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !lookaheadDelegate.getIsPlacingForAlignment() && this.this$0.getLookaheadLayoutPending())) {
                this.this$0.lookaheadLayoutPending = false;
                LayoutNode.LayoutState oldLayoutState = this.this$0.getLayoutState();
                this.this$0.layoutState = LayoutNode.LayoutState.LookaheadLayingOut;
                Owner owner = LayoutNodeKt.requireOwner(this.this$0.layoutNode);
                OwnerSnapshotObserver snapshotObserver = owner.getSnapshotObserver();
                LayoutNode layoutNode = this.this$0.layoutNode;
                final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.this$0;
                OwnerSnapshotObserver.observeLayoutSnapshotReads$ui_release$default(snapshotObserver, layoutNode, false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        LayoutNodeLayoutDelegate.LookaheadPassDelegate this_$iv = LayoutNodeLayoutDelegate.LookaheadPassDelegate.this;
                        MutableVector this_$iv$iv$iv = this_$iv.this$0.layoutNode.get_children$ui_release();
                        int size$iv$iv$iv = this_$iv$iv$iv.getSize();
                        if (size$iv$iv$iv > 0) {
                            int i$iv$iv$iv = 0;
                            Object[] content$iv$iv$iv = this_$iv$iv$iv.getContent();
                            Intrinsics.checkNotNull(content$iv$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                            do {
                                LayoutNode it$iv = (LayoutNode) content$iv$iv$iv[i$iv$iv$iv];
                                LayoutNodeLayoutDelegate.LookaheadPassDelegate it = it$iv.getLayoutDelegate().getLookaheadPassDelegate();
                                Intrinsics.checkNotNull(it);
                                it.isPreviouslyPlaced = it.getIsPlaced();
                                it.setPlaced(false);
                                i$iv$iv$iv++;
                            } while (i$iv$iv$iv < size$iv$iv$iv);
                        }
                        LayoutNode this_$iv2 = layoutNodeLayoutDelegate.layoutNode;
                        MutableVector this_$iv$iv = this_$iv2.get_children$ui_release();
                        int size$iv$iv = this_$iv$iv.getSize();
                        if (size$iv$iv > 0) {
                            int i$iv$iv = 0;
                            Object[] content$iv$iv = this_$iv$iv.getContent();
                            Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                            do {
                                LayoutNode it2 = (LayoutNode) content$iv$iv[i$iv$iv];
                                if (it2.getMeasuredByParentInLookahead() == LayoutNode.UsageByParent.InLayoutBlock) {
                                    it2.setMeasuredByParentInLookahead$ui_release(LayoutNode.UsageByParent.NotUsed);
                                }
                                i$iv$iv++;
                            } while (i$iv$iv < size$iv$iv);
                        }
                        LayoutNodeLayoutDelegate.LookaheadPassDelegate.this.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1.3
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                                invoke2(alignmentLinesOwner);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(AlignmentLinesOwner child) {
                                Intrinsics.checkNotNullParameter(child, "child");
                                child.getAlignmentLines().setUsedDuringParentLayout$ui_release(false);
                            }
                        });
                        lookaheadDelegate.getMeasureResult$ui_release().placeChildren();
                        LayoutNodeLayoutDelegate.LookaheadPassDelegate.this.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1.4
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                                invoke2(alignmentLinesOwner);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(AlignmentLinesOwner child) {
                                Intrinsics.checkNotNullParameter(child, "child");
                                child.getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(child.getAlignmentLines().getUsedDuringParentLayout());
                            }
                        });
                        LayoutNodeLayoutDelegate.LookaheadPassDelegate this_$iv3 = LayoutNodeLayoutDelegate.LookaheadPassDelegate.this;
                        MutableVector this_$iv$iv$iv2 = this_$iv3.this$0.layoutNode.get_children$ui_release();
                        int size$iv$iv$iv2 = this_$iv$iv$iv2.getSize();
                        if (size$iv$iv$iv2 <= 0) {
                            return;
                        }
                        int i$iv$iv$iv2 = 0;
                        Object[] content$iv$iv$iv2 = this_$iv$iv$iv2.getContent();
                        Intrinsics.checkNotNull(content$iv$iv$iv2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                        do {
                            LayoutNode it$iv2 = (LayoutNode) content$iv$iv$iv2[i$iv$iv$iv2];
                            LayoutNodeLayoutDelegate.LookaheadPassDelegate it3 = it$iv2.getLayoutDelegate().getLookaheadPassDelegate();
                            Intrinsics.checkNotNull(it3);
                            if (!it3.getIsPlaced()) {
                                it3.markSubtreeNotPlaced();
                            }
                            i$iv$iv$iv2++;
                        } while (i$iv$iv$iv2 < size$iv$iv$iv2);
                    }
                }, 2, null);
                this.this$0.layoutState = oldLayoutState;
                if (this.this$0.getCoordinatesAccessedDuringPlacement() && lookaheadDelegate.getIsPlacingForAlignment()) {
                    requestLayout();
                }
                this.this$0.lookaheadLayoutPendingForAlignment = false;
            }
            if (getAlignmentLines().getUsedDuringParentLayout()) {
                getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(true);
            }
            if (!getAlignmentLines().getDirty() || !getAlignmentLines().getRequired$ui_release()) {
                return;
            }
            getAlignmentLines().recalculate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void markSubtreeNotPlaced() {
            setPlaced(false);
            LayoutNode this_$iv$iv = this.this$0.layoutNode;
            MutableVector this_$iv$iv$iv = this_$iv$iv.get_children$ui_release();
            int size$iv$iv$iv = this_$iv$iv$iv.getSize();
            if (size$iv$iv$iv <= 0) {
                return;
            }
            int i$iv$iv$iv = 0;
            Object[] content$iv$iv$iv = this_$iv$iv$iv.getContent();
            Intrinsics.checkNotNull(content$iv$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                LayoutNode it$iv = (LayoutNode) content$iv$iv$iv[i$iv$iv$iv];
                LookaheadPassDelegate it = it$iv.getLayoutDelegate().getLookaheadPassDelegate();
                Intrinsics.checkNotNull(it);
                it.markSubtreeNotPlaced();
                i$iv$iv$iv++;
            } while (i$iv$iv$iv < size$iv$iv$iv);
        }

        @Override // androidx.compose.p000ui.node.AlignmentLinesOwner
        public Map<AlignmentLine, Integer> calculateAlignmentLines() {
            if (!this.duringAlignmentLinesQuery) {
                if (this.this$0.getLayoutState() == LayoutNode.LayoutState.LookaheadMeasuring) {
                    getAlignmentLines().setUsedByModifierMeasurement$ui_release(true);
                    if (getAlignmentLines().getDirty()) {
                        this.this$0.markLookaheadLayoutPending$ui_release();
                    }
                } else {
                    getAlignmentLines().setUsedByModifierLayout$ui_release(true);
                }
            }
            LookaheadDelegate lookaheadDelegate = getInnerCoordinator().getLookaheadDelegate();
            if (lookaheadDelegate != null) {
                lookaheadDelegate.setPlacingForAlignment$ui_release(true);
            }
            layoutChildren();
            LookaheadDelegate lookaheadDelegate2 = getInnerCoordinator().getLookaheadDelegate();
            if (lookaheadDelegate2 != null) {
                lookaheadDelegate2.setPlacingForAlignment$ui_release(false);
            }
            return getAlignmentLines().getLastCalculation();
        }

        @Override // androidx.compose.p000ui.node.AlignmentLinesOwner
        public AlignmentLinesOwner getParentAlignmentLinesOwner() {
            LayoutNodeLayoutDelegate layoutDelegate;
            LayoutNode parent$ui_release = this.this$0.layoutNode.getParent$ui_release();
            if (parent$ui_release == null || (layoutDelegate = parent$ui_release.getLayoutDelegate()) == null) {
                return null;
            }
            return layoutDelegate.getLookaheadAlignmentLinesOwner$ui_release();
        }

        @Override // androidx.compose.p000ui.node.AlignmentLinesOwner
        public void forEachChildAlignmentLinesOwner(Function1<? super AlignmentLinesOwner, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            List $this$fastForEach$iv = this.this$0.layoutNode.getChildren$ui_release();
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                LayoutNode it = (LayoutNode) item$iv;
                AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = it.getLayoutDelegate().getLookaheadAlignmentLinesOwner$ui_release();
                Intrinsics.checkNotNull(lookaheadAlignmentLinesOwner$ui_release);
                block.invoke(lookaheadAlignmentLinesOwner$ui_release);
            }
        }

        @Override // androidx.compose.p000ui.node.AlignmentLinesOwner
        public void requestLayout() {
            LayoutNode.requestLookaheadRelayout$ui_release$default(this.this$0.layoutNode, false, 1, null);
        }

        @Override // androidx.compose.p000ui.node.AlignmentLinesOwner
        public void requestMeasure() {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(this.this$0.layoutNode, false, 1, null);
        }

        public final void notifyChildrenUsingCoordinatesWhilePlacing() {
            if (this.this$0.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                List $this$fastForEach$iv = this.this$0.layoutNode.getChildren$ui_release();
                int size = $this$fastForEach$iv.size();
                for (int index$iv = 0; index$iv < size; index$iv++) {
                    Object item$iv = $this$fastForEach$iv.get(index$iv);
                    LayoutNode child = (LayoutNode) item$iv;
                    LayoutNodeLayoutDelegate childLayoutDelegate = child.getLayoutDelegate();
                    if (childLayoutDelegate.getCoordinatesAccessedDuringPlacement() && !childLayoutDelegate.getLayoutPending()) {
                        LayoutNode.requestLookaheadRelayout$ui_release$default(child, false, 1, null);
                    }
                    LookaheadPassDelegate lookaheadPassDelegate = childLayoutDelegate.getLookaheadPassDelegate();
                    if (lookaheadPassDelegate != null) {
                        lookaheadPassDelegate.notifyChildrenUsingCoordinatesWhilePlacing();
                    }
                }
            }
        }

        @Override // androidx.compose.p000ui.layout.Measurable
        /* renamed from: measure-BRTryo0 */
        public Placeable mo3492measureBRTryo0(long constraints) {
            trackLookaheadMeasurementByParent(this.this$0.layoutNode);
            if (this.this$0.layoutNode.getIntrinsicsUsageByParent() == LayoutNode.UsageByParent.NotUsed) {
                this.this$0.layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
            }
            m3639remeasureBRTryo0(constraints);
            return this;
        }

        private final void trackLookaheadMeasurementByParent(LayoutNode $this$trackLookaheadMeasurementByParent) {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode parent = $this$trackLookaheadMeasurementByParent.getParent$ui_release();
            if (parent == null) {
                $this$trackLookaheadMeasurementByParent.setMeasuredByParentInLookahead$ui_release(LayoutNode.UsageByParent.NotUsed);
                return;
            }
            if (!($this$trackLookaheadMeasurementByParent.getMeasuredByParentInLookahead() == LayoutNode.UsageByParent.NotUsed || $this$trackLookaheadMeasurementByParent.getCanMultiMeasure())) {
                throw new IllegalStateException(("measure() may not be called multiple times on the same Measurable. Current state " + $this$trackLookaheadMeasurementByParent.getMeasuredByParentInLookahead() + ". Parent state " + parent.getLayoutState$ui_release() + '.').toString());
            }
            switch (WhenMappings.$EnumSwitchMapping$0[parent.getLayoutState$ui_release().ordinal()]) {
                case 1:
                case 2:
                    usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                    break;
                case 3:
                case 4:
                    usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                    break;
                default:
                    throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + parent.getLayoutState$ui_release());
            }
            $this$trackLookaheadMeasurementByParent.setMeasuredByParentInLookahead$ui_release(usageByParent);
        }

        @Override // androidx.compose.p000ui.layout.Measured, androidx.compose.p000ui.layout.IntrinsicMeasurable
        public Object getParentData() {
            return this.parentData;
        }

        /* renamed from: remeasure-BRTryo0, reason: not valid java name */
        public final boolean m3639remeasureBRTryo0(long constraints) {
            LayoutNode parent = this.this$0.layoutNode.getParent$ui_release();
            boolean z = true;
            this.this$0.layoutNode.setCanMultiMeasure$ui_release(this.this$0.layoutNode.getCanMultiMeasure() || (parent != null && parent.getCanMultiMeasure()));
            if (!this.this$0.layoutNode.getLookaheadMeasurePending$ui_release()) {
                Constraints constraints2 = this.lookaheadConstraints;
                if (constraints2 == null ? false : Constraints.m4331equalsimpl0(constraints2.getValue(), constraints)) {
                    return false;
                }
            }
            this.lookaheadConstraints = Constraints.m4326boximpl(constraints);
            getAlignmentLines().setUsedByModifierMeasurement$ui_release(false);
            forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$remeasure$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                    invoke2(alignmentLinesOwner);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AlignmentLinesOwner it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.getAlignmentLines().setUsedDuringParentMeasurement$ui_release(false);
                }
            });
            this.measuredOnce = true;
            LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            if (!(lookaheadDelegate != null)) {
                throw new IllegalStateException("Lookahead result from lookaheadRemeasure cannot be null".toString());
            }
            long lastLookaheadSize = IntSizeKt.IntSize(lookaheadDelegate.getWidth(), lookaheadDelegate.getHeight());
            this.this$0.m3634performLookaheadMeasureBRTryo0(constraints);
            m3538setMeasuredSizeozmzZPI(IntSizeKt.IntSize(lookaheadDelegate.getWidth(), lookaheadDelegate.getHeight()));
            if (IntSize.m4542getWidthimpl(lastLookaheadSize) == lookaheadDelegate.getWidth() && IntSize.m4541getHeightimpl(lastLookaheadSize) == lookaheadDelegate.getHeight()) {
                z = false;
            }
            boolean sizeChanged = z;
            return sizeChanged;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.compose.p000ui.layout.Placeable
        /* renamed from: placeAt-f8xVGno */
        public void mo3493placeAtf8xVGno(final long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            this.this$0.layoutState = LayoutNode.LayoutState.LookaheadLayingOut;
            this.placedOnce = true;
            if (!IntOffset.m4499equalsimpl0(position, this.lastPosition)) {
                notifyChildrenUsingCoordinatesWhilePlacing();
            }
            getAlignmentLines().setUsedByModifierLayout$ui_release(false);
            Owner owner = LayoutNodeKt.requireOwner(this.this$0.layoutNode);
            this.this$0.setCoordinatesAccessedDuringPlacement(false);
            OwnerSnapshotObserver snapshotObserver = owner.getSnapshotObserver();
            LayoutNode layoutNode = this.this$0.layoutNode;
            final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.this$0;
            OwnerSnapshotObserver.observeLayoutModifierSnapshotReads$ui_release$default(snapshotObserver, layoutNode, false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$placeAt$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Placeable.PlacementScope.Companion $this$invoke_u24lambda_u2d0 = Placeable.PlacementScope.INSTANCE;
                    LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = LayoutNodeLayoutDelegate.this;
                    long j = position;
                    LookaheadDelegate lookaheadDelegate = layoutNodeLayoutDelegate2.getOuterCoordinator().getLookaheadDelegate();
                    Intrinsics.checkNotNull(lookaheadDelegate);
                    Placeable.PlacementScope.m3540place70tqf50$default($this$invoke_u24lambda_u2d0, lookaheadDelegate, j, 0.0f, 2, null);
                }
            }, 2, null);
            this.lastPosition = position;
            this.this$0.layoutState = LayoutNode.LayoutState.Idle;
        }

        @Override // androidx.compose.p000ui.layout.Placeable, androidx.compose.p000ui.layout.Measured
        public int getMeasuredWidth() {
            LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.getMeasuredWidth();
        }

        @Override // androidx.compose.p000ui.layout.Placeable, androidx.compose.p000ui.layout.Measured
        public int getMeasuredHeight() {
            LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.getMeasuredHeight();
        }

        @Override // androidx.compose.p000ui.layout.Measured
        public int get(AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            LayoutNode parent$ui_release = this.this$0.layoutNode.getParent$ui_release();
            if ((parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null) != LayoutNode.LayoutState.LookaheadMeasuring) {
                LayoutNode parent$ui_release2 = this.this$0.layoutNode.getParent$ui_release();
                if ((parent$ui_release2 != null ? parent$ui_release2.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.LookaheadLayingOut) {
                    getAlignmentLines().setUsedDuringParentLayout$ui_release(true);
                }
            } else {
                getAlignmentLines().setUsedDuringParentMeasurement$ui_release(true);
            }
            this.duringAlignmentLinesQuery = true;
            LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            int result = lookaheadDelegate.get(alignmentLine);
            this.duringAlignmentLinesQuery = false;
            return result;
        }

        @Override // androidx.compose.p000ui.layout.IntrinsicMeasurable
        public int minIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.minIntrinsicWidth(height);
        }

        @Override // androidx.compose.p000ui.layout.IntrinsicMeasurable
        public int maxIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.maxIntrinsicWidth(height);
        }

        @Override // androidx.compose.p000ui.layout.IntrinsicMeasurable
        public int minIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.minIntrinsicHeight(width);
        }

        @Override // androidx.compose.p000ui.layout.IntrinsicMeasurable
        public int maxIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.maxIntrinsicHeight(width);
        }

        private final void onIntrinsicsQueried() {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode.requestLookaheadRemeasure$ui_release$default(this.this$0.layoutNode, false, 1, null);
            LayoutNode parent = this.this$0.layoutNode.getParent$ui_release();
            if (parent != null && this.this$0.layoutNode.getIntrinsicsUsageByParent() == LayoutNode.UsageByParent.NotUsed) {
                LayoutNode layoutNode = this.this$0.layoutNode;
                switch (WhenMappings.$EnumSwitchMapping$0[parent.getLayoutState$ui_release().ordinal()]) {
                    case 2:
                        usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                        break;
                    case 3:
                        usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                        break;
                    default:
                        usageByParent = parent.getIntrinsicsUsageByParent();
                        break;
                }
                layoutNode.setIntrinsicsUsageByParent$ui_release(usageByParent);
            }
        }

        public final void invalidateIntrinsicsParent(boolean forceRequest) {
            LayoutNode parent$ui_release;
            LayoutNode parent = this.this$0.layoutNode.getParent$ui_release();
            LayoutNode.UsageByParent intrinsicsUsageByParent = this.this$0.layoutNode.getIntrinsicsUsageByParent();
            if (parent != null && intrinsicsUsageByParent != LayoutNode.UsageByParent.NotUsed) {
                LayoutNode intrinsicsUsingParent = parent;
                while (intrinsicsUsingParent.getIntrinsicsUsageByParent() == intrinsicsUsageByParent && (parent$ui_release = intrinsicsUsingParent.getParent$ui_release()) != null) {
                    intrinsicsUsingParent = parent$ui_release;
                }
                switch (WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent.ordinal()]) {
                    case 1:
                        intrinsicsUsingParent.requestLookaheadRemeasure$ui_release(forceRequest);
                        return;
                    case 2:
                        intrinsicsUsingParent.requestLookaheadRelayout$ui_release(forceRequest);
                        return;
                    default:
                        throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
                }
            }
        }

        public final boolean updateParentData() {
            Object parentData = getParentData();
            LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            boolean changed = !Intrinsics.areEqual(parentData, lookaheadDelegate.getParentData());
            LookaheadDelegate lookaheadDelegate2 = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate2);
            this.parentData = lookaheadDelegate2.getParentData();
            return changed;
        }

        public final void onPlaced() {
            if (!getIsPlaced()) {
                setPlaced(true);
                if (!this.isPreviouslyPlaced) {
                    requestSubtreeForLookahead();
                }
            }
        }

        private final void requestSubtreeForLookahead() {
            LayoutNode this_$iv = this.this$0.layoutNode;
            MutableVector this_$iv$iv = this_$iv.get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv <= 0) {
                return;
            }
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                it.rescheduleRemeasureOrRelayout$ui_release(it);
                LookaheadPassDelegate lookaheadPassDelegate = it.getLayoutDelegate().getLookaheadPassDelegate();
                Intrinsics.checkNotNull(lookaheadPassDelegate);
                lookaheadPassDelegate.requestSubtreeForLookahead();
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }

        private final void onBeforeLayoutChildren() {
            LayoutNode this_$iv = this.this$0.layoutNode;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.this$0;
            MutableVector this_$iv$iv = this_$iv.get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv <= 0) {
                return;
            }
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                if (it.getLookaheadMeasurePending$ui_release() && it.getMeasuredByParentInLookahead() == LayoutNode.UsageByParent.InMeasureBlock) {
                    LookaheadPassDelegate lookaheadPassDelegate = it.getLayoutDelegate().getLookaheadPassDelegate();
                    Intrinsics.checkNotNull(lookaheadPassDelegate);
                    Constraints lookaheadConstraints = getLookaheadConstraints();
                    Intrinsics.checkNotNull(lookaheadConstraints);
                    if (lookaheadPassDelegate.m3639remeasureBRTryo0(lookaheadConstraints.getValue())) {
                        LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNodeLayoutDelegate.layoutNode, false, 1, null);
                    }
                }
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }

        public final void replace() {
            if (!this.placedOnce) {
                throw new IllegalStateException("Check failed.".toString());
            }
            mo3493placeAtf8xVGno(this.lastPosition, 0.0f, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isOutMostLookaheadRoot(LayoutNode $this$isOutMostLookaheadRoot) {
        LookaheadScope mLookaheadScope = $this$isOutMostLookaheadRoot.getMLookaheadScope();
        return Intrinsics.areEqual(mLookaheadScope != null ? mLookaheadScope.getRoot() : null, $this$isOutMostLookaheadRoot);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: performMeasure-BRTryo0, reason: not valid java name */
    public final void m3635performMeasureBRTryo0(final long constraints) {
        if (!(this.layoutState == LayoutNode.LayoutState.Idle)) {
            throw new IllegalStateException("layout state is not idle before measure starts".toString());
        }
        this.layoutState = LayoutNode.LayoutState.Measuring;
        this.measurePending = false;
        LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver().observeMeasureSnapshotReads$ui_release(this.layoutNode, false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasure$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LayoutNodeLayoutDelegate.this.getOuterCoordinator().mo3492measureBRTryo0(constraints);
            }
        });
        if (this.layoutState == LayoutNode.LayoutState.Measuring) {
            markLayoutPending$ui_release();
            this.layoutState = LayoutNode.LayoutState.Idle;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: performLookaheadMeasure-BRTryo0, reason: not valid java name */
    public final void m3634performLookaheadMeasureBRTryo0(final long constraints) {
        this.layoutState = LayoutNode.LayoutState.LookaheadMeasuring;
        this.lookaheadMeasurePending = false;
        OwnerSnapshotObserver.observeMeasureSnapshotReads$ui_release$default(LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver(), this.layoutNode, false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$performLookaheadMeasure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
                Intrinsics.checkNotNull(lookaheadDelegate);
                lookaheadDelegate.mo3492measureBRTryo0(constraints);
            }
        }, 2, null);
        markLookaheadLayoutPending$ui_release();
        if (isOutMostLookaheadRoot(this.layoutNode)) {
            markLayoutPending$ui_release();
        } else {
            markMeasurePending$ui_release();
        }
        this.layoutState = LayoutNode.LayoutState.Idle;
    }

    public final void onLookaheadScopeChanged$ui_release(LookaheadScope newScope) {
        this.lookaheadPassDelegate = newScope != null ? new LookaheadPassDelegate(this, newScope) : null;
    }

    public final void updateParentData() {
        LayoutNode parent$ui_release;
        if (this.measurePassDelegate.updateParentData() && (parent$ui_release = this.layoutNode.getParent$ui_release()) != null) {
            LayoutNode.requestRemeasure$ui_release$default(parent$ui_release, false, 1, null);
        }
        LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate != null && lookaheadPassDelegate.updateParentData()) {
            if (isOutMostLookaheadRoot(this.layoutNode)) {
                LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
                if (parent$ui_release2 != null) {
                    LayoutNode.requestRemeasure$ui_release$default(parent$ui_release2, false, 1, null);
                    return;
                }
                return;
            }
            LayoutNode parent$ui_release3 = this.layoutNode.getParent$ui_release();
            if (parent$ui_release3 != null) {
                LayoutNode.requestLookaheadRemeasure$ui_release$default(parent$ui_release3, false, 1, null);
            }
        }
    }

    public final void resetAlignmentLines() {
        AlignmentLines alignmentLines;
        this.measurePassDelegate.getAlignmentLines().reset$ui_release();
        LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate == null || (alignmentLines = lookaheadPassDelegate.getAlignmentLines()) == null) {
            return;
        }
        alignmentLines.reset$ui_release();
    }

    public final void markChildrenDirty() {
        this.measurePassDelegate.setChildMeasurablesDirty$ui_release(true);
        LookaheadPassDelegate it = this.lookaheadPassDelegate;
        if (it != null) {
            it.setChildMeasurablesDirty$ui_release(true);
        }
    }
}
