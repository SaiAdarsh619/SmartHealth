package androidx.compose.p000ui.layout;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.node.LookaheadDelegate;
import androidx.compose.p000ui.node.NodeCoordinator;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.IntOffsetKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: LookaheadLayoutCoordinates.kt */
@Metadata(m286d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0096\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\nH\u0016J%\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010&\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J%\u0010)\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u001d\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u001d\u00100\u001a\u00020%2\u0006\u0010-\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010/J%\u00102\u001a\u0002032\u0006\u0010\"\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u001d\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010/R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006;"}, m287d2 = {"Landroidx/compose/ui/layout/LookaheadLayoutCoordinatesImpl;", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "lookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "isAttached", "", "()Z", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "parentCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "get", "", "alignmentLine", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "clipBounds", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "relativeToSource", "localLookaheadPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;J)J", "localPositionOf", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "(J)J", "localToWindow", "localToWindow-MK-Hz9U", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LookaheadLayoutCoordinatesImpl implements LookaheadLayoutCoordinates {
    private final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinatesImpl(LookaheadDelegate lookaheadDelegate) {
        Intrinsics.checkNotNullParameter(lookaheadDelegate, "lookaheadDelegate");
        this.lookaheadDelegate = lookaheadDelegate;
    }

    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    public final NodeCoordinator getCoordinator() {
        return this.lookaheadDelegate.getCoordinator();
    }

    @Override // androidx.compose.p000ui.layout.LookaheadLayoutCoordinates
    /* renamed from: localLookaheadPositionOf-R5De75A */
    public long mo3507localLookaheadPositionOfR5De75A(LookaheadLayoutCoordinates sourceCoordinates, long relativeToSource) {
        LookaheadDelegate sourceRoot;
        LookaheadDelegate rootLookaheadDelegate;
        LookaheadDelegate rootLookaheadDelegate2;
        LookaheadDelegate rootLookaheadDelegate3;
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        LookaheadDelegate source = ((LookaheadLayoutCoordinatesImpl) sourceCoordinates).lookaheadDelegate;
        NodeCoordinator commonAncestor = getCoordinator().findCommonAncestor$ui_release(source.getCoordinator());
        LookaheadDelegate ancestor = commonAncestor.getLookaheadDelegate();
        if (ancestor != null) {
            long arg0$iv = source.m3646positionInBjo55l4$ui_release(ancestor);
            long $this$round_u2dk_u2d4lQ0M$iv = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m1760getXimpl(relativeToSource)), MathKt.roundToInt(Offset.m1761getYimpl(relativeToSource)));
            long arg0$iv2 = IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(arg0$iv) + IntOffset.m4500getXimpl($this$round_u2dk_u2d4lQ0M$iv), IntOffset.m4501getYimpl(arg0$iv) + IntOffset.m4501getYimpl($this$round_u2dk_u2d4lQ0M$iv));
            long other$iv = this.lookaheadDelegate.m3646positionInBjo55l4$ui_release(ancestor);
            long arg0$iv3 = IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(arg0$iv2) - IntOffset.m4500getXimpl(other$iv), IntOffset.m4501getYimpl(arg0$iv2) - IntOffset.m4501getYimpl(other$iv));
            long $this$toOffset_u2d_u2dgyyYBs$iv = OffsetKt.Offset(IntOffset.m4500getXimpl(arg0$iv3), IntOffset.m4501getYimpl(arg0$iv3));
            return $this$toOffset_u2d_u2dgyyYBs$iv;
        }
        sourceRoot = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(source);
        long arg0$iv4 = source.m3646positionInBjo55l4$ui_release(sourceRoot);
        long other$iv2 = sourceRoot.getPosition();
        long arg0$iv5 = IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(arg0$iv4) + IntOffset.m4500getXimpl(other$iv2), IntOffset.m4501getYimpl(arg0$iv4) + IntOffset.m4501getYimpl(other$iv2));
        long $this$round_u2dk_u2d4lQ0M$iv2 = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m1760getXimpl(relativeToSource)), MathKt.roundToInt(Offset.m1761getYimpl(relativeToSource)));
        long arg0$iv6 = IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(arg0$iv5) + IntOffset.m4500getXimpl($this$round_u2dk_u2d4lQ0M$iv2), IntOffset.m4501getYimpl(arg0$iv5) + IntOffset.m4501getYimpl($this$round_u2dk_u2d4lQ0M$iv2));
        LookaheadDelegate $this$localLookaheadPositionOf_R5De75A_u24lambda_u2d2_u24lambda_u2d1 = this.lookaheadDelegate;
        rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate($this$localLookaheadPositionOf_R5De75A_u24lambda_u2d2_u24lambda_u2d1);
        long arg0$iv7 = $this$localLookaheadPositionOf_R5De75A_u24lambda_u2d2_u24lambda_u2d1.m3646positionInBjo55l4$ui_release(rootLookaheadDelegate);
        rootLookaheadDelegate2 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate($this$localLookaheadPositionOf_R5De75A_u24lambda_u2d2_u24lambda_u2d1);
        long other$iv3 = rootLookaheadDelegate2.getPosition();
        long other$iv4 = IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(arg0$iv7) + IntOffset.m4500getXimpl(other$iv3), IntOffset.m4501getYimpl(arg0$iv7) + IntOffset.m4501getYimpl(other$iv3));
        long other$iv5 = IntOffsetKt.IntOffset(IntOffset.m4500getXimpl(arg0$iv6) - IntOffset.m4500getXimpl(other$iv4), IntOffset.m4501getYimpl(arg0$iv6) - IntOffset.m4501getYimpl(other$iv4));
        rootLookaheadDelegate3 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        NodeCoordinator wrappedBy = rootLookaheadDelegate3.getCoordinator().getWrappedBy();
        Intrinsics.checkNotNull(wrappedBy);
        NodeCoordinator wrappedBy2 = sourceRoot.getCoordinator().getWrappedBy();
        Intrinsics.checkNotNull(wrappedBy2);
        long $this$toOffset_u2d_u2dgyyYBs$iv2 = OffsetKt.Offset(IntOffset.m4500getXimpl(other$iv5), IntOffset.m4501getYimpl(other$iv5));
        return wrappedBy.mo3498localPositionOfR5De75A(wrappedBy2, $this$toOffset_u2d_u2dgyyYBs$iv2);
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    /* renamed from: getSize-YbymL2g */
    public long mo3497getSizeYbymL2g() {
        return getCoordinator().mo3497getSizeYbymL2g();
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        return getCoordinator().getProvidedAlignmentLines();
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    public LayoutCoordinates getParentLayoutCoordinates() {
        return getCoordinator().getParentLayoutCoordinates();
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    public LayoutCoordinates getParentCoordinates() {
        return getCoordinator().getParentCoordinates();
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getCoordinator().isAttached();
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public long mo3502windowToLocalMKHz9U(long relativeToWindow) {
        return getCoordinator().mo3502windowToLocalMKHz9U(relativeToWindow);
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public long mo3500localToWindowMKHz9U(long relativeToLocal) {
        return getCoordinator().mo3500localToWindowMKHz9U(relativeToLocal);
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    /* renamed from: localToRoot-MK-Hz9U */
    public long mo3499localToRootMKHz9U(long relativeToLocal) {
        return getCoordinator().mo3499localToRootMKHz9U(relativeToLocal);
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-R5De75A */
    public long mo3498localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        return getCoordinator().mo3498localPositionOfR5De75A(sourceCoordinates, relativeToSource);
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        return getCoordinator().localBoundingBoxOf(sourceCoordinates, clipBounds);
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    /* renamed from: transformFrom-EL8BTi8 */
    public void mo3501transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        getCoordinator().mo3501transformFromEL8BTi8(sourceCoordinates, matrix);
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    public int get(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return getCoordinator().get(alignmentLine);
    }
}
