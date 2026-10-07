package androidx.compose.p000ui.focus;

import androidx.compose.p000ui.ExperimentalComposeUiApi;
import androidx.compose.p000ui.input.focus.FocusAwareInputModifier;
import androidx.compose.p000ui.input.key.KeyInputModifier;
import androidx.compose.p000ui.input.key.KeyInputModifierKt;
import androidx.compose.p000ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.p000ui.input.rotary.RotaryScrollEvent;
import androidx.compose.p000ui.layout.BeyondBoundsLayout;
import androidx.compose.p000ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.OnPlacedModifier;
import androidx.compose.p000ui.modifier.ModifierLocalConsumer;
import androidx.compose.p000ui.modifier.ModifierLocalProvider;
import androidx.compose.p000ui.modifier.ModifierLocalReadScope;
import androidx.compose.p000ui.modifier.ProvidableModifierLocal;
import androidx.compose.p000ui.node.LayoutNode;
import androidx.compose.p000ui.node.NodeCoordinator;
import androidx.compose.p000ui.node.Owner;
import androidx.compose.p000ui.node.OwnerScope;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.p000ui.platform.InspectorValueInfo;
import androidx.compose.runtime.collection.MutableVector;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusModifier.kt */
@Metadata(m286d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 g2\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001gB(\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0019\b\u0002\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f¢\u0006\u0002\u0010\rJ\u0010\u0010`\u001a\u00020\u000b2\u0006\u0010a\u001a\u00020RH\u0016J\u0010\u0010b\u001a\u00020\u000b2\u0006\u0010c\u001a\u00020dH\u0016J\u0010\u0010e\u001a\u00020/2\u0006\u0010f\u001a\u00020\\H\u0007R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00000\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u00101R\u001c\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000G8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0017\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u0015¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u0017R\"\u0010N\u001a\u0004\u0018\u00010K2\b\u0010M\u001a\u0004\u0018\u00010K@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u001a\u0010Q\u001a\u00020RX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001c\u0010W\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010B\"\u0004\bY\u0010DR\u001c\u0010Z\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010[X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b]\u0010^R\u0014\u0010:\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u0010B¨\u0006h"}, m287d2 = {"Landroidx/compose/ui/focus/FocusModifier;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/layout/OnPlacedModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "initialFocus", "Landroidx/compose/ui/focus/FocusStateImpl;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/focus/FocusStateImpl;Lkotlin/jvm/functions/Function1;)V", "beyondBoundsLayoutParent", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "getBeyondBoundsLayoutParent", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "setBeyondBoundsLayoutParent", "(Landroidx/compose/ui/layout/BeyondBoundsLayout;)V", "children", "Landroidx/compose/runtime/collection/MutableVector;", "getChildren", "()Landroidx/compose/runtime/collection/MutableVector;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "setCoordinator", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "focusEventListener", "Landroidx/compose/ui/focus/FocusEventModifierLocal;", "getFocusEventListener", "()Landroidx/compose/ui/focus/FocusEventModifierLocal;", "setFocusEventListener", "(Landroidx/compose/ui/focus/FocusEventModifierLocal;)V", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "getFocusProperties", "()Landroidx/compose/ui/focus/FocusProperties;", "focusPropertiesModifier", "Landroidx/compose/ui/focus/FocusPropertiesModifier;", "getFocusPropertiesModifier", "()Landroidx/compose/ui/focus/FocusPropertiesModifier;", "setFocusPropertiesModifier", "(Landroidx/compose/ui/focus/FocusPropertiesModifier;)V", "focusRequestedOnPlaced", "", "getFocusRequestedOnPlaced", "()Z", "setFocusRequestedOnPlaced", "(Z)V", "focusRequester", "Landroidx/compose/ui/focus/FocusRequesterModifierLocal;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequesterModifierLocal;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequesterModifierLocal;)V", "value", "focusState", "getFocusState", "()Landroidx/compose/ui/focus/FocusStateImpl;", "setFocusState", "(Landroidx/compose/ui/focus/FocusStateImpl;)V", "focusedChild", "getFocusedChild", "()Landroidx/compose/ui/focus/FocusModifier;", "setFocusedChild", "(Landroidx/compose/ui/focus/FocusModifier;)V", "isValid", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "keyInputChildren", "Landroidx/compose/ui/input/key/KeyInputModifier;", "getKeyInputChildren", "<set-?>", "keyInputModifier", "getKeyInputModifier", "()Landroidx/compose/ui/input/key/KeyInputModifier;", "modifierLocalReadScope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "getModifierLocalReadScope", "()Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "setModifierLocalReadScope", "(Landroidx/compose/ui/modifier/ModifierLocalReadScope;)V", "parent", "getParent", "setParent", "rotaryScrollParent", "Landroidx/compose/ui/input/focus/FocusAwareInputModifier;", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "getRotaryScrollParent$annotations", "()V", "getValue", "onModifierLocalsUpdated", "scope", "onPlaced", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "propagateRotaryEvent", NotificationCompat.CATEGORY_EVENT, "Companion", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class FocusModifier extends InspectorValueInfo implements ModifierLocalConsumer, ModifierLocalProvider<FocusModifier>, OwnerScope, OnPlacedModifier {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function1<FocusModifier, Unit> RefreshFocusProperties = new Function1<FocusModifier, Unit>() { // from class: androidx.compose.ui.focus.FocusModifier$Companion$RefreshFocusProperties$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FocusModifier focusModifier) {
            invoke2(focusModifier);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FocusModifier focusModifier) {
            Intrinsics.checkNotNullParameter(focusModifier, "focusModifier");
            FocusPropertiesKt.refreshFocusProperties(focusModifier);
        }
    };
    private BeyondBoundsLayout beyondBoundsLayoutParent;
    private final MutableVector<FocusModifier> children;
    private NodeCoordinator coordinator;
    private FocusEventModifierLocal focusEventListener;
    private final FocusProperties focusProperties;
    private FocusPropertiesModifier focusPropertiesModifier;
    private boolean focusRequestedOnPlaced;
    private FocusRequesterModifierLocal focusRequester;
    private FocusStateImpl focusState;
    private FocusModifier focusedChild;
    private final MutableVector<KeyInputModifier> keyInputChildren;
    private KeyInputModifier keyInputModifier;
    public ModifierLocalReadScope modifierLocalReadScope;
    private FocusModifier parent;
    private FocusAwareInputModifier<RotaryScrollEvent> rotaryScrollParent;

    /* compiled from: FocusModifier.kt */
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

    private static /* synthetic */ void getRotaryScrollParent$annotations() {
    }

    public /* synthetic */ FocusModifier(FocusStateImpl focusStateImpl, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(focusStateImpl, (i & 2) != 0 ? InspectableValueKt.getNoInspectorInfo() : function1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusModifier(FocusStateImpl initialFocus, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        Intrinsics.checkNotNullParameter(initialFocus, "initialFocus");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.children = new MutableVector<>(new FocusModifier[16], 0);
        this.focusState = initialFocus;
        this.focusProperties = new FocusPropertiesImpl();
        this.keyInputChildren = new MutableVector<>(new KeyInputModifier[16], 0);
    }

    public final FocusModifier getParent() {
        return this.parent;
    }

    public final void setParent(FocusModifier focusModifier) {
        this.parent = focusModifier;
    }

    public final MutableVector<FocusModifier> getChildren() {
        return this.children;
    }

    public final FocusStateImpl getFocusState() {
        return this.focusState;
    }

    public final void setFocusState(FocusStateImpl value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.focusState = value;
        FocusTransactionsKt.sendOnFocusEvent(this);
    }

    public final FocusModifier getFocusedChild() {
        return this.focusedChild;
    }

    public final void setFocusedChild(FocusModifier focusModifier) {
        this.focusedChild = focusModifier;
    }

    public final FocusEventModifierLocal getFocusEventListener() {
        return this.focusEventListener;
    }

    public final void setFocusEventListener(FocusEventModifierLocal focusEventModifierLocal) {
        this.focusEventListener = focusEventModifierLocal;
    }

    public final ModifierLocalReadScope getModifierLocalReadScope() {
        ModifierLocalReadScope modifierLocalReadScope = this.modifierLocalReadScope;
        if (modifierLocalReadScope != null) {
            return modifierLocalReadScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("modifierLocalReadScope");
        return null;
    }

    public final void setModifierLocalReadScope(ModifierLocalReadScope modifierLocalReadScope) {
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "<set-?>");
        this.modifierLocalReadScope = modifierLocalReadScope;
    }

    public final BeyondBoundsLayout getBeyondBoundsLayoutParent() {
        return this.beyondBoundsLayoutParent;
    }

    public final void setBeyondBoundsLayoutParent(BeyondBoundsLayout beyondBoundsLayout) {
        this.beyondBoundsLayoutParent = beyondBoundsLayout;
    }

    public final FocusPropertiesModifier getFocusPropertiesModifier() {
        return this.focusPropertiesModifier;
    }

    public final void setFocusPropertiesModifier(FocusPropertiesModifier focusPropertiesModifier) {
        this.focusPropertiesModifier = focusPropertiesModifier;
    }

    public final FocusProperties getFocusProperties() {
        return this.focusProperties;
    }

    public final FocusRequesterModifierLocal getFocusRequester() {
        return this.focusRequester;
    }

    public final void setFocusRequester(FocusRequesterModifierLocal focusRequesterModifierLocal) {
        this.focusRequester = focusRequesterModifierLocal;
    }

    public final NodeCoordinator getCoordinator() {
        return this.coordinator;
    }

    public final void setCoordinator(NodeCoordinator nodeCoordinator) {
        this.coordinator = nodeCoordinator;
    }

    public final boolean getFocusRequestedOnPlaced() {
        return this.focusRequestedOnPlaced;
    }

    public final void setFocusRequestedOnPlaced(boolean z) {
        this.focusRequestedOnPlaced = z;
    }

    public final KeyInputModifier getKeyInputModifier() {
        return this.keyInputModifier;
    }

    public final MutableVector<KeyInputModifier> getKeyInputChildren() {
        return this.keyInputChildren;
    }

    @Override // androidx.compose.p000ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        MutableVector<FocusModifier> mutableVector;
        MutableVector<FocusModifier> mutableVector2;
        LayoutNode layoutNode;
        Owner owner;
        FocusManager focusManager;
        Intrinsics.checkNotNullParameter(scope, "scope");
        setModifierLocalReadScope(scope);
        Object current = scope.getCurrent(FocusModifierKt.getModifierLocalParentFocusModifier());
        FocusModifier newParent = (FocusModifier) current;
        if (!Intrinsics.areEqual(newParent, this.parent)) {
            if (newParent == null) {
                switch (WhenMappings.$EnumSwitchMapping$0[this.focusState.ordinal()]) {
                    case 1:
                    case 2:
                        NodeCoordinator nodeCoordinator = this.coordinator;
                        if (nodeCoordinator != null && (layoutNode = nodeCoordinator.getLayoutNode()) != null && (owner = layoutNode.getOwner()) != null && (focusManager = owner.getFocusManager()) != null) {
                            focusManager.clearFocus(true);
                            break;
                        }
                        break;
                }
            }
            FocusModifier focusModifier = this.parent;
            if (focusModifier != null && (mutableVector2 = focusModifier.children) != null) {
                mutableVector2.remove(this);
            }
            if (newParent != null && (mutableVector = newParent.children) != null) {
                mutableVector.add(this);
            }
        }
        this.parent = (FocusModifier) current;
        Object current2 = scope.getCurrent(FocusEventModifierKt.getModifierLocalFocusEvent());
        FocusEventModifierLocal newFocusEventListener = (FocusEventModifierLocal) current2;
        if (!Intrinsics.areEqual(newFocusEventListener, this.focusEventListener)) {
            FocusEventModifierLocal focusEventModifierLocal = this.focusEventListener;
            if (focusEventModifierLocal != null) {
                focusEventModifierLocal.removeFocusModifier(this);
            }
            if (newFocusEventListener != null) {
                newFocusEventListener.addFocusModifier(this);
            }
        }
        this.focusEventListener = (FocusEventModifierLocal) current2;
        Object current3 = scope.getCurrent(FocusRequesterModifierKt.getModifierLocalFocusRequester());
        FocusRequesterModifierLocal newFocusRequester = (FocusRequesterModifierLocal) current3;
        if (!Intrinsics.areEqual(newFocusRequester, this.focusRequester)) {
            FocusRequesterModifierLocal focusRequesterModifierLocal = this.focusRequester;
            if (focusRequesterModifierLocal != null) {
                focusRequesterModifierLocal.removeFocusModifier(this);
            }
            if (newFocusRequester != null) {
                newFocusRequester.addFocusModifier(this);
            }
        }
        this.focusRequester = (FocusRequesterModifierLocal) current3;
        this.rotaryScrollParent = (FocusAwareInputModifier) scope.getCurrent(RotaryInputModifierKt.getModifierLocalRotaryScrollParent());
        this.beyondBoundsLayoutParent = (BeyondBoundsLayout) scope.getCurrent(BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout());
        this.keyInputModifier = (KeyInputModifier) scope.getCurrent(KeyInputModifierKt.getModifierLocalKeyInput());
        this.focusPropertiesModifier = (FocusPropertiesModifier) scope.getCurrent(FocusPropertiesKt.getModifierLocalFocusProperties());
        FocusPropertiesKt.refreshFocusProperties(this);
    }

    @ExperimentalComposeUiApi
    public final boolean propagateRotaryEvent(RotaryScrollEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        FocusAwareInputModifier<RotaryScrollEvent> focusAwareInputModifier = this.rotaryScrollParent;
        if (focusAwareInputModifier != null) {
            return focusAwareInputModifier.propagateFocusAwareEvent(event);
        }
        return false;
    }

    @Override // androidx.compose.p000ui.node.OwnerScope
    public boolean isValid() {
        return this.parent != null;
    }

    /* compiled from: FocusModifier.kt */
    @Metadata(m286d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m287d2 = {"Landroidx/compose/ui/focus/FocusModifier$Companion;", "", "()V", "RefreshFocusProperties", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusModifier;", "", "getRefreshFocusProperties", "()Lkotlin/jvm/functions/Function1;", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function1<FocusModifier, Unit> getRefreshFocusProperties() {
            return FocusModifier.RefreshFocusProperties;
        }
    }

    @Override // androidx.compose.p000ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal<FocusModifier> getKey() {
        return FocusModifierKt.getModifierLocalParentFocusModifier();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.p000ui.modifier.ModifierLocalProvider
    public FocusModifier getValue() {
        return this;
    }

    @Override // androidx.compose.p000ui.layout.OnPlacedModifier
    public void onPlaced(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        boolean wasNull = this.coordinator == null;
        this.coordinator = (NodeCoordinator) coordinates;
        if (wasNull) {
            FocusPropertiesKt.refreshFocusProperties(this);
        }
        if (this.focusRequestedOnPlaced) {
            this.focusRequestedOnPlaced = false;
            FocusTransactionsKt.requestFocus(this);
        }
    }
}
