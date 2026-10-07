package androidx.compose.foundation;

import androidx.compose.p000ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Overscroll.kt */
@Metadata(m286d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, m287d2 = {"overscroll", "Landroidx/compose/ui/Modifier;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class OverscrollKt {
    @ExperimentalFoundationApi
    public static final Modifier overscroll(Modifier $this$overscroll, OverscrollEffect overscrollEffect) {
        Intrinsics.checkNotNullParameter($this$overscroll, "<this>");
        Intrinsics.checkNotNullParameter(overscrollEffect, "overscrollEffect");
        return $this$overscroll.then(overscrollEffect.getEffectModifier());
    }
}
