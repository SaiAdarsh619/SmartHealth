package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
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

/* compiled from: FloatingActionButton.kt */
@Metadata(m286d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0089\u0001\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001ar\u0010\u001a\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\nH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, m287d2 = {"ExtendedFabIconPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExtendedFabSize", "ExtendedFabTextPadding", "FabSize", "ExtendedFloatingActionButton", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "onClick", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "ExtendedFloatingActionButton-wqdebIU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Landroidx/compose/runtime/Composer;II)V", "FloatingActionButton", "content", "FloatingActionButton-bogVsAg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class FloatingActionButtonKt {
    private static final float FabSize = C0504Dp.m4382constructorimpl(56);
    private static final float ExtendedFabSize = C0504Dp.m4382constructorimpl(48);
    private static final float ExtendedFabIconPadding = C0504Dp.m4382constructorimpl(12);
    private static final float ExtendedFabTextPadding = C0504Dp.m4382constructorimpl(20);

    /* JADX WARN: Removed duplicated region for block: B:100:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x022b  */
    /* renamed from: FloatingActionButton-bogVsAg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1412FloatingActionButtonbogVsAg(final Function0<Unit> onClick, Modifier modifier, MutableInteractionSource interactionSource, Shape shape, long backgroundColor, long contentColor, FloatingActionButtonElevation elevation, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        MutableInteractionSource mutableInteractionSource;
        Shape shape2;
        long backgroundColor2;
        final long contentColor2;
        Modifier modifier2;
        MutableInteractionSource interactionSource2;
        Shape shape3;
        int $dirty;
        long backgroundColor3;
        FloatingActionButtonElevation elevation2;
        MutableInteractionSource interactionSource3;
        final int $dirty2;
        Object value$iv$iv;
        FloatingActionButtonElevation elevation3;
        long contentColor3;
        Composer $composer2;
        ScopeUpdateScope endRestartGroup;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(1028985328);
        ComposerKt.sourceInformation($composer3, "C(FloatingActionButton)P(6,5,4,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)81@3832L39,82@3906L6,83@3994L6,84@4038L32,85@4148L11,94@4393L28,88@4205L685:FloatingActionButton.kt#jmzs0o");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changed(onClick) ? 4 : 2;
        }
        int i7 = i & 2;
        if (i7 != 0) {
            $dirty3 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 32 : 16;
        }
        int i8 = i & 4;
        if (i8 != 0) {
            $dirty3 |= 384;
            mutableInteractionSource = interactionSource;
        } else if (($changed & 896) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty3 |= $composer3.changed(mutableInteractionSource) ? 256 : 128;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                shape2 = shape;
                if ($composer3.changed(shape2)) {
                    i6 = 2048;
                    $dirty3 |= i6;
                }
            } else {
                shape2 = shape;
            }
            i6 = 1024;
            $dirty3 |= i6;
        } else {
            shape2 = shape;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                backgroundColor2 = backgroundColor;
                if ($composer3.changed(backgroundColor2)) {
                    i5 = 16384;
                    $dirty3 |= i5;
                }
            } else {
                backgroundColor2 = backgroundColor;
            }
            i5 = 8192;
            $dirty3 |= i5;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                contentColor2 = contentColor;
                if ($composer3.changed(contentColor2)) {
                    i4 = 131072;
                    $dirty3 |= i4;
                }
            } else {
                contentColor2 = contentColor;
            }
            i4 = 65536;
            $dirty3 |= i4;
        } else {
            contentColor2 = contentColor;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0 && $composer3.changed(elevation)) {
                i3 = 1048576;
                $dirty3 |= i3;
            }
            i3 = 524288;
            $dirty3 |= i3;
        }
        if ((i & 128) == 0) {
            i2 = (29360128 & $changed) == 0 ? $composer3.changed(content) ? 8388608 : 4194304 : 12582912;
            if ((23967451 & $dirty3) == 4793490 || !$composer3.getSkipping()) {
                $composer3.startDefaults();
                if (($changed & 1) != 0 || $composer3.getDefaultsInvalid()) {
                    Modifier.Companion modifier3 = i7 == 0 ? Modifier.INSTANCE : modifier;
                    if (i8 == 0) {
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                        modifier2 = modifier3;
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
                        modifier2 = modifier3;
                        interactionSource2 = mutableInteractionSource;
                    }
                    if ((i & 8) == 0) {
                        $dirty3 &= -7169;
                        shape3 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    } else {
                        shape3 = shape2;
                    }
                    if ((i & 16) != 0) {
                        $dirty3 &= -57345;
                        backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1319getSecondary0d7_KjU();
                    }
                    if ((i & 32) == 0) {
                        $dirty = $dirty3 & (-458753);
                        contentColor2 = ColorsKt.m1335contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty3 >> 12) & 14);
                    } else {
                        $dirty = $dirty3;
                    }
                    if ((i & 64) == 0) {
                        backgroundColor3 = backgroundColor2;
                        interactionSource3 = interactionSource2;
                        elevation2 = FloatingActionButtonDefaults.INSTANCE.m1410elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, $composer3, 24576, 15);
                        $dirty2 = $dirty & (-3670017);
                    } else {
                        backgroundColor3 = backgroundColor2;
                        elevation2 = elevation;
                        interactionSource3 = interactionSource2;
                        $dirty2 = $dirty;
                    }
                } else {
                    $composer3.skipToGroupEnd();
                    if ((i & 8) != 0) {
                        $dirty3 &= -7169;
                    }
                    if ((i & 16) != 0) {
                        $dirty3 &= -57345;
                    }
                    if ((i & 32) != 0) {
                        $dirty3 &= -458753;
                    }
                    if ((i & 64) != 0) {
                        modifier2 = modifier;
                        interactionSource3 = mutableInteractionSource;
                        shape3 = shape2;
                        backgroundColor3 = backgroundColor2;
                        elevation2 = elevation;
                        $dirty2 = $dirty3 & (-3670017);
                    } else {
                        modifier2 = modifier;
                        interactionSource3 = mutableInteractionSource;
                        shape3 = shape2;
                        backgroundColor3 = backgroundColor2;
                        elevation2 = elevation;
                        $dirty2 = $dirty3;
                    }
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1028985328, $dirty2, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:78)");
                }
                elevation3 = elevation2;
                contentColor3 = contentColor2;
                $composer2 = $composer3;
                SurfaceKt.m1514SurfaceLPr_se0(onClick, modifier2, false, shape3, backgroundColor3, contentColor2, null, elevation2.elevation(interactionSource3, $composer3, (($dirty2 >> 6) & 14) | (($dirty2 >> 15) & SdkConfig.SDK_VERSION)).getValue().m4396unboximpl(), interactionSource3, ComposableLambdaKt.composableLambda($composer3, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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
                        ComposerKt.sourceInformation($composer4, "C97@4492L392:FloatingActionButton.kt#jmzs0o");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1972871863, $changed2, -1, "androidx.compose.material.FloatingActionButton.<anonymous> (FloatingActionButton.kt:96)");
                            }
                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1998getAlphaimpl(contentColor2)))};
                            final Function2<Composer, Integer, Unit> function2 = content;
                            final int i9 = $dirty2;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer4, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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
                                    ComposerKt.sourceInformation($composer5, "C98@4609L10,98@4578L296:FloatingActionButton.kt#jmzs0o");
                                    if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1867794295, $changed3, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:97)");
                                        }
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography($composer5, 6).getButton();
                                        final Function2<Composer, Integer, Unit> function22 = function2;
                                        final int i10 = i9;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda($composer5, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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
                                                float f;
                                                float f2;
                                                ComposerKt.sourceInformation($composer6, "C99@4646L214:FloatingActionButton.kt#jmzs0o");
                                                if (($changed4 & 11) != 2 || !$composer6.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1567914264, $changed4, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:98)");
                                                    }
                                                    Modifier.Companion companion = Modifier.INSTANCE;
                                                    f = FloatingActionButtonKt.FabSize;
                                                    f2 = FloatingActionButtonKt.FabSize;
                                                    Modifier modifier$iv = SizeKt.m784defaultMinSizeVpY3zN4(companion, f, f2);
                                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                                                    Function2<Composer, Integer, Unit> function23 = function22;
                                                    int i11 = i10;
                                                    $composer6.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation($composer6, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer6, ((54 >> 3) & 14) | ((54 >> 3) & SdkConfig.SDK_VERSION));
                                                    int $changed$iv$iv = (54 << 3) & SdkConfig.SDK_VERSION;
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
                                                    $composer6.startReplaceableGroup(-2137368960);
                                                    ComposerKt.sourceInformation($composer6, "C72@3384L9:Box.kt#2w3rfo");
                                                    if (($changed$iv & 11) == 2 && $composer6.getSkipping()) {
                                                        $composer6.skipToGroupEnd();
                                                    } else {
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        int $changed5 = ((54 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                                        $composer6.startReplaceableGroup(-1049034642);
                                                        ComposerKt.sourceInformation($composer6, "C103@4849L9:FloatingActionButton.kt#jmzs0o");
                                                        if (($changed5 & 81) == 16 && $composer6.getSkipping()) {
                                                            $composer6.skipToGroupEnd();
                                                        } else {
                                                            function23.invoke($composer6, Integer.valueOf((i11 >> 21) & 14));
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
                }), $composer2, ($dirty2 & 14) | 805306368 | ($dirty2 & SdkConfig.SDK_VERSION) | ($dirty2 & 7168) | (57344 & $dirty2) | (458752 & $dirty2) | (($dirty2 << 18) & 234881024), 68);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer3.skipToGroupEnd();
                modifier2 = modifier;
                elevation3 = elevation;
                interactionSource3 = mutableInteractionSource;
                shape3 = shape2;
                backgroundColor3 = backgroundColor2;
                contentColor3 = contentColor2;
                $composer2 = $composer3;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Modifier modifier4 = modifier2;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
            final Shape shape4 = shape3;
            final long j = backgroundColor3;
            final long j2 = contentColor3;
            final FloatingActionButtonElevation floatingActionButtonElevation = elevation3;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3
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
                    FloatingActionButtonKt.m1412FloatingActionButtonbogVsAg(onClick, modifier4, mutableInteractionSource2, shape4, j, j2, floatingActionButtonElevation, content, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty3 |= i2;
        if ((23967451 & $dirty3) == 4793490) {
        }
        $composer3.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
        if ((i & 8) == 0) {
        }
        if ((i & 16) != 0) {
        }
        if ((i & 32) == 0) {
        }
        if ((i & 64) == 0) {
        }
        $composer3.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        elevation3 = elevation2;
        contentColor3 = contentColor2;
        $composer2 = $composer3;
        SurfaceKt.m1514SurfaceLPr_se0(onClick, modifier2, false, shape3, backgroundColor3, contentColor2, null, elevation2.elevation(interactionSource3, $composer3, (($dirty2 >> 6) & 14) | (($dirty2 >> 15) & SdkConfig.SDK_VERSION)).getValue().m4396unboximpl(), interactionSource3, ComposableLambdaKt.composableLambda($composer3, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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
                ComposerKt.sourceInformation($composer4, "C97@4492L392:FloatingActionButton.kt#jmzs0o");
                if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1972871863, $changed2, -1, "androidx.compose.material.FloatingActionButton.<anonymous> (FloatingActionButton.kt:96)");
                    }
                    ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1998getAlphaimpl(contentColor2)))};
                    final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                    final int i9 = $dirty2;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer4, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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
                            ComposerKt.sourceInformation($composer5, "C98@4609L10,98@4578L296:FloatingActionButton.kt#jmzs0o");
                            if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1867794295, $changed3, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:97)");
                                }
                                TextStyle button = MaterialTheme.INSTANCE.getTypography($composer5, 6).getButton();
                                final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                                final int i10 = i9;
                                TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda($composer5, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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
                                        float f;
                                        float f2;
                                        ComposerKt.sourceInformation($composer6, "C99@4646L214:FloatingActionButton.kt#jmzs0o");
                                        if (($changed4 & 11) != 2 || !$composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1567914264, $changed4, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:98)");
                                            }
                                            Modifier.Companion companion = Modifier.INSTANCE;
                                            f = FloatingActionButtonKt.FabSize;
                                            f2 = FloatingActionButtonKt.FabSize;
                                            Modifier modifier$iv = SizeKt.m784defaultMinSizeVpY3zN4(companion, f, f2);
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                                            Function2<Composer, Integer, Unit> function23 = function22;
                                            int i11 = i10;
                                            $composer6.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer6, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer6, ((54 >> 3) & 14) | ((54 >> 3) & SdkConfig.SDK_VERSION));
                                            int $changed$iv$iv = (54 << 3) & SdkConfig.SDK_VERSION;
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
                                            $composer6.startReplaceableGroup(-2137368960);
                                            ComposerKt.sourceInformation($composer6, "C72@3384L9:Box.kt#2w3rfo");
                                            if (($changed$iv & 11) == 2 && $composer6.getSkipping()) {
                                                $composer6.skipToGroupEnd();
                                            } else {
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int $changed5 = ((54 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                                $composer6.startReplaceableGroup(-1049034642);
                                                ComposerKt.sourceInformation($composer6, "C103@4849L9:FloatingActionButton.kt#jmzs0o");
                                                if (($changed5 & 81) == 16 && $composer6.getSkipping()) {
                                                    $composer6.skipToGroupEnd();
                                                } else {
                                                    function23.invoke($composer6, Integer.valueOf((i11 >> 21) & 14));
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
        }), $composer2, ($dirty2 & 14) | 805306368 | ($dirty2 & SdkConfig.SDK_VERSION) | ($dirty2 & 7168) | (57344 & $dirty2) | (458752 & $dirty2) | (($dirty2 << 18) & 234881024), 68);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* renamed from: ExtendedFloatingActionButton-wqdebIU, reason: not valid java name */
    public static final void m1411ExtendedFloatingActionButtonwqdebIU(final Function2<? super Composer, ? super Integer, Unit> text, final Function0<Unit> onClick, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, MutableInteractionSource interactionSource, Shape shape, long backgroundColor, long contentColor, FloatingActionButtonElevation elevation, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2 icon;
        MutableInteractionSource interactionSource2;
        long backgroundColor2;
        int $dirty;
        FloatingActionButtonElevation floatingActionButtonElevation;
        CornerBasedShape shape2;
        long contentColor2;
        Shape shape3;
        long contentColor3;
        FloatingActionButtonElevation elevation2;
        MutableInteractionSource interactionSource3;
        long backgroundColor3;
        final int $dirty2;
        Modifier modifier3;
        final Function2 icon2;
        Object value$iv$iv;
        Function2 icon3;
        Composer $composer2;
        int i2;
        int $dirty3;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer3 = $composer.startRestartGroup(-1555720195);
        ComposerKt.sourceInformation($composer3, "C(ExtendedFloatingActionButton)P(8,6,5,3,4,7,0:c#ui.graphics.Color,1:c#ui.graphics.Color)148@7090L39,149@7164L6,150@7252L6,151@7296L32,152@7406L11,154@7426L849:FloatingActionButton.kt#jmzs0o");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer3.changed(text) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty4 |= $composer3.changed(onClick) ? 32 : 16;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty4 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty4 |= 3072;
            icon = function2;
        } else if (($changed & 7168) == 0) {
            icon = function2;
            $dirty4 |= $composer3.changed(icon) ? 2048 : 1024;
        } else {
            icon = function2;
        }
        int i8 = i & 16;
        if (i8 != 0) {
            $dirty4 |= 24576;
            interactionSource2 = interactionSource;
        } else if (($changed & 57344) == 0) {
            interactionSource2 = interactionSource;
            $dirty4 |= $composer3.changed(interactionSource2) ? 16384 : 8192;
        } else {
            interactionSource2 = interactionSource;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0 && $composer3.changed(shape)) {
                i5 = 131072;
                $dirty4 |= i5;
            }
            i5 = 65536;
            $dirty4 |= i5;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                backgroundColor2 = backgroundColor;
                if ($composer3.changed(backgroundColor2)) {
                    i4 = 1048576;
                    $dirty4 |= i4;
                }
            } else {
                backgroundColor2 = backgroundColor;
            }
            i4 = 524288;
            $dirty4 |= i4;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0) {
                $dirty3 = $dirty4;
                if ($composer3.changed(contentColor)) {
                    i3 = 8388608;
                    $dirty = $dirty3 | i3;
                }
            } else {
                $dirty3 = $dirty4;
            }
            i3 = 4194304;
            $dirty = $dirty3 | i3;
        } else {
            $dirty = $dirty4;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0) {
                floatingActionButtonElevation = elevation;
                if ($composer3.changed(floatingActionButtonElevation)) {
                    i2 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    $dirty |= i2;
                }
            } else {
                floatingActionButtonElevation = elevation;
            }
            i2 = 33554432;
            $dirty |= i2;
        } else {
            floatingActionButtonElevation = elevation;
        }
        if (($dirty & 191739611) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            shape3 = shape;
            contentColor3 = contentColor;
            icon3 = icon;
            elevation2 = floatingActionButtonElevation;
            interactionSource3 = interactionSource2;
            backgroundColor3 = backgroundColor2;
            $composer2 = $composer3;
            modifier3 = modifier2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i7 != 0) {
                    icon = null;
                }
                if (i8 != 0) {
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
                }
                if ((i & 32) != 0) {
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    $dirty &= -458753;
                } else {
                    shape2 = shape;
                }
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1319getSecondary0d7_KjU();
                }
                if ((i & 128) != 0) {
                    contentColor2 = ColorsKt.m1335contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty >> 18) & 14);
                    $dirty &= -29360129;
                } else {
                    contentColor2 = contentColor;
                }
                if ((i & 256) != 0) {
                    int i9 = $dirty & (-234881025);
                    shape3 = shape2;
                    contentColor3 = contentColor2;
                    modifier3 = modifier2;
                    elevation2 = FloatingActionButtonDefaults.INSTANCE.m1410elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, $composer3, 24576, 15);
                    interactionSource3 = interactionSource2;
                    backgroundColor3 = backgroundColor2;
                    icon2 = icon;
                    $dirty2 = i9;
                } else {
                    shape3 = shape2;
                    contentColor3 = contentColor2;
                    elevation2 = floatingActionButtonElevation;
                    interactionSource3 = interactionSource2;
                    backgroundColor3 = backgroundColor2;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                    icon2 = icon;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    int i10 = $dirty & (-234881025);
                    shape3 = shape;
                    contentColor3 = contentColor;
                    modifier3 = modifier2;
                    elevation2 = floatingActionButtonElevation;
                    interactionSource3 = interactionSource2;
                    backgroundColor3 = backgroundColor2;
                    $dirty2 = i10;
                    icon2 = icon;
                } else {
                    shape3 = shape;
                    contentColor3 = contentColor;
                    elevation2 = floatingActionButtonElevation;
                    interactionSource3 = interactionSource2;
                    backgroundColor3 = backgroundColor2;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                    icon2 = icon;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1555720195, $dirty2, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:143)");
            }
            icon3 = icon2;
            $composer2 = $composer3;
            m1412FloatingActionButtonbogVsAg(onClick, SizeKt.m804sizeInqDBjuR0$default(modifier3, ExtendedFabSize, ExtendedFabSize, 0.0f, 0.0f, 12, null), interactionSource3, shape3, backgroundColor3, contentColor3, elevation2, ComposableLambdaKt.composableLambda($composer3, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                    float f;
                    float f2;
                    ComposerKt.sourceInformation($composer4, "C167@7894L375:FloatingActionButton.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1418981691, $changed2, -1, "androidx.compose.material.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:165)");
                        }
                        float startPadding = icon2 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding;
                        Modifier.Companion companion = Modifier.INSTANCE;
                        f = FloatingActionButtonKt.ExtendedFabTextPadding;
                        Modifier modifier$iv = PaddingKt.m763paddingqDBjuR0$default(companion, startPadding, 0.0f, f, 0.0f, 10, null);
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function2<Composer, Integer, Unit> function22 = icon2;
                        int i11 = $dirty2;
                        Function2<Composer, Integer, Unit> function23 = text;
                        $composer4.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation($composer4, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv = (384 << 3) & SdkConfig.SDK_VERSION;
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
                        Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
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
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer4.enableReusing();
                        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                        $composer4.startReplaceableGroup(2058660585);
                        int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                        $composer4.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation($composer4, "C80@3988L9:Row.kt#2w3rfo");
                        if (($changed$iv & 11) == 2 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                        } else {
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            int $changed3 = ((384 >> 6) & SdkConfig.SDK_VERSION) | 6;
                            $composer4.startReplaceableGroup(-388203689);
                            ComposerKt.sourceInformation($composer4, "C178@8253L6:FloatingActionButton.kt#jmzs0o");
                            if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                                $composer4.startReplaceableGroup(-1435223762);
                                ComposerKt.sourceInformation($composer4, "175@8157L6,176@8180L46");
                                if (function22 != null) {
                                    function22.invoke($composer4, Integer.valueOf((i11 >> 9) & 14));
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    f2 = FloatingActionButtonKt.ExtendedFabIconPadding;
                                    SpacerKt.Spacer(SizeKt.m805width3ABfNKs(companion2, f2), $composer4, 6);
                                }
                                $composer4.endReplaceableGroup();
                                function23.invoke($composer4, Integer.valueOf(i11 & 14));
                            } else {
                                $composer4.skipToGroupEnd();
                            }
                            $composer4.endReplaceableGroup();
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
            }), $composer3, (($dirty2 >> 3) & 14) | 12582912 | (($dirty2 >> 6) & 896) | (($dirty2 >> 6) & 7168) | (($dirty2 >> 6) & 57344) | (($dirty2 >> 6) & 458752) | (($dirty2 >> 6) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final Function2 function22 = icon3;
        final MutableInteractionSource mutableInteractionSource = interactionSource3;
        final Shape shape4 = shape3;
        final long j = backgroundColor3;
        final long j2 = contentColor3;
        final FloatingActionButtonElevation floatingActionButtonElevation2 = elevation2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$3
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
                FloatingActionButtonKt.m1411ExtendedFloatingActionButtonwqdebIU(text, onClick, modifier4, function22, mutableInteractionSource, shape4, j, j2, floatingActionButtonElevation2, composer, $changed | 1, i);
            }
        });
    }
}
