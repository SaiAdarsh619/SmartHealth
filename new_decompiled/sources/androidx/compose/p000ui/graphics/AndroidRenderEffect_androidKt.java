package androidx.compose.p000ui.graphics;

import android.graphics.RenderEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidRenderEffect.android.kt */
@Metadata(m286d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m287d2 = {"asComposeRenderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "Landroid/graphics/RenderEffect;", "ui-graphics_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AndroidRenderEffect_androidKt {
    public static final RenderEffect asComposeRenderEffect(RenderEffect $this$asComposeRenderEffect) {
        Intrinsics.checkNotNullParameter($this$asComposeRenderEffect, "<this>");
        return new AndroidRenderEffect($this$asComposeRenderEffect);
    }
}
