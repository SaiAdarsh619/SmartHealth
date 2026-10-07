package androidx.compose.p000ui.focus;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusManager.kt */
@Metadata(m286d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\u0010J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\b\u0015J\u001d\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0010J\u0006\u0010\u001c\u001a\u00020\u0010J\u001d\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, m287d2 = {"Landroidx/compose/ui/focus/FocusManagerImpl;", "Landroidx/compose/ui/focus/FocusManager;", "focusModifier", "Landroidx/compose/ui/focus/FocusModifier;", "(Landroidx/compose/ui/focus/FocusModifier;)V", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "clearFocus", "", "force", "", "fetchUpdatedFocusProperties", "getActiveFocusModifier", "getActiveFocusModifier$ui_release", "moveFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "moveFocus-3ESFkO8", "(I)Z", "releaseFocus", "takeFocus", "wrapAroundFocus", "wrapAroundFocus-3ESFkO8", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class FocusManagerImpl implements FocusManager {
    private final FocusModifier focusModifier;
    public LayoutDirection layoutDirection;
    private final Modifier modifier;

    /* compiled from: FocusManager.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 2;
            iArr[FocusStateImpl.Captured.ordinal()] = 3;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 4;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FocusManagerImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public FocusManagerImpl(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "focusModifier");
        this.focusModifier = focusModifier;
        this.modifier = FocusModifierKt.focusTarget(Modifier.INSTANCE, this.focusModifier);
    }

    public /* synthetic */ FocusManagerImpl(FocusModifier focusModifier, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new FocusModifier(FocusStateImpl.Inactive, null, 2, null) : focusModifier);
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final LayoutDirection getLayoutDirection() {
        LayoutDirection layoutDirection = this.layoutDirection;
        if (layoutDirection != null) {
            return layoutDirection;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutDirection");
        return null;
    }

    public final void setLayoutDirection(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
        this.layoutDirection = layoutDirection;
    }

    public final void takeFocus() {
        if (this.focusModifier.getFocusState() == FocusStateImpl.Inactive) {
            this.focusModifier.setFocusState(FocusStateImpl.Active);
        }
    }

    public final void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.focusModifier, true);
    }

    @Override // androidx.compose.p000ui.focus.FocusManager
    public void clearFocus(boolean force) {
        FocusStateImpl focusStateImpl;
        FocusStateImpl rootInitialState = this.focusModifier.getFocusState();
        if (FocusTransactionsKt.clearFocus(this.focusModifier, force)) {
            FocusModifier focusModifier = this.focusModifier;
            switch (WhenMappings.$EnumSwitchMapping$0[rootInitialState.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    focusStateImpl = FocusStateImpl.Active;
                    break;
                case 4:
                case 5:
                    focusStateImpl = FocusStateImpl.Deactivated;
                    break;
                case 6:
                    focusStateImpl = FocusStateImpl.Inactive;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            focusModifier.setFocusState(focusStateImpl);
        }
    }

    @Override // androidx.compose.p000ui.focus.FocusManager
    /* renamed from: moveFocus-3ESFkO8 */
    public boolean mo1703moveFocus3ESFkO8(int focusDirection) {
        final FocusModifier source = FocusTraversalKt.findActiveFocusNode(this.focusModifier);
        if (source == null) {
            return false;
        }
        FocusRequester nextFocusRequester = FocusOrderModifierKt.m1705customFocusSearchOMvw8(source, focusDirection, getLayoutDirection());
        if (Intrinsics.areEqual(nextFocusRequester, FocusRequester.INSTANCE.getCancel())) {
            return false;
        }
        if (Intrinsics.areEqual(nextFocusRequester, FocusRequester.INSTANCE.getDefault())) {
            boolean foundNextItem = FocusTraversalKt.m1712focusSearchsMXa3k8(this.focusModifier, focusDirection, getLayoutDirection(), new Function1<FocusModifier, Boolean>() { // from class: androidx.compose.ui.focus.FocusManagerImpl$moveFocus$foundNextItem$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(FocusModifier destination) {
                    Intrinsics.checkNotNullParameter(destination, "destination");
                    if (Intrinsics.areEqual(destination, FocusModifier.this)) {
                        return false;
                    }
                    if (destination.getParent() == null) {
                        throw new IllegalStateException("Focus search landed at the root.".toString());
                    }
                    FocusTransactionsKt.requestFocus(destination);
                    return true;
                }
            });
            return foundNextItem || m1704wrapAroundFocus3ESFkO8(focusDirection);
        }
        nextFocusRequester.requestFocus();
        return true;
    }

    public final void fetchUpdatedFocusProperties() {
        FocusManagerKt.updateProperties(this.focusModifier);
    }

    public final FocusModifier getActiveFocusModifier$ui_release() {
        FocusModifier findActiveItem;
        findActiveItem = FocusManagerKt.findActiveItem(this.focusModifier);
        return findActiveItem;
    }

    /* renamed from: wrapAroundFocus-3ESFkO8, reason: not valid java name */
    private final boolean m1704wrapAroundFocus3ESFkO8(int focusDirection) {
        if (!this.focusModifier.getFocusState().getHasFocus() || this.focusModifier.getFocusState().isFocused()) {
            return false;
        }
        if (!(FocusDirection.m1685equalsimpl0(focusDirection, FocusDirection.INSTANCE.m1698getNextdhqQ8s()) ? true : FocusDirection.m1685equalsimpl0(focusDirection, FocusDirection.INSTANCE.m1700getPreviousdhqQ8s()))) {
            return false;
        }
        clearFocus(false);
        if (this.focusModifier.getFocusState().isFocused()) {
            return mo1703moveFocus3ESFkO8(focusDirection);
        }
        return false;
    }
}
