package androidx.compose.p000ui.node;

import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutNodeLayoutDelegate.kt */
@Metadata(m286d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0007H\u0002¨\u0006\b"}, m287d2 = {"updateChildMeasurables", "", "Landroidx/compose/ui/node/LayoutNode;", "destination", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/layout/Measurable;", "transform", "Lkotlin/Function1;", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LayoutNodeLayoutDelegateKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateChildMeasurables(LayoutNode $this$updateChildMeasurables, MutableVector<Measurable> mutableVector, Function1<? super LayoutNode, ? extends Measurable> function1) {
        MutableVector this_$iv$iv = $this$updateChildMeasurables.get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                LayoutNode layoutNode = (LayoutNode) content$iv$iv[i$iv$iv];
                int i = i$iv$iv;
                if (mutableVector.getSize() <= i) {
                    mutableVector.add(function1.invoke(layoutNode));
                } else {
                    mutableVector.set(i, function1.invoke(layoutNode));
                }
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
        mutableVector.removeRange($this$updateChildMeasurables.getChildren$ui_release().size(), mutableVector.getSize());
    }
}
