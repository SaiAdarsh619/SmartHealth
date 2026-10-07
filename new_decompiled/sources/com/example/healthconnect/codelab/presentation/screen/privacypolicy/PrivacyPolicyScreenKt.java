package com.example.healthconnect.codelab.presentation.screen.privacypolicy;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.MenuKt;
import androidx.compose.material.TextKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.ColorFilter;
import androidx.compose.p000ui.layout.ContentScale;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.res.PainterResources_androidKt;
import androidx.compose.p000ui.res.StringResources_androidKt;
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
import com.example.healthconnect.codelab.C0965R;
import com.example.healthconnect.codelab.presentation.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: PrivacyPolicyScreen.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m287d2 = {"PrivacyPolicyScreen", "", "(Landroidx/compose/runtime/Composer;I)V", "PrivacyPolicyScreenPreview", "finished_debug"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes13.dex */
public final class PrivacyPolicyScreenKt {
    public static final void PrivacyPolicyScreen(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1827444685);
        ComposerKt.sourceInformation($composer2, "C(PrivacyPolicyScreen)42@1676L677:PrivacyPolicyScreen.kt#y5g8r1");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1827444685, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.privacypolicy.PrivacyPolicyScreen (PrivacyPolicyScreen.kt:41)");
            }
            Modifier modifier$iv = PaddingKt.m759padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), C0504Dp.m4382constructorimpl(32));
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getCenterHorizontally();
            $composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation($composer2, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & SdkConfig.SDK_VERSION));
            int $changed$iv$iv = (438 << 3) & SdkConfig.SDK_VERSION;
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
            $composer2.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation($composer2, "C79@4027L9:Column.kt#2w3rfo");
            if (($changed$iv & 11) == 2 && $composer2.getSkipping()) {
                $composer2.skipToGroupEnd();
            } else {
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int $changed2 = ((438 >> 6) & SdkConfig.SDK_VERSION) | 6;
                $composer2.startReplaceableGroup(196145987);
                ComposerKt.sourceInformation($composer2, "C51@1933L55,52@2017L49,49@1864L208,54@2077L41,56@2142L44,57@2216L6,55@2123L118,59@2246L41,60@2297L51,60@2292L57:PrivacyPolicyScreen.kt#y5g8r1");
                if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                    ImageKt.Image(PainterResources_androidKt.painterResource(C0965R.drawable.ic_health_connect_logo, $composer2, 0), StringResources_androidKt.stringResource(C0965R.string.health_connect_logo, $composer2, 0), SizeKt.fillMaxWidth(Modifier.INSTANCE, 0.5f), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, 392, MenuKt.InTransitionDuration);
                    SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(32)), $composer2, 6);
                    TextKt.m1585TextfLXpl1I(StringResources_androidKt.stringResource(C0965R.string.privacy_policy, $composer2, 0), null, MaterialTheme.INSTANCE.getColors($composer2, MaterialTheme.$stable).m1312getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer2, 0, 0, 65530);
                    SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(32)), $composer2, 6);
                    TextKt.m1585TextfLXpl1I(StringResources_androidKt.stringResource(C0965R.string.privacy_policy_description, $composer2, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer2, 0, 0, 65534);
                } else {
                    $composer2.skipToGroupEnd();
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
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.privacypolicy.PrivacyPolicyScreenKt$PrivacyPolicyScreen$2
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
                PrivacyPolicyScreenKt.PrivacyPolicyScreen(composer, $changed | 1);
            }
        });
    }

    public static final void PrivacyPolicyScreenPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1588640133);
        ComposerKt.sourceInformation($composer2, "C(PrivacyPolicyScreenPreview)67@2415L50:PrivacyPolicyScreen.kt#y5g8r1");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1588640133, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.privacypolicy.PrivacyPolicyScreenPreview (PrivacyPolicyScreen.kt:66)");
            }
            ThemeKt.HealthConnectTheme(false, ComposableSingletons$PrivacyPolicyScreenKt.INSTANCE.m4715getLambda1$finished_debug(), $composer2, 48, 1);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.privacypolicy.PrivacyPolicyScreenKt$PrivacyPolicyScreenPreview$1
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
                PrivacyPolicyScreenKt.PrivacyPolicyScreenPreview(composer, $changed | 1);
            }
        });
    }
}
