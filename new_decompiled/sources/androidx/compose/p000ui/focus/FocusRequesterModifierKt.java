package androidx.compose.p000ui.focus;

import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.modifier.ModifierLocalKt;
import androidx.compose.p000ui.modifier.ProvidableModifierLocal;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusRequesterModifier.kt */
@Metadata(m286d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0007\"\u001c\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, m287d2 = {"ModifierLocalFocusRequester", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/ui/focus/FocusRequesterModifierLocal;", "getModifierLocalFocusRequester", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "focusRequester", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/focus/FocusRequester;", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class FocusRequesterModifierKt {
    private static final ProvidableModifierLocal<FocusRequesterModifierLocal> ModifierLocalFocusRequester = ModifierLocalKt.modifierLocalOf(new Function0<FocusRequesterModifierLocal>() { // from class: androidx.compose.ui.focus.FocusRequesterModifierKt$ModifierLocalFocusRequester$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FocusRequesterModifierLocal invoke() {
            return null;
        }
    });

    public static final ProvidableModifierLocal<FocusRequesterModifierLocal> getModifierLocalFocusRequester() {
        return ModifierLocalFocusRequester;
    }

    public static final Modifier focusRequester(Modifier $this$focusRequester, final FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter($this$focusRequester, "<this>");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        return ComposedModifierKt.composed($this$focusRequester, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.focus.FocusRequesterModifierKt$focusRequester$$inlined$debugInspectorInfo$1
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
                $this$null.setName("focusRequester");
                $this$null.getProperties().set("focusRequester", FocusRequester.this);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.ui.focus.FocusRequesterModifierKt$focusRequester$2
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Object value$iv$iv;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(-307396750);
                ComposerKt.sourceInformation($composer, "C135@4947L92:FocusRequesterModifier.kt#b42af3");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-307396750, $changed, -1, "androidx.compose.ui.focus.focusRequester.<anonymous> (FocusRequesterModifier.kt:134)");
                }
                Object key1$iv = FocusRequester.this;
                FocusRequester focusRequester2 = FocusRequester.this;
                int i = MutableVector.$stable;
                $composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer.changed(key1$iv);
                Object it$iv$iv = $composer.rememberedValue();
                if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = new FocusRequesterModifierLocal(focusRequester2);
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                FocusRequesterModifierLocal focusRequesterModifierLocal = (FocusRequesterModifierLocal) value$iv$iv;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return focusRequesterModifierLocal;
            }
        });
    }
}
