package androidx.compose.p000ui.text.platform;

import android.graphics.Paint;
import android.text.TextPaint;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.graphics.AndroidPathEffect_androidKt;
import androidx.compose.p000ui.graphics.Brush;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.ColorKt;
import androidx.compose.p000ui.graphics.PathEffect;
import androidx.compose.p000ui.graphics.ShaderBrush;
import androidx.compose.p000ui.graphics.Shadow;
import androidx.compose.p000ui.graphics.SolidColor;
import androidx.compose.p000ui.graphics.drawscope.DrawStyle;
import androidx.compose.p000ui.graphics.drawscope.Fill;
import androidx.compose.p000ui.graphics.drawscope.Stroke;
import androidx.compose.p000ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.p000ui.text.style.TextDecoration;
import androidx.compose.p000ui.text.style.TextDrawStyleKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidTextPaint.android.kt */
@Metadata(m286d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J/\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u0005ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u001b\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010(\u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010)\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR&\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR/\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0081\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, m287d2 = {"Landroidx/compose/ui/text/platform/AndroidTextPaint;", "Landroid/text/TextPaint;", "flags", "", "density", "", "(IF)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush$ui_text_release$annotations", "()V", "getBrush$ui_text_release", "()Landroidx/compose/ui/graphics/Brush;", "setBrush$ui_text_release", "(Landroidx/compose/ui/graphics/Brush;)V", "brushSize", "Landroidx/compose/ui/geometry/Size;", "getBrushSize-VsRJwc0$ui_text_release$annotations", "getBrushSize-VsRJwc0$ui_text_release", "()Landroidx/compose/ui/geometry/Size;", "setBrushSize-iaC8Vc4$ui_text_release", "(Landroidx/compose/ui/geometry/Size;)V", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "setBrush", "", "size", "alpha", "setBrush-12SF9DM", "(Landroidx/compose/ui/graphics/Brush;JF)V", "setColor", "color", "Landroidx/compose/ui/graphics/Color;", "setColor-8_81llA", "(J)V", "setDrawStyle", "setShadow", "setTextDecoration", "ui-text_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AndroidTextPaint extends TextPaint {
    private Brush brush;
    private Size brushSize;
    private DrawStyle drawStyle;
    private Shadow shadow;
    private TextDecoration textDecoration;

    public static /* synthetic */ void getBrush$ui_text_release$annotations() {
    }

    /* renamed from: getBrushSize-VsRJwc0$ui_text_release$annotations, reason: not valid java name */
    public static /* synthetic */ void m4152getBrushSizeVsRJwc0$ui_text_release$annotations() {
    }

    public AndroidTextPaint(int flags, float density) {
        super(flags);
        this.density = density;
        this.textDecoration = TextDecoration.INSTANCE.getNone();
        this.shadow = Shadow.INSTANCE.getNone();
    }

    /* renamed from: getBrush$ui_text_release, reason: from getter */
    public final Brush getBrush() {
        return this.brush;
    }

    public final void setBrush$ui_text_release(Brush brush) {
        this.brush = brush;
    }

    /* renamed from: getBrushSize-VsRJwc0$ui_text_release, reason: not valid java name and from getter */
    public final Size getBrushSize() {
        return this.brushSize;
    }

    /* renamed from: setBrushSize-iaC8Vc4$ui_text_release, reason: not valid java name */
    public final void m4156setBrushSizeiaC8Vc4$ui_text_release(Size size) {
        this.brushSize = size;
    }

    public final void setTextDecoration(TextDecoration textDecoration) {
        if (textDecoration != null && !Intrinsics.areEqual(this.textDecoration, textDecoration)) {
            this.textDecoration = textDecoration;
            setUnderlineText(this.textDecoration.contains(TextDecoration.INSTANCE.getUnderline()));
            setStrikeThruText(this.textDecoration.contains(TextDecoration.INSTANCE.getLineThrough()));
        }
    }

    public final void setShadow(Shadow shadow) {
        if (shadow != null && !Intrinsics.areEqual(this.shadow, shadow)) {
            this.shadow = shadow;
            if (Intrinsics.areEqual(this.shadow, Shadow.INSTANCE.getNone())) {
                clearShadowLayer();
            } else {
                setShadowLayer(TextPaintExtensions_androidKt.correctBlurRadius(this.shadow.getBlurRadius()), Offset.m1760getXimpl(this.shadow.getOffset()), Offset.m1761getYimpl(this.shadow.getOffset()), ColorKt.m2051toArgb8_81llA(this.shadow.getColor()));
            }
        }
    }

    /* renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m4157setColor8_81llA(long color) {
        if (color != Color.INSTANCE.m2032getUnspecified0d7_KjU()) {
            int argbColor = ColorKt.m2051toArgb8_81llA(color);
            if (getColor() != argbColor) {
                setColor(argbColor);
            }
            setShader(null);
            this.brush = null;
            this.brushSize = null;
        }
    }

    /* renamed from: setBrush-12SF9DM$default, reason: not valid java name */
    public static /* synthetic */ void m4153setBrush12SF9DM$default(AndroidTextPaint androidTextPaint, Brush brush, long j, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            f = Float.NaN;
        }
        androidTextPaint.m4155setBrush12SF9DM(brush, j, f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
    
        if ((r0 == null ? false : androidx.compose.p000ui.geometry.Size.m1825equalsimpl0(r0.getPackedValue(), r8)) == false) goto L18;
     */
    /* renamed from: setBrush-12SF9DM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4155setBrush12SF9DM(Brush brush, long size, float alpha) {
        if (brush == null) {
            setShader(null);
            this.brush = null;
            this.brushSize = null;
        } else {
            if (brush instanceof SolidColor) {
                m4157setColor8_81llA(TextDrawStyleKt.m4286modulateDxMtmZc(((SolidColor) brush).getValue(), alpha));
                return;
            }
            if (brush instanceof ShaderBrush) {
                if (getShader() != null && Intrinsics.areEqual(this.brush, brush)) {
                    Size size2 = this.brushSize;
                }
                if (size != Size.INSTANCE.m1837getUnspecifiedNHjbRc()) {
                    this.brush = brush;
                    this.brushSize = Size.m1817boximpl(size);
                    setShader(((ShaderBrush) brush).mo1965createShaderuvyYCjk(size));
                }
                AndroidTextPaint_androidKt.setAlpha(this, alpha);
            }
        }
    }

    public final void setDrawStyle(DrawStyle drawStyle) {
        Paint.Join m4161toAndroidJoinWw9F2mQ;
        Paint.Cap m4160toAndroidCapBeK7IIE;
        if (drawStyle != null && !Intrinsics.areEqual(this.drawStyle, drawStyle)) {
            this.drawStyle = drawStyle;
            if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
                setStyle(Paint.Style.FILL);
                return;
            }
            if (drawStyle instanceof Stroke) {
                setStyle(Paint.Style.STROKE);
                setStrokeWidth(((Stroke) drawStyle).getWidth());
                setStrokeMiter(((Stroke) drawStyle).getMiter());
                m4161toAndroidJoinWw9F2mQ = AndroidTextPaint_androidKt.m4161toAndroidJoinWw9F2mQ(((Stroke) drawStyle).getJoin());
                setStrokeJoin(m4161toAndroidJoinWw9F2mQ);
                m4160toAndroidCapBeK7IIE = AndroidTextPaint_androidKt.m4160toAndroidCapBeK7IIE(((Stroke) drawStyle).getCap());
                setStrokeCap(m4160toAndroidCapBeK7IIE);
                PathEffect pathEffect = ((Stroke) drawStyle).getPathEffect();
                setPathEffect(pathEffect != null ? AndroidPathEffect_androidKt.asAndroidPathEffect(pathEffect) : null);
            }
        }
    }
}
