package androidx.compose.p000ui.focus;

import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.input.key.KeyInputModifier;
import androidx.compose.p000ui.layout.LayoutCoordinatesKt;
import androidx.compose.p000ui.node.LayoutNode;
import androidx.compose.p000ui.node.NodeCoordinator;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusTraversal.kt */
@Metadata(m286d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002\u001a\u0012\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b*\u00020\u0004H\u0000\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\u0004*\u00020\u0004H\u0000\u001a\u000e\u0010\r\u001a\u0004\u0018\u00010\u0004*\u00020\u0004H\u0000\u001a\u000e\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\u0004H\u0000\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0004H\u0000\u001a=\u0010\u0011\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00030\u0017H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, m287d2 = {"invalidFocusDirection", "", "isEligibleForFocusSearch", "", "Landroidx/compose/ui/focus/FocusModifier;", "(Landroidx/compose/ui/focus/FocusModifier;)Z", "lastOf", "Landroidx/compose/ui/input/key/KeyInputModifier;", "one", "two", "activatedChildren", "Landroidx/compose/runtime/collection/MutableVector;", "findActiveFocusNode", "findActiveParent", "findLastKeyInputModifier", "focusRect", "Landroidx/compose/ui/geometry/Rect;", "focusSearch", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "onFound", "Lkotlin/Function1;", "focusSearch-sMXa3k8", "(Landroidx/compose/ui/focus/FocusModifier;ILandroidx/compose/ui/unit/LayoutDirection;Lkotlin/jvm/functions/Function1;)Z", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class FocusTraversalKt {
    private static final String invalidFocusDirection = "Invalid FocusDirection";

    /* compiled from: FocusTraversal.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Rtl.ordinal()] = 1;
            iArr[LayoutDirection.Ltr.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            iArr2[FocusStateImpl.Active.ordinal()] = 1;
            iArr2[FocusStateImpl.Captured.ordinal()] = 2;
            iArr2[FocusStateImpl.ActiveParent.ordinal()] = 3;
            iArr2[FocusStateImpl.DeactivatedParent.ordinal()] = 4;
            iArr2[FocusStateImpl.Inactive.ordinal()] = 5;
            iArr2[FocusStateImpl.Deactivated.ordinal()] = 6;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* renamed from: focusSearch-sMXa3k8, reason: not valid java name */
    public static final boolean m1712focusSearchsMXa3k8(FocusModifier focusSearch, int focusDirection, LayoutDirection layoutDirection, Function1<? super FocusModifier, Boolean> onFound) {
        int direction;
        Intrinsics.checkNotNullParameter(focusSearch, "$this$focusSearch");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        if (FocusDirection.m1685equalsimpl0(focusDirection, FocusDirection.INSTANCE.m1698getNextdhqQ8s()) ? true : FocusDirection.m1685equalsimpl0(focusDirection, FocusDirection.INSTANCE.m1700getPreviousdhqQ8s())) {
            return OneDimensionalFocusSearchKt.m1715oneDimensionalFocusSearchOMvw8(focusSearch, focusDirection, onFound);
        }
        if (FocusDirection.m1685equalsimpl0(focusDirection, FocusDirection.INSTANCE.m1697getLeftdhqQ8s()) ? true : FocusDirection.m1685equalsimpl0(focusDirection, FocusDirection.INSTANCE.m1701getRightdhqQ8s()) ? true : FocusDirection.m1685equalsimpl0(focusDirection, FocusDirection.INSTANCE.m1702getUpdhqQ8s()) ? true : FocusDirection.m1685equalsimpl0(focusDirection, FocusDirection.INSTANCE.m1693getDowndhqQ8s())) {
            return TwoDimensionalFocusSearchKt.m1725twoDimensionalFocusSearchOMvw8(focusSearch, focusDirection, onFound);
        }
        boolean z = false;
        if (!FocusDirection.m1685equalsimpl0(focusDirection, FocusDirection.INSTANCE.m1694getEnterdhqQ8s())) {
            if (!FocusDirection.m1685equalsimpl0(focusDirection, FocusDirection.INSTANCE.m1695getExitdhqQ8s())) {
                throw new IllegalStateException(invalidFocusDirection.toString());
            }
            FocusModifier findActiveFocusNode = findActiveFocusNode(focusSearch);
            FocusModifier it = findActiveFocusNode != null ? findActiveParent(findActiveFocusNode) : null;
            if (!Intrinsics.areEqual(it, focusSearch) && it != null) {
                z = onFound.invoke(it).booleanValue();
            }
            return z;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()]) {
            case 1:
                direction = FocusDirection.INSTANCE.m1697getLeftdhqQ8s();
                break;
            case 2:
                direction = FocusDirection.INSTANCE.m1701getRightdhqQ8s();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        FocusModifier findActiveFocusNode2 = findActiveFocusNode(focusSearch);
        if (findActiveFocusNode2 != null) {
            return TwoDimensionalFocusSearchKt.m1725twoDimensionalFocusSearchOMvw8(findActiveFocusNode2, direction, onFound);
        }
        return false;
    }

    public static final FocusModifier findActiveFocusNode(FocusModifier $this$findActiveFocusNode) {
        Intrinsics.checkNotNullParameter($this$findActiveFocusNode, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[$this$findActiveFocusNode.getFocusState().ordinal()]) {
            case 1:
            case 2:
                return $this$findActiveFocusNode;
            case 3:
            case 4:
                FocusModifier focusedChild = $this$findActiveFocusNode.getFocusedChild();
                if (focusedChild != null) {
                    return findActiveFocusNode(focusedChild);
                }
                return null;
            case 5:
            case 6:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final FocusModifier findActiveParent(FocusModifier $this$findActiveParent) {
        Intrinsics.checkNotNullParameter($this$findActiveParent, "<this>");
        FocusModifier it = $this$findActiveParent.getParent();
        if (it == null) {
            return null;
        }
        switch (WhenMappings.$EnumSwitchMapping$1[$this$findActiveParent.getFocusState().ordinal()]) {
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
                return findActiveParent(it);
            case 3:
                return $this$findActiveParent;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final Rect focusRect(FocusModifier $this$focusRect) {
        Rect localBoundingBoxOf;
        Intrinsics.checkNotNullParameter($this$focusRect, "<this>");
        NodeCoordinator it = $this$focusRect.getCoordinator();
        return (it == null || (localBoundingBoxOf = LayoutCoordinatesKt.findRootCoordinates(it).localBoundingBoxOf(it, false)) == null) ? Rect.INSTANCE.getZero() : localBoundingBoxOf;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final MutableVector<FocusModifier> activatedChildren(FocusModifier $this$activatedChildren) {
        boolean z;
        Intrinsics.checkNotNullParameter($this$activatedChildren, "<this>");
        MutableVector this_$iv = $this$activatedChildren.getChildren();
        int size$iv = this_$iv.getSize();
        int i = 0;
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            while (!((FocusModifier) content$iv[i$iv]).getFocusState().isDeactivated()) {
                i$iv++;
                if (i$iv >= size$iv) {
                }
            }
            z = true;
            if (z) {
                return $this$activatedChildren.getChildren();
            }
            MutableVector activated = new MutableVector(new FocusModifier[16], 0);
            MutableVector this_$iv2 = $this$activatedChildren.getChildren();
            int size$iv2 = this_$iv2.getSize();
            if (size$iv2 > 0) {
                int i$iv2 = 0;
                Object[] content$iv2 = this_$iv2.getContent();
                Intrinsics.checkNotNull(content$iv2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                while (true) {
                    FocusModifier child = (FocusModifier) content$iv2[i$iv2];
                    if (child.getFocusState().isDeactivated()) {
                        FocusRequester customEnter = child.getFocusProperties().getEnter().invoke(FocusDirection.m1682boximpl(FocusDirection.INSTANCE.m1694getEnterdhqQ8s()));
                        if (!Intrinsics.areEqual(customEnter, FocusRequester.INSTANCE.getCancel())) {
                            if (Intrinsics.areEqual(customEnter, FocusRequester.INSTANCE.getDefault())) {
                                MutableVector elements$iv = activatedChildren(child);
                                activated.addAll(activated.getSize(), elements$iv);
                            } else {
                                MutableVector this_$iv3 = customEnter.getFocusRequesterModifierLocals$ui_release();
                                int size$iv3 = this_$iv3.getSize();
                                if (size$iv3 > 0) {
                                    int i$iv3 = 0;
                                    Object[] content$iv3 = this_$iv3.getContent();
                                    Intrinsics.checkNotNull(content$iv3, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                                    do {
                                        FocusModifier it = ((FocusRequesterModifierLocal) content$iv3[i$iv3]).findFocusNode();
                                        if (it != null) {
                                            activated.add(it);
                                        }
                                        i$iv3++;
                                    } while (i$iv3 < size$iv3);
                                }
                            }
                        } else {
                            return new MutableVector<>(new FocusModifier[16], i);
                        }
                    } else {
                        activated.add(child);
                    }
                    i$iv2++;
                    if (i$iv2 >= size$iv2) {
                        break;
                    }
                    i = 0;
                }
            }
            return activated;
        }
        z = false;
        if (z) {
        }
    }

    public static final KeyInputModifier findLastKeyInputModifier(FocusModifier $this$findLastKeyInputModifier) {
        LayoutNode layoutNode;
        Intrinsics.checkNotNullParameter($this$findLastKeyInputModifier, "<this>");
        NodeCoordinator coordinator = $this$findLastKeyInputModifier.getCoordinator();
        if (coordinator == null || (layoutNode = coordinator.getLayoutNode()) == null) {
            return null;
        }
        KeyInputModifier keyInputModifier = null;
        MutableVector this_$iv = $this$findLastKeyInputModifier.getKeyInputChildren();
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                KeyInputModifier keyInputModifier2 = (KeyInputModifier) content$iv[i$iv];
                if (Intrinsics.areEqual(keyInputModifier2.getLayoutNode(), layoutNode)) {
                    keyInputModifier = lastOf(keyInputModifier2, keyInputModifier);
                }
                i$iv++;
            } while (i$iv < size$iv);
        }
        if (keyInputModifier != null) {
            return keyInputModifier;
        }
        return $this$findLastKeyInputModifier.getKeyInputModifier();
    }

    public static final boolean isEligibleForFocusSearch(FocusModifier $this$isEligibleForFocusSearch) {
        LayoutNode layoutNode;
        LayoutNode layoutNode2;
        Intrinsics.checkNotNullParameter($this$isEligibleForFocusSearch, "<this>");
        NodeCoordinator coordinator = $this$isEligibleForFocusSearch.getCoordinator();
        if ((coordinator == null || (layoutNode2 = coordinator.getLayoutNode()) == null || !layoutNode2.getIsPlaced()) ? false : true) {
            NodeCoordinator coordinator2 = $this$isEligibleForFocusSearch.getCoordinator();
            if ((coordinator2 == null || (layoutNode = coordinator2.getLayoutNode()) == null || !layoutNode.isAttached()) ? false : true) {
                return true;
            }
        }
        return false;
    }

    private static final KeyInputModifier lastOf(KeyInputModifier one, KeyInputModifier two) {
        if (two == null) {
            return one;
        }
        KeyInputModifier mod = two;
        LayoutNode layoutNode = one.getLayoutNode();
        while (!Intrinsics.areEqual(mod, one)) {
            KeyInputModifier parent = mod.getParent();
            if (parent == null || !Intrinsics.areEqual(parent.getLayoutNode(), layoutNode)) {
                return one;
            }
            mod = parent;
        }
        return two;
    }
}
