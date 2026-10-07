package androidx.compose.foundation.text.selection;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: SelectionMagnifier.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, m287d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class SelectionMagnifierKt$animatedSelectionMagnifier$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Function0<Offset> $magnifierCenter;
    final /* synthetic */ Function1<Function0<Offset>, Modifier> $platformMagnifier;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SelectionMagnifierKt$animatedSelectionMagnifier$1(Function0<Offset> function0, Function1<? super Function0<Offset>, ? extends Modifier> function1) {
        super(3);
        this.$magnifierCenter = function0;
        this.$platformMagnifier = function1;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0, reason: not valid java name */
    public static final long m1154invoke$lambda0(State<Offset> state) {
        Object thisObj$iv = state.getValue();
        return ((Offset) thisObj$iv).getPackedValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
        final State animatedCenter$delegate;
        Function0<Offset> function0;
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        $composer.startReplaceableGroup(759876635);
        ComposerKt.sourceInformation($composer, "C67@2573L70,68@2682L18:SelectionMagnifier.kt#eksfi3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(759876635, $changed, -1, "androidx.compose.foundation.text.selection.animatedSelectionMagnifier.<anonymous> (SelectionMagnifier.kt:66)");
        }
        animatedCenter$delegate = SelectionMagnifierKt.rememberAnimatedMagnifierPosition(this.$magnifierCenter, $composer, 0);
        Function1<Function0<Offset>, Modifier> function1 = this.$platformMagnifier;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(animatedCenter$delegate);
        Object rememberedValue = $composer.rememberedValue();
        if (invalid$iv$iv || rememberedValue == Composer.INSTANCE.getEmpty()) {
            function0 = new Function0<Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionMagnifierKt$animatedSelectionMagnifier$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Offset invoke() {
                    return Offset.m1749boximpl(m1155invokeF1C5BW0());
                }

                /* renamed from: invoke-F1C5BW0, reason: not valid java name */
                public final long m1155invokeF1C5BW0() {
                    long m1154invoke$lambda0;
                    m1154invoke$lambda0 = SelectionMagnifierKt$animatedSelectionMagnifier$1.m1154invoke$lambda0(animatedCenter$delegate);
                    return m1154invoke$lambda0;
                }
            };
            $composer.updateRememberedValue(function0);
        } else {
            function0 = rememberedValue;
        }
        $composer.endReplaceableGroup();
        Modifier invoke = function1.invoke(function0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return invoke;
    }
}
