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
@Metadata(m286d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J|\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0013\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00110\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00110\u0015¢\u0006\u0002\b\u00162\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015¢\u0006\u0002\b\u00162\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001bR\u0019\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0007\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\t\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\n\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\f\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\r\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000e\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000f\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, m287d2 = {"Landroidx/compose/material/ThreeLine;", "", "()V", "ContentLeftPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ContentRightPadding", "IconLeftPadding", "IconMinPaddedWidth", "IconThreeLineVerticalPadding", "MinHeight", "ThreeLineBaselineFirstOffset", "ThreeLineBaselineSecondOffset", "ThreeLineBaselineThirdOffset", "ThreeLineTrailingTopPadding", "TrailingRightPadding", "ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "text", "secondaryText", "overlineText", "trailing", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class ThreeLine {
    public static final ThreeLine INSTANCE = new ThreeLine();
    private static final float MinHeight = C0504Dp.m4382constructorimpl(88);
    private static final float IconMinPaddedWidth = C0504Dp.m4382constructorimpl(40);
    private static final float IconLeftPadding = C0504Dp.m4382constructorimpl(16);
    private static final float IconThreeLineVerticalPadding = C0504Dp.m4382constructorimpl(16);
    private static final float ContentLeftPadding = C0504Dp.m4382constructorimpl(16);
    private static final float ContentRightPadding = C0504Dp.m4382constructorimpl(16);
    private static final float ThreeLineBaselineFirstOffset = C0504Dp.m4382constructorimpl(28);
    private static final float ThreeLineBaselineSecondOffset = C0504Dp.m4382constructorimpl(20);
    private static final float ThreeLineBaselineThirdOffset = C0504Dp.m4382constructorimpl(20);
    private static final float ThreeLineTrailingTopPadding = C0504Dp.m4382constructorimpl(16);
    private static final float TrailingRightPadding = C0504Dp.m4382constructorimpl(16);

    private ThreeLine() {
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0581  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void ListItem(Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> text, final Function2<? super Composer, ? super Integer, Unit> secondaryText, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final int $dirty;
        Modifier modifier3;
        int $changed$iv;
        int $changed2;
        RowScope $this$ListItem_u24lambda_u2d1;
        int $dirty2;
        Composer $composer$iv;
        Composer $composer2;
        Composer $composer3;
        Composer $composer$iv2;
        ScopeUpdateScope endRestartGroup;
        int i2;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(secondaryText, "secondaryText");
        Composer $composer4 = $composer.startRestartGroup(1749738797);
        ComposerKt.sourceInformation($composer4, "C(ListItem)P(1!1,4,3)302@11212L1431:ListItem.kt#jmzs0o");
        int $dirty3 = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty3 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer4.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty3 |= $composer4.changed(function2) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer4.changed(text) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty3 |= $composer4.changed(secondaryText) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty3 |= 24576;
        } else if ((57344 & $changed) == 0) {
            $dirty3 |= $composer4.changed(function22) ? 16384 : 8192;
        }
        if ((i & 32) == 0) {
            i2 = (458752 & $changed) == 0 ? $composer4.changed(function23) ? 131072 : 65536 : 196608;
            if ((i & 64) == 0) {
                $dirty3 |= 1572864;
            } else if ((3670016 & $changed) == 0) {
                $dirty3 |= $composer4.changed(this) ? 1048576 : 524288;
            }
            $dirty = $dirty3;
            if ((2995931 & $dirty) == 599186 || !$composer4.getSkipping()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1749738797, $dirty, -1, "androidx.compose.material.ThreeLine.ListItem (ListItem.kt:294)");
                }
                Modifier modifier$iv = SizeKt.m788heightInVpY3zN4$default(modifier2, MinHeight, 0.0f, 2, null);
                $composer4.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation($composer4, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                int $changed$iv$iv = (0 << 3) & SdkConfig.SDK_VERSION;
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
                modifier3 = modifier2;
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
                if (!$composer4.getInserting()) {
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
                $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                $composer4.startReplaceableGroup(-678309503);
                ComposerKt.sourceInformation($composer4, "C80@3988L9:Row.kt#2w3rfo");
                if (($changed$iv & 11) != 2 && $composer4.getSkipping()) {
                    $composer4.skipToGroupEnd();
                    $composer2 = $composer4;
                    $composer$iv2 = $composer4;
                } else {
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    $changed2 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                    $this$ListItem_u24lambda_u2d1 = rowScope;
                    $composer4.startReplaceableGroup(1483377809);
                    ComposerKt.sourceInformation($composer4, "C316@11836L477,330@12366L253:ListItem.kt#jmzs0o");
                    $dirty2 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty2 |= $composer4.changed($this$ListItem_u24lambda_u2d1) ? 4 : 2;
                    }
                    if (($dirty2 & 91) == 18 || !$composer4.getSkipping()) {
                        $composer4.startReplaceableGroup(-280382992);
                        ComposerKt.sourceInformation($composer4, "305@11369L440");
                        if (function2 != null) {
                            $composer$iv = $composer4;
                            $composer2 = $composer4;
                        } else {
                            float arg0$iv = IconLeftPadding;
                            float other$iv = IconMinPaddedWidth;
                            float minSize = C0504Dp.m4382constructorimpl(arg0$iv + other$iv);
                            Modifier modifier$iv2 = PaddingKt.m763paddingqDBjuR0$default(SizeKt.m804sizeInqDBjuR0$default(Modifier.INSTANCE, minSize, minSize, 0.0f, 0.0f, 12, null), IconLeftPadding, IconThreeLineVerticalPadding, 0.0f, IconThreeLineVerticalPadding, 4, null);
                            Alignment contentAlignment$iv = Alignment.INSTANCE.getCenterStart();
                            $composer4.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            $composer$iv = $composer4;
                            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((54 >> 3) & 14) | ((54 >> 3) & SdkConfig.SDK_VERSION));
                            int $changed$iv$iv2 = (54 << 3) & SdkConfig.SDK_VERSION;
                            $composer4.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume4 = $composer4.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            Density density$iv$iv2 = (Density) consume4;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume5 = $composer4.consume(localLayoutDirection2);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume6 = $composer4.consume(localViewConfiguration2);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                            $composer2 = $composer4;
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                $composer4.createNode(factory$iv$iv$iv2);
                            } else {
                                $composer4.useNode();
                            }
                            $composer4.disableReusing();
                            Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer4);
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            $composer4.enableReusing();
                            skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                            $composer4.startReplaceableGroup(2058660585);
                            int $changed$iv2 = ($changed$iv$iv$iv2 >> 9) & 14;
                            $composer4.startReplaceableGroup(-2137368960);
                            ComposerKt.sourceInformation($composer4, "C72@3384L9:Box.kt#2w3rfo");
                            if (($changed$iv2 & 11) == 2 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                            } else {
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                int $changed3 = ((54 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                $composer4.startReplaceableGroup(2007028978);
                                ComposerKt.sourceInformation($composer4, "C314@11801L6:ListItem.kt#jmzs0o");
                                if (($changed3 & 81) == 16 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                } else {
                                    function2.invoke($composer4, Integer.valueOf(($dirty >> 3) & 14));
                                }
                                $composer4.endReplaceableGroup();
                            }
                            $composer4.endReplaceableGroup();
                            $composer4.endReplaceableGroup();
                            $composer4.endNode();
                            $composer4.endReplaceableGroup();
                            $composer4.endReplaceableGroup();
                        }
                        $composer4.endReplaceableGroup();
                        ListItemKt.BaselinesOffsetColumn(CollectionsKt.listOf((Object[]) new C0504Dp[]{C0504Dp.m4380boximpl(ThreeLineBaselineFirstOffset), C0504Dp.m4380boximpl(ThreeLineBaselineSecondOffset), C0504Dp.m4380boximpl(ThreeLineBaselineThirdOffset)}), PaddingKt.m763paddingqDBjuR0$default(RowScope.weight$default($this$ListItem_u24lambda_u2d1, Modifier.INSTANCE, 1.0f, false, 2, null), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, null), ComposableLambdaKt.composableLambda($composer4, -318094245, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ThreeLine$ListItem$1$2
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
                                ComposerKt.sourceInformation($composer5, "C326@12261L6,327@12284L15:ListItem.kt#jmzs0o");
                                if (($changed4 & 11) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-318094245, $changed4, -1, "androidx.compose.material.ThreeLine.ListItem.<anonymous>.<anonymous> (ListItem.kt:324)");
                                    }
                                    $composer5.startReplaceableGroup(-755940677);
                                    ComposerKt.sourceInformation($composer5, "325@12230L14");
                                    if (function22 != null) {
                                        function22.invoke($composer5, Integer.valueOf(($dirty >> 12) & 14));
                                    }
                                    $composer5.endReplaceableGroup();
                                    text.invoke($composer5, Integer.valueOf(($dirty >> 6) & 14));
                                    secondaryText.invoke($composer5, Integer.valueOf(($dirty >> 9) & 14));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }), $composer4, 384, 0);
                        if (function23 != null) {
                            $composer3 = $composer4;
                            $composer$iv2 = $composer$iv;
                        } else {
                            float arg0$iv2 = ThreeLineBaselineFirstOffset;
                            float other$iv2 = ThreeLineTrailingTopPadding;
                            $composer3 = $composer4;
                            $composer$iv2 = $composer$iv;
                            ListItemKt.m1417OffsetToBaselineOrCenterKz89ssw(C0504Dp.m4382constructorimpl(arg0$iv2 - other$iv2), PaddingKt.m763paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, ThreeLineTrailingTopPadding, TrailingRightPadding, 0.0f, 9, null), function23, $composer3, (($dirty >> 9) & 896) | 54, 0);
                        }
                    } else {
                        $composer4.skipToGroupEnd();
                        $composer2 = $composer4;
                        $composer3 = $composer4;
                        $composer$iv2 = $composer4;
                    }
                    $composer3.endReplaceableGroup();
                }
                $composer$iv2.endReplaceableGroup();
                $composer2.endReplaceableGroup();
                $composer2.endNode();
                $composer2.endReplaceableGroup();
                $composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer4.skipToGroupEnd();
                modifier3 = modifier2;
                $composer2 = $composer4;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ThreeLine$ListItem$2
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
                    ThreeLine.this.ListItem(modifier4, function2, text, secondaryText, function22, function23, composer, $changed | 1, i);
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
        if (i3 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier modifier$iv3 = SizeKt.m788heightInVpY3zN4$default(modifier2, MinHeight, 0.0f, 2, null);
        $composer4.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation($composer4, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
        Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
        MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
        int $changed$iv$iv3 = (0 << 3) & SdkConfig.SDK_VERSION;
        $composer4.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume7 = $composer4.consume(localDensity3);
        ComposerKt.sourceInformationMarkerEnd($composer4);
        Density density$iv$iv3 = (Density) consume7;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume22 = $composer4.consume(localLayoutDirection3);
        ComposerKt.sourceInformationMarkerEnd($composer4);
        LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume22;
        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
        modifier3 = modifier2;
        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume32 = $composer4.consume(localViewConfiguration3);
        ComposerKt.sourceInformationMarkerEnd($composer4);
        ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume32;
        Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
        Function3 skippableUpdate$iv$iv$iv3 = LayoutKt.materializerOf(modifier$iv3);
        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 9) & 7168) | 6;
        if (!($composer4.getApplier() instanceof Applier)) {
        }
        $composer4.startReusableNode();
        if (!$composer4.getInserting()) {
        }
        $composer4.disableReusing();
        Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m1639constructorimpl($composer4);
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.INSTANCE.getSetDensity());
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
        $composer4.enableReusing();
        skippableUpdate$iv$iv$iv3.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & SdkConfig.SDK_VERSION));
        $composer4.startReplaceableGroup(2058660585);
        $changed$iv = ($changed$iv$iv$iv3 >> 9) & 14;
        $composer4.startReplaceableGroup(-678309503);
        ComposerKt.sourceInformation($composer4, "C80@3988L9:Row.kt#2w3rfo");
        if (($changed$iv & 11) != 2) {
        }
        RowScope rowScope2 = RowScopeInstance.INSTANCE;
        $changed2 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
        $this$ListItem_u24lambda_u2d1 = rowScope2;
        $composer4.startReplaceableGroup(1483377809);
        ComposerKt.sourceInformation($composer4, "C316@11836L477,330@12366L253:ListItem.kt#jmzs0o");
        $dirty2 = $changed2;
        if (($changed2 & 14) == 0) {
        }
        if (($dirty2 & 91) == 18) {
        }
        $composer4.startReplaceableGroup(-280382992);
        ComposerKt.sourceInformation($composer4, "305@11369L440");
        if (function2 != null) {
        }
        $composer4.endReplaceableGroup();
        ListItemKt.BaselinesOffsetColumn(CollectionsKt.listOf((Object[]) new C0504Dp[]{C0504Dp.m4380boximpl(ThreeLineBaselineFirstOffset), C0504Dp.m4380boximpl(ThreeLineBaselineSecondOffset), C0504Dp.m4380boximpl(ThreeLineBaselineThirdOffset)}), PaddingKt.m763paddingqDBjuR0$default(RowScope.weight$default($this$ListItem_u24lambda_u2d1, Modifier.INSTANCE, 1.0f, false, 2, null), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, null), ComposableLambdaKt.composableLambda($composer4, -318094245, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ThreeLine$ListItem$1$2
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
                ComposerKt.sourceInformation($composer5, "C326@12261L6,327@12284L15:ListItem.kt#jmzs0o");
                if (($changed4 & 11) != 2 || !$composer5.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-318094245, $changed4, -1, "androidx.compose.material.ThreeLine.ListItem.<anonymous>.<anonymous> (ListItem.kt:324)");
                    }
                    $composer5.startReplaceableGroup(-755940677);
                    ComposerKt.sourceInformation($composer5, "325@12230L14");
                    if (function22 != null) {
                        function22.invoke($composer5, Integer.valueOf(($dirty >> 12) & 14));
                    }
                    $composer5.endReplaceableGroup();
                    text.invoke($composer5, Integer.valueOf(($dirty >> 6) & 14));
                    secondaryText.invoke($composer5, Integer.valueOf(($dirty >> 9) & 14));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer5.skipToGroupEnd();
            }
        }), $composer4, 384, 0);
        if (function23 != null) {
        }
        $composer3.endReplaceableGroup();
        $composer$iv2.endReplaceableGroup();
        $composer2.endReplaceableGroup();
        $composer2.endNode();
        $composer2.endReplaceableGroup();
        $composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
