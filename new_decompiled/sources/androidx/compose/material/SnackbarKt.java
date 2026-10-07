package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.layout.AlignmentLineKt;
import androidx.compose.p000ui.layout.LayoutIdKt;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Constraints;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.health.platform.client.SdkConfig;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Snackbar.kt */
@Metadata(m286d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a3\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001a3\u0010\u0012\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001ac\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u0001H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a{\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u00012\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a \u0010&\u001a\u00020\f2\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010'\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\n\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006("}, m287d2 = {"HeightToFirstLine", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarMinHeightOneLine", "SnackbarMinHeightTwoLines", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "Snackbar", "snackbarData", "Landroidx/compose/material/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "actionColor", "elevation", "Snackbar-sPrSdHI", "(Landroidx/compose/material/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJFLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-7zSek6w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TextOnlySnackbar", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SnackbarKt {
    private static final float HeightToFirstLine = C0504Dp.m4382constructorimpl(30);
    private static final float HorizontalSpacing = C0504Dp.m4382constructorimpl(16);
    private static final float HorizontalSpacingButtonSide = C0504Dp.m4382constructorimpl(8);
    private static final float SeparateButtonExtraY = C0504Dp.m4382constructorimpl(2);
    private static final float SnackbarVerticalPadding = C0504Dp.m4382constructorimpl(6);
    private static final float TextEndExtraSpacing = C0504Dp.m4382constructorimpl(8);
    private static final float LongButtonVerticalOffset = C0504Dp.m4382constructorimpl(12);
    private static final float SnackbarMinHeightOneLine = C0504Dp.m4382constructorimpl(48);
    private static final float SnackbarMinHeightTwoLines = C0504Dp.m4382constructorimpl(68);

    /* JADX WARN: Removed duplicated region for block: B:48:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016c  */
    /* renamed from: Snackbar-7zSek6w, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1495Snackbar7zSek6w(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, boolean actionOnNewLine, Shape shape, long backgroundColor, long contentColor, float elevation, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        final Function2 action;
        final boolean actionOnNewLine2;
        Shape shape2;
        long backgroundColor2;
        int $dirty;
        float f;
        int $dirty2;
        Modifier.Companion modifier2;
        long contentColor2;
        final int $dirty3;
        float elevation2;
        long contentColor3;
        float elevation3;
        Modifier modifier3;
        long contentColor4;
        Function2 action2;
        boolean actionOnNewLine3;
        Shape shape3;
        long backgroundColor3;
        ScopeUpdateScope endRestartGroup;
        int i2;
        int $dirty4;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-558258760);
        ComposerKt.sourceInformation($composer2, "C(Snackbar)P(6!2,7,2:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.unit.Dp)84@3955L6,85@4015L15,86@4072L6,90@4158L631:Snackbar.kt#jmzs0o");
        int $dirty5 = $changed;
        int i6 = i & 1;
        if (i6 != 0) {
            $dirty5 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty5 |= $composer2.changed(modifier) ? 4 : 2;
        }
        int i7 = i & 2;
        if (i7 != 0) {
            $dirty5 |= 48;
            action = function2;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            action = function2;
            $dirty5 |= $composer2.changed(action) ? 32 : 16;
        } else {
            action = function2;
        }
        int i8 = i & 4;
        if (i8 != 0) {
            $dirty5 |= 384;
            actionOnNewLine2 = actionOnNewLine;
        } else if (($changed & 896) == 0) {
            actionOnNewLine2 = actionOnNewLine;
            $dirty5 |= $composer2.changed(actionOnNewLine2) ? 256 : 128;
        } else {
            actionOnNewLine2 = actionOnNewLine;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                shape2 = shape;
                if ($composer2.changed(shape2)) {
                    i5 = 2048;
                    $dirty5 |= i5;
                }
            } else {
                shape2 = shape;
            }
            i5 = 1024;
            $dirty5 |= i5;
        } else {
            shape2 = shape;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                backgroundColor2 = backgroundColor;
                if ($composer2.changed(backgroundColor2)) {
                    i4 = 16384;
                    $dirty5 |= i4;
                }
            } else {
                backgroundColor2 = backgroundColor;
            }
            i4 = 8192;
            $dirty5 |= i4;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                $dirty4 = $dirty5;
                if ($composer2.changed(contentColor)) {
                    i3 = 131072;
                    $dirty = $dirty4 | i3;
                }
            } else {
                $dirty4 = $dirty5;
            }
            i3 = 65536;
            $dirty = $dirty4 | i3;
        } else {
            $dirty = $dirty5;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty |= 1572864;
            f = elevation;
        } else if (($changed & 3670016) == 0) {
            f = elevation;
            $dirty |= $composer2.changed(f) ? 1048576 : 524288;
        } else {
            f = elevation;
        }
        if ((i & 128) == 0) {
            i2 = (29360128 & $changed) == 0 ? $composer2.changed(content) ? 8388608 : 4194304 : 12582912;
            $dirty2 = $dirty;
            if ((23967451 & $dirty2) == 4793490 || !$composer2.getSkipping()) {
                $composer2.startDefaults();
                if (($changed & 1) != 0 || $composer2.getDefaultsInvalid()) {
                    modifier2 = i6 == 0 ? Modifier.INSTANCE : modifier;
                    if (i7 != 0) {
                        action = null;
                    }
                    if (i8 != 0) {
                        actionOnNewLine2 = false;
                    }
                    if ((i & 8) != 0) {
                        $dirty2 &= -7169;
                        shape2 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getSmall();
                    }
                    if ((i & 16) != 0) {
                        backgroundColor2 = SnackbarDefaults.INSTANCE.getBackgroundColor($composer2, 6);
                        $dirty2 &= -57345;
                    }
                    if ((i & 32) == 0) {
                        contentColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1321getSurface0d7_KjU();
                        $dirty2 &= -458753;
                    } else {
                        contentColor2 = contentColor;
                    }
                    if (i9 == 0) {
                        $dirty3 = $dirty2;
                        elevation2 = C0504Dp.m4382constructorimpl(6);
                        contentColor3 = contentColor2;
                    } else {
                        $dirty3 = $dirty2;
                        elevation2 = f;
                        contentColor3 = contentColor2;
                    }
                } else {
                    $composer2.skipToGroupEnd();
                    if ((i & 8) != 0) {
                        $dirty2 &= -7169;
                    }
                    if ((i & 16) != 0) {
                        $dirty2 &= -57345;
                    }
                    if ((i & 32) != 0) {
                        $dirty2 &= -458753;
                    }
                    modifier2 = modifier;
                    contentColor3 = contentColor;
                    $dirty3 = $dirty2;
                    elevation2 = f;
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-558258760, $dirty3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:80)");
                }
                SurfaceKt.m1513SurfaceFjzlyU(modifier2, shape2, backgroundColor2, contentColor3, null, elevation2, ComposableLambdaKt.composableLambda($composer2, -2084221700, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1
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

                    public final void invoke(Composer $composer3, int $changed2) {
                        ComposerKt.sourceInformation($composer3, "C97@4400L4,97@4335L448:Snackbar.kt#jmzs0o");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2084221700, $changed2, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:96)");
                            }
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh($composer3, 6)))};
                            final Function2<Composer, Integer, Unit> function22 = action;
                            final Function2<Composer, Integer, Unit> function23 = content;
                            final int i10 = $dirty3;
                            final boolean z = actionOnNewLine2;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer3, 1939362236, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1.1
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

                                public final void invoke(Composer $composer4, int $changed3) {
                                    ComposerKt.sourceInformation($composer4, "C98@4450L10,99@4479L294:Snackbar.kt#jmzs0o");
                                    if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1939362236, $changed3, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:97)");
                                        }
                                        TextStyle textStyle = MaterialTheme.INSTANCE.getTypography($composer4, 6).getBody2();
                                        final Function2<Composer, Integer, Unit> function24 = function22;
                                        final Function2<Composer, Integer, Unit> function25 = function23;
                                        final int i11 = i10;
                                        final boolean z2 = z;
                                        TextKt.ProvideTextStyle(textStyle, ComposableLambdaKt.composableLambda($composer4, 225114541, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.Snackbar.1.1.1
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

                                            public final void invoke(Composer $composer5, int $changed4) {
                                                ComposerKt.sourceInformation($composer5, "C:Snackbar.kt#jmzs0o");
                                                if (($changed4 & 11) != 2 || !$composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(225114541, $changed4, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous>.<anonymous> (Snackbar.kt:99)");
                                                    }
                                                    if (function24 == null) {
                                                        $composer5.startReplaceableGroup(59708346);
                                                        ComposerKt.sourceInformation($composer5, "101@4578L25");
                                                        SnackbarKt.TextOnlySnackbar(function25, $composer5, (i11 >> 21) & 14);
                                                        $composer5.endReplaceableGroup();
                                                    } else if (z2) {
                                                        $composer5.startReplaceableGroup(59708411);
                                                        ComposerKt.sourceInformation($composer5, "102@4643L38");
                                                        SnackbarKt.NewLineButtonSnackbar(function25, function24, $composer5, ((i11 >> 21) & 14) | (i11 & SdkConfig.SDK_VERSION));
                                                        $composer5.endReplaceableGroup();
                                                    } else {
                                                        $composer5.startReplaceableGroup(59708478);
                                                        ComposerKt.sourceInformation($composer5, "103@4710L31");
                                                        SnackbarKt.OneRowSnackbar(function25, function24, $composer5, ((i11 >> 21) & 14) | (i11 & SdkConfig.SDK_VERSION));
                                                        $composer5.endReplaceableGroup();
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer5.skipToGroupEnd();
                                            }
                                        }), $composer4, 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer4.skipToGroupEnd();
                                }
                            }), $composer3, 56);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }), $composer2, ($dirty3 & 14) | 1572864 | (($dirty3 >> 6) & SdkConfig.SDK_VERSION) | (($dirty3 >> 6) & 896) | (($dirty3 >> 6) & 7168) | (($dirty3 >> 3) & 458752), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                elevation3 = elevation2;
                modifier3 = modifier2;
                contentColor4 = contentColor3;
                action2 = action;
                actionOnNewLine3 = actionOnNewLine2;
                shape3 = shape2;
                backgroundColor3 = backgroundColor2;
            } else {
                $composer2.skipToGroupEnd();
                contentColor4 = contentColor;
                action2 = action;
                actionOnNewLine3 = actionOnNewLine2;
                shape3 = shape2;
                backgroundColor3 = backgroundColor2;
                elevation3 = f;
                modifier3 = modifier;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Modifier modifier4 = modifier3;
            final Function2 function22 = action2;
            final boolean z = actionOnNewLine3;
            final Shape shape4 = shape3;
            final long j = backgroundColor3;
            final long j2 = contentColor4;
            final float f2 = elevation3;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$2
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

                public final void invoke(Composer composer, int i10) {
                    SnackbarKt.m1495Snackbar7zSek6w(Modifier.this, function22, z, shape4, j, j2, f2, content, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty |= i2;
        $dirty2 = $dirty;
        if ((23967451 & $dirty2) == 4793490) {
        }
        $composer2.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i6 == 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if ((i & 8) != 0) {
        }
        if ((i & 16) != 0) {
        }
        if ((i & 32) == 0) {
        }
        if (i9 == 0) {
        }
        $composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        SurfaceKt.m1513SurfaceFjzlyU(modifier2, shape2, backgroundColor2, contentColor3, null, elevation2, ComposableLambdaKt.composableLambda($composer2, -2084221700, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1
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

            public final void invoke(Composer $composer3, int $changed2) {
                ComposerKt.sourceInformation($composer3, "C97@4400L4,97@4335L448:Snackbar.kt#jmzs0o");
                if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2084221700, $changed2, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:96)");
                    }
                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh($composer3, 6)))};
                    final Function2<? super Composer, ? super Integer, Unit> function222 = action;
                    final Function2<? super Composer, ? super Integer, Unit> function23 = content;
                    final int i10 = $dirty3;
                    final boolean z2 = actionOnNewLine2;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer3, 1939362236, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1.1
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

                        public final void invoke(Composer $composer4, int $changed3) {
                            ComposerKt.sourceInformation($composer4, "C98@4450L10,99@4479L294:Snackbar.kt#jmzs0o");
                            if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1939362236, $changed3, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:97)");
                                }
                                TextStyle textStyle = MaterialTheme.INSTANCE.getTypography($composer4, 6).getBody2();
                                final Function2<? super Composer, ? super Integer, Unit> function24 = function222;
                                final Function2<? super Composer, ? super Integer, Unit> function25 = function23;
                                final int i11 = i10;
                                final boolean z22 = z2;
                                TextKt.ProvideTextStyle(textStyle, ComposableLambdaKt.composableLambda($composer4, 225114541, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.Snackbar.1.1.1
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

                                    public final void invoke(Composer $composer5, int $changed4) {
                                        ComposerKt.sourceInformation($composer5, "C:Snackbar.kt#jmzs0o");
                                        if (($changed4 & 11) != 2 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(225114541, $changed4, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous>.<anonymous> (Snackbar.kt:99)");
                                            }
                                            if (function24 == null) {
                                                $composer5.startReplaceableGroup(59708346);
                                                ComposerKt.sourceInformation($composer5, "101@4578L25");
                                                SnackbarKt.TextOnlySnackbar(function25, $composer5, (i11 >> 21) & 14);
                                                $composer5.endReplaceableGroup();
                                            } else if (z22) {
                                                $composer5.startReplaceableGroup(59708411);
                                                ComposerKt.sourceInformation($composer5, "102@4643L38");
                                                SnackbarKt.NewLineButtonSnackbar(function25, function24, $composer5, ((i11 >> 21) & 14) | (i11 & SdkConfig.SDK_VERSION));
                                                $composer5.endReplaceableGroup();
                                            } else {
                                                $composer5.startReplaceableGroup(59708478);
                                                ComposerKt.sourceInformation($composer5, "103@4710L31");
                                                SnackbarKt.OneRowSnackbar(function25, function24, $composer5, ((i11 >> 21) & 14) | (i11 & SdkConfig.SDK_VERSION));
                                                $composer5.endReplaceableGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), $composer4, 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer4.skipToGroupEnd();
                        }
                    }), $composer3, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer3.skipToGroupEnd();
            }
        }), $composer2, ($dirty3 & 14) | 1572864 | (($dirty3 >> 6) & SdkConfig.SDK_VERSION) | (($dirty3 >> 6) & 896) | (($dirty3 >> 6) & 7168) | (($dirty3 >> 3) & 458752), 16);
        if (ComposerKt.isTraceInProgress()) {
        }
        elevation3 = elevation2;
        modifier3 = modifier2;
        contentColor4 = contentColor3;
        action2 = action;
        actionOnNewLine3 = actionOnNewLine2;
        shape3 = shape2;
        backgroundColor3 = backgroundColor2;
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* renamed from: Snackbar-sPrSdHI, reason: not valid java name */
    public static final void m1496SnackbarsPrSdHI(final SnackbarData snackbarData, Modifier modifier, boolean actionOnNewLine, Shape shape, long backgroundColor, long contentColor, long actionColor, float elevation, Composer $composer, final int $changed, final int i) {
        boolean z;
        Shape shape2;
        long contentColor2;
        long actionColor2;
        Modifier.Companion modifier2;
        boolean actionOnNewLine2;
        CornerBasedShape shape3;
        long backgroundColor2;
        long actionColor3;
        float elevation2;
        long actionColor4;
        long actionColor5;
        Function2 actionComposable;
        long actionColor6;
        Modifier modifier3;
        boolean actionOnNewLine3;
        float elevation3;
        Shape shape4;
        long backgroundColor3;
        long contentColor3;
        int i2;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(snackbarData, "snackbarData");
        Composer $composer2 = $composer.startRestartGroup(258660814);
        ComposerKt.sourceInformation($composer2, "C(Snackbar)P(7,5,1,6,2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,4:c#ui.unit.Dp)155@7132L6,156@7192L15,157@7249L6,158@7307L18,173@7784L320:Snackbar.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(snackbarData) ? 4 : 2;
        }
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i7 = i & 4;
        if (i7 != 0) {
            $dirty |= 384;
            z = actionOnNewLine;
        } else if (($changed & 896) == 0) {
            z = actionOnNewLine;
            $dirty |= $composer2.changed(z) ? 256 : 128;
        } else {
            z = actionOnNewLine;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                shape2 = shape;
                if ($composer2.changed(shape2)) {
                    i5 = 2048;
                    $dirty |= i5;
                }
            } else {
                shape2 = shape;
            }
            i5 = 1024;
            $dirty |= i5;
        } else {
            shape2 = shape;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0 && $composer2.changed(backgroundColor)) {
                i4 = 16384;
                $dirty |= i4;
            }
            i4 = 8192;
            $dirty |= i4;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i3 = 131072;
                    $dirty |= i3;
                }
            } else {
                contentColor2 = contentColor;
            }
            i3 = 65536;
            $dirty |= i3;
        } else {
            contentColor2 = contentColor;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                actionColor2 = actionColor;
                if ($composer2.changed(actionColor2)) {
                    i2 = 1048576;
                    $dirty |= i2;
                }
            } else {
                actionColor2 = actionColor;
            }
            i2 = 524288;
            $dirty |= i2;
        } else {
            actionColor2 = actionColor;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer2.changed(elevation) ? 8388608 : 4194304;
        }
        if (($dirty & 23967451) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            backgroundColor3 = backgroundColor;
            elevation3 = elevation;
            actionOnNewLine3 = z;
            shape4 = shape2;
            actionColor6 = actionColor2;
            contentColor3 = contentColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i6 != 0 ? Modifier.INSTANCE : modifier;
                actionOnNewLine2 = i7 != 0 ? false : z;
                if ((i & 8) != 0) {
                    shape3 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getSmall();
                    $dirty &= -7169;
                } else {
                    shape3 = shape2;
                }
                if ((i & 16) != 0) {
                    backgroundColor2 = SnackbarDefaults.INSTANCE.getBackgroundColor($composer2, 6);
                    $dirty &= -57345;
                } else {
                    backgroundColor2 = backgroundColor;
                }
                if ((i & 32) != 0) {
                    contentColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1321getSurface0d7_KjU();
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    actionColor3 = SnackbarDefaults.INSTANCE.getPrimaryActionColor($composer2, 6);
                    $dirty &= -3670017;
                } else {
                    actionColor3 = actionColor2;
                }
                if (i8 != 0) {
                    elevation2 = C0504Dp.m4382constructorimpl(6);
                    actionColor2 = actionColor3;
                    actionColor4 = backgroundColor2;
                } else {
                    elevation2 = elevation;
                    actionColor2 = actionColor3;
                    actionColor4 = backgroundColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    elevation2 = elevation;
                    $dirty &= -3670017;
                    actionOnNewLine2 = z;
                    shape3 = shape2;
                    modifier2 = modifier;
                    actionColor4 = backgroundColor;
                } else {
                    modifier2 = modifier;
                    elevation2 = elevation;
                    actionOnNewLine2 = z;
                    shape3 = shape2;
                    actionColor4 = backgroundColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(258660814, $dirty, -1, "androidx.compose.material.Snackbar (Snackbar.kt:151)");
            }
            final String actionLabel = snackbarData.getActionLabel();
            if (actionLabel != null) {
                final long j = actionColor2;
                final int i9 = $dirty;
                actionColor5 = actionColor2;
                actionComposable = ComposableLambdaKt.composableLambda($composer2, 1843479216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1
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
                        ComposerKt.sourceInformation($composer3, "C165@7570L44,164@7518L219:Snackbar.kt#jmzs0o");
                        if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1843479216, $changed2, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:163)");
                        }
                        ButtonColors m1276textButtonColorsRGew2ao = ButtonDefaults.INSTANCE.m1276textButtonColorsRGew2ao(0L, j, 0L, $composer3, ((i9 >> 15) & SdkConfig.SDK_VERSION) | 3072, 5);
                        final SnackbarData snackbarData2 = snackbarData;
                        Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                SnackbarData.this.performAction();
                            }
                        };
                        final String str = actionLabel;
                        ButtonKt.TextButton(function0, null, false, null, null, null, null, m1276textButtonColorsRGew2ao, null, ComposableLambdaKt.composableLambda($composer3, -929149933, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                                invoke(rowScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope TextButton, Composer $composer4, int $changed3) {
                                Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                                ComposerKt.sourceInformation($composer4, "C167@7704L17:Snackbar.kt#jmzs0o");
                                if (($changed3 & 81) == 16 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-929149933, $changed3, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:167)");
                                }
                                TextKt.m1585TextfLXpl1I(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer4, 0, 0, 65534);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), $composer3, 805306368, 382);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                });
            } else {
                actionColor5 = actionColor2;
                actionComposable = null;
            }
            m1495Snackbar7zSek6w(PaddingKt.m759padding3ABfNKs(modifier2, C0504Dp.m4382constructorimpl(12)), actionComposable, actionOnNewLine2, shape3, actionColor4, contentColor2, elevation2, ComposableLambdaKt.composableLambda($composer2, -261845785, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C175@7858L26:Snackbar.kt#jmzs0o");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-261845785, $changed2, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:175)");
                    }
                    TextKt.m1585TextfLXpl1I(SnackbarData.this.getMessage(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer3, 0, 0, 65534);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), $composer2, ($dirty & 896) | 12582912 | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (($dirty >> 3) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            actionColor6 = actionColor5;
            modifier3 = modifier2;
            actionOnNewLine3 = actionOnNewLine2;
            elevation3 = elevation2;
            shape4 = shape3;
            backgroundColor3 = actionColor4;
            contentColor3 = contentColor2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final boolean z2 = actionOnNewLine3;
        final Shape shape5 = shape4;
        final long j2 = backgroundColor3;
        final long j3 = contentColor3;
        final long j4 = actionColor6;
        final float f = elevation3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i10) {
                SnackbarKt.m1496SnackbarsPrSdHI(SnackbarData.this, modifier4, z2, shape5, j2, j3, j4, f, composer, $changed | 1, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextOnlySnackbar(final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Function0 factory$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(917397959);
        ComposerKt.sourceInformation($composer2, "C(TextOnlySnackbar)236@9927L1207:Snackbar.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(function2) ? 4 : 2;
        }
        if (($dirty & 11) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(917397959, $dirty, -1, "androidx.compose.material.TextOnlySnackbar (Snackbar.kt:235)");
            }
            MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.material.SnackbarKt$TextOnlySnackbar$2
                @Override // androidx.compose.p000ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo331measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long constraints) {
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    if (!(measurables.size() == 1)) {
                        throw new IllegalArgumentException("text for Snackbar expected to have exactly only one child".toString());
                    }
                    final Placeable textPlaceable = ((Measurable) CollectionsKt.first((List) measurables)).mo3492measureBRTryo0(constraints);
                    int firstBaseline = textPlaceable.get(AlignmentLineKt.getFirstBaseline());
                    int lastBaseline = textPlaceable.get(AlignmentLineKt.getLastBaseline());
                    if (!(firstBaseline != Integer.MIN_VALUE)) {
                        throw new IllegalArgumentException("No baselines for text".toString());
                    }
                    if (!(lastBaseline != Integer.MIN_VALUE)) {
                        throw new IllegalArgumentException("No baselines for text".toString());
                    }
                    float minHeight = firstBaseline == lastBaseline ? SnackbarKt.SnackbarMinHeightOneLine : SnackbarKt.SnackbarMinHeightTwoLines;
                    final int containerHeight = Math.max(Layout.mo642roundToPx0680j_4(minHeight), textPlaceable.getHeight());
                    return MeasureScope.layout$default(Layout, Constraints.m4338getMaxWidthimpl(constraints), containerHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.SnackbarKt$TextOnlySnackbar$2$measure$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope layout) {
                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                            int textPlaceY = (containerHeight - textPlaceable.getHeight()) / 2;
                            Placeable.PlacementScope.placeRelative$default(layout, textPlaceable, 0, textPlaceY, 0.0f, 4, null);
                        }
                    }, 4, null);
                }
            };
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.INSTANCE;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv = (Density) consume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            Function0 factory$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv = factory$iv$iv2;
                $composer2.createNode(factory$iv$iv);
            } else {
                factory$iv$iv = factory$iv$iv2;
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
            $composer2.startReplaceableGroup(-266728784);
            ComposerKt.sourceInformation($composer2, "C237@9944L202:Snackbar.kt#jmzs0o");
            if ((($changed$iv$iv >> 9) & 14 & 11) == 2 && $composer2.getSkipping()) {
                $composer2.skipToGroupEnd();
            } else {
                Modifier modifier$iv2 = PaddingKt.m760paddingVpY3zN4(Modifier.INSTANCE, HorizontalSpacing, SnackbarVerticalPadding);
                $composer2.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((6 >> 3) & 14) | ((6 >> 3) & SdkConfig.SDK_VERSION));
                int $changed$iv$iv2 = (6 << 3) & SdkConfig.SDK_VERSION;
                $composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer2.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density density$iv$iv = (Density) consume4;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = $composer2.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume5;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = $composer2.consume(localViewConfiguration2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume6;
                Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv2);
                int $changed$iv$iv$iv = (($changed$iv$iv2 << 9) & 7168) | 6;
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    $composer2.createNode(factory$iv$iv$iv);
                } else {
                    $composer2.useNode();
                }
                $composer2.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer2);
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer2.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                $composer2.startReplaceableGroup(2058660585);
                int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                $composer2.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation($composer2, "C72@3384L9:Box.kt#2w3rfo");
                if (($changed$iv & 11) == 2 && $composer2.getSkipping()) {
                    $composer2.skipToGroupEnd();
                } else {
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int $changed2 = ((6 >> 6) & SdkConfig.SDK_VERSION) | 6;
                    $composer2.startReplaceableGroup(1392363114);
                    ComposerKt.sourceInformation($composer2, "C243@10127L9:Snackbar.kt#jmzs0o");
                    if (($changed2 & 81) == 16 && $composer2.getSkipping()) {
                        $composer2.skipToGroupEnd();
                    } else {
                        function2.invoke($composer2, Integer.valueOf($dirty & 14));
                    }
                    $composer2.endReplaceableGroup();
                }
                $composer2.endReplaceableGroup();
                $composer2.endReplaceableGroup();
                $composer2.endNode();
                $composer2.endReplaceableGroup();
                $composer2.endReplaceableGroup();
            }
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$TextOnlySnackbar$3
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
                SnackbarKt.TextOnlySnackbar(function2, composer, $changed | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NewLineButtonSnackbar(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer$iv;
        Composer $composer3 = $composer.startRestartGroup(-1229075900);
        ComposerKt.sourceInformation($composer3, "C(NewLineButtonSnackbar)P(1)274@11262L476:Snackbar.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(function2) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer3.changed(function22) ? 32 : 16;
        }
        if (($dirty & 91) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1229075900, $dirty, -1, "androidx.compose.material.NewLineButtonSnackbar (Snackbar.kt:270)");
            }
            Modifier modifier$iv = PaddingKt.m763paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), HorizontalSpacing, 0.0f, HorizontalSpacingButtonSide, SeparateButtonExtraY, 2, null);
            $composer3.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation($composer3, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & SdkConfig.SDK_VERSION));
            int $changed$iv$iv = (6 << 3) & SdkConfig.SDK_VERSION;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv = (Density) consume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer3);
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer3.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
            $composer3.startReplaceableGroup(2058660585);
            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
            $composer3.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation($composer3, "C79@3994L9:Column.kt#2w3rfo");
            if (($changed$iv & 11) == 2 && $composer3.getSkipping()) {
                $composer3.skipToGroupEnd();
                $composer$iv = $composer3;
                $composer2 = $composer3;
            } else {
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int $changed2 = ((6 >> 6) & SdkConfig.SDK_VERSION) | 6;
                ColumnScope $this$NewLineButtonSnackbar_u24lambda_u2d4 = columnScope;
                $composer3.startReplaceableGroup(-1214415430);
                ComposerKt.sourceInformation($composer3, "C282@11505L171,286@11685L47:Snackbar.kt#jmzs0o");
                int $dirty2 = $changed2;
                if (($changed2 & 14) == 0) {
                    $dirty2 |= $composer3.changed($this$NewLineButtonSnackbar_u24lambda_u2d4) ? 4 : 2;
                }
                int $changed$iv2 = $dirty2 & 91;
                if ($changed$iv2 == 18 && $composer3.getSkipping()) {
                    $composer3.skipToGroupEnd();
                    $composer$iv = $composer3;
                    $composer2 = $composer3;
                } else {
                    Modifier modifier$iv2 = PaddingKt.m763paddingqDBjuR0$default(androidx.compose.foundation.layout.AlignmentLineKt.m686paddingFromBaselineVpY3zN4(Modifier.INSTANCE, HeightToFirstLine, LongButtonVerticalOffset), 0.0f, 0.0f, HorizontalSpacingButtonSide, 0.0f, 11, null);
                    $composer3.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv2 = (6 << 3) & SdkConfig.SDK_VERSION;
                    $composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume4 = $composer3.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Density density$iv$iv2 = (Density) consume4;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume5 = $composer3.consume(localLayoutDirection2);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                    $composer2 = $composer3;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume6 = $composer3.consume(localViewConfiguration2);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                    Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                    $composer$iv = $composer3;
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        $composer3.createNode(factory$iv$iv$iv2);
                    } else {
                        $composer3.useNode();
                    }
                    $composer3.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer3);
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    $composer3.enableReusing();
                    skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                    $composer3.startReplaceableGroup(2058660585);
                    int $changed$iv3 = ($changed$iv$iv$iv2 >> 9) & 14;
                    $composer3.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer3, "C72@3384L9:Box.kt#2w3rfo");
                    if (($changed$iv3 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                    } else {
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int $changed3 = ((6 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        $composer3.startReplaceableGroup(1193033152);
                        ComposerKt.sourceInformation($composer3, "C285@11668L6:Snackbar.kt#jmzs0o");
                        if (($changed3 & 81) == 16 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                        } else {
                            function2.invoke($composer3, Integer.valueOf($dirty & 14));
                        }
                        $composer3.endReplaceableGroup();
                    }
                    $composer3.endReplaceableGroup();
                    $composer3.endReplaceableGroup();
                    $composer3.endNode();
                    $composer3.endReplaceableGroup();
                    $composer3.endReplaceableGroup();
                    Modifier modifier$iv3 = $this$NewLineButtonSnackbar_u24lambda_u2d4.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
                    $composer3.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv3 = (0 << 3) & SdkConfig.SDK_VERSION;
                    $composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume7 = $composer3.consume(localDensity3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Density density$iv$iv3 = (Density) consume7;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume8 = $composer3.consume(localLayoutDirection3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume8;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume9 = $composer3.consume(localViewConfiguration3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume9;
                    Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv3 = LayoutKt.materializerOf(modifier$iv3);
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 9) & 7168) | 6;
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        $composer3.createNode(factory$iv$iv$iv3);
                    } else {
                        $composer3.useNode();
                    }
                    $composer3.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m1639constructorimpl($composer3);
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    $composer3.enableReusing();
                    skippableUpdate$iv$iv$iv3.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & SdkConfig.SDK_VERSION));
                    $composer3.startReplaceableGroup(2058660585);
                    int $changed$iv4 = ($changed$iv$iv$iv3 >> 9) & 14;
                    $composer3.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer3, "C72@3384L9:Box.kt#2w3rfo");
                    if (($changed$iv4 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                    } else {
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        int $changed4 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        $composer3.startReplaceableGroup(-2100387721);
                        ComposerKt.sourceInformation($composer3, "C286@11722L8:Snackbar.kt#jmzs0o");
                        if (($changed4 & 81) == 16 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                        } else {
                            function22.invoke($composer3, Integer.valueOf(($dirty >> 3) & 14));
                        }
                        $composer3.endReplaceableGroup();
                    }
                    $composer3.endReplaceableGroup();
                    $composer3.endReplaceableGroup();
                    $composer3.endNode();
                    $composer3.endReplaceableGroup();
                    $composer3.endReplaceableGroup();
                }
                $composer3.endReplaceableGroup();
            }
            $composer$iv.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$NewLineButtonSnackbar$2
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
                SnackbarKt.NewLineButtonSnackbar(function2, function22, composer, $changed | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OneRowSnackbar(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-534813202);
        ComposerKt.sourceInformation($composer3, "C(OneRowSnackbar)P(1)297@11913L2543:Snackbar.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(function2) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer3.changed(function22) ? 32 : 16;
        }
        if (($dirty & 91) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-534813202, $dirty, -1, "androidx.compose.material.OneRowSnackbar (Snackbar.kt:291)");
            }
            final String textTag = "text";
            final String actionTag = "action";
            Modifier modifier$iv = PaddingKt.m763paddingqDBjuR0$default(Modifier.INSTANCE, HorizontalSpacing, 0.0f, HorizontalSpacingButtonSide, 0.0f, 10, null);
            MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.material.SnackbarKt$OneRowSnackbar$2
                @Override // androidx.compose.p000ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo331measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long constraints) {
                    float f;
                    long m4328copyZbe2FdA;
                    float f2;
                    float f3;
                    int it;
                    int containerHeight;
                    int textPlaceY;
                    float f4;
                    SnackbarKt$OneRowSnackbar$2 snackbarKt$OneRowSnackbar$2 = this;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    List<? extends Measurable> $this$first$iv = measurables;
                    String str = actionTag;
                    for (Object element$iv : $this$first$iv) {
                        Measurable it2 = (Measurable) element$iv;
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it2), str)) {
                            final Placeable buttonPlaceable = ((Measurable) element$iv).mo3492measureBRTryo0(constraints);
                            int m4338getMaxWidthimpl = Constraints.m4338getMaxWidthimpl(constraints) - buttonPlaceable.getWidth();
                            f = SnackbarKt.TextEndExtraSpacing;
                            int textMaxWidth = RangesKt.coerceAtLeast(m4338getMaxWidthimpl - Layout.mo642roundToPx0680j_4(f), Constraints.m4340getMinWidthimpl(constraints));
                            List<? extends Measurable> $this$first$iv2 = measurables;
                            String str2 = textTag;
                            for (Object element$iv2 : $this$first$iv2) {
                                Measurable it3 = (Measurable) element$iv2;
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it3), str2)) {
                                    m4328copyZbe2FdA = Constraints.m4328copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m4340getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m4338getMaxWidthimpl(constraints) : textMaxWidth, (r12 & 4) != 0 ? Constraints.m4339getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m4337getMaxHeightimpl(constraints) : 0);
                                    final Placeable textPlaceable = ((Measurable) element$iv2).mo3492measureBRTryo0(m4328copyZbe2FdA);
                                    int firstTextBaseline = textPlaceable.get(AlignmentLineKt.getFirstBaseline());
                                    if (!(firstTextBaseline != Integer.MIN_VALUE)) {
                                        throw new IllegalArgumentException("No baselines for text".toString());
                                    }
                                    int lastTextBaseline = textPlaceable.get(AlignmentLineKt.getLastBaseline());
                                    if (!(lastTextBaseline != Integer.MIN_VALUE)) {
                                        throw new IllegalArgumentException("No baselines for text".toString());
                                    }
                                    boolean isOneLine = firstTextBaseline == lastTextBaseline;
                                    final int buttonPlaceX = Constraints.m4338getMaxWidthimpl(constraints) - buttonPlaceable.getWidth();
                                    if (isOneLine) {
                                        f4 = SnackbarKt.SnackbarMinHeightOneLine;
                                        int minContainerHeight = Layout.mo642roundToPx0680j_4(f4);
                                        int contentHeight = buttonPlaceable.getHeight();
                                        int containerHeight2 = Math.max(minContainerHeight, contentHeight);
                                        int textPlaceY2 = (containerHeight2 - textPlaceable.getHeight()) / 2;
                                        int buttonBaseline = buttonPlaceable.get(AlignmentLineKt.getFirstBaseline());
                                        it = buttonBaseline != Integer.MIN_VALUE ? (textPlaceY2 + firstTextBaseline) - buttonBaseline : 0;
                                        containerHeight = containerHeight2;
                                        textPlaceY = textPlaceY2;
                                    } else {
                                        f2 = SnackbarKt.HeightToFirstLine;
                                        int baselineOffset = Layout.mo642roundToPx0680j_4(f2);
                                        int textPlaceY3 = baselineOffset - firstTextBaseline;
                                        f3 = SnackbarKt.SnackbarMinHeightTwoLines;
                                        int minContainerHeight2 = Layout.mo642roundToPx0680j_4(f3);
                                        int contentHeight2 = textPlaceY3 + textPlaceable.getHeight();
                                        int containerHeight3 = Math.max(minContainerHeight2, contentHeight2);
                                        it = (containerHeight3 - buttonPlaceable.getHeight()) / 2;
                                        containerHeight = containerHeight3;
                                        textPlaceY = textPlaceY3;
                                    }
                                    int contentHeight3 = Constraints.m4338getMaxWidthimpl(constraints);
                                    final int i = textPlaceY;
                                    final int i2 = it;
                                    return MeasureScope.layout$default(Layout, contentHeight3, containerHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.SnackbarKt$OneRowSnackbar$2$measure$4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                            invoke2(placementScope);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(Placeable.PlacementScope layout) {
                                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                            Placeable.PlacementScope.placeRelative$default(layout, Placeable.this, 0, i, 0.0f, 4, null);
                                            Placeable.PlacementScope.placeRelative$default(layout, buttonPlaceable, buttonPlaceX, i2, 0.0f, 4, null);
                                        }
                                    }, 4, null);
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        snackbarKt$OneRowSnackbar$2 = this;
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            };
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv = (Density) consume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv = ((48 << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv);
            } else {
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv = Updater.m1639constructorimpl($composer3);
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, density$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, layoutDirection$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, viewConfiguration$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer3.enableReusing();
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & SdkConfig.SDK_VERSION));
            $composer3.startReplaceableGroup(2058660585);
            $composer3.startReplaceableGroup(-643033641);
            ComposerKt.sourceInformation($composer3, "C299@11943L86,300@12042L46:Snackbar.kt#jmzs0o");
            if ((($changed$iv$iv >> 9) & 14 & 11) == 2 && $composer3.getSkipping()) {
                $composer3.skipToGroupEnd();
                $composer2 = $composer3;
            } else {
                Modifier modifier$iv2 = PaddingKt.m761paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "text"), 0.0f, SnackbarVerticalPadding, 1, null);
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & SdkConfig.SDK_VERSION));
                int $changed$iv$iv2 = (6 << 3) & SdkConfig.SDK_VERSION;
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer3.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv = (Density) consume4;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = $composer3.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume5;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = $composer3.consume(localViewConfiguration2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume6;
                Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv2);
                int $changed$iv$iv$iv = (($changed$iv$iv2 << 9) & 7168) | 6;
                $composer2 = $composer3;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(factory$iv$iv$iv);
                } else {
                    $composer3.useNode();
                }
                $composer3.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer3);
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer3.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                $composer3.startReplaceableGroup(2058660585);
                int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                $composer3.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation($composer3, "C72@3384L9:Box.kt#2w3rfo");
                if (($changed$iv & 11) == 2 && $composer3.getSkipping()) {
                    $composer3.skipToGroupEnd();
                } else {
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int $changed2 = ((6 >> 6) & SdkConfig.SDK_VERSION) | 6;
                    $composer3.startReplaceableGroup(1616738193);
                    ComposerKt.sourceInformation($composer3, "C299@12021L6:Snackbar.kt#jmzs0o");
                    if (($changed2 & 81) == 16 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                    } else {
                        function2.invoke($composer3, Integer.valueOf($dirty & 14));
                    }
                    $composer3.endReplaceableGroup();
                }
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
                Modifier modifier$iv3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "action");
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & SdkConfig.SDK_VERSION));
                int $changed$iv$iv3 = (6 << 3) & SdkConfig.SDK_VERSION;
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume7 = $composer3.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv2 = (Density) consume7;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume8 = $composer3.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume8;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume9 = $composer3.consume(localViewConfiguration3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume9;
                Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv3);
                int $changed$iv$iv$iv2 = (($changed$iv$iv3 << 9) & 7168) | 6;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(factory$iv$iv$iv2);
                } else {
                    $composer3.useNode();
                }
                $composer3.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer3);
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer3.enableReusing();
                skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                $composer3.startReplaceableGroup(2058660585);
                int $changed$iv2 = ($changed$iv$iv$iv2 >> 9) & 14;
                $composer3.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation($composer3, "C72@3384L9:Box.kt#2w3rfo");
                if (($changed$iv2 & 11) == 2 && $composer3.getSkipping()) {
                    $composer3.skipToGroupEnd();
                } else {
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    int $changed3 = ((6 >> 6) & SdkConfig.SDK_VERSION) | 6;
                    $composer3.startReplaceableGroup(-1690150342);
                    ComposerKt.sourceInformation($composer3, "C300@12078L8:Snackbar.kt#jmzs0o");
                    if (($changed3 & 81) == 16 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                    } else {
                        function22.invoke($composer3, Integer.valueOf(($dirty >> 3) & 14));
                    }
                    $composer3.endReplaceableGroup();
                }
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            }
            $composer3.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$OneRowSnackbar$3
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
                SnackbarKt.OneRowSnackbar(function2, function22, composer, $changed | 1);
            }
        });
    }
}
