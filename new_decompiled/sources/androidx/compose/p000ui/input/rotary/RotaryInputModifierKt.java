package androidx.compose.p000ui.input.rotary;

import androidx.compose.p000ui.ExperimentalComposeUiApi;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.input.focus.FocusAwareInputModifier;
import androidx.compose.p000ui.input.focus.FocusDirectedInputEvent;
import androidx.compose.p000ui.modifier.ModifierLocalKt;
import androidx.compose.p000ui.modifier.ProvidableModifierLocal;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RotaryInputModifier.kt */
@Metadata(m286d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\tH\u0003\u001a \u0010\f\u001a\u00020\r*\u00020\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\tH\u0007\u001a \u0010\u000e\u001a\u00020\r*\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\tH\u0007\"*\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, m287d2 = {"ModifierLocalRotaryScrollParent", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/ui/input/focus/FocusAwareInputModifier;", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "getModifierLocalRotaryScrollParent$annotations", "()V", "getModifierLocalRotaryScrollParent", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "focusAwareCallback", "Lkotlin/Function1;", "Landroidx/compose/ui/input/focus/FocusDirectedInputEvent;", "", "onPreRotaryScrollEvent", "Landroidx/compose/ui/Modifier;", "onRotaryScrollEvent", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class RotaryInputModifierKt {
    private static final ProvidableModifierLocal<FocusAwareInputModifier<RotaryScrollEvent>> ModifierLocalRotaryScrollParent = ModifierLocalKt.modifierLocalOf(new Function0<FocusAwareInputModifier<RotaryScrollEvent>>() { // from class: androidx.compose.ui.input.rotary.RotaryInputModifierKt$ModifierLocalRotaryScrollParent$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FocusAwareInputModifier<RotaryScrollEvent> invoke() {
            return null;
        }
    });

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getModifierLocalRotaryScrollParent$annotations() {
    }

    @ExperimentalComposeUiApi
    public static final Modifier onRotaryScrollEvent(Modifier $this$onRotaryScrollEvent, final Function1<? super RotaryScrollEvent, Boolean> onRotaryScrollEvent) {
        Intrinsics.checkNotNullParameter($this$onRotaryScrollEvent, "<this>");
        Intrinsics.checkNotNullParameter(onRotaryScrollEvent, "onRotaryScrollEvent");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.input.rotary.RotaryInputModifierKt$onRotaryScrollEvent$$inlined$debugInspectorInfo$1
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
                $this$null.setName("onRotaryScrollEvent");
                $this$null.getProperties().set("onRotaryScrollEvent", Function1.this);
            }
        } : InspectableValueKt.getNoInspectorInfo();
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier $this$inspectable$iv = InspectableValueKt.inspectableWrapper($this$onRotaryScrollEvent, inspectorInfo$iv, new FocusAwareInputModifier(focusAwareCallback(onRotaryScrollEvent), null, ModifierLocalRotaryScrollParent));
        return $this$inspectable$iv;
    }

    @ExperimentalComposeUiApi
    public static final Modifier onPreRotaryScrollEvent(Modifier $this$onPreRotaryScrollEvent, final Function1<? super RotaryScrollEvent, Boolean> onPreRotaryScrollEvent) {
        Intrinsics.checkNotNullParameter($this$onPreRotaryScrollEvent, "<this>");
        Intrinsics.checkNotNullParameter(onPreRotaryScrollEvent, "onPreRotaryScrollEvent");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.input.rotary.RotaryInputModifierKt$onPreRotaryScrollEvent$$inlined$debugInspectorInfo$1
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
                $this$null.setName("onPreRotaryScrollEvent");
                $this$null.getProperties().set("onPreRotaryScrollEvent", Function1.this);
            }
        } : InspectableValueKt.getNoInspectorInfo();
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier $this$inspectable$iv = InspectableValueKt.inspectableWrapper($this$onPreRotaryScrollEvent, inspectorInfo$iv, new FocusAwareInputModifier(null, focusAwareCallback(onPreRotaryScrollEvent), ModifierLocalRotaryScrollParent));
        return $this$inspectable$iv;
    }

    public static final ProvidableModifierLocal<FocusAwareInputModifier<RotaryScrollEvent>> getModifierLocalRotaryScrollParent() {
        return ModifierLocalRotaryScrollParent;
    }

    @ExperimentalComposeUiApi
    private static final Function1<FocusDirectedInputEvent, Boolean> focusAwareCallback(final Function1<? super RotaryScrollEvent, Boolean> function1) {
        return new Function1<FocusDirectedInputEvent, Boolean>() { // from class: androidx.compose.ui.input.rotary.RotaryInputModifierKt$focusAwareCallback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusDirectedInputEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                if (!(e instanceof RotaryScrollEvent)) {
                    throw new IllegalStateException("FocusAwareEvent is dispatched to the wrong FocusAwareParent.".toString());
                }
                return function1.invoke(e);
            }
        };
    }
}
