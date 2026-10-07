package com.example.healthconnect.codelab.presentation.navigation;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.res.StringResources_androidKt;
import androidx.compose.p000ui.text.TextStyle;
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
import androidx.health.platform.client.SdkConfig;
import com.example.healthconnect.codelab.presentation.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawerItem.kt */
@Metadata(m286d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m287d2 = {"DrawerItem", "", "item", "Lcom/example/healthconnect/codelab/presentation/navigation/Screen;", "selected", "", "onItemClick", "Lkotlin/Function1;", "(Lcom/example/healthconnect/codelab/presentation/navigation/Screen;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "DrawerItemPreview", "(Landroidx/compose/runtime/Composer;I)V", "finished_debug"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes11.dex */
public final class DrawerItemKt {
    public static final void DrawerItem(final Screen item, final boolean selected, final Function1<? super Screen, Unit> onItemClick, Composer $composer, final int $changed) {
        Object value$iv$iv;
        long j;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Composer $composer2 = $composer.startRestartGroup(148075990);
        ComposerKt.sourceInformation($composer2, "C(DrawerItem)P(!1,2)44@1597L21,41@1503L537:DrawerItem.kt#n2bxm1");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(item) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(selected) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(onItemClick) ? 256 : 128;
        }
        if (($dirty & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(148075990, $dirty, -1, "com.example.healthconnect.codelab.presentation.navigation.DrawerItem (DrawerItem.kt:36)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            int i = (($dirty >> 6) & 14) | (($dirty << 3) & SdkConfig.SDK_VERSION);
            $composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(onItemClick) | $composer2.changed(item);
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = (Function0) new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.DrawerItemKt$DrawerItem$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        onItemClick.invoke(item);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            Modifier modifier$iv = PaddingKt.m763paddingqDBjuR0$default(SizeKt.m786height3ABfNKs(ClickableKt.m514clickableXHw0xAI$default(fillMaxWidth$default, false, null, null, (Function0) value$iv$iv, 7, null), C0504Dp.m4382constructorimpl(48)), C0504Dp.m4382constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null);
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            $composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation($composer2, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & SdkConfig.SDK_VERSION));
            int $changed$iv$iv = (384 << 3) & SdkConfig.SDK_VERSION;
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
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                $composer2.useNode();
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
            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
            $composer2.startReplaceableGroup(-678309503);
            ComposerKt.sourceInformation($composer2, "C80@4021L9:Row.kt#2w3rfo");
            if (($changed$iv & 11) == 2 && $composer2.getSkipping()) {
                $composer2.skipToGroupEnd();
            } else {
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                int $changed2 = ((384 >> 6) & SdkConfig.SDK_VERSION) | 6;
                $composer2.startReplaceableGroup(1331174458);
                ComposerKt.sourceInformation($composer2, "C50@1780L28,51@1844L10,49@1755L279:DrawerItem.kt#n2bxm1");
                if (($changed2 & 81) == 16 && $composer2.getSkipping()) {
                    $composer2.skipToGroupEnd();
                } else {
                    String stringResource = StringResources_androidKt.stringResource(item.getTitleId(), $composer2, 0);
                    TextStyle h5 = MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getH5();
                    if (selected) {
                        $composer2.startReplaceableGroup(994222653);
                        ComposerKt.sourceInformation($composer2, "53@1925L6");
                        long m1317getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors($composer2, MaterialTheme.$stable).m1317getPrimary0d7_KjU();
                        $composer2.endReplaceableGroup();
                        j = m1317getPrimary0d7_KjU;
                    } else {
                        $composer2.startReplaceableGroup(994222719);
                        ComposerKt.sourceInformation($composer2, "55@1991L6");
                        long m1312getOnBackground0d7_KjU = MaterialTheme.INSTANCE.getColors($composer2, MaterialTheme.$stable).m1312getOnBackground0d7_KjU();
                        $composer2.endReplaceableGroup();
                        j = m1312getOnBackground0d7_KjU;
                    }
                    TextKt.m1585TextfLXpl1I(stringResource, null, j, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, h5, $composer2, 0, 0, 32762);
                }
                $composer2.endReplaceableGroup();
            }
            $composer2.endReplaceableGroup();
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.DrawerItemKt$DrawerItem$3
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

            public final void invoke(Composer composer, int i2) {
                DrawerItemKt.DrawerItem(Screen.this, selected, onItemClick, composer, $changed | 1);
            }
        });
    }

    public static final void DrawerItemPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-988318243);
        ComposerKt.sourceInformation($composer2, "C(DrawerItemPreview)64@2095L148:DrawerItem.kt#n2bxm1");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-988318243, $changed, -1, "com.example.healthconnect.codelab.presentation.navigation.DrawerItemPreview (DrawerItem.kt:63)");
            }
            ThemeKt.HealthConnectTheme(false, ComposableSingletons$DrawerItemKt.INSTANCE.m4701getLambda1$finished_debug(), $composer2, 48, 1);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.DrawerItemKt$DrawerItemPreview$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                DrawerItemKt.DrawerItemPreview(composer, $changed | 1);
            }
        });
    }
}
