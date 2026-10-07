package androidx.compose.p000ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.p000ui.text.android.TextLayout;
import androidx.compose.p000ui.text.android.style.IndentationFixSpan;
import androidx.compose.p000ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.p000ui.text.style.Hyphens;
import androidx.compose.p000ui.text.style.LineBreak;
import androidx.compose.p000ui.text.style.TextAlign;
import androidx.compose.p000ui.unit.TextUnit;
import androidx.compose.p000ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidParagraph.android.kt */
@Metadata(m286d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u001d\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\t\u001a\u001d\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\r\u001a\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002\u001a\u001d\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0014\u001a\u001d\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0018\u001a\f\u0010\u0019\u001a\u00020\u001a*\u00020\u001aH\u0002\u001a\u0014\u0010\u001b\u001a\u00020\u0006*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006H\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001e"}, m287d2 = {"shouldAttachIndentationFixSpan", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "ellipsis", "toLayoutAlign", "", "align", "Landroidx/compose/ui/text/style/TextAlign;", "toLayoutAlign-AMY3VfE", "toLayoutBreakStrategy", "breakStrategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "toLayoutBreakStrategy-u6PBz3U", "toLayoutHyphenationFrequency", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "toLayoutLineBreakStyle", "lineBreakStrictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "toLayoutLineBreakStyle-4a2g8L8", "toLayoutLineBreakWordStyle", "lineBreakWordStyle", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "toLayoutLineBreakWordStyle-gvcdTPQ", "attachIndentationFixSpan", "", "numberOfLinesThatFitMaxHeight", "Landroidx/compose/ui/text/android/TextLayout;", "maxHeight", "ui-text_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AndroidParagraph_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutAlign-AMY3VfE, reason: not valid java name */
    public static final int m3857toLayoutAlignAMY3VfE(TextAlign align) {
        if (align == null ? false : TextAlign.m4264equalsimpl0(align.getValue(), TextAlign.INSTANCE.m4271getLefte0LSkKk())) {
            return 3;
        }
        if (align == null ? false : TextAlign.m4264equalsimpl0(align.getValue(), TextAlign.INSTANCE.m4272getRighte0LSkKk())) {
            return 4;
        }
        if (align == null ? false : TextAlign.m4264equalsimpl0(align.getValue(), TextAlign.INSTANCE.m4268getCentere0LSkKk())) {
            return 2;
        }
        if (align == null ? false : TextAlign.m4264equalsimpl0(align.getValue(), TextAlign.INSTANCE.m4273getStarte0LSkKk())) {
            return 0;
        }
        return align == null ? false : TextAlign.m4264equalsimpl0(align.getValue(), TextAlign.INSTANCE.m4269getEnde0LSkKk()) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int toLayoutHyphenationFrequency(Hyphens hyphens) {
        if (!Intrinsics.areEqual(hyphens, Hyphens.INSTANCE.getAuto())) {
            return Intrinsics.areEqual(hyphens, Hyphens.INSTANCE.getNone()) ? 0 : 0;
        }
        if (Build.VERSION.SDK_INT <= 32) {
            return 1;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutBreakStrategy-u6PBz3U, reason: not valid java name */
    public static final int m3858toLayoutBreakStrategyu6PBz3U(LineBreak.Strategy breakStrategy) {
        if (breakStrategy == null ? false : LineBreak.Strategy.m4204equalsimpl0(breakStrategy.getValue(), LineBreak.Strategy.INSTANCE.m4210getSimplefcGXIks())) {
            return 0;
        }
        if (breakStrategy == null ? false : LineBreak.Strategy.m4204equalsimpl0(breakStrategy.getValue(), LineBreak.Strategy.INSTANCE.m4209getHighQualityfcGXIks())) {
            return 1;
        }
        return breakStrategy == null ? false : LineBreak.Strategy.m4204equalsimpl0(breakStrategy.getValue(), LineBreak.Strategy.INSTANCE.m4208getBalancedfcGXIks()) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakStyle-4a2g8L8, reason: not valid java name */
    public static final int m3859toLayoutLineBreakStyle4a2g8L8(LineBreak.Strictness lineBreakStrictness) {
        if (lineBreakStrictness == null ? false : LineBreak.Strictness.m4214equalsimpl0(lineBreakStrictness.getValue(), LineBreak.Strictness.INSTANCE.m4218getDefaultusljTpc())) {
            return 0;
        }
        if (lineBreakStrictness == null ? false : LineBreak.Strictness.m4214equalsimpl0(lineBreakStrictness.getValue(), LineBreak.Strictness.INSTANCE.m4219getLooseusljTpc())) {
            return 1;
        }
        if (lineBreakStrictness == null ? false : LineBreak.Strictness.m4214equalsimpl0(lineBreakStrictness.getValue(), LineBreak.Strictness.INSTANCE.m4220getNormalusljTpc())) {
            return 2;
        }
        return lineBreakStrictness == null ? false : LineBreak.Strictness.m4214equalsimpl0(lineBreakStrictness.getValue(), LineBreak.Strictness.INSTANCE.m4221getStrictusljTpc()) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakWordStyle-gvcdTPQ, reason: not valid java name */
    public static final int m3860toLayoutLineBreakWordStylegvcdTPQ(LineBreak.WordBreak lineBreakWordStyle) {
        if (lineBreakWordStyle == null ? false : LineBreak.WordBreak.m4225equalsimpl0(lineBreakWordStyle.getValue(), LineBreak.WordBreak.INSTANCE.m4229getDefaultjp8hJ3c())) {
            return 0;
        }
        return lineBreakWordStyle == null ? false : LineBreak.WordBreak.m4225equalsimpl0(lineBreakWordStyle.getValue(), LineBreak.WordBreak.INSTANCE.m4230getPhrasejp8hJ3c()) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout $this$numberOfLinesThatFitMaxHeight, int maxHeight) {
        int lineCount = $this$numberOfLinesThatFitMaxHeight.getLineCount();
        for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
            if ($this$numberOfLinesThatFitMaxHeight.getLineBottom(lineIndex) > maxHeight) {
                return lineIndex;
            }
        }
        int lineIndex2 = $this$numberOfLinesThatFitMaxHeight.getLineCount();
        return lineIndex2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean ellipsis) {
        if (ellipsis && !TextUnit.m4560equalsimpl0(textStyle.m3979getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) && !TextUnit.m4560equalsimpl0(textStyle.m3979getLetterSpacingXSAIIZE(), TextUnit.INSTANCE.m4574getUnspecifiedXSAIIZE()) && textStyle.m3981getTextAlignbuA522U() != null) {
            TextAlign m3981getTextAlignbuA522U = textStyle.m3981getTextAlignbuA522U();
            if (!(m3981getTextAlignbuA522U == null ? false : TextAlign.m4264equalsimpl0(m3981getTextAlignbuA522U.getValue(), TextAlign.INSTANCE.m4273getStarte0LSkKk()))) {
                TextAlign m3981getTextAlignbuA522U2 = textStyle.m3981getTextAlignbuA522U();
                return !(m3981getTextAlignbuA522U2 == null ? false : TextAlign.m4264equalsimpl0(m3981getTextAlignbuA522U2.getValue(), TextAlign.INSTANCE.m4270getJustifye0LSkKk()));
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence $this$attachIndentationFixSpan) {
        if ($this$attachIndentationFixSpan.length() == 0) {
            return $this$attachIndentationFixSpan;
        }
        SpannableString spannable = $this$attachIndentationFixSpan instanceof Spannable ? (Spannable) $this$attachIndentationFixSpan : new SpannableString($this$attachIndentationFixSpan);
        SpannableExtensions_androidKt.setSpan(spannable, new IndentationFixSpan(), spannable.length() - 1, spannable.length() - 1);
        return spannable;
    }
}
