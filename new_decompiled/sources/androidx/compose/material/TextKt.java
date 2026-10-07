package androidx.compose.material;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.Shadow;
import androidx.compose.p000ui.text.AnnotatedString;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.font.FontFamily;
import androidx.compose.p000ui.text.font.FontStyle;
import androidx.compose.p000ui.text.font.FontSynthesis;
import androidx.compose.p000ui.text.font.FontWeight;
import androidx.compose.p000ui.text.intl.LocaleList;
import androidx.compose.p000ui.text.style.BaselineShift;
import androidx.compose.p000ui.text.style.TextAlign;
import androidx.compose.p000ui.text.style.TextDecoration;
import androidx.compose.p000ui.text.style.TextDirection;
import androidx.compose.p000ui.text.style.TextGeometricTransform;
import androidx.compose.p000ui.text.style.TextIndent;
import androidx.compose.p000ui.text.style.TextOverflow;
import androidx.compose.p000ui.unit.TextUnit;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.health.platform.client.SdkConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Text.kt */
@Metadata(m286d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aß\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(2\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060,2\b\b\u0002\u0010.\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100\u001aÉ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020)2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060,2\b\b\u0002\u0010.\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00063"}, m287d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<TextStyle>() { // from class: androidx.compose.material.TextKt$LocalTextStyle$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextStyle invoke() {
            return TextStyle.INSTANCE.getDefault();
        }
    });

    /* renamed from: Text-fLXpl1I, reason: not valid java name */
    public static final void m1585TextfLXpl1I(final String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Function1<? super TextLayoutResult, Unit> function1, TextStyle style, Composer $composer, final int $changed, final int $changed1, final int i) {
        int i2;
        Modifier.Companion modifier2;
        long color2;
        long fontSize2;
        FontStyle fontStyle2;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        long letterSpacing2;
        TextDecoration textDecoration2;
        TextAlign textAlign2;
        long lineHeight2;
        int overflow2;
        boolean softWrap2;
        int maxLines2;
        Function1 onTextLayout;
        TextStyle style2;
        int maxLines3;
        long m1994copywmQWz5c;
        long textColor;
        int maxLines4;
        TextDecoration textDecoration3;
        int overflow3;
        TextAlign textAlign3;
        boolean softWrap3;
        Function1 onTextLayout2;
        FontStyle fontStyle3;
        TextStyle style3;
        FontWeight fontWeight3;
        FontFamily fontFamily3;
        long letterSpacing3;
        long lineHeight3;
        Modifier modifier3;
        long fontSize3;
        long color3;
        int i3;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer2 = $composer.startRestartGroup(-366126944);
        ComposerKt.sourceInformation($composer2, "C(Text)P(13,8,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,15,14:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,10:c#ui.text.style.TextOverflow,11)106@5548L7,129@6306L145:Text.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(text) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(color) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(fontSize) ? 2048 : 1024;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer2.changed(fontStyle) ? 16384 : 8192;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= 196608;
        } else if (($changed & 458752) == 0) {
            $dirty |= $composer2.changed(fontWeight) ? 131072 : 65536;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer2.changed(fontFamily) ? 1048576 : 524288;
        }
        int i10 = i & 128;
        if (i10 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer2.changed(letterSpacing) ? 8388608 : 4194304;
        }
        int i11 = i & 256;
        if (i11 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer2.changed(textDecoration) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i12 = i & 512;
        if (i12 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer2.changed(textAlign) ? 536870912 : 268435456;
        }
        int i13 = i & 1024;
        if (i13 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer2.changed(lineHeight) ? 4 : 2;
        }
        int i14 = i & 2048;
        if (i14 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & SdkConfig.SDK_VERSION) == 0) {
            $dirty1 |= $composer2.changed(overflow) ? 32 : 16;
        }
        int i15 = i & 4096;
        if (i15 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty1 |= $composer2.changed(softWrap) ? 256 : 128;
        }
        int i16 = i & 8192;
        if (i16 != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty1 |= $composer2.changed(maxLines) ? 2048 : 1024;
        }
        int i17 = i & 16384;
        if (i17 != 0) {
            $dirty1 |= 24576;
            i2 = i17;
        } else if (($changed1 & 57344) == 0) {
            i2 = i17;
            $dirty1 |= $composer2.changed(function1) ? 16384 : 8192;
        } else {
            i2 = i17;
        }
        if (($changed1 & 458752) == 0) {
            if ((i & 32768) == 0 && $composer2.changed(style)) {
                i3 = 131072;
                $dirty1 |= i3;
            }
            i3 = 65536;
            $dirty1 |= i3;
        }
        if (($dirty & 1533916891) == 306783378 && (374491 & $dirty1) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            color3 = color;
            fontSize3 = fontSize;
            fontStyle3 = fontStyle;
            fontWeight3 = fontWeight;
            fontFamily3 = fontFamily;
            letterSpacing3 = letterSpacing;
            textDecoration3 = textDecoration;
            textAlign3 = textAlign;
            lineHeight3 = lineHeight;
            overflow3 = overflow;
            softWrap3 = softWrap;
            maxLines4 = maxLines;
            onTextLayout2 = function1;
            style3 = style;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i4 != 0 ? Modifier.INSTANCE : modifier;
                color2 = i5 != 0 ? Color.INSTANCE.m2032getUnspecified0d7_KjU() : color;
                fontSize2 = i6 != 0 ? TextUnit.INSTANCE.m4574getUnspecifiedXSAIIZE() : fontSize;
                fontStyle2 = i7 != 0 ? null : fontStyle;
                fontWeight2 = i8 != 0 ? null : fontWeight;
                fontFamily2 = i9 != 0 ? null : fontFamily;
                letterSpacing2 = i10 != 0 ? TextUnit.INSTANCE.m4574getUnspecifiedXSAIIZE() : letterSpacing;
                textDecoration2 = i11 != 0 ? null : textDecoration;
                textAlign2 = i12 != 0 ? null : textAlign;
                lineHeight2 = i13 != 0 ? TextUnit.INSTANCE.m4574getUnspecifiedXSAIIZE() : lineHeight;
                overflow2 = i14 != 0 ? TextOverflow.INSTANCE.m4302getClipgIe3tQ8() : overflow;
                softWrap2 = i15 != 0 ? true : softWrap;
                maxLines2 = i16 != 0 ? Integer.MAX_VALUE : maxLines;
                onTextLayout = i2 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                } : function1;
                if ((i & 32768) != 0) {
                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    style2 = (TextStyle) consume;
                    $dirty1 &= -458753;
                } else {
                    style2 = style;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32768) != 0) {
                    modifier2 = modifier;
                    color2 = color;
                    fontSize2 = fontSize;
                    fontStyle2 = fontStyle;
                    fontWeight2 = fontWeight;
                    fontFamily2 = fontFamily;
                    letterSpacing2 = letterSpacing;
                    textAlign2 = textAlign;
                    lineHeight2 = lineHeight;
                    overflow2 = overflow;
                    softWrap2 = softWrap;
                    maxLines2 = maxLines;
                    onTextLayout = function1;
                    style2 = style;
                    $dirty1 = (-458753) & $dirty1;
                    textDecoration2 = textDecoration;
                } else {
                    modifier2 = modifier;
                    color2 = color;
                    fontSize2 = fontSize;
                    fontStyle2 = fontStyle;
                    fontWeight2 = fontWeight;
                    fontFamily2 = fontFamily;
                    letterSpacing2 = letterSpacing;
                    textDecoration2 = textDecoration;
                    textAlign2 = textAlign;
                    lineHeight2 = lineHeight;
                    overflow2 = overflow;
                    softWrap2 = softWrap;
                    maxLines2 = maxLines;
                    onTextLayout = function1;
                    style2 = style;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-366126944, $dirty, $dirty1, "androidx.compose.material.Text (Text.kt:90)");
            }
            $composer2.startReplaceableGroup(1557613088);
            ComposerKt.sourceInformation($composer2, "*111@5663L7,111@5702L7");
            long $this$takeOrElse_u2dDxMtmZc$iv = color2;
            if ($this$takeOrElse_u2dDxMtmZc$iv != Color.INSTANCE.m2032getUnspecified0d7_KjU()) {
                maxLines3 = maxLines2;
                textColor = $this$takeOrElse_u2dDxMtmZc$iv;
            } else {
                long $this$takeOrElse_u2dDxMtmZc$iv2 = style2.m3975getColor0d7_KjU();
                if ($this$takeOrElse_u2dDxMtmZc$iv2 != Color.INSTANCE.m2032getUnspecified0d7_KjU()) {
                    maxLines3 = maxLines2;
                } else {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer2.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    long m2006unboximpl = ((Color) consume2).m2006unboximpl();
                    ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                    maxLines3 = maxLines2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume3 = $composer2.consume(localContentAlpha);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    m1994copywmQWz5c = Color.m1994copywmQWz5c(m2006unboximpl, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(m2006unboximpl) : ((Number) consume3).floatValue(), (r12 & 2) != 0 ? Color.m2002getRedimpl(m2006unboximpl) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(m2006unboximpl) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(m2006unboximpl) : 0.0f);
                    $this$takeOrElse_u2dDxMtmZc$iv2 = m1994copywmQWz5c;
                }
                textColor = $this$takeOrElse_u2dDxMtmZc$iv2;
            }
            $composer2.endReplaceableGroup();
            TextStyle mergedStyle = style2.merge(new TextStyle(textColor, fontSize2, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, letterSpacing2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, lineHeight2, (TextIndent) null, 175952, (DefaultConstructorMarker) null));
            BasicTextKt.m1022BasicTextBpD7jsM(text, modifier2, mergedStyle, onTextLayout, overflow2, softWrap2, maxLines3, $composer2, ($dirty & 14) | ($dirty & SdkConfig.SDK_VERSION) | (($dirty1 >> 3) & 7168) | (($dirty1 << 9) & 57344) | (($dirty1 << 9) & 458752) | (3670016 & ($dirty1 << 9)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            maxLines4 = maxLines3;
            textDecoration3 = textDecoration2;
            overflow3 = overflow2;
            textAlign3 = textAlign2;
            softWrap3 = softWrap2;
            onTextLayout2 = onTextLayout;
            fontStyle3 = fontStyle2;
            style3 = style2;
            fontWeight3 = fontWeight2;
            fontFamily3 = fontFamily2;
            letterSpacing3 = letterSpacing2;
            lineHeight3 = lineHeight2;
            modifier3 = modifier2;
            fontSize3 = fontSize2;
            color3 = color2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final long j = color3;
        final long j2 = fontSize3;
        final FontStyle fontStyle4 = fontStyle3;
        final FontWeight fontWeight4 = fontWeight3;
        final FontFamily fontFamily4 = fontFamily3;
        final long j3 = letterSpacing3;
        final TextDecoration textDecoration4 = textDecoration3;
        final TextAlign textAlign4 = textAlign3;
        final long j4 = lineHeight3;
        final int i18 = overflow3;
        final boolean z = softWrap3;
        final int i19 = maxLines4;
        final Function1 function12 = onTextLayout2;
        final TextStyle textStyle = style3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i20) {
                TextKt.m1585TextfLXpl1I(text, modifier4, j, j2, fontStyle4, fontWeight4, fontFamily4, j3, textDecoration4, textAlign4, j4, i18, z, i19, function12, textStyle, composer, $changed | 1, $changed1, i);
            }
        });
    }

    /* renamed from: Text--4IGK_g, reason: not valid java name */
    public static final void m1584Text4IGK_g(final AnnotatedString text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Map<String, InlineTextContent> map, Function1<? super TextLayoutResult, Unit> function1, TextStyle style, Composer $composer, final int $changed, final int $changed1, final int i) {
        int i2;
        Modifier.Companion modifier2;
        long color2;
        long fontSize2;
        FontStyle fontStyle2;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        long letterSpacing2;
        TextDecoration textDecoration2;
        TextAlign textAlign2;
        int overflow2;
        Map inlineContent;
        TextStyle style2;
        int $dirty1;
        boolean softWrap2;
        Function1 onTextLayout;
        Map inlineContent2;
        int maxLines2;
        long lineHeight2;
        int maxLines3;
        Map inlineContent3;
        long m1994copywmQWz5c;
        long textColor;
        TextDecoration textDecoration3;
        Map inlineContent4;
        int maxLines4;
        boolean softWrap3;
        Modifier modifier3;
        int overflow3;
        TextAlign textAlign3;
        long lineHeight3;
        FontStyle fontStyle3;
        FontWeight fontWeight3;
        TextStyle style3;
        Function1 onTextLayout2;
        FontFamily fontFamily3;
        long color3;
        long letterSpacing3;
        long fontSize3;
        int i3;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer2 = $composer.startRestartGroup(-422393234);
        ComposerKt.sourceInformation($composer2, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12,8)210@10653L7,232@11410L167:Text.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(text) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(color) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(fontSize) ? 2048 : 1024;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer2.changed(fontStyle) ? 16384 : 8192;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= 196608;
        } else if (($changed & 458752) == 0) {
            $dirty |= $composer2.changed(fontWeight) ? 131072 : 65536;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer2.changed(fontFamily) ? 1048576 : 524288;
        }
        int i10 = i & 128;
        if (i10 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer2.changed(letterSpacing) ? 8388608 : 4194304;
        }
        int i11 = i & 256;
        if (i11 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer2.changed(textDecoration) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i12 = i & 512;
        if (i12 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer2.changed(textAlign) ? 536870912 : 268435456;
        }
        int i13 = i & 1024;
        if (i13 != 0) {
            $dirty12 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty12 |= $composer2.changed(lineHeight) ? 4 : 2;
        }
        int i14 = i & 2048;
        if (i14 != 0) {
            $dirty12 |= 48;
        } else if (($changed1 & SdkConfig.SDK_VERSION) == 0) {
            $dirty12 |= $composer2.changed(overflow) ? 32 : 16;
        }
        int i15 = i & 4096;
        if (i15 != 0) {
            $dirty12 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty12 |= $composer2.changed(softWrap) ? 256 : 128;
        }
        int i16 = i & 8192;
        if (i16 != 0) {
            $dirty12 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty12 |= $composer2.changed(maxLines) ? 2048 : 1024;
        }
        int i17 = i & 16384;
        if (i17 != 0) {
            $dirty12 |= 8192;
        }
        int i18 = i & 32768;
        if (i18 != 0) {
            $dirty12 |= 196608;
            i2 = i16;
        } else if (($changed1 & 458752) == 0) {
            i2 = i16;
            $dirty12 |= $composer2.changed(function1) ? 131072 : 65536;
        } else {
            i2 = i16;
        }
        if (($changed1 & 3670016) == 0) {
            if ((i & 65536) == 0 && $composer2.changed(style)) {
                i3 = 1048576;
                $dirty12 |= i3;
            }
            i3 = 524288;
            $dirty12 |= i3;
        }
        if (i17 == 16384 && (1533916891 & $dirty) == 306783378 && (2995931 & $dirty12) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            color3 = color;
            fontSize3 = fontSize;
            fontStyle3 = fontStyle;
            fontWeight3 = fontWeight;
            fontFamily3 = fontFamily;
            letterSpacing3 = letterSpacing;
            textDecoration3 = textDecoration;
            textAlign3 = textAlign;
            lineHeight3 = lineHeight;
            overflow3 = overflow;
            softWrap3 = softWrap;
            maxLines4 = maxLines;
            inlineContent4 = map;
            onTextLayout2 = function1;
            style3 = style;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i4 != 0 ? Modifier.INSTANCE : modifier;
                color2 = i5 != 0 ? Color.INSTANCE.m2032getUnspecified0d7_KjU() : color;
                fontSize2 = i6 != 0 ? TextUnit.INSTANCE.m4574getUnspecifiedXSAIIZE() : fontSize;
                fontStyle2 = i7 != 0 ? null : fontStyle;
                fontWeight2 = i8 != 0 ? null : fontWeight;
                fontFamily2 = i9 != 0 ? null : fontFamily;
                letterSpacing2 = i10 != 0 ? TextUnit.INSTANCE.m4574getUnspecifiedXSAIIZE() : letterSpacing;
                textDecoration2 = i11 != 0 ? null : textDecoration;
                textAlign2 = i12 != 0 ? null : textAlign;
                long lineHeight4 = i13 != 0 ? TextUnit.INSTANCE.m4574getUnspecifiedXSAIIZE() : lineHeight;
                overflow2 = i14 != 0 ? TextOverflow.INSTANCE.m4302getClipgIe3tQ8() : overflow;
                boolean softWrap4 = i15 != 0 ? true : softWrap;
                int maxLines5 = i2 != 0 ? Integer.MAX_VALUE : maxLines;
                if (i17 != 0) {
                    inlineContent = MapsKt.emptyMap();
                    $dirty12 &= -57345;
                } else {
                    inlineContent = map;
                }
                Function1 onTextLayout3 = i18 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                } : function1;
                if ((i & 65536) != 0) {
                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                    TextDecoration textDecoration4 = textDecoration2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    style2 = (TextStyle) consume;
                    $dirty1 = $dirty12 & (-3670017);
                    softWrap2 = softWrap4;
                    onTextLayout = onTextLayout3;
                    textDecoration2 = textDecoration4;
                    inlineContent2 = inlineContent;
                    maxLines2 = maxLines5;
                    lineHeight2 = lineHeight4;
                } else {
                    style2 = style;
                    $dirty1 = $dirty12;
                    softWrap2 = softWrap4;
                    onTextLayout = onTextLayout3;
                    inlineContent2 = inlineContent;
                    maxLines2 = maxLines5;
                    lineHeight2 = lineHeight4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if (i17 != 0) {
                    $dirty12 &= -57345;
                }
                if ((i & 65536) != 0) {
                    int i19 = (-3670017) & $dirty12;
                    modifier2 = modifier;
                    color2 = color;
                    fontSize2 = fontSize;
                    fontStyle2 = fontStyle;
                    fontWeight2 = fontWeight;
                    fontFamily2 = fontFamily;
                    letterSpacing2 = letterSpacing;
                    textAlign2 = textAlign;
                    lineHeight2 = lineHeight;
                    overflow2 = overflow;
                    softWrap2 = softWrap;
                    maxLines2 = maxLines;
                    inlineContent2 = map;
                    onTextLayout = function1;
                    style2 = style;
                    $dirty1 = i19;
                    textDecoration2 = textDecoration;
                } else {
                    modifier2 = modifier;
                    color2 = color;
                    fontSize2 = fontSize;
                    fontStyle2 = fontStyle;
                    fontWeight2 = fontWeight;
                    fontFamily2 = fontFamily;
                    letterSpacing2 = letterSpacing;
                    textDecoration2 = textDecoration;
                    textAlign2 = textAlign;
                    lineHeight2 = lineHeight;
                    overflow2 = overflow;
                    maxLines2 = maxLines;
                    inlineContent2 = map;
                    onTextLayout = function1;
                    style2 = style;
                    $dirty1 = $dirty12;
                    softWrap2 = softWrap;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                inlineContent3 = inlineContent2;
                maxLines3 = maxLines2;
                ComposerKt.traceEventStart(-422393234, $dirty, $dirty1, "androidx.compose.material.Text (Text.kt:193)");
            } else {
                maxLines3 = maxLines2;
                inlineContent3 = inlineContent2;
            }
            $composer2.startReplaceableGroup(1557618192);
            ComposerKt.sourceInformation($composer2, "*214@10767L7,214@10806L7");
            long $this$takeOrElse_u2dDxMtmZc$iv = color2;
            if ($this$takeOrElse_u2dDxMtmZc$iv != Color.INSTANCE.m2032getUnspecified0d7_KjU()) {
                textColor = $this$takeOrElse_u2dDxMtmZc$iv;
            } else {
                long $this$takeOrElse_u2dDxMtmZc$iv2 = style2.m3975getColor0d7_KjU();
                if (!($this$takeOrElse_u2dDxMtmZc$iv2 != Color.INSTANCE.m2032getUnspecified0d7_KjU())) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer2.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    long m2006unboximpl = ((Color) consume2).m2006unboximpl();
                    ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume3 = $composer2.consume(localContentAlpha);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    m1994copywmQWz5c = Color.m1994copywmQWz5c(m2006unboximpl, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(m2006unboximpl) : ((Number) consume3).floatValue(), (r12 & 2) != 0 ? Color.m2002getRedimpl(m2006unboximpl) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(m2006unboximpl) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(m2006unboximpl) : 0.0f);
                    $this$takeOrElse_u2dDxMtmZc$iv2 = m1994copywmQWz5c;
                }
                textColor = $this$takeOrElse_u2dDxMtmZc$iv2;
            }
            $composer2.endReplaceableGroup();
            TextStyle style4 = style2;
            TextStyle mergedStyle = style4.merge(new TextStyle(textColor, fontSize2, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, letterSpacing2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, lineHeight2, (TextIndent) null, 175952, (DefaultConstructorMarker) null));
            TextDecoration textDecoration5 = textDecoration2;
            BasicTextKt.m1021BasicText4YKlhWE(text, modifier2, mergedStyle, onTextLayout, overflow2, softWrap2, maxLines3, inlineContent3, $composer2, (($dirty1 >> 6) & 7168) | ($dirty & 14) | 16777216 | ($dirty & SdkConfig.SDK_VERSION) | (($dirty1 << 9) & 57344) | (($dirty1 << 9) & 458752) | (($dirty1 << 9) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            textDecoration3 = textDecoration5;
            inlineContent4 = inlineContent3;
            maxLines4 = maxLines3;
            softWrap3 = softWrap2;
            modifier3 = modifier2;
            overflow3 = overflow2;
            textAlign3 = textAlign2;
            lineHeight3 = lineHeight2;
            fontStyle3 = fontStyle2;
            fontWeight3 = fontWeight2;
            style3 = style4;
            onTextLayout2 = onTextLayout;
            fontFamily3 = fontFamily2;
            color3 = color2;
            letterSpacing3 = letterSpacing2;
            fontSize3 = fontSize2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final long j = color3;
        final long j2 = fontSize3;
        final FontStyle fontStyle4 = fontStyle3;
        final FontWeight fontWeight4 = fontWeight3;
        final FontFamily fontFamily4 = fontFamily3;
        final long j3 = letterSpacing3;
        final TextDecoration textDecoration6 = textDecoration3;
        final TextAlign textAlign4 = textAlign3;
        final long j4 = lineHeight3;
        final int i20 = overflow3;
        final boolean z = softWrap3;
        final int i21 = maxLines4;
        final Map map2 = inlineContent4;
        final Function1 function12 = onTextLayout2;
        final TextStyle textStyle = style3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i22) {
                TextKt.m1584Text4IGK_g(AnnotatedString.this, modifier4, j, j2, fontStyle4, fontWeight4, fontFamily4, j3, textDecoration6, textAlign4, j4, i20, z, i21, map2, function12, textStyle, composer, $changed | 1, $changed1, i);
            }
        });
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    public static final void ProvideTextStyle(final TextStyle value, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(1772272796);
        ComposerKt.sourceInformation($composer2, "C(ProvideTextStyle)P(1)263@12533L7,264@12558L80:Text.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(value) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(content) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1772272796, $dirty, -1, "androidx.compose.material.ProvideTextStyle (Text.kt:262)");
            }
            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(providableCompositionLocal);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            TextStyle mergedStyle = ((TextStyle) consume).merge(value);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{LocalTextStyle.provides(mergedStyle)}, content, $composer2, ($dirty & SdkConfig.SDK_VERSION) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$ProvideTextStyle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                TextKt.ProvideTextStyle(TextStyle.this, content, composer, $changed | 1);
            }
        });
    }
}
