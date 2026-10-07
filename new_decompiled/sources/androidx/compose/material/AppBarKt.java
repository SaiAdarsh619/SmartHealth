package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.RectangleShapeKt;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppBar.kt */
@Metadata(m286d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ae\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00072\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aq\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0087\u0001\u0010\u001f\u001a\u00020\n2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\n0!¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u0013\u001a\u00020\u00072\u0015\b\u0002\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010!¢\u0006\u0002\b\u00172\u001e\b\u0002\u0010#\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0001H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001ae\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)H\u0080\b\u001a,\u0010,\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0-2\u0006\u0010.\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\u0006\u0010/\u001a\u00020)H\u0000\u001a\u0011\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020)H\u0082\b\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00062"}, m287d2 = {"AppBarHeight", "Landroidx/compose/ui/unit/Dp;", "F", "AppBarHorizontalPadding", "BottomAppBarCutoutOffset", "BottomAppBarRoundedEdgeRadius", "TitleIconModifier", "Landroidx/compose/ui/Modifier;", "TitleInsetWithoutIcon", "AppBar", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "shape", "Landroidx/compose/ui/graphics/Shape;", "modifier", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "AppBar-celAv9A", "(JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar", "cutoutShape", "BottomAppBar-Y1yfwus", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TopAppBar", "title", "Lkotlin/Function0;", "navigationIcon", "actions", "TopAppBar-xWeB9-s", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "TopAppBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "calculateCutoutCircleYIntercept", "", "cutoutRadius", "verticalOffset", "calculateRoundedEdgeIntercept", "Lkotlin/Pair;", "controlPointX", "radius", "square", "x", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AppBarKt {
    private static final float AppBarHeight = C0504Dp.m4382constructorimpl(56);
    private static final float AppBarHorizontalPadding = C0504Dp.m4382constructorimpl(4);
    private static final float BottomAppBarCutoutOffset;
    private static final float BottomAppBarRoundedEdgeRadius;
    private static final Modifier TitleIconModifier;
    private static final Modifier TitleInsetWithoutIcon;

    /* renamed from: TopAppBar-xWeB9-s, reason: not valid java name */
    public static final void m1230TopAppBarxWeB9s(final Function2<? super Composer, ? super Integer, Unit> title, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, long backgroundColor, long contentColor, float elevation, Composer $composer, final int $changed, final int i) {
        final Function2 navigationIcon;
        final Function3 actions;
        long backgroundColor2;
        long contentColor2;
        float elevation2;
        Modifier.Companion modifier2;
        final int $dirty;
        long contentColor3;
        Modifier modifier3;
        long contentColor4;
        Function2 navigationIcon2;
        Function3 actions2;
        long backgroundColor3;
        float elevation3;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer2 = $composer.startRestartGroup(-2087748139);
        ComposerKt.sourceInformation($composer2, "C(TopAppBar)P(6,4,5!1,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)81@3902L6,82@3951L32,85@4047L1254:AppBar.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(title) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty2 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty2 |= 384;
            navigationIcon = function2;
        } else if (($changed & 896) == 0) {
            navigationIcon = function2;
            $dirty2 |= $composer2.changed(navigationIcon) ? 256 : 128;
        } else {
            navigationIcon = function2;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty2 |= 3072;
            actions = function3;
        } else if (($changed & 7168) == 0) {
            actions = function3;
            $dirty2 |= $composer2.changed(actions) ? 2048 : 1024;
        } else {
            actions = function3;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                backgroundColor2 = backgroundColor;
                if ($composer2.changed(backgroundColor2)) {
                    i3 = 16384;
                    $dirty2 |= i3;
                }
            } else {
                backgroundColor2 = backgroundColor;
            }
            i3 = 8192;
            $dirty2 |= i3;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i2 = 131072;
                    $dirty2 |= i2;
                }
            } else {
                contentColor2 = contentColor;
            }
            i2 = 65536;
            $dirty2 |= i2;
        } else {
            contentColor2 = contentColor;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            elevation2 = elevation;
        } else if (($changed & 3670016) == 0) {
            elevation2 = elevation;
            $dirty2 |= $composer2.changed(elevation2) ? 1048576 : 524288;
        } else {
            elevation2 = elevation;
        }
        if (($dirty2 & 2995931) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            actions2 = actions;
            backgroundColor3 = backgroundColor2;
            elevation3 = elevation2;
            contentColor4 = contentColor2;
            modifier3 = modifier;
            navigationIcon2 = navigationIcon;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i4 != 0 ? Modifier.INSTANCE : modifier;
                if (i5 != 0) {
                    navigationIcon = null;
                }
                if (i6 != 0) {
                    actions = ComposableSingletons$AppBarKt.INSTANCE.m1340getLambda1$material_release();
                }
                if ((i & 16) != 0) {
                    backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer2, 6));
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    contentColor2 = ColorsKt.m1335contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 12) & 14);
                    $dirty2 &= -458753;
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    elevation2 = AppBarDefaults.INSTANCE.m1226getTopAppBarElevationD9Ej5fM();
                    contentColor3 = contentColor2;
                } else {
                    $dirty = $dirty2;
                    contentColor3 = contentColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty = $dirty2 & (-458753);
                    contentColor3 = contentColor2;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    $dirty = $dirty2;
                    contentColor3 = contentColor2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2087748139, $dirty, -1, "androidx.compose.material.TopAppBar (AppBar.kt:76)");
            }
            m1227AppBarcelAv9A(backgroundColor2, contentColor3, elevation2, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), modifier2, ComposableLambdaKt.composableLambda($composer2, -1484077694, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                    invoke(rowScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope AppBar, Composer $composer3, int $changed2) {
                    Modifier modifier$iv;
                    String str;
                    String str2;
                    Modifier modifier4;
                    Intrinsics.checkNotNullParameter(AppBar, "$this$AppBar");
                    ComposerKt.sourceInformation($composer3, "C104@4595L378,116@5048L6,116@4983L312:AppBar.kt#jmzs0o");
                    int $dirty3 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty3 |= $composer3.changed(AppBar) ? 4 : 2;
                    }
                    if (($dirty3 & 91) != 18 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1484077694, $changed2, -1, "androidx.compose.material.TopAppBar.<anonymous> (AppBar.kt:92)");
                        }
                        if (navigationIcon == null) {
                            $composer3.startReplaceableGroup(-512812651);
                            ComposerKt.sourceInformation($composer3, "94@4259L29");
                            modifier4 = AppBarKt.TitleInsetWithoutIcon;
                            SpacerKt.Spacer(modifier4, $composer3, 6);
                            $composer3.endReplaceableGroup();
                            str = "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo";
                            str2 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh";
                        } else {
                            $composer3.startReplaceableGroup(-512812592);
                            ComposerKt.sourceInformation($composer3, "96@4318L257");
                            modifier$iv = AppBarKt.TitleIconModifier;
                            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                            Function2<Composer, Integer, Unit> function22 = navigationIcon;
                            int i8 = $dirty;
                            $composer3.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation($composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & SdkConfig.SDK_VERSION));
                            int $changed$iv$iv = (390 << 3) & SdkConfig.SDK_VERSION;
                            $composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume = $composer3.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Density density$iv$iv = (Density) consume;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            str = "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo";
                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume2 = $composer3.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                            str2 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh";
                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume3 = $composer3.consume(localViewConfiguration);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
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
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
                            $composer3.enableReusing();
                            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                            $composer3.startReplaceableGroup(2058660585);
                            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                            $composer3.startReplaceableGroup(-678309503);
                            ComposerKt.sourceInformation($composer3, "C80@3988L9:Row.kt#2w3rfo");
                            if (($changed$iv & 11) == 2 && $composer3.getSkipping()) {
                                $composer3.skipToGroupEnd();
                            } else {
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                int $changed3 = ((390 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                $composer3.startReplaceableGroup(1485618042);
                                ComposerKt.sourceInformation($composer3, "C98@4493L4,97@4407L154:AppBar.kt#jmzs0o");
                                if (($changed3 & 81) != 16 || !$composer3.getSkipping()) {
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh($composer3, 6)))}, function22, $composer3, ((i8 >> 3) & SdkConfig.SDK_VERSION) | 8);
                                } else {
                                    $composer3.skipToGroupEnd();
                                }
                                $composer3.endReplaceableGroup();
                            }
                            $composer3.endReplaceableGroup();
                            $composer3.endReplaceableGroup();
                            $composer3.endNode();
                            $composer3.endReplaceableGroup();
                            $composer3.endReplaceableGroup();
                            $composer3.endReplaceableGroup();
                        }
                        Modifier modifier$iv2 = RowScope.weight$default(AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                        Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getCenterVertically();
                        final Function2<Composer, Integer, Unit> function23 = title;
                        final int i9 = $dirty;
                        $composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation($composer3, str);
                        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv2 = (384 << 3) & SdkConfig.SDK_VERSION;
                        $composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer3, str2);
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
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume6 = $composer3.consume(localViewConfiguration2);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
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
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                        $composer3.enableReusing();
                        skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                        $composer3.startReplaceableGroup(2058660585);
                        int $changed$iv2 = ($changed$iv$iv$iv2 >> 9) & 14;
                        $composer3.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation($composer3, "C80@3988L9:Row.kt#2w3rfo");
                        if (($changed$iv2 & 11) == 2 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                        } else {
                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            int $changed4 = ((384 >> 6) & SdkConfig.SDK_VERSION) | 6;
                            $composer3.startReplaceableGroup(159489950);
                            ComposerKt.sourceInformation($composer3, "C108@4771L10,108@4732L231:AppBar.kt#jmzs0o");
                            if (($changed4 & 81) != 16 || !$composer3.getSkipping()) {
                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography($composer3, 6).getH6(), ComposableLambdaKt.composableLambda($composer3, -2021518195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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

                                    public final void invoke(Composer $composer4, int $changed5) {
                                        ComposerKt.sourceInformation($composer4, "C110@4890L4,109@4804L145:AppBar.kt#jmzs0o");
                                        if (($changed5 & 11) != 2 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2021518195, $changed5, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous>.<anonymous> (AppBar.kt:108)");
                                            }
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh($composer4, 6)))}, function23, $composer4, ((i9 << 3) & SdkConfig.SDK_VERSION) | 8);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), $composer3, 48);
                            } else {
                                $composer3.skipToGroupEnd();
                            }
                            $composer3.endReplaceableGroup();
                        }
                        $composer3.endReplaceableGroup();
                        $composer3.endReplaceableGroup();
                        $composer3.endNode();
                        $composer3.endReplaceableGroup();
                        $composer3.endReplaceableGroup();
                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium($composer3, 6)))};
                        final Function3<RowScope, Composer, Integer, Unit> function32 = actions;
                        final int i10 = $dirty;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer3, 1157662914, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                            public final void invoke(Composer $composer4, int $changed5) {
                                ComposerKt.sourceInformation($composer4, "C117@5070L215:AppBar.kt#jmzs0o");
                                if (($changed5 & 11) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1157662914, $changed5, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous> (AppBar.kt:116)");
                                    }
                                    Modifier modifier$iv3 = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getEnd();
                                    Alignment.Vertical verticalAlignment$iv3 = Alignment.INSTANCE.getCenterVertically();
                                    Function3 content$iv = function32;
                                    int $changed$iv3 = (i10 & 7168) | 438;
                                    $composer4.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation($composer4, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer4, (($changed$iv3 >> 3) & 14) | (($changed$iv3 >> 3) & SdkConfig.SDK_VERSION));
                                    int $changed$iv$iv3 = ($changed$iv3 << 3) & SdkConfig.SDK_VERSION;
                                    $composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume7 = $composer4.consume(localDensity3);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    Density density$iv$iv3 = (Density) consume7;
                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume8 = $composer4.consume(localLayoutDirection3);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume8;
                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume9 = $composer4.consume(localViewConfiguration3);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume9;
                                    Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                                    Function3 skippableUpdate$iv$iv$iv3 = LayoutKt.materializerOf(modifier$iv3);
                                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 9) & 7168) | 6;
                                    if (!($composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer4.startReusableNode();
                                    if ($composer4.getInserting()) {
                                        $composer4.createNode(factory$iv$iv$iv3);
                                    } else {
                                        $composer4.useNode();
                                    }
                                    $composer4.disableReusing();
                                    Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m1639constructorimpl($composer4);
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.Companion.getSetDensity());
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.Companion.getSetLayoutDirection());
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.Companion.getSetViewConfiguration());
                                    $composer4.enableReusing();
                                    skippableUpdate$iv$iv$iv3.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & SdkConfig.SDK_VERSION));
                                    $composer4.startReplaceableGroup(2058660585);
                                    $composer4.startReplaceableGroup(-678309503);
                                    ComposerKt.sourceInformation($composer4, "C80@3988L9:Row.kt#2w3rfo");
                                    if ((($changed$iv$iv$iv3 >> 9) & 14 & 11) == 2 && $composer4.getSkipping()) {
                                        $composer4.skipToGroupEnd();
                                    } else {
                                        content$iv.invoke(RowScopeInstance.INSTANCE, $composer4, Integer.valueOf((($changed$iv3 >> 6) & SdkConfig.SDK_VERSION) | 6));
                                    }
                                    $composer4.endReplaceableGroup();
                                    $composer4.endReplaceableGroup();
                                    $composer4.endNode();
                                    $composer4.endReplaceableGroup();
                                    $composer4.endReplaceableGroup();
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
            }), $composer2, (($dirty >> 12) & 14) | 1600512 | (($dirty >> 12) & SdkConfig.SDK_VERSION) | (($dirty >> 12) & 896) | (($dirty << 12) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            contentColor4 = contentColor3;
            navigationIcon2 = navigationIcon;
            actions2 = actions;
            backgroundColor3 = backgroundColor2;
            elevation3 = elevation2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final Function2 function22 = navigationIcon2;
        final Function3 function32 = actions2;
        final long j = backgroundColor3;
        final long j2 = contentColor4;
        final float f = elevation3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$2
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

            public final void invoke(Composer composer, int i8) {
                AppBarKt.m1230TopAppBarxWeB9s(title, modifier4, function22, function32, j, j2, f, composer, $changed | 1, i);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x011f  */
    /* renamed from: TopAppBar-HsRjFd4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1229TopAppBarHsRjFd4(Modifier modifier, long backgroundColor, long contentColor, float elevation, PaddingValues contentPadding, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long contentColor2;
        float elevation2;
        PaddingValues paddingValues;
        long backgroundColor2;
        Modifier modifier3;
        long backgroundColor3;
        long contentColor3;
        float elevation3;
        PaddingValues contentPadding2;
        int $dirty;
        ScopeUpdateScope endRestartGroup;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(1897058582);
        ComposerKt.sourceInformation($composer2, "C(TopAppBar)P(5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3)156@6973L6,157@7022L32,162@7231L182:AppBar.kt#jmzs0o");
        int $dirty2 = $changed;
        int i5 = i & 1;
        if (i5 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            if ((i & 2) == 0) {
                j = backgroundColor;
                if ($composer2.changed(j)) {
                    i4 = 32;
                    $dirty2 |= i4;
                }
            } else {
                j = backgroundColor;
            }
            i4 = 16;
            $dirty2 |= i4;
        } else {
            j = backgroundColor;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i3 = 256;
                    $dirty2 |= i3;
                }
            } else {
                contentColor2 = contentColor;
            }
            i3 = 128;
            $dirty2 |= i3;
        } else {
            contentColor2 = contentColor;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty2 |= 3072;
            elevation2 = elevation;
        } else if (($changed & 7168) == 0) {
            elevation2 = elevation;
            $dirty2 |= $composer2.changed(elevation2) ? 2048 : 1024;
        } else {
            elevation2 = elevation;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty2 |= 24576;
            paddingValues = contentPadding;
        } else if ((57344 & $changed) == 0) {
            paddingValues = contentPadding;
            $dirty2 |= $composer2.changed(paddingValues) ? 16384 : 8192;
        } else {
            paddingValues = contentPadding;
        }
        if ((i & 32) == 0) {
            i2 = ($changed & 458752) == 0 ? $composer2.changed(content) ? 131072 : 65536 : 196608;
            if ((374491 & $dirty2) == 74898 || !$composer2.getSkipping()) {
                $composer2.startDefaults();
                if (($changed & 1) != 0 || $composer2.getDefaultsInvalid()) {
                    Modifier.Companion modifier4 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i & 2) == 0) {
                        backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer2, 6));
                        $dirty2 &= -113;
                    } else {
                        backgroundColor2 = j;
                    }
                    if ((i & 4) != 0) {
                        long contentColor4 = ColorsKt.m1335contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 3) & 14);
                        $dirty2 &= -897;
                        contentColor2 = contentColor4;
                    }
                    if (i6 != 0) {
                        elevation2 = AppBarDefaults.INSTANCE.m1226getTopAppBarElevationD9Ej5fM();
                    }
                    if (i7 == 0) {
                        modifier3 = modifier4;
                        $dirty = $dirty2;
                        backgroundColor3 = backgroundColor2;
                        contentPadding2 = AppBarDefaults.INSTANCE.getContentPadding();
                        contentColor3 = contentColor2;
                        elevation3 = elevation2;
                    } else {
                        modifier3 = modifier4;
                        backgroundColor3 = backgroundColor2;
                        contentColor3 = contentColor2;
                        elevation3 = elevation2;
                        contentPadding2 = paddingValues;
                        $dirty = $dirty2;
                    }
                } else {
                    $composer2.skipToGroupEnd();
                    if ((i & 2) != 0) {
                        $dirty2 &= -113;
                    }
                    if ((i & 4) != 0) {
                        modifier3 = modifier2;
                        backgroundColor3 = j;
                        contentColor3 = contentColor2;
                        elevation3 = elevation2;
                        contentPadding2 = paddingValues;
                        $dirty = $dirty2 & (-897);
                    } else {
                        modifier3 = modifier2;
                        backgroundColor3 = j;
                        contentColor3 = contentColor2;
                        elevation3 = elevation2;
                        contentPadding2 = paddingValues;
                        $dirty = $dirty2;
                    }
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1897058582, $dirty, -1, "androidx.compose.material.TopAppBar (AppBar.kt:154)");
                }
                m1227AppBarcelAv9A(backgroundColor3, contentColor3, elevation3, contentPadding2, RectangleShapeKt.getRectangleShape(), modifier3, content, $composer2, (($dirty >> 3) & 14) | 24576 | (($dirty >> 3) & SdkConfig.SDK_VERSION) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (($dirty << 15) & 458752) | (3670016 & ($dirty << 3)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer2.skipToGroupEnd();
                modifier3 = modifier2;
                backgroundColor3 = j;
                contentColor3 = contentColor2;
                elevation3 = elevation2;
                contentPadding2 = paddingValues;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Modifier modifier5 = modifier3;
            final long j2 = backgroundColor3;
            final long j3 = contentColor3;
            final float f = elevation3;
            final PaddingValues paddingValues2 = contentPadding2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$3
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

                public final void invoke(Composer composer, int i8) {
                    AppBarKt.m1229TopAppBarHsRjFd4(Modifier.this, j2, j3, f, paddingValues2, content, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty2 |= i2;
        if ((374491 & $dirty2) == 74898) {
        }
        $composer2.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i5 == 0) {
        }
        if ((i & 2) == 0) {
        }
        if ((i & 4) != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 == 0) {
        }
        $composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        m1227AppBarcelAv9A(backgroundColor3, contentColor3, elevation3, contentPadding2, RectangleShapeKt.getRectangleShape(), modifier3, content, $composer2, (($dirty >> 3) & 14) | 24576 | (($dirty >> 3) & SdkConfig.SDK_VERSION) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (($dirty << 15) & 458752) | (3670016 & ($dirty << 3)), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x014c  */
    /* renamed from: BottomAppBar-Y1yfwus, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1228BottomAppBarY1yfwus(Modifier modifier, long backgroundColor, long contentColor, Shape cutoutShape, float elevation, PaddingValues contentPadding, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        long backgroundColor2;
        long contentColor2;
        Shape cutoutShape2;
        float elevation2;
        PaddingValues contentPadding2;
        Modifier modifier2;
        int $dirty;
        long backgroundColor3;
        long contentColor3;
        float elevation3;
        Shape cutoutShape3;
        Shape shape;
        Shape cutoutShape4;
        ScopeUpdateScope endRestartGroup;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-1651948973);
        ComposerKt.sourceInformation($composer2, "C(BottomAppBar)P(6,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4,5:c#ui.unit.Dp,3)216@9902L6,217@9951L32,223@10232L7,229@10422L152:AppBar.kt#jmzs0o");
        int $dirty2 = $changed;
        int i5 = i & 1;
        if (i5 != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            if ((i & 2) == 0) {
                backgroundColor2 = backgroundColor;
                if ($composer2.changed(backgroundColor2)) {
                    i4 = 32;
                    $dirty2 |= i4;
                }
            } else {
                backgroundColor2 = backgroundColor;
            }
            i4 = 16;
            $dirty2 |= i4;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i3 = 256;
                    $dirty2 |= i3;
                }
            } else {
                contentColor2 = contentColor;
            }
            i3 = 128;
            $dirty2 |= i3;
        } else {
            contentColor2 = contentColor;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty2 |= 3072;
            cutoutShape2 = cutoutShape;
        } else if (($changed & 7168) == 0) {
            cutoutShape2 = cutoutShape;
            $dirty2 |= $composer2.changed(cutoutShape2) ? 2048 : 1024;
        } else {
            cutoutShape2 = cutoutShape;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty2 |= 24576;
            elevation2 = elevation;
        } else if ((57344 & $changed) == 0) {
            elevation2 = elevation;
            $dirty2 |= $composer2.changed(elevation2) ? 16384 : 8192;
        } else {
            elevation2 = elevation;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 458752) == 0) {
            $dirty2 |= $composer2.changed(contentPadding) ? 131072 : 65536;
        }
        if ((i & 64) == 0) {
            i2 = ($changed & 3670016) == 0 ? $composer2.changed(content) ? 1048576 : 524288 : 1572864;
            if (($dirty2 & 2995931) == 599186 || !$composer2.getSkipping()) {
                $composer2.startDefaults();
                if (($changed & 1) != 0 || $composer2.getDefaultsInvalid()) {
                    Modifier.Companion modifier3 = i5 == 0 ? Modifier.INSTANCE : modifier;
                    if ((i & 2) != 0) {
                        $dirty2 &= -113;
                        backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer2, 6));
                    }
                    if ((i & 4) != 0) {
                        long contentColor4 = ColorsKt.m1335contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 3) & 14);
                        $dirty2 &= -897;
                        contentColor2 = contentColor4;
                    }
                    if (i6 != 0) {
                        cutoutShape2 = null;
                    }
                    if (i7 != 0) {
                        elevation2 = AppBarDefaults.INSTANCE.m1225getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i8 == 0) {
                        modifier2 = modifier3;
                        $dirty = $dirty2;
                        contentPadding2 = AppBarDefaults.INSTANCE.getContentPadding();
                        backgroundColor3 = backgroundColor2;
                        contentColor3 = contentColor2;
                        elevation3 = elevation2;
                        cutoutShape3 = cutoutShape2;
                    } else {
                        contentPadding2 = contentPadding;
                        modifier2 = modifier3;
                        $dirty = $dirty2;
                        backgroundColor3 = backgroundColor2;
                        contentColor3 = contentColor2;
                        elevation3 = elevation2;
                        cutoutShape3 = cutoutShape2;
                    }
                } else {
                    $composer2.skipToGroupEnd();
                    if ((i & 2) != 0) {
                        $dirty2 &= -113;
                    }
                    if ((i & 4) != 0) {
                        modifier2 = modifier;
                        contentPadding2 = contentPadding;
                        $dirty = $dirty2 & (-897);
                        backgroundColor3 = backgroundColor2;
                        contentColor3 = contentColor2;
                        elevation3 = elevation2;
                        cutoutShape3 = cutoutShape2;
                    } else {
                        modifier2 = modifier;
                        contentPadding2 = contentPadding;
                        $dirty = $dirty2;
                        backgroundColor3 = backgroundColor2;
                        contentColor3 = contentColor2;
                        elevation3 = elevation2;
                        cutoutShape3 = cutoutShape2;
                    }
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1651948973, $dirty, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:214)");
                }
                ProvidableCompositionLocal<FabPlacement> localFabPlacement = ScaffoldKt.getLocalFabPlacement();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(localFabPlacement);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                FabPlacement fabPlacement = (FabPlacement) consume;
                if (cutoutShape3 != null) {
                    boolean z = false;
                    if (fabPlacement != null && fabPlacement.getIsDocked()) {
                        z = true;
                    }
                    if (z) {
                        shape = new BottomAppBarCutoutShape(cutoutShape3, fabPlacement);
                        cutoutShape4 = cutoutShape3;
                        m1227AppBarcelAv9A(backgroundColor3, contentColor3, elevation3, contentPadding2, shape, modifier2, content, $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & SdkConfig.SDK_VERSION) | (($dirty >> 6) & 896) | (($dirty >> 6) & 7168) | (($dirty << 15) & 458752) | ($dirty & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }
                shape = RectangleShapeKt.getRectangleShape();
                cutoutShape4 = cutoutShape3;
                m1227AppBarcelAv9A(backgroundColor3, contentColor3, elevation3, contentPadding2, shape, modifier2, content, $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & SdkConfig.SDK_VERSION) | (($dirty >> 6) & 896) | (($dirty >> 6) & 7168) | (($dirty << 15) & 458752) | ($dirty & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
            } else {
                $composer2.skipToGroupEnd();
                modifier2 = modifier;
                contentPadding2 = contentPadding;
                backgroundColor3 = backgroundColor2;
                contentColor3 = contentColor2;
                cutoutShape4 = cutoutShape2;
                elevation3 = elevation2;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Modifier modifier4 = modifier2;
            final long j = backgroundColor3;
            final long j2 = contentColor3;
            final Shape shape2 = cutoutShape4;
            final float f = elevation3;
            final PaddingValues paddingValues = contentPadding2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$BottomAppBar$1
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

                public final void invoke(Composer composer, int i9) {
                    AppBarKt.m1228BottomAppBarY1yfwus(Modifier.this, j, j2, shape2, f, paddingValues, content, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty2 |= i2;
        if (($dirty2 & 2995931) == 599186) {
        }
        $composer2.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i5 == 0) {
        }
        if ((i & 2) != 0) {
        }
        if ((i & 4) != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 == 0) {
        }
        $composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<FabPlacement> localFabPlacement2 = ScaffoldKt.getLocalFabPlacement();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer2.consume(localFabPlacement2);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        FabPlacement fabPlacement2 = (FabPlacement) consume2;
        if (cutoutShape3 != null) {
        }
        shape = RectangleShapeKt.getRectangleShape();
        cutoutShape4 = cutoutShape3;
        m1227AppBarcelAv9A(backgroundColor3, contentColor3, elevation3, contentPadding2, shape, modifier2, content, $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & SdkConfig.SDK_VERSION) | (($dirty >> 6) & 896) | (($dirty >> 6) & 7168) | (($dirty << 15) & 458752) | ($dirty & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final float square(float x) {
        return x * x;
    }

    public static final float calculateCutoutCircleYIntercept(float cutoutRadius, float verticalOffset) {
        return -((float) Math.sqrt((cutoutRadius * cutoutRadius) - (verticalOffset * verticalOffset)));
    }

    public static final Pair<Float, Float> calculateRoundedEdgeIntercept(float controlPointX, float verticalOffset, float radius) {
        Float valueOf;
        Float valueOf2;
        Pair m294to;
        Float valueOf3;
        Float valueOf4;
        float discriminant = verticalOffset * verticalOffset * radius * radius * (((controlPointX * controlPointX) + (verticalOffset * verticalOffset)) - (radius * radius));
        float divisor = (controlPointX * controlPointX) + (verticalOffset * verticalOffset);
        float bCoefficient = radius * radius * controlPointX;
        float xSolutionA = (bCoefficient - ((float) Math.sqrt(discriminant))) / divisor;
        float xSolutionB = (((float) Math.sqrt(discriminant)) + bCoefficient) / divisor;
        float ySolutionA = (float) Math.sqrt((radius * radius) - (xSolutionA * xSolutionA));
        float ySolutionB = (float) Math.sqrt((radius * radius) - (xSolutionB * xSolutionB));
        if (verticalOffset > 0.0f) {
            if (ySolutionA > ySolutionB) {
                valueOf3 = Float.valueOf(xSolutionA);
                valueOf4 = Float.valueOf(ySolutionA);
            } else {
                valueOf3 = Float.valueOf(xSolutionB);
                valueOf4 = Float.valueOf(ySolutionB);
            }
            m294to = TuplesKt.m294to(valueOf3, valueOf4);
        } else {
            if (ySolutionA < ySolutionB) {
                valueOf = Float.valueOf(xSolutionA);
                valueOf2 = Float.valueOf(ySolutionA);
            } else {
                valueOf = Float.valueOf(xSolutionB);
                valueOf2 = Float.valueOf(ySolutionB);
            }
            m294to = TuplesKt.m294to(valueOf, valueOf2);
        }
        float xSolution = ((Number) m294to.component1()).floatValue();
        float ySolution = ((Number) m294to.component2()).floatValue();
        float adjustedYSolution = xSolution < controlPointX ? -ySolution : ySolution;
        return TuplesKt.m294to(Float.valueOf(xSolution), Float.valueOf(adjustedYSolution));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: AppBar-celAv9A, reason: not valid java name */
    public static final void m1227AppBarcelAv9A(final long backgroundColor, final long contentColor, final float elevation, final PaddingValues contentPadding, final Shape shape, Modifier modifier, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(-1249680788);
        ComposerKt.sourceInformation($composer2, "C(AppBar)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3,6,5)513@22344L583:AppBar.kt#jmzs0o");
        final int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(backgroundColor) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(contentColor) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(elevation) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(contentPadding) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changed(shape) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty |= 196608;
            modifier2 = modifier;
        } else if (($changed & 458752) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if ((3670016 & $changed) == 0) {
            $dirty |= $composer2.changed(function3) ? 1048576 : 524288;
        }
        if ((2995931 & $dirty) != 599186 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1249680788, $dirty, -1, "androidx.compose.material.AppBar (AppBar.kt:504)");
            }
            SurfaceKt.m1513SurfaceFjzlyU(modifier2, shape, backgroundColor, contentColor, null, elevation, ComposableLambdaKt.composableLambda($composer2, -1027830352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
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
                    ComposerKt.sourceInformation($composer3, "C520@22586L6,520@22521L400:AppBar.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1027830352, $changed2, -1, "androidx.compose.material.AppBar.<anonymous> (AppBar.kt:519)");
                        }
                        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium($composer3, 6)))};
                        final PaddingValues paddingValues = PaddingValues.this;
                        final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                        final int i3 = $dirty;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer3, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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
                                float f;
                                ComposerKt.sourceInformation($composer4, "C521@22608L303:AppBar.kt#jmzs0o");
                                if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1296061040, $changed3, -1, "androidx.compose.material.AppBar.<anonymous>.<anonymous> (AppBar.kt:520)");
                                    }
                                    Modifier padding = PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), PaddingValues.this);
                                    f = AppBarKt.AppBarHeight;
                                    Modifier modifier$iv = SizeKt.m786height3ABfNKs(padding, f);
                                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                    Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                                    Function3 content$iv = function32;
                                    int $changed$iv = ((i3 >> 9) & 7168) | 432;
                                    $composer4.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation($composer4, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & SdkConfig.SDK_VERSION));
                                    int $changed$iv$iv = ($changed$iv << 3) & SdkConfig.SDK_VERSION;
                                    $composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume = $composer4.consume(localDensity);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    Density density$iv$iv = (Density) consume;
                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume2 = $composer4.consume(localLayoutDirection);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume3 = $composer4.consume(localViewConfiguration);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                                    Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
                                    Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                                    int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                    if (!($composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer4.startReusableNode();
                                    if ($composer4.getInserting()) {
                                        $composer4.createNode(factory$iv$iv$iv);
                                    } else {
                                        $composer4.useNode();
                                    }
                                    $composer4.disableReusing();
                                    Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer4);
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
                                    $composer4.enableReusing();
                                    skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                                    $composer4.startReplaceableGroup(2058660585);
                                    $composer4.startReplaceableGroup(-678309503);
                                    ComposerKt.sourceInformation($composer4, "C80@3988L9:Row.kt#2w3rfo");
                                    if ((($changed$iv$iv$iv >> 9) & 14 & 11) == 2 && $composer4.getSkipping()) {
                                        $composer4.skipToGroupEnd();
                                    } else {
                                        content$iv.invoke(RowScopeInstance.INSTANCE, $composer4, Integer.valueOf((($changed$iv >> 6) & SdkConfig.SDK_VERSION) | 6));
                                    }
                                    $composer4.endReplaceableGroup();
                                    $composer4.endReplaceableGroup();
                                    $composer4.endNode();
                                    $composer4.endReplaceableGroup();
                                    $composer4.endReplaceableGroup();
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
            }), $composer2, (($dirty >> 15) & 14) | 1572864 | (($dirty >> 9) & SdkConfig.SDK_VERSION) | (($dirty << 6) & 896) | (($dirty << 6) & 7168) | (($dirty << 9) & 458752), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
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

            public final void invoke(Composer composer, int i3) {
                AppBarKt.m1227AppBarcelAv9A(backgroundColor, contentColor, elevation, contentPadding, shape, modifier4, function3, composer, $changed | 1, i);
            }
        });
    }

    static {
        Modifier.Companion companion = Modifier.INSTANCE;
        float arg0$iv = C0504Dp.m4382constructorimpl(16);
        float other$iv = AppBarHorizontalPadding;
        TitleInsetWithoutIcon = SizeKt.m805width3ABfNKs(companion, C0504Dp.m4382constructorimpl(arg0$iv - other$iv));
        Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
        float arg0$iv2 = C0504Dp.m4382constructorimpl(72);
        float other$iv2 = AppBarHorizontalPadding;
        TitleIconModifier = SizeKt.m805width3ABfNKs(fillMaxHeight$default, C0504Dp.m4382constructorimpl(arg0$iv2 - other$iv2));
        BottomAppBarCutoutOffset = C0504Dp.m4382constructorimpl(8);
        BottomAppBarRoundedEdgeRadius = C0504Dp.m4382constructorimpl(4);
    }
}
