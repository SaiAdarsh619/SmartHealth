package androidx.compose.p000ui.focus;

import androidx.compose.p000ui.layout.BeyondBoundsLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BeyondBoundsLayout.kt */
@Metadata(m286d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006¢\u0006\u0002\b\bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, m287d2 = {"searchBeyondBounds", "T", "Landroidx/compose/ui/focus/FocusModifier;", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "searchBeyondBounds--OM-vw8", "(Landroidx/compose/ui/focus/FocusModifier;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class BeyondBoundsLayoutKt {
    /* renamed from: searchBeyondBounds--OM-vw8, reason: not valid java name */
    public static final <T> T m1681searchBeyondBoundsOMvw8(FocusModifier searchBeyondBounds, int i, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> block) {
        int m3478getBeforehoxUOeE;
        Intrinsics.checkNotNullParameter(searchBeyondBounds, "$this$searchBeyondBounds");
        Intrinsics.checkNotNullParameter(block, "block");
        BeyondBoundsLayout beyondBoundsLayoutParent = searchBeyondBounds.getBeyondBoundsLayoutParent();
        if (beyondBoundsLayoutParent == null) {
            return null;
        }
        if (FocusDirection.m1685equalsimpl0(i, FocusDirection.INSTANCE.m1702getUpdhqQ8s())) {
            m3478getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m3476getAbovehoxUOeE();
        } else if (FocusDirection.m1685equalsimpl0(i, FocusDirection.INSTANCE.m1693getDowndhqQ8s())) {
            m3478getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m3479getBelowhoxUOeE();
        } else if (FocusDirection.m1685equalsimpl0(i, FocusDirection.INSTANCE.m1697getLeftdhqQ8s())) {
            m3478getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m3480getLefthoxUOeE();
        } else if (FocusDirection.m1685equalsimpl0(i, FocusDirection.INSTANCE.m1701getRightdhqQ8s())) {
            m3478getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m3481getRighthoxUOeE();
        } else if (FocusDirection.m1685equalsimpl0(i, FocusDirection.INSTANCE.m1698getNextdhqQ8s())) {
            m3478getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m3477getAfterhoxUOeE();
        } else {
            if (!FocusDirection.m1685equalsimpl0(i, FocusDirection.INSTANCE.m1700getPreviousdhqQ8s())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
            }
            m3478getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m3478getBeforehoxUOeE();
        }
        return (T) beyondBoundsLayoutParent.mo864layouto7g1Pn8(m3478getBeforehoxUOeE, block);
    }
}
