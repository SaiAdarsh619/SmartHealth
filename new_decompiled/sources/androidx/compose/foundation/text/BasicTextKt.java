package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.text.AnnotatedString;
import androidx.compose.p000ui.text.Placeholder;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.font.FontFamily;
import androidx.compose.p000ui.text.style.TextOverflow;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.health.platform.client.SdkConfig;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasicText.kt */
@Metadata(m286d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a{\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001ae\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00132\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001e\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001e"}, m287d2 = {"BasicText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "BasicText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "BasicText-BpD7jsM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILandroidx/compose/runtime/Composer;II)V", "selectionIdSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class BasicTextKt {
    /* renamed from: BasicText-BpD7jsM, reason: not valid java name */
    public static final void m1022BasicTextBpD7jsM(final String text, Modifier modifier, TextStyle style, Function1<? super TextLayoutResult, Unit> function1, int overflow, boolean softWrap, int maxLines, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        TextStyle textStyle;
        Function1 onTextLayout;
        int overflow2;
        boolean softWrap2;
        TextStyle style2;
        int maxLines2;
        long longValue;
        Object value$iv$iv;
        TextState state;
        Modifier modifier3;
        int overflow3;
        boolean softWrap3;
        SelectionRegistrar selectionRegistrar;
        Function1 onTextLayout2;
        int overflow4;
        int maxLines3;
        Function1 onTextLayout3;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer2 = $composer.startRestartGroup(1022429478);
        ComposerKt.sourceInformation($composer2, "C(BasicText)P(6,1,5,2,3:c#ui.text.style.TextOverflow,4)73@3673L7,74@3712L7,75@3773L7,95@4758L473,132@5929L69:BasicText.kt#423gt5");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(text) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            textStyle = style;
        } else if (($changed & 896) == 0) {
            textStyle = style;
            $dirty |= $composer2.changed(textStyle) ? 256 : 128;
        } else {
            textStyle = style;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            onTextLayout = function1;
        } else if (($changed & 7168) == 0) {
            onTextLayout = function1;
            $dirty |= $composer2.changed(onTextLayout) ? 2048 : 1024;
        } else {
            onTextLayout = function1;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            overflow2 = overflow;
        } else if ((57344 & $changed) == 0) {
            overflow2 = overflow;
            $dirty |= $composer2.changed(overflow2) ? 16384 : 8192;
        } else {
            overflow2 = overflow;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= 196608;
            softWrap2 = softWrap;
        } else if ((458752 & $changed) == 0) {
            softWrap2 = softWrap;
            $dirty |= $composer2.changed(softWrap2) ? 131072 : 65536;
        } else {
            softWrap2 = softWrap;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer2.changed(maxLines) ? 1048576 : 524288;
        }
        if (($dirty & 2995931) != 599186 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (i3 == 0) {
                style2 = textStyle;
            } else {
                style2 = TextStyle.INSTANCE.getDefault();
            }
            if (i4 != 0) {
                onTextLayout = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                };
            }
            if (i5 != 0) {
                overflow2 = TextOverflow.INSTANCE.m4302getClipgIe3tQ8();
            }
            if (i6 != 0) {
                softWrap2 = true;
            }
            if (i7 == 0) {
                maxLines2 = maxLines;
            } else {
                maxLines2 = Integer.MAX_VALUE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1022429478, $changed, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:58)");
            }
            if (!(maxLines2 > 0)) {
                throw new IllegalArgumentException("maxLines should be greater than 0".toString());
            }
            ProvidableCompositionLocal<SelectionRegistrar> localSelectionRegistrar = SelectionRegistrarKt.getLocalSelectionRegistrar();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localSelectionRegistrar);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final SelectionRegistrar selectionRegistrar2 = (SelectionRegistrar) consume;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) consume2;
            ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(localFontFamilyResolver);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            FontFamily.Resolver fontFamilyResolver = (FontFamily.Resolver) consume3;
            $composer2.startReplaceableGroup(959238313);
            ComposerKt.sourceInformation($composer2, "90@4579L150");
            if (selectionRegistrar2 == null) {
                longValue = 0;
            } else {
                longValue = ((Number) RememberSaveableKt.m1652rememberSaveable(new Object[]{text, selectionRegistrar2}, (Saver) selectionIdSaver(selectionRegistrar2), (String) null, (Function0) new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectableId$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Long invoke() {
                        return Long.valueOf(SelectionRegistrar.this.nextSelectableId());
                    }
                }, $composer2, 72, 4)).longValue();
            }
            $composer2.endReplaceableGroup();
            long selectableId = longValue;
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new TextController(new TextState(new TextDelegate(new AnnotatedString(text, null, null, 6, null), style2, maxLines2, softWrap2, overflow2, density, fontFamilyResolver, null, 128, null), selectableId));
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            TextController controller = (TextController) value$iv$iv;
            TextState state2 = controller.getState();
            if ($composer2.getInserting()) {
                state = state2;
                modifier3 = modifier2;
                overflow3 = overflow2;
                softWrap3 = softWrap2;
                selectionRegistrar = selectionRegistrar2;
                onTextLayout2 = onTextLayout;
            } else {
                state = state2;
                modifier3 = modifier2;
                boolean z = softWrap2;
                softWrap3 = softWrap2;
                selectionRegistrar = selectionRegistrar2;
                int i8 = overflow2;
                overflow3 = overflow2;
                onTextLayout2 = onTextLayout;
                controller.setTextDelegate(CoreTextKt.m1033updateTextDelegatey0kMQk(state2.getTextDelegate(), text, style2, density, fontFamilyResolver, z, i8, maxLines2));
            }
            state.setOnTextLayout(onTextLayout2);
            controller.update(selectionRegistrar);
            $composer2.startReplaceableGroup(959239630);
            ComposerKt.sourceInformation($composer2, "129@5894L7");
            if (selectionRegistrar != null) {
                ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer2.consume(localTextSelectionColors);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                state.m1119setSelectionBackgroundColor8_81llA(((SelectionColors) consume4).getSelectionBackgroundColor());
            }
            $composer2.endReplaceableGroup();
            Modifier modifier$iv = modifier3.then(controller.getModifiers());
            MeasurePolicy measurePolicy$iv = controller.getMeasurePolicy();
            $composer2.startReplaceableGroup(544976794);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(1)120@4589L7,121@4644L7,122@4703L7,124@4776L439:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer2.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv = (Density) consume5;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume6;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume7 = $composer2.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume7;
            Modifier materialized$iv = ComposedModifierKt.materialize($composer2, modifier$iv);
            final Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            $composer2.startReplaceableGroup(1405779621);
            ComposerKt.sourceInformation($composer2, "C(ReusableComposeNode):Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(new Function0<ComposeUiNode>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText-BpD7jsM$$inlined$Layout$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final ComposeUiNode invoke() {
                        return Function0.this.invoke();
                    }
                });
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d1$iv = Updater.m1639constructorimpl($composer2);
            Updater.m1646setimpl($this$Layout_u24lambda_u2d1$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d1$iv, density$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d1$iv, layoutDirection$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d1$iv, viewConfiguration$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d1$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            $composer2.enableReusing();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            softWrap2 = softWrap3;
            overflow4 = overflow3;
            maxLines3 = maxLines2;
            onTextLayout3 = onTextLayout2;
        } else {
            $composer2.skipToGroupEnd();
            maxLines3 = maxLines;
            modifier3 = modifier2;
            style2 = textStyle;
            onTextLayout3 = onTextLayout;
            overflow4 = overflow2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final TextStyle textStyle2 = style2;
        final Function1 function12 = onTextLayout3;
        final int i9 = overflow4;
        final boolean z2 = softWrap2;
        final int i10 = maxLines3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$3
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

            public final void invoke(Composer composer, int i11) {
                BasicTextKt.m1022BasicTextBpD7jsM(text, modifier4, textStyle2, function12, i9, z2, i10, composer, $changed | 1, i);
            }
        });
    }

    /* renamed from: BasicText-4YKlhWE, reason: not valid java name */
    public static final void m1021BasicText4YKlhWE(final AnnotatedString text, Modifier modifier, TextStyle style, Function1<? super TextLayoutResult, Unit> function1, int overflow, boolean softWrap, int maxLines, Map<String, InlineTextContent> map, Composer $composer, final int $changed, final int i) {
        TextStyle style2;
        Function1 onTextLayout;
        int overflow2;
        int $dirty;
        boolean softWrap2;
        int maxLines2;
        TextStyle style3;
        Function1 onTextLayout2;
        int overflow3;
        Map inlineContent;
        Modifier modifier2;
        long selectionBackgroundColor;
        SelectionRegistrar selectionRegistrar;
        String str;
        int $dirty2;
        Map inlineContent2;
        Function1 onTextLayout3;
        long selectableId;
        TextState state;
        final List inlineComposables;
        final int $dirty3;
        Function2 content$iv;
        Function1 onTextLayout4;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer2 = $composer.startRestartGroup(-648605928);
        ComposerKt.sourceInformation($composer2, "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5,1)172@8209L7,173@8248L7,174@8309L7,175@8377L7,197@9465L504,235@10641L270:BasicText.kt#423gt5");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer2.changed(text) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty4 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty4 |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty4 |= 384;
            style2 = style;
        } else if (($changed & 896) == 0) {
            style2 = style;
            $dirty4 |= $composer2.changed(style2) ? 256 : 128;
        } else {
            style2 = style;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty4 |= 3072;
            onTextLayout = function1;
        } else if (($changed & 7168) == 0) {
            onTextLayout = function1;
            $dirty4 |= $composer2.changed(onTextLayout) ? 2048 : 1024;
        } else {
            onTextLayout = function1;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty4 |= 24576;
            overflow2 = overflow;
        } else if ((57344 & $changed) == 0) {
            overflow2 = overflow;
            $dirty4 |= $composer2.changed(overflow2) ? 16384 : 8192;
        } else {
            overflow2 = overflow;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty4 |= 196608;
        } else if (($changed & 458752) == 0) {
            $dirty4 |= $composer2.changed(softWrap) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty4 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty4 |= $composer2.changed(maxLines) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty4 |= 4194304;
        }
        if (i8 == 128 && (23967451 & $dirty4) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            softWrap2 = softWrap;
            maxLines2 = maxLines;
            inlineContent2 = map;
            style3 = style2;
            onTextLayout4 = onTextLayout;
            overflow3 = overflow2;
            modifier2 = modifier;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if (i3 != 0) {
                    style2 = TextStyle.INSTANCE.getDefault();
                }
                if (i4 != 0) {
                    onTextLayout = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$4
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                            invoke2(textLayoutResult);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextLayoutResult it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    };
                }
                if (i5 != 0) {
                    overflow2 = TextOverflow.INSTANCE.m4302getClipgIe3tQ8();
                }
                boolean softWrap3 = i6 != 0 ? true : softWrap;
                int maxLines3 = i7 != 0 ? Integer.MAX_VALUE : maxLines;
                if (i8 != 0) {
                    Map inlineContent3 = MapsKt.emptyMap();
                    $dirty = $dirty4 & (-29360129);
                    softWrap2 = softWrap3;
                    maxLines2 = maxLines3;
                    style3 = style2;
                    onTextLayout2 = onTextLayout;
                    overflow3 = overflow2;
                    inlineContent = inlineContent3;
                    modifier2 = modifier3;
                } else {
                    $dirty = $dirty4;
                    softWrap2 = softWrap3;
                    maxLines2 = maxLines3;
                    style3 = style2;
                    onTextLayout2 = onTextLayout;
                    overflow3 = overflow2;
                    inlineContent = map;
                    modifier2 = modifier3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if (i8 != 0) {
                    $dirty4 &= -29360129;
                }
                softWrap2 = softWrap;
                maxLines2 = maxLines;
                $dirty = $dirty4;
                style3 = style2;
                onTextLayout2 = onTextLayout;
                overflow3 = overflow2;
                modifier2 = modifier;
                inlineContent = map;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-648605928, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:159)");
            }
            if (!(maxLines2 > 0)) {
                throw new IllegalArgumentException("maxLines should be greater than 0".toString());
            }
            ProvidableCompositionLocal<SelectionRegistrar> localSelectionRegistrar = SelectionRegistrarKt.getLocalSelectionRegistrar();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localSelectionRegistrar);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final SelectionRegistrar selectionRegistrar2 = (SelectionRegistrar) consume;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) consume2;
            ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(localFontFamilyResolver);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            FontFamily.Resolver fontFamilyResolver = (FontFamily.Resolver) consume3;
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer2.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            long selectionBackgroundColor2 = ((SelectionColors) consume4).getSelectionBackgroundColor();
            Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> resolveInlineContent = CoreTextKt.resolveInlineContent(text, inlineContent);
            List placeholders = resolveInlineContent.component1();
            List inlineComposables2 = resolveInlineContent.component2();
            $composer2.startReplaceableGroup(959243020);
            ComposerKt.sourceInformation($composer2, "192@9286L150");
            long selectableId2 = selectionRegistrar2 == null ? 0L : ((Number) RememberSaveableKt.m1652rememberSaveable(new Object[]{text, selectionRegistrar2}, (Saver) selectionIdSaver(selectionRegistrar2), (String) null, (Function0) new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectableId$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Long invoke() {
                    return Long.valueOf(SelectionRegistrar.this.nextSelectableId());
                }
            }, $composer2, 72, 4)).longValue();
            $composer2.endReplaceableGroup();
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Object value$iv$iv = $composer2.rememberedValue();
            if (value$iv$iv == Composer.INSTANCE.getEmpty()) {
                selectionBackgroundColor = selectionBackgroundColor2;
                selectionRegistrar = selectionRegistrar2;
                str = "C:CompositionLocal.kt#9igjgp";
                $dirty2 = $dirty;
                inlineContent2 = inlineContent;
                onTextLayout3 = onTextLayout2;
                selectableId = selectableId2;
                value$iv$iv = new TextController(new TextState(new TextDelegate(text, style3, maxLines2, softWrap2, overflow3, density, fontFamilyResolver, placeholders, null), selectableId));
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                selectionBackgroundColor = selectionBackgroundColor2;
                selectionRegistrar = selectionRegistrar2;
                str = "C:CompositionLocal.kt#9igjgp";
                $dirty2 = $dirty;
                inlineContent2 = inlineContent;
                onTextLayout3 = onTextLayout2;
                selectableId = selectableId2;
            }
            $composer2.endReplaceableGroup();
            TextController controller = (TextController) value$iv$iv;
            TextState state2 = controller.getState();
            if ($composer2.getInserting()) {
                state = state2;
            } else {
                state = state2;
                controller.setTextDelegate(CoreTextKt.m1031updateTextDelegatex_uQXYA(state2.getTextDelegate(), text, style3, density, fontFamilyResolver, softWrap2, overflow3, maxLines2, placeholders));
            }
            state.setOnTextLayout(onTextLayout3);
            state.m1119setSelectionBackgroundColor8_81llA(selectionBackgroundColor);
            controller.update(selectionRegistrar);
            if (inlineComposables2.isEmpty()) {
                content$iv = ComposableSingletons$BasicTextKt.INSTANCE.m1027getLambda1$foundation_release();
                inlineComposables = inlineComposables2;
                $dirty3 = $dirty2;
            } else {
                inlineComposables = inlineComposables2;
                $dirty3 = $dirty2;
                content$iv = ComposableLambdaKt.composableLambda($composer2, 1892283635, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer3, int $changed2) {
                        ComposerKt.sourceInformation($composer3, "C239@10748L39:BasicText.kt#423gt5");
                        if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1892283635, $changed2, -1, "androidx.compose.foundation.text.BasicText.<anonymous> (BasicText.kt:239)");
                        }
                        CoreTextKt.InlineChildren(AnnotatedString.this, inlineComposables, $composer3, ($dirty3 & 14) | 64);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                });
            }
            Modifier modifier$iv = modifier2.then(controller.getModifiers());
            MeasurePolicy measurePolicy$iv = controller.getMeasurePolicy();
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2907L7,75@2962L7,76@3021L7,77@3033L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            String str2 = str;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str2);
            Object consume5 = $composer2.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv = (Density) consume5;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str2);
            Object consume6 = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume6;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str2);
            Object consume7 = $composer2.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume7;
            Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv = Updater.m1639constructorimpl($composer2);
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, density$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, layoutDirection$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, viewConfiguration$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & SdkConfig.SDK_VERSION));
            $composer2.startReplaceableGroup(2058660585);
            content$iv.invoke($composer2, Integer.valueOf(($changed$iv$iv >> 9) & 14));
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onTextLayout4 = onTextLayout3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier2;
        final TextStyle textStyle = style3;
        final Function1 function12 = onTextLayout4;
        final int i9 = overflow3;
        final boolean z = softWrap2;
        final int i10 = maxLines2;
        final Map map2 = inlineContent2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$7
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

            public final void invoke(Composer composer, int i11) {
                BasicTextKt.m1021BasicText4YKlhWE(AnnotatedString.this, modifier4, textStyle, function12, i9, z, i10, map2, composer, $changed | 1, i);
            }
        });
    }

    private static final Saver<Long, Long> selectionIdSaver(final SelectionRegistrar selectionRegistrar) {
        return SaverKt.Saver(new Function2<SaverScope, Long, Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$selectionIdSaver$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Long invoke(SaverScope saverScope, Long l) {
                return invoke(saverScope, l.longValue());
            }

            public final Long invoke(SaverScope Saver, long it) {
                Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                if (SelectionRegistrarKt.hasSelection(SelectionRegistrar.this, it)) {
                    return Long.valueOf(it);
                }
                return null;
            }
        }, new Function1<Long, Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$selectionIdSaver$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Long invoke(Long l) {
                return invoke(l.longValue());
            }

            public final Long invoke(long it) {
                return Long.valueOf(it);
            }
        });
    }
}
