package com.example.healthconnect.codelab.presentation.screen.profile;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.material.RadioButtonKt;
import androidx.compose.material.SwitchKt;
import androidx.compose.material.TextFieldColors;
import androidx.compose.material.TextKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.input.KeyboardType;
import androidx.compose.p000ui.text.input.VisualTransformation;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.health.platform.client.SdkConfig;
import com.example.healthconnect.codelab.data.UserProfileManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* compiled from: ProfileScreen.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes9.dex */
final class ProfileScreenKt$ProfileScreen$1 extends Lambda implements Function3<PaddingValues, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ MutableState<String> $age$delegate;
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<String> $gender$delegate;
    final /* synthetic */ MutableState<Boolean> $hasCondition$delegate;
    final /* synthetic */ String $systemStatus;
    final /* synthetic */ UserProfileManager $userProfileManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileScreenKt$ProfileScreen$1(MutableState<String> mutableState, String str, int i, MutableState<String> mutableState2, MutableState<Boolean> mutableState3, UserProfileManager userProfileManager, Context context) {
        super(3);
        this.$age$delegate = mutableState;
        this.$systemStatus = str;
        this.$$dirty = i;
        this.$gender$delegate = mutableState2;
        this.$hasCondition$delegate = mutableState3;
        this.$userProfileManager = userProfileManager;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
        invoke(paddingValues, composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x116e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x1185  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x1260  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x126c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x12da  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x1396  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x1311  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x1270  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x10c2  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0ff0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0d27  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0d3e  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0e21  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0e2d  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0e9f  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0f5b  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0ed6  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0e31  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0c79  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0ba8  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x08de  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x08f5  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x09d8  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x09e4  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0a56  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0b13  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0a8d  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x09e8  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0830  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x06cd  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x06de A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x053e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0820  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x082c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x089e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0b91  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0c69  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0c75  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0ce7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0fd9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x10b2  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x10be  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x1130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke(PaddingValues padding, Composer $composer, int $changed) {
        String ProfileScreen$lambda$1;
        int i;
        int i2;
        String ProfileScreen$lambda$12;
        Object value$iv$iv;
        int $changed$iv;
        int $changed2;
        String ProfileScreen$lambda$4;
        boolean invalid$iv$iv;
        Object it$iv$iv;
        Object value$iv$iv2;
        String ProfileScreen$lambda$42;
        boolean invalid$iv$iv2;
        Object it$iv$iv2;
        Object value$iv$iv3;
        int $changed$iv2;
        int $changed3;
        RowScope $this$invoke_u24lambda_u2419_u24lambda_u246;
        int $dirty;
        MutableState<String> mutableState;
        Composer $composer$iv;
        int $changed$iv3;
        int $changed4;
        boolean ProfileScreen$lambda$7;
        boolean invalid$iv$iv3;
        Object value$iv$iv4;
        Object it$iv$iv3;
        Object value$iv$iv5;
        int $changed$iv4;
        int $changed5;
        RowScope $this$invoke_u24lambda_u2419_u24lambda_u2412;
        int $dirty2;
        MutableState<Boolean> mutableState2;
        int $changed$iv5;
        int $changed6;
        boolean invalid$iv$iv4;
        Object value$iv$iv6;
        Object it$iv$iv4;
        Object value$iv$iv7;
        int $changed$iv6;
        int $changed7;
        RowScope $this$invoke_u24lambda_u2419_u24lambda_u2418;
        int $dirty3;
        int $changed$iv7;
        int $changed8;
        boolean invalid$iv$iv5;
        Object value$iv$iv8;
        Intrinsics.checkNotNullParameter(padding, "padding");
        ComposerKt.sourceInformation($composer, "C38@1373L21,33@1204L6632:ProfileScreen.kt#amutfg");
        int $dirty4 = $changed;
        if (($changed & 14) == 0) {
            $dirty4 |= $composer.changed(padding) ? 4 : 2;
        }
        if (($dirty4 & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(835531858, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreen.<anonymous> (ProfileScreen.kt:32)");
            }
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(PaddingKt.m759padding3ABfNKs(PaddingKt.padding(Modifier.INSTANCE, padding), C0504Dp.m4382constructorimpl(16)), 0.0f, 1, null), ScrollKt.rememberScrollState(0, $composer, 0, 1), false, null, false, 14, null);
            Alignment.Horizontal start = Alignment.INSTANCE.getStart();
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            final MutableState<String> mutableState3 = this.$age$delegate;
            final String str = this.$systemStatus;
            final int i3 = this.$$dirty;
            final MutableState<String> mutableState4 = this.$gender$delegate;
            final MutableState<Boolean> mutableState5 = this.$hasCondition$delegate;
            final UserProfileManager userProfileManager = this.$userProfileManager;
            final Context context = this.$context;
            $composer.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation($composer, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(top, start, $composer, ((432 >> 3) & 14) | ((432 >> 3) & SdkConfig.SDK_VERSION));
            int $changed$iv$iv = (432 << 3) & SdkConfig.SDK_VERSION;
            $composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density$iv$iv = (Density) consume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(verticalScroll$default);
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                $composer.createNode(factory$iv$iv$iv);
            } else {
                $composer.useNode();
            }
            $composer.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer);
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
            $composer.startReplaceableGroup(2058660585);
            int $changed$iv8 = ($changed$iv$iv$iv >> 9) & 14;
            $composer.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation($composer, "C79@4027L9:Column.kt#2w3rfo");
            if (($changed$iv8 & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                $composer$iv = $composer;
            } else {
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int $changed9 = ((432 >> 6) & SdkConfig.SDK_VERSION) | 6;
                $composer.startReplaceableGroup(-2019474916);
                ComposerKt.sourceInformation($composer, "C42@1573L10,42@1522L65,45@1735L10,43@1600L228,51@1931L6,50@1877L1088,81@3292L10,82@3351L6,80@3188L252,88@3534L12,86@3454L286,94@3754L41,97@3905L10,97@3868L58,98@3939L466,112@4419L41,115@4506L715,133@5247L41,136@5349L57,137@5419L622,152@6055L41,155@6166L71,156@6250L612,171@6876L41,174@6958L868:ProfileScreen.kt#amutfg");
                if (($changed9 & 81) != 16 || !$composer.getSkipping()) {
                    TextKt.m1585TextfLXpl1I("Personal Information", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getH5(), $composer, 6, 0, 32766);
                    TextKt.m1585TextfLXpl1I("This information helps Smart Health provide personalized alerts.", PaddingKt.m763paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, C0504Dp.m4382constructorimpl(24), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getCaption(), $composer, 54, 0, 32764);
                    CardKt.m1280CardFjzlyU(PaddingKt.m763paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, C0504Dp.m4382constructorimpl(24), 7, null), null, MaterialTheme.INSTANCE.getColors($composer, MaterialTheme.$stable).m1321getSurface0d7_KjU(), 0L, null, C0504Dp.m4382constructorimpl(4), ComposableLambdaKt.composableLambda($composer, 85828825, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer2, int $changed10) {
                            Composer $composer$iv2;
                            Composer $composer3;
                            ComposerKt.sourceInformation($composer2, "C57@2130L821:ProfileScreen.kt#amutfg");
                            if (($changed10 & 11) != 2 || !$composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(85828825, $changed10, -1, "com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreen.<anonymous>.<anonymous>.<anonymous> (ProfileScreen.kt:56)");
                                }
                                Modifier modifier$iv = PaddingKt.m759padding3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(16));
                                String str2 = str;
                                int i4 = i3;
                                $composer2.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation($composer2, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((6 >> 3) & 14) | ((6 >> 3) & SdkConfig.SDK_VERSION));
                                int $changed$iv$iv2 = (6 << 3) & SdkConfig.SDK_VERSION;
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
                                Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv);
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
                                int $changed$iv9 = ($changed$iv$iv$iv2 >> 9) & 14;
                                $composer2.startReplaceableGroup(-1163856341);
                                ComposerKt.sourceInformation($composer2, "C79@4027L9:Column.kt#2w3rfo");
                                if (($changed$iv9 & 11) == 2 && $composer2.getSkipping()) {
                                    $composer2.skipToGroupEnd();
                                    $composer$iv2 = $composer2;
                                } else {
                                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                    int $changed11 = ((6 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                    $composer2.startReplaceableGroup(-529311197);
                                    ComposerKt.sourceInformation($composer2, "C60@2307L10,61@2375L6,58@2195L216,63@2432L40,66@2590L10,64@2493L132,70@2828L10,68@2646L287:ProfileScreen.kt#amutfg");
                                    if (($changed11 & 81) != 16 || !$composer2.getSkipping()) {
                                        TextKt.m1585TextfLXpl1I("System Reliability Status", null, MaterialTheme.INSTANCE.getColors($composer2, MaterialTheme.$stable).m1317getPrimary0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getSubtitle2(), $composer2, 6, 0, 32762);
                                        SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(4)), $composer2, 6);
                                        $composer$iv2 = $composer2;
                                        TextKt.m1585TextfLXpl1I(str2, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getH6(), $composer2, (i4 >> 3) & 14, 0, 32766);
                                        $composer3 = $composer2;
                                        TextKt.m1585TextfLXpl1I("The system automatically adapts from Medical Standards to Personal Data as it collects history.", PaddingKt.m763paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, C0504Dp.m4382constructorimpl(4), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getCaption(), $composer3, 54, 0, 32764);
                                    } else {
                                        $composer2.skipToGroupEnd();
                                        $composer$iv2 = $composer2;
                                        $composer3 = $composer2;
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
                                    return;
                                }
                                return;
                            }
                            $composer2.skipToGroupEnd();
                        }
                    }), $composer, 1769478, 26);
                    ProfileScreen$lambda$1 = ProfileScreenKt.ProfileScreen$lambda$1(mutableState3);
                    Integer intOrNull = StringsKt.toIntOrNull(ProfileScreen$lambda$1);
                    int currentAge = intOrNull != null ? intOrNull.intValue() : 30;
                    if (currentAge >= 18 && currentAge >= 60) {
                        i = 55;
                        i2 = 95;
                    } else {
                        i = 60;
                        i2 = 100;
                    }
                    Pair m294to = TuplesKt.m294to(i, Integer.valueOf(i2));
                    int minSafe = ((Number) m294to.component1()).intValue();
                    int maxSafe = ((Number) m294to.component2()).intValue();
                    TextKt.m1585TextfLXpl1I("Estimated Medically Safe Range: " + minSafe + " - " + maxSafe + " bpm", PaddingKt.m763paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, C0504Dp.m4382constructorimpl(8), 7, null), MaterialTheme.INSTANCE.getColors($composer, MaterialTheme.$stable).m1317getPrimary0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getCaption(), $composer, 48, 0, 32760);
                    ProfileScreen$lambda$12 = ProfileScreenKt.ProfileScreen$lambda$1(mutableState3);
                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, KeyboardType.INSTANCE.m4131getNumberPjHm6EE(), 0, 11, null);
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    $composer.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv6 = $composer.changed(mutableState3);
                    Object it$iv$iv5 = $composer.rememberedValue();
                    if (!invalid$iv$iv6 && it$iv$iv5 != Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = it$iv$iv5;
                        $composer.endReplaceableGroup();
                        OutlinedTextFieldKt.OutlinedTextField(ProfileScreen$lambda$12, (Function1<? super String, Unit>) value$iv$iv, fillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ProfileScreenKt.INSTANCE.m4718getLambda3$finished_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 1573248, 0, 520120);
                        SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(16)), $composer, 6);
                        TextKt.m1585TextfLXpl1I("Gender", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getSubtitle1(), $composer, 6, 0, 32766);
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        $composer.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation($composer, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        int $i$f$Row = ((384 >> 3) & 14) | ((384 >> 3) & SdkConfig.SDK_VERSION);
                        MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, $i$f$Row);
                        int $changed$iv$iv2 = (384 << 3) & SdkConfig.SDK_VERSION;
                        $composer.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume4 = $composer.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Density density$iv$iv2 = (Density) consume4;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume5 = $composer.consume(localLayoutDirection2);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume6 = $composer.consume(localViewConfiguration2);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv);
                        int $changed$iv9 = $changed$iv$iv2 << 9;
                        int $changed$iv$iv$iv2 = ($changed$iv9 & 7168) | 6;
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if (!$composer.getInserting()) {
                            $composer.createNode(factory$iv$iv$iv2);
                        } else {
                            $composer.useNode();
                        }
                        $composer.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer);
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer.enableReusing();
                        skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                        $composer.startReplaceableGroup(2058660585);
                        $changed$iv = ($changed$iv$iv$iv2 >> 9) & 14;
                        $composer.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation($composer, "C80@4021L9:Row.kt#2w3rfo");
                        if (($changed$iv & 11) == 2 || !$composer.getSkipping()) {
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            $changed2 = ((384 >> 6) & SdkConfig.SDK_VERSION) | 6;
                            $composer.startReplaceableGroup(742087480);
                            ComposerKt.sourceInformation($composer, "C101@4101L19,99@4009L129,103@4155L54,107@4321L21,105@4227L133,109@4377L14:ProfileScreen.kt#amutfg");
                            if (($changed2 & 81) == 16 || !$composer.getSkipping()) {
                                ProfileScreen$lambda$4 = ProfileScreenKt.ProfileScreen$lambda$4(mutableState4);
                                boolean areEqual = Intrinsics.areEqual(ProfileScreen$lambda$4, "Male");
                                $composer.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                                invalid$iv$iv = $composer.changed(mutableState4);
                                it$iv$iv = $composer.rememberedValue();
                                if (!invalid$iv$iv && it$iv$iv != Composer.INSTANCE.getEmpty()) {
                                    value$iv$iv2 = it$iv$iv;
                                    $composer.endReplaceableGroup();
                                    RadioButtonKt.RadioButton(areEqual, (Function0) value$iv$iv2, null, false, null, null, $composer, 0, 60);
                                    TextKt.m1585TextfLXpl1I("Male", PaddingKt.m763paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, C0504Dp.m4382constructorimpl(16), 0.0f, 11, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 54, 0, 65532);
                                    ProfileScreen$lambda$42 = ProfileScreenKt.ProfileScreen$lambda$4(mutableState4);
                                    boolean areEqual2 = Intrinsics.areEqual(ProfileScreen$lambda$42, "Female");
                                    $composer.startReplaceableGroup(1157296644);
                                    ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                                    invalid$iv$iv2 = $composer.changed(mutableState4);
                                    it$iv$iv2 = $composer.rememberedValue();
                                    if (!invalid$iv$iv2 && it$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                                        value$iv$iv3 = it$iv$iv2;
                                        $composer.endReplaceableGroup();
                                        RadioButtonKt.RadioButton(areEqual2, (Function0) value$iv$iv3, null, false, null, null, $composer, 0, 60);
                                        TextKt.m1585TextfLXpl1I("Female", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 6, 0, 65534);
                                    }
                                    value$iv$iv3 = (Function0) new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$3$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                            mutableState4.setValue("Female");
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv$iv3);
                                    $composer.endReplaceableGroup();
                                    RadioButtonKt.RadioButton(areEqual2, (Function0) value$iv$iv3, null, false, null, null, $composer, 0, 60);
                                    TextKt.m1585TextfLXpl1I("Female", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 6, 0, 65534);
                                }
                                value$iv$iv2 = (Function0) new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$3$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        mutableState4.setValue("Male");
                                    }
                                };
                                $composer.updateRememberedValue(value$iv$iv2);
                                $composer.endReplaceableGroup();
                                RadioButtonKt.RadioButton(areEqual, (Function0) value$iv$iv2, null, false, null, null, $composer, 0, 60);
                                TextKt.m1585TextfLXpl1I("Male", PaddingKt.m763paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, C0504Dp.m4382constructorimpl(16), 0.0f, 11, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 54, 0, 65532);
                                ProfileScreen$lambda$42 = ProfileScreenKt.ProfileScreen$lambda$4(mutableState4);
                                boolean areEqual22 = Intrinsics.areEqual(ProfileScreen$lambda$42, "Female");
                                $composer.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                                invalid$iv$iv2 = $composer.changed(mutableState4);
                                it$iv$iv2 = $composer.rememberedValue();
                                if (!invalid$iv$iv2) {
                                    value$iv$iv3 = it$iv$iv2;
                                    $composer.endReplaceableGroup();
                                    RadioButtonKt.RadioButton(areEqual22, (Function0) value$iv$iv3, null, false, null, null, $composer, 0, 60);
                                    TextKt.m1585TextfLXpl1I("Female", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 6, 0, 65534);
                                }
                                value$iv$iv3 = (Function0) new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$3$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        mutableState4.setValue("Female");
                                    }
                                };
                                $composer.updateRememberedValue(value$iv$iv3);
                                $composer.endReplaceableGroup();
                                RadioButtonKt.RadioButton(areEqual22, (Function0) value$iv$iv3, null, false, null, null, $composer, 0, 60);
                                TextKt.m1585TextfLXpl1I("Female", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 6, 0, 65534);
                            } else {
                                $composer.skipToGroupEnd();
                            }
                            $composer.endReplaceableGroup();
                        } else {
                            $composer.skipToGroupEnd();
                        }
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        $composer.endNode();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(24)), $composer, 6);
                        Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getSpaceBetween();
                        Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getCenterVertically();
                        $composer.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation($composer, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, ((438 >> 3) & 14) | ((438 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv3 = (438 << 3) & SdkConfig.SDK_VERSION;
                        $composer.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume7 = $composer.consume(localDensity3);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Density density$iv$iv3 = (Density) consume7;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume8 = $composer.consume(localLayoutDirection3);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume8;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume9 = $composer.consume(localViewConfiguration3);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume9;
                        Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv3 = LayoutKt.materializerOf(modifier$iv2);
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 9) & 7168) | 6;
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            $composer.createNode(factory$iv$iv$iv3);
                        } else {
                            $composer.useNode();
                        }
                        $composer.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m1639constructorimpl($composer);
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer.enableReusing();
                        skippableUpdate$iv$iv$iv3.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & SdkConfig.SDK_VERSION));
                        $composer.startReplaceableGroup(2058660585);
                        $changed$iv2 = ($changed$iv$iv$iv3 >> 9) & 14;
                        $composer.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation($composer, "C80@4021L9:Row.kt#2w3rfo");
                        if (($changed$iv2 & 11) == 2 || !$composer.getSkipping()) {
                            RowScope rowScope = RowScopeInstance.INSTANCE;
                            $changed3 = ((438 >> 6) & SdkConfig.SDK_VERSION) | 6;
                            $this$invoke_u24lambda_u2419_u24lambda_u246 = rowScope;
                            $composer.startReplaceableGroup(-1800427231);
                            ComposerKt.sourceInformation($composer, "C120@4713L348,129@5168L21,127@5078L129:ProfileScreen.kt#amutfg");
                            $dirty = $changed3;
                            if (($changed3 & 14) == 0) {
                                $dirty |= $composer.changed($this$invoke_u24lambda_u2419_u24lambda_u246) ? 4 : 2;
                            }
                            if (($dirty & 91) == 18 || !$composer.getSkipping()) {
                                Modifier modifier$iv3 = RowScope.weight$default($this$invoke_u24lambda_u2419_u24lambda_u246, Modifier.INSTANCE, 1.0f, false, 2, null);
                                $composer.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation($composer, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                                int $changed$iv$iv4 = (0 << 3) & SdkConfig.SDK_VERSION;
                                $composer.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object consume10 = $composer.consume(localDensity4);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                Density density$iv$iv4 = (Density) consume10;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object consume11 = $composer.consume(localLayoutDirection4);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                LayoutDirection layoutDirection$iv$iv4 = (LayoutDirection) consume11;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration4 = CompositionLocalsKt.getLocalViewConfiguration();
                                mutableState = mutableState3;
                                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object consume12 = $composer.consume(localViewConfiguration4);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ViewConfiguration viewConfiguration$iv$iv4 = (ViewConfiguration) consume12;
                                Function0 factory$iv$iv$iv4 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3 skippableUpdate$iv$iv$iv4 = LayoutKt.materializerOf(modifier$iv3);
                                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 9) & 7168) | 6;
                                $composer$iv = $composer;
                                if (!($composer.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer.startReusableNode();
                                if ($composer.getInserting()) {
                                    $composer.createNode(factory$iv$iv$iv4);
                                } else {
                                    $composer.useNode();
                                }
                                $composer.disableReusing();
                                Composer $this$Layout_u24lambda_u2d0$iv$iv4 = Updater.m1639constructorimpl($composer);
                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv4, density$iv$iv4, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv4, layoutDirection$iv$iv4, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv4, viewConfiguration$iv$iv4, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                $composer.enableReusing();
                                skippableUpdate$iv$iv$iv4.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv4 >> 3) & SdkConfig.SDK_VERSION));
                                $composer.startReplaceableGroup(2058660585);
                                $changed$iv3 = ($changed$iv$iv$iv4 >> 9) & 14;
                                $composer.startReplaceableGroup(-1163856341);
                                ComposerKt.sourceInformation($composer, "C79@4027L9:Column.kt#2w3rfo");
                                if (($changed$iv3 & 11) == 2 || !$composer.getSkipping()) {
                                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                    $changed4 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                    $composer.startReplaceableGroup(-968701461);
                                    ComposerKt.sourceInformation($composer, "C121@4829L10,121@4774L76,124@5003L10,122@4871L172:ProfileScreen.kt#amutfg");
                                    if (($changed4 & 81) == 16 || !$composer.getSkipping()) {
                                        TextKt.m1585TextfLXpl1I("Existing Heart Condition", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getSubtitle1(), $composer, 6, 0, 32766);
                                        TextKt.m1585TextfLXpl1I("Enabling this makes the alert system more sensitive.", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getCaption(), $composer, 6, 0, 32766);
                                    } else {
                                        $composer.skipToGroupEnd();
                                    }
                                    $composer.endReplaceableGroup();
                                } else {
                                    $composer.skipToGroupEnd();
                                }
                                $composer.endReplaceableGroup();
                                $composer.endReplaceableGroup();
                                $composer.endNode();
                                $composer.endReplaceableGroup();
                                $composer.endReplaceableGroup();
                                ProfileScreen$lambda$7 = ProfileScreenKt.ProfileScreen$lambda$7(mutableState5);
                                $composer.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                                invalid$iv$iv3 = $composer.changed(mutableState5);
                                Object it$iv$iv6 = $composer.rememberedValue();
                                if (!invalid$iv$iv3 || it$iv$iv6 == Composer.INSTANCE.getEmpty()) {
                                    value$iv$iv4 = (Function1) new Function1<Boolean, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$4$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                            invoke(bool.booleanValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(boolean it) {
                                            ProfileScreenKt.ProfileScreen$lambda$8(mutableState5, it);
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv$iv4);
                                } else {
                                    value$iv$iv4 = it$iv$iv6;
                                }
                                $composer.endReplaceableGroup();
                                SwitchKt.Switch(ProfileScreen$lambda$7, (Function1) value$iv$iv4, null, false, null, null, $composer, 0, 60);
                            } else {
                                $composer.skipToGroupEnd();
                                $composer$iv = $composer;
                                mutableState = mutableState3;
                            }
                            $composer.endReplaceableGroup();
                        } else {
                            $composer.skipToGroupEnd();
                            $composer$iv = $composer;
                            mutableState = mutableState3;
                        }
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        $composer.endNode();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(16)), $composer, 6);
                        $composer.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                        it$iv$iv3 = $composer.rememberedValue();
                        if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(userProfileManager.isAthlete()), null, 2, null);
                            $composer.updateRememberedValue(value$iv$iv5);
                        } else {
                            value$iv$iv5 = it$iv$iv3;
                        }
                        $composer.endReplaceableGroup();
                        final MutableState isAthlete$delegate = (MutableState) value$iv$iv5;
                        Modifier modifier$iv4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getSpaceBetween();
                        Alignment.Vertical verticalAlignment$iv3 = Alignment.INSTANCE.getCenterVertically();
                        $composer.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation($composer, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer, ((438 >> 3) & 14) | ((438 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv5 = (438 << 3) & SdkConfig.SDK_VERSION;
                        $composer.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume13 = $composer.consume(localDensity5);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Density density$iv$iv5 = (Density) consume13;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume14 = $composer.consume(localLayoutDirection5);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        LayoutDirection layoutDirection$iv$iv5 = (LayoutDirection) consume14;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration5 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume15 = $composer.consume(localViewConfiguration5);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ViewConfiguration viewConfiguration$iv$iv5 = (ViewConfiguration) consume15;
                        Function0 factory$iv$iv$iv5 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv5 = LayoutKt.materializerOf(modifier$iv4);
                        int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 9) & 7168) | 6;
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            $composer.createNode(factory$iv$iv$iv5);
                        } else {
                            $composer.useNode();
                        }
                        $composer.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv5 = Updater.m1639constructorimpl($composer);
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv5, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv5, density$iv$iv5, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv5, layoutDirection$iv$iv5, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv5, viewConfiguration$iv$iv5, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer.enableReusing();
                        skippableUpdate$iv$iv$iv5.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv5 >> 3) & SdkConfig.SDK_VERSION));
                        $composer.startReplaceableGroup(2058660585);
                        $changed$iv4 = ($changed$iv$iv$iv5 >> 9) & 14;
                        $composer.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation($composer, "C80@4021L9:Row.kt#2w3rfo");
                        if (($changed$iv4 & 11) == 2 || !$composer.getSkipping()) {
                            RowScope rowScope2 = RowScopeInstance.INSTANCE;
                            $changed5 = ((438 >> 6) & SdkConfig.SDK_VERSION) | 6;
                            $this$invoke_u24lambda_u2419_u24lambda_u2412 = rowScope2;
                            $composer.startReplaceableGroup(1526579136);
                            ComposerKt.sourceInformation($composer, "C142@5626L261,148@5991L18,146@5904L123:ProfileScreen.kt#amutfg");
                            $dirty2 = $changed5;
                            if (($changed5 & 14) == 0) {
                                $dirty2 |= $composer.changed($this$invoke_u24lambda_u2419_u24lambda_u2412) ? 4 : 2;
                            }
                            if (($dirty2 & 91) == 18 || !$composer.getSkipping()) {
                                Modifier modifier$iv5 = RowScope.weight$default($this$invoke_u24lambda_u2419_u24lambda_u2412, Modifier.INSTANCE, 1.0f, false, 2, null);
                                $composer.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation($composer, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                                MeasurePolicy measurePolicy$iv6 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                                int $changed$iv$iv6 = (0 << 3) & SdkConfig.SDK_VERSION;
                                $composer.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object consume16 = $composer.consume(localDensity6);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                Density density$iv$iv6 = (Density) consume16;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object consume17 = $composer.consume(localLayoutDirection6);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                LayoutDirection layoutDirection$iv$iv6 = (LayoutDirection) consume17;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration6 = CompositionLocalsKt.getLocalViewConfiguration();
                                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object consume18 = $composer.consume(localViewConfiguration6);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ViewConfiguration viewConfiguration$iv$iv6 = (ViewConfiguration) consume18;
                                Function0 factory$iv$iv$iv6 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3 skippableUpdate$iv$iv$iv6 = LayoutKt.materializerOf(modifier$iv5);
                                int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 9) & 7168) | 6;
                                mutableState2 = mutableState5;
                                if (!($composer.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer.startReusableNode();
                                if ($composer.getInserting()) {
                                    $composer.createNode(factory$iv$iv$iv6);
                                } else {
                                    $composer.useNode();
                                }
                                $composer.disableReusing();
                                Composer $this$Layout_u24lambda_u2d0$iv$iv6 = Updater.m1639constructorimpl($composer);
                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv6, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv6, density$iv$iv6, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv6, layoutDirection$iv$iv6, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv6, viewConfiguration$iv$iv6, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                $composer.enableReusing();
                                skippableUpdate$iv$iv$iv6.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv6 >> 3) & SdkConfig.SDK_VERSION));
                                $composer.startReplaceableGroup(2058660585);
                                $changed$iv5 = ($changed$iv$iv$iv6 >> 9) & 14;
                                $composer.startReplaceableGroup(-1163856341);
                                ComposerKt.sourceInformation($composer, "C79@4027L9:Column.kt#2w3rfo");
                                if (($changed$iv5 & 11) == 2 || !$composer.getSkipping()) {
                                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                                    $changed6 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                    $composer.startReplaceableGroup(-1936662390);
                                    ComposerKt.sourceInformation($composer, "C143@5741L10,143@5687L75,144@5850L10,144@5783L86:ProfileScreen.kt#amutfg");
                                    if (($changed6 & 81) == 16 || !$composer.getSkipping()) {
                                        TextKt.m1585TextfLXpl1I("Athlete / High Activity", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getSubtitle1(), $composer, 6, 0, 32766);
                                        TextKt.m1585TextfLXpl1I("Allows for lower resting heart rate.", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getCaption(), $composer, 6, 0, 32766);
                                    } else {
                                        $composer.skipToGroupEnd();
                                    }
                                    $composer.endReplaceableGroup();
                                } else {
                                    $composer.skipToGroupEnd();
                                }
                                $composer.endReplaceableGroup();
                                $composer.endReplaceableGroup();
                                $composer.endNode();
                                $composer.endReplaceableGroup();
                                $composer.endReplaceableGroup();
                                boolean invoke$lambda$19$lambda$8 = invoke$lambda$19$lambda$8(isAthlete$delegate);
                                $composer.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                                invalid$iv$iv4 = $composer.changed(isAthlete$delegate);
                                Object it$iv$iv7 = $composer.rememberedValue();
                                if (!invalid$iv$iv4 || it$iv$iv7 == Composer.INSTANCE.getEmpty()) {
                                    value$iv$iv6 = (Function1) new Function1<Boolean, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$5$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                            invoke(bool.booleanValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(boolean it) {
                                            ProfileScreenKt$ProfileScreen$1.invoke$lambda$19$lambda$9(isAthlete$delegate, it);
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv$iv6);
                                } else {
                                    value$iv$iv6 = it$iv$iv7;
                                }
                                $composer.endReplaceableGroup();
                                SwitchKt.Switch(invoke$lambda$19$lambda$8, (Function1) value$iv$iv6, null, false, null, null, $composer, 0, 60);
                            } else {
                                $composer.skipToGroupEnd();
                                mutableState2 = mutableState5;
                            }
                            $composer.endReplaceableGroup();
                        } else {
                            $composer.skipToGroupEnd();
                            mutableState2 = mutableState5;
                        }
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        $composer.endNode();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(16)), $composer, 6);
                        $composer.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                        it$iv$iv4 = $composer.rememberedValue();
                        if (it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(userProfileManager.getHasRespiratoryCondition()), null, 2, null);
                            $composer.updateRememberedValue(value$iv$iv7);
                        } else {
                            value$iv$iv7 = it$iv$iv4;
                        }
                        $composer.endReplaceableGroup();
                        final MutableState hasRespiratory$delegate = (MutableState) value$iv$iv7;
                        Modifier modifier$iv6 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.Horizontal horizontalArrangement$iv4 = Arrangement.INSTANCE.getSpaceBetween();
                        Alignment.Vertical verticalAlignment$iv4 = Alignment.INSTANCE.getCenterVertically();
                        $composer.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation($composer, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv7 = RowKt.rowMeasurePolicy(horizontalArrangement$iv4, verticalAlignment$iv4, $composer, ((438 >> 3) & 14) | ((438 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv7 = (438 << 3) & SdkConfig.SDK_VERSION;
                        $composer.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume19 = $composer.consume(localDensity7);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Density density$iv$iv7 = (Density) consume19;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection7 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume20 = $composer.consume(localLayoutDirection7);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        LayoutDirection layoutDirection$iv$iv7 = (LayoutDirection) consume20;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration7 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume21 = $composer.consume(localViewConfiguration7);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ViewConfiguration viewConfiguration$iv$iv7 = (ViewConfiguration) consume21;
                        Function0 factory$iv$iv$iv7 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv7 = LayoutKt.materializerOf(modifier$iv6);
                        int $changed$iv$iv$iv7 = (($changed$iv$iv7 << 9) & 7168) | 6;
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            $composer.createNode(factory$iv$iv$iv7);
                        } else {
                            $composer.useNode();
                        }
                        $composer.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv7 = Updater.m1639constructorimpl($composer);
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv7, measurePolicy$iv7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv7, density$iv$iv7, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv7, layoutDirection$iv$iv7, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv7, viewConfiguration$iv$iv7, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer.enableReusing();
                        skippableUpdate$iv$iv$iv7.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv7 >> 3) & SdkConfig.SDK_VERSION));
                        $composer.startReplaceableGroup(2058660585);
                        $changed$iv6 = ($changed$iv$iv$iv7 >> 9) & 14;
                        $composer.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation($composer, "C80@4021L9:Row.kt#2w3rfo");
                        if (($changed$iv6 & 11) == 2 || !$composer.getSkipping()) {
                            RowScope rowScope3 = RowScopeInstance.INSTANCE;
                            $changed7 = ((438 >> 6) & SdkConfig.SDK_VERSION) | 6;
                            $this$invoke_u24lambda_u2419_u24lambda_u2418 = rowScope3;
                            $composer.startReplaceableGroup(558618207);
                            ComposerKt.sourceInformation($composer, "C161@6457L241,167@6807L23,165@6715L133:ProfileScreen.kt#amutfg");
                            $dirty3 = $changed7;
                            if (($changed7 & 14) == 0) {
                                $dirty3 |= $composer.changed($this$invoke_u24lambda_u2419_u24lambda_u2418) ? 4 : 2;
                            }
                            if (($dirty3 & 91) == 18 || !$composer.getSkipping()) {
                                Modifier modifier$iv7 = RowScope.weight$default($this$invoke_u24lambda_u2419_u24lambda_u2418, Modifier.INSTANCE, 1.0f, false, 2, null);
                                $composer.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation($composer, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                                Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                                Alignment.Horizontal horizontalAlignment$iv3 = Alignment.INSTANCE.getStart();
                                MeasurePolicy measurePolicy$iv8 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                                int $changed$iv$iv8 = (0 << 3) & SdkConfig.SDK_VERSION;
                                $composer.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object consume22 = $composer.consume(localDensity8);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                Density density$iv$iv8 = (Density) consume22;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection8 = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object consume23 = $composer.consume(localLayoutDirection8);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                LayoutDirection layoutDirection$iv$iv8 = (LayoutDirection) consume23;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration8 = CompositionLocalsKt.getLocalViewConfiguration();
                                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object consume24 = $composer.consume(localViewConfiguration8);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ViewConfiguration viewConfiguration$iv$iv8 = (ViewConfiguration) consume24;
                                Function0 factory$iv$iv$iv8 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3 skippableUpdate$iv$iv$iv8 = LayoutKt.materializerOf(modifier$iv7);
                                int $changed$iv$iv$iv8 = (($changed$iv$iv8 << 9) & 7168) | 6;
                                if (!($composer.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer.startReusableNode();
                                if ($composer.getInserting()) {
                                    $composer.createNode(factory$iv$iv$iv8);
                                } else {
                                    $composer.useNode();
                                }
                                $composer.disableReusing();
                                Composer $this$Layout_u24lambda_u2d0$iv$iv8 = Updater.m1639constructorimpl($composer);
                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv8, measurePolicy$iv8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv8, density$iv$iv8, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv8, layoutDirection$iv$iv8, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv8, viewConfiguration$iv$iv8, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                $composer.enableReusing();
                                skippableUpdate$iv$iv$iv8.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv8 >> 3) & SdkConfig.SDK_VERSION));
                                $composer.startReplaceableGroup(2058660585);
                                $changed$iv7 = ($changed$iv$iv$iv8 >> 9) & 14;
                                $composer.startReplaceableGroup(-1163856341);
                                ComposerKt.sourceInformation($composer, "C79@4027L9:Column.kt#2w3rfo");
                                if (($changed$iv7 & 11) == 2 || !$composer.getSkipping()) {
                                    ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                                    $changed8 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                    $composer.startReplaceableGroup(1390343977);
                                    ComposerKt.sourceInformation($composer, "C162@6570L10,162@6518L73,163@6661L10,163@6612L68:ProfileScreen.kt#amutfg");
                                    if (($changed8 & 81) == 16 || !$composer.getSkipping()) {
                                        TextKt.m1585TextfLXpl1I("Respiratory Condition", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getSubtitle1(), $composer, 6, 0, 32766);
                                        TextKt.m1585TextfLXpl1I("Asthma, COPD, etc.", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getCaption(), $composer, 6, 0, 32766);
                                    } else {
                                        $composer.skipToGroupEnd();
                                    }
                                    $composer.endReplaceableGroup();
                                } else {
                                    $composer.skipToGroupEnd();
                                }
                                $composer.endReplaceableGroup();
                                $composer.endReplaceableGroup();
                                $composer.endNode();
                                $composer.endReplaceableGroup();
                                $composer.endReplaceableGroup();
                                boolean invoke$lambda$19$lambda$14 = invoke$lambda$19$lambda$14(hasRespiratory$delegate);
                                $composer.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                                invalid$iv$iv5 = $composer.changed(hasRespiratory$delegate);
                                Object it$iv$iv8 = $composer.rememberedValue();
                                if (!invalid$iv$iv5 || it$iv$iv8 == Composer.INSTANCE.getEmpty()) {
                                    value$iv$iv8 = new Function1<Boolean, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$6$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                            invoke(bool.booleanValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(boolean it) {
                                            ProfileScreenKt$ProfileScreen$1.invoke$lambda$19$lambda$15(hasRespiratory$delegate, it);
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv$iv8);
                                } else {
                                    value$iv$iv8 = it$iv$iv8;
                                }
                                $composer.endReplaceableGroup();
                                SwitchKt.Switch(invoke$lambda$19$lambda$14, (Function1) value$iv$iv8, null, false, null, null, $composer, 0, 60);
                            } else {
                                $composer.skipToGroupEnd();
                            }
                            $composer.endReplaceableGroup();
                        } else {
                            $composer.skipToGroupEnd();
                        }
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        $composer.endNode();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(32)), $composer, 6);
                        final MutableState<String> mutableState6 = mutableState;
                        final MutableState<Boolean> mutableState7 = mutableState2;
                        ButtonKt.Button(new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                String ProfileScreen$lambda$13;
                                String ProfileScreen$lambda$43;
                                boolean ProfileScreen$lambda$72;
                                boolean invoke$lambda$19$lambda$82;
                                boolean invoke$lambda$19$lambda$142;
                                ProfileScreen$lambda$13 = ProfileScreenKt.ProfileScreen$lambda$1(mutableState6);
                                Integer ageInt = StringsKt.toIntOrNull(ProfileScreen$lambda$13);
                                if (ageInt == null || ageInt.intValue() <= 0 || ageInt.intValue() >= 120) {
                                    Toast.makeText(context, "Invalid Age", 0).show();
                                    return;
                                }
                                UserProfileManager.this.setAge(ageInt.intValue());
                                UserProfileManager userProfileManager2 = UserProfileManager.this;
                                ProfileScreen$lambda$43 = ProfileScreenKt.ProfileScreen$lambda$4(mutableState4);
                                userProfileManager2.setGender(ProfileScreen$lambda$43);
                                UserProfileManager userProfileManager3 = UserProfileManager.this;
                                ProfileScreen$lambda$72 = ProfileScreenKt.ProfileScreen$lambda$7(mutableState7);
                                userProfileManager3.setHasHeartCondition(ProfileScreen$lambda$72);
                                UserProfileManager userProfileManager4 = UserProfileManager.this;
                                invoke$lambda$19$lambda$82 = ProfileScreenKt$ProfileScreen$1.invoke$lambda$19$lambda$8(isAthlete$delegate);
                                userProfileManager4.setAthlete(invoke$lambda$19$lambda$82);
                                UserProfileManager userProfileManager5 = UserProfileManager.this;
                                invoke$lambda$19$lambda$142 = ProfileScreenKt$ProfileScreen$1.invoke$lambda$19$lambda$14(hasRespiratory$delegate);
                                userProfileManager5.setHasRespiratoryCondition(invoke$lambda$19$lambda$142);
                                Toast.makeText(context, "Profile Saved", 0).show();
                            }
                        }, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, null, null, null, null, null, null, ComposableSingletons$ProfileScreenKt.INSTANCE.m4719getLambda4$finished_debug(), $composer, 805306416, 508);
                    }
                    value$iv$iv = (Function1) new Function1<String, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                            invoke2(str2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            mutableState3.setValue(it);
                        }
                    };
                    $composer.updateRememberedValue(value$iv$iv);
                    $composer.endReplaceableGroup();
                    OutlinedTextFieldKt.OutlinedTextField(ProfileScreen$lambda$12, (Function1<? super String, Unit>) value$iv$iv, fillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ProfileScreenKt.INSTANCE.m4718getLambda3$finished_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 1573248, 0, 520120);
                    SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(16)), $composer, 6);
                    TextKt.m1585TextfLXpl1I("Gender", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getSubtitle1(), $composer, 6, 0, 32766);
                    Alignment.Vertical verticalAlignment$iv5 = Alignment.INSTANCE.getCenterVertically();
                    $composer.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation($composer, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                    Modifier modifier$iv8 = Modifier.INSTANCE;
                    Arrangement.Horizontal horizontalArrangement$iv5 = Arrangement.INSTANCE.getStart();
                    int $i$f$Row2 = ((384 >> 3) & 14) | ((384 >> 3) & SdkConfig.SDK_VERSION);
                    MeasurePolicy measurePolicy$iv22 = RowKt.rowMeasurePolicy(horizontalArrangement$iv5, verticalAlignment$iv5, $composer, $i$f$Row2);
                    int $changed$iv$iv22 = (384 << 3) & SdkConfig.SDK_VERSION;
                    $composer.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume42 = $composer.consume(localDensity22);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Density density$iv$iv22 = (Density) consume42;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume52 = $composer.consume(localLayoutDirection22);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    LayoutDirection layoutDirection$iv$iv22 = (LayoutDirection) consume52;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration22 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume62 = $composer.consume(localViewConfiguration22);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ViewConfiguration viewConfiguration$iv$iv22 = (ViewConfiguration) consume62;
                    Function0 factory$iv$iv$iv22 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv22 = LayoutKt.materializerOf(modifier$iv8);
                    int $changed$iv92 = $changed$iv$iv22 << 9;
                    int $changed$iv$iv$iv22 = ($changed$iv92 & 7168) | 6;
                    if (!($composer.getApplier() instanceof Applier)) {
                    }
                    $composer.startReusableNode();
                    if (!$composer.getInserting()) {
                    }
                    $composer.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv22 = Updater.m1639constructorimpl($composer);
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, measurePolicy$iv22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, density$iv$iv22, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, layoutDirection$iv$iv22, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, viewConfiguration$iv$iv22, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    $composer.enableReusing();
                    skippableUpdate$iv$iv$iv22.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv22 >> 3) & SdkConfig.SDK_VERSION));
                    $composer.startReplaceableGroup(2058660585);
                    $changed$iv = ($changed$iv$iv$iv22 >> 9) & 14;
                    $composer.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation($composer, "C80@4021L9:Row.kt#2w3rfo");
                    if (($changed$iv & 11) == 2) {
                    }
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    $changed2 = ((384 >> 6) & SdkConfig.SDK_VERSION) | 6;
                    $composer.startReplaceableGroup(742087480);
                    ComposerKt.sourceInformation($composer, "C101@4101L19,99@4009L129,103@4155L54,107@4321L21,105@4227L133,109@4377L14:ProfileScreen.kt#amutfg");
                    if (($changed2 & 81) == 16) {
                    }
                    ProfileScreen$lambda$4 = ProfileScreenKt.ProfileScreen$lambda$4(mutableState4);
                    boolean areEqual3 = Intrinsics.areEqual(ProfileScreen$lambda$4, "Male");
                    $composer.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                    invalid$iv$iv = $composer.changed(mutableState4);
                    it$iv$iv = $composer.rememberedValue();
                    if (!invalid$iv$iv) {
                        value$iv$iv2 = it$iv$iv;
                        $composer.endReplaceableGroup();
                        RadioButtonKt.RadioButton(areEqual3, (Function0) value$iv$iv2, null, false, null, null, $composer, 0, 60);
                        TextKt.m1585TextfLXpl1I("Male", PaddingKt.m763paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, C0504Dp.m4382constructorimpl(16), 0.0f, 11, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 54, 0, 65532);
                        ProfileScreen$lambda$42 = ProfileScreenKt.ProfileScreen$lambda$4(mutableState4);
                        boolean areEqual222 = Intrinsics.areEqual(ProfileScreen$lambda$42, "Female");
                        $composer.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                        invalid$iv$iv2 = $composer.changed(mutableState4);
                        it$iv$iv2 = $composer.rememberedValue();
                        if (!invalid$iv$iv2) {
                        }
                        value$iv$iv3 = (Function0) new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$3$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                mutableState4.setValue("Female");
                            }
                        };
                        $composer.updateRememberedValue(value$iv$iv3);
                        $composer.endReplaceableGroup();
                        RadioButtonKt.RadioButton(areEqual222, (Function0) value$iv$iv3, null, false, null, null, $composer, 0, 60);
                        TextKt.m1585TextfLXpl1I("Female", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 6, 0, 65534);
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        $composer.endNode();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(24)), $composer, 6);
                        Modifier modifier$iv22 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.Horizontal horizontalArrangement$iv22 = Arrangement.INSTANCE.getSpaceBetween();
                        Alignment.Vertical verticalAlignment$iv22 = Alignment.INSTANCE.getCenterVertically();
                        $composer.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation($composer, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv32 = RowKt.rowMeasurePolicy(horizontalArrangement$iv22, verticalAlignment$iv22, $composer, ((438 >> 3) & 14) | ((438 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv32 = (438 << 3) & SdkConfig.SDK_VERSION;
                        $composer.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity32 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume72 = $composer.consume(localDensity32);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Density density$iv$iv32 = (Density) consume72;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection32 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume82 = $composer.consume(localLayoutDirection32);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        LayoutDirection layoutDirection$iv$iv32 = (LayoutDirection) consume82;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration32 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume92 = $composer.consume(localViewConfiguration32);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ViewConfiguration viewConfiguration$iv$iv32 = (ViewConfiguration) consume92;
                        Function0 factory$iv$iv$iv32 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv32 = LayoutKt.materializerOf(modifier$iv22);
                        int $changed$iv$iv$iv32 = (($changed$iv$iv32 << 9) & 7168) | 6;
                        if (!($composer.getApplier() instanceof Applier)) {
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                        }
                        $composer.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv32 = Updater.m1639constructorimpl($composer);
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv32, measurePolicy$iv32, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv32, density$iv$iv32, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv32, layoutDirection$iv$iv32, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv32, viewConfiguration$iv$iv32, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer.enableReusing();
                        skippableUpdate$iv$iv$iv32.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv32 >> 3) & SdkConfig.SDK_VERSION));
                        $composer.startReplaceableGroup(2058660585);
                        $changed$iv2 = ($changed$iv$iv$iv32 >> 9) & 14;
                        $composer.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation($composer, "C80@4021L9:Row.kt#2w3rfo");
                        if (($changed$iv2 & 11) == 2) {
                        }
                        RowScope rowScope4 = RowScopeInstance.INSTANCE;
                        $changed3 = ((438 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        $this$invoke_u24lambda_u2419_u24lambda_u246 = rowScope4;
                        $composer.startReplaceableGroup(-1800427231);
                        ComposerKt.sourceInformation($composer, "C120@4713L348,129@5168L21,127@5078L129:ProfileScreen.kt#amutfg");
                        $dirty = $changed3;
                        if (($changed3 & 14) == 0) {
                        }
                        if (($dirty & 91) == 18) {
                        }
                        Modifier modifier$iv32 = RowScope.weight$default($this$invoke_u24lambda_u2419_u24lambda_u246, Modifier.INSTANCE, 1.0f, false, 2, null);
                        $composer.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation($composer, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv4 = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv4 = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv42 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv4, horizontalAlignment$iv4, $composer, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv42 = (0 << 3) & SdkConfig.SDK_VERSION;
                        $composer.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity42 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume102 = $composer.consume(localDensity42);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Density density$iv$iv42 = (Density) consume102;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection42 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume112 = $composer.consume(localLayoutDirection42);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        LayoutDirection layoutDirection$iv$iv42 = (LayoutDirection) consume112;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration42 = CompositionLocalsKt.getLocalViewConfiguration();
                        mutableState = mutableState3;
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume122 = $composer.consume(localViewConfiguration42);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ViewConfiguration viewConfiguration$iv$iv42 = (ViewConfiguration) consume122;
                        Function0 factory$iv$iv$iv42 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv42 = LayoutKt.materializerOf(modifier$iv32);
                        int $changed$iv$iv$iv42 = (($changed$iv$iv42 << 9) & 7168) | 6;
                        $composer$iv = $composer;
                        if (!($composer.getApplier() instanceof Applier)) {
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                        }
                        $composer.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv42 = Updater.m1639constructorimpl($composer);
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv42, measurePolicy$iv42, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv42, density$iv$iv42, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv42, layoutDirection$iv$iv42, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv42, viewConfiguration$iv$iv42, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer.enableReusing();
                        skippableUpdate$iv$iv$iv42.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv42 >> 3) & SdkConfig.SDK_VERSION));
                        $composer.startReplaceableGroup(2058660585);
                        $changed$iv3 = ($changed$iv$iv$iv42 >> 9) & 14;
                        $composer.startReplaceableGroup(-1163856341);
                        ComposerKt.sourceInformation($composer, "C79@4027L9:Column.kt#2w3rfo");
                        if (($changed$iv3 & 11) == 2) {
                        }
                        ColumnScopeInstance columnScopeInstance22 = ColumnScopeInstance.INSTANCE;
                        $changed4 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        $composer.startReplaceableGroup(-968701461);
                        ComposerKt.sourceInformation($composer, "C121@4829L10,121@4774L76,124@5003L10,122@4871L172:ProfileScreen.kt#amutfg");
                        if (($changed4 & 81) == 16) {
                        }
                        TextKt.m1585TextfLXpl1I("Existing Heart Condition", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getSubtitle1(), $composer, 6, 0, 32766);
                        TextKt.m1585TextfLXpl1I("Enabling this makes the alert system more sensitive.", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getCaption(), $composer, 6, 0, 32766);
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        $composer.endNode();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        ProfileScreen$lambda$7 = ProfileScreenKt.ProfileScreen$lambda$7(mutableState5);
                        $composer.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                        invalid$iv$iv3 = $composer.changed(mutableState5);
                        Object it$iv$iv62 = $composer.rememberedValue();
                        if (invalid$iv$iv3) {
                        }
                        value$iv$iv4 = (Function1) new Function1<Boolean, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$4$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean it) {
                                ProfileScreenKt.ProfileScreen$lambda$8(mutableState5, it);
                            }
                        };
                        $composer.updateRememberedValue(value$iv$iv4);
                        $composer.endReplaceableGroup();
                        SwitchKt.Switch(ProfileScreen$lambda$7, (Function1) value$iv$iv4, null, false, null, null, $composer, 0, 60);
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        $composer.endNode();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(16)), $composer, 6);
                        $composer.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                        it$iv$iv3 = $composer.rememberedValue();
                        if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                        }
                        $composer.endReplaceableGroup();
                        final MutableState<Boolean> isAthlete$delegate2 = (MutableState) value$iv$iv5;
                        Modifier modifier$iv42 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.Horizontal horizontalArrangement$iv32 = Arrangement.INSTANCE.getSpaceBetween();
                        Alignment.Vertical verticalAlignment$iv32 = Alignment.INSTANCE.getCenterVertically();
                        $composer.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation($composer, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv52 = RowKt.rowMeasurePolicy(horizontalArrangement$iv32, verticalAlignment$iv32, $composer, ((438 >> 3) & 14) | ((438 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv52 = (438 << 3) & SdkConfig.SDK_VERSION;
                        $composer.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity52 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume132 = $composer.consume(localDensity52);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Density density$iv$iv52 = (Density) consume132;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection52 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume142 = $composer.consume(localLayoutDirection52);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        LayoutDirection layoutDirection$iv$iv52 = (LayoutDirection) consume142;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration52 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume152 = $composer.consume(localViewConfiguration52);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ViewConfiguration viewConfiguration$iv$iv52 = (ViewConfiguration) consume152;
                        Function0 factory$iv$iv$iv52 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv52 = LayoutKt.materializerOf(modifier$iv42);
                        int $changed$iv$iv$iv52 = (($changed$iv$iv52 << 9) & 7168) | 6;
                        if (!($composer.getApplier() instanceof Applier)) {
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                        }
                        $composer.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv52 = Updater.m1639constructorimpl($composer);
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv52, measurePolicy$iv52, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv52, density$iv$iv52, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv52, layoutDirection$iv$iv52, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv52, viewConfiguration$iv$iv52, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer.enableReusing();
                        skippableUpdate$iv$iv$iv52.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv52 >> 3) & SdkConfig.SDK_VERSION));
                        $composer.startReplaceableGroup(2058660585);
                        $changed$iv4 = ($changed$iv$iv$iv52 >> 9) & 14;
                        $composer.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation($composer, "C80@4021L9:Row.kt#2w3rfo");
                        if (($changed$iv4 & 11) == 2) {
                        }
                        RowScope rowScope22 = RowScopeInstance.INSTANCE;
                        $changed5 = ((438 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        $this$invoke_u24lambda_u2419_u24lambda_u2412 = rowScope22;
                        $composer.startReplaceableGroup(1526579136);
                        ComposerKt.sourceInformation($composer, "C142@5626L261,148@5991L18,146@5904L123:ProfileScreen.kt#amutfg");
                        $dirty2 = $changed5;
                        if (($changed5 & 14) == 0) {
                        }
                        if (($dirty2 & 91) == 18) {
                        }
                        Modifier modifier$iv52 = RowScope.weight$default($this$invoke_u24lambda_u2419_u24lambda_u2412, Modifier.INSTANCE, 1.0f, false, 2, null);
                        $composer.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation($composer, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv22 = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv22 = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv62 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv22, horizontalAlignment$iv22, $composer, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv62 = (0 << 3) & SdkConfig.SDK_VERSION;
                        $composer.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity62 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume162 = $composer.consume(localDensity62);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Density density$iv$iv62 = (Density) consume162;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection62 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume172 = $composer.consume(localLayoutDirection62);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        LayoutDirection layoutDirection$iv$iv62 = (LayoutDirection) consume172;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration62 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume182 = $composer.consume(localViewConfiguration62);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ViewConfiguration viewConfiguration$iv$iv62 = (ViewConfiguration) consume182;
                        Function0 factory$iv$iv$iv62 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv62 = LayoutKt.materializerOf(modifier$iv52);
                        int $changed$iv$iv$iv62 = (($changed$iv$iv62 << 9) & 7168) | 6;
                        mutableState2 = mutableState5;
                        if (!($composer.getApplier() instanceof Applier)) {
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                        }
                        $composer.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv62 = Updater.m1639constructorimpl($composer);
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv62, measurePolicy$iv62, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv62, density$iv$iv62, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv62, layoutDirection$iv$iv62, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv62, viewConfiguration$iv$iv62, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer.enableReusing();
                        skippableUpdate$iv$iv$iv62.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv62 >> 3) & SdkConfig.SDK_VERSION));
                        $composer.startReplaceableGroup(2058660585);
                        $changed$iv5 = ($changed$iv$iv$iv62 >> 9) & 14;
                        $composer.startReplaceableGroup(-1163856341);
                        ComposerKt.sourceInformation($composer, "C79@4027L9:Column.kt#2w3rfo");
                        if (($changed$iv5 & 11) == 2) {
                        }
                        ColumnScopeInstance columnScopeInstance32 = ColumnScopeInstance.INSTANCE;
                        $changed6 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        $composer.startReplaceableGroup(-1936662390);
                        ComposerKt.sourceInformation($composer, "C143@5741L10,143@5687L75,144@5850L10,144@5783L86:ProfileScreen.kt#amutfg");
                        if (($changed6 & 81) == 16) {
                        }
                        TextKt.m1585TextfLXpl1I("Athlete / High Activity", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getSubtitle1(), $composer, 6, 0, 32766);
                        TextKt.m1585TextfLXpl1I("Allows for lower resting heart rate.", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getCaption(), $composer, 6, 0, 32766);
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        $composer.endNode();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        boolean invoke$lambda$19$lambda$82 = invoke$lambda$19$lambda$8(isAthlete$delegate2);
                        $composer.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                        invalid$iv$iv4 = $composer.changed(isAthlete$delegate2);
                        Object it$iv$iv72 = $composer.rememberedValue();
                        if (invalid$iv$iv4) {
                        }
                        value$iv$iv6 = (Function1) new Function1<Boolean, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$5$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean it) {
                                ProfileScreenKt$ProfileScreen$1.invoke$lambda$19$lambda$9(isAthlete$delegate2, it);
                            }
                        };
                        $composer.updateRememberedValue(value$iv$iv6);
                        $composer.endReplaceableGroup();
                        SwitchKt.Switch(invoke$lambda$19$lambda$82, (Function1) value$iv$iv6, null, false, null, null, $composer, 0, 60);
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        $composer.endNode();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(16)), $composer, 6);
                        $composer.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                        it$iv$iv4 = $composer.rememberedValue();
                        if (it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
                        }
                        $composer.endReplaceableGroup();
                        final MutableState<Boolean> hasRespiratory$delegate2 = (MutableState) value$iv$iv7;
                        Modifier modifier$iv62 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.Horizontal horizontalArrangement$iv42 = Arrangement.INSTANCE.getSpaceBetween();
                        Alignment.Vertical verticalAlignment$iv42 = Alignment.INSTANCE.getCenterVertically();
                        $composer.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation($composer, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv72 = RowKt.rowMeasurePolicy(horizontalArrangement$iv42, verticalAlignment$iv42, $composer, ((438 >> 3) & 14) | ((438 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv72 = (438 << 3) & SdkConfig.SDK_VERSION;
                        $composer.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity72 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume192 = $composer.consume(localDensity72);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Density density$iv$iv72 = (Density) consume192;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection72 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume202 = $composer.consume(localLayoutDirection72);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        LayoutDirection layoutDirection$iv$iv72 = (LayoutDirection) consume202;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration72 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume212 = $composer.consume(localViewConfiguration72);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ViewConfiguration viewConfiguration$iv$iv72 = (ViewConfiguration) consume212;
                        Function0 factory$iv$iv$iv72 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv72 = LayoutKt.materializerOf(modifier$iv62);
                        int $changed$iv$iv$iv72 = (($changed$iv$iv72 << 9) & 7168) | 6;
                        if (!($composer.getApplier() instanceof Applier)) {
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                        }
                        $composer.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv72 = Updater.m1639constructorimpl($composer);
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv72, measurePolicy$iv72, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv72, density$iv$iv72, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv72, layoutDirection$iv$iv72, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv72, viewConfiguration$iv$iv72, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer.enableReusing();
                        skippableUpdate$iv$iv$iv72.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv72 >> 3) & SdkConfig.SDK_VERSION));
                        $composer.startReplaceableGroup(2058660585);
                        $changed$iv6 = ($changed$iv$iv$iv72 >> 9) & 14;
                        $composer.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation($composer, "C80@4021L9:Row.kt#2w3rfo");
                        if (($changed$iv6 & 11) == 2) {
                        }
                        RowScope rowScope32 = RowScopeInstance.INSTANCE;
                        $changed7 = ((438 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        $this$invoke_u24lambda_u2419_u24lambda_u2418 = rowScope32;
                        $composer.startReplaceableGroup(558618207);
                        ComposerKt.sourceInformation($composer, "C161@6457L241,167@6807L23,165@6715L133:ProfileScreen.kt#amutfg");
                        $dirty3 = $changed7;
                        if (($changed7 & 14) == 0) {
                        }
                        if (($dirty3 & 91) == 18) {
                        }
                        Modifier modifier$iv72 = RowScope.weight$default($this$invoke_u24lambda_u2419_u24lambda_u2418, Modifier.INSTANCE, 1.0f, false, 2, null);
                        $composer.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation($composer, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv32 = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv32 = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv82 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv32, horizontalAlignment$iv32, $composer, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv82 = (0 << 3) & SdkConfig.SDK_VERSION;
                        $composer.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity82 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume222 = $composer.consume(localDensity82);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Density density$iv$iv82 = (Density) consume222;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection82 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume232 = $composer.consume(localLayoutDirection82);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        LayoutDirection layoutDirection$iv$iv82 = (LayoutDirection) consume232;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration82 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume242 = $composer.consume(localViewConfiguration82);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ViewConfiguration viewConfiguration$iv$iv82 = (ViewConfiguration) consume242;
                        Function0 factory$iv$iv$iv82 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv82 = LayoutKt.materializerOf(modifier$iv72);
                        int $changed$iv$iv$iv82 = (($changed$iv$iv82 << 9) & 7168) | 6;
                        if (!($composer.getApplier() instanceof Applier)) {
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                        }
                        $composer.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv82 = Updater.m1639constructorimpl($composer);
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv82, measurePolicy$iv82, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv82, density$iv$iv82, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv82, layoutDirection$iv$iv82, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv82, viewConfiguration$iv$iv82, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer.enableReusing();
                        skippableUpdate$iv$iv$iv82.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv82 >> 3) & SdkConfig.SDK_VERSION));
                        $composer.startReplaceableGroup(2058660585);
                        $changed$iv7 = ($changed$iv$iv$iv82 >> 9) & 14;
                        $composer.startReplaceableGroup(-1163856341);
                        ComposerKt.sourceInformation($composer, "C79@4027L9:Column.kt#2w3rfo");
                        if (($changed$iv7 & 11) == 2) {
                        }
                        ColumnScopeInstance columnScopeInstance42 = ColumnScopeInstance.INSTANCE;
                        $changed8 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        $composer.startReplaceableGroup(1390343977);
                        ComposerKt.sourceInformation($composer, "C162@6570L10,162@6518L73,163@6661L10,163@6612L68:ProfileScreen.kt#amutfg");
                        if (($changed8 & 81) == 16) {
                        }
                        TextKt.m1585TextfLXpl1I("Respiratory Condition", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getSubtitle1(), $composer, 6, 0, 32766);
                        TextKt.m1585TextfLXpl1I("Asthma, COPD, etc.", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getCaption(), $composer, 6, 0, 32766);
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        $composer.endNode();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        boolean invoke$lambda$19$lambda$142 = invoke$lambda$19$lambda$14(hasRespiratory$delegate2);
                        $composer.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                        invalid$iv$iv5 = $composer.changed(hasRespiratory$delegate2);
                        Object it$iv$iv82 = $composer.rememberedValue();
                        if (!invalid$iv$iv5) {
                        }
                        value$iv$iv8 = new Function1<Boolean, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$6$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean it) {
                                ProfileScreenKt$ProfileScreen$1.invoke$lambda$19$lambda$15(hasRespiratory$delegate2, it);
                            }
                        };
                        $composer.updateRememberedValue(value$iv$iv8);
                        $composer.endReplaceableGroup();
                        SwitchKt.Switch(invoke$lambda$19$lambda$142, (Function1) value$iv$iv8, null, false, null, null, $composer, 0, 60);
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        $composer.endNode();
                        $composer.endReplaceableGroup();
                        $composer.endReplaceableGroup();
                        SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(32)), $composer, 6);
                        final MutableState<String> mutableState62 = mutableState;
                        final MutableState<Boolean> mutableState72 = mutableState2;
                        ButtonKt.Button(new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                String ProfileScreen$lambda$13;
                                String ProfileScreen$lambda$43;
                                boolean ProfileScreen$lambda$72;
                                boolean invoke$lambda$19$lambda$822;
                                boolean invoke$lambda$19$lambda$1422;
                                ProfileScreen$lambda$13 = ProfileScreenKt.ProfileScreen$lambda$1(mutableState62);
                                Integer ageInt = StringsKt.toIntOrNull(ProfileScreen$lambda$13);
                                if (ageInt == null || ageInt.intValue() <= 0 || ageInt.intValue() >= 120) {
                                    Toast.makeText(context, "Invalid Age", 0).show();
                                    return;
                                }
                                UserProfileManager.this.setAge(ageInt.intValue());
                                UserProfileManager userProfileManager2 = UserProfileManager.this;
                                ProfileScreen$lambda$43 = ProfileScreenKt.ProfileScreen$lambda$4(mutableState4);
                                userProfileManager2.setGender(ProfileScreen$lambda$43);
                                UserProfileManager userProfileManager3 = UserProfileManager.this;
                                ProfileScreen$lambda$72 = ProfileScreenKt.ProfileScreen$lambda$7(mutableState72);
                                userProfileManager3.setHasHeartCondition(ProfileScreen$lambda$72);
                                UserProfileManager userProfileManager4 = UserProfileManager.this;
                                invoke$lambda$19$lambda$822 = ProfileScreenKt$ProfileScreen$1.invoke$lambda$19$lambda$8(isAthlete$delegate2);
                                userProfileManager4.setAthlete(invoke$lambda$19$lambda$822);
                                UserProfileManager userProfileManager5 = UserProfileManager.this;
                                invoke$lambda$19$lambda$1422 = ProfileScreenKt$ProfileScreen$1.invoke$lambda$19$lambda$14(hasRespiratory$delegate2);
                                userProfileManager5.setHasRespiratoryCondition(invoke$lambda$19$lambda$1422);
                                Toast.makeText(context, "Profile Saved", 0).show();
                            }
                        }, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, null, null, null, null, null, null, ComposableSingletons$ProfileScreenKt.INSTANCE.m4719getLambda4$finished_debug(), $composer, 805306416, 508);
                    }
                    value$iv$iv2 = (Function0) new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$3$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            mutableState4.setValue("Male");
                        }
                    };
                    $composer.updateRememberedValue(value$iv$iv2);
                    $composer.endReplaceableGroup();
                    RadioButtonKt.RadioButton(areEqual3, (Function0) value$iv$iv2, null, false, null, null, $composer, 0, 60);
                    TextKt.m1585TextfLXpl1I("Male", PaddingKt.m763paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, C0504Dp.m4382constructorimpl(16), 0.0f, 11, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 54, 0, 65532);
                    ProfileScreen$lambda$42 = ProfileScreenKt.ProfileScreen$lambda$4(mutableState4);
                    boolean areEqual2222 = Intrinsics.areEqual(ProfileScreen$lambda$42, "Female");
                    $composer.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                    invalid$iv$iv2 = $composer.changed(mutableState4);
                    it$iv$iv2 = $composer.rememberedValue();
                    if (!invalid$iv$iv2) {
                    }
                    value$iv$iv3 = (Function0) new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$3$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            mutableState4.setValue("Female");
                        }
                    };
                    $composer.updateRememberedValue(value$iv$iv3);
                    $composer.endReplaceableGroup();
                    RadioButtonKt.RadioButton(areEqual2222, (Function0) value$iv$iv3, null, false, null, null, $composer, 0, 60);
                    TextKt.m1585TextfLXpl1I("Female", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 6, 0, 65534);
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    $composer.endNode();
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(24)), $composer, 6);
                    Modifier modifier$iv222 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.Horizontal horizontalArrangement$iv222 = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Vertical verticalAlignment$iv222 = Alignment.INSTANCE.getCenterVertically();
                    $composer.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation($composer, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv322 = RowKt.rowMeasurePolicy(horizontalArrangement$iv222, verticalAlignment$iv222, $composer, ((438 >> 3) & 14) | ((438 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv322 = (438 << 3) & SdkConfig.SDK_VERSION;
                    $composer.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity322 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume722 = $composer.consume(localDensity322);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Density density$iv$iv322 = (Density) consume722;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection322 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume822 = $composer.consume(localLayoutDirection322);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    LayoutDirection layoutDirection$iv$iv322 = (LayoutDirection) consume822;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration322 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume922 = $composer.consume(localViewConfiguration322);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ViewConfiguration viewConfiguration$iv$iv322 = (ViewConfiguration) consume922;
                    Function0 factory$iv$iv$iv322 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv322 = LayoutKt.materializerOf(modifier$iv222);
                    int $changed$iv$iv$iv322 = (($changed$iv$iv322 << 9) & 7168) | 6;
                    if (!($composer.getApplier() instanceof Applier)) {
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                    }
                    $composer.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv322 = Updater.m1639constructorimpl($composer);
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv322, measurePolicy$iv322, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv322, density$iv$iv322, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv322, layoutDirection$iv$iv322, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv322, viewConfiguration$iv$iv322, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    $composer.enableReusing();
                    skippableUpdate$iv$iv$iv322.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv322 >> 3) & SdkConfig.SDK_VERSION));
                    $composer.startReplaceableGroup(2058660585);
                    $changed$iv2 = ($changed$iv$iv$iv322 >> 9) & 14;
                    $composer.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation($composer, "C80@4021L9:Row.kt#2w3rfo");
                    if (($changed$iv2 & 11) == 2) {
                    }
                    RowScope rowScope42 = RowScopeInstance.INSTANCE;
                    $changed3 = ((438 >> 6) & SdkConfig.SDK_VERSION) | 6;
                    $this$invoke_u24lambda_u2419_u24lambda_u246 = rowScope42;
                    $composer.startReplaceableGroup(-1800427231);
                    ComposerKt.sourceInformation($composer, "C120@4713L348,129@5168L21,127@5078L129:ProfileScreen.kt#amutfg");
                    $dirty = $changed3;
                    if (($changed3 & 14) == 0) {
                    }
                    if (($dirty & 91) == 18) {
                    }
                    Modifier modifier$iv322 = RowScope.weight$default($this$invoke_u24lambda_u2419_u24lambda_u246, Modifier.INSTANCE, 1.0f, false, 2, null);
                    $composer.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation($composer, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv42 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv42 = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv422 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv42, horizontalAlignment$iv42, $composer, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv422 = (0 << 3) & SdkConfig.SDK_VERSION;
                    $composer.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity422 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume1022 = $composer.consume(localDensity422);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Density density$iv$iv422 = (Density) consume1022;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection422 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume1122 = $composer.consume(localLayoutDirection422);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    LayoutDirection layoutDirection$iv$iv422 = (LayoutDirection) consume1122;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration422 = CompositionLocalsKt.getLocalViewConfiguration();
                    mutableState = mutableState3;
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume1222 = $composer.consume(localViewConfiguration422);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ViewConfiguration viewConfiguration$iv$iv422 = (ViewConfiguration) consume1222;
                    Function0 factory$iv$iv$iv422 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv422 = LayoutKt.materializerOf(modifier$iv322);
                    int $changed$iv$iv$iv422 = (($changed$iv$iv422 << 9) & 7168) | 6;
                    $composer$iv = $composer;
                    if (!($composer.getApplier() instanceof Applier)) {
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                    }
                    $composer.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv422 = Updater.m1639constructorimpl($composer);
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv422, measurePolicy$iv422, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv422, density$iv$iv422, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv422, layoutDirection$iv$iv422, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv422, viewConfiguration$iv$iv422, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    $composer.enableReusing();
                    skippableUpdate$iv$iv$iv422.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv422 >> 3) & SdkConfig.SDK_VERSION));
                    $composer.startReplaceableGroup(2058660585);
                    $changed$iv3 = ($changed$iv$iv$iv422 >> 9) & 14;
                    $composer.startReplaceableGroup(-1163856341);
                    ComposerKt.sourceInformation($composer, "C79@4027L9:Column.kt#2w3rfo");
                    if (($changed$iv3 & 11) == 2) {
                    }
                    ColumnScopeInstance columnScopeInstance222 = ColumnScopeInstance.INSTANCE;
                    $changed4 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                    $composer.startReplaceableGroup(-968701461);
                    ComposerKt.sourceInformation($composer, "C121@4829L10,121@4774L76,124@5003L10,122@4871L172:ProfileScreen.kt#amutfg");
                    if (($changed4 & 81) == 16) {
                    }
                    TextKt.m1585TextfLXpl1I("Existing Heart Condition", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getSubtitle1(), $composer, 6, 0, 32766);
                    TextKt.m1585TextfLXpl1I("Enabling this makes the alert system more sensitive.", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getCaption(), $composer, 6, 0, 32766);
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    $composer.endNode();
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    ProfileScreen$lambda$7 = ProfileScreenKt.ProfileScreen$lambda$7(mutableState5);
                    $composer.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                    invalid$iv$iv3 = $composer.changed(mutableState5);
                    Object it$iv$iv622 = $composer.rememberedValue();
                    if (invalid$iv$iv3) {
                    }
                    value$iv$iv4 = (Function1) new Function1<Boolean, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$4$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean it) {
                            ProfileScreenKt.ProfileScreen$lambda$8(mutableState5, it);
                        }
                    };
                    $composer.updateRememberedValue(value$iv$iv4);
                    $composer.endReplaceableGroup();
                    SwitchKt.Switch(ProfileScreen$lambda$7, (Function1) value$iv$iv4, null, false, null, null, $composer, 0, 60);
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    $composer.endNode();
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(16)), $composer, 6);
                    $composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                    it$iv$iv3 = $composer.rememberedValue();
                    if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                    }
                    $composer.endReplaceableGroup();
                    final MutableState<Boolean> isAthlete$delegate22 = (MutableState) value$iv$iv5;
                    Modifier modifier$iv422 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.Horizontal horizontalArrangement$iv322 = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Vertical verticalAlignment$iv322 = Alignment.INSTANCE.getCenterVertically();
                    $composer.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation($composer, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv522 = RowKt.rowMeasurePolicy(horizontalArrangement$iv322, verticalAlignment$iv322, $composer, ((438 >> 3) & 14) | ((438 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv522 = (438 << 3) & SdkConfig.SDK_VERSION;
                    $composer.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity522 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume1322 = $composer.consume(localDensity522);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Density density$iv$iv522 = (Density) consume1322;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection522 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume1422 = $composer.consume(localLayoutDirection522);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    LayoutDirection layoutDirection$iv$iv522 = (LayoutDirection) consume1422;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration522 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume1522 = $composer.consume(localViewConfiguration522);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ViewConfiguration viewConfiguration$iv$iv522 = (ViewConfiguration) consume1522;
                    Function0 factory$iv$iv$iv522 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv522 = LayoutKt.materializerOf(modifier$iv422);
                    int $changed$iv$iv$iv522 = (($changed$iv$iv522 << 9) & 7168) | 6;
                    if (!($composer.getApplier() instanceof Applier)) {
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                    }
                    $composer.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv522 = Updater.m1639constructorimpl($composer);
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv522, measurePolicy$iv522, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv522, density$iv$iv522, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv522, layoutDirection$iv$iv522, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv522, viewConfiguration$iv$iv522, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    $composer.enableReusing();
                    skippableUpdate$iv$iv$iv522.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv522 >> 3) & SdkConfig.SDK_VERSION));
                    $composer.startReplaceableGroup(2058660585);
                    $changed$iv4 = ($changed$iv$iv$iv522 >> 9) & 14;
                    $composer.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation($composer, "C80@4021L9:Row.kt#2w3rfo");
                    if (($changed$iv4 & 11) == 2) {
                    }
                    RowScope rowScope222 = RowScopeInstance.INSTANCE;
                    $changed5 = ((438 >> 6) & SdkConfig.SDK_VERSION) | 6;
                    $this$invoke_u24lambda_u2419_u24lambda_u2412 = rowScope222;
                    $composer.startReplaceableGroup(1526579136);
                    ComposerKt.sourceInformation($composer, "C142@5626L261,148@5991L18,146@5904L123:ProfileScreen.kt#amutfg");
                    $dirty2 = $changed5;
                    if (($changed5 & 14) == 0) {
                    }
                    if (($dirty2 & 91) == 18) {
                    }
                    Modifier modifier$iv522 = RowScope.weight$default($this$invoke_u24lambda_u2419_u24lambda_u2412, Modifier.INSTANCE, 1.0f, false, 2, null);
                    $composer.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation($composer, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv222 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv222 = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv622 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv222, horizontalAlignment$iv222, $composer, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv622 = (0 << 3) & SdkConfig.SDK_VERSION;
                    $composer.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity622 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume1622 = $composer.consume(localDensity622);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Density density$iv$iv622 = (Density) consume1622;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection622 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume1722 = $composer.consume(localLayoutDirection622);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    LayoutDirection layoutDirection$iv$iv622 = (LayoutDirection) consume1722;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration622 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume1822 = $composer.consume(localViewConfiguration622);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ViewConfiguration viewConfiguration$iv$iv622 = (ViewConfiguration) consume1822;
                    Function0 factory$iv$iv$iv622 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv622 = LayoutKt.materializerOf(modifier$iv522);
                    int $changed$iv$iv$iv622 = (($changed$iv$iv622 << 9) & 7168) | 6;
                    mutableState2 = mutableState5;
                    if (!($composer.getApplier() instanceof Applier)) {
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                    }
                    $composer.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv622 = Updater.m1639constructorimpl($composer);
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv622, measurePolicy$iv622, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv622, density$iv$iv622, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv622, layoutDirection$iv$iv622, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv622, viewConfiguration$iv$iv622, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    $composer.enableReusing();
                    skippableUpdate$iv$iv$iv622.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv622 >> 3) & SdkConfig.SDK_VERSION));
                    $composer.startReplaceableGroup(2058660585);
                    $changed$iv5 = ($changed$iv$iv$iv622 >> 9) & 14;
                    $composer.startReplaceableGroup(-1163856341);
                    ComposerKt.sourceInformation($composer, "C79@4027L9:Column.kt#2w3rfo");
                    if (($changed$iv5 & 11) == 2) {
                    }
                    ColumnScopeInstance columnScopeInstance322 = ColumnScopeInstance.INSTANCE;
                    $changed6 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                    $composer.startReplaceableGroup(-1936662390);
                    ComposerKt.sourceInformation($composer, "C143@5741L10,143@5687L75,144@5850L10,144@5783L86:ProfileScreen.kt#amutfg");
                    if (($changed6 & 81) == 16) {
                    }
                    TextKt.m1585TextfLXpl1I("Athlete / High Activity", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getSubtitle1(), $composer, 6, 0, 32766);
                    TextKt.m1585TextfLXpl1I("Allows for lower resting heart rate.", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getCaption(), $composer, 6, 0, 32766);
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    $composer.endNode();
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    boolean invoke$lambda$19$lambda$822 = invoke$lambda$19$lambda$8(isAthlete$delegate22);
                    $composer.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                    invalid$iv$iv4 = $composer.changed(isAthlete$delegate22);
                    Object it$iv$iv722 = $composer.rememberedValue();
                    if (invalid$iv$iv4) {
                    }
                    value$iv$iv6 = (Function1) new Function1<Boolean, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$5$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean it) {
                            ProfileScreenKt$ProfileScreen$1.invoke$lambda$19$lambda$9(isAthlete$delegate22, it);
                        }
                    };
                    $composer.updateRememberedValue(value$iv$iv6);
                    $composer.endReplaceableGroup();
                    SwitchKt.Switch(invoke$lambda$19$lambda$822, (Function1) value$iv$iv6, null, false, null, null, $composer, 0, 60);
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    $composer.endNode();
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(16)), $composer, 6);
                    $composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                    it$iv$iv4 = $composer.rememberedValue();
                    if (it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
                    }
                    $composer.endReplaceableGroup();
                    final MutableState<Boolean> hasRespiratory$delegate22 = (MutableState) value$iv$iv7;
                    Modifier modifier$iv622 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.Horizontal horizontalArrangement$iv422 = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Vertical verticalAlignment$iv422 = Alignment.INSTANCE.getCenterVertically();
                    $composer.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation($composer, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv722 = RowKt.rowMeasurePolicy(horizontalArrangement$iv422, verticalAlignment$iv422, $composer, ((438 >> 3) & 14) | ((438 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv722 = (438 << 3) & SdkConfig.SDK_VERSION;
                    $composer.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity722 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume1922 = $composer.consume(localDensity722);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Density density$iv$iv722 = (Density) consume1922;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection722 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume2022 = $composer.consume(localLayoutDirection722);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    LayoutDirection layoutDirection$iv$iv722 = (LayoutDirection) consume2022;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration722 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume2122 = $composer.consume(localViewConfiguration722);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ViewConfiguration viewConfiguration$iv$iv722 = (ViewConfiguration) consume2122;
                    Function0 factory$iv$iv$iv722 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv722 = LayoutKt.materializerOf(modifier$iv622);
                    int $changed$iv$iv$iv722 = (($changed$iv$iv722 << 9) & 7168) | 6;
                    if (!($composer.getApplier() instanceof Applier)) {
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                    }
                    $composer.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv722 = Updater.m1639constructorimpl($composer);
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv722, measurePolicy$iv722, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv722, density$iv$iv722, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv722, layoutDirection$iv$iv722, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv722, viewConfiguration$iv$iv722, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    $composer.enableReusing();
                    skippableUpdate$iv$iv$iv722.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv722 >> 3) & SdkConfig.SDK_VERSION));
                    $composer.startReplaceableGroup(2058660585);
                    $changed$iv6 = ($changed$iv$iv$iv722 >> 9) & 14;
                    $composer.startReplaceableGroup(-678309503);
                    ComposerKt.sourceInformation($composer, "C80@4021L9:Row.kt#2w3rfo");
                    if (($changed$iv6 & 11) == 2) {
                    }
                    RowScope rowScope322 = RowScopeInstance.INSTANCE;
                    $changed7 = ((438 >> 6) & SdkConfig.SDK_VERSION) | 6;
                    $this$invoke_u24lambda_u2419_u24lambda_u2418 = rowScope322;
                    $composer.startReplaceableGroup(558618207);
                    ComposerKt.sourceInformation($composer, "C161@6457L241,167@6807L23,165@6715L133:ProfileScreen.kt#amutfg");
                    $dirty3 = $changed7;
                    if (($changed7 & 14) == 0) {
                    }
                    if (($dirty3 & 91) == 18) {
                    }
                    Modifier modifier$iv722 = RowScope.weight$default($this$invoke_u24lambda_u2419_u24lambda_u2418, Modifier.INSTANCE, 1.0f, false, 2, null);
                    $composer.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation($composer, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv322 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv322 = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv822 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv322, horizontalAlignment$iv322, $composer, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv822 = (0 << 3) & SdkConfig.SDK_VERSION;
                    $composer.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity822 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume2222 = $composer.consume(localDensity822);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Density density$iv$iv822 = (Density) consume2222;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection822 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume2322 = $composer.consume(localLayoutDirection822);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    LayoutDirection layoutDirection$iv$iv822 = (LayoutDirection) consume2322;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration822 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume2422 = $composer.consume(localViewConfiguration822);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ViewConfiguration viewConfiguration$iv$iv822 = (ViewConfiguration) consume2422;
                    Function0 factory$iv$iv$iv822 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv822 = LayoutKt.materializerOf(modifier$iv722);
                    int $changed$iv$iv$iv822 = (($changed$iv$iv822 << 9) & 7168) | 6;
                    if (!($composer.getApplier() instanceof Applier)) {
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                    }
                    $composer.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv822 = Updater.m1639constructorimpl($composer);
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv822, measurePolicy$iv822, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv822, density$iv$iv822, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv822, layoutDirection$iv$iv822, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv822, viewConfiguration$iv$iv822, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    $composer.enableReusing();
                    skippableUpdate$iv$iv$iv822.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv822 >> 3) & SdkConfig.SDK_VERSION));
                    $composer.startReplaceableGroup(2058660585);
                    $changed$iv7 = ($changed$iv$iv$iv822 >> 9) & 14;
                    $composer.startReplaceableGroup(-1163856341);
                    ComposerKt.sourceInformation($composer, "C79@4027L9:Column.kt#2w3rfo");
                    if (($changed$iv7 & 11) == 2) {
                    }
                    ColumnScopeInstance columnScopeInstance422 = ColumnScopeInstance.INSTANCE;
                    $changed8 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                    $composer.startReplaceableGroup(1390343977);
                    ComposerKt.sourceInformation($composer, "C162@6570L10,162@6518L73,163@6661L10,163@6612L68:ProfileScreen.kt#amutfg");
                    if (($changed8 & 81) == 16) {
                    }
                    TextKt.m1585TextfLXpl1I("Respiratory Condition", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getSubtitle1(), $composer, 6, 0, 32766);
                    TextKt.m1585TextfLXpl1I("Asthma, COPD, etc.", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getCaption(), $composer, 6, 0, 32766);
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    $composer.endNode();
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    boolean invoke$lambda$19$lambda$1422 = invoke$lambda$19$lambda$14(hasRespiratory$delegate22);
                    $composer.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                    invalid$iv$iv5 = $composer.changed(hasRespiratory$delegate22);
                    Object it$iv$iv822 = $composer.rememberedValue();
                    if (!invalid$iv$iv5) {
                    }
                    value$iv$iv8 = new Function1<Boolean, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$6$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean it) {
                            ProfileScreenKt$ProfileScreen$1.invoke$lambda$19$lambda$15(hasRespiratory$delegate22, it);
                        }
                    };
                    $composer.updateRememberedValue(value$iv$iv8);
                    $composer.endReplaceableGroup();
                    SwitchKt.Switch(invoke$lambda$19$lambda$1422, (Function1) value$iv$iv8, null, false, null, null, $composer, 0, 60);
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    $composer.endNode();
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(32)), $composer, 6);
                    final MutableState<String> mutableState622 = mutableState;
                    final MutableState<Boolean> mutableState722 = mutableState2;
                    ButtonKt.Button(new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$1$1$7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            String ProfileScreen$lambda$13;
                            String ProfileScreen$lambda$43;
                            boolean ProfileScreen$lambda$72;
                            boolean invoke$lambda$19$lambda$8222;
                            boolean invoke$lambda$19$lambda$14222;
                            ProfileScreen$lambda$13 = ProfileScreenKt.ProfileScreen$lambda$1(mutableState622);
                            Integer ageInt = StringsKt.toIntOrNull(ProfileScreen$lambda$13);
                            if (ageInt == null || ageInt.intValue() <= 0 || ageInt.intValue() >= 120) {
                                Toast.makeText(context, "Invalid Age", 0).show();
                                return;
                            }
                            UserProfileManager.this.setAge(ageInt.intValue());
                            UserProfileManager userProfileManager2 = UserProfileManager.this;
                            ProfileScreen$lambda$43 = ProfileScreenKt.ProfileScreen$lambda$4(mutableState4);
                            userProfileManager2.setGender(ProfileScreen$lambda$43);
                            UserProfileManager userProfileManager3 = UserProfileManager.this;
                            ProfileScreen$lambda$72 = ProfileScreenKt.ProfileScreen$lambda$7(mutableState722);
                            userProfileManager3.setHasHeartCondition(ProfileScreen$lambda$72);
                            UserProfileManager userProfileManager4 = UserProfileManager.this;
                            invoke$lambda$19$lambda$8222 = ProfileScreenKt$ProfileScreen$1.invoke$lambda$19$lambda$8(isAthlete$delegate22);
                            userProfileManager4.setAthlete(invoke$lambda$19$lambda$8222);
                            UserProfileManager userProfileManager5 = UserProfileManager.this;
                            invoke$lambda$19$lambda$14222 = ProfileScreenKt$ProfileScreen$1.invoke$lambda$19$lambda$14(hasRespiratory$delegate22);
                            userProfileManager5.setHasRespiratoryCondition(invoke$lambda$19$lambda$14222);
                            Toast.makeText(context, "Profile Saved", 0).show();
                        }
                    }, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, null, null, null, null, null, null, ComposableSingletons$ProfileScreenKt.INSTANCE.m4719getLambda4$finished_debug(), $composer, 805306416, 508);
                } else {
                    $composer.skipToGroupEnd();
                    $composer$iv = $composer;
                }
                $composer.endReplaceableGroup();
            }
            $composer$iv.endReplaceableGroup();
            $composer.endReplaceableGroup();
            $composer.endNode();
            $composer.endReplaceableGroup();
            $composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$19$lambda$8(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$19$lambda$9(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$19$lambda$14(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$19$lambda$15(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }
}
