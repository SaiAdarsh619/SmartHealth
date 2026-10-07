package androidx.compose.p000ui.text.platform.extensions;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.graphics.Brush;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.ColorKt;
import androidx.compose.p000ui.graphics.ShaderBrush;
import androidx.compose.p000ui.graphics.Shadow;
import androidx.compose.p000ui.graphics.SolidColor;
import androidx.compose.p000ui.text.AnnotatedString;
import androidx.compose.p000ui.text.AnnotatedStringKt;
import androidx.compose.p000ui.text.SpanStyle;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.android.style.BaselineShiftSpan;
import androidx.compose.p000ui.text.android.style.FontFeatureSpan;
import androidx.compose.p000ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.p000ui.text.android.style.LetterSpacingSpanPx;
import androidx.compose.p000ui.text.android.style.LineHeightSpan;
import androidx.compose.p000ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.p000ui.text.android.style.ShadowSpan;
import androidx.compose.p000ui.text.android.style.SkewXSpan;
import androidx.compose.p000ui.text.android.style.TextDecorationSpan;
import androidx.compose.p000ui.text.android.style.TypefaceSpan;
import androidx.compose.p000ui.text.font.FontFamily;
import androidx.compose.p000ui.text.font.FontStyle;
import androidx.compose.p000ui.text.font.FontSynthesis;
import androidx.compose.p000ui.text.font.FontWeight;
import androidx.compose.p000ui.text.intl.LocaleList;
import androidx.compose.p000ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.p000ui.text.style.BaselineShift;
import androidx.compose.p000ui.text.style.LineHeightStyle;
import androidx.compose.p000ui.text.style.TextDecoration;
import androidx.compose.p000ui.text.style.TextGeometricTransform;
import androidx.compose.p000ui.text.style.TextIndent;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.TextUnit;
import androidx.compose.p000ui.unit.TextUnitKt;
import androidx.compose.p000ui.unit.TextUnitType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* compiled from: SpannableExtensions.android.kt */
@Metadata(m286d1 = {"\u0000Ò\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001aF\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e0\r2\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0\u0010H\u0000\u001a-\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0002\u001a\u0016\u0010\u001b\u001a\u00020\u000b*\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002\u001a1\u0010\u001d\u001a\u00020\t*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$\u001a1\u0010%\u001a\u00020\t*\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b(\u001a.\u0010)\u001a\u00020\t*\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002\u001a1\u0010-\u001a\u00020\t*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010$\u001aS\u0010/\u001a\u00020\t*\u00020\u001e2\u0006\u00100\u001a\u00020\u001a2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e0\r2&\u00101\u001a\"\u0012\u0006\u0012\u0004\u0018\u000103\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020702H\u0002ø\u0001\u0001\u001a&\u00108\u001a\u00020\t*\u00020\u001e2\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002\u001a9\u0010;\u001a\u00020\t*\u00020\u001e2\u0006\u0010<\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b=\u0010>\u001a&\u0010?\u001a\u00020\t*\u00020\u001e2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002\u001a1\u0010B\u001a\u00020\t*\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010D\u001a9\u0010B\u001a\u00020\t*\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010E\u001a\u00020FH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010H\u001a&\u0010I\u001a\u00020\t*\u00020\u001e2\b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0000\u001a&\u0010L\u001a\u00020\t*\u00020\u001e2\b\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002\u001a$\u0010O\u001a\u00020\t*\u00020\u001e2\u0006\u0010P\u001a\u00020Q2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0000\u001a:\u0010R\u001a\u00020\t*\u00020\u001e2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010T\u001a\u0012\u0012\u0004\u0012\u00020V0Uj\b\u0012\u0004\u0012\u00020V`WH\u0002\u001a[\u0010X\u001a\u00020\t*\u00020\u001e2\u0006\u00100\u001a\u00020\u001a2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e0\r2\u0006\u0010\u0004\u001a\u00020\u00052&\u00101\u001a\"\u0012\u0006\u0012\u0004\u0018\u000103\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020702H\u0000ø\u0001\u0001\u001a&\u0010Y\u001a\u00020\t*\u00020\u001e2\b\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0000\u001a&\u0010\\\u001a\u00020\t*\u00020\u001e2\b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006_"}, m287d2 = {"createLetterSpacingSpan", "Landroid/text/style/MetricAffectingSpan;", "letterSpacing", "Landroidx/compose/ui/unit/TextUnit;", "density", "Landroidx/compose/ui/unit/Density;", "createLetterSpacingSpan-eAf_CNQ", "(JLandroidx/compose/ui/unit/Density;)Landroid/text/style/MetricAffectingSpan;", "flattenFontStylesAndApply", "", "contextFontSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "block", "Lkotlin/Function3;", "", "resolveLineHeightInPx", "", "lineHeight", "contextFontSize", "resolveLineHeightInPx-o2QH7mI", "(JFLandroidx/compose/ui/unit/Density;)F", "hasFontAttributes", "", "Landroidx/compose/ui/text/TextStyle;", "merge", "spanStyle", "setBackground", "Landroid/text/Spannable;", "color", "Landroidx/compose/ui/graphics/Color;", "start", "end", "setBackground-RPmYEkk", "(Landroid/text/Spannable;JII)V", "setBaselineShift", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "setBaselineShift-0ocSgnM", "setBrush", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "setColor", "setColor-RPmYEkk", "setFontAttributes", "contextTextStyle", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "setFontFeatureSettings", "fontFeatureSettings", "", "setFontSize", "fontSize", "setFontSize-KmRG4DE", "(Landroid/text/Spannable;JLandroidx/compose/ui/unit/Density;II)V", "setGeometricTransform", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "setLineHeight", "setLineHeight-r9BaKPg", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;)V", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "setLineHeight-KmRG4DE", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/style/LineHeightStyle;)V", "setLocaleList", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "setShadow", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "setSpan", "span", "", "setSpanStyle", "spanStyleRange", "lowPrioritySpans", "Ljava/util/ArrayList;", "Landroidx/compose/ui/text/platform/extensions/SpanRange;", "Lkotlin/collections/ArrayList;", "setSpanStyles", "setTextDecoration", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "setTextIndent", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "ui-text_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SpannableExtensions_androidKt {
    public static final void setSpan(Spannable $this$setSpan, Object span, int start, int end) {
        Intrinsics.checkNotNullParameter($this$setSpan, "<this>");
        Intrinsics.checkNotNullParameter(span, "span");
        $this$setSpan.setSpan(span, start, end, 33);
    }

    public static final void setTextIndent(Spannable $this$setTextIndent, TextIndent textIndent, float contextFontSize, Density density) {
        float firstLine;
        Intrinsics.checkNotNullParameter($this$setTextIndent, "<this>");
        Intrinsics.checkNotNullParameter(density, "density");
        if (textIndent != null) {
            if ((!TextUnit.m4560equalsimpl0(textIndent.getFirstLine(), TextUnitKt.getSp(0)) || !TextUnit.m4560equalsimpl0(textIndent.getRestLine(), TextUnitKt.getSp(0))) && !TextUnitKt.m4581isUnspecifiedR2X_6o(textIndent.getFirstLine()) && !TextUnitKt.m4581isUnspecifiedR2X_6o(textIndent.getRestLine())) {
                long m4562getTypeUIouoOA = TextUnit.m4562getTypeUIouoOA(textIndent.getFirstLine());
                float f = 0.0f;
                if (TextUnitType.m4591equalsimpl0(m4562getTypeUIouoOA, TextUnitType.INSTANCE.m4596getSpUIouoOA())) {
                    firstLine = density.mo647toPxR2X_6o(textIndent.getFirstLine());
                } else {
                    firstLine = TextUnitType.m4591equalsimpl0(m4562getTypeUIouoOA, TextUnitType.INSTANCE.m4595getEmUIouoOA()) ? TextUnit.m4563getValueimpl(textIndent.getFirstLine()) * contextFontSize : 0.0f;
                }
                long m4562getTypeUIouoOA2 = TextUnit.m4562getTypeUIouoOA(textIndent.getRestLine());
                if (TextUnitType.m4591equalsimpl0(m4562getTypeUIouoOA2, TextUnitType.INSTANCE.m4596getSpUIouoOA())) {
                    f = density.mo647toPxR2X_6o(textIndent.getRestLine());
                } else if (TextUnitType.m4591equalsimpl0(m4562getTypeUIouoOA2, TextUnitType.INSTANCE.m4595getEmUIouoOA())) {
                    f = TextUnit.m4563getValueimpl(textIndent.getRestLine()) * contextFontSize;
                }
                float restLine = f;
                setSpan($this$setTextIndent, new LeadingMarginSpan.Standard((int) Math.ceil(firstLine), (int) Math.ceil(restLine)), 0, $this$setTextIndent.length());
            }
        }
    }

    /* renamed from: setLineHeight-KmRG4DE, reason: not valid java name */
    public static final void m4173setLineHeightKmRG4DE(Spannable setLineHeight, long lineHeight, float contextFontSize, Density density, LineHeightStyle lineHeightStyle) {
        Intrinsics.checkNotNullParameter(setLineHeight, "$this$setLineHeight");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(lineHeightStyle, "lineHeightStyle");
        float resolvedLineHeight = m4168resolveLineHeightInPxo2QH7mI(lineHeight, contextFontSize, density);
        if (!Float.isNaN(resolvedLineHeight)) {
            int endIndex = ((setLineHeight.length() == 0) || StringsKt.last(setLineHeight) == '\n') ? setLineHeight.length() + 1 : setLineHeight.length();
            setSpan(setLineHeight, new LineHeightStyleSpan(resolvedLineHeight, 0, endIndex, LineHeightStyle.Trim.m4253isTrimFirstLineTopimpl$ui_text_release(lineHeightStyle.getTrim()), LineHeightStyle.Trim.m4254isTrimLastLineBottomimpl$ui_text_release(lineHeightStyle.getTrim()), lineHeightStyle.getAlignment()), 0, setLineHeight.length());
        }
    }

    /* renamed from: setLineHeight-r9BaKPg, reason: not valid java name */
    public static final void m4174setLineHeightr9BaKPg(Spannable setLineHeight, long lineHeight, float contextFontSize, Density density) {
        Intrinsics.checkNotNullParameter(setLineHeight, "$this$setLineHeight");
        Intrinsics.checkNotNullParameter(density, "density");
        float resolvedLineHeight = m4168resolveLineHeightInPxo2QH7mI(lineHeight, contextFontSize, density);
        if (!Float.isNaN(resolvedLineHeight)) {
            setSpan(setLineHeight, new LineHeightSpan(resolvedLineHeight), 0, setLineHeight.length());
        }
    }

    /* renamed from: resolveLineHeightInPx-o2QH7mI, reason: not valid java name */
    private static final float m4168resolveLineHeightInPxo2QH7mI(long lineHeight, float contextFontSize, Density density) {
        long m4562getTypeUIouoOA = TextUnit.m4562getTypeUIouoOA(lineHeight);
        if (TextUnitType.m4591equalsimpl0(m4562getTypeUIouoOA, TextUnitType.INSTANCE.m4596getSpUIouoOA())) {
            return density.mo647toPxR2X_6o(lineHeight);
        }
        if (TextUnitType.m4591equalsimpl0(m4562getTypeUIouoOA, TextUnitType.INSTANCE.m4595getEmUIouoOA())) {
            return TextUnit.m4563getValueimpl(lineHeight) * contextFontSize;
        }
        return Float.NaN;
    }

    public static final void setSpanStyles(Spannable $this$setSpanStyles, TextStyle contextTextStyle, List<AnnotatedString.Range<SpanStyle>> spanStyles, Density density, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> resolveTypeface) {
        Intrinsics.checkNotNullParameter($this$setSpanStyles, "<this>");
        Intrinsics.checkNotNullParameter(contextTextStyle, "contextTextStyle");
        Intrinsics.checkNotNullParameter(spanStyles, "spanStyles");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resolveTypeface, "resolveTypeface");
        setFontAttributes($this$setSpanStyles, contextTextStyle, spanStyles, resolveTypeface);
        ArrayList lowPrioritySpans = new ArrayList();
        int size = spanStyles.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range spanStyleRange = spanStyles.get(i);
            int start = spanStyleRange.getStart();
            int end = spanStyleRange.getEnd();
            if (start >= 0 && start < $this$setSpanStyles.length() && end > start && end <= $this$setSpanStyles.length()) {
                setSpanStyle($this$setSpanStyles, spanStyleRange, density, lowPrioritySpans);
            }
        }
        ArrayList $this$fastForEach$iv = lowPrioritySpans;
        int size2 = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size2; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            SpanRange spanRange = (SpanRange) item$iv;
            Object span = spanRange.getSpan();
            setSpan($this$setSpanStyles, span, spanRange.getStart(), spanRange.getEnd());
        }
    }

    private static final void setSpanStyle(Spannable $this$setSpanStyle, AnnotatedString.Range<SpanStyle> range, Density density, ArrayList<SpanRange> arrayList) {
        int start = range.getStart();
        int end = range.getEnd();
        SpanStyle style = range.getItem();
        m4170setBaselineShift0ocSgnM($this$setSpanStyle, style.getBaselineShift(), start, end);
        m4171setColorRPmYEkk($this$setSpanStyle, style.m3920getColor0d7_KjU(), start, end);
        setBrush($this$setSpanStyle, style.getBrush(), style.getAlpha(), start, end);
        setTextDecoration($this$setSpanStyle, style.getTextDecoration(), start, end);
        m4172setFontSizeKmRG4DE($this$setSpanStyle, style.getFontSize(), density, start, end);
        setFontFeatureSettings($this$setSpanStyle, style.getFontFeatureSettings(), start, end);
        setGeometricTransform($this$setSpanStyle, style.getTextGeometricTransform(), start, end);
        setLocaleList($this$setSpanStyle, style.getLocaleList(), start, end);
        m4169setBackgroundRPmYEkk($this$setSpanStyle, style.getBackground(), start, end);
        setShadow($this$setSpanStyle, style.getShadow(), start, end);
        MetricAffectingSpan it = m4167createLetterSpacingSpaneAf_CNQ(style.getLetterSpacing(), density);
        if (it != null) {
            arrayList.add(new SpanRange(it, start, end));
        }
    }

    private static final void setFontAttributes(final Spannable $this$setFontAttributes, TextStyle contextTextStyle, List<AnnotatedString.Range<SpanStyle>> list, final Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4) {
        SpanStyle contextFontSpanStyle;
        List target$iv = new ArrayList(list.size());
        int size = list.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            AnnotatedString.Range range = list.get(index$iv$iv);
            AnnotatedString.Range it = range;
            if (TextPaintExtensions_androidKt.hasFontAttributes(it.getItem()) || it.getItem().getFontSynthesis() != null) {
                target$iv.add(range);
            }
        }
        List fontRelatedSpanStyles = target$iv;
        if (hasFontAttributes(contextTextStyle)) {
            contextFontSpanStyle = new SpanStyle(0L, 0L, contextTextStyle.getFontWeight(), contextTextStyle.m3977getFontStyle4Lr2A7w(), contextTextStyle.m3978getFontSynthesisZQGJjVo(), contextTextStyle.getFontFamily(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, 16323, (DefaultConstructorMarker) null);
        } else {
            contextFontSpanStyle = null;
        }
        flattenFontStylesAndApply(contextFontSpanStyle, fontRelatedSpanStyles, new Function3<SpanStyle, Integer, Integer, Unit>() { // from class: androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt$setFontAttributes$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SpanStyle spanStyle, Integer num, Integer num2) {
                invoke(spanStyle, num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(SpanStyle spanStyle, int start, int end) {
                Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
                Spannable spannable = $this$setFontAttributes;
                Function4<FontFamily, FontWeight, FontStyle, FontSynthesis, Typeface> function42 = function4;
                FontFamily fontFamily = spanStyle.getFontFamily();
                FontWeight fontWeight = spanStyle.getFontWeight();
                if (fontWeight == null) {
                    fontWeight = FontWeight.INSTANCE.getNormal();
                }
                FontStyle fontStyle = spanStyle.getFontStyle();
                FontStyle m4037boximpl = FontStyle.m4037boximpl(fontStyle != null ? fontStyle.m4043unboximpl() : FontStyle.INSTANCE.m4045getNormal_LCdwA());
                FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
                spannable.setSpan(new TypefaceSpan(function42.invoke(fontFamily, fontWeight, m4037boximpl, FontSynthesis.m4046boximpl(fontSynthesis != null ? fontSynthesis.getValue() : FontSynthesis.INSTANCE.m4055getAllGVVA2EU()))), start, end, 33);
            }
        });
    }

    public static final void flattenFontStylesAndApply(SpanStyle contextFontSpanStyle, List<AnnotatedString.Range<SpanStyle>> spanStyles, Function3<? super SpanStyle, ? super Integer, ? super Integer, Unit> block) {
        int spanCount;
        Intrinsics.checkNotNullParameter(spanStyles, "spanStyles");
        Intrinsics.checkNotNullParameter(block, "block");
        int i = 0;
        if (spanStyles.size() <= 1) {
            if (!spanStyles.isEmpty()) {
                block.invoke(merge(contextFontSpanStyle, spanStyles.get(0).getItem()), Integer.valueOf(spanStyles.get(0).getStart()), Integer.valueOf(spanStyles.get(0).getEnd()));
                return;
            }
            return;
        }
        int spanCount2 = spanStyles.size();
        int i2 = spanCount2 * 2;
        Integer[] transitionOffsets = new Integer[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            transitionOffsets[i3] = 0;
        }
        int size = spanStyles.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            AnnotatedString.Range item$iv = spanStyles.get(index$iv);
            AnnotatedString.Range spanStyle = item$iv;
            int idx = index$iv;
            transitionOffsets[idx] = Integer.valueOf(spanStyle.getStart());
            transitionOffsets[idx + spanCount2] = Integer.valueOf(spanStyle.getEnd());
        }
        ArraysKt.sort((Object[]) transitionOffsets);
        int lastTransitionOffsets = ((Number) ArraysKt.first(transitionOffsets)).intValue();
        int length = transitionOffsets.length;
        while (i < length) {
            int transitionOffset = transitionOffsets[i].intValue();
            if (transitionOffset == lastTransitionOffsets) {
                spanCount = spanCount2;
            } else {
                SpanStyle spanStyle2 = contextFontSpanStyle;
                int index$iv2 = 0;
                int size2 = spanStyles.size();
                while (index$iv2 < size2) {
                    AnnotatedString.Range item$iv2 = spanStyles.get(index$iv2);
                    AnnotatedString.Range spanStyle3 = item$iv2;
                    int spanCount3 = spanCount2;
                    if (spanStyle3.getStart() != spanStyle3.getEnd() && AnnotatedStringKt.intersect(lastTransitionOffsets, transitionOffset, spanStyle3.getStart(), spanStyle3.getEnd())) {
                        spanStyle2 = merge(spanStyle2, spanStyle3.getItem());
                    }
                    index$iv2++;
                    spanCount2 = spanCount3;
                }
                spanCount = spanCount2;
                if (spanStyle2 != null) {
                    SpanStyle it = spanStyle2;
                    block.invoke(it, Integer.valueOf(lastTransitionOffsets), Integer.valueOf(transitionOffset));
                }
                lastTransitionOffsets = transitionOffset;
            }
            i++;
            spanCount2 = spanCount;
        }
    }

    /* renamed from: createLetterSpacingSpan-eAf_CNQ, reason: not valid java name */
    private static final MetricAffectingSpan m4167createLetterSpacingSpaneAf_CNQ(long letterSpacing, Density density) {
        long m4562getTypeUIouoOA = TextUnit.m4562getTypeUIouoOA(letterSpacing);
        if (TextUnitType.m4591equalsimpl0(m4562getTypeUIouoOA, TextUnitType.INSTANCE.m4596getSpUIouoOA())) {
            return new LetterSpacingSpanPx(density.mo647toPxR2X_6o(letterSpacing));
        }
        if (TextUnitType.m4591equalsimpl0(m4562getTypeUIouoOA, TextUnitType.INSTANCE.m4595getEmUIouoOA())) {
            return new LetterSpacingSpanEm(TextUnit.m4563getValueimpl(letterSpacing));
        }
        return null;
    }

    private static final void setShadow(Spannable $this$setShadow, Shadow shadow, int start, int end) {
        if (shadow != null) {
            setSpan($this$setShadow, new ShadowSpan(ColorKt.m2051toArgb8_81llA(shadow.getColor()), Offset.m1760getXimpl(shadow.getOffset()), Offset.m1761getYimpl(shadow.getOffset()), TextPaintExtensions_androidKt.correctBlurRadius(shadow.getBlurRadius())), start, end);
        }
    }

    /* renamed from: setBackground-RPmYEkk, reason: not valid java name */
    public static final void m4169setBackgroundRPmYEkk(Spannable setBackground, long color, int start, int end) {
        Intrinsics.checkNotNullParameter(setBackground, "$this$setBackground");
        if (color != Color.INSTANCE.m2032getUnspecified0d7_KjU()) {
            setSpan(setBackground, new BackgroundColorSpan(ColorKt.m2051toArgb8_81llA(color)), start, end);
        }
    }

    public static final void setLocaleList(Spannable $this$setLocaleList, LocaleList localeList, int start, int end) {
        Intrinsics.checkNotNullParameter($this$setLocaleList, "<this>");
        if (localeList != null) {
            setSpan($this$setLocaleList, LocaleListHelperMethods.INSTANCE.localeSpan(localeList), start, end);
        }
    }

    private static final void setGeometricTransform(Spannable $this$setGeometricTransform, TextGeometricTransform textGeometricTransform, int start, int end) {
        if (textGeometricTransform != null) {
            setSpan($this$setGeometricTransform, new ScaleXSpan(textGeometricTransform.getScaleX()), start, end);
            setSpan($this$setGeometricTransform, new SkewXSpan(textGeometricTransform.getSkewX()), start, end);
        }
    }

    private static final void setFontFeatureSettings(Spannable $this$setFontFeatureSettings, String fontFeatureSettings, int start, int end) {
        if (fontFeatureSettings != null) {
            setSpan($this$setFontFeatureSettings, new FontFeatureSpan(fontFeatureSettings), start, end);
        }
    }

    /* renamed from: setFontSize-KmRG4DE, reason: not valid java name */
    public static final void m4172setFontSizeKmRG4DE(Spannable setFontSize, long fontSize, Density density, int start, int end) {
        Intrinsics.checkNotNullParameter(setFontSize, "$this$setFontSize");
        Intrinsics.checkNotNullParameter(density, "density");
        long m4562getTypeUIouoOA = TextUnit.m4562getTypeUIouoOA(fontSize);
        if (TextUnitType.m4591equalsimpl0(m4562getTypeUIouoOA, TextUnitType.INSTANCE.m4596getSpUIouoOA())) {
            setSpan(setFontSize, new AbsoluteSizeSpan(MathKt.roundToInt(density.mo647toPxR2X_6o(fontSize)), false), start, end);
        } else if (TextUnitType.m4591equalsimpl0(m4562getTypeUIouoOA, TextUnitType.INSTANCE.m4595getEmUIouoOA())) {
            setSpan(setFontSize, new RelativeSizeSpan(TextUnit.m4563getValueimpl(fontSize)), start, end);
        }
    }

    public static final void setTextDecoration(Spannable $this$setTextDecoration, TextDecoration textDecoration, int start, int end) {
        Intrinsics.checkNotNullParameter($this$setTextDecoration, "<this>");
        if (textDecoration != null) {
            TextDecorationSpan textDecorationSpan = new TextDecorationSpan(textDecoration.contains(TextDecoration.INSTANCE.getUnderline()), textDecoration.contains(TextDecoration.INSTANCE.getLineThrough()));
            setSpan($this$setTextDecoration, textDecorationSpan, start, end);
        }
    }

    /* renamed from: setColor-RPmYEkk, reason: not valid java name */
    public static final void m4171setColorRPmYEkk(Spannable setColor, long color, int start, int end) {
        Intrinsics.checkNotNullParameter(setColor, "$this$setColor");
        if (color != Color.INSTANCE.m2032getUnspecified0d7_KjU()) {
            setSpan(setColor, new ForegroundColorSpan(ColorKt.m2051toArgb8_81llA(color)), start, end);
        }
    }

    /* renamed from: setBaselineShift-0ocSgnM, reason: not valid java name */
    private static final void m4170setBaselineShift0ocSgnM(Spannable $this$setBaselineShift_u2d0ocSgnM, BaselineShift baselineShift, int start, int end) {
        if (baselineShift != null) {
            float it = baselineShift.m4183unboximpl();
            setSpan($this$setBaselineShift_u2d0ocSgnM, new BaselineShiftSpan(it), start, end);
        }
    }

    private static final void setBrush(Spannable $this$setBrush, Brush brush, float alpha, int start, int end) {
        if (brush != null) {
            if (brush instanceof SolidColor) {
                m4171setColorRPmYEkk($this$setBrush, ((SolidColor) brush).getValue(), start, end);
            } else if (brush instanceof ShaderBrush) {
                setSpan($this$setBrush, new ShaderBrushSpan((ShaderBrush) brush, alpha), start, end);
            }
        }
    }

    private static final boolean hasFontAttributes(TextStyle $this$hasFontAttributes) {
        return TextPaintExtensions_androidKt.hasFontAttributes($this$hasFontAttributes.toSpanStyle()) || $this$hasFontAttributes.m3978getFontSynthesisZQGJjVo() != null;
    }

    private static final SpanStyle merge(SpanStyle $this$merge, SpanStyle spanStyle) {
        return $this$merge == null ? spanStyle : $this$merge.merge(spanStyle);
    }
}
