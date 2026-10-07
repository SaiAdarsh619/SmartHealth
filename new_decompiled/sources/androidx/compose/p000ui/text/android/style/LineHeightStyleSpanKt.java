package androidx.compose.p000ui.text.android.style;

import android.graphics.Paint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LineHeightStyleSpan.kt */
@Metadata(m286d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, m287d2 = {"lineHeight", "", "Landroid/graphics/Paint$FontMetricsInt;", "ui-text_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LineHeightStyleSpanKt {
    public static final int lineHeight(Paint.FontMetricsInt $this$lineHeight) {
        Intrinsics.checkNotNullParameter($this$lineHeight, "<this>");
        return $this$lineHeight.descent - $this$lineHeight.ascent;
    }
}
