package androidx.compose.p000ui.input.key;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.modifier.ModifierLocalKt;
import androidx.compose.p000ui.modifier.ProvidableModifierLocal;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyInputModifier.kt */
@Metadata(m286d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007ø\u0001\u0000\u001a!\u0010\n\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007ø\u0001\u0000\"\u001c\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, m287d2 = {"ModifierLocalKeyInput", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/ui/input/key/KeyInputModifier;", "getModifierLocalKeyInput", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "onKeyEvent", "Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "onPreviewKeyEvent", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class KeyInputModifierKt {
    private static final ProvidableModifierLocal<KeyInputModifier> ModifierLocalKeyInput = ModifierLocalKt.modifierLocalOf(new Function0<KeyInputModifier>() { // from class: androidx.compose.ui.input.key.KeyInputModifierKt$ModifierLocalKeyInput$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KeyInputModifier invoke() {
            return null;
        }
    });

    public static final Modifier onKeyEvent(Modifier $this$onKeyEvent, final Function1<? super KeyEvent, Boolean> onKeyEvent) {
        Intrinsics.checkNotNullParameter($this$onKeyEvent, "<this>");
        Intrinsics.checkNotNullParameter(onKeyEvent, "onKeyEvent");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.input.key.KeyInputModifierKt$onKeyEvent$$inlined$debugInspectorInfo$1
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
                $this$null.setName("onKeyEvent");
                $this$null.getProperties().set("onKeyEvent", Function1.this);
            }
        } : InspectableValueKt.getNoInspectorInfo();
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier $this$inspectable$iv = InspectableValueKt.inspectableWrapper($this$onKeyEvent, inspectorInfo$iv, new KeyInputModifier(onKeyEvent, null));
        return $this$inspectable$iv;
    }

    public static final Modifier onPreviewKeyEvent(Modifier $this$onPreviewKeyEvent, final Function1<? super KeyEvent, Boolean> onPreviewKeyEvent) {
        Intrinsics.checkNotNullParameter($this$onPreviewKeyEvent, "<this>");
        Intrinsics.checkNotNullParameter(onPreviewKeyEvent, "onPreviewKeyEvent");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.input.key.KeyInputModifierKt$onPreviewKeyEvent$$inlined$debugInspectorInfo$1
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
                $this$null.setName("onPreviewKeyEvent");
                $this$null.getProperties().set("onPreviewKeyEvent", Function1.this);
            }
        } : InspectableValueKt.getNoInspectorInfo();
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier $this$inspectable$iv = InspectableValueKt.inspectableWrapper($this$onPreviewKeyEvent, inspectorInfo$iv, new KeyInputModifier(null, onPreviewKeyEvent));
        return $this$inspectable$iv;
    }

    public static final ProvidableModifierLocal<KeyInputModifier> getModifierLocalKeyInput() {
        return ModifierLocalKeyInput;
    }
}
