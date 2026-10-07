package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.ClipKt;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.semantics.Role;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
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
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Chip.kt */
@Metadata(m286d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u008e\u0001\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010 \u001aÄ\u0001\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020#2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010%\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010&\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\t\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, m287d2 = {"HorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LeadingIconEndSpacing", "LeadingIconStartSpacing", "SelectedIconContainerSize", "SelectedOverlayOpacity", "", "SurfaceOverlayOpacity", "TrailingIconSpacing", "Chip", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ChipColors;", "leadingIcon", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "selected", "Landroidx/compose/material/SelectableChipColors;", "selectedIcon", "trailingIcon", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/SelectableChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ChipKt {
    private static final float SelectedOverlayOpacity = 0.16f;
    private static final float SurfaceOverlayOpacity = 0.12f;
    private static final float HorizontalPadding = C0504Dp.m4382constructorimpl(12);
    private static final float LeadingIconStartSpacing = C0504Dp.m4382constructorimpl(4);
    private static final float LeadingIconEndSpacing = C0504Dp.m4382constructorimpl(8);
    private static final float TrailingIconSpacing = C0504Dp.m4382constructorimpl(8);
    private static final float SelectedIconContainerSize = C0504Dp.m4382constructorimpl(24);

    /* JADX WARN: Removed duplicated region for block: B:46:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x019f  */
    @ExperimentalMaterialApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Chip(final Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, Shape shape, BorderStroke border, ChipColors colors, Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        MutableInteractionSource interactionSource2;
        Shape shape2;
        BorderStroke border2;
        Modifier modifier2;
        boolean enabled2;
        ChipColors colors2;
        Function2 leadingIcon;
        ChipColors colors3;
        MutableInteractionSource interactionSource3;
        Shape shape3;
        BorderStroke border3;
        boolean enabled3;
        int $dirty;
        Object value$iv$iv;
        long m1994copywmQWz5c;
        ChipColors colors4;
        boolean enabled4;
        Composer $composer2;
        ScopeUpdateScope endRestartGroup;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(-368396408);
        ComposerKt.sourceInformation($composer3, "C(Chip)P(7,6,3,4,8!2,5)91@4163L39,92@4237L6,94@4354L12,98@4499L21,104@4663L24,99@4525L1754:Chip.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(onClick) ? 4 : 2;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty2 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 32 : 16;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changed(enabled) ? 256 : 128;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            interactionSource2 = interactionSource;
        } else if (($changed & 7168) == 0) {
            interactionSource2 = interactionSource;
            $dirty2 |= $composer3.changed(interactionSource2) ? 2048 : 1024;
        } else {
            interactionSource2 = interactionSource;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                if ($composer3.changed(shape2)) {
                    i4 = 16384;
                    $dirty2 |= i4;
                }
            } else {
                shape2 = shape;
            }
            i4 = 8192;
            $dirty2 |= i4;
        } else {
            shape2 = shape;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty2 |= 196608;
            border2 = border;
        } else if ((458752 & $changed) == 0) {
            border2 = border;
            $dirty2 |= $composer3.changed(border2) ? 131072 : 65536;
        } else {
            border2 = border;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0 && $composer3.changed(colors)) {
                i3 = 1048576;
                $dirty2 |= i3;
            }
            i3 = 524288;
            $dirty2 |= i3;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty2 |= $composer3.changed(function2) ? 8388608 : 4194304;
        }
        if ((i & 256) == 0) {
            i2 = ($changed & 234881024) == 0 ? $composer3.changed(content) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432 : 100663296;
            if ((191739611 & $dirty2) == 38347922 || !$composer3.getSkipping()) {
                $composer3.startDefaults();
                if (($changed & 1) != 0 || $composer3.getDefaultsInvalid()) {
                    Modifier.Companion modifier3 = i5 == 0 ? Modifier.INSTANCE : modifier;
                    boolean enabled5 = i6 == 0 ? true : enabled;
                    if (i7 == 0) {
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                        modifier2 = modifier3;
                        Object it$iv$iv = $composer3.rememberedValue();
                        enabled2 = enabled5;
                        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                            $composer3.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                        }
                        $composer3.endReplaceableGroup();
                        interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    } else {
                        modifier2 = modifier3;
                        enabled2 = enabled5;
                    }
                    if ((i & 16) != 0) {
                        $dirty2 &= -57345;
                        shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    }
                    if (i8 != 0) {
                        border2 = null;
                    }
                    if ((i & 64) == 0) {
                        colors2 = ChipDefaults.INSTANCE.m1297chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, $composer3, 1572864, 63);
                        $dirty2 &= -3670017;
                    } else {
                        colors2 = colors;
                    }
                    if (i9 == 0) {
                        leadingIcon = null;
                        colors3 = colors2;
                        interactionSource3 = interactionSource2;
                        shape3 = shape2;
                        border3 = border2;
                        enabled3 = enabled2;
                        $dirty = $dirty2;
                    } else {
                        leadingIcon = function2;
                        colors3 = colors2;
                        interactionSource3 = interactionSource2;
                        shape3 = shape2;
                        border3 = border2;
                        enabled3 = enabled2;
                        $dirty = $dirty2;
                    }
                } else {
                    $composer3.skipToGroupEnd();
                    if ((i & 16) != 0) {
                        $dirty2 &= -57345;
                    }
                    if ((i & 64) != 0) {
                        modifier2 = modifier;
                        colors3 = colors;
                        leadingIcon = function2;
                        interactionSource3 = interactionSource2;
                        shape3 = shape2;
                        border3 = border2;
                        enabled3 = enabled;
                        $dirty = $dirty2 & (-3670017);
                    } else {
                        modifier2 = modifier;
                        colors3 = colors;
                        leadingIcon = function2;
                        interactionSource3 = interactionSource2;
                        shape3 = shape2;
                        border3 = border2;
                        enabled3 = enabled;
                        $dirty = $dirty2;
                    }
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-368396408, $dirty, -1, "androidx.compose.material.Chip (Chip.kt:87)");
                }
                final State contentColor$delegate = colors3.contentColor(enabled3, $composer3, (($dirty >> 6) & 14) | (($dirty >> 15) & SdkConfig.SDK_VERSION));
                long m2006unboximpl = colors3.backgroundColor(enabled3, $composer3, (($dirty >> 6) & 14) | (($dirty >> 15) & SdkConfig.SDK_VERSION)).getValue().m2006unboximpl();
                m1994copywmQWz5c = Color.m1994copywmQWz5c(r21, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r21) : 1.0f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r21) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r21) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(m1305Chip$lambda1(contentColor$delegate)) : 0.0f);
                final Function2 function22 = leadingIcon;
                final ChipColors chipColors = colors3;
                final boolean z = enabled3;
                final int i10 = $dirty;
                colors4 = colors3;
                enabled4 = enabled3;
                $composer2 = $composer3;
                SurfaceKt.m1514SurfaceLPr_se0(onClick, modifier2, enabled3, shape3, m2006unboximpl, m1994copywmQWz5c, border3, 0.0f, interactionSource3, ComposableLambdaKt.composableLambda($composer3, 139076687, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$2
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
                        long m1305Chip$lambda1;
                        ComposerKt.sourceInformation($composer4, "C109@4831L1442:Chip.kt#jmzs0o");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(139076687, $changed2, -1, "androidx.compose.material.Chip.<anonymous> (Chip.kt:108)");
                            }
                            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                            m1305Chip$lambda1 = ChipKt.m1305Chip$lambda1(contentColor$delegate);
                            ProvidedValue[] providedValueArr = {localContentAlpha.provides(Float.valueOf(Color.m1998getAlphaimpl(m1305Chip$lambda1)))};
                            final Function2<Composer, Integer, Unit> function23 = function22;
                            final ChipColors chipColors2 = chipColors;
                            final boolean z2 = z;
                            final int i11 = i10;
                            final Function3<RowScope, Composer, Integer, Unit> function3 = content;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer4, 667535631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$2.1
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
                                    ComposerKt.sourceInformation($composer5, "C111@4973L10,110@4917L1346:Chip.kt#jmzs0o");
                                    if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(667535631, $changed3, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous> (Chip.kt:109)");
                                        }
                                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography($composer5, 6).getBody2();
                                        final Function2<Composer, Integer, Unit> function24 = function23;
                                        final ChipColors chipColors3 = chipColors2;
                                        final boolean z3 = z2;
                                        final int i12 = i11;
                                        final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda($composer5, -1131213696, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.2.1.1
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
                                                float m4382constructorimpl;
                                                float f;
                                                float f2;
                                                float f3;
                                                float f4;
                                                ComposerKt.sourceInformation($composer6, "C113@5022L1227:Chip.kt#jmzs0o");
                                                if (($changed4 & 11) != 2 || !$composer6.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1131213696, $changed4, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:112)");
                                                    }
                                                    Modifier m785defaultMinSizeVpY3zN4$default = SizeKt.m785defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, ChipDefaults.INSTANCE.m1300getMinHeightD9Ej5fM(), 1, null);
                                                    if (function24 == null) {
                                                        f4 = ChipKt.HorizontalPadding;
                                                        m4382constructorimpl = f4;
                                                    } else {
                                                        m4382constructorimpl = C0504Dp.m4382constructorimpl(0);
                                                    }
                                                    f = ChipKt.HorizontalPadding;
                                                    Modifier modifier$iv = PaddingKt.m763paddingqDBjuR0$default(m785defaultMinSizeVpY3zN4$default, m4382constructorimpl, 0.0f, f, 0.0f, 10, null);
                                                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                                    Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                                                    Function2<Composer, Integer, Unit> function25 = function24;
                                                    ChipColors chipColors4 = chipColors3;
                                                    boolean z4 = z3;
                                                    int i13 = i12;
                                                    Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                                    $composer6.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation($composer6, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer6, ((432 >> 3) & 14) | ((432 >> 3) & SdkConfig.SDK_VERSION));
                                                    int $changed$iv$iv = (432 << 3) & SdkConfig.SDK_VERSION;
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
                                                    int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                                                    $composer6.startReplaceableGroup(-678309503);
                                                    ComposerKt.sourceInformation($composer6, "C80@3988L9:Row.kt#2w3rfo");
                                                    if (($changed$iv & 11) == 2 && $composer6.getSkipping()) {
                                                        $composer6.skipToGroupEnd();
                                                    } else {
                                                        RowScope rowScope = RowScopeInstance.INSTANCE;
                                                        int $changed5 = ((432 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                                        RowScope $this$invoke_u24lambda_u2d1 = rowScope;
                                                        $composer6.startReplaceableGroup(951468004);
                                                        ComposerKt.sourceInformation($composer6, "C137@6222L9:Chip.kt#jmzs0o");
                                                        int $dirty3 = $changed5;
                                                        if (($changed5 & 14) == 0) {
                                                            $dirty3 |= $composer6.changed($this$invoke_u24lambda_u2d1) ? 4 : 2;
                                                        }
                                                        if (($dirty3 & 91) != 18 || !$composer6.getSkipping()) {
                                                            $composer6.startReplaceableGroup(2084788874);
                                                            ComposerKt.sourceInformation($composer6, "128@5675L47,129@5785L32,130@5842L267,135@6134L45");
                                                            if (function25 != null) {
                                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                                f2 = ChipKt.LeadingIconStartSpacing;
                                                                SpacerKt.Spacer(SizeKt.m805width3ABfNKs(companion, f2), $composer6, 6);
                                                                State leadingIconContentColor$delegate = chipColors4.leadingIconContentColor(z4, $composer6, ((i13 >> 6) & 14) | ((i13 >> 15) & SdkConfig.SDK_VERSION));
                                                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1986boximpl(m1307invoke$lambda1$lambda0(leadingIconContentColor$delegate))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1998getAlphaimpl(m1307invoke$lambda1$lambda0(leadingIconContentColor$delegate))))}, function25, $composer6, ((i13 >> 18) & SdkConfig.SDK_VERSION) | 8);
                                                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                                                f3 = ChipKt.LeadingIconEndSpacing;
                                                                SpacerKt.Spacer(SizeKt.m805width3ABfNKs(companion2, f3), $composer6, 6);
                                                            }
                                                            $composer6.endReplaceableGroup();
                                                            function33.invoke($this$invoke_u24lambda_u2d1, $composer6, Integer.valueOf(($dirty3 & 14) | ((i13 >> 21) & SdkConfig.SDK_VERSION)));
                                                        } else {
                                                            $composer6.skipToGroupEnd();
                                                        }
                                                        $composer6.endReplaceableGroup();
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

                                            /* renamed from: invoke$lambda-1$lambda-0, reason: not valid java name */
                                            private static final long m1307invoke$lambda1$lambda0(State<Color> state) {
                                                Object thisObj$iv = state.getValue();
                                                return ((Color) thisObj$iv).m2006unboximpl();
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
                }), $composer2, ($dirty & 14) | 805306368 | ($dirty & SdkConfig.SDK_VERSION) | ($dirty & 896) | (($dirty >> 3) & 7168) | (($dirty << 3) & 3670016) | (($dirty << 15) & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer3.skipToGroupEnd();
                modifier2 = modifier;
                enabled4 = enabled;
                colors4 = colors;
                leadingIcon = function2;
                interactionSource3 = interactionSource2;
                shape3 = shape2;
                border3 = border2;
                $composer2 = $composer3;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Modifier modifier4 = modifier2;
            final boolean z2 = enabled4;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            final Shape shape4 = shape3;
            final BorderStroke borderStroke = border3;
            final ChipColors chipColors2 = colors4;
            final Function2 function23 = leadingIcon;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$3
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
                    ChipKt.Chip(onClick, modifier4, z2, mutableInteractionSource, shape4, borderStroke, chipColors2, function23, content, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty2 |= i2;
        if ((191739611 & $dirty2) == 38347922) {
        }
        $composer3.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if ((i & 16) != 0) {
        }
        if (i8 != 0) {
        }
        if ((i & 64) == 0) {
        }
        if (i9 == 0) {
        }
        $composer3.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final State<Color> contentColor$delegate2 = colors3.contentColor(enabled3, $composer3, (($dirty >> 6) & 14) | (($dirty >> 15) & SdkConfig.SDK_VERSION));
        long m2006unboximpl2 = colors3.backgroundColor(enabled3, $composer3, (($dirty >> 6) & 14) | (($dirty >> 15) & SdkConfig.SDK_VERSION)).getValue().m2006unboximpl();
        m1994copywmQWz5c = Color.m1994copywmQWz5c(r21, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r21) : 1.0f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r21) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r21) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(m1305Chip$lambda1(contentColor$delegate2)) : 0.0f);
        final Function2<? super Composer, ? super Integer, Unit> function222 = leadingIcon;
        final ChipColors chipColors3 = colors3;
        final boolean z3 = enabled3;
        final int i102 = $dirty;
        colors4 = colors3;
        enabled4 = enabled3;
        $composer2 = $composer3;
        SurfaceKt.m1514SurfaceLPr_se0(onClick, modifier2, enabled3, shape3, m2006unboximpl2, m1994copywmQWz5c, border3, 0.0f, interactionSource3, ComposableLambdaKt.composableLambda($composer3, 139076687, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$2
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
                long m1305Chip$lambda1;
                ComposerKt.sourceInformation($composer4, "C109@4831L1442:Chip.kt#jmzs0o");
                if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(139076687, $changed2, -1, "androidx.compose.material.Chip.<anonymous> (Chip.kt:108)");
                    }
                    ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                    m1305Chip$lambda1 = ChipKt.m1305Chip$lambda1(contentColor$delegate2);
                    ProvidedValue[] providedValueArr = {localContentAlpha.provides(Float.valueOf(Color.m1998getAlphaimpl(m1305Chip$lambda1)))};
                    final Function2<? super Composer, ? super Integer, Unit> function232 = function222;
                    final ChipColors chipColors22 = chipColors3;
                    final boolean z22 = z3;
                    final int i11 = i102;
                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer4, 667535631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$2.1
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
                            ComposerKt.sourceInformation($composer5, "C111@4973L10,110@4917L1346:Chip.kt#jmzs0o");
                            if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(667535631, $changed3, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous> (Chip.kt:109)");
                                }
                                TextStyle body2 = MaterialTheme.INSTANCE.getTypography($composer5, 6).getBody2();
                                final Function2<? super Composer, ? super Integer, Unit> function24 = function232;
                                final ChipColors chipColors32 = chipColors22;
                                final boolean z32 = z22;
                                final int i12 = i11;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda($composer5, -1131213696, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.2.1.1
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
                                        float m4382constructorimpl;
                                        float f;
                                        float f2;
                                        float f3;
                                        float f4;
                                        ComposerKt.sourceInformation($composer6, "C113@5022L1227:Chip.kt#jmzs0o");
                                        if (($changed4 & 11) != 2 || !$composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1131213696, $changed4, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:112)");
                                            }
                                            Modifier m785defaultMinSizeVpY3zN4$default = SizeKt.m785defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, ChipDefaults.INSTANCE.m1300getMinHeightD9Ej5fM(), 1, null);
                                            if (function24 == null) {
                                                f4 = ChipKt.HorizontalPadding;
                                                m4382constructorimpl = f4;
                                            } else {
                                                m4382constructorimpl = C0504Dp.m4382constructorimpl(0);
                                            }
                                            f = ChipKt.HorizontalPadding;
                                            Modifier modifier$iv = PaddingKt.m763paddingqDBjuR0$default(m785defaultMinSizeVpY3zN4$default, m4382constructorimpl, 0.0f, f, 0.0f, 10, null);
                                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                                            Function2<Composer, Integer, Unit> function25 = function24;
                                            ChipColors chipColors4 = chipColors32;
                                            boolean z4 = z32;
                                            int i13 = i12;
                                            Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                            $composer6.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation($composer6, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer6, ((432 >> 3) & 14) | ((432 >> 3) & SdkConfig.SDK_VERSION));
                                            int $changed$iv$iv = (432 << 3) & SdkConfig.SDK_VERSION;
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
                                            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                                            $composer6.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation($composer6, "C80@3988L9:Row.kt#2w3rfo");
                                            if (($changed$iv & 11) == 2 && $composer6.getSkipping()) {
                                                $composer6.skipToGroupEnd();
                                            } else {
                                                RowScope rowScope = RowScopeInstance.INSTANCE;
                                                int $changed5 = ((432 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                                RowScope $this$invoke_u24lambda_u2d1 = rowScope;
                                                $composer6.startReplaceableGroup(951468004);
                                                ComposerKt.sourceInformation($composer6, "C137@6222L9:Chip.kt#jmzs0o");
                                                int $dirty3 = $changed5;
                                                if (($changed5 & 14) == 0) {
                                                    $dirty3 |= $composer6.changed($this$invoke_u24lambda_u2d1) ? 4 : 2;
                                                }
                                                if (($dirty3 & 91) != 18 || !$composer6.getSkipping()) {
                                                    $composer6.startReplaceableGroup(2084788874);
                                                    ComposerKt.sourceInformation($composer6, "128@5675L47,129@5785L32,130@5842L267,135@6134L45");
                                                    if (function25 != null) {
                                                        Modifier.Companion companion = Modifier.INSTANCE;
                                                        f2 = ChipKt.LeadingIconStartSpacing;
                                                        SpacerKt.Spacer(SizeKt.m805width3ABfNKs(companion, f2), $composer6, 6);
                                                        State leadingIconContentColor$delegate = chipColors4.leadingIconContentColor(z4, $composer6, ((i13 >> 6) & 14) | ((i13 >> 15) & SdkConfig.SDK_VERSION));
                                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1986boximpl(m1307invoke$lambda1$lambda0(leadingIconContentColor$delegate))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1998getAlphaimpl(m1307invoke$lambda1$lambda0(leadingIconContentColor$delegate))))}, function25, $composer6, ((i13 >> 18) & SdkConfig.SDK_VERSION) | 8);
                                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                                        f3 = ChipKt.LeadingIconEndSpacing;
                                                        SpacerKt.Spacer(SizeKt.m805width3ABfNKs(companion2, f3), $composer6, 6);
                                                    }
                                                    $composer6.endReplaceableGroup();
                                                    function33.invoke($this$invoke_u24lambda_u2d1, $composer6, Integer.valueOf(($dirty3 & 14) | ((i13 >> 21) & SdkConfig.SDK_VERSION)));
                                                } else {
                                                    $composer6.skipToGroupEnd();
                                                }
                                                $composer6.endReplaceableGroup();
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

                                    /* renamed from: invoke$lambda-1$lambda-0, reason: not valid java name */
                                    private static final long m1307invoke$lambda1$lambda0(State<Color> state) {
                                        Object thisObj$iv = state.getValue();
                                        return ((Color) thisObj$iv).m2006unboximpl();
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
        }), $composer2, ($dirty & 14) | 805306368 | ($dirty & SdkConfig.SDK_VERSION) | ($dirty & 896) | (($dirty >> 3) & 7168) | (($dirty << 3) & 3670016) | (($dirty << 15) & 234881024), 128);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Chip$lambda-1, reason: not valid java name */
    public static final long m1305Chip$lambda1(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m2006unboximpl();
    }

    @ExperimentalMaterialApi
    public static final void FilterChip(final boolean selected, final Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, Shape shape, BorderStroke border, SelectableChipColors colors, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        boolean enabled2;
        MutableInteractionSource interactionSource2;
        CornerBasedShape shape2;
        SelectableChipColors colors2;
        Function2 trailingIcon;
        Function2 leadingIcon;
        MutableInteractionSource interactionSource3;
        Shape shape3;
        Function2 selectedIcon;
        BorderStroke border2;
        SelectableChipColors colors3;
        boolean enabled3;
        int $dirty;
        Object value$iv$iv;
        long m1994copywmQWz5c;
        final SelectableChipColors colors4;
        final boolean enabled4;
        Modifier modifier4;
        Composer $composer2;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(-1259208246);
        ComposerKt.sourceInformation($composer3, "C(FilterChip)P(8,7,6,3,4,10!2,5,9,11)188@8670L39,189@8744L6,191@8871L18,198@9202L31,204@9413L34,199@9238L4010:Chip.kt#jmzs0o");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(selected) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer3.changed(onClick) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty2 |= $composer3.changed(interactionSource) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0 && $composer3.changed(shape)) {
                i3 = 131072;
                $dirty2 |= i3;
            }
            i3 = 65536;
            $dirty2 |= i3;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty2 |= $composer3.changed(border) ? 1048576 : 524288;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0 && $composer3.changed(colors)) {
                i2 = 8388608;
                $dirty2 |= i2;
            }
            i2 = 4194304;
            $dirty2 |= i2;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer3.changed(function2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty2 |= $composer3.changed(function22) ? 536870912 : 268435456;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changed(function23) ? 4 : 2;
        }
        if ((i & 2048) != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & SdkConfig.SDK_VERSION) == 0) {
            $dirty1 |= $composer3.changed(content) ? 32 : 16;
        }
        final int $dirty12 = $dirty1;
        if ((1533916891 & $dirty2) == 306783378 && ($dirty12 & 91) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            enabled4 = enabled;
            interactionSource3 = interactionSource;
            shape3 = shape;
            border2 = border;
            colors4 = colors;
            leadingIcon = function2;
            selectedIcon = function22;
            trailingIcon = function23;
            modifier4 = modifier2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled5 = i5 != 0 ? true : enabled;
                if (i6 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    modifier3 = modifier5;
                    Object it$iv$iv = $composer3.rememberedValue();
                    enabled2 = enabled5;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    modifier3 = modifier5;
                    enabled2 = enabled5;
                    interactionSource2 = interactionSource;
                }
                if ((i & 32) != 0) {
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    $dirty2 &= -458753;
                } else {
                    shape2 = shape;
                }
                BorderStroke border3 = i7 != 0 ? null : border;
                if ((i & 128) != 0) {
                    colors2 = ChipDefaults.INSTANCE.m1298filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 805306368, FrameMetricsAggregator.EVERY_DURATION);
                    $dirty2 &= -29360129;
                } else {
                    colors2 = colors;
                }
                Function2 leadingIcon2 = i8 != 0 ? null : function2;
                Function2 selectedIcon2 = i9 != 0 ? null : function22;
                if (i10 != 0) {
                    leadingIcon = leadingIcon2;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                    selectedIcon = selectedIcon2;
                    trailingIcon = null;
                    border2 = border3;
                    colors3 = colors2;
                    modifier2 = modifier3;
                    enabled3 = enabled2;
                    $dirty = $dirty2;
                } else {
                    trailingIcon = function23;
                    leadingIcon = leadingIcon2;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                    selectedIcon = selectedIcon2;
                    border2 = border3;
                    colors3 = colors2;
                    modifier2 = modifier3;
                    enabled3 = enabled2;
                    $dirty = $dirty2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 128) != 0) {
                    enabled3 = enabled;
                    interactionSource3 = interactionSource;
                    shape3 = shape;
                    border2 = border;
                    colors3 = colors;
                    leadingIcon = function2;
                    selectedIcon = function22;
                    trailingIcon = function23;
                    $dirty = $dirty2 & (-29360129);
                } else {
                    enabled3 = enabled;
                    interactionSource3 = interactionSource;
                    shape3 = shape;
                    border2 = border;
                    colors3 = colors;
                    leadingIcon = function2;
                    selectedIcon = function22;
                    trailingIcon = function23;
                    $dirty = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1259208246, $dirty, $dirty12, "androidx.compose.material.FilterChip (Chip.kt:183)");
            }
            final State contentColor = colors3.contentColor(enabled3, selected, $composer3, (($dirty >> 9) & 14) | (($dirty << 3) & SdkConfig.SDK_VERSION) | (($dirty >> 15) & 896));
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    SemanticsPropertiesKt.m3845setRolekuIjeqM(semantics, Role.INSTANCE.m3833getCheckboxo7Vup1c());
                }
            }, 1, null);
            long m2006unboximpl = colors3.backgroundColor(enabled3, selected, $composer3, (($dirty >> 9) & 14) | (($dirty << 3) & SdkConfig.SDK_VERSION) | (($dirty >> 15) & 896)).getValue().m2006unboximpl();
            m1994copywmQWz5c = Color.m1994copywmQWz5c(r0, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r0) : 1.0f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r0) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r0) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(contentColor.getValue().m2006unboximpl()) : 0.0f);
            final Function2 function24 = leadingIcon;
            final int $dirty3 = $dirty;
            final Function2 function25 = selectedIcon;
            colors4 = colors3;
            final Function2 function26 = trailingIcon;
            enabled4 = enabled3;
            modifier4 = modifier2;
            $composer2 = $composer3;
            SurfaceKt.m1515SurfaceNy5ogXk(selected, onClick, semantics$default, false, shape3, m2006unboximpl, m1994copywmQWz5c, border2, 0.0f, interactionSource3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer3, 722126431, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$3
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
                    ComposerKt.sourceInformation($composer4, "C209@9597L3645:Chip.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(722126431, $changed2, -1, "androidx.compose.material.FilterChip.<anonymous> (Chip.kt:208)");
                        }
                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1998getAlphaimpl(contentColor.getValue().m2006unboximpl())))};
                        final Function2<Composer, Integer, Unit> function27 = function24;
                        final boolean z = selected;
                        final Function2<Composer, Integer, Unit> function28 = function25;
                        final Function2<Composer, Integer, Unit> function29 = function26;
                        final Function3<RowScope, Composer, Integer, Unit> function3 = content;
                        final int i11 = $dirty12;
                        final SelectableChipColors selectableChipColors = colors4;
                        final boolean z2 = enabled4;
                        final int i12 = $dirty3;
                        final State<Color> state = contentColor;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer4, 1582291359, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$3.1
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
                                ComposerKt.sourceInformation($composer5, "C211@9745L10,210@9689L3543:Chip.kt#jmzs0o");
                                if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1582291359, $changed3, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous> (Chip.kt:209)");
                                    }
                                    TextStyle body2 = MaterialTheme.INSTANCE.getTypography($composer5, 6).getBody2();
                                    final Function2<Composer, Integer, Unit> function210 = function27;
                                    final boolean z3 = z;
                                    final Function2<Composer, Integer, Unit> function211 = function28;
                                    final Function2<Composer, Integer, Unit> function212 = function29;
                                    final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                    final int i13 = i11;
                                    final SelectableChipColors selectableChipColors2 = selectableChipColors;
                                    final boolean z4 = z2;
                                    final int i14 = i12;
                                    final State<Color> state2 = state;
                                    TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda($composer5, -1543702066, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.3.1.1
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
                                            float m4382constructorimpl;
                                            float m4382constructorimpl2;
                                            float f;
                                            Composer $composer$iv;
                                            RowScope $this$invoke_u24lambda_u2d2;
                                            int $dirty4;
                                            float f2;
                                            float f3;
                                            float f4;
                                            float f5;
                                            float f6;
                                            float f7;
                                            ComposerKt.sourceInformation($composer6, "C213@9794L3424:Chip.kt#jmzs0o");
                                            if (($changed4 & 11) != 2 || !$composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1543702066, $changed4, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:212)");
                                                }
                                                Modifier m785defaultMinSizeVpY3zN4$default = SizeKt.m785defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, ChipDefaults.INSTANCE.m1300getMinHeightD9Ej5fM(), 1, null);
                                                if (function210 == null && (!z3 || function211 == null)) {
                                                    f7 = ChipKt.HorizontalPadding;
                                                    m4382constructorimpl = f7;
                                                } else {
                                                    m4382constructorimpl = C0504Dp.m4382constructorimpl(0);
                                                }
                                                if (function212 == null) {
                                                    f6 = ChipKt.HorizontalPadding;
                                                    m4382constructorimpl2 = f6;
                                                } else {
                                                    m4382constructorimpl2 = C0504Dp.m4382constructorimpl(0);
                                                }
                                                Modifier modifier$iv = PaddingKt.m763paddingqDBjuR0$default(m785defaultMinSizeVpY3zN4$default, m4382constructorimpl, 0.0f, m4382constructorimpl2, 0.0f, 10, null);
                                                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                                                Function2<Composer, Integer, Unit> function213 = function210;
                                                boolean z5 = z3;
                                                Function2<Composer, Integer, Unit> function214 = function211;
                                                Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                                int i15 = i13;
                                                Function2<Composer, Integer, Unit> function215 = function212;
                                                SelectableChipColors selectableChipColors3 = selectableChipColors2;
                                                boolean z6 = z4;
                                                int i16 = i14;
                                                State<Color> state3 = state2;
                                                $composer6.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation($composer6, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer6, ((432 >> 3) & 14) | ((432 >> 3) & SdkConfig.SDK_VERSION));
                                                int $changed$iv$iv = (432 << 3) & SdkConfig.SDK_VERSION;
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
                                                int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                                                $composer6.startReplaceableGroup(-678309503);
                                                ComposerKt.sourceInformation($composer6, "C80@3988L9:Row.kt#2w3rfo");
                                                if (($changed$iv & 11) == 2 && $composer6.getSkipping()) {
                                                    $composer6.skipToGroupEnd();
                                                    $composer$iv = $composer6;
                                                } else {
                                                    RowScope rowScope = RowScopeInstance.INSTANCE;
                                                    int $changed5 = ((432 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                                    RowScope $this$invoke_u24lambda_u2d22 = rowScope;
                                                    $composer6.startReplaceableGroup(1218705642);
                                                    ComposerKt.sourceInformation($composer6, "C275@12946L9,277@13028L43,278@13096L14,279@13135L43:Chip.kt#jmzs0o");
                                                    int $dirty5 = $changed5;
                                                    if (($changed5 & 14) == 0) {
                                                        $dirty5 |= $composer6.changed($this$invoke_u24lambda_u2d22) ? 4 : 2;
                                                    }
                                                    if (($dirty5 & 91) != 18 || !$composer6.getSkipping()) {
                                                        $composer6.startReplaceableGroup(-1943412137);
                                                        ComposerKt.sourceInformation($composer6, "236@10806L47,237@10878L1955,273@12858L45");
                                                        if (function213 != null || (z5 && function214 != null)) {
                                                            Modifier.Companion companion = Modifier.INSTANCE;
                                                            f = ChipKt.LeadingIconStartSpacing;
                                                            SpacerKt.Spacer(SizeKt.m805width3ABfNKs(companion, f), $composer6, 6);
                                                            $composer6.startReplaceableGroup(733328855);
                                                            ComposerKt.sourceInformation($composer6, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                            Modifier modifier$iv2 = Modifier.INSTANCE;
                                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                            $composer$iv = $composer6;
                                                            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer6, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                                                            int $changed$iv$iv2 = (0 << 3) & SdkConfig.SDK_VERSION;
                                                            $composer6.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation($composer6, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                                            ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object consume4 = $composer6.consume(localDensity2);
                                                            ComposerKt.sourceInformationMarkerEnd($composer6);
                                                            Density density$iv$iv2 = (Density) consume4;
                                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                                            $this$invoke_u24lambda_u2d2 = $this$invoke_u24lambda_u2d22;
                                                            ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object consume5 = $composer6.consume(localLayoutDirection2);
                                                            ComposerKt.sourceInformationMarkerEnd($composer6);
                                                            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                                            $dirty4 = $dirty5;
                                                            ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object consume6 = $composer6.consume(localViewConfiguration2);
                                                            ComposerKt.sourceInformationMarkerEnd($composer6);
                                                            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                                                            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                                                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                                                            if (!($composer6.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            $composer6.startReusableNode();
                                                            if ($composer6.getInserting()) {
                                                                $composer6.createNode(factory$iv$iv$iv2);
                                                            } else {
                                                                $composer6.useNode();
                                                            }
                                                            $composer6.disableReusing();
                                                            Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer6);
                                                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                                                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                            $composer6.enableReusing();
                                                            skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer6)), $composer6, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                                                            $composer6.startReplaceableGroup(2058660585);
                                                            int $changed$iv2 = ($changed$iv$iv$iv2 >> 9) & 14;
                                                            $composer6.startReplaceableGroup(-2137368960);
                                                            ComposerKt.sourceInformation($composer6, "C72@3384L9:Box.kt#2w3rfo");
                                                            if (($changed$iv2 & 11) == 2 && $composer6.getSkipping()) {
                                                                $composer6.skipToGroupEnd();
                                                            } else {
                                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                int $changed6 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                                                $composer6.startReplaceableGroup(-626917591);
                                                                ComposerKt.sourceInformation($composer6, "C:Chip.kt#jmzs0o");
                                                                if (($changed6 & 81) != 16 || !$composer6.getSkipping()) {
                                                                    $composer6.startReplaceableGroup(649985595);
                                                                    ComposerKt.sourceInformation($composer6, "239@11001L141,243@11175L297");
                                                                    if (function213 != null) {
                                                                        State leadingIconColor = selectableChipColors3.leadingIconColor(z6, z5, $composer6, ((i16 >> 9) & 14) | ((i16 << 3) & SdkConfig.SDK_VERSION) | ((i16 >> 15) & 896));
                                                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(leadingIconColor.getValue()), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1998getAlphaimpl(leadingIconColor.getValue().m2006unboximpl())))}, function213, $composer6, ((i16 >> 21) & SdkConfig.SDK_VERSION) | 8);
                                                                    }
                                                                    $composer6.endReplaceableGroup();
                                                                    $composer6.startReplaceableGroup(-1943411323);
                                                                    ComposerKt.sourceInformation($composer6, "262@12326L451");
                                                                    if (z5 && function214 != null) {
                                                                        Modifier overlayModifier = Modifier.INSTANCE;
                                                                        long iconColor = state3.getValue().m2006unboximpl();
                                                                        $composer6.startReplaceableGroup(649986426);
                                                                        ComposerKt.sourceInformation($composer6, "260@12219L34");
                                                                        if (function213 != null) {
                                                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                                                            f2 = ChipKt.SelectedIconContainerSize;
                                                                            overlayModifier = ClipKt.clip(BackgroundKt.m494backgroundbw27NRU(SizeKt.m792requiredSize3ABfNKs(companion2, f2), state3.getValue().m2006unboximpl(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                                                                            iconColor = selectableChipColors3.backgroundColor(z6, z5, $composer6, ((i16 >> 9) & 14) | ((i16 << 3) & SdkConfig.SDK_VERSION) | ((i16 >> 15) & 896)).getValue().m2006unboximpl();
                                                                        }
                                                                        $composer6.endReplaceableGroup();
                                                                        Alignment contentAlignment$iv2 = Alignment.INSTANCE.getCenter();
                                                                        $composer6.startReplaceableGroup(733328855);
                                                                        ComposerKt.sourceInformation($composer6, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                                        MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer6, ((48 >> 3) & 14) | ((48 >> 3) & SdkConfig.SDK_VERSION));
                                                                        int $changed$iv$iv3 = (48 << 3) & SdkConfig.SDK_VERSION;
                                                                        $composer6.startReplaceableGroup(-1323940314);
                                                                        ComposerKt.sourceInformation($composer6, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                                                        ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                                        Object consume7 = $composer6.consume(localDensity3);
                                                                        ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                        Density density$iv$iv3 = (Density) consume7;
                                                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                                                                        ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                                        Object consume8 = $composer6.consume(localLayoutDirection3);
                                                                        ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                        LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume8;
                                                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                                                        ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                                        Object consume9 = $composer6.consume(localViewConfiguration3);
                                                                        ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                        ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume9;
                                                                        Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
                                                                        Function3 skippableUpdate$iv$iv$iv3 = LayoutKt.materializerOf(overlayModifier);
                                                                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 9) & 7168) | 6;
                                                                        if (!($composer6.getApplier() instanceof Applier)) {
                                                                            ComposablesKt.invalidApplier();
                                                                        }
                                                                        $composer6.startReusableNode();
                                                                        if ($composer6.getInserting()) {
                                                                            $composer6.createNode(factory$iv$iv$iv3);
                                                                        } else {
                                                                            $composer6.useNode();
                                                                        }
                                                                        $composer6.disableReusing();
                                                                        Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m1639constructorimpl($composer6);
                                                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.INSTANCE.getSetDensity());
                                                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                                        $composer6.enableReusing();
                                                                        skippableUpdate$iv$iv$iv3.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer6)), $composer6, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & SdkConfig.SDK_VERSION));
                                                                        $composer6.startReplaceableGroup(2058660585);
                                                                        int $changed$iv3 = ($changed$iv$iv$iv3 >> 9) & 14;
                                                                        $composer6.startReplaceableGroup(-2137368960);
                                                                        ComposerKt.sourceInformation($composer6, "C72@3384L9:Box.kt#2w3rfo");
                                                                        if (($changed$iv3 & 11) == 2 && $composer6.getSkipping()) {
                                                                            $composer6.skipToGroupEnd();
                                                                        } else {
                                                                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                                                            int $changed7 = ((48 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                                                            $composer6.startReplaceableGroup(-370889391);
                                                                            ComposerKt.sourceInformation($composer6, "C266@12539L204:Chip.kt#jmzs0o");
                                                                            if (($changed7 & 81) != 16 || !$composer6.getSkipping()) {
                                                                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1986boximpl(iconColor))}, function214, $composer6, ((i16 >> 24) & SdkConfig.SDK_VERSION) | 8);
                                                                            } else {
                                                                                $composer6.skipToGroupEnd();
                                                                            }
                                                                            $composer6.endReplaceableGroup();
                                                                        }
                                                                        $composer6.endReplaceableGroup();
                                                                        $composer6.endReplaceableGroup();
                                                                        $composer6.endNode();
                                                                        $composer6.endReplaceableGroup();
                                                                        $composer6.endReplaceableGroup();
                                                                    }
                                                                    $composer6.endReplaceableGroup();
                                                                } else {
                                                                    $composer6.skipToGroupEnd();
                                                                }
                                                                $composer6.endReplaceableGroup();
                                                            }
                                                            $composer6.endReplaceableGroup();
                                                            $composer6.endReplaceableGroup();
                                                            $composer6.endNode();
                                                            $composer6.endReplaceableGroup();
                                                            $composer6.endReplaceableGroup();
                                                            Modifier.Companion companion3 = Modifier.INSTANCE;
                                                            f3 = ChipKt.LeadingIconEndSpacing;
                                                            SpacerKt.Spacer(SizeKt.m805width3ABfNKs(companion3, f3), $composer6, 6);
                                                        } else {
                                                            $composer$iv = $composer6;
                                                            $this$invoke_u24lambda_u2d2 = $this$invoke_u24lambda_u2d22;
                                                            $dirty4 = $dirty5;
                                                        }
                                                        $composer6.endReplaceableGroup();
                                                        function33.invoke($this$invoke_u24lambda_u2d2, $composer6, Integer.valueOf(($dirty4 & 14) | (i15 & SdkConfig.SDK_VERSION)));
                                                        if (function215 != null) {
                                                            Modifier.Companion companion4 = Modifier.INSTANCE;
                                                            f4 = ChipKt.TrailingIconSpacing;
                                                            SpacerKt.Spacer(SizeKt.m805width3ABfNKs(companion4, f4), $composer6, 6);
                                                            function215.invoke($composer6, Integer.valueOf(i15 & 14));
                                                            Modifier.Companion companion5 = Modifier.INSTANCE;
                                                            f5 = ChipKt.TrailingIconSpacing;
                                                            SpacerKt.Spacer(SizeKt.m805width3ABfNKs(companion5, f5), $composer6, 6);
                                                        }
                                                    } else {
                                                        $composer6.skipToGroupEnd();
                                                        $composer$iv = $composer6;
                                                    }
                                                    $composer6.endReplaceableGroup();
                                                }
                                                $composer$iv.endReplaceableGroup();
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
            }), $composer2, ($dirty3 & 14) | ($dirty3 & SdkConfig.SDK_VERSION) | (($dirty3 >> 3) & 57344) | (($dirty3 << 3) & 29360128) | (($dirty3 << 15) & 1879048192), 6, 264);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier4;
        final boolean z = enabled4;
        final MutableInteractionSource mutableInteractionSource = interactionSource3;
        final Shape shape4 = shape3;
        final BorderStroke borderStroke = border2;
        final SelectableChipColors selectableChipColors = colors4;
        final Function2 function27 = leadingIcon;
        final Function2 function28 = selectedIcon;
        final Function2 function29 = trailingIcon;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$4
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
                ChipKt.FilterChip(selected, onClick, modifier6, z, mutableInteractionSource, shape4, borderStroke, selectableChipColors, function27, function28, function29, content, composer, $changed | 1, $changed1, i);
            }
        });
    }
}
