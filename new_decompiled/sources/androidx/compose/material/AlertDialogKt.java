package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.p000ui.unit.TextUnitKt;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: AlertDialog.kt */
@Metadata(m286d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a~\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a8\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a;\u0010\u001e\u001a\u00020\t*\u00020\u001f2\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010 \"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, m287d2 = {"TextBaselineDistanceFromTitle", "Landroidx/compose/ui/unit/TextUnit;", "J", "TextBaselineDistanceFromTop", "TextPadding", "Landroidx/compose/ui/Modifier;", "TitleBaselineDistanceFromTop", "TitlePadding", "AlertDialogContent", "", "buttons", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "AlertDialogContent-WMdw5o4", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/runtime/Composer;II)V", "AlertDialogFlowRow", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "AlertDialogBaselineLayout", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AlertDialogKt {
    private static final Modifier TitlePadding = PaddingKt.m763paddingqDBjuR0$default(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(24), 0.0f, C0504Dp.m4382constructorimpl(24), 0.0f, 10, null);
    private static final Modifier TextPadding = PaddingKt.m763paddingqDBjuR0$default(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(24), 0.0f, C0504Dp.m4382constructorimpl(24), C0504Dp.m4382constructorimpl(28), 2, null);
    private static final long TitleBaselineDistanceFromTop = TextUnitKt.getSp(40);
    private static final long TextBaselineDistanceFromTitle = TextUnitKt.getSp(36);
    private static final long TextBaselineDistanceFromTop = TextUnitKt.getSp(38);

    /* renamed from: AlertDialogContent-WMdw5o4, reason: not valid java name */
    public static final void m1220AlertDialogContentWMdw5o4(final Function2<? super Composer, ? super Integer, Unit> buttons, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, long backgroundColor, long contentColor, Composer $composer, final int $changed, final int i) {
        final Function2 title;
        final Function2 text;
        Shape shape2;
        long backgroundColor2;
        long j;
        Modifier.Companion modifier2;
        final int $dirty;
        long contentColor2;
        Modifier modifier3;
        long contentColor3;
        Function2 title2;
        Function2 text2;
        Shape shape3;
        long backgroundColor3;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Composer $composer2 = $composer.startRestartGroup(-453679601);
        ComposerKt.sourceInformation($composer2, "C(AlertDialogContent)P(1,3,6,5,4,0:c#ui.graphics.Color,2:c#ui.graphics.Color)48@1896L6,49@1954L6,50@1996L32,52@2038L1047:AlertDialog.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(buttons) ? 4 : 2;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty2 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
            title = function2;
        } else if (($changed & 896) == 0) {
            title = function2;
            $dirty2 |= $composer2.changed(title) ? 256 : 128;
        } else {
            title = function2;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            text = function22;
        } else if (($changed & 7168) == 0) {
            text = function22;
            $dirty2 |= $composer2.changed(text) ? 2048 : 1024;
        } else {
            text = function22;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                if ($composer2.changed(shape2)) {
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
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                backgroundColor2 = backgroundColor;
                if ($composer2.changed(backgroundColor2)) {
                    i3 = 131072;
                    $dirty2 |= i3;
                }
            } else {
                backgroundColor2 = backgroundColor;
            }
            i3 = 65536;
            $dirty2 |= i3;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((3670016 & $changed) == 0) {
            if ((i & 64) == 0) {
                j = contentColor;
                if ($composer2.changed(j)) {
                    i2 = 1048576;
                    $dirty2 |= i2;
                }
            } else {
                j = contentColor;
            }
            i2 = 524288;
            $dirty2 |= i2;
        } else {
            j = contentColor;
        }
        if (($dirty2 & 2995931) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            text2 = text;
            shape3 = shape2;
            backgroundColor3 = backgroundColor2;
            contentColor3 = j;
            modifier3 = modifier;
            title2 = title;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i5 != 0 ? Modifier.INSTANCE : modifier;
                if (i6 != 0) {
                    title = null;
                }
                if (i7 != 0) {
                    text = null;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getMedium();
                }
                if ((i & 32) != 0) {
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1321getSurface0d7_KjU();
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-3670017);
                    contentColor2 = ColorsKt.m1335contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 15) & 14);
                } else {
                    $dirty = $dirty2;
                    contentColor2 = j;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-3670017);
                    contentColor2 = j;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    $dirty = $dirty2;
                    contentColor2 = j;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-453679601, $dirty, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
            }
            SurfaceKt.m1513SurfaceFjzlyU(modifier2, shape2, backgroundColor2, contentColor2, null, 0.0f, ComposableLambdaKt.composableLambda($composer2, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                    ComposerKt.sourceInformation($composer3, "C58@2184L895:AlertDialog.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(629950291, $changed2, -1, "androidx.compose.material.AlertDialogContent.<anonymous> (AlertDialog.kt:57)");
                        }
                        final Function2<Composer, Integer, Unit> function23 = title;
                        final Function2<Composer, Integer, Unit> function24 = text;
                        Function2<Composer, Integer, Unit> function25 = buttons;
                        final int i8 = $dirty;
                        $composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation($composer3, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv = (0 << 3) & SdkConfig.SDK_VERSION;
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
                        } else {
                            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                            int $changed3 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                            ColumnScope $this$invoke_u24lambda_u2d2 = columnScope;
                            $composer3.startReplaceableGroup(523699273);
                            ComposerKt.sourceInformation($composer3, "C59@2205L842,79@3060L9:AlertDialog.kt#jmzs0o");
                            int $dirty3 = $changed3;
                            if (($changed3 & 14) == 0) {
                                $dirty3 |= $composer3.changed($this$invoke_u24lambda_u2d2) ? 4 : 2;
                            }
                            if (($dirty3 & 91) != 18 || !$composer3.getSkipping()) {
                                AlertDialogKt.AlertDialogBaselineLayout($this$invoke_u24lambda_u2d2, function23 != null ? ComposableLambdaKt.composableLambda($composer3, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                                    public final void invoke(Composer $composer4, int $changed4) {
                                        ComposerKt.sourceInformation($composer4, "C62@2392L4,62@2327L240:AlertDialog.kt#jmzs0o");
                                        if (($changed4 & 11) != 2 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(620104160, $changed4, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:61)");
                                            }
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh($composer4, 6)))};
                                            final Function2<Composer, Integer, Unit> function26 = function23;
                                            final int i9 = i8;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer4, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                                public final void invoke(Composer $composer5, int $changed5) {
                                                    ComposerKt.sourceInformation($composer5, "C63@2458L10,64@2507L34:AlertDialog.kt#jmzs0o");
                                                    if (($changed5 & 11) != 2 || !$composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(770166432, $changed5, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:62)");
                                                        }
                                                        TextStyle textStyle = MaterialTheme.INSTANCE.getTypography($composer5, 6).getSubtitle1();
                                                        TextKt.ProvideTextStyle(textStyle, function26, $composer5, (i9 >> 3) & SdkConfig.SDK_VERSION);
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
                                }) : null, function24 != null ? ComposableLambdaKt.composableLambda($composer3, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                                    public final void invoke(Composer $composer4, int $changed4) {
                                        ComposerKt.sourceInformation($composer4, "C71@2796L6,70@2702L291:AlertDialog.kt#jmzs0o");
                                        if (($changed4 & 11) != 2 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1965858367, $changed4, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:69)");
                                            }
                                            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium($composer4, 6)))};
                                            final Function2<Composer, Integer, Unit> function26 = function24;
                                            final int i9 = i8;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer4, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                                public final void invoke(Composer $composer5, int $changed5) {
                                                    ComposerKt.sourceInformation($composer5, "C73@2889L10,74@2934L33:AlertDialog.kt#jmzs0o");
                                                    if (($changed5 & 11) != 2 || !$composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(2115920639, $changed5, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:72)");
                                                        }
                                                        TextStyle textStyle = MaterialTheme.INSTANCE.getTypography($composer5, 6).getBody2();
                                                        TextKt.ProvideTextStyle(textStyle, function26, $composer5, (i9 >> 6) & SdkConfig.SDK_VERSION);
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
                                }) : null, $composer3, $dirty3 & 14);
                                function25.invoke($composer3, Integer.valueOf(i8 & 14));
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
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, (($dirty >> 3) & 14) | 1572864 | (($dirty >> 9) & SdkConfig.SDK_VERSION) | (($dirty >> 9) & 896) | (($dirty >> 9) & 7168), 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            contentColor3 = contentColor2;
            title2 = title;
            text2 = text;
            shape3 = shape2;
            backgroundColor3 = backgroundColor2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final Function2 function23 = title2;
        final Function2 function24 = text2;
        final Shape shape4 = shape3;
        final long j2 = backgroundColor3;
        final long j3 = contentColor3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$2
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
                AlertDialogKt.m1220AlertDialogContentWMdw5o4(buttons, modifier4, function23, function24, shape4, j2, j3, composer, $changed | 1, i);
            }
        });
    }

    public static final void AlertDialogBaselineLayout(final ColumnScope $this$AlertDialogBaselineLayout, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed) {
        Function0 factory$iv$iv;
        Intrinsics.checkNotNullParameter($this$AlertDialogBaselineLayout, "<this>");
        Composer $composer2 = $composer.startRestartGroup(-555573207);
        ComposerKt.sourceInformation($composer2, "C(AlertDialogBaselineLayout)P(1)96@3561L3479:AlertDialog.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed($this$AlertDialogBaselineLayout) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(function2) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(function22) ? 256 : 128;
        }
        if (($dirty & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-555573207, $changed, -1, "androidx.compose.material.AlertDialogBaselineLayout (AlertDialog.kt:92)");
            }
            Modifier modifier$iv = $this$AlertDialogBaselineLayout.weight(Modifier.INSTANCE, 1.0f, false);
            MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2
                /* JADX WARN: Removed duplicated region for block: B:33:0x00c3  */
                /* JADX WARN: Removed duplicated region for block: B:40:0x00eb  */
                /* JADX WARN: Removed duplicated region for block: B:47:0x0109  */
                /* JADX WARN: Removed duplicated region for block: B:50:0x011e  */
                /* JADX WARN: Removed duplicated region for block: B:53:0x012b  */
                /* JADX WARN: Removed duplicated region for block: B:56:0x013e  */
                /* JADX WARN: Removed duplicated region for block: B:66:0x012e  */
                /* JADX WARN: Removed duplicated region for block: B:69:0x0126  */
                /* JADX WARN: Removed duplicated region for block: B:70:0x0112  */
                @Override // androidx.compose.p000ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final MeasureResult mo331measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long constraints) {
                    Object element$iv;
                    Placeable placeable;
                    Object element$iv2;
                    Placeable placeable2;
                    int i;
                    int firstTitleBaseline;
                    int i2;
                    long j;
                    int i3;
                    long j2;
                    int i4;
                    long j3;
                    long m4328copyZbe2FdA;
                    long m4328copyZbe2FdA2;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    List<? extends Measurable> $this$firstOrNull$iv = measurables;
                    Iterator it = $this$firstOrNull$iv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            element$iv = null;
                            break;
                        }
                        element$iv = it.next();
                        Measurable it2 = (Measurable) element$iv;
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it2), "title")) {
                            break;
                        }
                    }
                    Measurable measurable = (Measurable) element$iv;
                    if (measurable != null) {
                        m4328copyZbe2FdA2 = Constraints.m4328copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m4340getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m4338getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m4339getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m4337getMaxHeightimpl(constraints) : 0);
                        placeable = measurable.mo3492measureBRTryo0(m4328copyZbe2FdA2);
                    } else {
                        placeable = null;
                    }
                    final Placeable titlePlaceable = placeable;
                    List<? extends Measurable> $this$firstOrNull$iv2 = measurables;
                    Iterator it3 = $this$firstOrNull$iv2.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            element$iv2 = null;
                            break;
                        }
                        element$iv2 = it3.next();
                        Measurable it4 = (Measurable) element$iv2;
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it4), "text")) {
                            break;
                        }
                    }
                    Measurable measurable2 = (Measurable) element$iv2;
                    if (measurable2 != null) {
                        m4328copyZbe2FdA = Constraints.m4328copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m4340getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m4338getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m4339getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m4337getMaxHeightimpl(constraints) : 0);
                        placeable2 = measurable2.mo3492measureBRTryo0(m4328copyZbe2FdA);
                    } else {
                        placeable2 = null;
                    }
                    final Placeable textPlaceable = placeable2;
                    int layoutWidth = Math.max(titlePlaceable != null ? titlePlaceable.getWidth() : 0, textPlaceable != null ? textPlaceable.getWidth() : 0);
                    if (titlePlaceable != null) {
                        int baseline = titlePlaceable.get(AlignmentLineKt.getFirstBaseline());
                        Integer valueOf = baseline == Integer.MIN_VALUE ? null : Integer.valueOf(baseline);
                        if (valueOf != null) {
                            i = valueOf.intValue();
                            firstTitleBaseline = i;
                            if (titlePlaceable != null) {
                                int baseline2 = titlePlaceable.get(AlignmentLineKt.getLastBaseline());
                                Integer valueOf2 = baseline2 == Integer.MIN_VALUE ? null : Integer.valueOf(baseline2);
                                if (valueOf2 != null) {
                                    i2 = valueOf2.intValue();
                                    int lastTitleBaseline = i2;
                                    j = AlertDialogKt.TitleBaselineDistanceFromTop;
                                    int titleOffset = Layout.mo641roundToPxR2X_6o(j);
                                    final int titlePositionY = titleOffset - firstTitleBaseline;
                                    if (textPlaceable != null) {
                                        int baseline3 = textPlaceable.get(AlignmentLineKt.getFirstBaseline());
                                        Integer valueOf3 = baseline3 != Integer.MIN_VALUE ? Integer.valueOf(baseline3) : null;
                                        if (valueOf3 != null) {
                                            i3 = valueOf3.intValue();
                                            int firstTextBaseline = i3;
                                            if (titlePlaceable != null) {
                                                j3 = AlertDialogKt.TextBaselineDistanceFromTop;
                                                i4 = Layout.mo641roundToPxR2X_6o(j3);
                                            } else {
                                                j2 = AlertDialogKt.TextBaselineDistanceFromTitle;
                                                i4 = Layout.mo641roundToPxR2X_6o(j2);
                                            }
                                            int textOffset = i4;
                                            int titleHeightWithSpacing = titlePlaceable == null ? titlePlaceable.getHeight() + titlePositionY : 0;
                                            final int textPositionY = titlePlaceable != null ? textOffset - firstTextBaseline : lastTitleBaseline == 0 ? (titleHeightWithSpacing - firstTextBaseline) + textOffset : ((titlePositionY + lastTitleBaseline) - firstTextBaseline) + textOffset;
                                            if (textPlaceable != null) {
                                                if (lastTitleBaseline == 0) {
                                                    r0 = (textPlaceable.getHeight() + textOffset) - firstTextBaseline;
                                                } else {
                                                    r0 = ((textPlaceable.getHeight() + textOffset) - firstTextBaseline) - ((titlePlaceable != null ? titlePlaceable.getHeight() : 0) - lastTitleBaseline);
                                                }
                                            }
                                            int textHeightWithSpacing = r0;
                                            int layoutHeight = titleHeightWithSpacing + textHeightWithSpacing;
                                            return MeasureScope.layout$default(Layout, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2$measure$1
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
                                                    Placeable placeable3 = Placeable.this;
                                                    if (placeable3 != null) {
                                                        Placeable.PlacementScope.place$default(layout, placeable3, 0, titlePositionY, 0.0f, 4, null);
                                                    }
                                                    Placeable placeable4 = textPlaceable;
                                                    if (placeable4 != null) {
                                                        Placeable.PlacementScope.place$default(layout, placeable4, 0, textPositionY, 0.0f, 4, null);
                                                    }
                                                }
                                            }, 4, null);
                                        }
                                    }
                                    i3 = 0;
                                    int firstTextBaseline2 = i3;
                                    if (titlePlaceable != null) {
                                    }
                                    int textOffset2 = i4;
                                    int titleHeightWithSpacing2 = titlePlaceable == null ? titlePlaceable.getHeight() + titlePositionY : 0;
                                    final int textPositionY2 = titlePlaceable != null ? textOffset2 - firstTextBaseline2 : lastTitleBaseline == 0 ? (titleHeightWithSpacing2 - firstTextBaseline2) + textOffset2 : ((titlePositionY + lastTitleBaseline) - firstTextBaseline2) + textOffset2;
                                    if (textPlaceable != null) {
                                    }
                                    int textHeightWithSpacing2 = r0;
                                    int layoutHeight2 = titleHeightWithSpacing2 + textHeightWithSpacing2;
                                    return MeasureScope.layout$default(Layout, layoutWidth, layoutHeight2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2$measure$1
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
                                            Placeable placeable3 = Placeable.this;
                                            if (placeable3 != null) {
                                                Placeable.PlacementScope.place$default(layout, placeable3, 0, titlePositionY, 0.0f, 4, null);
                                            }
                                            Placeable placeable4 = textPlaceable;
                                            if (placeable4 != null) {
                                                Placeable.PlacementScope.place$default(layout, placeable4, 0, textPositionY2, 0.0f, 4, null);
                                            }
                                        }
                                    }, 4, null);
                                }
                            }
                            i2 = 0;
                            int lastTitleBaseline2 = i2;
                            j = AlertDialogKt.TitleBaselineDistanceFromTop;
                            int titleOffset2 = Layout.mo641roundToPxR2X_6o(j);
                            final int titlePositionY2 = titleOffset2 - firstTitleBaseline;
                            if (textPlaceable != null) {
                            }
                            i3 = 0;
                            int firstTextBaseline22 = i3;
                            if (titlePlaceable != null) {
                            }
                            int textOffset22 = i4;
                            int titleHeightWithSpacing22 = titlePlaceable == null ? titlePlaceable.getHeight() + titlePositionY2 : 0;
                            final int textPositionY22 = titlePlaceable != null ? textOffset22 - firstTextBaseline22 : lastTitleBaseline2 == 0 ? (titleHeightWithSpacing22 - firstTextBaseline22) + textOffset22 : ((titlePositionY2 + lastTitleBaseline2) - firstTextBaseline22) + textOffset22;
                            if (textPlaceable != null) {
                            }
                            int textHeightWithSpacing22 = r0;
                            int layoutHeight22 = titleHeightWithSpacing22 + textHeightWithSpacing22;
                            return MeasureScope.layout$default(Layout, layoutWidth, layoutHeight22, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2$measure$1
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
                                    Placeable placeable3 = Placeable.this;
                                    if (placeable3 != null) {
                                        Placeable.PlacementScope.place$default(layout, placeable3, 0, titlePositionY2, 0.0f, 4, null);
                                    }
                                    Placeable placeable4 = textPlaceable;
                                    if (placeable4 != null) {
                                        Placeable.PlacementScope.place$default(layout, placeable4, 0, textPositionY22, 0.0f, 4, null);
                                    }
                                }
                            }, 4, null);
                        }
                    }
                    i = 0;
                    firstTitleBaseline = i;
                    if (titlePlaceable != null) {
                    }
                    i2 = 0;
                    int lastTitleBaseline22 = i2;
                    j = AlertDialogKt.TitleBaselineDistanceFromTop;
                    int titleOffset22 = Layout.mo641roundToPxR2X_6o(j);
                    final int titlePositionY22 = titleOffset22 - firstTitleBaseline;
                    if (textPlaceable != null) {
                    }
                    i3 = 0;
                    int firstTextBaseline222 = i3;
                    if (titlePlaceable != null) {
                    }
                    int textOffset222 = i4;
                    int titleHeightWithSpacing222 = titlePlaceable == null ? titlePlaceable.getHeight() + titlePositionY22 : 0;
                    final int textPositionY222 = titlePlaceable != null ? textOffset222 - firstTextBaseline222 : lastTitleBaseline22 == 0 ? (titleHeightWithSpacing222 - firstTextBaseline222) + textOffset222 : ((titlePositionY22 + lastTitleBaseline22) - firstTextBaseline222) + textOffset222;
                    if (textPlaceable != null) {
                    }
                    int textHeightWithSpacing222 = r0;
                    int layoutHeight222 = titleHeightWithSpacing222 + textHeightWithSpacing222;
                    return MeasureScope.layout$default(Layout, layoutWidth, layoutHeight222, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2$measure$1
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
                            Placeable placeable3 = Placeable.this;
                            if (placeable3 != null) {
                                Placeable.PlacementScope.place$default(layout, placeable3, 0, titlePositionY22, 0.0f, 4, null);
                            }
                            Placeable placeable4 = textPlaceable;
                            if (placeable4 != null) {
                                Placeable.PlacementScope.place$default(layout, placeable4, 0, textPositionY222, 0.0f, 4, null);
                            }
                        }
                    }, 4, null);
                }
            };
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
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
            $composer2.startReplaceableGroup(1454034642);
            ComposerKt.sourceInformation($composer2, "C*104@3798L103:AlertDialog.kt#jmzs0o");
            if ((($changed$iv$iv >> 9) & 14 & 11) != 2 || !$composer2.getSkipping()) {
                $composer2.startReplaceableGroup(-1160646206);
                ComposerKt.sourceInformation($composer2, "*99@3629L106");
                if (function2 != null) {
                    Modifier modifier$iv2 = $this$AlertDialogBaselineLayout.align(LayoutIdKt.layoutId(TitlePadding, "title"), Alignment.INSTANCE.getStart());
                    $composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv2 = (0 << 3) & SdkConfig.SDK_VERSION;
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
                        int $changed2 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        $composer2.startReplaceableGroup(472489145);
                        ComposerKt.sourceInformation($composer2, "C*100@3710L7:AlertDialog.kt#jmzs0o");
                        if (($changed2 & 81) == 16 && $composer2.getSkipping()) {
                            $composer2.skipToGroupEnd();
                        } else {
                            function2.invoke($composer2, 0);
                        }
                        $composer2.endReplaceableGroup();
                    }
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    $composer2.endNode();
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
                $composer2.endReplaceableGroup();
                if (function22 != null) {
                    Modifier modifier$iv3 = $this$AlertDialogBaselineLayout.align(LayoutIdKt.layoutId(TextPadding, "text"), Alignment.INSTANCE.getStart());
                    $composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv3 = (0 << 3) & SdkConfig.SDK_VERSION;
                    $composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume7 = $composer2.consume(localDensity3);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Density density$iv$iv2 = (Density) consume7;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume8 = $composer2.consume(localLayoutDirection3);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume8;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume9 = $composer2.consume(localViewConfiguration3);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume9;
                    Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv3);
                    int $changed$iv$iv$iv2 = (($changed$iv$iv3 << 9) & 7168) | 6;
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        $composer2.createNode(factory$iv$iv$iv2);
                    } else {
                        $composer2.useNode();
                    }
                    $composer2.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer2);
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    $composer2.enableReusing();
                    skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                    $composer2.startReplaceableGroup(2058660585);
                    int $changed$iv2 = ($changed$iv$iv$iv2 >> 9) & 14;
                    $composer2.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer2, "C72@3384L9:Box.kt#2w3rfo");
                    if (($changed$iv2 & 11) == 2 && $composer2.getSkipping()) {
                        $composer2.skipToGroupEnd();
                    } else {
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        int $changed3 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        $composer2.startReplaceableGroup(-272722206);
                        ComposerKt.sourceInformation($composer2, "C*105@3877L6:AlertDialog.kt#jmzs0o");
                        if (($changed3 & 81) == 16 && $composer2.getSkipping()) {
                            $composer2.skipToGroupEnd();
                        } else {
                            function22.invoke($composer2, 0);
                        }
                        $composer2.endReplaceableGroup();
                    }
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    $composer2.endNode();
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    Unit unit3 = Unit.INSTANCE;
                    Unit unit4 = Unit.INSTANCE;
                }
            } else {
                $composer2.skipToGroupEnd();
            }
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$3
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
                AlertDialogKt.AlertDialogBaselineLayout(ColumnScope.this, function2, function22, composer, $changed | 1);
            }
        });
    }

    /* renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    public static final void m1221AlertDialogFlowRowixp7dh8(final float mainAxisSpacing, final float crossAxisSpacing, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(73434452);
        ComposerKt.sourceInformation($composer2, "C(AlertDialogFlowRow)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp)192@7298L3452:AlertDialog.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(mainAxisSpacing) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(crossAxisSpacing) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(content) ? 256 : 128;
        }
        if (($dirty & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(73434452, $dirty, -1, "androidx.compose.material.AlertDialogFlowRow (AlertDialog.kt:187)");
            }
            MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$1
                @Override // androidx.compose.p000ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo331measure3p2s80s(final MeasureScope Layout, List<? extends Measurable> measurables, long constraints) {
                    final int mainAxisLayoutSize;
                    Ref.IntRef currentCrossAxisSize;
                    Ref.IntRef currentMainAxisSize;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    final List sequences = new ArrayList();
                    List crossAxisSizes = new ArrayList();
                    final List crossAxisPositions = new ArrayList();
                    Ref.IntRef mainAxisSpace = new Ref.IntRef();
                    Ref.IntRef crossAxisSpace = new Ref.IntRef();
                    List currentSequence = new ArrayList();
                    Ref.IntRef currentMainAxisSize2 = new Ref.IntRef();
                    Ref.IntRef currentCrossAxisSize2 = new Ref.IntRef();
                    long childConstraints = ConstraintsKt.Constraints$default(0, Constraints.m4338getMaxWidthimpl(constraints), 0, 0, 13, null);
                    for (Measurable measurable : measurables) {
                        Placeable placeable = measurable.mo3492measureBRTryo0(childConstraints);
                        long childConstraints2 = childConstraints;
                        if (measure_3p2s80s$canAddToCurrentSequence(currentSequence, currentMainAxisSize2, Layout, mainAxisSpacing, constraints, placeable)) {
                            currentCrossAxisSize = currentCrossAxisSize2;
                            currentMainAxisSize = currentMainAxisSize2;
                        } else {
                            currentCrossAxisSize = currentCrossAxisSize2;
                            currentMainAxisSize = currentMainAxisSize2;
                            measure_3p2s80s$startNewSequence(sequences, crossAxisSpace, Layout, crossAxisSpacing, currentSequence, crossAxisSizes, currentCrossAxisSize2, crossAxisPositions, mainAxisSpace, currentMainAxisSize2);
                        }
                        if (currentSequence.isEmpty()) {
                            currentMainAxisSize2 = currentMainAxisSize;
                        } else {
                            currentMainAxisSize2 = currentMainAxisSize;
                            currentMainAxisSize2.element += Layout.mo642roundToPx0680j_4(mainAxisSpacing);
                        }
                        currentSequence.add(placeable);
                        currentMainAxisSize2.element += placeable.getWidth();
                        currentCrossAxisSize.element = Math.max(currentCrossAxisSize.element, placeable.getHeight());
                        currentCrossAxisSize2 = currentCrossAxisSize;
                        childConstraints = childConstraints2;
                    }
                    Ref.IntRef currentCrossAxisSize3 = currentCrossAxisSize2;
                    if (!currentSequence.isEmpty()) {
                        measure_3p2s80s$startNewSequence(sequences, crossAxisSpace, Layout, crossAxisSpacing, currentSequence, crossAxisSizes, currentCrossAxisSize3, crossAxisPositions, mainAxisSpace, currentMainAxisSize2);
                    }
                    if (Constraints.m4338getMaxWidthimpl(constraints) != Integer.MAX_VALUE) {
                        mainAxisLayoutSize = Constraints.m4338getMaxWidthimpl(constraints);
                    } else {
                        mainAxisLayoutSize = Math.max(mainAxisSpace.element, Constraints.m4340getMinWidthimpl(constraints));
                    }
                    int crossAxisLayoutSize = Math.max(crossAxisSpace.element, Constraints.m4339getMinHeightimpl(constraints));
                    int layoutWidth = mainAxisLayoutSize;
                    final float f = mainAxisSpacing;
                    return MeasureScope.layout$default(Layout, layoutWidth, crossAxisLayoutSize, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$1$measure$1
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
                            List $this$fastForEachIndexed$iv = sequences;
                            MeasureScope measureScope = Layout;
                            float f2 = f;
                            int i = mainAxisLayoutSize;
                            List<Integer> list = crossAxisPositions;
                            int size = $this$fastForEachIndexed$iv.size();
                            int index$iv = 0;
                            while (index$iv < size) {
                                Object item$iv = $this$fastForEachIndexed$iv.get(index$iv);
                                List placeables = (List) item$iv;
                                int i2 = index$iv;
                                int size2 = placeables.size();
                                int[] iArr = new int[size2];
                                int i3 = 0;
                                while (i3 < size2) {
                                    iArr[i3] = placeables.get(i3).getWidth() + (i3 < CollectionsKt.getLastIndex(placeables) ? measureScope.mo642roundToPx0680j_4(f2) : 0);
                                    i3++;
                                }
                                int[] childrenMainAxisSizes = iArr;
                                Arrangement.Vertical arrangement = Arrangement.INSTANCE.getBottom();
                                int length = childrenMainAxisSizes.length;
                                int[] iArr2 = new int[length];
                                for (int i4 = 0; i4 < length; i4++) {
                                    iArr2[i4] = 0;
                                }
                                int[] mainAxisPositions = iArr2;
                                arrangement.arrange(measureScope, i, childrenMainAxisSizes, mainAxisPositions);
                                int index$iv2 = 0;
                                int size3 = placeables.size();
                                while (index$iv2 < size3) {
                                    Object item$iv2 = placeables.get(index$iv2);
                                    Placeable placeable2 = (Placeable) item$iv2;
                                    int j = index$iv2;
                                    Placeable.PlacementScope.place$default(layout, placeable2, mainAxisPositions[j], list.get(i2).intValue(), 0.0f, 4, null);
                                    index$iv2++;
                                    childrenMainAxisSizes = childrenMainAxisSizes;
                                    i2 = i2;
                                    index$iv = index$iv;
                                    placeables = placeables;
                                    size3 = size3;
                                    mainAxisPositions = mainAxisPositions;
                                }
                                index$iv++;
                            }
                        }
                    }, 4, null);
                }

                private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, Ref.IntRef currentMainAxisSize, MeasureScope $this_Layout, float $mainAxisSpacing, long $constraints, Placeable placeable) {
                    return list.isEmpty() || (currentMainAxisSize.element + $this_Layout.mo642roundToPx0680j_4($mainAxisSpacing)) + placeable.getWidth() <= Constraints.m4338getMaxWidthimpl($constraints);
                }

                private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> list, Ref.IntRef crossAxisSpace, MeasureScope $this_Layout, float $crossAxisSpacing, List<Placeable> list2, List<Integer> list3, Ref.IntRef currentCrossAxisSize, List<Integer> list4, Ref.IntRef mainAxisSpace, Ref.IntRef currentMainAxisSize) {
                    if (!list.isEmpty()) {
                        crossAxisSpace.element += $this_Layout.mo642roundToPx0680j_4($crossAxisSpacing);
                    }
                    list.add(CollectionsKt.toList(list2));
                    list3.add(Integer.valueOf(currentCrossAxisSize.element));
                    list4.add(Integer.valueOf(crossAxisSpace.element));
                    crossAxisSpace.element += currentCrossAxisSize.element;
                    mainAxisSpace.element = Math.max(mainAxisSpace.element, currentMainAxisSize.element);
                    list2.clear();
                    currentMainAxisSize.element = 0;
                    currentCrossAxisSize.element = 0;
                }
            };
            int $changed$iv = ($dirty >> 6) & 14;
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
            Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv = (($changed$iv << 9) & 7168) | 6;
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
            content.invoke($composer2, Integer.valueOf(($changed$iv$iv >> 9) & 14));
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$2
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
                AlertDialogKt.m1221AlertDialogFlowRowixp7dh8(mainAxisSpacing, crossAxisSpacing, content, composer, $changed | 1);
            }
        });
    }
}
