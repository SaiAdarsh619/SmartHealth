package androidx.compose.p000ui.focus;

import androidx.compose.p000ui.layout.BeyondBoundsLayout;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: OneDimensionalFocusSearch.kt */
@Metadata(m286d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a \u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001aE\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\f\u001a\u0002H\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\t0\u0007H\u0082\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u000e\u001aE\u0010\u000f\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\f\u001a\u0002H\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\t0\u0007H\u0082\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u000e\u001a \u0010\u0010\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001a=\u0010\u0011\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\u0004*\u00020\u0005H\u0002\u001a5\u0010\u0018\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a \u0010\u001b\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001a \u0010\u001c\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001a=\u0010\u001d\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u0016\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, m287d2 = {"InvalidFocusDirection", "", "NoActiveChild", "backwardFocusSearch", "", "Landroidx/compose/ui/focus/FocusModifier;", "onFound", "Lkotlin/Function1;", "forEachItemAfter", "", "T", "Landroidx/compose/runtime/collection/MutableVector;", "item", "action", "(Landroidx/compose/runtime/collection/MutableVector;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "forEachItemBefore", "forwardFocusSearch", "generateAndSearchChildren", "focusedItem", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusModifier;Landroidx/compose/ui/focus/FocusModifier;ILkotlin/jvm/functions/Function1;)Z", "isRoot", "oneDimensionalFocusSearch", "oneDimensionalFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusModifier;ILkotlin/jvm/functions/Function1;)Z", "pickChildForBackwardSearch", "pickChildForForwardSearch", "searchChildren", "searchChildren-4C6V_qg", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class OneDimensionalFocusSearchKt {
    private static final String InvalidFocusDirection = "This function should only be used for 1-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    /* compiled from: OneDimensionalFocusSearch.kt */
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

    /* renamed from: oneDimensionalFocusSearch--OM-vw8, reason: not valid java name */
    public static final boolean m1715oneDimensionalFocusSearchOMvw8(FocusModifier oneDimensionalFocusSearch, int direction, Function1<? super FocusModifier, Boolean> onFound) {
        Intrinsics.checkNotNullParameter(oneDimensionalFocusSearch, "$this$oneDimensionalFocusSearch");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        if (FocusDirection.m1685equalsimpl0(direction, FocusDirection.INSTANCE.m1698getNextdhqQ8s())) {
            return forwardFocusSearch(oneDimensionalFocusSearch, onFound);
        }
        if (FocusDirection.m1685equalsimpl0(direction, FocusDirection.INSTANCE.m1700getPreviousdhqQ8s())) {
            return backwardFocusSearch(oneDimensionalFocusSearch, onFound);
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    private static final boolean forwardFocusSearch(FocusModifier $this$forwardFocusSearch, Function1<? super FocusModifier, Boolean> function1) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$forwardFocusSearch.getFocusState().ordinal()]) {
            case 1:
            case 2:
                FocusModifier focusedChild = $this$forwardFocusSearch.getFocusedChild();
                if (focusedChild != null) {
                    return forwardFocusSearch(focusedChild, function1) || m1714generateAndSearchChildren4C6V_qg($this$forwardFocusSearch, focusedChild, FocusDirection.INSTANCE.m1698getNextdhqQ8s(), function1);
                }
                throw new IllegalStateException(NoActiveChild.toString());
            case 3:
            case 4:
            case 5:
                return pickChildForForwardSearch($this$forwardFocusSearch, function1);
            case 6:
                return function1.invoke($this$forwardFocusSearch).booleanValue();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final boolean backwardFocusSearch(FocusModifier $this$backwardFocusSearch, Function1<? super FocusModifier, Boolean> function1) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$backwardFocusSearch.getFocusState().ordinal()]) {
            case 1:
            case 2:
                FocusModifier focusedChild = $this$backwardFocusSearch.getFocusedChild();
                if (focusedChild == null) {
                    throw new IllegalStateException(NoActiveChild.toString());
                }
                switch (WhenMappings.$EnumSwitchMapping$0[focusedChild.getFocusState().ordinal()]) {
                    case 1:
                        return backwardFocusSearch(focusedChild, function1) || function1.invoke(focusedChild).booleanValue();
                    case 2:
                        return backwardFocusSearch(focusedChild, function1) || m1714generateAndSearchChildren4C6V_qg($this$backwardFocusSearch, focusedChild, FocusDirection.INSTANCE.m1700getPreviousdhqQ8s(), function1);
                    case 3:
                    case 4:
                        return m1714generateAndSearchChildren4C6V_qg($this$backwardFocusSearch, focusedChild, FocusDirection.INSTANCE.m1700getPreviousdhqQ8s(), function1);
                    case 5:
                    case 6:
                        throw new IllegalStateException(NoActiveChild.toString());
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            case 3:
            case 4:
            case 5:
                return pickChildForBackwardSearch($this$backwardFocusSearch, function1);
            case 6:
                return pickChildForBackwardSearch($this$backwardFocusSearch, function1) || function1.invoke($this$backwardFocusSearch).booleanValue();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg, reason: not valid java name */
    private static final boolean m1714generateAndSearchChildren4C6V_qg(final FocusModifier $this$generateAndSearchChildren_u2d4C6V_qg, final FocusModifier focusedItem, final int direction, final Function1<? super FocusModifier, Boolean> function1) {
        if (m1716searchChildren4C6V_qg($this$generateAndSearchChildren_u2d4C6V_qg, focusedItem, direction, function1)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m1681searchBeyondBoundsOMvw8($this$generateAndSearchChildren_u2d4C6V_qg, direction, new Function1<BeyondBoundsLayout.BeyondBoundsScope, Boolean>() { // from class: androidx.compose.ui.focus.OneDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BeyondBoundsLayout.BeyondBoundsScope searchBeyondBounds) {
                boolean m1716searchChildren4C6V_qg;
                Intrinsics.checkNotNullParameter(searchBeyondBounds, "$this$searchBeyondBounds");
                m1716searchChildren4C6V_qg = OneDimensionalFocusSearchKt.m1716searchChildren4C6V_qg(FocusModifier.this, focusedItem, direction, function1);
                Boolean valueOf = Boolean.valueOf(m1716searchChildren4C6V_qg);
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
    public static final boolean m1716searchChildren4C6V_qg(FocusModifier $this$searchChildren_u2d4C6V_qg, FocusModifier focusedItem, int direction, Function1<? super FocusModifier, Boolean> function1) {
        if (!($this$searchChildren_u2d4C6V_qg.getFocusState() == FocusStateImpl.ActiveParent || $this$searchChildren_u2d4C6V_qg.getFocusState() == FocusStateImpl.DeactivatedParent)) {
            throw new IllegalStateException("This function should only be used within a parent that has focus.".toString());
        }
        $this$searchChildren_u2d4C6V_qg.getChildren().sortWith(FocusableChildrenComparator.INSTANCE);
        if (!FocusDirection.m1685equalsimpl0(direction, FocusDirection.INSTANCE.m1698getNextdhqQ8s())) {
            if (FocusDirection.m1685equalsimpl0(direction, FocusDirection.INSTANCE.m1700getPreviousdhqQ8s())) {
                MutableVector $this$forEachItemBefore$iv = $this$searchChildren_u2d4C6V_qg.getChildren();
                boolean itemFound$iv = false;
                IntRange intRange = new IntRange(0, $this$forEachItemBefore$iv.getSize() - 1);
                int first = intRange.getFirst();
                int index$iv = intRange.getLast();
                if (first <= index$iv) {
                    while (true) {
                        if (itemFound$iv) {
                            FocusModifier child = $this$forEachItemBefore$iv.getContent()[index$iv];
                            if (FocusTraversalKt.isEligibleForFocusSearch(child) && backwardFocusSearch(child, function1)) {
                                return true;
                            }
                        }
                        if (Intrinsics.areEqual($this$forEachItemBefore$iv.getContent()[index$iv], focusedItem)) {
                            itemFound$iv = true;
                        }
                        if (index$iv == first) {
                            break;
                        }
                        index$iv--;
                    }
                }
            } else {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
        } else {
            MutableVector $this$forEachItemAfter$iv = $this$searchChildren_u2d4C6V_qg.getChildren();
            boolean itemFound$iv2 = false;
            IntRange intRange2 = new IntRange(0, $this$forEachItemAfter$iv.getSize() - 1);
            int index$iv2 = intRange2.getFirst();
            int last = intRange2.getLast();
            if (index$iv2 <= last) {
                while (true) {
                    if (itemFound$iv2) {
                        FocusModifier child2 = $this$forEachItemAfter$iv.getContent()[index$iv2];
                        if (FocusTraversalKt.isEligibleForFocusSearch(child2) && forwardFocusSearch(child2, function1)) {
                            return true;
                        }
                    }
                    if (Intrinsics.areEqual($this$forEachItemAfter$iv.getContent()[index$iv2], focusedItem)) {
                        itemFound$iv2 = true;
                    }
                    if (index$iv2 == last) {
                        break;
                    }
                    index$iv2++;
                }
            }
        }
        if (FocusDirection.m1685equalsimpl0(direction, FocusDirection.INSTANCE.m1698getNextdhqQ8s()) || $this$searchChildren_u2d4C6V_qg.getFocusState() == FocusStateImpl.DeactivatedParent || isRoot($this$searchChildren_u2d4C6V_qg)) {
            return false;
        }
        return function1.invoke($this$searchChildren_u2d4C6V_qg).booleanValue();
    }

    private static final boolean pickChildForForwardSearch(FocusModifier $this$pickChildForForwardSearch, Function1<? super FocusModifier, Boolean> function1) {
        $this$pickChildForForwardSearch.getChildren().sortWith(FocusableChildrenComparator.INSTANCE);
        MutableVector this_$iv = $this$pickChildForForwardSearch.getChildren();
        int size$iv = this_$iv.getSize();
        if (size$iv <= 0) {
            return false;
        }
        int i$iv = 0;
        Object[] content$iv = this_$iv.getContent();
        Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        do {
            FocusModifier it = (FocusModifier) content$iv[i$iv];
            if (((FocusTraversalKt.isEligibleForFocusSearch(it) && forwardFocusSearch(it, function1)) ? 1 : null) != null) {
                return true;
            }
            i$iv++;
        } while (i$iv < size$iv);
        return false;
    }

    private static final boolean pickChildForBackwardSearch(FocusModifier $this$pickChildForBackwardSearch, Function1<? super FocusModifier, Boolean> function1) {
        $this$pickChildForBackwardSearch.getChildren().sortWith(FocusableChildrenComparator.INSTANCE);
        MutableVector this_$iv = $this$pickChildForBackwardSearch.getChildren();
        int size$iv = this_$iv.getSize();
        if (size$iv <= 0) {
            return false;
        }
        int i$iv = size$iv - 1;
        Object[] content$iv = this_$iv.getContent();
        Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        do {
            FocusModifier it = (FocusModifier) content$iv[i$iv];
            if (FocusTraversalKt.isEligibleForFocusSearch(it) && backwardFocusSearch(it, function1)) {
                return true;
            }
            i$iv--;
        } while (i$iv >= 0);
        return false;
    }

    private static final boolean isRoot(FocusModifier $this$isRoot) {
        return $this$isRoot.getParent() == null;
    }

    private static final <T> void forEachItemAfter(MutableVector<T> mutableVector, T t, Function1<? super T, Unit> function1) {
        boolean itemFound = false;
        IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
        int index = intRange.getFirst();
        int last = intRange.getLast();
        if (index > last) {
            return;
        }
        while (true) {
            if (itemFound) {
                function1.invoke(mutableVector.getContent()[index]);
            }
            if (Intrinsics.areEqual(mutableVector.getContent()[index], t)) {
                itemFound = true;
            }
            if (index == last) {
                return;
            } else {
                index++;
            }
        }
    }

    private static final <T> void forEachItemBefore(MutableVector<T> mutableVector, T t, Function1<? super T, Unit> function1) {
        boolean itemFound = false;
        IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
        int first = intRange.getFirst();
        int index = intRange.getLast();
        if (first > index) {
            return;
        }
        while (true) {
            if (itemFound) {
                function1.invoke(mutableVector.getContent()[index]);
            }
            if (Intrinsics.areEqual(mutableVector.getContent()[index], t)) {
                itemFound = true;
            }
            if (index == first) {
                return;
            } else {
                index--;
            }
        }
    }
}
