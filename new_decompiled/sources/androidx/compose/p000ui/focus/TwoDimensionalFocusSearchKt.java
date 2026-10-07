package androidx.compose.p000ui.focus;

import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.layout.BeyondBoundsLayout;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TwoDimensionalFocusSearch.kt */
@Metadata(m286d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u001a5\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a5\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\f\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0013H\u0002\u001a\f\u0010\u0014\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a1\u0010\u0015\u001a\u0004\u0018\u00010\u0013*\b\u0012\u0004\u0012\u00020\u00130\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a5\u0010\u001a\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u001cH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a=\u0010\u001f\u001a\u00020\u0004*\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u001cH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"\u001a=\u0010#\u001a\u00020\u0004*\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u001cH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\"\u001a\f\u0010%\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a5\u0010&\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u001cH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010\u001e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006("}, m287d2 = {"InvalidFocusDirection", "", "NoActiveChild", "beamBeats", "", "source", "Landroidx/compose/ui/geometry/Rect;", "rect1", "rect2", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "beamBeats-I7lrPNg", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;I)Z", "isBetterCandidate", "proposedCandidate", "currentCandidate", "focusedRect", "isBetterCandidate-I7lrPNg", "activeNode", "Landroidx/compose/ui/focus/FocusModifier;", "bottomRight", "findBestCandidate", "Landroidx/compose/runtime/collection/MutableVector;", "focusRect", "findBestCandidate-4WY_MpI", "(Landroidx/compose/runtime/collection/MutableVector;Landroidx/compose/ui/geometry/Rect;I)Landroidx/compose/ui/focus/FocusModifier;", "findChildCorrespondingToFocusEnter", "onFound", "Lkotlin/Function1;", "findChildCorrespondingToFocusEnter--OM-vw8", "(Landroidx/compose/ui/focus/FocusModifier;ILkotlin/jvm/functions/Function1;)Z", "generateAndSearchChildren", "focusedItem", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusModifier;Landroidx/compose/ui/focus/FocusModifier;ILkotlin/jvm/functions/Function1;)Z", "searchChildren", "searchChildren-4C6V_qg", "topLeft", "twoDimensionalFocusSearch", "twoDimensionalFocusSearch--OM-vw8", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TwoDimensionalFocusSearchKt {
    private static final String InvalidFocusDirection = "This function should only be used for 2-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    /* compiled from: TwoDimensionalFocusSearch.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 1;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 2;
            iArr[FocusStateImpl.Active.ordinal()] = 3;
            iArr[FocusStateImpl.Captured.ordinal()] = 4;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: twoDimensionalFocusSearch--OM-vw8, reason: not valid java name */
    public static final boolean m1725twoDimensionalFocusSearchOMvw8(FocusModifier twoDimensionalFocusSearch, int direction, Function1<? super FocusModifier, Boolean> onFound) {
        Intrinsics.checkNotNullParameter(twoDimensionalFocusSearch, "$this$twoDimensionalFocusSearch");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        switch (WhenMappings.$EnumSwitchMapping$0[twoDimensionalFocusSearch.getFocusState().ordinal()]) {
            case 1:
            case 2:
                FocusModifier focusedChild = twoDimensionalFocusSearch.getFocusedChild();
                if (focusedChild == null) {
                    throw new IllegalStateException(NoActiveChild.toString());
                }
                switch (WhenMappings.$EnumSwitchMapping$0[focusedChild.getFocusState().ordinal()]) {
                    case 1:
                    case 2:
                        if (m1725twoDimensionalFocusSearchOMvw8(focusedChild, direction, onFound)) {
                            return true;
                        }
                        Boolean performRequestFocus$ui_release = focusedChild.getFocusProperties().getExit().invoke(FocusDirection.m1682boximpl(direction)).performRequestFocus$ui_release(onFound);
                        if (performRequestFocus$ui_release == null) {
                            return m1722generateAndSearchChildren4C6V_qg(twoDimensionalFocusSearch, activeNode(focusedChild), direction, onFound);
                        }
                        boolean it = performRequestFocus$ui_release.booleanValue();
                        return it;
                    case 3:
                    case 4:
                        return m1722generateAndSearchChildren4C6V_qg(twoDimensionalFocusSearch, focusedChild, direction, onFound);
                    case 5:
                    case 6:
                        throw new IllegalStateException(NoActiveChild.toString());
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            case 3:
            case 4:
                return m1721findChildCorrespondingToFocusEnterOMvw8(twoDimensionalFocusSearch, direction, onFound);
            case 5:
                return false;
            case 6:
                return onFound.invoke(twoDimensionalFocusSearch).booleanValue();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: findChildCorrespondingToFocusEnter--OM-vw8, reason: not valid java name */
    public static final boolean m1721findChildCorrespondingToFocusEnterOMvw8(FocusModifier findChildCorrespondingToFocusEnter, int direction, Function1<? super FocusModifier, Boolean> onFound) {
        int requestedDirection;
        Rect initialFocusRect;
        Intrinsics.checkNotNullParameter(findChildCorrespondingToFocusEnter, "$this$findChildCorrespondingToFocusEnter");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        Boolean performRequestFocus$ui_release = findChildCorrespondingToFocusEnter.getFocusProperties().getEnter().invoke(FocusDirection.m1682boximpl(direction)).performRequestFocus$ui_release(onFound);
        if (performRequestFocus$ui_release != null) {
            return performRequestFocus$ui_release.booleanValue();
        }
        MutableVector focusableChildren = FocusTraversalKt.activatedChildren(findChildCorrespondingToFocusEnter);
        if (focusableChildren.getSize() > 1) {
            if (FocusDirection.m1685equalsimpl0(direction, FocusDirection.INSTANCE.m1694getEnterdhqQ8s())) {
                requestedDirection = FocusDirection.INSTANCE.m1697getLeftdhqQ8s();
            } else {
                requestedDirection = direction;
            }
            if (FocusDirection.m1685equalsimpl0(requestedDirection, FocusDirection.INSTANCE.m1701getRightdhqQ8s()) ? true : FocusDirection.m1685equalsimpl0(requestedDirection, FocusDirection.INSTANCE.m1693getDowndhqQ8s())) {
                initialFocusRect = topLeft(FocusTraversalKt.focusRect(findChildCorrespondingToFocusEnter));
            } else {
                if (!(FocusDirection.m1685equalsimpl0(requestedDirection, FocusDirection.INSTANCE.m1697getLeftdhqQ8s()) ? true : FocusDirection.m1685equalsimpl0(requestedDirection, FocusDirection.INSTANCE.m1702getUpdhqQ8s()))) {
                    throw new IllegalStateException(InvalidFocusDirection.toString());
                }
                initialFocusRect = bottomRight(FocusTraversalKt.focusRect(findChildCorrespondingToFocusEnter));
            }
            FocusModifier nextCandidate = m1720findBestCandidate4WY_MpI(focusableChildren, initialFocusRect, requestedDirection);
            if (nextCandidate != null) {
                return onFound.invoke(nextCandidate).booleanValue();
            }
            return false;
        }
        FocusModifier it = focusableChildren.isEmpty() ? null : focusableChildren.getContent()[0];
        if (it != null) {
            return onFound.invoke(it).booleanValue();
        }
        return false;
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg, reason: not valid java name */
    private static final boolean m1722generateAndSearchChildren4C6V_qg(final FocusModifier $this$generateAndSearchChildren_u2d4C6V_qg, final FocusModifier focusedItem, final int direction, final Function1<? super FocusModifier, Boolean> function1) {
        if (m1724searchChildren4C6V_qg($this$generateAndSearchChildren_u2d4C6V_qg, focusedItem, direction, function1)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m1681searchBeyondBoundsOMvw8($this$generateAndSearchChildren_u2d4C6V_qg, direction, new Function1<BeyondBoundsLayout.BeyondBoundsScope, Boolean>() { // from class: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BeyondBoundsLayout.BeyondBoundsScope searchBeyondBounds) {
                boolean m1724searchChildren4C6V_qg;
                Intrinsics.checkNotNullParameter(searchBeyondBounds, "$this$searchBeyondBounds");
                m1724searchChildren4C6V_qg = TwoDimensionalFocusSearchKt.m1724searchChildren4C6V_qg(FocusModifier.this, focusedItem, direction, function1);
                Boolean valueOf = Boolean.valueOf(m1724searchChildren4C6V_qg);
                boolean found = valueOf.booleanValue();
                if (found || !searchBeyondBounds.getHasMoreContent()) {
                    return valueOf;
                }
                return null;
            }
        });
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: searchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m1724searchChildren4C6V_qg(FocusModifier $this$searchChildren_u2d4C6V_qg, FocusModifier focusedItem, int direction, Function1<? super FocusModifier, Boolean> function1) {
        FocusModifier nextItem;
        int capacity$iv = $this$searchChildren_u2d4C6V_qg.getChildren().getSize();
        MutableVector this_$iv = new MutableVector(new FocusModifier[capacity$iv], 0);
        MutableVector elements$iv = $this$searchChildren_u2d4C6V_qg.getChildren();
        this_$iv.addAll(this_$iv.getSize(), elements$iv);
        while (this_$iv.isNotEmpty() && (nextItem = m1720findBestCandidate4WY_MpI(this_$iv, FocusTraversalKt.focusRect(focusedItem), direction)) != null) {
            if (!nextItem.getFocusState().isDeactivated()) {
                return function1.invoke(nextItem).booleanValue();
            }
            Boolean performRequestFocus$ui_release = nextItem.getFocusProperties().getEnter().invoke(FocusDirection.m1682boximpl(direction)).performRequestFocus$ui_release(function1);
            if (performRequestFocus$ui_release != null) {
                boolean it = performRequestFocus$ui_release.booleanValue();
                return it;
            }
            boolean it2 = m1722generateAndSearchChildren4C6V_qg(nextItem, focusedItem, direction, function1);
            if (it2) {
                return true;
            }
            this_$iv.remove(nextItem);
        }
        return false;
    }

    /* renamed from: findBestCandidate-4WY_MpI, reason: not valid java name */
    private static final FocusModifier m1720findBestCandidate4WY_MpI(MutableVector<FocusModifier> mutableVector, Rect focusRect, int direction) {
        Rect translate;
        if (FocusDirection.m1685equalsimpl0(direction, FocusDirection.INSTANCE.m1697getLeftdhqQ8s())) {
            translate = focusRect.translate(focusRect.getWidth() + 1, 0.0f);
        } else if (FocusDirection.m1685equalsimpl0(direction, FocusDirection.INSTANCE.m1701getRightdhqQ8s())) {
            translate = focusRect.translate(-(focusRect.getWidth() + 1), 0.0f);
        } else if (FocusDirection.m1685equalsimpl0(direction, FocusDirection.INSTANCE.m1702getUpdhqQ8s())) {
            translate = focusRect.translate(0.0f, focusRect.getHeight() + 1);
        } else {
            if (!FocusDirection.m1685equalsimpl0(direction, FocusDirection.INSTANCE.m1693getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            translate = focusRect.translate(0.0f, -(focusRect.getHeight() + 1));
        }
        Rect rect = translate;
        FocusModifier focusModifier = null;
        int size$iv = mutableVector.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = mutableVector.getContent();
            Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                FocusModifier candidateNode = (FocusModifier) content$iv[i$iv];
                if (FocusTraversalKt.isEligibleForFocusSearch(candidateNode)) {
                    Rect candidateRect = FocusTraversalKt.focusRect(candidateNode);
                    if (m1723isBetterCandidateI7lrPNg(candidateRect, rect, focusRect, direction)) {
                        rect = candidateRect;
                        focusModifier = candidateNode;
                    }
                }
                i$iv++;
            } while (i$iv < size$iv);
        }
        return focusModifier;
    }

    private static final boolean isBetterCandidate_I7lrPNg$isCandidate(Rect $this$isBetterCandidate_I7lrPNg_u24isCandidate, int $direction, Rect $focusedRect) {
        if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1697getLeftdhqQ8s())) {
            return ($focusedRect.getRight() > $this$isBetterCandidate_I7lrPNg_u24isCandidate.getRight() || $focusedRect.getLeft() >= $this$isBetterCandidate_I7lrPNg_u24isCandidate.getRight()) && $focusedRect.getLeft() > $this$isBetterCandidate_I7lrPNg_u24isCandidate.getLeft();
        }
        if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1701getRightdhqQ8s())) {
            return ($focusedRect.getLeft() < $this$isBetterCandidate_I7lrPNg_u24isCandidate.getLeft() || $focusedRect.getRight() <= $this$isBetterCandidate_I7lrPNg_u24isCandidate.getLeft()) && $focusedRect.getRight() < $this$isBetterCandidate_I7lrPNg_u24isCandidate.getRight();
        }
        if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1702getUpdhqQ8s())) {
            return ($focusedRect.getBottom() > $this$isBetterCandidate_I7lrPNg_u24isCandidate.getBottom() || $focusedRect.getTop() >= $this$isBetterCandidate_I7lrPNg_u24isCandidate.getBottom()) && $focusedRect.getTop() > $this$isBetterCandidate_I7lrPNg_u24isCandidate.getTop();
        }
        if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1693getDowndhqQ8s())) {
            return ($focusedRect.getTop() < $this$isBetterCandidate_I7lrPNg_u24isCandidate.getTop() || $focusedRect.getBottom() <= $this$isBetterCandidate_I7lrPNg_u24isCandidate.getTop()) && $focusedRect.getBottom() < $this$isBetterCandidate_I7lrPNg_u24isCandidate.getBottom();
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    private static final float isBetterCandidate_I7lrPNg$majorAxisDistance(Rect $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance, int $direction, Rect $focusedRect) {
        float majorAxisDistance;
        if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1697getLeftdhqQ8s())) {
            majorAxisDistance = $focusedRect.getLeft() - $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance.getRight();
        } else if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1701getRightdhqQ8s())) {
            majorAxisDistance = $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance.getLeft() - $focusedRect.getRight();
        } else if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1702getUpdhqQ8s())) {
            majorAxisDistance = $focusedRect.getTop() - $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance.getBottom();
        } else {
            if (!FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1693getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            majorAxisDistance = $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance.getTop() - $focusedRect.getBottom();
        }
        return Math.max(0.0f, majorAxisDistance);
    }

    private static final float isBetterCandidate_I7lrPNg$minorAxisDistance(Rect $this$isBetterCandidate_I7lrPNg_u24minorAxisDistance, int $direction, Rect $focusedRect) {
        if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1697getLeftdhqQ8s()) ? true : FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1701getRightdhqQ8s())) {
            float f = 2;
            return ($focusedRect.getTop() + ($focusedRect.getHeight() / f)) - ($this$isBetterCandidate_I7lrPNg_u24minorAxisDistance.getTop() + ($this$isBetterCandidate_I7lrPNg_u24minorAxisDistance.getHeight() / f));
        }
        if (!(FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1702getUpdhqQ8s()) ? true : FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1693getDowndhqQ8s()))) {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        }
        float f2 = 2;
        return ($focusedRect.getLeft() + ($focusedRect.getWidth() / f2)) - ($this$isBetterCandidate_I7lrPNg_u24minorAxisDistance.getLeft() + ($this$isBetterCandidate_I7lrPNg_u24minorAxisDistance.getWidth() / f2));
    }

    private static final long isBetterCandidate_I7lrPNg$weightedDistance(int $direction, Rect $focusedRect, Rect candidate) {
        long majorAxisDistance = (long) Math.abs(isBetterCandidate_I7lrPNg$majorAxisDistance(candidate, $direction, $focusedRect));
        long minorAxisDistance = (long) Math.abs(isBetterCandidate_I7lrPNg$minorAxisDistance(candidate, $direction, $focusedRect));
        return (13 * majorAxisDistance * majorAxisDistance) + (minorAxisDistance * minorAxisDistance);
    }

    /* renamed from: isBetterCandidate-I7lrPNg, reason: not valid java name */
    private static final boolean m1723isBetterCandidateI7lrPNg(Rect proposedCandidate, Rect currentCandidate, Rect focusedRect, int direction) {
        if (!isBetterCandidate_I7lrPNg$isCandidate(proposedCandidate, direction, focusedRect)) {
            return false;
        }
        if (isBetterCandidate_I7lrPNg$isCandidate(currentCandidate, direction, focusedRect) && !m1718beamBeatsI7lrPNg(focusedRect, proposedCandidate, currentCandidate, direction)) {
            return !m1718beamBeatsI7lrPNg(focusedRect, currentCandidate, proposedCandidate, direction) && isBetterCandidate_I7lrPNg$weightedDistance(direction, focusedRect, proposedCandidate) < isBetterCandidate_I7lrPNg$weightedDistance(direction, focusedRect, currentCandidate);
        }
        return true;
    }

    private static final boolean beamBeats_I7lrPNg$inSourceBeam(Rect $this$beamBeats_I7lrPNg_u24inSourceBeam, int $direction, Rect $source) {
        if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1697getLeftdhqQ8s()) ? true : FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1701getRightdhqQ8s())) {
            return $this$beamBeats_I7lrPNg_u24inSourceBeam.getBottom() > $source.getTop() && $this$beamBeats_I7lrPNg_u24inSourceBeam.getTop() < $source.getBottom();
        }
        if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1702getUpdhqQ8s()) ? true : FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1693getDowndhqQ8s())) {
            return $this$beamBeats_I7lrPNg_u24inSourceBeam.getRight() > $source.getLeft() && $this$beamBeats_I7lrPNg_u24inSourceBeam.getLeft() < $source.getRight();
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    private static final boolean beamBeats_I7lrPNg$isInDirectionOfSearch(Rect $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch, int $direction, Rect $source) {
        if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1697getLeftdhqQ8s())) {
            return $source.getLeft() >= $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch.getRight();
        }
        if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1701getRightdhqQ8s())) {
            return $source.getRight() <= $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch.getLeft();
        }
        if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1702getUpdhqQ8s())) {
            return $source.getTop() >= $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch.getBottom();
        }
        if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1693getDowndhqQ8s())) {
            return $source.getBottom() <= $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch.getTop();
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    /* renamed from: beamBeats_I7lrPNg$majorAxisDistance-6, reason: not valid java name */
    private static final float m1719beamBeats_I7lrPNg$majorAxisDistance6(Rect $this$beamBeats_I7lrPNg_u24majorAxisDistance_u2d6, int $direction, Rect $source) {
        float majorAxisDistance;
        if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1697getLeftdhqQ8s())) {
            majorAxisDistance = $source.getLeft() - $this$beamBeats_I7lrPNg_u24majorAxisDistance_u2d6.getRight();
        } else if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1701getRightdhqQ8s())) {
            majorAxisDistance = $this$beamBeats_I7lrPNg_u24majorAxisDistance_u2d6.getLeft() - $source.getRight();
        } else if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1702getUpdhqQ8s())) {
            majorAxisDistance = $source.getTop() - $this$beamBeats_I7lrPNg_u24majorAxisDistance_u2d6.getBottom();
        } else {
            if (!FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1693getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            majorAxisDistance = $this$beamBeats_I7lrPNg_u24majorAxisDistance_u2d6.getTop() - $source.getBottom();
        }
        return Math.max(0.0f, majorAxisDistance);
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(Rect $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge, int $direction, Rect $source) {
        float majorAxisDistance;
        if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1697getLeftdhqQ8s())) {
            majorAxisDistance = $source.getLeft() - $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge.getLeft();
        } else if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1701getRightdhqQ8s())) {
            majorAxisDistance = $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge.getRight() - $source.getRight();
        } else if (FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1702getUpdhqQ8s())) {
            majorAxisDistance = $source.getTop() - $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge.getTop();
        } else {
            if (!FocusDirection.m1685equalsimpl0($direction, FocusDirection.INSTANCE.m1693getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            majorAxisDistance = $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge.getBottom() - $source.getBottom();
        }
        return Math.max(1.0f, majorAxisDistance);
    }

    /* renamed from: beamBeats-I7lrPNg, reason: not valid java name */
    private static final boolean m1718beamBeatsI7lrPNg(Rect source, Rect rect1, Rect rect2, int direction) {
        if (beamBeats_I7lrPNg$inSourceBeam(rect2, direction, source) || !beamBeats_I7lrPNg$inSourceBeam(rect1, direction, source)) {
            return false;
        }
        if (!beamBeats_I7lrPNg$isInDirectionOfSearch(rect2, direction, source)) {
            return true;
        }
        if (FocusDirection.m1685equalsimpl0(direction, FocusDirection.INSTANCE.m1697getLeftdhqQ8s()) || FocusDirection.m1685equalsimpl0(direction, FocusDirection.INSTANCE.m1701getRightdhqQ8s())) {
            return true;
        }
        return m1719beamBeats_I7lrPNg$majorAxisDistance6(rect1, direction, source) < beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(rect2, direction, source);
    }

    private static final Rect topLeft(Rect $this$topLeft) {
        return new Rect($this$topLeft.getLeft(), $this$topLeft.getTop(), $this$topLeft.getLeft(), $this$topLeft.getTop());
    }

    private static final Rect bottomRight(Rect $this$bottomRight) {
        return new Rect($this$bottomRight.getRight(), $this$bottomRight.getBottom(), $this$bottomRight.getRight(), $this$bottomRight.getBottom());
    }

    private static final FocusModifier activeNode(FocusModifier $this$activeNode) {
        if (!($this$activeNode.getFocusState() == FocusStateImpl.ActiveParent || $this$activeNode.getFocusState() == FocusStateImpl.DeactivatedParent)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        FocusModifier findActiveFocusNode = FocusTraversalKt.findActiveFocusNode($this$activeNode);
        if (findActiveFocusNode != null) {
            return findActiveFocusNode;
        }
        throw new IllegalStateException(NoActiveChild.toString());
    }
}
