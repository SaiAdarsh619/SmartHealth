package androidx.compose.p000ui.text;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.graphics.Brush;
import androidx.compose.p000ui.graphics.Canvas;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.Shadow;
import androidx.compose.p000ui.graphics.drawscope.DrawContext;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.graphics.drawscope.DrawTransform;
import androidx.compose.p000ui.text.AnnotatedString;
import androidx.compose.p000ui.text.style.TextDecoration;
import androidx.compose.p000ui.text.style.TextDrawStyleKt;
import androidx.compose.p000ui.text.style.TextOverflow;
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.compose.p000ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextPainter.kt */
@Metadata(m286d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001aU\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001aW\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a{\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u0014\b\u0002\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0$2\b\b\u0002\u0010'\u001a\u00020(H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u001ae\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020+2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010'\u001a\u00020(H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006."}, m287d2 = {"clip", "", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "drawText", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "brush", "Landroidx/compose/ui/graphics/Brush;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "alpha", "", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawText-712uMfE", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Brush;JFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawText-xIhfjkU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;JJFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "maxSize", "Landroidx/compose/ui/unit/IntSize;", "drawText-i2ZdXms", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextStyle;IZILjava/util/List;J)V", "", "drawText-O6gbksU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Ljava/lang/String;JLandroidx/compose/ui/text/TextStyle;IZIJ)V", "ui-text_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TextPainterKt {
    @ExperimentalTextApi
    /* renamed from: drawText-i2ZdXms, reason: not valid java name */
    public static final void m3941drawTexti2ZdXms(DrawScope drawText, TextMeasurer textMeasurer, AnnotatedString text, long topLeft, TextStyle style, int overflow, boolean softWrap, int maxLines, List<AnnotatedString.Range<Placeholder>> placeholders, long maxSize) {
        TextLayoutResult textLayoutResult;
        Intrinsics.checkNotNullParameter(drawText, "$this$drawText");
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        textLayoutResult = textMeasurer.m3936measurexDpz5zY(text, (r26 & 2) != 0 ? TextStyle.INSTANCE.getDefault() : style, (r26 & 4) != 0 ? TextOverflow.INSTANCE.m4302getClipgIe3tQ8() : overflow, (r26 & 8) != 0 ? true : softWrap, (r26 & 16) != 0 ? Integer.MAX_VALUE : maxLines, (r26 & 32) != 0 ? CollectionsKt.emptyList() : placeholders, (r26 & 64) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null) : ConstraintsKt.Constraints$default(0, IntSize.m4542getWidthimpl(maxSize), 0, IntSize.m4541getHeightimpl(maxSize), 5, null), (r26 & 128) != 0 ? textMeasurer.fallbackLayoutDirection : drawText.getLayoutDirection(), (r26 & 256) != 0 ? textMeasurer.fallbackDensity : drawText, (r26 & 512) != 0 ? textMeasurer.fallbackFontFamilyResolver : null, (r26 & 1024) != 0 ? false : false);
        DrawContext $this$withTransform_u24lambda_u2d6$iv = drawText.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u2d6$iv.mo2415getSizeNHjbRc();
        $this$withTransform_u24lambda_u2d6$iv.getCanvas().save();
        DrawTransform $this$drawText_i2ZdXms_u24lambda_u2d0 = $this$withTransform_u24lambda_u2d6$iv.getTransform();
        $this$drawText_i2ZdXms_u24lambda_u2d0.translate(Offset.m1760getXimpl(topLeft), Offset.m1761getYimpl(topLeft));
        clip($this$drawText_i2ZdXms_u24lambda_u2d0, textLayoutResult);
        textLayoutResult.getMultiParagraph().m3865paintRPmYEkk(drawText.getDrawContext().getCanvas(), (r12 & 2) != 0 ? Color.INSTANCE.m2032getUnspecified0d7_KjU() : 0L, (r12 & 4) != 0 ? null : null, (r12 & 8) != 0 ? null : null);
        $this$withTransform_u24lambda_u2d6$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u2d6$iv.mo2416setSizeuvyYCjk(previousSize$iv);
    }

    @ExperimentalTextApi
    /* renamed from: drawText-O6gbksU, reason: not valid java name */
    public static final void m3939drawTextO6gbksU(DrawScope drawText, TextMeasurer textMeasurer, String text, long topLeft, TextStyle style, int overflow, boolean softWrap, int maxLines, long maxSize) {
        TextLayoutResult textLayoutResult;
        Intrinsics.checkNotNullParameter(drawText, "$this$drawText");
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        textLayoutResult = textMeasurer.m3936measurexDpz5zY(new AnnotatedString(text, null, null, 6, null), (r26 & 2) != 0 ? TextStyle.INSTANCE.getDefault() : style, (r26 & 4) != 0 ? TextOverflow.INSTANCE.m4302getClipgIe3tQ8() : overflow, (r26 & 8) != 0 ? true : softWrap, (r26 & 16) != 0 ? Integer.MAX_VALUE : maxLines, (r26 & 32) != 0 ? CollectionsKt.emptyList() : null, (r26 & 64) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null) : ConstraintsKt.Constraints$default(0, IntSize.m4542getWidthimpl(maxSize), 0, IntSize.m4541getHeightimpl(maxSize), 5, null), (r26 & 128) != 0 ? textMeasurer.fallbackLayoutDirection : drawText.getLayoutDirection(), (r26 & 256) != 0 ? textMeasurer.fallbackDensity : drawText, (r26 & 512) != 0 ? textMeasurer.fallbackFontFamilyResolver : null, (r26 & 1024) != 0 ? false : false);
        DrawContext $this$withTransform_u24lambda_u2d6$iv = drawText.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u2d6$iv.mo2415getSizeNHjbRc();
        $this$withTransform_u24lambda_u2d6$iv.getCanvas().save();
        DrawTransform $this$drawText_O6gbksU_u24lambda_u2d2 = $this$withTransform_u24lambda_u2d6$iv.getTransform();
        $this$drawText_O6gbksU_u24lambda_u2d2.translate(Offset.m1760getXimpl(topLeft), Offset.m1761getYimpl(topLeft));
        clip($this$drawText_O6gbksU_u24lambda_u2d2, textLayoutResult);
        textLayoutResult.getMultiParagraph().m3865paintRPmYEkk(drawText.getDrawContext().getCanvas(), (r12 & 2) != 0 ? Color.INSTANCE.m2032getUnspecified0d7_KjU() : 0L, (r12 & 4) != 0 ? null : null, (r12 & 8) != 0 ? null : null);
        $this$withTransform_u24lambda_u2d6$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u2d6$iv.mo2416setSizeuvyYCjk(previousSize$iv);
    }

    @ExperimentalTextApi
    /* renamed from: drawText-xIhfjkU, reason: not valid java name */
    public static final void m3943drawTextxIhfjkU(DrawScope drawText, TextLayoutResult textLayoutResult, long color, long topLeft, float alpha, Shadow shadow, TextDecoration textDecoration) {
        Intrinsics.checkNotNullParameter(drawText, "$this$drawText");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Shadow newShadow = shadow == null ? textLayoutResult.getLayoutInput().getStyle().getShadow() : shadow;
        TextDecoration newTextDecoration = textDecoration == null ? textLayoutResult.getLayoutInput().getStyle().getTextDecoration() : textDecoration;
        DrawContext $this$withTransform_u24lambda_u2d6$iv = drawText.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u2d6$iv.mo2415getSizeNHjbRc();
        $this$withTransform_u24lambda_u2d6$iv.getCanvas().save();
        DrawTransform $this$drawText_xIhfjkU_u24lambda_u2d4 = $this$withTransform_u24lambda_u2d6$iv.getTransform();
        $this$drawText_xIhfjkU_u24lambda_u2d4.translate(Offset.m1760getXimpl(topLeft), Offset.m1761getYimpl(topLeft));
        clip($this$drawText_xIhfjkU_u24lambda_u2d4, textLayoutResult);
        Brush brush = textLayoutResult.getLayoutInput().getStyle().getBrush();
        if (brush != null) {
            if (color == Color.INSTANCE.m2032getUnspecified0d7_KjU()) {
                textLayoutResult.getMultiParagraph().paint(drawText.getDrawContext().getCanvas(), brush, !Float.isNaN(alpha) ? alpha : textLayoutResult.getLayoutInput().getStyle().getAlpha(), newShadow, newTextDecoration);
                $this$withTransform_u24lambda_u2d6$iv.getCanvas().restore();
                $this$withTransform_u24lambda_u2d6$iv.mo2416setSizeuvyYCjk(previousSize$iv);
            }
        }
        MultiParagraph multiParagraph = textLayoutResult.getMultiParagraph();
        Canvas canvas = drawText.getDrawContext().getCanvas();
        long $this$takeOrElse_u2dDxMtmZc$iv = color;
        if (!($this$takeOrElse_u2dDxMtmZc$iv != Color.INSTANCE.m2032getUnspecified0d7_KjU())) {
            $this$takeOrElse_u2dDxMtmZc$iv = textLayoutResult.getLayoutInput().getStyle().m3975getColor0d7_KjU();
        }
        multiParagraph.m3865paintRPmYEkk(canvas, TextDrawStyleKt.m4286modulateDxMtmZc($this$takeOrElse_u2dDxMtmZc$iv, alpha), newShadow, newTextDecoration);
        $this$withTransform_u24lambda_u2d6$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u2d6$iv.mo2416setSizeuvyYCjk(previousSize$iv);
    }

    @ExperimentalTextApi
    /* renamed from: drawText-712uMfE, reason: not valid java name */
    public static final void m3937drawText712uMfE(DrawScope drawText, TextLayoutResult textLayoutResult, Brush brush, long topLeft, float alpha, Shadow shadow, TextDecoration textDecoration) {
        Intrinsics.checkNotNullParameter(drawText, "$this$drawText");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Shadow newShadow = shadow == null ? textLayoutResult.getLayoutInput().getStyle().getShadow() : shadow;
        TextDecoration newTextDecoration = textDecoration == null ? textLayoutResult.getLayoutInput().getStyle().getTextDecoration() : textDecoration;
        DrawContext $this$withTransform_u24lambda_u2d6$iv = drawText.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u2d6$iv.mo2415getSizeNHjbRc();
        $this$withTransform_u24lambda_u2d6$iv.getCanvas().save();
        DrawTransform $this$drawText_712uMfE_u24lambda_u2d7 = $this$withTransform_u24lambda_u2d6$iv.getTransform();
        $this$drawText_712uMfE_u24lambda_u2d7.translate(Offset.m1760getXimpl(topLeft), Offset.m1761getYimpl(topLeft));
        clip($this$drawText_712uMfE_u24lambda_u2d7, textLayoutResult);
        textLayoutResult.getMultiParagraph().paint(drawText.getDrawContext().getCanvas(), brush, !Float.isNaN(alpha) ? alpha : textLayoutResult.getLayoutInput().getStyle().getAlpha(), newShadow, newTextDecoration);
        $this$withTransform_u24lambda_u2d6$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u2d6$iv.mo2416setSizeuvyYCjk(previousSize$iv);
    }

    private static final void clip(DrawTransform $this$clip, TextLayoutResult textLayoutResult) {
        if (textLayoutResult.getHasVisualOverflow() && !TextOverflow.m4295equalsimpl0(textLayoutResult.getLayoutInput().getOverflow(), TextOverflow.INSTANCE.m4304getVisiblegIe3tQ8())) {
            DrawTransform.m2541clipRectN_I0leg$default($this$clip, 0.0f, 0.0f, IntSize.m4542getWidthimpl(textLayoutResult.getSize()), IntSize.m4541getHeightimpl(textLayoutResult.getSize()), 0, 16, null);
        }
    }
}
