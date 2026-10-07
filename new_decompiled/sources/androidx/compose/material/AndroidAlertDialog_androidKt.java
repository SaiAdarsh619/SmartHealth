package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.p000ui.window.AndroidDialog_androidKt;
import androidx.compose.p000ui.window.DialogProperties;
import androidx.compose.p000ui.window.SecureFlagPolicy;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidAlertDialog.android.kt */
@Metadata(m286d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u00ad\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0096\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, m287d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-6oU6zVQ", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "buttons", "AlertDialog-wqdebIU", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AndroidAlertDialog_androidKt {
    /* renamed from: AlertDialog-6oU6zVQ, reason: not valid java name */
    public static final void m1222AlertDialog6oU6zVQ(final Function0<Unit> onDismissRequest, final Function2<? super Composer, ? super Integer, Unit> confirmButton, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, long backgroundColor, long contentColor, DialogProperties properties, Composer $composer, final int $changed, final int i) {
        Function2 function24;
        Function2 function25;
        long contentColor2;
        CornerBasedShape shape2;
        long backgroundColor2;
        DialogProperties properties2;
        Modifier modifier2;
        Function2 title;
        Function2 text;
        Shape shape3;
        long contentColor3;
        long backgroundColor3;
        final int $dirty;
        final Function2 dismissButton;
        Function2 dismissButton2;
        Composer $composer2;
        int i2;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(confirmButton, "confirmButton");
        Composer $composer3 = $composer.startRestartGroup(-606536823);
        ComposerKt.sourceInformation($composer3, "C(AlertDialog)P(5,1,4,3,9,8,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color)70@3471L6,71@3529L6,72@3571L32,75@3667L735:AndroidAlertDialog.android.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(onDismissRequest) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer3.changed(confirmButton) ? 32 : 16;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            function24 = function2;
        } else if (($changed & 7168) == 0) {
            function24 = function2;
            $dirty2 |= $composer3.changed(function24) ? 2048 : 1024;
        } else {
            function24 = function2;
        }
        int i8 = i & 16;
        if (i8 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty2 |= $composer3.changed(function22) ? 16384 : 8192;
        }
        int i9 = i & 32;
        if (i9 != 0) {
            $dirty2 |= 196608;
            function25 = function23;
        } else if (($changed & 458752) == 0) {
            function25 = function23;
            $dirty2 |= $composer3.changed(function25) ? 131072 : 65536;
        } else {
            function25 = function23;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0 && $composer3.changed(shape)) {
                i5 = 1048576;
                $dirty2 |= i5;
            }
            i5 = 524288;
            $dirty2 |= i5;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0 && $composer3.changed(backgroundColor)) {
                i4 = 8388608;
                $dirty2 |= i4;
            }
            i4 = 4194304;
            $dirty2 |= i4;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0) {
                contentColor2 = contentColor;
                if ($composer3.changed(contentColor2)) {
                    i3 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    $dirty2 |= i3;
                }
            } else {
                contentColor2 = contentColor;
            }
            i3 = 33554432;
            $dirty2 |= i3;
        } else {
            contentColor2 = contentColor;
        }
        if ((1879048192 & $changed) == 0) {
            if ((i & 512) == 0 && $composer3.changed(properties)) {
                i2 = 536870912;
                $dirty2 |= i2;
            }
            i2 = 268435456;
            $dirty2 |= i2;
        }
        if (($dirty2 & 1533916891) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            title = function22;
            shape3 = shape;
            backgroundColor3 = backgroundColor;
            properties2 = properties;
            dismissButton2 = function24;
            contentColor3 = contentColor2;
            text = function25;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i6 != 0 ? Modifier.INSTANCE : modifier;
                Function2 dismissButton3 = i7 != 0 ? null : function24;
                Function2 title2 = i8 != 0 ? null : function22;
                Function2 text2 = i9 != 0 ? null : function25;
                if ((i & 64) != 0) {
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getMedium();
                    $dirty2 &= -3670017;
                } else {
                    shape2 = shape;
                }
                if ((i & 128) != 0) {
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1321getSurface0d7_KjU();
                    $dirty2 &= -29360129;
                } else {
                    backgroundColor2 = backgroundColor;
                }
                if ((i & 256) != 0) {
                    contentColor2 = ColorsKt.m1335contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty2 >> 21) & 14);
                    $dirty2 &= -234881025;
                }
                if ((i & 512) != 0) {
                    modifier2 = modifier3;
                    properties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                    title = title2;
                    text = text2;
                    shape3 = shape2;
                    contentColor3 = contentColor2;
                    backgroundColor3 = backgroundColor2;
                    $dirty = $dirty2 & (-1879048193);
                    dismissButton = dismissButton3;
                } else {
                    properties2 = properties;
                    modifier2 = modifier3;
                    title = title2;
                    text = text2;
                    shape3 = shape2;
                    contentColor3 = contentColor2;
                    backgroundColor3 = backgroundColor2;
                    $dirty = $dirty2;
                    dismissButton = dismissButton3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty2 &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty2 &= -234881025;
                }
                if ((i & 512) != 0) {
                    modifier2 = modifier;
                    title = function22;
                    shape3 = shape;
                    backgroundColor3 = backgroundColor;
                    properties2 = properties;
                    contentColor3 = contentColor2;
                    text = function25;
                    $dirty = (-1879048193) & $dirty2;
                    dismissButton = function24;
                } else {
                    modifier2 = modifier;
                    title = function22;
                    shape3 = shape;
                    backgroundColor3 = backgroundColor;
                    properties2 = properties;
                    contentColor3 = contentColor2;
                    text = function25;
                    $dirty = $dirty2;
                    dismissButton = function24;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-606536823, $dirty, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
            }
            dismissButton2 = dismissButton;
            $composer2 = $composer3;
            m1223AlertDialogwqdebIU(onDismissRequest, ComposableLambdaKt.composableLambda($composer3, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
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
                    ComposerKt.sourceInformation($composer4, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1849673151, $changed2, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:77)");
                    }
                    Modifier modifier$iv = PaddingKt.m760paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C0504Dp.m4382constructorimpl(8), C0504Dp.m4382constructorimpl(2));
                    final Function2<Composer, Integer, Unit> function26 = dismissButton;
                    final int i10 = $dirty;
                    final Function2<Composer, Integer, Unit> function27 = confirmButton;
                    $composer4.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & SdkConfig.SDK_VERSION));
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
                    int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                    $composer4.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer4, "C72@3384L9:Box.kt#2w3rfo");
                    if (($changed$iv & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                    } else {
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int $changed3 = ((6 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        $composer4.startReplaceableGroup(-434861445);
                        ComposerKt.sourceInformation($composer4, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                        if (($changed3 & 81) == 16 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                        } else {
                            AlertDialogKt.m1221AlertDialogFlowRowixp7dh8(C0504Dp.m4382constructorimpl(8), C0504Dp.m4382constructorimpl(12), ComposableLambdaKt.composableLambda($composer4, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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
                                    ComposerKt.sourceInformation($composer5, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                    if (($changed4 & 11) != 2 || !$composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1789213604, $changed4, -1, "androidx.compose.material.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:83)");
                                        }
                                        Function2<Composer, Integer, Unit> function28 = function26;
                                        $composer5.startReplaceableGroup(-1046483318);
                                        ComposerKt.sourceInformation($composer5, "84@4101L8");
                                        if (function28 != null) {
                                            function28.invoke($composer5, Integer.valueOf((i10 >> 9) & 14));
                                            Unit unit = Unit.INSTANCE;
                                        }
                                        $composer5.endReplaceableGroup();
                                        function27.invoke($composer5, Integer.valueOf((i10 >> 3) & 14));
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer5.skipToGroupEnd();
                                }
                            }), $composer4, 438);
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
                    }
                }
            }), modifier2, title, text, shape3, backgroundColor3, contentColor3, properties2, $composer3, ($dirty & 14) | 48 | ($dirty & 896) | (($dirty >> 3) & 7168) | (($dirty >> 3) & 57344) | (($dirty >> 3) & 458752) | (($dirty >> 3) & 3670016) | (($dirty >> 3) & 29360128) | (($dirty >> 3) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier2;
        final Function2 function26 = dismissButton2;
        final Function2 function27 = title;
        final Function2 function28 = text;
        final Shape shape4 = shape3;
        final long j = backgroundColor3;
        final long j2 = contentColor3;
        final DialogProperties dialogProperties = properties2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
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

            public final void invoke(Composer composer, int i10) {
                AndroidAlertDialog_androidKt.m1222AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier4, function26, function27, function28, shape4, j, j2, dialogProperties, composer, $changed | 1, i);
            }
        });
    }

    /* renamed from: AlertDialog-wqdebIU, reason: not valid java name */
    public static final void m1223AlertDialogwqdebIU(final Function0<Unit> onDismissRequest, final Function2<? super Composer, ? super Integer, Unit> buttons, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, long backgroundColor, long contentColor, DialogProperties properties, Composer $composer, final int $changed, final int i) {
        Function2 function23;
        long backgroundColor2;
        long j;
        CornerBasedShape shape2;
        long contentColor2;
        DialogProperties properties2;
        Modifier modifier2;
        Function2 title;
        Function2 text;
        Shape shape3;
        long contentColor3;
        long backgroundColor3;
        final int $dirty;
        int i2;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Composer $composer2 = $composer.startRestartGroup(1035523925);
        ComposerKt.sourceInformation($composer2, "C(AlertDialog)P(4,1,3,8,7,6,0:c#ui.graphics.Color,2:c#ui.graphics.Color)131@6133L6,132@6191L6,133@6233L32,136@6329L366:AndroidAlertDialog.android.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(onDismissRequest) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer2.changed(buttons) ? 32 : 16;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            function23 = function2;
        } else if (($changed & 7168) == 0) {
            function23 = function2;
            $dirty2 |= $composer2.changed(function23) ? 2048 : 1024;
        } else {
            function23 = function2;
        }
        int i8 = i & 16;
        if (i8 != 0) {
            $dirty2 |= 24576;
        } else if ((57344 & $changed) == 0) {
            $dirty2 |= $composer2.changed(function22) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0 && $composer2.changed(shape)) {
                i5 = 131072;
                $dirty2 |= i5;
            }
            i5 = 65536;
            $dirty2 |= i5;
        }
        if ((3670016 & $changed) == 0) {
            if ((i & 64) == 0) {
                backgroundColor2 = backgroundColor;
                if ($composer2.changed(backgroundColor2)) {
                    i4 = 1048576;
                    $dirty2 |= i4;
                }
            } else {
                backgroundColor2 = backgroundColor;
            }
            i4 = 524288;
            $dirty2 |= i4;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0) {
                j = contentColor;
                if ($composer2.changed(j)) {
                    i3 = 8388608;
                    $dirty2 |= i3;
                }
            } else {
                j = contentColor;
            }
            i3 = 4194304;
            $dirty2 |= i3;
        } else {
            j = contentColor;
        }
        if ((234881024 & $changed) == 0) {
            if ((i & 256) == 0 && $composer2.changed(properties)) {
                i2 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty2 |= i2;
            }
            i2 = 33554432;
            $dirty2 |= i2;
        }
        if (($dirty2 & 191739611) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            text = function22;
            shape3 = shape;
            properties2 = properties;
            title = function23;
            contentColor3 = j;
            backgroundColor3 = backgroundColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i6 != 0 ? Modifier.INSTANCE : modifier;
                Function2 title2 = i7 != 0 ? null : function23;
                Function2 text2 = i8 != 0 ? null : function22;
                if ((i & 32) != 0) {
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getMedium();
                    $dirty2 &= -458753;
                } else {
                    shape2 = shape;
                }
                if ((i & 64) != 0) {
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1321getSurface0d7_KjU();
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    contentColor2 = ColorsKt.m1335contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 18) & 14);
                    $dirty2 &= -29360129;
                } else {
                    contentColor2 = j;
                }
                if ((i & 256) != 0) {
                    modifier2 = modifier3;
                    title = title2;
                    properties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                    text = text2;
                    shape3 = shape2;
                    contentColor3 = contentColor2;
                    backgroundColor3 = backgroundColor2;
                    $dirty = $dirty2 & (-234881025);
                } else {
                    properties2 = properties;
                    modifier2 = modifier3;
                    title = title2;
                    text = text2;
                    shape3 = shape2;
                    contentColor3 = contentColor2;
                    backgroundColor3 = backgroundColor2;
                    $dirty = $dirty2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty2 &= -29360129;
                }
                if ((i & 256) != 0) {
                    modifier2 = modifier;
                    text = function22;
                    shape3 = shape;
                    properties2 = properties;
                    title = function23;
                    contentColor3 = j;
                    backgroundColor3 = backgroundColor2;
                    $dirty = $dirty2 & (-234881025);
                } else {
                    modifier2 = modifier;
                    text = function22;
                    shape3 = shape;
                    properties2 = properties;
                    title = function23;
                    contentColor3 = j;
                    backgroundColor3 = backgroundColor2;
                    $dirty = $dirty2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1035523925, $dirty, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
            }
            final Modifier modifier4 = modifier2;
            final Function2 function24 = title;
            final Function2 function25 = text;
            final Shape shape4 = shape3;
            final long j2 = backgroundColor3;
            final long j3 = contentColor3;
            int $dirty3 = $dirty;
            AndroidDialog_androidKt.Dialog(onDismissRequest, properties2, ComposableLambdaKt.composableLambda($composer2, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
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
                    ComposerKt.sourceInformation($composer3, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1787418772, $changed2, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:139)");
                        }
                        AlertDialogKt.m1220AlertDialogContentWMdw5o4(buttons, modifier4, function24, function25, shape4, j2, j3, $composer3, (($dirty >> 3) & 14) | (($dirty >> 3) & SdkConfig.SDK_VERSION) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 3) & 57344) | (($dirty >> 3) & 458752) | (($dirty >> 3) & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, ($dirty3 & 14) | 384 | (($dirty3 >> 21) & SdkConfig.SDK_VERSION), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier2;
        final Function2 function26 = title;
        final Function2 function27 = text;
        final Shape shape5 = shape3;
        final long j4 = backgroundColor3;
        final long j5 = contentColor3;
        final DialogProperties dialogProperties = properties2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$4
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
                AndroidAlertDialog_androidKt.m1223AlertDialogwqdebIU(onDismissRequest, buttons, modifier5, function26, function27, shape5, j4, j5, dialogProperties, composer, $changed | 1, i);
            }
        });
    }
}
