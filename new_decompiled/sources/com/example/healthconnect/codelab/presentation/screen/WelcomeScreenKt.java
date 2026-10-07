package com.example.healthconnect.codelab.presentation.screen;

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
import androidx.compose.p000ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.res.PainterResources_androidKt;
import androidx.compose.p000ui.res.StringResources_androidKt;
import androidx.compose.p000ui.text.style.TextAlign;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.health.platform.client.SdkConfig;
import androidx.lifecycle.LifecycleOwner;
import com.example.healthconnect.codelab.C0965R;
import com.example.healthconnect.codelab.data.HealthConnectAvailability;
import com.example.healthconnect.codelab.presentation.component.InstalledMessageKt;
import com.example.healthconnect.codelab.presentation.component.NotInstalledMessageKt;
import com.example.healthconnect.codelab.presentation.component.NotSupportedMessageKt;
import com.example.healthconnect.codelab.presentation.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WelcomeScreen.kt */
@Metadata(m286d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a-\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, m287d2 = {"InstalledMessagePreview", "", "(Landroidx/compose/runtime/Composer;I)V", "NotInstalledMessagePreview", "NotSupportedMessagePreview", "WelcomeScreen", "healthConnectAvailability", "Lcom/example/healthconnect/codelab/data/HealthConnectAvailability;", "onResumeAvailabilityCheck", "Lkotlin/Function0;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/example/healthconnect/codelab/data/HealthConnectAvailability;Lkotlin/jvm/functions/Function0;Landroidx/lifecycle/LifecycleOwner;Landroidx/compose/runtime/Composer;II)V", "finished_debug"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes4.dex */
public final class WelcomeScreenKt {

    /* compiled from: WelcomeScreen.kt */
    @Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HealthConnectAvailability.values().length];
            try {
                iArr[HealthConnectAvailability.INSTALLED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[HealthConnectAvailability.NOT_INSTALLED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[HealthConnectAvailability.NOT_SUPPORTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0195  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void WelcomeScreen(final HealthConnectAvailability healthConnectAvailability, final Function0<Unit> onResumeAvailabilityCheck, LifecycleOwner lifecycleOwner, Composer $composer, final int $changed, final int i) {
        LifecycleOwner lifecycleOwner2;
        LifecycleOwner lifecycleOwner3;
        int $changed$iv;
        int $changed2;
        Intrinsics.checkNotNullParameter(healthConnectAvailability, "healthConnectAvailability");
        Intrinsics.checkNotNullParameter(onResumeAvailabilityCheck, "onResumeAvailabilityCheck");
        Composer $composer2 = $composer.startRestartGroup(-183496191);
        ComposerKt.sourceInformation($composer2, "C(WelcomeScreen)P(!1,2)55@2482L7,57@2531L47,64@3014L432,80@3450L980:WelcomeScreen.kt#j0z0ov");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(healthConnectAvailability) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(onResumeAvailabilityCheck) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 128;
        }
        if (i2 == 4 && ($dirty & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            lifecycleOwner3 = lifecycleOwner;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if (i2 != 0) {
                    $dirty &= -897;
                }
            } else if (i2 != 0) {
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(localLifecycleOwner);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                lifecycleOwner2 = (LifecycleOwner) consume;
                $dirty &= -897;
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-183496191, $dirty, -1, "com.example.healthconnect.codelab.presentation.screen.WelcomeScreen (WelcomeScreen.kt:52)");
                }
                State currentOnAvailabilityCheck$delegate = SnapshotStateKt.rememberUpdatedState(onResumeAvailabilityCheck, $composer2, ($dirty >> 3) & 14);
                EffectsKt.DisposableEffect(lifecycleOwner2, new WelcomeScreenKt$WelcomeScreen$1(lifecycleOwner2, currentOnAvailabilityCheck$delegate), $composer2, 8);
                Modifier modifier$iv = PaddingKt.m759padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), C0504Dp.m4382constructorimpl(32));
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getCenterHorizontally();
                $composer2.startReplaceableGroup(-483455358);
                ComposerKt.sourceInformation($composer2, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & SdkConfig.SDK_VERSION));
                int $changed$iv$iv = (438 << 3) & SdkConfig.SDK_VERSION;
                $composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume2 = $composer2.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density density$iv$iv = (Density) consume2;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume3 = $composer2.consume(localLayoutDirection);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer2.consume(localViewConfiguration);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
                Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                lifecycleOwner3 = lifecycleOwner2;
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
                $composer2.startReplaceableGroup(-1163856341);
                ComposerKt.sourceInformation($composer2, "C79@4027L9:Column.kt#2w3rfo");
                if (($changed$iv & 11) == 2 || !$composer2.getSkipping()) {
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    $changed2 = ((438 >> 6) & SdkConfig.SDK_VERSION) | 6;
                    $composer2.startReplaceableGroup(-1586041993);
                    ComposerKt.sourceInformation($composer2, "C89@3710L55,90@3794L49,87@3641L208,92@3854L41,94@3919L45,95@3994L10,96@4037L6,93@3900L229,99@4134L41:WelcomeScreen.kt#j0z0ov");
                    if (($changed2 & 81) == 16 || !$composer2.getSkipping()) {
                        ImageKt.Image(PainterResources_androidKt.painterResource(C0965R.drawable.ic_health_connect_logo, $composer2, 0), StringResources_androidKt.stringResource(C0965R.string.health_connect_logo, $composer2, 0), SizeKt.fillMaxWidth(Modifier.INSTANCE, 0.6f), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, 392, MenuKt.InTransitionDuration);
                        SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(48)), $composer2, 6);
                        TextKt.m1585TextfLXpl1I(StringResources_androidKt.stringResource(C0965R.string.welcome_message, $composer2, 0), null, MaterialTheme.INSTANCE.getColors($composer2, MaterialTheme.$stable).m1312getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m4261boximpl(TextAlign.INSTANCE.m4268getCentere0LSkKk()), 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getH5(), $composer2, 0, 0, 32250);
                        SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(48)), $composer2, 6);
                        switch (WhenMappings.$EnumSwitchMapping$0[healthConnectAvailability.ordinal()]) {
                            case 1:
                                $composer2.startReplaceableGroup(188213124);
                                ComposerKt.sourceInformation($composer2, "101@4260L18");
                                InstalledMessageKt.InstalledMessage($composer2, 0);
                                $composer2.endReplaceableGroup();
                                break;
                            case 2:
                                $composer2.startReplaceableGroup(188213192);
                                ComposerKt.sourceInformation($composer2, "102@4328L21");
                                NotInstalledMessageKt.NotInstalledMessage($composer2, 0);
                                $composer2.endReplaceableGroup();
                                break;
                            case 3:
                                $composer2.startReplaceableGroup(188213263);
                                ComposerKt.sourceInformation($composer2, "103@4399L21");
                                NotSupportedMessageKt.NotSupportedMessage($composer2, 0);
                                $composer2.endReplaceableGroup();
                                break;
                            default:
                                $composer2.startReplaceableGroup(188213290);
                                $composer2.endReplaceableGroup();
                                break;
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
            }
            lifecycleOwner2 = lifecycleOwner;
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            State currentOnAvailabilityCheck$delegate2 = SnapshotStateKt.rememberUpdatedState(onResumeAvailabilityCheck, $composer2, ($dirty >> 3) & 14);
            EffectsKt.DisposableEffect(lifecycleOwner2, new WelcomeScreenKt$WelcomeScreen$1(lifecycleOwner2, currentOnAvailabilityCheck$delegate2), $composer2, 8);
            Modifier modifier$iv2 = PaddingKt.m759padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), C0504Dp.m4382constructorimpl(32));
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getCenterHorizontally();
            $composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation($composer2, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & SdkConfig.SDK_VERSION));
            int $changed$iv$iv2 = (438 << 3) & SdkConfig.SDK_VERSION;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume22 = $composer2.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv2 = (Density) consume22;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume32 = $composer2.consume(localLayoutDirection2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume32;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume42 = $composer2.consume(localViewConfiguration2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume42;
            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
            lifecycleOwner3 = lifecycleOwner2;
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
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
            $changed$iv = ($changed$iv$iv$iv2 >> 9) & 14;
            $composer2.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation($composer2, "C79@4027L9:Column.kt#2w3rfo");
            if (($changed$iv & 11) == 2) {
            }
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            $changed2 = ((438 >> 6) & SdkConfig.SDK_VERSION) | 6;
            $composer2.startReplaceableGroup(-1586041993);
            ComposerKt.sourceInformation($composer2, "C89@3710L55,90@3794L49,87@3641L208,92@3854L41,94@3919L45,95@3994L10,96@4037L6,93@3900L229,99@4134L41:WelcomeScreen.kt#j0z0ov");
            if (($changed2 & 81) == 16) {
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(C0965R.drawable.ic_health_connect_logo, $composer2, 0), StringResources_androidKt.stringResource(C0965R.string.health_connect_logo, $composer2, 0), SizeKt.fillMaxWidth(Modifier.INSTANCE, 0.6f), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, 392, MenuKt.InTransitionDuration);
            SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(48)), $composer2, 6);
            TextKt.m1585TextfLXpl1I(StringResources_androidKt.stringResource(C0965R.string.welcome_message, $composer2, 0), null, MaterialTheme.INSTANCE.getColors($composer2, MaterialTheme.$stable).m1312getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m4261boximpl(TextAlign.INSTANCE.m4268getCentere0LSkKk()), 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getH5(), $composer2, 0, 0, 32250);
            SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(48)), $composer2, 6);
            switch (WhenMappings.$EnumSwitchMapping$0[healthConnectAvailability.ordinal()]) {
            }
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final LifecycleOwner lifecycleOwner4 = lifecycleOwner3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.WelcomeScreenKt$WelcomeScreen$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i3) {
                WelcomeScreenKt.WelcomeScreen(HealthConnectAvailability.this, onResumeAvailabilityCheck, lifecycleOwner4, composer, $changed | 1, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> WelcomeScreen$lambda$0(State<? extends Function0<Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function0) thisObj$iv;
    }

    public static final void InstalledMessagePreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1272765778);
        ComposerKt.sourceInformation($composer2, "C(InstalledMessagePreview)111@4489L157:WelcomeScreen.kt#j0z0ov");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1272765778, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.InstalledMessagePreview (WelcomeScreen.kt:110)");
            }
            ThemeKt.HealthConnectTheme(false, ComposableSingletons$WelcomeScreenKt.INSTANCE.m4702getLambda1$finished_debug(), $composer2, 48, 1);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.WelcomeScreenKt$InstalledMessagePreview$1
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
                WelcomeScreenKt.InstalledMessagePreview(composer, $changed | 1);
            }
        });
    }

    public static final void NotInstalledMessagePreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1059958473);
        ComposerKt.sourceInformation($composer2, "C(NotInstalledMessagePreview)122@4708L161:WelcomeScreen.kt#j0z0ov");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1059958473, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.NotInstalledMessagePreview (WelcomeScreen.kt:121)");
            }
            ThemeKt.HealthConnectTheme(false, ComposableSingletons$WelcomeScreenKt.INSTANCE.m4703getLambda2$finished_debug(), $composer2, 48, 1);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.WelcomeScreenKt$NotInstalledMessagePreview$1
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
                WelcomeScreenKt.NotInstalledMessagePreview(composer, $changed | 1);
            }
        });
    }

    public static final void NotSupportedMessagePreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1098791829);
        ComposerKt.sourceInformation($composer2, "C(NotSupportedMessagePreview)133@4931L161:WelcomeScreen.kt#j0z0ov");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1098791829, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.NotSupportedMessagePreview (WelcomeScreen.kt:132)");
            }
            ThemeKt.HealthConnectTheme(false, ComposableSingletons$WelcomeScreenKt.INSTANCE.m4704getLambda3$finished_debug(), $composer2, 48, 1);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.WelcomeScreenKt$NotSupportedMessagePreview$1
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
                WelcomeScreenKt.NotSupportedMessagePreview(composer, $changed | 1);
            }
        });
    }
}
