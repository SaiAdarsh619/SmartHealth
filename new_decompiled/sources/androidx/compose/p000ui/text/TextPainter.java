package androidx.compose.p000ui.text;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.geometry.RectKt;
import androidx.compose.p000ui.geometry.SizeKt;
import androidx.compose.p000ui.graphics.Brush;
import androidx.compose.p000ui.graphics.Canvas;
import androidx.compose.p000ui.text.style.TextOverflow;
import androidx.compose.p000ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextPainter.kt */
@Metadata(m286d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, m287d2 = {"Landroidx/compose/ui/text/TextPainter;", "", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "ui-text_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TextPainter {
    public static final int $stable = 0;
    public static final TextPainter INSTANCE = new TextPainter();

    private TextPainter() {
    }

    public final void paint(Canvas canvas, TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        boolean needClipping = textLayoutResult.getHasVisualOverflow() && !TextOverflow.m4295equalsimpl0(textLayoutResult.getLayoutInput().getOverflow(), TextOverflow.INSTANCE.m4304getVisiblegIe3tQ8());
        if (needClipping) {
            float width = IntSize.m4542getWidthimpl(textLayoutResult.getSize());
            float height = IntSize.m4541getHeightimpl(textLayoutResult.getSize());
            Rect bounds = RectKt.m1800Recttz77jQw(Offset.INSTANCE.m1776getZeroF1C5BW0(), SizeKt.Size(width, height));
            canvas.save();
            Canvas.m1969clipRectmtrdDE$default(canvas, bounds, 0, 2, null);
        }
        try {
            Brush brush = textLayoutResult.getLayoutInput().getStyle().getBrush();
            if (brush != null) {
                textLayoutResult.getMultiParagraph().paint(canvas, brush, textLayoutResult.getLayoutInput().getStyle().getAlpha(), textLayoutResult.getLayoutInput().getStyle().getShadow(), textLayoutResult.getLayoutInput().getStyle().getTextDecoration());
            } else {
                textLayoutResult.getMultiParagraph().m3865paintRPmYEkk(canvas, textLayoutResult.getLayoutInput().getStyle().m3975getColor0d7_KjU(), textLayoutResult.getLayoutInput().getStyle().getShadow(), textLayoutResult.getLayoutInput().getStyle().getTextDecoration());
            }
        } finally {
            if (needClipping) {
                canvas.restore();
            }
        }
    }
}
