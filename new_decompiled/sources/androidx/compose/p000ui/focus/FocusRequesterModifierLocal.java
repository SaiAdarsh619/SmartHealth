package androidx.compose.p000ui.focus;

import androidx.compose.p000ui.modifier.ModifierLocalConsumer;
import androidx.compose.p000ui.modifier.ModifierLocalProvider;
import androidx.compose.p000ui.modifier.ModifierLocalReadScope;
import androidx.compose.p000ui.modifier.ProvidableModifierLocal;
import androidx.compose.p000ui.node.LayoutNode;
import androidx.compose.p000ui.node.NodeCoordinator;
import androidx.compose.runtime.collection.MutableVector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusRequesterModifier.kt */
@Metadata(m286d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bJ\u0014\u0010\u0016\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bJ\u0014\u0010\u001d\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, m287d2 = {"Landroidx/compose/ui/focus/FocusRequesterModifierLocal;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Landroidx/compose/ui/focus/FocusRequester;)V", "focusModifiers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/focus/FocusModifier;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "parent", "value", "getValue", "()Landroidx/compose/ui/focus/FocusRequesterModifierLocal;", "addFocusModifier", "", "focusModifier", "addFocusModifiers", "newModifiers", "findFocusNode", "onModifierLocalsUpdated", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "removeFocusModifier", "removeFocusModifiers", "removedModifiers", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class FocusRequesterModifierLocal implements ModifierLocalConsumer, ModifierLocalProvider<FocusRequesterModifierLocal> {
    private final MutableVector<FocusModifier> focusModifiers;
    private final FocusRequester focusRequester;
    private FocusRequesterModifierLocal parent;

    public FocusRequesterModifierLocal(FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        this.focusRequester = focusRequester;
        this.focusModifiers = new MutableVector<>(new FocusModifier[16], 0);
        MutableVector this_$iv = this.focusRequester.getFocusRequesterModifierLocals$ui_release();
        this_$iv.add(this);
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    @Override // androidx.compose.p000ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        FocusRequesterModifierLocal newParent = (FocusRequesterModifierLocal) scope.getCurrent(FocusRequesterModifierKt.getModifierLocalFocusRequester());
        if (!Intrinsics.areEqual(newParent, this.parent)) {
            FocusRequesterModifierLocal focusRequesterModifierLocal = this.parent;
            if (focusRequesterModifierLocal != null) {
                focusRequesterModifierLocal.removeFocusModifiers(this.focusModifiers);
            }
            if (newParent != null) {
                newParent.addFocusModifiers(this.focusModifiers);
            }
            this.parent = newParent;
        }
    }

    @Override // androidx.compose.p000ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal<FocusRequesterModifierLocal> getKey() {
        return FocusRequesterModifierKt.getModifierLocalFocusRequester();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.p000ui.modifier.ModifierLocalProvider
    public FocusRequesterModifierLocal getValue() {
        return this;
    }

    public final void addFocusModifier(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "focusModifier");
        MutableVector this_$iv = this.focusModifiers;
        this_$iv.add(focusModifier);
        FocusRequesterModifierLocal focusRequesterModifierLocal = this.parent;
        if (focusRequesterModifierLocal != null) {
            focusRequesterModifierLocal.addFocusModifier(focusModifier);
        }
    }

    public final void addFocusModifiers(MutableVector<FocusModifier> newModifiers) {
        Intrinsics.checkNotNullParameter(newModifiers, "newModifiers");
        MutableVector this_$iv = this.focusModifiers;
        this_$iv.addAll(this_$iv.getSize(), newModifiers);
        FocusRequesterModifierLocal focusRequesterModifierLocal = this.parent;
        if (focusRequesterModifierLocal != null) {
            focusRequesterModifierLocal.addFocusModifiers(newModifiers);
        }
    }

    public final void removeFocusModifier(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "focusModifier");
        MutableVector this_$iv = this.focusModifiers;
        this_$iv.remove(focusModifier);
        FocusRequesterModifierLocal focusRequesterModifierLocal = this.parent;
        if (focusRequesterModifierLocal != null) {
            focusRequesterModifierLocal.removeFocusModifier(focusModifier);
        }
    }

    public final void removeFocusModifiers(MutableVector<FocusModifier> removedModifiers) {
        Intrinsics.checkNotNullParameter(removedModifiers, "removedModifiers");
        this.focusModifiers.removeAll(removedModifiers);
        FocusRequesterModifierLocal focusRequesterModifierLocal = this.parent;
        if (focusRequesterModifierLocal != null) {
            focusRequesterModifierLocal.removeFocusModifiers(removedModifiers);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0094, code lost:
    
        if (r13 < r14) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final FocusModifier findFocusNode() {
        NodeCoordinator coordinator;
        LayoutNode layoutNode1;
        LayoutNode layoutNode2;
        MutableVector this_$iv = this.focusModifiers;
        FocusModifier focusModifier = (FocusModifier) null;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                FocusModifier mod2 = (FocusModifier) content$iv[i$iv];
                FocusModifier mod1 = focusModifier;
                if (mod1 != null && (coordinator = mod1.getCoordinator()) != null && (layoutNode1 = coordinator.getLayoutNode()) != null) {
                    NodeCoordinator coordinator2 = mod2.getCoordinator();
                    if (coordinator2 != null && (layoutNode2 = coordinator2.getLayoutNode()) != null) {
                        while (layoutNode1.getDepth() > layoutNode2.getDepth()) {
                            LayoutNode parent$ui_release = layoutNode1.getParent$ui_release();
                            Intrinsics.checkNotNull(parent$ui_release);
                            layoutNode1 = parent$ui_release;
                        }
                        while (layoutNode2.getDepth() > layoutNode1.getDepth()) {
                            LayoutNode parent$ui_release2 = layoutNode2.getParent$ui_release();
                            Intrinsics.checkNotNull(parent$ui_release2);
                            layoutNode2 = parent$ui_release2;
                        }
                        while (!Intrinsics.areEqual(layoutNode1.getParent$ui_release(), layoutNode2.getParent$ui_release())) {
                            LayoutNode parent$ui_release3 = layoutNode1.getParent$ui_release();
                            Intrinsics.checkNotNull(parent$ui_release3);
                            layoutNode1 = parent$ui_release3;
                            LayoutNode parent$ui_release4 = layoutNode2.getParent$ui_release();
                            Intrinsics.checkNotNull(parent$ui_release4);
                            layoutNode2 = parent$ui_release4;
                        }
                        LayoutNode parent$ui_release5 = layoutNode1.getParent$ui_release();
                        Intrinsics.checkNotNull(parent$ui_release5);
                        List children = parent$ui_release5.getChildren$ui_release();
                        int index1 = children.indexOf(layoutNode1);
                        int index2 = children.indexOf(layoutNode2);
                    }
                    mod2 = mod1;
                }
                focusModifier = mod2;
                i$iv++;
            } while (i$iv < size$iv);
        }
        FocusModifier first = focusModifier;
        return first;
    }
}
