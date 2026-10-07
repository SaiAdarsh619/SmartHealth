package androidx.compose.p000ui.draw;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.GraphicsLayerModifierKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Rotate.kt */
@Metadata(m286d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, m287d2 = {"rotate", "Landroidx/compose/ui/Modifier;", "degrees", "", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class RotateKt {
    public static final Modifier rotate(Modifier $this$rotate, float degrees) {
        Intrinsics.checkNotNullParameter($this$rotate, "<this>");
        return !((degrees > 0.0f ? 1 : (degrees == 0.0f ? 0 : -1)) == 0) ? GraphicsLayerModifierKt.m2133graphicsLayerpANQ8Wg$default($this$rotate, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, degrees, 0.0f, 0L, null, false, null, 0L, 0L, 65279, null) : $this$rotate;
    }
}
