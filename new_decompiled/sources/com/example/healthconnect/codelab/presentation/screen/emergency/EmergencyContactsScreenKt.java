package com.example.healthconnect.codelab.presentation.screen.emergency;

import android.content.Context;
import android.widget.Toast;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.FloatingActionButtonKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextFieldColors;
import androidx.compose.material.TextKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.PersonKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.input.KeyboardType;
import androidx.compose.p000ui.text.input.VisualTransformation;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.p000ui.window.AndroidDialog_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.content.ContextCompat;
import androidx.health.platform.client.SdkConfig;
import androidx.lifecycle.LifecycleOwner;
import com.example.healthconnect.codelab.data.EmergencyContact;
import com.example.healthconnect.codelab.data.EmergencyContactsManager;
import com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: EmergencyContactsScreen.kt */
@Metadata(m286d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u000b\u001a\u001d\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, m287d2 = {"AddContactDialog", "", "initialName", "", "initialPhone", "isEdit", "", "onDismiss", "Lkotlin/Function0;", "onConfirm", "Lkotlin/Function2;", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "EmergencyContactsScreen", "contactsManager", "Lcom/example/healthconnect/codelab/data/EmergencyContactsManager;", "viewModel", "Lcom/example/healthconnect/codelab/presentation/screen/inputreadings/InputReadingsViewModel;", "(Lcom/example/healthconnect/codelab/data/EmergencyContactsManager;Lcom/example/healthconnect/codelab/presentation/screen/inputreadings/InputReadingsViewModel;Landroidx/compose/runtime/Composer;I)V", "finished_debug"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes12.dex */
public final class EmergencyContactsScreenKt {
    public static final void EmergencyContactsScreen(final EmergencyContactsManager contactsManager, final InputReadingsViewModel viewModel, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv$iv;
        Composer $composer2;
        Object value$iv$iv2;
        String phoneNumber;
        String name;
        Intrinsics.checkNotNullParameter(contactsManager, "contactsManager");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer $composer3 = $composer.startRestartGroup(769477434);
        ComposerKt.sourceInformation($composer3, "C(EmergencyContactsScreen)41@1896L7,42@1932L172,48@2151L7,49@2163L528,64@2712L453,76@3171L5431,196@8865L25,192@8680L641:EmergencyContactsScreen.kt#z8wdr8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(769477434, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreen (EmergencyContactsScreen.kt:34)");
        }
        Object it$iv = $composer3.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(contactsManager.getContacts(), null, 2, null);
            $composer3.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        final MutableState contacts$delegate = (MutableState) value$iv;
        Object it$iv2 = $composer3.rememberedValue();
        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            $composer3.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        final MutableState showAddDialog$delegate = (MutableState) value$iv2;
        Object it$iv3 = $composer3.rememberedValue();
        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
            value$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            $composer3.updateRememberedValue(value$iv3);
        } else {
            value$iv3 = it$iv3;
        }
        final MutableState contactToEdit$delegate = (MutableState) value$iv3;
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer3.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd($composer3);
        final Context context = (Context) consume;
        $composer3.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer3.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(ContextCompat.checkSelfPermission(context, "android.permission.SEND_SMS") == 0), null, 2, null);
            $composer3.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer3.endReplaceableGroup();
        final MutableState hasSmsPermission$delegate = (MutableState) value$iv$iv;
        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer3.consume(localLifecycleOwner);
        ComposerKt.sourceInformationMarkerEnd($composer3);
        LifecycleOwner lifecycleOwner = (LifecycleOwner) consume2;
        EffectsKt.DisposableEffect(lifecycleOwner, new EmergencyContactsScreenKt$EmergencyContactsScreen$1(lifecycleOwner, context, hasSmsPermission$delegate), $composer3, 8);
        final ManagedActivityResultLauncher launcher = ActivityResultRegistryKt.rememberLauncherForActivityResult(new ActivityResultContracts.RequestPermission(), new Function1<Boolean, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$EmergencyContactsScreen$launcher$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean isGranted) {
                EmergencyContactsScreenKt.EmergencyContactsScreen$lambda$11(hasSmsPermission$delegate, isGranted);
                if (isGranted) {
                    Toast.makeText(context, "Permission Granted", 0).show();
                } else {
                    Toast.makeText(context, "Permission Denied. Alert cannot be sent.", 0).show();
                }
            }
        }, $composer3, 8);
        final boolean isEdit = true;
        ScaffoldKt.m1484Scaffold27mzLpw(null, null, null, null, null, ComposableLambdaKt.composableLambda($composer3, 1628756338, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$EmergencyContactsScreen$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer4, int $changed2) {
                Object value$iv$iv3;
                ComposerKt.sourceInformation($composer4, "C78@3257L91,78@3226L215:EmergencyContactsScreen.kt#z8wdr8");
                if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                    $composer4.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1628756338, $changed2, -1, "com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreen.<anonymous> (EmergencyContactsScreen.kt:77)");
                }
                Object key1$iv = contactToEdit$delegate;
                Object key2$iv = showAddDialog$delegate;
                final MutableState<EmergencyContact> mutableState = contactToEdit$delegate;
                final MutableState<Boolean> mutableState2 = showAddDialog$delegate;
                $composer4.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer4, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer4.changed(key1$iv) | $composer4.changed(key2$iv);
                Object it$iv$iv2 = $composer4.rememberedValue();
                if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv3 = new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$EmergencyContactsScreen$2$1$1
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
                            mutableState.setValue(null);
                            EmergencyContactsScreenKt.EmergencyContactsScreen$lambda$5(mutableState2, true);
                        }
                    };
                    $composer4.updateRememberedValue(value$iv$iv3);
                } else {
                    value$iv$iv3 = it$iv$iv2;
                }
                $composer4.endReplaceableGroup();
                Object key1$iv2 = value$iv$iv3;
                FloatingActionButtonKt.m1412FloatingActionButtonbogVsAg((Function0) key1$iv2, null, null, null, 0L, 0L, null, ComposableSingletons$EmergencyContactsScreenKt.INSTANCE.m4705getLambda1$finished_debug(), $composer4, 12582912, 126);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.composableLambda($composer3, -1473263172, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$EmergencyContactsScreen$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
                invoke(paddingValues, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PaddingValues padding, Composer $composer4, int $changed2) {
                Composer $composer$iv;
                boolean EmergencyContactsScreen$lambda$10;
                Intrinsics.checkNotNullParameter(padding, "padding");
                ComposerKt.sourceInformation($composer4, "C86@3479L5117:EmergencyContactsScreen.kt#z8wdr8");
                int $dirty = $changed2;
                if (($changed2 & 14) == 0) {
                    $dirty |= $composer4.changed(padding) ? 4 : 2;
                }
                if (($dirty & 91) != 18 || !$composer4.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1473263172, $changed2, -1, "com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreen.<anonymous> (EmergencyContactsScreen.kt:85)");
                    }
                    Modifier modifier$iv = SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.INSTANCE, padding), 0.0f, 1, null);
                    final MutableState<Boolean> mutableState = hasSmsPermission$delegate;
                    final MutableState<List<EmergencyContact>> mutableState2 = contacts$delegate;
                    final MutableState<EmergencyContact> mutableState3 = contactToEdit$delegate;
                    final MutableState<Boolean> mutableState4 = showAddDialog$delegate;
                    final EmergencyContactsManager emergencyContactsManager = contactsManager;
                    final ManagedActivityResultLauncher<String, Boolean> managedActivityResultLauncher = launcher;
                    final Context context2 = context;
                    final InputReadingsViewModel inputReadingsViewModel = viewModel;
                    $composer4.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv = (0 << 3) & SdkConfig.SDK_VERSION;
                    $composer4.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume3 = $composer4.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Density density$iv$iv = (Density) consume3;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume4 = $composer4.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume4;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume5 = $composer4.consume(localViewConfiguration);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume5;
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
                    $composer4.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer4, "C72@3384L9:Box.kt#2w3rfo");
                    if (($changed$iv & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        $composer$iv = $composer4;
                    } else {
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int $changed3 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        BoxScope $this$invoke_u24lambda_u241 = boxScope;
                        $composer4.startReplaceableGroup(440111862);
                        ComposerKt.sourceInformation($composer4, "C87@3549L4003,183@8462L6,183@8417L62,168@7609L977:EmergencyContactsScreen.kt#z8wdr8");
                        int $dirty2 = $changed3;
                        if (($changed3 & 14) == 0) {
                            $dirty2 |= $composer4.changed($this$invoke_u24lambda_u241) ? 4 : 2;
                        }
                        if (($dirty2 & 91) != 18 || !$composer4.getSkipping()) {
                            Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            $composer4.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation($composer4, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                            int $changed$iv2 = ((6 >> 3) & 14) | ((6 >> 3) & SdkConfig.SDK_VERSION);
                            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, $changed$iv2);
                            int $changed$iv$iv2 = (6 << 3) & SdkConfig.SDK_VERSION;
                            $composer4.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume6 = $composer4.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            Density density$iv$iv2 = (Density) consume6;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume7 = $composer4.consume(localLayoutDirection2);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume7;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                            $composer$iv = $composer4;
                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume8 = $composer4.consume(localViewConfiguration2);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume8;
                            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
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
                            int $changed$iv3 = ($changed$iv$iv$iv2 >> 9) & 14;
                            $composer4.startReplaceableGroup(-1163856341);
                            ComposerKt.sourceInformation($composer4, "C79@4027L9:Column.kt#2w3rfo");
                            if (($changed$iv3 & 11) == 2 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                            } else {
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                int $changed4 = ((6 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                $composer4.startReplaceableGroup(-175028160);
                                ComposerKt.sourceInformation($composer4, "C90@3706L10,88@3609L184,103@4198L3340:EmergencyContactsScreen.kt#z8wdr8");
                                if (($changed4 & 81) != 16 || !$composer4.getSkipping()) {
                                    TextKt.m1585TextfLXpl1I("Emergency Contacts", PaddingKt.m759padding3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(16)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getH4(), $composer4, 54, 0, 32764);
                                    $composer4.startReplaceableGroup(876870752);
                                    ComposerKt.sourceInformation($composer4, "97@3991L6,98@4051L10,95@3856L306");
                                    EmergencyContactsScreen$lambda$10 = EmergencyContactsScreenKt.EmergencyContactsScreen$lambda$10(mutableState);
                                    if (!EmergencyContactsScreen$lambda$10) {
                                        TextKt.m1585TextfLXpl1I("⚠️ SMS Permission Missing. Alerts will NOT work.", PaddingKt.m761paddingVpY3zN4$default(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(16), 0.0f, 2, null), MaterialTheme.INSTANCE.getColors($composer4, MaterialTheme.$stable).m1311getError0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBody2(), $composer4, 54, 0, 32760);
                                    }
                                    $composer4.endReplaceableGroup();
                                    LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$EmergencyContactsScreen$3$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                            invoke2(lazyListScope);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(LazyListScope LazyColumn) {
                                            final List items$iv;
                                            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                            items$iv = EmergencyContactsScreenKt.EmergencyContactsScreen$lambda$1(mutableState2);
                                            final MutableState<EmergencyContact> mutableState5 = mutableState3;
                                            final MutableState<Boolean> mutableState6 = mutableState4;
                                            final EmergencyContactsManager emergencyContactsManager2 = emergencyContactsManager;
                                            final MutableState<List<EmergencyContact>> mutableState7 = mutableState2;
                                            final Function1 contentType$iv = new Function1() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$EmergencyContactsScreen$3$1$1$1$invoke$$inlined$items$default$1
                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                                    return invoke((EmergencyContact) p1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Void invoke(EmergencyContact emergencyContact) {
                                                    return null;
                                                }
                                            };
                                            LazyColumn.items(items$iv.size(), null, new Function1<Integer, Object>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$EmergencyContactsScreen$3$1$1$1$invoke$$inlined$items$default$3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                                    return invoke(num.intValue());
                                                }

                                                public final Object invoke(int index) {
                                                    return Function1.this.invoke(items$iv.get(index));
                                                }
                                            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$EmergencyContactsScreen$3$1$1$1$invoke$$inlined$items$default$4
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(4);
                                                }

                                                @Override // kotlin.jvm.functions.Function4
                                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(LazyItemScope items, int it, Composer $composer5, int $changed5) {
                                                    Composer $composer6;
                                                    Intrinsics.checkNotNullParameter(items, "$this$items");
                                                    ComposerKt.sourceInformation($composer5, "C145@6530L22:LazyDsl.kt#428nma");
                                                    int $dirty3 = $changed5;
                                                    if (($changed5 & 14) == 0) {
                                                        $dirty3 |= $composer5.changed(items) ? 4 : 2;
                                                    }
                                                    if (($changed5 & SdkConfig.SDK_VERSION) == 0) {
                                                        $dirty3 |= $composer5.changed(it) ? 32 : 16;
                                                    }
                                                    if (($dirty3 & 731) == 146 && $composer5.getSkipping()) {
                                                        $composer5.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-632812321, $dirty3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:144)");
                                                    }
                                                    int $changed6 = $dirty3 & 14;
                                                    final EmergencyContact contact = (EmergencyContact) items$iv.get(it);
                                                    $composer5.startReplaceableGroup(-200884565);
                                                    ComposerKt.sourceInformation($composer5, "C*110@4561L6,105@4284L3214:EmergencyContactsScreen.kt#z8wdr8");
                                                    int $dirty4 = $changed6;
                                                    if (($changed6 & SdkConfig.SDK_VERSION) == 0) {
                                                        $dirty4 |= $composer5.changed(contact) ? 32 : 16;
                                                    }
                                                    final int $dirty5 = $dirty4;
                                                    if (($dirty5 & 721) == 144 && $composer5.getSkipping()) {
                                                        $composer5.skipToGroupEnd();
                                                        $composer6 = $composer5;
                                                    } else {
                                                        Modifier m760paddingVpY3zN4 = PaddingKt.m760paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C0504Dp.m4382constructorimpl(16), C0504Dp.m4382constructorimpl(8));
                                                        float m4382constructorimpl = C0504Dp.m4382constructorimpl(4);
                                                        CornerBasedShape medium = MaterialTheme.INSTANCE.getShapes($composer5, MaterialTheme.$stable).getMedium();
                                                        final MutableState mutableState8 = mutableState5;
                                                        final MutableState mutableState9 = mutableState6;
                                                        final EmergencyContactsManager emergencyContactsManager3 = emergencyContactsManager2;
                                                        final MutableState mutableState10 = mutableState7;
                                                        $composer6 = $composer5;
                                                        CardKt.m1280CardFjzlyU(m760paddingVpY3zN4, medium, 0L, 0L, null, m4382constructorimpl, ComposableLambdaKt.composableLambda($composer6, -807587186, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$EmergencyContactsScreen$3$1$1$1$1$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                                invoke(composer, num.intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(Composer $composer7, int $changed7) {
                                                                Composer $composer$iv2;
                                                                MutableState<Boolean> mutableState11;
                                                                MutableState<EmergencyContact> mutableState12;
                                                                int i;
                                                                long m1994copywmQWz5c;
                                                                Object value$iv$iv3;
                                                                ComposerKt.sourceInformation($composer7, "C112@4631L2841:EmergencyContactsScreen.kt#z8wdr8");
                                                                if (($changed7 & 11) == 2 && $composer7.getSkipping()) {
                                                                    $composer7.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-807587186, $changed7, -1, "com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (EmergencyContactsScreen.kt:111)");
                                                                }
                                                                Modifier modifier$iv3 = PaddingKt.m759padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C0504Dp.m4382constructorimpl(16));
                                                                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
                                                                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                                                                final EmergencyContact emergencyContact = EmergencyContact.this;
                                                                MutableState<EmergencyContact> mutableState13 = mutableState8;
                                                                MutableState<Boolean> mutableState14 = mutableState9;
                                                                int i2 = $dirty5;
                                                                final EmergencyContactsManager emergencyContactsManager4 = emergencyContactsManager3;
                                                                final MutableState<List<EmergencyContact>> mutableState15 = mutableState10;
                                                                $composer7.startReplaceableGroup(693286680);
                                                                ComposerKt.sourceInformation($composer7, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                                                                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer7, ((438 >> 3) & 14) | ((438 >> 3) & SdkConfig.SDK_VERSION));
                                                                int $changed$iv$iv3 = (438 << 3) & SdkConfig.SDK_VERSION;
                                                                $composer7.startReplaceableGroup(-1323940314);
                                                                ComposerKt.sourceInformation($composer7, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                                                ComposerKt.sourceInformationMarkerStart($composer7, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                                Object consume9 = $composer7.consume(localDensity3);
                                                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                                                Density density$iv$iv3 = (Density) consume9;
                                                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                                                                ComposerKt.sourceInformationMarkerStart($composer7, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                                Object consume10 = $composer7.consume(localLayoutDirection3);
                                                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                                                LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume10;
                                                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                                                ComposerKt.sourceInformationMarkerStart($composer7, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                                Object consume11 = $composer7.consume(localViewConfiguration3);
                                                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                                                ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume11;
                                                                Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
                                                                Function3 skippableUpdate$iv$iv$iv3 = LayoutKt.materializerOf(modifier$iv3);
                                                                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 9) & 7168) | 6;
                                                                if (!($composer7.getApplier() instanceof Applier)) {
                                                                    ComposablesKt.invalidApplier();
                                                                }
                                                                $composer7.startReusableNode();
                                                                if ($composer7.getInserting()) {
                                                                    $composer7.createNode(factory$iv$iv$iv3);
                                                                } else {
                                                                    $composer7.useNode();
                                                                }
                                                                $composer7.disableReusing();
                                                                Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m1639constructorimpl($composer7);
                                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.INSTANCE.getSetDensity());
                                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                                $composer7.enableReusing();
                                                                skippableUpdate$iv$iv$iv3.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer7)), $composer7, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & SdkConfig.SDK_VERSION));
                                                                $composer7.startReplaceableGroup(2058660585);
                                                                int $changed$iv4 = ($changed$iv$iv$iv3 >> 9) & 14;
                                                                $composer7.startReplaceableGroup(-678309503);
                                                                ComposerKt.sourceInformation($composer7, "C80@4021L9:Row.kt#2w3rfo");
                                                                if (($changed$iv4 & 11) == 2 && $composer7.getSkipping()) {
                                                                    $composer7.skipToGroupEnd();
                                                                    $composer$iv2 = $composer7;
                                                                } else {
                                                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                                    int $changed8 = ((438 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                                                    $composer7.startReplaceableGroup(-99023374);
                                                                    ComposerKt.sourceInformation($composer7, "C119@5018L1143,139@6227L1215:EmergencyContactsScreen.kt#z8wdr8");
                                                                    if (($changed8 & 81) == 16 && $composer7.getSkipping()) {
                                                                        $composer7.skipToGroupEnd();
                                                                        $composer$iv2 = $composer7;
                                                                    } else {
                                                                        Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getCenterVertically();
                                                                        $composer7.startReplaceableGroup(693286680);
                                                                        ComposerKt.sourceInformation($composer7, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                                                                        Modifier modifier$iv4 = Modifier.INSTANCE;
                                                                        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                                                                        MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer7, ((384 >> 3) & 14) | ((384 >> 3) & SdkConfig.SDK_VERSION));
                                                                        int $changed$iv$iv4 = (384 << 3) & SdkConfig.SDK_VERSION;
                                                                        $composer7.startReplaceableGroup(-1323940314);
                                                                        ComposerKt.sourceInformation($composer7, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                                        ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                                                                        ComposerKt.sourceInformationMarkerStart($composer7, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                                        Object consume12 = $composer7.consume(localDensity4);
                                                                        ComposerKt.sourceInformationMarkerEnd($composer7);
                                                                        Density density$iv$iv4 = (Density) consume12;
                                                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                                                                        ComposerKt.sourceInformationMarkerStart($composer7, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                                        Object consume13 = $composer7.consume(localLayoutDirection4);
                                                                        ComposerKt.sourceInformationMarkerEnd($composer7);
                                                                        LayoutDirection layoutDirection$iv$iv4 = (LayoutDirection) consume13;
                                                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration4 = CompositionLocalsKt.getLocalViewConfiguration();
                                                                        ComposerKt.sourceInformationMarkerStart($composer7, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                                        Object consume14 = $composer7.consume(localViewConfiguration4);
                                                                        ComposerKt.sourceInformationMarkerEnd($composer7);
                                                                        ViewConfiguration viewConfiguration$iv$iv4 = (ViewConfiguration) consume14;
                                                                        Function0 factory$iv$iv$iv4 = ComposeUiNode.INSTANCE.getConstructor();
                                                                        Function3 skippableUpdate$iv$iv$iv4 = LayoutKt.materializerOf(modifier$iv4);
                                                                        int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 9) & 7168) | 6;
                                                                        $composer$iv2 = $composer7;
                                                                        if (!($composer7.getApplier() instanceof Applier)) {
                                                                            ComposablesKt.invalidApplier();
                                                                        }
                                                                        $composer7.startReusableNode();
                                                                        if ($composer7.getInserting()) {
                                                                            $composer7.createNode(factory$iv$iv$iv4);
                                                                        } else {
                                                                            $composer7.useNode();
                                                                        }
                                                                        $composer7.disableReusing();
                                                                        Composer $this$Layout_u24lambda_u2d0$iv$iv4 = Updater.m1639constructorimpl($composer7);
                                                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv4, density$iv$iv4, ComposeUiNode.INSTANCE.getSetDensity());
                                                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv4, layoutDirection$iv$iv4, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv4, viewConfiguration$iv$iv4, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                                        $composer7.enableReusing();
                                                                        skippableUpdate$iv$iv$iv4.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer7)), $composer7, Integer.valueOf(($changed$iv$iv$iv4 >> 3) & SdkConfig.SDK_VERSION));
                                                                        $composer7.startReplaceableGroup(2058660585);
                                                                        int $changed$iv5 = ($changed$iv$iv$iv4 >> 9) & 14;
                                                                        $composer7.startReplaceableGroup(-678309503);
                                                                        ComposerKt.sourceInformation($composer7, "C80@4021L9:Row.kt#2w3rfo");
                                                                        if (($changed$iv5 & 11) == 2 && $composer7.getSkipping()) {
                                                                            $composer7.skipToGroupEnd();
                                                                            mutableState12 = mutableState13;
                                                                            mutableState11 = mutableState14;
                                                                            i = i2;
                                                                        } else {
                                                                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                                                            int $changed9 = ((384 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                                                            $composer7.startReplaceableGroup(106072662);
                                                                            ComposerKt.sourceInformation($composer7, "C123@5319L6,120@5109L356,126@5502L625:EmergencyContactsScreen.kt#z8wdr8");
                                                                            if (($changed9 & 81) == 16 && $composer7.getSkipping()) {
                                                                                $composer7.skipToGroupEnd();
                                                                                mutableState12 = mutableState13;
                                                                                mutableState11 = mutableState14;
                                                                                i = i2;
                                                                            } else {
                                                                                IconKt.m1415Iconww6aTOc(PersonKt.getPerson(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m800size3ABfNKs(PaddingKt.m763paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, C0504Dp.m4382constructorimpl(16), 0.0f, 11, null), C0504Dp.m4382constructorimpl(40)), MaterialTheme.INSTANCE.getColors($composer7, MaterialTheme.$stable).m1317getPrimary0d7_KjU(), $composer7, 432, 0);
                                                                                $composer7.startReplaceableGroup(-483455358);
                                                                                ComposerKt.sourceInformation($composer7, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                                                                                Modifier modifier$iv5 = Modifier.INSTANCE;
                                                                                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                                                                                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                                                                                MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer7, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                                                                                int $changed$iv$iv5 = (0 << 3) & SdkConfig.SDK_VERSION;
                                                                                $composer7.startReplaceableGroup(-1323940314);
                                                                                ComposerKt.sourceInformation($composer7, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                                                ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                                                                                ComposerKt.sourceInformationMarkerStart($composer7, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                                                Object consume15 = $composer7.consume(localDensity5);
                                                                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                                                                Density density$iv$iv5 = (Density) consume15;
                                                                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                                                                                mutableState11 = mutableState14;
                                                                                ComposerKt.sourceInformationMarkerStart($composer7, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                                                Object consume16 = $composer7.consume(localLayoutDirection5);
                                                                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                                                                LayoutDirection layoutDirection$iv$iv5 = (LayoutDirection) consume16;
                                                                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration5 = CompositionLocalsKt.getLocalViewConfiguration();
                                                                                mutableState12 = mutableState13;
                                                                                ComposerKt.sourceInformationMarkerStart($composer7, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                                                Object consume17 = $composer7.consume(localViewConfiguration5);
                                                                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                                                                ViewConfiguration viewConfiguration$iv$iv5 = (ViewConfiguration) consume17;
                                                                                Function0 factory$iv$iv$iv5 = ComposeUiNode.INSTANCE.getConstructor();
                                                                                Function3 skippableUpdate$iv$iv$iv5 = LayoutKt.materializerOf(modifier$iv5);
                                                                                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 9) & 7168) | 6;
                                                                                i = i2;
                                                                                if (!($composer7.getApplier() instanceof Applier)) {
                                                                                    ComposablesKt.invalidApplier();
                                                                                }
                                                                                $composer7.startReusableNode();
                                                                                if ($composer7.getInserting()) {
                                                                                    $composer7.createNode(factory$iv$iv$iv5);
                                                                                } else {
                                                                                    $composer7.useNode();
                                                                                }
                                                                                $composer7.disableReusing();
                                                                                Composer $this$Layout_u24lambda_u2d0$iv$iv5 = Updater.m1639constructorimpl($composer7);
                                                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv5, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv5, density$iv$iv5, ComposeUiNode.INSTANCE.getSetDensity());
                                                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv5, layoutDirection$iv$iv5, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv5, viewConfiguration$iv$iv5, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                                                $composer7.enableReusing();
                                                                                skippableUpdate$iv$iv$iv5.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer7)), $composer7, Integer.valueOf(($changed$iv$iv$iv5 >> 3) & SdkConfig.SDK_VERSION));
                                                                                $composer7.startReplaceableGroup(2058660585);
                                                                                int $changed$iv6 = ($changed$iv$iv$iv5 >> 9) & 14;
                                                                                $composer7.startReplaceableGroup(-1163856341);
                                                                                ComposerKt.sourceInformation($composer7, "C79@4027L9:Column.kt#2w3rfo");
                                                                                if (($changed$iv6 & 11) == 2 && $composer7.getSkipping()) {
                                                                                    $composer7.skipToGroupEnd();
                                                                                } else {
                                                                                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                                                                    int $changed10 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                                                                    $composer7.startReplaceableGroup(-217329844);
                                                                                    ComposerKt.sourceInformation($composer7, "C129@5688L10,127@5551L192,133@5928L10,134@6012L6,131@5784L305:EmergencyContactsScreen.kt#z8wdr8");
                                                                                    if (($changed10 & 81) == 16 && $composer7.getSkipping()) {
                                                                                        $composer7.skipToGroupEnd();
                                                                                    } else {
                                                                                        TextKt.m1585TextfLXpl1I(emergencyContact.getName(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer7, MaterialTheme.$stable).getH6(), $composer7, 0, 0, 32766);
                                                                                        String phoneNumber2 = emergencyContact.getPhoneNumber();
                                                                                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography($composer7, MaterialTheme.$stable).getBody2();
                                                                                        m1994copywmQWz5c = Color.m1994copywmQWz5c(r83, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r83) : 0.6f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r83) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r83) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer7, MaterialTheme.$stable).m1316getOnSurface0d7_KjU()) : 0.0f);
                                                                                        TextKt.m1585TextfLXpl1I(phoneNumber2, null, m1994copywmQWz5c, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, body2, $composer7, 0, 0, 32762);
                                                                                    }
                                                                                    $composer7.endReplaceableGroup();
                                                                                }
                                                                                $composer7.endReplaceableGroup();
                                                                                $composer7.endReplaceableGroup();
                                                                                $composer7.endNode();
                                                                                $composer7.endReplaceableGroup();
                                                                                $composer7.endReplaceableGroup();
                                                                            }
                                                                            $composer7.endReplaceableGroup();
                                                                        }
                                                                        $composer7.endReplaceableGroup();
                                                                        $composer7.endReplaceableGroup();
                                                                        $composer7.endNode();
                                                                        $composer7.endReplaceableGroup();
                                                                        $composer7.endReplaceableGroup();
                                                                        $composer7.startReplaceableGroup(693286680);
                                                                        ComposerKt.sourceInformation($composer7, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                                                                        Modifier modifier$iv6 = Modifier.INSTANCE;
                                                                        Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                                                                        Alignment.Vertical verticalAlignment$iv3 = Alignment.INSTANCE.getTop();
                                                                        MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer7, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                                                                        int $changed$iv$iv6 = (0 << 3) & SdkConfig.SDK_VERSION;
                                                                        $composer7.startReplaceableGroup(-1323940314);
                                                                        ComposerKt.sourceInformation($composer7, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                                        ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                                                                        ComposerKt.sourceInformationMarkerStart($composer7, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                                        Object consume18 = $composer7.consume(localDensity6);
                                                                        ComposerKt.sourceInformationMarkerEnd($composer7);
                                                                        Density density$iv$iv6 = (Density) consume18;
                                                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
                                                                        ComposerKt.sourceInformationMarkerStart($composer7, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                                        Object consume19 = $composer7.consume(localLayoutDirection6);
                                                                        ComposerKt.sourceInformationMarkerEnd($composer7);
                                                                        LayoutDirection layoutDirection$iv$iv6 = (LayoutDirection) consume19;
                                                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration6 = CompositionLocalsKt.getLocalViewConfiguration();
                                                                        ComposerKt.sourceInformationMarkerStart($composer7, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                                        Object consume20 = $composer7.consume(localViewConfiguration6);
                                                                        ComposerKt.sourceInformationMarkerEnd($composer7);
                                                                        ViewConfiguration viewConfiguration$iv$iv6 = (ViewConfiguration) consume20;
                                                                        Function0 factory$iv$iv$iv6 = ComposeUiNode.INSTANCE.getConstructor();
                                                                        Function3 skippableUpdate$iv$iv$iv6 = LayoutKt.materializerOf(modifier$iv6);
                                                                        int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 9) & 7168) | 6;
                                                                        if (!($composer7.getApplier() instanceof Applier)) {
                                                                            ComposablesKt.invalidApplier();
                                                                        }
                                                                        $composer7.startReusableNode();
                                                                        if ($composer7.getInserting()) {
                                                                            $composer7.createNode(factory$iv$iv$iv6);
                                                                        } else {
                                                                            $composer7.useNode();
                                                                        }
                                                                        $composer7.disableReusing();
                                                                        Composer $this$Layout_u24lambda_u2d0$iv$iv6 = Updater.m1639constructorimpl($composer7);
                                                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv6, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv6, density$iv$iv6, ComposeUiNode.INSTANCE.getSetDensity());
                                                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv6, layoutDirection$iv$iv6, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv6, viewConfiguration$iv$iv6, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                                        $composer7.enableReusing();
                                                                        skippableUpdate$iv$iv$iv6.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer7)), $composer7, Integer.valueOf(($changed$iv$iv$iv6 >> 3) & SdkConfig.SDK_VERSION));
                                                                        $composer7.startReplaceableGroup(2058660585);
                                                                        int $changed$iv7 = ($changed$iv$iv$iv6 >> 9) & 14;
                                                                        $composer7.startReplaceableGroup(-678309503);
                                                                        ComposerKt.sourceInformation($composer7, "C80@4021L9:Row.kt#2w3rfo");
                                                                        if (($changed$iv7 & 11) == 2 && $composer7.getSkipping()) {
                                                                            $composer7.skipToGroupEnd();
                                                                        } else {
                                                                            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                                                                            int $changed11 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                                                            $composer7.startReplaceableGroup(-1195220211);
                                                                            ComposerKt.sourceInformation($composer7, "C140@6290L164,140@6269L531,150@6837L571:EmergencyContactsScreen.kt#z8wdr8");
                                                                            if (($changed11 & 81) == 16 && $composer7.getSkipping()) {
                                                                                $composer7.skipToGroupEnd();
                                                                            } else {
                                                                                int i3 = (i & SdkConfig.SDK_VERSION) | 390;
                                                                                $composer7.startReplaceableGroup(1618982084);
                                                                                ComposerKt.sourceInformation($composer7, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                                                                                final MutableState<EmergencyContact> mutableState16 = mutableState12;
                                                                                final MutableState<Boolean> mutableState17 = mutableState11;
                                                                                boolean invalid$iv$iv = $composer7.changed(mutableState16) | $composer7.changed(emergencyContact) | $composer7.changed(mutableState17);
                                                                                Object it$iv$iv2 = $composer7.rememberedValue();
                                                                                if (!invalid$iv$iv && it$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                                                                                    value$iv$iv3 = it$iv$iv2;
                                                                                    $composer7.endReplaceableGroup();
                                                                                    IconButtonKt.IconButton((Function0) value$iv$iv3, null, false, null, ComposableSingletons$EmergencyContactsScreenKt.INSTANCE.m4706getLambda2$finished_debug(), $composer7, 24576, 14);
                                                                                    IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$EmergencyContactsScreen$3$1$1$1$1$1$1$2$2
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
                                                                                            EmergencyContactsManager.this.removeContact(emergencyContact.getId());
                                                                                            mutableState15.setValue(EmergencyContactsManager.this.getContacts());
                                                                                        }
                                                                                    }, null, false, null, ComposableSingletons$EmergencyContactsScreenKt.INSTANCE.m4707getLambda3$finished_debug(), $composer7, 24576, 14);
                                                                                }
                                                                                value$iv$iv3 = new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$EmergencyContactsScreen$3$1$1$1$1$1$1$2$1$1
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
                                                                                        mutableState16.setValue(EmergencyContact.this);
                                                                                        EmergencyContactsScreenKt.EmergencyContactsScreen$lambda$5(mutableState17, true);
                                                                                    }
                                                                                };
                                                                                $composer7.updateRememberedValue(value$iv$iv3);
                                                                                $composer7.endReplaceableGroup();
                                                                                IconButtonKt.IconButton((Function0) value$iv$iv3, null, false, null, ComposableSingletons$EmergencyContactsScreenKt.INSTANCE.m4706getLambda2$finished_debug(), $composer7, 24576, 14);
                                                                                IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$EmergencyContactsScreen$3$1$1$1$1$1$1$2$2
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
                                                                                        EmergencyContactsManager.this.removeContact(emergencyContact.getId());
                                                                                        mutableState15.setValue(EmergencyContactsManager.this.getContacts());
                                                                                    }
                                                                                }, null, false, null, ComposableSingletons$EmergencyContactsScreenKt.INSTANCE.m4707getLambda3$finished_debug(), $composer7, 24576, 14);
                                                                            }
                                                                            $composer7.endReplaceableGroup();
                                                                        }
                                                                        $composer7.endReplaceableGroup();
                                                                        $composer7.endReplaceableGroup();
                                                                        $composer7.endNode();
                                                                        $composer7.endReplaceableGroup();
                                                                        $composer7.endReplaceableGroup();
                                                                    }
                                                                    $composer7.endReplaceableGroup();
                                                                }
                                                                $composer$iv2.endReplaceableGroup();
                                                                $composer7.endReplaceableGroup();
                                                                $composer7.endNode();
                                                                $composer7.endReplaceableGroup();
                                                                $composer7.endReplaceableGroup();
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }), $composer6, 1769478, 28);
                                                    }
                                                    $composer6.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }));
                                        }
                                    }, $composer4, 0, 255);
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
                            ButtonKt.Button(new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$EmergencyContactsScreen$3$1$2
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
                                    boolean EmergencyContactsScreen$lambda$102;
                                    EmergencyContactsScreen$lambda$102 = EmergencyContactsScreenKt.EmergencyContactsScreen$lambda$10(mutableState);
                                    if (!EmergencyContactsScreen$lambda$102) {
                                        managedActivityResultLauncher.launch("android.permission.SEND_SMS");
                                        return;
                                    }
                                    List currentContacts = emergencyContactsManager.getContacts();
                                    if (currentContacts.isEmpty()) {
                                        Toast.makeText(context2, "No contacts to test", 0).show();
                                    } else {
                                        inputReadingsViewModel.sendTestAlert();
                                        Toast.makeText(context2, "Sending Test Alert with Location...", 0).show();
                                    }
                                }
                            }, PaddingKt.m759padding3ABfNKs($this$invoke_u24lambda_u241.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomStart()), C0504Dp.m4382constructorimpl(16)), false, null, null, null, null, ButtonDefaults.INSTANCE.m1267buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColors($composer4, MaterialTheme.$stable).m1319getSecondary0d7_KjU(), 0L, 0L, 0L, $composer4, ButtonDefaults.$stable << 12, 14), null, ComposableSingletons$EmergencyContactsScreenKt.INSTANCE.m4708getLambda4$finished_debug(), $composer4, 805306368, 380);
                        } else {
                            $composer4.skipToGroupEnd();
                            $composer$iv = $composer4;
                        }
                        $composer4.endReplaceableGroup();
                    }
                    $composer$iv.endReplaceableGroup();
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
        }), $composer3, 196608, 12582912, 131039);
        if (!EmergencyContactsScreen$lambda$4(showAddDialog$delegate)) {
            $composer2 = $composer3;
        } else {
            if (EmergencyContactsScreen$lambda$7(contactToEdit$delegate) == null) {
                isEdit = false;
            }
            EmergencyContact EmergencyContactsScreen$lambda$7 = EmergencyContactsScreen$lambda$7(contactToEdit$delegate);
            String str = (EmergencyContactsScreen$lambda$7 == null || (name = EmergencyContactsScreen$lambda$7.getName()) == null) ? "" : name;
            EmergencyContact EmergencyContactsScreen$lambda$72 = EmergencyContactsScreen$lambda$7(contactToEdit$delegate);
            String str2 = (EmergencyContactsScreen$lambda$72 == null || (phoneNumber = EmergencyContactsScreen$lambda$72.getPhoneNumber()) == null) ? "" : phoneNumber;
            $composer3.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer3, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer3.changed(showAddDialog$delegate);
            Object it$iv$iv2 = $composer3.rememberedValue();
            if (!invalid$iv$iv && it$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = it$iv$iv2;
                $composer3.endReplaceableGroup();
                $composer2 = $composer3;
                AddContactDialog(str, str2, isEdit, (Function0) value$iv$iv2, new Function2<String, String, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$EmergencyContactsScreen$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(String str3, String str4) {
                        invoke2(str3, str4);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String name2, String phone) {
                        EmergencyContact it;
                        Intrinsics.checkNotNullParameter(name2, "name");
                        Intrinsics.checkNotNullParameter(phone, "phone");
                        if (isEdit) {
                            it = EmergencyContactsScreenKt.EmergencyContactsScreen$lambda$7(contactToEdit$delegate);
                            if (it != null) {
                                contactsManager.updateContact(it.getId(), name2, phone);
                            }
                        } else {
                            contactsManager.addContact(name2, phone);
                        }
                        contacts$delegate.setValue(contactsManager.getContacts());
                        EmergencyContactsScreenKt.EmergencyContactsScreen$lambda$5(showAddDialog$delegate, false);
                    }
                }, $composer2, 0, 0);
            }
            value$iv$iv2 = (Function0) new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$EmergencyContactsScreen$4$1
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
                    EmergencyContactsScreenKt.EmergencyContactsScreen$lambda$5(showAddDialog$delegate, false);
                }
            };
            $composer3.updateRememberedValue(value$iv$iv2);
            $composer3.endReplaceableGroup();
            $composer2 = $composer3;
            AddContactDialog(str, str2, isEdit, (Function0) value$iv$iv2, new Function2<String, String, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$EmergencyContactsScreen$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str3, String str4) {
                    invoke2(str3, str4);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String name2, String phone) {
                    EmergencyContact it;
                    Intrinsics.checkNotNullParameter(name2, "name");
                    Intrinsics.checkNotNullParameter(phone, "phone");
                    if (isEdit) {
                        it = EmergencyContactsScreenKt.EmergencyContactsScreen$lambda$7(contactToEdit$delegate);
                        if (it != null) {
                            contactsManager.updateContact(it.getId(), name2, phone);
                        }
                    } else {
                        contactsManager.addContact(name2, phone);
                    }
                    contacts$delegate.setValue(contactsManager.getContacts());
                    EmergencyContactsScreenKt.EmergencyContactsScreen$lambda$5(showAddDialog$delegate, false);
                }
            }, $composer2, 0, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$EmergencyContactsScreen$6
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
                EmergencyContactsScreenKt.EmergencyContactsScreen(EmergencyContactsManager.this, viewModel, composer, $changed | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<EmergencyContact> EmergencyContactsScreen$lambda$1(MutableState<List<EmergencyContact>> mutableState) {
        MutableState<List<EmergencyContact>> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    private static final boolean EmergencyContactsScreen$lambda$4(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EmergencyContactsScreen$lambda$5(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EmergencyContact EmergencyContactsScreen$lambda$7(MutableState<EmergencyContact> mutableState) {
        MutableState<EmergencyContact> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean EmergencyContactsScreen$lambda$10(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EmergencyContactsScreen$lambda$11(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    public static final void AddContactDialog(String initialName, String initialPhone, boolean isEdit, final Function0<Unit> onDismiss, final Function2<? super String, ? super String, Unit> onConfirm, Composer $composer, final int $changed, final int i) {
        String str;
        String str2;
        boolean isEdit2;
        String initialName2;
        String initialPhone2;
        Object value$iv;
        Object value$iv2;
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Composer $composer2 = $composer.startRestartGroup(352825115);
        ComposerKt.sourceInformation($composer2, "C(AddContactDialog)P(!3,4)223@9647L1484:EmergencyContactsScreen.kt#z8wdr8");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            str = initialName;
        } else if (($changed & 14) == 0) {
            str = initialName;
            $dirty |= $composer2.changed(str) ? 4 : 2;
        } else {
            str = initialName;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            str2 = initialPhone;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            str2 = initialPhone;
            $dirty |= $composer2.changed(str2) ? 32 : 16;
        } else {
            str2 = initialPhone;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            isEdit2 = isEdit;
        } else if (($changed & 896) == 0) {
            isEdit2 = isEdit;
            $dirty |= $composer2.changed(isEdit2) ? 256 : 128;
        } else {
            isEdit2 = isEdit;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(onDismiss) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changed(onConfirm) ? 16384 : 8192;
        }
        final int $dirty2 = $dirty;
        if ((46811 & $dirty2) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            initialName2 = str;
            initialPhone2 = str2;
        } else {
            initialName2 = i2 != 0 ? "" : str;
            initialPhone2 = i3 != 0 ? "" : str2;
            if (i4 != 0) {
                isEdit2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(352825115, $dirty2, -1, "com.example.healthconnect.codelab.presentation.screen.emergency.AddContactDialog (EmergencyContactsScreen.kt:213)");
            }
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialName2, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState name$delegate = (MutableState) value$iv;
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialPhone2, null, 2, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableState phone$delegate = (MutableState) value$iv2;
            final boolean z = isEdit2;
            AndroidDialog_androidKt.Dialog(onDismiss, null, ComposableLambdaKt.composableLambda($composer2, 926423282, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$AddContactDialog$1
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
                    ComposerKt.sourceInformation($composer3, "C224@9694L1431:EmergencyContactsScreen.kt#z8wdr8");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(926423282, $changed2, -1, "com.example.healthconnect.codelab.presentation.screen.emergency.AddContactDialog.<anonymous> (EmergencyContactsScreen.kt:223)");
                    }
                    Modifier m759padding3ABfNKs = PaddingKt.m759padding3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(16));
                    float m4382constructorimpl = C0504Dp.m4382constructorimpl(8);
                    final boolean z2 = z;
                    final MutableState<String> mutableState = name$delegate;
                    final MutableState<String> mutableState2 = phone$delegate;
                    final Function0<Unit> function0 = onDismiss;
                    final int i5 = $dirty2;
                    final Function2<String, String, Unit> function2 = onConfirm;
                    CardKt.m1280CardFjzlyU(m759padding3ABfNKs, null, 0L, 0L, null, m4382constructorimpl, ComposableLambdaKt.composableLambda($composer3, 1760264213, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$AddContactDialog$1.1
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

                        /* JADX WARN: Removed duplicated region for block: B:47:0x041f  */
                        /* JADX WARN: Removed duplicated region for block: B:50:0x042b  */
                        /* JADX WARN: Removed duplicated region for block: B:70:0x042f  */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void invoke(Composer $composer4, int $changed3) {
                            String AddContactDialog$lambda$14;
                            Object value$iv$iv;
                            String AddContactDialog$lambda$17;
                            int $changed$iv;
                            int $changed4;
                            Composer $composer$iv;
                            Composer $composer5;
                            Composer $composer$iv2;
                            Composer $composer$iv3;
                            boolean invalid$iv$iv;
                            Object value$iv$iv2;
                            ComposerKt.sourceInformation($composer4, "C225@9767L1348:EmergencyContactsScreen.kt#z8wdr8");
                            if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1760264213, $changed3, -1, "com.example.healthconnect.codelab.presentation.screen.emergency.AddContactDialog.<anonymous>.<anonymous> (EmergencyContactsScreen.kt:224)");
                                }
                                Modifier modifier$iv = PaddingKt.m759padding3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(16));
                                boolean z3 = z2;
                                final MutableState<String> mutableState3 = mutableState;
                                final MutableState<String> mutableState4 = mutableState2;
                                Function0<Unit> function02 = function0;
                                int i6 = i5;
                                final Function2<String, String, Unit> function22 = function2;
                                $composer4.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation($composer4, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & SdkConfig.SDK_VERSION));
                                int $changed$iv$iv = (6 << 3) & SdkConfig.SDK_VERSION;
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
                                int $changed$iv2 = ($changed$iv$iv$iv >> 9) & 14;
                                $composer4.startReplaceableGroup(-1163856341);
                                ComposerKt.sourceInformation($composer4, "C79@4027L9:Column.kt#2w3rfo");
                                if (($changed$iv2 & 11) == 2 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    $composer$iv2 = $composer4;
                                } else {
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    int $changed5 = ((6 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                    $composer4.startReplaceableGroup(246905995);
                                    ComposerKt.sourceInformation($composer4, "C226@9922L10,226@9828L108,227@9953L40,230@10099L13,228@10010L222,234@10249L40,237@10396L14,235@10306L322,242@10645L41,243@10703L398:EmergencyContactsScreen.kt#z8wdr8");
                                    if (($changed5 & 81) != 16 || !$composer4.getSkipping()) {
                                        TextKt.m1585TextfLXpl1I(z3 ? "Edit Emergency Contact" : "Add Emergency Contact", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getH6(), $composer4, 0, 0, 32766);
                                        SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(8)), $composer4, 6);
                                        AddContactDialog$lambda$14 = EmergencyContactsScreenKt.AddContactDialog$lambda$14(mutableState3);
                                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        $composer4.startReplaceableGroup(1157296644);
                                        ComposerKt.sourceInformation($composer4, "C(remember)P(1):Composables.kt#9igjgp");
                                        boolean invalid$iv$iv2 = $composer4.changed(mutableState3);
                                        Object it$iv$iv = $composer4.rememberedValue();
                                        if (invalid$iv$iv2 || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                                            value$iv$iv = (Function1) new Function1<String, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$AddContactDialog$1$1$1$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                                                    invoke2(str3);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(String it) {
                                                    Intrinsics.checkNotNullParameter(it, "it");
                                                    mutableState3.setValue(it);
                                                }
                                            };
                                            $composer4.updateRememberedValue(value$iv$iv);
                                        } else {
                                            value$iv$iv = it$iv$iv;
                                        }
                                        $composer4.endReplaceableGroup();
                                        OutlinedTextFieldKt.OutlinedTextField(AddContactDialog$lambda$14, (Function1<? super String, Unit>) value$iv$iv, fillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EmergencyContactsScreenKt.INSTANCE.m4709getLambda5$finished_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer4, 1573248, 0, 524216);
                                        SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(8)), $composer4, 6);
                                        AddContactDialog$lambda$17 = EmergencyContactsScreenKt.AddContactDialog$lambda$17(mutableState4);
                                        KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, KeyboardType.INSTANCE.m4134getPhonePjHm6EE(), 0, 11, null);
                                        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        $composer4.startReplaceableGroup(1157296644);
                                        ComposerKt.sourceInformation($composer4, "C(remember)P(1):Composables.kt#9igjgp");
                                        boolean invalid$iv$iv3 = $composer4.changed(mutableState4);
                                        Object value$iv$iv3 = $composer4.rememberedValue();
                                        if (!invalid$iv$iv3 && value$iv$iv3 != Composer.INSTANCE.getEmpty()) {
                                            $composer4.endReplaceableGroup();
                                            OutlinedTextFieldKt.OutlinedTextField(AddContactDialog$lambda$17, (Function1<? super String, Unit>) value$iv$iv3, fillMaxWidth$default2, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EmergencyContactsScreenKt.INSTANCE.m4710getLambda6$finished_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer4, 1573248, 0, 520120);
                                            SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(16)), $composer4, 6);
                                            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                            Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            $composer4.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation($composer4, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                                            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                                            int $i$f$Row = ((54 >> 3) & 14) | ((54 >> 3) & SdkConfig.SDK_VERSION);
                                            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(end, verticalAlignment$iv, $composer4, $i$f$Row);
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
                                            Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(fillMaxWidth$default3);
                                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if (!$composer4.getInserting()) {
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
                                            $changed$iv = ($changed$iv$iv$iv2 >> 9) & 14;
                                            $composer4.startReplaceableGroup(-678309503);
                                            ComposerKt.sourceInformation($composer4, "C80@4021L9:Row.kt#2w3rfo");
                                            if (($changed$iv & 11) == 2 || !$composer4.getSkipping()) {
                                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                $changed4 = ((54 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                                $composer4.startReplaceableGroup(-1598235409);
                                                ComposerKt.sourceInformation($composer4, "C244@10806L50,245@10894L171,245@10877L206:EmergencyContactsScreen.kt#z8wdr8");
                                                if (($changed4 & 81) == 16 || !$composer4.getSkipping()) {
                                                    $composer$iv = $composer4;
                                                    $composer5 = $composer4;
                                                    $composer$iv2 = $composer4;
                                                    ButtonKt.TextButton(function02, null, false, null, null, null, null, null, null, ComposableSingletons$EmergencyContactsScreenKt.INSTANCE.m4711getLambda7$finished_debug(), $composer4, ((i6 >> 9) & 14) | 805306368, 510);
                                                    int i7 = ((i6 >> 6) & 896) | 54;
                                                    $composer$iv3 = $composer4;
                                                    $composer$iv3.startReplaceableGroup(1618982084);
                                                    ComposerKt.sourceInformation($composer$iv3, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                                                    invalid$iv$iv = $composer$iv3.changed(mutableState3) | $composer$iv3.changed(mutableState4) | $composer$iv3.changed(function22);
                                                    Object it$iv$iv2 = $composer$iv3.rememberedValue();
                                                    if (!invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                                                        value$iv$iv2 = (Function0) new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$AddContactDialog$1$1$1$3$1$1
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
                                                                String AddContactDialog$lambda$142;
                                                                String AddContactDialog$lambda$172;
                                                                String AddContactDialog$lambda$143;
                                                                String AddContactDialog$lambda$173;
                                                                AddContactDialog$lambda$142 = EmergencyContactsScreenKt.AddContactDialog$lambda$14(mutableState3);
                                                                if (!StringsKt.isBlank(AddContactDialog$lambda$142)) {
                                                                    AddContactDialog$lambda$172 = EmergencyContactsScreenKt.AddContactDialog$lambda$17(mutableState4);
                                                                    if (!StringsKt.isBlank(AddContactDialog$lambda$172)) {
                                                                        Function2<String, String, Unit> function23 = function22;
                                                                        AddContactDialog$lambda$143 = EmergencyContactsScreenKt.AddContactDialog$lambda$14(mutableState3);
                                                                        AddContactDialog$lambda$173 = EmergencyContactsScreenKt.AddContactDialog$lambda$17(mutableState4);
                                                                        function23.invoke(AddContactDialog$lambda$143, AddContactDialog$lambda$173);
                                                                    }
                                                                }
                                                            }
                                                        };
                                                        $composer$iv3.updateRememberedValue(value$iv$iv2);
                                                    } else {
                                                        value$iv$iv2 = it$iv$iv2;
                                                    }
                                                    $composer$iv3.endReplaceableGroup();
                                                    ButtonKt.Button((Function0) value$iv$iv2, null, false, null, null, null, null, null, null, ComposableSingletons$EmergencyContactsScreenKt.INSTANCE.m4712getLambda8$finished_debug(), $composer$iv3, 805306368, 510);
                                                } else {
                                                    $composer4.skipToGroupEnd();
                                                    $composer$iv = $composer4;
                                                    $composer5 = $composer4;
                                                    $composer$iv3 = $composer4;
                                                    $composer$iv2 = $composer4;
                                                }
                                                $composer$iv3.endReplaceableGroup();
                                            } else {
                                                $composer4.skipToGroupEnd();
                                                $composer$iv = $composer4;
                                                $composer5 = $composer4;
                                                $composer$iv2 = $composer4;
                                            }
                                            $composer$iv.endReplaceableGroup();
                                            $composer5.endReplaceableGroup();
                                            $composer5.endNode();
                                            $composer5.endReplaceableGroup();
                                            $composer5.endReplaceableGroup();
                                        }
                                        value$iv$iv3 = (Function1) new Function1<String, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$AddContactDialog$1$1$1$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                                                invoke2(str3);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(String it) {
                                                Intrinsics.checkNotNullParameter(it, "it");
                                                mutableState4.setValue(it);
                                            }
                                        };
                                        $composer4.updateRememberedValue(value$iv$iv3);
                                        $composer4.endReplaceableGroup();
                                        OutlinedTextFieldKt.OutlinedTextField(AddContactDialog$lambda$17, (Function1<? super String, Unit>) value$iv$iv3, fillMaxWidth$default2, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EmergencyContactsScreenKt.INSTANCE.m4710getLambda6$finished_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer4, 1573248, 0, 520120);
                                        SpacerKt.Spacer(SizeKt.m786height3ABfNKs(Modifier.INSTANCE, C0504Dp.m4382constructorimpl(16)), $composer4, 6);
                                        Arrangement.Horizontal end2 = Arrangement.INSTANCE.getEnd();
                                        Modifier fillMaxWidth$default32 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        $composer4.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation($composer4, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                                        Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
                                        int $i$f$Row2 = ((54 >> 3) & 14) | ((54 >> 3) & SdkConfig.SDK_VERSION);
                                        MeasurePolicy measurePolicy$iv22 = RowKt.rowMeasurePolicy(end2, verticalAlignment$iv2, $composer4, $i$f$Row2);
                                        int $changed$iv$iv22 = (54 << 3) & SdkConfig.SDK_VERSION;
                                        $composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume42 = $composer4.consume(localDensity22);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        Density density$iv$iv22 = (Density) consume42;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22 = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume52 = $composer4.consume(localLayoutDirection22);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        LayoutDirection layoutDirection$iv$iv22 = (LayoutDirection) consume52;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration22 = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume62 = $composer4.consume(localViewConfiguration22);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ViewConfiguration viewConfiguration$iv$iv22 = (ViewConfiguration) consume62;
                                        Function0 factory$iv$iv$iv22 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3 skippableUpdate$iv$iv$iv22 = LayoutKt.materializerOf(fillMaxWidth$default32);
                                        int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 9) & 7168) | 6;
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                        }
                                        $composer4.startReusableNode();
                                        if (!$composer4.getInserting()) {
                                        }
                                        $composer4.disableReusing();
                                        Composer $this$Layout_u24lambda_u2d0$iv$iv22 = Updater.m1639constructorimpl($composer4);
                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, measurePolicy$iv22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, density$iv$iv22, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, layoutDirection$iv$iv22, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv22, viewConfiguration$iv$iv22, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        $composer4.enableReusing();
                                        skippableUpdate$iv$iv$iv22.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv22 >> 3) & SdkConfig.SDK_VERSION));
                                        $composer4.startReplaceableGroup(2058660585);
                                        $changed$iv = ($changed$iv$iv$iv22 >> 9) & 14;
                                        $composer4.startReplaceableGroup(-678309503);
                                        ComposerKt.sourceInformation($composer4, "C80@4021L9:Row.kt#2w3rfo");
                                        if (($changed$iv & 11) == 2) {
                                        }
                                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                        $changed4 = ((54 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                        $composer4.startReplaceableGroup(-1598235409);
                                        ComposerKt.sourceInformation($composer4, "C244@10806L50,245@10894L171,245@10877L206:EmergencyContactsScreen.kt#z8wdr8");
                                        if (($changed4 & 81) == 16) {
                                        }
                                        $composer$iv = $composer4;
                                        $composer5 = $composer4;
                                        $composer$iv2 = $composer4;
                                        ButtonKt.TextButton(function02, null, false, null, null, null, null, null, null, ComposableSingletons$EmergencyContactsScreenKt.INSTANCE.m4711getLambda7$finished_debug(), $composer4, ((i6 >> 9) & 14) | 805306368, 510);
                                        int i72 = ((i6 >> 6) & 896) | 54;
                                        $composer$iv3 = $composer4;
                                        $composer$iv3.startReplaceableGroup(1618982084);
                                        ComposerKt.sourceInformation($composer$iv3, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                                        invalid$iv$iv = $composer$iv3.changed(mutableState3) | $composer$iv3.changed(mutableState4) | $composer$iv3.changed(function22);
                                        Object it$iv$iv22 = $composer$iv3.rememberedValue();
                                        if (invalid$iv$iv) {
                                        }
                                        value$iv$iv2 = (Function0) new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$AddContactDialog$1$1$1$3$1$1
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
                                                String AddContactDialog$lambda$142;
                                                String AddContactDialog$lambda$172;
                                                String AddContactDialog$lambda$143;
                                                String AddContactDialog$lambda$173;
                                                AddContactDialog$lambda$142 = EmergencyContactsScreenKt.AddContactDialog$lambda$14(mutableState3);
                                                if (!StringsKt.isBlank(AddContactDialog$lambda$142)) {
                                                    AddContactDialog$lambda$172 = EmergencyContactsScreenKt.AddContactDialog$lambda$17(mutableState4);
                                                    if (!StringsKt.isBlank(AddContactDialog$lambda$172)) {
                                                        Function2<String, String, Unit> function23 = function22;
                                                        AddContactDialog$lambda$143 = EmergencyContactsScreenKt.AddContactDialog$lambda$14(mutableState3);
                                                        AddContactDialog$lambda$173 = EmergencyContactsScreenKt.AddContactDialog$lambda$17(mutableState4);
                                                        function23.invoke(AddContactDialog$lambda$143, AddContactDialog$lambda$173);
                                                    }
                                                }
                                            }
                                        };
                                        $composer$iv3.updateRememberedValue(value$iv$iv2);
                                        $composer$iv3.endReplaceableGroup();
                                        ButtonKt.Button((Function0) value$iv$iv2, null, false, null, null, null, null, null, null, ComposableSingletons$EmergencyContactsScreenKt.INSTANCE.m4712getLambda8$finished_debug(), $composer$iv3, 805306368, 510);
                                        $composer$iv3.endReplaceableGroup();
                                        $composer$iv.endReplaceableGroup();
                                        $composer5.endReplaceableGroup();
                                        $composer5.endNode();
                                        $composer5.endReplaceableGroup();
                                        $composer5.endReplaceableGroup();
                                    } else {
                                        $composer4.skipToGroupEnd();
                                        $composer5 = $composer4;
                                        $composer$iv2 = $composer4;
                                    }
                                    $composer5.endReplaceableGroup();
                                }
                                $composer$iv2.endReplaceableGroup();
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
                    }), $composer3, 1769478, 30);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), $composer2, (($dirty2 >> 9) & 14) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final String str3 = initialName2;
        final String str4 = initialPhone2;
        final boolean z2 = isEdit2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$AddContactDialog$2
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

            public final void invoke(Composer composer, int i5) {
                EmergencyContactsScreenKt.AddContactDialog(str3, str4, z2, onDismiss, onConfirm, composer, $changed | 1, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AddContactDialog$lambda$14(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AddContactDialog$lambda$17(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }
}
