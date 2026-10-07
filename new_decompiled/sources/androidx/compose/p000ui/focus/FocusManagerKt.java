package androidx.compose.p000ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusManager.kt */
@Metadata(m286d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0001H\u0002¨\u0006\u0004"}, m287d2 = {"findActiveItem", "Landroidx/compose/ui/focus/FocusModifier;", "updateProperties", "", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class FocusManagerKt {

    /* compiled from: FocusManager.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.Captured.ordinal()] = 2;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 4;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateProperties(FocusModifier $this$updateProperties) {
        FocusPropertiesKt.refreshFocusProperties($this$updateProperties);
        MutableVector this_$iv = $this$updateProperties.getChildren();
        int size$iv = this_$iv.getSize();
        if (size$iv <= 0) {
            return;
        }
        int i$iv = 0;
        Object[] content$iv = this_$iv.getContent();
        Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        do {
            FocusModifier it = (FocusModifier) content$iv[i$iv];
            updateProperties(it);
            i$iv++;
        } while (i$iv < size$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FocusModifier findActiveItem(FocusModifier $this$findActiveItem) {
        FocusModifier findActiveItem;
        switch (WhenMappings.$EnumSwitchMapping$0[$this$findActiveItem.getFocusState().ordinal()]) {
            case 1:
            case 2:
                return $this$findActiveItem;
            case 3:
            case 4:
                FocusModifier focusedChild = $this$findActiveItem.getFocusedChild();
                if (focusedChild == null || (findActiveItem = findActiveItem(focusedChild)) == null) {
                    throw new IllegalStateException("no child".toString());
                }
                return findActiveItem;
            case 5:
            case 6:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
