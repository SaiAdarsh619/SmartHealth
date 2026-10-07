package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.TextStyleKt;
import androidx.compose.p000ui.text.font.FontFamily;
import androidx.compose.p000ui.text.font.FontStyle;
import androidx.compose.p000ui.text.font.FontSynthesis;
import androidx.compose.p000ui.text.font.FontWeight;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MaxLinesHeightModifier.kt */
@Metadata(m286d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m287d2 = {"maxLinesHeight", "Landroidx/compose/ui/Modifier;", "maxLines", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class MaxLinesHeightModifierKt {
    public static final Modifier maxLinesHeight(Modifier $this$maxLinesHeight, final int maxLines, final TextStyle textStyle) {
        Intrinsics.checkNotNullParameter($this$maxLinesHeight, "<this>");
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        return ComposedModifierKt.composed($this$maxLinesHeight, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.text.MaxLinesHeightModifierKt$maxLinesHeight$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("maxLinesHeight");
                $this$null.getProperties().set("maxLines", Integer.valueOf(maxLines));
                $this$null.getProperties().set("textStyle", textStyle);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.MaxLinesHeightModifierKt$maxLinesHeight$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Object value$iv$iv;
                Object value$iv$iv2;
                Object value$iv$iv3;
                Object value$iv$iv4;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(-1027014173);
                ComposerKt.sourceInformation($composer, "C53@1909L7,54@1970L7,55@2025L7,59@2196L96,62@2313L313,71@2654L366,87@3052L428:MaxLinesHeightModifier.kt#423gt5");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1027014173, $changed, -1, "androidx.compose.foundation.text.maxLinesHeight.<anonymous> (MaxLinesHeightModifier.kt:47)");
                }
                if (!(maxLines > 0)) {
                    throw new IllegalArgumentException("maxLines must be greater than 0".toString());
                }
                if (maxLines == Integer.MAX_VALUE) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer.endReplaceableGroup();
                    return companion;
                }
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = $composer.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Density density = (Density) consume;
                ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume2 = $composer.consume(localFontFamilyResolver);
                ComposerKt.sourceInformationMarkerEnd($composer);
                FontFamily.Resolver fontFamilyResolver = (FontFamily.Resolver) consume2;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume3 = $composer.consume(localLayoutDirection);
                ComposerKt.sourceInformationMarkerEnd($composer);
                LayoutDirection layoutDirection = (LayoutDirection) consume3;
                Object key1$iv = textStyle;
                TextStyle textStyle2 = textStyle;
                $composer.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer.changed(key1$iv) | $composer.changed(layoutDirection);
                Object it$iv$iv = $composer.rememberedValue();
                if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = TextStyleKt.resolveDefaults(textStyle2, layoutDirection);
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                TextStyle resolvedStyle = (TextStyle) value$iv$iv;
                $composer.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv2 = $composer.changed(fontFamilyResolver) | $composer.changed(resolvedStyle);
                Object it$iv$iv2 = $composer.rememberedValue();
                if (invalid$iv$iv2 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                    FontFamily fontFamily = resolvedStyle.getFontFamily();
                    FontWeight fontWeight = resolvedStyle.getFontWeight();
                    if (fontWeight == null) {
                        fontWeight = FontWeight.INSTANCE.getNormal();
                    }
                    FontWeight fontWeight2 = fontWeight;
                    FontStyle m3977getFontStyle4Lr2A7w = resolvedStyle.m3977getFontStyle4Lr2A7w();
                    int m4043unboximpl = m3977getFontStyle4Lr2A7w != null ? m3977getFontStyle4Lr2A7w.m4043unboximpl() : FontStyle.INSTANCE.m4045getNormal_LCdwA();
                    FontSynthesis m3978getFontSynthesisZQGJjVo = resolvedStyle.m3978getFontSynthesisZQGJjVo();
                    int $changed$iv = m3978getFontSynthesisZQGJjVo != null ? m3978getFontSynthesisZQGJjVo.getValue() : FontSynthesis.INSTANCE.m4055getAllGVVA2EU();
                    value$iv$iv2 = fontFamilyResolver.mo4017resolveDPcqOEQ(fontFamily, fontWeight2, m4043unboximpl, $changed$iv);
                    $composer.updateRememberedValue(value$iv$iv2);
                } else {
                    value$iv$iv2 = it$iv$iv2;
                }
                $composer.endReplaceableGroup();
                State typeface$delegate = (State) value$iv$iv2;
                Object[] keys$iv = {density, fontFamilyResolver, textStyle, layoutDirection, typeface$delegate.getValue()};
                $composer.startReplaceableGroup(-568225417);
                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv = false;
                for (Object key$iv : keys$iv) {
                    invalid$iv |= $composer.changed(key$iv);
                }
                Object it$iv$iv3 = $composer.rememberedValue();
                if (invalid$iv || it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv3 = Integer.valueOf(IntSize.m4541getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(resolvedStyle, density, fontFamilyResolver, TextFieldDelegateKt.getEmptyTextReplacement(), 1)));
                    $composer.updateRememberedValue(value$iv$iv3);
                } else {
                    value$iv$iv3 = it$iv$iv3;
                }
                $composer.endReplaceableGroup();
                int firstLineHeight = ((Number) value$iv$iv3).intValue();
                Object[] keys$iv2 = {density, fontFamilyResolver, textStyle, layoutDirection, typeface$delegate.getValue()};
                $composer.startReplaceableGroup(-568225417);
                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv2 = false;
                for (Object key$iv2 : keys$iv2) {
                    invalid$iv2 |= $composer.changed(key$iv2);
                }
                Object it$iv$iv4 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
                    String twoLines = TextFieldDelegateKt.getEmptyTextReplacement() + '\n' + TextFieldDelegateKt.getEmptyTextReplacement();
                    value$iv$iv4 = Integer.valueOf(IntSize.m4541getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(resolvedStyle, density, fontFamilyResolver, twoLines, 2)));
                    $composer.updateRememberedValue(value$iv$iv4);
                } else {
                    value$iv$iv4 = it$iv$iv4;
                }
                $composer.endReplaceableGroup();
                int firstTwoLinesHeight = ((Number) value$iv$iv4).intValue();
                int lineHeight = firstTwoLinesHeight - firstLineHeight;
                int precomputedMaxLinesHeight = ((maxLines - 1) * lineHeight) + firstLineHeight;
                Modifier m788heightInVpY3zN4$default = SizeKt.m788heightInVpY3zN4$default(Modifier.INSTANCE, 0.0f, density.mo645toDpu2uoSUM(precomputedMaxLinesHeight), 1, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return m788heightInVpY3zN4$default;
            }
        });
    }
}
