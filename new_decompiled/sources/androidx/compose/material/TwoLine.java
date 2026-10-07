package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
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
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListItem.kt */
@Metadata(m286d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J~\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010\u001eR\u0019\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0007\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\t\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\n\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\f\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\r\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000e\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000f\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0010\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0011\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0012\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, m287d2 = {"Landroidx/compose/material/TwoLine;", "", "()V", "ContentLeftPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ContentRightPadding", "IconLeftPadding", "IconMinPaddedWidth", "IconVerticalPadding", "MinHeight", "MinHeightWithIcon", "OverlineBaselineOffset", "OverlineToPrimaryBaselineOffset", "PrimaryBaselineOffsetNoIcon", "PrimaryBaselineOffsetWithIcon", "PrimaryToSecondaryBaselineOffsetNoIcon", "PrimaryToSecondaryBaselineOffsetWithIcon", "TrailingRightPadding", "ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "text", "secondaryText", "overlineText", "trailing", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class TwoLine {
    public static final TwoLine INSTANCE = new TwoLine();
    private static final float MinHeight = C0504Dp.m4382constructorimpl(64);
    private static final float MinHeightWithIcon = C0504Dp.m4382constructorimpl(72);
    private static final float IconMinPaddedWidth = C0504Dp.m4382constructorimpl(40);
    private static final float IconLeftPadding = C0504Dp.m4382constructorimpl(16);
    private static final float IconVerticalPadding = C0504Dp.m4382constructorimpl(16);
    private static final float ContentLeftPadding = C0504Dp.m4382constructorimpl(16);
    private static final float ContentRightPadding = C0504Dp.m4382constructorimpl(16);
    private static final float OverlineBaselineOffset = C0504Dp.m4382constructorimpl(24);
    private static final float OverlineToPrimaryBaselineOffset = C0504Dp.m4382constructorimpl(20);
    private static final float PrimaryBaselineOffsetNoIcon = C0504Dp.m4382constructorimpl(28);
    private static final float PrimaryBaselineOffsetWithIcon = C0504Dp.m4382constructorimpl(32);
    private static final float PrimaryToSecondaryBaselineOffsetNoIcon = C0504Dp.m4382constructorimpl(20);
    private static final float PrimaryToSecondaryBaselineOffsetWithIcon = C0504Dp.m4382constructorimpl(20);
    private static final float TrailingRightPadding = C0504Dp.m4382constructorimpl(16);

    private TwoLine() {
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0590  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x04ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void ListItem(Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> text, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final int $dirty;
        int $changed$iv;
        int $changed2;
        RowScope $this$ListItem_u24lambda_u2d1;
        int $dirty2;
        Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i2;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer2 = $composer.startRestartGroup(-1340612993);
        ComposerKt.sourceInformation($composer2, "C(ListItem)P(1!1,4,3)205@7745L2468:ListItem.kt#jmzs0o");
        int $dirty3 = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty3 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty3 |= $composer2.changed(function2) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer2.changed(text) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty3 |= $composer2.changed(function22) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty3 |= 24576;
        } else if ((57344 & $changed) == 0) {
            $dirty3 |= $composer2.changed(function23) ? 16384 : 8192;
        }
        if ((i & 32) == 0) {
            i2 = (458752 & $changed) == 0 ? $composer2.changed(function24) ? 131072 : 65536 : 196608;
            if ((i & 64) == 0) {
                $dirty3 |= 1572864;
            } else if ((3670016 & $changed) == 0) {
                $dirty3 |= $composer2.changed(this) ? 1048576 : 524288;
            }
            $dirty = $dirty3;
            if ((2995931 & $dirty) == 599186 || !$composer2.getSkipping()) {
                Modifier.Companion modifier4 = i3 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1340612993, $dirty, -1, "androidx.compose.material.TwoLine.ListItem (ListItem.kt:196)");
                }
                final float minHeight = function2 != null ? MinHeight : MinHeightWithIcon;
                Modifier modifier$iv = SizeKt.m788heightInVpY3zN4$default(modifier4, minHeight, 0.0f, 2, null);
                $composer2.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation($composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                Modifier modifier5 = modifier4;
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                int $changed$iv$iv = (0 << 3) & SdkConfig.SDK_VERSION;
                $composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density density$iv$iv = (Density) consume;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume2 = $composer2.consume(localLayoutDirection);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume3 = $composer2.consume(localViewConfiguration);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    $composer2.useNode();
                } else {
                    $composer2.createNode(factory$iv$iv$iv);
                }
                $composer2.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer2);
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer2.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                $composer2.startReplaceableGroup(2058660585);
                $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                $composer2.startReplaceableGroup(-678309503);
                ComposerKt.sourceInformation($composer2, "C80@3988L9:Row.kt#2w3rfo");
                if (($changed$iv & 11) == 2 || !$composer2.getSkipping()) {
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    $changed2 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                    $this$ListItem_u24lambda_u2d1 = rowScope;
                    $composer2.startReplaceableGroup(1912737507);
                    ComposerKt.sourceInformation($composer2, "C254@9588L601:ListItem.kt#jmzs0o");
                    $dirty2 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty2 |= $composer2.changed($this$ListItem_u24lambda_u2d1) ? 4 : 2;
                    }
                    if (($dirty2 & 91) == 18 || !$composer2.getSkipping()) {
                        Modifier columnModifier = PaddingKt.m763paddingqDBjuR0$default(RowScope.weight$default($this$ListItem_u24lambda_u2d1, Modifier.INSTANCE, 1.0f, false, 2, null), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, null);
                        $composer2.startReplaceableGroup(-269995367);
                        ComposerKt.sourceInformation($composer2, "210@7969L532");
                        if (function2 == null) {
                            Modifier.Companion companion = Modifier.INSTANCE;
                            float arg0$iv = IconLeftPadding;
                            float other$iv = IconMinPaddedWidth;
                            Modifier modifier$iv2 = PaddingKt.m763paddingqDBjuR0$default(SizeKt.m804sizeInqDBjuR0$default(companion, C0504Dp.m4382constructorimpl(arg0$iv + other$iv), minHeight, 0.0f, 0.0f, 12, null), IconLeftPadding, IconVerticalPadding, 0.0f, IconVerticalPadding, 4, null);
                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                            $composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((48 >> 3) & 14) | ((48 >> 3) & SdkConfig.SDK_VERSION));
                            int $changed$iv$iv2 = (48 << 3) & SdkConfig.SDK_VERSION;
                            $composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume4 = $composer2.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            Density density$iv$iv2 = (Density) consume4;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume5 = $composer2.consume(localLayoutDirection2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume6 = $composer2.consume(localViewConfiguration2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
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
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                int $changed3 = ((48 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                $composer2.startReplaceableGroup(1698757508);
                                ComposerKt.sourceInformation($composer2, "C222@8493L6:ListItem.kt#jmzs0o");
                                if (($changed3 & 81) == 16 && $composer2.getSkipping()) {
                                    $composer2.skipToGroupEnd();
                                } else {
                                    function2.invoke($composer2, Integer.valueOf(($dirty >> 3) & 14));
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
                        if (function23 == null) {
                            $composer2.startReplaceableGroup(-269994745);
                            ComposerKt.sourceInformation($composer2, "226@8573L242");
                            ListItemKt.BaselinesOffsetColumn(CollectionsKt.listOf((Object[]) new C0504Dp[]{C0504Dp.m4380boximpl(OverlineBaselineOffset), C0504Dp.m4380boximpl(OverlineToPrimaryBaselineOffset)}), columnModifier, ComposableLambdaKt.composableLambda($composer2, -1675021441, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TwoLine$ListItem$1$2
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

                                public final void invoke(Composer $composer3, int $changed4) {
                                    ComposerKt.sourceInformation($composer3, "C230@8756L14,231@8791L6:ListItem.kt#jmzs0o");
                                    if (($changed4 & 11) != 2 || !$composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1675021441, $changed4, -1, "androidx.compose.material.TwoLine.ListItem.<anonymous>.<anonymous> (ListItem.kt:229)");
                                        }
                                        function23.invoke($composer3, Integer.valueOf(($dirty >> 12) & 14));
                                        text.invoke($composer3, Integer.valueOf(($dirty >> 6) & 14));
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer3.skipToGroupEnd();
                                }
                            }), $composer2, 384, 0);
                            $composer2.endReplaceableGroup();
                        } else {
                            $composer2.startReplaceableGroup(-269994465);
                            ComposerKt.sourceInformation($composer2, "234@8853L668");
                            C0504Dp[] c0504DpArr = new C0504Dp[2];
                            c0504DpArr[0] = C0504Dp.m4380boximpl(function2 != null ? PrimaryBaselineOffsetWithIcon : PrimaryBaselineOffsetNoIcon);
                            c0504DpArr[1] = C0504Dp.m4380boximpl(function2 != null ? PrimaryToSecondaryBaselineOffsetWithIcon : PrimaryToSecondaryBaselineOffsetNoIcon);
                            ListItemKt.BaselinesOffsetColumn(CollectionsKt.listOf((Object[]) c0504DpArr), columnModifier, ComposableLambdaKt.composableLambda($composer2, 993836488, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TwoLine$ListItem$1$3
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

                                public final void invoke(Composer $composer3, int $changed4) {
                                    ComposerKt.sourceInformation($composer3, "C249@9459L6,250@9486L17:ListItem.kt#jmzs0o");
                                    if (($changed4 & 11) != 2 || !$composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(993836488, $changed4, -1, "androidx.compose.material.TwoLine.ListItem.<anonymous>.<anonymous> (ListItem.kt:248)");
                                        }
                                        text.invoke($composer3, Integer.valueOf(($dirty >> 6) & 14));
                                        Function2<Composer, Integer, Unit> function25 = function22;
                                        Intrinsics.checkNotNull(function25);
                                        function25.invoke($composer3, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer3.skipToGroupEnd();
                                }
                            }), $composer2, 384, 0);
                            $composer2.endReplaceableGroup();
                        }
                        if (function24 != null) {
                            ListItemKt.m1417OffsetToBaselineOrCenterKz89ssw(function2 != null ? PrimaryBaselineOffsetWithIcon : PrimaryBaselineOffsetNoIcon, null, ComposableLambdaKt.composableLambda($composer2, -1696992176, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TwoLine$ListItem$1$4
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

                                public final void invoke(Composer $composer3, int $changed4) {
                                    float f;
                                    ComposerKt.sourceInformation($composer3, "C261@9851L320:ListItem.kt#jmzs0o");
                                    if (($changed4 & 11) != 2 || !$composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1696992176, $changed4, -1, "androidx.compose.material.TwoLine.ListItem.<anonymous>.<anonymous> (ListItem.kt:260)");
                                        }
                                        Modifier m788heightInVpY3zN4$default = SizeKt.m788heightInVpY3zN4$default(Modifier.INSTANCE, minHeight, 0.0f, 2, null);
                                        f = TwoLine.TrailingRightPadding;
                                        Modifier modifier$iv3 = PaddingKt.m763paddingqDBjuR0$default(m788heightInVpY3zN4$default, 0.0f, 0.0f, f, 0.0f, 11, null);
                                        Alignment contentAlignment$iv2 = Alignment.INSTANCE.getCenter();
                                        Function2<Composer, Integer, Unit> function25 = function24;
                                        int i4 = $dirty;
                                        $composer3.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                        MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & SdkConfig.SDK_VERSION));
                                        int $changed$iv$iv3 = (48 << 3) & SdkConfig.SDK_VERSION;
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
                                        int $changed$iv3 = ($changed$iv$iv$iv3 >> 9) & 14;
                                        $composer3.startReplaceableGroup(-2137368960);
                                        ComposerKt.sourceInformation($composer3, "C72@3384L9:Box.kt#2w3rfo");
                                        if (($changed$iv3 & 11) == 2 && $composer3.getSkipping()) {
                                            $composer3.skipToGroupEnd();
                                        } else {
                                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                            int $changed5 = ((48 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                            $composer3.startReplaceableGroup(868648534);
                                            ComposerKt.sourceInformation($composer3, "C266@10159L10:ListItem.kt#jmzs0o");
                                            if (($changed5 & 81) == 16 && $composer3.getSkipping()) {
                                                $composer3.skipToGroupEnd();
                                            } else {
                                                function25.invoke($composer3, Integer.valueOf((i4 >> 15) & 14));
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
                            }), $composer2, 384, 2);
                        }
                    } else {
                        $composer2.skipToGroupEnd();
                    }
                    $composer2.endReplaceableGroup();
                } else {
                    $composer2.skipToGroupEnd();
                }
                $composer2.endReplaceableGroup();
                $composer2.endReplaceableGroup();
                $composer2.endNode();
                $composer2.endReplaceableGroup();
                $composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                $composer2.skipToGroupEnd();
                modifier3 = modifier2;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TwoLine$ListItem$2
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

                public final void invoke(Composer composer, int i4) {
                    TwoLine.this.ListItem(modifier6, function2, text, function22, function23, function24, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty3 |= i2;
        if ((i & 64) == 0) {
        }
        $dirty = $dirty3;
        if ((2995931 & $dirty) == 599186) {
        }
        if (i3 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (function2 != null) {
        }
        Modifier modifier$iv3 = SizeKt.m788heightInVpY3zN4$default(modifier4, minHeight, 0.0f, 2, null);
        $composer2.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation($composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
        Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
        Modifier modifier52 = modifier4;
        MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
        int $changed$iv$iv3 = (0 << 3) & SdkConfig.SDK_VERSION;
        $composer2.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume7 = $composer2.consume(localDensity3);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        Density density$iv$iv3 = (Density) consume7;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume22 = $composer2.consume(localLayoutDirection3);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume22;
        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume32 = $composer2.consume(localViewConfiguration3);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume32;
        Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
        Function3 skippableUpdate$iv$iv$iv3 = LayoutKt.materializerOf(modifier$iv3);
        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 9) & 7168) | 6;
        if (!($composer2.getApplier() instanceof Applier)) {
        }
        $composer2.startReusableNode();
        if ($composer2.getInserting()) {
        }
        $composer2.disableReusing();
        Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m1639constructorimpl($composer2);
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.INSTANCE.getSetDensity());
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
        $composer2.enableReusing();
        skippableUpdate$iv$iv$iv3.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & SdkConfig.SDK_VERSION));
        $composer2.startReplaceableGroup(2058660585);
        $changed$iv = ($changed$iv$iv$iv3 >> 9) & 14;
        $composer2.startReplaceableGroup(-678309503);
        ComposerKt.sourceInformation($composer2, "C80@3988L9:Row.kt#2w3rfo");
        if (($changed$iv & 11) == 2) {
        }
        RowScope rowScope2 = RowScopeInstance.INSTANCE;
        $changed2 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
        $this$ListItem_u24lambda_u2d1 = rowScope2;
        $composer2.startReplaceableGroup(1912737507);
        ComposerKt.sourceInformation($composer2, "C254@9588L601:ListItem.kt#jmzs0o");
        $dirty2 = $changed2;
        if (($changed2 & 14) == 0) {
        }
        if (($dirty2 & 91) == 18) {
        }
        Modifier columnModifier2 = PaddingKt.m763paddingqDBjuR0$default(RowScope.weight$default($this$ListItem_u24lambda_u2d1, Modifier.INSTANCE, 1.0f, false, 2, null), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, null);
        $composer2.startReplaceableGroup(-269995367);
        ComposerKt.sourceInformation($composer2, "210@7969L532");
        if (function2 == null) {
        }
        $composer2.endReplaceableGroup();
        if (function23 == null) {
        }
        if (function24 != null) {
        }
        $composer2.endReplaceableGroup();
        $composer2.endReplaceableGroup();
        $composer2.endReplaceableGroup();
        $composer2.endNode();
        $composer2.endReplaceableGroup();
        $composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier52;
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
