package androidx.compose.p000ui.text.platform;

import android.graphics.Matrix;
import android.graphics.Shader;
import androidx.compose.p000ui.geometry.SizeKt;
import androidx.compose.p000ui.graphics.Brush;
import androidx.compose.p000ui.graphics.BrushKt;
import androidx.compose.p000ui.graphics.Canvas;
import androidx.compose.p000ui.graphics.ShaderBrush;
import androidx.compose.p000ui.graphics.Shadow;
import androidx.compose.p000ui.graphics.SolidColor;
import androidx.compose.p000ui.text.MultiParagraph;
import androidx.compose.p000ui.text.Paragraph;
import androidx.compose.p000ui.text.ParagraphInfo;
import androidx.compose.p000ui.text.style.TextDecoration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidMultiParagraphDraw.kt */
@Metadata(m286d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000\u001a8\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¨\u0006\u000e"}, m287d2 = {"drawMultiParagraph", "", "Landroidx/compose/ui/text/MultiParagraph;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "decoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawParagraphs", "ui-text_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AndroidMultiParagraphDrawKt {
    public static final void drawMultiParagraph(MultiParagraph $this$drawMultiParagraph, Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration decoration) {
        Intrinsics.checkNotNullParameter($this$drawMultiParagraph, "<this>");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(brush, "brush");
        canvas.save();
        if ($this$drawMultiParagraph.getParagraphInfoList$ui_text_release().size() <= 1) {
            drawParagraphs($this$drawMultiParagraph, canvas, brush, alpha, shadow, decoration);
        } else if (brush instanceof SolidColor) {
            drawParagraphs($this$drawMultiParagraph, canvas, brush, alpha, shadow, decoration);
        } else if (brush instanceof ShaderBrush) {
            List $this$fastForEach$iv = $this$drawMultiParagraph.getParagraphInfoList$ui_text_release();
            int size = $this$fastForEach$iv.size();
            float height = 0.0f;
            float width = 0.0f;
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                ParagraphInfo it = (ParagraphInfo) item$iv;
                height += it.getParagraph().getHeight();
                width = Math.max(width, it.getParagraph().getWidth());
            }
            Shader shader = ((ShaderBrush) brush).mo1965createShaderuvyYCjk(SizeKt.Size(width, height));
            Matrix matrix = new Matrix();
            shader.getLocalMatrix(matrix);
            List $this$fastForEach$iv2 = $this$drawMultiParagraph.getParagraphInfoList$ui_text_release();
            int index$iv2 = 0;
            for (int size2 = $this$fastForEach$iv2.size(); index$iv2 < size2; size2 = size2) {
                Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
                ParagraphInfo it2 = (ParagraphInfo) item$iv2;
                Paragraph.paint$default(it2.getParagraph(), canvas, BrushKt.ShaderBrush(shader), alpha, shadow, decoration, null, 32, null);
                canvas.translate(0.0f, it2.getParagraph().getHeight());
                matrix.setTranslate(0.0f, -it2.getParagraph().getHeight());
                shader.setLocalMatrix(matrix);
                index$iv2++;
                $this$fastForEach$iv2 = $this$fastForEach$iv2;
            }
        }
        canvas.restore();
    }

    private static final void drawParagraphs(MultiParagraph $this$drawParagraphs, Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration decoration) {
        List $this$fastForEach$iv = $this$drawParagraphs.getParagraphInfoList$ui_text_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            ParagraphInfo it = (ParagraphInfo) item$iv;
            Paragraph.paint$default(it.getParagraph(), canvas, brush, alpha, shadow, decoration, null, 32, null);
            canvas.translate(0.0f, it.getParagraph().getHeight());
        }
    }
}
