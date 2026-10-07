package androidx.compose.p000ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.p000ui.text.AnnotatedString;
import androidx.compose.p000ui.text.InternalTextApi;
import androidx.compose.p000ui.text.SpanStyle;
import androidx.compose.p000ui.text.TtsAnnotation;
import androidx.compose.p000ui.text.UrlAnnotation;
import androidx.compose.p000ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.p000ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.p000ui.text.font.Font;
import androidx.compose.p000ui.text.font.FontFamily;
import androidx.compose.p000ui.text.font.FontStyle;
import androidx.compose.p000ui.text.font.FontSynthesis;
import androidx.compose.p000ui.text.font.FontWeight;
import androidx.compose.p000ui.text.font.GenericFontFamily;
import androidx.compose.p000ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.p000ui.text.platform.extensions.TtsAnnotationExtensions_androidKt;
import androidx.compose.p000ui.text.platform.extensions.UrlAnnotationExtensions_androidKt;
import androidx.compose.p000ui.text.style.TextDecoration;
import androidx.compose.p000ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidAccessibilitySpannableString.android.kt */
@Metadata(m286d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001c\u0010\f\u001a\u00020\u0002*\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u001c\u0010\f\u001a\u00020\u0002*\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\u0010"}, m287d2 = {"setSpanStyle", "", "Landroid/text/SpannableString;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "start", "", "end", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "toAccessibilitySpannableString", "Landroidx/compose/ui/text/AnnotatedString;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "ui-text_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AndroidAccessibilitySpannableString_androidKt {
    @InternalTextApi
    public static final SpannableString toAccessibilitySpannableString(AnnotatedString $this$toAccessibilitySpannableString, Density density, Font.ResourceLoader resourceLoader) {
        Intrinsics.checkNotNullParameter($this$toAccessibilitySpannableString, "<this>");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resourceLoader, "resourceLoader");
        return toAccessibilitySpannableString($this$toAccessibilitySpannableString, density, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader));
    }

    @InternalTextApi
    public static final SpannableString toAccessibilitySpannableString(AnnotatedString $this$toAccessibilitySpannableString, Density density, FontFamily.Resolver fontFamilyResolver) {
        Intrinsics.checkNotNullParameter($this$toAccessibilitySpannableString, "<this>");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        SpannableString spannableString = new SpannableString($this$toAccessibilitySpannableString.getText());
        List $this$fastForEach$iv = $this$toAccessibilitySpannableString.getSpanStyles();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            AnnotatedString.Range<SpanStyle> range = (AnnotatedString.Range) item$iv;
            SpanStyle style = range.component1();
            int start = range.getStart();
            int end = range.getEnd();
            SpanStyle noFontStyle = SpanStyle.m3913copyIuqyXdg$default(style, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 16351, null);
            setSpanStyle(spannableString, noFontStyle, start, end, density, fontFamilyResolver);
        }
        List $this$fastForEach$iv2 = $this$toAccessibilitySpannableString.getTtsAnnotations(0, $this$toAccessibilitySpannableString.length());
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
            AnnotatedString.Range<TtsAnnotation> range2 = (AnnotatedString.Range) item$iv2;
            TtsAnnotation ttsAnnotation = range2.component1();
            int start2 = range2.getStart();
            int end2 = range2.getEnd();
            spannableString.setSpan(TtsAnnotationExtensions_androidKt.toSpan(ttsAnnotation), start2, end2, 33);
        }
        List $this$fastForEach$iv3 = $this$toAccessibilitySpannableString.getUrlAnnotations(0, $this$toAccessibilitySpannableString.length());
        int size3 = $this$fastForEach$iv3.size();
        for (int index$iv3 = 0; index$iv3 < size3; index$iv3++) {
            Object item$iv3 = $this$fastForEach$iv3.get(index$iv3);
            AnnotatedString.Range<UrlAnnotation> range3 = (AnnotatedString.Range) item$iv3;
            UrlAnnotation urlAnnotation = range3.component1();
            int start3 = range3.getStart();
            int end3 = range3.getEnd();
            spannableString.setSpan(UrlAnnotationExtensions_androidKt.toSpan(urlAnnotation), start3, end3, 33);
        }
        return spannableString;
    }

    private static final void setSpanStyle(SpannableString $this$setSpanStyle, SpanStyle spanStyle, int start, int end, Density density, FontFamily.Resolver fontFamilyResolver) {
        SpannableExtensions_androidKt.m4171setColorRPmYEkk($this$setSpanStyle, spanStyle.m3920getColor0d7_KjU(), start, end);
        SpannableExtensions_androidKt.m4172setFontSizeKmRG4DE($this$setSpanStyle, spanStyle.getFontSize(), density, start, end);
        if (spanStyle.getFontWeight() != null || spanStyle.getFontStyle() != null) {
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.INSTANCE.getNormal();
            }
            FontStyle fontStyle = spanStyle.getFontStyle();
            int fontStyle2 = fontStyle != null ? fontStyle.m4043unboximpl() : FontStyle.INSTANCE.m4045getNormal_LCdwA();
            $this$setSpanStyle.setSpan(new StyleSpan(AndroidFontUtils_androidKt.m3995getAndroidTypefaceStyleFO1MlWM(fontWeight, fontStyle2)), start, end, 33);
        }
        if (spanStyle.getFontFamily() != null) {
            if (spanStyle.getFontFamily() instanceof GenericFontFamily) {
                $this$setSpanStyle.setSpan(new TypefaceSpan(((GenericFontFamily) spanStyle.getFontFamily()).getName()), start, end, 33);
            } else if (Build.VERSION.SDK_INT >= 28) {
                FontFamily fontFamily = spanStyle.getFontFamily();
                FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
                Object value = FontFamily.Resolver.m4016resolveDPcqOEQ$default(fontFamilyResolver, fontFamily, null, 0, fontSynthesis != null ? fontSynthesis.getValue() : FontSynthesis.INSTANCE.m4055getAllGVVA2EU(), 6, null).getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.graphics.Typeface");
                Typeface typeface = (Typeface) value;
                $this$setSpanStyle.setSpan(Api28Impl.INSTANCE.createTypefaceSpan(typeface), start, end, 33);
            }
        }
        if (spanStyle.getTextDecoration() != null) {
            if (spanStyle.getTextDecoration().contains(TextDecoration.INSTANCE.getUnderline())) {
                $this$setSpanStyle.setSpan(new UnderlineSpan(), start, end, 33);
            }
            if (spanStyle.getTextDecoration().contains(TextDecoration.INSTANCE.getLineThrough())) {
                $this$setSpanStyle.setSpan(new StrikethroughSpan(), start, end, 33);
            }
        }
        if (spanStyle.getTextGeometricTransform() != null) {
            $this$setSpanStyle.setSpan(new ScaleXSpan(spanStyle.getTextGeometricTransform().getScaleX()), start, end, 33);
        }
        SpannableExtensions_androidKt.setLocaleList($this$setSpanStyle, spanStyle.getLocaleList(), start, end);
        SpannableExtensions_androidKt.m4169setBackgroundRPmYEkk($this$setSpanStyle, spanStyle.getBackground(), start, end);
    }
}
