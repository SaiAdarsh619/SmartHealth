package androidx.compose.p000ui.focus;

import androidx.compose.p000ui.node.LayoutNode;
import androidx.compose.p000ui.node.NodeCoordinator;
import androidx.compose.p000ui.node.Owner;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusTransactions.kt */
@Metadata(m286d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0002H\u0002\u001a\u0016\u0010\u0006\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\t\u001a\u00020\u0004*\u00020\u0002H\u0000\u001a\f\u0010\n\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0014\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002\u001a\f\u0010\u000f\u001a\u00020\u0004*\u00020\u0002H\u0002\u001a\f\u0010\u0010\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0011"}, m287d2 = {"activateNode", "", "Landroidx/compose/ui/focus/FocusModifier;", "captureFocus", "", "clearChildFocus", "clearFocus", "forcedClear", "deactivateNode", "freeFocus", "grantFocus", "grantFocusToChild", "childNode", "requestFocus", "requestFocusForChild", "requestFocusForOwner", "sendOnFocusEvent", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class FocusTransactionsKt {

    /* compiled from: FocusTransactions.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.Captured.ordinal()] = 2;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 4;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void requestFocus(FocusModifier $this$requestFocus) {
        LayoutNode layoutNode;
        Intrinsics.checkNotNullParameter($this$requestFocus, "<this>");
        NodeCoordinator coordinator = $this$requestFocus.getCoordinator();
        if (((coordinator == null || (layoutNode = coordinator.getLayoutNode()) == null) ? null : layoutNode.getOwner()) == null) {
            $this$requestFocus.setFocusRequestedOnPlaced(true);
        }
        switch (WhenMappings.$EnumSwitchMapping$0[$this$requestFocus.getFocusState().ordinal()]) {
            case 1:
            case 2:
                sendOnFocusEvent($this$requestFocus);
                break;
            case 3:
                if (clearChildFocus($this$requestFocus)) {
                    grantFocus($this$requestFocus);
                    break;
                }
                break;
            case 4:
            case 5:
                TwoDimensionalFocusSearchKt.m1721findChildCorrespondingToFocusEnterOMvw8($this$requestFocus, FocusDirection.INSTANCE.m1694getEnterdhqQ8s(), new Function1<FocusModifier, Boolean>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt$requestFocus$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(FocusModifier it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        FocusTransactionsKt.requestFocus(it);
                        return true;
                    }
                });
                break;
            case 6:
                FocusModifier focusParent = $this$requestFocus.getParent();
                if (focusParent != null) {
                    requestFocusForChild(focusParent, $this$requestFocus);
                    break;
                } else if (requestFocusForOwner($this$requestFocus)) {
                    grantFocus($this$requestFocus);
                    break;
                }
                break;
        }
    }

    public static final void activateNode(FocusModifier $this$activateNode) {
        Intrinsics.checkNotNullParameter($this$activateNode, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$activateNode.getFocusState().ordinal()]) {
            case 4:
                $this$activateNode.setFocusState(FocusStateImpl.Inactive);
                break;
            case 5:
                $this$activateNode.setFocusState(FocusStateImpl.ActiveParent);
                break;
        }
    }

    public static final void deactivateNode(FocusModifier $this$deactivateNode) {
        LayoutNode layoutNode;
        Owner owner;
        FocusManager focusManager;
        Intrinsics.checkNotNullParameter($this$deactivateNode, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$deactivateNode.getFocusState().ordinal()]) {
            case 1:
            case 2:
                NodeCoordinator coordinator = $this$deactivateNode.getCoordinator();
                if (coordinator != null && (layoutNode = coordinator.getLayoutNode()) != null && (owner = layoutNode.getOwner()) != null && (focusManager = owner.getFocusManager()) != null) {
                    focusManager.clearFocus(true);
                }
                $this$deactivateNode.setFocusState(FocusStateImpl.Deactivated);
                break;
            case 3:
                $this$deactivateNode.setFocusState(FocusStateImpl.DeactivatedParent);
                break;
            case 6:
                $this$deactivateNode.setFocusState(FocusStateImpl.Deactivated);
                break;
        }
    }

    public static final boolean captureFocus(FocusModifier $this$captureFocus) {
        Intrinsics.checkNotNullParameter($this$captureFocus, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$captureFocus.getFocusState().ordinal()]) {
            case 1:
                $this$captureFocus.setFocusState(FocusStateImpl.Captured);
                return true;
            case 2:
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final boolean freeFocus(FocusModifier $this$freeFocus) {
        Intrinsics.checkNotNullParameter($this$freeFocus, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$freeFocus.getFocusState().ordinal()]) {
            case 1:
                return true;
            case 2:
                $this$freeFocus.setFocusState(FocusStateImpl.Active);
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ boolean clearFocus$default(FocusModifier focusModifier, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return clearFocus(focusModifier, z);
    }

    public static final boolean clearFocus(FocusModifier $this$clearFocus, boolean forcedClear) {
        Intrinsics.checkNotNullParameter($this$clearFocus, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$clearFocus.getFocusState().ordinal()]) {
            case 1:
                $this$clearFocus.setFocusState(FocusStateImpl.Inactive);
                return true;
            case 2:
                if (forcedClear) {
                    $this$clearFocus.setFocusState(FocusStateImpl.Inactive);
                }
                return forcedClear;
            case 3:
                if (!clearChildFocus($this$clearFocus)) {
                    return false;
                }
                $this$clearFocus.setFocusState(FocusStateImpl.Inactive);
                return true;
            case 4:
            case 6:
                return true;
            case 5:
                if (!clearChildFocus($this$clearFocus)) {
                    return false;
                }
                $this$clearFocus.setFocusState(FocusStateImpl.Deactivated);
                return true;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final void grantFocus(FocusModifier $this$grantFocus) {
        FocusStateImpl focusStateImpl;
        switch (WhenMappings.$EnumSwitchMapping$0[$this$grantFocus.getFocusState().ordinal()]) {
            case 1:
            case 3:
            case 6:
                focusStateImpl = FocusStateImpl.Active;
                break;
            case 2:
                focusStateImpl = FocusStateImpl.Captured;
                break;
            case 4:
            case 5:
                throw new IllegalStateException("Granting focus to a deactivated node.".toString());
            default:
                throw new NoWhenBranchMatchedException();
        }
        $this$grantFocus.setFocusState(focusStateImpl);
    }

    private static final boolean grantFocusToChild(FocusModifier $this$grantFocusToChild, FocusModifier childNode) {
        $this$grantFocusToChild.setFocusedChild(childNode);
        grantFocus(childNode);
        return true;
    }

    private static final boolean clearChildFocus(FocusModifier $this$clearChildFocus) {
        FocusModifier focusedChild = $this$clearChildFocus.getFocusedChild();
        if (focusedChild == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        if (!clearFocus$default(focusedChild, false, 1, null)) {
            return false;
        }
        $this$clearChildFocus.setFocusedChild(null);
        return true;
    }

    private static final boolean requestFocusForChild(FocusModifier $this$requestFocusForChild, FocusModifier childNode) {
        if (!$this$requestFocusForChild.getChildren().contains(childNode)) {
            throw new IllegalStateException("Non child node cannot request focus.".toString());
        }
        switch (WhenMappings.$EnumSwitchMapping$0[$this$requestFocusForChild.getFocusState().ordinal()]) {
            case 1:
                $this$requestFocusForChild.setFocusState(FocusStateImpl.ActiveParent);
                return grantFocusToChild($this$requestFocusForChild, childNode);
            case 2:
                return false;
            case 3:
                if (clearChildFocus($this$requestFocusForChild)) {
                    return grantFocusToChild($this$requestFocusForChild, childNode);
                }
                return false;
            case 4:
                activateNode($this$requestFocusForChild);
                boolean requestFocusForChild = requestFocusForChild($this$requestFocusForChild, childNode);
                deactivateNode($this$requestFocusForChild);
                return requestFocusForChild;
            case 5:
                if ($this$requestFocusForChild.getFocusedChild() == null || clearChildFocus($this$requestFocusForChild)) {
                    return grantFocusToChild($this$requestFocusForChild, childNode);
                }
                return false;
            case 6:
                FocusModifier focusParent = $this$requestFocusForChild.getParent();
                if (focusParent == null && requestFocusForOwner($this$requestFocusForChild)) {
                    $this$requestFocusForChild.setFocusState(FocusStateImpl.Active);
                    return requestFocusForChild($this$requestFocusForChild, childNode);
                }
                if (focusParent == null || !requestFocusForChild(focusParent, $this$requestFocusForChild)) {
                    return false;
                }
                return requestFocusForChild($this$requestFocusForChild, childNode);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final boolean requestFocusForOwner(FocusModifier $this$requestFocusForOwner) {
        LayoutNode layoutNode;
        Owner owner;
        NodeCoordinator coordinator = $this$requestFocusForOwner.getCoordinator();
        if (coordinator == null || (layoutNode = coordinator.getLayoutNode()) == null || (owner = layoutNode.getOwner()) == null) {
            throw new IllegalStateException("Owner not initialized.".toString());
        }
        return owner.requestFocus();
    }

    public static final void sendOnFocusEvent(FocusModifier $this$sendOnFocusEvent) {
        Intrinsics.checkNotNullParameter($this$sendOnFocusEvent, "<this>");
        FocusEventModifierLocal focusEventListener = $this$sendOnFocusEvent.getFocusEventListener();
        if (focusEventListener != null) {
            focusEventListener.propagateFocusEvent();
        }
    }
}
