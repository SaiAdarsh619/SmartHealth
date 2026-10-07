package androidx.compose.p000ui.text.platform.extensions;

import android.graphics.Typeface;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.Shadow;
import androidx.compose.p000ui.text.SpanStyle;
import androidx.compose.p000ui.text.font.FontFamily;
import androidx.compose.p000ui.text.font.FontStyle;
import androidx.compose.p000ui.text.font.FontSynthesis;
import androidx.compose.p000ui.text.font.FontWeight;
import androidx.compose.p000ui.text.intl.LocaleList;
import androidx.compose.p000ui.text.platform.AndroidTextPaint;
import androidx.compose.p000ui.text.style.BaselineShift;
import androidx.compose.p000ui.text.style.TextDecoration;
import androidx.compose.p000ui.text.style.TextGeometricTransform;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.TextUnit;
import androidx.compose.p000ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextPaintExtensions.android.kt */
@Metadata(m286d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001aG\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00042&\u0010\u0007\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000ø\u0001\u0000\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0004H\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m287d2 = {"correctBlurRadius", "", "blurRadius", "applySpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "style", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "density", "Landroidx/compose/ui/unit/Density;", "hasFontAttributes", "", "ui-text_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TextPaintExtensions_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SpanStyle applySpanStyle(AndroidTextPaint $this$applySpanStyle, SpanStyle style, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> resolveTypeface, Density density) {
        long m4574getUnspecifiedXSAIIZE;
        long background;
        BaselineShift baselineShift;
        BaselineShift baselineShift2;
        Intrinsics.checkNotNullParameter($this$applySpanStyle, "<this>");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(resolveTypeface, "resolveTypeface");
        Intrinsics.checkNotNullParameter(density, "density");
        long m4562getTypeUIouoOA = TextUnit.m4562getTypeUIouoOA(style.getFontSize());
        if (TextUnitType.m4591equalsimpl0(m4562getTypeUIouoOA, TextUnitType.INSTANCE.m4596getSpUIouoOA())) {
            $this$applySpanStyle.setTextSize(density.mo647toPxR2X_6o(style.getFontSize()));
        } else if (TextUnitType.m4591equalsimpl0(m4562getTypeUIouoOA, TextUnitType.INSTANCE.m4595getEmUIouoOA())) {
            $this$applySpanStyle.setTextSize($this$applySpanStyle.getTextSize() * TextUnit.m4563getValueimpl(style.getFontSize()));
        }
        if (hasFontAttributes(style)) {
            FontFamily fontFamily = style.getFontFamily();
            FontWeight fontWeight = style.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.INSTANCE.getNormal();
            }
            FontStyle fontStyle = style.getFontStyle();
            FontStyle m4037boximpl = FontStyle.m4037boximpl(fontStyle != null ? fontStyle.m4043unboximpl() : FontStyle.INSTANCE.m4045getNormal_LCdwA());
            FontSynthesis fontSynthesis = style.getFontSynthesis();
            $this$applySpanStyle.setTypeface(resolveTypeface.invoke(fontFamily, fontWeight, m4037boximpl, FontSynthesis.m4046boximpl(fontSynthesis != null ? fontSynthesis.getValue() : FontSynthesis.INSTANCE.m4055getAllGVVA2EU())));
        }
        if (style.getLocaleList() != null && !Intrinsics.areEqual(style.getLocaleList(), LocaleList.INSTANCE.getCurrent())) {
            LocaleListHelperMethods.INSTANCE.setTextLocales($this$applySpanStyle, style.getLocaleList());
        }
        long m4562getTypeUIouoOA2 = TextUnit.m4562getTypeUIouoOA(style.getLetterSpacing());
        if (TextUnitType.m4591equalsimpl0(m4562getTypeUIouoOA2, TextUnitType.INSTANCE.m4595getEmUIouoOA())) {
            $this$applySpanStyle.setLetterSpacing(TextUnit.m4563getValueimpl(style.getLetterSpacing()));
        } else {
            TextUnitType.m4591equalsimpl0(m4562getTypeUIouoOA2, TextUnitType.INSTANCE.m4596getSpUIouoOA());
        }
        if (style.getFontFeatureSettings() != null && !Intrinsics.areEqual(style.getFontFeatureSettings(), "")) {
            $this$applySpanStyle.setFontFeatureSettings(style.getFontFeatureSettings());
        }
        if (style.getTextGeometricTransform() != null && !Intrinsics.areEqual(style.getTextGeometricTransform(), TextGeometricTransform.INSTANCE.getNone$ui_text_release())) {
            $this$applySpanStyle.setTextScaleX($this$applySpanStyle.getTextScaleX() * style.getTextGeometricTransform().getScaleX());
            $this$applySpanStyle.setTextSkewX($this$applySpanStyle.getTextSkewX() + style.getTextGeometricTransform().getSkewX());
        }
        $this$applySpanStyle.m4157setColor8_81llA(style.m3920getColor0d7_KjU());
        $this$applySpanStyle.m4155setBrush12SF9DM(style.getBrush(), Size.INSTANCE.m1837getUnspecifiedNHjbRc(), style.getAlpha());
        $this$applySpanStyle.setShadow(style.getShadow());
        if (TextUnitType.m4591equalsimpl0(TextUnit.m4562getTypeUIouoOA(style.getLetterSpacing()), TextUnitType.INSTANCE.m4596getSpUIouoOA())) {
            if (!(TextUnit.m4563getValueimpl(style.getLetterSpacing()) == 0.0f)) {
                m4574getUnspecifiedXSAIIZE = style.getLetterSpacing();
                if (!Color.m1997equalsimpl0(style.getBackground(), Color.INSTANCE.m2031getTransparent0d7_KjU())) {
                    background = Color.INSTANCE.m2032getUnspecified0d7_KjU();
                } else {
                    background = style.getBackground();
                }
                baselineShift = style.getBaselineShift();
                if (!(baselineShift != null ? BaselineShift.m4180equalsimpl0(baselineShift.m4183unboximpl(), BaselineShift.INSTANCE.m4187getNoney9eOQZs()) : false)) {
                    baselineShift2 = null;
                } else {
                    baselineShift2 = style.getBaselineShift();
                }
                return new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, m4574getUnspecifiedXSAIIZE, baselineShift2, (TextGeometricTransform) null, (LocaleList) null, background, Intrinsics.areEqual(style.getTextDecoration(), TextDecoration.INSTANCE.getNone()) ? style.getTextDecoration() : null, (Shadow) null, 9855, (DefaultConstructorMarker) null);
            }
        }
        m4574getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m4574getUnspecifiedXSAIIZE();
        if (!Color.m1997equalsimpl0(style.getBackground(), Color.INSTANCE.m2031getTransparent0d7_KjU())) {
        }
        baselineShift = style.getBaselineShift();
        if (!(baselineShift != null ? BaselineShift.m4180equalsimpl0(baselineShift.m4183unboximpl(), BaselineShift.INSTANCE.m4187getNoney9eOQZs()) : false)) {
        }
        return new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, m4574getUnspecifiedXSAIIZE, baselineShift2, (TextGeometricTransform) null, (LocaleList) null, background, Intrinsics.areEqual(style.getTextDecoration(), TextDecoration.INSTANCE.getNone()) ? style.getTextDecoration() : null, (Shadow) null, 9855, (DefaultConstructorMarker) null);
    }

    public static final boolean hasFontAttributes(SpanStyle $this$hasFontAttributes) {
        Intrinsics.checkNotNullParameter($this$hasFontAttributes, "<this>");
        return ($this$hasFontAttributes.getFontFamily() == null && $this$hasFontAttributes.getFontStyle() == null && $this$hasFontAttributes.getFontWeight() == null) ? false : true;
    }

    public static final float correctBlurRadius(float blurRadius) {
        if (blurRadius == 0.0f) {
            return Float.MIN_VALUE;
        }
        return blurRadius;
    }
}
