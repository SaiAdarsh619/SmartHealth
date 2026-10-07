package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo;
import androidx.compose.p000ui.layout.BeyondBoundsLayout;
import androidx.compose.p000ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.p000ui.layout.Remeasurement;
import androidx.compose.p000ui.modifier.ModifierLocalProvider;
import androidx.compose.p000ui.modifier.ProvidableModifierLocal;
import androidx.compose.p000ui.unit.LayoutDirection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: LazyBeyondBoundsModifier.kt */
@Metadata(m286d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ%\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J@\u0010\u001a\u001a\u0004\u0018\u0001H\u001b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0019\u0010\u001c\u001a\u0015\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u0001H\u001b0\u001d¢\u0006\u0002\b\u001fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!J!\u0010\"\u001a\u00020\b*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006%"}, m287d2 = {"Landroidx/compose/foundation/lazy/LazyListBeyondBoundsModifierLocal;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "reverseLayout", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;ZLandroidx/compose/ui/unit/LayoutDirection;)V", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "getValue", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "addNextInterval", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;", "currentInterval", "direction", "Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "addNextInterval-FR3nfPY", "(Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;I)Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;", "layout", "T", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "layout-o7g1Pn8", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "hasMoreContent", "hasMoreContent-FR3nfPY", "(Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;I)Z", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class LazyListBeyondBoundsModifierLocal implements ModifierLocalProvider<BeyondBoundsLayout>, BeyondBoundsLayout {
    private final LazyListBeyondBoundsInfo beyondBoundsInfo;
    private final LayoutDirection layoutDirection;
    private final boolean reverseLayout;
    private final LazyListState state;

    /* compiled from: LazyBeyondBoundsModifier.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LazyListBeyondBoundsModifierLocal(LazyListState state, LazyListBeyondBoundsInfo beyondBoundsInfo, boolean reverseLayout, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(beyondBoundsInfo, "beyondBoundsInfo");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        this.state = state;
        this.beyondBoundsInfo = beyondBoundsInfo;
        this.reverseLayout = reverseLayout;
        this.layoutDirection = layoutDirection;
    }

    @Override // androidx.compose.p000ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal<BeyondBoundsLayout> getKey() {
        return BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.p000ui.modifier.ModifierLocalProvider
    public BeyondBoundsLayout getValue() {
        return this;
    }

    @Override // androidx.compose.p000ui.layout.BeyondBoundsLayout
    /* renamed from: layout-o7g1Pn8, reason: not valid java name */
    public <T> T mo864layouto7g1Pn8(final int direction, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) this.beyondBoundsInfo.addInterval(this.state.getFirstVisibleItemIndex(), ((LazyListItemInfo) CollectionsKt.last((List) this.state.getLayoutInfo().getVisibleItemsInfo())).getIndex());
        T t = null;
        while (t == null && m863hasMoreContentFR3nfPY((LazyListBeyondBoundsInfo.Interval) objectRef.element, direction)) {
            T t2 = (T) m862addNextIntervalFR3nfPY((LazyListBeyondBoundsInfo.Interval) objectRef.element, direction);
            this.beyondBoundsInfo.removeInterval((LazyListBeyondBoundsInfo.Interval) objectRef.element);
            objectRef.element = t2;
            Remeasurement remeasurement$foundation_release = this.state.getRemeasurement$foundation_release();
            if (remeasurement$foundation_release != null) {
                remeasurement$foundation_release.forceRemeasure();
            }
            t = block.invoke(new BeyondBoundsLayout.BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierLocal$layout$2
                @Override // androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope
                public boolean getHasMoreContent() {
                    boolean m863hasMoreContentFR3nfPY;
                    m863hasMoreContentFR3nfPY = LazyListBeyondBoundsModifierLocal.this.m863hasMoreContentFR3nfPY(objectRef.element, direction);
                    return m863hasMoreContentFR3nfPY;
                }
            });
        }
        this.beyondBoundsInfo.removeInterval((LazyListBeyondBoundsInfo.Interval) objectRef.element);
        Remeasurement remeasurement$foundation_release2 = this.state.getRemeasurement$foundation_release();
        if (remeasurement$foundation_release2 != null) {
            remeasurement$foundation_release2.forceRemeasure();
        }
        return t;
    }

    /* renamed from: addNextInterval-FR3nfPY, reason: not valid java name */
    private final LazyListBeyondBoundsInfo.Interval m862addNextIntervalFR3nfPY(LazyListBeyondBoundsInfo.Interval currentInterval, int direction) {
        int start = currentInterval.getStart();
        int end = currentInterval.getEnd();
        if (BeyondBoundsLayout.LayoutDirection.m3472equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.INSTANCE.m3478getBeforehoxUOeE())) {
            start--;
        } else if (BeyondBoundsLayout.LayoutDirection.m3472equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.INSTANCE.m3477getAfterhoxUOeE())) {
            end++;
        } else if (BeyondBoundsLayout.LayoutDirection.m3472equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.INSTANCE.m3476getAbovehoxUOeE())) {
            if (this.reverseLayout) {
                end++;
            } else {
                start--;
            }
        } else if (BeyondBoundsLayout.LayoutDirection.m3472equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.INSTANCE.m3479getBelowhoxUOeE())) {
            if (this.reverseLayout) {
                start--;
            } else {
                end++;
            }
        } else if (BeyondBoundsLayout.LayoutDirection.m3472equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.INSTANCE.m3480getLefthoxUOeE())) {
            switch (WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()]) {
                case 1:
                    if (!this.reverseLayout) {
                        start--;
                        break;
                    } else {
                        end++;
                        break;
                    }
                case 2:
                    if (!this.reverseLayout) {
                        end++;
                        break;
                    } else {
                        start--;
                        break;
                    }
            }
        } else {
            if (!BeyondBoundsLayout.LayoutDirection.m3472equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.INSTANCE.m3481getRighthoxUOeE())) {
                LazyBeyondBoundsModifierKt.unsupportedDirection();
                throw new KotlinNothingValueException();
            }
            switch (WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()]) {
                case 1:
                    if (!this.reverseLayout) {
                        end++;
                        break;
                    } else {
                        start--;
                        break;
                    }
                case 2:
                    if (!this.reverseLayout) {
                        start--;
                        break;
                    } else {
                        end++;
                        break;
                    }
            }
        }
        return this.beyondBoundsInfo.addInterval(start, end);
    }

    private static final boolean hasMoreContent_FR3nfPY$hasMoreItemsBefore(LazyListBeyondBoundsInfo.Interval $this_hasMoreContent) {
        return $this_hasMoreContent.getStart() > 0;
    }

    private static final boolean hasMoreContent_FR3nfPY$hasMoreItemsAfter(LazyListBeyondBoundsInfo.Interval $this_hasMoreContent, LazyListBeyondBoundsModifierLocal this$0) {
        return $this_hasMoreContent.getEnd() < this$0.state.getLayoutInfo().getTotalItemsCount() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hasMoreContent-FR3nfPY, reason: not valid java name */
    public final boolean m863hasMoreContentFR3nfPY(LazyListBeyondBoundsInfo.Interval $this$hasMoreContent_u2dFR3nfPY, int direction) {
        if (BeyondBoundsLayout.LayoutDirection.m3472equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.INSTANCE.m3478getBeforehoxUOeE())) {
            return hasMoreContent_FR3nfPY$hasMoreItemsBefore($this$hasMoreContent_u2dFR3nfPY);
        }
        if (BeyondBoundsLayout.LayoutDirection.m3472equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.INSTANCE.m3477getAfterhoxUOeE())) {
            return hasMoreContent_FR3nfPY$hasMoreItemsAfter($this$hasMoreContent_u2dFR3nfPY, this);
        }
        if (BeyondBoundsLayout.LayoutDirection.m3472equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.INSTANCE.m3476getAbovehoxUOeE())) {
            return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsAfter($this$hasMoreContent_u2dFR3nfPY, this) : hasMoreContent_FR3nfPY$hasMoreItemsBefore($this$hasMoreContent_u2dFR3nfPY);
        }
        if (BeyondBoundsLayout.LayoutDirection.m3472equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.INSTANCE.m3479getBelowhoxUOeE())) {
            return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsBefore($this$hasMoreContent_u2dFR3nfPY) : hasMoreContent_FR3nfPY$hasMoreItemsAfter($this$hasMoreContent_u2dFR3nfPY, this);
        }
        if (BeyondBoundsLayout.LayoutDirection.m3472equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.INSTANCE.m3480getLefthoxUOeE())) {
            switch (WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()]) {
                case 1:
                    return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsAfter($this$hasMoreContent_u2dFR3nfPY, this) : hasMoreContent_FR3nfPY$hasMoreItemsBefore($this$hasMoreContent_u2dFR3nfPY);
                case 2:
                    return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsBefore($this$hasMoreContent_u2dFR3nfPY) : hasMoreContent_FR3nfPY$hasMoreItemsAfter($this$hasMoreContent_u2dFR3nfPY, this);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        if (!BeyondBoundsLayout.LayoutDirection.m3472equalsimpl0(direction, BeyondBoundsLayout.LayoutDirection.INSTANCE.m3481getRighthoxUOeE())) {
            LazyBeyondBoundsModifierKt.unsupportedDirection();
            throw new KotlinNothingValueException();
        }
        switch (WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()]) {
            case 1:
                return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsBefore($this$hasMoreContent_u2dFR3nfPY) : hasMoreContent_FR3nfPY$hasMoreItemsAfter($this$hasMoreContent_u2dFR3nfPY, this);
            case 2:
                return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsAfter($this$hasMoreContent_u2dFR3nfPY, this) : hasMoreContent_FR3nfPY$hasMoreItemsBefore($this$hasMoreContent_u2dFR3nfPY);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
