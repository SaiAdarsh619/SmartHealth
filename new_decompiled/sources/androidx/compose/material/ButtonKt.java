package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Button.kt */
@Metadata(m286d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u008d\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001c"}, m287d2 = {"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "elevation", "Landroidx/compose/material/ButtonElevation;", "shape", "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ButtonColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/ButtonElevation;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ButtonColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedButton", "TextButton", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ButtonKt {
    public static final void Button(final Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, ButtonElevation elevation, Shape shape, BorderStroke border, ButtonColors colors, PaddingValues contentPadding, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        boolean z;
        MutableInteractionSource mutableInteractionSource;
        ButtonElevation elevation2;
        BorderStroke borderStroke;
        int i2;
        PaddingValues paddingValues;
        Modifier modifier2;
        MutableInteractionSource interactionSource2;
        int i3;
        CornerBasedShape shape2;
        ButtonColors colors2;
        final PaddingValues contentPadding2;
        final int $dirty;
        Shape shape3;
        BorderStroke border2;
        ButtonColors colors3;
        ButtonElevation elevation3;
        boolean enabled2;
        Object value$iv$iv;
        long m1994copywmQWz5c;
        PaddingValues contentPadding3;
        ButtonColors colors4;
        ButtonElevation elevation4;
        boolean enabled3;
        Composer $composer2;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(-2116133464);
        ComposerKt.sourceInformation($composer3, "C(Button)P(8,7,5,6,4,9!2,3)94@4533L39,95@4623L11,96@4669L6,98@4759L14,102@4922L21,108@5086L24,111@5228L37,103@4948L1086:Button.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(onClick) ? 4 : 2;
        }
        int i7 = i & 2;
        if (i7 != 0) {
            $dirty2 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 32 : 16;
        }
        int i8 = i & 4;
        if (i8 != 0) {
            $dirty2 |= 384;
            z = enabled;
        } else if (($changed & 896) == 0) {
            z = enabled;
            $dirty2 |= $composer3.changed(z) ? 256 : 128;
        } else {
            z = enabled;
        }
        int i9 = i & 8;
        if (i9 != 0) {
            $dirty2 |= 3072;
            mutableInteractionSource = interactionSource;
        } else if (($changed & 7168) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty2 |= $composer3.changed(mutableInteractionSource) ? 2048 : 1024;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                elevation2 = elevation;
                if ($composer3.changed(elevation2)) {
                    i6 = 16384;
                    $dirty2 |= i6;
                }
            } else {
                elevation2 = elevation;
            }
            i6 = 8192;
            $dirty2 |= i6;
        } else {
            elevation2 = elevation;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0 && $composer3.changed(shape)) {
                i5 = 131072;
                $dirty2 |= i5;
            }
            i5 = 65536;
            $dirty2 |= i5;
        }
        int i10 = i & 64;
        if (i10 != 0) {
            $dirty2 |= 1572864;
            borderStroke = border;
        } else if (($changed & 3670016) == 0) {
            borderStroke = border;
            $dirty2 |= $composer3.changed(borderStroke) ? 1048576 : 524288;
        } else {
            borderStroke = border;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0 && $composer3.changed(colors)) {
                i4 = 8388608;
                $dirty2 |= i4;
            }
            i4 = 4194304;
            $dirty2 |= i4;
        }
        int i11 = i & 256;
        if (i11 != 0) {
            $dirty2 |= 100663296;
            i2 = i11;
            paddingValues = contentPadding;
        } else if (($changed & 234881024) == 0) {
            i2 = i11;
            paddingValues = contentPadding;
            $dirty2 |= $composer3.changed(paddingValues) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i11;
            paddingValues = contentPadding;
        }
        if ((i & 512) != 0) {
            $dirty2 |= 805306368;
        } else if ((1879048192 & $changed) == 0) {
            $dirty2 |= $composer3.changed(content) ? 536870912 : 268435456;
        }
        int $dirty3 = $dirty2;
        if ((1533916891 & $dirty3) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            shape3 = shape;
            colors4 = colors;
            enabled3 = z;
            interactionSource2 = mutableInteractionSource;
            border2 = borderStroke;
            contentPadding3 = paddingValues;
            elevation4 = elevation2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier2 = i7 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i8 != 0 ? true : z;
                if (i9 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    interactionSource2 = mutableInteractionSource;
                }
                if ((i & 16) != 0) {
                    i3 = i2;
                    $dirty3 &= -57345;
                    elevation2 = ButtonDefaults.INSTANCE.m1268elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 196608, 31);
                } else {
                    i3 = i2;
                }
                if ((i & 32) != 0) {
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall();
                    $dirty3 &= -458753;
                } else {
                    shape2 = shape;
                }
                BorderStroke border3 = i10 != 0 ? null : border;
                if ((i & 128) != 0) {
                    colors2 = ButtonDefaults.INSTANCE.m1267buttonColorsro_MJ88(0L, 0L, 0L, 0L, $composer3, 24576, 15);
                    $dirty3 &= -29360129;
                } else {
                    colors2 = colors;
                }
                if (i3 != 0) {
                    $dirty = $dirty3;
                    shape3 = shape2;
                    border2 = border3;
                    colors3 = colors2;
                    contentPadding2 = ButtonDefaults.INSTANCE.getContentPadding();
                    elevation3 = elevation2;
                    enabled2 = enabled4;
                } else {
                    contentPadding2 = contentPadding;
                    $dirty = $dirty3;
                    shape3 = shape2;
                    border2 = border3;
                    colors3 = colors2;
                    elevation3 = elevation2;
                    enabled2 = enabled4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                modifier2 = modifier;
                shape3 = shape;
                interactionSource2 = mutableInteractionSource;
                border2 = borderStroke;
                contentPadding2 = paddingValues;
                elevation3 = elevation2;
                colors3 = colors;
                $dirty = $dirty3;
                enabled2 = z;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2116133464, $dirty, -1, "androidx.compose.material.Button (Button.kt:90)");
            }
            final State contentColor$delegate = colors3.contentColor(enabled2, $composer3, (($dirty >> 6) & 14) | (($dirty >> 18) & SdkConfig.SDK_VERSION));
            long m2006unboximpl = colors3.backgroundColor(enabled2, $composer3, (($dirty >> 6) & 14) | (($dirty >> 18) & SdkConfig.SDK_VERSION)).getValue().m2006unboximpl();
            m1994copywmQWz5c = Color.m1994copywmQWz5c(r0, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r0) : 1.0f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r0) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r0) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(m1277Button$lambda1(contentColor$delegate)) : 0.0f);
            State<C0504Dp> elevation5 = elevation3 == null ? null : elevation3.elevation(enabled2, interactionSource2, $composer3, (($dirty >> 6) & 14) | (($dirty >> 6) & SdkConfig.SDK_VERSION) | (($dirty >> 6) & 896));
            contentPadding3 = contentPadding2;
            colors4 = colors3;
            elevation4 = elevation3;
            enabled3 = enabled2;
            $composer2 = $composer3;
            SurfaceKt.m1514SurfaceLPr_se0(onClick, modifier2, enabled2, shape3, m2006unboximpl, m1994copywmQWz5c, border2, elevation5 != null ? elevation5.getValue().m4396unboximpl() : C0504Dp.m4382constructorimpl(0), interactionSource2, ComposableLambdaKt.composableLambda($composer3, 7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$2
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

                public final void invoke(Composer $composer4, int $changed2) {
                    long m1277Button$lambda1;
                    ComposerKt.sourceInformation($composer4, "C114@5345L683:Button.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(7524271, $changed2, -1, "androidx.compose.material.Button.<anonymous> (Button.kt:113)");
                        }
                        ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                        m1277Button$lambda1 = ButtonKt.m1277Button$lambda1(contentColor$delegate);
                        ProvidedValue[] providedValueArr = {localContentAlpha.provides(Float.valueOf(Color.m1998getAlphaimpl(m1277Button$lambda1)))};
                        final PaddingValues paddingValues2 = contentPadding2;
                        final Function3<RowScope, Composer, Integer, Unit> function3 = content;
                        final int i12 = $dirty;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer4, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$2.1
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

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C116@5487L10,115@5431L587:Button.kt#jmzs0o");
                                if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1699085201, $changed3, -1, "androidx.compose.material.Button.<anonymous>.<anonymous> (Button.kt:114)");
                                    }
                                    TextStyle button = MaterialTheme.INSTANCE.getTypography($composer5, 6).getButton();
                                    final PaddingValues paddingValues3 = PaddingValues.this;
                                    final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                    final int i13 = i12;
                                    TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda($composer5, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
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

                                        public final void invoke(Composer $composer6, int $changed4) {
                                            ComposerKt.sourceInformation($composer6, "C118@5537L467:Button.kt#jmzs0o");
                                            if (($changed4 & 11) != 2 || !$composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-630330208, $changed4, -1, "androidx.compose.material.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:117)");
                                                }
                                                Modifier modifier$iv = PaddingKt.padding(SizeKt.m784defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m1273getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1272getMinHeightD9Ej5fM()), PaddingValues.this);
                                                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
                                                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                                                Function3 content$iv = function32;
                                                int $changed$iv = ((i13 >> 18) & 7168) | 432;
                                                $composer6.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation($composer6, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer6, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & SdkConfig.SDK_VERSION));
                                                int $changed$iv$iv = ($changed$iv << 3) & SdkConfig.SDK_VERSION;
                                                $composer6.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer6, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                                ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object consume = $composer6.consume(localDensity);
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                Density density$iv$iv = (Density) consume;
                                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object consume2 = $composer6.consume(localLayoutDirection);
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object consume3 = $composer6.consume(localViewConfiguration);
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                                                Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer6.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer6.startReusableNode();
                                                if ($composer6.getInserting()) {
                                                    $composer6.createNode(factory$iv$iv$iv);
                                                } else {
                                                    $composer6.useNode();
                                                }
                                                $composer6.disableReusing();
                                                Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer6);
                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                $composer6.enableReusing();
                                                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer6)), $composer6, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                                                $composer6.startReplaceableGroup(2058660585);
                                                $composer6.startReplaceableGroup(-678309503);
                                                ComposerKt.sourceInformation($composer6, "C80@3988L9:Row.kt#2w3rfo");
                                                if ((($changed$iv$iv$iv >> 9) & 14 & 11) == 2 && $composer6.getSkipping()) {
                                                    $composer6.skipToGroupEnd();
                                                } else {
                                                    content$iv.invoke(RowScopeInstance.INSTANCE, $composer6, Integer.valueOf((($changed$iv >> 6) & SdkConfig.SDK_VERSION) | 6));
                                                }
                                                $composer6.endReplaceableGroup();
                                                $composer6.endReplaceableGroup();
                                                $composer6.endNode();
                                                $composer6.endReplaceableGroup();
                                                $composer6.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer6.skipToGroupEnd();
                                        }
                                    }), $composer5, 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }), $composer4, 56);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, ($dirty & 14) | 805306368 | ($dirty & SdkConfig.SDK_VERSION) | ($dirty & 896) | (($dirty >> 6) & 7168) | ($dirty & 3670016) | (($dirty << 15) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = modifier2;
        final boolean z2 = enabled3;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
        final ButtonElevation buttonElevation = elevation4;
        final Shape shape4 = shape3;
        final BorderStroke borderStroke2 = border2;
        final ButtonColors buttonColors = colors4;
        final PaddingValues paddingValues2 = contentPadding3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$3
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

            public final void invoke(Composer composer, int i12) {
                ButtonKt.Button(onClick, modifier3, z2, mutableInteractionSource2, buttonElevation, shape4, borderStroke2, buttonColors, paddingValues2, content, composer, $changed | 1, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Button$lambda-1, reason: not valid java name */
    public static final long m1277Button$lambda1(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m2006unboximpl();
    }

    public static final void OutlinedButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, ButtonElevation elevation, Shape shape, BorderStroke border, ButtonColors colors, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        MutableInteractionSource interactionSource2;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        $composer.startReplaceableGroup(-1776134358);
        ComposerKt.sourceInformation($composer, "C(OutlinedButton)P(8,7,5,6,4,9!2,3)168@7956L39,170@8070L6,171@8127L14,172@8185L22,175@8325L270:Button.kt#jmzs0o");
        Modifier modifier2 = (i & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean enabled2 = (i & 4) != 0 ? true : enabled;
        if ((i & 8) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            interactionSource2 = (MutableInteractionSource) value$iv$iv;
        } else {
            interactionSource2 = interactionSource;
        }
        ButtonElevation elevation2 = (i & 16) != 0 ? null : elevation;
        Shape shape2 = (i & 32) != 0 ? MaterialTheme.INSTANCE.getShapes($composer, 6).getSmall() : shape;
        BorderStroke border2 = (i & 64) != 0 ? ButtonDefaults.INSTANCE.getOutlinedBorder($composer, 6) : border;
        ButtonColors colors2 = (i & 128) != 0 ? ButtonDefaults.INSTANCE.m1275outlinedButtonColorsRGew2ao(0L, 0L, 0L, $composer, 3072, 7) : colors;
        PaddingValues contentPadding2 = (i & 256) != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : contentPadding;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1776134358, $changed, -1, "androidx.compose.material.OutlinedButton (Button.kt:164)");
        }
        Button(onClick, modifier2, enabled2, interactionSource2, elevation2, shape2, border2, colors2, contentPadding2, content, $composer, ($changed & 14) | ($changed & SdkConfig.SDK_VERSION) | ($changed & 896) | ($changed & 7168) | (57344 & $changed) | (458752 & $changed) | (3670016 & $changed) | (29360128 & $changed) | (234881024 & $changed) | (1879048192 & $changed), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    public static final void TextButton(Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, ButtonElevation elevation, Shape shape, BorderStroke border, ButtonColors colors, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        MutableInteractionSource interactionSource2;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        $composer.startReplaceableGroup(288797557);
        ComposerKt.sourceInformation($composer, "C(TextButton)P(8,7,5,6,4,9!2,3)222@10527L39,224@10641L6,226@10731L18,229@10877L270:Button.kt#jmzs0o");
        Modifier modifier2 = (i & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean enabled2 = (i & 4) != 0 ? true : enabled;
        if ((i & 8) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            interactionSource2 = (MutableInteractionSource) value$iv$iv;
        } else {
            interactionSource2 = interactionSource;
        }
        ButtonElevation elevation2 = (i & 16) != 0 ? null : elevation;
        Shape shape2 = (i & 32) != 0 ? MaterialTheme.INSTANCE.getShapes($composer, 6).getSmall() : shape;
        BorderStroke border2 = (i & 64) != 0 ? null : border;
        ButtonColors colors2 = (i & 128) != 0 ? ButtonDefaults.INSTANCE.m1276textButtonColorsRGew2ao(0L, 0L, 0L, $composer, 3072, 7) : colors;
        PaddingValues contentPadding2 = (i & 256) != 0 ? ButtonDefaults.INSTANCE.getTextButtonContentPadding() : contentPadding;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(288797557, $changed, -1, "androidx.compose.material.TextButton (Button.kt:218)");
        }
        Button(onClick, modifier2, enabled2, interactionSource2, elevation2, shape2, border2, colors2, contentPadding2, content, $composer, ($changed & 14) | ($changed & SdkConfig.SDK_VERSION) | ($changed & 896) | ($changed & 7168) | (57344 & $changed) | (458752 & $changed) | (3670016 & $changed) | (29360128 & $changed) | (234881024 & $changed) | (1879048192 & $changed), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }
}
