package androidx.compose.p000ui.layout;

import androidx.compose.p000ui.ExperimentalComposeUiApi;
import androidx.compose.p000ui.Modifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RelocationRequesterModifier.kt */
@Metadata(m286d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0007¨\u0006\u0003"}, m287d2 = {"relocationRequester", "Landroidx/compose/ui/Modifier;", "", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class RelocationRequesterModifierKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Please use bringIntoViewRequester instead.", replaceWith = @ReplaceWith(expression = "bringIntoViewRequester", imports = {"androidx.compose.foundation.relocation.bringIntoViewRequester"}))
    @ExperimentalComposeUiApi
    public static final Modifier relocationRequester(Modifier $this$relocationRequester, Object relocationRequester) {
        Intrinsics.checkNotNullParameter($this$relocationRequester, "<this>");
        Intrinsics.checkNotNullParameter(relocationRequester, "relocationRequester");
        return $this$relocationRequester;
    }
}
