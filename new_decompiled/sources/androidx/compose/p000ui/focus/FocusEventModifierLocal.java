package androidx.compose.p000ui.focus;

import androidx.compose.p000ui.modifier.ModifierLocalConsumer;
import androidx.compose.p000ui.modifier.ModifierLocalProvider;
import androidx.compose.p000ui.modifier.ModifierLocalReadScope;
import androidx.compose.p000ui.modifier.ProvidableModifierLocal;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusEventModifier.kt */
@Metadata(m286d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00012\u00020\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000bJ\u0016\u0010\u0018\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\tH\u0002J\u0006\u0010\u001a\u001a\u00020\u0006J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0006\u0010\u001e\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000bJ\u0016\u0010 \u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\tH\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, m287d2 = {"Landroidx/compose/ui/focus/FocusEventModifierLocal;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "onFocusEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusState;", "", "(Lkotlin/jvm/functions/Function1;)V", "children", "Landroidx/compose/runtime/collection/MutableVector;", "focusModifiers", "Landroidx/compose/ui/focus/FocusModifier;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getOnFocusEvent", "()Lkotlin/jvm/functions/Function1;", "parent", "value", "getValue", "()Landroidx/compose/ui/focus/FocusEventModifierLocal;", "addFocusModifier", "focusModifier", "addFocusModifiers", "modifiers", "notifyIfNoFocusModifiers", "onModifierLocalsUpdated", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "propagateFocusEvent", "removeFocusModifier", "removeFocusModifiers", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class FocusEventModifierLocal implements ModifierLocalProvider<FocusEventModifierLocal>, ModifierLocalConsumer {
    private final MutableVector<FocusEventModifierLocal> children;
    private final MutableVector<FocusModifier> focusModifiers;
    private final Function1<FocusState, Unit> onFocusEvent;
    private FocusEventModifierLocal parent;

    /* compiled from: FocusEventModifier.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 2;
            iArr[FocusStateImpl.Captured.ordinal()] = 3;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 4;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FocusEventModifierLocal(Function1<? super FocusState, Unit> onFocusEvent) {
        Intrinsics.checkNotNullParameter(onFocusEvent, "onFocusEvent");
        this.onFocusEvent = onFocusEvent;
        this.children = new MutableVector<>(new FocusEventModifierLocal[16], 0);
        this.focusModifiers = new MutableVector<>(new FocusModifier[16], 0);
    }

    public final Function1<FocusState, Unit> getOnFocusEvent() {
        return this.onFocusEvent;
    }

    @Override // androidx.compose.p000ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal<FocusEventModifierLocal> getKey() {
        return FocusEventModifierKt.getModifierLocalFocusEvent();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.p000ui.modifier.ModifierLocalProvider
    public FocusEventModifierLocal getValue() {
        return this;
    }

    @Override // androidx.compose.p000ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        FocusEventModifierLocal newParent = (FocusEventModifierLocal) scope.getCurrent(FocusEventModifierKt.getModifierLocalFocusEvent());
        if (!Intrinsics.areEqual(newParent, this.parent)) {
            FocusEventModifierLocal parent = this.parent;
            if (parent != null) {
                MutableVector this_$iv = parent.children;
                this_$iv.remove(this);
                MutableVector this_$iv2 = this.focusModifiers;
                parent.removeFocusModifiers(this_$iv2);
            }
            this.parent = newParent;
            if (newParent != null) {
                MutableVector this_$iv3 = newParent.children;
                this_$iv3.add(this);
                MutableVector this_$iv4 = this.focusModifiers;
                newParent.addFocusModifiers(this_$iv4);
            }
        }
        this.parent = (FocusEventModifierLocal) scope.getCurrent(FocusEventModifierKt.getModifierLocalFocusEvent());
    }

    public final void addFocusModifier(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "focusModifier");
        MutableVector this_$iv = this.focusModifiers;
        this_$iv.add(focusModifier);
        FocusEventModifierLocal focusEventModifierLocal = this.parent;
        if (focusEventModifierLocal != null) {
            focusEventModifierLocal.addFocusModifier(focusModifier);
        }
    }

    private final void addFocusModifiers(MutableVector<FocusModifier> modifiers) {
        MutableVector this_$iv = this.focusModifiers;
        this_$iv.addAll(this_$iv.getSize(), modifiers);
        FocusEventModifierLocal focusEventModifierLocal = this.parent;
        if (focusEventModifierLocal != null) {
            focusEventModifierLocal.addFocusModifiers(modifiers);
        }
    }

    public final void removeFocusModifier(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "focusModifier");
        MutableVector this_$iv = this.focusModifiers;
        this_$iv.remove(focusModifier);
        FocusEventModifierLocal focusEventModifierLocal = this.parent;
        if (focusEventModifierLocal != null) {
            focusEventModifierLocal.removeFocusModifier(focusModifier);
        }
    }

    private final void removeFocusModifiers(MutableVector<FocusModifier> modifiers) {
        this.focusModifiers.removeAll(modifiers);
        FocusEventModifierLocal focusEventModifierLocal = this.parent;
        if (focusEventModifierLocal != null) {
            focusEventModifierLocal.removeFocusModifiers(modifiers);
        }
    }

    public final void propagateFocusEvent() {
        FocusStateImpl notifiedState;
        FocusStateImpl focusState;
        switch (this.focusModifiers.getSize()) {
            case 0:
                notifiedState = FocusStateImpl.Inactive;
                break;
            case 1:
                notifiedState = this.focusModifiers.getContent()[0].getFocusState();
                break;
            default:
                FocusModifier focusModifier = null;
                Object allChildrenDisabled = null;
                MutableVector this_$iv = this.focusModifiers;
                int size$iv = this_$iv.getSize();
                if (size$iv > 0) {
                    int i$iv = 0;
                    Object[] content$iv = this_$iv.getContent();
                    Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                    do {
                        FocusModifier it = (FocusModifier) content$iv[i$iv];
                        switch (WhenMappings.$EnumSwitchMapping$0[it.getFocusState().ordinal()]) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                focusModifier = it;
                                allChildrenDisabled = false;
                                break;
                            case 5:
                                if (allChildrenDisabled == null) {
                                    allChildrenDisabled = true;
                                    break;
                                }
                                break;
                            case 6:
                                allChildrenDisabled = false;
                                break;
                        }
                        i$iv++;
                    } while (i$iv < size$iv);
                }
                if (focusModifier != null && (focusState = focusModifier.getFocusState()) != null) {
                    notifiedState = focusState;
                    break;
                } else if (Intrinsics.areEqual(allChildrenDisabled, (Object) true)) {
                    notifiedState = FocusStateImpl.Deactivated;
                    break;
                } else {
                    notifiedState = FocusStateImpl.Inactive;
                    break;
                }
                break;
        }
        this.onFocusEvent.invoke(notifiedState);
        FocusEventModifierLocal focusEventModifierLocal = this.parent;
        if (focusEventModifierLocal != null) {
            focusEventModifierLocal.propagateFocusEvent();
        }
    }

    public final void notifyIfNoFocusModifiers() {
        if (this.focusModifiers.isEmpty()) {
            this.onFocusEvent.invoke(FocusStateImpl.Inactive);
        }
    }
}
