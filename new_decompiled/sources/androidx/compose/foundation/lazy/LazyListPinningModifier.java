package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.PinnableParent;
import androidx.compose.foundation.lazy.layout.PinnableParentKt;
import androidx.compose.p000ui.layout.Remeasurement;
import androidx.compose.p000ui.modifier.ModifierLocalConsumer;
import androidx.compose.p000ui.modifier.ModifierLocalProvider;
import androidx.compose.p000ui.modifier.ModifierLocalReadScope;
import androidx.compose.p000ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyListPinningModifier.kt */
@Metadata(m286d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001a2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0002:\u0001\u001aB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001b"}, m287d2 = {"Landroidx/compose/foundation/lazy/LazyListPinningModifier;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/foundation/lazy/layout/PinnableParent;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;)V", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "pinnableGrandParent", "getPinnableGrandParent", "()Landroidx/compose/foundation/lazy/layout/PinnableParent;", "setPinnableGrandParent", "(Landroidx/compose/foundation/lazy/layout/PinnableParent;)V", "value", "getValue", "onModifierLocalsUpdated", "", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "pinItems", "Landroidx/compose/foundation/lazy/layout/PinnableParent$PinnedItemsHandle;", "Companion", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class LazyListPinningModifier implements ModifierLocalProvider<PinnableParent>, ModifierLocalConsumer, PinnableParent {
    private static final LazyListPinningModifier$Companion$EmptyPinnedItemsHandle$1 EmptyPinnedItemsHandle = new PinnableParent.PinnedItemsHandle() { // from class: androidx.compose.foundation.lazy.LazyListPinningModifier$Companion$EmptyPinnedItemsHandle$1
        @Override // androidx.compose.foundation.lazy.layout.PinnableParent.PinnedItemsHandle
        public void unpin() {
        }
    };
    private final LazyListBeyondBoundsInfo beyondBoundsInfo;
    private PinnableParent pinnableGrandParent;
    private final LazyListState state;

    public LazyListPinningModifier(LazyListState state, LazyListBeyondBoundsInfo beyondBoundsInfo) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(beyondBoundsInfo, "beyondBoundsInfo");
        this.state = state;
        this.beyondBoundsInfo = beyondBoundsInfo;
    }

    public final PinnableParent getPinnableGrandParent() {
        return this.pinnableGrandParent;
    }

    public final void setPinnableGrandParent(PinnableParent pinnableParent) {
        this.pinnableGrandParent = pinnableParent;
    }

    @Override // androidx.compose.p000ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal<PinnableParent> getKey() {
        return PinnableParentKt.getModifierLocalPinnableParent();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.p000ui.modifier.ModifierLocalProvider
    public PinnableParent getValue() {
        return this;
    }

    @Override // androidx.compose.p000ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.pinnableGrandParent = (PinnableParent) scope.getCurrent(PinnableParentKt.getModifierLocalPinnableParent());
    }

    @Override // androidx.compose.foundation.lazy.layout.PinnableParent
    public PinnableParent.PinnedItemsHandle pinItems() {
        PinnableParent.PinnedItemsHandle pinItems;
        final LazyListBeyondBoundsInfo $this$pinItems_u24lambda_u2d1 = this.beyondBoundsInfo;
        if ($this$pinItems_u24lambda_u2d1.hasIntervals()) {
            return new PinnableParent.PinnedItemsHandle($this$pinItems_u24lambda_u2d1) { // from class: androidx.compose.foundation.lazy.LazyListPinningModifier$pinItems$1$1
                final /* synthetic */ LazyListBeyondBoundsInfo $this_with;
                private final LazyListBeyondBoundsInfo.Interval interval;
                private final PinnableParent.PinnedItemsHandle parentPinnedItemsHandle;

                {
                    this.$this_with = $this$pinItems_u24lambda_u2d1;
                    PinnableParent pinnableGrandParent = LazyListPinningModifier.this.getPinnableGrandParent();
                    this.parentPinnedItemsHandle = pinnableGrandParent != null ? pinnableGrandParent.pinItems() : null;
                    this.interval = $this$pinItems_u24lambda_u2d1.addInterval($this$pinItems_u24lambda_u2d1.getStart(), $this$pinItems_u24lambda_u2d1.getEnd());
                }

                public final PinnableParent.PinnedItemsHandle getParentPinnedItemsHandle() {
                    return this.parentPinnedItemsHandle;
                }

                public final LazyListBeyondBoundsInfo.Interval getInterval() {
                    return this.interval;
                }

                @Override // androidx.compose.foundation.lazy.layout.PinnableParent.PinnedItemsHandle
                public void unpin() {
                    LazyListState lazyListState;
                    this.$this_with.removeInterval(this.interval);
                    PinnableParent.PinnedItemsHandle pinnedItemsHandle = this.parentPinnedItemsHandle;
                    if (pinnedItemsHandle != null) {
                        pinnedItemsHandle.unpin();
                    }
                    lazyListState = LazyListPinningModifier.this.state;
                    Remeasurement remeasurement$foundation_release = lazyListState.getRemeasurement$foundation_release();
                    if (remeasurement$foundation_release != null) {
                        remeasurement$foundation_release.forceRemeasure();
                    }
                }
            };
        }
        PinnableParent pinnableParent = this.pinnableGrandParent;
        return (pinnableParent == null || (pinItems = pinnableParent.pinItems()) == null) ? EmptyPinnedItemsHandle : pinItems;
    }
}
