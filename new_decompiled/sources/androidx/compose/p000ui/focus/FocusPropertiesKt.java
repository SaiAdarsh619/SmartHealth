package androidx.compose.p000ui.focus;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.modifier.ModifierLocalKt;
import androidx.compose.p000ui.modifier.ProvidableModifierLocal;
import androidx.compose.p000ui.node.NodeCoordinator;
import androidx.compose.p000ui.node.Owner;
import androidx.compose.p000ui.node.OwnerSnapshotObserver;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.health.connect.client.records.CervicalMucusRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusProperties.kt */
@Metadata(m286d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a#\u0010\b\u001a\u00020\t*\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\f\u001a\f\u0010\r\u001a\u00020\u0006*\u00020\u000eH\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0006*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u0000\"\u001c\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0011"}, m287d2 = {"ModifierLocalFocusProperties", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/ui/focus/FocusPropertiesModifier;", "getModifierLocalFocusProperties", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", CervicalMucusRecord.Appearance.CLEAR, "", "Landroidx/compose/ui/focus/FocusProperties;", "focusProperties", "Landroidx/compose/ui/Modifier;", "scope", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "refreshFocusProperties", "Landroidx/compose/ui/focus/FocusModifier;", "setUpdatedProperties", "properties", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class FocusPropertiesKt {
    private static final ProvidableModifierLocal<FocusPropertiesModifier> ModifierLocalFocusProperties = ModifierLocalKt.modifierLocalOf(new Function0<FocusPropertiesModifier>() { // from class: androidx.compose.ui.focus.FocusPropertiesKt$ModifierLocalFocusProperties$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FocusPropertiesModifier invoke() {
            return null;
        }
    });

    public static final ProvidableModifierLocal<FocusPropertiesModifier> getModifierLocalFocusProperties() {
        return ModifierLocalFocusProperties;
    }

    public static final Modifier focusProperties(Modifier $this$focusProperties, final Function1<? super FocusProperties, Unit> scope) {
        Intrinsics.checkNotNullParameter($this$focusProperties, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return $this$focusProperties.then(new FocusPropertiesModifier(scope, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.focus.FocusPropertiesKt$focusProperties$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("focusProperties");
                $this$null.getProperties().set("scope", Function1.this);
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    public static final void setUpdatedProperties(FocusModifier $this$setUpdatedProperties, FocusProperties properties) {
        Intrinsics.checkNotNullParameter($this$setUpdatedProperties, "<this>");
        Intrinsics.checkNotNullParameter(properties, "properties");
        if (properties.getCanFocus()) {
            FocusTransactionsKt.activateNode($this$setUpdatedProperties);
        } else {
            FocusTransactionsKt.deactivateNode($this$setUpdatedProperties);
        }
    }

    public static final void clear(FocusProperties $this$clear) {
        Intrinsics.checkNotNullParameter($this$clear, "<this>");
        $this$clear.setCanFocus(true);
        $this$clear.setNext(FocusRequester.INSTANCE.getDefault());
        $this$clear.setPrevious(FocusRequester.INSTANCE.getDefault());
        $this$clear.setUp(FocusRequester.INSTANCE.getDefault());
        $this$clear.setDown(FocusRequester.INSTANCE.getDefault());
        $this$clear.setLeft(FocusRequester.INSTANCE.getDefault());
        $this$clear.setRight(FocusRequester.INSTANCE.getDefault());
        $this$clear.setStart(FocusRequester.INSTANCE.getDefault());
        $this$clear.setEnd(FocusRequester.INSTANCE.getDefault());
        $this$clear.setEnter(new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusPropertiesKt$clear$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
                return m1710invoke3ESFkO8(focusDirection.getValue());
            }

            /* renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m1710invoke3ESFkO8(int it) {
                return FocusRequester.INSTANCE.getDefault();
            }
        });
        $this$clear.setExit(new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusPropertiesKt$clear$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
                return m1711invoke3ESFkO8(focusDirection.getValue());
            }

            /* renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m1711invoke3ESFkO8(int it) {
                return FocusRequester.INSTANCE.getDefault();
            }
        });
    }

    public static final void refreshFocusProperties(final FocusModifier $this$refreshFocusProperties) {
        OwnerSnapshotObserver snapshotObserver;
        Intrinsics.checkNotNullParameter($this$refreshFocusProperties, "<this>");
        NodeCoordinator coordinator = $this$refreshFocusProperties.getCoordinator();
        if (coordinator == null) {
            return;
        }
        clear($this$refreshFocusProperties.getFocusProperties());
        Owner owner = coordinator.getLayoutNode().getOwner();
        if (owner != null && (snapshotObserver = owner.getSnapshotObserver()) != null) {
            snapshotObserver.observeReads$ui_release($this$refreshFocusProperties, FocusModifier.INSTANCE.getRefreshFocusProperties(), new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusPropertiesKt$refreshFocusProperties$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FocusPropertiesModifier focusPropertiesModifier = FocusModifier.this.getFocusPropertiesModifier();
                    if (focusPropertiesModifier != null) {
                        focusPropertiesModifier.calculateProperties(FocusModifier.this.getFocusProperties());
                    }
                }
            });
        }
        setUpdatedProperties($this$refreshFocusProperties, $this$refreshFocusProperties.getFocusProperties());
    }
}
